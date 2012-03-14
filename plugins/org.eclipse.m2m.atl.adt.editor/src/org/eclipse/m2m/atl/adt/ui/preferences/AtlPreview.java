/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.preferences;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.MarginPainter;
import org.eclipse.jface.text.WhitespaceCharacterPainter;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.editor.formatter.AtlCodeFormatter;
import org.eclipse.m2m.atl.adt.ui.text.AtlSourceViewerConfiguration;
import org.eclipse.m2m.atl.adt.ui.text.AtlTextTools;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCompletionDataSource;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCompletionHelper;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlModelAnalyser;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;

/**
 * The ATL Formatter previewer.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlPreview implements Observer {

	private Document document;
	private SourceViewer fSourceViewer;
	private AtlSourceViewerConfiguration fViewerConfiguration;
	private final IPreferenceStore fPreferenceStore;
	private final MarginPainter fMarginPainter;
	private AtlModelAnalyser modelAnalyser;
	private WhitespaceCharacterPainter fWhitespaceCharacterPainter;
	private Map<String, String> fWorkingValues;

	public AtlPreview(Map<String, String> workingValues, Composite parent) {
		AtlTextTools tools = AtlUIPlugin.getDefault().getTextTools();
		document = new Document();
		AtlEditor editor = new AtlEditor();
		fViewerConfiguration = new AtlSourceViewerConfiguration(tools, editor);
		fWorkingValues = workingValues;
		int styles = SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION;
		fSourceViewer = new SourceViewer(parent, null, null, false, styles);
		fSourceViewer.configure(fViewerConfiguration);
		fSourceViewer.setEditable(false);
		Cursor arrowCursor = fSourceViewer.getTextWidget().getDisplay().getSystemCursor(SWT.CURSOR_ARROW);
		fSourceViewer.getTextWidget().setCursor(arrowCursor);
		fSourceViewer.getTextWidget().setCaret(null);
		fSourceViewer.getTextWidget().setFont(JFaceResources.getTextFont());
		fSourceViewer.setDocument(document);
		fPreferenceStore = fViewerConfiguration.getPreferenceStore();
		// The margin painter (comment to hide)
		fMarginPainter = new MarginPainter(fSourceViewer);
		final RGB rgb = PreferenceConverter.getColor(fPreferenceStore,
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLOR);
		fMarginPainter.setMarginRulerColor(tools.getColorManager().getColor(rgb));
		fSourceViewer.addPainter(fMarginPainter);
	}

	public void setText(String text) {
		document.set(text);
		updateEditor();
	}

	public void updateEditor() {
		final StyledText widget = (StyledText)fSourceViewer.getControl();
		final int height = widget.getClientArea().height;
		final int top0 = widget.getTopPixel();

		final int totalPixels0 = getHeightOfAllLines(widget);
		final int topPixelRange0 = totalPixels0 > height ? totalPixels0 - height : 0;

		widget.setRedraw(false);
		
		AtlSourceManager sourceManager = new AtlSourceManager();
		sourceManager.updateDataSource(document.get());
		this.modelAnalyser = new AtlModelAnalyser(
				new AtlCompletionHelper(document.get()), sourceManager
						.getModel(), 0, AtlCompletionDataSource.getATLFileContext(sourceManager));
		try {
			new AtlCodeFormatter().format(document, fWorkingValues, modelAnalyser);
		} catch (BadLocationException e) {
			// Location problem, the model may not be up-to-date (not saved)
		}

		fSourceViewer.setSelection(null);

		final int totalPixels1 = getHeightOfAllLines(widget);
		final int topPixelRange1 = totalPixels1 > height ? totalPixels1 - height : 0;

		final int top1 = topPixelRange0 > 0 ? (int)(topPixelRange1 * top0 / (double)topPixelRange0) : 0;
		widget.setTopPixel(top1);
		widget.setRedraw(true);
	}

	private int getHeightOfAllLines(StyledText styledText) {
		int height= 0;
		int lineCount= styledText.getLineCount();
		for (int i= 0; i < lineCount; i++)
			height= height + styledText.getLineHeight(styledText.getOffsetAtLine(i));
		return height;
	}

	public Control getControl() {
		return fSourceViewer.getControl();
	}

	public void showInvisibleCharacters(boolean enable) {
		if (enable) {
			if (fWhitespaceCharacterPainter == null) {
				fWhitespaceCharacterPainter = new WhitespaceCharacterPainter(fSourceViewer);
				fSourceViewer.addPainter(fWhitespaceCharacterPainter);
			}
		} else {
			fSourceViewer.removePainter(fWhitespaceCharacterPainter);
			fWhitespaceCharacterPainter = null;
		}
	}

	public boolean isShowInvisible() {
		return (fWhitespaceCharacterPainter != null);
	}

	public Map<String, String> getWorkingValues() {
		return fWorkingValues;
	}
	public void setWorkingValues(Map<String, String> workingValues) {
		this.fWorkingValues = workingValues;
	}

	public void update(Observable o, Object arg) {
		if(o instanceof ProfileManager) {
			ProfileManager manager = (ProfileManager)o;
			fWorkingValues = manager.getSelected().getSettings();
			updateEditor();
		}
	}

}
