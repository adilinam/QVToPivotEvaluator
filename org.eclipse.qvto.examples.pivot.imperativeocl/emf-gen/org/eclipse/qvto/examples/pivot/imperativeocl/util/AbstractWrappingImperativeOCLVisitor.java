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
 * An AbstractWrappingImperativeOCLVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingImperativeOCLVisitor<R, C, D extends ImperativeOCLVisitor<R>, P>
	extends org.eclipse.ocl.pivot.util.AbstractWrappingVisitor<R, C, D, P>
	implements ImperativeOCLVisitor<R>
{
	protected AbstractWrappingImperativeOCLVisitor( D delegate,  C context) {
		super(delegate, context);
	}

	public @Nullable R visitAltExp( org.eclipse.qvto.examples.pivot.imperativeocl.AltExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitAltExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitAssertExp( org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitAssertExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitAssignExp( org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitAssignExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitBlockExp( org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitBlockExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitBreakExp( org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitBreakExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitCatchExp( org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitCatchExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitComputeExp( org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitComputeExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitContinueExp( org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitContinueExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitDictLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDictLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitDictLiteralPart( org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDictLiteralPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitDictionaryType( org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDictionaryType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitForExp( org.eclipse.qvto.examples.pivot.imperativeocl.ForExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitForExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitImperativeExpression( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitImperativeExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitImperativeIterateExp( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitImperativeIterateExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitImperativeLoopExp( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitImperativeLoopExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitInstantiationExp( org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitInstantiationExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitListLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitListLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitListType( org.eclipse.qvto.examples.pivot.imperativeocl.ListType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitListType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitLogExp( org.eclipse.qvto.examples.pivot.imperativeocl.LogExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitLogExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitOrderedTupleLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOrderedTupleLiteralExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitOrderedTupleLiteralPart( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOrderedTupleLiteralPart(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitOrderedTupleType( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOrderedTupleType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitRaiseExp( org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitRaiseExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitReturnExp( org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitReturnExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitSwitchExp( org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitSwitchExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitTryExp( org.eclipse.qvto.examples.pivot.imperativeocl.TryExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTryExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitTypedef( org.eclipse.qvto.examples.pivot.imperativeocl.Typedef object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTypedef(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitUnlinkExp( org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitUnlinkExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitUnpackExp( org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitUnpackExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitVariableInitExp( org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableInitExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitWhileExp( org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitWhileExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
