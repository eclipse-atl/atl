/*******************************************************************************
 * Copyright (c) 2010, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text;

import org.eclipse.jface.text.DefaultTextDoubleClickStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.m2m.atl.adt.ui.text.atl.OpenDeclarationUtils;
import org.eclipse.m2m.atl.common.IAtlLexems;

/**
 * This class permits to redefine the default double-clic strategy by selecting a block of
 * matching brackets or a word in an expression.
 * 
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
public class AtlTextDoubleClickStrategy extends DefaultTextDoubleClickStrategy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.DefaultTextDoubleClickStrategy.findExtendedDoubleClickSelection(IDocument,
	 *      int)
	 */
	protected IRegion findExtendedDoubleClickSelection(IDocument document, int offset) {
		AtlPairMatcher bracketMatcher = new AtlPairMatcher(IAtlLexems.BRACKETS);
		IRegion region = OpenDeclarationUtils.findWord(document, offset);
		if(region == null || region.getLength() == 0) {
			region = bracketMatcher.match(document, offset);
			if(region != null)
				region = new Region(region.getOffset()+1, region.getLength()-2);
		}
		return region;
	}

}
