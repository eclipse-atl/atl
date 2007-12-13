/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.launching;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;

/**
 * @author Frederic Jouault
 */
public abstract class AtlVM implements ILaunchConfigurationDelegate {
	
	public final static String ATLVM_REGULAR = "Regular VM (with debugger)";

	private static String atlVMs[] = null;

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);
	
	public static AtlVM getVM(String vm) {
		AtlVM ret = null;
		
		// TODO old ATL launch configuration does not have vm attribute, retro-compatibility may be dealed by ATL launch configuration 
		if (vm == null || vm.equals(""))
			vm = ATLVM_REGULAR;
		
		if(ATLVM_REGULAR.equals(vm)) {
			ret = new AtlRegularVM();
		} else {
			IExtensionRegistry registry = Platform.getExtensionRegistry();
            if (registry == null) {
                throw new RuntimeException("Eclipse platform extension registry not found. Dynamic repository lookup does not work outside Eclipse.");
            }
            
			IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.adt.debug.atlvm");

			IExtension[] extensions = point.getExtensions();		
			extensions: for(int i = 0 ; i < extensions.length ; i++){		
				IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for(int j = 0 ; j < elements.length ; j++){
					try {					
						if(elements[j].getAttribute("name").equals(vm)) {
							ret = (AtlVM)elements[j].createExecutableExtension("class");
							break extensions;
						}
					} catch (CoreException e){
						logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//						e.printStackTrace();
					}				
				}
			 }
		}

		if(ret == null) {
			throw new RuntimeException("ATL VM " + vm + " not found. You may need to install an ATL VM plugin.");
		}
		
		return ret;
	}
	
	public static String[] getVMs() {
		if(atlVMs == null) {
			List avms = new ArrayList();
			avms.add(ATLVM_REGULAR);
			
			IExtensionRegistry registry = Platform.getExtensionRegistry();		
			IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.adt.debug.atlvm");
	
			IExtension[] extensions = point.getExtensions();		
			for(int i = 0 ; i < extensions.length ; i++){		
				IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for(int j = 0 ; j < elements.length ; j++){
					avms.add(elements[j].getAttribute("name"));
				}
			}
			atlVMs = (String[])avms.toArray(new String [] {});
		}
		return atlVMs;
	}

	public abstract void launch(URL asmUrl, Map libs, Map models, Map params, List superimps, Map options);
}
