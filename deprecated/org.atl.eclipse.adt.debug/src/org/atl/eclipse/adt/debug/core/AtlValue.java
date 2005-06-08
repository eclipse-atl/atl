/*
 * Created on 10 mai 2004
 */

package org.atl.eclipse.adt.debug.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.atl.engine.vm.adwp.BooleanValue;
import org.atl.engine.vm.adwp.IntegerValue;
import org.atl.engine.vm.adwp.NullValue;
import org.atl.engine.vm.adwp.ObjectReference;
import org.atl.engine.vm.adwp.RealValue;
import org.atl.engine.vm.adwp.StringValue;
import org.atl.engine.vm.adwp.Value;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

/**
 * @author allilaire
 */
public class AtlValue implements IValue {

	String typeName;
	String asString;
	Value value;
	ObjectReference asType = null;
	AtlDebugTarget atlDT;
	
	public AtlValue(Value value, ObjectReference asType, AtlDebugTarget atlDT) {
		this(value, atlDT);
		this.asType = asType;
		this.typeName = getTypeName(value, asType);
		asString = value.toString();
	}

	public AtlValue(Value value, AtlDebugTarget atlDT) {
		this.value = value;
		this.atlDT = atlDT;
		this.typeName = getTypeName(value);
		if(typeName.equals("EnumLiteral")) {
			asString = ((StringValue)(((ObjectReference)value).call("toString",Collections.EMPTY_LIST))).getValue();
		} else {
			asString = value.toString();
		}
	}
	
	static String getTypeName(Value value) {
		return getTypeName(value, null);
	}

