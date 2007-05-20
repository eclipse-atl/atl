package org.eclipse.m2m.atl.ocl.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.engine.AtlLauncher;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.SimpleDebugger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBoolean;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMInteger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * 
 * @author Frédéric Jouault
 *
 */
public class OclQuery extends OclEvaluator {
	
	private String query;
	private ASM compiledQuery;
	
	public OclQuery(String query) {
		this.query = query;
		this.compiledQuery = null;
	}
	
	public static ASMOclAny eval(String query) throws Exception {
		return new OclQuery(query).eval();		
	}
	
	public static ASMOclAny eval(String query, Map models) throws Exception {
		return new OclQuery(query).eval(models);
	}

	public void compile() throws Exception {
		compiledQuery = compile("query test = " + query + ";");
	}

	public ASMOclAny eval() throws Exception {
		Map models = new HashMap();
		models.put("MOF", ASMEMFModel.getMOF());
		return eval(models);
	}
	
	public String evalString(Map models) throws Exception {
		return ((ASMString)eval(models)).getSymbol();
	}
	
	public int evalInteger(Map models) throws Exception {
		return ((ASMInteger)eval(models)).getSymbol();
	}
	
	public boolean evalBoolean(Map models) throws Exception {
		return ((ASMBoolean)eval(models)).getSymbol();
	}
	
	public ASMOclAny eval(Map models) throws Exception {
		return eval(models, Collections.EMPTY_MAP);
	}
	
	public ASMOclAny eval(Map models, Map libraries) throws Exception {
		if(compiledQuery == null)
			compile();
		return interpretQuery(compiledQuery, models, libraries);
	}
	
	private ASMOclAny interpretQuery(ASM asm, Map models, Map libraries) throws Exception {
		ASMOclAny ret = null;
		
		AtlLauncher al = AtlLauncher.getDefault();
		Map asmParams = Collections.EMPTY_MAP;
		
		Debugger debugger = new SimpleDebugger(
				/* step = */ false,
				/* stepops = */ new ArrayList(),
				/* deepstepops = */ new ArrayList(),
				/* nostepops = */ new ArrayList(),
				/* deepnostepops = */ new ArrayList(),
				/* showStackTrace = */ true
		);
		ret = (ASMOclAny)al.launch(asm, libraries, models, asmParams, Collections.EMPTY_LIST, Collections.EMPTY_MAP, debugger);
		
		return ret;
	}
}
