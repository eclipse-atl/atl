/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Andres Yie (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * ASMTransientLinkSet represents a set of traceability links.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMTransientLinkSet extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("TransientLinkSet", getOclAnyType());

	public ASMTransientLinkSet() {
		super(myType);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer("TransientLinkSet {");

		for (Iterator i = linksBySourceElement.values().iterator(); i.hasNext();) {
			ret.append(i.next());
			if (i.hasNext()) {
				ret.append(", ");
			}
		}

		ret.append("}");

		return ret.toString();
	}

	// Native Operations below

	public static void addLink(StackFrame frame, ASMTransientLinkSet self, ASMTransientLink link) {
		addLink2(frame, self, link, new ASMBoolean(true));
	}

	public static void addLink2(StackFrame frame, ASMTransientLinkSet self, ASMTransientLink link,
			ASMBoolean isDefault) {
		ASMOclAny rule = ASMTransientLink.getRule(frame, link);
		ASMSequence s = (ASMSequence)self.linksByRule.get(rule);

		if (s == null) {
			s = new ASMSequence();
			self.linksByRule.put(rule, s);
		}
		self.links.add(link);
		s.add(link);

		Map linksBySourceElements2 = (Map)self.linksBySourceElementByRule.get(rule);
		if (linksBySourceElements2 == null) {
			linksBySourceElements2 = new HashMap();
			self.linksBySourceElementByRule.put(rule, linksBySourceElements2);
		}
		for (Iterator i = link.getSourceElements().iterator(); i.hasNext();) {
			Object e = i.next();
			linksBySourceElements2.put(e, link);
		}

		if (isDefault.getSymbol()) {
			Object se;
			if (link.getSourceElements().size() == 1) {
				se = link.getSourceElements().iterator().next();
			} else {
				se = new ASMTuple();
				for (Iterator i = link.getSourceMap().keySet().iterator(); i.hasNext();) {
					String k = (String)i.next();
					((ASMTuple)se).set(frame, k, (ASMOclAny)link.getSourceMap().get(k));
				}
			}
			ASMTransientLink other = (ASMTransientLink)self.linksBySourceElement.get(se);
			if (other != null) {
				frame.printStackTrace("Trying to register several rules as default for element " + se + ": "
						+ ASMTransientLink.getRule(frame, other) + " and " + rule);
			}
			self.linksBySourceElement.put(se, link);
		}
		for (Iterator i = link.getTargetElements().iterator(); i.hasNext();) {
			Object o = i.next();
			if (o instanceof ASMCollection) {
				for (Iterator j = ((ASMCollection)o).iterator(); j.hasNext();) {
					self.linksByTargetElement.put(j.next(), link);
				}
			} else {
				self.linksByTargetElement.put(o, link);
			}
		}
	}

	public static ASMSequence getLinksByRule(StackFrame frame, ASMTransientLinkSet self, ASMOclAny rule) {
		ASMSequence ret = (ASMSequence)self.linksByRule.get(rule);

		if (ret == null) {
			ret = new ASMSequence();
		}

		return ret;
	}

	public static ASMOclAny getLinkBySourceElement(StackFrame frame, ASMTransientLinkSet self,
			ASMOclAny sourceElement) {
		ASMOclAny ret = (ASMOclAny)self.linksBySourceElement.get(sourceElement);

		if (ret == null) {
			ret = new ASMOclUndefined();
		}

		return ret;
	}

	public static ASMOclAny getLinkByRuleAndSourceElement(StackFrame frame, ASMTransientLinkSet self,
			ASMOclAny rule, ASMOclAny sourceElement) {
		Map map = (Map)self.linksBySourceElementByRule.get(rule);
		ASMOclAny ret = null;

		if (map != null) {
			ret = (ASMOclAny)map.get(sourceElement);
		}
		if (ret == null) {
			ret = new ASMOclUndefined();
		}

		return ret;
	}

	public static ASMOclAny getLinkByTargetElement(StackFrame frame, ASMTransientLinkSet self,
			ASMOclAny targetElement) {
		ASMOclAny ret = (ASMOclAny)self.linksByTargetElement.get(targetElement);

		if (ret == null) {
			ret = new ASMOclUndefined();
		}

		return ret;
	}
	
	/**
	 * This method allows for retrieving all the TransientLinks in a Sequence
	 * @param frame
	 * @param self
	 * @return A Sequence of TransientLinks is returned.
	 * @author Andres Yie <ayiegarz@vub.ac.be>
	 */
	public static ASMSequence getAllLinks(StackFrame frame, ASMTransientLinkSet self) {
		return self.links;
	}

	private Map linksByRule = new HashMap();

	private Map linksBySourceElementByRule = new HashMap();

	private Map linksBySourceElement = new HashMap();

	private Map linksByTargetElement = new HashMap();
	
	/**
	 * The attribute links store the sequence of all TransientLinks
	 */
	private ASMSequence links = new ASMSequence();
}
