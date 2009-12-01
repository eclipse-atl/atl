/*******************************************************************************

 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package match;

import java.util.Iterator;
import java.util.List;

public class DistractorFilter {
	
	static DistractorFilter instance;
	
	static DistractorFilter Instance() {
		
		if (instance == null) {
			instance = new DistractorFilter();
		}
		
		return instance;
	}
	
	public String filter (String cad, List distractors) {
			
		for(Iterator j = distractors.iterator(); j.hasNext();){			
			cad = cad.replaceAll((String)j.next(), "");
		}
			
		return cad.trim();
	}
}
