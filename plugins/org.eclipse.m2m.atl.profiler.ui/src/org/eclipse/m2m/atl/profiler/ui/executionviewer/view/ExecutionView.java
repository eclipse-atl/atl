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
 *    Obeo - icons modifications, observer deletion
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.ui.executionviewer.view;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.atl.profiler.core.ATLModelHandler;
import org.eclipse.m2m.atl.profiler.core.ATLProfiler;
import org.eclipse.m2m.atl.profiler.core.ProfilerModelHandler;
import org.eclipse.m2m.atl.profiler.model.Context;
import org.eclipse.m2m.atl.profiler.model.ExecutionError;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;
import org.eclipse.m2m.atl.profiler.model.provider.ModelItemProviderAdapterFactory;
import org.eclipse.m2m.atl.profiler.ui.Messages;
import org.eclipse.m2m.atl.profiler.ui.activators.ExecutionViewerActivator;
import org.eclipse.m2m.atl.profiler.ui.profilingdatatable.ProfilingDataTableView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

/**
 * The execution view.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
public class ExecutionView extends ViewPart implements Observer, ISelectionListener {

	/** The execution view id. */
	public static final String ID = "org.eclipse.m2m.atl.profiler.ui.executionviewer.view.ExecutionView"; //$NON-NLS-1$

	private static final String QUICKINFO_ERROR = Messages.getString("ExecutionView_PROFILER_ERROR"); //$NON-NLS-1$

	private static final String SUMMARY_INFO = Messages.getString("ExecutionView_SUMMARY"); //$NON-NLS-1$

	private static boolean showCallTree;

	private static final String SHOW_EXECUTION_SUMMARY_LABEL = Messages
			.getString("ExecutionView_SHOW_SUMMARY"); //$NON-NLS-1$

	private static final String SUMMARY_ACTION_ICON = "summaryAction.gif"; //$NON-NLS-1$

	private static final String SHOW_RESOLVE_CONTEXT_ICON = "showResolveContext.gif"; //$NON-NLS-1$

	private static final String EXECUTION_VIEW_ICON = "executionView.gif"; //$NON-NLS-1$

	private static final String CALL_VIEW_ICON = "callView.gif"; //$NON-NLS-1$

	private static final String ATL_PROFILER_QUICK_INFO = Messages.getString("ExecutionView_QUICK_INFO"); //$NON-NLS-1$

	private static final String SWITCH_ICON = "switch.gif"; //$NON-NLS-1$

	private static final String ATL_PROFILER_CALLS_VIEW = Messages.getString("ExecutionView_CALLS_VIEW"); //$NON-NLS-1$

	private static final String ATL_PROFILER_EXECUTION_VIEW = Messages
			.getString("ExecutionView_EXECUTION_VIEW"); //$NON-NLS-1$

	private static final String SWITCH_LABEL = Messages.getString("ExecutionView_SWITCH_VIEW"); //$NON-NLS-1$

	private static final String HIDE_HELPER_ICON = "hideHelper.gif"; //$NON-NLS-1$

	private static final String HIDE_ASM_INSTRUCTIONS = Messages.getString("ExecutionView_HIDE_ASM"); //$NON-NLS-1$

	private static boolean showResolvContextInlabel = true;

	private TreeViewer treeViewer;

	private DrillDownAdapter drillDownAdapter;

	private Action hideSimpleInstructionsAction;

	private InstructionFilter instructionFilter;

	private Action switchToCallTreeAction;

	private Action doubleClickAction;

	private Action summaryInfoAction;

	private Action putResolveContextInLabelAction;

	/**
	 * The constructor.
	 */
	public ExecutionView() {
		ATLProfiler.getInstance().addObserver(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	public void dispose() {
		super.dispose();
		ATLProfiler.getInstance().deleteObserver(this);
	}

	/**
	 * {@inheritDoc} This is a callback that will allow us to create the treeViewer and initialize it.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(treeViewer);
		executionViewProviders();

		makeFilters();
		hookDoubleClickAction();
		makeActions();
		setDefaultActions();
		contributeToActionBars();

		getSite().setSelectionProvider(treeViewer);
		getSite().getWorkbenchWindow().getSelectionService().addPostSelectionListener(this);

	}

	private void executionViewProviders() {
		treeViewer
				.setContentProvider(new ExecutionViewContentProvider(new ModelItemProviderAdapterFactory()));
		treeViewer.setLabelProvider(new ExecutionViewLabelProvider(new ModelItemProviderAdapterFactory()));
	}

	private void callsViewProviders() {
		treeViewer.setContentProvider(new CallsViewContentProvider(new ModelItemProviderAdapterFactory()));
		treeViewer.setLabelProvider(new CallsViewLabelProvider(new ModelItemProviderAdapterFactory()));
	}

	private void showQuickSummary() {
		ProfilerModelHandler modelHandler = ProfilerModelHandler.getInstance();
		ProfilingOperation pop = modelHandler.getProfilingModel();
		String message = ""; //$NON-NLS-1$
		if (pop != null) {
			message += Messages.getString("ExecutionView_TOTAL_INSTRUCTIONS") + modelHandler.getModelTotalInstructions(); //$NON-NLS-1$
			message += Messages.getString("ExecutionView_TOTAL_TIME") + modelHandler.getModelTotalTime() + " s"; //$NON-NLS-1$ //$NON-NLS-2$
			double mem = (pop.getMaxMemoryUsage() - pop.getLaunchedMemoryUsage()) / 1000.0;
			message += Messages.getString("ExecutionView_USED_MEMORY") + mem + " Kb"; //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			message = Messages.getString("ExecutionView_NO_SUMMARY"); //$NON-NLS-1$
		}
		showMessage(message, SUMMARY_INFO);
	}

	private void hookDoubleClickAction() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void setDefaultActions() {
		if (ProfilerModelHandler.getInstance().isHasTocreateStep()) {
			hideSimpleInstructionsAction.setChecked(true);
		}

		putResolveContextInLabelAction.setChecked(true);
		treeViewer.addFilter(instructionFilter);
	}

	private void makeFilters() {
		instructionFilter = new InstructionFilter();
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		if (ProfilerModelHandler.getInstance().isHasTocreateStep()) {
			manager.add(hideSimpleInstructionsAction);
		}
		manager.add(switchToCallTreeAction);
		manager.add(summaryInfoAction);
		manager.add(putResolveContextInLabelAction);
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		if (ProfilerModelHandler.getInstance().isHasTocreateStep()) {
			manager.add(hideSimpleInstructionsAction);
		}
		manager.add(switchToCallTreeAction);
		manager.add(summaryInfoAction);
		manager.add(putResolveContextInLabelAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		// Warning - Button displayed only if this option is true
		if (ProfilerModelHandler.getInstance().isHasTocreateStep()) {
			hideSimpleInstructionsAction = new Action(HIDE_ASM_INSTRUCTIONS, Action.AS_CHECK_BOX) {
				@Override
				public void run() {
					updateFilters(hideSimpleInstructionsAction);
				}
			};
			hideSimpleInstructionsAction.setImageDescriptor(ExecutionViewerActivator
					.getImageDescriptor(HIDE_HELPER_ICON));
		}

		switchToCallTreeAction = new Action(SWITCH_LABEL, Action.AS_CHECK_BOX) {
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {
				if (showCallTree) {
					showCallTree = false;
					executionViewProviders();
					putResolveContextInLabelAction.setEnabled(true);
					if (ProfilerModelHandler.getInstance().isHasTocreateStep()) {
						hideSimpleInstructionsAction.setEnabled(true);
					}
					putResolveContextInLabelAction.setEnabled(true);
					summaryInfoAction.setEnabled(true);

					updateViewName(ATL_PROFILER_EXECUTION_VIEW);
					updateViewIcon(ExecutionViewerActivator.getImageDescriptor(EXECUTION_VIEW_ICON));

				} else {
					showCallTree = true;
					callsViewProviders();
					putResolveContextInLabelAction.setEnabled(false);
					if (ProfilerModelHandler.getInstance().isHasTocreateStep()) {
						hideSimpleInstructionsAction.setEnabled(false);
					}
					putResolveContextInLabelAction.setEnabled(false);
					summaryInfoAction.setEnabled(false);

					updateViewName(ATL_PROFILER_CALLS_VIEW);
					updateViewIcon(ExecutionViewerActivator.getImageDescriptor(CALL_VIEW_ICON));
				}

				treeViewer.refresh();
			}
		};
		switchToCallTreeAction.setImageDescriptor(ExecutionViewerActivator.getImageDescriptor(SWITCH_ICON));

		doubleClickAction = new Action() {
			@Override
			public void run() {
				ISelection selection = treeViewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if (obj instanceof ProfilingOperation) {
					showQuickInfo((ProfilingOperation)obj);
				} else if (obj instanceof ExecutionError) {
					showQuickError((ExecutionError)obj);
				}
			}
		};

		summaryInfoAction = new Action(SHOW_EXECUTION_SUMMARY_LABEL) {
			@Override
			public void run() {
				showQuickSummary();
			}
		};
		summaryInfoAction
				.setImageDescriptor(ExecutionViewerActivator.getImageDescriptor(SUMMARY_ACTION_ICON));

		putResolveContextInLabelAction = new Action("Show __resolve__ context in label", Action.AS_CHECK_BOX) { //$NON-NLS-1$
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {
				if (showResolvContextInlabel) {
					showResolvContextInlabel = false;
				} else {
					showResolvContextInlabel = true;
				}
				treeViewer.refresh();
			}
		};
		putResolveContextInLabelAction.setImageDescriptor(ExecutionViewerActivator
				.getImageDescriptor(SHOW_RESOLVE_CONTEXT_ICON));
	}

	private void showQuickInfo(ProfilingOperation pop) {
		if (!showCallTree) {
			String message = ""; //$NON-NLS-1$
			message += Messages.getString("ExecutionView_OPERATION") + pop.getContent() + "\n"; //$NON-NLS-1$ //$NON-NLS-2$

			if (ATLModelHandler.isNativeOperation(pop.getContent())) {
				message += Messages.getString("ExecutionView_NATIVE_OPERATION"); //$NON-NLS-1$
			} else {
				message += Messages.getString("ExecutionView_ATL_ELEMENT") + pop.getAtlInstruction().getName() + "\n\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}
			double time = (pop.getEndTime() - pop.getLaunchedTime()) / 1000.0;
			message += Messages.getString("ExecutionView_EXECUTION_TIME") + time + "s \n"; //$NON-NLS-1$ //$NON-NLS-2$
			message += Messages.getString("ExecutionView_EXECUTED_INSTRUCTIONS") + pop.getExecutionInstructions() + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
			double memStart = pop.getLaunchedMemoryUsage() / 1000.0;
			double memEnd = pop.getEndMemoryUsage() / 1000.0;
			message += Messages.getString("ExecutionView_LAUNCH_MEMORY") + memStart + " kb \n"; //$NON-NLS-1$ //$NON-NLS-2$
			message += Messages.getString("ExecutionView_END_MEMORY") + memEnd + " Kb \n"; //$NON-NLS-1$ //$NON-NLS-2$

			if (pop.isHasError()) {
				int nbErrors = pop.getExecutionErrors().size();
				if (nbErrors > 0) {
					message += "\n" + nbErrors + " Errors : \n"; //$NON-NLS-1$ //$NON-NLS-2$
					for (ExecutionError execErr : pop.getExecutionErrors()) {
						message += execErr.getMessage() + "\n"; //$NON-NLS-1$
					}
				} else {
					message += "\nErrors in sub operations \n"; //$NON-NLS-1$
				}

			}

			message += "\nContext : "; //$NON-NLS-1$
			for (Context c : pop.getContext()) {
				message += c.getContent() + "\n"; //$NON-NLS-1$
			}
			showMessage(message, ATL_PROFILER_QUICK_INFO);
		}
	}

	private void showQuickError(ExecutionError obj) {
		if (!showCallTree) {
			String message = ""; //$NON-NLS-1$
			message += obj.getMessage();
			message += "\n\nContext : \n"; //$NON-NLS-1$
			message += obj.getFrames();
			message += "\n\nError : \n"; //$NON-NLS-1$
			message += obj.getError();
			showMessage(message, QUICKINFO_ERROR);
		}
	}

	private void showMessage(String message, String title) {
		MessageDialog.openInformation(treeViewer.getControl().getShell(), title, message);
	}

	private void updateViewName(String name) {
		this.setPartName(name);
	}

	private void updateViewIcon(ImageDescriptor image) {
		this.setTitleImage(image.createImage());
	}

	private void updateFilters(Action updateFiltersAction) {
		if (updateFiltersAction.isChecked()) {
			treeViewer.addFilter(instructionFilter);
		} else {
			treeViewer.removeFilter(instructionFilter);
		}
		treeViewer.refresh();
	}

	/**
	 * Passing the focus request to the treeViewer's control.
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
				showQuickSummary();
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
		if (part instanceof ProfilingDataTableView && !ExecutionView.isShowCallTree()) {
			TreeSelection current = (TreeSelection)selection;
			if (current.getFirstElement() instanceof ProfilingOperation) {
				treeViewer.setSelection(current);
			}
		}
	}

	public static boolean isShowCallTree() {
		return showCallTree;
	}

	public static boolean isShowResolvContextInlabel() {
		return showResolvContextInlabel;
	}
}
