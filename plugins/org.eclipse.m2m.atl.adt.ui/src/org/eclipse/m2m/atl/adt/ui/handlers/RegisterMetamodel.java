/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.handlers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.adt.ui.Messages;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Registers a metamodel in order to open models in xmi default editor.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class RegisterMetamodel extends AbstractHandler {

	private Shell shell;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection iss = (IStructuredSelection)HandlerUtil.getCurrentSelection(event);
		this.shell = HandlerUtil.getActiveShell(event);
		IFile currentFile = (IFile)iss.getFirstElement();
		String artifactUri = currentFile.getLocation().toString();
		init(artifactUri);
		return null;
	}

	private Set<EObject> getElementsByType(Resource extent, String type) {
		Set<EObject> ret = new HashSet<EObject>();
		for (Iterator<?> i = extent.getAllContents(); i.hasNext();) {
			EObject eo = (EObject)i.next();
			if (eo.eClass().getName().equals(type)) {
				ret.add(eo);
			}
		}
		return ret;
	}

	private void init(String metamodelURL) {
		Resource.Factory myEcoreFactory = new EcoreResourceFactoryImpl();
		Resource mmExtent = myEcoreFactory.createResource(URI.createURI(metamodelURL));
		try {
			mmExtent.load(new FileInputStream(metamodelURL), Collections.EMPTY_MAP);
		} catch (IOException e) {
			MessageDialog.openError(shell, Messages.getString("RegisterMetamodel.REGISTER_FAIL"), e.getMessage()); //$NON-NLS-1$
		}
		for (Iterator<EObject> it = getElementsByType(mmExtent, "EPackage").iterator(); it.hasNext();) { //$NON-NLS-1$
			EPackage p = (EPackage)it.next();
			String nsURI = p.getNsURI();
			if (nsURI == null) {
				nsURI = p.getName();
				p.setNsURI(nsURI);
			}
			EPackage.Registry.INSTANCE.put(nsURI, p);
		}

		for (Iterator<EObject> it = getElementsByType(mmExtent, "EDataType").iterator(); it.hasNext();) { //$NON-NLS-1$
			EObject eo = it.next();
			EStructuralFeature sf;
			sf = eo.eClass().getEStructuralFeature("name"); //$NON-NLS-1$
			String tname = (String)eo.eGet(sf);
			String icn = null;
			if (tname.equals("Boolean")) { //$NON-NLS-1$
				icn = "boolean"; //$NON-NLS-1$
			} else if (tname.equals("Double") || tname.equals("Real")) { //$NON-NLS-1$ //$NON-NLS-2$
				icn = "java.lang.Double"; //$NON-NLS-1$
			} else if (tname.equals("Float")) { //$NON-NLS-1$
				icn = "java.lang.Float"; //$NON-NLS-1$
			} else if (tname.equals("Integer")) { //$NON-NLS-1$
				icn = "java.lang.Integer"; //$NON-NLS-1$
			} else if (tname.equals("String")) { //$NON-NLS-1$
				icn = "java.lang.String"; //$NON-NLS-1$
			}
			if (icn != null) {
				sf = eo.eClass().getEStructuralFeature("instanceClassName"); //$NON-NLS-1$
				eo.eSet(sf, icn);
			}
		}
	}
}
