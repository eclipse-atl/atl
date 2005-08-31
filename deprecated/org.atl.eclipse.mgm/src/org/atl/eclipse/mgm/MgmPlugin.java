package org.atl.eclipse.mgm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

/**
 * The main plugin class to be used in the desktop.
 */
public class MgmPlugin extends AbstractUIPlugin {

	//The shared instance.
	private static MgmPlugin plugin;

	//Resource bundle.
	private ResourceBundle resourceBundle;
	private JarClassLoader loader;
	private MetaHandler handler;
	
	/**
	 * The constructor.
	 */
	public MgmPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.atl.eclipse.mgm.MgmPluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);

		Dictionary dico = MgmPlugin.getDefault().getBundle().getHeaders();
		String requires = (String)dico.get(Constants.BUNDLE_CLASSPATH);
		
		String metaModel = MgmPlugin.getPluginRep() + "resources/AM3/AM3.ecore";
		String model = MgmPlugin.getPluginRep() + "resources/AM3/megamodel-AM3.ecore";
		handler = new MetaHandler(metaModel, model);

		Set elements = handler.getElementsByType("EBNFInjector");

		for (Iterator it = elements.iterator(); it.hasNext();) {
			EObject eo = (EObject) it.next();
			requires += ",\n " + handler.get(eo, "uri");
		}
		
		dico.put(Constants.BUNDLE_CLASSPATH, requires);
		createLoader();
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static MgmPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = MgmPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	static public String getPluginRep(){
		try {
			URL urlPlatform = MgmPlugin.getDefault().getBundle().getEntry("/");
			URL localFileInPluginURL = Platform.asLocalURL(urlPlatform);
			String path = localFileInPluginURL.getPath().toString();
			return path;
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return null;
	}
	
	private void createLoader() {
		try {
			if (loader == null) {
				URL url = MgmPlugin.getDefault().getBundle().getEntry("/");
	 			String urlString = url.toString();

				LinkedList list = new LinkedList();
				String requires = (String)MgmPlugin.getDefault().getBundle().getHeaders().get(Constants.BUNDLE_CLASSPATH);
				ManifestElement[] elements = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, requires);
	 			for (int i = 0; i < elements.length; i++) {
	 				ManifestElement element = elements[i];
	 				String libPathStr = element.getValue();
					String libUrlStr = urlString + libPathStr;
					URL libUrl = new URL(libUrlStr);
					list.add(libUrl);
				}
	 			URL[] libUrls = (URL[]) list.toArray(new URL[list.size()]);
	 			loader = new JarClassLoader(libUrls, getClass().getClassLoader());
			}
		} catch (BundleException e) {
			e.printStackTrace();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		}

	}
	
	public MetaHandler getHandler() {
		return handler;
	}
	
	public JarClassLoader getLoader() {
		return loader;
	}
}
