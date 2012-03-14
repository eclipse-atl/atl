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
package org.eclipse.m2m.atl.adt.ui.editor.formatter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.adt.ui.editor.formatter.objects.CodeFragment;
import org.eclipse.m2m.atl.adt.ui.editor.formatter.objects.FormattedObject;
import org.eclipse.m2m.atl.adt.ui.preferences.AtlCodeFormatterProfileManager;
import org.eclipse.m2m.atl.adt.ui.preferences.AtlCodeFormatterPropertyPage;
import org.eclipse.m2m.atl.adt.ui.preferences.PreferencesAccess;
import org.eclipse.m2m.atl.adt.ui.preferences.ProfileManager.Profile;
import org.eclipse.m2m.atl.adt.ui.preferences.ProfileStore;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCompletionDataSource;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCompletionHelper;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlModelAnalyser;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

/**
 * This class represents a code formatter. It uses the current model of the ATL editor to format the ATL
 * source code.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @see org.eclipse.m2m.atl.adt.ui.editor.formatter.AtlCodeFormatterPreferences
 */
public class AtlCodeFormatter {

	private AtlModelAnalyser modelAnalyser;

	/**
	 * the strings expressions of the source code; they don't need to be formatted, so we remove them at the
	 * beginning, and put them back at the end.
	 */
	private HashMap<String, String> stringExp;

	/**
	 * the preferences of the code formatter.
	 */
	private AtlCodeFormatterPreferences preferences;

	private FormattedObject formattedRoot;

	/**
	 * Launches the code formatting on the given editor. Entry point of the code formatter.
	 * 
	 * @param editor
	 *            the editor we want to work on.
	 * @throws BadLocationException
	 */
	public void format(AtlEditor editor) throws BadLocationException {
		// Try to simulate a save action, the model is updated (unless an error is detected)

		ISelection selection = editor.getSelectionProvider().getSelection();

		editor.getSourceManager().updateDataSource(editor.getViewer().getDocument().get());
		this.modelAnalyser = new AtlModelAnalyser(
				new AtlCompletionHelper(editor.getDocumentProviderContent()), editor.getSourceManager()
						.getModel(), 0, AtlCompletionDataSource.getATLFileContext(editor.getSourceManager()));

		applyProfileToEditor(editor);

		format(editor.getViewer().getDocument());

		editor.getSelectionProvider().setSelection(selection);

	}

	public void format(IDocument document, Map<String, String> options, AtlModelAnalyser modelAnalyser)
			throws BadLocationException {
		this.modelAnalyser = modelAnalyser;
		if (options != null) {
			// Get preferences from options
			preferences = new AtlCodeFormatterPreferences(options);
		} else {
			// Get default preferences if options are null
			preferences = new AtlCodeFormatterPreferences();
		}
		format(document);
	}

	public String format(InputStream is) throws IOException, BadLocationException {
		InputStreamReader isr = new InputStreamReader(is);
		StringBuffer s = new StringBuffer();
		char buffer[] = new char[10000];
		int size;
		while ((size = isr.read(buffer)) > 0) {
			s.append(buffer, 0, size);
		}

		Document document = new Document();
		document.set(s.toString());
		AtlSourceManager sourceManager = new AtlSourceManager();
		sourceManager.updateDataSource(document.get());
		this.modelAnalyser = new AtlModelAnalyser(new AtlCompletionHelper(document.get()), sourceManager
				.getModel(), 0, AtlCompletionDataSource.getATLFileContext(sourceManager));
		format(document, AtlCodeFormatterPreferences.getDefaultOptions(), this.modelAnalyser);
		if (formattedRoot == null) {
			return s.toString();
		}
		return formattedRoot.getText();
	}

	private void format(IDocument document) throws BadLocationException {
		FormattedObject.resetCounter();
		stringExp = new HashMap<String, String>();
		EObject root = modelAnalyser.getRoot();
		if (root == null)
			return;
		formattedRoot = new FormattedObject(root, document.get());
		initialize(formattedRoot);
		format(formattedRoot);
		finalize(formattedRoot);
		if (!formattedRoot.getText().equals(document.get()))
			document.set(formattedRoot.getText());
	}

	public void applyProfileToEditor(AtlEditor editor) {
		IEditorPart editorPart = editor.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
		if (editorPart != null) {
			IFileEditorInput input = (IFileEditorInput)editorPart.getEditorInput();
			IFile file = input.getFile();
			IProject activeProject = file.getProject();

			PreferencesAccess access = PreferencesAccess.getOriginalPreferences();
			ProfileStore profileStore = new ProfileStore(AtlCodeFormatterPropertyPage.PROFILES_KEY);
			IScopeContext scope = access.getInstanceScope();

			IScopeContext projectScope = access.getProjectScope(activeProject);
			IEclipsePreferences node = projectScope.getNode(AtlUIPlugin.getPluginId());
			String profileId = node.get(AtlCodeFormatterPropertyPage.CURRENT_PROFILE_KEY, null);
			AtlCodeFormatterProfileManager manager = AtlCodeFormatterProfileManager.getCurrentProfileManager(
					scope, access, profileStore);
			Profile projectProfile = manager.getProfile(profileId);
			if (projectProfile == null
					|| !isProjectSpecificSettingsEnabled(access.getProjectScope(activeProject))) {
				if (editor.getSourceViewerConf().getPreferenceStore() != null) {
					// Get preferences from store
					preferences = new AtlCodeFormatterPreferences(editor.getSourceViewerConf()
							.getPreferenceStore());
				} else {
					// Get default preferences if no store exists
					preferences = new AtlCodeFormatterPreferences();
				}
				return;
			}
			manager.setSelected(projectProfile);
			if (projectProfile.getSettings() != null) {
				// Get preferences from options
				preferences = new AtlCodeFormatterPreferences(projectProfile.getSettings());
			} else {
				// Get default preferences if options are null
				preferences = new AtlCodeFormatterPreferences();
			}
		}
	}

	public boolean isProjectSpecificSettingsEnabled(IScopeContext context) {
		return context.getNode(AtlUIPlugin.getPluginId()).getBoolean(
				AtlCodeFormatterPropertyPage.PROJECT_SPECIFIC_SETTINGS_ENABLED, false);
	}

