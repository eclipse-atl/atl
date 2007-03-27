package org.eclipse.m2m.atl.ocl.core;

import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.atl.engine.AtlCompiler;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMEmitter;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.StackFrame;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * 
 * @author Frédéric Jouault
 *
 */
public abstract class OclEvaluator {
	
	private static long id = 0;

	protected ASM compile(String atl) throws Exception {
		ASM ret = null;
//		System.out.println(atl);
		AtlCompiler ac = AtlCompiler.getDefault();
		
		String key = "ID=" + id++;
		EObject pbs[] = ac.compile(new StringBufferInputStream(atl), new DummyFile(key));
		for(int i = 0 ; i < pbs.length ; i++) {
			String sev = get(pbs[i], "severity").toString();
			System.out.println(sev + ":" + get(pbs[i], "location") + ":" + get(pbs[i], "description"));
		}
		ret = (ASM)dumpedASMs.get(key);
		return ret;
	}
	
	private static Object get(EObject o, String f) {
		EStructuralFeature sf = o.eClass().getEStructuralFeature(f);
		return o.eGet(sf);
	}
	
	private static Map dumpedASMs = new HashMap();
	
	static {
		try {
			ATLVMTools.addVMOperation(ASMEmitter.myType, ATLVMTools.toVMOperation(OclEvaluator.class, "dumpASM"));
		} catch(Exception e) {
			
		}
	}

	// New VM Operations
	public static void dumpASM(StackFrame frame, ASMEmitter self, ASMString fileName) {
		self.finishOperation();
		String key = ((ASMString)((ASMExecEnv)frame.getExecEnv()).getASMModule().get(frame, "fileName")).getSymbol();
		if(key.startsWith("ID=")) {
			dumpedASMs.put(key, self.getASM());
		} else {
			self.dumpASM(fileName.getSymbol());
		}
	}	
}
