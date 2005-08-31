package org.atl.eclipse.mgm.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.atl.eclipse.engine.AtlLauncher;
import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.eclipse.mgm.MgmPlugin;
import org.atl.engine.vm.nativelib.ASMModel;
import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMString;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IActionDelegate;

/**
 * This action executes an ATL query
 * @author allilaire
 */
public class ActionATLExtractor extends Action {

	private AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
	private IFile file;
	private EObject extractor;
	private EObject metamodel;
	
	/**
	 * Constructor for ActionATLExtractor
	 */
	public ActionATLExtractor(String text, IFile file, EObject extractor, EObject metamodel) {
		super(text);
		this.file = file;
		this.extractor = extractor;
		this.metamodel = metamodel;
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run() {
		try {
			InputStream in = file.getContents();
			File languageMetamodel = new File(MgmPlugin.getPluginRep() + MgmPlugin.getDefault().getHandler().get(metamodel, "uri"));
			ASMModel mm = amh.loadModel((String)MgmPlugin.getDefault().getHandler().get(metamodel, "name"), amh.getMof(), new FileInputStream(languageMetamodel));
			ASMModel model = amh.loadModel(file.getName(), mm, in);

			Map models = new HashMap();
			models.put(MgmPlugin.getDefault().getHandler().get(extractor, "paramMetamodel"), mm);
			models.put(MgmPlugin.getDefault().getHandler().get(extractor, "paramModel"), model);
			Map params = Collections.EMPTY_MAP;
			Map libs = Collections.EMPTY_MAP;
			URL asmUrl = new File(MgmPlugin.getPluginRep() + ((String)MgmPlugin.getDefault().getHandler().get(extractor, "uri"))).toURL(); 
			ASMOclAny s = (ASMOclAny)AtlLauncher.getDefault().launch(asmUrl, libs, models, params);

			if (s == null)
				return;
			
			if (!(s instanceof ASMString)) {
				System.err.println("Query is not an instance of ASMString");
			}
			
			String name = file.getName();
			name = name.substring(0, name.length() - file.getFileExtension().length()) + MgmPlugin.getDefault().getHandler().get(extractor, "extension");
			if(((ASMString)s).getSymbol() != null) {
				IWorkspace wks = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot wksroot = wks.getRoot();
				IFile fileCreated = wksroot.getFile(file.getFullPath().removeLastSegments(1).append(name));
				InputStream stream = openContentStream(((ASMString)s).getSymbol());
				if (fileCreated.exists()) {
					fileCreated.setContents(stream, true, true, null);
				} else {
					fileCreated.create(stream, true, null);
				}
				try {
					stream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}		
		} catch (CoreException e) {
			e.printStackTrace();
		}
		catch (IOException e1) {
			System.err.println(e1);
		}
	}
	
	/**
	 * This method transforms string into inputstream
	 * @param contents content of the file to cast in InputStream
	 * @return the InputStream content
	 */
	private InputStream openContentStream(String contents) {
		return new ByteArrayInputStream(contents.getBytes());
	}

}
