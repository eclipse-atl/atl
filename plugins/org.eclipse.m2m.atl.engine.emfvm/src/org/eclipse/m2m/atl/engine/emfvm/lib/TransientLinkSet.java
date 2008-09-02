/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TransientLinkSet {

	public List links = new ArrayList();
	public Map linksByRule = new HashMap();
	public Map linksBySourceElement = new HashMap();
	public Map linksBySourceElementByRule = new HashMap();
	
	public void addLink(TransientLink tl) {
		addLink2(tl, true);
	}
	
	public void addLink2(TransientLink tl, boolean isDefault) {
		links.add(tl);		// necessary? not in RegularVM
		List links = (List)linksByRule.get(tl.rule);
		if(links == null) {
			links = new ArrayList();
			linksByRule.put(tl.rule, links);
		}
		links.add(tl);

		Map linksBySourceElementForRule = (Map)linksBySourceElementByRule.get(tl.rule);
		if(linksBySourceElementForRule == null) {
			linksBySourceElementForRule = new HashMap();
			linksBySourceElementByRule.put(tl.rule, linksBySourceElementForRule);
		}
		for(Iterator i = tl.sourceElements.values().iterator() ; i.hasNext() ; ) {
			Object e = i.next();
			linksBySourceElementForRule.put(e, tl);
		}
		
		if(isDefault) {
			Object se = null;
			if(tl.sourceElements.size() == 1) {
				se = tl.sourceElements.values().iterator().next();
			} else {
				se = new Tuple(tl.sourceElements);
			}
			TransientLink other = (TransientLink)linksBySourceElement.get(se);
			if(other != null) {
				// TODO: pretty print
				throw new RuntimeException("trying to register several rules as default for element " + se + ": " + other.rule + " and " + tl.rule);
			}
			linksBySourceElement.put(se, tl);
		}
		
		// TODO: links by target element?
	}

	public Collection getLinksByRule(Object rule) {
		Collection ret = (Collection)linksByRule.get(rule);
		if(ret == null)
			ret = Collections.EMPTY_LIST;
		return ret;
	}
	
	public TransientLink getLinkBySourceElement(Object sourceElement) {
		TransientLink ret = (TransientLink)linksBySourceElement.get(sourceElement);
		return ret;
	}
	
	public TransientLink getLinkByRuleAndSourceElement(Object rule, Object sourceElement) {
		TransientLink ret = (TransientLink)linksBySourceElement.get(sourceElement);
		return ret;
	}
}
