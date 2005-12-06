package org.atl.engine.repositories.mdr4atl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jmi.reflect.RefAssociation;
import javax.jmi.reflect.RefEnum;
import javax.jmi.reflect.RefException;
import javax.jmi.reflect.RefObject;
import javax.jmi.reflect.RefPackage;
import javax.jmi.reflect.RefStruct;

import org.atl.engine.vm.ClassNativeOperation;
import org.atl.engine.vm.StackFrame;
import org.atl.engine.vm.nativelib.ASMBoolean;
import org.atl.engine.vm.nativelib.ASMCollection;
import org.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.atl.engine.vm.nativelib.ASMInteger;
import org.atl.engine.vm.nativelib.ASMModel;
import org.atl.engine.vm.nativelib.ASMModelElement;
import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMOclType;
import org.atl.engine.vm.nativelib.ASMOclUndefined;
import org.atl.engine.vm.nativelib.ASMReal;
import org.atl.engine.vm.nativelib.ASMSequence;
import org.atl.engine.vm.nativelib.ASMSet;
import org.atl.engine.vm.nativelib.ASMString;
import org.atl.engine.vm.nativelib.ASMTuple;

/**
 * @author Frédéric Jouault
 */
public class ASMMDRModelElement extends ASMModelElement {

	private static Map modelElements = new HashMap();
	public static ASMModelElement getASMModelElement(ASMModel model, RefObject object) {
		ASMModelElement ret = (ASMModelElement)modelElements.get(object);

		if(ret == null) {
			ret = new ASMMDRModelElement((ASMMDRModel)model, object);


		}

		return ret;
	}

	private static ASMModelElement getMetaobject(ASMMDRModel model, RefObject object) {
		ASMModelElement ret = null;

		RefObject mo = object.refMetaObject();
		if(!mo.equals(object)) {
			ret = getASMModelElement(model.getMetamodel(), object.refMetaObject());
		}

		return ret;
	}

	private ASMMDRModelElement(ASMMDRModel model, RefObject object) {
		super(model, getMetaobject(model, object));
		modelElements.put(object, this);
		this.object = object;
		try {
			String name = (String)object.refGetValue("name");
			if(name == null) {
				name = "<notnamedyet>";
			}
			setName(name);
		} catch(Exception e) {
			setName("<unnamed>");
		}

//new Exception(this + " : " + getMetaobject()).printStackTrace(System.out);
		if(getMetaobject() == null) {
			setMetaobject(this);
		}
		setType(getMetaobject());
		if((model.equals(ASMMDRModel.getMOF()) && (getName().equals("Class") || getName().equals("Classifier"))) || object.refIsInstanceOf(getClassifier(), true)) {
			for(Iterator i = ((Collection)object.refGetValue("supertypes")).iterator() ; i.hasNext() ; ) {
				RefObject ro = (RefObject)i.next();
				ASMModelElement ame = getASMModelElement(model, ro);
				addSupertype(ame);
			}
			addSupertype(ASMOclType.myType);
		}
	}


	private static void registerMOFOperation(String modelelementName, String methodName, Class args[]) throws Exception {
		List realArgs = new ArrayList(Arrays.asList(args));
		realArgs.add(0, ASMMDRModelElement.class);
		realArgs.add(0, StackFrame.class);
		ClassNativeOperation no = new ClassNativeOperation(ASMMDRModelElement.class.getMethod(methodName, (Class[])realArgs.toArray(args)));
		ASMModelElement amme = ASMMDRModel.getMOF().findModelElement(modelelementName);
//		System.out.println("Registering on " + amme + " : " + no);
		amme.registerVMOperation(no);
	}

