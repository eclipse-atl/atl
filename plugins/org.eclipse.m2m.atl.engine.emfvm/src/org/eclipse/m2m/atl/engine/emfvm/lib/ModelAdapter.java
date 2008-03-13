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
 * $Id: ModelAdapter.java,v 1.1.2.2 2008/03/13 16:21:46 dwagelaar Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Mikaël Barbero
 *
 */
public interface ModelAdapter {

	public abstract Object get(StackFrame frame, Object eo, String name);
	
	public abstract void set(StackFrame frame, Object eo, String name, Object value);
	
	public abstract void delete(StackFrame frame, Object eo);
	
	public abstract void registerVMSupertypes(Map vmSupertypes);
	
	public abstract void registerVMTypeOperations(Map vmTypeOperations);
	
	public abstract boolean prettyPrint(PrintStream out, Object value);
	
	public abstract Object getType(Object value);
	
	public abstract List getSupertypes(Object type);
	
	public Model getModelOf(Object element);
	
	/**
	 * Sets "allow inter-model references" for this model adapter.
	 * @param allowInterModelRefs
	 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
	 */
	public abstract void setAllowInterModelReferences(boolean allowInterModelRefs);
}
