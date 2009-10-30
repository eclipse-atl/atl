/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * Stores / Loads ATL launch parameters from:
 * <ul>
 * <li>an ATL file.</li>
 * <li>an ATL Launch Configuration.</li>
 * <li>an ATL properties file.</li>
 * </ul>
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class CreateRunnableData {

	private static final String[] NON_LAUNCHER_OPTIONS = new String[] {"OPTION_DERIVED", "OPTION_CLEAR",}; //$NON-NLS-1$ //$NON-NLS-2$

	private IFile[] transformationFiles;

	private String fileType;

	private boolean isRefining;

	private Map<String, String> inModels;

	private Map<String, String> inOutModels;

	private Map<String, String> outModels;

	private Map<String, String> metamodelLocations;

	private Map<String, String> libraryLocations;

	private Map<String, String> options;

	private Set<String> libraryNames;

	private List<String> pluginDependencies;

	private Map<String, String> packageClassNames;

	private String classShortName;

	/**
	 * Updates the parameters from the given transformation files.
	 * 
	 * @param filePaths
	 *            the transformation file paths
	 * @throws IOException
	 * @throws CoreException
	 */
	public void load(String... filePaths) throws IOException, CoreException {
		List<IFile> atlModules = new ArrayList<IFile>();
		for (String filePath : filePaths) {
			IFile file = getFile(filePath);
			if (file != null) {
				atlModules.add(file);
			}
		}
		transformationFiles = atlModules.toArray(new IFile[atlModules.size()]);
		updateFromFiles();
		computeMetamodelDependencies();
	}

	/**
	 * Updates the parameters from the given property file.
	 * 
	 * @param properties
	 *            the properties
	 * @throws IOException
	 * @throws CoreException
	 */
	public void load(ATLProperties properties) throws IOException, CoreException {
		transformationFiles = properties.getTransformationFiles();
		updateFromFiles();
		libraryLocations.putAll(properties.getLibraryLocations());
		metamodelLocations.putAll(properties.getMetamodelLocations());
		options.putAll(properties.getOptions());
		computeMetamodelDependencies();
	}

	/**
	 * Updates the parameters from the given launch configuration.
	 * 
	 * @param configuration
	 *            the ATL launch configuration
	 * @throws IOException
	 * @throws CoreException
	 */
	@SuppressWarnings("unchecked")
	public void load(ILaunchConfiguration configuration) throws IOException, CoreException {
		String mainModulePath = configuration.getAttribute(ATLLaunchConstants.ATL_FILE_NAME,
				ATLLaunchConstants.NULL_PARAMETER);
		List<String> superimposedModulesPaths = configuration.getAttribute(ATLLaunchConstants.SUPERIMPOSE,
				Collections.EMPTY_LIST);

		List<IFile> atlModules = new ArrayList<IFile>();
		if (mainModulePath != null && !"".equals(mainModulePath)) { //$NON-NLS-1$
			IFile mainFile = getFile(mainModulePath);
			if (mainFile != null) {
				atlModules.add(mainFile);
				for (String path : superimposedModulesPaths) {
					IFile file = getFile(path);
					if (file != null) {
						atlModules.add(file);
					}
				}
			}
		}
		transformationFiles = atlModules.toArray(new IFile[atlModules.size()]);

		// initialize models and metamodels locations (if present)
		updateFromFiles();

		Map<?, ?> launchConfigOptions = configuration.getAttribute(ATLLaunchConstants.OPTIONS,
				Collections.EMPTY_MAP);
		for (Object optionName : launchConfigOptions.keySet()) {
			if (!Arrays.asList(NON_LAUNCHER_OPTIONS).contains(optionName)) {
				options.put(optionName.toString(), launchConfigOptions.get(optionName).toString());
			}
		}

		Map<String, String> launchConfigLibraryPaths = configuration.getAttribute(ATLLaunchConstants.LIBS,
				Collections.EMPTY_MAP);
		Map<String, String> libraryPaths = convertLocations(launchConfigLibraryPaths);
		for (String libraryName : getAllLibrariesNames()) {
			libraryLocations.put(libraryName, libraryPaths.get(libraryName));
		}

		Map<String, String> launchConfigModelPaths = configuration.getAttribute(ATLLaunchConstants.PATH,
				Collections.EMPTY_MAP);
		Map<String, String> modelPaths = convertLocations(launchConfigModelPaths);
		for (String metamodelName : getAllMetamodelsNames()) {
			metamodelLocations.put(metamodelName, modelPaths.get(metamodelName));
		}
		computeMetamodelDependencies();
	}

	public Object getClassShortName() {
		return classShortName;
	}

	public List<String> getPluginDependencies() {
		return pluginDependencies;
	}

	public Map<String, String> getPackageClassNames() {
		return packageClassNames;
	}

	private void updateFromFiles() throws IOException, CoreException {
		inModels = new LinkedHashMap<String, String>();
		inOutModels = new LinkedHashMap<String, String>();
		outModels = new LinkedHashMap<String, String>();
		libraryNames = new LinkedHashSet<String>();
		// keep previously set locations and options
		if (libraryLocations == null) {
			libraryLocations = new HashMap<String, String>();
		}
		if (metamodelLocations == null) {
			metamodelLocations = new HashMap<String, String>();
		}
		if (options == null) {
			options = new LinkedHashMap<String, String>();
		}

		if (transformationFiles.length >= 1) {
			AtlSourceManager sourceManager = new AtlSourceManager();
			sourceManager.updateDataSource(transformationFiles[0].getContents());
			isRefining = sourceManager.isRefining();
			classShortName = new Path(Character.toUpperCase(transformationFiles[0].getName().charAt(0))
					+ transformationFiles[0].getName().substring(1)).removeFileExtension().lastSegment();
			switch (sourceManager.getATLFileType()) {
				case AtlSourceManager.ATL_FILE_TYPE_MODULE:
					fileType = "Module"; //$NON-NLS-1$
					break;
				case AtlSourceManager.ATL_FILE_TYPE_QUERY:
					fileType = "Query"; //$NON-NLS-1$
					break;
				case AtlSourceManager.ATL_FILE_TYPE_LIBRARY:
					fileType = "Library"; //$NON-NLS-1$
					break;
				default:
					break;
			}

			for (IFile file : transformationFiles) {
				sourceManager.updateDataSource(file.getContents());
				updateFromFile(sourceManager);
			}
			if (isRefining) {
				inOutModels.putAll(inModels);
				inModels.clear();
				List<String> toRemove = new ArrayList<String>();
				for (String modelName : inOutModels.keySet()) {
					String metamodelName = inOutModels.get(modelName);
					for (String outModelName : outModels.keySet()) {
						if (metamodelName.equals(outModels.get(outModelName))) {
							toRemove.add(outModelName);
							break;
						}
					}
				}
				for (String modelName : toRemove) {
					outModels.remove(modelName);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void updateFromFile(AtlSourceManager sourceManager) {
		if (sourceManager.getInputModels() != null) {
			inModels.putAll(sourceManager.getInputModels());
		}
		if (sourceManager.getOutputModels() != null) {
			outModels.putAll(sourceManager.getOutputModels());
		}
		libraryNames.addAll(sourceManager.getLibrariesImports());
		Map<String, String> locationsFromFile = convertLocations(sourceManager.getMetamodelLocations());
		for (String metamodelName : getAllMetamodelsNames()) {
			String location = locationsFromFile.get(metamodelName);
			if (location != null) {
				EPackage regValue = EPackage.Registry.INSTANCE.getEPackage(location);
				if (regValue != null) {
					metamodelLocations.put(metamodelName, location);
				}
			}
		}
	}

	/**
	 * Computes plug-in dependency with the given metamodel.
	 * 
	 * @param metamodel
	 *            is the metamodel
	 */
	private void computeMetamodelDependencies() {
		pluginDependencies = new ArrayList<String>();
		packageClassNames = new HashMap<String, String>();
		for (String metamodelName : getAllMetamodelsNames()) {
			EPackage regValue = EPackage.Registry.INSTANCE.getEPackage(getMetamodelLocations().get(
					metamodelName));
			if (regValue != null) {
				computeMetamodelDependencies(metamodelName, regValue);
			}
		}
	}

	/**
	 * Computes plug-in dependency with the given metamodel.
	 * 
	 * @param metamodel
	 *            is the metamodel
	 */
	private void computeMetamodelDependencies(String metamodelName, EPackage metamodel) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry
				.getExtensionPoint("org.eclipse.emf.ecore.generated_package"); //$NON-NLS-1$
		if (extensionPoint != null && extensionPoint.getExtensions().length > 0) {
			IExtension[] extensions = extensionPoint.getExtensions();
			for (int i = 0; i < extensions.length; i++) {
				IExtension extension = extensions[i];
				IConfigurationElement[] members = extension.getConfigurationElements();
				for (int j = 0; j < members.length; j++) {
					IConfigurationElement member = members[j];
					String mURI = member.getAttribute("uri"); //$NON-NLS-1$
					if (mURI != null && mURI.equals(metamodel.getNsURI())) {
						if (!pluginDependencies.contains(member.getNamespaceIdentifier())) {
							pluginDependencies.add(member.getNamespaceIdentifier());
						}
						// uri can differ between versions
						packageClassNames.put(metamodelName, member.getAttribute("class")); //$NON-NLS-1$
					}
				}
			}
		}
	}

	public IFile[] getTransformationFiles() {
		return transformationFiles;
	}

	public String getFileType() {
		return fileType;
	}

	public boolean isRefining() {
		return isRefining;
	}

	public Map<String, String> getInModels() {
		return inModels;
	}

	public Map<String, String> getInOutModels() {
		return inOutModels;
	}

	public Map<String, String> getOutModels() {
		return outModels;
	}

	public Set<String> getAllLibrariesNames() {
		return libraryNames;
	}

	public Map<String, String> getLibraryLocations() {
		return libraryLocations;
	}

	public Map<String, String> getMetamodelLocations() {
		return metamodelLocations;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	/**
	 * Sets the given location for the given library name.
	 * 
	 * @param name
	 *            the library name
	 * @param location
	 *            the library location
	 */
	public void updateLibraryLocation(String name, String location) {
		libraryLocations.put(name, location);
	}

	/**
	 * Sets the given location for the given metamodel name.
	 * 
	 * @param name
	 *            the metamodel name
	 * @param location
	 *            the metamodel location
	 */
	public void updateMetamodelLocation(String name, String location) {
		metamodelLocations.put(name, location);
	}

	public void setOptions(Map<String, String> options) {
		this.options = options;
	}

	/**
	 * Aggregates all models names.
	 * 
	 * @return the model names
	 */
	public List<String> getAllModelsNames() {
		List<String> res = new ArrayList<String>();
		res.addAll(getInModels().keySet());
		res.addAll(getInOutModels().keySet());
		res.addAll(getOutModels().keySet());
		return res;
	}

	/**
	 * Aggregates all models to load names.
	 * 
	 * @return the model names
	 */
	public List<String> getModelsToLoadNames() {
		List<String> res = new ArrayList<String>();
		res.addAll(getInModels().keySet());
		res.addAll(getInOutModels().keySet());
		return res;
	}

	/**
	 * Aggregates all models to save names.
	 * 
	 * @return the model names
	 */
	public List<String> getModelsToSaveNames() {
		List<String> res = new ArrayList<String>();
		res.addAll(getInOutModels().keySet());
		res.addAll(getOutModels().keySet());
		return res;
	}

	/**
	 * Aggregates all metamodels names.
	 * 
	 * @return the metamodels names
	 */
	public Set<String> getAllMetamodelsNames() {
		Set<String> res = new HashSet<String>();
		res.addAll(getInModels().values());
		res.addAll(getInOutModels().values());
		res.addAll(getOutModels().values());
		return res;
	}

	/**
	 * Returns <code>true</code> if the given metamodel is a metametamodel.
	 * 
	 * @param metamodelName
	 *            the metamodel name
	 * @return <code>true</code> if the given metamodel is a metametamodel
	 */
	public boolean isMetametamodel(String metamodelName) {
		String location = getMetamodelLocations().get(metamodelName);
		if (location != null) {
			return location.startsWith("#"); //$NON-NLS-1$
		}
		return false;
	}

	public boolean isQuery() {
		return "Query".equals(getFileType()); //$NON-NLS-1$
	}

	/**
	 * Convert model map paths.
	 * 
	 * @param paths
	 *            the model path map
	 * @return the converted map
	 */
	private static Map<String, String> convertLocations(Map<String, String> paths) {
		Map<String, String> result = new HashMap<String, String>();
		for (Iterator<String> iterator = paths.keySet().iterator(); iterator.hasNext();) {
			String name = iterator.next();
			String location = paths.get(name);
			String validLocation = null;
			if (location.startsWith("uri:")) { //$NON-NLS-1$
				validLocation = location.substring(4);
			} else if (!(location.startsWith("ext:") || location.startsWith("platform:") || location //$NON-NLS-1$ //$NON-NLS-2$ 
					.startsWith("pathmap"))) { //$NON-NLS-1$
				validLocation = location;
			}
			if (validLocation != null) {
				result.put(name, validLocation);
			}
		}
		return result;
	}

	/**
	 * Returns the ATL file for a given .atl or .asm path.
	 * 
	 * @param path
	 *            the file path
	 * @return the .atl file
	 */
	public static IFile getFile(String path) {
		IResource res = null;
		if (path != null && !"".equals(path)) { //$NON-NLS-1$
			res = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
			if (res instanceof IFile) {
				IFile file = (IFile)res;
				IFile atlFile = null;
				String extension = file.getFileExtension().toLowerCase();
				if (extension.equals("asm")) { //$NON-NLS-1$
					String atlPath = file.getFullPath().removeFileExtension().addFileExtension("atl") //$NON-NLS-1$
							.toString();
					atlFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(atlPath));
				} else if (extension.equals("atl")) { //$NON-NLS-1$
					atlFile = file;
				}
				if (atlFile.isAccessible()) {
					return atlFile;
				}
			}
		}
		return null;
	}

}