	/**
	 * Does the formatting recursively. The formatter calls it on the root, then it is called on every sub
	 * EObject recursively.
	 * 
	 * @param parent
	 *            the current formatted object.
	 * @throws BadLocationException
	 */
	private void format(FormattedObject parent) throws BadLocationException {
		// We remove strings from the code and put them in an array; they will be put back after the
		// formatting
		correctIndentationLevel(parent);
		// For each child of the current object, we call the format method, and
		// replace the result of the formatting into the parent.
		EObject eObject = parent.getEObject();
		for (EObject child : eObject.eContents()) {
			String childText = modelAnalyser.getText(child);
			FormattedObject formattedChild = new FormattedObject(child, childText,
					parent.getIndentationLevel() + 1);
			treatStrings(formattedChild);
			CodeFragment fragment = initializeCodeFragment(parent.getText(), childText);
			parent.addChildren(formattedChild);

			if (parent.getType() == FormattedObject.TYPE_OPERATOR_CALL_EXP) {
				formattedChild.setIndentationLevel(formattedChild.getIndentationLevel() - 1);
			}

			format(formattedChild);

			if (formattedChild.getType() != FormattedObject.TYPE_UNKNOWN) {
				fragment.setReplacementCodeFragment(formattedChild.getReplacement());
			} else {
				parent.getChildren().addAll(formattedChild.getChildren());
				fragment.setReplacementCodeFragment(formattedChild.getText());
			}
			try {
				replaceFragment(parent, fragment);
			} catch (InvalidFragmentException e) {
				// Unmatched fragment, we can't do anything.
				// It means that the code fragment can't be found anymore in the parent text,
				// and may be caused by a desynchronization with the model (due to an error).
			}
		}

		// NOTE: The formatter strategy assumes that all text elements match a CST object. Sometimes the
		// parser fails to build a CST from text with grammar errors. So unless we base the strategy on more
		// stable informations, we have to treat specific cases where the CST is incorrect
		if (eObject.eContents().isEmpty()
				&& ("OutPattern".equals(eObject.eClass().getName()) || "InPattern".equals(eObject.eClass()
						.getName()))) {
			// the CST is incorrect and formatting may lead to code losses. We chose no to format the element.
			return;
		}

		// According to the type of the current object, we call the appropriate method
		formatParent(parent);
	}

