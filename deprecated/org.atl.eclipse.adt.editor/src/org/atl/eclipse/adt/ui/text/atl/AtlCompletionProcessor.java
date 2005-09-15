/*
 * Created on 22 juil. 2004
 */
package org.atl.eclipse.adt.ui.text.atl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.atl.eclipse.adt.ui.AtlUIMessages;
import org.atl.eclipse.adt.ui.text.AtlCodeReader;
import org.atl.eclipse.adt.ui.text.IAtlLexems;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationExtension;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;


/**
 * This class represents the processor for completions and computes the content information.
 * 
 * @author C. MONTI for ATL Team
 */
public class AtlCompletionProcessor implements IContentAssistProcessor {
	
	private static class ContextInformationWrapper implements IContextInformation, IContextInformationExtension {
		
		private final IContextInformation fContextInformation;
		private int fPosition;
		
		public ContextInformationWrapper(IContextInformation contextInformation) {
			fContextInformation= contextInformation;
		}
		
		/*
		 * @see org.eclipse.jface.text.contentassist.IContextInformation#equals(java.lang.Object)
		 */
		public boolean equals(Object object) {
			if (object instanceof ContextInformationWrapper)
				return fContextInformation.equals(((ContextInformationWrapper) object).fContextInformation);
			else
				return fContextInformation.equals(object);
		}
		
		/*
		 * @see IContextInformation#getContextDisplayString()
		 */
		public String getContextDisplayString() {
			return fContextInformation.getContextDisplayString();
		}
		
		/*
		 * @see IContextInformationExtension#getContextInformationPosition()
		 */
		public int getContextInformationPosition() {
			return fPosition;
		}
		
		/*
		 * @see IContextInformation#getImage()
		 */
		public Image getImage() {
			return fContextInformation.getImage();
		}
		
		/*
		 * @see IContextInformation#getInformationDisplayString()
		 */
		public String getInformationDisplayString() {
			return fContextInformation.getInformationDisplayString();
		}
		
		public void setContextInformationPosition(int position) {
			fPosition= position;	
		}
	}
	
	private AtlCompletionProposalComparator fComparator;
//	private IEditorPart fEditor;
//	private int fNumberOfComputedResults;
	private char[] fProposalAutoActivationSet;
	private AtlParameterListValidator fValidator;
	
	public AtlCompletionProcessor(IEditorPart editor) {
//		fEditor = editor;
		fComparator = new AtlCompletionProposalComparator();
	}
	/**
	 * Adds a new proposal in the completion list.
	 * 
	 * @param proposal the string to add
	 * @param proposals the completion list
	 * @param documentOffset the offset in the document of the proposal
	 */
	private void addCompletionProposal(String proposal, List proposals, int documentOffset) {
		proposals.add(
				new AtlCompletionProposal(proposal, documentOffset, proposal.length(), null, proposal + " ", documentOffset));
	}
	
