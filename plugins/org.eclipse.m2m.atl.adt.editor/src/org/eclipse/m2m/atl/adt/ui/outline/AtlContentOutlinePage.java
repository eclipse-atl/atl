/*
 * Created on 17 mai 2004
 */
package org.eclipse.m2m.atl.adt.ui.outline;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IResource;
import org.eclipse.debug.core.DebugException;
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
import org.eclipse.m2m.atl.adt.debug.core.AtlBreakpoint;
import org.eclipse.m2m.atl.adt.ui.AtlUIPlugin;
import org.eclipse.m2m.atl.adt.ui.editor.AtlEditor;
import org.eclipse.m2m.atl.engine.AtlNbCharFile;
import org.eclipse.m2m.atl.engine.AtlParser;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * @author idrissi 
 */
public class AtlContentOutlinePage extends AtlOutlinePage {	
	
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	/**
	 * perspective listener
	 */
	private class PerspectiveListener implements IPerspectiveListener {

		/**
		 * @see org.eclipse.ui.IPerspectiveListener#perspectiveActivated(org.eclipse.ui.IWorkbenchPage, org.eclipse.ui.IPerspectiveDescriptor)
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
		 * @see org.eclipse.ui.IPerspectiveListener#perspectiveChanged(org.eclipse.ui.IWorkbenchPage, org.eclipse.ui.IPerspectiveDescriptor, java.lang.String)
		 */
		public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) {
			// do nothing			
		}
		
	}
	
	/** The outline view context menu id. May be used for extensions by other plugins */
	public final static String ATL_OUTLINE_VIEW_CONTEXT_MENU_ID = "org.atl.eclipse.adt.outline.contextMenu";
	
	/** The wake up frequency of the background thread in charge of the refresh of the outline tree viewer */
//	private final static int REFRESH_PERIOD = 5000;
	
	/* Sorter enabling sorting the content of the tree viewer */
	private ViewerSorter alphabeticalSorter, defaultSorter;
	
	/** A description of the current cursor position of the associated editor
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#getCursorPosition()
	 */
	private String cursorPosition;
	
	/** max depth of research in the outline tree. It is different according to the current perspective.
	 * it equals to -1 in the debug perspective and 1 in the others.
	 * TODO put in a preference page 
	 */
	private int depth = 1; 	
	
//	/** The document provider of the textEditor */
//	private IDocumentProvider documentProvider;  
	
	/** The editorInput of the textEditor */
	private IEditorInput editorInput;
		
	/** <p>Each ATL element has a location String that indicates where it is located in the source file</p>
	 *  <p><code>AtlNbCharFile</code> class is useful to get index char start and index char end from the
	 *  location string</p>
	 * @see AtlNbCharFile
	 */
	private AtlNbCharFile help;
	
	/* Filter enabling filtering the display of the tree viewer */
	private ViewerFilter helperFilter, ruleFilter, defaultFilter;
	
	/** <code>true</code> if the tree viewer input has been set <coded>false</code> otherwise */
	private boolean inputSet = false;	
	
	/** Indicates whether the editor associated with this outline is opened */
//	private volatile boolean isTextEditorOpened = true;
	
	/** The perspective listener for the current page */
	private PerspectiveListener perspectiveListener;
	
	/* Actions that will be used in the toolBar and menu bar */
	private Action refreshItemAction, filterHelperAction, filterRuleAction, sorterAction;
	
	/** The background thread in charge of the refreshment of the outline tree viewer */
//	private Thread refreshThread = new Thread() {
//		public void run() {
//			while (isTextEditorOpened) {
//				try {
//					Thread.sleep(REFRESH_PERIOD);										
//					setUnit(); 					
//				} catch(InterruptedException e) {
//					System.err.println(e);
//				}
//			}
//		}
//	};
	
	/* other actions */
