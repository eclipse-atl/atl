package org.atl.eclipse.adt.ui.text.atl;

import java.util.ArrayList;
import java.util.List;

import org.atl.eclipse.adt.ui.AtlPreferenceConstants;
import org.atl.eclipse.adt.ui.text.AbstractScanner;
import org.atl.eclipse.adt.ui.text.AtlTextTools;
import org.atl.eclipse.adt.ui.text.AtlWordDetector;
import org.atl.eclipse.adt.ui.text.IAtlLexems;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.NumberRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordPatternRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.jface.util.PropertyChangeEvent;

/**
 * This class controls the highlight syntaxing coloration for the ATL editor.
 * 
 * @author C. MONTI for ATL Team
 */
public class AtlCodeScanner extends AbstractScanner {
	
	/**
	 * Rule to detect atl identifier.
	 */
	public class IdentifierRule implements IRule {

		/**
		 * Returned token for this rule.
		 */
		private final Token token;

		/**
		 * Creates a new identifier rule.
		 * 
		 * @param token the given token for this rule.
		 */
		public IdentifierRule(Token token) {
			this.token = token;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
		 */
		public IToken evaluate(ICharacterScanner scanner) {
			int character = scanner.read();
			if((char) character == '"') {
				evaluateSimpleName(scanner);
				scanner.unread();
				if((char) character == '"') {
					return token;
				}
			} else if(Character.isLetter((char) character) || ((char) character == '_')) {
				evaluateSimpleName(scanner);
				scanner.unread();
				return token;
			}
			scanner.unread();
			return Token.UNDEFINED;
		}
		
		private void evaluateSimpleName(ICharacterScanner scanner) {
			int character = scanner.read();
			do {
				character = scanner.read();
			} while(Character.isLetterOrDigit((char) character) || ((char) character == '_'));
		}

	}
	
	/**
	 * Rule to detect atl literals.
	 */
	public class EnumLiteralRule implements IRule {
		
		/** Token to return for this rule */
		private final IToken token;

		/**
		 * Creates a new operator rule.
		 * 
         * @param token the token associated with this rule
         */
        public EnumLiteralRule(Token token) {
            this.token = token;
        }

		/* (non-Javadoc)
		 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
		 */
		public IToken evaluate(ICharacterScanner scanner) {
			int character = scanner.read();
			if((char) character == '#') {
				character = scanner.read();
				do {
					character = scanner.read();
				} while(Character.isLetterOrDigit((char) character) || ((char) character == '_'));
				scanner.unread();
				return token;
			} else {
				scanner.unread();
				return Token.UNDEFINED;
			}
		}

	}
	
	/**
	 * Rule to detect symbols.
	 */
	protected class SymbolRule implements IRule {
		
		/** Token to return for this rule */
		private final IToken token;
		
		/** The associated list with this tule */
		private final String[] list;
		
		/**
		 * Creates a new operator rule.
		 * 
         * @param token the token associated with this rule
         */
        public SymbolRule(String[] list, Token token) {
        	this.list = list;
            this.token = token;
        }

        /*
		 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
		 */
		public IToken evaluate(ICharacterScanner scanner) {
			int character= scanner.read();
			if(isInList((char) character)) {
				do {
					character = scanner.read();
				} while(isInList((char) character));
				scanner.unread();
				return token;
			} else {
				scanner.unread();
				return Token.UNDEFINED;
			}
		}
		
		/**
		 * Is this character in the list?
		 * 
		 * @param character Character to determine whether it is an operator character
		 * @return <code>true</code> iff the character is an operator, <code>false</code> otherwise.
		 */
		public boolean isInList(char character) {
			for(int i = 0; i < list.length; ++i) {
				if(list[i].equals(Character.toString(character)))
					return true;
			}
			return false;
		}
		
	}
	
	/**
	 * Creates a new instance of the ATL scanner.
	 * 
	 * @param textTools the ATL text tools
	 */
	public AtlCodeScanner(AtlTextTools textTools) {
		super(textTools);
	}

