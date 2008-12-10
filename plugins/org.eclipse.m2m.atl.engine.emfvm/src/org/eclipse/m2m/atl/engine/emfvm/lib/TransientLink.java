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
	private Map<Object,Object> sourceElements = new HashMap<Object,Object>();

	/** The target elements map. */
	private Map<Object,Object> targetElements = new HashMap<Object,Object>();

	/** The target elements list. */
	private List<Object> targetElementsList = new ArrayList<Object>();

	/** The variables of the link. */
	private Map<Object,Object> variables = new HashMap<Object,Object>();

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Map<Object,Object> getSourceElements() {
		return sourceElements;
	}

	public void setSourceElements(Map<Object,Object> sourceElements) {
		this.sourceElements = sourceElements;
	}

	public Map<Object,Object> getTargetElements() {
		return targetElements;
	}

	public void setTargetElements(Map<Object,Object> targetElements) {
		this.targetElements = targetElements;
	}

	public List<Object> getTargetElementsList() {
		return targetElementsList;
	}

	public void setTargetElementsList(List<Object> targetElementsList) {
		this.targetElementsList = targetElementsList;
	}

	public Map<Object,Object> getVariables() {
		return variables;
	}

	public void setVariables(Map<Object,Object> variables) {
		this.variables = variables;
	}
}
