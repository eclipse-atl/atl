/*
 * Created on 19 juil. 2004
 */
package org.atl.eclipse.adt.ui.text.atl;

import java.util.Comparator;


/**
 * @author C. MONTI for ATL team
 */
public class AtlCompletionProposalComparator implements Comparator {

    private boolean orderAlphabetically = false;

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(Object o1, Object o2) {
		AtlCompletionProposal p1 = (AtlCompletionProposal) o1;
		AtlCompletionProposal p2 = (AtlCompletionProposal) o2;

		if (! orderAlphabetically) {
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
