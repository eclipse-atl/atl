/*******************************************************************************

 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package match;

import java.util.ArrayList;
import java.util.Iterator;

public class UpperCaseTokenizer implements Tokenizer {
	
	
	public String tokenize (String cad) {
		
		String rCad = "";
		char[] cadChar = cad.toCharArray();
		ArrayList<Integer> cUpperIndexes = new ArrayList<Integer>();
		int i = 0;
		while(i < cadChar.length) {
			
			if (Character.isUpperCase(cadChar[i])) {
				cUpperIndexes.add(i);
			}
			i++;
		}
		
		cUpperIndexes.add(cadChar.length);
		
		int startIndex = 0, endIndex = 0;
		Iterator<Integer> ite = cUpperIndexes.iterator();
		
		while(ite.hasNext()){
			
			endIndex = ite.next();
			rCad = rCad + cad.substring(startIndex, endIndex) + " ";
			
			startIndex = endIndex;
		}
		// delete first and last whitespace
		
		return rCad.trim().toLowerCase();
	}
		
}