	static {
		try {
			// Force creation of MOF!Class before any other (otherwise MOF!Classifier gets created twice)
			ASMMDRModel.getMOF().findModelElement("Class");

			// Operations on MOF!Classifier
			registerMOFOperation("Classifier", "allInstances", new Class[] {});
			registerMOFOperation("Classifier", "allInstancesFrom", new Class[] {ASMString.class});
			registerMOFOperation("Classifier", "newInstance", new Class[] {});
			registerMOFOperation("Classifier", "getElementBy", new Class[] {ASMString.class, ASMOclAny.class});
			registerMOFOperation("Classifier", "getElementsBy", new Class[] {ASMString.class, ASMOclAny.class});

			// Operations on MOF!GeneralizableElement
			registerMOFOperation("GeneralizableElement", "findElementsByTypeExtended", new Class[] {ASMMDRModelElement.class, ASMBoolean.class});
			registerMOFOperation("GeneralizableElement", "lookupElementExtended", new Class[] {ASMString.class});

			// Operations on MOF!AssociationEnd
			registerMOFOperation("AssociationEnd", "otherEnd", new Class[] {});
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}

	public static ASMModelElement otherEnd(StackFrame frame, ASMMDRModelElement self) {
		RefObject ret = null;

		try {
			ret = (RefObject)self.object.refInvokeOperation("otherEnd", new ArrayList());
		} catch(RefException re) {
			re.printStackTrace(System.out);
		}

		return (ASMModelElement)java2ASM(frame, self.getModel(), ret);
	}

	public static ASMModelElement lookupElementExtended(StackFrame frame, ASMMDRModelElement self, ASMString name) {
		RefObject ret = null;

		try {
			ret = (RefObject)self.object.refInvokeOperation("lookupElementExtended", Arrays.asList(new Object[] {name.getSymbol()}));
		} catch(RefException re) {
			re.printStackTrace(System.out);
		}

		return (ASMModelElement)java2ASM(frame, self.getModel(), ret);
	}

	public static ASMSequence findElementsByTypeExtended(StackFrame frame, ASMMDRModelElement self, ASMMDRModelElement ofType, ASMBoolean includeSubtypes) {
		List ret = null;

		try {
			ret = (List)self.object.refInvokeOperation("findElementsByTypeExtended", Arrays.asList(new Object[] {ofType.object, new Boolean(includeSubtypes.getSymbol())}));
		} catch(RefException re) {
			re.printStackTrace(System.out);
		}

		return (ASMSequence)java2ASM(frame, self.getModel(), ret);
	}

	public static ASMModelElement getElementsBy(StackFrame frame, ASMMDRModelElement self, ASMString propName, ASMOclAny value) {
		return (ASMModelElement)getMap(frame, self, propName).get(value);	// TODO : return collection if several
	}

	public static ASMModelElement getElementBy(StackFrame frame, ASMMDRModelElement self, ASMString propName, ASMOclAny value) {
		return (ASMModelElement)getMap(frame, self, propName).get(value);
	}

	private static Map propMapMap = new HashMap();
	private static Map getMap(StackFrame frame, ASMMDRModelElement self, ASMString propName) {
		Map propMap = (Map)propMapMap.get(self);

		if(propMap == null) {
			propMap = new HashMap();
			propMapMap.put(self, propMap);
		}
		Map ret = (Map)propMap.get(propName);

		if(ret == null) {
			ret = new HashMap();
			String propNames = propName.getSymbol();
			for(Iterator i = allInstances(frame, self).iterator() ; i.hasNext() ; ) {
				ASMModelElement ame = (ASMModelElement)i.next();
				ret.put(ame.get(frame, propNames), ame);
			}

			propMap.put(propName, ret);
		}

		return ret;
	}

	public static ASMSet allInstances(StackFrame frame, ASMMDRModelElement self) {
		return allInstancesFrom(frame, self, null);
	}

	public static ASMSet allInstancesFrom(StackFrame frame, ASMMDRModelElement self, ASMString sourceModelName) {
final boolean debug = false;
		Set ret = new HashSet();

if(debug) System.out.println(self + ".allInstancesFrom(" + ((sourceModelName == null) ? "null" : "\"" + sourceModelName + "\"") + ")");
		if(self.object.refMetaObject().refIsInstanceOf(getClassifier(), true)) {
			for(Iterator i = frame.getModels().keySet().iterator() ; i.hasNext() ; ) {
				String mname = (String)i.next();
if(debug) System.out.println("\ttrying: " + mname);
				if((sourceModelName != null) && !mname.equals(sourceModelName.getSymbol())) continue;
				ASMModel am = (ASMModel)frame.getModels().get(mname);
if(debug) System.out.println("\t\tfound: " + am.getName());
if(debug) System.out.println("\t\tam.getMetamodel() = " + am.getMetamodel().hashCode());
if(debug) System.out.println("\t\tself.getModel() = " + self.getModel().hashCode());
if(debug) System.out.println("\t\tam.getMetamodel().equals(self.getModel()) = " + am.getMetamodel().equals(self.getModel()));
				if(!am.getMetamodel().equals(self.getModel())) continue;
if(debug) System.out.println("\t\t\tsearching on: " + am.getName());
				Set elems = am.getElementsByType(self);
				ret.addAll(elems);
if(debug) System.out.println("\t\t\t\tfound: " + elems);
			}
		}

		return new ASMSet(ret);
	}

	public static ASMModelElement newInstance(StackFrame frame, ASMMDRModelElement self) {
		ASMModelElement ret = null;

		if(self.object.refMetaObject().refIsInstanceOf(getClassifier(), true)) {
			for(Iterator i = self.getModel().getSubModels().values().iterator() ; i.hasNext() ; ) {
				ASMModel am = (ASMModel)i.next();
				if(am.isTarget()) {
					ret = am.newModelElement(self);
					break;
				}
			}
		}

		return ret;
	}

	public ASMOclAny get(StackFrame frame, String name) {
		ASMOclAny ret = null;

		if((frame != null) && isHelper(frame, name)) {
			ret = getHelper(frame, name);
		} else {
			try {
				Object o = object.refGetValue(name);
				ret = java2ASM(frame, getModel(), o);
			} catch(Exception e) {
				if(frame != null)
					frame.printStackTrace("this = " + this + " ; name = " + name, e);
			} catch(Error e) {
				if(frame != null)
					frame.printStackTrace("this = " + this + " ; name = " + name + " ; " + e.toString());				
			}
		}

		return ret;
	}

	private static ASMOclAny java2ASM(StackFrame frame, ASMModel model, Object o) {
		ASMOclAny ret = null;

		if(o instanceof String) {
			ret = new ASMString((String)o);
		} else if(o instanceof Integer) {
			ret = new ASMInteger(((Integer)o).intValue());
		} else if(o instanceof Boolean) {
			ret = new ASMBoolean(((Boolean)o).booleanValue());
		} else if(o instanceof Double) {
			ret = new ASMReal(((Double)o).doubleValue());
		} else if(o instanceof RefObject) {
			ret = getASMModelElement(model, (RefObject)o);
		} else if(o instanceof List) {
			ret = new ASMSequence();
			for(Iterator i = ((List)o).iterator() ; i.hasNext() ; ) {
				((ASMSequence)ret).add(java2ASM(frame, model, i.next()));
			}
		} else if(o instanceof Collection) {
			ret = new ASMSet();
			for(Iterator i = ((Collection)o).iterator() ; i.hasNext() ; ) {
				((ASMSet)ret).add(java2ASM(frame, model, i.next()));
			}
		} else if(o instanceof RefStruct) {
			ASMTuple t = new ASMTuple();
			for(Iterator i = ((RefStruct)o).refFieldNames().iterator() ; i.hasNext() ; ) {
				String name = (String)i.next();
				ASMOclAny e = java2ASM(frame, model, ((RefStruct)o).refGetValue(name));
				t.set(frame, name, e);
			}
			ret = t;
		} else if(o instanceof RefEnum) {
			ret = new ASMEnumLiteral(o.toString());
		} else if(o == null) {
			ret = new ASMOclUndefined();
		} else {
			frame.printStackTrace("ERROR: could not convert " + o + " : " + o.getClass());
		}

		return ret;
	}

	public void set(StackFrame frame, String name, ASMOclAny value) {
		super.set(frame, name, value);
/*		System.out.println(this + " : " + getMetaobject() + "." + name + " <- " + value + " : " + value.getType() + " (old value is " + object.refGetValue(name) + ")");
		if(object.refGetValue(name) instanceof Collection)
			System.out.println(new ArrayList((Collection)object.refGetValue(name)));
*/
		Object valueToSet = asm2Java(frame, getModel(), value, name);
		Object oldValue = null;
		if(valueToSet == null) return;
		try {
			if(((ASMMDRModelElement)getMetaobject()).isNNAcquaintance(name)) {
//System.out.println("WARNING: AssociationEnd " + name + " is not navigable.");
				ASMMDRModelElement ae = (ASMMDRModelElement)((ASMMDRModelElement)getMetaobject()).getAcquaintance(name).get(frame, "container");
				RefAssociation aec = ((ASMMDRModel)getModel()).findRefAssociation(ae.getObject());
				if(((ASMMDRModelElement)getMetaobject()).isAcquaintanceFirst(name)) {
					aec.refAddLink(((ASMMDRModelElement)value).object, object);
				} else {
					aec.refAddLink(object, ((ASMMDRModelElement)value).object);
				}
			} else {
				oldValue = object.refGetValue(name);

				if(oldValue instanceof Collection) {
					if(valueToSet instanceof Collection) {
						for(Iterator i = ((Collection)valueToSet).iterator() ; i.hasNext() ; ) {
							((Collection)oldValue).add(i.next());
						}
					} else {
						((Collection)oldValue).add(valueToSet);
					}
				} else {
					if(valueToSet instanceof Collection) {
						frame.printStackTrace("Warning: trying to set a Collection (" + valueToSet + ")to a single-valued property, using first element");
						if(((Collection)valueToSet).size() >= 1) {
							valueToSet = ((Collection)valueToSet).iterator().next();
							object.refSetValue(name, valueToSet);
						}
					} else {
						object.refSetValue(name, valueToSet);
					}
				}
			}
		} catch(Exception e) {
			String msg = "Cannot set property " + name + " on element " + this + " : " + getMetaobject() + " to " + value + " : " + value.getType() + " (old value is " + oldValue + ")";
			if(frame != null) {
				frame.printStackTrace(msg, e);
			} else {
				System.out.println(msg);
				e.printStackTrace(System.out);
			}
		}
	}

	private Object asm2Java(StackFrame frame, ASMModel model, ASMOclAny asmValue, String propertyName) {
		Object ret = null;

		if(asmValue instanceof ASMString) {
			ret = ((ASMString)asmValue).getSymbol();
		} else if(asmValue instanceof ASMInteger) {
			ret = new Integer(((ASMInteger)asmValue).getSymbol());
		} else if(asmValue instanceof ASMBoolean) {
			ret = new Boolean(((ASMBoolean)asmValue).getSymbol());
		} else if(asmValue instanceof ASMReal) {
			ret = new Double(((ASMReal)asmValue).getSymbol());
		} else if(asmValue instanceof ASMModelElement) {
			if(((ASMModelElement)asmValue).getModel().equals(model)) {
				ret = ((ASMMDRModelElement)asmValue).getObject();
			} else {
//				frame.printStackTrace("Warning: trying to set " + o + " : " + ((ASMModelElement)o).getType() + " from " + ((ASMModelElement)o).getModel() + " to an element off model " + model);
				ret = null;
			}
		} else if(asmValue instanceof ASMCollection) {
			ret = new ArrayList();
			for(Iterator i = ((ASMCollection)asmValue).iterator() ; i.hasNext() ; ) {
				Object v = asm2Java(frame, model, (ASMOclAny)i.next(), propertyName);
				if(v != null)
					((List)ret).add(v);
			}
		} else if(asmValue instanceof ASMEnumLiteral) {
			ASMMDRModelElement type = (ASMMDRModelElement)lookupElementExtended(frame, (ASMMDRModelElement)getMetaobject(), new ASMString(propertyName)).get(frame, "type");
			if(((ASMString)type.getMetaobject().get(frame, "name")).getSymbol().equals("EnumerationType")) {	// already checked by semantic analysis ?
				RefObject typeObject = type.getObject();
				RefObject typeObjectPackage = (RefObject)typeObject.refImmediateComposite();
				RefPackage pack = ((ASMMDRModel)model).getPackage();
				if(!pack.refMetaObject().equals(typeObjectPackage)) {
					pack = pack.refPackage(typeObjectPackage);
				}
				ret = pack.refGetEnum(typeObject, ((ASMEnumLiteral)asmValue).getName());
			} else {
				frame.printStackTrace("ERROR: could not convert " + asmValue);
			}
		} else if(asmValue instanceof ASMTuple) {
			ret = asm2JavaStructure(frame, model, asmValue, (ASMMDRModelElement)getMetaobject(), propertyName);
		} else if(asmValue instanceof ASMOclUndefined) {
			ret = null;		// TODO: means unset ?
		} else {
			frame.printStackTrace("ERROR: could not convert " + asmValue);
		}

		return ret;
	}
	
	private Object asm2JavaStructure(StackFrame frame, ASMModel model, ASMOclAny asmValue, ASMMDRModelElement contextType, String propertyName) {
		Object ret = null;
		ASMMDRModelElement type = (ASMMDRModelElement)lookupElementExtended(frame, contextType, new ASMString(propertyName)).get(frame, "type");
		if(((ASMString)type.getMetaobject().get(frame, "name")).getSymbol().equals("StructureType")) {	// already checked by semantic analysis ?
			List args = new ArrayList();
			for(Iterator i = ((ASMCollection)type.get(frame, "contents")).iterator() ; i.hasNext() ; ) {
				ASMModelElement ame = (ASMModelElement)i.next();
				if(((ASMString)ame.getMetaobject().get(frame, "name")).getSymbol().equals("StructureField")) {
					String fieldName = ((ASMString)ame.get(frame, "name")).getSymbol();
					ASMOclAny v = ((ASMTuple)asmValue).get(frame, fieldName);
					Object value;
					if(v instanceof ASMTuple) {
						value = asm2JavaStructure(frame, model, v, type, fieldName);
					} else {
						value = asm2Java(frame, model, v, propertyName);
					}
					args.add(value);
				}
			}
			RefObject pack = ((ASMMDRModelElement)type.get(frame, "container")).getObject(); 
			RefPackage rp = ((ASMMDRModel)model).getPackage();
			if(rp.refMetaObject() != pack) {
				rp = rp.refPackage(pack);
			}
			ret = rp.refCreateStruct(type.getObject(), args);
		} else {
			frame.printStackTrace("ERROR: could not convert " + asmValue);
		}
		return ret;
	}

	public RefObject getObject() {
		return object;
	}

	// only for metamodels...?
	public ASMBoolean conformsTo(ASMOclType other) {
		boolean ret = false;

//System.out.println(this + ".conformsTo(" + other);
		if(other instanceof ASMMDRModelElement) {
			RefObject o = ((ASMMDRModelElement)other).object;
			RefObject t = object;

			if(o.refIsInstanceOf(getClassifier(), true) && t.refIsInstanceOf(getClassifier(), true)) {
				try {
					ret = o.equals(t) || ((Collection)t.refInvokeOperation("allSupertypes", new ArrayList())).contains(o);
				} catch(Exception e) {
					e.printStackTrace(System.out);
				}
			}
		}

		return new ASMBoolean(ret);
	}

	public ASMOclAny refImmediateComposite() {
		ASMOclAny ret = null;
		
		Object ic = object.refImmediateComposite();
		if((ic == null) || !(ic instanceof RefObject)) {
			ret = super.refImmediateComposite();
		} else {
			ret = getASMModelElement(getModel(), (RefObject)ic);
		}
		
		return ret;
	}

	// only for metamodels...?
	public ASMModelElement getPropertyType(String name) {
		ASMModelElement ret = null;
		
		ASMModelElement p = getProperty(name);
		if(p != null) {
			ret = (ASMModelElement)p.get(null, "type");
		}
		
		return ret;
	}
	
	// only for metamodels...?
	public ASMModelElement getProperty(String name) {
		ASMModelElement ret = null;

		RefObject t = object;

		if(t.refIsInstanceOf(getClassifier(), true)) {
			try {
				List args = new ArrayList();
				args.add(name);
				ret = getASMModelElement(getModel(), (RefObject)t.refInvokeOperation("lookupElementExtended", args));
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		}

		return ret;
	}

	private static RefObject getClassifier() {
		return ((ASMMDRModelElement)ASMMDRModel.getMOF().findModelElement("Classifier")).object;
	}

/*
	public String toString() {
		return super.toString() + "@" + hashCode();
	}
*/

	public void addAcquaintance(String name, ASMModelElement asso, ASMModelElement ae, boolean isFirst) {
		acquaintances.put(name, new Object[] {ae, new Boolean(isFirst)});
		if(!((ASMBoolean)ae.get(null, "isNavigable")).getSymbol()) {	// TODO: null -> frame
			nonNavigableAcquaintances.put(name, new Object[] {ae, new Boolean(isFirst)});
		}
	}

	public boolean isNNAcquaintance(String name) {
		Object ret = nonNavigableAcquaintances.get(name);
		
		if(ret == null) {
			for(Iterator i = getSupertypes().iterator() ; i.hasNext() && (ret == null) ; ) {
				Object o = i.next();
				if(o instanceof ASMMDRModelElement) {
					ASMMDRModelElement ame = (ASMMDRModelElement)o;
					ret = ame.nonNavigableAcquaintances.get(name);
				}
			}			
		}
		
		return ret != null;
	}

	public boolean isAcquaintance(String name) {
		return getAcquaintance(name) != null;
	}

	public ASMModelElement getAcquaintance(String name) {
		Object[] oa = getAcquaintanceStruct(name);
		return (oa != null) ? (ASMModelElement)oa[0] : null;
	}
	
	public Object[] getAcquaintanceStruct(String name) {
		Object[] ret = (Object[])acquaintances.get(name);

		if(ret == null) {
			for(Iterator i = getSupertypes().iterator() ; i.hasNext() && (ret == null) ; ) {
				Object o = i.next();
				if(o instanceof ASMMDRModelElement) {
					ASMMDRModelElement ame = (ASMMDRModelElement)o;
					ret = ame.getAcquaintanceStruct(name);
				}
			}
		}

		return ret;
	}

	public boolean isAcquaintanceFirst(String name) {
		return ((Boolean)(getAcquaintanceStruct(name))[1]).booleanValue();
	}

	private Map acquaintances = new HashMap();
	private Map nonNavigableAcquaintances = new HashMap();
	private RefObject object;
}

