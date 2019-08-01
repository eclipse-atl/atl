/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.editor;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ILineTracker;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISelectionValidator;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.link.ILinkedModeListener;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedModeUI;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.jface.text.link.LinkedModeUI.ExitFlags;
import org.eclipse.jface.text.link.LinkedModeUI.IExitPolicy;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.actions.FormatCodeAction;
import org.eclipse.m2m.atl.adt.ui.actions.IAtlActionConstants;
import org.eclipse.m2m.atl.adt.ui.actions.IndentAction;
import org.eclipse.m2m.atl.adt.ui.actions.ToggleCommentAction;
import org.eclipse.m2m.atl.adt.ui.editor.IOccurrencesFinder.OccurrenceLocation;
import org.eclipse.m2m.atl.adt.ui.outline.AtlContentOutlinePage;
import org.eclipse.m2m.atl.adt.ui.outline.AtlEMFConstants;
import org.eclipse.m2m.atl.adt.ui.properties.AtlPropertySourceProvider;
import org.eclipse.m2m.atl.adt.ui.text.AtlContentAssistPreference;
import org.eclipse.m2m.atl.adt.ui.text.AtlPairMatcher;
import org.eclipse.m2m.atl.adt.ui.text.AtlSourceViewerConfiguration;
import org.eclipse.m2m.atl.adt.ui.text.IAtlPartitions;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCompletionDataSource;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCompletionHelper;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlModelAnalyser;
import org.eclipse.m2m.atl.adt.ui.text.atl.LastSaveComparator;
import org.eclipse.m2m.atl.adt.ui.text.atl.OpenDeclarationUtils;
import org.eclipse.m2m.atl.adt.ui.viewsupport.AtlEditorTickErrorUpdater;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.common.AtlNbCharFile;
import org.eclipse.m2m.atl.common.IAtlLexems;
import org.eclipse.m2m.atl.debug.core.AtlBreakpoint;
import org.eclipse.m2m.atl.debug.core.AtlDebugModelConstants;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.IEditorStatusLine;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.texteditor.link.EditorLinkedModeUI;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * The AtlEditor class is the main class that allows editing atl code. All editor's specifications are
 * declared here.
 */
public class AtlEditor extends TextEditor {

	private ProjectionSupport projectionSupport;

	/** The editor's bracket matcher. */
	protected AtlPairMatcher bracketMatcher = new AtlPairMatcher(IAtlLexems.BRACKETS);

	/** The editor selection changed listener. */
	private EditorSelectionChangedListener editorSelectionChangedListener;

	/** The bracket inserter. */
	private BracketInserter fBracketInserter = new BracketInserter();

	private TabConverter fTabConverter;

	private AtlSourceManager sourceManager;

	private AtlModelAnalyser analyser;

	private LastSaveComparator comparator;

	private class BracketInserter implements VerifyKeyListener, ILinkedModeListener {
		private final String category = toString();

		private Stack<BracketLevel> fBracketLevelStack = new Stack<BracketLevel>();

		private boolean fCloseBrackets = true;

		private boolean fCloseStrings = true;

		private IPositionUpdater fUpdater = new ExclusivePositionUpdater(category);

		private boolean hasCharacterToTheRight(IDocument document, int offset, char character) {
			try {
				int end = offset;
				IRegion endLine = document.getLineInformationOfOffset(end);
				int maxEnd = endLine.getOffset() + endLine.getLength();
				while (end != maxEnd && Character.isWhitespace(document.getChar(end)))
					++end;

				return end != maxEnd && document.getChar(end) == character;
			} catch (BadLocationException e) {
				// be conservative
				return true;
			}
		}

		private boolean hasIdentifierToTheLeft(IDocument document, int offset) {
			try {
				int start = offset;
				IRegion startLine = document.getLineInformationOfOffset(start);
				int minStart = startLine.getOffset();
				while (start != minStart && Character.isWhitespace(document.getChar(start - 1)))
					--start;

				return start != minStart && Character.isJavaIdentifierPart(document.getChar(start - 1));
			} catch (BadLocationException e) {
				return true;
			}
		}

