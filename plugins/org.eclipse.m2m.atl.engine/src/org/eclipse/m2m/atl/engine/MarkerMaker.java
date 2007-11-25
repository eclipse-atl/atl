/*
 * Created on 21 juil. 2004
 * @author idrissi
 */
package org.eclipse.m2m.atl.engine;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModelElement;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * @author idrissi
 *
 */
public class MarkerMaker {	
	
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	private static Map severities = new HashMap();
	
	static {
		severities.put("error", new Integer(IMarker.SEVERITY_ERROR));
		severities.put("warning", new Integer(IMarker.SEVERITY_WARNING));		
		severities.put("critic", new Integer(IMarker.SEVERITY_INFO));		
	}
	
	/**
	 * creates a problem marker from an Eobject. This EObject contain the required information.
	 * @see org.eclipse.m2m.atl.engine.resources#Problem.ecore
	 * @param res the resource associated to the created marker
	 * @param problem the EObject representing a problem
	 */
	private void eObjectToPbmMarker(IResource res, EObject problem, int tabWidth) {
		EPackage pkProblem = null;
		EClass clProblem = null;
		EStructuralFeature sfSeverity = null;
		EStructuralFeature sfLocation = null;
		EStructuralFeature sfDescription = null;
		
		pkProblem = problem.eClass().getEPackage();
		clProblem = (EClass)pkProblem.getEClassifier("Problem");
		sfSeverity = clProblem.getEStructuralFeature("severity");
		sfLocation = clProblem.getEStructuralFeature("location");
		sfDescription = clProblem.getEStructuralFeature("description");


		String description = (String)problem.eGet(sfDescription);
		
		String location = (String)problem.eGet(sfLocation);
		int lineNumber = Integer.parseInt(location.split(":")[0]);
		int charStart = 0, charEnd = 0;
		try {
			AtlNbCharFile help = new AtlNbCharFile(((IFile)res).getContents());
			if (location.indexOf('-') == -1) {
				location +=  '-' + location;
			}
			int[] pos = help.getIndexChar(location, tabWidth);
			charStart = pos[0];
			charEnd = pos[1];
		} catch (CoreException e1) {
			logger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
//			e1.printStackTrace();
		} catch(Exception e) {
			description += " [location \"" + location + "\" incorrectly reported because of error]";
		}
		
		String severity = ((EEnumLiteral)problem.eGet(sfSeverity)).getName();
		int eclipseSeverity = ((Integer)severities.get(severity)).intValue();
		
		try {
			IMarker pbmMarker = res.createMarker(IMarker.PROBLEM);
			pbmMarker.setAttribute(IMarker.SEVERITY, eclipseSeverity);
			pbmMarker.setAttribute(IMarker.MESSAGE, description);
			pbmMarker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
			pbmMarker.setAttribute(IMarker.CHAR_START, charStart);
			pbmMarker.setAttribute(IMarker.CHAR_END, (charEnd > charStart) ? charEnd : charStart + 1);
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
	}
	
	private void createPbmMarkers(IResource res, EObject[] eos, int tabWidth) {
		for (int i = 0; i  < eos.length; i++) {
			eObjectToPbmMarker(res, eos[i], tabWidth);
		}
	}
	
	public void resetPbmMarkers(IResource res, EObject[] eos) throws CoreException {
		resetPbmMarkers(res, eos, -1);
	}
	
	public void resetPbmMarkers(final IResource res, final EObject[] eos, final int tabWidth) throws CoreException {
		try {
			res.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}
		IWorkspaceRunnable r = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				createPbmMarkers(res, eos, tabWidth);
			}
		};
		
		res.getWorkspace().run(r, null, IWorkspace.AVOID_UPDATE, null);
	}
	
	public int applyMarkers(IFile file, ASMModel pbs) throws CoreException {
		return applyMarkers(file, pbs, -1);
	}
	/**
	 * Transforms the Problem model given as argument into a set of markers.
	 * @param file Resource on which markers are to be added.
	 * @param pbs The Problem model containing the problems.
	 * @return The number of errors (Problems with severity #error).
	 * @throws CoreException
	 */
	public int applyMarkers(IFile file, ASMModel pbs, int tabWidth) throws CoreException {
		int nbErrors = 0;
		
		Collection pbsc = pbs.getElementsByType("Problem");
		EObject pbsa[] = new EObject[pbsc.size()];
		int k = 0;
		for(Iterator i = pbsc.iterator() ; i.hasNext() ; ) {
			ASMEMFModelElement ame = (ASMEMFModelElement)i.next();
			pbsa[k] = ame.getObject();
			if("error".equals(((ASMEnumLiteral)ame.get(null, "severity")).getName())) {
				nbErrors++;
			}
			k++;
		}
		resetPbmMarkers(file, pbsa, tabWidth);
		
		return nbErrors;
	}	

}
