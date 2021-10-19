/**
 * Copyright (c) 2004, 2008, 2014 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *     Dennis Wagelaar
 *
 * $Id: ParserWrapper.java,v 1.1 2009/04/21 14:12:27 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.injector.wrappers;

import java.io.Reader;
import java.util.Map;

import org.eclipse.m2m.atl.dsls.tcs.injector.TCSRuntime;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public abstract class ParserWrapper {
	// Token Types
	protected int TT_NL = -1;
	protected int TT_WS = -1;
	protected int TT_COMMENT = -1;
	protected final String pack = "org.eclipse.m2m.atl.dsls.tcs.injector."; //$NON-NLS-1$
	protected TCSRuntime runtime;

	public abstract Object parse(int tabSize, String name, String productionRule, Reader in,
			Map<?, ?> params) throws Exception;

	public abstract void reportError(Exception re);

	public abstract void setCommentsBefore(Object ame, Object token);

	public abstract void setCommentsAfter(Object ame_, Object token_);

	public abstract Object getLastToken();

	public abstract String getLocation(Object token);

	public abstract int getStartOffset(Object token);

	public abstract int getEndOffset(Object token);

	public void setRuntime(final TCSRuntime runtime) {
		this.runtime = runtime;
	}
}