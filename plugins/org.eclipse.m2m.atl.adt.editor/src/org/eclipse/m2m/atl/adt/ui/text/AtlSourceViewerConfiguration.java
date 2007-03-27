package org.eclipse.m2m.atl.adt.ui.text;

import java.util.Vector;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IAutoIndentStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlAutoIndentStrategy;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCodeScanner;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCompletionProcessor;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlStringAutoIndentStrategy;
import org.eclipse.pde.internal.ui.editor.text.AnnotationHover;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * This class bundles the whole configuration space of a source viewer. Instances of this class are
 * passed to the configure method of ISourceViewer.
 * 
 * @author C. MONTI for ATL Team
 */
public class AtlSourceViewerConfiguration extends SourceViewerConfiguration {
	
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
	 * @param editor the editor in which the configured viewer(s) will reside
	 */
	public AtlSourceViewerConfiguration(AtlTextTools tools, ITextEditor editor) {
		fTextTools = tools;
		fTextEditor = editor;
		fProcessor = new AtlCompletionProcessor(getEditor());
	}
	
	/**
	 * Determines whether the preference change encoded by the given event
	 * changes the behavior of one of its contained components.
	 * 
	 * @param event the event to be investigated
	 * @return <code>true</code> if event causes a behavioral change
	 */
	public boolean affectsTextPresentation(PropertyChangeEvent event) {
		return
		getTextTools().getCodeScanner().affectsBehavior(event)
		// TODO Method may be updated later
		/*
		 || fMultilineCommentScanner.affectsBehavior(event)
		 || fSinglelineCommentScanner.affectsBehavior(event)
		 || fStringScanner.affectsBehavior(event)
		 || fJavaDocScanner.affectsBehavior(event);
		 */
		;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getAutoIndentStrategy(org.eclipse.jface.text.source.ISourceViewer, java.lang.String)
	 */
	public IAutoIndentStrategy getAutoIndentStrategy(ISourceViewer sourceViewer, String contentType) {
		if(IAtlPartitions.STRING.equals(contentType)) {
			return new AtlStringAutoIndentStrategy(getConfiguredDocumentPartitioning(sourceViewer));
		} else {
			return new AtlAutoIndentStrategy(getConfiguredDocumentPartitioning(sourceViewer));
		}
	}
	
//	private Color getColor(IPreferenceStore store, String key, AtlColorManager manager) {
//		return manager.getColor(PreferenceConverter.getColor(store, key));
//	}
	
	/**
	 * Gets the color manager stored in the text tools.
	 * 
	 * @return the color manager
	 */
	public AtlColorManager getColorManager() {
		return getTextTools().getColorManager();
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getContentAssistant(org.eclipse.jface.text.source.ISourceViewer)
	 */
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		IPreferenceStore store = AtlUIPlugin.getDefault().getPreferenceStore();
//		AtlColorManager manager = AtlUIPlugin.getDefault().getTextTools().getColorManager();
		
		ContentAssistant assistant= new ContentAssistant();
		assistant.setContentAssistProcessor(fProcessor, IDocument.DEFAULT_CONTENT_TYPE);
		// Register the same processor for strings and single line comments to get code completion at the start of those partitions.
		assistant.setContentAssistProcessor(fProcessor, IAtlPartitions.STRING);
		assistant.setContentAssistProcessor(fProcessor, IAtlPartitions.CHARACTER);
		assistant.setContentAssistProcessor(fProcessor, IAtlPartitions.SINGLE_LINE_COMMENT);
		assistant.setContentAssistProcessor(fProcessor, IAtlPartitions.DOC);
		
		AtlContentAssistPreference.configure(assistant, store);
		assistant.setContextInformationPopupOrientation(ContentAssistant.CONTEXT_INFO_ABOVE);
		assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));
		
