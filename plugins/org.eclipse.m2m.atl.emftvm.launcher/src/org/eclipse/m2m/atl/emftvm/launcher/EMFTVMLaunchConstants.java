/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.launcher;

/**
 * Constants for launching EMFTVM transformations in the Eclipse UI.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public interface EMFTVMLaunchConstants {

	String LAUNCH_CONFIGURATION_TYPE = "org.eclipse.m2m.atl.emftvm.launcher.EMFTVMTransformation"; //$NON-NLS-1$
	String MODULE_FILE_NAME = "Module File Name"; //$NON-NLS-1$
	String METAMODELS = "Metamodels"; //$NON-NLS-1$
	String INPUT_MODELS = "Input Models"; //$NON-NLS-1$
	String INOUT_MODELS = "Inout Models"; //$NON-NLS-1$
	String OUTPUT_MODELS = "Output Models"; //$NON-NLS-1$
	String DISPLAY_TIMING = "Display Timing Data"; //$NON-NLS-1$
	String METAMODEL_OPTIONS = "Metamodel Options"; //$NON-NLS-1$
	String INPUT_MODEL_OPTIONS = "Input Model Options"; //$NON-NLS-1$
	String INOUT_MODEL_OPTIONS = "Inout Model Options"; //$NON-NLS-1$
	String OUTPUT_MODEL_OPTIONS = "Output Model Options"; //$NON-NLS-1$
	
	String OPT_ALLOW_INTER_MODEL_REFERENCES = "allowIntermodelReferences"; //$NON-NLS-1$
	String OPT_DERIVED_FILE = "derivedFile"; //$NON-NLS-1$

}
