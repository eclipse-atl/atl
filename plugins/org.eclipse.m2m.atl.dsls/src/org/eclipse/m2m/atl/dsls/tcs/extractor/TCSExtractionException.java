/**
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: TCSExtractionException.java,v 1.1 2009/04/21 14:12:26 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.extractor;

/**
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 *
 */
public class TCSExtractionException extends RuntimeException {
	
	private static final long serialVersionUID = 8291141709543223208L;

	public TCSExtractionException(String msg, Throwable cause) {
		super(msg, cause);
	}
}