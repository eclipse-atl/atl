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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.ui.IEditorPart;

/**
 * The completion processor, provides content assist.
 *
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class AtlCompletionProcessor implements IContentAssistProcessor {

	/** the ATL code analyser */
	private AtlCompletionHelper fHelper;

	private AtlCompletionProposalComparator fComparator;

	private AtlParameterListValidator fValidator;

	/** the editor */
	private AtlEditor fEditor;

	/** the completion data source */
	private AtlCompletionDataSource fDatasource;

	private char[] fProposalAutoActivationSet = new char[]{' '};

	/**
	 * Constructor.
	 * @param editor
	 */
	public AtlCompletionProcessor(IEditorPart editor) {
		fEditor = (AtlEditor) editor;
		fDatasource = new AtlCompletionDataSource(fEditor);
		fComparator = new AtlCompletionProposalComparator();
		fHelper = new AtlCompletionHelper();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer,
	 *      int)
	 */
	public ICompletionProposal[] computeCompletionProposals(
			ITextViewer refViewer, int documentOffset) {	
		if (!fDatasource.initialized()) {
			fDatasource.updateDataSource();
		}
		try {
			List listProposals = new ArrayList();
			fHelper.setDocument(refViewer.getDocument());

			ITextSelection selection = (ITextSelection) refViewer.getSelectionProvider().getSelection();
			int offset = selection.getOffset() + selection.getLength();
			String prefix = fHelper.extractPrefix(offset);

			AtlModelAnalyser analyser = fHelper.computeContext(offset, prefix);

			listProposals.addAll(getProposalsFromAnalyser(analyser, prefix,
					offset));

			ICompletionProposal[] proposals = (ICompletionProposal[]) listProposals
			.toArray(new ICompletionProposal[listProposals.size()]);
			return proposals;

		} catch (BadLocationException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Determine proposals from a given analyser.
	 * 
	 * @param analyser the ATL model analyser
	 * @param prefix the completion prefix
	 * @param offset the completion offset
	 * @return the proposals
	 * @throws BadLocationException
	 */
	private List getProposalsFromAnalyser(AtlModelAnalyser analyser,
			String prefix, int offset) throws BadLocationException {
		String line = fHelper.getCurrentLine(offset);
		/*
		 * URIs completion 
		 */
		if (analyser.getContext() == AtlModelAnalyser.NULL_CONTEXT) {
			if (line.trim().startsWith("-- @"+AtlCompletionDataSource.URI_TAG)) { //$NON-NLS-1$
				if (prefix.contains("=")) { //$NON-NLS-1$
					if (prefix.split("=").length == 2) { //$NON-NLS-1$
						String uriPrefix = prefix.split("=")[1]; //$NON-NLS-1$
						return fDatasource.getURIProposals(uriPrefix, offset);
					} else if (prefix.endsWith("=")) { //$NON-NLS-1$
						return fDatasource.getURIProposals("", offset); //$NON-NLS-1$
					}
				}
			}
		} else {
			// no completion on comments
			if (!line.contains("--")) { //$NON-NLS-1$

				EObject locatedElement = analyser.getLocatedElement(offset
						- prefix.length());
				if (locatedElement != null) {

					switch (analyser.getContext()) {

					/*
					 * HELPER COMPLETION
					 */
					case AtlModelAnalyser.HELPER_CONTEXT :
						if (oclIsKindOf(locatedElement, "OclModel") || oclIsKindOf(locatedElement, "OclType")){ //$NON-NLS-1$ //$NON-NLS-2$
							return fDatasource.getHelperTypesProposals(prefix, offset);
						}
						break;

						/*
						 * INPUT PATTERN COMPLETION
						 */
					case AtlModelAnalyser.FROM_CONTEXT :
						if (oclIsKindOf(locatedElement, "OclModel") ||  //$NON-NLS-1$
								oclIsKindOf(locatedElement, "OclModelElement")) { //$NON-NLS-1$
							if (analyser.getLostType("InPattern") != null) { //$NON-NLS-1$
								return fDatasource.getMetaElementsProposals(prefix,offset,AtlCompletionDataSource.INPUT_METAMODELS);
							}
						}
						break;

						/*
						 * OUTPUT PATTERN COMPLETION
						 */
					case AtlModelAnalyser.TO_CONTEXT:
						if ((oclIsKindOf(locatedElement, "OclModel") || oclIsKindOf(locatedElement, "OclModelElement")) || //$NON-NLS-1$ //$NON-NLS-2$
								(oclIsKindOf(locatedElement,"SimpleOutPatternElement"))) { //$NON-NLS-1$
							return fDatasource.getMetaElementsProposals(prefix,offset,AtlCompletionDataSource.OUTPUT_METAMODELS);
						} 
						else if (oclIsKindOf(locatedElement, "OutPattern")) { //$NON-NLS-1$
							if (analyser.getLostType("Binding") != null) { //$NON-NLS-1$
								EObject simpleOutPatternElement = analyser.getLostType("SimpleOutPatternElement"); //$NON-NLS-1$
								EObject oclModelElement = (EObject) AtlCompletionDataSource.eGet(simpleOutPatternElement,"type"); //$NON-NLS-1$

								List existingBindings = new ArrayList();
								Collection bindings = (Collection) AtlCompletionDataSource.eGet(simpleOutPatternElement,"bindings"); //$NON-NLS-1$

								for (Iterator iterator = bindings.iterator(); iterator.hasNext();) {
									EObject binding = (EObject) iterator.next();
									String ref = AtlCompletionDataSource.eGet(binding,"propertyName").toString(); //$NON-NLS-1$
									existingBindings.add(ref);
								}

								if (oclModelElement != null) {
									return fDatasource.getMetaFeaturesProposals(existingBindings,oclModelElement,prefix, offset);
								}
							}
						}
						break;
					}
				} else {
					/*
					 * CODE templates
					 */

					List res = new ArrayList();
					String helperTemplate = "helper context CONTEXT_TYPE def : NAME : TYPE = "; //$NON-NLS-1$
					String ruleTemplate = "rule RULE_NAME {"; //$NON-NLS-1$
					String fromTemplate = "from VAR_NAME : MM!TYPE "; //$NON-NLS-1$
					String toTemplate = "to VAR_NAME : MM!TYPE ("; //$NON-NLS-1$
					String doTemplate = "do {"; //$NON-NLS-1$
					String usingTemplate = "using {"; //$NON-NLS-1$

					switch (analyser.getContext()) {
					case AtlModelAnalyser.RULE_CONTEXT :
						if (fromTemplate.startsWith(prefix)) {
							AtlCompletionProposal fromProposal = new AtlCompletionProposal(
									fromTemplate, offset - prefix.length(),
									fromTemplate.length(), AtlCompletionDataSource.getImage("inPattern.gif"), "from", 0); //$NON-NLS-1$ //$NON-NLS-2$
							fromProposal.setCursorPosition(fromTemplate.length() - 19);
							res.add(fromProposal);
						}
						break;

					case AtlModelAnalyser.FROM_CONTEXT :
						if (usingTemplate.startsWith(prefix))
							res.add(new AtlCompletionProposal(
									usingTemplate, offset - prefix.length(),
									usingTemplate.length(),AtlCompletionDataSource.getImage("using.gif") , "using", 0)); //$NON-NLS-1$ //$NON-NLS-2$

					case AtlModelAnalyser.USING_CONTEXT:	
						if (toTemplate.startsWith(prefix)) {
							AtlCompletionProposal toProposal = new AtlCompletionProposal(
									toTemplate, offset - prefix.length(),
									toTemplate.length(), AtlCompletionDataSource.getImage("outPattern.gif"), "to", 0); //$NON-NLS-1$ //$NON-NLS-2$
							toProposal.setCursorPosition(toTemplate.length() - 20);
							res.add(toProposal);
						}
						break;

					case AtlModelAnalyser.TO_CONTEXT:
						if (doTemplate.startsWith(prefix))
							res.add(new AtlCompletionProposal(
									doTemplate, offset - prefix.length(),
									doTemplate.length(),AtlCompletionDataSource.getImage("imperative.gif") , "do", 0)); //$NON-NLS-1$ //$NON-NLS-2$

					case AtlModelAnalyser.DO_CONTEXT:
					case AtlModelAnalyser.MODULE_CONTEXT:
						if (ruleTemplate.startsWith(prefix)) {
							AtlCompletionProposal ruleProposal = new AtlCompletionProposal(
									ruleTemplate, offset - prefix.length(),
									ruleTemplate.length(), AtlCompletionDataSource.getImage("matchedRule.gif"), "rule", 0); //$NON-NLS-1$ //$NON-NLS-2$
							ruleProposal.setCursorPosition(ruleTemplate.length() - 11);
							res.add(ruleProposal);
						}
						if (helperTemplate.startsWith(prefix)) {
							AtlCompletionProposal helperProposal = new AtlCompletionProposal(
									helperTemplate, offset - prefix.length(),
									helperTemplate.length(), AtlCompletionDataSource.getImage("helper.gif"), "helper", 0); //$NON-NLS-1$ //$NON-NLS-2$
							helperProposal.setCursorPosition(helperTemplate.length() - 33);
							res.add(helperProposal);
						}
						break;

					default:
						break;
					}
					return res;
				}
			}
		}
		return new ArrayList();
	}

	/**
	 * Equivalent of ASMOclAny oclIsKindOf method for EObjects.
	 * @param element
	 * @param testedElementName
	 * @return <code>True</code> element has testedElementName in its superTypes, <code>False</code> else.
	 */
	private static boolean oclIsKindOf(EObject element,
			String testedElementName) {
		if (element.eClass().getName().equals(testedElementName)) {
			return true;
		} else {
			List superTypList = element.eClass().getEAllSuperTypes();
			for (Iterator iterator = superTypList.iterator(); iterator.hasNext();) {
				EClassifier object = (EClassifier) iterator.next();
				if (object.getName().equals(testedElementName)) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer,
	 *      int)
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		return fProposalAutoActivationSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
	 */
	public IContextInformationValidator getContextInformationValidator() {
		if (fValidator == null)
			fValidator = new AtlParameterListValidator();
		return fValidator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
	 */
	public String getErrorMessage() {
		return "AtlEditor.codeassist.noCompletions"; //$NON-NLS-1$
	}

	public void orderProposalsAlphabetically(boolean order) {
		fComparator.setOrderAlphabetically(order);
	}

	/**
	 * Tells this processor to restrict is proposals to those starting with
	 * matching cases.
	 * 
	 * @param restrict
	 *            <code>true</code> if proposals should be restricted
	 */
	public void restrictProposalsToMatchingCases(boolean restrict) {
		// TODO not yet supported
	}

	/**
	 * Tells this processor to restrict its proposal to those element visible in
	 * the actual invocation context.
	 * 
	 * @param restrict
	 *            <code>true</code> if proposals should be restricted
	 */
	public void restrictProposalsToVisibility(boolean restrict) {
		// TODO not yet supported
	}

	public AtlCompletionDataSource getCompletionDatasource() {
		return fDatasource;
	}

	/**
	 * Sets this processor's set of characters triggering the activation of the
	 * completion proposal computation.
	 * 
	 * @param activationSet the activation set
	 */
	public void setCompletionProposalAutoActivationCharacters(char[] activationSet) {
		fProposalAutoActivationSet = activationSet;
	}


}
