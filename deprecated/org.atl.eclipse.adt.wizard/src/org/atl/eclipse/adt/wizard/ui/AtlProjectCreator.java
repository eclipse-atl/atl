package org.atl.eclipse.adt.wizard.ui;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

import org.atl.eclipse.adt.builder.AtlNature;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

public class AtlProjectCreator extends Wizard implements INewWizard, IExecutableExtension {
	
	/** The id of the wizard extension defined in the plugin.xml file of this plugin*/
	private static final String NEW_PROJECT_WIZARD_EXTENSION_ID = "org.atl.eclipse.adt.projectCreationWizard";
	
	private AtlDescriptionProjectScreen page;
	
	private IConfigurationElement configElement;
	
//	private MetaModelScreen page2;
	
	private FileNameScreen page3;
	
	private ISelection selection;
	
	private IProject modelProject;

	/**
	 * Constructor
	 */
	public AtlProjectCreator() {
		super();
		setNeedsProgressMonitor(true);		
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new AtlDescriptionProjectScreen(selection);
		addPage(page);
		/*page2 = new MetaModelScreen(selection);
		addPage(page2);*/
		/*page3 = new FileNameScreen(selection);
		addPage(page3);*/
	}

	/**
	 * return the configuration with the specified name or <code>null</code> if it does not exist
	 * @param name The name of the configuration element to find
	 * @return the configuration element with the specified name or <code>null</code> does not exist
	 */
	/*private IConfigurationElement getConfigElement(String name) {
		IExtension ext = AtlWizardPlugin.getDefault().getDescriptor().getExtension(NEW_PROJECT_WIZARD_EXTENSION_ID);
		IConfigurationElement[] elts = ext.getConfigurationElements();
		for (int i = 0; i < elts.length; i++) {
			IConfigurationElement elt = elts[i];
			if (elt.getName().equals(name))
				return elt;
		}
		return null;
	}*/
	
	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		page.update();
//		page2.update();
//		page3.update();
		String projectName = NewProjectData.getInstance().getProjectName();

		try{
			// Get the worskspace container (IWorkspaceRoot)
			IWorkspace wks = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot wksroot = wks.getRoot();

			// Create a project model instance
			modelProject = wksroot.getProject(projectName);
			if (!modelProject.exists())
				modelProject.create(null);

			// open project if necessary
			if (!modelProject.isOpen())
				modelProject.open(null);
			
			modelProject.setLocal(!NewProjectData.getInstance().isExternalLocation(), IResource.DEPTH_ZERO, null);

//			ProjectDescription description = new ProjectDescription();
//			description.setComment(
//					"InputMetaModel=" + NewProjectData.getInstance().getInputMetaModel() + "\n" +
//					"OutputMetaModele=" + NewProjectData.getInstance().getOutputMetaModel() + "\n" +
//					"SameFolderForSourcesAndBuilds=" + !NewProjectData.getInstance().isProjectLayoutSeparate() + "\n" +
//					"ProjectWithToString=" + NewProjectData.getInstance().isToStringFile()
//			);
//			modelProject.setDescription(description, null);
			addNature(modelProject, AtlNature.ATL_NATURE_ID);
			newProjectBuilder();
			NewProjectData.getInstance().clean();
			BasicNewProjectResourceWizard.updatePerspective(configElement);
		}
		catch(CoreException ce){
			System.out.println("core exception caught..." + ce.getMessage());
		}

		return true;
	}

	/**
	 * This method creates an ATL project in the workspace with :
	 * 		the ATL transformation file 
	 *		the toString file (if the project needs it)
	 *		the toString query file (if the project needs it)
	 */
	public void newProjectBuilder() {
		NewProjectData npd = NewProjectData.getInstance();
		String transfoName = npd.getTransformationName() + ".atl";

		// Creation of transformation file
//		String ATLTransformationFile = "";
//		String ATLTransformationFile = "module " + npd.getProjectName() + ";\n";
//		ATLTransformationFile += "create OUT : " + shortFileNameWithoutExtension(npd.getOutputMetaModel());
//		ATLTransformationFile += " from IN : " + shortFileNameWithoutExtension(npd.getInputMetaModel()) + ";\n";

//		createFile(transfoName, ATLTransformationFile);
		
//		if (npd.isToStringFile()) {
//			// Creation of toString file
//			String toStringFile = "library " + npd.getToStringFileName() + ";\n"; 
//			createFile(npd.getToStringFileName() + ".atl", toStringFile);
//			
//			// Creation of query file for toString transformation
//			String queryFile = "query " + npd.getToStringFileName() + "_query = -- Write here your query\n";
//			createFile(npd.getToStringFileName() + "-query.atl", queryFile);
//		}
	}

	/**
	 * This method give the file name without the extension
	 * In the model (NewProjectData), inputMetaModel or outputMetaModel contain the
	 * long file name. In the ATL transformation file, the short file name without extension is needed
 	 * @param longFileName 
	 * */
	private String shortFileNameWithoutExtension(String longFileName) {
		String shortFileName = "";
		StringTokenizer fileNameToken = new StringTokenizer(longFileName, "/");

		while (fileNameToken.hasMoreElements())
			shortFileName = fileNameToken.nextToken();

		fileNameToken = new StringTokenizer(shortFileName, ".");

		return fileNameToken.nextToken(); 
	}
	
	/**
	 * This method creates a file with its content in the project
	 * There is two cases :
	 * 		the project has external location
	 * 		the project has local location
	 * In the first case, a file is created in the file system and there is a link between this file
	 * and the ATL project.
	 * In the second case, a file is created in the project
	 * @param fileName name of the file to create
	 * @param content content of the file to create
	 */
	private void createFile(String fileName, String content) {
		IFile file = modelProject.getFile(fileName);
		try {
			if (NewProjectData.getInstance().isExternalLocation()) {
				FileWriter fw = new FileWriter(fileName);
				fw.write(content);
				fw.close();

				file.createLink(new Path(fileName), IResource.ALLOW_MISSING_LOCAL, null);
			}
			else {
				InputStream stream = openContentStream(content);
				if (file.exists()) {
					file.setContents(stream, true, true, null);
				} else {
					file.create(stream, true, null);
				}
				stream.close();	
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CoreException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * This method transforms string into inputstream
	 * @param contents content of the file to cast in InputStream
	 * @return the InputStream content
	 */
	private InputStream openContentStream(String contents) {
		return new ByteArrayInputStream(contents.getBytes());
	}
	
	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	/**
	 * Adds a nature to a project
	 * @param project the project to add a nature to
	 * @param natureId the natureId of the nature to be added to the project
	 */
	public void addNature(IProject project, String natureId) {
	try {
	      IProjectDescription description = project.getDescription();
	      String[] natures = description.getNatureIds();
	      String[] newNatures = new String[natures.length + 1];
	      System.arraycopy(natures, 0, newNatures, 0, natures.length);
	      newNatures[natures.length] = natureId;
	      description.setNatureIds(newNatures);
	      project.setDescription(description, null);
	   } catch (CoreException e) {
	   		System.err.println(e);
	   }
	}

	/**
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		this.configElement = config;
	}
}