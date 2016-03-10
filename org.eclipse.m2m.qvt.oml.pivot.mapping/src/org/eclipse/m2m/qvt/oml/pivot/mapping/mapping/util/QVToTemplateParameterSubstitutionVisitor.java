package org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.qvto.examples.pivot.imperativeocl.AltExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType;
import org.eclipse.qvto.examples.pivot.imperativeocl.ForExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListType;
import org.eclipse.qvto.examples.pivot.imperativeocl.LogExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType;
import org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.TryExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.Typedef;
import org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.Constructor;
import org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Helper;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Library;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelType;
import org.eclipse.qvto.examples.pivot.qvtoperational.Module;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport;
import org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.Tag;
import org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

public class QVToTemplateParameterSubstitutionVisitor extends TemplateParameterSubstitutionVisitor implements QVTOperationalVisitor<Object>
{	
	protected static @NonNull QVToTemplateParameterSubstitutionVisitor createVisitor(@NonNull EObject eObject, @NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		Resource resource = eObject.eResource();
		if (resource instanceof ASResource) {
			return (@NonNull QVToTemplateParameterSubstitutionVisitor) ((ASResource)resource).getASResourceFactory().createTemplateParameterSubstitutionVisitor(environmentFactory, selfType, selfTypeValue);
		}
		else {
			return new QVToTemplateParameterSubstitutionVisitor(environmentFactory, selfType, selfTypeValue);
		}
	}

	/**
	 * Return the specialized form of type analyzing expr to determine the formal to actual parameter mappings under the
	 * supervision of a metamodelManager and using selfType as the value of OclSelf.
	 */
	public static @NonNull Type specializeType(@NonNull Type type, @NonNull CallExp callExp, @NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		QVToTemplateParameterSubstitutionVisitor visitor = createVisitor(callExp, environmentFactory, selfType, selfTypeValue);
//		visitor.exclude(callExp);
		visitor.visit(callExp);
		return visitor.specializeType(type);
	}
	
	public QVToTemplateParameterSubstitutionVisitor(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		super(environmentFactory, selfType, selfTypeValue);
	}

	@Override
	public @Nullable Object visitAltExp(AltExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitAssertExp(AssertExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitAssignExp(AssignExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitBlockExp(BlockExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitBreakExp(BreakExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitCatchExp(CatchExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitComputeExp(ComputeExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitContinueExp(ContinueExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitDictLiteralExp(DictLiteralExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitDictLiteralPart(DictLiteralPart object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitDictionaryType(DictionaryType object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitForExp(ForExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitImperativeExpression(ImperativeExpression object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitImperativeIterateExp(ImperativeIterateExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitImperativeLoopExp(ImperativeLoopExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitInstantiationExp(InstantiationExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitListLiteralExp(ListLiteralExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitListType(ListType object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitLogExp(LogExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitOrderedTupleLiteralExp(OrderedTupleLiteralExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitOrderedTupleLiteralPart(OrderedTupleLiteralPart object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitOrderedTupleType(OrderedTupleType object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitRaiseExp(RaiseExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitReturnExp(ReturnExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitSwitchExp(SwitchExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitTryExp(TryExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitTypedef(Typedef object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitUnlinkExp(UnlinkExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitUnpackExp(UnpackExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitVariableInitExp(VariableInitExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitWhileExp(WhileExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitConstructor(Constructor object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitConstructorBody(ConstructorBody object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitContextualProperty(ContextualProperty object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitDummyRelation(DummyRelation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitDummyRelationDomain(DummyRelationDomain object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitDummyRelationalTransformation(DummyRelationalTransformation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitEntryOperation(EntryOperation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitHelper(Helper object) {
		return visitImperativeOperation(object);
	}

	@Override
	public @Nullable Object visitImperativeCallExp(ImperativeCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitImperativeOperation(ImperativeOperation object) {
		return visitOperation(object);
	}

	@Override
	public @Nullable Object visitLibrary(Library object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitMappingBody(MappingBody object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitMappingCallExp(MappingCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitMappingOperation(MappingOperation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitMappingParameter(MappingParameter object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitModelParameter(ModelParameter object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitModelType(ModelType object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitModule(Module object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitModuleImport(ModuleImport object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitObjectExp(ObjectExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitOperationBody(OperationBody object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitOperationalTransformation(OperationalTransformation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitResolveExp(ResolveExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitResolveInExp(ResolveInExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitTag(Tag object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Object visitVarParameter(VarParameter object) {
		return visitParameter(object);
	}
}
