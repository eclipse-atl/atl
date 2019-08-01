/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.runner;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * Stores ATL launch parameters which are not provided by an ATL file.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLProperties extends Properties {

	/** The id of the modules property inside of the ATL property file. */
	public static final String MODULES_ID = "modules"; //$NON-NLS-1$

	/** The id of the metamodels properties inside of the ATL property file. */
	public static final String METAMODELS_ID = "metamodels"; //$NON-NLS-1$

	/** The id of the libraries properties inside of the ATL property file. */
	public static final String LIBRARIES_ID = "libraries"; //$NON-NLS-1$

	/** The id of the options properties inside of the ATL property file. */
	public static final String OPTIONS_ID = "options"; //$NON-NLS-1$

	private static final long serialVersionUID = -6057251615280415740L;

	private IFile file;

	private String name;

	/**
	 * Constructor.
	 * 
	 * @param file
	 *            the property file
	 * @throws IOException
	 * @throws CoreException
	 */
	public ATLProperties(IFile file) throws IOException, CoreException {
		super();
		this.file = file;
		InputStream is = file.getContents();
		load(is);
		is.close();
		this.name = file.getFullPath().removeFileExtension().lastSegment();
	}

	public IFile getIFile() {
		return file;
	}

	public Map<String, String> getMetamodelLocations() {
		return getMapFromProperties(name + '.' + METAMODELS_ID + '.');
	}

	public Map<String, String> getOptions() {
		return getMapFromProperties(name + '.' + OPTIONS_ID + '.');
	}

	public Map<String, String> getLibraryLocations() {
		return getMapFromProperties(name + '.' + LIBRARIES_ID + '.');
	}

	/**
	 * Returns the transformation files.
	 * 
	 * @return the transformation files
	 */
	public IFile[] getTransformationFiles() {
		String[] moduleFileNames = null;
		String modulesList = getProperty(name + '.' + MODULES_ID);
		if (modulesList != null) {
			moduleFileNames = modulesList.split(","); //$NON-NLS-1$
			List<IFile> atlModules = new ArrayList<IFile>();
			for (String moduleFileName : moduleFileNames) {
				IResource member = file.getParent().findMember(moduleFileName.trim());
				if (member != null) {
					IFile moduleFile = CreateRunnableData.getFile(member.getFullPath().toString());
					atlModules.add(moduleFile);
				}
			}
			return atlModules.toArray(new IFile[atlModules.size()]);
		}
		return null;
	}

	private Map<String, String> getMapFromProperties(String prefix) {
		Map<String, String> res = new HashMap<String, String>();
		for (Entry<Object, Object> property : entrySet()) {
			if (property.getKey().toString().startsWith(prefix)) {
				String key = property.getKey().toString().replaceFirst(prefix, ""); //$NON-NLS-1$
				String value = property.getValue().toString();
				if (!"".equals(value.trim())) { //$NON-NLS-1$
					res.put(key, value);
				}
			}
		}
		return res;
	}

}
