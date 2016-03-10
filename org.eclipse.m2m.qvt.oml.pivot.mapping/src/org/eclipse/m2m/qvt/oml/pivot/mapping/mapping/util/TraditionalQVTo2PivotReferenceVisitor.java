package org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.internal.qvt.oml.expressions.Constructor;
import org.eclipse.m2m.internal.qvt.oml.expressions.ConstructorBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.EntryOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AltExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssertExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BlockExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BreakExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.CatchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ContinueExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ForExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.InstantiationExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.LogExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.RaiseExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ReturnExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.SwitchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TryExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnlinkExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnpackExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.VariableInitExp;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLFactory;
import org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp;

@SuppressWarnings("restriction")
public class TraditionalQVTo2PivotReferenceVisitor extends TraditionalOCL2PivotReferenceVisitor
{
	protected static class OCLEcoreSwitch extends AbstractEcoreSwitch
	{
		public OCLEcoreSwitch(@NonNull TraditionalToPivotMapping converter) {
			super(converter);
		}

		@Override
		public Element caseEPackage(EPackage object) {
			return converter.getPivotOfEcore(org.eclipse.ocl.pivot.Package.class, object);
		}
	}

	public TraditionalQVTo2PivotReferenceVisitor(TraditionalToPivotMapping converter) {
		super(converter, new OCLEcoreSwitch(converter));
	}

	public Object visitAssignExp(AssignExp astNode) {
		org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp pivotElement = (org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp) converter.getPivot(astNode);
		return pivotElement;
	}


