package org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.utilities.ExpressionInOCL;

public abstract class TraditionalOCL2PivotDeclarationVisitor extends AbstractQVToVisitorImpl
{
	public TraditionalOCL2PivotDeclarationVisitor(TraditionalToPivotMapping converter, @NonNull AbstractEcoreSwitch ecoreSwitch) {
		super(converter, ecoreSwitch);
	}

	@Override
	public Object visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> astNode) {
		org.eclipse.ocl.pivot.AssociationClassCallExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createAssociationClassCallExp());
		
		
	//	pivotElement.setReferredAssociationClass(doProcess(AssociationClass.class, astNode.getReferredAssociationClass()));
		
		return pivotElement;
	}

	@Override
	public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.BooleanLiteralExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createBooleanLiteralExp());
		pivotElement.setBooleanSymbol(astNode.getBooleanSymbol());
		return pivotElement;
	}

	@Override
	public Object visitCollectionItem(CollectionItem<EClassifier> astNode) {
		org.eclipse.ocl.pivot.CollectionItem pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createCollectionItem());
		pivotElement.setOwnedItem(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getItem()));
		return pivotElement;
	}

	@Override
	public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.CollectionLiteralExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createCollectionLiteralExp());
		pivotElement.getOwnedParts().addAll(doProcessAll(org.eclipse.ocl.pivot.CollectionLiteralPart.class, astNode.getPart()));
		return pivotElement;
	}

	@Override
	public Object visitCollectionRange(CollectionRange<EClassifier> astNode) {
		org.eclipse.ocl.pivot.CollectionRange pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createCollectionRange());
		pivotElement.setOwnedFirst(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getFirst()));
		pivotElement.setOwnedLast(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getLast()));
		return pivotElement;
	}

	@Override
	public Object visitConstraint(Constraint astNode) {
		org.eclipse.ocl.pivot.Constraint pivotElement = null;
		//FIXME			converter.addCreated(astNode, PivotFactory.eINSTANCE.createConstraint());
		//...
		return pivotElement;
	}

	@Override
	public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> astNode) {
		org.eclipse.ocl.pivot.EnumLiteralExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createEnumLiteralExp());
		pivotElement.setReferredLiteral(doProcess(org.eclipse.ocl.pivot.EnumerationLiteral.class, astNode.getReferredEnumLiteral()));
		return pivotElement;
	}

	@Override
	public Object visitExpressionInOCL(ExpressionInOCL<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.ExpressionInOCL pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createExpressionInOCL());
		//...
		return pivotElement;
	}

	@Override
	public Object visitIfExp(IfExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.IfExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createIfExp());
		pivotElement.setOwnedCondition(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getCondition()));
		pivotElement.setOwnedThen(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getThenExpression()));
		pivotElement.setOwnedElse(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getElseExpression()));
		return pivotElement;
	}

	@Override
	public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.IntegerLiteralExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createIntegerLiteralExp());
		pivotElement.setIntegerSymbol(astNode.getLongSymbol());
		return pivotElement;
	}

	@Override
	public Object visitIterateExp(IterateExp<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.IterateExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createIterateExp());
		pivotElement.setOwnedSource(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getSource()));
		pivotElement.getOwnedIterators().addAll(doProcessAll(org.eclipse.ocl.pivot.Variable.class, astNode.getIterator()));
		pivotElement.setOwnedResult(doProcess(org.eclipse.ocl.pivot.Variable.class, astNode.getResult()));
		pivotElement.setOwnedBody(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getBody()));
		return super.visitIterateExp(astNode);
	}

	@Override
	public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.IteratorExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createIteratorExp());
		pivotElement.setOwnedSource(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getSource()));
		pivotElement.getOwnedIterators().addAll(doProcessAll(org.eclipse.ocl.pivot.Variable.class, astNode.getIterator()));
		pivotElement.setOwnedBody(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getBody()));
		return pivotElement;
	}

	@Override
	public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.InvalidLiteralExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createInvalidLiteralExp());
		return pivotElement;
	}

	@Override
	public Object visitLetExp(LetExp<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.LetExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createLetExp());
		pivotElement.setOwnedVariable(doProcess(org.eclipse.ocl.pivot.Variable.class, astNode.getVariable()));
		pivotElement.setOwnedIn(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getIn()));
		return pivotElement;
	}

	@Override
	public Object visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> astNode) {
		org.eclipse.ocl.pivot.MessageExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createMessageExp());
		//...
		return pivotElement;
	}

	@Override
	public Object visitNullLiteralExp(NullLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.NullLiteralExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createNullLiteralExp());
		return pivotElement;
	}

	@Override
	public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> astNode) {
		org.eclipse.ocl.pivot.OperationCallExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createOperationCallExp());
