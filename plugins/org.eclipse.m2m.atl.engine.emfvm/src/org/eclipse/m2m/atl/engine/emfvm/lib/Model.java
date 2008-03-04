/**
 * Copyright (c) 2007, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: Model.java,v 1.2.4.1 2008/03/04 21:12:13 mbarbero Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author Mikael Barbero
 * @author Frederic Jouault
 *
 */
public interface Model {
	// returned value could (actually was) a non-ordered set Set, because there is no order in theory
	// BUT keeping the same order (i.e., resource/XMI order) typically makes things simpler
	public abstract Set getElementsByType(Object metaElement);

	public abstract ReferenceModel getReferenceModel();

	public abstract Object newElement(Object metaElement);

	public abstract Iterator getContents(); // is it necessary ?
	
	public abstract void save(String uri) throws IOException;

	public abstract void dispose();
}
