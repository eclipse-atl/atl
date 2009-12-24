/*******************************************************************************
 * Copyright (c) 2007, 2009 Obeo.
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.AtlTypesProcessor;

/**
 * Atl model analyser, used to get information from an incomplete ATL model.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlModelAnalyser {

	/** completion helper used to find located elements. */
	private AtlCompletionHelper fHelper;

	/** code model root (EMF object). */
	private EObject root;

	private String lastKeyword;

	 private String fileContext;

	private EObject locatedElement;

	private String context;

	private int modelOffset;

	private List<EObject> lostElements;

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
	 * @param fileContext
	 *            the main context of the file
	 */
	public AtlModelAnalyser(AtlCompletionHelper fHelper, EObject emfRoot, int modelOffset,
			String lastKeyword, int userOffset, String fileContext) throws BadLocationException {
		this.fHelper = fHelper;
		this.root = emfRoot;
		this.lastKeyword = lastKeyword;
		this.fileContext = fileContext;
		this.modelOffset = modelOffset;
		this.locatedElement = fHelper.getLocatedElement(emfRoot, userOffset, modelOffset);
		computeLostElements();
		computeContext();
	}

	private void computeLostElements() {
		lostElements = new ArrayList<EObject>();
		if (root != null) {
			for (EObject element : root.eResource().getContents()) {
				if (AtlCompletionHelper.getLocation(element) == null) {
					lostElements.add(element);
				}
			}
		}
	}

	private void computeContext() {
		if (lastKeyword != null) {
			if (lastKeyword.equalsIgnoreCase("helper") && (locatedElement != null || getLostTypesNames().contains("Helper"))) { //$NON-NLS-1$ //$NON-NLS-2$
				context = AtlContextType.HELPER_CONTEXT_ID;
			} else if (lastKeyword.equalsIgnoreCase("rule")) { //$NON-NLS-1$
				context = AtlContextType.RULE_CONTEXT_ID;
			} else if (lastKeyword.equalsIgnoreCase("from") && root != null) { //$NON-NLS-1$
				context = AtlContextType.RULE_CONTEXT_ID;
			} else if ((lastKeyword.equalsIgnoreCase("to") || lastKeyword.equalsIgnoreCase("do")) //$NON-NLS-1$//$NON-NLS-2$
					&& (locatedElement != null || (getLostTypesNames().contains("MatchedRule") //$NON-NLS-1$
							|| getLostTypesNames().contains("CalledRule") || getLostTypesNames().contains(//$NON-NLS-1$
							"LazyMatchedRule")))) { //$NON-NLS-1$
				context = AtlContextType.RULE_CONTEXT_ID;
			} else if (lastKeyword.equalsIgnoreCase("using")) { //$NON-NLS-1$
				context = AtlContextType.RULE_CONTEXT_ID;
			} else {
				context = fileContext;
			}
		} else {
			context = AtlContextType.ATL_CONTEXT_ID;
		}
	}

	public String getContext() {
		return context;
	}

	/**
	 * Search the parent element of the given element, if present.
	 * 
	 * @param element
	 *            the element
	 * @return the parent element
	 * @throws BadLocationException
	 */
	public EObject getContainer(EObject element) throws BadLocationException {
		EObject res = null;
		if (element.eContainer() != null) {
			res = element.eContainer();
		} else if (root != null) {
			int[] elementOffsets = fHelper.getElementOffsets(element, modelOffset);
			if (elementOffsets != null) {
				TreeIterator<EObject> ti = root.eResource().getAllContents();
				int maxDebOffset = -1;
				while (ti.hasNext()) {
					EObject tmp = ti.next();
					int[] tmpOffsets = fHelper.getElementOffsets(tmp, modelOffset);
					if (tmpOffsets != null) {
						if (tmpOffsets[0] <= elementOffsets[0] && tmpOffsets[1] >= elementOffsets[1]) {
							if (tmpOffsets[0] > maxDebOffset) {
								maxDebOffset = tmpOffsets[0];
								if (!element.equals(tmp)) {
									res = tmp;
								}
							}
						}
					}
				}
			}
		}
		return res;
	}

	/**
	 * Computes the previous element in the model.
	 * 
	 * @param element
	 *            the current element
	 * @return the previous element
	 * @throws BadLocationException
	 */
	public EObject getPreviousElement(EObject element) throws BadLocationException {
		EObject res = null;
		if (root != null) {
			int[] elementOffsets = fHelper.getElementOffsets(element, modelOffset);
			if (elementOffsets != null) {
				TreeIterator<EObject> ti = root.eResource().getAllContents();
				int maxEndOffset = -1;
				while (ti.hasNext()) {
					EObject tmp = ti.next();
					if (!tmp.equals(element)) {
						int[] tmpOffsets = fHelper.getElementOffsets(tmp, modelOffset);
						if (tmpOffsets != null && tmpOffsets[1] <= elementOffsets[0]
								&& tmpOffsets[1] > maxEndOffset) {
							maxEndOffset = tmpOffsets[1];
							if (!element.equals(tmp)) {
								res = tmp;
							}
						}
					}
				}
			}
		}
		return res;
	}

	public EObject getRoot() {
		return root;
	}

	public EObject getLocatedElement() {
		return locatedElement;
	}

	/**
	 * Returns the list of the lost types names. A type is "lost" when it has no container and no location.
	 * 
	 * @return the list of the lost types names
	 */
	public List<String> getLostTypesNames() {
		List<String> res = new ArrayList<String>();
		for (EObject element : lostElements) {
			res.add(element.eClass().getName());
		}
		return res;
	}

	/**
	 * Returns the list of the lost types having the given type.
	 * 
	 * @param typeName
	 *            the type name
	 * @return the list of the lost types
	 */
	public List<EObject> getLostElementsByType(String typeName) {
		List<EObject> res = new ArrayList<EObject>();
		for (EObject element : lostElements) {
			if (element.eClass().getName().equalsIgnoreCase(typeName)) {
				res.add(element);
			}
		}
		return res;
	}

	/**
	 * Returns the last lost types having the given type.
	 * 
	 * @param typeName
	 *            the type name
	 * @return the lost types
	 */
	public EObject getLastLostElementByType(String typeName) {
		List<EObject> found = getLostElementsByType(typeName);
		if (!found.isEmpty()) {
			return found.get(found.size() - 1);
		}
		return null;
	}

	/**
	 * Debugging utility (for a developer purpose).
	 */
	public void displayModel() {
		if (root != null) {
			try {
				root.eResource().save(System.err, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("no model to display"); //$NON-NLS-1$
		}
	}

	/**
	 * Returns the text associated to the given located element.
	 * 
	 * @param locatedElement
	 *            the element
	 * @return the text associated to the given located element
	 * @throws BadLocationException
	 */
	public String getText(EObject locatedElement) throws BadLocationException {
		return fHelper.getText(locatedElement, modelOffset);
	}

	/**
	 * Return the variable having the given name.
	 * 
	 * @param name
	 *            the variable name
	 * @return the variable object (in the ATL model)
	 */
	public EObject getVariableDeclaration(String name) {
		if (root != null) {
			for (Iterator<EObject> iterator = root.eResource().getAllContents(); iterator.hasNext();) {
				EObject element = iterator.next();
				if (AtlTypesProcessor.oclIsKindOf(element, "VariableDeclaration")) { //$NON-NLS-1$
					if (name.equals(AtlTypesProcessor.eGet(element, "varName"))) { //$NON-NLS-1$
						return element;
					}
				}
			}
		}
		return null;
	}

}
