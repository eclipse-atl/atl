package org.atl.engine.vm.adwp;

import java.util.List;

/**
 * @author Frédéric Jouault
 */
public abstract class ObjectReference extends Value {

	protected ObjectReference(int id) {
		this.id = id;
	}

	public abstract Value get(String propName);

	public abstract void set(String propName, Value value);

	public abstract Value call(String opName, List args);

	public int getId() {
		return id;
	}

	public String toString() {
		return "Object " + id;
	}

	protected int id;
}

