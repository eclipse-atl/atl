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

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * Images for EMFTVM launcher plug-in.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public final class EmftvmLauncherImages {

	/**
	 * Icons path.
	 */
	public static final String ICONS_PATH = "icons/"; //$NON-NLS-1$

	/** Image name prefix. */
	public static final String NAME_PREFIX = EmftvmLauncherPlugin.PLUGIN_ID + "."; //$NON-NLS-1$

	/*
	 * Frequently used images.
	 */
	/** Main tab image name. */
	public static final String OBJ_MAIN_TAB = NAME_PREFIX + "MAIN_TAB"; //$NON-NLS-1$
	/** Parameter tab image name. */
	public static final String OBJ_PARAMETER_TAB = NAME_PREFIX + "PARAMETER_TAB"; //$NON-NLS-1$

	/*
	 * Set of predefined Image Descriptors.
	 */
	/** OBJ image path. */
	public static final String PATH_OBJ = ICONS_PATH + "obj16/"; //$NON-NLS-1$

	/*
	 * OBJ16 images.
	 */
	/** EMFTVM launch image. */
	public static final ImageDescriptor DESC_EMFTVM = create(PATH_OBJ, "emftvm_launch.gif"); //$NON-NLS-1$
	/** Main tab image. */
	public static final ImageDescriptor DESC_MAIN_TAB = create(PATH_OBJ, "main_tab.gif"); //$NON-NLS-1$
	/** Parameter tab image. */
	public static final ImageDescriptor DESC_PARAMETER_TAB = create(PATH_OBJ, "parameter_tab.gif"); //$NON-NLS-1$

	private static ImageRegistry pluginRegistry;

	/**
	 * Do not use.
	 */
	private EmftvmLauncherImages() {
	}

	/**
	 * Creates an {@link ImageDescriptor} for <code>prefix</code>, <code>name</code>.
	 * @param prefix
	 * @param name
	 * @return a new {@link ImageDescriptor}
	 */
	private static ImageDescriptor create(String prefix, String name) {
		return ImageDescriptor.createFromURL(makeImageURL(prefix, name));
	}

	/**
	 * Returns the {@link Image} for <code>key</code>, or <code>null</code>.
	 * @param key the image name
	 * @return the {@link Image} for <code>key</code>, or <code>null</code>.
	 */
	public static Image get(String key) {
		if (pluginRegistry == null)
			initialize();
		return pluginRegistry.get(key);
	}

	/* package */
	private static void initialize() {
		pluginRegistry = new ImageRegistry();
		manage(OBJ_MAIN_TAB, DESC_MAIN_TAB);
		manage(OBJ_PARAMETER_TAB, DESC_PARAMETER_TAB);
	}

	/**
	 * Creates an image {@link URL} for <code>prefix</code>, <code>name</code>.
	 * @param prefix
	 * @param name
	 * @return the {@link URL}
	 */
	private static URL makeImageURL(String prefix, String name) {
		String path = "$nl$/" + prefix + name; //$NON-NLS-1$
		return FileLocator.find(EmftvmLauncherPlugin.getInstance().getBundle(), new Path(path), null);
	}

	/**
	 * Creates an {@link Image} from <code>desc</code>, and registers it under <code>key</code>.
	 * @param key the image name
	 * @param desc the image descriptor
	 * @return the new {@link Image}
	 */
	public static Image manage(String key, ImageDescriptor desc) {
		Image image = desc.createImage();
		pluginRegistry.put(key, image);
		return image;
	}
}
