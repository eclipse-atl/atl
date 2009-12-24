/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;

/**
 * The ATL Editor parameters.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class AtlEditorUI {

	/** Key to store custom templates. */
	private static final String CUSTOM_TEMPLATES_KEY = "org.eclipse.m2m.atl.editor.customtemplates"; //$NON-NLS-1$

	/** The shared instance. */
	private static AtlEditorUI fInstance;

	/** The template store. */
	private TemplateStore fStore;

	/** The context type registry. */
	private ContributionContextTypeRegistry fRegistry;

	private Map<String, String> templateImagePaths;

	private AtlEditorUI() {
		// c.f. file templates/atl.properties
		templateImagePaths = new HashMap<String, String>();

		templateImagePaths.put("Module", "$nl$/icons/module.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		templateImagePaths.put("Library", "$nl$/icons/libs.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		templateImagePaths.put("Query", "$nl$/icons/query.gif"); //$NON-NLS-1$ //$NON-NLS-2$

		templateImagePaths.put("Rule", "$nl$/icons/matchedRule.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		templateImagePaths.put("Called Rule", "$nl$/icons/matchedRule.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		templateImagePaths.put("Helper", "$nl$/icons/helper.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		templateImagePaths.put("Attribute", "$nl$/icons/helper.gif"); //$NON-NLS-1$ //$NON-NLS-2$

		templateImagePaths.put("Using", "$nl$/icons/using.gif"); //$NON-NLS-1$ //$NON-NLS-2$
		templateImagePaths.put("Do", "$nl$/icons/imperative.gif"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static AtlEditorUI getDefault() {
		if (fInstance == null)
			fInstance = new AtlEditorUI();
		return fInstance;
	}

	/**
	 * Returns this plug-in's template store.
	 * 
	 * @return the template store of this plug-in instance
	 */
	public TemplateStore getTemplateStore() {
		if (fStore == null) {
			fStore = new ContributionTemplateStore(getContextTypeRegistry(), AtlUIPlugin.getDefault()
					.getPreferenceStore(), CUSTOM_TEMPLATES_KEY);
			try {
				fStore.load();
			} catch (IOException e) {
				AtlUIPlugin.getDefault().getLog().log(
						new Status(IStatus.ERROR, "org.eclipse.m2m.atl.adt.editor", IStatus.OK, "", e)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return fStore;
	}

	/**
	 * Returns this plug-in's context type registry.
	 * 
	 * @return the context type registry for this plug-in instance
	 */
	public ContextTypeRegistry getContextTypeRegistry() {
		if (fRegistry == null) {
			// create an configure the contexts available in the template editor
			fRegistry = new ContributionContextTypeRegistry();
			fRegistry.addContextType(AtlContextType.ATL_CONTEXT_ID);
			fRegistry.addContextType(AtlContextType.MODULE_CONTEXT_ID);
			fRegistry.addContextType(AtlContextType.QUERY_CONTEXT_ID);
			fRegistry.addContextType(AtlContextType.LIBRARY_CONTEXT_ID);
			fRegistry.addContextType(AtlContextType.RULE_CONTEXT_ID);
			fRegistry.addContextType(AtlContextType.HELPER_CONTEXT_ID);
		}
		return fRegistry;
	}

	/**
	 * Retrieves the {@link Image} for a given template name.
	 * 
	 * @param name
	 *            the template name
	 * @return the {@link Image}
	 */
	public Image getTemplateImage(String name) {
		String path = templateImagePaths.get(name);
		if (path == null) {
			path = "$nl$/icons/templateprop_co.gif"; //$NON-NLS-1$
		}
		return AtlUIPlugin.getDefault().getImage(path);
	}

	/**
	 * Registers an image in the repository.
	 * 
	 * @param name
	 *            the image name
	 * @param path
	 *            the image path
	 */
	public void registerImage(String name, String path) {
		templateImagePaths.put(name, path);
	}

}
