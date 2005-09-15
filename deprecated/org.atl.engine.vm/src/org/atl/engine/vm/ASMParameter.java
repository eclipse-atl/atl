package org.atl.engine.vm;

/**
 * @author Frédéric Jouault
 */
public class ASMParameter {

	public ASMParameter(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public String toString() {
		return name + " : " + type;
	}

	private String name;
	private String type;
}

