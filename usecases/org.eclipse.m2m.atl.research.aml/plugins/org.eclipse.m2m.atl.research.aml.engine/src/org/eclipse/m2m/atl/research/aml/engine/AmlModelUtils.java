/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.engine;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.ASM;
import org.eclipse.m2m.atl.engine.emfvm.ASMOperation;
import org.eclipse.m2m.atl.engine.emfvm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.emfvm.StackFrame;
import org.eclipse.m2m.atl.engine.emfvm.VMException;
import org.eclipse.m2m.atl.engine.emfvm.adapter.EMFModelAdapter;
import org.eclipse.m2m.atl.engine.emfvm.lib.ASMModule;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclUndefined;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

/**
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 */
public class AmlModelUtils {
	
	private ASM amlLibraryASM;
	
	
	private static AmlModelUtils defaultAmlEgineUtil = null;
	
	
	public static AmlModelUtils getDefault() {
		if(defaultAmlEgineUtil == null) {			
			defaultAmlEgineUtil = new AmlModelUtils();
		}
		return defaultAmlEgineUtil;
	}
	
	AmlModelUtils() {
		
		Map<String, InputStream> matchingLibraries = AmlCompiler.getCompiler().getMatchingLibraries();
		Collection<InputStream> coll = matchingLibraries.values();
		//TODO handle the existence of multiple matching libraries
		for(Iterator i = coll.iterator(); i.hasNext();) {
			amlLibraryASM = new ASMXMLReader().read((InputStream)i.next());
		}
		
		
		
	}
	
	public Boolean hasMethodCalls (IModel model) throws ATLCoreException {
		
		EObject matcher = getMatcher(model);
		if (evaluateAmlLibraryHelper("lastModelFlowDecl", matcher) instanceof OclUndefined) {
			return false;
		}
		return true;
	}
	
	public EObject getMatcher(IModel model) throws ATLCoreException {
			
			// find the matcher specified in the AML strategy
			
			
			EMFModel amlInjected = (EMFModel) model; 		
			EMFReferenceModel amlMetamodel = (EMFReferenceModel) AmlCompiler.getCompiler().getAmlMetamodel();
			EClass matcherClass = (EClass)amlMetamodel.getMetaElementByName("Matcher");
			Set<EObject> matcherSet = amlInjected.getElementsByType(matcherClass);
			EObject matcher = null;
			for(Iterator<EObject> ite = matcherSet.iterator(); ite.hasNext();){
				matcher = ite.next();
			}
			
			return matcher;
	}
	
	public Object evaluateAmlLibraryHelper(String helperName, Object... parameters) throws VMException {
		
				
		Map<String, IModel> models = new HashMap<String, IModel>();
		models.put("AML", AmlCompiler.getDefault().getAmlMetamodel());
		
		Object res = null;

			// ATL VM environment initialization
			ExecEnv execEnv = new ExecEnv(models, null);
			execEnv.init(new EMFModelAdapter());
			ASM.registerOperations(execEnv, amlLibraryASM.getOperations());

			// helper lookup
			ASMOperation helper = null;
			for (Iterator<ASMOperation> iterator = amlLibraryASM.getOperations(); iterator
					.hasNext();) {
				ASMOperation op = iterator.next();
				if (op.getName().equals(helperName)) {
					helper = op;
					break;
				}
			}

			// execution frame initialization
			AbstractStackFrame frame = new StackFrame(execEnv, new ASMModule(),
					helper);
		frame.setLocalVars(parameters);

			// execution

		res = helper.exec(frame);
		return res;
	}
	
	public String getMatchingMetametamodel (IModel in) throws ATLCoreException {
	
		EObject matcher = getMatcher(in);
	
		return (String) AmlModelUtils.getDefault().evaluateAmlLibraryHelper("metametamodel", matcher);
	
	}
	
	public EObject[] getProblems (IModel pbs) {
		IReferenceModel problemMetamodel = AtlParser.getDefault().getProblemMetamodel();
		Object problemType = problemMetamodel.getMetaElementByName("Problem");
		Set<? extends Object> sPbs = pbs.getElementsByType(problemType);
		EObject[] oPbs = (EObject[]) sPbs.toArray(new EObject[sPbs.size()]);
		
		return oPbs;
		
	}
	
	
	

}
