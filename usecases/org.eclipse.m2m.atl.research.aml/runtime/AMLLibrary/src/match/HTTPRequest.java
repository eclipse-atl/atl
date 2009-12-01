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

/**
 * 
 * @author garces
 *
 */
public class HTTPRequest {
	
	private static HTTPRequest http;
	
	HTTPRequest() {
		
				
	}
	
	static HTTPRequest Instance() {
		
		if (http == null) {
			http = new HTTPRequest();
		}
		
		return http;
	}

	
	/**
	* Sends an HTTP GET request to a url and save the result into a text file
	 * @param distractors TODO
	 * @param leftTokenizerName TODO
	 * @param rightTokenizerName TODO
	* 
	*/
	public void sendGetRequest(String msr, List terms, List terms2, String textFilePath, List leftDistractors, List rightDistractors)
	{
			System.out.println("Before processing...");
			System.out.println(terms);
			System.out.println(terms2);
			
			
			
			// Send a GET request to the servlet
			try
			{
				// Construct data
				
				String urlStr  = "http://cwl-projects.cogsci.rpi.edu/cgi-bin/msr/msr.cgi?" + 
				"msr=" + msr + "&" +
				"terms=" + concatenateTerms(terms, leftDistractors) + "&" +
				"terms2=" + concatenateTerms(terms2, rightDistractors);
			
				System.out.println(urlStr);
				
			} catch (Exception e){
					e.printStackTrace();
			}
	}
	
	/**
	 *  
	 * @param terms
	 * @param tokenizerName TODO
	 * @return looks like ['cat','dog','feline','man','woman','shoe']
	 */
	private String concatenateTerms (List terms, List distractors) {
		
		String lastTerm = "";
		
		try {
			lastTerm = (String) terms.remove(terms.size() - 1);
		}
		catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		String cad = getProperTerm(lastTerm, distractors) + "]";
		
		for(Iterator j = terms.iterator(); j.hasNext();){
			cad = getProperTerm((String) j.next(), distractors) + "," + cad;
		}
		
		cad = "[" + cad; 
		
		return cad;
	}
	
	private String getProperTerm (String cad, List distractors) {
		
		cad = "\'" + TermProcessor.Instance().getProperTerm(cad, distractors) + "\'";
		
		return cad;
		
	}
	
		
}
