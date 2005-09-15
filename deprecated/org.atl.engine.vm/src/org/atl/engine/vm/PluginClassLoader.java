package org.atl.engine.vm;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.List;

/**
 * A basic plugin facillity used in command-line.
 * Eclipse plugins are used within Eclipse.
 * @author Frédéric Jouault
 */
public class PluginClassLoader extends URLClassLoader {

	private final static boolean debug = false;

	private static URL[] toURLs(List locations) {
		URL ret[] = new URL[locations.size()];
		int k = 0;

		for(Iterator i = locations.iterator() ; i.hasNext() ; ) {
			ret[k++] = toURL((String)i.next());
		}

		return ret;
	}

	private static URL toURL(String location) {
		URL ret = null;

		try {
			ret = new URL("file:" + (String)location);
		} catch(MalformedURLException mue) {
			mue.printStackTrace(System.out);
		}

		return ret;
	}

	public PluginClassLoader(List locations) {
		super(toURLs(locations));
	}

	public void addLocation(String location) {
		addURL(toURL(location));
	}
}

