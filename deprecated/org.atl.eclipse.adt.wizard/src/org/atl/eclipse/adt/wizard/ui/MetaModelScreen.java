/*
 * Created on 16 avr. 2004
 */
package org.atl.eclipse.adt.wizard.ui;

import java.util.StringTokenizer;

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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

/**
 * @author allilaire
 */
public class MetaModelScreen extends WizardPage {

	private ISelection selection;
	private Composite container;
	private Text text1;
	private Label label1;
	private Group group2;
	private Text text2;
	private Label label2;
	private Group group1;
	private Button button1;
	private Button button2;

	public MetaModelScreen(ISelection selection) {
		super("wizardPage");
		setTitle("ATL Project Creator");
		setDescription("Input model and Output model files are required (Files need XMI Extension)");
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

		group1 = new Group(container,SWT.NULL);
		label2 = new Label(group1,SWT.NULL);
		text2 = new Text(group1,SWT.NULL);
		button1 = new Button(group1,SWT.PUSH| SWT.CENTER);

		group2 = new Group(container,SWT.NULL);
		label1 = new Label(group2,SWT.NULL);
		text1 = new Text(group2,SWT.NULL);
		button2 = new Button(group2,SWT.PUSH| SWT.CENTER);

		GridData gd = new GridData(GridData.VERTICAL_ALIGN_CENTER);
		group1.setLayoutData(gd);
		gd = new GridData(GridData.VERTICAL_ALIGN_CENTER);
		group2.setLayoutData(gd);

		/*********************************
		 * Creation of FormData
		 ******************************* */

		FormData labelLData = new FormData();
		labelLData.height = 30;
		labelLData.width = 100;
		labelLData.left =  new FormAttachment(15, 100, 0);
		labelLData.right =  new FormAttachment(35, 100, 0);
		labelLData.top =  new FormAttachment(20, 100, 0);
		labelLData.bottom =  new FormAttachment(80, 100, 0);
		
		FormData textLData = new FormData();
		textLData.height = 30;
		textLData.width = 200;
		textLData.left =  new FormAttachment(45, 100, 0);
		textLData.right =  new FormAttachment(75, 100, 0);
		textLData.top =  new FormAttachment(20, 100, 0);
		textLData.bottom =  new FormAttachment(80, 100, 0);

		FormData buttonLData = new FormData();
		buttonLData.height = 30;
		buttonLData.width = 50;
		buttonLData.left =  new FormAttachment(80, 100, 0);
		buttonLData.right =  new FormAttachment(90, 100, 0);
		buttonLData.top =  new FormAttachment(20, 100, 0);
		buttonLData.bottom =  new FormAttachment(80, 100, 0);
		
		FormLayout groupLayout = new FormLayout();
		groupLayout.marginWidth = 0;
		groupLayout.marginHeight = 0;
		groupLayout.spacing = 0;

		/**********************
		 * Components of group1 : Input meta-model
		 **********************/

		group1.setText("Input");
		group1.setSize(new org.eclipse.swt.graphics.Point(561,79));


		label2.setLayoutData(labelLData);
		label2.setText("Input Meta-Model");
		label2.setSize(new org.eclipse.swt.graphics.Point(124,32));


		text2.setLayoutData(textLData);
		text2.setSize(new org.eclipse.swt.graphics.Point(248,30));
		text2.setText(NewProjectData.getInstance().getInputMetaModel());
		text2.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				text1KeyPressed(evt);
			}
		});

		
		button1.setLayoutData(buttonLData);
		button1.setText("Browse");
		button1.setSize(new org.eclipse.swt.graphics.Point(320,27));
		button1.addSelectionListener( new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				openBrowser(evt, text2);
			}
		});

		group1.setLayout(groupLayout);
		group1.layout();

		/**********************
		 * Components of group2 : Output meta-model
		 **********************/

		group2.setText("Output");
		group2.setSize(new org.eclipse.swt.graphics.Point(561,79));

		label1.setLayoutData(labelLData);
		label1.setText("Output Meta-Model");
		label1.setSize(new org.eclipse.swt.graphics.Point(124,32));

		text1.setLayoutData(textLData);
		text1.setSize(new org.eclipse.swt.graphics.Point(248,30));
		text1.setText(NewProjectData.getInstance().getOutputMetaModel());
		text1.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				text1KeyPressed(evt);
			}
		});

		button2.setLayoutData(buttonLData);
		button2.setText("Browse");
		button2.setSize(new org.eclipse.swt.graphics.Point(320,27));
		button2.addSelectionListener( new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				openBrowser(evt, text1);
			}
		});
		
		group2.setLayout(groupLayout);
		group2.layout();

		container.layout();
		setControl(container);
	}
	
	/**
	 * This method update the model (NewProjectData) with the screen values : 
	 * 		The Input meta-model
	 * 		The Output meta-model
	 * */
	public void update() {
		NewProjectData.getInstance().setInputMetaModel(text2.getText());
		NewProjectData.getInstance().setOutputMetaModel(text1.getText());
	}
	
	/**
	 * When a key was released in text1 or text2 area,
	 * if text1 and text2 are empty this page is considered not complete
	 * else the page is considered complete. That is to say the button next is available
	 * */
	protected void text1KeyPressed(KeyEvent evt){
		if (isXMIFileName(text1.getText()) && isXMIFileName(text2.getText()))
			this.setPageComplete(true);
		else
			this.setPageComplete(false);
	}

	private boolean isXMIFileName(String fileName) {
		if (fileName.equals(""))
			return false;

		String extension = "";
		StringTokenizer fileNameToken = new StringTokenizer(fileName, ".");

		while (fileNameToken.hasMoreElements())
			extension = fileNameToken.nextToken();

		 if (extension.toLowerCase().equals("xmi"))
		 	return true;
		 else
		 	return false;
	}
	
	public void openBrowser(SelectionEvent evt, Text text) {
		FileDialog fileDialog = new FileDialog(this.getShell());
		fileDialog.setText("Choose the meta-model");
		fileDialog.setFilterExtensions(new String[]{"*.xmi"});
		String fileName = fileDialog.open();
		String extension = "";
		
		StringTokenizer fileNameToken = new StringTokenizer(fileName, ".");
		while (fileNameToken.hasMoreElements())
			extension = fileNameToken.nextToken();
		
		 if (!extension.toLowerCase().equals("xmi")) {
            MessageBox msgBox = new MessageBox(this.getShell(), SWT.APPLICATION_MODAL | SWT.OK);
            msgBox.setText("Error");
            msgBox.setMessage("Please, give an XMI file");
            msgBox.open();
            return;
		 }
		 else
		 	text.setText(fileName);

		if (isXMIFileName(text1.getText()) && isXMIFileName(text2.getText()))
			this.setPageComplete(true);
		else
			this.setPageComplete(false);
	}
}