		return assistant;
	}
	
	/**
	 * Returns the editor in which the configured viewer(s) will reside.
	 *
	 * @return the enclosing editor
	 */
	protected ITextEditor getEditor() {
		return fTextEditor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getIndentPrefixes(org.eclipse.jface.text.source.ISourceViewer, java.lang.String)
	 */
	public String[] getIndentPrefixes(ISourceViewer sourceViewer, String contentType) {
		Vector vector= new Vector();
		
		// prefix[0] is either '\t' or ' ' x tabWidth, depending on useSpaces
		
		int tabWidth= getPreferenceStore().getInt(AtlPreferenceConstants.APPEARANCE_TAB_WIDTH);
		boolean useSpaces= getPreferenceStore().getBoolean(AtlPreferenceConstants.TYPING_SPACES_FOR_TABS);
		
		for (int i= 0; i <= tabWidth; i++) {
			StringBuffer prefix= new StringBuffer();
			
			if (useSpaces) {
				for (int j= 0; j + i < tabWidth; j++)
					prefix.append(' ');
				
				if (i != 0)
					prefix.append('\t');				
			} else {    
				for (int j= 0; j < i; j++)
					prefix.append(' ');
				
				if (i != tabWidth)
					prefix.append('\t');
			}
			
			vector.add(prefix.toString());
		}
		
		vector.add("");
		return (String[]) vector.toArray(new String[vector.size()]);
	}
	
	/**
	 * Gets the preference fPreferenceeStore stored in the text tools.
	 * 
	 * @return the preference fPreferenceeStore
	 */
	public IPreferenceStore getPreferenceStore() {
		return getTextTools().getPreferenceStore();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getPresentationReconciler(org.eclipse.jface.text.source.ISourceViewer)
	 */
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
		
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getTextTools().getCodeScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		/*
		 dr= new DefaultDamagerRepairer(getJavaDocScanner());
		 reconciler.setDamager(dr, IJavaPartitions.JAVA_DOC);
		 reconciler.setRepairer(dr, IJavaPartitions.JAVA_DOC);
		 
		 dr= new DefaultDamagerRepairer(getMultilineCommentScanner());		
		 reconciler.setDamager(dr, IJavaPartitions.JAVA_MULTI_LINE_COMMENT);
		 reconciler.setRepairer(dr, IJavaPartitions.JAVA_MULTI_LINE_COMMENT);
		 
		 dr= new DefaultDamagerRepairer(getSinglelineCommentScanner());		
		 reconciler.setDamager(dr, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);
		 reconciler.setRepairer(dr, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);
		 
		 dr= new DefaultDamagerRepairer(getStringScanner());
		 reconciler.setDamager(dr, IJavaPartitions.JAVA_STRING);
		 reconciler.setRepairer(dr, IJavaPartitions.JAVA_STRING);
		 
		 dr= new DefaultDamagerRepairer(getStringScanner());
		 reconciler.setDamager(dr, IJavaPartitions.JAVA_CHARACTER);
		 reconciler.setRepairer(dr, IJavaPartitions.JAVA_CHARACTER);
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
	 * Adapts the behavior of the contained components to the change
	 * encoded in the given event.
	 * 
	 * @param event the event to which to adapt
	 */
	public void handlePropertyChangeEvent(PropertyChangeEvent event) {
		if(getTextTools().getCodeScanner().affectsBehavior(event))
			getTextTools().getCodeScanner().adaptToPreferenceChange(event);
		// TODO Method may be updated later
		/*
		 if(fMultilineCommentScanner.affectsBehavior(event))
		 fMultilineCommentScanner.adaptToPreferenceChange(event);
		 if(fSinglelineCommentScanner.affectsBehavior(event))
		 fSinglelineCommentScanner.adaptToPreferenceChange(event);
		 if(fStringScanner.affectsBehavior(event))
		 fStringScanner.adaptToPreferenceChange(event);
		 if(fJavaDocScanner.affectsBehavior(event))
		 fJavaDocScanner.adaptToPreferenceChange(event);
		 */
	}
	
	/**
	 * Initializes the scanners.
	 */
	private void initializeScanners() {
		getTextTools().setCodeScanner(new AtlCodeScanner(getTextTools()));
		/*
		 fMultilineCommentScanner= new JavaCommentScanner(getColorManager(), getNewPreferenceStore(), IJavaColorConstants.JAVA_MULTI_LINE_COMMENT);
		 fSinglelineCommentScanner= new JavaCommentScanner(getColorManager(), getNewPreferenceStore(), IJavaColorConstants.JAVA_SINGLE_LINE_COMMENT);
		 fStringScanner= new SingleTokenJavaScanner(getColorManager(), getNewPreferenceStore(), IJavaColorConstants.JAVA_STRING);
		 fJavaDocScanner= new JavaDocScanner(getColorManager(), getNewPreferenceStore());
		 */
	}
	
	/**
	 * Sets the preference fPreferenceeStore used by this configuration to initialize
	 * the individual bits and pieces to the given preference fPreferenceeStore.
	 * 
	 * @param preferenceStore the preference fPreferenceeStore to initialize this configuration
	 */
	public void setNewPreferenceStore(IPreferenceStore preferenceStore) {
		getTextTools().setNewPreferenceStore(preferenceStore);
		initializeScanners();
	}

	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return new AnnotationHover();
	}

	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		return null;	//TODO
	}
	
}
