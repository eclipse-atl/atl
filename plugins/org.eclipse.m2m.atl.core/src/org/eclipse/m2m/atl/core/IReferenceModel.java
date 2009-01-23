/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core;

/**
 * The IReferenceModel interface defines a reference model, i.e. a metamodel managed by any framework.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public interface IReferenceModel extends IModel {

	/**
	 * Returns the metaelement having the given name.
	 * 
	 * @param name
	 *            the given name
	 * @return the metaelement having the given name
	 */
	Object getMetaElementByName(String name);

	/**
	 * Returns true if the given object is contained in this model's resource or a referenced resource.
	 * 
	 * @param object
	 *            the model element
	 * @return true if object is contained in this model's resource or a referenced resource
	 */
	boolean isModelOf(Object object);

}
