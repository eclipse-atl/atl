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
package org.eclipse.m2m.atl.adt.ui.text.atl;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.swt.graphics.Image;

/**
 * This class allows us to split an installed template description so that it fits in
 * the completion panel.
 * 
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
public class AtlInstalledTemplateProposal extends AtlTemplateProposal {

	public AtlInstalledTemplateProposal(Template template, TemplateContext context, IRegion region,
			Image image, int relevance, String information) {
		super(template, context, region, image, relevance, information);
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.text.templates.TemplateProposal#getDisplayString()
	 */
	public String getDisplayString() {
		return this.getTemplate().getName() + " - " + this.getTemplate().getDescription().split(":")[0]; //$NON-NLS-1$ //$NON-NLS-2$
	}

}
