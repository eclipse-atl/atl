/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.service.core.nestedElements;

import java.util.HashMap;
import java.util.Map;

public class ModelToSave {
	
	private class Extractor {
		private String type;
		private Map params;

		public Extractor(String type) {
			this.type = type;
			params = new HashMap();
		}		
	}
	
	private String name;
	private String fileName;
	private Extractor extractor;

	public ModelToSave(String name, String fileName, String extractorType, Map paramsExtractor) {
		super();
		this.name = name;
		this.fileName = fileName;
		Extractor e = new Extractor(extractorType);
		e.params = paramsExtractor;
		this.extractor = e;
	}
	
	public ModelToSave(String name, String fileName) {
		super();
		this.name = name;
		this.fileName = fileName;
	}

	public boolean isExtractor() {
		return extractor != null;
	}
	
	public String getExtractorType() {
		return extractor.type;
	}
	
	public Map getExtractorParams() {
		return extractor.params;
	}

	public String getFileName() {
		return fileName;
	}

	public String getName() {
		return name;
	}
}