	private List addContextInformations(ITextViewer viewer, int offset) {
		ICompletionProposal[] proposals= internalComputeCompletionProposals(viewer, offset, -1);
		
		List result= new ArrayList();
		for (int i= 0; i < proposals.length; i++) {
			IContextInformation contextInformation= proposals[i].getContextInformation();
			if (contextInformation != null) {
				ContextInformationWrapper wrapper= new ContextInformationWrapper(contextInformation);
				wrapper.setContextInformationPosition(offset);
				result.add(wrapper);				
			}
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		return internalComputeCompletionProposals(viewer, offset, guessContextInformationPosition(viewer, offset));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer, int)
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		List result= addContextInformations(viewer, guessContextInformationPosition(viewer, offset));
		return (IContextInformation[]) result.toArray(new IContextInformation[result.size()]);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		return fProposalAutoActivationSet;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
	 */
	public IContextInformationValidator getContextInformationValidator() {
		if (fValidator == null)
			fValidator= new AtlParameterListValidator();
		return fValidator;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
	 */
	public String getErrorMessage() {
		return AtlUIMessages.getString("AtlEditor.codeassist.noCompletions");
	}
	
	private int guessContextInformationPosition(ITextViewer viewer, int offset) {
		int contextPosition= offset;
		
		IDocument document= viewer.getDocument();
		
		try {
			AtlCodeReader reader= new AtlCodeReader();
			reader.configureBackwardReader(document, offset, true, true);
			
			int nestingLevel= 0;
			
			int curr= reader.read();		
			while (curr != AtlCodeReader.EOF) {
				
				if (')' == (char) curr)
					++ nestingLevel;
				
				else if ('(' == (char) curr) {
					-- nestingLevel;
					
					if (nestingLevel < 0) {
						int start= reader.getOffset();
						if (looksLikeRule(reader))
							return start + 1;
					}	
				}
				
				curr= reader.read();					
			}
		} catch (IOException e) {
		}
		
		return contextPosition;
	}
	
	private ICompletionProposal[] internalComputeCompletionProposals(ITextViewer viewer, int documentOffset, int contextOffset) {
		List proposals = new ArrayList();
		
		for(int i = 0; i < IAtlLexems.CONSTANTS.length; ++i) {
			addCompletionProposal(IAtlLexems.CONSTANTS[i], proposals, documentOffset);
		}
		for(int i = 0; i < IAtlLexems.KEYWORDS.length; ++i) {
			addCompletionProposal(IAtlLexems.KEYWORDS[i], proposals, documentOffset);
		}
		for(int i = 0; i < IAtlLexems.OPERATORS.length; ++i) {
			addCompletionProposal(IAtlLexems.OPERATORS[i], proposals, documentOffset);
		}
		for(int i = 0; i < IAtlLexems.TYPES.length; ++i) {
			addCompletionProposal(IAtlLexems.TYPES[i], proposals, documentOffset);
		}
		
		ICompletionProposal[] results = new ICompletionProposal[proposals.size()];
		proposals.toArray(results);
//		fNumberOfComputedResults = (results == null ? 0 : results.length);
		
		/*
		 * Order here and not in result collector to make sure that the order
		 * applies to all proposals and not just those of the compilation unit. 
		 */
		return order(results);
	}
	
	private boolean looksLikeRule(AtlCodeReader reader) throws IOException {
		int curr= reader.read();
		while (curr != AtlCodeReader.EOF && Character.isWhitespace((char) curr))
			curr= reader.read();
		
		if (curr == AtlCodeReader.EOF)
			return false;
		
		return Character.isJavaIdentifierPart((char) curr) || Character.isJavaIdentifierStart((char) curr);
	}
	
	/**
	 * Order the given proposals.
	 */
	private ICompletionProposal[] order(ICompletionProposal[] proposals) {
		Arrays.sort(proposals, fComparator);
		return proposals;	
	}
	
	public void orderProposalsAlphabetically(boolean order) {
		fComparator.setOrderAlphabetically(order);
	}
	
	/**
	 * Tells this processor to restrict is proposals to those
	 * starting with matching cases.
	 * 
	 * @param restrict <code>true</code> if proposals should be restricted
	 */
	public void restrictProposalsToMatchingCases(boolean restrict) {
		// TODO not yet supported
	}
	
	/**
	 * Tells this processor to restrict its proposal to those element
	 * visible in the actual invocation context.
	 * 
	 * @param restrict <code>true</code> if proposals should be restricted
	 */
	public void restrictProposalsToVisibility(boolean restrict) {
		// TODO not yet supported
	}
	
	/**
	 * Sets this processor's set of characters triggering the activation of the
	 * completion proposal computation.
	 * 
	 * @param activationSet the activation set
	 */
	public void setCompletionProposalAutoActivationCharacters(char[] activationSet) {
		fProposalAutoActivationSet = activationSet;
	}
	
}
