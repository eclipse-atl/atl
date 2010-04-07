/*******************************************************************************
 * Copyright (c) 2009, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.swt.graphics.Image;

/**
 * Completion helper, dedicated to document parsing.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
public class AtlTemplateProposal extends TemplateProposal implements Comparable<AtlTemplateProposal> {

	private String information;

	/**
	 * Creates a new ATL Template proposal.
	 * 
	 * @param template
	 *            the template
	 * @param context
	 *            the template context
	 * @param region
	 *            the selected region
	 * @param image
	 *            the template image
	 * @param relevance
	 *            the template relevance
	 * @param information
	 *            the template information
	 */
	public AtlTemplateProposal(Template template, TemplateContext context, IRegion region, Image image,
			int relevance, String information) {
		super(template, context, region, image, relevance);
		this.information = information;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.templates.TemplateProposal#getAdditionalProposalInfo()
	 */
	@Override
	public String getAdditionalProposalInfo() {
		if (information != null) {
			int frameLength = 67;
			StringBuffer sb = new StringBuffer(this.information);
			for(int i=0;i<(sb.length()/frameLength);i++) {
				int end = ((i+1)*frameLength)+i;
				if(end > sb.length())
					end = sb.length();
				int offset = sb.substring(0, end).lastIndexOf(' ');
				if(offset != -1)
					sb.replace(offset, offset+1, "\n"); //$NON-NLS-1$
			}
			return super.getAdditionalProposalInfo() + "\n\n" + sb.toString(); //$NON-NLS-1$
		}
		return super.getAdditionalProposalInfo();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(AtlTemplateProposal o) {
		return getDisplayString().compareTo(o.getDisplayString());
	}

}
