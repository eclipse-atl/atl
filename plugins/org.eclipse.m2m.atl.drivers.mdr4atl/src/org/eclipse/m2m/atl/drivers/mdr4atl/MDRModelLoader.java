/*******************************************************************************
 * Copyright (c) 2004 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.mdr4atl;

import java.io.InputStream;
import java.util.logging.Level;

import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * @author Frédéric Jouault
 */
public class MDRModelLoader extends ModelLoader {

	public ASMModel loadModel(String name, ASMModel metamodel, InputStream in) {
		return null;
	}

	protected ASMModel realLoadModel(String name, ASMModel metamodel, String href) {
		ASMModel ret = null;

		try {
			ret = ASMMDRModel.loadASMMDRModel(name, (ASMMDRModel)metamodel, href, this);
		} catch(Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace(System.out);
		}

		return ret;
	}

	public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;

		try {
			ret = ASMMDRModel.newASMMDRModel(name, (ASMMDRModel)metamodel, this);
		} catch(Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace(System.out);
		}

		return ret;
	}

	public ASMModel newModel(String name, String uri, ASMModel metamodel) {
		ASMModel ret = null;

		try {
			ret = ASMMDRModel.newASMMDRModel(name, uri, (ASMMDRModel)metamodel, this);
		} catch(Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace(System.out);
		}

		return ret;
	}

	private String xmiVersion = null;
	private String encoding = null;
	
	protected void setParameter(String name, Object value) {
		if("xmiVersion".equals(name)) {
			xmiVersion = (String)value;
		} else if("encoding".equals(name)) {
			encoding = (String)value;
		}
	}

	protected void realSave(ASMModel model, String href) {
		try {
			((ASMMDRModel)model).save(href, xmiVersion, encoding);
		} catch(Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace(System.out);
		}
	}

	public ASMModel getMOF() {
		if(mofmm == null) {
			mofmm = ASMMDRModel.createMOF(this);
		}
		
		return mofmm;
	}
	
	private ASMMDRModel mofmm = null;
}

