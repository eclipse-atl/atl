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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;

/**
 * Atl model analyser, used to get information from an incomplete ATL model.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class AtlModelAnalyser {

	/** context types */
	public final static int NULL_CONTEXT = 0;
	public final static int MODULE_CONTEXT = 1;
	public final static int HELPER_CONTEXT = 2;
	public final static int RULE_CONTEXT = 3;
	public final static int FROM_CONTEXT = 4;
	public final static int TO_CONTEXT = 5;
	public final static int DO_CONTEXT = 6;
	public final static int USING_CONTEXT = 7;

	/** detached types considered as "normal" */
	private final static String[] NORMAL_TYPES = { "OclModel", "Helper",
			"Module", "MatchedRule", "CalledRule", "Rule", "LazyRule" };

	/** completion helper used to find located elements */
	private AtlCompletionHelper fHelper;

	/** code model root (EMF object) */
	private EObject emfRoot = null;

	/** base offset of the model in the document */
	private int modelOffset;

	/** user offset in the document */
	private int context;
	
	public AtlModelAnalyser(AtlCompletionHelper fHelper, EObject emfRoot,
			int modelOffset, String lastKeyword, int userOffset) {
		this.fHelper = fHelper;
		this.modelOffset = modelOffset;
		this.emfRoot = emfRoot;
		try {
			this.context = getContext(lastKeyword, userOffset);
		} catch (BadLocationException e) {
			AtlUIPlugin.log(e);
		}
	}

	/**
	 * Search the nearest element of the given offset.
	 * 
	 * @param offset
	 * @return the element
	 * @throws BadLocationException
	 */
	public EObject getLocatedElement(int offset) throws BadLocationException {
		EObject res = null;
		if (emfRoot != null) {
			TreeIterator ti = emfRoot.eResource().getAllContents();
			int maxDebOffset = -1;
			while (ti.hasNext()) {
				EObject object = (EObject) ti.next();
				int[] elementOffsets = fHelper.getElementOffsets(object,
						modelOffset);
				if (elementOffsets != null) {
					if (elementOffsets[0] <= offset
							&& elementOffsets[1] >= offset) {
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
	 * Looks for a specific type in the anormal root types
	 * 
	 * @param type
	 *            the name of the searched type
	 * @return the corresponding EMF object if present
	 */
	public EObject getLostType(String type) {
		if (emfRoot != null) {
			EList ti = emfRoot.eResource().getContents();
			for (Iterator iterator = ti.iterator(); iterator.hasNext();) {
				EObject object = (EObject) iterator.next();
				String currentType = object.eClass().getName();
				boolean isnormal = false;
				for (int i = 0; i < NORMAL_TYPES.length; i++) {
					isnormal = isnormal || NORMAL_TYPES[i].equals(currentType);
				}
				if (!isnormal) {
					if (type.equals(currentType))
						return object;
				}
			}
		}
		return null;
	}

	public int getContext() {
		return context;
	}

	private int getContext(String keyword, int offset) throws BadLocationException {
		if (keyword == null)
			return AtlModelAnalyser.NULL_CONTEXT;
		if (keyword.equalsIgnoreCase("module"))
			return AtlModelAnalyser.MODULE_CONTEXT;
		if (keyword.equalsIgnoreCase("helper")) {
			if (getLocatedElement(offset) == null)
				return AtlModelAnalyser.MODULE_CONTEXT;
			return AtlModelAnalyser.HELPER_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("rule"))
			return AtlModelAnalyser.RULE_CONTEXT;
		if (keyword.equalsIgnoreCase("from")) {
			if (emfRoot == null)
				return AtlModelAnalyser.MODULE_CONTEXT;
			return AtlModelAnalyser.FROM_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("to")) {
			return AtlModelAnalyser.TO_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("do")) {
			if (getLocatedElement(offset) == null)
				return AtlModelAnalyser.MODULE_CONTEXT;
			return AtlModelAnalyser.DO_CONTEXT;
		}
		if (keyword.equalsIgnoreCase("using"))
			return AtlModelAnalyser.USING_CONTEXT;
		return AtlModelAnalyser.NULL_CONTEXT;
	}

	public static String getContextName(int id) {
		switch (id) {
		case NULL_CONTEXT : return "NULL_CONTEXT";
		case MODULE_CONTEXT : return "MODULE_CONTEXT";
		case HELPER_CONTEXT : return "HELPER_CONTEXT";
		case RULE_CONTEXT : return "RULE_CONTEXT";
		case FROM_CONTEXT : return "FROM_CONTEXT";
		case TO_CONTEXT : return "TO_CONTEXT";
		case DO_CONTEXT : return "DO_CONTEXT";
		case USING_CONTEXT : return "USING_CONTEXT";
		}
		return "NULL_CONTEXT";
	}
}