//	private Action renameItemAction;
	private Action addBreakPointAction;
	private Action cutAction;
	private Action copyAction;
	private Action  pasteAction;
	
	/** The root of the treeViewer */
	private Root root;
	
	/** The element currently selected in the tree viewer */
	private EObject selectedEo;
	
	/** The ATL editor associated with this outline */
	private ITextEditor textEditor;
	
	/**
	 * @param textEditor
	 * @param editorInput
	 * @param documentProvider
	 */
	public AtlContentOutlinePage(ITextEditor textEditor, IEditorInput editorInput, IDocumentProvider documentProvider) {
		super();
		this.textEditor = textEditor;
		this.editorInput = editorInput;
//		this.documentProvider = documentProvider;
		// refreshThread.start();
	}
    
    
    
    /**
     * Adds a breakpoint to current selected element of the tree viewer
     */
    private void addBreakpoint() {
    	IStructuredSelection is =  (IStructuredSelection)treeViewer.getSelection();
    	EObject element = (EObject)is.getFirstElement();
    	String location = (String)element.eGet(AtlEMFConstants.sfLocation);
    	int[]pos = help.getIndexChar(location); 
    	int charStart = pos[0];
    	int charEnd = pos[1];
    
    	IFileEditorInput ifei = (IFileEditorInput)editorInput;
		IResource ifile = ifei.getFile();
		int lineNumber= Integer.parseInt(location.split("-")[0].split(":")[0]);
		try {
			new AtlBreakpoint(ifile, location, lineNumber, charStart, charEnd);
//			AtlBreakpoint bkpt = new AtlBreakpoint(ifile, location, lineNumber, charStart, charEnd);		
		} catch (DebugException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}			    		    	
    }
    
    /**
     * <p>Adds a perspective listener to the perspective service</p>
     * <p>This is useful when some parameters need to be adjusted according to the current perspective.
     * In the present case the <code>depth</code> is different in the debug perspective.</p>
     * @param l the perspective listener to add
     */
    private void addPerspectiveListener(IPerspectiveListener l) {
    	getSite().getPage().getWorkbenchWindow().addPerspectiveListener(l);
    }
	
	/**
	 * computes the <code>depth</code> for the current perspective.
	 * The depth varies according to the perspective
	 * @param ipd the perspective for which to compute the depth
	 */
	private int computeDepth(IPerspectiveDescriptor ipd) {		
		if (IDebugUIConstants.ID_DEBUG_PERSPECTIVE.equals(ipd.getId())) {
			return -1;
		} 
		
		return 1;		
	}
    
    /**
     * Creates the actions that will be used in the toolbar of the view and in the
     * context menu of the tree viewer
     */
    public void createActions() {
    	cutAction = new Action("Cut") {
    		public void run() {
    			
    		}
    	};
    	cutAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("cut.gif"));
    	
    	copyAction = new Action("Copy") {
    		public void run() {
    			
    		}
    	};
    	copyAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("copy.gif"));
    	
    	pasteAction = new Action("Paste") {
    		public void run() {
    			
    		}
    	};    	    
    	pasteAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("paste.gif"));
    	
