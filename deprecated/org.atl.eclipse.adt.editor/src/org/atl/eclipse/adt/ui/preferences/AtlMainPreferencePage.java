/*
 * Created on 23 juil. 2004
 */
package org.atl.eclipse.adt.ui.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author C. MONTI for ATL team
 */
public class AtlMainPreferencePage extends AbstractPreferencePage {

    public AtlMainPreferencePage() {
        super(AtlPreferencesMessages.getString("MainPreferencePage.description"));
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
     */
    protected Control createContents(Composite parent) {
        return null;
    }

}
