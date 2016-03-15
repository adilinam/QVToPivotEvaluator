package org.eclipse.m2m.qvt.oml.pivot.evaluator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationVisitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

@SuppressWarnings("restriction")
public abstract class AbstractQVToPivotVisitorImpl extends BasicEvaluationVisitor implements QVTOperationalVisitor<Object>
{
	
	protected AbstractQVToPivotVisitorImpl(BasicQVToExecutor basicQVToExecutor) {
		
	super(basicQVToExecutor);
			
	}
	
	public Object visiting(Object astNode) {
//		throw new UnsupportedOperationException("Unsupported " + getClass().getSimpleName() + " for " + ((EObject)astNode).eClass().getName());
		System.err.println("Unsupported " + getClass().getSimpleName() + " for " + ((EObject)astNode).eClass().getName());
		return null;
	}

	@Override
	public Object  visitConstructor( org.eclipse.qvto.examples.pivot.qvtoperational.Constructor astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitConstructorBody( org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitContextualProperty( org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitDummyRelation( org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitDummyRelationDomain( org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitDummyRelationalTransformation( org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitEntryOperation( org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitHelper( org.eclipse.qvto.examples.pivot.qvtoperational.Helper astNode) {
		return visiting(astNode);
	}
	@Override
	public Object visitImperativeCallExp( org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitImperativeOperation( org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitLibrary( org.eclipse.qvto.examples.pivot.qvtoperational.Library astNode) {
		return visiting(astNode);
	}
	@Override
	public Object visitMappingBody( org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitMappingCallExp( org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitMappingOperation( org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitMappingParameter( org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitModelParameter( org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitModelType( org.eclipse.qvto.examples.pivot.qvtoperational.ModelType astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitModule( org.eclipse.qvto.examples.pivot.qvtoperational.Module astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitModuleImport( org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitObjectExp( org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitOperationBody(  org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitOperationalTransformation( org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitResolveExp( org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitResolveInExp( org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp astNode) {
		return visiting(astNode);
	}
	@Override
	public Object  visitTag( org.eclipse.qvto.examples.pivot.qvtoperational.Tag astNode) {
		return visiting(astNode);
	}
	@Override
	public Object visitVarParameter( org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter astNode) {
		return visiting(astNode);
	}

}
