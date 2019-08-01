/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.debug.core.adwp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The remote implementation of the {@link ObjectReference}.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public final class RemoteObjectReference extends ObjectReference {

	private static Map<List<Object>, ObjectReference> values = new HashMap<List<Object>, ObjectReference>();

	private ADWPDebugger debugger;

	private RemoteObjectReference(ADWPDebugger debugger, int id) {
		super(id);
		this.debugger = debugger;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ObjectReference#get(java.lang.String)
	 */
	@Override
	public Value get(String propName) {
		Value ret = null;
		ret = debugger.request(ADWPDebugger.CMD_GET, Arrays.asList(new Value[] {this,
				StringValue.valueOf(propName),}));
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ObjectReference#set(java.lang.String,
	 *      org.eclipse.m2m.atl.debug.core.adwp.Value)
	 */
	@Override
	public void set(String propName, Value value) {
		debugger.sendCommand(ADWPDebugger.CMD_SET, Arrays.asList(new Value[] {IntegerValue.valueOf(id),
				StringValue.valueOf(propName), value,}));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ObjectReference#call(java.lang.String, java.util.List)
	 */
	@Override
	public Value call(String opName, List<Value> args) {
		Value ret = null;
		List<Value> params = new ArrayList<Value>();
		params.add(this);
		params.add(StringValue.valueOf(opName));
		params.add(IntegerValue.valueOf(args.size()));
		for (Iterator<Value> i = args.iterator(); i.hasNext();) {
			params.add(i.next());
		}
		ret = debugger.request(ADWPDebugger.CMD_CALL, params);
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ObjectReference#toString()
	 */
	@Override
	public String toString() {
		return call("toString", Collections.<Value> emptyList()).toString(); //$NON-NLS-1$
	}

	/**
	 * Returns the {@link ObjectReference} of a given object by its id.
	 * 
	 * @param debugger
	 *            the current debugger
	 * @param objectId
	 *            the object id
	 * @return the {@link ObjectReference}
	 */
	public static ObjectReference valueOf(ADWPDebugger debugger, int objectId) {
		Integer id = Integer.valueOf(objectId);
		List<Object> key = new ArrayList<Object>();
		key.add(id);
		key.add(debugger);
		ObjectReference ret = values.get(key);
		if (ret == null) {
			ret = new RemoteObjectReference(debugger, objectId);
			values.put(key, ret);
		}
		return ret;
	}
}
