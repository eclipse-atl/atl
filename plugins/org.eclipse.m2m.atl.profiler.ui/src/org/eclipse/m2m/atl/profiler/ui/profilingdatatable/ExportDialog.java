/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.ui.profilingdatatable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * A dialog for profiling model export.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class ExportDialog extends Dialog {

	Object result;

	/**
	 * Creates the dialog.
	 * 
	 * @param parent
	 *            the parent shell
	 * @param style
	 *            the dialog style
	 */
	public ExportDialog(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Creates the dialog.
	 * 
	 * @param parent
	 *            the parent shell
	 */
	public ExportDialog(Shell parent) {
		this(parent, 0); // your default style bits go here (not the Shell's style bits)
	}

	/**
	 * Opens the dialog.
	 * 
	 * @return the result
	 */
	public Object open() {
		Shell parent = getParent();
		Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText(getText());
		// TODO fill in
		shell.open();
		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}
}
