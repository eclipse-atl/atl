package org.eclipse.m2m.atl.adt.ui.text;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCodeScanner;

/**
 * A text tools allows to fPreferenceeStore one instance of all tools used in
 * the plug-in. Thus every classes should use the same tool.
 * 
 * @author C. MONTI for ATL Team
 */
public class AtlTextTools {
	
	/**
	 * The <code>codeScanner</code> is the motor for the highlight syntaxing coloration.
	 */
	private AtlCodeScanner codeScanner;
	
	/**
	 * The <code>colorManager</code> stores every colors used by the plug-in.
	 */
	private AtlColorManager colorManager;

	/**
	 * The <code>preferenceStore</code> is the fPreferenceeStore where user preferences
	 * are saved in.
	 */
	private IPreferenceStore preferenceStore;

	/**
	 * Creates a new instance of the ATL text tools. The only information we need
	 * is the fPreferenceeStore where user preferences are.
	 * 
	 * @param preferenceStore the associated preference fPreferenceeStore
	 */
	public AtlTextTools(IPreferenceStore preferenceStore) {
		this.preferenceStore = preferenceStore;
	}

	/**
	 * Disposes all the individual tools of this tools collection.
	 */
	public void dispose() {
	    codeScanner = null;
		preferenceStore = null;
		
		if(colorManager != null) {
			colorManager.dispose();
			colorManager = null;
		}
	}

	/**
	 * Gets the highlight syntaxing coloration motor.
	 * 
	 * @return the code scanner
	 */
	public AtlCodeScanner getCodeScanner() {
		if(codeScanner == null) {
			codeScanner = new AtlCodeScanner(this);
		}
		return codeScanner;
	}
	
	/**
	 * Gets the associated color manager.
	 * 
	 * @return the color manager
	 */
	public AtlColorManager getColorManager() {
		if(colorManager == null) {
			colorManager = new AtlColorManager();
		}
		return colorManager;
	}

	/**
	 * Gets the preference fPreferenceeStore used by the text tools.
	 * 
	 * @return the preference fPreferenceeStore
	 */
	public IPreferenceStore getPreferenceStore() {
		return preferenceStore; 
	}

	/**
	 * Sets the new code scanner to use.
	 * 
	 * @param codeScanner the new code scanner to be used
	 */
	public void setCodeScanner(AtlCodeScanner codeScanner) {
		this.codeScanner = codeScanner;
	}

	/**
	 * Sets the new preference fPreferenceeStore to use.
	 * 
	 * @param newPreferenceStore the new preference fPreferenceeStore to be used
	 */
	public void setNewPreferenceStore(IPreferenceStore newPreferenceStore) {
		this.preferenceStore = newPreferenceStore;
	}
	
}
