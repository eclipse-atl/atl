/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text;

import java.util.Map;
import java.util.Vector;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlAutoIndentStrategy;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCodeScanner;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCompletionProcessor;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlStringAutoIndentStrategy;
import org.eclipse.m2m.atl.adt.ui.text.hover.AtlTextHover;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * This class bundles the whole configuration space of a source viewer. Instances of this class are passed to
 * the configure method of ISourceViewer.
 */
public class AtlSourceViewerConfiguration extends TextSourceViewerConfiguration {

	private IContentAssistProcessor fProcessor;

	/**
	 * <code>fTextEditor</code> is the source viewer editor for this configurator.
	 */
	private ITextEditor fTextEditor;

	/**
	 * <code>fTextTools</code> represents the tools for the source.
	 */
	private AtlTextTools fTextTools;

	/**
	 * Creates a new instance of the configurator.
	 * 
	 * @param editor
	 *            the editor in which the configured viewer(s) will reside
	 */
	public AtlSourceViewerConfiguration(AtlTextTools tools, ITextEditor editor) {
		fTextTools = tools;
		fTextEditor = editor;
		fProcessor = new AtlCompletionProcessor(getEditor());
		fPreferenceStore = tools.getPreferenceStore();
	}

	/**
	 * Determines whether the preference change encoded by the given event changes the behavior of one of its
	 * contained components.
	 * 
	 * @param event
	 *            the event to be investigated
	 * @return <code>true</code> if event causes a behavioral change
	 */
	public boolean affectsTextPresentation(PropertyChangeEvent event) {
		return getTextTools().getCodeScanner().affectsBehavior(event)
		// TODO Method may be updated later
		/*
		 * || fMultilineCommentScanner.affectsBehavior(event) ||
		 * fSinglelineCommentScanner.affectsBehavior(event) || fStringScanner.affectsBehavior(event) ||
		 * fJavaDocScanner.affectsBehavior(event);
		 */
		;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getAutoEditStrategies(org.eclipse.jface.text.source.ISourceViewer,
	 *      java.lang.String)
	 */
	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
		if (IAtlPartitions.STRING.equals(contentType)) {
			return new IAutoEditStrategy[] {new AtlStringAutoIndentStrategy(
					getConfiguredDocumentPartitioning(sourceViewer)),};
		} else {
			return new IAutoEditStrategy[] {new AtlAutoIndentStrategy(
					getConfiguredDocumentPartitioning(sourceViewer)),};
		}
	}

	/**
	 * Gets the color manager stored in the text tools.
	 * 
	 * @return the color manager
	 */
	public AtlColorManager getColorManager() {
		return getTextTools().getColorManager();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getContentAssistant(org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		IPreferenceStore store = AtlUIPlugin.getDefault().getPreferenceStore();
		// AtlColorManager manager = AtlUIPlugin.getDefault().getTextTools().getColorManager();

		ContentAssistant assistant = new ContentAssistant();
		assistant.setContentAssistProcessor(fProcessor, IDocument.DEFAULT_CONTENT_TYPE);
		// Register the same processor for strings and single line comments to get code completion at the
		// start of those partitions.
		assistant.setContentAssistProcessor(fProcessor, IAtlPartitions.STRING);
		assistant.setContentAssistProcessor(fProcessor, IAtlPartitions.CHARACTER);
		assistant.setContentAssistProcessor(fProcessor, IAtlPartitions.SINGLE_LINE_COMMENT);
		assistant.setContentAssistProcessor(fProcessor, IAtlPartitions.DOC);

		AtlContentAssistPreference.configure(assistant, store);
		assistant.setContextInformationPopupOrientation(ContentAssistant.CONTEXT_INFO_ABOVE);
		assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
		assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));
		//assistant.enableAutoInsert(true);
		//assistant.enableAutoActivation(true);
		//assistant.setAutoActivationDelay(1);
		assistant.setRepeatedInvocationMode(true);
		assistant.setStatusLineVisible(true);
		//assistant.setShowEmptyList(true);

