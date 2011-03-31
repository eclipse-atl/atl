/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlModelAnalyser;
import org.eclipse.m2m.atl.adt.ui.text.atl.OpenDeclarationUtils;

/**
 * This class allows us to look into the model for the occurrence of the selected word (if there are). Several
 * problems are encountered:
 * <ul>
 * <li>while the model isn't saved, the finder looks into the old model</li>
 * <li>if there is an error in the model, the finder cannot go through it, and can only find occurrences
 * before the error</li>
 * <li>see also the query todo</li>
 * </ul>
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlOccurrencesFinder implements IOccurrencesFinder {

	/**
	 * the list of all the occurrences locations
	 */
	private List<OccurrenceLocation> fResult;

	private IDocument document;

	private AtlEditor editor;

	private AtlModelAnalyser analyser;

	/**
	 * the region of the selection (cannot be null or empty (length = 0)
	 */
	private IRegion selection;

	/**
	 * the description to display in the eclipse marker
	 */
	private String fDescription;

	/**
	 * the kind of occurrence (the word is highlighted differently according to this flag)
	 */
	private int fFlag = F_EXCEPTION_DECLARATION;

	/**
	 * if this attribute is true, we do not add occurrences to the result list
	 */
	private boolean fQuit = false;

	public AtlOccurrencesFinder(AtlEditor editor, IDocument document) {
		this.editor = editor;
		this.document = document;
		fResult = new ArrayList<IOccurrencesFinder.OccurrenceLocation>();
	}

	/**
	 * Initialization of the finder, with a text selection.
	 * 
	 * @param selection
	 *            the current text selection
	 * @return always null (this is not used here)
	 */
	public String initialize(IRegion selection) {
		this.selection = selection;
		return null;
	}

	public String getJobLabel() {
		return null;
	}

	public String getUnformattedPluralLabel() {
		return null;
	}

	public String getUnformattedSingularLabel() {
		return null;
	}

	public String getElementName() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.editor.IOccurrencesFinder#getOccurrences()
	 */
	public OccurrenceLocation[] getOccurrences() {
		try {
			performSearch();
		} catch (BadLocationException e) {
			// Do nothing
		}
		if (fResult.isEmpty())
			return null;

		return (OccurrenceLocation[])fResult.toArray(new OccurrenceLocation[fResult.size()]);
	}

	/**
	 * Performs the occurrences search, and looks into the model for occurrences of the current selected word.
	 * The search is different according to the type of the selected word.
	 * 
	 * @throws BadLocationException
	 */
	private void performSearch() throws BadLocationException {
		analyser = editor.getModelAnalyser();
		if (selection != null) {
			EObject selectedObject = analyser.getLocatedElement(selection.getOffset());
			if (oclIsKindOf(selectedObject, "VariableExp")) { //$NON-NLS-1$
				variableExpSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "OclModelElement")) { //$NON-NLS-1$
				oclModelElementSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "Binding")) { //$NON-NLS-1$
				bindingSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "NavigationOrAttributeCallExp")) { //$NON-NLS-1$
				navigationOrAttributeCallExpSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "OperationCallExp")) { //$NON-NLS-1$
				operationCallExpSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "VariableDeclaration")) { //$NON-NLS-1$
				variableDeclarationSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "OclModel")) { //$NON-NLS-1$
				oclModelSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "EnumLiteralExp")) { //$NON-NLS-1$
				enumLiteralExpSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "Operation")) { //$NON-NLS-1$
				operationSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "Attribute")) { //$NON-NLS-1$
				attributeSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "IteratorExp")) { //$NON-NLS-1$
				iteratorExpSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "IterateExp")) { //$NON-NLS-1$
				iterateExpSearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "Query")) { //$NON-NLS-1$
				querySearch(selectedObject);
			} else if (oclIsKindOf(selectedObject, "OclType")) { //$NON-NLS-1$
				oclTypeSearch(selectedObject);
			} else {
				selection = null;
				fResult = new ArrayList<IOccurrencesFinder.OccurrenceLocation>();
				return;
			}
			if (!fQuit) {
				fResult.add(new OccurrenceLocation(selection.getOffset(), selection.getLength(), fFlag,
						fDescription));
			}
			fQuit = false;
		}
	}

	/**
	 * Returns the value of a feature on an EObject.
	 * 
	 * @param self
	 *            the EObject
	 * @param featureName
	 *            the feature name
	 * @return the feature value
	 */
	public static Object eGet(EObject self, String featureName) {
		EStructuralFeature feature = self.eClass().getEStructuralFeature(featureName);
		if (feature != null) {
			return self.eGet(feature);
		}
		return null;
	}

	/**
	 * Equivalent of ASMOclAny oclIsKindOf method for EObjects.
	 * 
	 * @param element
	 *            the tested element
	 * @param testedElementName
	 *            the type name
	 * @return <code>True</code> element has testedElementName in its superTypes, <code>False</code> else.
	 */
	public static boolean oclIsKindOf(EObject element, String testedElementName) {
		if (element != null) {
			if (element.eClass().getName().equals(testedElementName)) {
				return true;
			} else {
				EList<EClass> types = element.eClass().getEAllSuperTypes();
				for (Iterator<EClass> iterator = types.iterator(); iterator.hasNext();) {
					EClass object = iterator.next();
					if (object.getName().equals(testedElementName)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Gets the region of the element (actually, it gives the region of the word that is interesting for us in
	 * the expression given by the element.
	 * 
	 * @param element
	 *            the expression we want to extract the word
	 * @return the region of the interesting word of the given element
	 * @throws BadLocationException
	 */
	public IRegion getRegionFromElement(EObject element) throws BadLocationException {
		if (element == null)
			return null;
		String text = analyser.getHelper().getText(element, 0);
		int[] offsets = analyser.getHelper().getElementOffsets(element, 0);
		if(offsets == null)
			return null;
		int offset = offsets[0];
		if (oclIsKindOf(element, "IteratorExp") || //$NON-NLS-1$
				oclIsKindOf(element, "NavigationOrAttributeCallExp") || //$NON-NLS-1$
				oclIsKindOf(element, "OclModelElement")) { //$NON-NLS-1$
			String name = (String)eGet(element, "name"); //$NON-NLS-1$
			offset = offsets[0] + text.lastIndexOf(name);
		} else if (oclIsKindOf(element, "CollectionOperationCallExp") || //$NON-NLS-1$
				oclIsKindOf(element, "OperationCallExp")) { //$NON-NLS-1$
			String name = (String)eGet(element, "operationName"); //$NON-NLS-1$
			offset = offsets[0] + text.lastIndexOf(name);
		} else if (oclIsKindOf(element, "IterateExp")) { //$NON-NLS-1$
			offset = offsets[0] + text.lastIndexOf("iterate"); //$NON-NLS-1$
		}
		return OpenDeclarationUtils.findWord(document, offset);
	}

	/**
	 * Browses the model in order to find occurrences of an element and add it to the result list.
	 * 
	 * @param element
	 *            the element we want the occurrences from
	 * @param name
	 *            the name of the element we are looking for
	 * @param featureName
	 *            the name of the feature that allows us to find the name of the current navigated element
	 * @param declarationType
	 *            the type of the element that will be considered as "declaration" (different highlighting)
	 * @param useType
	 *            the type of the element that will be considered as "occurrence" (different highlighting)
	 * @param displayType
	 *            the type that is going to be displayed in the eclipse marker
	 * @throws BadLocationException
	 */
	public void browseModel(EObject element, String name, String featureName, String declarationType,
			String useType, String displayType) throws BadLocationException {
		IRegion varRegion = null;
		for (EObject obj : element.eContents()) {
			String subName = (String)eGet(obj, featureName);
			if (subName == null && !featureName.equals("name")) //$NON-NLS-1$
				subName = (String)eGet(obj, "name"); //$NON-NLS-1$
			if (useType.equals("IterateExp")) { //$NON-NLS-1$
				if (oclIsKindOf(obj, "IterateExp")) { //$NON-NLS-1$
					subName = name;
				}
			}
			if (subName != null && subName.equals(name)) {
				varRegion = getRegionFromElement(obj);
				if(varRegion == null)
					return;
				if (oclIsKindOf(obj, declarationType)) {
					fResult.add(new OccurrenceLocation(varRegion.getOffset(), varRegion.getLength(),
							F_WRITE_OCCURRENCE, "Declaration of " + displayType + " '" + name + "'")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				} else if (oclIsKindOf(obj, useType)) {
					fResult.add(new OccurrenceLocation(varRegion.getOffset(), varRegion.getLength(),
							F_EXCEPTION_DECLARATION, "Occurrence of " + displayType + " '" + name + "'")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}
			}
			if (obj.eContents() != null && obj.eContents().size() > 0)
				browseModel(obj, name, featureName, declarationType, useType, displayType);
		}
	}

	/**
	 * Browses the model in order to find occurrences of a type and add it to the result list.
	 * 
	 * @param element
	 *            the type
	 * @param name
	 *            the name of the type
	 * @throws BadLocationException
	 */
	public void browseModelForType(EObject element, String name) throws BadLocationException {
		IRegion varRegion = null;
		for (EObject obj : element.eContents()) {
			String subName = analyser.getHelper().getText(obj, 0);
			if (subName != null && subName.equals(name)) {
				varRegion = getRegionFromElement(obj);
				if(varRegion == null)
					return;
				fResult.add(new OccurrenceLocation(varRegion.getOffset(), varRegion.getLength(),
						F_EXCEPTION_DECLARATION, "Occurrence of type '" + name + "'")); //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (obj.eContents() != null && obj.eContents().size() > 0)
				browseModelForType(obj, name);
		}
	}

	/**
	 * The search for an element of type variable expression
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void variableExpSearch(EObject element) throws BadLocationException {
		EObject referredVariable = (EObject)eGet(element, "referredVariable"); //$NON-NLS-1$
		String name = (String)eGet(referredVariable, "varName"); //$NON-NLS-1$
		IRegion varRegion = getRegionFromElement(referredVariable);
		fResult.add(new OccurrenceLocation(varRegion.getOffset(), varRegion.getLength(), F_WRITE_OCCURRENCE,
				"Declaration of variable '" + name + "'")); //$NON-NLS-1$ //$NON-NLS-2$
		for (EObject obj : referredVariable.eCrossReferences()) {
			varRegion = getRegionFromElement(obj);
			if (obj != element) {
				fResult.add(new OccurrenceLocation(varRegion.getOffset(), varRegion.getLength(),
						F_EXCEPTION_DECLARATION, "Occurrence of variable '" + name + "'")); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		fDescription = "Occurrence of variable '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_EXCEPTION_DECLARATION;
	}

	/**
	 * The search for an element of type ocl model element
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void oclModelElementSearch(EObject element) throws BadLocationException {
		String name = (String)eGet(element, "name"); //$NON-NLS-1$
		this.browseModel(analyser.getRoot(), name, "name", "", "OclModelElement", "model element"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		fDescription = "Occurrence of model element '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_EXCEPTION_DECLARATION;
	}

	/**
	 * The search for an element of type binding
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void bindingSearch(EObject element) throws BadLocationException {
		String name = (String)eGet(element, "propertyName"); //$NON-NLS-1$
		this.browseModel(element.eContainer(), name, "propertyName", "", "Binding", "binding"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		fDescription = "Occurrence of binding '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_EXCEPTION_DECLARATION;
	}

	/**
	 * The search for an element of type navigation or attribute call expression
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void navigationOrAttributeCallExpSearch(EObject element) throws BadLocationException {
		String name = (String)eGet(element, "name"); //$NON-NLS-1$
		this.browseModel(analyser.getRoot(), name, "name", "Attribute", "NavigationOrAttributeCallExp", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"attribute"); //$NON-NLS-1$
		fDescription = "Occurrence of attribute '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_EXCEPTION_DECLARATION;
	}

	/**
	 * The search for an element of type operation call expression
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void operationCallExpSearch(EObject element) throws BadLocationException {
		String name = (String)eGet(element, "operationName"); //$NON-NLS-1$
		if (name.equals("and") || //$NON-NLS-1$
				name.equals("or")) { //$NON-NLS-1$ // TODO check and complete this not exhaustive list
			fQuit = true;
			return;
		}
		this.browseModel(analyser.getRoot(), name, "operationName", "Operation", "OperationCallExp", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"operation"); //$NON-NLS-1$
		fDescription = "Occurrence of operation '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_EXCEPTION_DECLARATION;
	}

	/**
	 * The search for an element of type variable declaration
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void variableDeclarationSearch(EObject element) throws BadLocationException {
		String name = (String)eGet(element, "varName"); //$NON-NLS-1$
		if (name.equals("self") || name.equals("thisModule")) { //$NON-NLS-1$ //$NON-NLS-2$
			fQuit = true;
			return;
		}
		IRegion varRegion = null;
		for (EObject obj : element.eCrossReferences()) {
			varRegion = getRegionFromElement(obj);
			fResult.add(new OccurrenceLocation(varRegion.getOffset(), varRegion.getLength(),
					F_EXCEPTION_DECLARATION, "Occurrence of variable '" + name + "'")); //$NON-NLS-1$ //$NON-NLS-2$
		}
		fDescription = "Declaration of variable '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_WRITE_OCCURRENCE;
	}

	/**
	 * The search for an element of type ocl model
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void oclModelSearch(EObject element) throws BadLocationException {
		String name = (String)eGet(element, "name"); //$NON-NLS-1$
		if (name.equals("OUT") || name.equals("IN")) { //$NON-NLS-1$ //$NON-NLS-2$
			fQuit = true;
			return;
		}
		IRegion varRegion = null;
		for (EObject model : analyser.getRoot().eResource().getContents()) {
			varRegion = getRegionFromElement(model);
			if (varRegion == null)
				return;
			if (oclIsKindOf(model, "OclModel")) { //$NON-NLS-1$
				String subName = (String)eGet(model, "name"); //$NON-NLS-1$
				if (subName.equals(name)) {
					fResult.add(new OccurrenceLocation(varRegion.getOffset(), varRegion.getLength(),
							F_EXCEPTION_DECLARATION, "Occurrence of model '" + name + "'")); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
		fDescription = "Occurrence of model '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_EXCEPTION_DECLARATION;
	}

	/**
	 * The search for an element of type enumeration literal expression
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void enumLiteralExpSearch(EObject element) throws BadLocationException {
		String name = (String)eGet(element, "name"); //$NON-NLS-1$
		this.browseModel(analyser.getRoot(), name, "name", "", "EnumLiteralExp", "literal"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		fDescription = "Occurrence of literal '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_EXCEPTION_DECLARATION;
	}

	/**
	 * The search for an element of type operation (or helper with parameters) declaration
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void operationSearch(EObject element) throws BadLocationException {
		String name = (String)eGet(element, "name"); //$NON-NLS-1$
		this.browseModel(analyser.getRoot(), name, "operationName", "Operation", "OperationCallExp", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"operation"); //$NON-NLS-1$
		fDescription = "Declaration of operation '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_WRITE_OCCURRENCE;
	}

	/**
	 * The search for an element of type attribute (or helper attribute) declaration
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void attributeSearch(EObject element) throws BadLocationException {
		String name = (String)eGet(element, "name"); //$NON-NLS-1$
		this.browseModel(analyser.getRoot(), name, "name", "Attribute", "NavigationOrAttributeCallExp", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"attribute"); //$NON-NLS-1$
		fDescription = "Declaration of attribute '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_WRITE_OCCURRENCE;
	}

	/**
	 * The search for an element of type iterator expression
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void iteratorExpSearch(EObject element) throws BadLocationException {
		String name = (String)eGet(element, "name"); //$NON-NLS-1$
		this.browseModel(analyser.getRoot(), name, "name", "", "IteratorExp", "iterator"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		fDescription = "Occurrence of iterator '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_EXCEPTION_DECLARATION;
	}

	/**
	 * The search for an element of type iterate expression
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void iterateExpSearch(EObject element) throws BadLocationException {
		this.browseModel(analyser.getRoot(), "iterate", "name", "", "IterateExp", "iterator"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		fDescription = "Occurrence of iterator 'iterate'"; //$NON-NLS-1$
		fFlag = F_EXCEPTION_DECLARATION;
	}

	/**
	 * The search for an element of type query declaration
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void querySearch(EObject element) throws BadLocationException {
		// TODO search for the query occurrences. For now, the name of the query cannot be distinguished from
		// the 'query' keyword
		fQuit = true;
		return;
		//		String name = (String)eGet(element, "name"); //$NON-NLS-1$
		//		if (name.equals("query")) { //$NON-NLS-1$
		// fQuit = true;
		// return;
		// }
		//		this.browseModel(analyser.getRoot(), name, "name", "Query", "Query", "query"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		//		fDescription = "Declaration of query " + name; //$NON-NLS-1$
		// fFlag = F_WRITE_OCCURRENCE;
	}

	/**
	 * The search for an element of type ocl type
	 * 
	 * @param element
	 *            the selected element
	 * @throws BadLocationException
	 */
	private void oclTypeSearch(EObject element) throws BadLocationException {
		String name = analyser.getHelper().getText(element, 0);
		this.browseModelForType(analyser.getRoot(), name);
		fDescription = "Occurrence of type '" + name + "'"; //$NON-NLS-1$ //$NON-NLS-2$
		fFlag = F_EXCEPTION_DECLARATION;
	}

	public int getSearchKind() {
		return 0;
	}

	public String getID() {
		return null;
	}

}
