package org.eclipse.gmt.atl.oclquery.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.atl.eclipse.engine.AtlLauncher;
import org.atl.engine.repositories.emf4atl.ASMEMFModel;
import org.atl.engine.vm.ASM;
import org.atl.engine.vm.Debugger;
import org.atl.engine.vm.SimpleDebugger;
import org.atl.engine.vm.nativelib.ASMOclAny;

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
	
	public ASMOclAny eval(Map models) throws Exception {
		if(compiledQuery == null)
			compile();
		return interpretQuery(compiledQuery, models);
	}
	
	private ASMOclAny interpretQuery(ASM asm, Map models) throws Exception {
		ASMOclAny ret = null;
		
		AtlLauncher al = AtlLauncher.getDefault();
		Map libraries = Collections.EMPTY_MAP;
		Map asmParams = Collections.EMPTY_MAP;
		
		Debugger debugger = new SimpleDebugger(
				/* step = */ false,
				/* stepops = */ new ArrayList(),
				/* deepstepops = */ new ArrayList(),
				/* nostepops = */ new ArrayList(),
				/* deepnostepops = */ new ArrayList(),
				/* showStackTrace = */ true
		);
		ret = (ASMOclAny)al.launch(asm, libraries, models, asmParams, debugger);
		
		return ret;
	}
}
