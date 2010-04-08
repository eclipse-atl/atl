/*******************************************************************************
 * Copyright (c) 2009, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.common;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.atl.adt.ui.Messages;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * This dialog displays files from the workspace.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class WorkspaceFileDialog extends ElementTreeSelectionDialog {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent Shell
	 * @param extensions
	 *            the handled file extensions
	 */
	public WorkspaceFileDialog(Shell parent, final String... extensions) {
		super(parent, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		setInput(ResourcesPlugin.getWorkspace().getRoot());
		setMessage(Messages.getString("WorkspaceFileDialog.SELECT_FILE")); //$NON-NLS-1$
		setTitle(Messages.getString("WorkspaceFileDialog.SELECT_FILE")); //$NON-NLS-1$
		setAllowMultiple(false);
		setDoubleClickSelects(true);
		addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				boolean ret = false;
				try {
					ret = isResourceAvailable((IResource)element, extensions);
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
				return ret;
			}
		});
		setValidator(new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				IStatus ret = Status.CANCEL_STATUS;
				if (selection.length == 1) {
					if (selection[0] instanceof IFile) {
						ret = Status.OK_STATUS;
					}
				}
				return ret;
			}
		});
	}

	private static boolean isResourceAvailable(IResource resource, String... extensions) throws CoreException {
		if (resource instanceof IContainer) {
			if (((IContainer)resource).isAccessible()) {
				IResource[] members = ((IContainer)resource).members();
				for (IResource member : members) {
					if (isResourceAvailable(member, extensions)) {
						return true;
					}
				}
			}
		} else if (resource instanceof IFile) {
			IFile currentFile = (IFile)resource;
			if (extensions == null || extensions.length == 0) {
				return true;
			} else if (currentFile.getFileExtension() != null) {
				for (int i = 0; i < extensions.length; i++) {
					String extension = extensions[i];
					if (currentFile.getFileExtension().toUpperCase().equals(extension.toUpperCase())) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
