/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.adt.ui.outline.AtlLabelProvider;
import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * Class that manage information from the ATL VM (via ATL profiler) linked with the profiling model.
 * 
 * @see org.eclipse.m2m.atl.profiler.core.ATLProfiler
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public final class ATLModelHandler {

	// singleton access
	private static ATLModelHandler instance;

	// fields
	private AtlLabelProvider labelProvider;

	private EObject atlModel;

	private Map<String, EObject> registry;

	// debug
	private boolean debugMessages;

	private ATLModelHandler() {

	}

	/**
	 * Singleton access.
	 * 
	 * @return the {@link ATLModelHandler} singleton
	 */
	public static ATLModelHandler getInstance() {
		if (instance == null) {
			instance = new ATLModelHandler();
		}
		return instance;
	}

	/**
	 * Initialize components.
	 */
	public void init() {
		// get methods for labels
		labelProvider = new AtlLabelProvider();
		registry = new HashMap<String, EObject>();
	}

	/**
	 * Register ATL model for operation registry.
	 * 
	 * @param model
	 *            the atl model
	 */
	public void registerATLModel(EObject model) {
		this.atlModel = model;
		registerElements(model);
	}

	/**
	 * Register elements.
	 * 
	 * @param eo
	 */
	private void registerElements(EObject eo) {
		String name = getName(eo).trim();
		if (!name.equals("<default>")) { //$NON-NLS-1$
			registry.put(name, eo);
			for (EObject o : eo.eContents()) {
				registerElements(o);
			}
			if (debugMessages) {
				ATLLogger.info("atl registry : [" + name + "]"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * Get the name for an ATL element.
	 * 
	 * @param eo
	 * @return
	 */
	private String getName(EObject eo) {
		// return first part
		return labelProvider.getText(eo).trim().split(":")[0]; //$NON-NLS-1$
	}

	/**
	 * Check if the name refer to a atl asm native operation.
	 * 
	 * @param name
	 *            the operation name
	 * @return <code>true</code> if the operation is native
	 */
	public static boolean isNativeOperation(String name) {
		return name.equals(ASMConstants.EXEC) || name.equals(ASMConstants.MATCHER)
				|| name.equals(ASMConstants.RESOLVE);
	}

	/**
	 * Get the real ATL name (from the ATL Model).
	 * 
	 * @param sfOpName
	 *            the operation name
	 * @return the real ATL name
	 */
	public String getATLName(String sfOpName) {
		String name = ""; //$NON-NLS-1$
		if (sfOpName.contains(ASMConstants.APPLY)) {
			name = sfOpName.split(ASMConstants.APPLY)[1];
		} else if (sfOpName.contains(ASMConstants.MATCH) & !(sfOpName.contains(ASMConstants.MATCHER))) {
			name = sfOpName.split(ASMConstants.MATCH)[1];
		} else if (sfOpName.contains(ASMConstants.INIT)) {
			name = sfOpName.split(ASMConstants.INIT)[1];
		} else {
			name = sfOpName;
		}
		return name;
	}

	/**
	 * Get ATL operation from a name.
	 * 
	 * @param sfOpName
	 *            the operation name
	 * @return the operation element
	 */
	public EObject getATLOperationFromName(String sfOpName) {
		String name = getATLName(sfOpName);
		EObject o = registry.get(name);

		return o;
	}

	// getters & setters
	public EObject getAtlModel() {
		return atlModel;
	}

	public void setAtlModel(EObject atlModel) {
		this.atlModel = atlModel;
	}

}
