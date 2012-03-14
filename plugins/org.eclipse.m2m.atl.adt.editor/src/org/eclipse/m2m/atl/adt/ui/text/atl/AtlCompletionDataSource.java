/*******************************************************************************
 * Copyright (c) 2007, 2012 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *     INRIA - additionalProposalInfo implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.BooleanType;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.IntegerType;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.ModelElementType;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.RealType;
import org.eclipse.m2m.atl.adt.ui.text.atl.types.StringType;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The AtlCompletionDataSource, retrieves data from EMF metamodels.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class AtlCompletionDataSource {

	private AtlSourceManager manager;

	/**
	 * Creates a new completion datasource.
	 * 
	 * @param manager
	 *            the source manager
	 */
	public AtlCompletionDataSource(AtlSourceManager manager) {
		super();
		this.manager = manager;
	}

	/**
	 * Returns the current file context.
	 * 
	 * @return the current file context
	 */
	public String getATLFileContext() {
		return getATLFileContext(manager);
	}

	/**
	 * Returns the current file context.
	 * 
	 * @return the current file context
	 */
	public static String getATLFileContext(AtlSourceManager manager) {
		String context = AtlContextType.ATL_CONTEXT_ID;
		if (manager != null) {
			int type = manager.getATLFileType();
			switch (type) {
				case AtlSourceManager.ATL_FILE_TYPE_MODULE:
					context = AtlContextType.MODULE_CONTEXT_ID;
					break;
				case AtlSourceManager.ATL_FILE_TYPE_QUERY:
					context = AtlContextType.QUERY_CONTEXT_ID;
					break;
				case AtlSourceManager.ATL_FILE_TYPE_LIBRARY:
					context = AtlContextType.LIBRARY_CONTEXT_ID;
					break;
				default:
					context = AtlContextType.ATL_CONTEXT_ID;
					break;
			}
		}
		return context;
	}

	/**
	 * Returns the currently registered URIs.
	 * 
	 * @return the currently registered URIs
	 */
	public static String[] getURIs() {
		Set<String> uris = EPackage.Registry.INSTANCE.keySet();
		return uris.toArray(new String[uris.size()]);
	}

	/**
	 * Computes proposals for EMF paths.
	 * 
	 * @return the proposals
	 */
	public static IPath[] getPaths() {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IWorkspaceRoot root = workspace.getRoot();
		final IProject[] projects = root.getProjects();
		final List<IPath> allFiles = new ArrayList<IPath>();
		try {
			getWorkspaceEcoreFilePaths(projects, allFiles);
		} catch (final CoreException e1) {
			// do nothing -- fail silentlty
		}
		return allFiles.toArray(new IPath[allFiles.size()]);
	}

	/**
	 * Get all files contained in a set of resources.
	 * 
	 * @param resources
	 *            the resources to scan
	 * @param filePaths
	 *            the result file paths
	 * @throws CoreException
	 *             if {@link org.eclipse.core.resources.IContainer#members()} on a resource fails. Reasons
	 *             include:
	 *             <ul>
	 *             <li>This resource does not exist.</li>
	 *             <li>This resource is a project that is not open.</li>
	 *             </ul>
	 */
	private static void getWorkspaceEcoreFilePaths(final IResource[] resources, final List<IPath> filePaths)
			throws CoreException {
		for (int i = 0; i < resources.length; i++) {
			final IResource resource = resources[i];
			if (resource.isAccessible()) {
				if (resource instanceof IFile) {
					if ("ecore".equals(resource.getFileExtension())) { //$NON-NLS-1$
						filePaths.add(resource.getFullPath());
					}
				} else if (resource instanceof IProject) {
					getWorkspaceEcoreFilePaths(((IProject)resource).members(), filePaths);
				} else if (resource instanceof IFolder) {
					getWorkspaceEcoreFilePaths(((IFolder)resource).members(), filePaths);
				}
			}
		}
	}

	/**
	 * Metamodels names.
	 * 
	 * @return the names
	 */
	@SuppressWarnings("unchecked")
	public String[] getMetamodels() {
		Set<String> res = new HashSet<String>();
		if (manager != null) {
			res.addAll(manager.getInputModels().values());
			res.addAll(manager.getOutputModels().values());
		}
		return res.toArray(new String[res.size()]);
	}

	/**
	 * Metamodel classifiers for a given filter.
	 * 
	 * @param filter
	 *            the given filter
	 * @return the filtered classifiers (with metamodelName as key)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, OclAnyType[]> getClassifiers(int filter) {
		Map<String, OclAnyType[]> res = new HashMap<String, OclAnyType[]>();
		if (manager != null) {
			Map metamodelPackages = manager.getMetamodelPackages(filter);
			// input or output metamodels
			for (Iterator iterator = metamodelPackages.entrySet().iterator(); iterator.hasNext();) {
				Entry entry = (Entry)iterator.next();
				String metamodelName = entry.getKey().toString();
				List packages = (List)entry.getValue();
				Set<EClassifier> classifiers = new HashSet<EClassifier>();
				if (packages != null) {
					// packages of the current metamodel
					for (Iterator it = packages.iterator(); it.hasNext();) {
						EPackage metamodel = (EPackage)it.next();
						classifiers.addAll(getClassifiers(metamodel));
					}
				}
				OclAnyType[] types = new OclAnyType[classifiers.size()];
				int i = 0;
				for (Iterator iter = classifiers.iterator(); iter.hasNext();) {
					EClassifier eClassifier = (EClassifier)iter.next();
					types[i] = ModelElementType.create(eClassifier, metamodelName);
					i++;
				}
				res.put(metamodelName, types);
			}
		}
		return res;
	}

	/**
	 * Metamodel classifiers for a given metamodel.
	 * 
	 * @param metamodelName
	 * @param metamodel
	 * @return the classifiers
	 */
	private Collection<EClassifier> getClassifiers(EPackage metamodel) {
		// classifiers computation
		Collection<EClassifier> classifiers = new LinkedHashSet<EClassifier>();
		classifiers.addAll(computeAllClassifiersList(metamodel));

		// adds classifiers with a "normal" formalism : MM!ME
		for (Iterator<EClassifier> iterator = classifiers.iterator(); iterator.hasNext();) {
			classifiers.add(iterator.next());
		}
		return classifiers;
	}

	private static List<EClassifier> computeAllClassifiersList(EPackage ePackage) {
		List<EClassifier> classifiers = new BasicEList<EClassifier>();
		if (ePackage != null) {
			computeAllClassifiersList(ePackage, classifiers);
		}
		return classifiers;
	}

	private static void computeAllClassifiersList(EPackage ePackage, List<EClassifier> all) {
		Iterator<EClassifier> classifiers = ePackage.getEClassifiers().iterator();
		while (classifiers.hasNext()) {
			EClassifier classifier = classifiers.next();
			if (classifier instanceof EClass && !((EClass)classifier).isInterface()) {
				all.add(classifier);
			}
		}
		Iterator<EPackage> packages = ePackage.getESubpackages().iterator();
		while (packages.hasNext()) {
			computeAllClassifiersList(packages.next(), all);
		}
	}

	/**
	 * Returns the ATL primitive types instances.
	 * 
	 * @return the ATL primitive types instances
	 */
	@SuppressWarnings("serial")
	public Map<String, OclAnyType[]> getAtlPrimitiveTypes() {
		return new HashMap<String, OclAnyType[]>() {
			{
				put("", new OclAnyType[] {OclAnyType.getInstance(), StringType.getInstance(), //$NON-NLS-1$
						IntegerType.getInstance(), BooleanType.getInstance(), RealType.getInstance(),});
			}
		};
	}
}
