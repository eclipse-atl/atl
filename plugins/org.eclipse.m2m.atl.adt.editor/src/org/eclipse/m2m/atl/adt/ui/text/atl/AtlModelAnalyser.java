/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import java.util.Iterator;
import java.util.logging.Level;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.m2m.atl.ATLLogger;

/**
 * Atl model analyser, used to get information from an incomplete ATL model.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlModelAnalyser {

	/** context types. */
	public static final int NULL_CONTEXT = 0;

	/** ATL module. */
	public static final int MODULE_CONTEXT = 1;

	/** Helper. */
	public static final int HELPER_CONTEXT = 2;

	/** Rule. */
	public static final int RULE_CONTEXT = 3;

	/** From section. */
	public static final int FROM_CONTEXT = 4;

	/** To section. */
	public static final int TO_CONTEXT = 5;

	/** Do section. */
	public static final int DO_CONTEXT = 6;

	/** Using section. */
	public static final int USING_CONTEXT = 7;

	/** detached types considered as "normal". */
	private static final String[] NORMAL_TYPES = {"OclModel", "Helper", //$NON-NLS-1$ //$NON-NLS-2$
			"Module", "MatchedRule", "CalledRule", "Rule", "LazyRule",}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	/** completion helper used to find located elements. */
	private AtlCompletionHelper fHelper;

	/** code model root (EMF object). */
	private EObject emfRoot;

	/** base offset of the model in the document. */
	private int modelOffset;

	/** user offset in the document. */
	private int context;

	/**
	 * Creates an analyser for ATL models.
	 * 
	 * @param fHelper
	 *            the completion helper
	 * @param emfRoot
	 *            the model root
	 * @param modelOffset
	 *            the model offset
	 * @param lastKeyword
	 *            the last detected keyword
	 * @param userOffset
	 *            the user current offset
	 */
	public AtlModelAnalyser(AtlCompletionHelper fHelper, EObject emfRoot, int modelOffset,
			String lastKeyword, int userOffset) {
		this.fHelper = fHelper;
		this.modelOffset = modelOffset;
		this.emfRoot = emfRoot;
		try {
			this.context = getContext(lastKeyword, userOffset);
		} catch (BadLocationException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Search the root element of the model.
	 * 
	 * @return the element
	 * @throws BadLocationException
	 */
	public EObject getRootElement() throws BadLocationException {
		return emfRoot;
	}

	/**
	 * Search the nearest element of the given offset.
	 * 
	 * @param offset
	 *            the given offset
	 * @return the element
	 * @throws BadLocationException
	 */
	public EObject getLocatedElement(int offset) throws BadLocationException {
		EObject res = null;
		if (emfRoot != null) {
			TreeIterator ti = emfRoot.eResource().getAllContents();
			int maxDebOffset = -1;
			while (ti.hasNext()) {
				EObject object = (EObject)ti.next();
				int[] elementOffsets = fHelper.getElementOffsets(object, modelOffset);
				if (elementOffsets != null) {
					if (elementOffsets[0] <= offset && elementOffsets[1] >= offset) {
						if (elementOffsets[0] > maxDebOffset) {
							maxDebOffset = elementOffsets[0];
							res = object;
						}
					}
				}
			}
		}
		return res;
	}

	/**
	 * Looks for a specific type in the anormal root types.
	 * 
	 * @param type
	 *            the name of the searched type
	 * @return the corresponding EMF object if present
	 */
	public EObject getLostType(String type) {
		if (emfRoot != null) {
			EList ti = emfRoot.eResource().getContents();
			for (Iterator iterator = ti.iterator(); iterator.hasNext();) {
				EObject object = (EObject)iterator.next();
				String currentType = object.eClass().getName();
				boolean isnormal = false;
				for (int i = 0; i < NORMAL_TYPES.length; i++) {
					isnormal = isnormal || NORMAL_TYPES[i].equals(currentType);
				}
				if (!isnormal) {
					if (type.equals(currentType)) {
						return object;
					}
				}
			}
		}
		return null;
	}

	public int getContext() {
		return context;
	}

	private int getContext(String keyword, int offset) throws BadLocationException {
		if (keyword == null) {
			return AtlModelAnalyser.NULL_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("module")) { //$NON-NLS-1$
			return AtlModelAnalyser.MODULE_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("helper")) { //$NON-NLS-1$
			if (getLocatedElement(offset) == null) {
				return AtlModelAnalyser.MODULE_CONTEXT;
			}
			return AtlModelAnalyser.HELPER_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("rule")) { //$NON-NLS-1$
			return AtlModelAnalyser.RULE_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("from")) { //$NON-NLS-1$
			if (emfRoot == null) {
				return AtlModelAnalyser.MODULE_CONTEXT;
			}
			return AtlModelAnalyser.FROM_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("to")) { //$NON-NLS-1$
			return AtlModelAnalyser.TO_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("do")) { //$NON-NLS-1$
			if (getLocatedElement(offset) == null) {
				return AtlModelAnalyser.MODULE_CONTEXT;
			}
			return AtlModelAnalyser.DO_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("using")) { //$NON-NLS-1$
			return AtlModelAnalyser.USING_CONTEXT;
		}
		return AtlModelAnalyser.NULL_CONTEXT;
	}

	/**
	 * Returns the context name by id.
	 * 
	 * @param id
	 *            the given id
	 * @return the context name
	 */
	public static String getContextName(int id) {
		switch (id) {
			case NULL_CONTEXT:
				return "NULL_CONTEXT"; //$NON-NLS-1$
			case MODULE_CONTEXT:
				return "MODULE_CONTEXT"; //$NON-NLS-1$
			case HELPER_CONTEXT:
				return "HELPER_CONTEXT"; //$NON-NLS-1$
			case RULE_CONTEXT:
				return "RULE_CONTEXT"; //$NON-NLS-1$
			case FROM_CONTEXT:
				return "FROM_CONTEXT"; //$NON-NLS-1$
			case TO_CONTEXT:
				return "TO_CONTEXT"; //$NON-NLS-1$
			case DO_CONTEXT:
				return "DO_CONTEXT"; //$NON-NLS-1$
			case USING_CONTEXT:
				return "USING_CONTEXT"; //$NON-NLS-1$
			default:
				return "NULL_CONTEXT"; //$NON-NLS-1$
		}
	}
}
