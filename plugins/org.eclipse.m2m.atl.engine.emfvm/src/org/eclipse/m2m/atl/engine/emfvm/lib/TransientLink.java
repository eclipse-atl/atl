/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Stores a transient link.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class TransientLink {

	/** The rule making the link. */
	private String rule;

	/** The source elements map. */
	private Map sourceElements = new HashMap();

	/** The target elements map. */
	private Map targetElements = new HashMap();

	/** The target elements list. */
	private List targetElementsList = new ArrayList();

	/** The variables of the link. */
	private Map variables = new HashMap();

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Map getSourceElements() {
		return sourceElements;
	}
	
	public Map getSourceElementsMap() {
		return getSourceElements();
	}

	public void setSourceElements(Map sourceElements) {
		this.sourceElements = sourceElements;
	}

	public Map getTargetElements() {
		return targetElements;
	}
	
	public Map getTargetElementsMap() {
		return getTargetElements();
	}

	public void setTargetElements(Map targetElements) {
		this.targetElements = targetElements;
	}

	public List getTargetElementsList() {
		return targetElementsList;
	}

	public void setTargetElementsList(List targetElementsList) {
		this.targetElementsList = targetElementsList;
	}

	public Map getVariables() {
		return variables;
	}

	public void setVariables(Map variables) {
		this.variables = variables;
	}
}
