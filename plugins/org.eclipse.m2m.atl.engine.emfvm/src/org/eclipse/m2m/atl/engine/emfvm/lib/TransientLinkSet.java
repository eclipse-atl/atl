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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Stores a {@link TransientLink} Set.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class TransientLinkSet {

	private List links = new ArrayList();

	private Map linksByRule = new HashMap();

	private Map linksBySourceElement = new HashMap();

	private Map linksBySourceElementByRule = new HashMap();

	/**
	 * Adds a link to the set.
	 * 
	 * @param tl
	 *            the link
	 */
	public void addLink(TransientLink tl) {
		addLink2(tl, true);
	}

	/**
	 * Adds a link to the set.
	 * 
	 * @param tl
	 *            the link
	 * @param isDefault
	 *            true if the link is the default link
	 */
	public void addLink2(TransientLink tl, boolean isDefault) {
		links.add(tl); // necessary? not in RegularVM
		List linkList = (List)linksByRule.get(tl.getRule());
		if (linkList == null) {
			linkList = new ArrayList();
			linksByRule.put(tl.getRule(), linkList);
		}
		linkList.add(tl);

		Map linksBySourceElementForRule = (Map)linksBySourceElementByRule.get(tl.getRule());
		if (linksBySourceElementForRule == null) {
			linksBySourceElementForRule = new HashMap();
			linksBySourceElementByRule.put(tl.getRule(), linksBySourceElementForRule);
		}
		for (Iterator i = tl.getSourceElements().values().iterator(); i.hasNext();) {
			Object e = i.next();
			linksBySourceElementForRule.put(e, tl);
		}

		if (isDefault) {
			Object se = null;
			if (tl.getSourceElements().size() == 1) {
				se = tl.getSourceElements().values().iterator().next();
			} else {
				se = new Tuple(tl.getSourceElements());
			}
			TransientLink other = (TransientLink)linksBySourceElement.get(se);
			if (other != null) {
				// TODO: pretty print
				throw new RuntimeException("trying to register several rules as default for element " + se
						+ ": " + other.getRule() + " and " + tl.getRule());
			}
			linksBySourceElement.put(se, tl);
		}

		// TODO: links by target element?
	}

	/**
	 * Returns the links of a rule.
	 * 
	 * @param rule
	 *            the rule
	 * @return the links of a rule
	 */
	public Collection getLinksByRule(Object rule) {
		Collection ret = (Collection)linksByRule.get(rule);
		if (ret == null) {
			ret = Collections.EMPTY_LIST;
		}
		return ret;
	}

	/**
	 * Retrieve a link by the given source element.
	 * 
	 * @param sourceElement
	 *            the source element
	 * @return the link
	 */
	public TransientLink getLinkBySourceElement(Object sourceElement) {
		TransientLink ret = (TransientLink)linksBySourceElement.get(sourceElement);
		return ret;
	}

	/**
	 * Retrieve a link by the given rule and source element.
	 * 
	 * @param rule
	 *            the given rule
	 * @param sourceElement
	 *            the source element
	 * @return the link
	 */
	public TransientLink getLinkByRuleAndSourceElement(Object rule, Object sourceElement) {
		TransientLink ret = (TransientLink)linksBySourceElement.get(sourceElement);
		return ret;
	}
}
