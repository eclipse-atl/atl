package org.atl.engine.vm.nativelib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.atl.engine.vm.StackFrame;

/**
 * ASMTransientLinkSet represents a set of traceability links.
 * @author Frédéric Jouault
 */
public class ASMTransientLinkSet extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("TransientLinkSet", getOclAnyType());

	public ASMTransientLinkSet() {
		super(myType);
	}

	public String toString() {
		StringBuffer ret = new StringBuffer("TransientLinkSet {");

		for(Iterator i = linksBySourceElement.values().iterator() ; i.hasNext() ; ) {
			ret.append(i.next());
			if(i.hasNext()) {
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
	
	public static void addLink2(StackFrame frame, ASMTransientLinkSet self, ASMTransientLink link, ASMBoolean isDefault) {
		ASMSequence s = (ASMSequence)self.linksByRule.get(ASMTransientLink.getRule(frame, link));

		if(s == null) {
			s = new ASMSequence();
			self.linksByRule.put(ASMTransientLink.getRule(frame, link), s);
		}
		s.add(link);
		if(isDefault.getSymbol()) {
			for(Iterator i = link.getSourceElements().iterator() ; i.hasNext() ; ) {
				Object e = i.next();
				if(self.linksBySourceElement.containsKey(e)) {
					frame.printStackTrace("trying to register several rules as default for element " + e);
				}
				self.linksBySourceElement.put(e, link);
			}
		}
		for(Iterator i = link.getTargetElements().iterator() ; i.hasNext() ; ) {
			Object o = i.next();
			if(o instanceof ASMCollection) {
				for(Iterator j = ((ASMCollection)o).iterator() ; j.hasNext() ; ) {
					self.linksByTargetElement.put(j.next(), link);
				}
			} else {
				self.linksByTargetElement.put(o, link);
			}
		}
	}

	public static ASMSequence getLinksByRule(StackFrame frame, ASMTransientLinkSet self, ASMOclAny rule) {
		ASMSequence ret = (ASMSequence)self.linksByRule.get(rule);

		if(ret == null) {
			ret = new ASMSequence();
		}

		return ret;
	}

	public static ASMOclAny getLinkBySourceElement(StackFrame frame, ASMTransientLinkSet self, ASMOclAny sourceElement) {
		ASMOclAny ret = (ASMOclAny)self.linksBySourceElement.get(sourceElement);

		if(ret == null) {
			ret = new ASMOclUndefined();
		}

		return ret;
	}

	public static ASMOclAny getLinkByTargetElement(StackFrame frame, ASMTransientLinkSet self, ASMOclAny targetElement) {
		ASMOclAny ret = (ASMOclAny)self.linksByTargetElement.get(targetElement);

		if(ret == null) {
			ret = new ASMOclUndefined();
		}

		return ret;
	}

	private Map linksByRule = new HashMap();
	private Map linksBySourceElement = new HashMap();
	private Map linksByTargetElement = new HashMap();
}