	static String getTypeName(Value value, ObjectReference asType) {
		String ret = null;
		
		if (value instanceof BooleanValue)
			ret = "Boolean";
		if (value instanceof IntegerValue)
			ret = "Integer";
		if (value instanceof RealValue)
			ret = "Real";
		if (value instanceof StringValue)
			ret = "String";
		if (value instanceof NullValue)
			ret = "Null";
		if (value instanceof ObjectReference) {
			ObjectReference or = (ObjectReference)value;
			Object v = asType;
			if(v == null) v = or.call("oclType", new ArrayList());
			if(v instanceof ObjectReference) {
				or = (ObjectReference)v;
				ret = ((StringValue)or.call("getName", new ArrayList())).getValue();
			} else {
				ret = "ObjectReference";
			}
		}
		return ret;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IValue#getReferenceTypeName()
	 */
	public String getReferenceTypeName() throws DebugException {
		return typeName;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IValue#getValueString()
	 */
	public String getValueString() throws DebugException {
		return asString;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IValue#isAllocated()
	 */
	public boolean isAllocated() throws DebugException 
	{
		return true;
	}
	
	private IVariable[] getProperties(ObjectReference orValue, ObjectReference type, String supertypesName, String contentsName, String referenceName, String attributeName) throws DebugException {
 		IVariable ret[] = null;
		List list = new ArrayList();

		// Add supertypes
		ObjectReference supertypes = (ObjectReference) type.get(supertypesName); // Sequence
		int n = ((IntegerValue) supertypes.call("size", new ArrayList()))
				.getValue();
		for (int i = 1; i <= n; i++) {
			ObjectReference element = (ObjectReference)supertypes.call("at", Arrays.asList(new Object[]{IntegerValue.valueOf(i)}));  
			list.add(new AtlVariable("<supertype>", new AtlValue(value, element, atlDT), atlDT, AtlVariable.SUPERTYPE));
		}
		
		// Add StructuralFeatures in contents
		ObjectReference contents = (ObjectReference) type.get(contentsName); // Sequence
		n = ((IntegerValue) contents.call("size", new ArrayList())).getValue();
		for (int i = 1; i <= n; i++) {
			ObjectReference element = (ObjectReference)contents.call("at", Arrays.asList(new Object[]{IntegerValue.valueOf(i)}));
			String tn = getTypeName(element);
			if(tn.equals(referenceName)) {
				String en = ((StringValue)element.get("name")).getValue();
				Value varValue = orValue.get(en); 
				list.add(new AtlVariable(en, new AtlValue(varValue, atlDT), atlDT, AtlVariable.REFERENCE));
			}
			else if(tn.equals(attributeName)) {
				String en = ((StringValue)element.get("name")).getValue();
				Value varValue = orValue.get(en); 
				list.add(new AtlVariable(en, new AtlValue(varValue, atlDT), atlDT, AtlVariable.ATTRIBUTE));
			}
		}
		ret = (IVariable[])list.toArray(new IVariable[0]);
		
		return ret;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IValue#getVariables()
	 */
	public IVariable[] getVariables() throws DebugException {
 		IVariable ret[] = null;
		
		if (value instanceof ObjectReference) {
			ObjectReference orValue = (ObjectReference) value;
			Value v = asType;
			if(v == null) v = orValue.call("oclType", new ArrayList());
			if (v instanceof ObjectReference) {
				ObjectReference type = (ObjectReference) v;
				String ttn = getTypeName(type);
				if(ttn.equals("MOF!Class")) {
					ret = getProperties(orValue, type, "supertypes", "contents", "MOF!Reference", "MOF!Attribute");
				} else if(ttn.equals("MOF!EClass")) {
					ret = getProperties(orValue, type, "eSuperTypes", "eStructuralFeatures", "MOF!EReference", "MOF!EAttribute");
				}
				else {
					String tn = typeName;
					if(tn.equals("Sequence")) {
						ret = doSequence(orValue);
					}
					else if(tn.equals("Set")) {
						orValue = (ObjectReference)orValue.call("asSequence", new ArrayList());
						ret = doSequence(orValue);
					}
					else if(tn.equals("Bag")) {
						orValue = (ObjectReference)orValue.call("asSequence", new ArrayList());
						ret = doSequence(orValue);
					}
					else if(tn.equals("Map")) {
						ret = doMap(orValue, false);
					}
					else if(tn.equals("Tuple")) {
						ObjectReference map = (ObjectReference)orValue.call("asMap", new ArrayList());
						ret = doMap(map, true);
					}
				}
			}

		}
		
		return ret;
	}

	private IVariable[] doMap(ObjectReference orValue, boolean useKeyAsName) {
		IVariable ret[] = null;
		ObjectReference keys = (ObjectReference)orValue.call("getKeys", new ArrayList());
	
		keys = (ObjectReference)keys.call("asSequence", new ArrayList());
		
		List list = new ArrayList();
		int n = ((IntegerValue) keys.call("size", new ArrayList())).getValue();
		for (int i = 1; i <= n; i++) {
			Value varKey = (Value)keys.call("at", Arrays.asList(new Object[]{IntegerValue.valueOf(i)}));
			Value varValue = (Value)orValue.call("get", Arrays.asList(new Object[]{varKey}));
			
			if(useKeyAsName) {
				list.add(new AtlVariable(((StringValue)varKey).getValue(), new AtlValue(varValue, atlDT), atlDT, AtlVariable.ATTRIBUTE));
			} else {
				list.add(new AtlVariable("Map[" + i + "]", new AtlMapValue(varKey, varValue, atlDT), atlDT, AtlVariable.ELEMENT));
			}
		}
		ret = (IVariable[])list.toArray(new IVariable[0]);
		if (ret.length == 0)
			ret = null;
		
		return ret;
	}
	
	/**
	 * This method retuns an array of IVariable
	 * From an object reference, the variable of this object reference are returned
	 * @param orValue
	 * @return
	 */
	private IVariable[] doSequence(ObjectReference orValue) {
		IVariable[] ret = null;
		List list = new ArrayList();

		int n = ((IntegerValue) orValue.call("size", new ArrayList())).getValue();
		for (int i = 1; i <= n; i++) {
			Value varValue = (Value)orValue.call("at", Arrays.asList(new Object[]{IntegerValue.valueOf(i)}));
			list.add(new AtlVariable("[" + i + "]", new AtlValue(varValue, atlDT), atlDT, AtlVariable.ELEMENT));
		}
		ret = (IVariable[])list.toArray(new IVariable[0]);
		return ret;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IValue#hasVariables()
	 */
	public boolean hasVariables() throws DebugException 
	{
		return getVariables() != null;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() 
	{
		return atlDT.getModelIdentifier();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return atlDT.getDebugTarget();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return atlDT.getLaunch();
	}
	
	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		return null;
	}
	/**
	 * @return Returns the value.
	 */
	public Value getValue() {
		return value;
	}
}
