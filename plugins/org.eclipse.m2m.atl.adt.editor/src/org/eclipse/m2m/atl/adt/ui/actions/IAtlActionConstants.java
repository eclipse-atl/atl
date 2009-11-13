/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.actions;

/**
 * Action ids for standard actions, for groups in the menu bar, and for actions in context menus of JDT views.
 */
public interface IAtlActionConstants {

	/**
	 * Source menu: name of standard Indent global action (value
	 * <code>"org.eclipse.m2m.atl.adt.ui.actions.Indent"</code>).
	 */
	String INDENT = "org.eclipse.m2m.atl.adt.ui.actions.Indent"; //$NON-NLS-1$

	/**
	 * Source menu: name of standard Toggle Comment action (value
	 * <code>"org.eclipse.m2m.atl.adt.ui.actions.ToggleComment"</code>).
	 */
	String TOGGLE_COMMENT = "org.eclipse.m2m.atl.adt.ui.actions.ToggleComment"; //$NON-NLS-1$

	/**
	 * Source menu: name of standard go to matching bracket action (value
	 * <code>"org.eclipse.m2m.atl.adt.ui.actions.gotoMatchingBracket"</code>).
	 */
	String GOTO_MATCHING_BRACKET = "org.eclipse.m2m.atl.adt.ui.actions.gotoMatchingBracket"; //$NON-NLS-1$

}
