/*
 * Created on 1 juin 2004
 *
 */
package org.atl.eclipse.engine;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.mda.asm.nativeimpl.ASMMDRModel;
import org.mda.asm.nativeimpl.ASMModel;

/**
 * @author JOUAULT
 *
 */
public class AtlMDRModelHandler extends AtlModelHandler{
	
	private ASMMDRModel atlmm;
	private ASMMDRModel mofmm;	
	public void saveModel(final ASMModel model, IProject project) {
		saveModel(model, model.getName() + ".xmi", project);
	}
	
	public void saveModel(final ASMModel model, String fileName, IProject project) {
		IFile file = project.getFile(fileName);
		try {
			PipedInputStream in = new PipedInputStream();
			final OutputStream out = new PipedOutputStream(in);
			new Thread() {
				public void run() {
					try {
						((ASMMDRModel)model).save(out);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
			if(file.exists())
				file.setContents(in, IFile.FORCE, null);
			else
				file.create(in, IFile.FORCE, null);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public ASMModel getAtl() {
		return atlmm;
	}

	public ASMModel getMof() {
		return mofmm;
	}
	
	public ASMModel loadModel(String name, ASMModel metamodel, InputStream in) {
		ASMModel ret = null;
		
		try {
			ret = ASMMDRModel.loadASMMDRModel(name, (ASMMDRModel)metamodel, in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;
		
		try {
			ret = ASMMDRModel.newASMMDRModel(name, (ASMMDRModel)metamodel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	protected AtlMDRModelHandler() {
		URL atlurl = AtlMDRModelHandler.class.getResource("resources/ATL-0.2.xmi");
		mofmm = ASMMDRModel.createMOF();
		
		try {
			atlmm = ASMMDRModel.loadASMMDRModel("ATL", mofmm, atlurl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ASMModel getBuiltInMetaModel(String name) {
		ASMModel ret = null;
		
		return ret;
	}
}
