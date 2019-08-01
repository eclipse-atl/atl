/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl.types;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The ATL Module type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
@SuppressWarnings("serial")
public abstract class UnitType extends OclAnyType {

	protected AtlSourceManager sourceManager;

	private IFile file;

	private Map<OclAnyType, Set<Operation>> helpers;

	private Map<OclAnyType, Set<Feature>> attributes;

	private List<LibraryType> libraries = new ArrayList<LibraryType>();

	/**
	 * Creates a new ATL Unit from the given source manager.
	 * 
	 * @param file
	 *            the unit file
	 * @param manager
	 *            the source manager
	 * @param unitType
	 *            the unit type
	 */
	public UnitType(IFile file, AtlSourceManager manager, OclType unitType) {
		super(unitType);
		this.file = file;
		this.sourceManager = manager;
		init();
	}

	public IFile getFile() {
		return file;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getSupertypes()
	 */
	@Override
	public OclAnyType[] getSupertypes() {
		return new OclAnyType[] {OclAnyType.getInstance()};
	}

	private void addHelper(OclAnyType context, final Operation helper) {
		if (helpers == null) {
			helpers = new HashMap<OclAnyType, Set<Operation>>();
		}
		if (helpers.get(context) == null) {
			Set<Operation> contextHelpers = new HashSet<Operation>() {
				{
					add(helper);
				}
			};
			helpers.put(context, contextHelpers);
		} else {
			helpers.get(context).add(helper);
		}
	}

	/**
	 * Returns the helpers atl objects.
	 * 
	 * @return the helpers atl objects
	 */
	protected abstract Collection<EObject> getHelpersObjects();

	/**
	 * Initializes the helpers and attributes.
	 */
	@SuppressWarnings("unchecked")
	protected void init() {
		if (sourceManager != null && sourceManager.getModel() != null) {
			// libraries
			Collection<EObject> librariesObjects = (Collection<EObject>)AtlTypesProcessor.eGet(sourceManager
					.getModel(), "libraries"); //$NON-NLS-1$;
			for (EObject libraryObject : librariesObjects) {
				String libraryName = (String)AtlTypesProcessor.eGet(libraryObject, "name"); //$NON-NLS-1$
				if (libraryName != null && sourceManager.getLibraryLocations().get(libraryName) != null) {
					String location = (String)sourceManager.getLibraryLocations().get(libraryName);
					AtlSourceManager libraryManager = new AtlSourceManager();
					IFile file = (IFile)ResourcesPlugin.getWorkspace().getRoot().findMember(
							new Path(location));
					if (file != null && file.isAccessible()) {
						if ("asm".equals(file.getFileExtension())) { //$NON-NLS-1$
							file = file.getProject().getParent().getFile(
									file.getFullPath().removeFileExtension().addFileExtension("atl")); //$NON-NLS-1$
						}
						if (file != null && file.isAccessible()) {
							try {
								libraryManager.updateDataSource(file.getContents());
								libraries.add(new LibraryType(file, libraryManager));
							} catch (IOException e) {
								// do nothing
							} catch (CoreException e) {
								// do nothing
							}
						}
					}
				}
			}

			Collection<EObject> helpers = getHelpersObjects();
			if (helpers != null) {
				for (Iterator<EObject> iterator = helpers.iterator(); iterator.hasNext();) {
					EObject element = iterator.next();
					if (element.eClass().getName().equals("Helper")) { //$NON-NLS-1$
						EObject definition = (EObject)AtlTypesProcessor.eGet(element, "definition"); //$NON-NLS-1$
						if (definition != null) {
							EObject context = (EObject)AtlTypesProcessor.eGet(definition, "context_"); //$NON-NLS-1$
							OclAnyType type = OclAnyType.getInstance();
							if (context != null) {
								EObject contextType = (EObject)AtlTypesProcessor.eGet(context, "context_"); //$NON-NLS-1$
								type = OclAnyType.create(sourceManager, contextType);
							} else {
								type = this;
							}
							EObject f = (EObject)AtlTypesProcessor.eGet(definition, "feature"); //$NON-NLS-1$
							if (f != null) {
								if (f.eClass().getName().equals("Attribute")) { //$NON-NLS-1$
									addAttribute(type, Feature.createFromAttribute(this, f, type));
								} else if (f.eClass().getName().equals("Operation")) { //$NON-NLS-1$
									addHelper(type, Operation.createFromHelper(this, f, type));
								}
							}
						}
					}
				}
			}
		}
	}

	private void addAttribute(OclAnyType context, final Feature attribute) {
		if (attributes == null) {
			attributes = new HashMap<OclAnyType, Set<Feature>>();
		}
		if (attributes.get(context) == null) {
			Set<Feature> contextAttributes = new HashSet<Feature>() {
				{
					add(attribute);
				}
			};
			attributes.put(context, contextAttributes);
		} else {
			attributes.get(context).add(attribute);
		}
	}

	/**
	 * Returns all the registered attributes for the given type.
	 * 
	 * @param type
	 *            the context type
	 * @return the registered attributes
	 */
	public Set<Feature> getAttributes(OclAnyType type) {
		Set<Feature> res = new LinkedHashSet<Feature>();
		for (LibraryType library : libraries) {
			res.addAll(library.getAttributes(type));
		}
		if (attributes != null) {
			if (attributes.get(type) != null) {
				res.addAll(attributes.get(type));
			}
			for (OclAnyType supertype : type.getSupertypes()) {
				res.addAll(getAttributes(supertype));
			}
		}
		return res;
	}

	public Set<Feature> getAllAttributes() {
		Set<Feature> res = new LinkedHashSet<Feature>();
		if(attributes != null) {
			for(Collection<Feature> features : attributes.values())
				res.addAll(features);
		}
		return res;
	}

	/**
	 * Returns all the registered helpers for the given type.
	 * 
	 * @param type
	 *            the context type
	 * @return the registered helpers
	 */
	public Set<Operation> getHelpers(OclAnyType type) {
		Set<Operation> res = new LinkedHashSet<Operation>();
		for (LibraryType library : libraries) {
			res.addAll(library.getHelpers(type));
		}
		if (helpers != null) {
			if (helpers.get(type) != null) {
				res.addAll(helpers.get(type));
			}
			for (OclAnyType supertype : type.getSupertypes()) {
				res.addAll(getHelpers(supertype));
			}
		}
		return res;
	}

	public Set<Operation> getAllHelpers() {
		Set<Operation> res = new LinkedHashSet<Operation>();
		if (helpers != null) {
			for(Collection<Operation> helpersByType : helpers.values())
				res.addAll(helpersByType);
		}
		return res;
	}

	public AtlSourceManager getSourceManager() {
		return sourceManager;
	}

	/**
	 * Returns the atl unit type.
	 * 
	 * @param file
	 *            the unit file
	 * @param manager
	 *            the unit source manager
	 * @return the atl unit type
	 */
	public static UnitType create(IFile file, AtlSourceManager manager) {
		if (file != null && manager != null) {
			switch (manager.getATLFileType()) {
				case AtlSourceManager.ATL_FILE_TYPE_MODULE:
					return new ModuleType(file, manager);
				case AtlSourceManager.ATL_FILE_TYPE_LIBRARY:
					return new LibraryType(file, manager);
				case AtlSourceManager.ATL_FILE_TYPE_QUERY:
					return new QueryType(file, manager);
				default:
					break;
			}
		}
		// Dummy instance
		return new ModuleType(null, null);
	}

}
