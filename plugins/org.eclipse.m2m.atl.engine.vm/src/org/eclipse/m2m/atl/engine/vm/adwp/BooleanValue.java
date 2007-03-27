package org.eclipse.m2m.atl.engine.vm.adwp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Frédéric Jouault
 */
public class BooleanValue extends Value {

	private static Map values = new HashMap();

	public static BooleanValue valueOf(boolean value_) {
		Boolean value = new Boolean(value_);
		BooleanValue ret = (BooleanValue)values.get(value);

		if(ret == null) {
			ret = new BooleanValue(value_);
			values.put(value, ret);
		}

		return ret;
	}

	private BooleanValue(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	public String toString() {
		return value ? "true" : "false";
	}

	private boolean value;
}

