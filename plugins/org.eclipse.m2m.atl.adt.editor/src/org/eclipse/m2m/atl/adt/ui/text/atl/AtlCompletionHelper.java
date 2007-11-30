/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.tcs.injector.TCSInjector;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModelElement;
import org.eclipse.m2m.atl.engine.AtlModelHandler;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * Completion helper, dedicated to document parsing.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class AtlCompletionHelper {

	/** ATL parsing triggers */
	private static final String[] PARSING_KEYWORDS = { "rule", "helper" };

	/** Context indicators */
	private static final String[] HIGH_LEVEL_KEYWORDS = { "rule", "helper",
		"from", "to", "do", "using", "module" };

	/** Observed document */
	private IDocument document;

	/**
	 * Configures the IDocument for this helper.
	 * @param document
	 */
	public void setDocument(IDocument document) {
		this.document = document;
	}

	/**
	 * Computes the document part to analyze, process the analysis.
	 * 
	 * @param offset
	 * @param prefix
	 * @return an analyser which purposes contextual informations.
	 * @throws BadLocationException
	 */
	public AtlModelAnalyser computeContext(int offset, String prefix)
	throws BadLocationException {
		// parsed zone computation
		int begin = 0;
		int[] lastParsingKeyWordLocation = getLastKeyWordLocation(offset - prefix.length(), PARSING_KEYWORDS);
		begin = lastParsingKeyWordLocation[0];
		String lastParsingKeyWord = null;
		if (begin > 0) {
			lastParsingKeyWord = document.get(lastParsingKeyWordLocation[0],lastParsingKeyWordLocation[1]);
			// take the line from beginning
			int lineNumber = document.getLineOfOffset(begin);
			begin = document.getLineOffset(lineNumber);
		}
		int end = offset;

		// gets the zone and correct it
		String text = document.get(begin, end - begin);
		if (prefix.equals("")) {
			text += "a";
		} else if (prefix.startsWith("'")){
			text += "'";
		}

		// if no context available, don't process parsing
		if (lastParsingKeyWord == null) {
			return new AtlModelAnalyser(this, null, begin, getLastKeyWord(offset - prefix.length()), offset);
		}

		// code fragment parsing
		ASMModel[] ret = AtlCompletionHelper.parseExpression(text,
				lastParsingKeyWord);
		ASMEMFModel atlmodel = (ASMEMFModel) ret[0];

		// retrieves root element
		EObject emfRoot = null;
		Set modules = atlmodel.getElementsByType(Character
				.toUpperCase(lastParsingKeyWord.charAt(0))
				+ lastParsingKeyWord.substring(1));
		if (modules.size() > 0) {
			emfRoot = ((ASMEMFModelElement) modules.iterator().next())
			.getObject();
		}
		AtlModelAnalyser res = new AtlModelAnalyser(this, emfRoot, begin, getLastKeyWord(offset - prefix.length()), offset);

		/* DEBUGGING 
		 * 
		 
		AtlModelHandler amh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
		amh.saveModel(atlmodel, System.out);	
		*/
		
		return res;
	}
	
	/**
	 * Compute the right offset from an element, according to 
	 * the base offset of the model.
	 * 
	 * @param element
	 * @param baseOffset
	 * @return [deboffset, endoffset]
	 * @throws BadLocationException
	 */
	public int[] getElementOffsets(EObject element, int baseOffset)
	throws BadLocationException {
		Object loc = AtlCompletionDataSource.eGet(element,"location");
		if (loc != null) {
			String location = loc.toString();
			location = location.replaceAll("'", "");
			int linesToAdd = document.getLineOfOffset(baseOffset);
			int columnsToAdd = baseOffset - document.getLineOffset(document
					.getLineOfOffset(baseOffset));
			int debLine = new Integer(location.split("-")[0].split(":")[0]).intValue() + linesToAdd;
			int debColumn = new Integer(location.split("-")[0].split(":")[1]).intValue() + columnsToAdd;
			int endLine = new Integer(location.split("-")[1].split(":")[0]).intValue() + linesToAdd;
			int endColumn = new Integer(location.split("-")[1].split(":")[1]).intValue() + columnsToAdd;
			int debOffset = document.getLineOffset(debLine - 1) + debColumn - 1;
			int endOffset = document.getLineOffset(endLine - 1) + endColumn - 1;
			return new int[] { debOffset, endOffset };

		}
		return null;
	}

	/**
	 * ATL injector launcher.
	 * 
	 * @param expression
	 * @param expressionType the Syntax Element parsed
	 * @return outputs models
	 */
	public static ASMModel[] parseExpression(String expression,
			String expressionType) {
		ASMModel[] ret = new ASMModel[2];
		AtlModelHandler amh = AtlModelHandler
		.getDefault(AtlModelHandler.AMH_EMF);
		ASMModel atlmm = amh.getAtl();
		ASMModel pbmm = amh.getBuiltInMetaModel("Problem");

		try {
			ret[0] = ASMEMFModel.newASMEMFModel("temp", "temp",
					(ASMEMFModel) atlmm, null);
			ret[1] = amh.newModel("pb", "pb", pbmm);
			TCSInjector ebnfi = new TCSInjector();
			Map params = new HashMap();
			if (expressionType == null) {
				params.put("name", "ATL");
			} else {
				params.put("name", "ATL-" + expressionType);
			}
			params.put("problems", ret[1]);
			ebnfi.inject(ret[0],
					new ByteArrayInputStream(expression.getBytes()), params);
		} catch (Throwable e) {
			// nothing : silent incorrect expressions parsing
		}
		return ret;
	}

	/**
	 * Extracts the prefix of the last typed characters
	 * 
	 * @param offset
	 * @return the prefix of the last word
	 */
	public String extractPrefix(int offset) {
		int i = offset;
		if (i > document.getLength())
			return ""; //$NON-NLS-1$
		try {
			while (i > 0) {
				char ch = document.getChar(i - 1);
				if (Character.isWhitespace(ch))
					break;
				i--;
			}
			return document.get(i, offset - i);
		} catch (BadLocationException e) {
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * Compute the whole line of the current offset.
	 * @param offset
	 * @return the line containing the offset, ended with the offset
	 * @throws BadLocationException
	 */
	public String getCurrentLine(int offset) throws BadLocationException {
		if (offset >= 0) {
			int lineNumber = document.getLineOfOffset(offset);
			int lineOffset = document.getLineOffset(lineNumber);
			return document.get(lineOffset, offset - lineOffset);
		}
		return null;
	}

	/**
	 * Retrieves the last typed keyword.
	 * @param offset
	 * @return
	 */
	public String getLastKeyWord(int offset) throws BadLocationException {
		int[] location = getLastKeyWordLocation(offset, HIGH_LEVEL_KEYWORDS);
		if (location[0]>0) {
			return document.get(location[0],location[1]);			
		}
		return null;
	}

	private int[] getLastKeyWordLocation(int offset, String[] keywords) throws BadLocationException {
		int bestindex = 0;
		String nearest_keyword = "";
		for (int i = 0; i < keywords.length; i++) {
			String keyword = keywords[i];
			int lastindex = getLastKeyWordLocation(offset, keyword)[0];
			if (lastindex > 0 && lastindex > bestindex) {
				bestindex = lastindex;
				nearest_keyword = keyword;
			}
		}
		return new int[]{bestindex, nearest_keyword.length()};
	}

	private int[] getLastKeyWordLocation(int offset, String keyword) throws BadLocationException {
		int lastindex = document.get().lastIndexOf(keyword, offset-1);
		String line = getCurrentLine(lastindex);
		if (line != null) {
			if (line.contains("--")) 	
				return getLastKeyWordLocation(document.get().lastIndexOf("--", offset-1), keyword);
		} 
		return new int[]{lastindex, keyword.length()};
	}
}
