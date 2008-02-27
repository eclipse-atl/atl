/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL extractor
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.util;

import java.io.File;
import java.io.FileInputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.AtlParser;
import org.eclipse.m2m.atl.tests.AtlTestPlugin;

/**
 * Init parser data.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class InitParserData {

	/*
	 * PARSER TEST INITIALIZER
	 * creates all missing atl.ecore files into the expected directory
	 */
	public static void main(String[] args) {
		System.out.println("-- init --");
		File expDir = new File(AtlTestPlugin.getDefault().getBaseDirectory() + "/org.eclipse.m2m.atl.tests/data/expected");
		final File[] directories = FileUtils.listDirectories(expDir);
		if (directories != null) {
			for (int i = 0; i < directories.length; i++) {
				initSnapshots(directories[i], true);
			}
		}
		System.out.println("-- done --");
	}

	private static void initSnapshots(File directory, boolean useEmfCompare){
		if (FileUtils.listDirectories(directory).length != 0) {
			for (int i = 0; i < FileUtils.listDirectories(directory).length; i++) {
				initSnapshots(FileUtils.listDirectories(directory)[i], useEmfCompare);
			}
		} else {
			initTest(directory);
		}
	}
	
	private static void initTest(File directory) {	
		final String transfoPath = directory.toString().replaceFirst("expected","inputs")+ File.separator + directory.getName() + ".atl";	 //$NON-NLS-1$
		final String ecoreTransfoPath = directory.toString()+ File.separator + directory.getName() + ".atl.ecore";	 //$NON-NLS-1$
		if (new File(ecoreTransfoPath).exists())
			return;
		try {
			EObject result = AtlParser.getDefault().parse(new FileInputStream(transfoPath));
			ModelUtils.save(result, "file:/"+ecoreTransfoPath);	 //$NON-NLS-1$ //$NON-NLS-2$
			System.out.println(transfoPath+" extracted.");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
