package org.atl.engine.repositories.mdr4atl;

import java.io.InputStream;

import org.atl.engine.vm.ModelLoader;
import org.atl.engine.vm.nativelib.ASMModel;

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
			e.printStackTrace(System.out);
		}

		return ret;
	}

	public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;

		try {
			ret = ASMMDRModel.newASMMDRModel(name, (ASMMDRModel)metamodel, this);
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}

		return ret;
	}

	private String xmiVersion = null;
	
	protected void setParameter(String name, Object value) {
		if("xmiVersion".equals(name)) {
			xmiVersion = (String)value;
		}
	}

	protected void realSave(ASMModel model, String href) {
		try {
			((ASMMDRModel)model).save(href, xmiVersion);
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}

	public ASMModel getMOF() {
		ASMModel ret = null;

		ret = ASMMDRModel.createMOF(this);

		return ret;
	}
}

