/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * This manager allows to share colors. A color is represented as a couple of a string and an RGB value.
 */
public class AtlColorManager implements ISharedTextColors {

	/**
	 * Tells the color manager <code>autoDisposeOnDisplayDispose</code> if it will be diposed in the same time
	 * that the display.
	 */
	private boolean autoDisposeOnDisplayDispose;

	/**
	 * <code>displayTable</code> stores a map for each display found.
	 */
	protected Map<Display, Map<RGB, Color>> displayTable = new HashMap<Display, Map<RGB, Color>>();

	/**
	 * <code>keyTable</code> is a hash map regrouping the string key of the color and the effective RGB color
	 * associated with.
	 */
	protected HashMap<String, RGB> keyTable = new HashMap<String, RGB>();

	/**
	 * Creates a new color manager setting to auto dispose it when the display is disposed.
	 */
	public AtlColorManager() {
		this(true);
	}

	/**
	 * Creates a new color manager setting the auto dispose on display dispose mode with the given parameter.
	 * 
	 * @param adodd
	 *            the auto dispose on display dispose mode
	 */
	public AtlColorManager(boolean adodd) {
		autoDisposeOnDisplayDispose = adodd;
	}

	/**
	 * Adds in the table a new color.
	 * 
	 * @param key
	 *            the string key representing the color
	 * @param rgb
	 *            the RGB color associated to the color
	 * @return the new object inserted in the table
	 */
	public Object add(String key, RGB rgb) {
		if (keyTable.get(key) != null)
			throw new UnsupportedOperationException();

		return keyTable.put(key, rgb);
	}

	/**
	 * Remembers the given color specification under the given key.
	 * 
	 * @param key
	 *            the color key
	 * @param rgb
	 *            the color specification
	 * @exception UnsupportedOperationException
	 *                if there is already a color specification remembered under the given key
	 */
	public void bindColor(String key, RGB rgb) {
		Object value = keyTable.get(key);
		if (value != null)
			throw new UnsupportedOperationException();

		keyTable.put(key, rgb);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.text.source.ISharedTextColors#dispose()
	 */
	public void dispose() {
		if (!autoDisposeOnDisplayDispose)
			dispose(Display.getCurrent());
	}

	/**
	 * Disposes the color manager with the values from the display.
	 * 
	 * @param display
	 *            the display to use
	 */
	protected void dispose(Display display) {
		Map<RGB, Color> colorTable = displayTable.get(display);
		if (colorTable != null) {
			Iterator<Color> e = colorTable.values().iterator();
			while (e.hasNext()) {
				Color color = e.next();
				if (color != null && !color.isDisposed()) {
					color.dispose();
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.text.source.ISharedTextColors#getColor(org.eclipse.swt.graphics.RGB)
	 */
	public Color getColor(RGB rgb) {
		if (rgb == null)
			return null;

		final Display display = Display.getCurrent();
		Map<RGB, Color> colorTable = displayTable.get(display);
		if (colorTable == null) {
			colorTable = new HashMap<RGB, Color>(10);
			displayTable.put(display, colorTable);
			if (autoDisposeOnDisplayDispose) {
				display.disposeExec(new Runnable() {
					public void run() {
						dispose(display);
					}
				});
			}
		}

		Color color = colorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			colorTable.put(rgb, color);
		}

		return color;
	}

	/**
	 * Gets the color resource matching the color string.
	 * 
	 * @param color
	 *            the key string of the color
	 * @return the matching color associated to the color key
	 */
	public Color getColor(String color) {
		if (color == null)
			return null;

		return getColor(keyTable.get(color));
	}

	/**
	 * Removes from the table the color given by the string key.
	 * 
	 * @param key
	 *            the string key of the color
	 * @return the object removed from the table
	 */
	public Object remove(String key) {
		return keyTable.remove(key);
	}

	/**
	 * Forgets the color specification remembered under the given key.
	 * 
	 * @param key
	 *            the color key
	 */
	public void unbindColor(String key) {
		keyTable.remove(key);
	}

}