	private void treatStrings(FormattedObject parent) {
		if (parent.getType() == FormattedObject.TYPE_STRING_EXP
				&& parent.getText().startsWith("'") && parent.getText().endsWith("'")) { //$NON-NLS-1$ //$NON-NLS-2$
			stringExp.put((stringExp.keySet().size() + 1) + "", parent.getText()); //$NON-NLS-1$
			parent.setText("'{" + stringExp.size() + "}'"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
	}

	private void formatParent(FormattedObject parent) throws BadLocationException {
		treatComments(parent);
		String result = parent.getText();
		String save = result;
		switch (parent.getType()) {
			case FormattedObject.TYPE_MODULE:
				result = formatModule(parent);
				break;
			case FormattedObject.TYPE_OCL_MODEL:
				result = formatOclModel(parent);
				break;
			case FormattedObject.TYPE_HELPER:
				result = formatHelper(parent);
				break;
			case FormattedObject.TYPE_MATCHED_RULE:
			case FormattedObject.TYPE_LAZY_MATCHED_RULE:
			case FormattedObject.TYPE_ABSTRACT_MATCHED_RULE:
				result = formatRule(parent);
				break;
			case FormattedObject.TYPE_CALLED_RULE:
				result = formatCalledRule(parent);
				break;
			case FormattedObject.TYPE_OPERATOR_CALL_EXP:
				result = formatOperatorCallExp(parent);
				break;
			case FormattedObject.TYPE_PARAMETER:
				result = formatParameter(parent);
				break;
			case FormattedObject.TYPE_BINDING:
				result = formatBinding(parent);
				break;
			case FormattedObject.TYPE_IN_PATTERN: // from
				result = formatInPattern(parent);
				break;
			case FormattedObject.TYPE_RULE_VARIABLE_DECLARATION: // using
				result = formatRuleVariableDeclaration(parent);
				break;
			case FormattedObject.TYPE_OUT_PATTERN: // to
				result = formatOutPattern(parent);
				break;
			case FormattedObject.TYPE_COLLECTION_TYPE:
				result = formatCollectionType(parent);
				break;
			case FormattedObject.TYPE_OPERATION:
				result = formatOperation(parent);
				break;
			case FormattedObject.TYPE_ATTRIBUTE:
				result = formatAttribute(parent);
				break;
			case FormattedObject.TYPE_TUPLE_EXP:
				result = formatTupleExp(parent);
				break;
			case FormattedObject.TYPE_COLLECTION_EXP:
				result = formatCollectionExp(parent);
				break;
			case FormattedObject.TYPE_COLLECTION_OPERATION_CALL_EXP:
			case FormattedObject.TYPE_OPERATION_CALL_EXP:
				result = formatCollectionOperationCallExp(parent);
				break;
			case FormattedObject.TYPE_NAVIGATION_OR_ATTRIBUTE_CALL_EXP:
				result = formatNavigationOrAttributeCallExp(parent);
				break;
			case FormattedObject.TYPE_LIBRARY:
				result = formatLibrary(parent);
				break;
			case FormattedObject.TYPE_QUERY:
				result = formatQuery(parent);
				break;
			case FormattedObject.TYPE_ITERATE_EXP:
			case FormattedObject.TYPE_ITERATOR_EXP:
				result = formatIteratorExp(parent);
				break;
			case FormattedObject.TYPE_IF_EXP:
				result = formatIfExp(parent);
				break;
			case FormattedObject.TYPE_FOR_EXP:
				result = formatForExp(parent);
				break;
			case FormattedObject.TYPE_ACTION_BLOCK: // do
				result = formatActionBlock(parent);
				break;
			case FormattedObject.TYPE_OCL_MODEL_ELEMENT: // do
				result = formatOclModelElement(parent);
				break;
			case FormattedObject.TYPE_SIMPLE_IN_PATTERN: // do
				result = formatSimpleInPattern(parent);
				break;
			case FormattedObject.TYPE_LET_EXP:
				result = formatLetExp(parent);
				break;
			case FormattedObject.TYPE_SIMPLE_OUT_PATTERN_ELEMENT:
				result = formatSimpleOutPatternElement(parent);
				break;
			case FormattedObject.TYPE_FOR_EACH_OUT_PATTERN_ELEMENT:
				result = formatForEachOutPatternElement(parent);
				break;
			case FormattedObject.TYPE_OCL_UNDEFINED:
				result = "OclUndefined";
				break;
			case FormattedObject.TYPE_UNKNOWN:
			default:
				// Enters here for untreated cases
				break;
		}
		if (result.trim().equals("")) {
			parent.setText(save);
		} else {
			parent.setText(result);
		}

	}

	private void treatComments(FormattedObject fo) throws BadLocationException {
		String text = fo.getText();
		while (hasComment(text) && !fo.getEObject().equals(modelAnalyser.getRoot())) {
			int beginOffset = text.indexOf("--"); //$NON-NLS-1$
			int endOffset = beginOffset + getNextNoneCommentOffset(text.substring(beginOffset));
			int allTrimmedEndOffset = beginOffset
					+ getNextNoneCommentAllTrimmedOffset(text.substring(beginOffset, endOffset));
			// int trimmedEndOffset = beginOffset +
			// getNextNoneCommentTrimmedOffset(text.substring(beginOffset, endOffset));
			String comment = text.substring(beginOffset, allTrimmedEndOffset);// +
																				// text.substring(trimmedEndOffset,
																				// endOffset);
			// CodeFragment fragment = initializeCodeFragment(text, comment);
			boolean end = true;
			int childNum = -1;
			String regex = FormattedObject.RPLCMT_RGX_GRPNM + "\\s*" + Pattern.quote(comment); //$NON-NLS-1$
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(text.substring(0, endOffset));
			while (m.find()) {
				childNum = Integer.parseInt(m.group(1));
			}
			if (childNum == -1) {
				end = false;
				regex = Pattern.quote(comment) + "\\s*" + FormattedObject.RPLCMT_RGX_GRPNM; //$NON-NLS-1$
				p = Pattern.compile(regex);
				m = p.matcher(text.substring(beginOffset));
				while (m.find()) {
					childNum = Integer.parseInt(m.group(1));
				}
			}
			if (childNum == -1) {
				return;
			}
			comment += "\n" + AtlCodeFormatterPreferences.getChars(fo.getIndentationLevel() + 1, '\t'); //$NON-NLS-1$
			text = text.substring(0, beginOffset) + " " + text.substring(endOffset); //$NON-NLS-1$
			addCommentToChild(fo, childNum, comment, end);
			// fragment.setReplacementCodeFragment(comment);
			// commentFragments.add(fragment);
			fo.setText(text);
		}
	}

	private void addCommentToChild(FormattedObject parent, int childNum, String comment, boolean end) {
		for (FormattedObject child : parent.getChildren()) {
			if (child.getNumber() == childNum) {
				if (end)
					child.setText(child.getText() + " " + comment); //$NON-NLS-1$
				else
					child.setText(comment + child.getText());
				return;
			}
		}
	}

	private int getNextNoneCommentAllTrimmedOffset(String text) {
		String regex = "\\S\\s*\\z"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		int offset = text.length();
		while (m.find()) {
			offset = m.start() + 1;
		}
		return offset;
	}

	private int getNextNoneCommentOffset(String text) {
		String regex = "\\A((?:--[^\n]*\\s*)*)"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		int offset = text.indexOf("\n"); //$NON-NLS-1$
		while (m.find()) {
			offset = m.group(1).length();
		}
		return offset;
	}

	private void correctIndentationLevel(FormattedObject parent) {
		int indentationLevel = parent.getIndentationLevel();
		if (isRuleType(parent.getType()))
			indentationLevel = 0;
		if (parent.getType() == FormattedObject.TYPE_HELPER)
			indentationLevel = -2;
		parent.setIndentationLevel(indentationLevel);
	}

	private boolean isRuleType(int type) {
		return (type == FormattedObject.TYPE_MATCHED_RULE || type == FormattedObject.TYPE_LAZY_MATCHED_RULE
				|| type == FormattedObject.TYPE_ABSTRACT_MATCHED_RULE || type == FormattedObject.TYPE_CALLED_RULE);
	}

	/**
	 * At the end of the formatting process, if lineMaxLength > -1, we cut lines of the code so that each line
	 * length does not exceed lineMaxLength (if possible).
	 * 
	 * @param text
	 *            the text to cut.
	 * @return the cut text.
	 */
	private String cutLines(String text) {
		// TODO FORMATTER fix comments line cut
		if (preferences.getLineMaxLength() == -1) // -1 means no length limit for the text
			return text;
		String result = ""; //$NON-NLS-1$
		for (String line : text.split("\n")) { //$NON-NLS-1$
			boolean isStringOpened = (getLineType(line) == FormattedObject.LINE_TYPE_STRING);
			if (calculateSize(line) > preferences.getLineMaxLength() && isToBeCut(line)) {
				String splitLine = new String(line);
				String oldSplitLine = ""; //$NON-NLS-1$
				while (calculateSize(splitLine) > preferences.getLineMaxLength()
						&& !splitLine.equals(oldSplitLine) && canBeSplit(splitLine)) {
					oldSplitLine = splitLine;
					int offset = lastOffsetToMaxLength(splitLine);
					int endOffset = offset;
					if (splitLine.charAt(offset) == ' ')
						endOffset = offset + 1;
					String endLine = ""; //$NON-NLS-1$
					String beginNewLine = getTabs(line);
					int lineType = getLineType(splitLine.substring(0, offset));
					if (!isStringOpened && lineType == FormattedObject.LINE_TYPE_STRING) {
						endLine = "'"; //$NON-NLS-1$
						beginNewLine += "+ '"; //$NON-NLS-1$
						endOffset -= 1;
					} else if (lineType == FormattedObject.LINE_TYPE_HELPER_COMMENT) {
						beginNewLine = "---" + preferences.getSpacesAfterComment(); //$NON-NLS-1$
					} else if (lineType == FormattedObject.LINE_TYPE_COMMENT) {
						beginNewLine += "--" + preferences.getSpacesAfterComment(); //$NON-NLS-1$
					}
					result += splitLine.substring(0, offset/* - endLine.length() */) + endLine + "\n"; //$NON-NLS-1$
					splitLine = beginNewLine + splitLine.substring(endOffset/* - endLine.length() */);
				}
				result += splitLine;
			} else
				result += line;
			result += "\n"; //$NON-NLS-1$
		}
		return result;
	}

	private boolean canBeSplit(String line) {
		if (line.trim().equals("") || line.indexOf(' ') == -1) //$NON-NLS-1$
			return false;
		return true;
	}

	/**
	 * Put back the removed strings of the source code after the formatting.
	 * 
	 * @param line
	 *            the line in which we want to put back its strings.
	 * @return the line with its strings, if exist.
	 */
	private String replaceStrings(String line) {
		int partialLineType = getLineType(line.substring(0,
				(line.indexOf("'{") == -1 ? line.length() : line.indexOf("'{")))); //$NON-NLS-1$ //$NON-NLS-2$
		String regex = "'\\{(\\d+)\\}'"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(line);
		while (m.find()) {
			if (partialLineType != FormattedObject.LINE_TYPE_COMMENT
					&& partialLineType != FormattedObject.LINE_TYPE_HELPER_COMMENT) {
				String stringKey = m.group(1);
				String replacement = stringExp.get(stringKey).replace("\\", "\\\\").replace("$", "\\$"); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				line = line.replaceFirst(Pattern.quote(m.group()), replacement);
				// stringExp.remove(stringKey);
			}
			partialLineType = getLineType(line.substring(0,
					(line.indexOf("'{") == -1 ? line.length() : line.indexOf("'{")))); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return line;
	}

	/**
	 * Returns the type of the given line.
	 * 
	 * @param line
	 *            the line.
	 * @return an integer value for the type.
	 */
	private static int getLineType(String line) {
		boolean stringFlag = false;
		int commentFlag = 0;
		char currChar, prevChar = (char)0;
		for (int i = 0; i < line.length(); i++) {
			currChar = line.charAt(i);
			if (currChar == '\'' && prevChar != '\\' && commentFlag < 2) {
				stringFlag = !stringFlag;
			} else if (((currChar == '-' && commentFlag < 2) || (currChar == '-' && prevChar == '-'))
					&& !stringFlag) {
				commentFlag++;
			}
			if ((currChar != '-' && commentFlag < 2) || currChar == '\n')
				commentFlag = 0;
			prevChar = currChar;
		}
		if (stringFlag)
			return FormattedObject.LINE_TYPE_STRING;
		if (commentFlag == 2)
			return FormattedObject.LINE_TYPE_COMMENT;
		if (commentFlag > 2)
			return FormattedObject.LINE_TYPE_HELPER_COMMENT;
		return FormattedObject.LINE_TYPE_NORMAL;
	}

	private static boolean hasComment(String text) {
		for (String line : text.split("\n")) { //$NON-NLS-1$
			if (getLineType(line) == FormattedObject.LINE_TYPE_COMMENT
					|| getLineType(line) == FormattedObject.LINE_TYPE_HELPER_COMMENT)
				return true;
		}
		return false;
	}

	/**
	 * Determines whether the line is to be wrapped or not. Basically, only special tag lines do not have to
	 * be cut.
	 * 
	 * @param line
	 *            the line.
	 * @return whether the line is to be wrapped or not.
	 */
	private static boolean isToBeCut(String line) {
		if (line.matches("\\A[-]{2,}\\s*@[^$]*")) //$NON-NLS-1$
			return false;
		if (line.matches(".*[-]{2,}\\s*\\[NOCUT\\].*")) //$NON-NLS-1$
			return false;
		return true;
	}

	/**
	 * Calculates the size of a line (its tabulations may count for more than one character)
	 * 
	 * @param line
	 *            the line.
	 * @return the size of the given line.
	 */
	private int calculateSize(String line) {
		// TODO FORMATTER remove right spaces and tabs
		int size = line.length();
		size += tabsCount(line) * (preferences.getTabSpaces() - 1);
		return size;
	}

	/**
	 * Counts the number of tabulations of a line.
	 * 
	 * @param line
	 *            the line.
	 * @return the number of tabulations of the line.
	 */
	private static int tabsCount(String line) {
		int tabsCount = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '\t')
				tabsCount++;
		}
		return tabsCount;
	}

	/**
	 * Determines the offset where a line has to be cut (according to lineMaxLength).
	 * 
	 * @param line
	 *            the line.
	 * @return the offset of the line.
	 */
	private int lastOffsetToMaxLength(String line) {
		int correctedLineMaxLength = preferences.getLineMaxLength();
		int tabsCountLine = tabsCount(line);
		correctedLineMaxLength -= tabsCountLine * (preferences.getTabSpaces() - 1);
		if (correctedLineMaxLength < 0)
			correctedLineMaxLength = 0;
		int offset = line.substring(0, correctedLineMaxLength).lastIndexOf(' ');
		if (getLineType(line) == FormattedObject.LINE_TYPE_NORMAL) {
			int afterPoint = 1;
			if (!preferences.isCutAfterPoint()) {
				afterPoint = 0;
			}
			int offsetPoint = line.substring(0, correctedLineMaxLength).lastIndexOf('.') + afterPoint;
			if (offsetPoint > offset)
				offset = offsetPoint;
		}
		if (offset <= tabsCountLine + 2) {
			int offsetTemp = line.substring(correctedLineMaxLength).indexOf(' ');
			if (offsetTemp > 0)
				offset = correctedLineMaxLength + offsetTemp;
		}
		if (offset <= tabsCountLine + 2)
			offset = line.length() - 1;
		return offset;
	}

	/**
	 * Gives a succession of tabulations in a string to know the indentation level when the line is cut.
	 * 
	 * @param line
	 *            the line.
	 * @return a succession of tabulations in a string.
	 */
	private static String getTabs(String line) {
		String result = "\t\t"; //$NON-NLS-1$
		int offset = 0;
		while (line.charAt(offset) == '\t') {
			result += "\t"; //$NON-NLS-1$
			offset++;
		}
		return result;
	}

	/**
	 * Initializes the code formatting.
	 * 
	 * @param parent
	 *            the root.
	 * @throws BadLocationException
	 */
	private void initialize(FormattedObject parent) throws BadLocationException {
		removeExtraSpace(parent);
	}

	/**
	 * Finalizes the code formatting.
	 * 
	 * @param parent
	 *            the document root.
	 */
	private void finalize(FormattedObject parent) {
		parent.setText(formatSpecialComments(parent));
		parent.setText(parent.getText());
		getBackCode(parent);
		String documentText = parent.getText();
		documentText = documentText.replaceAll(
				"([-]{2,})[\\s&&[^$]]*(^[-@])", "$1" + preferences.getSpacesAfterComment() + "$2"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		documentText = documentText.replaceAll("(\\S+)\\s*\\z", "$1\n"); //$NON-NLS-1$ //$NON-NLS-2$
		documentText = documentText.replaceAll("\\A\\s*(\\S+)", "$1"); //$NON-NLS-1$ //$NON-NLS-2$
		String text = ""; //$NON-NLS-1$
		for (String line : documentText.split("\n")) { //$NON-NLS-1$
			text += replaceStrings(line) + "\n"; //$NON-NLS-1$
		}
		documentText = cutLines(text);
		parent.setText(documentText);
	}

	private void getBackCode(FormattedObject parent) {
		String text = parent.getText();
		for (FormattedObject fo : parent.getChildren()) {
			getBackCode(fo);
			text = text.replace(fo.getReplacement(), fo.getText());
		}
		parent.setText(text);
	}

	/**
	 * Removes extra space in the code between elements (rules and helpers).
	 * 
	 * @param parent
	 *            the root.
	 * @throws BadLocationException
	 */
	private void removeExtraSpace(FormattedObject parent) throws BadLocationException {
		String parentText = parent.getText();
		if (parent.getEObject().equals(modelAnalyser.getRoot())) {
			for (int i = parent.getEObject().eContents().size() - 1; i >= 0; i--) {
				FormattedObject child = parent.getChild(i);
				if (child.getType() == FormattedObject.TYPE_HELPER
						|| child.getType() == FormattedObject.TYPE_QUERY
						|| child.getType() == FormattedObject.TYPE_LIBRARY || isRuleType(child.getType())) {
					EObject previousElt = modelAnalyser.getPreviousElement(child.getEObject());
					if (previousElt != null
							&& FormattedObject.typeOf(previousElt) == FormattedObject.TYPE_HELPER
							|| isRuleType(FormattedObject.typeOf(previousElt))) {
						int[] offsets = getElementOffset(child.getEObject());
						int[] offsetsPreviousElt = getElementOffset(previousElt);
						String trimedString = parentText.substring(offsetsPreviousElt[1], offsets[0]);
						trimedString = trimedString.replaceAll(
								"\\s*\n+\\s*(\\S+)", preferences.getLinesSpaces() + "\n$1"); //$NON-NLS-1$ //$NON-NLS-2$
						trimedString = trimedString.replaceAll("(\\S+)\n+\\s*(\\S+)", "$1\n$2"); //$NON-NLS-1$ //$NON-NLS-2$
						trimedString = trimedString.replaceAll("(\\S*)\\s+\\z", "$1\n"); //$NON-NLS-1$ //$NON-NLS-2$
						trimedString = trimedString.replaceAll(
								"\\A\\p{Blank}*([^\n]+)", " $1" + preferences.getLinesSpaces()); //$NON-NLS-1$ //$NON-NLS-2$
						if (trimedString.trim().equals("")) { //$NON-NLS-1$
							trimedString = "\n"; //$NON-NLS-1$
							trimedString += preferences.getLinesSpaces();
						}
						parentText = parentText.substring(0, offsetsPreviousElt[1]) + trimedString
								+ parentText.substring(offsets[0], parentText.length());
					}
				}
			}
		}
		parent.setText(parentText);
	}

	private CodeFragment initializeCodeFragment(String parentText, String childText)
			throws BadLocationException {

		int startOffset = parentText.indexOf(childText);

		String regex = "\\b" + Pattern.quote(childText) + "\\b"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(parentText);
		boolean goAhead = true;
		while (m.find() && goAhead) {
			if (!isAStringOffset(m.start(), parentText)) { // Avoid replacing in a string
				startOffset = m.start();
				goAhead = false;
			}
		}

		return new CodeFragment(childText, startOffset);
	}

	private static boolean isAStringOffset(int offset, String text) {
		String lineOfOffset = text.substring(/* lineBeginIndex */0, offset);
		return getLineType(lineOfOffset) == FormattedObject.LINE_TYPE_STRING;
	}

	private static void replaceFragment(FormattedObject parent, CodeFragment fragment)
			throws InvalidFragmentException {
		if (fragment.getInitialStart() == -1)
			throw new InvalidFragmentException();
		String result = parent.getText().substring(0, fragment.getReplacementStart());
		result += fragment.getReplacementCodeFragment();
		result += parent.getText().substring(fragment.getInitialEnd(), parent.getText().length());
		parent.setText(result);
	}

	private int[] getElementOffset(EObject obj) throws BadLocationException {
		return modelAnalyser.getHelper().getElementOffsets(obj, 0);
	}

	private String formatModule(FormattedObject parent) {
		String text = formatModuleString(parent);
		parent.setText(text);
		text = formatCreate(parent);
		parent.setText(text);
		text = formatFrom(parent);
		return text;
	}

	private String formatSpecialComments(FormattedObject parent) {
		String text = parent.getText();
		text = text.replaceAll(
				"(\n|\r\n)?\\s*--\\s*\\@(\\w+)\\s+(\\w+)\\s*=\\s*([^\n|^\r\n]*)\\s*", "$1-- @$2 $3=$4\n"); //$NON-NLS-1$ //$NON-NLS-2$

		text = text.replaceAll("(\n|\r\n)?\\s*--\\s*\\@([^\n|^\r\n]*)\\s*", "$1-- @$2\n"); //$NON-NLS-1$ //$NON-NLS-2$

		int max = text.length();

		String endSpecialCommentsRegex = "(\n|\r\n)?\\s*module|(\n|\r\n)?\\s*query|(\n|\r\n)?\\s*library";

		String[] split = text.split(endSpecialCommentsRegex);
		if (split != null && split.length > 0) {
			max = split[0].length();
		}

		String regex = "\\s*--\\s*\\@([^\n|^\r\n]*)\\s*"; //$NON-NLS-1$

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text.subSequence(0, max));

		String result = text;
		while (m.find()) {
			result = text.substring(0, m.end());
			result += preferences.getLinesAfterSpecialTags(); // Space after special tags
			result += text.substring(m.end());
		}
		return result;
	}

	private String formatModuleString(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\s*module\\s+(\\w+)\\s*;\\s*"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		String result = text;
		// TODO FORMATTER check : was "while"
		if (m.find()) {
			result = text.substring(0, m.start()).trim();
			if (!result.trim().equals("")) //$NON-NLS-1$
				result += "\n\n"; //$NON-NLS-1$
			result += "module " + m.group(1) + preferences.getEndingSemicolon(); //$NON-NLS-1$
			result += text.substring(m.end(), text.length());
		}
		return result;
	}

	private String formatCreate(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\s*create\\s+(" + FormattedObject.RPLCMT_RGX + "(?:\\s*,\\s*" + FormattedObject.RPLCMT_RGX + ")*)\\s+(from|refining)"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		String result = text;
		while (m.find()) {
			result = text.substring(0, m.start());
			result += preferences.getLinesAfterModule(); // Space after MODULE declaration
			String outModels = m.group(1);
			outModels = outModels.replaceAll("\\s*([.]*)\\s*,", "$1,"); //$NON-NLS-1$ //$NON-NLS-2$
			outModels = outModels.replaceAll(",\\s*([.]*)\\s*", preferences.getComa() + "$1"); //$NON-NLS-1$ //$NON-NLS-2$
			outModels = outModels.replaceAll("\\s*\\z", ""); //$NON-NLS-1$ //$NON-NLS-2$
			result += "\ncreate " + outModels + " " + m.group(2); //$NON-NLS-1$ //$NON-NLS-2$
			result += text.substring(m.end(), text.length());
		}
		return result;
	}

	private String formatFrom(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\s*(from|refining)\\s+(" + FormattedObject.RPLCMT_RGX + "\\s*(?:,\\s*" + //$NON-NLS-1$ //$NON-NLS-2$
				FormattedObject.RPLCMT_RGX + "\\s*)*)\\s*;\\s*"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		String result = text;
		while (m.find()) {
			result = text.substring(0, m.start());
			String inModels = m.group(2);
			inModels = inModels.replaceAll("\\s*([.]*)\\s*,", "$1,"); //$NON-NLS-1$ //$NON-NLS-2$
			inModels = inModels.replaceAll(",\\s*([.]*)\\s*", preferences.getComa() + "$1"); //$NON-NLS-1$ //$NON-NLS-2$
			inModels = inModels.replaceAll("\\s*\\z", ""); //$NON-NLS-1$ //$NON-NLS-2$
			result += " " + m.group(1) + " " + inModels + preferences.getEndingSemicolon() + "\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			result += preferences.getLinesAfterCreateFrom(); // Space after create ... from declaration
			result += text.substring(m.end(), text.length());
		}
		return result;
	}

	private String formatOclModel(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(\\w+)\\s*\\:\\s*(\\w+)\\z"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.group(1) + preferences.getColon() + m.group(2);
		}
		return text;
	}

	private String formatHelper(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\Ahelper(?:\\s+context\\s+(\\S+))?\\s+def\\s*\\:\\s*(\\p{ASCII}*\\S+)\\s*;\\z"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			String body = m.group(2);
			if (getLineType(body) == FormattedObject.LINE_TYPE_COMMENT
					|| getLineType(body) == FormattedObject.LINE_TYPE_HELPER_COMMENT)
				body += "\n\t"; //$NON-NLS-1$
			if (m.group(1) != null)
				text = "helper context " + m.group(1) + " def" + preferences.getColon() + body + preferences.getEndingSemicolon();// + preferences.getEndingEqual() + "\n\t" + body + preferences.getEndingSemicolon(); //$NON-NLS-1$ //$NON-NLS-2$
			else
				text = "helper def" + preferences.getColon() + body + preferences.getEndingSemicolon();// + preferences.getEndingEqual() + "\n\t" + body + preferences.getEndingSemicolon(); //$NON-NLS-1$
		}
		return text;
	}

	private String formatRule(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(lazy|abstract)?\\s*rule\\s+(\\w+)\\s*\\{\\s*(\\p{ASCII}*)\\s*\\}\\z"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			String body = ""; //$NON-NLS-1$
			String regex2 = "\\A(" + FormattedObject.RPLCMT_RGX + ")\\s*(?:using\\s*\\{(\\s*(?:\\s*" + //$NON-NLS-1$ //$NON-NLS-2$
					FormattedObject.RPLCMT_RGX + ")*\\s*)\\})?\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*(" + //$NON-NLS-1$ //$NON-NLS-2$
					FormattedObject.RPLCMT_RGX + ")?\\s*\\z"; //$NON-NLS-1$
			Pattern p2 = Pattern.compile(regex2);
			Matcher m2 = p2.matcher(m.group(3));
			while (m2.find()) {
				body += m2.group(1) + "\n\t"; //$NON-NLS-1$
				if (m2.group(2) != null) {
					body += "using" + preferences.getRuleBrace(parent.getIndentationLevel() + 1); //$NON-NLS-1$
					String usings = m2.group(2).replaceAll(
							"\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*", "\n\t\t$1"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					body += usings + "\n\t}\n\t"; //$NON-NLS-1$
				}
				if (m2.group(3) != null) {
					body += m2.group(3);
				}
				if (m2.group(4) != null) {
					body += "\n\t" + m2.group(4); //$NON-NLS-1$
				}
			}
			if (m.group(1) == null)
				text = "rule " + m.group(2) + preferences.getRuleBrace(parent.getIndentationLevel()) + "\n\t" + body + "\n}"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			else
				text = m.group(1)
						+ " rule " + m.group(2) + preferences.getRuleBrace(parent.getIndentationLevel()) + "\n\t" + body + "\n}"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return text;
	}

	private String formatCalledRule(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\Aentrypoint\\s+rule\\s+(\\w+)\\s*(\\([\\p{ASCII}]*\\))\\s*\\{\\s*([\\p{ASCII}[\\S]]*)\\s*\\}\\z"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			String body = ""; //$NON-NLS-1$
			String regex2 = "(?:using\\s*\\{(\\s*(?:\\s*" + FormattedObject.RPLCMT_RGX + ")*\\s*)\\})?\\s*(" + //$NON-NLS-1$ //$NON-NLS-2$
					FormattedObject.RPLCMT_RGX + ")\\s*(" + FormattedObject.RPLCMT_RGX + ")?\\s*\\z"; //$NON-NLS-1$ //$NON-NLS-2$
			Pattern p2 = Pattern.compile(regex2);
			Matcher m2 = p2.matcher(m.group(3));
			while (m2.find()) {
				if (m2.group(1) != null) {
					body += "using" + preferences.getRuleBrace(parent.getIndentationLevel() + 1); //$NON-NLS-1$
					String usings = m2.group(1).replaceAll(
							"\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*", "\n\t\t$1"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					body += usings + "\n\t}\n\t"; //$NON-NLS-1$
				}
				if (m2.group(2) != null) {
					body += m2.group(2);
				}
				if (m2.group(3) != null) {
					body += "\n\t" + m2.group(3); //$NON-NLS-1$
				}
			}
			text = "entrypoint rule " + m.group(1) + formatOperationParameters(m.group(2)) + preferences.getRuleBrace(parent.getIndentationLevel()) + "\n\t" + body + "\n}"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return text;
	}

	private String formatOperatorCallExp(FormattedObject parent) {
		String text = parent.getText();
		String operators = "\\=|\\+|\\*|/|<=|>=|<>|<|-|>"; //$NON-NLS-1$
		String andOr = "and|or"; //$NON-NLS-1$
		String not = "not"; //$NON-NLS-1$
		//String minusGreater = "-|>"; //$NON-NLS-1$

		text = text
				.replaceAll(
						"\\A("	+ FormattedObject.RPLCMT_RGX + ")\\s*(" + operators + ")\\s*(" + FormattedObject.RPLCMT_RGX + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								")\\z",
						"$1"	+ preferences.getBeforeOperator(parent.getIndentationLevel() + 1) + "$2" + preferences.getAfterOperator(parent.getIndentationLevel()) + "$3"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		text = text.replaceAll("\\A(" + FormattedObject.RPLCMT_RGX + ")\\s+(" + andOr + ")\\s+(" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				FormattedObject.RPLCMT_RGX + ")\\z", "$1 $2 $3"); //$NON-NLS-1$ //$NON-NLS-2$
		text = text.replaceAll("\\A(" + not + ")\\s+(" + //$NON-NLS-1$ //$NON-NLS-2$
				FormattedObject.RPLCMT_RGX + ")\\z", "$1 $2"); //$NON-NLS-1$ //$NON-NLS-2$
		return text;
	}

	private String formatParameter(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A([\\w]+)\\s*\\:\\s*(" + FormattedObject.RPLCMT_RGX + ")\\z"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.group(1) + preferences.getColon() + m.group(2);
		}
		return text;
	}

	private String formatBinding(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A([\\w]+)\\s*<-\\s*(" + FormattedObject.RPLCMT_RGX + ")\\z"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.group(1) + preferences.getBindingArrow() + m.group(2);
		}
		return text;
	}

	private String formatInPattern(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\Afrom\\s+(" + FormattedObject.RPLCMT_RGX + ")\\s*(?:\\(\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*\\))?\\s*\\z"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = "from\n\t\t" + m.group(1); //$NON-NLS-1$
			if (m.group(2) != null) {
				text += " (\n\t\t\t" + m.group(2) + "\n\t\t)"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return text;
	}

	private String formatRuleVariableDeclaration(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A([\\w]+)\\s*\\:\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*=\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*;\\z"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.group(1) + preferences.getColon() + m.group(2) + preferences.getEqual() + m.group(3)
					+ preferences.getEndingSemicolon();
		}
		return text;
	}

	private String formatOutPattern(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		String result = "to\n\t\t"; //$NON-NLS-1$
		int i = 0;
		while (m.find()) {
			if (i++ > 0)
				result += preferences.getEndingComa(2);
			result += m.group(1);
		}
		return result;
	}

	private String formatCollectionType(FormattedObject parent) {
		String text = parent.getText();
		String collections = "Sequence|TupleType|Set|Bag|OrderedSet|Map|Collection"; //$NON-NLS-1$
		String regex = "\\A(" + collections + ")\\s*\\(\\s*([\\p{ASCII}]*\\S+)\\s*\\)\\z"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.group(1) + formatOperationParameters("(" + m.group(2) + ")"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return text;
	}

	private String formatOperation(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(\\w+)\\s*(\\([\\p{ASCII}]*\\))\\s*\\:\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*\\=\\s*(" + FormattedObject.RPLCMT_RGX + ")\\z"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.group(1) + formatOperationParameters(m.group(2)) + preferences.getColon() + m.group(3)
					+ preferences.getEndingEqual() + "\n\t" + m.group(4); //$NON-NLS-1$
		}
		return text;
	}

	private String formatAttribute(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(\\w+)\\s*\\:\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*\\=\\s*(" + FormattedObject.RPLCMT_RGX + ")\\z"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.group(1) + preferences.getColon() + m.group(2) + preferences.getEndingEqual()
					+ "\n\t" + m.group(3); //$NON-NLS-1$
		}
		return text;
	}

	private String formatTupleExp(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\s*(\\w+)(?:\\s*\\:\\s*(" + FormattedObject.RPLCMT_RGX + "))?\\s*(?:\\=\\s*(" + FormattedObject.RPLCMT_RGX + "))"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		int i = 0;
		String result = "Tuple" + preferences.getOpeningCollectionBrace(); //$NON-NLS-1$
		while (m.find()) {
			if (i++ > 0)
				result += preferences.getComa();
			result += m.group(1);
			if (m.group(2) != null)
				result += preferences.getColon() + m.group(2);
			if (m.group(3) != null)
				result += preferences.getEqual() + m.group(3);
		}
		result += preferences.getClosingCollectionBrace();
		return result;
	}

	private String formatCollectionExp(FormattedObject parent) {
		String text = parent.getText();
		String collections = "Sequence|Set|Bag|OrderedSet|Map|Collection"; //$NON-NLS-1$
		String regex = "\\A(" + collections + ")\\s*\\{\\s*([\\p{ASCII}]*\\S+)\\s*\\}\\z"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			String structs = m.group(2);
			structs = structs.replaceAll("\\s*([.]*)\\s*,", "$1,"); //$NON-NLS-1$ //$NON-NLS-2$
			structs = structs.replaceAll(
					",\\s*([.]*)\\s*", preferences.getEndingComa(parent.getIndentationLevel() + 2) + "$1"); //$NON-NLS-1$ //$NON-NLS-2$
			structs = structs.replaceAll("\\s*\\z", ""); //$NON-NLS-1$ //$NON-NLS-2$
			text = m.group(1) + preferences.getOpeningCollectionBrace() + structs
					+ preferences.getClosingCollectionBrace();
		}
		return text;
	}

