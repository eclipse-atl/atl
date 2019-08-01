/**
 * Copyright (c) 2004, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: ModelAdapter.java,v 1.1 2009/04/21 14:12:26 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.injector;

import java.util.Set;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public interface ModelAdapter {
	
	public Object get(Object ame_, String propertyName);

	public Object createElement(String typeName);

	public Set getElementsByType(String typeName);
	
	public Object getType(Object me_);

	public boolean isCandidate(Object ame, String typeName);
	
	public void set(Object ame, String prop, Object value);

	public String getString(Object ame, String propName);
	
	public boolean isAModelElement(Object me);
	
	public Object createEnumLiteral(String name);
	
	public Object getModel();
}