		private boolean hasIdentifierToTheRight(IDocument document, int offset) {
			try {
				int end = offset;
				IRegion endLine = document.getLineInformationOfOffset(end);
				int maxEnd = endLine.getOffset() + endLine.getLength();
				while (end != maxEnd && Character.isWhitespace(document.getChar(end)))
					++end;

				return end != maxEnd && Character.isJavaIdentifierPart(document.getChar(end));
			} catch (BadLocationException e) {
				// be conservative
				return true;
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.text.link.ILinkedModeListener#left(org.eclipse.jface.text.link.LinkedModeModel,
		 *      int)
		 */
		public void left(LinkedModeModel environment, int flags) {

			final BracketLevel level = fBracketLevelStack.pop();

			if (flags != ILinkedModeListener.EXTERNAL_MODIFICATION) {
				return;
			}

			// remove brackets
			final ISourceViewer sourceViewer = getSourceViewer();
			final IDocument document = sourceViewer.getDocument();
			if (document instanceof IDocumentExtension) {
				IDocumentExtension extension = (IDocumentExtension)document;
				extension.registerPostNotificationReplace(null, new IDocumentExtension.IReplace() {

					public void perform(IDocument d, IDocumentListener owner) {
						if ((level.fFirstPosition.isDeleted || level.fFirstPosition.length == 0)
								&& !level.fSecondPosition.isDeleted
								&& level.fSecondPosition.offset == level.fFirstPosition.offset) {
							try {
								document.replace(level.fSecondPosition.offset, level.fSecondPosition.length,
										null);
							} catch (BadLocationException e) {
							}
						}

						if (fBracketLevelStack.size() == 0) {
							document.removePositionUpdater(fUpdater);
							try {
								document.removePositionCategory(category);
							} catch (BadPositionCategoryException e) {
							}
						}
					}

				});
			}

		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.text.link.ILinkedModeListener#resume(org.eclipse.jface.text.link.LinkedModeModel,
		 *      int)
		 */
		public void resume(LinkedModeModel environment, int flags) {
		}

		public void setCloseBracketsEnabled(boolean enabled) {
			fCloseBrackets = enabled;
		}

		public void setCloseStringsEnabled(boolean enabled) {
			fCloseStrings = enabled;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.text.link.ILinkedModeListener#suspend(org.eclipse.jface.text.link.LinkedModeModel)
		 */
		public void suspend(LinkedModeModel environment) {
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.swt.custom.VerifyKeyListener#verifyKey(org.eclipse.swt.events.VerifyEvent)
		 */
		public void verifyKey(VerifyEvent event) {
			// TODO when smart insert will be set, remove this
			if (!event.doit) { /* || getInsertMode() != SMART_INSERT */
				return;
			}

			final ISourceViewer sourceViewer = getSourceViewer();
			IDocument document = sourceViewer.getDocument();

			final Point selection = sourceViewer.getSelectedRange();
			final int offset = selection.x;
			final int length = selection.y;

			switch (event.character) {
				case '(':
					if (hasCharacterToTheRight(document, offset + length, '(')) {
						return;
					}
					// fall through

				case '[':
					if (!fCloseBrackets) {
						return;
					}
					if (hasIdentifierToTheRight(document, offset + length)) {
						return;
					}
					// fall through

				case '\'':
					if (event.character == '\'') {
						if (!fCloseStrings) {
							return;
						}
						if (hasIdentifierToTheLeft(document, offset)
								|| hasIdentifierToTheRight(document, offset + length)) {
							return;
						}
					}

					// fall through

				case '"':
					if (event.character == '"') {
						if (!fCloseStrings) {
							return;
						}
						if (hasIdentifierToTheLeft(document, offset)
								|| hasIdentifierToTheRight(document, offset + length)) {
							return;
						}
					}

					try {
						ITypedRegion partition = TextUtilities.getPartition(document,
								IAtlPartitions.PARTITIONING, offset, true);
						// if (! IDocument.DEFAULT_CONTENT_TYPE.equals(partition.getType()) &&
						// partition.getOffset() != offset)
						if (!IDocument.DEFAULT_CONTENT_TYPE.equals(partition.getType())) {
							return;
						}

						if (!validateEditorInputState()) {
							return;
						}

						final char character = event.character;
						final char closingCharacter = getPeerCharacter(character);
						final StringBuffer buffer = new StringBuffer();
						buffer.append(character);
						buffer.append(closingCharacter);

						document.replace(offset, length, buffer.toString());

						BracketLevel level = new BracketLevel();
						fBracketLevelStack.push(level);

						LinkedPositionGroup group = new LinkedPositionGroup();
						group.addPosition(new LinkedPosition(document, offset + 1, 0,
								LinkedPositionGroup.NO_STOP));

						LinkedModeModel model = new LinkedModeModel();
						model.addLinkingListener(this);
						model.addGroup(group);
						model.forceInstall();

						level.fOffset = offset;
						level.fLength = 2;

						// set up position tracking for our magic peers
						if (fBracketLevelStack.size() == 1) {
							document.addPositionCategory(category);
							document.addPositionUpdater(fUpdater);
						}
						level.fFirstPosition = new Position(offset, 1);
						level.fSecondPosition = new Position(offset + 1, 1);
						document.addPosition(category, level.fFirstPosition);
						document.addPosition(category, level.fSecondPosition);

						level.fUI = new EditorLinkedModeUI(model, sourceViewer);
						level.fUI.setSimpleMode(true);
						level.fUI.setExitPolicy(new ExitPolicy(closingCharacter,
								getEscapeCharacter(closingCharacter), fBracketLevelStack));
						level.fUI.setExitPosition(sourceViewer, offset + 2, 0, Integer.MAX_VALUE);
						level.fUI.setCyclingMode(LinkedModeUI.CYCLE_NEVER);
						level.fUI.enter();

						IRegion newSelection = level.fUI.getSelectedRegion();
						sourceViewer.setSelectedRange(newSelection.getOffset(), newSelection.getLength());

						event.doit = false;

					} catch (BadLocationException e) {
						ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
					} catch (BadPositionCategoryException e) {
						ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
					break;
			}
		}
	}

	protected static class BracketLevel {
		Position fFirstPosition;

		int fLength;

		int fOffset;

		Position fSecondPosition;

		LinkedModeUI fUI;
	}

	/**
	 * Updates the Java outline page selection and this editor's range indicator.
	 * 
	 * @since 3.0
	 */
	private class EditorSelectionChangedListener implements ISelectionChangedListener {

		/*
		 * @see
		 * org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.
		 * SelectionChangedEvent)
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			synchronizeOutlinePageSelection();
			updateOccurrenceAnnotations((ITextSelection)event.getSelection());
		}
	}

	private Annotation[] fOccurrenceAnnotations = null;

	private ISelection fForcedMarkOccurrencesSelection;

	private OccurrencesFinderJob fOccurrencesFinderJob;

	private long fMarkOccurrenceModificationStamp = IDocumentExtension4.UNKNOWN_MODIFICATION_STAMP;

	private IRegion fMarkOccurrenceTargetRegion;

	/**
	 * Compute the whole line of the current offset.
	 * 
	 * @param document
	 *            the current document
	 * @param offset
	 *            the current offset
	 * @return the line containing the offset, ended with the offset
	 */
	public static String getCurrentLine(IDocument document, int offset) {
		try {
			if (offset >= 0) {
				int lineNumber = document.getLineOfOffset(offset);
				int lineOffset = document.getLineOffset(lineNumber);
				return document.get(lineOffset, offset - lineOffset);
			}
			return null;
		} catch (BadLocationException ble) {
			return null;
		}
	}

	/**
	 * Updates occurrences annotations.
	 * 
	 * @param selection
	 *            the text selection
	 */
	public void updateOccurrenceAnnotations(ITextSelection selection) {
		IDocument document = getSourceViewer().getDocument();
		if (document == null)
			return;
		boolean hasChanged = false;
		if (document instanceof IDocumentExtension4) {
			int offset = selection.getOffset();
			String currentLine = getCurrentLine(document, offset);
			if (currentLine != null && currentLine.contains("--")) //$NON-NLS-1$
				return;
			long currentModificationStamp = ((IDocumentExtension4)document).getModificationStamp();
			IRegion markOccurrenceTargetRegion = fMarkOccurrenceTargetRegion;
			hasChanged = currentModificationStamp != fMarkOccurrenceModificationStamp;
			if (markOccurrenceTargetRegion != null && !hasChanged) {
				if (markOccurrenceTargetRegion.getOffset() <= offset
						&& offset <= markOccurrenceTargetRegion.getOffset()
								+ markOccurrenceTargetRegion.getLength())
					return;
			}
			fMarkOccurrenceTargetRegion = OpenDeclarationUtils.findWord(document, offset);
			if (fMarkOccurrenceTargetRegion == null || fMarkOccurrenceTargetRegion.getLength() <= 0)
				return;
			fMarkOccurrenceModificationStamp = currentModificationStamp;
		}
		AtlOccurrencesFinder finder = new AtlOccurrencesFinder(this, document);
		OccurrenceLocation[] locations = null;
		if (finder.initialize(fMarkOccurrenceTargetRegion) == null) {
			locations = finder.getOccurrences();
		}
		fOccurrencesFinderJob = new OccurrencesFinderJob(document, locations, selection);
		fOccurrencesFinderJob.run(new NullProgressMonitor());
	}

	/**
	 * Finds and marks occurrence annotations.
	 * 
	 * @since 3.0
	 */
	class OccurrencesFinderJob extends Job {

		private final IDocument fDocument;

		private final ISelection fSelection;

		private final ISelectionValidator fPostSelectionValidator;

		private boolean fCanceled = false;

		private final OccurrenceLocation[] fLocations;

		public OccurrencesFinderJob(IDocument document, OccurrenceLocation[] locations, ISelection selection) {
			super(""); //$NON-NLS-1$
			fDocument = document;
			fSelection = selection;
			fLocations = locations;

			if (getSelectionProvider() instanceof ISelectionValidator)
				fPostSelectionValidator = (ISelectionValidator)getSelectionProvider();
			else
				fPostSelectionValidator = null;
		}

		// cannot use cancel() because it is declared final
		void doCancel() {
			fCanceled = true;
			cancel();
		}

		private boolean isCanceled(IProgressMonitor progressMonitor) {
			return fCanceled
					|| progressMonitor.isCanceled()
					|| fPostSelectionValidator != null
					&& !(fPostSelectionValidator.isValid(fSelection) || fForcedMarkOccurrencesSelection == fSelection)
					|| LinkedModeModel.hasInstalledModel(fDocument);
		}

		/*
		 * @see Job#run(org.eclipse.core.runtime.IProgressMonitor)
		 */
		public IStatus run(IProgressMonitor progressMonitor) {
			if (fLocations == null || fLocations.length <= 0)
				return null;
			if (isCanceled(progressMonitor))
				return Status.CANCEL_STATUS;

			ITextViewer textViewer = getViewer();
			if (textViewer == null)
				return Status.CANCEL_STATUS;

			IDocument document = textViewer.getDocument();
			if (document == null)
				return Status.CANCEL_STATUS;

			IDocumentProvider documentProvider = getDocumentProvider();
			if (documentProvider == null)
				return Status.CANCEL_STATUS;

			IAnnotationModel annotationModel = documentProvider.getAnnotationModel(getEditorInput());
			if (annotationModel == null)
				return Status.CANCEL_STATUS;

			// Add occurrence annotations
			int length = fLocations.length;
			Map<Annotation, Position> annotationMap = new HashMap<Annotation, Position>(length);
			for (int i = 0; i < length; i++) {

				if (isCanceled(progressMonitor))
					return Status.CANCEL_STATUS;

				OccurrenceLocation location = fLocations[i];
				Position position = new Position(location.getOffset(), location.getLength());

				String description = location.getDescription();
				String annotationType = (location.getFlags() == IOccurrencesFinder.F_WRITE_OCCURRENCE) ? "org.eclipse.jdt.ui.occurrences.write" : "org.eclipse.jdt.ui.occurrences"; //$NON-NLS-1$ //$NON-NLS-2$

				annotationMap.put(new Annotation(annotationType, false, description), position);
			}

			if (isCanceled(progressMonitor))
				return Status.CANCEL_STATUS;

			synchronized (getLockObject(annotationModel)) {
				if (annotationModel instanceof IAnnotationModelExtension) {
					((IAnnotationModelExtension)annotationModel).replaceAnnotations(fOccurrenceAnnotations,
							annotationMap);
				} else {
					// removeOccurrenceAnnotations();
					Iterator<Entry<Annotation, Position>> iter = annotationMap.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry<Annotation, Position> mapEntry = (Map.Entry<Annotation, Position>)iter
								.next();
						annotationModel.addAnnotation((Annotation)mapEntry.getKey(), (Position)mapEntry
								.getValue());
					}
				}
				fOccurrenceAnnotations = (Annotation[])annotationMap.keySet().toArray(
						new Annotation[annotationMap.keySet().size()]);
			}

			return Status.OK_STATUS;
		}
	}

	/**
	 * Returns the lock object for the given annotation model.
	 * 
	 * @param annotationModel
	 *            the annotation model
	 * @return the annotation model's lock object
	 * @since 3.0
	 */
	private Object getLockObject(IAnnotationModel annotationModel) {
		if (annotationModel instanceof ISynchronizable) {
			Object lock = ((ISynchronizable)annotationModel).getLockObject();
			if (lock != null)
				return lock;
		}
		return annotationModel;
	}

	/**
	 * Position updater that takes any changes at the borders of a position to not belong to the position.
	 * 
	 * @since 3.0
	 */
	protected static class ExclusivePositionUpdater implements IPositionUpdater {

		/** The position category. */
		private final String fCategory;

		/**
		 * Creates a new updater for the given <code>category</code>.
		 * 
		 * @param category
		 *            the new category.
		 */
		public ExclusivePositionUpdater(String category) {
			fCategory = category;
		}

		/**
		 * Returns the position category.
		 * 
		 * @return the position category
		 */
		public String getCategory() {
			return fCategory;
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.jface.text.IPositionUpdater#update(org.eclipse.jface.text.DocumentEvent)
		 */
		public void update(DocumentEvent event) {
			int eventOffset = event.getOffset();
			int eventOldLength = event.getLength();
			int eventNewLength = event.getText() == null ? 0 : event.getText().length();
			int deltaLength = eventNewLength - eventOldLength;

			try {
				Position[] positions = event.getDocument().getPositions(fCategory);

				for (int i = 0; i != positions.length; i++) {

					Position position = positions[i];

					if (position.isDeleted()) {
						continue;
					}

					int offset = position.getOffset();
					int length = position.getLength();
					int end = offset + length;

					if (offset >= eventOffset + eventOldLength) {
						// position comes
						// after change - shift
						position.setOffset(offset + deltaLength);
					} else if (end <= eventOffset) {
						// position comes way before change -
						// leave alone
					} else if (offset <= eventOffset && end >= eventOffset + eventOldLength) {
						// event completely internal to the position - adjust length
						position.setLength(length + deltaLength);
					} else if (offset < eventOffset) {
						// event extends over end of position - adjust length
						int newEnd = eventOffset;
						position.setLength(newEnd - offset);
					} else if (end > eventOffset + eventOldLength) {
						// event extends from before position into it - adjust offset
						// and length
						// offset becomes end of event, length ajusted acordingly
						int newOffset = eventOffset + eventNewLength;
						position.setOffset(newOffset);
						position.setLength(end - newOffset);
					} else {
						// event consumes the position - delete it
						position.delete();
					}
				}
			} catch (BadPositionCategoryException e) {
				// ignore and return
			}
		}

	}

	private class ExitPolicy implements IExitPolicy {
		final char fEscapeCharacter;

		final char fExitCharacter;

		final int fSize;

		final Stack<BracketLevel> fStack;

		public ExitPolicy(char exitCharacter, char escapeCharacter, Stack<BracketLevel> stack) {
			fExitCharacter = exitCharacter;
			fEscapeCharacter = escapeCharacter;
			fStack = stack;
			fSize = fStack.size();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.text.link.LinkedModeUI.IExitPolicy#doExit(org.eclipse.jface.text.link.LinkedModeModel,
		 *      org.eclipse.swt.events.VerifyEvent, int, int)
		 */
		public ExitFlags doExit(LinkedModeModel model, VerifyEvent event, int offset, int length) {

			if (event.character == fExitCharacter) {

				if (fSize == fStack.size() && !isMasked(offset)) {
					BracketLevel level = fStack.peek();
					if (level.fFirstPosition.offset > offset || level.fSecondPosition.offset < offset) {
						return null;
					}
					if (level.fSecondPosition.offset == offset && length == 0) {
						// don't enter the character if if its the closing peer
						return new ExitFlags(ILinkedModeListener.UPDATE_CARET, false);
					}
				}
			}
			return null;
		}

		private boolean isMasked(int offset) {
			IDocument document = getSourceViewer().getDocument();
			try {
				return fEscapeCharacter == document.getChar(offset - 1);
			} catch (BadLocationException e) {
			}
			return false;
		}
	}

	interface ITextConverter {
		void customizeDocumentCommand(IDocument document, DocumentCommand command);
	}

	private class SelectionChangedListener implements ISelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			doSelectionChanged(event);
		}
	}

	static class TabConverter implements ITextConverter {
		private ILineTracker fLineTracker;

		private int fTabRatio;

		public TabConverter() {
		}

		public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
			String text = command.text;
			if (text == null) {
				return;
			}

			int index = text.indexOf('\t');
			if (index > -1) {

				StringBuffer buffer = new StringBuffer();

				fLineTracker.set(command.text);
				int lines = fLineTracker.getNumberOfLines();

				try {

					for (int i = 0; i < lines; i++) {

						int offset = fLineTracker.getLineOffset(i);
						int endOffset = offset + fLineTracker.getLineLength(i);
						String line = text.substring(offset, endOffset);

						int position = 0;
						if (i == 0) {
							IRegion firstLine = document.getLineInformationOfOffset(command.offset);
							position = command.offset - firstLine.getOffset();
						}

						int length = line.length();
						for (int j = 0; j < length; j++) {
							char c = line.charAt(j);
							if (c == '\t') {
								position += insertTabString(buffer, position);
							} else {
								buffer.append(c);
								++position;
							}
						}

					}

					command.text = buffer.toString();

				} catch (BadLocationException x) {
				}
			}
		}

		private int insertTabString(StringBuffer buffer, int offsetInLine) {

			if (fTabRatio == 0) {
				return 0;
			}

			int remainder = offsetInLine % fTabRatio;
			remainder = fTabRatio - remainder;
			for (int i = 0; i < remainder; i++) {
				buffer.append(' ');
			}
			return remainder;
		}

		public void setLineTracker(ILineTracker lineTracker) {
			fLineTracker = lineTracker;
		}

		public void setNumberOfSpacesPerTab(int ratio) {
			fTabRatio = ratio;
		}
	}

	private static char getEscapeCharacter(char character) {
		switch (character) {
			case '"':
			case '\'':
				return '\\';
			default:
				return 0;
		}
	}

	private static char getPeerCharacter(char character) {
		switch (character) {
			case '(':
				return ')';

			case ')':
				return '(';

			case '[':
				return ']';

			case ']':
				return '[';

			case '"':
			case '\'':
				return character;

			default:
				throw new IllegalArgumentException();
		}
	}

	private static boolean isBracket(char character) {
		for (int i = 0; i != IAtlLexems.BRACKETS.length; ++i) {
			if (character == IAtlLexems.BRACKETS[i].toCharArray()[0]) {
				return true;
			}
		}
		return false;
	}

	private static boolean isSurroundedByBrackets(IDocument document, int offset) {
		if (offset == 0 || offset == document.getLength()) {
			return false;
		}

		try {
			return isBracket(document.getChar(offset - 1)) && isBracket(document.getChar(offset));
		} catch (BadLocationException e) {
			return false;
		}
	}

	/**
	 * <p>
	 * Each ATL element has a location String that indicates where it is located in the source file
	 * </p>
	 * <p>
	 * <code>AtlNbCharFile</code> class is useful to get index char start and index char end from the location
	 * string
	 * </p>
	 * 
	 * @see AtlNbCharFile
	 */
	private AtlNbCharFile help;

	/** The <code>ContentOutlinePage</code> associated with this Editor */
	private AtlContentOutlinePage outlinePage;

	/**
	 * <p>
	 * The <code>PropertySheetPage</code> associated with this Editor
	 * </p>
	 * .
	 * <p>
	 * It will be used to display, in the properties view, information about any object selected in the tree
	 * viewer.
	 * </p>
	 */
	private PropertySheetPage propertySheetPage;

	/** The outline selection changed listener */
	private SelectionChangedListener selectionChangedListener;

	/**
	 * To update the title image when a problem marker change occurs. A problem marker change typically
	 * happens during compilation process.
	 */
	private AtlEditorTickErrorUpdater tickErrorUpdater;

	/**
	 * Creates a new ATL editor. Initialize his values from the <code>AtlUIPlugin</code> default instance.
	 */
	public AtlEditor() {
		super();
		setPreferenceStore(AtlUIPlugin.getDefault().getPreferenceStore());
		tickErrorUpdater = new AtlEditorTickErrorUpdater(this);
		sourceManager = new AtlSourceManager();
		comparator = new LastSaveComparator(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#affectsTextPresentation(org.eclipse.jface.util.PropertyChangeEvent)
	 */
	@Override
	protected boolean affectsTextPresentation(PropertyChangeEvent event) {
		return ((AtlSourceViewerConfiguration)getSourceViewerConfiguration()).affectsTextPresentation(event)
				|| super.affectsTextPresentation(event);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#configureSourceViewerDecorationSupport(org.eclipse.ui.texteditor.SourceViewerDecorationSupport)
	 */
	@Override
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		support.setCharacterPairMatcher(bracketMatcher);
		support.setMatchingCharacterPainterPreferenceKeys(
				AtlPreferenceConstants.APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS,
				AtlPreferenceConstants.APPEARANCE_HIGHLIGHT_MATCHING_BRACKETS_COLOR);

		super.configureSourceViewerDecorationSupport(support);
	}

	private void configureTabConverter() {
		if (fTabConverter != null) {
			// IDocumentProvider provider = getDocumentProvider();
			// TODO create line tracket method from the compulation unit document provider
			// fTabConverter.setLineTracker((IDocumentProvider)
			// provider.createLineTracker(getEditorInput()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#createActions()
	 */
	@Override
	protected void createActions() {
		super.createActions();
		Action action;
		ResourceBundle resourceBundle = Messages.getResourceBundle();

		action = new IndentAction(resourceBundle, "Indent.", this, false); //$NON-NLS-1$
		action.setActionDefinitionId(IAtlActionConstants.INDENT);
		setAction("Indent", action); //$NON-NLS-1$
		markAsStateDependentAction("Indent", true); //$NON-NLS-1$
		markAsSelectionDependentAction("Indent", true); //$NON-NLS-1$
		// TODO workbench help action
		// WorkbenchHelp.setHelp(action, IJavaHelpContextIds.INDENT_ACTION);

		action = new IndentAction(Messages.getResourceBundle(), "Indent.", this, true); //$NON-NLS-1$
		setAction("IndentOnTab", action); //$NON-NLS-1$
		markAsStateDependentAction("IndentOnTab", true); //$NON-NLS-1$
		markAsSelectionDependentAction("IndentOnTab", true); //$NON-NLS-1$

		if (getPreferenceStore().getBoolean(AtlPreferenceConstants.TYPING_SMART_TAB)) {
			// don't replace Shift Right - have to make sure their enablement is mutually exclusive
			// removeActionActivationCode(ITextEditorActionConstants.SHIFT_RIGHT);
			setActionActivationCode("IndentOnTab", '\t', -1, SWT.NONE); //$NON-NLS-1$
		}

		installContentAssistAction();

		action = new ToggleCommentAction(Messages.getResourceBundle(), "ToggleComment.", this); //$NON-NLS-1$
		action.setActionDefinitionId("atlCommands.commentBlock"); //$NON-NLS-1$
		setAction("ToggleComment", action); //$NON-NLS-1$
		markAsStateDependentAction("ToggleComment", true); //$NON-NLS-1$
		configureToggleCommentAction();

		action = new FormatCodeAction(Messages.getResourceBundle(), "FormatCode.", this); //$NON-NLS-1$
		action.setActionDefinitionId("atlCommands.formatCode"); //$NON-NLS-1$
		setAction("FormatCode", action); //$NON-NLS-1$
		markAsStateDependentAction("FormatCode", true); //$NON-NLS-1$

		// action = new GotoMatchingBracketAction(this);
		//		action.setActionDefinitionId("atlCommands.gotoMatchingBracket"); //$NON-NLS-1$
		//		setAction("GoToMatchingBracket", action); //$NON-NLS-1$
		//		markAsStateDependentAction("GoToMatchingBracket", true); //$NON-NLS-1$
	}

	/**
	 * Configures the toggle comment action
	 */
	private void configureToggleCommentAction() {
		IAction action = getAction("ToggleComment"); //$NON-NLS-1$
		if (action instanceof ToggleCommentAction) {
			ISourceViewer sourceViewer = getSourceViewer();
			SourceViewerConfiguration configuration = getSourceViewerConfiguration();
			((ToggleCommentAction)action).configure(sourceViewer, configuration);
		}
	}

	/**
	 * Installs an action so that the user can invoke the content assist feature by the well known combination
	 * of key strokes.
	 * 
	 * @author Matthias Bohlen
	 * @see "http://wiki.eclipse.org/FAQ_How_do_I_add_Content_Assist_to_my_editor%3F"
	 */
	private void installContentAssistAction() {
		ResourceBundle resourceBundle = Messages.getResourceBundle();
		Action action = new ContentAssistAction(resourceBundle, "ContentAssistProposal.", this); //$NON-NLS-1$
		String id = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		action.setActionDefinitionId(id);
		setAction("ContentAssistProposal", action); //$NON-NLS-1$
		markAsStateDependentAction("ContentAssistProposal", true); //$NON-NLS-1$
	}

	protected AtlContentOutlinePage createOutlinePage() {
		AtlContentOutlinePage page = new AtlContentOutlinePage(this, getEditorInput(), getDocumentProvider());
		selectionChangedListener = new SelectionChangedListener();
		page.addPostSelectionChangedListener(selectionChangedListener);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.texteditor.ExtendedTextEditor#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		editorSelectionChangedListener = new EditorSelectionChangedListener();
		IPostSelectionProvider editorSelectionProvider = (IPostSelectionProvider)getSelectionProvider();
		editorSelectionProvider.addPostSelectionChangedListener(editorSelectionChangedListener);

		// TODO startTabConversion
		// if (isTabConversionEnabled())
		// startTabConversion();

		IPreferenceStore preferenceStore = getPreferenceStore();
		fBracketInserter.setCloseBracketsEnabled(preferenceStore
				.getBoolean(AtlPreferenceConstants.TYPING_CLOSE_BRACKETS));
		fBracketInserter.setCloseStringsEnabled(preferenceStore
				.getBoolean(AtlPreferenceConstants.TYPING_CLOSE_STRINGS));

		ISourceViewer sourceViewer = getSourceViewer();
		if (sourceViewer instanceof ITextViewerExtension)
			((ITextViewerExtension)sourceViewer).prependVerifyKeyListener(fBracketInserter);

		ProjectionViewer viewer = (ProjectionViewer)getSourceViewer();

		projectionSupport = new ProjectionSupport(viewer, getAnnotationAccess(), getSharedColors());
		projectionSupport.install();

		// turn projection mode on
		viewer.doOperation(ProjectionViewer.TOGGLE);

		annotationModel = viewer.getProjectionAnnotationModel();
	}

	private ProjectionAnnotationModel annotationModel;

	/**
	 * Updates the folding structure of the template. This will be called from the Atl template reconciler in
	 * order to allow the folding of blocks to the user.
	 * 
	 * @param addedAnnotations
	 *            These annotations have been added since the last reconciling operation.
	 * @param deletedAnnotations
	 *            This list represents the annotations that were deleted since we last reconciled.
	 * @param modifiedAnnotations
	 *            These annotations have seen their positions updated.
	 */
	public void updateFoldingStructure(Map<Annotation, Position> addedAnnotations,
			List<Annotation> deletedAnnotations, Map<Annotation, Position> modifiedAnnotations) {
		Annotation[] deleted = new Annotation[deletedAnnotations.size() + modifiedAnnotations.size()];
		for (int i = 0; i < deletedAnnotations.size(); i++) {
			deleted[i] = deletedAnnotations.get(i);
		}
		final Iterator<Annotation> modifiedIterator = modifiedAnnotations.keySet().iterator();
		for (int i = deletedAnnotations.size(); i < deleted.length; i++) {
			deleted[i] = modifiedIterator.next();
		}
		addedAnnotations.putAll(modifiedAnnotations);
		if (annotationModel != null) {
			annotationModel.modifyAnnotations(deleted, addedAnnotations, null);
		}
	}

	/**
	 * Creates the property sheet page used with this editor
	 */
	protected PropertySheetPage createPropertySheetPage() {
		PropertySheetPage page = new PropertySheetPage();
		AtlPropertySourceProvider apsp = new AtlPropertySourceProvider();
		page.setPropertySourceProvider(apsp);
		return page;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();

		tickErrorUpdater.dispose();

		if (bracketMatcher != null) {
			bracketMatcher.dispose();
			bracketMatcher = null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		super.doSave(progressMonitor);
		sourceManager.updateDataSource(getDocumentProviderContent());
		analyser = new AtlModelAnalyser(new AtlCompletionHelper(getDocumentProviderContent()), sourceManager
				.getModel(), 0, AtlCompletionDataSource.getATLFileContext(sourceManager));
		comparator.markAsSave();
		if (outlinePage != null) {
			outlinePage.setUnit();
		}
	}

	public AtlPairMatcher getBracketMatcher() {
		return bracketMatcher;
	}

	protected void doSelectionChanged(SelectionChangedEvent event) {
		if (isAtlOutlinePageActive()) {
			setSelection(event);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#doSetSelection(org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	protected void doSetSelection(ISelection selection) {
		super.doSetSelection(selection);
		synchronizeOutlinePageSelection();
	}

	/**
	 * @return the current active part
	 */
	private IWorkbenchPart getActivePart() {
		IWorkbenchWindow window = getSite().getWorkbenchWindow();
		IPartService service = window.getPartService();
		IWorkbenchPart part = service.getActivePart();
		return part;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class required) {

		if (IContentOutlinePage.class.equals(required)) {
			if (outlinePage == null) {
				outlinePage = createOutlinePage();
			}
			return outlinePage;
		}

		if (IPropertySheetPage.class.equals(required)) {
			if (propertySheetPage == null) {
				propertySheetPage = createPropertySheetPage();
			}
			return propertySheetPage;
		}

		return super.getAdapter(required);
	}

	/**
	 * <p>
	 * return the content of the editor, i.e what currently displayed on the screen
	 * </p>
	 * 
	 * @return the content of the document provider associated with this AtlEditor
	 */
	public String getDocumentProviderContent() {
		return getDocumentProvider().getDocument(getEditorInput()).get();
	}

	/**
	 * <p>
	 * return the content of the file associated to the active editor.
	 * </p>
	 * <p>
	 * When the current editor is dirty, i.e when changes have not been saved yet, the content of the active
	 * editor differs from the content of the file associated to this editor.
	 * </p>
	 * 
	 * @return the content of the editor input associated with this AtlEditor
	 */
	public String getEditorInputContent() {
		IFileEditorInput editorInput = (IFileEditorInput)getEditorInput();
		IFile ifi = editorInput.getFile();
		StringBuffer content = new StringBuffer();
		InputStream is = null;
		try {
			int c;
			is = ifi.getContents();
			while ((c = is.read()) != -1)
				content.append((char)c);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e1) {
					ATLLogger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
				}
			}
		}
		return content.toString();
	}

	/**
	 * Returns the signed current selection. The length will be negative if the resulting selection is
	 * right-to-left(RtoL).
	 * <p>
	 * The selection offset is model based.
	 * </p>
	 * 
	 * @param sourceViewer
	 *            the source viewer
	 * @return a region denoting the current signed selection, for a resulting RtoL selections length is < 0
	 */
	protected IRegion getSignedSelection(ISourceViewer sourceViewer) {
		StyledText text = sourceViewer.getTextWidget();
		Point selection = text.getSelectionRange();

		if (text.getCaretOffset() == selection.x) {
			selection.x = selection.x + selection.y;
			selection.y = -selection.y;
		}

		selection.x = widgetOffset2ModelOffset(sourceViewer, selection.x);

		return new Region(selection.x, selection.y);
	}

	/**
	 * @return the IResource associated to <code>AtlEditor</code> or <code>null</code> if none
	 */
	public IResource getUnderlyingResource() {
		IEditorInput input = getEditorInput();
		if (input instanceof IFileEditorInput) {
			return ((IFileEditorInput)input).getFile();
		}
		return null;
	}

	public ISourceViewer getViewer() {
		return getSourceViewer();
	}

	public void gotoMatchingBracket() {
		ISourceViewer sourceViewer = getSourceViewer();
		IDocument document = sourceViewer.getDocument();
		if (document == null)
			return;

		IRegion selection = getSignedSelection(sourceViewer);

		int selectionLength = Math.abs(selection.getLength());
		if (selectionLength > 1) {
			setStatusLineErrorMessage(Messages.getString("GotoMatchingBracket.error.invalidSelection")); //$NON-NLS-1$
			sourceViewer.getTextWidget().getDisplay().beep();
			return;
		}

		int sourceCaretOffset = selection.getOffset() + selection.getLength();
		if (isSurroundedByBrackets(document, sourceCaretOffset))
			sourceCaretOffset -= selection.getLength();

		IRegion region = bracketMatcher.match(document, sourceCaretOffset);
		if (region == null) {
			setStatusLineErrorMessage(Messages.getString("GotoMatchingBracket.error.noMatchingBracket")); //$NON-NLS-1$
			sourceViewer.getTextWidget().getDisplay().beep();
			return;
		}

		int offset = region.getOffset();
		int length = region.getLength();

		if (length < 1)
			return;

		int anchor = bracketMatcher.getAnchor();
		// http://dev.eclipse.org/bugs/show_bug.cgi?id=34195
		int targetOffset = (AtlPairMatcher.RIGHT == anchor) ? offset + 1 : offset + length;

		boolean visible = false;
		if (sourceViewer instanceof ITextViewerExtension5) {
			ITextViewerExtension5 extension = (ITextViewerExtension5)sourceViewer;
			visible = extension.modelOffset2WidgetOffset(targetOffset) > -1;
		} else {
			IRegion visibleRegion = sourceViewer.getVisibleRegion();
			// http://dev.eclipse.org/bugs/show_bug.cgi?id=34195
			visible = targetOffset >= visibleRegion.getOffset()
					&& targetOffset <= visibleRegion.getOffset() + visibleRegion.getLength();
		}

		if (!visible) {
			setStatusLineErrorMessage(Messages
					.getString("GotoMatchingBracket.error.bracketOutsideSelectedElement")); //$NON-NLS-1$
			sourceViewer.getTextWidget().getDisplay().beep();
			return;
		}

		if (selection.getLength() < 0) {
			targetOffset -= selection.getLength();
		}

		sourceViewer.setSelectedRange(targetOffset, selection.getLength());
		sourceViewer.revealRange(targetOffset, selection.getLength());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#handlePreferenceStoreChanged(org.eclipse.jface.util.PropertyChangeEvent)
	 */
	@Override
	protected void handlePreferenceStoreChanged(PropertyChangeEvent event) {
		try {
			ISourceViewer sourceViewer = getSourceViewer();
			if (sourceViewer != null) {
				String property = event.getProperty();

				AtlSourceViewerConfiguration sourceViewerConfiguration = (AtlSourceViewerConfiguration)getSourceViewerConfiguration();
				sourceViewerConfiguration.handlePropertyChangeEvent(event);

				if (AtlPreferenceConstants.TYPING_CLOSE_BRACKETS.equals(property)) {
					fBracketInserter.setCloseBracketsEnabled(getPreferenceStore().getBoolean(property));
					return;
				}

				if (AtlPreferenceConstants.TYPING_CLOSE_STRINGS.equals(property)) {
					fBracketInserter.setCloseStringsEnabled(getPreferenceStore().getBoolean(property));
					return;
				}

				if (AtlPreferenceConstants.TYPING_SPACES_FOR_TABS.equals(property)) {
					if (isTabConversionEnabled())
						startTabConversion();
					else
						stopTabConversion();
					return;
				}

				if (AtlPreferenceConstants.TYPING_SMART_TAB.equals(property)) {
					if (getPreferenceStore().getBoolean(AtlPreferenceConstants.TYPING_SMART_TAB)) {
						setActionActivationCode("IndentOnTab", '\t', -1, SWT.NONE); //$NON-NLS-1$
					} else {
						removeActionActivationCode("IndentOnTab"); //$NON-NLS-1$
					}
				}

				// TODO when sourceViewer will be created remove first and uncomment second lines
				IContentAssistant c = sourceViewerConfiguration.getContentAssistant(sourceViewer);
				// IContentAssistant c = sourceViewer.getContentAssistant();
				if (c instanceof ContentAssistant)
					AtlContentAssistPreference.changeConfiguration((ContentAssistant)c, getPreferenceStore(),
							event);

				// TODO uncomment this when tab conversion will be created
				// if (CODE_FORMATTER_TAB_SIZE.equals(property)) {
				// sourceViewer.updateIndentationPrefixes();
				// if (fTabConverter != null)
				// fTabConverter.setNumberOfSpacesPerTab(getTabSize());
				// }
			}
		} finally {
			super.handlePreferenceStoreChanged(event);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#init(org.eclipse.ui.IEditorSite,
	 *      org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		tickErrorUpdater.updateEditorImage(getUnderlyingResource());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#initializeEditor()
	 */
	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setSourceViewerConfiguration(new AtlSourceViewerConfiguration(
				AtlUIPlugin.getDefault().getTextTools(), this));
	}

	/**
	 * @return <code>true</code> if this editor is the current active part <code>false</code> otherwise
	 */
	private boolean isActivePart() {
		IWorkbenchPart part = getActivePart();
		return part != null && part.equals(this);
	}

	/**
	 * @return <code>true</code> if the outline page used with this editor is the current active part
	 *         <code>false</code> otherwise
	 */
	private boolean isAtlOutlinePageActive() {
		IWorkbenchPart part = getActivePart();
		return (part instanceof ContentOutline) && ((ContentOutline)part).getCurrentPage() == outlinePage;
	}

	private boolean isTabConversionEnabled() {
		return getPreferenceStore().getBoolean(AtlPreferenceConstants.TYPING_SPACES_FOR_TABS);
	}

	public void setHelp(AtlNbCharFile help) {
		this.help = help;
	}

	protected void setNewPreferenceStore(IPreferenceStore store) {
		super.setPreferenceStore(store);
		if (getSourceViewerConfiguration() instanceof AtlSourceViewerConfiguration)
			((AtlSourceViewerConfiguration)getSourceViewerConfiguration()).setNewPreferenceStore(store);
	}

	private void setSelection(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection)event.getSelection();
		if (selection.isEmpty()) {
			resetHighlightRange();
		} else {
			EObject element = (EObject)selection.getFirstElement();
			String location = (String)element.eGet(AtlEMFConstants.sfLocation);
			if (location == null) { // some OclModel(meta model) define no location
				return;
			}

			int[] sl = help.getIndexChar(location);
			int start = sl[0];
			int length = sl[1] - sl[0];
			try {
				setHighlightRange(start, length, false);
				selectAndReveal(start, length);
			} catch (IllegalArgumentException x) {
				resetHighlightRange();
			}
		}
	}

	/**
	 * Sets the given message as error message to this editor's status line.
	 * 
	 * @param msg
	 *            message to be set
	 */
	@Override
	protected void setStatusLineErrorMessage(String msg) {
		IEditorStatusLine statusLine = (IEditorStatusLine)getAdapter(IEditorStatusLine.class);
		if (statusLine != null)
			statusLine.setMessage(true, msg, null);
	}

	/**
	 * Sets the given message as message to this editor's status line.
	 * 
	 * @param msg
	 *            message to be set
	 */
	@Override
	protected void setStatusLineMessage(String msg) {
		IEditorStatusLine statusLine = (IEditorStatusLine)getAdapter(IEditorStatusLine.class);
		if (statusLine != null)
			statusLine.setMessage(false, msg, null);
	}

	private void startTabConversion() {
		if (fTabConverter == null) {
			// TODO update tab conversion when source viewer will be available
			fTabConverter = new TabConverter();
			configureTabConverter();
			fTabConverter.setNumberOfSpacesPerTab(getPreferenceStore().getInt(
					AtlPreferenceConstants.APPEARANCE_TAB_WIDTH));
			// AdaptedSourceViewer sourceViewer= (AdaptedSourceViewer) getSourceViewer();
			// sourceViewer.addTextConverter(fTabConverter);
			// // http://dev.eclipse.org/bugs/show_bug.cgi?id=19270
			// sourceViewer.updateIndentationPrefixes();
		}
	}

	private void stopTabConversion() {
		if (fTabConverter != null) {
			// TODO update tab conversion when source viewer will be available
			// AdaptedSourceViewer asv= (AdaptedSourceViewer) getSourceViewer();
			// asv.removeTextConverter(fTabConverter);
			// // http://dev.eclipse.org/bugs/show_bug.cgi?id=19270
			// asv.updateIndentationPrefixes();
			fTabConverter = null;
		}
	}

	/**
	 * Synchronizes the outliner selection with the actual cursor position in the editor.
	 */
	public void synchronizeOutlinePageSelection() {
		if (isActivePart()) {
			if (outlinePage != null) {
				outlinePage.removePostSelectionChangedListener(selectionChangedListener);
				outlinePage.setSelection(getCursorPosition());
				outlinePage.addPostSelectionChangedListener(selectionChangedListener);
			}
		}
	}

	public void updateTitleImage(Image image) {
		setTitleImage(image);
	}

	public AtlContentOutlinePage getOutlinePage() {
		return outlinePage;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#createSourceViewer(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.jface.text.source.IVerticalRuler, int)
	 */
	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		ISourceViewer viewer = new ProjectionViewer(parent, ruler, getOverviewRuler(),
				isOverviewRulerVisible(), styles);

		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);
		return viewer;
	}

	public void toggleLineBreakpoints(ISelection selection) throws CoreException {
		IResource resource = (IResource)getEditorInput().getAdapter(IResource.class);
		ITextSelection textSelection = (ITextSelection)selection;
		int lineNumber = textSelection.getStartLine();
		int offset = textSelection.getOffset();
		if (offset == -1) {
			return;
		}
		EObject element = getDebugElement(lineNumber);
		if (element != null) {
			String location = (String)element.eGet(AtlEMFConstants.sfLocation);
			int[] pos = help.getIndexChar(location);
			int charStart = pos[0];
			int charEnd = pos[1];
			int elementLineNumber = Integer.parseInt(location.split("-")[0].split(":")[0]); //$NON-NLS-1$ //$NON-NLS-2$

			IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(
					AtlDebugModelConstants.ATL_DEBUG_MODEL_ID);
			for (int i = 0; i < breakpoints.length; i++) {
				IBreakpoint breakpoint = breakpoints[i];
				if (resource.equals(breakpoint.getMarker().getResource())) {
					int bLineNumber = ((ILineBreakpoint)breakpoint).getLineNumber();
					int bCharStart = ((ILineBreakpoint)breakpoint).getCharStart();
					int bCharEnd = ((ILineBreakpoint)breakpoint).getCharEnd();
					if (bLineNumber == elementLineNumber || bCharStart == charStart
							|| (charStart <= bCharStart && charEnd >= bCharEnd)) {
						// remove
						breakpoint.delete();
						return;
					}
				}
			}
			// new AtlBreakpoint(resource, location, lineNumber + 1, offset, offset + length);
			new AtlBreakpoint(resource, location, elementLineNumber, charStart, charEnd);
		}
	}

	public void toggleLineBreakpoints(EObject element) throws CoreException {
		IResource resource = (IResource)getEditorInput().getAdapter(IResource.class);
		if (element != null) {
			String location = (String)element.eGet(AtlEMFConstants.sfLocation);
			int[] pos = help.getIndexChar(location);
			int charStart = pos[0];
			int charEnd = pos[1];
			int elementLineNumber = Integer.parseInt(location.split("-")[0].split(":")[0]); //$NON-NLS-1$ //$NON-NLS-2$

			IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(
					AtlDebugModelConstants.ATL_DEBUG_MODEL_ID);
			for (int i = 0; i < breakpoints.length; i++) {
				IBreakpoint breakpoint = breakpoints[i];
				if (resource.equals(breakpoint.getMarker().getResource())) {
					int bLineNumber = ((ILineBreakpoint)breakpoint).getLineNumber();
					int bCharStart = ((ILineBreakpoint)breakpoint).getCharStart();
					int bCharEnd = ((ILineBreakpoint)breakpoint).getCharEnd();
					if (bLineNumber == elementLineNumber || bCharStart == charStart
							|| (charStart <= bCharStart && charEnd >= bCharEnd)) {
						// remove
						breakpoint.delete();
						return;
					}
				}
			}
			// new AtlBreakpoint(resource, location, lineNumber + 1, offset, offset + length);
			new AtlBreakpoint(resource, location, elementLineNumber, charStart, charEnd);
		}
	}

	public EObject getDebugElement(int lineNumber) {
		EObject res = null;
		if (sourceManager.getModel() != null) {
			TreeIterator<EObject> ti = sourceManager.getModel().eAllContents();
			while (ti.hasNext()) {
				EObject object = ti.next();
				EStructuralFeature feature = object.eClass().getEStructuralFeature("location"); //$NON-NLS-1$
				if (feature != null) {
					String location = (String)object.eGet(feature);
					int elementLineNumber = Integer.parseInt(location.split("-")[0].split(":")[0]); //$NON-NLS-1$ //$NON-NLS-2$
					if (elementLineNumber == lineNumber + 1) {
						res = object;
					}
				}
			}
		}
		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#doSetInput(org.eclipse.ui.IEditorInput)
	 */
	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		super.doSetInput(input);
		configureToggleCommentAction();
		if (tickErrorUpdater != null) {
			tickErrorUpdater.updateEditorImage(getUnderlyingResource());
		}
		sourceManager.updateDataSource(getDocumentProviderContent());
		analyser = new AtlModelAnalyser(new AtlCompletionHelper(getDocumentProviderContent()), sourceManager
				.getModel(), 0, AtlCompletionDataSource.getATLFileContext(sourceManager));
		comparator.markAsSave();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#initializeKeyBindingScopes()
	 */
	@Override
	protected void initializeKeyBindingScopes() {
		setKeyBindingScopes(new String[] {"org.eclipse.m2m.atl.adt.editor"}); //$NON-NLS-1$
	}

	public LastSaveComparator getComparator() {
		return comparator;
	}

	public AtlSourceViewerConfiguration getSourceViewerConf() {
		return (AtlSourceViewerConfiguration)getSourceViewerConfiguration();
	}

	public AtlSourceManager getSourceManager() {
		return sourceManager;
	}

	public AtlModelAnalyser getModelAnalyser() {
		return analyser;
	}

}
