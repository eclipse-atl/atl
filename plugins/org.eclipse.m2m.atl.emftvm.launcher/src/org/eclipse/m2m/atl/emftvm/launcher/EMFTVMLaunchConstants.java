/*******************************************************************************
 * Copyright (c) 2011-2014 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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

	/**
	 * The EMFTVM launch configuration ID.
	 */
	String LAUNCH_CONFIGURATION_TYPE = "org.eclipse.m2m.atl.emftvm.launcher.EMFTVMTransformation"; //$NON-NLS-1$
	/** Module File Name. */
	String MODULE_FILE_NAME = "Module File Name"; //$NON-NLS-1$
	/** Module Name. */
	String MODULE_NAME = "Module Name"; //$NON-NLS-1$
	/** Module Path. */
	String MODULE_PATH = "Module Path"; //$NON-NLS-1$
	/** Metamodels. */
	String METAMODELS = "Metamodels"; //$NON-NLS-1$
	/** Input Models. */
	String INPUT_MODELS = "Input Models"; //$NON-NLS-1$
	/** Inout Models. */
	String INOUT_MODELS = "Inout Models"; //$NON-NLS-1$
	/** Inout Models Output Locations. */
	String INOUT_OUT_MODELS = "Inout Models Output Locations"; //$NON-NLS-1$
	/** Output Models. */
	String OUTPUT_MODELS = "Output Models"; //$NON-NLS-1$
	/** Display Timing Data. */
	String DISPLAY_TIMING = "Display Timing Data"; //$NON-NLS-1$
	/** Disable JIT compiler. */
	String DISABLE_JIT = "Disable JIT compiler"; //$NON-NLS-1$
	/** Display Profiling Data. */
	String PROFILE = "Display Profiling Data"; //$NON-NLS-1$
	/** Metamodel Options. */
	String METAMODEL_OPTIONS = "Metamodel Options"; //$NON-NLS-1$
	/** Input Model Options. */
	String INPUT_MODEL_OPTIONS = "Input Model Options"; //$NON-NLS-1$
	/** Inout Model Options. */
	String INOUT_MODEL_OPTIONS = "Inout Model Options"; //$NON-NLS-1$
	/** Output Model Options. */
	String OUTPUT_MODEL_OPTIONS = "Output Model Options"; //$NON-NLS-1$

	/** isMetametamodel. */
	String OPT_IS_METAMETAMODEL = "isMetametamodel"; //$NON-NLS-1$
	/** allowInterModelReferences. */
	String OPT_ALLOW_INTER_MODEL_REFERENCES = "allowIntermodelReferences"; //$NON-NLS-1$
	/** derivedFile. */
	String OPT_DERIVED_FILE = "derivedFile"; //$NON-NLS-1$
	/** createNewModel. */
	String OPT_CREATE_NEW_MODEL = "createNewModel"; //$NON-NLS-1$

}
