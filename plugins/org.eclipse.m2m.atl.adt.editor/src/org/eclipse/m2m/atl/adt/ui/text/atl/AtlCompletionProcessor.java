/*******************************************************************************
 * Copyright (c) 2007, 2009 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *     INRIA - additionalProposalInfo
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.editor.Messages;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.AtlTypesProcessor;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.Feature;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.ModelElementType;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.Operation;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

/**
 * The completion processor, provides content assist.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class AtlCompletionProcessor extends TemplateCompletionProcessor implements IContentAssistProcessor {

	private static final String[] PREFIX_TEMPLATES_NAMES = new String[] {
			"using", "do", "collect", "select", "reject",}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	private static final String URI_TAG_REGEX = "^\\p{Space}*--\\p{Space}*@" + AtlSourceManager.URI_TAG + ".*"; //$NON-NLS-1$ //$NON-NLS-2$

	private static final String PATH_TAG_REGEX = "^\\p{Space}*--\\p{Space}*@" + AtlSourceManager.PATH_TAG + ".*"; //$NON-NLS-1$ //$NON-NLS-2$

	private static final String COMPILER_TAG_REGEX = "^\\p{Space}*--\\p{Space}*@" + AtlSourceManager.COMPILER_TAG + ".*"; //$NON-NLS-1$ //$NON-NLS-2$

	private AtlCompletionProposalComparator fComparator;

	private AtlParameterListValidator fValidator;

	/** The editor. */
	private AtlEditor fEditor;

	private char[] fProposalAutoActivationSet = new char[] {' '};

	private IATLCompletionRecorder recorder;

	private AtlTypesProcessor typeProcessor;

	private ITextViewer viewer;

	private IDocument document;

	private AtlSourceManager manager;

	private String atlContext;

	/**
	 * Constructor.
	 * 
	 * @param editor
	 *            the editor part
	 */
	public AtlCompletionProcessor(IEditorPart editor) {
		fEditor = (AtlEditor)editor;
		fComparator = new AtlCompletionProposalComparator();
		typeProcessor = new AtlTypesProcessor();
	}

	/**
	 * Creates a new completion processor only based on an {@link IDocument}.
	 * 
	 * @param document
	 *            the document
	 */
	public AtlCompletionProcessor(IDocument document) {
		manager = new AtlSourceManager();
		manager.updateDataSource(document.get());
		fComparator = new AtlCompletionProposalComparator();
		typeProcessor = new AtlTypesProcessor();
	}

	/**
	 * Returns the source manager, which contains the main ATL file model.
	 * 
	 * @return the source manager
	 */
	public AtlSourceManager getSourceManager() {
		if (manager == null) {
			if (fEditor != null) {
				manager = fEditor.getSourceManager();
			}
		}
		return manager;
	}

	/**
	 * This interface is a non-regression utility.
	 */
	public interface IATLCompletionRecorder {
		/**
		 * Records the proposals computed by the completion processor at the given offset.
		 * 
		 * @param offset
		 *            the offset
		 * @param line
		 *            the current line
		 * @param proposals
		 *            the proposals
		 */
		void record(int offset, String line, ICompletionProposal[] proposals);
	}

	public void setRecorder(IATLCompletionRecorder recorder) {
		this.recorder = recorder;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer,
	 *      int)
	 */
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer refViewer, int documentOffset) {
		ITextSelection selection = (ITextSelection)refViewer.getSelectionProvider().getSelection();
		int offset = selection.getOffset() + selection.getLength();
		try {
			return computeCompletionProposals(refViewer, refViewer.getDocument(), offset);
		} catch (BadLocationException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			return null;
		}
	}

	/**
	 * Computes the ATL completion proposals from a viewer or a document.
	 * 
	 * @param viewer
	 *            the current viewer
	 * @param document
	 *            the document
	 * @param offset
	 *            the offset
	 * @return the proposals
	 * @throws BadLocationException
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, IDocument document, int offset)
			throws BadLocationException {
		this.viewer = viewer;
		this.document = document;
		String prefix = extractPrefix(document, offset);
		AtlCompletionDataSource datasource = new AtlCompletionDataSource(getSourceManager());

		AtlModelAnalyser currentAnalyser = null;
		// if (fEditor.isDirty()) {
		currentAnalyser = new AtlCompletionHelper(document.get()).computeModelAnalyser(offset, prefix,
				datasource.getATLFileContext());
		// } else {
		// currentAnalyser = fEditor.getModelAnalyser();
		// }
		IFileEditorInput editorInput = (IFileEditorInput)fEditor.getEditorInput();
		typeProcessor.update(editorInput.getFile(), currentAnalyser, manager);
		List<ICompletionProposal> listProposals = new ArrayList<ICompletionProposal>();
		String line = getCurrentLine(offset);

		atlContext = currentAnalyser.getContext(offset);

		if (AtlContextType.ATL_CONTEXT_ID.equals(atlContext)) {
			listProposals.addAll(getTagProposals(offset, line, prefix, datasource));
		} else {
			if (line.indexOf("--") == -1) { //$NON-NLS-1$
				listProposals.addAll(getAtlModelProposals(prefix, offset, datasource, currentAnalyser));
			}
		}
		if (line.indexOf("--") == -1) { //$NON-NLS-1$
			listProposals.addAll(getInstalledTemplates(prefix, offset));
		}

		ICompletionProposal[] proposals = listProposals
				.toArray(new ICompletionProposal[listProposals.size()]);

		if (recorder != null) {
			recorder.record(offset, line, proposals);
		}

		return proposals;
	}

	/**
	 * Compute the whole line of the current offset.
	 * 
	 * @param offset
	 *            the current offset
	 * @return the line containing the offset, ended with the offset
	 * @throws BadLocationException
	 */
	public String getCurrentLine(int offset) throws BadLocationException {
		if (offset >= 0) {
			int lineNumber = document.getLineOfOffset(offset);
			int lineOffset = document.getLineOffset(lineNumber);
			return document.get(lineOffset, offset - lineOffset);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer,
	 *      int)
	 */
	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 */
	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		return fProposalAutoActivationSet;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
	 */
	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
	 */
	@Override
	public IContextInformationValidator getContextInformationValidator() {
		if (fValidator == null) {
			fValidator = new AtlParameterListValidator();
		}
		return fValidator;
	}

	/**
	 * Reorder proposals.
	 * 
	 * @param order
	 *            the order to set.
	 */
	public void orderProposalsAlphabetically(boolean order) {
		fComparator.setOrderAlphabetically(order);
	}

	/**
	 * Tells this processor to restrict is proposals to those starting with matching cases.
	 * 
	 * @param restrict
	 *            <code>true</code> if proposals should be restricted
	 */
	public void restrictProposalsToMatchingCases(boolean restrict) {
	}

	/**
	 * Tells this processor to restrict its proposal to those element visible in the actual invocation
	 * context.
	 * 
	 * @param restrict
	 *            <code>true</code> if proposals should be restricted
	 */
	public void restrictProposalsToVisibility(boolean restrict) {
	}

	/**
	 * Sets this processor's set of characters triggering the activation of the completion proposal
	 * computation.
	 * 
	 * @param activationSet
	 *            the activation set
	 */
	public void setCompletionProposalAutoActivationCharacters(char[] activationSet) {
		fProposalAutoActivationSet = activationSet;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
	 */
	@Override
	public String getErrorMessage() {
		return "AtlEditor.codeassist.noCompletions"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor#getTemplates(java.lang.String)
	 */
	@Override
	protected Template[] getTemplates(String contextTypeId) {
		return AtlEditorUI.getDefault().getTemplateStore().getTemplates();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor#getContextType(org.eclipse.jface.text.ITextViewer,
	 *      org.eclipse.jface.text.IRegion)
	 */
	@Override
	protected TemplateContextType getContextType(ITextViewer viewer, IRegion region) {
		return AtlEditorUI.getDefault().getContextTypeRegistry().getContextType(atlContext);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor#getImage(org.eclipse.jface.text.templates.Template)
	 */
	@Override
	protected Image getImage(Template template) {
		return AtlEditorUI.getDefault().getTemplateImage(template.getName());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor#extractPrefix(org.eclipse.jface.text.ITextViewer,
	 *      int)
	 */
	@Override
	protected String extractPrefix(ITextViewer viewer, int offset) {
		return extractPrefix(viewer.getDocument(), offset);
	}

	/**
	 * Extracts the prefix at the given offset in the given document.
	 * 
	 * @param document
	 *            the document
	 * @param offset
	 *            the given offset
	 * @return the prefix
	 */
	public static String extractPrefix(IDocument document, int offset) {
		int i = offset;
		if (document != null) {
			if (i > document.getLength()) {
				return ""; //$NON-NLS-1$
			}
			try {
				while (i > 0) {
					char ch = document.getChar(i - 1);
					if (!AtlCompletionHelper.isAtlIdentifierPart(ch)) {
						break;
					}
					i--;
				}
				return document.get(i, offset - i);
			} catch (BadLocationException e) {
				return ""; //$NON-NLS-1$
			}
		}
		return ""; //$NON-NLS-1$
	}

	private Collection<ICompletionProposal> getAtlModelProposals(String prefix, int offset,
			AtlCompletionDataSource datasource, AtlModelAnalyser currentAnalyser) throws BadLocationException {

		List<ICompletionProposal> res = new ArrayList<ICompletionProposal>();
		EObject locatedElement = currentAnalyser.getLocatedElement(offset);
		if (locatedElement != null) {

			EObject container = currentAnalyser.getContainer(locatedElement);
			if (container != null) {

				if (AtlTypesProcessor.oclIsKindOf(locatedElement, "OclModel") || //$NON-NLS-1$
						AtlTypesProcessor.oclIsKindOf(locatedElement, "OclModelElement") //$NON-NLS-1$
						|| AtlTypesProcessor.oclIsKindOf(locatedElement, "OclFeatureDefinition") //$NON-NLS-1$
						|| AtlTypesProcessor.oclIsKindOf(locatedElement, "OclType")) { //$NON-NLS-1$

					/*
					 * Classifiers proposals.
					 */

					if (atlContext.equals(AtlContextType.RULE_CONTEXT_ID)) {
						if (AtlTypesProcessor.oclIsKindOf(container, "InPatternElement") || AtlTypesProcessor.oclIsKindOf(container, "InPattern")) { //$NON-NLS-1$ //$NON-NLS-2$
							res.addAll(createTypeProposals(prefix, offset, datasource
									.getClassifiers(AtlSourceManager.FILTER_INPUT_METAMODELS)));
						} else if (AtlTypesProcessor.oclIsKindOf(container, "OutPatternElement")) { //$NON-NLS-1$
							res.addAll(createTypeProposals(prefix, offset, datasource
									.getClassifiers(AtlSourceManager.FILTER_OUTPUT_METAMODELS)));
						} else {
							res.addAll(createTypeProposals(prefix, offset, datasource
									.getClassifiers(AtlSourceManager.FILTER_ALL_METAMODELS)));
							res
									.addAll(createTypeProposals(prefix, offset, datasource
											.getAtlPrimitiveTypes()));
							res.addAll(createComplexTypeProposals(prefix, offset, currentAnalyser));
						}
					} else if (atlContext.equals(AtlContextType.HELPER_CONTEXT_ID)) {
						// could be restricted to input meta elements
						res.addAll(createTypeProposals(prefix, offset, datasource
								.getClassifiers(AtlSourceManager.FILTER_ALL_METAMODELS)));
						res.addAll(createTypeProposals(prefix, offset, datasource.getAtlPrimitiveTypes()));

						if (!(AtlTypesProcessor.oclIsKindOf(container, "OclContextDefinition") || //$NON-NLS-1$
						AtlTypesProcessor.oclIsKindOf(container, "OclFeatureDefinition"))) { //$NON-NLS-1$
							res.addAll(createComplexTypeProposals(prefix, offset, currentAnalyser));
						}
					} else if (atlContext.equals(AtlContextType.QUERY_CONTEXT_ID)) {
						// could be restricted to input meta elements
						res.addAll(createTypeProposals(prefix, offset, datasource
								.getClassifiers(AtlSourceManager.FILTER_ALL_METAMODELS)));
						res.addAll(createTypeProposals(prefix, offset, datasource.getAtlPrimitiveTypes()));
					}
				} else if (AtlTypesProcessor.oclIsKindOf(locatedElement, "OutPattern")) { //$NON-NLS-1$

					/*
					 * Bindings proposals.
					 */

					if (currentAnalyser.getLostTypesNames().contains("Binding")) { //$NON-NLS-1$
						EObject simpleOutPatternElement = currentAnalyser
								.getLastLostElementByType("SimpleOutPatternElement"); //$NON-NLS-1$
						if (simpleOutPatternElement != null) {
							EObject oclModelElement = (EObject)AtlTypesProcessor.eGet(
									simpleOutPatternElement, "type"); //$NON-NLS-1$
							if (oclModelElement != null) {
								OclAnyType type = OclAnyType.create(getSourceManager(), oclModelElement);
								res.addAll(createFeatureProposals(prefix, offset, type.getFeatures()));
							}
						} else {
							// TODO manage distinct...foreach
						}
					} else {

						String templateName = Messages
								.getString("AtlCompletionProcessor.OUTPUT_PATTERN_NAME"); //$NON-NLS-1$
						String pattern = "${variable} : ${type} (\n\t\t${cursor}\t\n)"; //$NON-NLS-1$
						String description = Messages
								.getString("AtlCompletionProcessor.OUTPUT_PATTERN_DESCRIPTION"); //$NON-NLS-1$

						String information = "variable : type (\n\t\t\t\n)"; //$NON-NLS-1$
						Template template = new Template(templateName.toString(), description, atlContext,
								pattern.toString(), false);
						ICompletionProposal proposal = convertToProposal(template, prefix, offset,
								AtlUIPlugin.getDefault().getImage("$nl$/icons/templateprop_co.gif"), true, //$NON-NLS-1$
								information);
						if (proposal != null) {
							res.add(proposal);
						}
					}
				} else if (AtlTypesProcessor.oclIsKindOf(locatedElement, "VariableExp") //$NON-NLS-1$
						|| AtlTypesProcessor.oclIsKindOf(locatedElement, "VariableDeclaration")) { //$NON-NLS-1$

					/*
					 * Variables proposals.
					 */

					res.addAll(createVariablesProposals(prefix, offset, typeProcessor
							.getVariables(locatedElement)));

				} else if (AtlTypesProcessor.oclIsKindOf(locatedElement, "NavigationOrAttributeCallExp") //$NON-NLS-1$
						|| AtlTypesProcessor.oclIsKindOf(locatedElement, "CollectionOperationCallExp")) { //$NON-NLS-1$

					/*
					 * Navigation proposals.
					 */

					EObject source = (EObject)AtlTypesProcessor.eGet(locatedElement, "source"); //$NON-NLS-1$
					if (source != null) {
						OclAnyType type = typeProcessor.getType(source);

						res.addAll(createFeatureProposals(prefix, offset, type.getFeatures()));
						res.addAll(createFeatureProposals(prefix, offset, typeProcessor.getUnit()
								.getAttributes(type)));
						res.addAll(createOperationProposals(prefix, offset, type, typeProcessor.getUnit()
								.getHelpers(type), currentAnalyser));
						res.addAll(createOperationProposals(prefix, offset, type, type.getOperations(),
								currentAnalyser));

					} else {
						// no source found
					}
				} else {
					// unrecognized located element
				}
			}
		} else {
			// no located element found
		}
		return res;
	}

	private Collection<ICompletionProposal> getInstalledTemplates(String prefix, int offset) {
		Region region = new Region(offset - prefix.length(), prefix.length());
		TemplateContext context = new DocumentTemplateContext(getContextType(viewer, region), document,
				region.getOffset(), region.getLength());
		if (context == null)
			return Collections.emptyList();

		if (viewer != null) {
			ITextSelection selection = (ITextSelection)viewer.getSelectionProvider().getSelection();
			context.setVariable("selection", selection.getText()); // name of the selection variables {line, word}_selection //$NON-NLS-1$
		}
		Template[] templates = getTemplates(context.getContextType().getId());
		List<ICompletionProposal> matches = new ArrayList<ICompletionProposal>();
		for (int i = 0; i < templates.length; i++) {
			Template template = templates[i];
			try {
				context.getContextType().validate(template.getPattern());
			} catch (TemplateException e) {
				continue;
			}
			if (template.matches(prefix, context.getContextType().getId())) {
				if (!needPrefix(template)
						|| (needPrefix(template) && !"".equals(prefix) && template.getPattern().startsWith(//$NON-NLS-1$
								prefix))) {
					matches.add(createProposal(template, context, (IRegion)region, getRelevance(template,
							prefix)));
				}
			}
		}
		return matches;
	}

	private AtlTemplateProposal convertToProposal(Template template, String prefix, int offset, Image image,
			boolean needPrefix, String information) {
		Region region = new Region(offset - prefix.length(), prefix.length());
		TemplateContext context = new DocumentTemplateContext(getContextType(viewer, region), document,
				region.getOffset(), region.getLength());
		if (context == null)
			return null;

		if (viewer != null) {
			ITextSelection selection = (ITextSelection)viewer.getSelectionProvider().getSelection();
			context.setVariable("selection", selection.getText()); // name of the selection variables {line, word}_selection //$NON-NLS-1$
		}

		if (template.matches(prefix, context.getContextType().getId())) {
			if ("".equals(prefix) || !needPrefix || (needPrefix && template.getPattern().startsWith(//$NON-NLS-1$
					prefix))) {
				AtlTemplateProposal res = new AtlTemplateProposal(template, context, region, image,
						getRelevance(template, prefix), information);
				return res;
			}
		}
		return null;
	}

	/**
	 * Computes tag informations proposals.
	 * 
	 * @param offset
	 *            the current offset
	 * @param line
	 *            the last line
	 * @param prefix
	 *            the last prefix
	 * @return the proposals
	 */
	private Collection<ICompletionProposal> getTagProposals(int offset, String line, String prefix,
			AtlCompletionDataSource datasource) {
		if (line.matches(COMPILER_TAG_REGEX)) {

			/*
			 * Compiler names completion.
			 */

			List<String> compilersNames = new ArrayList<String>();
			IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(
					"org.eclipse.m2m.atl.engine.atlcompiler").getExtensions(); //$NON-NLS-1$
			for (int i = 0; i < extensions.length; i++) {
				IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for (int j = 0; j < elements.length; j++) {
					compilersNames.add(elements[j].getAttribute("name")); //$NON-NLS-1$
				}
			}
			return createProposalsFromList(prefix, offset, compilersNames.toArray(), null);

		} else if (line.matches(URI_TAG_REGEX)) {

			/*
			 * URI tag completion.
			 */

			if (line.indexOf("=") > -1) { //$NON-NLS-1$

				// Metamodel uri

				if (line.split("=").length == 2) { //$NON-NLS-1$
					String uriPrefix = line.split("=")[1]; //$NON-NLS-1$
					return createProposalsFromList(uriPrefix, offset, AtlCompletionDataSource.getURIs(),
							AtlUIPlugin.getDefault().getImage("$nl$/icons/EPackage.gif")); //$NON-NLS-1$
				} else if (line.endsWith("=")) { //$NON-NLS-1$
					return createProposalsFromList("", offset, AtlCompletionDataSource.getURIs(), AtlUIPlugin //$NON-NLS-1$
							.getDefault().getImage("$nl$/icons/EPackage.gif")); //$NON-NLS-1$
				}
			} else {

				// Metamodel name

				return createProposalsFromList(prefix, offset, datasource.getMetamodels(), AtlUIPlugin
						.getDefault().getImage("$nl$/icons/oclModel.gif")); //$NON-NLS-1$
			}

		} else if (line.matches(PATH_TAG_REGEX)) {

			/*
			 * Path tag completion.
			 */

			if (line.indexOf("=") > -1) { //$NON-NLS-1$

				// Metamodel path

				if (line.split("=").length == 2) { //$NON-NLS-1$
					String uriPrefix = line.split("=")[1]; //$NON-NLS-1$
					return createProposalsFromList(uriPrefix, offset, AtlCompletionDataSource.getPaths(),
							AtlUIPlugin.getDefault().getImage("$nl$/icons/EcoreModelFile.gif")); //$NON-NLS-1$
				} else if (line.endsWith("=")) { //$NON-NLS-1$
					return createProposalsFromList("", offset, AtlCompletionDataSource.getPaths(), //$NON-NLS-1$
							AtlUIPlugin.getDefault().getImage("$nl$/icons/EcoreModelFile.gif")); //$NON-NLS-1$
				}
			} else {

				// Metamodel name

				return createProposalsFromList(prefix, offset, datasource.getMetamodels(), AtlUIPlugin
						.getDefault().getImage("$nl$/icons/oclModel.gif")); //$NON-NLS-1$
			}
		} else {

			/*
			 * Tags completion.
			 */

			String pathTemplate = "-- @" + AtlSourceManager.PATH_TAG; //$NON-NLS-1$
			String uriTemplate = "-- @" + AtlSourceManager.URI_TAG; //$NON-NLS-1$
			String libTemplate = "-- @" + AtlSourceManager.LIB_TAG; //$NON-NLS-1$
			String compilerTemplate = "-- @" + AtlSourceManager.COMPILER_TAG; //$NON-NLS-1$
			return createProposalsFromList(line, offset, new String[] {pathTemplate, uriTemplate,
					libTemplate, compilerTemplate,}, AtlUIPlugin.getDefault().getImage(
					"$nl$/icons/EAnnotation.gif")); //$NON-NLS-1$
		}
		return Collections.emptyList();
	}

	private boolean needPrefix(Template template) {
		boolean res = false;
		for (String name : PREFIX_TEMPLATES_NAMES) {
			res = res || name.equals(template.getName());
		}
		return res;
	}

	/**
	 * startsWithIgnoreCase method, i.e. equalsIgnoreCase and startsWith mix.
	 * 
	 * @param prefix
	 * @param replacementString
	 * @return <code>True</code> if the replacementString starts with the prefix, without checking the case,
	 *         <code>False</code> else.
	 */
	private static boolean startsWithIgnoreCase(String prefix, String replacementString) {
		if (replacementString.length() >= prefix.length()) {
			String tmp = replacementString.substring(0, prefix.length());
			return tmp.equalsIgnoreCase(prefix);
		}
		return false;
	}

	private static List<ICompletionProposal> createProposalsFromList(String prefix, int offset,
			Object[] proposals, Image image) {
		List<ICompletionProposal> res = new ArrayList<ICompletionProposal>();
		for (int i = 0; i < proposals.length; i++) {
			String replacementString = proposals[i].toString();
			if (startsWithIgnoreCase(prefix, replacementString) || replacementString.contains(prefix)) {
				AtlCompletionProposal proposal = new AtlCompletionProposal(replacementString, offset
						- prefix.length(), replacementString.length(), image, replacementString, 0, null);
				if (proposal != null) {
					res.add(proposal);
				}
			}
		}
		return res;
	}

	private List<ICompletionProposal> createTypeProposals(String prefix, int offset,
			Map<String, OclAnyType[]> types) {
		List<ICompletionProposal> res = new ArrayList<ICompletionProposal>();
		for (String metamodelName : types.keySet()) {
			OclAnyType[] metamodelTypes = types.get(metamodelName);
			for (OclAnyType oclAnyType : metamodelTypes) {
				AtlCompletionProposal proposal = createTypeProposal(prefix, offset, metamodelName, oclAnyType);
				if (proposal != null) {
					res.add(proposal);
				}
			}
		}
		return res;
	}

	private List<AtlCompletionProposal> createVariablesProposals(String prefix, int offset,
			Map<String, OclAnyType> variables) {
		List<AtlCompletionProposal> res = new ArrayList<AtlCompletionProposal>();
		for (Iterator<Entry<String, OclAnyType>> iterator = variables.entrySet().iterator(); iterator
				.hasNext();) {
			Entry<String, OclAnyType> entry = iterator.next();
			String replacementString = entry.getKey().toString();
			String displayString = replacementString + " : " + entry.getValue(); //$NON-NLS-1$
			if (startsWithIgnoreCase(prefix, replacementString) && !prefix.equals(replacementString)) {
				AtlCompletionProposal proposal = new AtlCompletionProposal(replacementString, offset
						- prefix.length(), replacementString.length(), AtlUIPlugin.getDefault().getImage(
						"$nl$/icons/localvariable_obj.gif"), displayString, 0, null); //$NON-NLS-1$
				res.add(proposal);
			}
		}
		Collections.sort(res);
		return res;
	}

	private List<AtlCompletionProposal> createFeatureProposals(String prefix, int offset,
			Collection<Feature> features) {
		List<AtlCompletionProposal> res = new ArrayList<AtlCompletionProposal>();
		if (features != null) {
			for (Feature feature : features) {
				AtlCompletionProposal proposal = createFeatureProposal(prefix, offset, feature);
				if (proposal != null) {
					res.add(proposal);
				}
			}
		}
		return res;
	}

	private AtlCompletionProposal createFeatureProposal(String prefix, int offset, Feature feature) {
		String replacementString = feature.getName();
		if (startsWithIgnoreCase(prefix, replacementString) && !prefix.equals(replacementString)) {
			String displayString = feature.getInformation();
			AtlCompletionProposal proposal = new AtlCompletionProposal(replacementString, offset
					- prefix.length(), replacementString.length(), AtlUIPlugin.getDefault().getImage(
					feature.getImagePath()), displayString.toString(), 0, feature.getDocumentation());
			return proposal;
		}
		return null;
	}

	private List<AtlTemplateProposal> createOperationProposals(String prefix, int offset, OclAnyType context,
			Collection<Operation> operations, AtlModelAnalyser analyser) {
		List<AtlTemplateProposal> res = new ArrayList<AtlTemplateProposal>();
		if (operations != null) {
			for (Operation operation : operations) {
				AtlTemplateProposal proposal = createOperationProposal(prefix, offset, context, operation,
						analyser);
				if (proposal != null) {
					res.add(proposal);
				}
			}
		}
		return res;
	}

	private AtlTemplateProposal createOperationProposal(String prefix, int offset, OclAnyType context,
			Operation operation, AtlModelAnalyser analyser) {
		StringBuffer pattern = new StringBuffer();
		pattern.append(operation.getName());
		pattern.append('(');
		for (Iterator<Entry<String, OclAnyType>> iterator = operation.getParameters().entrySet().iterator(); iterator
				.hasNext();) {
			Entry<String, OclAnyType> parameter = iterator.next();
			pattern.append("${" + parameter.getKey() + '}'); //$NON-NLS-1$
			if (iterator.hasNext()) {
				pattern.append(", "); //$NON-NLS-1$
			}
		}
		pattern.append(')');
		if (operation.getType(context) != null) {
			// nothing
		}
		// already done by Template description :
		// templateName.append(" - "); //$NON-NLS-1$
		// templateName.append(operation.getContextType());
		String description = ""; //$NON-NLS-1$
		if (operation.getContextType() != null) {
			description = operation.getContextType().toString();
		}
		Template template = new Template(operation.getInformation(context), description, atlContext, pattern
				.toString(), false);

		return convertToProposal(template, prefix, offset, AtlUIPlugin.getDefault().getImage(
				operation.getImagePath()), true, operation.getDocumentation(context));
	}

	private AtlCompletionProposal createTypeProposal(String prefix, int offset, String metamodelName,
			OclAnyType type) {
		if (type instanceof ModelElementType) {
			ModelElementType meType = (ModelElementType)type;
			String replacementString = metamodelName + "!" + meType.getOclType().getClassifier().getName(); //$NON-NLS-1$
			if (startsWithIgnoreCase(prefix, replacementString) && !prefix.equals(replacementString)) {
				Image image = AtlUIPlugin.getDefault().getImage("$nl$/icons/model_class.gif"); //$NON-NLS-1$
				return new AtlCompletionProposal(replacementString, offset - prefix.length(),
						replacementString.length(), image, replacementString, 0, meType.getInformation()
								.toString());
			}
		} else {
			String replacementString = type.toString();
			if (startsWithIgnoreCase(prefix, replacementString) && !prefix.equals(replacementString)) {
				return new AtlCompletionProposal(replacementString, offset - prefix.length(),
						replacementString.length(), null, replacementString, 0, ""); //$NON-NLS-1$
			}
		}
		return null;
	}

	private Collection<AtlTemplateProposal> createComplexTypeProposals(String prefix, int offset,
			AtlModelAnalyser analyser) {
		List<AtlTemplateProposal> res = new ArrayList<AtlTemplateProposal>();
		AtlTemplateProposal collectionProposal = createComplexTypeProposal(prefix, offset, analyser,
				"Collection", "OclAny"); //$NON-NLS-1$ //$NON-NLS-2$
		if (collectionProposal != null) {
			res.add(collectionProposal);
		}
		AtlTemplateProposal sequenceProposal = createComplexTypeProposal(prefix, offset, analyser,
				"Sequence", "OclAny"); //$NON-NLS-1$ //$NON-NLS-2$
		if (sequenceProposal != null) {
			res.add(sequenceProposal);
		}
		AtlTemplateProposal bagProposal = createComplexTypeProposal(prefix, offset, analyser, "Bag", "OclAny"); //$NON-NLS-1$ //$NON-NLS-2$
		if (bagProposal != null) {
			res.add(bagProposal);
		}
		AtlTemplateProposal setProposal = createComplexTypeProposal(prefix, offset, analyser, "Set", "OclAny"); //$NON-NLS-1$ //$NON-NLS-2$
		if (setProposal != null) {
			res.add(setProposal);
		}
		AtlTemplateProposal orderedSetProposal = createComplexTypeProposal(prefix, offset, analyser,
				"OrderedSet", "OclAny"); //$NON-NLS-1$ //$NON-NLS-2$
		if (orderedSetProposal != null) {
			res.add(orderedSetProposal);
		}
		// TODO Map type proposal
		// TODO Tuple type proposal
		return res;
	}

	private AtlTemplateProposal createComplexTypeProposal(String prefix, int offset,
			AtlModelAnalyser analyser, String typeName, String... parameters) {
		StringBuffer templateName = new StringBuffer();
		StringBuffer pattern = new StringBuffer();
		templateName.append(typeName);
		pattern.append(typeName);
		templateName.append('(');
		pattern.append('(');
		for (int i = 0; i < parameters.length; i++) {
			String parameter = parameters[i];
			templateName.append(parameter);
			pattern.append("${" + parameter + '}'); //$NON-NLS-1$
			if (i < parameters.length - 1) {
				templateName.append(", "); //$NON-NLS-1$
				pattern.append(", "); //$NON-NLS-1$
			}
		}

		templateName.append(')');
		pattern.append(')');

		Template template = new Template(templateName.toString(), typeName + " declaration", atlContext, //$NON-NLS-1$
				pattern.toString(), false);

		return convertToProposal(template, prefix, offset, null, true, null);
	}
}