	private String formatCollectionOperationCallExp(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(" + FormattedObject.RPLCMT_RGX + ")\\s*(->|\\.)\\s*(\\w+)\\s*([\\p{ASCII}]+)\\z"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			String callingObject = preferences.getPoint();
			if (m.group(2).equals("->")) //$NON-NLS-1$
				callingObject = preferences.getCallingArrow();
			text = m.group(1) + callingObject + m.group(3) + formatOperationParameters(m.group(4));
		}
		return text;
	}

	private String formatNavigationOrAttributeCallExp(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(" + FormattedObject.RPLCMT_RGX + ")\\s*\\.\\s*(\\S+[\\p{ASCII}]*)\\z"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.group(1) + preferences.getPoint() + m.group(2);
		}
		return text;
	}

	private String formatLibrary(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\s*library\\s+(\\w+)\\s*;\\s*"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = "\n\nlibrary " + m.group(1) + preferences.getEndingSemicolon() + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return text;
	}

	private String formatQuery(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\s*query\\s+(\\w+)\\s*\\=\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*;\\s*"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.replaceAll("\n\nquery " + m.group(1) + preferences.getEqual() + m.group(2) + preferences.getEndingSemicolon() + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return text;
	}

	private String formatIteratorExp(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(" + FormattedObject.RPLCMT_RGX + ")\\s*->\\s*(\\w+)\\s*\\(\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*(?:;\\s*(\\w+)\\s*\\:\\s*(" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				FormattedObject.RPLCMT_RGX + ")\\s*=\\s*(" + FormattedObject.RPLCMT_RGX + "))?\\s*\\|\\s*(" + //$NON-NLS-1$ //$NON-NLS-2$
				FormattedObject.RPLCMT_RGX + ")\\s*\\)\\z"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			if (m.group(4) != null)
				text = m.group(1) + preferences.getCallingArrow() + m.group(2)
						+ preferences.getOpeningBracket() + m.group(3) + preferences.getSemicolon()
						+ m.group(4) + preferences.getColon() + m.group(5) + preferences.getEqual()
						+ m.group(6) + preferences.getPipe() + m.group(7) + preferences.getClosingBracket();
			else
				text = m.group(1) + preferences.getCallingArrow() + m.group(2)
						+ preferences.getOpeningBracket() + m.group(3) + preferences.getPipe() + m.group(7)
						+ preferences.getClosingBracket();
		}
		return text;
	}

	private String formatIfExp(FormattedObject parent) {
		String text = parent.getText();
		int indentationLevel = parent.getIndentationLevel();
		String regex = "\\Aif\\s*(\\(\\s*)?(" + FormattedObject.RPLCMT_RGX + ")(\\s*\\))?\\s*then\\s*(\\(\\s*)?(" + FormattedObject.RPLCMT_RGX + //$NON-NLS-1$ //$NON-NLS-2$
				")(\\s*\\))?\\s*else\\s*(\\(\\s*)?(" + FormattedObject.RPLCMT_RGX + ")(\\s*\\))?\\s*endif\\z"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = "if " + getBracket(m.group(1)) + m.group(2) + getBracket(m.group(3)) + " then\n\t" + AtlCodeFormatterPreferences.getChars(indentationLevel, '\t') //$NON-NLS-1$ //$NON-NLS-2$
					+ getBracket(m.group(4))
					+ m.group(5)
					+ getBracket(m.group(6))
					+ "\n" + AtlCodeFormatterPreferences.getChars(indentationLevel, '\t') //$NON-NLS-1$
					+ "else\n\t" + AtlCodeFormatterPreferences.getChars(indentationLevel, '\t') //$NON-NLS-1$
					+ getBracket(m.group(7)) + m.group(8) + getBracket(m.group(9))
					+ "\n" + AtlCodeFormatterPreferences.getChars(indentationLevel, '\t') + "endif"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return text;
	}

	private String formatForExp(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\Afor\\s*\\(\\s*(OBJECT\\{\\d+\\})\\s*in\\s*(OBJECT\\{\\d+\\})\\)\\s*\\{\\s*(OBJECT\\{\\d+\\})?\\s*\\}\\z"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			String body = m.group(3);
			if (body == null)
				body = ""; //$NON-NLS-1$
			text = "for" + preferences.getOpeningBracket() + m.group(1) + " in " + m.group(2) + preferences.getClosingBracket() + //$NON-NLS-1$ //$NON-NLS-2$
					preferences.getRuleBrace(parent.getIndentationLevel())
					+ "\n" + AtlCodeFormatterPreferences.getChars(parent.getIndentationLevel() + 1, '\t') + //$NON-NLS-1$
					body
					+ "\n" + AtlCodeFormatterPreferences.getChars(parent.getIndentationLevel(), '\t') + "}"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return text;
	}

	private String formatActionBlock(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\Ado\\s*\\{\\s*(\\s*[" + FormattedObject.RPLCMT_RGX + "\\s*(?:;)?]*)\\s*\\}\\z"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = "do" + preferences.getRuleBrace(parent.getIndentationLevel()); //$NON-NLS-1$
			String regex2 = "\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*(;)?\\s*"; //$NON-NLS-1$ //$NON-NLS-2$
			Pattern p2 = Pattern.compile(regex2);
			Matcher m2 = p2.matcher(m.group(1));
			while (m2.find()) {
				text += "\n" + AtlCodeFormatterPreferences.getChars(parent.getIndentationLevel() + 1, '\t') + m2.group(1); //$NON-NLS-1$
				if (m2.group(2) != null)
					text += preferences.getSemicolon();
			}
			text += "\n\t}"; //$NON-NLS-1$
		}
		return text;
	}

	private String formatOclModelElement(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(\\w+)\\s*!\\s*(\\w+)\\z"; //$NON-NLS-1$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.group(1) + preferences.getExclamation() + m.group(2);
		}
		return text;
	}

	private String formatSimpleInPattern(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(\\w+)\\s*\\:\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*(?:in\\s+(\\w+))?\\z"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = m.group(1) + preferences.getColon() + m.group(2);
			if (m.group(3) != null)
				text += " in " + m.group(3); //$NON-NLS-1$
		}
		return text;
	}

	private String formatLetExp(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\Alet\\s*(\\w+)\\s*\\:\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*=\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*in\\s*(" + FormattedObject.RPLCMT_RGX + ")\\z"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			text = "let " + m.group(1) + preferences.getColon() + m.group(2) + preferences.getEndingEqual() + "\n" + //$NON-NLS-1$ //$NON-NLS-2$
					AtlCodeFormatterPreferences.getChars(parent.getIndentationLevel() + 1, '\t') + m.group(3)
					+ "\n" + AtlCodeFormatterPreferences.getChars(parent.getIndentationLevel(), '\t') + //$NON-NLS-1$
					"in\n" + AtlCodeFormatterPreferences.getChars(parent.getIndentationLevel() + 1, '\t')
					+ m.group(4); //$NON-NLS-1$

		}
		return text;
	}

	private String formatSimpleOutPatternElement(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(\\w+)\\s*\\:\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s*(?:in\\s+(\\w+))?\\s*(?:mapsTo\\s+(\\w+))?\\s*(\\(\\s*(?:" + FormattedObject.RPLCMT_RGX //$NON-NLS-1$ //$NON-NLS-2$
				+ "(?:\\s*,\\s*" + FormattedObject.RPLCMT_RGX + ")*)\\s*\\)|\\(\\s*\\)|\\((\\s*--[\\p{ASCII}]*\\s*)\\))?\\z"; //$NON-NLS-1$ //$NON-NLS-2$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		String result = ""; //$NON-NLS-1$
		while (m.find()) {
			result += m.group(1) + preferences.getColon() + m.group(2);
			if (m.group(3) != null)
				result += " in " + m.group(3); //$NON-NLS-1$
			if (m.group(4) != null)
				result += " mapsTo " + m.group(4); //$NON-NLS-1$
			if (m.group(5) != null)
				result += formatBindingsOutPatterns(m.group(5), 3);
		}
		/*
		 * if(result.equals("")) //$NON-NLS-1$ return text;
		 */
		return result;
	}

	private String formatForEachOutPatternElement(FormattedObject parent) {
		String text = parent.getText();
		String regex = "\\A(\\w+)\\s*\\:\\s*distinct\\s+(" + FormattedObject.RPLCMT_RGX + ")\\s+foreach\\s*\\(\\s*(" + FormattedObject.RPLCMT_RGX + ")\\s+in\\s+(" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				FormattedObject.RPLCMT_RGX
				+ ")\\s*\\)\\s*\\(\\s*((?:" + FormattedObject.RPLCMT_RGX + ")(\\s*,\\s*" + FormattedObject.RPLCMT_RGX + ")*)?\\s*\\)\\z"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		String result = text;
		while (m.find()) {
			result = m.group(1) + preferences.getColon()
					+ "distinct " + m.group(2) + " foreach" + preferences.getOpeningBracket() + //$NON-NLS-1$ //$NON-NLS-2$
					m.group(3) + " in " + m.group(4) + preferences.getClosingBracket() + " (\n"; //$NON-NLS-1$ //$NON-NLS-2$
			if (m.group(5) != null) {
				result += AtlCodeFormatterPreferences.getChars(parent.getIndentationLevel() + 1, '\t')
						+ formatBindingsOutPatterns(m.group(5), parent.getIndentationLevel() + 1);
			}
			result += "\n" + AtlCodeFormatterPreferences.getChars(parent.getIndentationLevel(), '\t') + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return result;
	}

	private String formatOperationParameters(String text) {
		String parameters = text.replaceAll("\\s*([.]*)\\s*,", "$1,"); //$NON-NLS-1$ //$NON-NLS-2$
		parameters = parameters.replaceAll("\\A\\(\\s*", preferences.getOpeningBracket()); //$NON-NLS-1$
		parameters = parameters.replaceAll("\\s*\\)\\z", preferences.getClosingBracket()); //$NON-NLS-1$
		parameters = parameters.replaceAll(",\\s*([.]*)\\s*", preferences.getComa() + "$1"); //$NON-NLS-1$ //$NON-NLS-2$
		return parameters;
	}

	private String formatBindingsOutPatterns(String text, int tab) {
		String parameters = text.replaceAll("\\s*([.]*)\\s*,", "$1,"); //$NON-NLS-1$ //$NON-NLS-2$
		parameters = parameters.replaceAll(
				"\\A\\(\\s*", " (\n" + AtlCodeFormatterPreferences.getChars(tab, '\t')); //$NON-NLS-1$ //$NON-NLS-2$
		parameters = parameters.replaceAll(
				"\\s*\\)\\z", "\n" + AtlCodeFormatterPreferences.getChars(tab - 1, '\t') + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		parameters = parameters.replaceAll(",\\s*([.]*)\\s*", preferences.getEndingComa(tab) + "$1"); //$NON-NLS-1$ //$NON-NLS-2$
		return parameters;
	}

	private String getBracket(String bracket) {
		if (bracket == null)
			return ""; //$NON-NLS-1$
		if (bracket.trim().equals("(")) //$NON-NLS-1$
			return preferences.getOpeningBracket();
		if (bracket.trim().equals(")")) //$NON-NLS-1$
			return preferences.getClosingBracket();
		return ""; //$NON-NLS-1$
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
		if (self == null)
			return null;
		EStructuralFeature feature = self.eClass().getEStructuralFeature(featureName);
		if (feature != null) {
			return self.eGet(feature);
		}
		return null;
	}

}
