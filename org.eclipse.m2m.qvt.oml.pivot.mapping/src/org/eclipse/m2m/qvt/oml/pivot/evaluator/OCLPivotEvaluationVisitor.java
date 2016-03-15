package org.eclipse.m2m.qvt.oml.pivot.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
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
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp;import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp;
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

public class OCLPivotEvaluationVisitor extends AbstractQVToPivotVisitorImpl  {


	

	protected OCLPivotEvaluationVisitor(BasicQVToExecutor basicQVToExecutor) 
	{
		super(basicQVToExecutor);

		}

	private @Nullable Transformation loadTransformation(@NonNull PivotMetamodelManager metamodelManager) {
		// TODO Auto-generated method stub
		return null;
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


}
