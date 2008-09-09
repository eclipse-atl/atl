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
package org.eclipse.m2m.atl.adt.ui.text;

import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.m2m.atl.adt.ui.AtlPreferenceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;

/**
 * Its subclasses are only responsible for providing a list of preference keys based on which tokens are
 * generated and to use this tokens to define the rules controlling this scanner.
 */
public abstract class AbstractScanner extends RuleBasedScanner {

	private String[] propertyNamesBold;

	private String[] propertyNamesColor;

	private String[] propertyNamesItalic;

	private AtlTextTools textTools;

	private HashMap tokenMap = new HashMap();

	/**
	 * Creates an abstract ATL scanner. This needs to create firstable the tokens style, and afterwards
	 * associate them to their token value.
	 */
	public AbstractScanner(AtlTextTools texttools) {
		super();
		this.textTools = texttools;
		;
		initialize();
		setDefaultReturnToken(getToken(AtlPreferenceConstants.SYNTAX_DEFAULT_COLOR));
	}

	private void adaptToColorChange(Token token, PropertyChangeEvent event) {
		RGB rgb = null;

		Object value = event.getNewValue();
		if (value instanceof RGB)
			rgb = (RGB)value;
		else if (value instanceof String)
			rgb = StringConverter.asRGB((String)value);

		if (rgb != null) {

			String property = event.getProperty();

			if (getTextTools().getColorManager() instanceof AtlColorManager) {
				getTextTools().getColorManager().unbindColor(property);
				getTextTools().getColorManager().bindColor(property, rgb);
			}

			Object data = token.getData();
			if (data instanceof TextAttribute) {
				TextAttribute oldAttr = (TextAttribute)data;
				token.setData(new TextAttribute(getTextTools().getColorManager().getColor(property), oldAttr
						.getBackground(), oldAttr.getStyle()));
			}
		}
	}

	public void adaptToPreferenceChange(PropertyChangeEvent event) {
		String p = event.getProperty();
		int index = indexOf(p);
		Token token = getToken(getPropertyNamesColor()[index]);
		if (getPropertyNamesColor()[index].equals(p))
			adaptToColorChange(token, event);
		else if (getPropertyNamesBold()[index].equals(p))
			adaptToStyleChange(token, event, SWT.BOLD);
		else if (getPropertyNamesItalic()[index].equals(p))
			adaptToStyleChange(token, event, SWT.ITALIC);
	}

	private void adaptToStyleChange(Token token, PropertyChangeEvent event, int styleAttribute) {
		boolean eventValue = false;
		Object value = event.getNewValue();
		if (value instanceof Boolean) {
			eventValue = ((Boolean)value).booleanValue();
		} else if (IPreferenceStore.TRUE.equals(value)) {
			eventValue = true;
		}

		Object data = token.getData();
		if (data instanceof TextAttribute) {
			TextAttribute oldAttr = (TextAttribute)data;
			boolean activeValue = (oldAttr.getStyle() & styleAttribute) == styleAttribute;
			if (activeValue != eventValue) {
				token.setData(new TextAttribute(oldAttr.getForeground(), oldAttr.getBackground(),
						eventValue ? oldAttr.getStyle() | styleAttribute : oldAttr.getStyle()
								& ~styleAttribute));
			}
		}
	}

	/**
	 * Adds in the map the token whose key is <code>color</code>.
	 * 
	 * @param color
	 *            the string of the color
	 * @param boldKey
	 *            the bold style associated to the key
	 * @param italicKey
	 *            the italic style associated to the key
	 */
	private void addToken(String color, String boldKey, String italicKey) {
		getTextTools().getColorManager().add(color,
				PreferenceConverter.getColor(getTextTools().getPreferenceStore(), color));
		int style = getTextTools().getPreferenceStore().getBoolean(boldKey) ? SWT.BOLD : SWT.NORMAL;
		if (getTextTools().getPreferenceStore().getBoolean(italicKey)) {
			style |= SWT.ITALIC;
		}

		tokenMap.put(color, new Token(new TextAttribute(getTextTools().getColorManager().getColor(color),
				null, style)));
	}

	public boolean affectsBehavior(PropertyChangeEvent event) {
		return indexOf(event.getProperty()) >= 0;
	}

	/**
	 * Creates the list of rules controlling this scanner.
	 * 
	 * @return the list of rules
	 */
	protected abstract List createRules();

	/**
	 * Returns a list of constants matching the token.
	 * 
	 * @return the list of constants
	 */
	protected abstract String[] getPropertyNames();

	/**
	 * Gets the list of property names appended with the bold style.
	 * 
	 * @return the list of property names bold style
	 */
	private String[] getPropertyNamesBold() {
		if (propertyNamesBold == null) {
			int length = getPropertyNames().length;
			propertyNamesBold = new String[length];
			for (int i = 0; i < length; ++i) {
				propertyNamesBold[i] = getPropertyNames()[i] + AtlPreferenceConstants.BOLD_SUFFIX;
			}
		}
		return propertyNamesBold;
	}

	/**
	 * Gets the list of property names appended with the color.
	 * 
	 * @return the list of property names bold style
	 */
	private String[] getPropertyNamesColor() {
		if (propertyNamesColor == null) {
			int length = getPropertyNames().length;
			propertyNamesColor = new String[length];
			for (int i = 0; i < length; ++i) {
				propertyNamesColor[i] = getPropertyNames()[i] + AtlPreferenceConstants.COLOR_SUFFIX;
			}
		}
		return propertyNamesColor;
	}

	/**
	 * Gets the list of property names appended with the bold style.
	 * 
	 * @return the list of property names bold style
	 */
	private String[] getPropertyNamesItalic() {
		if (propertyNamesItalic == null) {
			int length = getPropertyNames().length;
			propertyNamesItalic = new String[length];
			for (int i = 0; i < length; ++i) {
				propertyNamesItalic[i] = getPropertyNames()[i] + AtlPreferenceConstants.ITALIC_SUFFIX;
			}
		}
		return propertyNamesItalic;
	}

	protected AtlTextTools getTextTools() {
		return textTools;
	}

	/**
	 * Return the token matching the color value.
	 * 
	 * @param color
	 *            the color name of the key
	 * @return the fetching token
	 */
	protected Token getToken(String color) {
		return (Token)tokenMap.get(color);
	}

	private int indexOf(String property) {
		if (property != null) {
			int length = getPropertyNamesColor().length;
			for (int i = 0; i < length; i++) {
				if (property.equals(getPropertyNamesColor()[i]) || property.equals(getPropertyNamesBold()[i])
						|| property.equals(getPropertyNamesItalic()[i]))
					return i;
			}
		}
		return -1;
	}

	/**
	 * Must be called after the constructor has been called.
	 */
	public final void initialize() {
		for (int i = 0; i < getPropertyNames().length; ++i) {
			addToken(getPropertyNamesColor()[i], getPropertyNamesBold()[i], getPropertyNamesItalic()[i]);
		}

		List rules = createRules();
		if (rules != null) {
			IRule[] result = new IRule[rules.size()];
			rules.toArray(result);
			setRules(result);
		}
	}

}
