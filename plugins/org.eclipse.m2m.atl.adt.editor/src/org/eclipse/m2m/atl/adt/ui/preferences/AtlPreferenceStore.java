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
package org.eclipse.m2m.atl.adt.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

/**
 * A preference fPreferenceeStore organizes the user preferences with those in place.
 */
public class AtlPreferenceStore implements IPreferenceStore {
	
	/**
	 * This is a simple generic class.
	 * 
	 * @author C. MONTI for ATL Team
	 */
	public static final class Descriptor {
		
	}
	
	/**
	 * Describes a preference key. It has to match a descriptor (a kind of classes) and
	 * a name that determines what key it is.
	 * 
	 * @author C. MONTI for ATL Team
	 */
	public static class Key {
		Descriptor descriptor;
		String key;
		
		public Key(Descriptor descriptor, String key) {
			this.descriptor = descriptor;
			this.key = key;
		}
	}
	
	private class PropertyListener implements IPropertyChangeListener {
				
		/*
		 * @see IPropertyChangeListener#propertyChange(PropertyChangeEvent)
		 */
		public void propertyChange(PropertyChangeEvent event) {
			Key key = findKey(event.getProperty());
			if (key != null)
				setProperty(parent, key, store); 
		}
	}
	
	public static final Descriptor BOOLEAN = new Descriptor();
	public static final Descriptor DOUBLE = new Descriptor();
	public static final Descriptor FLOAT = new Descriptor();
	public static final Descriptor INT = new Descriptor();
	public static final Descriptor LONG = new Descriptor();
	public static final Descriptor STRING = new Descriptor();
	
	private Key[] keys;
	private boolean needsSaving;
	private IPreferenceStore parent;
	private PropertyListener propertyListener ;
	private IPreferenceStore store;
	
