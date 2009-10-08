/**
 * <copyright>
 *
 * Copyright (c) 2002-2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Obeo - code cleanup and tweaking for use within ATL
 *
 * </copyright>
 *
 * $Id: AtlResourceSelectionBox.java,v 1.1 2009/10/08 15:22:30 wpiers Exp $
 */
package org.eclipse.m2m.atl.adt.ui.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * Provide dialogs to get EMF metamodels URIs or path. This class originally came from plugin
 * <code>org.eclipse.emf.ecore.editor</code>.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlResourceSelectionBox extends LoadResourceDialog {

	private Shell shell;

	private Set<EPackage> registeredPackages = new LinkedHashSet<EPackage>();

	/**
	 * Creates the dialogs.
	 * 
	 * @param parent
	 *            the parent shell
	 */
	public AtlResourceSelectionBox(Shell parent) {
		super(parent);
		this.shell = parent;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog#processResource(org.eclipse.emf.ecore.resource.Resource)
	 */
	@Override
	protected boolean processResource(Resource resource) {
		// Put all static package in the package registry.
		//
		ResourceSet resourceSet = domain.getResourceSet();
		if (!resourceSet.getResources().contains(resource)) {
			Registry packageRegistry = resourceSet.getPackageRegistry();
			for (EPackage ePackage : getAllPackages(resource)) {
				packageRegistry.put(ePackage.getNsURI(), ePackage);
				registeredPackages.add(ePackage);
			}
		}
		return true;
	}

	public Set<EPackage> getRegisteredPackages() {
		return registeredPackages;
	}

	private Collection<EPackage> getAllPackages(Resource resource) {
		List<EPackage> result = new ArrayList<EPackage>();
		for (TreeIterator<?> j = new EcoreUtil.ContentTreeIterator<Object>(resource.getContents()) {
			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<? extends EObject> getEObjectChildren(EObject eObject) {
				return eObject instanceof EPackage ? ((EPackage)eObject).getESubpackages().iterator()
						: Collections.<EObject> emptyList().iterator();
			}
		}; j.hasNext();) {
			Object content = j.next();
			if (content instanceof EPackage) {
				result.add((EPackage)content);
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.ui.dialogs.ResourceDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		Composite buttonComposite = (Composite)composite.getChildren()[0];
		Button browseRegisteredPackagesButton = new Button(buttonComposite, SWT.PUSH);
		browseRegisteredPackagesButton.setText(EcoreEditorPlugin.INSTANCE
				.getString("_UI_BrowseRegisteredPackages_label")); //$NON-NLS-1$
		prepareBrowseRegisteredPackagesButton(browseRegisteredPackagesButton);

		FormData data = new FormData();
		Control[] children = buttonComposite.getChildren();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(children[0], -CONTROL_OFFSET);
		browseRegisteredPackagesButton.setLayoutData(data);

		uriField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String text = uriField.getText();
				if (text.contains(" ")) { //$NON-NLS-1$
					String[] uris = text.split(" "); //$NON-NLS-1$
					if (uris.length > 0) {
						uriField.setText(uris[uris.length - 1]);
					}
				}
			}
		});

		return composite;
	}

	private void prepareBrowseRegisteredPackagesButton(Button browseRegisteredPackagesButton) {
		browseRegisteredPackagesButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				RegisteredPackageDialog registeredPackageDialog = new RegisteredPackageDialog(getShell());
				registeredPackageDialog.setMultipleSelection(false);
				registeredPackageDialog.open();
				Object[] result = registeredPackageDialog.getResult();
				if (result != null && result.length == 1) {
					Object nsURI = result[0];
					if (registeredPackageDialog.isDevelopmentTimeVersion()) {
						ResourceSet resourceSet = new ResourceSetImpl();
						resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
						String uri = ""; //$NON-NLS-1$
						Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin
								.getEPackageNsURIToGenModelLocationMap();

						URI location = ePackageNsURItoGenModelLocationMap.get(nsURI);
						Resource resource = resourceSet.getResource(location, true);
						EcoreUtil.resolveAll(resource);

						for (Resource r : resourceSet.getResources()) {
							for (EPackage ePackage : getAllPackages(r)) {
								if (nsURI.equals(ePackage.getNsURI())) {
									uri = r.getURI().toString();
									break;
								}
							}
						}
						uriField.setText(uri);
					} else {
						uriField.setText(nsURI.toString());
					}
				}
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.ui.dialogs.ResourceDialog#getURIText()
	 */
	@Override
	public String getURIText() {
		String res = super.getURIText();
		if (res != null && res.contains(" ")) { //$NON-NLS-1$
			res = res.split(" ")[0]; //$NON-NLS-1$
		}
		return res;
	}

	/**
	 * Sets the dialog text.
	 * 
	 * @param text
	 *            the text
	 */
	public void setText(String text) {
		uriField.setText(text);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.window.Window#getShell()
	 */
	@Override
	public Shell getShell() {
		return shell;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.ui.dialogs.ResourceDialog#isMulti()
	 */
	@Override
	protected boolean isMulti() {
		return false;
	}

	/**
	 * This dialog displays registered packages.
	 */
	public static class RegisteredPackageDialog extends ElementListSelectionDialog {

		private boolean isDevelopmentTimeVersion;

		/**
		 * Creates the dialogs.
		 * 
		 * @param parent
		 *            the parent shell
		 */
		public RegisteredPackageDialog(Shell parent) {
			super(parent, new LabelProvider() {
				@Override
				public Image getImage(Object element) {
					return ExtendedImageRegistry.getInstance().getImage(
							EcoreEditPlugin.INSTANCE.getImage("full/obj16/EPackage")); //$NON-NLS-1$
				}
			});

			setMultipleSelection(true);
			setMessage(EcoreEditorPlugin.INSTANCE.getString("_UI_SelectRegisteredPackageURI")); //$NON-NLS-1$
			setFilter("*"); //$NON-NLS-1$
			setTitle(EcoreEditorPlugin.INSTANCE.getString("_UI_PackageSelection_label")); //$NON-NLS-1$
		}

		public boolean isDevelopmentTimeVersion() {
			return isDevelopmentTimeVersion;
		}

		private void updateElements() {
			if (isDevelopmentTimeVersion) {
				Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin
						.getEPackageNsURIToGenModelLocationMap();
				Object[] result = ePackageNsURItoGenModelLocationMap.keySet().toArray(
						new Object[ePackageNsURItoGenModelLocationMap.size()]);
				Arrays.sort(result);
				setListElements(result);
			} else {
				Object[] result = EPackage.Registry.INSTANCE.keySet().toArray(
						new Object[EPackage.Registry.INSTANCE.size()]);
				Arrays.sort(result);
				setListElements(result);
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.dialogs.ElementListSelectionDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		protected Control createDialogArea(Composite parent) {
			Composite result = (Composite)super.createDialogArea(parent);
			Composite buttonGroup = new Composite(result, SWT.NONE);
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			buttonGroup.setLayout(layout);
			final Button developmentTimeVersionButton = new Button(buttonGroup, SWT.RADIO);
			developmentTimeVersionButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					isDevelopmentTimeVersion = developmentTimeVersionButton.getSelection();
					updateElements();
				}
			});
			developmentTimeVersionButton.setText(EcoreEditorPlugin.INSTANCE
					.getString("_UI_DevelopmentTimeVersion_label")); //$NON-NLS-1$
			Button runtimeTimeVersionButton = new Button(buttonGroup, SWT.RADIO);
			runtimeTimeVersionButton
					.setText(EcoreEditorPlugin.INSTANCE.getString("_UI_RuntimeVersion_label")); //$NON-NLS-1$
			runtimeTimeVersionButton.setSelection(true);

			updateElements();

			return result;
		}
	}
}
