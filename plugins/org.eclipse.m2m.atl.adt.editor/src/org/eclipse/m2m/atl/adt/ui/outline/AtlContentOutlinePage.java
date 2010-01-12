/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.outline;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.common.AtlNbCharFile;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

public class AtlContentOutlinePage extends AtlOutlinePage {

	/**
	 * perspective listener
	 */
	private class PerspectiveListener implements IPerspectiveListener {

		/**
		 * @see org.eclipse.ui.IPerspectiveListener#perspectiveActivated(org.eclipse.ui.IWorkbenchPage,
		 *      org.eclipse.ui.IPerspectiveDescriptor)
		 */
		public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
			if (page == getSite().getPage()) {
				int newDepth = computeDepth(perspective);
				if (depth != newDepth) {
					depth = newDepth;
					doSetSelection(cursorPosition);
				}
			}
		}

		/**
		 * @see org.eclipse.ui.IPerspectiveListener#perspectiveChanged(org.eclipse.ui.IWorkbenchPage,
		 *      org.eclipse.ui.IPerspectiveDescriptor, java.lang.String)
		 */
		public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective,
				String changeId) {
			// do nothing
		}

	}

	/** The outline view context menu id. May be used for extensions by other plugins */
	public static final String ATL_OUTLINE_VIEW_CONTEXT_MENU_ID = "org.eclipse.m2m.atl.adt.outline.contextMenu"; //$NON-NLS-1$

	/** The wake up frequency of the background thread in charge of the refresh of the outline tree viewer */
	// private static final int REFRESH_PERIOD = 5000;
	/* Sorter enabling sorting the content of the tree viewer */
	private ViewerSorter alphabeticalSorter, defaultSorter;

	/**
	 * A description of the current cursor position of the associated editor
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#getCursorPosition()
	 */
	private String cursorPosition;

	/**
	 * max depth of research in the outline tree. It is different according to the current perspective. it
	 * equals to -1 in the debug perspective and 1 in the others. TODO put in a preference page
	 */
	private int depth = 1;

	/**
	 * <p>
	 * Each ATL element has a location String that indicates where it is located in the source file.
	 * </p>
	 * <p>
	 * <code>AtlNbCharFile</code> class is useful to get index char start and index char end from the location
	 * string
	 * </p>
	 * 
	 * @see AtlNbCharFile
	 */
	private static AtlNbCharFile help;

	/** Filter enabling filtering the display of the tree viewer. */
	private ViewerFilter helperFilter;

	private ViewerFilter ruleFilter;

	private ViewerFilter defaultFilter;

	/** <code>true</code> if the tree viewer input has been set. */
	private boolean inputSet;

	/** The perspective listener for the current page. */
	private PerspectiveListener perspectiveListener;

	// /* Actions that will be used in the toolBar and menu bar */
	// private Action refreshItemAction;

	private Action filterHelperAction;

	private Action filterRuleAction;

	private Action sorterAction;

	private Action addBreakPointAction;

	private Action cutAction;

	private Action copyAction;

	private Action pasteAction;

	/** The root of the treeViewer. */
	private Root root;

	/** The element currently selected in the tree viewer. */
	private EObject selectedEo;

	/** The ATL editor associated with this outline. */
	private AtlEditor textEditor;

	/**
	 * @param textEditor
	 * @param editorInput
	 * @param documentProvider
	 */
	public AtlContentOutlinePage(ITextEditor textEditor, IEditorInput editorInput,
			IDocumentProvider documentProvider) {
		super();
		this.textEditor = (AtlEditor)textEditor;
	}

	/**
	 * <p>
	 * Adds a perspective listener to the perspective service
	 * </p>
	 * <p>
	 * This is useful when some parameters need to be adjusted according to the current perspective. In the
	 * present case the <code>depth</code> is different in the debug perspective.
	 * </p>
	 * 
	 * @param l
	 *            the perspective listener to add
	 */
	private void addPerspectiveListener(IPerspectiveListener l) {
		getSite().getPage().getWorkbenchWindow().addPerspectiveListener(l);
	}

	/**
	 * computes the <code>depth</code> for the current perspective. The depth varies according to the
	 * perspective
	 * 
	 * @param ipd
	 *            the perspective for which to compute the depth
	 */
	private int computeDepth(IPerspectiveDescriptor ipd) {
		if (IDebugUIConstants.ID_DEBUG_PERSPECTIVE.equals(ipd.getId())) {
			return -1;
		}

		return 1;
	}

	/**
	 * Creates the actions that will be used in the toolbar of the view and in the context menu of the tree
	 * viewer.
	 */
	private void createActions() {
		cutAction = new Action("Cut") { //$NON-NLS-1$
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {

			}
		};
		cutAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("cut.gif")); //$NON-NLS-1$

		copyAction = new Action("Copy") { //$NON-NLS-1$
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {

			}
		};
		copyAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("copy.gif")); //$NON-NLS-1$

		pasteAction = new Action("Paste") { //$NON-NLS-1$
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {

			}
		};
		pasteAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("paste.gif")); //$NON-NLS-1$

		addBreakPointAction = new Action("Toggle breakpoint") { //$NON-NLS-1$
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {
				IStructuredSelection is = (IStructuredSelection)treeViewer.getSelection();
				EObject element = (EObject)is.getFirstElement();
				try {
					textEditor.toggleLineBreakpoints(element);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		};
		addBreakPointAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("brkp_obj.gif")); //$NON-NLS-1$

		//		refreshItemAction = new Action("Refresh") { //$NON-NLS-1$
		// /**
		// * {@inheritDoc}
		// *
		// * @see org.eclipse.jface.action.Action#run()
		// */
		// @Override
		// public void run() {
		// setUnit();
		// }
		// };
		//		refreshItemAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("refresh.gif")); //$NON-NLS-1$
		//		refreshItemAction.setToolTipText("refresh outline"); //$NON-NLS-1$

		filterHelperAction = new Action("Hide Helpers", Action.AS_CHECK_BOX) { //$NON-NLS-1$
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {
				updateFilters(filterHelperAction);
			}
		};
		filterHelperAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("hideHelper.gif")); //$NON-NLS-1$
		filterHelperAction.setToolTipText("Hide helpers"); //$NON-NLS-1$

		filterRuleAction = new Action("Hide rules", Action.AS_CHECK_BOX) { //$NON-NLS-1$
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {
				updateFilters(filterRuleAction);
			}
		};
		filterRuleAction.setToolTipText("Hide the rules"); //$NON-NLS-1$
		filterRuleAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("hideMatchedRule.gif")); //$NON-NLS-1$

		sorterAction = new Action("Alphabetical sort", Action.AS_CHECK_BOX) { //$NON-NLS-1$
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {
				updateSorter(sorterAction);
			}
		};
		sorterAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("alphab_sort.gif")); //$NON-NLS-1$
		sorterAction.setToolTipText("sort alphabetically"); //$NON-NLS-1$
	}

	/**
	 * Creates a context menu for this view.
	 */
	private void createContextMenu() {
		// Create menu manager.
		MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr) {
				fillContextMenu(mgr);
			}
		});
		// Create menu.
		Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);
		// Register menu for extension.
		getSite().registerContextMenu(ATL_OUTLINE_VIEW_CONTEXT_MENU_ID, menuMgr, this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.outline.AtlOutlinePage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite arg0) {
		super.createControl(arg0);
		root = new Root();
		// Add all listeners that were added when the tree viewer was null
		Object[] listeners = selectionChangedListeners.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			selectionChangedListeners.remove(listeners[i]);
			treeViewer.addPostSelectionChangedListener((ISelectionChangedListener)listeners[i]);
		}
		treeViewer.setContentProvider(new AtlContentProvider());
		treeViewer.setLabelProvider(new AtlLabelProvider());
		createActions();
		createContextMenu();
		createToolbar();
		createMenu();
		createFiltersAndSorters();
		setUnit();
		treeViewer.addFilter(defaultFilter);
		treeViewer.setSorter(defaultSorter);
		// Necessary so that the PropertySheetView hears about selections in the treeViewer
		getSite().setSelectionProvider(treeViewer);
		this.perspectiveListener = new PerspectiveListener();
		addPerspectiveListener(perspectiveListener);
		this.depth = computeDepth(getCurrentPerspective());
	}

	/**
	 * Creates the filters and sorters.
	 */
	public void createFiltersAndSorters() {
		helperFilter = new HideHelperFilter();
		ruleFilter = new HideRuleFilter();
		defaultFilter = new DefaultFilter();
		alphabeticalSorter = new AlphabeticalSorter();
		defaultSorter = new DefaultSorter();
	}

	/**
	 * Creates a menu (for the view) with the same actions than the toolbar.
	 */
	private void createMenu() {
		IMenuManager mgr = getSite().getActionBars().getMenuManager();
		// mgr.add(refreshItemAction);
		mgr.add(filterHelperAction);
		mgr.add(filterRuleAction);
		mgr.add(sorterAction);
	}

	/**
	 * Creates a toolbar (for the view) with a refresh button and buttons to filter and sort the contents of
	 * the tree viewer.
	 */
	private void createToolbar() {
		IToolBarManager mgr = getSite().getActionBars().getToolBarManager();
		// mgr.add(refreshItemAction);
		mgr.add(filterHelperAction);
		mgr.add(filterRuleAction);
		mgr.add(sorterAction);
	}

	private void doSetSelection(String currentCursorPosition) {
		if (!(currentCursorPosition == null || treeViewer.getTree().isDisposed())) {
			this.cursorPosition = currentCursorPosition;
			Root input = (Root)treeViewer.getInput();
			if (input != null) {
				EObject unit = input.getUnit();
				int cursorIndexChar = help.getIndex(currentCursorPosition);
				if (cursorIndexChar == -1) {
					return;
				}
				this.selectedEo = unit;
				setSelection(unit, cursorIndexChar, 0);
				treeViewer.collapseAll();
				treeViewer.expandToLevel(2);
				showItem(selectedEo);
			}
		}
	}

	/**
	 * Fills the context menu with actions that were previously created.
	 * 
	 * @param mgr
	 *            the menu manager
	 */
	private void fillContextMenu(IMenuManager mgr) {
		mgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		mgr.add(cutAction);
		mgr.add(copyAction);
		mgr.add(pasteAction);
		mgr.add(new Separator());
		mgr.add(addBreakPointAction);
		mgr.add(new Separator());
		// MenuManager refactor = new MenuManager("Refactor");
		// refactor.add(renameItemAction);
		// mgr.add(refactor);
	}

	/**
	 * Returns the perspective descriptor of the current perspective.
	 * 
	 * @return the perspective descriptor of the current perspective
	 */
	private IPerspectiveDescriptor getCurrentPerspective() {
		return getSite().getPage().getPerspective();
	}

	/**
	 * Return an array with two value. first value : index of start char second value : index of end char.
	 * 
	 * @param eo
	 *            The EObject for which to compute index of end/start char
	 * @return return an array with two value. first value : index of start char second value : index of end
	 *         char
	 */
	private static int[] getPos(EObject eo) {
		String location = (String)eo.eGet(AtlEMFConstants.sfLocation);
		if (location == null) {
			return null;
		}
		int[] pos = help.getIndexChar(location);
		return pos;
	}

	/**
	 * Initializes the <code>AtlNbCharFile</code> object used to convert the location string and passes it to
	 * the <code>DefaultSorter</code> object.
	 */
	private void initAtlNbCharFile(String content) {
		help = new AtlNbCharFile(toInputStream(content));
		((DefaultSorter)defaultSorter).setHelp(help);
		textEditor.setHelp(help);
	}

	/**
	 * Sets the Unit of the input of the tree Viewer.
	 */
	public void setUnit() {
		EObject eo = textEditor.getSourceManager().getModel();
		String newContent = textEditor.getDocumentProviderContent();
		if (eo != null) {
			root.setUnit(eo);
			if (!inputSet) {
				treeViewer.setInput(root);
				inputSet = true;
			}
			initAtlNbCharFile(newContent);
			treeViewer.refresh(root);
			treeViewer.expandToLevel(2);
		}
	}

	/**
	 * Updates the tree viewer selection according to the editor cursor position.
	 */
	private void setSelection(EObject input, int cursorIndexChar, int currentLevel) {
		if (input == null || input.eContents() == null || input.eContents().isEmpty()) {
			return;
		}

		Object[] contents = input.eContents().toArray();
		for (int i = 0; i < contents.length; i++) {
			EObject eo = (EObject)contents[i];
			int[] pos = getPos(eo);
			if (pos == null) { // some EObject define no location
				continue;
			}

			int eoStartChar = pos[0];
			int eoEndChar = pos[1];
			if (eoStartChar <= cursorIndexChar && eoEndChar >= cursorIndexChar) {
				this.selectedEo = eo;
				if ((currentLevel + 1 < depth) || (depth == -1)) {
					setSelection(eo, cursorIndexChar, currentLevel + 1);
				}

				break;
			}
		}
	}

	/**
	 * Sets the selection to the given cursorPosition.
	 * 
	 * @param currentCursorPosition
	 *            the cursor position
	 */
	public void setSelection(String currentCursorPosition) {
		doSetSelection(currentCursorPosition);
	}

	/**
	 * Highlights the given item in the tree viewer and makes it visible to the user, scrolling the tree
	 * viewer if necessary. And adjusts the highlighted range in the associated editor.
	 * 
	 * @param element
	 *            the element to show in the tree viewer
	 */
	private void showItem(EObject element) {
		int[] pos = getPos(element);
		if (pos != null) {
			if (pos[1] - pos[0] > 0) {
				textEditor.setHighlightRange(pos[0], pos[1] - pos[0], false);
			}
		}
		treeViewer.setSelection(new StructuredSelection(element), true);
	}

	/**
	 * Converts from <code>String</code> to <code>InputStream</code>.
	 * 
	 * @param contents
	 *            the <code>String</code> to convert
	 * @return the created InputStream
	 */
	private InputStream toInputStream(String contents) {
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * Updates the filters of the tree viewer Multiple filters can be enabled at a time.
	 * 
	 * @param actionParam
	 *            the action
	 */
	protected void updateFilters(Action actionParam) {
		if (actionParam == filterHelperAction) {
			if (actionParam.isChecked()) {
				treeViewer.addFilter(helperFilter);
			} else {
				treeViewer.removeFilter(helperFilter);
			}
		} else if (actionParam == filterRuleAction) {
			if (actionParam.isChecked()) {
				treeViewer.addFilter(ruleFilter);
			} else {
				treeViewer.removeFilter(ruleFilter);
			}
		}
	}

	/**
	 * Updates the sorter of the tree viewer One sorter can be enabled at a time.
	 * 
	 * @param actionParam
	 *            the action
	 */
	protected void updateSorter(Action actionParam) {
		if (actionParam == sorterAction) {
			if (actionParam.isChecked()) {
				treeViewer.setSorter(alphabeticalSorter);
			} else {
				treeViewer.setSorter(defaultSorter);
			}
		}
	}

}