	/**
	 * Creates a new instance of ATL preference fPreferenceeStore.
	 * 
	 * @param parent the parent fPreferenceeStore let's this one restore to the current value the preferences
	 * @param keys this array is a list of keys for initialization
	 */
	public AtlPreferenceStore(IPreferenceStore parent, Key[] keys) {
		this.parent = parent;
		this.keys = keys;
		this.store = new PreferenceStore();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#addPropertyChangeListener(org.eclipse.jface.util.IPropertyChangeListener)
	 */
	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		store.addPropertyChangeListener(listener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#contains(java.lang.String)
	 */
	public boolean contains(String name) {
		return store.contains(name);
	}
	
	/**
	 * Gets a key matching its name.
	 * 
	 * @param name the string describing the key
	 * @return the key if it exists or null
	 */
	private Key findKey(String name) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].key.equals(name))
				return keys[i];
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#firePropertyChangeEvent(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void firePropertyChangeEvent(String name, Object oldValue, Object newValue) {
		store.firePropertyChangeEvent(name, oldValue, newValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getBoolean(java.lang.String)
	 */
	public boolean getBoolean(String name) {
		return store.getBoolean(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getDefaultBoolean(java.lang.String)
	 */
	public boolean getDefaultBoolean(String name) {
		return parent.getDefaultBoolean(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getDefaultDouble(java.lang.String)
	 */
	public double getDefaultDouble(String name) {
		return parent.getDefaultDouble(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getDefaultFloat(java.lang.String)
	 */
	public float getDefaultFloat(String name) {
		return parent.getDefaultFloat(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getDefaultInt(java.lang.String)
	 */
	public int getDefaultInt(String name) {
		return parent.getDefaultInt(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getDefaultLong(java.lang.String)
	 */
	public long getDefaultLong(String name) {
		return parent.getDefaultLong(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getDefaultString(java.lang.String)
	 */
	public String getDefaultString(String name) {
		return parent.getDefaultString(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getDouble(java.lang.String)
	 */
	public double getDouble(String name) {
		return store.getDouble(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getFloat(java.lang.String)
	 */
	public float getFloat(String name) {
		return store.getFloat(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getInt(java.lang.String)
	 */
	public int getInt(String name) {
		return store.getInt(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getLong(java.lang.String)
	 */
	public long getLong(String name) {
		return store.getLong(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#getString(java.lang.String)
	 */
	public String getString(String name) {
		return store.getString(name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#isDefault(java.lang.String)
	 */
	public boolean isDefault(String name) {
		return store.isDefault(name);
	}
	
	/**
	 * Loads every preferences from the parent fPreferenceeStore to this one.
	 */
	public void load() {
		for (int i = 0; i < keys.length; i++) {
			setProperty(parent, keys[i], store);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#needsSaving()
	 */
	public boolean needsSaving() {
		return needsSaving;
	}
	
	/**
	 * Propagates the preferences of this fPreferenceeStore to the parent one.
	 */
	public void propagate() {
		for (int i = 0; i < keys.length; i++) {
			setProperty(store, keys[i], parent);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#putValue(java.lang.String, java.lang.String)
	 */
	public void putValue(String name, String value) {
		if(findKey(name) != null)
			store.putValue(name, value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#removePropertyChangeListener(org.eclipse.jface.util.IPropertyChangeListener)
	 */
	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		store.removePropertyChangeListener(listener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setDefault(java.lang.String, boolean)
	 */
	public void setDefault(String name, boolean value) {
		if(findKey(name) != null)
			store.setDefault(name, value);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setDefault(java.lang.String, double)
	 */
	public void setDefault(String name, double value) {
		if(findKey(name) != null)
			store.setDefault(name, value);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setDefault(java.lang.String, float)
	 */
	public void setDefault(String name, float value) {
		if(findKey(name) != null)
			store.setDefault(name, value);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setDefault(java.lang.String, int)
	 */
	public void setDefault(String name, int value) {
		if(findKey(name) != null)
			store.setDefault(name, value);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setDefault(java.lang.String, long)
	 */
	public void setDefault(String name, long value) {
		if(findKey(name) != null)
			store.setDefault(name, value);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setDefault(java.lang.String, java.lang.String)
	 */
	public void setDefault(String name, String value) {
		if(findKey(name) != null)
			store.setDefault(name, value);
		needsSaving = true;
	}
	
	/**
	 * Sets the value of the source key in the target fPreferenceeStore.
	 * 
	 * @param source the source fPreferenceeStore
	 * @param key the key to copy
	 * @param target the target fPreferenceeStore
	 */
	private void setProperty(IPreferenceStore source, Key key, IPreferenceStore target) {
		Descriptor d = key.descriptor;
		if (BOOLEAN == d) {
			target.setValue(key.key, source.getBoolean(key.key));
		} else if (DOUBLE == d) {
			target.setValue(key.key, source.getDouble(key.key));
		} else if (FLOAT == d) {
			target.setValue(key.key, source.getFloat(key.key));
		} else if (INT == d) {
			target.setValue(key.key, source.getInt(key.key));
		} else if (LONG == d) {
			target.setValue(key.key, source.getLong(key.key));
		} else if (STRING == d) {
			target.setValue(key.key, source.getString(key.key));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setToDefault(java.lang.String)
	 */
	public void setToDefault(String name) {
		store.setToDefault(name);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setValue(java.lang.String, boolean)
	 */
	public void setValue(String name, boolean value) {
		if (findKey(name) != null)
			store.setValue(name, value);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setValue(java.lang.String, double)
	 */
	public void setValue(String name, double value) {
		if (findKey(name) != null)
			store.setValue(name, value);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setValue(java.lang.String, float)
	 */
	public void setValue(String name, float value) {
		if (findKey(name) != null)
			store.setValue(name, value);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setValue(java.lang.String, int)
	 */
	public void setValue(String name, int value) {
		if (findKey(name) != null)
			store.setValue(name, value);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setValue(java.lang.String, long)
	 */
	public void setValue(String name, long value) {
		if (findKey(name) != null)
			store.setValue(name, value);
		needsSaving = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferenceStore#setValue(java.lang.String, java.lang.String)
	 */
	public void setValue(String name, String value) {
		if (findKey(name) != null)
			store.setValue(name, value);
		needsSaving = true;
	}
	
	public void start() {
		if (propertyListener == null) {
			propertyListener = new PropertyListener();
			parent.addPropertyChangeListener(propertyListener);
		}
	}
	
	public void stop() {
		if (propertyListener != null)  {
			parent.removePropertyChangeListener(propertyListener);
			propertyListener = null;
		}
	}
	
}
