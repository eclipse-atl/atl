/*******************************************************************************
 * Copyright (c) 2018, 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import java.lang.reflect.Field;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Registers an EMF metamodel.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class RegisterMetamodelTask extends EMFTVMTask {

	private String packageClass;
	private String resourceFactoryClass;
	private String fileExtension;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void innerExecute() throws Exception {
		final String packageClass = getPackageClass();
		final Class<?> packageClazz = Class.forName(packageClass);
		final Field eInstance = packageClazz.getDeclaredField("eINSTANCE");
		final EPackage ePackage = (EPackage) eInstance.get(packageClazz);
		if (ePackage == null) {
			throw new IllegalArgumentException("Cannot find package class " + packageClass);
		}

		final String resourceFactoryClass = getResourceFactoryClass();
		if (resourceFactoryClass != null) {
			final Class<?> resourceFactoryClazz = Class.forName(resourceFactoryClass);
			final Resource.Factory resourceFactory = (Resource.Factory) resourceFactoryClazz.getDeclaredConstructor()
					.newInstance();
			final String fileExtension = getFileExtension();
			if (fileExtension == null) {
				throw new IllegalArgumentException("File extension cannot be null if resource factory class is set");
			}
			getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension,
					resourceFactory);
		}
	}

	/**
	 * Returns the {@link EPackage} class to register.
	 *
	 * @return the packageClass
	 */
	public String getPackageClass() {
		return packageClass;
	}

	/**
	 * Sets the {@link EPackage} class to register.
	 *
	 * @param packageClass
	 *            the packageClass to set
	 */
	public void setPackageClass(String packageClass) {
		this.packageClass = packageClass;
	}

	/**
	 * @return the resourceFactoryClass
	 */
	public String getResourceFactoryClass() {
		return resourceFactoryClass;
	}

	/**
	 * @param resourceFactoryClass
	 *            the resourceFactoryClass to set
	 */
	public void setResourceFactoryClass(String resourceFactoryClass) {
		this.resourceFactoryClass = resourceFactoryClass;
	}

	/**
	 * Returns the file extension of the instance models.
	 *
	 * @return the fileExtension
	 */
	public String getFileExtension() {
		return fileExtension;
	}

	/**
	 * Sets the file extension of the instance models.
	 *
	 * @param fileExtension
	 *            the fileExtension to set
	 */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

}
