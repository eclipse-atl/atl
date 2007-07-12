package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.util.Iterator;

import org.eclipse.m2m.atl.engine.vm.StackFrame;

/** An ASMModelElement represents a model element.
 * There is no separate class for special model elements such as metamodel
 * elements. Therefore, some operations of ASMModelElement are only valid
 * for metamodel ASMModelElements.
 * @author Frédéric Jouault
 */
public abstract class ASMModelElement extends ASMOclType {

	protected ASMModelElement(ASMModel model, ASMModelElement metaobject) {
		super(metaobject);
		this.model = model;
		this.metaobject = metaobject;
		addSupertype(getOclAnyType());
	}

	public abstract ASMOclAny get(StackFrame frame, String name);

	public void set(StackFrame frame, String name, ASMOclAny value) {
		if(value instanceof ASMOclUndefined) return;
		if(name.equals("name") && (value instanceof ASMString)) this.name = ((ASMString)value).getSymbol();
		// the rest is up to the subclass' implementation
	}

	public String toString() {
		return  model.getName() + "!" + name;
	}

	public void setMetaobject(ASMModelElement metaobject) {
		this.metaobject = metaobject;
	}

	public ASMModelElement getMetaobject() {
		return metaobject;
	}

	public ASMModel getModel() {
		return model;
	}

	public String getName() {
		return model.getName() + "!" + name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public abstract ASMBoolean conformsTo(ASMOclType other);

	public ASMModelElement getAcquaintance(String name) {
		return null;
	}

	public abstract ASMModelElement getProperty(String name);

	public abstract ASMModelElement getPropertyType(String name);

	public static ASMModelElement lookupElementExtended(StackFrame frame, ASMModelElement self, ASMString name) {
		return null;
	}

	public static ASMModelElement otherEnd(StackFrame frame, ASMModelElement self) {
		return null;
	}

	/**
	 * @param frame
	 * @param self The meta-class to instantiate
	 * @return A new instance of self, if a suitable target model is found, null otherwise
	 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
	 */
	protected static ASMModelElement createNewInstance(StackFrame frame, ASMModelElement self) {
		ASMModel selfModel = self.getModel();
		for (Iterator j = frame.getExecEnv().getModels().values().iterator(); j.hasNext();) {
			ASMModel model = (ASMModel)j.next();
			if (model.isTarget() && model.getMetamodel().equals(selfModel)) {
				return model.newModelElement(self);
			}
		}
		return null;
	}

	private ASMModel model;
	private ASMModelElement metaobject;
	private String name;
}

