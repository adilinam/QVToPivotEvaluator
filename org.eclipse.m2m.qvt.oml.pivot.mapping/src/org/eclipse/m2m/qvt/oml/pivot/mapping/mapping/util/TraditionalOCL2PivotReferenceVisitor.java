package org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreOCLStandardLibrary;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.Visitable;

public abstract class TraditionalOCL2PivotReferenceVisitor extends AbstractQVToVisitorImpl
{
	private final @NonNull EPackage oclStdLibPackage;
	private final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final /*@NonNull*/ org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager metamodelManager;
	private final /*@NonNull*/ org.eclipse.ocl.pivot.StandardLibrary standardLibrary;
	private final /*@NonNull*/ org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal completeModel;

	public TraditionalOCL2PivotReferenceVisitor(TraditionalToPivotMapping converter, @NonNull AbstractEcoreSwitch ecoreSwitch) {
		super(converter, ecoreSwitch);
		oclStdLibPackage = new EcoreOCLStandardLibrary().getOCLStdLibPackage();
		environmentFactory = converter.getEnvironmentFactory();
		metamodelManager = (org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager) converter.getMetamodelManager();
		standardLibrary = converter.getStandardLibrary();
		completeModel = (org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal)converter.getCompleteModel();
	}

	/*	protected <T extends Element> @Nullable T doProcess(@NonNull Class<T> pivotClass, @Nullable EObject astNode) {
		if (astNode == null) {
			return null;
		}
		Object pivotElement;
		if (astNode instanceof Visitable) {
			pivotElement = ((Visitable)astNode).accept(this);
		}
		else {
			pivotElement = ecoreSwitch.doSwitch(astNode);
		}
		if (pivotElement == null) {		// FIXME debugging
			if (astNode instanceof Visitable) {
				pivotElement = ((Visitable)astNode).accept(this);
			}
			else {
				pivotElement = ecoreSwitch.doSwitch(astNode);
			}
		}
		assert pivotElement != null: "No Pivot object for " + TraditionalToPivotMapping.debugId(astNode)
		+ " contained by " + TraditionalToPivotMapping.debugId(astNode.eContainer()) + "::" + astNode.eContainingFeature().getName();
		return (T) pivotElement;
	} */

	protected @NonNull String getBaseName(@NonNull EClassifier eContainingClass) {
		String name = eContainingClass.getName();
		if (name.endsWith("_Class")) {
			name = name.substring(0, name.length()-6);
		}
		if (name.endsWith("(T)")) {
			name = name.substring(0, name.length()-3);
		}
		return name;
	}

