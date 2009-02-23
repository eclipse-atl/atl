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
 * $Id: IModelAdapter.java,v 1.4 2009/02/23 15:12:02 wpiers Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.adapter;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;

/**
 * The EMFVM execution interface. Defines a set of methods dedicated to the execution of transformations.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a> *
 */
public interface IModelAdapter {

	/**
	 * Gets a value from an object in the given frame.
	 * 
	 * @param frame
	 *            the {@link AbstractStackFrame}
	 * @param eo
	 *            the object
	 * @param name
	 *            the name of the attribute / feature which contains the value
	 * @return the value
	 */
	Object get(AbstractStackFrame frame, Object eo, String name);

	/**
	 * Sets a value on an object in the given frame.
	 * 
	 * @param frame
	 *            the {@link AbstractStackFrame}
	 * @param eo
	 *            the object
	 * @param name
	 *            the name of the attribute / feature which will contain the value
	 * @param value
	 *            the value to set
	 */
	void set(AbstractStackFrame frame, Object eo, String name, Object value);

	/**
	 * Unsets a value on an object in the given frame.
	 * 
	 * @param frame
	 *            the {@link AbstractStackFrame}
	 * @param eo
	 *            the object
	 * @param name
	 *            the name of the attribute / feature which will contain the value
	 */
	void unSet(AbstractStackFrame frame, Object eo, String name);

	/**
	 * Deletes an object on the given frame.
	 * 
	 * @param frame
	 *            the {@link AbstractStackFrame}
	 * @param eo
	 *            the object to delete
	 */
	void delete(AbstractStackFrame frame, Object eo);

	/**
	 * Registers a map of supertypes.
	 * 
	 * @param vmSupertypes
	 *            the map
	 */
	void registerVMSupertypes(Map<Class<?>, List<Class<?>>> vmSupertypes);

	/**
	 * Registers a map of operations.
	 * 
	 * @param vmTypeOperations
	 *            the map
	 */
	void registerVMTypeOperations(Map<Object, Map<String, Operation>> vmTypeOperations);

	/**
	 * Displays in a readable format the given object.
	 * 
	 * @param execEnv
	 *            the current execEnv
	 * @param out
	 *            the output stream
	 * @param value
	 *            the object to display
	 * @return true if display has been successful
	 */
	boolean prettyPrint(ExecEnv execEnv, PrintStream out, Object value);

	/**
	 * Returns the type of a given element.
	 * 
	 * @param value
	 *            the type
	 * @return the type
	 */
	Object getType(Object value);

	/**
	 * Returns the list of supertypes of a given type.
	 * 
	 * @param type
	 *            the type
	 * @return the list of supertypes
	 */
	List<Object> getSupertypes(Object type);

	/**
	 * Sets "allow inter-model references" for this model adapter.
	 * 
	 * @param allowInterModelRefs
	 *            true if intermodel references are allowed
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	void setAllowInterModelReferences(boolean allowInterModelRefs);

	/**
	 * Invokes a method.
	 * 
	 * @param method
	 *            the method to invoke
	 * @param self
	 *            the object context
	 * @param arguments
	 *            the call arguments
	 * @return the method result
	 */
	Object invoke(Method method, Object self, Object[] arguments);

	/**
	 * Finalizes the given model.
	 * 
	 * @param model
	 *            the given model
	 */
	void finalizeModel(IModel model);
}
