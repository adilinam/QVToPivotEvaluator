/**
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
 */
public interface ImperativeOCLVisitor<R> extends org.eclipse.ocl.pivot.util.Visitor<R>
{
	@Nullable R visitAltExp( org.eclipse.qvto.examples.pivot.imperativeocl.AltExp object);
	@Nullable R visitAssertExp( org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp object);
	@Nullable R visitAssignExp( org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp object);
	@Nullable R visitBlockExp( org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp object);
	@Nullable R visitBreakExp( org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp object);
	@Nullable R visitCatchExp( org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp object);
	@Nullable R visitComputeExp( org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp object);
	@Nullable R visitContinueExp( org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp object);
	@Nullable R visitDictLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp object);
	@Nullable R visitDictLiteralPart( org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart object);
	@Nullable R visitDictionaryType( org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType object);
	@Nullable R visitForExp( org.eclipse.qvto.examples.pivot.imperativeocl.ForExp object);
	@Nullable R visitImperativeExpression( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression object);
	@Nullable R visitImperativeIterateExp( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp object);
	@Nullable R visitImperativeLoopExp( org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp object);
	@Nullable R visitInstantiationExp( org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp object);
	@Nullable R visitListLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp object);
	@Nullable R visitListType( org.eclipse.qvto.examples.pivot.imperativeocl.ListType object);
	@Nullable R visitLogExp( org.eclipse.qvto.examples.pivot.imperativeocl.LogExp object);
	@Nullable R visitOrderedTupleLiteralExp( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp object);
	@Nullable R visitOrderedTupleLiteralPart( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart object);
	@Nullable R visitOrderedTupleType( org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType object);
	@Nullable R visitRaiseExp( org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp object);
	@Nullable R visitReturnExp( org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp object);
	@Nullable R visitSwitchExp( org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp object);
	@Nullable R visitTryExp( org.eclipse.qvto.examples.pivot.imperativeocl.TryExp object);
	@Nullable R visitTypedef( org.eclipse.qvto.examples.pivot.imperativeocl.Typedef object);
	@Nullable R visitUnlinkExp( org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp object);
	@Nullable R visitUnpackExp( org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp object);
	@Nullable R visitVariableInitExp( org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp object);
	@Nullable R visitWhileExp( org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp object);
}
