/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *    Obeo - icons modifications
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.ui.profilingdatatable;

import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.m2m.atl.profiler.core.ATLModelHandler;
import org.eclipse.m2m.atl.profiler.core.ATLProfiler;
import org.eclipse.m2m.atl.profiler.core.ProfilerModelHandler;
import org.eclipse.m2m.atl.profiler.core.util.ProfilerModelExporter;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;
import org.eclipse.m2m.atl.profiler.model.provider.ModelItemProviderAdapterFactory;
import org.eclipse.m2m.atl.profiler.ui.Messages;
import org.eclipse.m2m.atl.profiler.ui.activators.ExecutionViewerActivator;
import org.eclipse.m2m.atl.profiler.ui.executionviewer.view.ExecutionView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

/**
 * The data table view.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
public class ProfilingDataTableView extends ViewPart implements Observer, ISelectionListener {

	/** Instructions column name. */
	public static final String INSTRUCTIONS_COLNAME = Messages
			.getString("ProfilingDataTableView_EXECUTED_INSTRUCTIONS"); //$NON-NLS-1$

	/** Execution time column name. */
	public static final String TIME_EXECUTION_COLNAME = Messages
			.getString("ProfilingDataTableView_TIME_EXECUTION"); //$NON-NLS-1$

	/** Calls column name. */
	public static final String CALLS_COLNAME = Messages.getString("ProfilingDataTableView_CALLS"); //$NON-NLS-1$

	/** Operation name column name. */
	public static final String OPERATION_NAME_COLNAME = Messages
			.getString("ProfilingDataTableView_OPERATION_NAME"); //$NON-NLS-1$

	/** In memory column name. */
	public static final String INMEMORY_COLNAME = Messages.getString("ProfilingDataTableView_MEMORY_COL"); //$NON-NLS-1$

	/** Max memory column name. */
	public static final String MAXMEMORY_COLNAME = Messages
			.getString("ProfilingDataTableView_MAX_MEMORY_COL"); //$NON-NLS-1$

	/** Out memory column name. */
	public static final String OUTMEMORY_COLNAME = Messages
			.getString("ProfilingDataTableView_END_MEMORY_COL"); //$NON-NLS-1$

	/** The view id. */
	public static final String ID = "org.eclipse.m2m.atl.profiler.ui.profilingdatatable"; //$NON-NLS-1$

	private static final String SHOW_PERCENTS = Messages
			.getString("ProfilingDataTableView_PERCENT_STATISTICS"); //$NON-NLS-1$

	private static final String EXPORT_DATA = Messages.getString("ProfilingDataTableView_XMI_EXPORT"); //$NON-NLS-1$

	private static final String SHOW_PERCENTS_GIF = "percentsStatistics.gif"; //$NON-NLS-1$
	
	private static final String SAVE_GIF = "save.gif"; //$NON-NLS-1$

	private static final String HIDE_NATIVE_OPERATIONS_GIF = "hideNativeOperations.gif"; //$NON-NLS-1$

	private static final String SHOW_PERCENTAGES = Messages
			.getString("ProfilingDataTableView_HIDE_NATIVE_OPERATIONS"); //$NON-NLS-1$

	private static int instructionsColId;

	private static int timeExecutionColId;

	private static int callsColId;

	private static int operationNameColId;

	private static int inMemoryColId;

	private static int maxMemoryColId;

	private static int outMemoryColId;

	private static boolean showPercents;

	private static long totalInstructions;

	private static double totalTime;

	// Actions
	private Action showPercentsAction;

	private Action hideNativeOperationsAction;

	// Filters
	private NativeOperationFilter hideNativeOperationsfilter;

	private TreeViewer treeViewer;

	private DrillDownAdapter drillDownAdapter;

	private Action doubleClickAction;

	private Action xmiExportAction;

	private DirectoryDialog exportDirectorydialog;

	/**
	 * The constructor.
	 */
	public ProfilingDataTableView() {
		ATLProfiler.getInstance().addObserver(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent, SWT.FULL_SELECTION);
		drillDownAdapter = new DrillDownAdapter(treeViewer);
		treeViewer.setContentProvider(new ProfilingDataTableContentProvider(
				new ModelItemProviderAdapterFactory()));
		treeViewer
				.setLabelProvider(new ProfilingDataTableLabelProvider(new ModelItemProviderAdapterFactory()));

		exportDirectorydialog = new DirectoryDialog(parent.getShell());

		makeColumns();
		makeListeners();
		makefilters();
		makeActions();
		setDefaultActions();
		contributeToActionBars();
		hookDoubleClickAction();
		getSite().getWorkbenchWindow().getSelectionService().addPostSelectionListener(this);
		getSite().setSelectionProvider(treeViewer);
	}

	private void makeListeners() {
		// TreeTable listeners
		Tree tree = treeViewer.getTree();
		addColumnSelectionListener(operationNameColId, tree, new NameComparator());
		addColumnSelectionListener(timeExecutionColId, tree, new TimeComparator());
		addColumnSelectionListener(instructionsColId, tree, new TotalInstructionComparator());
		addColumnSelectionListener(callsColId, tree, new CallsComparator());
		addColumnSelectionListener(inMemoryColId, tree, new MemoryComparator(
				MemoryComparator.ColumnType.InMem));
		addColumnSelectionListener(maxMemoryColId, tree, new MemoryComparator(
				MemoryComparator.ColumnType.MaxMem));
		addColumnSelectionListener(outMemoryColId, tree, new MemoryComparator(
				MemoryComparator.ColumnType.OutMem));
	}

	private void addColumnSelectionListener(final int colId, final Tree tree, final ViewerComparator wc) {
		tree.getColumn(colId).addSelectionListener(new SelectionAdapter() {
			private int direction;

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (direction == SWT.None) {
					setupColumnSorting(colId, SWT.UP, tree, wc);
				} else if (direction == SWT.UP) {
					setupColumnSorting(colId, SWT.DOWN, tree, wc);
				} else {
					setupColumnSorting(colId, SWT.None, tree, null);
				}
				treeViewer.refresh();
			}

			private void setupColumnSorting(final int colId, final int dir, final Tree tree,
					final ViewerComparator wc) {
				treeViewer.collapseAll();
				treeViewer.setComparator(wc);
				tree.setSortColumn(tree.getColumn(colId));
				direction = dir;
				tree.setSortDirection(direction);
			}
		});
	}

	private void makeColumns() {
		int i = 0;

		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		operationNameColId = i;
		TreeColumn opNameCol = new TreeColumn(tree, SWT.LEFT);
		opNameCol.setText(OPERATION_NAME_COLNAME);
		opNameCol.setWidth(150);

		i++;
		callsColId = i;
		TreeColumn callsCol = new TreeColumn(tree, SWT.CENTER);
		callsCol.setText(CALLS_COLNAME);
		callsCol.setWidth(75);

		i++;
		timeExecutionColId = i;
		TreeColumn timeExecCol = new TreeColumn(tree, SWT.CENTER);
		timeExecCol.setText(TIME_EXECUTION_COLNAME);
		timeExecCol.setWidth(120);

		i++;
		instructionsColId = i;
		TreeColumn instrCountCol = new TreeColumn(tree, SWT.CENTER);
		instrCountCol.setText(INSTRUCTIONS_COLNAME);
		instrCountCol.setWidth(140);

		i++;
		inMemoryColId = i;
		TreeColumn inMemCol = new TreeColumn(tree, SWT.CENTER);
		inMemCol.setText(INMEMORY_COLNAME);
		inMemCol.setWidth(120);

		i++;
		maxMemoryColId = i;
		TreeColumn maxMemCol = new TreeColumn(tree, SWT.CENTER);
		maxMemCol.setText(MAXMEMORY_COLNAME);
		maxMemCol.setWidth(105);

		i++;
		outMemoryColId = i;
		TreeColumn outMemCol = new TreeColumn(tree, SWT.CENTER);
		outMemCol.setText(OUTMEMORY_COLNAME);
		outMemCol.setWidth(85);
	}

	private void makefilters() {
		hideNativeOperationsfilter = new NativeOperationFilter();
	}

	private void makeActions() {
		hideNativeOperationsAction = new Action(SHOW_PERCENTAGES, Action.AS_CHECK_BOX) {
			@Override
			public void run() {
				updateFilters(hideNativeOperationsAction);
			}
		};
		hideNativeOperationsAction.setImageDescriptor(ExecutionViewerActivator
				.getImageDescriptor(HIDE_NATIVE_OPERATIONS_GIF));

		showPercentsAction = new Action(SHOW_PERCENTS, Action.AS_CHECK_BOX) {
			@Override
			public void run() {
				if (showPercents) {
					showPercents = true;
					// get total time & total instructions
					totalTime = ProfilerModelHandler.getInstance().getModelTotalTime();
					totalInstructions = ProfilerModelHandler.getInstance().getModelTotalInstructions();

				} else {
					showPercents = false;
				}
				treeViewer.refresh();

			}
		};
		showPercentsAction.setImageDescriptor(ExecutionViewerActivator.getImageDescriptor(SHOW_PERCENTS_GIF));

		xmiExportAction = new Action(EXPORT_DATA) {
			@Override
			public void run() {
				String path = exportDirectorydialog.open();
				if (path != null) {
					path += "/profiler_export.xmi"; //$NON-NLS-1$
					URI uri = URI.createFileURI(path);
					Resource rsc = new ResourceSetImpl().createResource(uri);
					rsc.getContents().clear();
					ExportRoot exportModel = null;
					try {
						exportModel = ProfilerModelExporter.exportCurrentProfilingModel();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (exportModel != null) {
						rsc.getContents().add(exportModel);
						try {
							rsc.save(Collections.EMPTY_MAP);
						} catch (Exception e) {
							e.printStackTrace();
						}
						showMessage(
								Messages.getString("ProfilingDataTableView_EXPORT_SUCCESSFULL") + path, Messages.getString("ProfilingDataTableView_EXPORT")); //$NON-NLS-1$ //$NON-NLS-2$
					} else {
						showError(
								Messages.getString("ProfilingDataTableView_UNABLE_TO_EXPORT"), Messages.getString("ProfilingDataTableView_EXPORT")); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}
			}
		};
		xmiExportAction.setImageDescriptor(ExecutionViewerActivator.getImageDescriptor(SAVE_GIF));

		doubleClickAction = new Action() {
			@Override
			public void run() {
				ISelection selection = treeViewer.getSelection();
				if (treeViewer.getComparator() != null) {
					treeViewer.collapseAll();
					treeViewer.setComparator(null);
					treeViewer.getTree().setSortDirection(0);

					TreeSelection current = (TreeSelection)selection;
					treeViewer.setSelection(current);
				}
			}
		};
	}

	private void hookDoubleClickAction() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void setDefaultActions() {

		hideNativeOperationsAction.setChecked(true);
		treeViewer.addFilter(hideNativeOperationsfilter);
	}

	private void updateFilters(Action updateFiltersAction) {
		if (updateFiltersAction.isChecked()) {
			treeViewer.addFilter(hideNativeOperationsfilter);
		} else {
			treeViewer.removeFilter(hideNativeOperationsfilter);
		}
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(hideNativeOperationsAction);
		manager.add(showPercentsAction);
		manager.add(xmiExportAction);
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(hideNativeOperationsAction);
		manager.add(showPercentsAction);
		manager.add(xmiExportAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

	/**
	 * Sets the view input.
	 * 
	 * @param arg
	 *            the input
	 */
	public void setInput(final Object arg) {

		Display display = PlatformUI.getWorkbench().getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				treeViewer.setInput(arg);
				treeViewer.refresh();
			}
		});

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		setInput(arg);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part instanceof ExecutionView && !ExecutionView.isShowCallTree()) {
			TreeSelection current = (TreeSelection)selection;
			if (current.getFirstElement() instanceof ProfilingOperation) {
				TreePath tp = current.getPaths()[0];
				if (tp.getLastSegment() instanceof ProfilingOperation) {
					ProfilingOperation pOp = (ProfilingOperation)tp.getLastSegment();
					String atlName = ATLModelHandler.getInstance().getATLName(pOp.getContent());
					Object[] segments = new Object[2];
					segments[0] = ProfilerModelHandler.getInstance().getOperationRegistry().get(atlName);
					segments[1] = pOp;
					if (!((pOp.getContent().equals("__resolve__") || pOp.getContent().equals("__match_") || pOp //$NON-NLS-1$ //$NON-NLS-2$
							.getContent().equals("__exec__")) && hideNativeOperationsAction.isChecked())) { //$NON-NLS-1$
						TreePath newTp = new TreePath(segments);
						TreeSelection newselection = new TreeSelection(newTp);
						treeViewer.setSelection(newselection);
					}
				}
			}
		} else if (part instanceof ExecutionView && ExecutionView.isShowCallTree()) {
			TreeSelection current = (TreeSelection)selection;
			if (current.getFirstElement() instanceof ProfilingOperation) {
				TreePath tp = current.getPaths()[0];
				if (tp.getLastSegment() instanceof ProfilingOperation) {
					ProfilingOperation pOp = (ProfilingOperation)tp.getLastSegment();
					String atlName = ATLModelHandler.getInstance().getATLName(pOp.getContent());
					Object[] segments = new Object[1];
					segments[0] = ProfilerModelHandler.getInstance().getOperationRegistry().get(atlName);
					TreePath newTp = new TreePath(segments);
					TreeSelection newselection = new TreeSelection(newTp);
					treeViewer.setSelection(newselection);
				}
			}
		}
	}

	private void showMessage(String message, String title) {
		MessageDialog.openInformation(treeViewer.getControl().getShell(), title, message);
	}

	private void showError(String message, String title) {
		MessageDialog.openError(treeViewer.getControl().getShell(), title, message);
	}

	public static int getTotalInstructionsId() {
		return instructionsColId;
	}

	public static int getTotalTimeExecutionId() {
		return timeExecutionColId;
	}

	public static int getCallsId() {
		return callsColId;
	}

	public static int getOperationNameId() {
		return operationNameColId;
	}

	public static int getInMemoryColId() {
		return inMemoryColId;
	}

	public static boolean isShowPercentAction() {
		return showPercents;
	}

	public static void setShowPercentAction(boolean s) {
		showPercents = s;
	}

	public static long getTotalInstructions() {
		return totalInstructions;
	}

	public static double getTotalTime() {
		return totalTime;
	}

	public static int getMaxMemoryColID() {
		return maxMemoryColId;
	}

	public static int getOutMemoryColId() {
		return outMemoryColId;
	}

}
