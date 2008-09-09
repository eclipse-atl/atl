/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: ModelAdapter.java,v 1.3 2008/09/09 13:15:01 wpiers Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

/**
 * The model adapter interface, defining model interactions.
 * 
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 */
public interface ModelAdapter {

	/**
	 * Returns the value of a feature in a given model element.
	 * 
	 * @param frame
	 *            the frame context
	 * @param eo
	 *            the model element
	 * @param name
	 *            the feature name
	 * @return the value
	 */
	Object get(StackFrame frame, Object eo, String name);

	/**
	 * Sets the value of a feature in a given model element.
	 * 
	 * @param frame
	 *            the frame context
	 * @param eo
	 *            the model element
	 * @param name
	 *            the feature name
	 * @param value
	 *            the value to set
	 */
	void set(StackFrame frame, Object eo, String name, Object value);

	/**
	 * Deletes a model element.
	 * 
	 * @param frame
	 *            the frame context
	 * @param eo
	 *            the model element to delete
	 */
	void delete(StackFrame frame, Object eo);

	/**
	 * Registers a map of supertypes.
	 * 
	 * @param vmSupertypes
	 *            the supertypes map
	 */
	void registerVMSupertypes(Map vmSupertypes);

	/**
	 * Registers a map of operations.
	 * 
	 * @param vmTypeOperations
	 *            the operations map
	 */
	void registerVMTypeOperations(Map vmTypeOperations);

	/**
	 * Displays a value.
	 * 
	 * @param out
	 *            the stream where to display the value
	 * @param value
	 *            the value to display
	 * @return true if the value has been displayed
	 */
	boolean prettyPrint(PrintStream out, Object value);

	/**
	 * Returns the type of a given value.
	 * 
	 * @param value
	 *            the value
	 * @return the type of a given value.
	 */
	Object getType(Object value);

	/**
	 * Returns the list of the supertypes of a given type.
	 * 
	 * @param type
	 *            a model element type
	 * @return the list of the supertypes of a given type
	 */
	List getSupertypes(Object type);

	/**
	 * Returns the model of a given element.
	 * 
	 * @param element
	 *            a model element
	 * @return the model of a given element
	 */
	Model getModelOf(Object element);

	/**
	 * Sets "allow inter-model references" for this model adapter.
	 * 
	 * @param allowInterModelRefs
	 *            the value
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	void setAllowInterModelReferences(boolean allowInterModelRefs);
}
