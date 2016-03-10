package org.eclipse.m2m.qvt.oml.pivot.evaluator;

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
import org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util.QVToFacade;
import org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util.TraditionalToPivotMapping;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.evaluation.OCLEvaluationVisitor;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.AbstractExtendingQVTOperationalVisitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalAdapterFactory;

@SuppressWarnings("restriction")
public abstract class AbstractQVToPivotVisitorImpl extends OCLEvaluationVisitor  
implements org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor<Object>
{
	protected static class AbstractEcoreSwitch extends EcoreSwitch<org.eclipse.ocl.pivot.Element>
	{
		protected final  TraditionalToPivotMapping converter;
		
		public AbstractEcoreSwitch( TraditionalToPivotMapping converter) {
			this.converter = converter;
		}

		public org.eclipse.ocl.pivot.Element defaultCase(EObject astNode) {
			//System.out.println(astNode);
//			throw new UnsupportedOperationException("Unsupported " + getClass().getSimpleName() + " for " + ((EObject)astNode).eClass().getName());
			
			System.err.println("Unsupported " + getClass().getSimpleName() + " for " + ((EObject)astNode).eClass().getName());
			return null;
		}	
	}
	
	
	protected AbstractQVToPivotVisitorImpl(EvaluationEnvironment environment) {
		super(environment);		
	}
	
	public Object visiting(Object astNode) {
//		throw new UnsupportedOperationException("Unsupported " + getClass().getSimpleName() + " for " + ((EObject)astNode).eClass().getName());
		System.err.println("Unsupported " + getClass().getSimpleName() + " for " + ((EObject)astNode).eClass().getName());
		return null;
	}

	public Object  visitConstructor( org.eclipse.qvto.examples.pivot.qvtoperational.Constructor astNode) {
		return visiting(astNode);
	}
	public Object  visitConstructorBody( org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody astNode) {
		return visiting(astNode);
	}
	public Object  visitContextualProperty( org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty astNode) {
		return visiting(astNode);
	}
	public Object  visitDummyRelation( org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation astNode) {
		return visiting(astNode);
	}
	public Object  visitDummyRelationDomain( org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain astNode) {
		return visiting(astNode);
	}
	public Object  visitDummyRelationalTransformation( org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation astNode) {
		return visiting(astNode);
	}
	public Object  visitEntryOperation( org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation astNode) {
		return visiting(astNode);
	}
	public Object  visitHelper( org.eclipse.qvto.examples.pivot.qvtoperational.Helper astNode) {
		return visiting(astNode);
	}
	public Object visitImperativeCallExp( org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp astNode) {
		return visiting(astNode);
	}
	public Object  visitImperativeOperation( org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation astNode) {
		return visiting(astNode);
	}
	public Object  visitLibrary( org.eclipse.qvto.examples.pivot.qvtoperational.Library astNode) {
		return visiting(astNode);
	}
	public Object visitMappingBody( org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody astNode) {
		return visiting(astNode);
	}
	public Object  visitMappingCallExp( org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp astNode) {
		return visiting(astNode);
	}
	public Object  visitMappingOperation( org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation astNode) {
		return visiting(astNode);
	}
	public Object  visitMappingParameter( org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter astNode) {
		return visiting(astNode);
	}
	public Object  visitModelParameter( org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter astNode) {
		return visiting(astNode);
	}
	public Object  visitModelType( org.eclipse.qvto.examples.pivot.qvtoperational.ModelType astNode) {
		return visiting(astNode);
	}
	public Object  visitModule( org.eclipse.qvto.examples.pivot.qvtoperational.Module astNode) {
		return visiting(astNode);
	}
	public Object  visitModuleImport( org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport astNode) {
		return visiting(astNode);
	}
	public Object  visitObjectExp( org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp astNode) {
		return visiting(astNode);
	}
	public Object  visitOperationBody(  org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody astNode) {
		return visiting(astNode);
	}
	public Object  visitOperationalTransformation( org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation astNode) {
		return visiting(astNode);
	}
	public Object  visitResolveExp( org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp astNode) {
		return visiting(astNode);
	}
	public Object  visitResolveInExp( org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp astNode) {
		return visiting(astNode);
	}
	public Object  visitTag( org.eclipse.qvto.examples.pivot.qvtoperational.Tag astNode) {
		return visiting(astNode);
	}
	public Object visitVarParameter( org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter astNode) {
		return visiting(astNode);
	}

}
