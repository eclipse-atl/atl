/*
 * Created on 14 avr. 2004
 */
package org.atl.eclipse.adt.wizard.ui;

/**
 * @author allilaire
 * 
 * This class was used by the wizard for creating a new ATL project
 * This class contains the data for the project
 *
 * 	// Data for the first screen
 *	String projectName 				--> name of the building project
 * 	boolean externalLocation 		--> if the location is external or in the default workspace
 *	boolean projectLayoutSeparate 	--> if sources and build files are separated
 *
 *	Data for the second screen
 *	String inputMetaModel 			--> name of the input meta-model
 *	String outputMetaModel 			--> name of the out meta-model
 *
 *	// Data for the third screen
 *	String transformationName 		--> name of the ATL transformation
 *	boolean toStringFile 			--> if the project needs a toString file
 *	String toStringFileName 		--> name of the toString file
 */

public class NewProjectData {

	private String projectName;
	private boolean externalLocation;
	private boolean projectLayoutSeparate;

	private String inputMetaModel;
	private String outputMetaModel;
	
	private String transformationName;
	private boolean toStringFile;
	private String toStringFileName;
	
	public static NewProjectData getInstance() {
		if (null == instance)
			instance = new NewProjectData();
		return instance;
	}
	
	private NewProjectData() {
		projectName = "";
		externalLocation = false;
		projectLayoutSeparate = false;
		inputMetaModel = "";
		outputMetaModel = "";
		transformationName = "";
		toStringFile = false;
		toStringFileName = "";
	}
	
	private static NewProjectData instance;

	/**
	 * Reset data
	 * */
	public void clean() {
		instance = new NewProjectData();
	}

	/**
	 * @return Returns the externalLocation.
	 */
	public boolean isExternalLocation() {
		return externalLocation;
	}
	/**
	 * @param externalLocation The externalLocation to set.
	 */
	public void setExternalLocation(boolean externalLocation) {
		this.externalLocation = externalLocation;
	}
	/**
	 * @return Returns the inputMetaModel.
	 */
	public String getInputMetaModel() {
		return inputMetaModel;
	}
	/**
	 * @param inputMetaModel The inputMetaModel to set.
	 */
	public void setInputMetaModel(String inputMetaModel) {
		this.inputMetaModel = inputMetaModel;
	}
	/**
	 * @return Returns the outputMetaModel.
	 */
	public String getOutputMetaModel() {
		return outputMetaModel;
	}
	/**
	 * @param outputMetaModel The outputMetaModel to set.
	 */
	public void setOutputMetaModel(String outputMetaModel) {
		this.outputMetaModel = outputMetaModel;
	}
	/**
	 * @return Returns the projectLayoutSeparate.
	 */
	public boolean isProjectLayoutSeparate() {
		return projectLayoutSeparate;
	}
	/**
	 * @param projectLayoutSeparate The projectLayoutSeparate to set.
	 */
	public void setProjectLayoutSeparate(boolean projectLayoutSeparate) {
		this.projectLayoutSeparate = projectLayoutSeparate;
	}
	/**
	 * @return Returns the projectName.
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName The projectName to set.
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return Returns the toStringFile.
	 */
	public boolean isToStringFile() {
		return toStringFile;
	}
	/**
	 * @param toStringFile The toStringFile to set.
	 */
	public void setToStringFile(boolean toStringFile) {
		this.toStringFile = toStringFile;
	}
	/**
	 * @return Returns the toStringFileName.
	 */
	public String getToStringFileName() {
		return toStringFileName;
	}
	/**
	 * @param toStringFileName The toStringFileName to set.
	 */
	public void setToStringFileName(String toStringFileName) {
		this.toStringFileName = toStringFileName;
	}
	/**
	 * @return Returns the transformationName.
	 */
	public String getTransformationName() {
		return transformationName;
	}
	/**
	 * @param transformationName The transformationName to set.
	 */
	public void setTransformationName(String transformationName) {
		this.transformationName = transformationName;
	}
}
