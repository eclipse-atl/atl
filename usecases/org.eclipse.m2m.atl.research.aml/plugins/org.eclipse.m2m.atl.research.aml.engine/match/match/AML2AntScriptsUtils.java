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

package match;


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.LibExtension;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;
import org.eclipse.osgi.service.datalocation.Location;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class AML2AntScriptsUtils implements LibExtension{
	
	
	
	@Override
	public void apply(ExecEnv execEnv, Map<String, Object> options) {
		String hotPropFilePath =  null; 
		String wsPath = (String)options.get("wsPath");
		String fileSep = System.getProperty("file.separator");
		hotPropFilePath = wsPath + fileSep + "AMLLibrary" + fileSep + "ATL" + fileSep + "HOT" + fileSep + "MatchingMethod-HOT.properties";
		
		final Properties properties = new Properties();
		
			 
		try {
			InputStream MHProperties = new FileInputStream(hotPropFilePath);
			properties.load(MHProperties);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Operation opGetEclipsePath = new Operation(1, "getEclipsePath") {
			public Object exec(AbstractStackFrame frame) {				
				return getEclipsePath();
			
			}
		};
		
		execEnv.registerOperation(String.class, opGetEclipsePath);
		
		Operation opGetSuperImposingHots = new Operation(1, "getSuperImposingHots") {
			public Object exec(AbstractStackFrame frame) {
					
					Object localVars[] = frame.getLocalVars();
					EObject matcher = (EObject)localVars[0];
					return getSuperimposingModules(matcher);
					
				
			}
			
			private Collection<String> getSuperimposingModules(EObject matcher) {
				
				EObject modelsFlowsBlock = (EObject) get(matcher, "modelsFlowsBlock");
				EList<EObject> modelsFlows = (EList<EObject>) get(modelsFlowsBlock, "modelsFlows");
				
				ArrayList<String> modules = new ArrayList<String>();
				EObject method;
				String methodName;
				String HOTName;
				
				for(Iterator<EObject> ite = modelsFlows.iterator(); ite.hasNext();){
					method = (EObject) get(ite.next(), "method");
					methodName = (String) get(method, "name");
					HOTName = properties.getProperty(methodName);
					if(HOTName != null){					
						modules.add(HOTName);
					}
				}
				
				return modules;
			}
			
			
		};
		
		for(Iterator<IModel> i = execEnv.getModels() ; i.hasNext() ; ) {
			IModel m = i.next();
			if(m instanceof IReferenceModel) {
				IReferenceModel rm = (IReferenceModel)m;
				Object wle = rm.getMetaElementByName("Matcher");
				if(wle != null)
					execEnv.registerOperation(wle, opGetSuperImposingHots);			
			}
		}
		
		
		
		
	}
	
	
	
	private static String getEclipsePath() {
		Location loc  = Platform.getInstallLocation();				
		String eclipsePath = loc.getURL().getPath();
		return eclipsePath;
	}
	
	public static Object get(EObject eo, String featureName) {
		return eo.eGet(eo.eClass().getEStructuralFeature(featureName));
	}

}
