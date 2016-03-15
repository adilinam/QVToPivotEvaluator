package org.eclipse.m2m.qvt.oml.pivot.evaluator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util.TraditionalToPivotMapping;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.evaluation.OCLEvaluationVisitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalAdapterFactory;

@SuppressWarnings("restriction")
public  class QVToPivotEvaluationVisitor  extends OCLPivotEvaluationVisitor
{
	


	public QVToPivotEvaluationVisitor(BasicQVToExecutor basicQVToExecutor) {
		super(basicQVToExecutor);
		
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
