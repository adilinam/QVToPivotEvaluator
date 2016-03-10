/*******************************************************************************
 * Copyright (c) 2009, 2014 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core;

import org.eclipse.osgi.util.NLS;

public class DebugMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.qvt.oml.debug.core.DebugMessages"; //$NON-NLS-1$
	
	/**
	 * @since 1.5
	 */
	public static String QVTOVirtualProcess_processLabel;
	/**
	 * @since 1.5
	 */
	public static String QVTOVirtualProcess_defaultLabel;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DebugMessages.class);
	}

	private DebugMessages() {
	}
}