	protected org.eclipse.ocl.pivot.Type resolveEClassifier(EClassifier referredClassifier) {
		if (referredClassifier instanceof Visitable) {
			return (org.eclipse.ocl.pivot.Type)converter.getPivot((Visitable)referredClassifier);
		}
		/*		else if (referredClassifier instanceof ListType/DictType) {
			CollectionType collectionType = (CollectionType)referredClassifier;
			CollectionKind kind = collectionType.getKind();
			EClassifier elementClassifier = collectionType.getElementType();
			org.eclipse.ocl.pivot.Type elementType = resolveEClassifier(elementClassifier);
			return metamodelManager.getCollectionType(kind.getName(), elementType, false, null, null);
		} */
		else if (referredClassifier instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)referredClassifier;
			CollectionKind kind = collectionType.getKind();
			EClassifier elementClassifier = collectionType.getElementType();
			org.eclipse.ocl.pivot.Type elementType = resolveEClassifier(elementClassifier);
			return metamodelManager.getCollectionType(kind.getName(), elementType, false, null, null);
		}
		else if (referredClassifier instanceof PrimitiveType) {
			//			String name = getBaseName(eContainingClass);
			org.eclipse.ocl.pivot.Class pivotClass = standardLibrary.getPackage().getOwnedClass(referredClassifier.getName());
			org.eclipse.ocl.pivot.CompleteModel completeModel = converter.getCompleteModel();
			org.eclipse.ocl.pivot.CompleteClass completeClass = completeModel.getCompleteClass(pivotClass);
			return completeClass.getPrimaryClass();
		}
		/*		else if (referredClassifier instanceof TupleType) {
			CollectionType collectionType = (CollectionType)referredClassifier;
			CollectionKind kind = collectionType.getKind();
			EClassifier elementClassifier = collectionType.getElementType();
			org.eclipse.ocl.pivot.Type elementType = resolveEClassifier(elementClassifier);
			return metamodelManager.getCollectionType(kind.getName(), elementType, false, null, null);
		} */
		else {
			return converter.getPivotOfEcore(org.eclipse.ocl.pivot.Type.class, referredClassifier);
		}
	}

	protected org.eclipse.ocl.pivot.EnumerationLiteral resolveEEnumLiteral(EEnumLiteral referredLiteral) {
		if (referredLiteral instanceof Visitable) {
			return (org.eclipse.ocl.pivot.EnumerationLiteral)converter.getPivot((Visitable)referredLiteral);
		}
		else {
			return converter.getPivotOfEcore(org.eclipse.ocl.pivot.EnumerationLiteral.class, referredLiteral);
		}
	}

	protected org.eclipse.ocl.pivot.Property resolveEFeature(EStructuralFeature referredFeature) {
		if (referredFeature instanceof Visitable) {
			return (org.eclipse.ocl.pivot.Property)converter.getPivot((Visitable)referredFeature);
		}
		else {
			return converter.getPivotOfEcore(org.eclipse.ocl.pivot.Property.class, referredFeature);
		}
	}

	protected org.eclipse.ocl.pivot.Operation resolveEOperation(@NonNull EOperation referredOperation) {
		if (referredOperation instanceof Visitable) {
			return doProcess(org.eclipse.ocl.pivot.Operation.class,(Visitable)referredOperation);
		}
		EClass eContainingClass = referredOperation.getEContainingClass();
		EPackage ePackage = eContainingClass.getEPackage();
		if (ePackage != oclStdLibPackage) {
			return converter.getPivotOfEcore(org.eclipse.ocl.pivot.Operation.class, referredOperation);
		}
		String name = getBaseName(eContainingClass);
		org.eclipse.ocl.pivot.Class pivotClass = standardLibrary.getPackage().getOwnedClass(name);
		org.eclipse.ocl.pivot.CompleteModel completeModel = converter.getCompleteModel();
		org.eclipse.ocl.pivot.CompleteClass completeClass = completeModel.getCompleteClass(pivotClass);
		Iterable<org.eclipse.ocl.pivot.Operation> operations = completeClass.getOperations(null, referredOperation.getName());
		org.eclipse.ocl.pivot.Operation pivotOperation = operations.iterator().next();		// FIXME errors/overloads
		return pivotOperation;
	}

	private org.eclipse.ocl.pivot.Iteration resolveIteration(@NonNull String name, org.eclipse.ocl.pivot.OCLExpression pivotSource, int size) {
		org.eclipse.ocl.pivot.Type pivotType = pivotSource.getType();
		org.eclipse.ocl.pivot.CompleteClass completeClass = completeModel.getCompleteClass(pivotType);
		Iterable<org.eclipse.ocl.pivot.Operation> operations = completeClass.getOperations(null, name);
		org.eclipse.ocl.pivot.Operation pivotOperation = operations.iterator().next();		// FIXME errors/overloads
		return (org.eclipse.ocl.pivot.Iteration) pivotOperation;
	}

	@Override
	public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.BooleanLiteralExp pivotElement = (org.eclipse.ocl.pivot.BooleanLiteralExp)converter.getPivot(astNode);
		pivotElement.setType(standardLibrary.getBooleanType());
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitCollectionItem(CollectionItem<EClassifier> astNode) {
		org.eclipse.ocl.pivot.CollectionItem pivotElement = (org.eclipse.ocl.pivot.CollectionItem)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.OCLExpression pivotInit = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getItem());
		pivotElement.setType(pivotInit.getType());
		pivotElement.setIsRequired(pivotInit.isIsRequired());
		return pivotElement;
	}

	@Override
	public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.CollectionLiteralExp pivotElement = (org.eclipse.ocl.pivot.CollectionLiteralExp)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.Type commonType = null;
		boolean isNullFree = true;
		for (org.eclipse.ocl.pivot.CollectionLiteralPart pivotPart : doProcessAll(org.eclipse.ocl.pivot.CollectionLiteralPart.class, astNode.getPart())) {
			org.eclipse.ocl.pivot.Type asType = pivotPart.getType();
			org.eclipse.ocl.pivot.Type type = PivotUtilInternal.getType(asType);
			if (commonType == null) {
				commonType = type;
			}
			else if (commonType != type) {
				commonType = metamodelManager.getCommonType(commonType, TemplateParameterSubstitutions.EMPTY, type, TemplateParameterSubstitutions.EMPTY);
			}
			if (pivotPart instanceof org.eclipse.ocl.pivot.CollectionItem) {
				if ((((org.eclipse.ocl.pivot.CollectionItem)pivotPart).getOwnedItem() instanceof org.eclipse.ocl.pivot.NullLiteralExp)) {
					isNullFree = false;
				}
			}
			else if (pivotPart instanceof org.eclipse.ocl.pivot.CollectionRange) {
				;
			}
			else {
				isNullFree = false;
			}
		}
		if (commonType == null) {
			commonType = standardLibrary.getOclVoidType();
		}
		String collectionTypeName = astNode.getKind().getName();
		
		org.eclipse.ocl.pivot.Type collectionType = metamodelManager.getCollectionType(collectionTypeName, commonType, isNullFree, null, null);
		pivotElement.setKind(pivotElement.getKind());
		
		pivotElement.setType(collectionType);
		pivotElement.setIsRequired(isNullFree);
		return pivotElement;
	}

	@Override
	public Object visitCollectionRange(CollectionRange<EClassifier> astNode) {
		org.eclipse.ocl.pivot.CollectionItem pivotElement = (org.eclipse.ocl.pivot.CollectionItem)converter.getPivot(astNode);
		pivotElement.setType(standardLibrary.getIntegerType());
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> astNode) {
		org.eclipse.ocl.pivot.EnumLiteralExp pivotElement = (org.eclipse.ocl.pivot.EnumLiteralExp)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.EnumerationLiteral pivotEnumerationLiteral = resolveEEnumLiteral(astNode.getReferredEnumLiteral());
		pivotElement.setReferredLiteral(pivotEnumerationLiteral);
		pivotElement.setType(pivotEnumerationLiteral.getOwningEnumeration());
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitExpressionInOCL(ExpressionInOCL<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.ExpressionInOCL pivotElement = (org.eclipse.ocl.pivot.ExpressionInOCL)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.OCLExpression pivotBody = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getBodyExpression());
		pivotElement.setType(pivotBody.getType());
		pivotElement.setIsRequired(pivotBody.isIsRequired());
		return pivotElement;
	}

	@Override
	public Object visitIfExp(IfExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.IfExp pivotElement = (org.eclipse.ocl.pivot.IfExp)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.OCLExpression pivotThen = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getThenExpression());
		org.eclipse.ocl.pivot.OCLExpression pivotElse = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getElseExpression());
		org.eclipse.ocl.pivot.Type thenType = pivotThen.getType();
		org.eclipse.ocl.pivot.Type elseType = pivotElse.getType();
		org.eclipse.ocl.pivot.Type thenTypeValue = pivotThen.getTypeValue();
		org.eclipse.ocl.pivot.Type elseTypeValue = pivotElse.getTypeValue();
		org.eclipse.ocl.pivot.Type commonType = (thenType != null) && (elseType != null) ? metamodelManager.getCommonType(thenType, TemplateParameterSubstitutions.EMPTY, elseType, TemplateParameterSubstitutions.EMPTY) : null;
		org.eclipse.ocl.pivot.Type commonTypeValue = (thenTypeValue != null) && (elseTypeValue != null) ? metamodelManager.getCommonType(thenTypeValue, TemplateParameterSubstitutions.EMPTY, elseTypeValue, TemplateParameterSubstitutions.EMPTY) : null;
		pivotElement.setType(commonType);
		pivotElement.setTypeValue(commonTypeValue);
		pivotElement.setIsRequired(pivotThen.isIsRequired() && pivotElse.isIsRequired());
		return pivotElement;
	}

	@Override
	public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.IntegerLiteralExp pivotElement = (org.eclipse.ocl.pivot.IntegerLiteralExp)converter.getPivot(astNode);
		pivotElement.setType(standardLibrary.getIntegerType());
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.InvalidLiteralExp pivotElement = (org.eclipse.ocl.pivot.InvalidLiteralExp)converter.getPivot(astNode);
		pivotElement.setType(standardLibrary.getOclInvalidType());
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitIterateExp(IterateExp<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.IterateExp pivotElement = (org.eclipse.ocl.pivot.IterateExp)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.OCLExpression pivotSource = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getSource());
		org.eclipse.ocl.pivot.Iteration pivotIteration = resolveIteration(astNode.getName(), pivotSource, astNode.getIterator().size());
		pivotElement.setReferredIteration(pivotIteration);
		pivotElement.setName(pivotIteration.getName());
		org.eclipse.ocl.pivot.Type returnType = null;
		org.eclipse.ocl.pivot.Type formalType = pivotIteration.getType();
		if (formalType != null) {
			org.eclipse.ocl.pivot.Type sourceType = pivotSource.getType();
			if (pivotIteration.isIsTypeof()) {
				returnType = metamodelManager.specializeType(formalType, pivotElement, sourceType, null);
			}
			else {
				returnType = metamodelManager.specializeType(formalType, pivotElement, sourceType, pivotSource.getTypeValue());
			}
			pivotElement.setType(returnType);
			pivotElement.setIsRequired(pivotIteration.isIsRequired());
		}
		return pivotElement;
	}

	@Override
	public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.IteratorExp pivotElement = (org.eclipse.ocl.pivot.IteratorExp)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.OCLExpression pivotSource = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getSource());
		org.eclipse.ocl.pivot.Iteration pivotIteration = resolveIteration(astNode.getName(), pivotSource, astNode.getIterator().size());
		pivotElement.setReferredIteration(pivotIteration);
		pivotElement.setName(pivotIteration.getName());
		org.eclipse.ocl.pivot.Type returnType = null;
		org.eclipse.ocl.pivot.Type formalType = pivotIteration.getType();
		if (formalType != null) {
			org.eclipse.ocl.pivot.Type sourceType = pivotSource.getType();
			if (pivotIteration.isIsTypeof()) {
				returnType = metamodelManager.specializeType(formalType, pivotElement, sourceType, null);
			}
			else {
				returnType = metamodelManager.specializeType(formalType, pivotElement, sourceType, pivotSource.getTypeValue());
			}
			pivotElement.setType(returnType);
			pivotElement.setIsRequired(pivotIteration.isIsRequired());
		}
		return pivotElement;
	}

	@Override
	public Object visitLetExp(LetExp<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.LetExp pivotElement = (org.eclipse.ocl.pivot.LetExp)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.OCLExpression pivotIn = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getIn());
		pivotElement.setType(pivotIn.getType());
		pivotElement.setTypeValue(pivotIn.getTypeValue());
		pivotElement.setIsRequired(pivotIn.isIsRequired());
		return pivotElement;
	}

	@Override
	public Object visitNullLiteralExp(NullLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.NullLiteralExp pivotElement = (org.eclipse.ocl.pivot.NullLiteralExp)converter.getPivot(astNode);
		pivotElement.setType(standardLibrary.getOclVoidType());
		return pivotElement;
	}

	@Override
	public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> astNode) {
		org.eclipse.ocl.pivot.OperationCallExp pivotElement = (org.eclipse.ocl.pivot.OperationCallExp)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.OCLExpression pivotSource = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getSource());
		org.eclipse.ocl.pivot.Operation pivotOperation = resolveEOperation(astNode.getReferredOperation());

		if(pivotOperation!=null) //FIXME referred operation returned null from ecoreSwitch.doSwitch(astNode);
		{
			pivotElement.setReferredOperation(pivotOperation);
			pivotElement.setName(pivotOperation.getName());
			org.eclipse.ocl.pivot.Type returnType = null;
			org.eclipse.ocl.pivot.Type formalType = pivotOperation.getType();
			if (formalType != null) {
				org.eclipse.ocl.pivot.Type sourceType = pivotSource.getType();
				if (pivotOperation.isIsTypeof()) {
					returnType = metamodelManager.specializeType(formalType, pivotElement, sourceType, null);
				}
				else {
					//				returnType = metamodelManager.specializeType(formalType, pivotElement, sourceType, pivotSource.getTypeValue());
					returnType = QVToTemplateParameterSubstitutionVisitor.specializeType(formalType, pivotElement, environmentFactory, sourceType, pivotSource.getTypeValue());
				}
				pivotElement.setType(returnType);
				pivotElement.setIsRequired(pivotOperation.isIsRequired());

			}
			else {
				pivotElement.setType(standardLibrary.getOclVoidType());
			}
		}
		else {
			pivotElement.setType(standardLibrary.getOclVoidType());
		}
		return pivotElement;
	}

	@Override
	public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> astNode) {
		org.eclipse.ocl.pivot.PropertyCallExp pivotElement = (org.eclipse.ocl.pivot.PropertyCallExp)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.OCLExpression pivotSource = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getSource());
		org.eclipse.ocl.pivot.Property pivotProperty = resolveEFeature(astNode.getReferredProperty());
		pivotElement.setReferredProperty(pivotProperty);
		//FIXME catering null properties which was set in declaration visitor due to ecoreSwitch.doSwitch(astNode)
		if(pivotProperty!=null)
		{


			pivotElement.setName(pivotProperty.getName());
			org.eclipse.ocl.pivot.Type formalType = pivotProperty.getType();
			if (formalType != null) {
				org.eclipse.ocl.pivot.Type actualType;
				org.eclipse.ocl.pivot.Type sourceType = pivotSource.getType();
				if (sourceType != null) {
					actualType = metamodelManager.specializeType(formalType, pivotElement, sourceType, pivotSource.getTypeValue());
				}
				else {
					actualType = formalType;
				}
				if (pivotProperty.isIsStatic() && (actualType.isTemplateParameter() != null)) {
					actualType = metamodelManager.getMetaclass(actualType);
				}
				pivotElement.setType(actualType);
				pivotElement.setIsRequired(pivotProperty.isIsRequired());
			}
		}
		return pivotElement;
	}

	@Override
	public Object visitRealLiteralExp(RealLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.RealLiteralExp pivotElement = (org.eclipse.ocl.pivot.RealLiteralExp)converter.getPivot(astNode);
		pivotElement.setType(standardLibrary.getRealType());
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitStringLiteralExp(StringLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.StringLiteralExp pivotElement = 
				(org.eclipse.ocl.pivot.StringLiteralExp)converter.getPivot(astNode);
		pivotElement.setType(standardLibrary.getStringType());
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> astNode) {
		org.eclipse.ocl.pivot.TupleLiteralExp pivotElement = (org.eclipse.ocl.pivot.TupleLiteralExp)converter.getPivot(astNode);
		String tupleTypeName = "Tuple"; //ownedCollectionType.getName();
		List<org.eclipse.ocl.pivot.TupleLiteralPart> parts = doProcessAll(org.eclipse.ocl.pivot.TupleLiteralPart.class, astNode.getPart());
		pivotElement.setType(completeModel.getTupleType(tupleTypeName, parts, null));
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> astNode) {
		org.eclipse.ocl.pivot.TupleLiteralPart pivotElement = (org.eclipse.ocl.pivot.TupleLiteralPart)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.OCLExpression pivotInit = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getValue());
		pivotElement.setType(pivotInit.getType());
		pivotElement.setIsRequired(pivotInit.isIsRequired());
		return pivotElement;
	}

	@Override
	public Object visitTypeExp(TypeExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.TypeExp pivotElement = (org.eclipse.ocl.pivot.TypeExp)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.Type pivotType = resolveEClassifier(astNode.getReferredType());
		pivotElement.setReferredType(pivotType);
		pivotElement.setType(standardLibrary.getClassType());
		pivotElement.setTypeValue(pivotType);
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp pivotElement = (org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp)converter.getPivot(astNode);
		pivotElement.setType(standardLibrary.getUnlimitedNaturalType());
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitVariable(Variable<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.Variable pivotElement = (org.eclipse.ocl.pivot.Variable)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.Type pivotType = resolveEClassifier(astNode.getType());
		OCLExpression<EClassifier> astInit = astNode.getInitExpression();
		if (astInit != null) {
			org.eclipse.ocl.pivot.OCLExpression pivotInit = doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astInit);
			org.eclipse.ocl.pivot.Type initType = pivotInit.getType();
			pivotType = metamodelManager.getCommonType(pivotType, TemplateParameterSubstitutions.EMPTY, initType, TemplateParameterSubstitutions.EMPTY);
		}
		pivotElement.setType(pivotType);
		//		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	public Object visitVariableExp(VariableExp<EClassifier, EParameter> astNode) {

		org.eclipse.ocl.pivot.VariableExp pivotElement = (org.eclipse.ocl.pivot.VariableExp)converter.getPivot(astNode);
		org.eclipse.ocl.pivot.Variable pivotVariable = (org.eclipse.ocl.pivot.Variable)converter.getPivot(astNode.getReferredVariable());

		pivotElement.setReferredVariable(pivotVariable);
		if(pivotVariable!=null)
		{
			pivotElement.setName(pivotVariable.getName());
			pivotElement.setType(pivotVariable.getType());
			pivotElement.setTypeValue(pivotVariable.getTypeValue());
			pivotElement.setIsRequired(pivotVariable.isIsRequired());
		}

		return pivotElement;
	}
}
