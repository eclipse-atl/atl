/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm.adwp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Frédéric Jouault
 */
public class RemoteObjectReference extends ObjectReference {

	private static Map values = new HashMap();

	public static ObjectReference valueOf(ADWPDebugger debugger, int id_) {
		Integer id = new Integer(id_);
		List key = new ArrayList();
		key.add(id);
		key.add(debugger);

		ObjectReference ret = (ObjectReference)values.get(key);

		if(ret == null) {
			ret = new RemoteObjectReference(debugger, id_);
			values.put(id, key);
		}

		return ret;
	}

	private RemoteObjectReference(ADWPDebugger debugger, int id) {
		super(id);
		this.debugger = debugger;
	}

	public Value get(String propName) {
		Value ret = null;

		ret = debugger.request(ADWPDebugger.CMD_GET, Arrays.asList(new Object[] {this, StringValue.valueOf(propName)}));

		return ret;
	}

	public void set(String propName, Value value) {
		debugger.sendCommand(ADWPDebugger.CMD_SET, Arrays.asList(new Object[] {IntegerValue.valueOf(id), StringValue.valueOf(propName), value}));
	}

	public Value call(String opName, List args) {
		Value ret = null;

		List params = new ArrayList();
		params.add(this);
		params.add(StringValue.valueOf(opName));
		params.add(IntegerValue.valueOf(args.size()));
		for(Iterator i = args.iterator() ; i.hasNext() ; ) {
			params.add(i.next());
		}
		ret = debugger.request(ADWPDebugger.CMD_CALL, params);

		return ret;
	}

	private ADWPDebugger debugger;
}

