package org.atl.eclipse.adt.wizard.ui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.SWT;
import org.eclipse.jface.viewers.*;


public class AtlDescriptionProjectScreen extends WizardPage {

	private ISelection selection;
	private Composite container;
	private Text text1;
	private Button button3;
	private Button button4;
	private Group group2;
	private Button button1;
	private Button button2;
	private Group group1;
	private Group group0;
	private Label label2;
	
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

		group0 = new Group(container,SWT.CENTER);
		group0.setText("Description");
		group0.setSize(new org.eclipse.swt.graphics.Point(586,63));

		group1 = new Group(container,SWT.CENTER);
		group1.setText("Location");
		group1.setSize(new org.eclipse.swt.graphics.Point(586,74));

		group2 = new Group(container,SWT.CENTER);
		group2.setText("Project layout");
		group2.setSize(new org.eclipse.swt.graphics.Point(586,63));
		
		label2 = new Label(group0,SWT.NULL);
		text1 = new Text(group0,SWT.NULL);

		button2 = new Button(group1,SWT.RADIO| SWT.LEFT);
		button1 = new Button(group1,SWT.RADIO| SWT.LEFT);

		button4 = new Button(group2,SWT.RADIO| SWT.LEFT);
		button3 = new Button(group2,SWT.RADIO| SWT.LEFT);

		/**********************
		 * Components of group0 : Description
		 **********************/
		
		FormData label2LData = new FormData();
		label2LData.height = 30;
		label2LData.width = 150;
		label2LData.left =  new FormAttachment(15, 100, 0);
		label2LData.right =  new FormAttachment(50, 100, 0);
		label2LData.top =  new FormAttachment(30, 100, 0);
		label2LData.bottom =  new FormAttachment(70, 100, 0);

		label2.setLayoutData(label2LData);
		label2.setText("Project name");
		label2.setSize(new org.eclipse.swt.graphics.Point(102,30));


		FormData text1LData = new FormData();
		text1LData.height = 30;
		text1LData.width = 150;
		text1LData.left =  new FormAttachment(50, 100, 0);
		text1LData.right =  new FormAttachment(85, 100, 0);
		text1LData.top =  new FormAttachment(30, 100, 0);
		text1LData.bottom =  new FormAttachment(70, 100, 0);

		text1.setLayoutData(text1LData);
		text1.setSize(new org.eclipse.swt.graphics.Point(245,23));
		text1.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				text1KeyPressed(evt);
			}
		});


		FormLayout group0Layout = new FormLayout();
		group0.setLayout(group0Layout);
		group0Layout.marginWidth = 0;
		group0Layout.marginHeight = 0;
		group0Layout.spacing = 0;
		group0.layout();

		/**********************
		 * Components of group1 : Location
		 **********************/
		
		FormData radioButtonBottomLData = new FormData();
		radioButtonBottomLData.height = 20;
		radioButtonBottomLData.width = 300;
		radioButtonBottomLData.left =  new FormAttachment(15, 100, 0);
		radioButtonBottomLData.right =  new FormAttachment(85, 100, 0);
		radioButtonBottomLData.top =  new FormAttachment(55, 100, 0);
		radioButtonBottomLData.bottom =  new FormAttachment(85, 100, 0);

		button2.setLayoutData(radioButtonBottomLData);
		button2.setText("Project at external location");
		button2.setSize(new org.eclipse.swt.graphics.Point(360,30));

		
		FormData radioButtonTopLData = new FormData();
		radioButtonTopLData.height = 20;
		radioButtonTopLData.width = 300;
		radioButtonTopLData.left =  new FormAttachment(15, 100, 0);
		radioButtonTopLData.right =  new FormAttachment(85, 100, 0);
		radioButtonTopLData.top =  new FormAttachment(15, 100, 0);
		radioButtonTopLData.bottom =  new FormAttachment(45, 100, 0);

		button1.setLayoutData(radioButtonTopLData);
		button1.setText("Project in workspace");
		button1.setSize(new org.eclipse.swt.graphics.Point(360,30));
		button1.setSelection(true);

		
		group1.setLayout(group0Layout);
		group1.layout();
		
		/**********************
		 * Components of group2 : Project layout
		 **********************/

		button4.setLayoutData(radioButtonBottomLData);
		button4.setText("Separate folders for sources and build files");
		button4.setSize(new org.eclipse.swt.graphics.Point(360,30));

		button3.setLayoutData(radioButtonTopLData);
		button3.setText("Same folder for sources and build files");
		button3.setSize(new org.eclipse.swt.graphics.Point(360,30));
		button3.setSelection(true);

		group2.setLayout(group0Layout);
		group2.layout();

		container.layout();
		setControl(container);
	}

	/**
	 * This method update the model (NewProjectData) with the screen values : 
	 * 		The project name
	 * 		If the project is located in the default workspace
	 * 		If sources and build files are separated
	 * */
	public void update() {
		NewProjectData npd = NewProjectData.getInstance();
		npd.setProjectName(text1.getText());
		if (button1.getSelection())
			npd.setExternalLocation(false);
		else
			npd.setExternalLocation(true);

		if (button3.getSelection())
			npd.setProjectLayoutSeparate(false);
		else
			npd.setProjectLayoutSeparate(true);
	}
	
	/**
	 * When a key was released in text1 area,
	 * if text1 is empty this page is considered not complete
	 * else the page is considered complete. That is to say the button next is available
	 * */
	protected void text1KeyPressed(KeyEvent evt) {
		if (text1.getText().equals(""))
			this.setPageComplete(false);
		else
			this.setPageComplete(true);
	}
}