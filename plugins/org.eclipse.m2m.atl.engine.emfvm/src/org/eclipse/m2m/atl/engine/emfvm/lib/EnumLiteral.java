package org.eclipse.m2m.atl.engine.emfvm.lib;

import org.eclipse.emf.common.util.Enumerator;

public class EnumLiteral implements HasFields {

	private String name;

	public EnumLiteral() {}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

	public Object get(StackFrame frame, Object name) {
		if("name".equals(name)) {
			return this.name;
		} else {
			throw new VMException(frame, "error accessing EnumLiteral." + name);
		}
	}

	public void set(StackFrame frame, Object name, Object value) {
		if("name".equals(name) && (value instanceof String)) {
			this.name = (String)value;
		} else {
			throw new VMException(frame, "error assigning " + value + " to EnumLiteral." + name);
		}
	}
	
	public boolean equals(Object arg) {
		boolean ret = false;
		if (arg instanceof Enumerator) {
			ret = toString().equals(((Enumerator)arg).getLiteral());
		} else if (arg instanceof EnumLiteral) {
			ret = toString().equals(arg.toString());
		}
		return ret;
	}
}
