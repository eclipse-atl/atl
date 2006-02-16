/*
 * Created on 21 juil. 2004
 * @author idrissi
 */
package org.atl.eclipse.engine;

import java.util.HashMap;
import java.util.Map;

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

/**
 * @author idrissi
 *
 */
public class MarkerMaker {	
	
	private static boolean initialized = false; 
	
	private static EPackage pkProblem = null;
	private static EClass clProblem = null;
	private static EStructuralFeature sfSeverity = null;
	private static EStructuralFeature sfLocation = null;
	private static EStructuralFeature sfDescription = null;
//	private static EEnum enSeverity = null; 

	private static Map severities = new HashMap();
	
	static {
		severities.put("error", new Integer(IMarker.SEVERITY_ERROR));
		severities.put("warning", new Integer(IMarker.SEVERITY_WARNING));		
		severities.put("critic", new Integer(IMarker.SEVERITY_INFO));		
	}
	
	private void initialize(EObject problem) {
		pkProblem = problem.eClass().getEPackage();
		clProblem = (EClass)pkProblem.getEClassifier("Problem");
		sfSeverity = clProblem.getEStructuralFeature("severity");
		sfLocation = clProblem.getEStructuralFeature("location");
		sfDescription = clProblem.getEStructuralFeature("description");
//		enSeverity = (EEnum)pkProblem.getEClassifier("Severity");
		initialized = true;
	}
	
	/**
	 * creates a problem marker from an Eobject. This EObject contain the required information.
	 * @see org.atl.eclipse.engine.resources#Problem.ecore
	 * @param res the resource associated to the created marker
	 * @param eo the EObject representing a problem
	 */
	private void eObjectToPbmMarker(IResource res, EObject eo) {
		String description = (String)eo.eGet(sfDescription);
		
		String location = (String)eo.eGet(sfLocation);
		int lineNumber = Integer.parseInt(location.split(":")[0]);
		int charStart = 0, charEnd = 0;
		try {
			AtlNbCharFile help = new AtlNbCharFile(((IFile)res).getContents());
			if (location.indexOf('-') == -1) {
				location +=  '-' + location;
			}
			int[] pos = help.getIndexChar(location);
			charStart = pos[0];
			charEnd = pos[1];
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		
		String severity = ((EEnumLiteral)eo.eGet(sfSeverity)).getName();
		int eclipseSeverity = ((Integer)severities.get(severity)).intValue();
		
		try {
			IMarker pbmMarker = res.createMarker(IMarker.PROBLEM);
			pbmMarker.setAttribute(IMarker.SEVERITY, eclipseSeverity);
			pbmMarker.setAttribute(IMarker.MESSAGE, description);
			pbmMarker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
			pbmMarker.setAttribute(IMarker.CHAR_START, charStart);
			pbmMarker.setAttribute(IMarker.CHAR_END, (charEnd > charStart) ? charEnd : charStart + 1);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	private void createPbmMarkers(IResource res, EObject[] eos) {
		if (!initialized && eos.length > 0) {
			initialize(eos[0]);
		}
		for (int i = 0; i  < eos.length; i++) {
			eObjectToPbmMarker(res, eos[i]);
		}
	}
	
	public void resetPbmMarkers(final IResource res, final EObject[] eos) throws CoreException {
		try {
			res.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		IWorkspaceRunnable r = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				createPbmMarkers(res, eos);
			}
		};
		
		res.getWorkspace().run(r, null, IWorkspace.AVOID_UPDATE, null);
	}
	
}
