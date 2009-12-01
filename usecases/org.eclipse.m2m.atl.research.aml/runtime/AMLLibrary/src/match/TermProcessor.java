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
import java.util.LinkedHashSet;
import java.util.List;

public class TermProcessor {

	DistractorFilter f;
	static TermProcessor instance;
	LinkedHashSet<Tokenizer> tokenizerSet;
		
	public TermProcessor() {
		tokenizerSet = new LinkedHashSet<Tokenizer>();
		f = new DistractorFilter();
		initTokenizers();
	}
	
	static TermProcessor Instance() {
				
		if (instance == null) {
			
			instance = new TermProcessor();
		} 
				
		return instance;
	}
	
	public void initTokenizers() {
		try {			
			// Tokenizers order is relevant, if there is not tokenizer applying, UpperCaseTokenizer is default 
			String[] tokenizers = {"UnderScoreTokenizer", "HyphenTokenizer", "UpperCaseTokenizer"};
			for(int i=0; i<tokenizers.length; i++){
				tokenizerSet.add((Tokenizer) Class.forName("match." + tokenizers[i]).newInstance());
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getProperTerm (String cad, List distractors) {
				
		Iterator<Tokenizer> ite = tokenizerSet.iterator();
		String tokCad = "";
		Tokenizer t;
		while(ite.hasNext()) {
			t = (Tokenizer) ite.next();
			tokCad = t.tokenize(cad).toLowerCase(); 
			if(!tokCad.equals(cad.toLowerCase())) {
				break;
			} 			
		}
		String filCad = f.filter(tokCad, distractors);		 
		return filCad;
		
	}
}
