package org.atl.engine.vm;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Frédéric Jouault
 */
public abstract class ASMWriter {

	public abstract void print(ASM asm);

	protected int getCPIndex(String s) {
		Integer ret = (Integer)cpMap.get(s);

		if(ret == null) {
			ret = new Integer(lastCPIndex++);
			cpMap.put(s, ret);
			cp.add(s);
		}

		return ret.intValue();
	}

	protected List getConstantPool() {
		return cp;
	}

	private int lastCPIndex = 0;
	private List cp = new ArrayList();
	private Map cpMap = new HashMap();
}