//    	renameItemAction = new Action("Rename") {
//        	public void run() {
//        		RenameAction ra = new RenameAction((IStructuredSelection)treeViewer.getSelection());
//        		ra.run();        		
//            }
//        };
        
        addBreakPointAction = new Action("Add breakpoint") {
        	public void run() {
        		addBreakpoint();        		
        	}
        };
        
        refreshItemAction = new Action("Refresh") {
        	public void run() {        	
        		setUnit();
        	}
        };
        refreshItemAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("refresh.gif"));
        refreshItemAction.setToolTipText("refresh outline");
        
        filterHelperAction = new Action("Hide Helpers", Action.AS_CHECK_BOX) {
        	public void run() {
        		updateFilters(filterHelperAction);        		
        	}
        };
        filterHelperAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("hideHelper.gif"));        
        filterHelperAction.setToolTipText("Hide helpers");
        
        filterRuleAction = new Action("Hide rules", Action.AS_CHECK_BOX) {
        	public void run() {
        		updateFilters(filterRuleAction);
        	}
        };        
        filterRuleAction.setToolTipText("Hide the rules");
        filterRuleAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("hideMatchedRule.gif"));
        
        sorterAction = new Action("Alphabetical sort", Action.AS_CHECK_BOX) {
        	public void run() {
        		updateSorter(sorterAction);
        	}
        };
        sorterAction.setImageDescriptor(AtlUIPlugin.getImageDescriptor("alphab_sort.gif"));
        sorterAction.setToolTipText("sort alphabetically");
    }
			
	/**
     * Creates a context menu for this view
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
	 * @see org.eclipse.ui.views.contentoutline.ContentOutlinePage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite arg0) {
		super.createControl(arg0);
		root = new Root();
		// Add all listeners that were added when the tree viewer was null
		Object[] listeners= selectionChangedListeners.getListeners();
		for (int i= 0; i < listeners.length; i++) {
			selectionChangedListeners.remove(listeners[i]);
			treeViewer.addPostSelectionChangedListener((ISelectionChangedListener) listeners[i]);
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
     * Creates the filters and sorters
     */
    public void createFiltersAndSorters() {
    	helperFilter = new HideHelperFilter();
    	ruleFilter = new HideRuleFilter();
    	defaultFilter = new DefaultFilter();
    	alphabeticalSorter = new AlphabeticalSorter();
    	defaultSorter = new DefaultSorter();
    }
    
    /**
     * Creates a menu (for the view) with the same actions than the toolbar
     */
    private void createMenu() {
    	IMenuManager mgr = getSite().getActionBars().getMenuManager();
    	mgr.add(refreshItemAction);
    	mgr.add(filterHelperAction);
    	mgr.add(filterRuleAction);
    	mgr.add(sorterAction);
    }
    
    /**
     * Creates a toolbar (for the view) with a refresh button and buttons
     * to filter and sort the contents of the tree viewer
     */
    private void createToolbar() {
    	IToolBarManager mgr = getSite().getActionBars().getToolBarManager();
    	mgr.add(refreshItemAction);
    	mgr.add(filterHelperAction);
    	mgr.add(filterRuleAction);
    	mgr.add(sorterAction);    	
    }    
	
	private void doSetSelection(String cursorPosition) {
		if (!(cursorPosition == null || treeViewer.getTree().isDisposed())) {
			this.cursorPosition = cursorPosition;
			Root input = (Root)treeViewer.getInput();
			if (input != null) {
				EObject unit = input.getUnit();
				int cursorIndexChar = help.getIndex(cursorPosition);
				if (cursorIndexChar == -1)
					return;
				this.selectedEo = unit;
				setSelection(unit, cursorIndexChar, 0);
				treeViewer.collapseAll();
				treeViewer.expandToLevel(2);		
				showItem(selectedEo);
			}
		}
	}
    
    /**
     * fills the context menu with actions that were previously created
     * @param mgr the menu manager
     */
    private void fillContextMenu(IMenuManager mgr) {  	
    	mgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
    	mgr.add(cutAction);
    	mgr.add(copyAction);
    	mgr.add(pasteAction);
    	mgr.add(new Separator());
    	mgr.add(addBreakPointAction);
    	mgr.add(new Separator());
//    	MenuManager refactor = new MenuManager("Refactor");
//    	refactor.add(renameItemAction);
//    	mgr.add(refactor);
    }
    
    /**
	 * returns the perspective descriptor of the current perspective
	 * @return the perspective descriptor of the current perspective
	 */
    private IPerspectiveDescriptor getCurrentPerspective() {
    	return getSite().getPage().getPerspective();    					    	 
    }
	
	/**
	 * return an array with two value. first value : index of start char 
	 * second value : index of end char
	 * @param eo The EObject for which to compute index of end/start char
	 * @return  return an array with two value. first value : index of start char 
	 * second value : index of end char
	 */
	private int[] getPos(EObject eo) {
		String location = (String)eo.eGet(AtlEMFConstants.sfLocation);
		if (location == null) {
			return null;
		}
		
		int[] pos = help.getIndexChar(location);
		return pos;
	}
    
    /**
     * Initializes the <code>AtlNbCharFile</code> object used to convert the location string
     * and passes it to the <code>DefaultSorter</code> object.
     */
    private void initAtlNbCharFile(String content) {
    	help = new AtlNbCharFile(toInputStream(content));
    	((DefaultSorter)defaultSorter).setHelp(help);
    	((AtlEditor)textEditor).setHelp(help);
    }
	
	/** Sets the Unit of the input of the tree Viewer */ 
	public void setUnit() {
		String newContent = ((AtlEditor)textEditor).getDocumentProviderContent();				
		AtlParser parser = AtlParser.getDefault();			
		EObject eo = parser.parse(toInputStream(newContent));
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
	 * updates the tree viewer selection according to the editor cursor position
	 */
	private void setSelection(EObject input, int cursorIndexChar, int currentLevel) {
		if (input == null || input.eContents() == null || input.eContents().isEmpty()) {
			return;
		}
		
		Object[]contents = input.eContents().toArray();		
		for (int i = 0 ; i < contents.length; i++) {
			EObject eo = (EObject)contents[i];
			int[] pos = getPos(eo);
			if (pos == null) { // some EObject define no location
				continue;				
			}
		
			int eoStartChar = pos[0] ;
			int eoEndChar = pos[1];			
			if (eoStartChar <= cursorIndexChar && eoEndChar >= cursorIndexChar) {							
				this.selectedEo = eo;
				if ( (currentLevel+1 < depth) || (depth == -1) ) {
					setSelection(eo, cursorIndexChar, currentLevel+1);
				}
										
				break;											
			}				
		}			
	}
	
	
	public void setSelection (String cursorPosition) {
		doSetSelection(cursorPosition);
	}
		
	public void setTextEditorOpened(boolean isTextEditorOpened) {
//		this.isTextEditorOpened = isTextEditorOpened;
	}
	
	/**
	 * Highlights the given item in the tree viewer and makes it visible to the user, scrolling the tree viewer if necessary.
	 * And adjusts the highlighted range in the associated editor. 
	 * @param element the element to show in the tree viewer
	 */
	private void showItem(EObject element) {
		int[] pos = getPos(element);
		if (pos != null) {
			textEditor.setHighlightRange(pos[0], pos[1] - pos[0], false);			
		}
		treeViewer.setSelection(new StructuredSelection(element), true);		
	}
	
	/**
	 * convert from <code>String</code> to <code>InputStream</code>
	 * @param contents the <code>String</code> to convert
	 * @return the created InputStream 
	 */
	private InputStream toInputStream(String contents) {		
		return new ByteArrayInputStream(contents.getBytes());
	}
    
    /**
     * Updates the filters of the tree viewer 
     * Multiple filters can be enabled at a time
     */
    protected void updateFilters(Action action) {
    	if(action == filterHelperAction) {
        	if(action.isChecked()) {
        		treeViewer.addFilter(helperFilter);
        	} else {
            	treeViewer.removeFilter(helperFilter);
            }               
        } 
    	else if(action == filterRuleAction) {
    		if(action.isChecked()) {
    			treeViewer.addFilter(ruleFilter);
    		} else { 
    			treeViewer.removeFilter(ruleFilter);
    		}
        }    	
    }

    /**
     * Updates the sorter of the tree viewer
     * One sorter can be enabled at a time
     */
    protected void updateSorter(Action action) {
    	if (action == sorterAction) {
    		if (action.isChecked()) {
    			treeViewer.setSorter(alphabeticalSorter);
    		} else { 
    			treeViewer.setSorter(defaultSorter);
    		}
    	}
    }
    
}
