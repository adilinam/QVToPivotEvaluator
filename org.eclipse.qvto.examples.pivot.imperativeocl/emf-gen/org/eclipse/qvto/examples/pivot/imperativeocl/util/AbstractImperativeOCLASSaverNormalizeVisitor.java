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

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;

/**
 * An AbstractImperativeOCLASSaverNormalizeVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractImperativeOCLASSaverNormalizeVisitor
	extends ASSaverNormalizeVisitor
	implements ImperativeOCLVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractImperativeOCLASSaverNormalizeVisitor( ASSaver context) {
		super(context);
	}	

	public @Nullable Object visitAltExp( org.eclipse.qvto.examples.pivot.imperativeocl.AltExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitAssertExp( org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitAssignExp( org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitBlockExp( org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitBreakExp( org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitCatchExp( org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitComputeExp( org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitContinueExp( org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitDictLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable Object visitDictLiteralPart( org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart object) {
		return visitElement(object);
	}

	public @Nullable Object visitDictionaryType( org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType object) {
		return visitCollectionType(object);
	}

	public @Nullable Object visitForExp( org.eclipse.qvto.examples.pivot.imperativeocl.ForExp object) {
		return visitImperativeLoopExp(object);
	}

	public @Nullable Object visitImperativeExpression( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression object) {
		return visitOCLExpression(object);
	}

	public @Nullable Object visitImperativeIterateExp( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp object) {
		return visitImperativeLoopExp(object);
	}

	public @Nullable Object visitImperativeLoopExp( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp object) {
		return visitLoopExp(object);
	}

	public @Nullable Object visitInstantiationExp( org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitListLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable Object visitListType( org.eclipse.qvto.examples.pivot.imperativeocl.ListType object) {
		return visitCollectionType(object);
	}

	public @Nullable Object visitLogExp( org.eclipse.qvto.examples.pivot.imperativeocl.LogExp object) {
		return visitOperationCallExp(object);
	}

	public @Nullable Object visitOrderedTupleLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable Object visitOrderedTupleLiteralPart( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart object) {
		return visitElement(object);
	}

	public @Nullable Object visitOrderedTupleType( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType object) {
		return visitClass(object);
	}

	public @Nullable Object visitRaiseExp( org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitReturnExp( org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitSwitchExp( org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitTryExp( org.eclipse.qvto.examples.pivot.imperativeocl.TryExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitTypedef( org.eclipse.qvto.examples.pivot.imperativeocl.Typedef object) {
		return visitClass(object);
	}

	public @Nullable Object visitUnlinkExp( org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitUnpackExp( org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitVariableInitExp( org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitWhileExp( org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp object) {
		return visitImperativeExpression(object);
	}
}
