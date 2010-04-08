/*******************************************************************************
 * Copyright (c) 2009, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import org.eclipse.jface.text.templates.GlobalTemplateVariables;
import org.eclipse.jface.text.templates.TemplateContextType;

/**
 * The context types, used to provides content assist.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlContextType extends TemplateContextType {

	/** ATL file context. */
	public static final String ATL_CONTEXT_ID = "atl_context"; //$NON-NLS-1$

	/** ATL module context. */
	public static final String MODULE_CONTEXT_ID = "module_context"; //$NON-NLS-1$

	/** ATL query context. */
	public static final String QUERY_CONTEXT_ID = "query_context"; //$NON-NLS-1$

	/** ATL library context. */
	public static final String LIBRARY_CONTEXT_ID = "library_context"; //$NON-NLS-1$

	/** ATL rule context. */
	public static final String RULE_CONTEXT_ID = "rule_context"; //$NON-NLS-1$

	/** ATL helper context. */
	public static final String HELPER_CONTEXT_ID = "helper_context"; //$NON-NLS-1$

	/**
	 * Initialize context types.
	 */
	public AtlContextType() {
		// prevents instantiation
		initializeContextTypeResolvers();
	}

	/**
	 * Initializes the context type resolvers.
	 */
	public void initializeContextTypeResolvers() {
		addResolver(new GlobalTemplateVariables.Cursor());
	}

}
