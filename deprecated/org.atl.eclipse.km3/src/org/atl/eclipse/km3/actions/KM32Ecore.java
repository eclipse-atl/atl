package org.atl.eclipse.km3.actions;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.atl.eclipse.adt.builder.MarkerMaker;
import org.atl.eclipse.engine.AtlLauncher;
import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.engine.repositories.emf4atl.ASMEMFModelElement;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.mda.asm.nativeimpl.ASMModel;
import org.mda.conv.KM3Lexer;
import org.mda.conv.KM3Parser;
import org.mda.injectors.EBNFInjector2;

public class KM32Ecore implements IObjectActionDelegate {

	private ISelection selection;
	private AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
	private ASMModel mm;
	private ASMModel pbmm;
	private MarkerMaker markerMaker;
	private String mmName = "KM3";

	/**
	 * Constructor for Action1.
	 */
	public KM32Ecore() {
		super();

		URL mmurl = KM32Ecore.class.getResource("resources/" + mmName + ".ecore");
		try {
			mm = amh.loadModel(mmName, amh.getMof(), mmurl.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pbmm = amh.getBuiltInMetaModel("Problem");
		markerMaker = new MarkerMaker();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		try {
			File file = ((File)((IStructuredSelection)selection).getFirstElement());
			InputStream in = file.getContents();
			
			ASMModel model = amh.newModel(file.getName(), mm);
			EBNFInjector2 ebnfi = new EBNFInjector2();
			try {
				ASMModel pbs = amh.newModel("pbs", pbmm);
				Class lexer = KM3Lexer.class;
				Class parser = KM3Parser.class;
				ebnfi.performImportation(mm, model, in, mmName, lexer, parser, pbs);
				in.close();
				
				Collection pbsc = pbs.getElementsByType("Problem");
				EObject pbsa[] = new EObject[pbsc.size()];
				int k = 0;
				for(Iterator i = pbsc.iterator() ; i.hasNext() ; ) {
					pbsa[k++] = ((ASMEMFModelElement)i.next()).getObject();
				}
				markerMaker.resetPbmMarkers(file, pbsa);
				
				// Transformation
				URL KM32EMFurl = KM32Ecore.class.getResource("resources/KM32EMF.asm");
				
				Map models = new HashMap();
				models.put("MOF", amh.getMof());
				models.put("KM3", mm);
				models.put("IN", model);
				ASMModel emf = amh.newModel("OUT", amh.getMof());
				models.put("OUT", emf);

				Map params = Collections.EMPTY_MAP;
				
				Map libs = Collections.EMPTY_MAP;

				AtlLauncher.getDefault().launch(KM32EMFurl, libs, models, params);
				String name = file.getFullPath().removeFirstSegments(1).toString();
				name = name.substring(0, name.length() - file.getFileExtension().length()) + "ecore";
				amh.saveModel(emf, name, file.getProject());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
