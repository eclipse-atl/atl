/*
 * Created on 16 avr. 2004
 */
package org.atl.eclipse.adt.wizard.ui;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author allilaire
 */
public class FileNameScreen extends WizardPage {

	private ISelection selection;
	private Composite container;
	private Text text2;
	private Label label2;
	private Button button1;
	private Label label1;
	private Text text1;
	private Group group1;
	private Group group0;

	public FileNameScreen(ISelection selection) {
		super("wizardPage");
		setTitle("ATL Project Creator");
		setDescription("Transformation name is required");
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

		group0 = new Group(container,SWT.CENTER);
		group0.setText("Transformation");
		group0.setSize(new org.eclipse.swt.graphics.Point(586,63));
		
		group1 = new Group(container,SWT.CENTER);
		group1.setText("toString");
		group1.setSize(new org.eclipse.swt.graphics.Point(586,63));
		
		label1 = new Label(group0, SWT.NULL);
		text1 = new Text(group0, SWT.NULL);

		button1 = new Button(group1, SWT.CHECK| SWT.LEFT);
		label2 = new Label(group1, SWT.NULL);
		text2 = new Text(group1, SWT.NULL);

		/**********************
		 * Components of group0 : transformation file
		 **********************/

		FormData label1LData = new FormData();
		label1LData.height = 30;
		label1LData.width = 150;
		label1LData.left =  new FormAttachment(15, 100, 0);
		label1LData.right =  new FormAttachment(50, 100, 0);
		label1LData.top =  new FormAttachment(30, 100, 0);
		label1LData.bottom =  new FormAttachment(70, 100, 0);

		label1.setLayoutData(label1LData);
		label1.setText("Transformation name");
		label1.setSize(new org.eclipse.swt.graphics.Point(156,30));
		

		FormData text1LData = new FormData();
		text1LData.height = 30;
		text1LData.width = 150;
		text1LData.left =  new FormAttachment(50, 100, 0);
		text1LData.right =  new FormAttachment(85, 100, 0);
		text1LData.top =  new FormAttachment(30, 100, 0);
		text1LData.bottom =  new FormAttachment(70, 100, 0);

		text1.setLayoutData(text1LData);
		text1.setSize(new org.eclipse.swt.graphics.Point(187,28));
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
		 * Components of group1 : toString file
		 **********************/

		FormData button1LData = new FormData();
		button1LData.height = 30;
		button1LData.width = 300;
		button1LData.left =  new FormAttachment(15, 100, 0);
		button1LData.right =  new FormAttachment(85, 100, 0);
		button1LData.top =  new FormAttachment(15, 100, 0);
		button1LData.bottom =  new FormAttachment(45, 100, 0);

		button1.setLayoutData(button1LData);
		button1.setText("Does the project need a toString transformation");
		button1.setSize(new org.eclipse.swt.graphics.Point(456,26));
		button1.addSelectionListener( new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				button1WidgetSelected(evt);
			}
		});
		button1.setSelection(NewProjectData.getInstance().isToStringFile());


		FormData label2LData = new FormData();
		label2LData.height = 30;
		label2LData.width = 100;
		label2LData.left =  new FormAttachment(15, 100, 0);
		label2LData.right =  new FormAttachment(50, 100, 0);
		label2LData.top =  new FormAttachment(55, 100, 0);
		label2LData.bottom =  new FormAttachment(85, 100, 0);

		label2.setLayoutData(label2LData);
		label2.setText("toString file name");
		label2.setSize(new org.eclipse.swt.graphics.Point(138,30));


		FormData text2LData = new FormData();
		text2LData.height = 30;
		text2LData.width = 100;
		text2LData.left =  new FormAttachment(50, 100, 0);
		text2LData.right =  new FormAttachment(85, 100, 0);
		text2LData.top =  new FormAttachment(55, 100, 0);
		text2LData.bottom =  new FormAttachment(85, 100, 0);

		text2.setLayoutData(text2LData);
		text2.setSize(new org.eclipse.swt.graphics.Point(178,28));
		text2.setEnabled(false);
		text2.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				text1KeyPressed(evt);
			}
		});

		
		FormLayout group1Layout = new FormLayout();
		group1.setLayout(group1Layout);
		group1Layout.marginWidth = 0;
		group1Layout.marginHeight = 0;
		group1Layout.spacing = 0;
		group1.layout();

		container.layout();

		setControl(container);
	}
	
	// Check box toString
	protected void button1WidgetSelected(SelectionEvent evt){
		if (button1.getSelection())
			text2.setEnabled(true);
		else
			text2.setEnabled(false);

		if (text1.getText().equals(""))
			this.setPageComplete(false);
		else {
			if ((!text2.getText().equals("") && button1.getSelection()) || (!button1.getSelection()))
				this.setPageComplete(true);
			else
				this.setPageComplete(false);
		}
	}

	/**
	 * This method update the model (NewProjectData) with the screen values : 
	 * 		The transformation name
	 * 		If the ATL project needs a toString transformation
	 * 		The toString file name
	 * */
	public void update() {
		NewProjectData.getInstance().setTransformationName(text1.getText());
		NewProjectData.getInstance().setToStringFileName(text2.getText());
		NewProjectData.getInstance().setToStringFile(button1.getSelection());
	}
	
	/**
	 * When a key was released in text1 or text2 area,
	 * if text1 and text2 (if button1 is selected) are empty this page is considered not complete
	 * else the page is considered complete. That is to say the button next is available
	 * */
	protected void text1KeyPressed(KeyEvent evt){
		if (text1.getText().equals(""))
			this.setPageComplete(false);
		else {
			if ((!text2.getText().equals("") && button1.getSelection()) || (!button1.getSelection()))
				this.setPageComplete(true);
			else
				this.setPageComplete(false);
		}
	}
}
