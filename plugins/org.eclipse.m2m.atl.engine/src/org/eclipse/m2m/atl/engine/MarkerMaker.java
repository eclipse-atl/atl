/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Tarik Idrissi (INRIA) - initial API and implementation
 *     Frederic Jouault (INRIA)
 *******************************************************************************/
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
 * The MarkerMaker class.
 * 
 * @author <a href="mailto:tarik.idrissi@laposte.net">Tarik Idrissi</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class MarkerMaker {

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	private static Map severities = new HashMap();

	static {
		severities.put("error", new Integer(IMarker.SEVERITY_ERROR)); //$NON-NLS-1$
		severities.put("warning", new Integer(IMarker.SEVERITY_WARNING)); //$NON-NLS-1$		
		severities.put("critic", new Integer(IMarker.SEVERITY_INFO)); //$NON-NLS-1$		
	}

	/**
	 * creates a problem marker from an Eobject. This EObject contain the required information.
	 * 
	 * @see org.eclipse.m2m.atl.engine.resources#Problem.ecore
	 * @param res
	 *            the resource associated to the created marker
	 * @param problem
	 *            the EObject representing a problem
	 */
	private void eObjectToPbmMarker(IResource res, AtlNbCharFile help, EObject problem, int tabWidth) {
		EPackage pkProblem = null;
		EClass clProblem = null;
		EStructuralFeature sfSeverity = null;
		EStructuralFeature sfLocation = null;
		EStructuralFeature sfDescription = null;

		pkProblem = problem.eClass().getEPackage();
		clProblem = (EClass)pkProblem.getEClassifier("Problem"); //$NON-NLS-1$
		sfSeverity = clProblem.getEStructuralFeature("severity"); //$NON-NLS-1$
		sfLocation = clProblem.getEStructuralFeature("location"); //$NON-NLS-1$
		sfDescription = clProblem.getEStructuralFeature("description"); //$NON-NLS-1$

		String description = (String)problem.eGet(sfDescription);

		String location = (String)problem.eGet(sfLocation);
		String[] parts = location.split("-")[0].split(":");
		int lineNumber = Integer.parseInt(parts[0]);
		int columnNumber = Integer.parseInt(parts[1]);
		int charStart = 0;
		int charEnd = 0;
		// try {
		if (location.indexOf('-') == -1) {
			location += '-' + location;
		}
		int[] pos = help.getIndexChar(location, tabWidth);
		charStart = pos[0];
		charEnd = pos[1];
		// } catch (Exception e) {
		// description += " [location \"" + location + "\" incorrectly reported because of error]";
		// //$NON-NLS-1$//$NON-NLS-2$
		// }

		String severity = ((EEnumLiteral)problem.eGet(sfSeverity)).getName();
		int eclipseSeverity = ((Integer)severities.get(severity)).intValue();

		try {
			IMarker pbmMarker = res.createMarker(IMarker.PROBLEM);
			pbmMarker.setAttribute(IMarker.SEVERITY, eclipseSeverity);
			pbmMarker.setAttribute(IMarker.MESSAGE, description);
			pbmMarker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
			pbmMarker.setAttribute(IMarker.LOCATION, "line " + lineNumber + ", column " + columnNumber);
			pbmMarker.setAttribute(IMarker.CHAR_START, charStart);
			pbmMarker.setAttribute(IMarker.CHAR_END, (charEnd > charStart) ? charEnd : charStart + 1);
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	private void createPbmMarkers(IResource res, EObject[] eos, int tabWidth) {
		try {
			AtlNbCharFile help = new AtlNbCharFile(((IFile)res).getContents());
			for (int i = 0; i < eos.length; i++) {
				eObjectToPbmMarker(res, help, eos[i], tabWidth);
			}
		} catch (CoreException e1) {
			logger.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
		}
	}

	/**
	 * Resets the marker on a resource.
	 * 
	 * @param res the resource
	 * @param eos the problem list
	 * @throws CoreException
	 */
	public void resetPbmMarkers(IResource res, EObject[] eos) throws CoreException {
		resetPbmMarkers(res, eos, -1);
	}

	private void resetPbmMarkers(final IResource res, final EObject[] eos, final int tabWidth)
			throws CoreException {
		IWorkspaceRunnable r = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				synchronized (res) {
					try {
						res.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
					} catch (CoreException e) {
						logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
					createPbmMarkers(res, eos, tabWidth);
				}
			}
		};

		res.getWorkspace().run(r, null, IWorkspace.AVOID_UPDATE, null);
	}

	/**
	 * Transforms the Problem model given as argument into a set of markers.
	 * 
	 * @param file
	 *            Resource on which markers are to be added.
	 * @param pbs
	 *            The Problem model containing the problems.
	 * @return The number of errors (Problems with severity #error).
	 * @throws CoreException
	 */
	public int applyMarkers(IFile file, ASMModel pbs) throws CoreException {
		return applyMarkers(file, pbs, -1);
	}

	/**
	 * Transforms the Problem model given as argument into a set of markers.
	 * 
	 * @param file
	 *            Resource on which markers are to be added.
	 * @param pbs
	 *            The Problem model containing the problems.
	 * @param tabWidth
	 *            the size of the tab
	 * @return The number of errors (Problems with severity #error).
	 * @throws CoreException
	 */
	private int applyMarkers(IFile file, ASMModel pbs, int tabWidth) throws CoreException {
		int nbErrors = 0;

		Collection pbsc = pbs.getElementsByType("Problem"); //$NON-NLS-1$
		EObject[] pbsa = new EObject[pbsc.size()];
		int k = 0;
		for (Iterator i = pbsc.iterator(); i.hasNext();) {
			ASMEMFModelElement ame = (ASMEMFModelElement)i.next();
			pbsa[k] = ame.getObject();
			if ("error".equals(((ASMEnumLiteral)ame.get(null, "severity")).getName())) { //$NON-NLS-1$//$NON-NLS-2$
				nbErrors++;
			}
			k++;
		}
		resetPbmMarkers(file, pbsa, tabWidth);

		return nbErrors;
	}

}
