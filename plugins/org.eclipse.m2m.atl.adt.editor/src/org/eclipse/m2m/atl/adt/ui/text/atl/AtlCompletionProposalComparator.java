/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import java.util.Comparator;

/**
 * The completion proposals comparator.
 */
public class AtlCompletionProposalComparator implements Comparator<AtlCompletionProposal> {

	private boolean orderAlphabetically;

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(AtlCompletionProposal o1, AtlCompletionProposal o2) {
		AtlCompletionProposal p1 = o1;
		AtlCompletionProposal p2 = o2;

		if (!orderAlphabetically) {
			int relevanceDif = p2.getRelevance() - p1.getRelevance();
			if (relevanceDif != 0) {
				return relevanceDif;
			}
		}

		return p1.getDisplayString().compareToIgnoreCase(p2.getDisplayString());
	}

	public void setOrderAlphabetically(boolean order) {
		orderAlphabetically = order;
	}

}