	/*
	 * @see AbstractScanner#adaptToPreferenceChange(PropertyChangeEvent)
	 */
	public void adaptToPreferenceChange(PropertyChangeEvent event) {
		if(super.affectsBehavior(event)) {
			super.adaptToPreferenceChange(event);
		}
	}

	/*
	 * @see AbstractScanner#affectsBehavior(PropertyChangeEvent)
	 */
	public boolean affectsBehavior(PropertyChangeEvent event) {
		return super.affectsBehavior(event);
	}
	
	/*(non-Javadoc)
	 * @see org.atl.eclipse.adt.ui.text.AbstractScanner#createRules()
	 */
	protected List createRules() {
		List rules = new ArrayList();
		
		rules.add(new EndOfLineRule("--", getToken(AtlPreferenceConstants.SYNTAX_SINGLE_LINE_COMMENT_COLOR)));
		rules.add(new EnumLiteralRule(getToken(AtlPreferenceConstants.SYNTAX_LITERAL_COLOR)));
		rules.add(new MultiLineRule("'", "'", getToken(AtlPreferenceConstants.SYNTAX_STRING_COLOR), '\\'));
		rules.add(new NumberRule(getToken(AtlPreferenceConstants.SYNTAX_NUMBER_COLOR)));
		rules.add(new SymbolRule(IAtlLexems.BRACKETS, getToken(AtlPreferenceConstants.SYNTAX_BRACKET_COLOR)));
		rules.add(new SymbolRule(IAtlLexems.OPERATORS, getToken(AtlPreferenceConstants.SYNTAX_OPERATOR_COLOR)));
		rules.add(new SymbolRule(IAtlLexems.SYMBOLS, getToken(AtlPreferenceConstants.SYNTAX_SYMBOL_COLOR)));
		
		WordRule wordRule = new WordRule(new AtlWordDetector(), getToken(AtlPreferenceConstants.SYNTAX_DEFAULT_COLOR));
		for(int i = 0; i < IAtlLexems.CONSTANTS.length; ++i)
			wordRule.addWord(IAtlLexems.CONSTANTS[i], getToken(AtlPreferenceConstants.SYNTAX_CONSTANT_COLOR));
		for(int i = 0; i < IAtlLexems.KEYWORDS.length; ++i)
			wordRule.addWord(IAtlLexems.KEYWORDS[i], getToken(AtlPreferenceConstants.SYNTAX_KEYWORD_COLOR));
		for(int i = 0; i < IAtlLexems.TYPES.length; ++i)
			wordRule.addWord(IAtlLexems.TYPES[i], getToken(AtlPreferenceConstants.SYNTAX_TYPE_COLOR));
		rules.add(wordRule);
		
		// TODO identifiers rule not well done
		//rules.add(new IdentifierRule(getToken(IAtlConstants.EDITOR_IDENTIFIER)));
		rules.add(new WordPatternRule(new AtlWordDetector(), "\"", "\"", getToken(AtlPreferenceConstants.SYNTAX_IDENTIFIER_COLOR)));

		return rules;
	}
	
	/*(non-Javadoc)
	 * @see org.atl.eclipse.adt.ui.text.AbstractScanner#getPropertyNames()
	 */
	protected String[] getPropertyNames() {
		return new String[] {
				AtlPreferenceConstants.SYNTAX_BRACKET,
				AtlPreferenceConstants.SYNTAX_CONSTANT,
				AtlPreferenceConstants.SYNTAX_DEFAULT,
				AtlPreferenceConstants.SYNTAX_IDENTIFIER,
				AtlPreferenceConstants.SYNTAX_KEYWORD,
				AtlPreferenceConstants.SYNTAX_LITERAL,
				AtlPreferenceConstants.SYNTAX_NUMBER,
				AtlPreferenceConstants.SYNTAX_OPERATOR,
				AtlPreferenceConstants.SYNTAX_SINGLE_LINE_COMMENT,
				AtlPreferenceConstants.SYNTAX_STRING,
				AtlPreferenceConstants.SYNTAX_SYMBOL,
				AtlPreferenceConstants.SYNTAX_TYPE
		};
	}
	
}
