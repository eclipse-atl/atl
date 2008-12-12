/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core;

import java.util.Set;

/**
 * The IModel interface defines a model managed by any framework.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public interface IModel {

	/**
	 * Creates a new element in the model.
	 * 
	 * @param metaElement
	 *            the new element metatype
	 * @return the newly created element
	 */
	Object newElement(Object metaElement);

	/**
	 * Returns the {@link IReferenceModel} (i.e. the metamodel).
	 * 
	 * @return the {@link IReferenceModel}
	 */
	IReferenceModel getReferenceModel();

	/**
	 * Returns a {@link Set} of the elements matching the given type.
	 * 
	 * @param metaElement
	 *            a metatype
	 * @return a {@link Set} of the elements matching the given type
	 */
	Set<? extends Object> getElementsByType(Object metaElement);

	/**
	 * Defines if the model is readonly or not.
	 * 
	 * @return true if the model allows writing
	 */
	boolean isTarget();

	/**
	 * Sets if the model is readonly or not.
	 * 
	 * @param value
	 *            true if the model allows writing
	 */
	void setIsTarget(boolean value);

	/**
	 * Deletes the model in memory.
	 */
	void dispose();
	
	/**
	 * Returns the ModelFactory used to create the current model.
	 * 
	 * @return true if the model allows writing
	 */
	ModelFactory getModelFactory();
}