//		//FIXME returns null for referredOperation from ecoreSwitch.doSwitch(astNode);
//	//	Operation operation= doProcess(Operation.class, astNode.getReferredOperation());
//		if(operation!=null)
//		{
//			pivotElement.setReferredOperation(operation);
//		}
		pivotElement.setOwnedSource(doProcess(OCLExpression.class, astNode.getSource()));
		pivotElement.getOwnedArguments().addAll(doProcessAll(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getArgument()));
		return pivotElement;
	}

	@Override
	public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> astNode) {
		org.eclipse.ocl.pivot.PropertyCallExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createPropertyCallExp());
		pivotElement.setOwnedSource(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getSource()));
		//FIXME returning null Property from ecoreSwitch.doSwitch
//		Property property=doProcess(Property.class, astNode.getReferredProperty());
//		if(property!=null)
//		{
//			pivotElement.setReferredProperty(property);
//		}
		return pivotElement;
	}

	@Override
	public Object visitRealLiteralExp(RealLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.RealLiteralExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createRealLiteralExp());
		pivotElement.setRealSymbol(astNode.getRealSymbol());
		return pivotElement;
	}

	@Override
	public Object visitStateExp(StateExp<EClassifier, EObject> astNode) {
		org.eclipse.ocl.pivot.StateExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createStateExp());
		//...
		return pivotElement;
	}

	@Override
	public Object visitStringLiteralExp(StringLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.StringLiteralExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createStringLiteralExp());
			
		pivotElement.setStringSymbol(astNode.getStringSymbol());
		return pivotElement;
	}

	@Override
	public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> astNode) {
		org.eclipse.ocl.pivot.TupleLiteralExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createTupleLiteralExp());
		pivotElement.getOwnedParts().addAll(doProcessAll(org.eclipse.ocl.pivot.TupleLiteralPart.class, astNode.getPart()));
		return pivotElement;
	}

	@Override
	public Object visitTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> astNode) {
		org.eclipse.ocl.pivot.TupleLiteralPart pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createTupleLiteralPart());
		pivotElement.setName(astNode.getName());
		pivotElement.setOwnedInit(doProcess(org.eclipse.ocl.pivot.OCLExpression.class, astNode.getValue()));
		return pivotElement;
	}

	@Override
	public Object visitTypeExp(TypeExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.TypeExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createTypeExp());
		return pivotElement;
	}

	@Override
	public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<EClassifier> astNode) {
		org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp());
		pivotElement.setUnlimitedNaturalSymbol(astNode.getLongSymbol());
		return pivotElement;
	}

	@Override
	public Object visitVariable(Variable<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.Variable pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createVariable());

		pivotElement.setName(astNode.getName());		
		return pivotElement;
	}

	@Override
	public Object visitVariableExp(VariableExp<EClassifier, EParameter> astNode) {
		org.eclipse.ocl.pivot.VariableExp pivotElement =
				converter.addCreated(astNode, PivotFactory.eINSTANCE.createVariableExp());
		pivotElement.setName(astNode.getName());

//		pivotElement.setReferredVariable(doProcess(org.eclipse.ocl.pivot.Variable.class, astNode.getReferredVariable()));

		return pivotElement;
	}
}