	public Object visitConstructor(Constructor astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.Constructor pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.Constructor) converter.getPivot(astNode);
		return pivotElement;
	}

	public Object visitConstructorBody(ConstructorBody astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody) converter.getPivot(astNode);
		return pivotElement;
	}

	public Object visitEntryOperation(EntryOperation astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation) converter.getPivot(astNode);
		return pivotElement;
	}

	public Object visitHelper(Helper astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.Helper pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.Helper)converter.getPivot(astNode);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		pivotElement.setIsRequired(true);
		return pivotElement;
	}
	public Object visitContextualProperty(ContextualProperty astNode) {
		//Not Tested
		org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty pivotElement = 
				(org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty)converter.getPivot(astNode);
		//	pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;
	}

	public Object visitDictLiteralExp(DictLiteralExp astNode) {
		// Not Tested
		org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp)converter.getPivot(astNode);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;	
	}
	public Object visitDictLiteralPart(DictLiteralPart astNode) {
		//Not Tested
		org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart)converter.getPivot(astNode);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));

		return pivotElement;
	}

	public Object visitImperativeOperation(ImperativeOperation astNode) {
		//Not Tested
		org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation pivotElement =
				(org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation) converter.getPivot(astNode);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;

	}

	public Object visitMappingBody(MappingBody astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody) converter.getPivot(astNode);
		return pivotElement;
	}

	@Override
	public Object visitMappingCallExp(MappingCallExp astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp) converter.getPivot(astNode);

		pivotElement.setReferredOperation(doProcess(Operation.class, astNode.getReferredOperation()));
		pivotElement.setType(resolveEClassifier(astNode.getEType()));

		//..
		return pivotElement;
	}
	public Object visitInstantiationExp(InstantiationExp astNode) {
		//Not Tested
		org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp pivotElement =
				(org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp ) converter.getPivot(astNode);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;

	}
	public Object visitOrderedTupleLiteralExp(OrderedTupleLiteralExp astNode) {
		//Not Tested
		org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp pivotElement =
				(org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp ) converter.getPivot(astNode);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;
	}
	public Object visitOrderedTupleLiteralPart(OrderedTupleLiteralPart astNode) {		
		// Not Tested
		org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart pivotElement =
				(org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart) converter.getPivot(astNode);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;

	}
	public Object visitRaiseExp(RaiseExp astNode) {
		// Not Tested
		org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp pivotElement =
				(org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp) converter.getPivot(astNode);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;
	}
	public Object visitUnpackExp(UnpackExp astNode) {
		// Not Tested
		org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp pivotElement =
				(org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp) converter.getPivot(astNode);
		return pivotElement;
	}

	public Object visitUnlinkExp(UnlinkExp astNode) {
		// Not Tested
		org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp pivotElement =
				(org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp) converter.getPivot(astNode);
		return pivotElement;
	}
	public Object visitMappingOperation(MappingOperation astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation) converter.getPivot(astNode);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;
	}

	@Override
	public Object visitModelType(ModelType astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.ModelType pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.ModelType) converter.getPivot(astNode);

		//FIXME errors due to EcoreSwitch
			pivotElement.getMetamodel().addAll(doProcessAll(org.eclipse.ocl.pivot.Package.class, astNode.getMetamodel()));
		
		return pivotElement;
	}

	public Object visitModule(Module astNode) {
		if (astNode instanceof OperationalTransformation) {
			return visitOperationalTransformation((OperationalTransformation)astNode);
		}
		org.eclipse.qvto.examples.pivot.qvtoperational.Module pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.Module) converter.getPivot(astNode);
		return pivotElement;
	}

	public Object visitObjectExp(ObjectExp astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp) converter.getPivot(astNode);
		org.eclipse.ocl.pivot.Variable referredObject = (org.eclipse.ocl.pivot.Variable) converter.getPivot(astNode.getReferredObject());
		pivotElement.setReferredObject(referredObject);
		return pivotElement;
	}
	public Object visitImperativeIterateExp(org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeIterateExp astNode) {
		ImperativeIterateExp pivotElement = (ImperativeIterateExp) converter.getPivot(astNode);
		Variable target=(Variable) converter.getPivot(astNode.getTarget());
		pivotElement.setTarget(target);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;
	}
	public Object visitSwitchExp(SwitchExp astNode)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp) converter.getPivot(astNode);
		//	pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;
	}
	public Object visitWhileExp(org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.WhileExp astNode)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp) converter.getPivot(astNode);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;
	}
	public Object visitAltExp(AltExp astNode)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.AltExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.AltExp) converter.getPivot(astNode);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;
	}
	public Object visitBreakExp(BreakExp astNode)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp) converter.getPivot(astNode);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;

	}
	public Object visitAssertExp(AssertExp astNode) {
		org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp) converter.getPivot(astNode);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;

	}
	public Object visitVariableInitExp(VariableInitExp astNode)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp) converter.getPivot(astNode);
		Variable variable=(Variable) converter.getPivot(astNode.getReferredVariable());
		pivotElement.setReferredVariable(variable);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));

		return pivotElement;
	}
	public Object visitTryExp(TryExp astNode)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.TryExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.TryExp) converter.getPivot(astNode);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		return pivotElement;
	}
	public Object visitCatchtExp(CatchExp astNode)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp) converter.getPivot(astNode);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		//FIXME exceptions not handled
		//		for(EClassifier classifers: astNode.getExceptsion())
		//		{
		//			pivotElement.getException().add(resolveEClassifier(classifers));
		//		}
		return pivotElement;
	}
	public Object visitContinueExp(ContinueExp astNode) {
		org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp) converter.getPivot(astNode);
		return pivotElement;
	}
	public Object visitBlockExp(BlockExp astNode)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp) converter.getPivot(astNode);
		//		pivotElement.setType(resolveEClassifier(astNode.getEType()));	//FIXME
		return pivotElement;
	}
	public Object visitForExp(ForExp astNode)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.ForExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.ForExp) converter.getPivot(astNode);
		OCLExpression condition=(OCLExpression) converter.getPivot(astNode.getCondition());
		pivotElement.setCondition(condition);
		//	pivotElement.setType(resolveEClassifier(astNode.getEType())); 
		return pivotElement;
	}
	public Object visitReturnExp(ReturnExp astNode)
	{

		org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp) converter.getPivot(astNode);

		pivotElement.setValue((OCLExpression) converter.getPivot(astNode.getValue()));
		pivotElement.setType(resolveEClassifier(astNode.getEType())); 

		return pivotElement;
	}

	public Object visitLogExp(LogExp astNode)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.LogExp pivotElement = 
				(org.eclipse.qvto.examples.pivot.imperativeocl.LogExp) converter.getPivot(astNode);
		OCLExpression condition=(OCLExpression) converter.getPivot(astNode.getCondition());
		pivotElement.setCondition(condition);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));

		return pivotElement;
	}
	public Object visitOperationBody(OperationBody astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody) converter.getPivot(astNode);
		return pivotElement;
	}
	public Object visitVariableExp(VariableExp astNode)
	{
		org.eclipse.ocl.pivot.VariableExp pivotElement = 
				(org.eclipse.ocl.pivot.VariableExp) converter.getPivot(astNode);
		Variable referredVariable=(Variable) converter.getPivot(astNode.getReferredVariable());
		pivotElement.setReferredVariable(referredVariable);
		return pivotElement;
	}

	public Object visitOperationalTransformation(OperationalTransformation astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation) converter.getPivot(astNode);
		pivotElement.getUsedModelType().addAll(doProcessAll(org.eclipse.qvto.examples.pivot.qvtoperational.ModelType.class, astNode.getUsedModelType()));
		return pivotElement;
	}

	@Override
	public Object visitResolveExp(ResolveExp astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp) converter.getPivot(astNode);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitResolveInExp(ResolveInExp astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp) converter.getPivot(astNode);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		pivotElement.setIsRequired(true);
		return pivotElement;
	}

	@Override
	public Object visitVarParameter(VarParameter astNode) {
		org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter pivotElement = (org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter) converter.getPivot(astNode);
		pivotElement.setType(resolveEClassifier(astNode.getEType()));
		pivotElement.setIsRequired(true);
		return pivotElement;
	}
}
