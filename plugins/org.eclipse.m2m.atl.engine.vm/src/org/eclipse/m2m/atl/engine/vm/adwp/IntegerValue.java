package org.eclipse.m2m.atl.engine.vm.adwp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Frédéric Jouault
 */
public class IntegerValue extends Value {

	private static Map values = new HashMap();

	public static IntegerValue valueOf(int value_) {
		Integer value = new Integer(value_);
		IntegerValue ret = (IntegerValue)values.get(value);

		if(ret == null) {
			ret = new IntegerValue(value_);
			values.put(value, ret);
		}

		return ret;
	}

	private IntegerValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return "" + value;
	}

	private int value;
}

