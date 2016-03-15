/*******************************************************************************
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvto.examples.pivot.imperativeocl/model/ImperativeOCL.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvto.examples.pivot.imperativeocl.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractMergedImperativeOCLVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedImperativeOCLVisitor<R, C>
	extends org.eclipse.ocl.pivot.util.AbstractMergedVisitor<R, C>
	implements ImperativeOCLVisitor<R>
{
	protected AbstractMergedImperativeOCLVisitor( C context) {
		super(context);
	}

	public @Nullable R visitAltExp( org.eclipse.qvto.examples.pivot.imperativeocl.AltExp object) {
		return visiting(object);
	}

	public @Nullable R visitAssertExp( org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp object) {
		return visiting(object);
	}

	public @Nullable R visitAssignExp( org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp object) {
		return visiting(object);
	}

	public @Nullable R visitBlockExp( org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp object) {
		return visiting(object);
	}

	public @Nullable R visitBreakExp( org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp object) {
		return visiting(object);
	}

	public @Nullable R visitCatchExp( org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp object) {
		return visiting(object);
	}

	public @Nullable R visitComputeExp( org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp object) {
		return visiting(object);
	}

	public @Nullable R visitContinueExp( org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp object) {
		return visiting(object);
	}

	public @Nullable R visitDictLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp object) {
		return visiting(object);
	}

	public @Nullable R visitDictLiteralPart( org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart object) {
		return visiting(object);
	}

	public @Nullable R visitDictionaryType( org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType object) {
		return visiting(object);
	}

	public @Nullable R visitForExp( org.eclipse.qvto.examples.pivot.imperativeocl.ForExp object) {
		return visiting(object);
	}

	public @Nullable R visitImperativeExpression( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression object) {
		return visiting(object);
	}

	public @Nullable R visitImperativeIterateExp( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp object) {
		return visiting(object);
	}

	public @Nullable R visitImperativeLoopExp( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp object) {
		return visiting(object);
	}

	public @Nullable R visitInstantiationExp( org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp object) {
		return visiting(object);
	}

	public @Nullable R visitListLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp object) {
		return visiting(object);
	}

	public @Nullable R visitListType( org.eclipse.qvto.examples.pivot.imperativeocl.ListType object) {
		return visiting(object);
	}

	public @Nullable R visitLogExp( org.eclipse.qvto.examples.pivot.imperativeocl.LogExp object) {
		return visiting(object);
	}

	public @Nullable R visitOrderedTupleLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp object) {
		return visiting(object);
	}

	public @Nullable R visitOrderedTupleLiteralPart( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart object) {
		return visiting(object);
	}

	public @Nullable R visitOrderedTupleType( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType object) {
		return visiting(object);
	}

	public @Nullable R visitRaiseExp( org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp object) {
		return visiting(object);
	}

	public @Nullable R visitReturnExp( org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp object) {
		return visiting(object);
	}

	public @Nullable R visitSwitchExp( org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp object) {
		return visiting(object);
	}

	public @Nullable R visitTryExp( org.eclipse.qvto.examples.pivot.imperativeocl.TryExp object) {
		return visiting(object);
	}

	public @Nullable R visitTypedef( org.eclipse.qvto.examples.pivot.imperativeocl.Typedef object) {
		return visiting(object);
	}

	public @Nullable R visitUnlinkExp( org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp object) {
		return visiting(object);
	}

	public @Nullable R visitUnpackExp( org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp object) {
		return visiting(object);
	}

	public @Nullable R visitVariableInitExp( org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp object) {
		return visiting(object);
	}

	public @Nullable R visitWhileExp( org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp object) {
		return visiting(object);
	}
}
