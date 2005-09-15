package org.atl.engine.vm.adwp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Frédéric Jouault
 */
public class StringValue extends Value {

	private static Map values = new HashMap();

	public static StringValue valueOf(String value) {
		if(value == null) value = "<null>";
		value = value.intern();
		StringValue ret = (StringValue)values.get(value);

		if(ret == null) {
			ret = new StringValue(value);
			values.put(value, ret);
		}

		return ret;
	}

	private StringValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return value;
	}

	private String value;
}

