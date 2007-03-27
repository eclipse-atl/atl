package org.eclipse.m2m.atl.engine.vm.adwp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Frédéric Jouault
 */
public class RealValue extends Value {

	private static Map values = new HashMap();

	public static RealValue valueOf(double value_) {
		Double value = new Double(value_);
		RealValue ret = (RealValue)values.get(value);

		if(ret == null) {
			ret = new RealValue(value_);
			values.put(value, ret);
		}

		return ret;
	}

	private RealValue(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public String toString() {
		return "" + value;
	}

	private double value;
}

