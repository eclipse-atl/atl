/*
 * Created on 12 juil. 2005
 */
package org.atl.eclipse.mgm.view;

import java.util.Iterator;
import java.util.Set;

import org.atl.eclipse.mgm.MgmPlugin;
import org.atl.eclipse.mgm.action.ActionATLExtractor;
import org.atl.eclipse.mgm.action.ActionEBNFExtractor;
import org.atl.eclipse.mgm.action.ActionEBNFInjector;
import org.atl.eclipse.mgm.action.ActionXMLExtractor;
import org.atl.eclipse.mgm.action.ActionXMLInjector;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.views.navigator.ResourceNavigator;

/**
 * This class is an extension of ResourceNavigator (classic navigator in Eclipse)
 * to add specific behaviors
 * 
 * @author allilaire
 */
public class ResourceNavigatorMgm extends ResourceNavigator {
	
	public ResourceNavigatorMgm() {
		super();
	}
	
	/**
	 * If the current item selected is an instance of IFile
	 * then load method is launched
	 */
	protected void fillContextMenu(IMenuManager menu) {

		super.fillContextMenu(menu);

		IStructuredSelection selection = (IStructuredSelection) getViewer().getSelection();
		Object objectSelected = selection.getFirstElement();
		if (objectSelected instanceof IFile) {
			IFile fileSelected = (IFile)objectSelected;
			load(fileSelected.getFileExtension().toLowerCase(), fileSelected, menu);
		}
	}

	/**
	 * if fileSelected is an ecore file, extraction actions are added in context menu
	 * else
	 * 		injection action is added if there is one available for this extension
	 * @param extension extension of current fime
	 * @param fileSelected
	 * @param menu
	 */
	private void load(String extension, IFile fileSelected, IMenuManager menu) {
		if (extension.equals("ecore")) {
			Set extractors = MgmPlugin.getDefault().getHandler().getElementsBySupertype("Extractor");
			
			for (Iterator it = extractors.iterator(); it.hasNext();) {
				EObject currentExtractor = (EObject) it.next();
				
				Set metamodels = MgmPlugin.getDefault().getHandler().getElementsByType("Metamodel");
				for (Iterator it2 = metamodels.iterator(); it2.hasNext();) {
					EObject currentMetamodel = (EObject) it2.next();
					if (MgmPlugin.getDefault().getHandler().get(currentExtractor, "name").equals(MgmPlugin.getDefault().getHandler().get(currentMetamodel, "name"))) {
						menu.add(new Separator("settings"));
						String mmName = (String)MgmPlugin.getDefault().getHandler().get(currentExtractor, "name");
						String actionName = "Extract " + mmName + " model to " + mmName + " file";
						if (currentExtractor.eClass().getName().equals("ATLExtractor"))
							menu.add(new ActionATLExtractor(actionName, fileSelected, currentExtractor, currentMetamodel));
						else if (currentExtractor.eClass().getName().equals("XMLExtractor"))
							menu.add(new ActionXMLExtractor(actionName, fileSelected, currentMetamodel));
						else if (currentExtractor.eClass().getName().equals("EBNFExtractor")) {
							Set tcss = MgmPlugin.getDefault().getHandler().getElementsByType("TCS");
							for (Iterator it3 = tcss.iterator(); it3.hasNext();) {
								EObject currentTCS = (EObject) it3.next();
								if (MgmPlugin.getDefault().getHandler().get(currentTCS, "name").equals(mmName))
									menu.add(new ActionEBNFExtractor(actionName, fileSelected, currentMetamodel, currentExtractor, currentTCS));
							}
						}
					}
				}
			}
		}
		else {
			Set injectors = MgmPlugin.getDefault().getHandler().getElementsBySupertype("Injector");
			
			for (Iterator it = injectors.iterator(); it.hasNext();) {
				EObject currentInjector = (EObject) it.next();
				
				Set metamodels = MgmPlugin.getDefault().getHandler().getElementsByType("Metamodel");
				for (Iterator it2 = metamodels.iterator(); it2.hasNext();) {
					EObject currentMetamodel = (EObject) it2.next();
					if (MgmPlugin.getDefault().getHandler().get(currentInjector, "name").equals(MgmPlugin.getDefault().getHandler().get(currentMetamodel, "name"))) {
						if ((currentInjector.eClass().getName().equals("XMLInjector") && extension.equals("xml"))) {
							menu.add(new Separator("settings"));
							String mmName = (String)MgmPlugin.getDefault().getHandler().get(currentInjector, "name");
							String actionName = "Inject " + mmName + " file to " + mmName + " model";
							
							menu.add(new ActionXMLInjector(actionName, fileSelected, currentMetamodel));
						}
						else if	(currentInjector.eClass().getName().equals("EBNFInjector") && extension.equals(MgmPlugin.getDefault().getHandler().get(currentInjector, "extension"))) {
							menu.add(new Separator("settings"));
							String mmName = (String)MgmPlugin.getDefault().getHandler().get(currentInjector, "name");
							String actionName = "Inject " + mmName + " file to " + mmName + " model";
							
							menu.add(new ActionEBNFInjector(actionName, fileSelected, currentInjector, currentMetamodel));
						}
					}
				}
			}
		}
	}

}