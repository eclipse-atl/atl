package org.atl.eclipse.adt.wizard.atlproject;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class AtlDescriptionProjectScreen extends WizardPage {

	private ISelection selection;
	private Composite container;
	private Text textProjectName;
	private Group groupProject;
	
	/**
	 * Constructor
	 */
	public AtlDescriptionProjectScreen(ISelection selection) {
		super("wizardPage");
		setTitle("ATL Project Creator");
		setDescription("A name is required for your ATL Project");
		this.selection = selection;
		this.setPageComplete(false);
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 * In this method, the GUI is created
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;
		
		/* Instanciation of all the components */

		groupProject = new Group(container,SWT.CENTER);
		groupProject.setText("ATL PROJECT");
		groupProject.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		groupProject.setLayout(layout);

		new Label(groupProject,SWT.NULL).setText("Project name");
		textProjectName = new Text(groupProject,SWT.BORDER);
		textProjectName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textProjectName.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				textProjectNameKeyPressed(evt);
			}
		});

		container.layout();
		setControl(container);
	}

	public String getProjectName() {
		return textProjectName.getText();
	}
	
	/**
	 * When a key was released in textProjectName area,
	 * if textProjectName is empty this page is considered not complete
	 * else the page is considered complete. That is to say the button next is available
	 * */
	protected void textProjectNameKeyPressed(KeyEvent evt) {
		if (textProjectName.getText().equals(""))
			this.setPageComplete(false);
		else
			this.setPageComplete(true);
	}
}