		assistant.addCompletionListener((AtlCompletionProcessor)fProcessor);
		return assistant;
	}

	public IContentAssistProcessor getCompletionProcessor() {
		return fProcessor;
	}

	/**
	 * Returns the editor in which the configured viewer(s) will reside.
	 * 
	 * @return the enclosing editor
	 */
	protected ITextEditor getEditor() {
		return fTextEditor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.TextSourceViewerConfiguration#getIndentPrefixes(org.eclipse.jface.text.source.ISourceViewer,
	 *      java.lang.String)
	 */
	@Override
	public String[] getIndentPrefixes(ISourceViewer sourceViewer, String contentType) {
		Vector<String> vector = new Vector<String>();

		// prefix[0] is either '\t' or ' ' x tabWidth, depending on useSpaces

		int tabWidth = getPreferenceStore().getInt(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH);
		boolean useSpaces = getPreferenceStore().getBoolean(AtlPreferenceConstants.TYPING_SPACES_FOR_TABS);

		for (int i = 0; i <= tabWidth; i++) {
			StringBuffer prefix = new StringBuffer();

			if (useSpaces) {
				for (int j = 0; j + i < tabWidth; j++)
					prefix.append(' ');

				if (i != 0)
					prefix.append('\t');
			} else {
				for (int j = 0; j < i; j++)
					prefix.append(' ');

				if (i != tabWidth)
					prefix.append('\t');
			}

			vector.add(prefix.toString());
		}

		vector.add(""); //$NON-NLS-1$
		return vector.toArray(new String[vector.size()]);
	}

	/**
	 * Gets the preference fPreferenceeStore stored in the text tools.
	 * 
	 * @return the preference fPreferenceeStore
	 */
	public IPreferenceStore getPreferenceStore() {
		return getTextTools().getPreferenceStore();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getPresentationReconciler(org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getTextTools().getCodeScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		/*
		 * dr= new DefaultDamagerRepairer(getJavaDocScanner()); reconciler.setDamager(dr,
		 * IJavaPartitions.JAVA_DOC); reconciler.setRepairer(dr, IJavaPartitions.JAVA_DOC); dr= new
		 * DefaultDamagerRepairer(getMultilineCommentScanner()); reconciler.setDamager(dr,
		 * IJavaPartitions.JAVA_MULTI_LINE_COMMENT); reconciler.setRepairer(dr,
		 * IJavaPartitions.JAVA_MULTI_LINE_COMMENT); dr= new
		 * DefaultDamagerRepairer(getSinglelineCommentScanner()); reconciler.setDamager(dr,
		 * IJavaPartitions.JAVA_SINGLE_LINE_COMMENT); reconciler.setRepairer(dr,
		 * IJavaPartitions.JAVA_SINGLE_LINE_COMMENT); dr= new DefaultDamagerRepairer(getStringScanner());
		 * reconciler.setDamager(dr, IJavaPartitions.JAVA_STRING); reconciler.setRepairer(dr,
		 * IJavaPartitions.JAVA_STRING); dr= new DefaultDamagerRepairer(getStringScanner());
		 * reconciler.setDamager(dr, IJavaPartitions.JAVA_CHARACTER); reconciler.setRepairer(dr,
		 * IJavaPartitions.JAVA_CHARACTER);
		 */
		return reconciler;
	}

	/**
	 * Gets the text tools associated to this configurator.
	 * 
	 * @return the text tools
	 */
	public AtlTextTools getTextTools() {
		return fTextTools;
	}

	/**
	 * Adapts the behavior of the contained components to the change encoded in the given event.
	 * 
	 * @param event
	 *            the event to which to adapt
	 */
	public void handlePropertyChangeEvent(PropertyChangeEvent event) {
		if (getTextTools().getCodeScanner().affectsBehavior(event))
			getTextTools().getCodeScanner().adaptToPreferenceChange(event);
		// TODO Method may be updated later
		/*
		 * if(fMultilineCommentScanner.affectsBehavior(event))
		 * fMultilineCommentScanner.adaptToPreferenceChange(event);
		 * if(fSinglelineCommentScanner.affectsBehavior(event))
		 * fSinglelineCommentScanner.adaptToPreferenceChange(event); if(fStringScanner.affectsBehavior(event))
		 * fStringScanner.adaptToPreferenceChange(event); if(fJavaDocScanner.affectsBehavior(event))
		 * fJavaDocScanner.adaptToPreferenceChange(event);
		 */
	}

	/**
	 * Initializes the scanners.
	 */
	private void initializeScanners() {
		getTextTools().setCodeScanner(new AtlCodeScanner(getTextTools()));
		/*
		 * fMultilineCommentScanner= new JavaCommentScanner(getColorManager(), getNewPreferenceStore(),
		 * IJavaColorConstants.JAVA_MULTI_LINE_COMMENT); fSinglelineCommentScanner= new
		 * JavaCommentScanner(getColorManager(), getNewPreferenceStore(),
		 * IJavaColorConstants.JAVA_SINGLE_LINE_COMMENT); fStringScanner= new
		 * SingleTokenJavaScanner(getColorManager(), getNewPreferenceStore(),
		 * IJavaColorConstants.JAVA_STRING); fJavaDocScanner= new JavaDocScanner(getColorManager(),
		 * getNewPreferenceStore());
		 */
	}

	/**
	 * Sets the preference fPreferenceeStore used by this configuration to initialize the individual bits and
	 * pieces to the given preference fPreferenceeStore.
	 * 
	 * @param preferenceStore
	 *            the preference fPreferenceeStore to initialize this configuration
	 */
	public void setNewPreferenceStore(IPreferenceStore preferenceStore) {
		getTextTools().setNewPreferenceStore(preferenceStore);
		initializeScanners();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.TextSourceViewerConfiguration#getAnnotationHover(org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return new AtlAnnotationHover();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getReconciler(org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		return new MonoReconciler(new AtlReconcilingStrategy((AtlEditor)fTextEditor), false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.TextSourceViewerConfiguration#getHyperlinkDetectorTargets(org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	protected Map getHyperlinkDetectorTargets(ISourceViewer sourceViewer) {
		Map targets = super.getHyperlinkDetectorTargets(sourceViewer);
		targets.put("org.eclipse.m2m.atl.adt.editor.AtlEditorSource", fTextEditor); //$NON-NLS-1$
		return targets;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getDefaultPrefixes(org.eclipse.jface.text.source.ISourceViewer,
	 *      java.lang.String)
	 */
	@Override
	public String[] getDefaultPrefixes(ISourceViewer sourceViewer, String contentType) {
		return new String[] {"--", ""}; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.TextSourceViewerConfiguration#getTextHover(org.eclipse.jface.text.source.ISourceViewer,
	 *      java.lang.String)
	 */
	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		return new AtlTextHover((AtlEditor)fTextEditor);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.SourceViewerConfiguration#getDoubleClickStrategy(org.eclipse.jface.text.source.ISourceViewer,
	 *      java.lang.String)
	 */
	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, String contentType) {
		return new AtlTextDoubleClickStrategy();
	}

}
