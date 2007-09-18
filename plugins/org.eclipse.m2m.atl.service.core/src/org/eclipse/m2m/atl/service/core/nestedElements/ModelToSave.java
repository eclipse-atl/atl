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
		if (extractor != null)
			return true;
		else
			return false;
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
