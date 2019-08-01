/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.service.core.nestedElements;

import java.util.HashMap;
import java.util.Map;

/**
 * A saveable model.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class ModelToSave {

	/**
	 * The extractor definition.
	 */
	private final class Extractor {
		private String type;

		private Map params;

		private Extractor(String type) {
			this.type = type;
			params = new HashMap();
		}
	}

	private String name;

	private String fileName;

	private Extractor extractor;

	/**
	 * Creates a model to save.
	 * 
	 * @param name
	 *            the model name
	 * @param fileName
	 *            the file
	 * @param extractorType
	 *            the extractor type
	 * @param paramsExtractor
	 *            the extractor parameters
	 */
	public ModelToSave(String name, String fileName, String extractorType, Map paramsExtractor) {
		super();
		this.name = name;
		this.fileName = fileName;
		Extractor e = new Extractor(extractorType);
		e.params = paramsExtractor;
		this.extractor = e;
	}

	/**
	 * Creates a model to save.
	 * 
	 * @param name
	 *            the model name
	 * @param fileName
	 *            the model file
	 */
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
