package org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.util.QVTOperationalVisitor;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AltExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssertExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BlockExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BreakExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.CatchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ComputeExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ContinueExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ForExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeIterateExp;
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
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.WhileExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.Visitable;

@SuppressWarnings("restriction")
public abstract class AbstractQVToVisitorImpl extends AbstractVisitor<Object, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
EObject, CallOperationAction, SendSignalAction, Constraint> implements QVTOperationalVisitor<Object>
{
	protected static class AbstractEcoreSwitch extends EcoreSwitch<org.eclipse.ocl.pivot.Element>
	{
		protected final @NonNull TraditionalToPivotMapping converter;
		
		public AbstractEcoreSwitch(@NonNull TraditionalToPivotMapping converter) {
			this.converter = converter;
		}

		public org.eclipse.ocl.pivot.Element defaultCase(EObject astNode) {
			//System.out.println(astNode);
//			throw new UnsupportedOperationException("Unsupported " + getClass().getSimpleName() + " for " + ((EObject)astNode).eClass().getName());
			
			System.err.println("Unsupported " + getClass().getSimpleName() + " for " + ((EObject)astNode).eClass().getName());
			return null;
		}	
	}
	
	protected final @NonNull TraditionalToPivotMapping converter;
	protected final @NonNull QVToFacade qvto;
	protected final @NonNull AbstractEcoreSwitch ecoreSwitch;
	
	protected AbstractQVToVisitorImpl(@NonNull TraditionalToPivotMapping converter, @NonNull AbstractEcoreSwitch ecoreSwitch) {
		super(null);
		this.converter = converter;
		this.qvto = converter.getQVTo();
		this.ecoreSwitch = ecoreSwitch;
	}
	
	protected <T extends Element> @Nullable T doProcess(@NonNull Class<T> pivotClass, @Nullable EObject astNode) {
		if (astNode == null) {
			return null;
		}
		EObject pivotElement = null;
		if (astNode instanceof Visitable) {
			pivotElement = (EObject) ((Visitable)astNode).accept(this);
		}
		else {
			
				pivotElement = ecoreSwitch.doSwitch(astNode);
		}
		if (astNode.eContainer() == null) {
			assert pivotElement != null: "No Pivot object for " + TraditionalToPivotMapping.debugId(astNode)
			+ " contained by null";
		}
		else {
			assert pivotElement != null: "No Pivot object for " + TraditionalToPivotMapping.debugId(astNode)
			+ " contained by " + TraditionalToPivotMapping.debugId(astNode.eContainer()) + "::" + astNode.eContainingFeature().getName();
		}
		assert pivotClass.isAssignableFrom(pivotElement.getClass()) : pivotElement.eClass().getName() + " is not a " + pivotClass.getSimpleName();
		@SuppressWarnings("unchecked") T castElement = (T) pivotElement;
		return castElement;
	}

	/**
	 * Iteratively convert all the nodes to Pivot and return pivotElements as List
	 * @param pivotClass
	 * @param astNodes
	 * @return
	 */
	protected <T extends Element> @NonNull List<T> doProcessAll(@NonNull Class<T> pivotClass, /*@NonNull*/ Iterable<? extends EObject> astNodes) {
		List<T> pivotElements = new ArrayList<T>();
		for (EObject astNode : astNodes) {
			T pivotElement = doProcess(pivotClass, astNode);
			pivotElements.add((T)pivotElement);
		}
		return pivotElements;
	}

	public Object visiting(EObject astNode) {
//		throw new UnsupportedOperationException("Unsupported " + getClass().getSimpleName() + " for " + ((EObject)astNode).eClass().getName());
		System.err.println("Unsupported " + getClass().getSimpleName() + " for " + ((EObject)astNode).eClass().getName());
		return null;
	}

	@Override
	public Object visitAltExp(AltExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitAssertExp(AssertExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitBlockExp(BlockExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitBreakExp(BreakExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitCatchtExp(CatchExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitComputeExp(ComputeExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitContextualProperty(ContextualProperty astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitContinueExp(ContinueExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitDictLiteralExp(DictLiteralExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitDictLiteralPart(DictLiteralPart astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitForExp(ForExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitImperativeIterateExp(ImperativeIterateExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitImperativeOperation(ImperativeOperation astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitInstantiationExp(InstantiationExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitLibrary(Library astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitLogExp(LogExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitMappingCallExp(MappingCallExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitModelType(ModelType astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitModuleImport(ModuleImport astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitOrderedTupleLiteralExp(OrderedTupleLiteralExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitOrderedTupleLiteralPart(OrderedTupleLiteralPart astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitRaiseExp(RaiseExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitResolveExp(ResolveExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitResolveInExp(ResolveInExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitReturnExp(ReturnExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitSwitchExp(SwitchExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitTryExp(TryExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitUnlinkExp(UnlinkExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitUnpackExp(UnpackExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitVarParameter(VarParameter astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitVariableInitExp(VariableInitExp astNode) {
		return visiting(astNode);
	}

	@Override
	public Object visitWhileExp(WhileExp astNode) {
		return visiting(astNode);
	}
}
