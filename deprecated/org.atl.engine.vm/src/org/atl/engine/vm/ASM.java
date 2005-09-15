package org.atl.engine.vm;

import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMOclSimpleType;
import org.atl.engine.vm.nativelib.ASMOclType;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * This class represents a transformation module, which can have fields.
 * @author Frédéric Jouault
 */
public class ASM extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("ASM", getOclAnyType());
	static {
		NativeOperation.registerOperations(myType, ASMEmitter.class, false, true, true, true);
	}

	public ASM() {
		super(myType);
	}

	public ASM(String name) {
		this();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addField(ASMField f) {
		fields.add(f);
		fieldsMap.put(f.getName(), f);
	}

	public ASMField getField(String name) {
		return (ASMField)fieldsMap.get(name);
	}

	public List getFields() {
		return fields;
	}

	public void addOperation(ASMOperation o) {
		operations.add(o);
		operationsMap.put(o.getName(), o);
	}

	public ASMOperation getOperation(String name) {
		return (ASMOperation)operationsMap.get(name);
	}

	public List getOperations() {
		return operations;
	}

	private String name;
	private List fields = new ArrayList();
	private Map fieldsMap = new HashMap();
	private List operations = new ArrayList();
	private Map operationsMap = new HashMap();
}

