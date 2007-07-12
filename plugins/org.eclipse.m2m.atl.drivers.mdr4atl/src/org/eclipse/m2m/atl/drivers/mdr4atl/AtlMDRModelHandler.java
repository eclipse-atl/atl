/*
 * Created on 1 juin 2004
 *
 */
package org.eclipse.m2m.atl.drivers.mdr4atl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

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
		saveModel(model, file);
	}

	public void saveModel(final ASMModel model, String uri) {
        try {
            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri));
            saveModel(model, file);
        } catch (Throwable e) {
            try {
                ((ASMMDRModel)model).save(uri);
            } catch (IOException ioe) {
    			logger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
//                ioe.printStackTrace();
            }
        }
	}
	
	private void saveModel(final ASMModel model, IFile file) {
		try {
			PipedInputStream in = new PipedInputStream();
			final OutputStream out = new PipedOutputStream(in);
			new Thread() {
				public void run() {
                    saveModel(model, out);
				}
			}.start();
			if(file.exists())
				file.setContents(in, IFile.FORCE, null);
			else
				file.create(in, IFile.FORCE, null);
			file.setDerived(true);
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}		
	}
	
    public void saveModel(final ASMModel model, OutputStream out) {
        try {
            ((ASMMDRModel)model).save(out);
        } catch (IOException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//            e.printStackTrace();
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
			ret = ASMMDRModel.loadASMMDRModel(name, (ASMMDRModel)metamodel, in, null);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
		
		return ret;
	}

    /**
     * @see ASMMDRModel#newASMMDRModel(String, ASMMDRModel, ModelLoader)
     */
    public ASMModel newModel(String name, ASMModel metamodel) {
		ASMModel ret = null;
		
		try {
			ret = ASMMDRModel.newASMMDRModel(name, (ASMMDRModel)metamodel, null);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
		
		return ret;
	}

    /**
     * @see ASMMDRModel#newASMMDRModel(String, String, ASMMDRModel, ModelLoader)
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
    public ASMModel newModel(String name, String uri, ASMModel metamodel) {
        ASMModel ret = null;
        
        try {
            ret = ASMMDRModel.newASMMDRModel(name, uri, (ASMMDRModel)metamodel, null);
        } catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//            e.printStackTrace();
        }
        
        return ret;
    }

	public AtlMDRModelHandler() {
		URL atlurl = AtlMDRModelHandler.class.getResource("resources/ATL-0.2.xmi");
		mofmm = ASMMDRModel.createMOF(null);
		
		try {
			atlmm = ASMMDRModel.loadASMMDRModel("ATL", mofmm, atlurl, null);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
	}
	
	public ASMModel getBuiltInMetaModel(String name) {
		ASMModel ret = null;
		
		return ret;
	}

	public boolean isHandling(ASMModel model) {
		return model instanceof ASMMDRModel;
	}

	public void disposeOfModel(ASMModel model) {
		((ASMMDRModel)model).dispose();
	}
}
