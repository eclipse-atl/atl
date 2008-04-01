package org.eclipse.m2m.atl.dsls;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.dsls.textsource.TextSource;

public interface Resource {

	public TextSource asTextSource();

	public URL asURL();
	
	public URI asEMFURI();
}
