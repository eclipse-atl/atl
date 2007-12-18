/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.m2m.atl.adt.ui.logging.ConsoleStreamHandler;
import org.eclipse.m2m.atl.adt.ui.text.AtlTextTools;
import org.eclipse.m2m.atl.adt.ui.viewsupport.ProblemMarkerManager;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 * This class is necessary for every plug-in because it used by Eclipse to dialog
 * with it and its extensions.
 */
public class AtlUIPlugin extends AbstractUIPlugin {

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);
	private static MessageConsole console = null;
	private static MessageConsoleStream consoleStream = null;
    private static IConsoleManager consoleMgr = null; 
	private static final String ATL_CONSOLE = "org.eclipse.m2m.atl.adt.editor.console";	//$NON-NLS-1$
	private static final String ID = "org.eclipse.m2m.atl.adt.editor";//$NON-NLS-1$
	
	/**
	 * This class registers a shared (static) instance of the plug-in that can be
	 * accessible from everywhere.
	 */
	static private AtlUIPlugin plugin;
	
	public static IWorkbenchPage getActivePage() {
		return getDefault().internalGetActivePage();
	}
	
	/**
	 * Returns the shared instance of the plug-in.
	 */
	static public AtlUIPlugin getDefault() {
		return plugin;
	}
	
	/**
	 * Returns the image descriptor with the given relative path.
	 */
	static public ImageDescriptor getImageDescriptor(String name) {
		AtlUIPlugin plugin = AtlUIPlugin.getDefault();
		String pluginDir = plugin.getBundle().getEntry("/").toString();//$NON-NLS-1$
		String iconPath = "icons/";//$NON-NLS-1$
		try {
			return ImageDescriptor.createFromURL(
					new URL(pluginDir + iconPath + name));
		}
		catch(MalformedURLException mfe) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}
	
	public static String getPluginId() {
		return ID;
	}
	
	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	static public String getResourceString(String key) {
		ResourceBundle bundle = AtlUIPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}
	
	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}
	
	public static void log(Throwable e) {
		log(new Status(IStatus.ERROR, getPluginId(), IAtlStatusConstants.INTERNAL_ERROR, Messages.getString("JavaPlugin.internal_error"), e));//$NON-NLS-1$
	}
	
	/**
	 * Our plug-in uses a text tools to allow every part of the plug-in to have the
	 * same tools for configuring their variables.
	 */
	private AtlTextTools atlTextTools;
	
	//  The problem marker manager 
	private ProblemMarkerManager problemMarkerManager ;
	
	/**
	 * The specific ATL compilation editor.
	 */
	//    private ICompilationUnitDocumentProvider compilationUnitDocumentProvider;
	
	/**
	 * The resource bundle exists for the internationalization of the plug-in.
	 * The informations are stored in a file .properties and Eclipse used these files
	 * to set the default values. It also uses it to fPreferenceeStore the client values. 
	 */
	private ResourceBundle resourceBundle;
	
	/**
	 * Creates a new instance of the ATL plug-in.
	 * Use the AbstractUIPlugin constructor to define it, and try to get the resource bundle.
	 * 
	 * @param descriptor the plug-in descriptor
	 * @deprecated
	 */
	public AtlUIPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.eclipse.m2m.atl.adt.ui.AtlUIPluginResources");//$NON-NLS-1$
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}	
		
		if (console == null) initConsole ();		
	}
	
	public synchronized ProblemMarkerManager getProblemMarkerManager() {
		if (problemMarkerManager == null)
			problemMarkerManager= new ProblemMarkerManager();
		return problemMarkerManager;
	}
	
	//    public synchronized ICompilationUnitDocumentProvider getCompilationUnitDocumentProvider() {
	//        if (compilationUnitDocumentProvider == null)
	//            compilationUnitDocumentProvider = new CompilationUnitDocumentProvider();
	//        return compilationUnitDocumentProvider;
	//    }
	
	/**
	 * Returns the plugin's resource bundle.
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	/**
	 * Gets the ATL text tools used by the plug-in. If it doesn't exists,
	 * create a new one with the default preference fPreferenceeStore.
	 * 
	 * @return the text tools.
	 */
	public synchronized AtlTextTools getTextTools() {
		if (atlTextTools == null)
			atlTextTools= new AtlTextTools(getPreferenceStore());
		return atlTextTools;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#initializeDefaultPreferences(org.eclipse.jface.preference.IPreferenceStore)
	 */
	protected void initializeDefaultPreferences(IPreferenceStore store) {
		/*
		 * super.initializeDefaultPreferences(fPreferenceeStore);
		 * @deprecated
		 */
		MarkerAnnotationPreferences.initializeDefaultValues(store);
		AtlPreferenceConstants.initializeDefaultValues(store);
	}
	
	private IWorkbenchPage internalGetActivePage() {
		IWorkbenchWindow window= getWorkbench().getActiveWorkbenchWindow();
		if (window == null)
			return null;
		return getWorkbench().getActiveWorkbenchWindow().getActivePage();
	}
	
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		try {
			//            if(compilationUnitDocumentProvider != null) {
			//                compilationUnitDocumentProvider.shutdown();
			//                compilationUnitDocumentProvider = null;
			//            }
			
			if(atlTextTools != null) {
				atlTextTools.dispose();
				atlTextTools = null;
			}
		} finally {	
			super.stop(context);
		}
	}
	
	public void println (String toPrint) {
		if (consoleStream != null)
			consoleStream.println(toPrint);
	}
	
	public void print (String toPrint) {
		if (consoleStream != null)
			consoleStream.print(toPrint);
	}	
	
	private void initConsole () {
		console = findConsole(ATL_CONSOLE);
		Font f = null;
		try {
			FontData data = new FontData ("Arial", 9, 9);//$NON-NLS-1$
			data.setStyle(SWT.NORMAL);
			f = new Font (null, data);

			console.setFont(f);
		} catch (Exception ex) {	   	
		}
		// console.setFont(new Font());
		consoleStream = console.newMessageStream();
		activateConsole();
		// System.out = out;	   
		consoleStream.println(Messages.getString("AtlUIPlugin.INIT")); //$NON-NLS-1$
//		PrintStream redirStream = new PrintStream (consoleStream);
//		System.setOut(redirStream);
		// System.setErr(redirStream);	   
		Handler handler = new ConsoleStreamHandler(consoleStream);
		Logger.getLogger(ATLVMPlugin.LOGGER).addHandler(handler);
	}

	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		consoleMgr = plugin.getConsoleManager();
		IConsole[] existing = consoleMgr.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		//no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		consoleMgr.addConsoles(new IConsole[]{myConsole});
		return myConsole;
	}

	private void activateConsole () {
		IWorkbenchPage page = AtlUIPlugin.getActivePage();
		String id = IConsoleConstants.ID_CONSOLE_VIEW;
		try {
			if (page != null) {
				IConsoleView view = (IConsoleView) page.showView(id);
				view.display(console);	   	
			}
		} catch (org.eclipse.ui.PartInitException pex) {
			logger.log(Level.SEVERE, "AtlUiPlugin - " + pex.getLocalizedMessage(), pex);//$NON-NLS-1$
//			System.out.println ("AtlUiPlugin - " + pex);
		}
	}

}
