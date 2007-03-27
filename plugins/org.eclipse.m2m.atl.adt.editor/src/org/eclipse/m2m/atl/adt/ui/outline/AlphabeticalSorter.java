/*
 * Created on 21 avr. 2004
 */
package org.eclipse.m2m.atl.adt.ui.outline;

import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @author idrissi
 */
public class AlphabeticalSorter extends ViewerSorter 
{ 
	
	 /*
      * @see ViewerSorter#category(Object)
      */
    public int category(Object element) {
    	return 1;
        /*if(element instanceof Helper) return 1;
          if(element instanceof Rule) return 2;
          return 3;*/
    }

	/*
     * @see ViewerSorter#compare(Viewer, Object, Object)
     */
    public int compare(Viewer viewer, Object e1, Object e2) {
		int cat1 = category(e1);
		int cat2 = category(e2);
		if (cat1 != cat2)
			return cat1 - cat2;
		String name1, name2;
		if (viewer == null || !(viewer instanceof ContentViewer)) {
			name1 = e1.toString();
			name2 = e2.toString();
		} 
		else {
			IBaseLabelProvider prov = ((ContentViewer) viewer).getLabelProvider();
			if (prov instanceof ILabelProvider) {
				ILabelProvider lprov = (ILabelProvider) prov;
				name1 = lprov.getText(e1);
				name2 = lprov.getText(e2);
			} 
			else {
				name1 = e1.toString();
				name2 = e2.toString();
			}
		}
		if (name1 == null)
			name1 = "";
		if (name2 == null)
			name2 = "";
		return collator.compare(name1, name2);
	}
}
