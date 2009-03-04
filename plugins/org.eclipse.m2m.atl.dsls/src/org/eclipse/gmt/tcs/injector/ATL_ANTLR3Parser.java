/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 */
// $ANTLR 3.0.1 D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g 2009-03-04 15:45:48
package org.eclipse.gmt.tcs.injector;

import java.util.HashMap;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
public class ATL_ANTLR3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "SEMI", "COMA", "EQ", "COLON", "LPAREN", "RPAREN", "LCURLY", "RCURLY", "RARROW", "LARROW", "EXCL", "PIPE", "SHARP", "POINT", "MINUS", "STAR", "SLASH", "PLUS", "GT", "LT", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "LSQUARE", "RSQUARE", "QMARK", "AROBAS", "COMMENT", "'module'", "'create'", "'refining'", "'from'", "'library'", "'query'", "'uses'", "'helper'", "'def'", "'context'", "'nodefault'", "'abstract'", "'rule'", "'extends'", "'using'", "'unique'", "'lazy'", "'entrypoint'", "'endpoint'", "'in'", "'to'", "'mapsTo'", "'distinct'", "'foreach'", "'do'", "'if'", "'else'", "'for'", "'iterate'", "'OclUndefined'", "'true'", "'false'", "'then'", "'endif'", "'super'", "'let'", "'Bag'", "'Set'", "'OrderedSet'", "'Sequence'", "'Map'", "'Tuple'", "'OclType'", "'OclAny'", "'TupleType'", "'Integer'", "'Real'", "'Boolean'", "'String'", "'Collection'", "'not'", "'div'", "'mod'", "'and'", "'or'", "'xor'", "'implies'"
    };
    public static final int GE=28;
    public static final int LT=27;
    public static final int STAR=23;
    public static final int LSQUARE=37;
    public static final int SHARP=20;
    public static final int POINT=21;
    public static final int AROBAS=40;
    public static final int ESC=36;
    public static final int RARROW=16;
    public static final int LARROW=17;
    public static final int LCURLY=14;
    public static final int FLOAT=7;
    public static final int INT=6;
    public static final int EXCL=18;
    public static final int RSQUARE=38;
    public static final int MINUS=22;
    public static final int EOF=-1;
    public static final int COMA=9;
    public static final int SEMI=8;
    public static final int ALPHA=34;
    public static final int LPAREN=12;
    public static final int COLON=11;
    public static final int RPAREN=13;
    public static final int NAME=4;
    public static final int WS=32;
    public static final int SLASH=24;
    public static final int SNAME=35;
    public static final int RCURLY=15;
    public static final int GT=26;
    public static final int PLUS=25;
    public static final int PIPE=19;
    public static final int DIGIT=33;
    public static final int NL=31;
    public static final int EQ=10;
    public static final int COMMENT=41;
    public static final int QMARK=39;
    public static final int LE=29;
    public static final int STRING=5;
    public static final int NE=30;

        public ATL_ANTLR3Parser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[312+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g"; }


        public org.eclipse.gmt.tcs.injector.TCSRuntime ei = null;
        
    //	public void reportError(RecognitionException ex) {
    //		ei.reportError((Exception)ex);
    //	}
    	
    //	public void emitErrorMessage(String s) {
    //		ei.reportError(s);
    //	}

    	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    		ei.reportError((Exception)e);
    	}

    	//TODO: what about warnings?
    //	public void reportWarning(String s) {
    //		ei.reportWarning(s);
    //	}
    	
        public static void main(String[] args) throws Exception {
    						CharStream input = new ANTLRFileStream(args[0]);
        ATL_ANTLR3Lexer lex = new 
        ATL_ANTLR3Lexer(input);
    						CommonTokenStream tokens = new CommonTokenStream(lex);
    						tokens.discardTokenType(WS);
    						tokens.discardTokenType(COMMENT);
    						tokens.discardTokenType(NL);
    						
        ATL_ANTLR3Parser parser = new 
        ATL_ANTLR3Parser(tokens);
    						parser.main();
    					}



    // $ANTLR start main
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:63:1: main returns [Object ret2] : ( (ret= unit ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:64:2: ( ( (ret= unit ) EOF ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:64:4: ( (ret= unit ) EOF )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:64:4: ( (ret= unit ) EOF )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:64:5: (ret= unit ) EOF
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:64:5: (ret= unit )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:64:6: ret= unit
            {
            pushFollow(FOLLOW_unit_in_main61);
            ret=unit();
            _fsp--;
            if (failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main64); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end main


    // $ANTLR start identifier
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:71:1: identifier returns [Object ret2] : ast= NAME ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:72:2: (ast= NAME )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:72:4: ast= NAME
            {
            ast=(Token)input.LT(1);
            match(input,NAME,FOLLOW_NAME_in_identifier97); if (failed) return ret2;
            if ( backtracking==0 ) {
              ret = ast.getText(); ei.setToken((Object)ast);
            }
            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end identifier


    // $ANTLR start identifierOrKeyword
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:79:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:2: ( (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:4: (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:4: (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )
            int alt1=58;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 42:
                {
                alt1=2;
                }
                break;
            case 43:
                {
                alt1=3;
                }
                break;
            case 44:
                {
                alt1=4;
                }
                break;
            case 45:
                {
                alt1=5;
                }
                break;
            case 46:
                {
                alt1=6;
                }
                break;
            case 47:
                {
                alt1=7;
                }
                break;
            case 48:
                {
                alt1=8;
                }
                break;
            case 49:
                {
                alt1=9;
                }
                break;
            case 50:
                {
                alt1=10;
                }
                break;
            case 51:
                {
                alt1=11;
                }
                break;
            case 52:
                {
                alt1=12;
                }
                break;
            case 53:
                {
                alt1=13;
                }
                break;
            case 54:
                {
                alt1=14;
                }
                break;
            case 55:
                {
                alt1=15;
                }
                break;
            case 56:
                {
                alt1=16;
                }
                break;
            case 57:
                {
                alt1=17;
                }
                break;
            case 58:
                {
                alt1=18;
                }
                break;
            case 59:
                {
                alt1=19;
                }
                break;
            case 60:
                {
                alt1=20;
                }
                break;
            case 61:
                {
                alt1=21;
                }
                break;
            case 62:
                {
                alt1=22;
                }
                break;
            case 63:
                {
                alt1=23;
                }
                break;
            case 64:
                {
                alt1=24;
                }
                break;
            case 65:
                {
                alt1=25;
                }
                break;
            case 66:
                {
                alt1=26;
                }
                break;
            case 67:
                {
                alt1=27;
                }
                break;
            case 68:
                {
                alt1=28;
                }
                break;
            case 69:
                {
                alt1=29;
                }
                break;
            case 70:
                {
                alt1=30;
                }
                break;
            case 71:
                {
                alt1=31;
                }
                break;
            case 72:
                {
                alt1=32;
                }
                break;
            case 73:
                {
                alt1=33;
                }
                break;
            case 74:
                {
                alt1=34;
                }
                break;
            case 75:
                {
                alt1=35;
                }
                break;
            case 76:
                {
                alt1=36;
                }
                break;
            case 77:
                {
                alt1=37;
                }
                break;
            case 78:
                {
                alt1=38;
                }
                break;
            case 79:
                {
                alt1=39;
                }
                break;
            case 80:
                {
                alt1=40;
                }
                break;
            case 81:
                {
                alt1=41;
                }
                break;
            case 82:
                {
                alt1=42;
                }
                break;
            case 83:
                {
                alt1=43;
                }
                break;
            case 84:
                {
                alt1=44;
                }
                break;
            case 85:
                {
                alt1=45;
                }
                break;
            case 86:
                {
                alt1=46;
                }
                break;
            case 87:
                {
                alt1=47;
                }
                break;
            case 88:
                {
                alt1=48;
                }
                break;
            case 89:
                {
                alt1=49;
                }
                break;
            case 90:
                {
                alt1=50;
                }
                break;
            case 91:
                {
                alt1=51;
                }
                break;
            case 92:
                {
                alt1=52;
                }
                break;
            case 93:
                {
                alt1=53;
                }
                break;
            case 94:
                {
                alt1=54;
                }
                break;
            case 95:
                {
                alt1=55;
                }
                break;
            case 96:
                {
                alt1=56;
                }
                break;
            case 97:
                {
                alt1=57;
                }
                break;
            case 98:
                {
                alt1=58;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("80:4: (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:5: ast= NAME
                    {
                    ast=(Token)input.LT(1);
                    match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword132); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = ast.getText(); ei.setToken((Object)ast);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:64: 'module'
                    {
                    match(input,42,FOLLOW_42_in_identifierOrKeyword137); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "module";
                    }

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:92: 'create'
                    {
                    match(input,43,FOLLOW_43_in_identifierOrKeyword142); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "create";
                    }

                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:120: 'refining'
                    {
                    match(input,44,FOLLOW_44_in_identifierOrKeyword147); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "refining";
                    }

                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:152: 'from'
                    {
                    match(input,45,FOLLOW_45_in_identifierOrKeyword152); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "from";
                    }

                    }
                    break;
                case 6 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:176: 'library'
                    {
                    match(input,46,FOLLOW_46_in_identifierOrKeyword157); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "library";
                    }

                    }
                    break;
                case 7 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:206: 'query'
                    {
                    match(input,47,FOLLOW_47_in_identifierOrKeyword162); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "query";
                    }

                    }
                    break;
                case 8 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:232: 'uses'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword167); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "uses";
                    }

                    }
                    break;
                case 9 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:256: 'helper'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword172); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "helper";
                    }

                    }
                    break;
                case 10 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:284: 'def'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword177); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "def";
                    }

                    }
                    break;
                case 11 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:306: 'context'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword182); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "context";
                    }

                    }
                    break;
                case 12 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:336: 'nodefault'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword187); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "nodefault";
                    }

                    }
                    break;
                case 13 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:370: 'abstract'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword192); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 14 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:402: 'rule'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword197); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "rule";
                    }

                    }
                    break;
                case 15 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:426: 'extends'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword202); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "extends";
                    }

                    }
                    break;
                case 16 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:456: 'using'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword207); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "using";
                    }

                    }
                    break;
                case 17 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:482: 'unique'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword212); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "unique";
                    }

                    }
                    break;
                case 18 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:510: 'lazy'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword217); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "lazy";
                    }

                    }
                    break;
                case 19 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:534: 'entrypoint'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword222); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "entrypoint";
                    }

                    }
                    break;
                case 20 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:570: 'endpoint'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword227); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "endpoint";
                    }

                    }
                    break;
                case 21 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:602: 'in'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword232); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "in";
                    }

                    }
                    break;
                case 22 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:622: 'to'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword237); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "to";
                    }

                    }
                    break;
                case 23 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:642: 'mapsTo'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword242); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "mapsTo";
                    }

                    }
                    break;
                case 24 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:670: 'distinct'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword247); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "distinct";
                    }

                    }
                    break;
                case 25 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:702: 'foreach'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword252); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "foreach";
                    }

                    }
                    break;
                case 26 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:732: 'do'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword257); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "do";
                    }

                    }
                    break;
                case 27 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:752: 'if'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword262); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "if";
                    }

                    }
                    break;
                case 28 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:772: 'else'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword267); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "else";
                    }

                    }
                    break;
                case 29 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:796: 'for'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword272); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "for";
                    }

                    }
                    break;
                case 30 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:818: 'iterate'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword277); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "iterate";
                    }

                    }
                    break;
                case 31 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:848: 'OclUndefined'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword282); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OclUndefined";
                    }

                    }
                    break;
                case 32 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:888: 'true'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword287); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 33 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:912: 'false'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword292); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 34 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:938: 'then'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword297); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "then";
                    }

                    }
                    break;
                case 35 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:962: 'endif'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword302); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "endif";
                    }

                    }
                    break;
                case 36 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:988: 'super'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword307); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "super";
                    }

                    }
                    break;
                case 37 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1014: 'let'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword312); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "let";
                    }

                    }
                    break;
                case 38 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1036: 'Bag'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword317); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Bag";
                    }

                    }
                    break;
                case 39 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1058: 'Set'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword322); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Set";
                    }

                    }
                    break;
                case 40 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1080: 'OrderedSet'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword327); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OrderedSet";
                    }

                    }
                    break;
                case 41 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1116: 'Sequence'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword332); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Sequence";
                    }

                    }
                    break;
                case 42 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1148: 'Map'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword337); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Map";
                    }

                    }
                    break;
                case 43 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1170: 'Tuple'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword342); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Tuple";
                    }

                    }
                    break;
                case 44 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1196: 'OclType'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword347); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OclType";
                    }

                    }
                    break;
                case 45 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1226: 'OclAny'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword352); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OclAny";
                    }

                    }
                    break;
                case 46 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1254: 'TupleType'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword357); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "TupleType";
                    }

                    }
                    break;
                case 47 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1288: 'Integer'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword362); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Integer";
                    }

                    }
                    break;
                case 48 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1318: 'Real'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword367); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Real";
                    }

                    }
                    break;
                case 49 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1342: 'Boolean'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword372); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Boolean";
                    }

                    }
                    break;
                case 50 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1372: 'String'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword377); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "String";
                    }

                    }
                    break;
                case 51 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1400: 'Collection'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword382); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Collection";
                    }

                    }
                    break;
                case 52 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1436: 'not'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword387); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "not";
                    }

                    }
                    break;
                case 53 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1458: 'div'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword392); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "div";
                    }

                    }
                    break;
                case 54 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1480: 'mod'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword397); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "mod";
                    }

                    }
                    break;
                case 55 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1502: 'and'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword402); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 56 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1524: 'or'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword407); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "or";
                    }

                    }
                    break;
                case 57 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1544: 'xor'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword412); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "xor";
                    }

                    }
                    break;
                case 58 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:80:1566: 'implies'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword417); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "implies";
                    }

                    }
                    break;

            }

            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end identifierOrKeyword


    // $ANTLR start stringSymbol
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:87:1: stringSymbol returns [Object ret2] : ast= STRING ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:88:2: (ast= STRING )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:88:4: ast= STRING
            {
            ast=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_stringSymbol452); if (failed) return ret2;
            if ( backtracking==0 ) {
              ret = ei.unescapeString(ast.getText(), 1); ei.setToken((Object)ast);
            }
            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end stringSymbol


    // $ANTLR start integerSymbol
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:95:1: integerSymbol returns [Object ret2] : ast= INT ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:96:2: (ast= INT )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:96:4: ast= INT
            {
            ast=(Token)input.LT(1);
            match(input,INT,FOLLOW_INT_in_integerSymbol486); if (failed) return ret2;
            if ( backtracking==0 ) {
              ret = Integer.valueOf(ast.getText()); ei.setToken((Object)ast);
            }
            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end integerSymbol


    // $ANTLR start floatSymbol
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:103:1: floatSymbol returns [Object ret2] : ast= FLOAT ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:104:2: (ast= FLOAT )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:104:4: ast= FLOAT
            {
            ast=(Token)input.LT(1);
            match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol520); if (failed) return ret2;
            if ( backtracking==0 ) {
              ret = Double.valueOf(ast.getText()); ei.setToken((Object)ast);
            }
            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end floatSymbol


    // $ANTLR start unit
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:111:1: unit returns [Object ret2] : ( (ret= module | ret= library | ret= query ) ) ;
    public final Object unit() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:112:2: ( ( (ret= module | ret= library | ret= query ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:112:4: ( (ret= module | ret= library | ret= query ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:112:4: ( (ret= module | ret= library | ret= query ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:112:5: (ret= module | ret= library | ret= query )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:112:5: (ret= module | ret= library | ret= query )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt2=1;
                }
                break;
            case 46:
                {
                alt2=2;
                }
                break;
            case 47:
                {
                alt2=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("112:5: (ret= module | ret= library | ret= query )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:112:6: ret= module
                    {
                    pushFollow(FOLLOW_module_in_unit556);
                    ret=module();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:112:18: ret= library
                    {
                    pushFollow(FOLLOW_library_in_unit561);
                    ret=library();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:112:31: ret= query
                    {
                    pushFollow(FOLLOW_query_in_unit566);
                    ret=query();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end unit


    // $ANTLR start module
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:120:1: module returns [Object ret2] : ( 'module' temp= identifier SEMI 'create' ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) ( ( 'refining' ) | ( 'from' ) ) ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) ) ) ;
    public final Object module() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Module", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:2: ( ( 'module' temp= identifier SEMI 'create' ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) ( ( 'refining' ) | ( 'from' ) ) ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:4: ( 'module' temp= identifier SEMI 'create' ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) ( ( 'refining' ) | ( 'from' ) ) ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:4: ( 'module' temp= identifier SEMI 'create' ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) ( ( 'refining' ) | ( 'from' ) ) ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:5: 'module' temp= identifier SEMI 'create' ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) ( ( 'refining' ) | ( 'from' ) ) ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) )
            {
            match(input,42,FOLLOW_42_in_module599); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_module603);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_module607); if (failed) return ret2;
            match(input,43,FOLLOW_43_in_module609); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:73: ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:74: (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:74: (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:75: temp= oclModel ( ( ( COMA ) temp= oclModel ) )*
            {
            pushFollow(FOLLOW_oclModel_in_module615);
            temp=oclModel();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "outModels", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:123: ( ( ( COMA ) temp= oclModel ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==COMA) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:124: ( ( COMA ) temp= oclModel )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:124: ( ( COMA ) temp= oclModel )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:125: ( COMA ) temp= oclModel
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:125: ( COMA )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:126: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_module622); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_oclModel_in_module627);
            	    temp=oclModel();
            	    _fsp--;
            	    if (failed) return ret2;
            	    if ( backtracking==0 ) {
            	      ei.set(ret, "outModels", temp);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:185: ( ( 'refining' ) | ( 'from' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==44) ) {
                alt4=1;
            }
            else if ( (LA4_0==45) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("121:185: ( ( 'refining' ) | ( 'from' ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:186: ( 'refining' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:186: ( 'refining' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:187: 'refining'
                    {
                    match(input,44,FOLLOW_44_in_module638); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:253: ( 'from' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:253: ( 'from' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:254: 'from'
                    {
                    match(input,45,FOLLOW_45_in_module645); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:317: ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:318: (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:318: (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:319: temp= oclModel ( ( ( COMA ) temp= oclModel ) )*
            {
            pushFollow(FOLLOW_oclModel_in_module655);
            temp=oclModel();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "inModels", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:366: ( ( ( COMA ) temp= oclModel ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:367: ( ( COMA ) temp= oclModel )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:367: ( ( COMA ) temp= oclModel )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:368: ( COMA ) temp= oclModel
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:368: ( COMA )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:369: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_module662); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_oclModel_in_module667);
            	    temp=oclModel();
            	    _fsp--;
            	    if (failed) return ret2;
            	    if ( backtracking==0 ) {
            	      ei.set(ret, "inModels", temp);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            match(input,SEMI,FOLLOW_SEMI_in_module676); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:432: ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:433: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:433: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:434: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:434: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==48) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:435: (temp= libraryRef ( (temp= libraryRef ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:435: (temp= libraryRef ( (temp= libraryRef ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:436: temp= libraryRef ( (temp= libraryRef ) )*
                    {
                    pushFollow(FOLLOW_libraryRef_in_module684);
                    temp=libraryRef();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "libraries", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:486: ( (temp= libraryRef ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==48) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:487: (temp= libraryRef )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:487: (temp= libraryRef )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:488: temp= libraryRef
                    	    {
                    	    pushFollow(FOLLOW_libraryRef_in_module692);
                    	    temp=libraryRef();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "libraries", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:544: ( (temp= moduleElement ( (temp= moduleElement ) )* ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==44||LA9_0==49||(LA9_0>=52 && LA9_0<=54)||(LA9_0>=57 && LA9_0<=60)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:545: (temp= moduleElement ( (temp= moduleElement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:545: (temp= moduleElement ( (temp= moduleElement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:546: temp= moduleElement ( (temp= moduleElement ) )*
                    {
                    pushFollow(FOLLOW_moduleElement_in_module706);
                    temp=moduleElement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:598: ( (temp= moduleElement ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==44||LA8_0==49||(LA8_0>=52 && LA8_0<=54)||(LA8_0>=57 && LA8_0<=60)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:599: (temp= moduleElement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:599: (temp= moduleElement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:121:600: temp= moduleElement
                    	    {
                    	    pushFollow(FOLLOW_moduleElement_in_module714);
                    	    temp=moduleElement();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "elements", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end module


    // $ANTLR start library
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:131:1: library returns [Object ret2] : ( 'library' temp= identifier SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) ) ;
    public final Object library() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Library", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:2: ( ( 'library' temp= identifier SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:4: ( 'library' temp= identifier SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:4: ( 'library' temp= identifier SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:5: 'library' temp= identifier SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) )
            {
            match(input,46,FOLLOW_46_in_library756); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_library760);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_library764); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:65: ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:66: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:66: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:67: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:67: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==48) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:68: (temp= libraryRef ( (temp= libraryRef ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:68: (temp= libraryRef ( (temp= libraryRef ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:69: temp= libraryRef ( (temp= libraryRef ) )*
                    {
                    pushFollow(FOLLOW_libraryRef_in_library772);
                    temp=libraryRef();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "libraries", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:119: ( (temp= libraryRef ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==48) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:120: (temp= libraryRef )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:120: (temp= libraryRef )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:121: temp= libraryRef
                    	    {
                    	    pushFollow(FOLLOW_libraryRef_in_library780);
                    	    temp=libraryRef();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "libraries", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:177: ( (temp= helper ( (temp= helper ) )* ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==49) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:178: (temp= helper ( (temp= helper ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:178: (temp= helper ( (temp= helper ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:179: temp= helper ( (temp= helper ) )*
                    {
                    pushFollow(FOLLOW_helper_in_library794);
                    temp=helper();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "helpers", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:223: ( (temp= helper ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==49) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:224: (temp= helper )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:224: (temp= helper )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:132:225: temp= helper
                    	    {
                    	    pushFollow(FOLLOW_helper_in_library802);
                    	    temp=helper();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "helpers", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end library


    // $ANTLR start query
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:142:1: query returns [Object ret2] : ( 'query' temp= identifier EQ temp= oclExpression SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) ) ;
    public final Object query() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Query", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:2: ( ( 'query' temp= identifier EQ temp= oclExpression SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:4: ( 'query' temp= identifier EQ temp= oclExpression SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:4: ( 'query' temp= identifier EQ temp= oclExpression SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:5: 'query' temp= identifier EQ temp= oclExpression SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) )
            {
            match(input,47,FOLLOW_47_in_query844); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_query848);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_query852); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_query856);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "body", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_query860); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:114: ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:115: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:115: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:116: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:116: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==48) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:117: (temp= libraryRef ( (temp= libraryRef ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:117: (temp= libraryRef ( (temp= libraryRef ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:118: temp= libraryRef ( (temp= libraryRef ) )*
                    {
                    pushFollow(FOLLOW_libraryRef_in_query868);
                    temp=libraryRef();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "libraries", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:168: ( (temp= libraryRef ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==48) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:169: (temp= libraryRef )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:169: (temp= libraryRef )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:170: temp= libraryRef
                    	    {
                    	    pushFollow(FOLLOW_libraryRef_in_query876);
                    	    temp=libraryRef();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "libraries", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:226: ( (temp= helper ( (temp= helper ) )* ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==49) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:227: (temp= helper ( (temp= helper ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:227: (temp= helper ( (temp= helper ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:228: temp= helper ( (temp= helper ) )*
                    {
                    pushFollow(FOLLOW_helper_in_query890);
                    temp=helper();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "helpers", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:272: ( (temp= helper ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==49) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:273: (temp= helper )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:273: (temp= helper )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:143:274: temp= helper
                    	    {
                    	    pushFollow(FOLLOW_helper_in_query898);
                    	    temp=helper();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "helpers", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end query


    // $ANTLR start libraryRef
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:153:1: libraryRef returns [Object ret2] : ( 'uses' temp= identifier SEMI ) ;
    public final Object libraryRef() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LibraryRef", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:154:2: ( ( 'uses' temp= identifier SEMI ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:154:4: ( 'uses' temp= identifier SEMI )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:154:4: ( 'uses' temp= identifier SEMI )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:154:5: 'uses' temp= identifier SEMI
            {
            match(input,48,FOLLOW_48_in_libraryRef940); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_libraryRef944);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_libraryRef948); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end libraryRef


    // $ANTLR start moduleElement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:164:1: moduleElement returns [Object ret2] : ( (ret= helper | ret= rule ) ) ;
    public final Object moduleElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:165:2: ( ( (ret= helper | ret= rule ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:165:4: ( (ret= helper | ret= rule ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:165:4: ( (ret= helper | ret= rule ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:165:5: (ret= helper | ret= rule )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:165:5: (ret= helper | ret= rule )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==49) ) {
                alt18=1;
            }
            else if ( (LA18_0==44||(LA18_0>=52 && LA18_0<=54)||(LA18_0>=57 && LA18_0<=60)) ) {
                alt18=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("165:5: (ret= helper | ret= rule )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:165:6: ret= helper
                    {
                    pushFollow(FOLLOW_helper_in_moduleElement983);
                    ret=helper();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:165:18: ret= rule
                    {
                    pushFollow(FOLLOW_rule_in_moduleElement988);
                    ret=rule();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end moduleElement


    // $ANTLR start helper
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:173:1: helper returns [Object ret2] : ( 'helper' temp= oclFeatureDefinition SEMI ) ;
    public final Object helper() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Helper", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:174:2: ( ( 'helper' temp= oclFeatureDefinition SEMI ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:174:4: ( 'helper' temp= oclFeatureDefinition SEMI )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:174:4: ( 'helper' temp= oclFeatureDefinition SEMI )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:174:5: 'helper' temp= oclFeatureDefinition SEMI
            {
            match(input,49,FOLLOW_49_in_helper1021); if (failed) return ret2;
            pushFollow(FOLLOW_oclFeatureDefinition_in_helper1025);
            temp=oclFeatureDefinition();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "definition", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_helper1029); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end helper


    // $ANTLR start oclFeatureDefinition
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:184:1: oclFeatureDefinition returns [Object ret2] : ( ( (temp= oclContextDefinition ) | () ) 'def' COLON temp= oclFeature ) ;
    public final Object oclFeatureDefinition() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OclFeatureDefinition", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:2: ( ( ( (temp= oclContextDefinition ) | () ) 'def' COLON temp= oclFeature ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:4: ( ( (temp= oclContextDefinition ) | () ) 'def' COLON temp= oclFeature )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:4: ( ( (temp= oclContextDefinition ) | () ) 'def' COLON temp= oclFeature )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:5: ( (temp= oclContextDefinition ) | () ) 'def' COLON temp= oclFeature
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:5: ( (temp= oclContextDefinition ) | () )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==51) ) {
                alt19=1;
            }
            else if ( (LA19_0==50) ) {
                alt19=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("185:5: ( (temp= oclContextDefinition ) | () )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:6: (temp= oclContextDefinition )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:6: (temp= oclContextDefinition )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:7: temp= oclContextDefinition
                    {
                    pushFollow(FOLLOW_oclContextDefinition_in_oclFeatureDefinition1065);
                    temp=oclContextDefinition();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "context_", temp);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:71: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:71: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:185:72: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            match(input,50,FOLLOW_50_in_oclFeatureDefinition1079); if (failed) return ret2;
            match(input,COLON,FOLLOW_COLON_in_oclFeatureDefinition1081); if (failed) return ret2;
            pushFollow(FOLLOW_oclFeature_in_oclFeatureDefinition1085);
            temp=oclFeature();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "feature", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end oclFeatureDefinition


    // $ANTLR start oclContextDefinition
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:195:1: oclContextDefinition returns [Object ret2] : ( 'context' temp= oclType ) ;
    public final Object oclContextDefinition() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OclContextDefinition", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:196:2: ( ( 'context' temp= oclType ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:196:4: ( 'context' temp= oclType )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:196:4: ( 'context' temp= oclType )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:196:5: 'context' temp= oclType
            {
            match(input,51,FOLLOW_51_in_oclContextDefinition1119); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_oclContextDefinition1123);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "context_", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end oclContextDefinition


    // $ANTLR start oclFeature
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:206:1: oclFeature returns [Object ret2] : ( (ret= operation | ret= attribute ) ) ;
    public final Object oclFeature() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:207:2: ( ( (ret= operation | ret= attribute ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:207:4: ( (ret= operation | ret= attribute ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:207:4: ( (ret= operation | ret= attribute ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:207:5: (ret= operation | ret= attribute )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:207:5: (ret= operation | ret= attribute )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==NAME) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==LPAREN) ) {
                    alt20=1;
                }
                else if ( (LA20_1==COLON) ) {
                    alt20=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("207:5: (ret= operation | ret= attribute )", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("207:5: (ret= operation | ret= attribute )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:207:6: ret= operation
                    {
                    pushFollow(FOLLOW_operation_in_oclFeature1160);
                    ret=operation();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:207:21: ret= attribute
                    {
                    pushFollow(FOLLOW_attribute_in_oclFeature1165);
                    ret=attribute();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end oclFeature


    // $ANTLR start operation
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:215:1: operation returns [Object ret2] : (temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN COLON temp= oclType EQ ( (temp= oclExpression ) ) ) ;
    public final Object operation() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Operation", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:2: ( (temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN COLON temp= oclType EQ ( (temp= oclExpression ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:4: (temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN COLON temp= oclType EQ ( (temp= oclExpression ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:4: (temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN COLON temp= oclType EQ ( (temp= oclExpression ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:5: temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN COLON temp= oclType EQ ( (temp= oclExpression ) )
            {
            pushFollow(FOLLOW_identifier_in_operation1200);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_operation1204); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:57: ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NAME) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:58: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:58: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:59: temp= parameter ( ( ( COMA ) temp= parameter ) )*
                    {
                    pushFollow(FOLLOW_parameter_in_operation1210);
                    temp=parameter();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "parameters", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:109: ( ( ( COMA ) temp= parameter ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==COMA) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:110: ( ( COMA ) temp= parameter )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:110: ( ( COMA ) temp= parameter )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:111: ( COMA ) temp= parameter
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:111: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:112: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_operation1217); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_parameter_in_operation1222);
                    	    temp=parameter();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "parameters", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_operation1232); if (failed) return ret2;
            match(input,COLON,FOLLOW_COLON_in_operation1234); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_operation1238);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "returnType", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_operation1242); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:238: ( (temp= oclExpression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:239: (temp= oclExpression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:239: (temp= oclExpression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:216:240: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_operation1248);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "body", temp);
            }

            }


            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end operation


    // $ANTLR start parameter
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:226:1: parameter returns [Object ret2] : (temp= identifier COLON temp= oclType ) ;
    public final Object parameter() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Parameter", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:227:2: ( (temp= identifier COLON temp= oclType ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:227:4: (temp= identifier COLON temp= oclType )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:227:4: (temp= identifier COLON temp= oclType )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:227:5: temp= identifier COLON temp= oclType
            {
            pushFollow(FOLLOW_identifier_in_parameter1286);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_parameter1290); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_parameter1294);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end parameter


    // $ANTLR start attribute
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:237:1: attribute returns [Object ret2] : (temp= identifier COLON temp= oclType EQ ( (temp= oclExpression ) ) ) ;
    public final Object attribute() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Attribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:238:2: ( (temp= identifier COLON temp= oclType EQ ( (temp= oclExpression ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:238:4: (temp= identifier COLON temp= oclType EQ ( (temp= oclExpression ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:238:4: (temp= identifier COLON temp= oclType EQ ( (temp= oclExpression ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:238:5: temp= identifier COLON temp= oclType EQ ( (temp= oclExpression ) )
            {
            pushFollow(FOLLOW_identifier_in_attribute1330);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_attribute1334); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_attribute1338);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_attribute1342); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:238:101: ( (temp= oclExpression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:238:102: (temp= oclExpression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:238:102: (temp= oclExpression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:238:103: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_attribute1348);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "initExpression", temp);
            }

            }


            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end attribute


    // $ANTLR start rule
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:248:1: rule returns [Object ret2] : ( (ret= calledRule | ret= matchedRule ) ) ;
    public final Object rule() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:249:2: ( ( (ret= calledRule | ret= matchedRule ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:249:4: ( (ret= calledRule | ret= matchedRule ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:249:4: ( (ret= calledRule | ret= matchedRule ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:249:5: (ret= calledRule | ret= matchedRule )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:249:5: (ret= calledRule | ret= matchedRule )
            int alt23=2;
            switch ( input.LA(1) ) {
            case 59:
            case 60:
                {
                alt23=1;
                }
                break;
            case 54:
                {
                int LA23_2 = input.LA(2);

                if ( (LA23_2==NAME) ) {
                    int LA23_4 = input.LA(3);

                    if ( (LA23_4==LCURLY||LA23_4==55) ) {
                        alt23=2;
                    }
                    else if ( (LA23_4==LPAREN) ) {
                        alt23=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("249:5: (ret= calledRule | ret= matchedRule )", 23, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("249:5: (ret= calledRule | ret= matchedRule )", 23, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
            case 52:
            case 53:
            case 57:
            case 58:
                {
                alt23=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("249:5: (ret= calledRule | ret= matchedRule )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:249:6: ret= calledRule
                    {
                    pushFollow(FOLLOW_calledRule_in_rule1387);
                    ret=calledRule();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:249:22: ret= matchedRule
                    {
                    pushFollow(FOLLOW_matchedRule_in_rule1392);
                    ret=matchedRule();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end rule


    // $ANTLR start matchedRule
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:257:1: matchedRule returns [Object ret2] : ( (ret= lazyMatchedRule | ret= matchedRule_abstractContents ) ) ;
    public final Object matchedRule() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:258:2: ( ( (ret= lazyMatchedRule | ret= matchedRule_abstractContents ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:258:4: ( (ret= lazyMatchedRule | ret= matchedRule_abstractContents ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:258:4: ( (ret= lazyMatchedRule | ret= matchedRule_abstractContents ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:258:5: (ret= lazyMatchedRule | ret= matchedRule_abstractContents )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:258:5: (ret= lazyMatchedRule | ret= matchedRule_abstractContents )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=57 && LA24_0<=58)) ) {
                alt24=1;
            }
            else if ( (LA24_0==44||(LA24_0>=52 && LA24_0<=54)) ) {
                alt24=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("258:5: (ret= lazyMatchedRule | ret= matchedRule_abstractContents )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:258:6: ret= lazyMatchedRule
                    {
                    pushFollow(FOLLOW_lazyMatchedRule_in_matchedRule1428);
                    ret=lazyMatchedRule();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:258:27: ret= matchedRule_abstractContents
                    {
                    pushFollow(FOLLOW_matchedRule_abstractContents_in_matchedRule1433);
                    ret=matchedRule_abstractContents();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, true);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end matchedRule


    // $ANTLR start lazyMatchedRule
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:266:1: lazyMatchedRule returns [Object ret2] : ( ( ( 'unique' ) | () ) 'lazy' ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) ;
    public final Object lazyMatchedRule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LazyMatchedRule", true, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:2: ( ( ( ( 'unique' ) | () ) 'lazy' ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:4: ( ( ( 'unique' ) | () ) 'lazy' ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:4: ( ( ( 'unique' ) | () ) 'lazy' ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:5: ( ( 'unique' ) | () ) 'lazy' ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:5: ( ( 'unique' ) | () )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==57) ) {
                alt25=1;
            }
            else if ( (LA25_0==58) ) {
                alt25=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("267:5: ( ( 'unique' ) | () )", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:6: ( 'unique' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:6: ( 'unique' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:7: 'unique'
                    {
                    match(input,57,FOLLOW_57_in_lazyMatchedRule1468); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isUnique", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:69: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:69: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:70: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isUnique", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            match(input,58,FOLLOW_58_in_lazyMatchedRule1480); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:132: ( ( 'abstract' ) | () )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==53) ) {
                alt26=1;
            }
            else if ( (LA26_0==44||LA26_0==54) ) {
                alt26=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("267:132: ( ( 'abstract' ) | () )", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:133: ( 'abstract' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:133: ( 'abstract' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:134: 'abstract'
                    {
                    match(input,53,FOLLOW_53_in_lazyMatchedRule1484); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAbstract", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:200: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:200: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:201: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAbstract", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:258: ( ( 'refining' ) | () )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==44) ) {
                alt27=1;
            }
            else if ( (LA27_0==54) ) {
                alt27=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("267:258: ( ( 'refining' ) | () )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:259: ( 'refining' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:259: ( 'refining' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:260: 'refining'
                    {
                    match(input,44,FOLLOW_44_in_lazyMatchedRule1498); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:326: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:326: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:327: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            match(input,54,FOLLOW_54_in_lazyMatchedRule1510); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_lazyMatchedRule1514);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:436: ( ( 'extends' temp= identifier ) | () )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==55) ) {
                alt28=1;
            }
            else if ( (LA28_0==LCURLY) ) {
                alt28=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("267:436: ( ( 'extends' temp= identifier ) | () )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:437: ( 'extends' temp= identifier )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:437: ( 'extends' temp= identifier )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:438: 'extends' temp= identifier
                    {
                    match(input,55,FOLLOW_55_in_lazyMatchedRule1520); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_lazyMatchedRule1524);
                    temp=identifier();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.setRef(ret, "superRule", "MatchedRule", "name", temp, null, "never", null, true, null);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:562: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:562: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:563: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_lazyMatchedRule1538); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:576: ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:577: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:577: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:578: temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () )
            {
            pushFollow(FOLLOW_inPattern_in_lazyMatchedRule1544);
            temp=inPattern();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "inPattern", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:627: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==56) ) {
                alt31=1;
            }
            else if ( (LA31_0==RCURLY||LA31_0==62||LA31_0==66) ) {
                alt31=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("267:627: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:628: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:628: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:629: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,56,FOLLOW_56_in_lazyMatchedRule1550); if (failed) return ret2;
                    match(input,LCURLY,FOLLOW_LCURLY_in_lazyMatchedRule1552); if (failed) return ret2;
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:644: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:645: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:645: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:646: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:646: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==NAME) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:647: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:647: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:648: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1560);
                            temp=ruleVariableDeclaration();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "variables", temp);
                            }
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:711: ( (temp= ruleVariableDeclaration ) )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==NAME) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:712: (temp= ruleVariableDeclaration )
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:712: (temp= ruleVariableDeclaration )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:713: temp= ruleVariableDeclaration
                            	    {
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1568);
                            	    temp=ruleVariableDeclaration();
                            	    _fsp--;
                            	    if (failed) return ret2;
                            	    if ( backtracking==0 ) {
                            	      ei.set(ret, "variables", temp);
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop29;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_lazyMatchedRule1580); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:796: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:796: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:797: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:803: ( (temp= outPattern ) | () )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==62) ) {
                alt32=1;
            }
            else if ( (LA32_0==RCURLY||LA32_0==66) ) {
                alt32=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("267:803: ( (temp= outPattern ) | () )", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:804: (temp= outPattern )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:804: (temp= outPattern )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:805: temp= outPattern
                    {
                    pushFollow(FOLLOW_outPattern_in_lazyMatchedRule1596);
                    temp=outPattern();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "outPattern", temp);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:861: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:861: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:862: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:868: ( (temp= actionBlock ) | () )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==66) ) {
                alt33=1;
            }
            else if ( (LA33_0==RCURLY) ) {
                alt33=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("267:868: ( (temp= actionBlock ) | () )", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:869: (temp= actionBlock )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:869: (temp= actionBlock )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:870: temp= actionBlock
                    {
                    pushFollow(FOLLOW_actionBlock_in_lazyMatchedRule1614);
                    temp=actionBlock();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "actionBlock", temp);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:928: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:928: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:267:929: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_lazyMatchedRule1630); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end lazyMatchedRule


    // $ANTLR start ruleVariableDeclaration
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:277:1: ruleVariableDeclaration returns [Object ret2] : (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI ) ;
    public final Object ruleVariableDeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("RuleVariableDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:278:2: ( (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:278:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:278:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:278:5: temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI
            {
            pushFollow(FOLLOW_identifier_in_ruleVariableDeclaration1664);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_ruleVariableDeclaration1668); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_ruleVariableDeclaration1672);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_ruleVariableDeclaration1676); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_ruleVariableDeclaration1680);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "initExpression", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_ruleVariableDeclaration1684); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end ruleVariableDeclaration


    // $ANTLR start calledRule
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:288:1: calledRule returns [Object ret2] : ( ( ( 'entrypoint' ) | () ) ( ( 'endpoint' ) | () ) 'rule' temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN LCURLY ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) ;
    public final Object calledRule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CalledRule", true, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:2: ( ( ( ( 'entrypoint' ) | () ) ( ( 'endpoint' ) | () ) 'rule' temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN LCURLY ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:4: ( ( ( 'entrypoint' ) | () ) ( ( 'endpoint' ) | () ) 'rule' temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN LCURLY ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:4: ( ( ( 'entrypoint' ) | () ) ( ( 'endpoint' ) | () ) 'rule' temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN LCURLY ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:5: ( ( 'entrypoint' ) | () ) ( ( 'endpoint' ) | () ) 'rule' temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN LCURLY ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:5: ( ( 'entrypoint' ) | () )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==59) ) {
                alt34=1;
            }
            else if ( (LA34_0==54||LA34_0==60) ) {
                alt34=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("289:5: ( ( 'entrypoint' ) | () )", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:6: ( 'entrypoint' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:6: ( 'entrypoint' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:7: 'entrypoint'
                    {
                    match(input,59,FOLLOW_59_in_calledRule1718); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isEntrypoint", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:77: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:77: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:78: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isEntrypoint", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:137: ( ( 'endpoint' ) | () )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==60) ) {
                alt35=1;
            }
            else if ( (LA35_0==54) ) {
                alt35=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("289:137: ( ( 'endpoint' ) | () )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:138: ( 'endpoint' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:138: ( 'endpoint' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:139: 'endpoint'
                    {
                    match(input,60,FOLLOW_60_in_calledRule1732); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isEndpoint", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:205: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:205: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:206: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isEndpoint", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            match(input,54,FOLLOW_54_in_calledRule1744); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_calledRule1748);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_calledRule1752); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:322: ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==NAME) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:323: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:323: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:324: temp= parameter ( ( ( COMA ) temp= parameter ) )*
                    {
                    pushFollow(FOLLOW_parameter_in_calledRule1758);
                    temp=parameter();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "parameters", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:374: ( ( ( COMA ) temp= parameter ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==COMA) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:375: ( ( COMA ) temp= parameter )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:375: ( ( COMA ) temp= parameter )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:376: ( COMA ) temp= parameter
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:376: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:377: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_calledRule1765); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_parameter_in_calledRule1770);
                    	    temp=parameter();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "parameters", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_calledRule1780); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_calledRule1782); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:453: ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:454: ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:454: ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:455: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:455: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==56) ) {
                alt40=1;
            }
            else if ( (LA40_0==RCURLY||LA40_0==62||LA40_0==66) ) {
                alt40=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("289:455: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:456: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:456: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:457: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,56,FOLLOW_56_in_calledRule1788); if (failed) return ret2;
                    match(input,LCURLY,FOLLOW_LCURLY_in_calledRule1790); if (failed) return ret2;
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:472: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:473: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:473: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:474: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:474: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==NAME) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:475: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:475: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:476: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_calledRule1798);
                            temp=ruleVariableDeclaration();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "variables", temp);
                            }
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:539: ( (temp= ruleVariableDeclaration ) )*
                            loop38:
                            do {
                                int alt38=2;
                                int LA38_0 = input.LA(1);

                                if ( (LA38_0==NAME) ) {
                                    alt38=1;
                                }


                                switch (alt38) {
                            	case 1 :
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:540: (temp= ruleVariableDeclaration )
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:540: (temp= ruleVariableDeclaration )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:541: temp= ruleVariableDeclaration
                            	    {
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_calledRule1806);
                            	    temp=ruleVariableDeclaration();
                            	    _fsp--;
                            	    if (failed) return ret2;
                            	    if ( backtracking==0 ) {
                            	      ei.set(ret, "variables", temp);
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop38;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_calledRule1818); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:624: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:624: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:625: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:631: ( (temp= outPattern ) | () )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==62) ) {
                alt41=1;
            }
            else if ( (LA41_0==RCURLY||LA41_0==66) ) {
                alt41=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("289:631: ( (temp= outPattern ) | () )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:632: (temp= outPattern )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:632: (temp= outPattern )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:633: temp= outPattern
                    {
                    pushFollow(FOLLOW_outPattern_in_calledRule1834);
                    temp=outPattern();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "outPattern", temp);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:689: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:689: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:690: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:696: ( (temp= actionBlock ) | () )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==66) ) {
                alt42=1;
            }
            else if ( (LA42_0==RCURLY) ) {
                alt42=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("289:696: ( (temp= actionBlock ) | () )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:697: (temp= actionBlock )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:697: (temp= actionBlock )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:698: temp= actionBlock
                    {
                    pushFollow(FOLLOW_actionBlock_in_calledRule1852);
                    temp=actionBlock();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "actionBlock", temp);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:756: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:756: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:289:757: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_calledRule1868); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end calledRule


    // $ANTLR start inPattern
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:299:1: inPattern returns [Object ret2] : ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) ) ) ;
    public final Object inPattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("InPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:2: ( ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:4: ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:4: ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:5: 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) )
            {
            match(input,45,FOLLOW_45_in_inPattern1900); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:12: ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:13: ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:13: ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:14: ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:14: ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:15: (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:15: (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:16: temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )*
            {
            pushFollow(FOLLOW_inPatternElement_in_inPattern1908);
            temp=inPatternElement();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elements", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:71: ( ( ( COMA ) temp= inPatternElement ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==COMA) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:72: ( ( COMA ) temp= inPatternElement )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:72: ( ( COMA ) temp= inPatternElement )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:73: ( COMA ) temp= inPatternElement
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:73: ( COMA )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:74: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_inPattern1915); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_inPatternElement_in_inPattern1920);
            	    temp=inPatternElement();
            	    _fsp--;
            	    if (failed) return ret2;
            	    if ( backtracking==0 ) {
            	      ei.set(ret, "elements", temp);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:140: ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==LPAREN) ) {
                alt44=1;
            }
            else if ( (LA44_0==RCURLY||LA44_0==56||LA44_0==62||LA44_0==66) ) {
                alt44=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("300:140: ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () )", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:141: ( LPAREN ( (temp= oclExpression ) ) RPAREN )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:141: ( LPAREN ( (temp= oclExpression ) ) RPAREN )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:142: LPAREN ( (temp= oclExpression ) ) RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_inPattern1931); if (failed) return ret2;
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:149: ( (temp= oclExpression ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:150: (temp= oclExpression )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:150: (temp= oclExpression )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:151: temp= oclExpression
                    {
                    pushFollow(FOLLOW_oclExpression_in_inPattern1937);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "filter", temp);
                    }

                    }


                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_inPattern1943); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:215: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:215: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:300:216: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end inPattern


    // $ANTLR start inPatternElement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:310:1: inPatternElement returns [Object ret2] : (ret= simpleInPatternElement ) ;
    public final Object inPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:311:2: ( (ret= simpleInPatternElement ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:311:4: (ret= simpleInPatternElement )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:311:4: (ret= simpleInPatternElement )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:311:5: ret= simpleInPatternElement
            {
            pushFollow(FOLLOW_simpleInPatternElement_in_inPatternElement1989);
            ret=simpleInPatternElement();
            _fsp--;
            if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, true);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end inPatternElement


    // $ANTLR start simpleInPatternElement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:319:1: simpleInPatternElement returns [Object ret2] : (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) ) ;
    public final Object simpleInPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SimpleInPatternElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:2: ( (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:4: (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:4: (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:5: temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () )
            {
            pushFollow(FOLLOW_identifier_in_simpleInPatternElement2023);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_simpleInPatternElement2027); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_simpleInPatternElement2031);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:101: ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==61) ) {
                alt47=1;
            }
            else if ( (LA47_0==EOF||LA47_0==COMA||LA47_0==LPAREN||LA47_0==RCURLY||LA47_0==56||LA47_0==62||LA47_0==66) ) {
                alt47=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("320:101: ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () )", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:102: ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:102: ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:103: 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )?
                    {
                    match(input,61,FOLLOW_61_in_simpleInPatternElement2037); if (failed) return ret2;
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:108: ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==NAME) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:109: (temp= identifier ( ( ( COMA ) temp= identifier ) )* )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:109: (temp= identifier ( ( ( COMA ) temp= identifier ) )* )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:110: temp= identifier ( ( ( COMA ) temp= identifier ) )*
                            {
                            pushFollow(FOLLOW_identifier_in_simpleInPatternElement2043);
                            temp=identifier();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.setRef(ret, "models", "OclModel", "name", temp, "#all", "never", null, false, null);
                            }
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:216: ( ( ( COMA ) temp= identifier ) )*
                            loop45:
                            do {
                                int alt45=2;
                                int LA45_0 = input.LA(1);

                                if ( (LA45_0==COMA) ) {
                                    int LA45_1 = input.LA(2);

                                    if ( (LA45_1==NAME) ) {
                                        int LA45_3 = input.LA(3);

                                        if ( (LA45_3==EOF||LA45_3==COMA||LA45_3==LPAREN||LA45_3==RCURLY||LA45_3==56||LA45_3==62||LA45_3==66) ) {
                                            alt45=1;
                                        }


                                    }


                                }


                                switch (alt45) {
                            	case 1 :
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:217: ( ( COMA ) temp= identifier )
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:217: ( ( COMA ) temp= identifier )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:218: ( COMA ) temp= identifier
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:218: ( COMA )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:219: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_simpleInPatternElement2050); if (failed) return ret2;

                            	    }

                            	    pushFollow(FOLLOW_identifier_in_simpleInPatternElement2055);
                            	    temp=identifier();
                            	    _fsp--;
                            	    if (failed) return ret2;
                            	    if ( backtracking==0 ) {
                            	      ei.setRef(ret, "models", "OclModel", "name", temp, "#all", "never", null, false, null);
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop45;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:342: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:342: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:320:343: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end simpleInPatternElement


    // $ANTLR start outPattern
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:330:1: outPattern returns [Object ret2] : ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) ) ;
    public final Object outPattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OutPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:2: ( ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:4: ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:4: ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:5: 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) )
            {
            match(input,62,FOLLOW_62_in_outPattern2105); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:10: ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:11: ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:11: ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:12: ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:12: ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:13: (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:13: (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:14: temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )*
            {
            pushFollow(FOLLOW_outPatternElement_in_outPattern2113);
            temp=outPatternElement();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elements", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:70: ( ( ( COMA ) temp= outPatternElement ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==COMA) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:71: ( ( COMA ) temp= outPatternElement )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:71: ( ( COMA ) temp= outPatternElement )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:72: ( COMA ) temp= outPatternElement
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:72: ( COMA )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:331:73: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_outPattern2120); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_outPatternElement_in_outPattern2125);
            	    temp=outPatternElement();
            	    _fsp--;
            	    if (failed) return ret2;
            	    if ( backtracking==0 ) {
            	      ei.set(ret, "elements", temp);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }


            }


            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end outPattern


    // $ANTLR start outPatternElement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:341:1: outPatternElement returns [Object ret2] : ( (ret= simpleOutPatternElement | ret= forEachOutPatternElement ) ) ;
    public final Object outPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:342:2: ( ( (ret= simpleOutPatternElement | ret= forEachOutPatternElement ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:342:4: ( (ret= simpleOutPatternElement | ret= forEachOutPatternElement ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:342:4: ( (ret= simpleOutPatternElement | ret= forEachOutPatternElement ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:342:5: (ret= simpleOutPatternElement | ret= forEachOutPatternElement )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:342:5: (ret= simpleOutPatternElement | ret= forEachOutPatternElement )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==NAME) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==COLON) ) {
                    int LA49_2 = input.LA(3);

                    if ( (LA49_2==64) ) {
                        alt49=2;
                    }
                    else if ( (LA49_2==NAME||(LA49_2>=78 && LA49_2<=82)||(LA49_2>=84 && LA49_2<=91)) ) {
                        alt49=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("342:5: (ret= simpleOutPatternElement | ret= forEachOutPatternElement )", 49, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("342:5: (ret= simpleOutPatternElement | ret= forEachOutPatternElement )", 49, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("342:5: (ret= simpleOutPatternElement | ret= forEachOutPatternElement )", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:342:6: ret= simpleOutPatternElement
                    {
                    pushFollow(FOLLOW_simpleOutPatternElement_in_outPatternElement2169);
                    ret=simpleOutPatternElement();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:342:35: ret= forEachOutPatternElement
                    {
                    pushFollow(FOLLOW_forEachOutPatternElement_in_outPatternElement2174);
                    ret=forEachOutPatternElement();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, true);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end outPatternElement


    // $ANTLR start simpleOutPatternElement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:350:1: simpleOutPatternElement returns [Object ret2] : (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) ) ;
    public final Object simpleOutPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SimpleOutPatternElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:2: ( (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:4: (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:4: (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:5: temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )
            {
            pushFollow(FOLLOW_identifier_in_simpleOutPatternElement2209);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_simpleOutPatternElement2213); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_simpleOutPatternElement2217);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:101: ( ( 'in' temp= identifier ) | () )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==61) ) {
                alt50=1;
            }
            else if ( (LA50_0==EOF||LA50_0==COMA||LA50_0==LPAREN||(LA50_0>=RCURLY && LA50_0<=RARROW)||LA50_0==63||LA50_0==66) ) {
                alt50=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("351:101: ( ( 'in' temp= identifier ) | () )", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:102: ( 'in' temp= identifier )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:102: ( 'in' temp= identifier )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:103: 'in' temp= identifier
                    {
                    match(input,61,FOLLOW_61_in_simpleOutPatternElement2223); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_simpleOutPatternElement2227);
                    temp=identifier();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.setRef(ret, "model", "OclModel", "name", temp, "#all", "never", null, false, null);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:218: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:218: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:219: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:225: ( ( 'mapsTo' temp= identifier ) | () )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==63) ) {
                alt51=1;
            }
            else if ( (LA51_0==EOF||LA51_0==COMA||LA51_0==LPAREN||(LA51_0>=RCURLY && LA51_0<=RARROW)||LA51_0==66) ) {
                alt51=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("351:225: ( ( 'mapsTo' temp= identifier ) | () )", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:226: ( 'mapsTo' temp= identifier )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:226: ( 'mapsTo' temp= identifier )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:227: 'mapsTo' temp= identifier
                    {
                    match(input,63,FOLLOW_63_in_simpleOutPatternElement2243); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_simpleOutPatternElement2247);
                    temp=identifier();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.setRef(ret, "sourceElement", "InPatternElement", "varName", temp, null, "never", null, false, null);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:363: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:363: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:364: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:370: ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RARROW) ) {
                alt54=1;
            }
            else if ( (LA54_0==EOF||LA54_0==COMA||LA54_0==LPAREN||LA54_0==RCURLY||LA54_0==66) ) {
                alt54=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("351:370: ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () )", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:371: ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:371: ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:372: RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
                    {
                    match(input,RARROW,FOLLOW_RARROW_in_simpleOutPatternElement2263); if (failed) return ret2;
                    match(input,LPAREN,FOLLOW_LPAREN_in_simpleOutPatternElement2265); if (failed) return ret2;
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:386: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( ((LA53_0>=NAME && LA53_0<=FLOAT)||LA53_0==LPAREN||LA53_0==SHARP||LA53_0==MINUS||LA53_0==67||(LA53_0>=71 && LA53_0<=73)||(LA53_0>=76 && LA53_0<=92)) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:387: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:387: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:388: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                            {
                            pushFollow(FOLLOW_oclExpression_in_simpleOutPatternElement2271);
                            temp=oclExpression();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "reverseBindings", temp);
                            }
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:447: ( ( ( COMA ) temp= oclExpression ) )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==COMA) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:448: ( ( COMA ) temp= oclExpression )
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:448: ( ( COMA ) temp= oclExpression )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:449: ( COMA ) temp= oclExpression
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:449: ( COMA )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:450: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_simpleOutPatternElement2278); if (failed) return ret2;

                            	    }

                            	    pushFollow(FOLLOW_oclExpression_in_simpleOutPatternElement2283);
                            	    temp=oclExpression();
                            	    _fsp--;
                            	    if (failed) return ret2;
                            	    if ( backtracking==0 ) {
                            	      ei.set(ret, "reverseBindings", temp);
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop52;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_simpleOutPatternElement2293); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:533: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:533: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:534: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:540: ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==LPAREN) ) {
                alt57=1;
            }
            else if ( (LA57_0==EOF||LA57_0==COMA||LA57_0==RCURLY||LA57_0==66) ) {
                alt57=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("351:540: ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:541: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:541: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:542: LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_simpleOutPatternElement2307); if (failed) return ret2;
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:549: ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:550: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:550: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:551: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:551: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==NAME||(LA56_0>=42 && LA56_0<=98)) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:552: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:552: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:553: temp= binding ( ( ( COMA ) temp= binding ) )*
                            {
                            pushFollow(FOLLOW_binding_in_simpleOutPatternElement2315);
                            temp=binding();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "bindings", temp);
                            }
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:599: ( ( ( COMA ) temp= binding ) )*
                            loop55:
                            do {
                                int alt55=2;
                                int LA55_0 = input.LA(1);

                                if ( (LA55_0==COMA) ) {
                                    alt55=1;
                                }


                                switch (alt55) {
                            	case 1 :
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:600: ( ( COMA ) temp= binding )
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:600: ( ( COMA ) temp= binding )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:601: ( COMA ) temp= binding
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:601: ( COMA )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:602: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_simpleOutPatternElement2322); if (failed) return ret2;

                            	    }

                            	    pushFollow(FOLLOW_binding_in_simpleOutPatternElement2327);
                            	    temp=binding();
                            	    _fsp--;
                            	    if (failed) return ret2;
                            	    if ( backtracking==0 ) {
                            	      ei.set(ret, "bindings", temp);
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop55;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_simpleOutPatternElement2339); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:674: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:674: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:351:675: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end simpleOutPatternElement


    // $ANTLR start forEachOutPatternElement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:361:1: forEachOutPatternElement returns [Object ret2] : (temp= identifier COLON 'distinct' temp= oclType 'foreach' LPAREN temp= iterator 'in' temp= oclExpression RPAREN ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) ) ;
    public final Object forEachOutPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ForEachOutPatternElement", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:2: ( (temp= identifier COLON 'distinct' temp= oclType 'foreach' LPAREN temp= iterator 'in' temp= oclExpression RPAREN ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:4: (temp= identifier COLON 'distinct' temp= oclType 'foreach' LPAREN temp= iterator 'in' temp= oclExpression RPAREN ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:4: (temp= identifier COLON 'distinct' temp= oclType 'foreach' LPAREN temp= iterator 'in' temp= oclExpression RPAREN ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:5: temp= identifier COLON 'distinct' temp= oclType 'foreach' LPAREN temp= iterator 'in' temp= oclExpression RPAREN ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )
            {
            pushFollow(FOLLOW_identifier_in_forEachOutPatternElement2383);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_forEachOutPatternElement2387); if (failed) return ret2;
            match(input,64,FOLLOW_64_in_forEachOutPatternElement2389); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_forEachOutPatternElement2393);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            match(input,65,FOLLOW_65_in_forEachOutPatternElement2397); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_forEachOutPatternElement2399); if (failed) return ret2;
            pushFollow(FOLLOW_iterator_in_forEachOutPatternElement2403);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterator", temp);
            }
            match(input,61,FOLLOW_61_in_forEachOutPatternElement2407); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_forEachOutPatternElement2411);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "collection", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_forEachOutPatternElement2415); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:242: ( ( 'mapsTo' temp= identifier ) | () )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==63) ) {
                alt58=1;
            }
            else if ( (LA58_0==EOF||LA58_0==COMA||LA58_0==LPAREN||LA58_0==RCURLY||LA58_0==66) ) {
                alt58=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("362:242: ( ( 'mapsTo' temp= identifier ) | () )", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:243: ( 'mapsTo' temp= identifier )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:243: ( 'mapsTo' temp= identifier )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:244: 'mapsTo' temp= identifier
                    {
                    match(input,63,FOLLOW_63_in_forEachOutPatternElement2419); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_forEachOutPatternElement2423);
                    temp=identifier();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.setRef(ret, "sourceElement", "InPatternElement", "varName", temp, null, "never", null, false, null);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:380: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:380: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:381: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:387: ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==LPAREN) ) {
                alt61=1;
            }
            else if ( (LA61_0==EOF||LA61_0==COMA||LA61_0==RCURLY||LA61_0==66) ) {
                alt61=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("362:387: ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:388: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:388: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:389: LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_forEachOutPatternElement2439); if (failed) return ret2;
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:396: ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:397: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:397: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:398: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:398: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==NAME||(LA60_0>=42 && LA60_0<=98)) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:399: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:399: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:400: temp= binding ( ( ( COMA ) temp= binding ) )*
                            {
                            pushFollow(FOLLOW_binding_in_forEachOutPatternElement2447);
                            temp=binding();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "bindings", temp);
                            }
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:446: ( ( ( COMA ) temp= binding ) )*
                            loop59:
                            do {
                                int alt59=2;
                                int LA59_0 = input.LA(1);

                                if ( (LA59_0==COMA) ) {
                                    alt59=1;
                                }


                                switch (alt59) {
                            	case 1 :
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:447: ( ( COMA ) temp= binding )
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:447: ( ( COMA ) temp= binding )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:448: ( COMA ) temp= binding
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:448: ( COMA )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:449: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_forEachOutPatternElement2454); if (failed) return ret2;

                            	    }

                            	    pushFollow(FOLLOW_binding_in_forEachOutPatternElement2459);
                            	    temp=binding();
                            	    _fsp--;
                            	    if (failed) return ret2;
                            	    if ( backtracking==0 ) {
                            	      ei.set(ret, "bindings", temp);
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop59;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_forEachOutPatternElement2471); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:521: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:521: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:362:522: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end forEachOutPatternElement


    // $ANTLR start binding
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:372:1: binding returns [Object ret2] : (temp= identifierOrKeyword LARROW temp= oclExpression ) ;
    public final Object binding() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Binding", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:373:2: ( (temp= identifierOrKeyword LARROW temp= oclExpression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:373:4: (temp= identifierOrKeyword LARROW temp= oclExpression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:373:4: (temp= identifierOrKeyword LARROW temp= oclExpression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:373:5: temp= identifierOrKeyword LARROW temp= oclExpression
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_binding2515);
            temp=identifierOrKeyword();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "propertyName", temp);
            }
            match(input,LARROW,FOLLOW_LARROW_in_binding2519); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_binding2523);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "value", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end binding


    // $ANTLR start actionBlock
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:383:1: actionBlock returns [Object ret2] : ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object actionBlock() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ActionBlock", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:2: ( ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:4: ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:4: ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:5: 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,66,FOLLOW_66_in_actionBlock2557); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_actionBlock2559); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:17: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:18: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:18: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:19: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:19: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=NAME && LA63_0<=FLOAT)||LA63_0==LPAREN||LA63_0==SHARP||LA63_0==MINUS||LA63_0==67||LA63_0==69||(LA63_0>=71 && LA63_0<=73)||(LA63_0>=76 && LA63_0<=92)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:20: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:20: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:21: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_actionBlock2567);
                    temp=statement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "statements", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:71: ( (temp= statement ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( ((LA62_0>=NAME && LA62_0<=FLOAT)||LA62_0==LPAREN||LA62_0==SHARP||LA62_0==MINUS||LA62_0==67||LA62_0==69||(LA62_0>=71 && LA62_0<=73)||(LA62_0>=76 && LA62_0<=92)) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:72: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:72: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:384:73: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_actionBlock2575);
                    	    temp=statement();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "statements", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_actionBlock2587); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end actionBlock


    // $ANTLR start statement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:394:1: statement returns [Object ret2] : ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) ) ;
    public final Object statement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:2: ( ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:4: ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:4: ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )
            int alt64=4;
            switch ( input.LA(1) ) {
            case 67:
                {
                int LA64_1 = input.LA(2);

                if ( (synpred121()) ) {
                    alt64=1;
                }
                else if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 1, input);

                    throw nvae;
                }
                }
                break;
            case 92:
                {
                int LA64_2 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 2, input);

                    throw nvae;
                }
                }
                break;
            case MINUS:
                {
                int LA64_3 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 3, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                int LA64_4 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 4, input);

                    throw nvae;
                }
                }
                break;
            case NAME:
                {
                int LA64_5 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 5, input);

                    throw nvae;
                }
                }
                break;
            case 71:
                {
                int LA64_6 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 6, input);

                    throw nvae;
                }
                }
                break;
            case INT:
                {
                int LA64_7 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 7, input);

                    throw nvae;
                }
                }
                break;
            case FLOAT:
                {
                int LA64_8 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 8, input);

                    throw nvae;
                }
                }
                break;
            case 72:
                {
                int LA64_9 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 9, input);

                    throw nvae;
                }
                }
                break;
            case 73:
                {
                int LA64_10 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 10, input);

                    throw nvae;
                }
                }
                break;
            case STRING:
                {
                int LA64_11 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 11, input);

                    throw nvae;
                }
                }
                break;
            case 76:
                {
                int LA64_12 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 12, input);

                    throw nvae;
                }
                }
                break;
            case SHARP:
                {
                int LA64_13 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 13, input);

                    throw nvae;
                }
                }
                break;
            case 78:
                {
                int LA64_14 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 14, input);

                    throw nvae;
                }
                }
                break;
            case 79:
                {
                int LA64_15 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 15, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                int LA64_16 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 16, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA64_17 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 17, input);

                    throw nvae;
                }
                }
                break;
            case 82:
                {
                int LA64_18 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 18, input);

                    throw nvae;
                }
                }
                break;
            case 83:
                {
                int LA64_19 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 19, input);

                    throw nvae;
                }
                }
                break;
            case 85:
                {
                int LA64_20 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 20, input);

                    throw nvae;
                }
                }
                break;
            case 86:
                {
                int LA64_21 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 21, input);

                    throw nvae;
                }
                }
                break;
            case 87:
                {
                int LA64_22 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 22, input);

                    throw nvae;
                }
                }
                break;
            case 88:
                {
                int LA64_23 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 23, input);

                    throw nvae;
                }
                }
                break;
            case 89:
                {
                int LA64_24 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 24, input);

                    throw nvae;
                }
                }
                break;
            case 90:
                {
                int LA64_25 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 25, input);

                    throw nvae;
                }
                }
                break;
            case 91:
                {
                int LA64_26 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 26, input);

                    throw nvae;
                }
                }
                break;
            case 84:
                {
                int LA64_27 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 27, input);

                    throw nvae;
                }
                }
                break;
            case 77:
                {
                int LA64_28 = input.LA(2);

                if ( (synpred122()) ) {
                    alt64=2;
                }
                else if ( (synpred123()) ) {
                    alt64=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 28, input);

                    throw nvae;
                }
                }
                break;
            case 69:
                {
                alt64=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:6: ret= ifStat
                    {
                    pushFollow(FOLLOW_ifStat_in_statement2622);
                    ret=ifStat();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:18: ret= expressionStat
                    {
                    pushFollow(FOLLOW_expressionStat_in_statement2627);
                    ret=expressionStat();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:38: ret= bindingStat
                    {
                    pushFollow(FOLLOW_bindingStat_in_statement2632);
                    ret=bindingStat();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:55: ret= forStat
                    {
                    pushFollow(FOLLOW_forStat_in_statement2637);
                    ret=forStat();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end statement


    // $ANTLR start bindingStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:403:1: bindingStat returns [Object ret2] : (temp= oclExpression LARROW temp= oclExpression SEMI ) ;
    public final Object bindingStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BindingStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:404:2: ( (temp= oclExpression LARROW temp= oclExpression SEMI ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:404:4: (temp= oclExpression LARROW temp= oclExpression SEMI )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:404:4: (temp= oclExpression LARROW temp= oclExpression SEMI )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:404:5: temp= oclExpression LARROW temp= oclExpression SEMI
            {
            pushFollow(FOLLOW_oclExpression_in_bindingStat2672);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "source", temp);
            }
            match(input,LARROW,FOLLOW_LARROW_in_bindingStat2676); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_bindingStat2680);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "value", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_bindingStat2684); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end bindingStat


    // $ANTLR start expressionStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:414:1: expressionStat returns [Object ret2] : (temp= oclExpression SEMI ) ;
    public final Object expressionStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ExpressionStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:415:2: ( (temp= oclExpression SEMI ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:415:4: (temp= oclExpression SEMI )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:415:4: (temp= oclExpression SEMI )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:415:5: temp= oclExpression SEMI
            {
            pushFollow(FOLLOW_oclExpression_in_expressionStat2718);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "expression", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_expressionStat2722); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end expressionStat


    // $ANTLR start ifStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:425:1: ifStat returns [Object ret2] : ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) ) ;
    public final Object ifStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IfStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:2: ( ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:4: ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:4: ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:5: 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )
            {
            match(input,67,FOLLOW_67_in_ifStat2754); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_ifStat2756); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_ifStat2760);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "condition", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ifStat2764); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:77: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=NAME && LA67_0<=FLOAT)||LA67_0==LPAREN||LA67_0==SHARP||LA67_0==MINUS||LA67_0==67||LA67_0==69||(LA67_0>=71 && LA67_0<=73)||(LA67_0>=76 && LA67_0<=92)) ) {
                alt67=1;
            }
            else if ( (LA67_0==LCURLY) ) {
                alt67=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("426:77: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:78: ( ( (temp= statement ) ) )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:78: ( ( (temp= statement ) ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:79: ( (temp= statement ) )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:79: ( (temp= statement ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:80: (temp= statement )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:80: (temp= statement )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:81: temp= statement
                    {
                    pushFollow(FOLLOW_statement_in_ifStat2772);
                    temp=statement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "thenStatements", temp);
                    }

                    }


                    }


                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:142: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:142: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:143: LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
                    {
                    match(input,LCURLY,FOLLOW_LCURLY_in_ifStat2783); if (failed) return ret2;
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:150: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:151: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:151: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:152: ( (temp= statement ( (temp= statement ) )* ) )?
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:152: ( (temp= statement ( (temp= statement ) )* ) )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( ((LA66_0>=NAME && LA66_0<=FLOAT)||LA66_0==LPAREN||LA66_0==SHARP||LA66_0==MINUS||LA66_0==67||LA66_0==69||(LA66_0>=71 && LA66_0<=73)||(LA66_0>=76 && LA66_0<=92)) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:153: (temp= statement ( (temp= statement ) )* )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:153: (temp= statement ( (temp= statement ) )* )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:154: temp= statement ( (temp= statement ) )*
                            {
                            pushFollow(FOLLOW_statement_in_ifStat2791);
                            temp=statement();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "thenStatements", temp);
                            }
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:208: ( (temp= statement ) )*
                            loop65:
                            do {
                                int alt65=2;
                                int LA65_0 = input.LA(1);

                                if ( ((LA65_0>=NAME && LA65_0<=FLOAT)||LA65_0==LPAREN||LA65_0==SHARP||LA65_0==MINUS||LA65_0==67||LA65_0==69||(LA65_0>=71 && LA65_0<=73)||(LA65_0>=76 && LA65_0<=92)) ) {
                                    alt65=1;
                                }


                                switch (alt65) {
                            	case 1 :
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:209: (temp= statement )
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:209: (temp= statement )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:210: temp= statement
                            	    {
                            	    pushFollow(FOLLOW_statement_in_ifStat2799);
                            	    temp=statement();
                            	    _fsp--;
                            	    if (failed) return ret2;
                            	    if ( backtracking==0 ) {
                            	      ei.set(ret, "thenStatements", temp);
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop65;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_ifStat2811); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:284: ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==68) ) {
                int LA71_1 = input.LA(2);

                if ( (synpred130()) ) {
                    alt71=1;
                }
                else if ( (true) ) {
                    alt71=2;
                }
                //DEAD CODE
//                else {
//                    if (backtracking>0) {failed=true; return ret2;}
//                    NoViableAltException nvae =
//                        new NoViableAltException("426:284: ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )", 71, 1, input);
//
//                    throw nvae;
//                }
            }
            else if ( (LA71_0==EOF||(LA71_0>=NAME && LA71_0<=FLOAT)||LA71_0==LPAREN||LA71_0==RCURLY||LA71_0==SHARP||LA71_0==MINUS||LA71_0==67||LA71_0==69||(LA71_0>=71 && LA71_0<=73)||(LA71_0>=76 && LA71_0<=92)) ) {
                alt71=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("426:284: ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:285: ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:285: ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:286: 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
                    {
                    match(input,68,FOLLOW_68_in_ifStat2819); if (failed) return ret2;
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:293: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( ((LA70_0>=NAME && LA70_0<=FLOAT)||LA70_0==LPAREN||LA70_0==SHARP||LA70_0==MINUS||LA70_0==67||LA70_0==69||(LA70_0>=71 && LA70_0<=73)||(LA70_0>=76 && LA70_0<=92)) ) {
                        alt70=1;
                    }
                    else if ( (LA70_0==LCURLY) ) {
                        alt70=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("426:293: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )", 70, 0, input);

                        throw nvae;
                    }
                    switch (alt70) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:294: ( ( (temp= statement ) ) )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:294: ( ( (temp= statement ) ) )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:295: ( (temp= statement ) )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:295: ( (temp= statement ) )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:296: (temp= statement )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:296: (temp= statement )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:297: temp= statement
                            {
                            pushFollow(FOLLOW_statement_in_ifStat2827);
                            temp=statement();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "elseStatements", temp);
                            }

                            }


                            }


                            }

                            if ( backtracking==0 ) {
                            }

                            }
                            break;
                        case 2 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:358: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:358: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:359: LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
                            {
                            match(input,LCURLY,FOLLOW_LCURLY_in_ifStat2838); if (failed) return ret2;
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:366: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:367: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:367: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:368: ( (temp= statement ( (temp= statement ) )* ) )?
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:368: ( (temp= statement ( (temp= statement ) )* ) )?
                            int alt69=2;
                            int LA69_0 = input.LA(1);

                            if ( ((LA69_0>=NAME && LA69_0<=FLOAT)||LA69_0==LPAREN||LA69_0==SHARP||LA69_0==MINUS||LA69_0==67||LA69_0==69||(LA69_0>=71 && LA69_0<=73)||(LA69_0>=76 && LA69_0<=92)) ) {
                                alt69=1;
                            }
                            switch (alt69) {
                                case 1 :
                                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:369: (temp= statement ( (temp= statement ) )* )
                                    {
                                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:369: (temp= statement ( (temp= statement ) )* )
                                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:370: temp= statement ( (temp= statement ) )*
                                    {
                                    pushFollow(FOLLOW_statement_in_ifStat2846);
                                    temp=statement();
                                    _fsp--;
                                    if (failed) return ret2;
                                    if ( backtracking==0 ) {
                                      ei.set(ret, "elseStatements", temp);
                                    }
                                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:424: ( (temp= statement ) )*
                                    loop68:
                                    do {
                                        int alt68=2;
                                        int LA68_0 = input.LA(1);

                                        if ( ((LA68_0>=NAME && LA68_0<=FLOAT)||LA68_0==LPAREN||LA68_0==SHARP||LA68_0==MINUS||LA68_0==67||LA68_0==69||(LA68_0>=71 && LA68_0<=73)||(LA68_0>=76 && LA68_0<=92)) ) {
                                            alt68=1;
                                        }


                                        switch (alt68) {
                                    	case 1 :
                                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:425: (temp= statement )
                                    	    {
                                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:425: (temp= statement )
                                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:426: temp= statement
                                    	    {
                                    	    pushFollow(FOLLOW_statement_in_ifStat2854);
                                    	    temp=statement();
                                    	    _fsp--;
                                    	    if (failed) return ret2;
                                    	    if ( backtracking==0 ) {
                                    	      ei.set(ret, "elseStatements", temp);
                                    	    }

                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop68;
                                        }
                                    } while (true);


                                    }


                                    }
                                    break;

                            }


                            }


                            }

                            match(input,RCURLY,FOLLOW_RCURLY_in_ifStat2866); if (failed) return ret2;

                            }

                            if ( backtracking==0 ) {
                            }

                            }
                            break;

                    }


                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:505: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:505: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:506: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end ifStat


    // $ANTLR start forStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:436:1: forStat returns [Object ret2] : ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object forStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ForStat", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:2: ( ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:4: ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:4: ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:5: 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,69,FOLLOW_69_in_forStat2912); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_forStat2914); if (failed) return ret2;
            pushFollow(FOLLOW_iterator_in_forStat2918);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterator", temp);
            }
            match(input,61,FOLLOW_61_in_forStat2922); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_forStat2926);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "collection", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_forStat2930); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_forStat2932); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:138: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:139: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:139: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:140: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:140: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=NAME && LA73_0<=FLOAT)||LA73_0==LPAREN||LA73_0==SHARP||LA73_0==MINUS||LA73_0==67||LA73_0==69||(LA73_0>=71 && LA73_0<=73)||(LA73_0>=76 && LA73_0<=92)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:141: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:141: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:142: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_forStat2940);
                    temp=statement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "statements", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:192: ( (temp= statement ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( ((LA72_0>=NAME && LA72_0<=FLOAT)||LA72_0==LPAREN||LA72_0==SHARP||LA72_0==MINUS||LA72_0==67||LA72_0==69||(LA72_0>=71 && LA72_0<=73)||(LA72_0>=76 && LA72_0<=92)) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:193: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:193: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:437:194: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_forStat2948);
                    	    temp=statement();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "statements", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_forStat2960); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end forStat


    // $ANTLR start oclModel
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:447:1: oclModel returns [Object ret2] : (temp= identifier COLON temp= identifier ) ;
    public final Object oclModel() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OclModel", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:448:2: ( (temp= identifier COLON temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:448:4: (temp= identifier COLON temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:448:4: (temp= identifier COLON temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:448:5: temp= identifier COLON temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_oclModel2994);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_oclModel2998); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_oclModel3002);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.setRef(ret, "metamodel", "OclModel", "name", temp, "#all", "ifmissing", null, false, null);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end oclModel


    // $ANTLR start oclModelElement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:458:1: oclModelElement returns [Object ret2] : (temp= identifier EXCL temp= identifier ) ;
    public final Object oclModelElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OclModelElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:459:2: ( (temp= identifier EXCL temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:459:4: (temp= identifier EXCL temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:459:4: (temp= identifier EXCL temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:459:5: temp= identifier EXCL temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_oclModelElement3038);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.setRef(ret, "model", "OclModel", "name", temp, "#all", "ifmissing", null, false, null);
            }
            match(input,EXCL,FOLLOW_EXCL_in_oclModelElement3042); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_oclModelElement3046);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end oclModelElement


    // $ANTLR start oclExpression
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:469:1: oclExpression returns [Object ret2] : (ret= priority_5 | ret= letExp ) ;
    public final Object oclExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:470:2: ( (ret= priority_5 | ret= letExp ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:470:4: (ret= priority_5 | ret= letExp )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:470:4: (ret= priority_5 | ret= letExp )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=NAME && LA74_0<=FLOAT)||LA74_0==LPAREN||LA74_0==SHARP||LA74_0==MINUS||LA74_0==67||(LA74_0>=71 && LA74_0<=73)||LA74_0==76||(LA74_0>=78 && LA74_0<=92)) ) {
                alt74=1;
            }
            else if ( (LA74_0==77) ) {
                alt74=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("470:4: (ret= priority_5 | ret= letExp )", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:470:5: ret= priority_5
                    {
                    pushFollow(FOLLOW_priority_5_in_oclExpression3082);
                    ret=priority_5();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:470:21: ret= letExp
                    {
                    pushFollow(FOLLOW_letExp_in_oclExpression3087);
                    ret=letExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }

            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end oclExpression


    // $ANTLR start iteratorExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:477:1: iteratorExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN ) ;
    public final Object iteratorExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IteratorExp", true, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:2: ( (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:4: (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:4: (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:5: temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN
            {
            pushFollow(FOLLOW_identifier_in_iteratorExp3122);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_iteratorExp3126); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:57: ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:58: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:58: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:59: temp= iterator ( ( ( COMA ) temp= iterator ) )*
            {
            pushFollow(FOLLOW_iterator_in_iteratorExp3132);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterators", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:107: ( ( ( COMA ) temp= iterator ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==COMA) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:108: ( ( COMA ) temp= iterator )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:108: ( ( COMA ) temp= iterator )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:109: ( COMA ) temp= iterator
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:109: ( COMA )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:110: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_iteratorExp3139); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_iterator_in_iteratorExp3144);
            	    temp=iterator();
            	    _fsp--;
            	    if (failed) return ret2;
            	    if ( backtracking==0 ) {
            	      ei.set(ret, "iterators", temp);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);


            }


            }

            match(input,PIPE,FOLLOW_PIPE_in_iteratorExp3153); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:174: ( (temp= oclExpression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:175: (temp= oclExpression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:175: (temp= oclExpression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:478:176: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_iteratorExp3159);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "body", temp);
            }

            }


            }

            match(input,RPAREN,FOLLOW_RPAREN_in_iteratorExp3165); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          // discard operator name
                          ei.set(ret, "source", left);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ei.leaveContext(true);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end iteratorExp


    // $ANTLR start iterateExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:490:1: iterateExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN ) ;
    public final Object iterateExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IterateExp", true, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:2: ( ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:4: ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:4: ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:5: 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN
            {
            match(input,70,FOLLOW_70_in_iterateExp3198); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_iterateExp3200); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:22: ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:23: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:23: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:24: temp= iterator ( ( ( COMA ) temp= iterator ) )*
            {
            pushFollow(FOLLOW_iterator_in_iterateExp3206);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterators", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:72: ( ( ( COMA ) temp= iterator ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==COMA) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:73: ( ( COMA ) temp= iterator )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:73: ( ( COMA ) temp= iterator )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:74: ( COMA ) temp= iterator
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:74: ( COMA )
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:75: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_iterateExp3213); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_iterator_in_iterateExp3218);
            	    temp=iterator();
            	    _fsp--;
            	    if (failed) return ret2;
            	    if ( backtracking==0 ) {
            	      ei.set(ret, "iterators", temp);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            }


            }

            match(input,SEMI,FOLLOW_SEMI_in_iterateExp3227); if (failed) return ret2;
            pushFollow(FOLLOW_variableDeclaration_in_iterateExp3231);
            temp=variableDeclaration();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "result", temp);
            }
            match(input,PIPE,FOLLOW_PIPE_in_iterateExp3235); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:200: ( (temp= oclExpression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:201: (temp= oclExpression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:201: (temp= oclExpression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:491:202: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_iterateExp3241);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "body", temp);
            }

            }


            }

            match(input,RPAREN,FOLLOW_RPAREN_in_iterateExp3247); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          // discard operator name
                          ei.set(ret, "source", left);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ei.leaveContext(true);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end iterateExp


    // $ANTLR start collectionOperationCallExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:503:1: collectionOperationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) ;
    public final Object collectionOperationCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CollectionOperationCallExp", false, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:2: ( (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:4: (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:4: (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:5: temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifier_in_collectionOperationCallExp3282);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "operationName", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_collectionOperationCallExp3286); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:66: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=NAME && LA78_0<=FLOAT)||LA78_0==LPAREN||LA78_0==SHARP||LA78_0==MINUS||LA78_0==67||(LA78_0>=71 && LA78_0<=73)||(LA78_0>=76 && LA78_0<=92)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:67: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:67: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:68: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_collectionOperationCallExp3292);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "arguments", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:121: ( ( ( COMA ) temp= oclExpression ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==COMA) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:122: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:122: ( ( COMA ) temp= oclExpression )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:123: ( COMA ) temp= oclExpression
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:123: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:504:124: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_collectionOperationCallExp3299); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_collectionOperationCallExp3304);
                    	    temp=oclExpression();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "arguments", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_collectionOperationCallExp3314); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          // discard operator name
                          ei.set(ret, "source", left);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ei.leaveContext(false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end collectionOperationCallExp


    // $ANTLR start operationCallExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:516:1: operationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) ;
    public final Object operationCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OperationCallExp", false, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:2: ( (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:4: (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:4: (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:5: temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_operationCallExp3349);
            temp=identifierOrKeyword();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "operationName", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_operationCallExp3353); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:75: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=NAME && LA80_0<=FLOAT)||LA80_0==LPAREN||LA80_0==SHARP||LA80_0==MINUS||LA80_0==67||(LA80_0>=71 && LA80_0<=73)||(LA80_0>=76 && LA80_0<=92)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:76: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:76: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:77: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_operationCallExp3359);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "arguments", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:130: ( ( ( COMA ) temp= oclExpression ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==COMA) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:131: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:131: ( ( COMA ) temp= oclExpression )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:132: ( COMA ) temp= oclExpression
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:132: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:517:133: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_operationCallExp3366); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_operationCallExp3371);
                    	    temp=oclExpression();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "arguments", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_operationCallExp3381); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          // discard operator name
                          ei.set(ret, "source", left);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ei.leaveContext(false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end operationCallExp


    // $ANTLR start navigationOrAttributeCallExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:529:1: navigationOrAttributeCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword ) ;
    public final Object navigationOrAttributeCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("NavigationOrAttributeCallExp", false, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:530:2: ( (temp= identifierOrKeyword ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:530:4: (temp= identifierOrKeyword )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:530:4: (temp= identifierOrKeyword )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:530:5: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_navigationOrAttributeCallExp3416);
            temp=identifierOrKeyword();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }

            }

            if ( backtracking==0 ) {

                          // discard operator name
                          ei.set(ret, "source", left);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ei.leaveContext(false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end navigationOrAttributeCallExp


    // $ANTLR start operatorCallExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:542:1: operatorCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object operatorCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OperatorCallExp", false, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:543:2: ()
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:544:9: 
            {
            if ( backtracking==0 ) {

                          ei.set(ret, "operationName", opName);
                          ei.set(ret, "source", left);
                          // post actions performed in calling rule (i.e., priority_<n>)
                          ei.leaveContext(false);
                          ret2=ret;
                      
            }

            }

        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end operatorCallExp


    // $ANTLR start iterator
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:554:1: iterator returns [Object ret2] : (temp= identifier ) ;
    public final Object iterator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Iterator", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:555:2: ( (temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:555:4: (temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:555:4: (temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:555:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_iterator3481);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end iterator


    // $ANTLR start oclUndefinedExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:565:1: oclUndefinedExp returns [Object ret2] : ( 'OclUndefined' ) ;
    public final Object oclUndefinedExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclUndefinedExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:566:2: ( ( 'OclUndefined' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:566:4: ( 'OclUndefined' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:566:4: ( 'OclUndefined' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:566:5: 'OclUndefined'
            {
            match(input,71,FOLLOW_71_in_oclUndefinedExp3515); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end oclUndefinedExp


    // $ANTLR start primitiveExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:576:1: primitiveExp returns [Object ret2] : ( (ret= numericExp | ret= booleanExp | ret= stringExp ) ) ;
    public final Object primitiveExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:577:2: ( ( (ret= numericExp | ret= booleanExp | ret= stringExp ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:577:4: ( (ret= numericExp | ret= booleanExp | ret= stringExp ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:577:4: ( (ret= numericExp | ret= booleanExp | ret= stringExp ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:577:5: (ret= numericExp | ret= booleanExp | ret= stringExp )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:577:5: (ret= numericExp | ret= booleanExp | ret= stringExp )
            int alt81=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
                {
                alt81=1;
                }
                break;
            case 72:
            case 73:
                {
                alt81=2;
                }
                break;
            case STRING:
                {
                alt81=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("577:5: (ret= numericExp | ret= booleanExp | ret= stringExp )", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:577:6: ret= numericExp
                    {
                    pushFollow(FOLLOW_numericExp_in_primitiveExp3550);
                    ret=numericExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:577:22: ret= booleanExp
                    {
                    pushFollow(FOLLOW_booleanExp_in_primitiveExp3555);
                    ret=booleanExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:577:38: ret= stringExp
                    {
                    pushFollow(FOLLOW_stringExp_in_primitiveExp3560);
                    ret=stringExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end primitiveExp


    // $ANTLR start numericExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:585:1: numericExp returns [Object ret2] : ( (ret= integerExp | ret= realExp ) ) ;
    public final Object numericExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:586:2: ( ( (ret= integerExp | ret= realExp ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:586:4: ( (ret= integerExp | ret= realExp ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:586:4: ( (ret= integerExp | ret= realExp ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:586:5: (ret= integerExp | ret= realExp )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:586:5: (ret= integerExp | ret= realExp )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==INT) ) {
                alt82=1;
            }
            else if ( (LA82_0==FLOAT) ) {
                alt82=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("586:5: (ret= integerExp | ret= realExp )", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:586:6: ret= integerExp
                    {
                    pushFollow(FOLLOW_integerExp_in_numericExp3596);
                    ret=integerExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:586:22: ret= realExp
                    {
                    pushFollow(FOLLOW_realExp_in_numericExp3601);
                    ret=realExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end numericExp


    // $ANTLR start booleanExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:594:1: booleanExp returns [Object ret2] : ( ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object booleanExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("BooleanExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:2: ( ( ( ( 'true' ) | ( 'false' ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:4: ( ( ( 'true' ) | ( 'false' ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:4: ( ( ( 'true' ) | ( 'false' ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:5: ( ( 'true' ) | ( 'false' ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:5: ( ( 'true' ) | ( 'false' ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==72) ) {
                alt83=1;
            }
            else if ( (LA83_0==73) ) {
                alt83=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("595:5: ( ( 'true' ) | ( 'false' ) )", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:6: ( 'true' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:6: ( 'true' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:7: 'true'
                    {
                    match(input,72,FOLLOW_72_in_booleanExp3636); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "booleanSymbol", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:72: ( 'false' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:72: ( 'false' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:595:73: 'false'
                    {
                    match(input,73,FOLLOW_73_in_booleanExp3643); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "booleanSymbol", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end booleanExp


    // $ANTLR start integerExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:605:1: integerExp returns [Object ret2] : (temp= integerSymbol ) ;
    public final Object integerExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IntegerExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:606:2: ( (temp= integerSymbol ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:606:4: (temp= integerSymbol )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:606:4: (temp= integerSymbol )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:606:5: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_integerExp3681);
            temp=integerSymbol();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "integerSymbol", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end integerExp


    // $ANTLR start realExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:616:1: realExp returns [Object ret2] : (temp= floatSymbol ) ;
    public final Object realExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("RealExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:617:2: ( (temp= floatSymbol ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:617:4: (temp= floatSymbol )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:617:4: (temp= floatSymbol )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:617:5: temp= floatSymbol
            {
            pushFollow(FOLLOW_floatSymbol_in_realExp3717);
            temp=floatSymbol();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "realSymbol", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end realExp


    // $ANTLR start stringExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:627:1: stringExp returns [Object ret2] : (temp= stringSymbol ) ;
    public final Object stringExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("StringExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:628:2: ( (temp= stringSymbol ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:628:4: (temp= stringSymbol )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:628:4: (temp= stringSymbol )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:628:5: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_stringExp3753);
            temp=stringSymbol();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "stringSymbol", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end stringExp


    // $ANTLR start ifExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:638:1: ifExp returns [Object ret2] : ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' ) ;
    public final Object ifExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IfExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:2: ( ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:4: ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:4: ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:5: 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif'
            {
            match(input,67,FOLLOW_67_in_ifExp3787); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_ifExp3791);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "condition", temp);
            }
            match(input,74,FOLLOW_74_in_ifExp3795); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:70: ( (temp= oclExpression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:71: (temp= oclExpression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:71: (temp= oclExpression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:72: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_ifExp3801);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "thenExpression", temp);
            }

            }


            }

            match(input,68,FOLLOW_68_in_ifExp3807); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:139: ( (temp= oclExpression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:140: (temp= oclExpression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:140: (temp= oclExpression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:639:141: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_ifExp3813);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elseExpression", temp);
            }

            }


            }

            match(input,75,FOLLOW_75_in_ifExp3819); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end ifExp


    // $ANTLR start variableExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:649:1: variableExp returns [Object ret2] : (temp= identifier ) ;
    public final Object variableExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:650:2: ( (temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:650:4: (temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:650:4: (temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:650:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_variableExp3853);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.setRef(ret, "referredVariable", "VariableDeclaration", "varName", temp, null, "ifmissing", null, false, null);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end variableExp


    // $ANTLR start superExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:660:1: superExp returns [Object ret2] : ( 'super' ) ;
    public final Object superExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("SuperExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:661:2: ( ( 'super' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:661:4: ( 'super' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:661:4: ( 'super' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:661:5: 'super'
            {
            match(input,76,FOLLOW_76_in_superExp3887); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end superExp


    // $ANTLR start letExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:671:1: letExp returns [Object ret2] : ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) ) ;
    public final Object letExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LetExp", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:672:2: ( ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:672:4: ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:672:4: ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:672:5: 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) )
            {
            match(input,77,FOLLOW_77_in_letExp3919); if (failed) return ret2;
            pushFollow(FOLLOW_variableDeclaration_in_letExp3923);
            temp=variableDeclaration();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "variable", temp);
            }
            match(input,61,FOLLOW_61_in_letExp3927); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:672:74: ( (temp= oclExpression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:672:75: (temp= oclExpression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:672:75: (temp= oclExpression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:672:76: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_letExp3933);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "in_", temp);
            }

            }


            }


            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end letExp


    // $ANTLR start variableDeclaration
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:682:1: variableDeclaration returns [Object ret2] : (temp= identifier COLON temp= oclType EQ temp= oclExpression ) ;
    public final Object variableDeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:683:2: ( (temp= identifier COLON temp= oclType EQ temp= oclExpression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:683:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:683:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:683:5: temp= identifier COLON temp= oclType EQ temp= oclExpression
            {
            pushFollow(FOLLOW_identifier_in_variableDeclaration3971);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_variableDeclaration3975); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_variableDeclaration3979);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_variableDeclaration3983); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_variableDeclaration3987);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "initExpression", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end variableDeclaration


    // $ANTLR start enumLiteralExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:693:1: enumLiteralExp returns [Object ret2] : ( SHARP temp= identifier ) ;
    public final Object enumLiteralExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("EnumLiteralExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:694:2: ( ( SHARP temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:694:4: ( SHARP temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:694:4: ( SHARP temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:694:5: SHARP temp= identifier
            {
            match(input,SHARP,FOLLOW_SHARP_in_enumLiteralExp4021); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_enumLiteralExp4025);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end enumLiteralExp


    // $ANTLR start collectionExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:704:1: collectionExp returns [Object ret2] : ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) ) ;
    public final Object collectionExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:705:2: ( ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:705:4: ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:705:4: ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:705:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:705:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )
            int alt84=4;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt84=1;
                }
                break;
            case 79:
                {
                alt84=2;
                }
                break;
            case 80:
                {
                alt84=3;
                }
                break;
            case 81:
                {
                alt84=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("705:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:705:6: ret= bagExp
                    {
                    pushFollow(FOLLOW_bagExp_in_collectionExp4062);
                    ret=bagExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:705:18: ret= setExp
                    {
                    pushFollow(FOLLOW_setExp_in_collectionExp4067);
                    ret=setExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:705:30: ret= orderedSetExp
                    {
                    pushFollow(FOLLOW_orderedSetExp_in_collectionExp4072);
                    ret=orderedSetExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:705:49: ret= sequenceExp
                    {
                    pushFollow(FOLLOW_sequenceExp_in_collectionExp4077);
                    ret=sequenceExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end collectionExp


    // $ANTLR start bagExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:713:1: bagExp returns [Object ret2] : ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object bagExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BagExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:2: ( ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:4: ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:4: ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:5: 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,78,FOLLOW_78_in_bagExp4110); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_bagExp4112); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:18: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( ((LA86_0>=NAME && LA86_0<=FLOAT)||LA86_0==LPAREN||LA86_0==SHARP||LA86_0==MINUS||LA86_0==67||(LA86_0>=71 && LA86_0<=73)||(LA86_0>=76 && LA86_0<=92)) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:20: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_bagExp4118);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:72: ( ( ( COMA ) temp= oclExpression ) )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==COMA) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:73: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:73: ( ( COMA ) temp= oclExpression )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:74: ( COMA ) temp= oclExpression
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:74: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:714:75: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_bagExp4125); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_bagExp4130);
                    	    temp=oclExpression();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "elements", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop85;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_bagExp4140); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end bagExp


    // $ANTLR start setExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:724:1: setExp returns [Object ret2] : ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object setExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SetExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:2: ( ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:4: ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:4: ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:5: 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,79,FOLLOW_79_in_setExp4172); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_setExp4174); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:18: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( ((LA88_0>=NAME && LA88_0<=FLOAT)||LA88_0==LPAREN||LA88_0==SHARP||LA88_0==MINUS||LA88_0==67||(LA88_0>=71 && LA88_0<=73)||(LA88_0>=76 && LA88_0<=92)) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:20: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_setExp4180);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:72: ( ( ( COMA ) temp= oclExpression ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==COMA) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:73: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:73: ( ( COMA ) temp= oclExpression )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:74: ( COMA ) temp= oclExpression
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:74: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:725:75: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_setExp4187); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_setExp4192);
                    	    temp=oclExpression();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "elements", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop87;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_setExp4202); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end setExp


    // $ANTLR start orderedSetExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:735:1: orderedSetExp returns [Object ret2] : ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object orderedSetExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OrderedSetExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:2: ( ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:4: ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:4: ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:5: 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,80,FOLLOW_80_in_orderedSetExp4234); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_orderedSetExp4236); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:25: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=NAME && LA90_0<=FLOAT)||LA90_0==LPAREN||LA90_0==SHARP||LA90_0==MINUS||LA90_0==67||(LA90_0>=71 && LA90_0<=73)||(LA90_0>=76 && LA90_0<=92)) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:26: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:26: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:27: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_orderedSetExp4242);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:79: ( ( ( COMA ) temp= oclExpression ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==COMA) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:80: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:80: ( ( COMA ) temp= oclExpression )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:81: ( COMA ) temp= oclExpression
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:81: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:736:82: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_orderedSetExp4249); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_orderedSetExp4254);
                    	    temp=oclExpression();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "elements", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop89;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_orderedSetExp4264); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end orderedSetExp


    // $ANTLR start sequenceExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:746:1: sequenceExp returns [Object ret2] : ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object sequenceExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SequenceExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:2: ( ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:4: ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:4: ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:5: 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,81,FOLLOW_81_in_sequenceExp4296); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_sequenceExp4298); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:23: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( ((LA92_0>=NAME && LA92_0<=FLOAT)||LA92_0==LPAREN||LA92_0==SHARP||LA92_0==MINUS||LA92_0==67||(LA92_0>=71 && LA92_0<=73)||(LA92_0>=76 && LA92_0<=92)) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:24: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:24: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:25: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_sequenceExp4304);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:77: ( ( ( COMA ) temp= oclExpression ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==COMA) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:78: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:78: ( ( COMA ) temp= oclExpression )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:79: ( COMA ) temp= oclExpression
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:79: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:747:80: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_sequenceExp4311); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_sequenceExp4316);
                    	    temp=oclExpression();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "elements", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop91;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_sequenceExp4326); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end sequenceExp


    // $ANTLR start mapExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:757:1: mapExp returns [Object ret2] : ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY ) ;
    public final Object mapExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:2: ( ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:4: ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:4: ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:5: 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY
            {
            match(input,82,FOLLOW_82_in_mapExp4358); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_mapExp4360); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:18: ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==LPAREN) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:19: (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:19: (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:20: temp= mapElement ( ( ( COMA ) temp= mapElement ) )*
                    {
                    pushFollow(FOLLOW_mapElement_in_mapExp4366);
                    temp=mapElement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:69: ( ( ( COMA ) temp= mapElement ) )*
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==COMA) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:70: ( ( COMA ) temp= mapElement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:70: ( ( COMA ) temp= mapElement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:71: ( COMA ) temp= mapElement
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:71: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:758:72: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_mapExp4373); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_mapElement_in_mapExp4378);
                    	    temp=mapElement();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "elements", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop93;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_mapExp4388); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end mapExp


    // $ANTLR start mapElement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:768:1: mapElement returns [Object ret2] : ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN ) ;
    public final Object mapElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:769:2: ( ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:769:4: ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:769:4: ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:769:5: LPAREN temp= oclExpression COMA temp= oclExpression RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_mapElement4420); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_mapElement4424);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "key", temp);
            }
            match(input,COMA,FOLLOW_COMA_in_mapElement4428); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_mapElement4432);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "value", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_mapElement4436); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end mapElement


    // $ANTLR start tupleExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:779:1: tupleExp returns [Object ret2] : ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY ) ;
    public final Object tupleExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:2: ( ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:4: ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:4: ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:5: 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY
            {
            match(input,83,FOLLOW_83_in_tupleExp4468); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_tupleExp4470); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:20: ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==NAME||(LA96_0>=42 && LA96_0<=98)) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:21: (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:21: (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:22: temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )*
                    {
                    pushFollow(FOLLOW_tuplePart_in_tupleExp4476);
                    temp=tuplePart();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "tuplePart", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:71: ( ( ( COMA ) temp= tuplePart ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==COMA) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:72: ( ( COMA ) temp= tuplePart )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:72: ( ( COMA ) temp= tuplePart )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:73: ( COMA ) temp= tuplePart
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:73: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:780:74: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_tupleExp4483); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_tuplePart_in_tupleExp4488);
                    	    temp=tuplePart();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "tuplePart", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop95;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_tupleExp4498); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end tupleExp


    // $ANTLR start tuplePart
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:790:1: tuplePart returns [Object ret2] : (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression ) ;
    public final Object tuplePart() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TuplePart", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:2: ( (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:4: (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:4: (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:5: temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tuplePart4532);
            temp=identifierOrKeyword();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:62: ( ( COLON temp= oclType ) | () )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==COLON) ) {
                alt97=1;
            }
            else if ( (LA97_0==EQ) ) {
                alt97=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("791:62: ( ( COLON temp= oclType ) | () )", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:63: ( COLON temp= oclType )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:63: ( COLON temp= oclType )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:64: COLON temp= oclType
                    {
                    match(input,COLON,FOLLOW_COLON_in_tuplePart4538); if (failed) return ret2;
                    pushFollow(FOLLOW_oclType_in_tuplePart4542);
                    temp=oclType();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "type", temp);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:117: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:117: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:791:118: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            match(input,EQ,FOLLOW_EQ_in_tuplePart4556); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_tuplePart4560);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "initExpression", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end tuplePart


    // $ANTLR start oclType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:801:1: oclType returns [Object ret2] : ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) ) ;
    public final Object oclType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:2: ( ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:4: ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:4: ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:5: (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:5: (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )
            int alt98=7;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt98=1;
                }
                break;
            case 85:
                {
                alt98=2;
                }
                break;
            case 86:
                {
                alt98=3;
                }
                break;
            case 82:
                {
                alt98=4;
                }
                break;
            case 87:
            case 88:
            case 89:
            case 90:
                {
                alt98=5;
                }
                break;
            case 78:
            case 79:
            case 80:
            case 81:
            case 91:
                {
                alt98=6;
                }
                break;
            case 84:
                {
                alt98=7;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("802:5: (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:6: ret= oclModelElement
                    {
                    pushFollow(FOLLOW_oclModelElement_in_oclType4597);
                    ret=oclModelElement();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:27: ret= oclAnyType
                    {
                    pushFollow(FOLLOW_oclAnyType_in_oclType4602);
                    ret=oclAnyType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:43: ret= tupleType
                    {
                    pushFollow(FOLLOW_tupleType_in_oclType4607);
                    ret=tupleType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:58: ret= mapType
                    {
                    pushFollow(FOLLOW_mapType_in_oclType4612);
                    ret=mapType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:71: ret= primitive
                    {
                    pushFollow(FOLLOW_primitive_in_oclType4617);
                    ret=primitive();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 6 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:86: ret= collectionType
                    {
                    pushFollow(FOLLOW_collectionType_in_oclType4622);
                    ret=collectionType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 7 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:802:106: ret= oclType_abstractContents
                    {
                    pushFollow(FOLLOW_oclType_abstractContents_in_oclType4627);
                    ret=oclType_abstractContents();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end oclType


    // $ANTLR start oclAnyType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:810:1: oclAnyType returns [Object ret2] : ( 'OclAny' ) ;
    public final Object oclAnyType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclAnyType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:811:2: ( ( 'OclAny' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:811:4: ( 'OclAny' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:811:4: ( 'OclAny' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:811:5: 'OclAny'
            {
            match(input,85,FOLLOW_85_in_oclAnyType4660); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end oclAnyType


    // $ANTLR start tupleType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:821:1: tupleType returns [Object ret2] : ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN ) ;
    public final Object tupleType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:2: ( ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:4: ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:4: ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:5: 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN
            {
            match(input,86,FOLLOW_86_in_tupleType4692); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_tupleType4694); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:24: ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==NAME) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:25: (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:25: (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:26: temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )*
                    {
                    pushFollow(FOLLOW_tupleTypeAttribute_in_tupleType4700);
                    temp=tupleTypeAttribute();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "attributes", temp);
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:85: ( ( ( COMA ) temp= tupleTypeAttribute ) )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==COMA) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:86: ( ( COMA ) temp= tupleTypeAttribute )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:86: ( ( COMA ) temp= tupleTypeAttribute )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:87: ( COMA ) temp= tupleTypeAttribute
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:87: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:822:88: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_tupleType4707); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_tupleTypeAttribute_in_tupleType4712);
                    	    temp=tupleTypeAttribute();
                    	    _fsp--;
                    	    if (failed) return ret2;
                    	    if ( backtracking==0 ) {
                    	      ei.set(ret, "attributes", temp);
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop99;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_tupleType4722); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end tupleType


    // $ANTLR start tupleTypeAttribute
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:832:1: tupleTypeAttribute returns [Object ret2] : (temp= identifier COLON temp= oclType ) ;
    public final Object tupleTypeAttribute() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleTypeAttribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:833:2: ( (temp= identifier COLON temp= oclType ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:833:4: (temp= identifier COLON temp= oclType )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:833:4: (temp= identifier COLON temp= oclType )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:833:5: temp= identifier COLON temp= oclType
            {
            pushFollow(FOLLOW_identifier_in_tupleTypeAttribute4756);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_tupleTypeAttribute4760); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_tupleTypeAttribute4764);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end tupleTypeAttribute


    // $ANTLR start mapType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:843:1: mapType returns [Object ret2] : ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN ) ;
    public final Object mapType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:844:2: ( ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:844:4: ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:844:4: ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:844:5: 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN
            {
            match(input,82,FOLLOW_82_in_mapType4798); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_mapType4800); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_mapType4804);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "keyType", temp);
            }
            match(input,COMA,FOLLOW_COMA_in_mapType4808); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_mapType4812);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "valueType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_mapType4816); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end mapType


    // $ANTLR start primitive
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:854:1: primitive returns [Object ret2] : ( (ret= numericType | ret= booleanType | ret= stringType ) ) ;
    public final Object primitive() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:855:2: ( ( (ret= numericType | ret= booleanType | ret= stringType ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:855:4: ( (ret= numericType | ret= booleanType | ret= stringType ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:855:4: ( (ret= numericType | ret= booleanType | ret= stringType ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:855:5: (ret= numericType | ret= booleanType | ret= stringType )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:855:5: (ret= numericType | ret= booleanType | ret= stringType )
            int alt101=3;
            switch ( input.LA(1) ) {
            case 87:
            case 88:
                {
                alt101=1;
                }
                break;
            case 89:
                {
                alt101=2;
                }
                break;
            case 90:
                {
                alt101=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("855:5: (ret= numericType | ret= booleanType | ret= stringType )", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:855:6: ret= numericType
                    {
                    pushFollow(FOLLOW_numericType_in_primitive4851);
                    ret=numericType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:855:23: ret= booleanType
                    {
                    pushFollow(FOLLOW_booleanType_in_primitive4856);
                    ret=booleanType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:855:40: ret= stringType
                    {
                    pushFollow(FOLLOW_stringType_in_primitive4861);
                    ret=stringType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end primitive


    // $ANTLR start numericType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:863:1: numericType returns [Object ret2] : ( (ret= integerType | ret= realType ) ) ;
    public final Object numericType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:864:2: ( ( (ret= integerType | ret= realType ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:864:4: ( (ret= integerType | ret= realType ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:864:4: ( (ret= integerType | ret= realType ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:864:5: (ret= integerType | ret= realType )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:864:5: (ret= integerType | ret= realType )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==87) ) {
                alt102=1;
            }
            else if ( (LA102_0==88) ) {
                alt102=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("864:5: (ret= integerType | ret= realType )", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:864:6: ret= integerType
                    {
                    pushFollow(FOLLOW_integerType_in_numericType4897);
                    ret=integerType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:864:23: ret= realType
                    {
                    pushFollow(FOLLOW_realType_in_numericType4902);
                    ret=realType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end numericType


    // $ANTLR start integerType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:872:1: integerType returns [Object ret2] : ( 'Integer' ) ;
    public final Object integerType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("IntegerType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:873:2: ( ( 'Integer' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:873:4: ( 'Integer' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:873:4: ( 'Integer' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:873:5: 'Integer'
            {
            match(input,87,FOLLOW_87_in_integerType4935); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end integerType


    // $ANTLR start realType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:883:1: realType returns [Object ret2] : ( 'Real' ) ;
    public final Object realType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("RealType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:884:2: ( ( 'Real' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:884:4: ( 'Real' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:884:4: ( 'Real' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:884:5: 'Real'
            {
            match(input,88,FOLLOW_88_in_realType4967); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end realType


    // $ANTLR start booleanType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:894:1: booleanType returns [Object ret2] : ( 'Boolean' ) ;
    public final Object booleanType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("BooleanType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:895:2: ( ( 'Boolean' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:895:4: ( 'Boolean' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:895:4: ( 'Boolean' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:895:5: 'Boolean'
            {
            match(input,89,FOLLOW_89_in_booleanType4999); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end booleanType


    // $ANTLR start stringType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:905:1: stringType returns [Object ret2] : ( 'String' ) ;
    public final Object stringType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("StringType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:906:2: ( ( 'String' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:906:4: ( 'String' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:906:4: ( 'String' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:906:5: 'String'
            {
            match(input,90,FOLLOW_90_in_stringType5031); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end stringType


    // $ANTLR start collectionType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:916:1: collectionType returns [Object ret2] : ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) ) ;
    public final Object collectionType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:917:2: ( ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:917:4: ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:917:4: ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:917:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:917:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )
            int alt103=5;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt103=1;
                }
                break;
            case 79:
                {
                alt103=2;
                }
                break;
            case 80:
                {
                alt103=3;
                }
                break;
            case 81:
                {
                alt103=4;
                }
                break;
            case 91:
                {
                alt103=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("917:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:917:6: ret= bagType
                    {
                    pushFollow(FOLLOW_bagType_in_collectionType5066);
                    ret=bagType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:917:19: ret= setType
                    {
                    pushFollow(FOLLOW_setType_in_collectionType5071);
                    ret=setType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:917:32: ret= orderedSetType
                    {
                    pushFollow(FOLLOW_orderedSetType_in_collectionType5076);
                    ret=orderedSetType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:917:52: ret= sequenceType
                    {
                    pushFollow(FOLLOW_sequenceType_in_collectionType5081);
                    ret=sequenceType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:917:70: ret= collectionType_abstractContents
                    {
                    pushFollow(FOLLOW_collectionType_abstractContents_in_collectionType5086);
                    ret=collectionType_abstractContents();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {

                          ei.addToContext(ret, false);
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end collectionType


    // $ANTLR start bagType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:925:1: bagType returns [Object ret2] : ( 'Bag' LPAREN temp= oclType RPAREN ) ;
    public final Object bagType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BagType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:926:2: ( ( 'Bag' LPAREN temp= oclType RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:926:4: ( 'Bag' LPAREN temp= oclType RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:926:4: ( 'Bag' LPAREN temp= oclType RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:926:5: 'Bag' LPAREN temp= oclType RPAREN
            {
            match(input,78,FOLLOW_78_in_bagType5119); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_bagType5121); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_bagType5125);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_bagType5129); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end bagType


    // $ANTLR start setType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:936:1: setType returns [Object ret2] : ( 'Set' LPAREN temp= oclType RPAREN ) ;
    public final Object setType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SetType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:937:2: ( ( 'Set' LPAREN temp= oclType RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:937:4: ( 'Set' LPAREN temp= oclType RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:937:4: ( 'Set' LPAREN temp= oclType RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:937:5: 'Set' LPAREN temp= oclType RPAREN
            {
            match(input,79,FOLLOW_79_in_setType5161); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_setType5163); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_setType5167);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_setType5171); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end setType


    // $ANTLR start orderedSetType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:947:1: orderedSetType returns [Object ret2] : ( 'OrderedSet' LPAREN temp= oclType RPAREN ) ;
    public final Object orderedSetType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OrderedSetType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:948:2: ( ( 'OrderedSet' LPAREN temp= oclType RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:948:4: ( 'OrderedSet' LPAREN temp= oclType RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:948:4: ( 'OrderedSet' LPAREN temp= oclType RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:948:5: 'OrderedSet' LPAREN temp= oclType RPAREN
            {
            match(input,80,FOLLOW_80_in_orderedSetType5203); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_orderedSetType5205); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_orderedSetType5209);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_orderedSetType5213); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end orderedSetType


    // $ANTLR start sequenceType
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:958:1: sequenceType returns [Object ret2] : ( 'Sequence' LPAREN temp= oclType RPAREN ) ;
    public final Object sequenceType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SequenceType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:959:2: ( ( 'Sequence' LPAREN temp= oclType RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:959:4: ( 'Sequence' LPAREN temp= oclType RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:959:4: ( 'Sequence' LPAREN temp= oclType RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:959:5: 'Sequence' LPAREN temp= oclType RPAREN
            {
            match(input,81,FOLLOW_81_in_sequenceType5245); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_sequenceType5247); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_sequenceType5251);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_sequenceType5255); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end sequenceType


    // $ANTLR start priority_0
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:969:1: priority_0 returns [Object ret2] : (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:2: ( (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:4: (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:4: (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:5: ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_oclExpression_in_priority_05289);
            ret=primary_oclExpression();
            _fsp--;
            if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:31: ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==RARROW||LA107_0==POINT) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )
            	    int alt106=2;
            	    int LA106_0 = input.LA(1);

            	    if ( (LA106_0==POINT) ) {
            	        alt106=1;
            	    }
            	    else if ( (LA106_0==RARROW) ) {
            	        alt106=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("970:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )", 106, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt106) {
            	        case 1 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:33: ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:33: ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:34: POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )
            	            {
            	            match(input,POINT,FOLLOW_POINT_in_priority_05294); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = ".";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )
            	            int alt104=2;
            	            switch ( input.LA(1) ) {
            	            case NAME:
            	                {
            	                int LA104_1 = input.LA(2);

            	                if ( (LA104_1==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_1==EOF||(LA104_1>=SEMI && LA104_1<=EQ)||LA104_1==RPAREN||(LA104_1>=RCURLY && LA104_1<=LARROW)||LA104_1==PIPE||(LA104_1>=POINT && LA104_1<=NE)||LA104_1==61||LA104_1==68||(LA104_1>=74 && LA104_1<=75)||(LA104_1>=93 && LA104_1<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 1, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 42:
            	                {
            	                int LA104_2 = input.LA(2);

            	                if ( (LA104_2==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_2==EOF||(LA104_2>=SEMI && LA104_2<=EQ)||LA104_2==RPAREN||(LA104_2>=RCURLY && LA104_2<=LARROW)||LA104_2==PIPE||(LA104_2>=POINT && LA104_2<=NE)||LA104_2==61||LA104_2==68||(LA104_2>=74 && LA104_2<=75)||(LA104_2>=93 && LA104_2<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 2, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 43:
            	                {
            	                int LA104_3 = input.LA(2);

            	                if ( (LA104_3==EOF||(LA104_3>=SEMI && LA104_3<=EQ)||LA104_3==RPAREN||(LA104_3>=RCURLY && LA104_3<=LARROW)||LA104_3==PIPE||(LA104_3>=POINT && LA104_3<=NE)||LA104_3==61||LA104_3==68||(LA104_3>=74 && LA104_3<=75)||(LA104_3>=93 && LA104_3<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_3==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 3, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 44:
            	                {
            	                int LA104_4 = input.LA(2);

            	                if ( (LA104_4==EOF||(LA104_4>=SEMI && LA104_4<=EQ)||LA104_4==RPAREN||(LA104_4>=RCURLY && LA104_4<=LARROW)||LA104_4==PIPE||(LA104_4>=POINT && LA104_4<=NE)||LA104_4==61||LA104_4==68||(LA104_4>=74 && LA104_4<=75)||(LA104_4>=93 && LA104_4<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_4==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 4, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 45:
            	                {
            	                int LA104_5 = input.LA(2);

            	                if ( (LA104_5==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_5==EOF||(LA104_5>=SEMI && LA104_5<=EQ)||LA104_5==RPAREN||(LA104_5>=RCURLY && LA104_5<=LARROW)||LA104_5==PIPE||(LA104_5>=POINT && LA104_5<=NE)||LA104_5==61||LA104_5==68||(LA104_5>=74 && LA104_5<=75)||(LA104_5>=93 && LA104_5<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 5, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 46:
            	                {
            	                int LA104_6 = input.LA(2);

            	                if ( (LA104_6==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_6==EOF||(LA104_6>=SEMI && LA104_6<=EQ)||LA104_6==RPAREN||(LA104_6>=RCURLY && LA104_6<=LARROW)||LA104_6==PIPE||(LA104_6>=POINT && LA104_6<=NE)||LA104_6==61||LA104_6==68||(LA104_6>=74 && LA104_6<=75)||(LA104_6>=93 && LA104_6<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 6, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 47:
            	                {
            	                int LA104_7 = input.LA(2);

            	                if ( (LA104_7==EOF||(LA104_7>=SEMI && LA104_7<=EQ)||LA104_7==RPAREN||(LA104_7>=RCURLY && LA104_7<=LARROW)||LA104_7==PIPE||(LA104_7>=POINT && LA104_7<=NE)||LA104_7==61||LA104_7==68||(LA104_7>=74 && LA104_7<=75)||(LA104_7>=93 && LA104_7<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_7==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 7, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 48:
            	                {
            	                int LA104_8 = input.LA(2);

            	                if ( (LA104_8==EOF||(LA104_8>=SEMI && LA104_8<=EQ)||LA104_8==RPAREN||(LA104_8>=RCURLY && LA104_8<=LARROW)||LA104_8==PIPE||(LA104_8>=POINT && LA104_8<=NE)||LA104_8==61||LA104_8==68||(LA104_8>=74 && LA104_8<=75)||(LA104_8>=93 && LA104_8<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_8==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 8, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 49:
            	                {
            	                int LA104_9 = input.LA(2);

            	                if ( (LA104_9==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_9==EOF||(LA104_9>=SEMI && LA104_9<=EQ)||LA104_9==RPAREN||(LA104_9>=RCURLY && LA104_9<=LARROW)||LA104_9==PIPE||(LA104_9>=POINT && LA104_9<=NE)||LA104_9==61||LA104_9==68||(LA104_9>=74 && LA104_9<=75)||(LA104_9>=93 && LA104_9<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 9, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 50:
            	                {
            	                int LA104_10 = input.LA(2);

            	                if ( (LA104_10==EOF||(LA104_10>=SEMI && LA104_10<=EQ)||LA104_10==RPAREN||(LA104_10>=RCURLY && LA104_10<=LARROW)||LA104_10==PIPE||(LA104_10>=POINT && LA104_10<=NE)||LA104_10==61||LA104_10==68||(LA104_10>=74 && LA104_10<=75)||(LA104_10>=93 && LA104_10<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_10==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 10, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 51:
            	                {
            	                int LA104_11 = input.LA(2);

            	                if ( (LA104_11==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_11==EOF||(LA104_11>=SEMI && LA104_11<=EQ)||LA104_11==RPAREN||(LA104_11>=RCURLY && LA104_11<=LARROW)||LA104_11==PIPE||(LA104_11>=POINT && LA104_11<=NE)||LA104_11==61||LA104_11==68||(LA104_11>=74 && LA104_11<=75)||(LA104_11>=93 && LA104_11<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 11, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 52:
            	                {
            	                int LA104_12 = input.LA(2);

            	                if ( (LA104_12==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_12==EOF||(LA104_12>=SEMI && LA104_12<=EQ)||LA104_12==RPAREN||(LA104_12>=RCURLY && LA104_12<=LARROW)||LA104_12==PIPE||(LA104_12>=POINT && LA104_12<=NE)||LA104_12==61||LA104_12==68||(LA104_12>=74 && LA104_12<=75)||(LA104_12>=93 && LA104_12<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 12, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 53:
            	                {
            	                int LA104_13 = input.LA(2);

            	                if ( (LA104_13==EOF||(LA104_13>=SEMI && LA104_13<=EQ)||LA104_13==RPAREN||(LA104_13>=RCURLY && LA104_13<=LARROW)||LA104_13==PIPE||(LA104_13>=POINT && LA104_13<=NE)||LA104_13==61||LA104_13==68||(LA104_13>=74 && LA104_13<=75)||(LA104_13>=93 && LA104_13<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_13==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 13, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 54:
            	                {
            	                int LA104_14 = input.LA(2);

            	                if ( (LA104_14==EOF||(LA104_14>=SEMI && LA104_14<=EQ)||LA104_14==RPAREN||(LA104_14>=RCURLY && LA104_14<=LARROW)||LA104_14==PIPE||(LA104_14>=POINT && LA104_14<=NE)||LA104_14==61||LA104_14==68||(LA104_14>=74 && LA104_14<=75)||(LA104_14>=93 && LA104_14<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_14==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 14, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 55:
            	                {
            	                int LA104_15 = input.LA(2);

            	                if ( (LA104_15==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_15==EOF||(LA104_15>=SEMI && LA104_15<=EQ)||LA104_15==RPAREN||(LA104_15>=RCURLY && LA104_15<=LARROW)||LA104_15==PIPE||(LA104_15>=POINT && LA104_15<=NE)||LA104_15==61||LA104_15==68||(LA104_15>=74 && LA104_15<=75)||(LA104_15>=93 && LA104_15<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 15, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 56:
            	                {
            	                int LA104_16 = input.LA(2);

            	                if ( (LA104_16==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_16==EOF||(LA104_16>=SEMI && LA104_16<=EQ)||LA104_16==RPAREN||(LA104_16>=RCURLY && LA104_16<=LARROW)||LA104_16==PIPE||(LA104_16>=POINT && LA104_16<=NE)||LA104_16==61||LA104_16==68||(LA104_16>=74 && LA104_16<=75)||(LA104_16>=93 && LA104_16<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 16, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 57:
            	                {
            	                int LA104_17 = input.LA(2);

            	                if ( (LA104_17==EOF||(LA104_17>=SEMI && LA104_17<=EQ)||LA104_17==RPAREN||(LA104_17>=RCURLY && LA104_17<=LARROW)||LA104_17==PIPE||(LA104_17>=POINT && LA104_17<=NE)||LA104_17==61||LA104_17==68||(LA104_17>=74 && LA104_17<=75)||(LA104_17>=93 && LA104_17<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_17==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 17, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 58:
            	                {
            	                int LA104_18 = input.LA(2);

            	                if ( (LA104_18==EOF||(LA104_18>=SEMI && LA104_18<=EQ)||LA104_18==RPAREN||(LA104_18>=RCURLY && LA104_18<=LARROW)||LA104_18==PIPE||(LA104_18>=POINT && LA104_18<=NE)||LA104_18==61||LA104_18==68||(LA104_18>=74 && LA104_18<=75)||(LA104_18>=93 && LA104_18<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_18==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 18, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 59:
            	                {
            	                int LA104_19 = input.LA(2);

            	                if ( (LA104_19==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_19==EOF||(LA104_19>=SEMI && LA104_19<=EQ)||LA104_19==RPAREN||(LA104_19>=RCURLY && LA104_19<=LARROW)||LA104_19==PIPE||(LA104_19>=POINT && LA104_19<=NE)||LA104_19==61||LA104_19==68||(LA104_19>=74 && LA104_19<=75)||(LA104_19>=93 && LA104_19<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 19, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 60:
            	                {
            	                int LA104_20 = input.LA(2);

            	                if ( (LA104_20==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_20==EOF||(LA104_20>=SEMI && LA104_20<=EQ)||LA104_20==RPAREN||(LA104_20>=RCURLY && LA104_20<=LARROW)||LA104_20==PIPE||(LA104_20>=POINT && LA104_20<=NE)||LA104_20==61||LA104_20==68||(LA104_20>=74 && LA104_20<=75)||(LA104_20>=93 && LA104_20<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 20, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 61:
            	                {
            	                int LA104_21 = input.LA(2);

            	                if ( (LA104_21==EOF||(LA104_21>=SEMI && LA104_21<=EQ)||LA104_21==RPAREN||(LA104_21>=RCURLY && LA104_21<=LARROW)||LA104_21==PIPE||(LA104_21>=POINT && LA104_21<=NE)||LA104_21==61||LA104_21==68||(LA104_21>=74 && LA104_21<=75)||(LA104_21>=93 && LA104_21<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_21==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 21, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 62:
            	                {
            	                int LA104_22 = input.LA(2);

            	                if ( (LA104_22==EOF||(LA104_22>=SEMI && LA104_22<=EQ)||LA104_22==RPAREN||(LA104_22>=RCURLY && LA104_22<=LARROW)||LA104_22==PIPE||(LA104_22>=POINT && LA104_22<=NE)||LA104_22==61||LA104_22==68||(LA104_22>=74 && LA104_22<=75)||(LA104_22>=93 && LA104_22<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_22==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 22, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 63:
            	                {
            	                int LA104_23 = input.LA(2);

            	                if ( (LA104_23==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_23==EOF||(LA104_23>=SEMI && LA104_23<=EQ)||LA104_23==RPAREN||(LA104_23>=RCURLY && LA104_23<=LARROW)||LA104_23==PIPE||(LA104_23>=POINT && LA104_23<=NE)||LA104_23==61||LA104_23==68||(LA104_23>=74 && LA104_23<=75)||(LA104_23>=93 && LA104_23<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 23, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 64:
            	                {
            	                int LA104_24 = input.LA(2);

            	                if ( (LA104_24==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_24==EOF||(LA104_24>=SEMI && LA104_24<=EQ)||LA104_24==RPAREN||(LA104_24>=RCURLY && LA104_24<=LARROW)||LA104_24==PIPE||(LA104_24>=POINT && LA104_24<=NE)||LA104_24==61||LA104_24==68||(LA104_24>=74 && LA104_24<=75)||(LA104_24>=93 && LA104_24<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 24, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 65:
            	                {
            	                int LA104_25 = input.LA(2);

            	                if ( (LA104_25==EOF||(LA104_25>=SEMI && LA104_25<=EQ)||LA104_25==RPAREN||(LA104_25>=RCURLY && LA104_25<=LARROW)||LA104_25==PIPE||(LA104_25>=POINT && LA104_25<=NE)||LA104_25==61||LA104_25==68||(LA104_25>=74 && LA104_25<=75)||(LA104_25>=93 && LA104_25<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_25==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 25, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 66:
            	                {
            	                int LA104_26 = input.LA(2);

            	                if ( (LA104_26==EOF||(LA104_26>=SEMI && LA104_26<=EQ)||LA104_26==RPAREN||(LA104_26>=RCURLY && LA104_26<=LARROW)||LA104_26==PIPE||(LA104_26>=POINT && LA104_26<=NE)||LA104_26==61||LA104_26==68||(LA104_26>=74 && LA104_26<=75)||(LA104_26>=93 && LA104_26<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_26==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 26, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 67:
            	                {
            	                int LA104_27 = input.LA(2);

            	                if ( (LA104_27==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_27==EOF||(LA104_27>=SEMI && LA104_27<=EQ)||LA104_27==RPAREN||(LA104_27>=RCURLY && LA104_27<=LARROW)||LA104_27==PIPE||(LA104_27>=POINT && LA104_27<=NE)||LA104_27==61||LA104_27==68||(LA104_27>=74 && LA104_27<=75)||(LA104_27>=93 && LA104_27<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 27, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 68:
            	                {
            	                int LA104_28 = input.LA(2);

            	                if ( (LA104_28==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_28==EOF||(LA104_28>=SEMI && LA104_28<=EQ)||LA104_28==RPAREN||(LA104_28>=RCURLY && LA104_28<=LARROW)||LA104_28==PIPE||(LA104_28>=POINT && LA104_28<=NE)||LA104_28==61||LA104_28==68||(LA104_28>=74 && LA104_28<=75)||(LA104_28>=93 && LA104_28<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 28, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 69:
            	                {
            	                int LA104_29 = input.LA(2);

            	                if ( (LA104_29==EOF||(LA104_29>=SEMI && LA104_29<=EQ)||LA104_29==RPAREN||(LA104_29>=RCURLY && LA104_29<=LARROW)||LA104_29==PIPE||(LA104_29>=POINT && LA104_29<=NE)||LA104_29==61||LA104_29==68||(LA104_29>=74 && LA104_29<=75)||(LA104_29>=93 && LA104_29<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_29==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 29, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 70:
            	                {
            	                int LA104_30 = input.LA(2);

            	                if ( (LA104_30==EOF||(LA104_30>=SEMI && LA104_30<=EQ)||LA104_30==RPAREN||(LA104_30>=RCURLY && LA104_30<=LARROW)||LA104_30==PIPE||(LA104_30>=POINT && LA104_30<=NE)||LA104_30==61||LA104_30==68||(LA104_30>=74 && LA104_30<=75)||(LA104_30>=93 && LA104_30<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_30==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 30, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 71:
            	                {
            	                int LA104_31 = input.LA(2);

            	                if ( (LA104_31==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_31==EOF||(LA104_31>=SEMI && LA104_31<=EQ)||LA104_31==RPAREN||(LA104_31>=RCURLY && LA104_31<=LARROW)||LA104_31==PIPE||(LA104_31>=POINT && LA104_31<=NE)||LA104_31==61||LA104_31==68||(LA104_31>=74 && LA104_31<=75)||(LA104_31>=93 && LA104_31<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 31, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 72:
            	                {
            	                int LA104_32 = input.LA(2);

            	                if ( (LA104_32==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_32==EOF||(LA104_32>=SEMI && LA104_32<=EQ)||LA104_32==RPAREN||(LA104_32>=RCURLY && LA104_32<=LARROW)||LA104_32==PIPE||(LA104_32>=POINT && LA104_32<=NE)||LA104_32==61||LA104_32==68||(LA104_32>=74 && LA104_32<=75)||(LA104_32>=93 && LA104_32<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 32, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 73:
            	                {
            	                int LA104_33 = input.LA(2);

            	                if ( (LA104_33==EOF||(LA104_33>=SEMI && LA104_33<=EQ)||LA104_33==RPAREN||(LA104_33>=RCURLY && LA104_33<=LARROW)||LA104_33==PIPE||(LA104_33>=POINT && LA104_33<=NE)||LA104_33==61||LA104_33==68||(LA104_33>=74 && LA104_33<=75)||(LA104_33>=93 && LA104_33<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_33==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 33, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 74:
            	                {
            	                int LA104_34 = input.LA(2);

            	                if ( (LA104_34==EOF||(LA104_34>=SEMI && LA104_34<=EQ)||LA104_34==RPAREN||(LA104_34>=RCURLY && LA104_34<=LARROW)||LA104_34==PIPE||(LA104_34>=POINT && LA104_34<=NE)||LA104_34==61||LA104_34==68||(LA104_34>=74 && LA104_34<=75)||(LA104_34>=93 && LA104_34<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_34==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 34, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 75:
            	                {
            	                int LA104_35 = input.LA(2);

            	                if ( (LA104_35==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_35==EOF||(LA104_35>=SEMI && LA104_35<=EQ)||LA104_35==RPAREN||(LA104_35>=RCURLY && LA104_35<=LARROW)||LA104_35==PIPE||(LA104_35>=POINT && LA104_35<=NE)||LA104_35==61||LA104_35==68||(LA104_35>=74 && LA104_35<=75)||(LA104_35>=93 && LA104_35<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 35, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 76:
            	                {
            	                int LA104_36 = input.LA(2);

            	                if ( (LA104_36==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_36==EOF||(LA104_36>=SEMI && LA104_36<=EQ)||LA104_36==RPAREN||(LA104_36>=RCURLY && LA104_36<=LARROW)||LA104_36==PIPE||(LA104_36>=POINT && LA104_36<=NE)||LA104_36==61||LA104_36==68||(LA104_36>=74 && LA104_36<=75)||(LA104_36>=93 && LA104_36<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 36, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 77:
            	                {
            	                int LA104_37 = input.LA(2);

            	                if ( (LA104_37==EOF||(LA104_37>=SEMI && LA104_37<=EQ)||LA104_37==RPAREN||(LA104_37>=RCURLY && LA104_37<=LARROW)||LA104_37==PIPE||(LA104_37>=POINT && LA104_37<=NE)||LA104_37==61||LA104_37==68||(LA104_37>=74 && LA104_37<=75)||(LA104_37>=93 && LA104_37<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_37==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 37, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 78:
            	                {
            	                int LA104_38 = input.LA(2);

            	                if ( (LA104_38==EOF||(LA104_38>=SEMI && LA104_38<=EQ)||LA104_38==RPAREN||(LA104_38>=RCURLY && LA104_38<=LARROW)||LA104_38==PIPE||(LA104_38>=POINT && LA104_38<=NE)||LA104_38==61||LA104_38==68||(LA104_38>=74 && LA104_38<=75)||(LA104_38>=93 && LA104_38<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_38==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 38, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 79:
            	                {
            	                int LA104_39 = input.LA(2);

            	                if ( (LA104_39==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_39==EOF||(LA104_39>=SEMI && LA104_39<=EQ)||LA104_39==RPAREN||(LA104_39>=RCURLY && LA104_39<=LARROW)||LA104_39==PIPE||(LA104_39>=POINT && LA104_39<=NE)||LA104_39==61||LA104_39==68||(LA104_39>=74 && LA104_39<=75)||(LA104_39>=93 && LA104_39<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 39, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 80:
            	                {
            	                int LA104_40 = input.LA(2);

            	                if ( (LA104_40==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_40==EOF||(LA104_40>=SEMI && LA104_40<=EQ)||LA104_40==RPAREN||(LA104_40>=RCURLY && LA104_40<=LARROW)||LA104_40==PIPE||(LA104_40>=POINT && LA104_40<=NE)||LA104_40==61||LA104_40==68||(LA104_40>=74 && LA104_40<=75)||(LA104_40>=93 && LA104_40<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 40, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 81:
            	                {
            	                int LA104_41 = input.LA(2);

            	                if ( (LA104_41==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_41==EOF||(LA104_41>=SEMI && LA104_41<=EQ)||LA104_41==RPAREN||(LA104_41>=RCURLY && LA104_41<=LARROW)||LA104_41==PIPE||(LA104_41>=POINT && LA104_41<=NE)||LA104_41==61||LA104_41==68||(LA104_41>=74 && LA104_41<=75)||(LA104_41>=93 && LA104_41<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 41, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 82:
            	                {
            	                int LA104_42 = input.LA(2);

            	                if ( (LA104_42==EOF||(LA104_42>=SEMI && LA104_42<=EQ)||LA104_42==RPAREN||(LA104_42>=RCURLY && LA104_42<=LARROW)||LA104_42==PIPE||(LA104_42>=POINT && LA104_42<=NE)||LA104_42==61||LA104_42==68||(LA104_42>=74 && LA104_42<=75)||(LA104_42>=93 && LA104_42<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_42==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 42, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 83:
            	                {
            	                int LA104_43 = input.LA(2);

            	                if ( (LA104_43==EOF||(LA104_43>=SEMI && LA104_43<=EQ)||LA104_43==RPAREN||(LA104_43>=RCURLY && LA104_43<=LARROW)||LA104_43==PIPE||(LA104_43>=POINT && LA104_43<=NE)||LA104_43==61||LA104_43==68||(LA104_43>=74 && LA104_43<=75)||(LA104_43>=93 && LA104_43<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_43==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 43, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 84:
            	                {
            	                int LA104_44 = input.LA(2);

            	                if ( (LA104_44==EOF||(LA104_44>=SEMI && LA104_44<=EQ)||LA104_44==RPAREN||(LA104_44>=RCURLY && LA104_44<=LARROW)||LA104_44==PIPE||(LA104_44>=POINT && LA104_44<=NE)||LA104_44==61||LA104_44==68||(LA104_44>=74 && LA104_44<=75)||(LA104_44>=93 && LA104_44<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_44==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 44, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 85:
            	                {
            	                int LA104_45 = input.LA(2);

            	                if ( (LA104_45==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_45==EOF||(LA104_45>=SEMI && LA104_45<=EQ)||LA104_45==RPAREN||(LA104_45>=RCURLY && LA104_45<=LARROW)||LA104_45==PIPE||(LA104_45>=POINT && LA104_45<=NE)||LA104_45==61||LA104_45==68||(LA104_45>=74 && LA104_45<=75)||(LA104_45>=93 && LA104_45<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 45, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 86:
            	                {
            	                int LA104_46 = input.LA(2);

            	                if ( (LA104_46==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_46==EOF||(LA104_46>=SEMI && LA104_46<=EQ)||LA104_46==RPAREN||(LA104_46>=RCURLY && LA104_46<=LARROW)||LA104_46==PIPE||(LA104_46>=POINT && LA104_46<=NE)||LA104_46==61||LA104_46==68||(LA104_46>=74 && LA104_46<=75)||(LA104_46>=93 && LA104_46<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 46, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 87:
            	                {
            	                int LA104_47 = input.LA(2);

            	                if ( (LA104_47==EOF||(LA104_47>=SEMI && LA104_47<=EQ)||LA104_47==RPAREN||(LA104_47>=RCURLY && LA104_47<=LARROW)||LA104_47==PIPE||(LA104_47>=POINT && LA104_47<=NE)||LA104_47==61||LA104_47==68||(LA104_47>=74 && LA104_47<=75)||(LA104_47>=93 && LA104_47<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_47==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 47, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 88:
            	                {
            	                int LA104_48 = input.LA(2);

            	                if ( (LA104_48==EOF||(LA104_48>=SEMI && LA104_48<=EQ)||LA104_48==RPAREN||(LA104_48>=RCURLY && LA104_48<=LARROW)||LA104_48==PIPE||(LA104_48>=POINT && LA104_48<=NE)||LA104_48==61||LA104_48==68||(LA104_48>=74 && LA104_48<=75)||(LA104_48>=93 && LA104_48<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_48==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 48, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 89:
            	                {
            	                int LA104_49 = input.LA(2);

            	                if ( (LA104_49==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_49==EOF||(LA104_49>=SEMI && LA104_49<=EQ)||LA104_49==RPAREN||(LA104_49>=RCURLY && LA104_49<=LARROW)||LA104_49==PIPE||(LA104_49>=POINT && LA104_49<=NE)||LA104_49==61||LA104_49==68||(LA104_49>=74 && LA104_49<=75)||(LA104_49>=93 && LA104_49<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 49, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 90:
            	                {
            	                int LA104_50 = input.LA(2);

            	                if ( (LA104_50==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_50==EOF||(LA104_50>=SEMI && LA104_50<=EQ)||LA104_50==RPAREN||(LA104_50>=RCURLY && LA104_50<=LARROW)||LA104_50==PIPE||(LA104_50>=POINT && LA104_50<=NE)||LA104_50==61||LA104_50==68||(LA104_50>=74 && LA104_50<=75)||(LA104_50>=93 && LA104_50<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 50, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 91:
            	                {
            	                int LA104_51 = input.LA(2);

            	                if ( (LA104_51==EOF||(LA104_51>=SEMI && LA104_51<=EQ)||LA104_51==RPAREN||(LA104_51>=RCURLY && LA104_51<=LARROW)||LA104_51==PIPE||(LA104_51>=POINT && LA104_51<=NE)||LA104_51==61||LA104_51==68||(LA104_51>=74 && LA104_51<=75)||(LA104_51>=93 && LA104_51<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_51==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 51, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 92:
            	                {
            	                int LA104_52 = input.LA(2);

            	                if ( (LA104_52==EOF||(LA104_52>=SEMI && LA104_52<=EQ)||LA104_52==RPAREN||(LA104_52>=RCURLY && LA104_52<=LARROW)||LA104_52==PIPE||(LA104_52>=POINT && LA104_52<=NE)||LA104_52==61||LA104_52==68||(LA104_52>=74 && LA104_52<=75)||(LA104_52>=93 && LA104_52<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_52==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 52, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 93:
            	                {
            	                int LA104_53 = input.LA(2);

            	                if ( (LA104_53==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_53==EOF||(LA104_53>=SEMI && LA104_53<=EQ)||LA104_53==RPAREN||(LA104_53>=RCURLY && LA104_53<=LARROW)||LA104_53==PIPE||(LA104_53>=POINT && LA104_53<=NE)||LA104_53==61||LA104_53==68||(LA104_53>=74 && LA104_53<=75)||(LA104_53>=93 && LA104_53<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 53, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 94:
            	                {
            	                int LA104_54 = input.LA(2);

            	                if ( (LA104_54==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_54==EOF||(LA104_54>=SEMI && LA104_54<=EQ)||LA104_54==RPAREN||(LA104_54>=RCURLY && LA104_54<=LARROW)||LA104_54==PIPE||(LA104_54>=POINT && LA104_54<=NE)||LA104_54==61||LA104_54==68||(LA104_54>=74 && LA104_54<=75)||(LA104_54>=93 && LA104_54<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 54, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 95:
            	                {
            	                int LA104_55 = input.LA(2);

            	                if ( (LA104_55==EOF||(LA104_55>=SEMI && LA104_55<=EQ)||LA104_55==RPAREN||(LA104_55>=RCURLY && LA104_55<=LARROW)||LA104_55==PIPE||(LA104_55>=POINT && LA104_55<=NE)||LA104_55==61||LA104_55==68||(LA104_55>=74 && LA104_55<=75)||(LA104_55>=93 && LA104_55<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_55==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 55, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 96:
            	                {
            	                int LA104_56 = input.LA(2);

            	                if ( (LA104_56==EOF||(LA104_56>=SEMI && LA104_56<=EQ)||LA104_56==RPAREN||(LA104_56>=RCURLY && LA104_56<=LARROW)||LA104_56==PIPE||(LA104_56>=POINT && LA104_56<=NE)||LA104_56==61||LA104_56==68||(LA104_56>=74 && LA104_56<=75)||(LA104_56>=93 && LA104_56<=98)) ) {
            	                    alt104=2;
            	                }
            	                else if ( (LA104_56==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 56, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 97:
            	                {
            	                int LA104_57 = input.LA(2);

            	                if ( (LA104_57==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_57==EOF||(LA104_57>=SEMI && LA104_57<=EQ)||LA104_57==RPAREN||(LA104_57>=RCURLY && LA104_57<=LARROW)||LA104_57==PIPE||(LA104_57>=POINT && LA104_57<=NE)||LA104_57==61||LA104_57==68||(LA104_57>=74 && LA104_57<=75)||(LA104_57>=93 && LA104_57<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 57, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 98:
            	                {
            	                int LA104_58 = input.LA(2);

            	                if ( (LA104_58==LPAREN) ) {
            	                    alt104=1;
            	                }
            	                else if ( (LA104_58==EOF||(LA104_58>=SEMI && LA104_58<=EQ)||LA104_58==RPAREN||(LA104_58>=RCURLY && LA104_58<=LARROW)||LA104_58==PIPE||(LA104_58>=POINT && LA104_58<=NE)||LA104_58==61||LA104_58==68||(LA104_58>=74 && LA104_58<=75)||(LA104_58>=93 && LA104_58<=98)) ) {
            	                    alt104=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 58, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            default:
            	                if (backtracking>0) {failed=true; return ret2;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 104, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt104) {
            	                case 1 :
            	                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:57: ret= operationCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_operationCallExp_in_priority_05301);
            	                    ret=operationCallExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;
            	                case 2 :
            	                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:105: ret= navigationOrAttributeCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_navigationOrAttributeCallExp_in_priority_05308);
            	                    ret=navigationOrAttributeCallExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:167: ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:167: ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:168: RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )
            	            {
            	            match(input,RARROW,FOLLOW_RARROW_in_priority_05316); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "->";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:192: (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )
            	            int alt105=3;
            	            alt105 = dfa105.predict(input);
            	            switch (alt105) {
            	                case 1 :
            	                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:193: ret= iteratorExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_iteratorExp_in_priority_05323);
            	                    ret=iteratorExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;
            	                case 2 :
            	                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:236: ret= iterateExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_iterateExp_in_priority_05330);
            	                    ret=iterateExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;
            	                case 3 :
            	                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:970:278: ret= collectionOperationCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_collectionOperationCallExp_in_priority_05337);
            	                    ret=collectionOperationCallExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);


            }

            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end priority_0


    // $ANTLR start priority_1
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:977:1: priority_1 returns [Object ret2] : ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) ;
    public final Object priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:978:2: ( ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:978:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:978:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            int alt108=3;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt108=1;
                }
                break;
            case MINUS:
                {
                alt108=2;
                }
                break;
            case NAME:
            case STRING:
            case INT:
            case FLOAT:
            case LPAREN:
            case SHARP:
            case 67:
            case 71:
            case 72:
            case 73:
            case 76:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                {
                alt108=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("978:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:978:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:978:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:978:6: 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,92,FOLLOW_92_in_priority_15377); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      opName = "not";
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:978:30: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:978:31: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_15384);
                    ret=operatorCallExp(opName,  right,  firstToken);
                    _fsp--;
                    if (failed) return ret2;
                    pushFollow(FOLLOW_priority_0_in_priority_15389);
                    right=priority_0();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
                      	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:979:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:979:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:979:72: MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_priority_15397); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      opName = "-";
                    }
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:979:94: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:979:95: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_15404);
                    ret=operatorCallExp(opName,  right,  firstToken);
                    _fsp--;
                    if (failed) return ret2;
                    pushFollow(FOLLOW_priority_0_in_priority_15409);
                    right=priority_0();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
                      	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:980:71: (ret= priority_0 )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:980:71: (ret= priority_0 )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:980:72: ret= priority_0
                    {
                    pushFollow(FOLLOW_priority_0_in_priority_15419);
                    ret=priority_0();
                    _fsp--;
                    if (failed) return ret2;

                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end priority_1


    // $ANTLR start priority_2
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:987:1: priority_2 returns [Object ret2] : (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ;
    public final Object priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:2: ( (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:5: ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_1_in_priority_25454);
            ret=priority_1();
            _fsp--;
            if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:20: ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( ((LA110_0>=STAR && LA110_0<=SLASH)||(LA110_0>=93 && LA110_0<=94)) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    int alt109=4;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt109=1;
            	        }
            	        break;
            	    case SLASH:
            	        {
            	        alt109=2;
            	        }
            	        break;
            	    case 93:
            	        {
            	        alt109=3;
            	        }
            	        break;
            	    case 94:
            	        {
            	        alt109=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("988:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )", 109, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt109) {
            	        case 1 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:23: STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,STAR,FOLLOW_STAR_in_priority_25459); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "*";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:988:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25466);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25471);
            	            right=priority_1();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:989:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:989:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:989:72: SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,SLASH,FOLLOW_SLASH_in_priority_25479); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "/";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:989:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:989:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25486);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25491);
            	            right=priority_1();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:990:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:990:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:990:72: 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,93,FOLLOW_93_in_priority_25499); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "div";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:990:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:990:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25506);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25511);
            	            right=priority_1();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:991:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:991:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:991:72: 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,94,FOLLOW_94_in_priority_25519); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "mod";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:991:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:991:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25526);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25531);
            	            right=priority_1();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop110;
                }
            } while (true);


            }

            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end priority_2


    // $ANTLR start priority_3
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:999:1: priority_3 returns [Object ret2] : (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) ;
    public final Object priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:2: ( (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:5: ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_2_in_priority_35572);
            ret=priority_2();
            _fsp--;
            if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:20: ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( (LA112_0==MINUS||LA112_0==PLUS) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    int alt111=2;
            	    int LA111_0 = input.LA(1);

            	    if ( (LA111_0==PLUS) ) {
            	        alt111=1;
            	    }
            	    else if ( (LA111_0==MINUS) ) {
            	        alt111=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1000:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )", 111, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt111) {
            	        case 1 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:23: PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_priority_35577); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "+";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1000:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_35584);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_2_in_priority_35589);
            	            right=priority_2();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1001:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1001:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1001:72: MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_priority_35597); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "-";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1001:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1001:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_35604);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_2_in_priority_35609);
            	            right=priority_2();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop112;
                }
            } while (true);


            }

            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end priority_3


    // $ANTLR start priority_4
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1009:1: priority_4 returns [Object ret2] : (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* ) ;
    public final Object priority_4() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:2: ( (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:5: ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_3_in_priority_45650);
            ret=priority_3();
            _fsp--;
            if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:20: ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==EQ||(LA114_0>=GT && LA114_0<=NE)) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )
            	    int alt113=6;
            	    switch ( input.LA(1) ) {
            	    case EQ:
            	        {
            	        alt113=1;
            	        }
            	        break;
            	    case GT:
            	        {
            	        alt113=2;
            	        }
            	        break;
            	    case LT:
            	        {
            	        alt113=3;
            	        }
            	        break;
            	    case GE:
            	        {
            	        alt113=4;
            	        }
            	        break;
            	    case LE:
            	        {
            	        alt113=5;
            	        }
            	        break;
            	    case NE:
            	        {
            	        alt113=6;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1010:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )", 113, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt113) {
            	        case 1 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:23: EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,EQ,FOLLOW_EQ_in_priority_45655); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "=";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:42: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1010:43: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45662);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45667);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1011:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1011:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1011:72: GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GT,FOLLOW_GT_in_priority_45675); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = ">";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1011:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1011:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45682);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45687);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1012:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1012:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1012:72: LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LT,FOLLOW_LT_in_priority_45695); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "<";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1012:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1012:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45702);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45707);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1013:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1013:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1013:72: GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GE,FOLLOW_GE_in_priority_45715); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = ">=";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1013:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1013:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45722);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45727);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 5 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1014:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1014:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1014:72: LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LE,FOLLOW_LE_in_priority_45735); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "<=";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1014:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1014:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45742);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45747);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 6 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1015:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1015:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1015:72: NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,NE,FOLLOW_NE_in_priority_45755); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "<>";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1015:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1015:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45762);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45767);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop114;
                }
            } while (true);


            }

            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end priority_4


    // $ANTLR start priority_5
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1023:1: priority_5 returns [Object ret2] : (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ;
    public final Object priority_5() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:2: ( (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:5: ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_4_in_priority_55808);
            ret=priority_4();
            _fsp--;
            if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:20: ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( ((LA116_0>=95 && LA116_0<=98)) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    int alt115=4;
            	    switch ( input.LA(1) ) {
            	    case 95:
            	        {
            	        alt115=1;
            	        }
            	        break;
            	    case 96:
            	        {
            	        alt115=2;
            	        }
            	        break;
            	    case 97:
            	        {
            	        alt115=3;
            	        }
            	        break;
            	    case 98:
            	        {
            	        alt115=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1024:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )", 115, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt115) {
            	        case 1 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:23: 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,95,FOLLOW_95_in_priority_55813); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "and";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:47: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1024:48: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55820);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55825);
            	            right=priority_4();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1025:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1025:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1025:72: 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,96,FOLLOW_96_in_priority_55833); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "or";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1025:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1025:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55840);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55845);
            	            right=priority_4();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1026:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1026:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1026:72: 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,97,FOLLOW_97_in_priority_55853); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "xor";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1026:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1026:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55860);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55865);
            	            right=priority_4();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1027:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1027:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1027:72: 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,98,FOLLOW_98_in_priority_55873); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "implies";
            	            }
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1027:104: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1027:105: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55880);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55885);
            	            right=priority_4();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop116;
                }
            } while (true);


            }

            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end priority_5


    // $ANTLR start matchedRule_abstractContents
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1035:1: matchedRule_abstractContents returns [Object ret2] : ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) ;
    public final Object matchedRule_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MatchedRule", true, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:2: ( ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:4: ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:4: ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:5: ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:5: ( ( 'nodefault' ) | () )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==52) ) {
                alt117=1;
            }
            else if ( (LA117_0==44||(LA117_0>=53 && LA117_0<=54)) ) {
                alt117=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:5: ( ( 'nodefault' ) | () )", 117, 0, input);

                throw nvae;
            }
            switch (alt117) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:6: ( 'nodefault' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:6: ( 'nodefault' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:7: 'nodefault'
                    {
                    match(input,52,FOLLOW_52_in_matchedRule_abstractContents5926); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isNoDefault", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:75: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:75: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:76: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isNoDefault", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:134: ( ( 'abstract' ) | () )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==53) ) {
                alt118=1;
            }
            else if ( (LA118_0==44||LA118_0==54) ) {
                alt118=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:134: ( ( 'abstract' ) | () )", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:135: ( 'abstract' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:135: ( 'abstract' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:136: 'abstract'
                    {
                    match(input,53,FOLLOW_53_in_matchedRule_abstractContents5940); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAbstract", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:202: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:202: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:203: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAbstract", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:260: ( ( 'refining' ) | () )
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==44) ) {
                alt119=1;
            }
            else if ( (LA119_0==54) ) {
                alt119=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:260: ( ( 'refining' ) | () )", 119, 0, input);

                throw nvae;
            }
            switch (alt119) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:261: ( 'refining' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:261: ( 'refining' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:262: 'refining'
                    {
                    match(input,44,FOLLOW_44_in_matchedRule_abstractContents5954); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:328: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:328: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:329: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            match(input,54,FOLLOW_54_in_matchedRule_abstractContents5966); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_matchedRule_abstractContents5970);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:438: ( ( 'extends' temp= identifier ) | () )
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==55) ) {
                alt120=1;
            }
            else if ( (LA120_0==LCURLY) ) {
                alt120=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:438: ( ( 'extends' temp= identifier ) | () )", 120, 0, input);

                throw nvae;
            }
            switch (alt120) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:439: ( 'extends' temp= identifier )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:439: ( 'extends' temp= identifier )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:440: 'extends' temp= identifier
                    {
                    match(input,55,FOLLOW_55_in_matchedRule_abstractContents5976); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_matchedRule_abstractContents5980);
                    temp=identifier();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.setRef(ret, "superRule", "MatchedRule", "name", temp, null, "never", null, true, null);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:564: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:564: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:565: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_matchedRule_abstractContents5994); if (failed) return ret2;
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:578: ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:579: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:579: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:580: temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () )
            {
            pushFollow(FOLLOW_inPattern_in_matchedRule_abstractContents6000);
            temp=inPattern();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "inPattern", temp);
            }
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:629: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==56) ) {
                alt123=1;
            }
            else if ( (LA123_0==RCURLY||LA123_0==62||LA123_0==66) ) {
                alt123=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:629: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:630: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:630: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:631: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,56,FOLLOW_56_in_matchedRule_abstractContents6006); if (failed) return ret2;
                    match(input,LCURLY,FOLLOW_LCURLY_in_matchedRule_abstractContents6008); if (failed) return ret2;
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:646: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:647: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:647: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:648: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:648: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( (LA122_0==NAME) ) {
                        alt122=1;
                    }
                    switch (alt122) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:649: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:649: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:650: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6016);
                            temp=ruleVariableDeclaration();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "variables", temp);
                            }
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:713: ( (temp= ruleVariableDeclaration ) )*
                            loop121:
                            do {
                                int alt121=2;
                                int LA121_0 = input.LA(1);

                                if ( (LA121_0==NAME) ) {
                                    alt121=1;
                                }


                                switch (alt121) {
                            	case 1 :
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:714: (temp= ruleVariableDeclaration )
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:714: (temp= ruleVariableDeclaration )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:715: temp= ruleVariableDeclaration
                            	    {
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6024);
                            	    temp=ruleVariableDeclaration();
                            	    _fsp--;
                            	    if (failed) return ret2;
                            	    if ( backtracking==0 ) {
                            	      ei.set(ret, "variables", temp);
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop121;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_matchedRule_abstractContents6036); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:798: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:798: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:799: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:805: ( (temp= outPattern ) | () )
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==62) ) {
                alt124=1;
            }
            else if ( (LA124_0==RCURLY||LA124_0==66) ) {
                alt124=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:805: ( (temp= outPattern ) | () )", 124, 0, input);

                throw nvae;
            }
            switch (alt124) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:806: (temp= outPattern )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:806: (temp= outPattern )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:807: temp= outPattern
                    {
                    pushFollow(FOLLOW_outPattern_in_matchedRule_abstractContents6052);
                    temp=outPattern();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "outPattern", temp);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:863: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:863: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:864: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:870: ( (temp= actionBlock ) | () )
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==66) ) {
                alt125=1;
            }
            else if ( (LA125_0==RCURLY) ) {
                alt125=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:870: ( (temp= actionBlock ) | () )", 125, 0, input);

                throw nvae;
            }
            switch (alt125) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:871: (temp= actionBlock )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:871: (temp= actionBlock )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:872: temp= actionBlock
                    {
                    pushFollow(FOLLOW_actionBlock_in_matchedRule_abstractContents6070);
                    temp=actionBlock();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "actionBlock", temp);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:930: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:930: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1036:931: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_matchedRule_abstractContents6086); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end matchedRule_abstractContents


    // $ANTLR start oclType_abstractContents
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1046:1: oclType_abstractContents returns [Object ret2] : ( 'OclType' ) ;
    public final Object oclType_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1047:2: ( ( 'OclType' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1047:4: ( 'OclType' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1047:4: ( 'OclType' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1047:5: 'OclType'
            {
            match(input,84,FOLLOW_84_in_oclType_abstractContents6118); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end oclType_abstractContents


    // $ANTLR start collectionType_abstractContents
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1057:1: collectionType_abstractContents returns [Object ret2] : ( 'Collection' LPAREN temp= oclType RPAREN ) ;
    public final Object collectionType_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CollectionType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1058:2: ( ( 'Collection' LPAREN temp= oclType RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1058:4: ( 'Collection' LPAREN temp= oclType RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1058:4: ( 'Collection' LPAREN temp= oclType RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1058:5: 'Collection' LPAREN temp= oclType RPAREN
            {
            match(input,91,FOLLOW_91_in_collectionType_abstractContents6150); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_collectionType_abstractContents6152); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_collectionType_abstractContents6156);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_collectionType_abstractContents6160); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end collectionType_abstractContents


    // $ANTLR start primary_oclExpression
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1068:1: primary_oclExpression returns [Object ret2] : ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType ) ;
    public final Object primary_oclExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:2: ( ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )
            int alt126=11;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt126=1;
                }
                break;
            case NAME:
                {
                int LA126_2 = input.LA(2);

                if ( (LA126_2==EXCL) ) {
                    alt126=11;
                }
                else if ( (LA126_2==EOF||(LA126_2>=SEMI && LA126_2<=EQ)||LA126_2==RPAREN||(LA126_2>=RCURLY && LA126_2<=LARROW)||LA126_2==PIPE||(LA126_2>=POINT && LA126_2<=NE)||LA126_2==61||LA126_2==68||(LA126_2>=74 && LA126_2<=75)||(LA126_2>=93 && LA126_2<=98)) ) {
                    alt126=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 126, 2, input);

                    throw nvae;
                }
                }
                break;
            case 71:
                {
                alt126=3;
                }
                break;
            case STRING:
            case INT:
            case FLOAT:
            case 72:
            case 73:
                {
                alt126=4;
                }
                break;
            case 67:
                {
                alt126=5;
                }
                break;
            case 76:
                {
                alt126=6;
                }
                break;
            case SHARP:
                {
                alt126=7;
                }
                break;
            case 78:
                {
                int LA126_8 = input.LA(2);

                if ( (LA126_8==LCURLY) ) {
                    alt126=8;
                }
                else if ( (LA126_8==LPAREN) ) {
                    alt126=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 126, 8, input);

                    throw nvae;
                }
                }
                break;
            case 79:
                {
                int LA126_9 = input.LA(2);

                if ( (LA126_9==LCURLY) ) {
                    alt126=8;
                }
                else if ( (LA126_9==LPAREN) ) {
                    alt126=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 126, 9, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                int LA126_10 = input.LA(2);

                if ( (LA126_10==LCURLY) ) {
                    alt126=8;
                }
                else if ( (LA126_10==LPAREN) ) {
                    alt126=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 126, 10, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA126_11 = input.LA(2);

                if ( (LA126_11==LCURLY) ) {
                    alt126=8;
                }
                else if ( (LA126_11==LPAREN) ) {
                    alt126=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 126, 11, input);

                    throw nvae;
                }
                }
                break;
            case 82:
                {
                int LA126_12 = input.LA(2);

                if ( (LA126_12==LPAREN) ) {
                    alt126=11;
                }
                else if ( (LA126_12==LCURLY) ) {
                    alt126=9;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 126, 12, input);

                    throw nvae;
                }
                }
                break;
            case 83:
                {
                alt126=10;
                }
                break;
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                {
                alt126=11;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 126, 0, input);

                throw nvae;
            }

            switch (alt126) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:5: ( LPAREN ret= oclExpression RPAREN )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:5: ( LPAREN ret= oclExpression RPAREN )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:6: LPAREN ret= oclExpression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_oclExpression6193); if (failed) return ret2;
                    pushFollow(FOLLOW_oclExpression_in_primary_oclExpression6197);
                    ret=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_oclExpression6199); if (failed) return ret2;

                    }


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:40: ret= variableExp
                    {
                    pushFollow(FOLLOW_variableExp_in_primary_oclExpression6205);
                    ret=variableExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:57: ret= oclUndefinedExp
                    {
                    pushFollow(FOLLOW_oclUndefinedExp_in_primary_oclExpression6210);
                    ret=oclUndefinedExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:78: ret= primitiveExp
                    {
                    pushFollow(FOLLOW_primitiveExp_in_primary_oclExpression6215);
                    ret=primitiveExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:96: ret= ifExp
                    {
                    pushFollow(FOLLOW_ifExp_in_primary_oclExpression6220);
                    ret=ifExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 6 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:107: ret= superExp
                    {
                    pushFollow(FOLLOW_superExp_in_primary_oclExpression6225);
                    ret=superExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 7 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:121: ret= enumLiteralExp
                    {
                    pushFollow(FOLLOW_enumLiteralExp_in_primary_oclExpression6230);
                    ret=enumLiteralExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 8 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:141: ret= collectionExp
                    {
                    pushFollow(FOLLOW_collectionExp_in_primary_oclExpression6235);
                    ret=collectionExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 9 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:160: ret= mapExp
                    {
                    pushFollow(FOLLOW_mapExp_in_primary_oclExpression6240);
                    ret=mapExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 10 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:172: ret= tupleExp
                    {
                    pushFollow(FOLLOW_tupleExp_in_primary_oclExpression6245);
                    ret=tupleExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 11 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:1069:186: ret= oclType
                    {
                    pushFollow(FOLLOW_oclType_in_primary_oclExpression6250);
                    ret=oclType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;

            }

            if ( backtracking==0 ) {

                          ret2=ret;
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end primary_oclExpression

    // $ANTLR start synpred121
    public final void synpred121_fragment() throws RecognitionException {   
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:6: ( ifStat )
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:6: ifStat
        {
        pushFollow(FOLLOW_ifStat_in_synpred1212622);
        ifStat();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred121

    // $ANTLR start synpred122
    public final void synpred122_fragment() throws RecognitionException {   
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:18: ( expressionStat )
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:18: expressionStat
        {
        pushFollow(FOLLOW_expressionStat_in_synpred1222627);
        expressionStat();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred122

    // $ANTLR start synpred123
    public final void synpred123_fragment() throws RecognitionException {   
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:38: ( bindingStat )
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:395:38: bindingStat
        {
        pushFollow(FOLLOW_bindingStat_in_synpred1232632);
        bindingStat();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred123

    // $ANTLR start synpred130
    public final void synpred130_fragment() throws RecognitionException {   
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:285: ( ( 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) ) ) )
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:285: ( 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) ) )
        {
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:285: ( 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) ) )
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:286: 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) )
        {
        match(input,68,FOLLOW_68_in_synpred1302819); if (failed) return ;
        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:293: ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) )
        int alt158=2;
        int LA158_0 = input.LA(1);

        if ( ((LA158_0>=NAME && LA158_0<=FLOAT)||LA158_0==LPAREN||LA158_0==SHARP||LA158_0==MINUS||LA158_0==67||LA158_0==69||(LA158_0>=71 && LA158_0<=73)||(LA158_0>=76 && LA158_0<=92)) ) {
            alt158=1;
        }
        else if ( (LA158_0==LCURLY) ) {
            alt158=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("426:293: ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) )", 158, 0, input);

            throw nvae;
        }
        switch (alt158) {
            case 1 :
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:294: ( ( ( statement ) ) )
                {
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:294: ( ( ( statement ) ) )
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:295: ( ( statement ) )
                {
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:295: ( ( statement ) )
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:296: ( statement )
                {
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:296: ( statement )
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:297: statement
                {
                pushFollow(FOLLOW_statement_in_synpred1302827);
                statement();
                _fsp--;
                if (failed) return ;

                }


                }


                }


                }
                break;
            case 2 :
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:358: ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY )
                {
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:358: ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY )
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:359: LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY
                {
                match(input,LCURLY,FOLLOW_LCURLY_in_synpred1302838); if (failed) return ;
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:366: ( ( ( ( statement ( ( statement ) )* ) )? ) )
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:367: ( ( ( statement ( ( statement ) )* ) )? )
                {
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:367: ( ( ( statement ( ( statement ) )* ) )? )
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:368: ( ( statement ( ( statement ) )* ) )?
                {
                // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:368: ( ( statement ( ( statement ) )* ) )?
                int alt157=2;
                int LA157_0 = input.LA(1);

                if ( ((LA157_0>=NAME && LA157_0<=FLOAT)||LA157_0==LPAREN||LA157_0==SHARP||LA157_0==MINUS||LA157_0==67||LA157_0==69||(LA157_0>=71 && LA157_0<=73)||(LA157_0>=76 && LA157_0<=92)) ) {
                    alt157=1;
                }
                switch (alt157) {
                    case 1 :
                        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:369: ( statement ( ( statement ) )* )
                        {
                        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:369: ( statement ( ( statement ) )* )
                        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:370: statement ( ( statement ) )*
                        {
                        pushFollow(FOLLOW_statement_in_synpred1302846);
                        statement();
                        _fsp--;
                        if (failed) return ;
                        // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:424: ( ( statement ) )*
                        loop156:
                        do {
                            int alt156=2;
                            int LA156_0 = input.LA(1);

                            if ( ((LA156_0>=NAME && LA156_0<=FLOAT)||LA156_0==LPAREN||LA156_0==SHARP||LA156_0==MINUS||LA156_0==67||LA156_0==69||(LA156_0>=71 && LA156_0<=73)||(LA156_0>=76 && LA156_0<=92)) ) {
                                alt156=1;
                            }


                            switch (alt156) {
                        	case 1 :
                        	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:425: ( statement )
                        	    {
                        	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:425: ( statement )
                        	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ATL\\Syntax\\ATL_ANTLR3.g:426:426: statement
                        	    {
                        	    pushFollow(FOLLOW_statement_in_synpred1302854);
                        	    statement();
                        	    _fsp--;
                        	    if (failed) return ;

                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop156;
                            }
                        } while (true);


                        }


                        }
                        break;

                }


                }


                }

                match(input,RCURLY,FOLLOW_RCURLY_in_synpred1302866); if (failed) return ;

                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred130

    public final boolean synpred122() {
        backtracking++;
        int start = input.mark();
        try {
            synpred122_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred123() {
        backtracking++;
        int start = input.mark();
        try {
            synpred123_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred121() {
        backtracking++;
        int start = input.mark();
        try {
            synpred121_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred130() {
        backtracking++;
        int start = input.mark();
        try {
            synpred130_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


    protected DFA105 dfa105 = new DFA105(this);
    static final String DFA105_eotS =
        "\11\uffff";
    static final String DFA105_eofS =
        "\11\uffff";
    static final String DFA105_minS =
        "\1\4\1\14\1\uffff\1\4\1\uffff\1\11\1\4\1\uffff\1\11";
    static final String DFA105_maxS =
        "\1\106\1\14\1\uffff\1\134\1\uffff\1\142\1\134\1\uffff\1\142";
    static final String DFA105_acceptS =
        "\2\uffff\1\2\1\uffff\1\3\2\uffff\1\1\1\uffff";
    static final String DFA105_specialS =
        "\11\uffff}>";
    static final String[] DFA105_transitionS = {
            "\1\1\101\uffff\1\2",
            "\1\3",
            "",
            "\1\5\3\4\4\uffff\2\4\6\uffff\1\4\1\uffff\1\4\54\uffff\1\4\3"+
            "\uffff\3\4\2\uffff\21\4",
            "",
            "\1\6\1\4\2\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\7\1\uffff\12"+
            "\4\76\uffff\6\4",
            "\1\10\3\4\4\uffff\1\4\7\uffff\1\4\1\uffff\1\4\54\uffff\1\4\3"+
            "\uffff\3\4\2\uffff\21\4",
            "",
            "\1\6\1\4\2\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\7\1\uffff\12"+
            "\4\76\uffff\6\4"
    };

    static final short[] DFA105_eot = DFA.unpackEncodedString(DFA105_eotS);
    static final short[] DFA105_eof = DFA.unpackEncodedString(DFA105_eofS);
    static final char[] DFA105_min = DFA.unpackEncodedStringToUnsignedChars(DFA105_minS);
    static final char[] DFA105_max = DFA.unpackEncodedStringToUnsignedChars(DFA105_maxS);
    static final short[] DFA105_accept = DFA.unpackEncodedString(DFA105_acceptS);
    static final short[] DFA105_special = DFA.unpackEncodedString(DFA105_specialS);
    static final short[][] DFA105_transition;

    static {
        int numStates = DFA105_transitionS.length;
        DFA105_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA105_transition[i] = DFA.unpackEncodedString(DFA105_transitionS[i]);
        }
    }

    class DFA105 extends DFA {

        public DFA105(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 105;
            this.eot = DFA105_eot;
            this.eof = DFA105_eof;
            this.min = DFA105_min;
            this.max = DFA105_max;
            this.accept = DFA105_accept;
            this.special = DFA105_special;
            this.transition = DFA105_transition;
        }
        public String getDescription() {
            return "970:192: (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )";
        }
    }
 

    public static final BitSet FOLLOW_unit_in_main61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifier97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_identifierOrKeyword137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_identifierOrKeyword142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_identifierOrKeyword147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_identifierOrKeyword152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_identifierOrKeyword157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_identifierOrKeyword162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_identifierOrKeyword167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_identifierOrKeyword182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_identifierOrKeyword187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_identifierOrKeyword192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_identifierOrKeyword197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_identifierOrKeyword202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_identifierOrKeyword207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_identifierOrKeyword212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_identifierOrKeyword217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_identifierOrKeyword222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_identifierOrKeyword227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_identifierOrKeyword232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_identifierOrKeyword237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_identifierOrKeyword242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_identifierOrKeyword247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_identifierOrKeyword252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_identifierOrKeyword257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_identifierOrKeyword262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_identifierOrKeyword267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_identifierOrKeyword272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_identifierOrKeyword277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_identifierOrKeyword282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_identifierOrKeyword287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_identifierOrKeyword292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_identifierOrKeyword297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_identifierOrKeyword302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_identifierOrKeyword307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_identifierOrKeyword312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_identifierOrKeyword317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_identifierOrKeyword322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_identifierOrKeyword327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_identifierOrKeyword332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_identifierOrKeyword337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_identifierOrKeyword342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_identifierOrKeyword347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_identifierOrKeyword352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_identifierOrKeyword357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_identifierOrKeyword362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_identifierOrKeyword367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_identifierOrKeyword372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_identifierOrKeyword377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_identifierOrKeyword382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_identifierOrKeyword387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_identifierOrKeyword392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_identifierOrKeyword397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_identifierOrKeyword402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_identifierOrKeyword407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_identifierOrKeyword412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_identifierOrKeyword417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_module_in_unit556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_library_in_unit561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_unit566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_module599 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_module603 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_module607 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_module609 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module615 = new BitSet(new long[]{0x0000300000000200L});
    public static final BitSet FOLLOW_COMA_in_module622 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module627 = new BitSet(new long[]{0x0000300000000200L});
    public static final BitSet FOLLOW_44_in_module638 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_45_in_module645 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module655 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_COMA_in_module662 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module667 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_SEMI_in_module676 = new BitSet(new long[]{0x1E73100000000002L});
    public static final BitSet FOLLOW_libraryRef_in_module684 = new BitSet(new long[]{0x1E73100000000002L});
    public static final BitSet FOLLOW_libraryRef_in_module692 = new BitSet(new long[]{0x1E73100000000002L});
    public static final BitSet FOLLOW_moduleElement_in_module706 = new BitSet(new long[]{0x1E72100000000002L});
    public static final BitSet FOLLOW_moduleElement_in_module714 = new BitSet(new long[]{0x1E72100000000002L});
    public static final BitSet FOLLOW_46_in_library756 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_library760 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_library764 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_library772 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_library780 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_helper_in_library794 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_helper_in_library802 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_47_in_query844 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_query848 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_query852 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_query856 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_query860 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_query868 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_query876 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_helper_in_query890 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_helper_in_query898 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_48_in_libraryRef940 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_libraryRef944 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_libraryRef948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_helper_in_moduleElement983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_moduleElement988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_helper1021 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_oclFeatureDefinition_in_helper1025 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_helper1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclContextDefinition_in_oclFeatureDefinition1065 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_oclFeatureDefinition1079 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_oclFeatureDefinition1081 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclFeature_in_oclFeatureDefinition1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_oclContextDefinition1119 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_oclContextDefinition1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operation_in_oclFeature1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_oclFeature1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_operation1200 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_operation1204 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_parameter_in_operation1210 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_operation1217 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parameter_in_operation1222 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_operation1232 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_operation1234 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_operation1238 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_operation1242 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_operation1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_parameter1286 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_parameter1290 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_parameter1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_attribute1330 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_attribute1334 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_attribute1338 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_attribute1342 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_attribute1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_calledRule_in_rule1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_matchedRule_in_rule1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lazyMatchedRule_in_matchedRule1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_matchedRule_abstractContents_in_matchedRule1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_lazyMatchedRule1468 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_lazyMatchedRule1480 = new BitSet(new long[]{0x0060100000000000L});
    public static final BitSet FOLLOW_53_in_lazyMatchedRule1484 = new BitSet(new long[]{0x0040100000000000L});
    public static final BitSet FOLLOW_44_in_lazyMatchedRule1498 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_lazyMatchedRule1510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lazyMatchedRule1514 = new BitSet(new long[]{0x0080000000004000L});
    public static final BitSet FOLLOW_55_in_lazyMatchedRule1520 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lazyMatchedRule1524 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_lazyMatchedRule1538 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_inPattern_in_lazyMatchedRule1544 = new BitSet(new long[]{0x4100000000008000L,0x0000000000000004L});
    public static final BitSet FOLLOW_56_in_lazyMatchedRule1550 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_lazyMatchedRule1552 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1560 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1568 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RCURLY_in_lazyMatchedRule1580 = new BitSet(new long[]{0x4000000000008000L,0x0000000000000004L});
    public static final BitSet FOLLOW_outPattern_in_lazyMatchedRule1596 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000004L});
    public static final BitSet FOLLOW_actionBlock_in_lazyMatchedRule1614 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RCURLY_in_lazyMatchedRule1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ruleVariableDeclaration1664 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_ruleVariableDeclaration1668 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_ruleVariableDeclaration1672 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_ruleVariableDeclaration1676 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_ruleVariableDeclaration1680 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_ruleVariableDeclaration1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_calledRule1718 = new BitSet(new long[]{0x1040000000000000L});
    public static final BitSet FOLLOW_60_in_calledRule1732 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_calledRule1744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_calledRule1748 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_calledRule1752 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_parameter_in_calledRule1758 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_calledRule1765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parameter_in_calledRule1770 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_calledRule1780 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_calledRule1782 = new BitSet(new long[]{0x4100000000008000L,0x0000000000000004L});
    public static final BitSet FOLLOW_56_in_calledRule1788 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_calledRule1790 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_calledRule1798 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_calledRule1806 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RCURLY_in_calledRule1818 = new BitSet(new long[]{0x4000000000008000L,0x0000000000000004L});
    public static final BitSet FOLLOW_outPattern_in_calledRule1834 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000004L});
    public static final BitSet FOLLOW_actionBlock_in_calledRule1852 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RCURLY_in_calledRule1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_inPattern1900 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inPatternElement_in_inPattern1908 = new BitSet(new long[]{0x0000000000001202L});
    public static final BitSet FOLLOW_COMA_in_inPattern1915 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inPatternElement_in_inPattern1920 = new BitSet(new long[]{0x0000000000001202L});
    public static final BitSet FOLLOW_LPAREN_in_inPattern1931 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_inPattern1937 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_inPattern1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleInPatternElement_in_inPatternElement1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2023 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_simpleInPatternElement2027 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_simpleInPatternElement2031 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_simpleInPatternElement2037 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2043 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_COMA_in_simpleInPatternElement2050 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2055 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_62_in_outPattern2105 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_outPatternElement_in_outPattern2113 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_COMA_in_outPattern2120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_outPatternElement_in_outPattern2125 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_simpleOutPatternElement_in_outPatternElement2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forEachOutPatternElement_in_outPatternElement2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2209 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_simpleOutPatternElement2213 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_simpleOutPatternElement2217 = new BitSet(new long[]{0xA000000000011002L});
    public static final BitSet FOLLOW_61_in_simpleOutPatternElement2223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2227 = new BitSet(new long[]{0x8000000000011002L});
    public static final BitSet FOLLOW_63_in_simpleOutPatternElement2243 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2247 = new BitSet(new long[]{0x0000000000011002L});
    public static final BitSet FOLLOW_RARROW_in_simpleOutPatternElement2263 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_simpleOutPatternElement2265 = new BitSet(new long[]{0x00000000005030F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_simpleOutPatternElement2271 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_simpleOutPatternElement2278 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_simpleOutPatternElement2283 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_simpleOutPatternElement2293 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LPAREN_in_simpleOutPatternElement2307 = new BitSet(new long[]{0xFFFFFC0000002010L,0x00000007FFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_simpleOutPatternElement2315 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_simpleOutPatternElement2322 = new BitSet(new long[]{0xFFFFFC0000000010L,0x00000007FFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_simpleOutPatternElement2327 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_simpleOutPatternElement2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_forEachOutPatternElement2383 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_forEachOutPatternElement2387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_forEachOutPatternElement2389 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_forEachOutPatternElement2393 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_forEachOutPatternElement2397 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_forEachOutPatternElement2399 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_forEachOutPatternElement2403 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_forEachOutPatternElement2407 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_forEachOutPatternElement2411 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_forEachOutPatternElement2415 = new BitSet(new long[]{0x8000000000001002L});
    public static final BitSet FOLLOW_63_in_forEachOutPatternElement2419 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_forEachOutPatternElement2423 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LPAREN_in_forEachOutPatternElement2439 = new BitSet(new long[]{0xFFFFFC0000002010L,0x00000007FFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_forEachOutPatternElement2447 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_forEachOutPatternElement2454 = new BitSet(new long[]{0xFFFFFC0000000010L,0x00000007FFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_forEachOutPatternElement2459 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_forEachOutPatternElement2471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_binding2515 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_LARROW_in_binding2519 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_binding2523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_actionBlock2557 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_actionBlock2559 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_actionBlock2567 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_actionBlock2575 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_RCURLY_in_actionBlock2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_statement2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStat_in_statement2627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bindingStat_in_statement2632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStat_in_statement2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclExpression_in_bindingStat2672 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_LARROW_in_bindingStat2676 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_bindingStat2680 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_bindingStat2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclExpression_in_expressionStat2718 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_expressionStat2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ifStat2754 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_ifStat2756 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_ifStat2760 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_ifStat2764 = new BitSet(new long[]{0x00000000005050F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_ifStat2772 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_LCURLY_in_ifStat2783 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_ifStat2791 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_ifStat2799 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_RCURLY_in_ifStat2811 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ifStat2819 = new BitSet(new long[]{0x00000000005050F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_ifStat2827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_ifStat2838 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_ifStat2846 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_ifStat2854 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_RCURLY_in_ifStat2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_forStat2912 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_forStat2914 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_forStat2918 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_forStat2922 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_forStat2926 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_forStat2930 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_forStat2932 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_forStat2940 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_forStat2948 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_RCURLY_in_forStat2960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_oclModel2994 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_oclModel2998 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_oclModel3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_oclModelElement3038 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EXCL_in_oclModelElement3042 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_oclModelElement3046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_5_in_oclExpression3082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letExp_in_oclExpression3087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_iteratorExp3122 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_iteratorExp3126 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iteratorExp3132 = new BitSet(new long[]{0x0000000000080200L});
    public static final BitSet FOLLOW_COMA_in_iteratorExp3139 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iteratorExp3144 = new BitSet(new long[]{0x0000000000080200L});
    public static final BitSet FOLLOW_PIPE_in_iteratorExp3153 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_iteratorExp3159 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_iteratorExp3165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_iterateExp3198 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_iterateExp3200 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iterateExp3206 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_COMA_in_iterateExp3213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iterateExp3218 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_SEMI_in_iterateExp3227 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclaration_in_iterateExp3231 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_PIPE_in_iterateExp3235 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_iterateExp3241 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_iterateExp3247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_collectionOperationCallExp3282 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionOperationCallExp3286 = new BitSet(new long[]{0x00000000005030F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_collectionOperationCallExp3292 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_collectionOperationCallExp3299 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_collectionOperationCallExp3304 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_collectionOperationCallExp3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_operationCallExp3349 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_operationCallExp3353 = new BitSet(new long[]{0x00000000005030F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_operationCallExp3359 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_operationCallExp3366 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_operationCallExp3371 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_operationCallExp3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_navigationOrAttributeCallExp3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_iterator3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_oclUndefinedExp3515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericExp_in_primitiveExp3550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanExp_in_primitiveExp3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExp_in_primitiveExp3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerExp_in_numericExp3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realExp_in_numericExp3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_booleanExp3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_booleanExp3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_integerExp3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatSymbol_in_realExp3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_stringExp3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ifExp3787 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_ifExp3791 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ifExp3795 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_ifExp3801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ifExp3807 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_ifExp3813 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ifExp3819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableExp3853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_superExp3887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_letExp3919 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclaration_in_letExp3923 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_letExp3927 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_letExp3933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableDeclaration3971 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_variableDeclaration3975 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_variableDeclaration3979 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_variableDeclaration3983 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_variableDeclaration3987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_enumLiteralExp4021 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_enumLiteralExp4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bagExp_in_collectionExp4062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setExp_in_collectionExp4067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orderedSetExp_in_collectionExp4072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceExp_in_collectionExp4077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_bagExp4110 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_bagExp4112 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_bagExp4118 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_bagExp4125 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_bagExp4130 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_bagExp4140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_setExp4172 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_setExp4174 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_setExp4180 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_setExp4187 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_setExp4192 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_setExp4202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_orderedSetExp4234 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_orderedSetExp4236 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_orderedSetExp4242 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_orderedSetExp4249 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_orderedSetExp4254 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_orderedSetExp4264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_sequenceExp4296 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_sequenceExp4298 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_sequenceExp4304 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_sequenceExp4311 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_sequenceExp4316 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_sequenceExp4326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_mapExp4358 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_mapExp4360 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_mapElement_in_mapExp4366 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_mapExp4373 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mapElement_in_mapExp4378 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_mapExp4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_mapElement4420 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_mapElement4424 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMA_in_mapElement4428 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_mapElement4432 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_mapElement4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_tupleExp4468 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_tupleExp4470 = new BitSet(new long[]{0xFFFFFC0000008010L,0x00000007FFFFFFFFL});
    public static final BitSet FOLLOW_tuplePart_in_tupleExp4476 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_tupleExp4483 = new BitSet(new long[]{0xFFFFFC0000000010L,0x00000007FFFFFFFFL});
    public static final BitSet FOLLOW_tuplePart_in_tupleExp4488 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_tupleExp4498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tuplePart4532 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COLON_in_tuplePart4538 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_tuplePart4542 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tuplePart4556 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_tuplePart4560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclModelElement_in_oclType4597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclAnyType_in_oclType4602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleType_in_oclType4607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapType_in_oclType4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitive_in_oclType4617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_oclType4622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclType_abstractContents_in_oclType4627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_oclAnyType4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_tupleType4692 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_tupleType4694 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_tupleTypeAttribute_in_tupleType4700 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_tupleType4707 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_tupleTypeAttribute_in_tupleType4712 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_tupleType4722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tupleTypeAttribute4756 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_tupleTypeAttribute4760 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_tupleTypeAttribute4764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_mapType4798 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_mapType4800 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_mapType4804 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMA_in_mapType4808 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_mapType4812 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_mapType4816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericType_in_primitive4851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanType_in_primitive4856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringType_in_primitive4861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerType_in_numericType4897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realType_in_numericType4902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_integerType4935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_realType4967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_booleanType4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_stringType5031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bagType_in_collectionType5066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setType_in_collectionType5071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orderedSetType_in_collectionType5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceType_in_collectionType5081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_abstractContents_in_collectionType5086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_bagType5119 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_bagType5121 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_bagType5125 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_bagType5129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_setType5161 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_setType5163 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_setType5167 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_setType5171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_orderedSetType5203 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_orderedSetType5205 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_orderedSetType5209 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_orderedSetType5213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_sequenceType5245 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_sequenceType5247 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_sequenceType5251 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_sequenceType5255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_oclExpression_in_priority_05289 = new BitSet(new long[]{0x0000000000210002L});
    public static final BitSet FOLLOW_POINT_in_priority_05294 = new BitSet(new long[]{0xFFFFFC0000000010L,0x00000007FFFFFFFFL});
    public static final BitSet FOLLOW_operationCallExp_in_priority_05301 = new BitSet(new long[]{0x0000000000210002L});
    public static final BitSet FOLLOW_navigationOrAttributeCallExp_in_priority_05308 = new BitSet(new long[]{0x0000000000210002L});
    public static final BitSet FOLLOW_RARROW_in_priority_05316 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_iteratorExp_in_priority_05323 = new BitSet(new long[]{0x0000000000210002L});
    public static final BitSet FOLLOW_iterateExp_in_priority_05330 = new BitSet(new long[]{0x0000000000210002L});
    public static final BitSet FOLLOW_collectionOperationCallExp_in_priority_05337 = new BitSet(new long[]{0x0000000000210002L});
    public static final BitSet FOLLOW_92_in_priority_15377 = new BitSet(new long[]{0x00000000001010F0L,0x000000000FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_15384 = new BitSet(new long[]{0x00000000001010F0L,0x000000000FFFD388L});
    public static final BitSet FOLLOW_priority_0_in_priority_15389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_priority_15397 = new BitSet(new long[]{0x00000000001010F0L,0x000000000FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_15404 = new BitSet(new long[]{0x00000000001010F0L,0x000000000FFFD388L});
    public static final BitSet FOLLOW_priority_0_in_priority_15409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_0_in_priority_15419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_1_in_priority_25454 = new BitSet(new long[]{0x0000000001800002L,0x0000000060000000L});
    public static final BitSet FOLLOW_STAR_in_priority_25459 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25466 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_1_in_priority_25471 = new BitSet(new long[]{0x0000000001800002L,0x0000000060000000L});
    public static final BitSet FOLLOW_SLASH_in_priority_25479 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25486 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_1_in_priority_25491 = new BitSet(new long[]{0x0000000001800002L,0x0000000060000000L});
    public static final BitSet FOLLOW_93_in_priority_25499 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25506 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_1_in_priority_25511 = new BitSet(new long[]{0x0000000001800002L,0x0000000060000000L});
    public static final BitSet FOLLOW_94_in_priority_25519 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25526 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_1_in_priority_25531 = new BitSet(new long[]{0x0000000001800002L,0x0000000060000000L});
    public static final BitSet FOLLOW_priority_2_in_priority_35572 = new BitSet(new long[]{0x0000000002400002L});
    public static final BitSet FOLLOW_PLUS_in_priority_35577 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_35584 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_2_in_priority_35589 = new BitSet(new long[]{0x0000000002400002L});
    public static final BitSet FOLLOW_MINUS_in_priority_35597 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_35604 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_2_in_priority_35609 = new BitSet(new long[]{0x0000000002400002L});
    public static final BitSet FOLLOW_priority_3_in_priority_45650 = new BitSet(new long[]{0x000000007C000402L});
    public static final BitSet FOLLOW_EQ_in_priority_45655 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45662 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_3_in_priority_45667 = new BitSet(new long[]{0x000000007C000402L});
    public static final BitSet FOLLOW_GT_in_priority_45675 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45682 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_3_in_priority_45687 = new BitSet(new long[]{0x000000007C000402L});
    public static final BitSet FOLLOW_LT_in_priority_45695 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45702 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_3_in_priority_45707 = new BitSet(new long[]{0x000000007C000402L});
    public static final BitSet FOLLOW_GE_in_priority_45715 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45722 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_3_in_priority_45727 = new BitSet(new long[]{0x000000007C000402L});
    public static final BitSet FOLLOW_LE_in_priority_45735 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45742 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_3_in_priority_45747 = new BitSet(new long[]{0x000000007C000402L});
    public static final BitSet FOLLOW_NE_in_priority_45755 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45762 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_3_in_priority_45767 = new BitSet(new long[]{0x000000007C000402L});
    public static final BitSet FOLLOW_priority_4_in_priority_55808 = new BitSet(new long[]{0x0000000000000002L,0x0000000780000000L});
    public static final BitSet FOLLOW_95_in_priority_55813 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55820 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_4_in_priority_55825 = new BitSet(new long[]{0x0000000000000002L,0x0000000780000000L});
    public static final BitSet FOLLOW_96_in_priority_55833 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55840 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_4_in_priority_55845 = new BitSet(new long[]{0x0000000000000002L,0x0000000780000000L});
    public static final BitSet FOLLOW_97_in_priority_55853 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55860 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_4_in_priority_55865 = new BitSet(new long[]{0x0000000000000002L,0x0000000780000000L});
    public static final BitSet FOLLOW_98_in_priority_55873 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55880 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFD388L});
    public static final BitSet FOLLOW_priority_4_in_priority_55885 = new BitSet(new long[]{0x0000000000000002L,0x0000000780000000L});
    public static final BitSet FOLLOW_52_in_matchedRule_abstractContents5926 = new BitSet(new long[]{0x0060100000000000L});
    public static final BitSet FOLLOW_53_in_matchedRule_abstractContents5940 = new BitSet(new long[]{0x0040100000000000L});
    public static final BitSet FOLLOW_44_in_matchedRule_abstractContents5954 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_matchedRule_abstractContents5966 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_matchedRule_abstractContents5970 = new BitSet(new long[]{0x0080000000004000L});
    public static final BitSet FOLLOW_55_in_matchedRule_abstractContents5976 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_matchedRule_abstractContents5980 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_matchedRule_abstractContents5994 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_inPattern_in_matchedRule_abstractContents6000 = new BitSet(new long[]{0x4100000000008000L,0x0000000000000004L});
    public static final BitSet FOLLOW_56_in_matchedRule_abstractContents6006 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_matchedRule_abstractContents6008 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6016 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6024 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RCURLY_in_matchedRule_abstractContents6036 = new BitSet(new long[]{0x4000000000008000L,0x0000000000000004L});
    public static final BitSet FOLLOW_outPattern_in_matchedRule_abstractContents6052 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000004L});
    public static final BitSet FOLLOW_actionBlock_in_matchedRule_abstractContents6070 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RCURLY_in_matchedRule_abstractContents6086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_oclType_abstractContents6118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_collectionType_abstractContents6150 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionType_abstractContents6152 = new BitSet(new long[]{0x0000000000000010L,0x000000000FF7C000L});
    public static final BitSet FOLLOW_oclType_in_collectionType_abstractContents6156 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_collectionType_abstractContents6160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_oclExpression6193 = new BitSet(new long[]{0x00000000005010F0L,0x000000001FFFF388L});
    public static final BitSet FOLLOW_oclExpression_in_primary_oclExpression6197 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_oclExpression6199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExp_in_primary_oclExpression6205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclUndefinedExp_in_primary_oclExpression6210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveExp_in_primary_oclExpression6215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifExp_in_primary_oclExpression6220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_superExp_in_primary_oclExpression6225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumLiteralExp_in_primary_oclExpression6230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionExp_in_primary_oclExpression6235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapExp_in_primary_oclExpression6240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleExp_in_primary_oclExpression6245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclType_in_primary_oclExpression6250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_synpred1212622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStat_in_synpred1222627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bindingStat_in_synpred1232632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred1302819 = new BitSet(new long[]{0x00000000005050F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_synpred1302827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_synpred1302838 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_synpred1302846 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_statement_in_synpred1302854 = new BitSet(new long[]{0x00000000005090F0L,0x000000001FFFF3A8L});
    public static final BitSet FOLLOW_RCURLY_in_synpred1302866 = new BitSet(new long[]{0x0000000000000002L});

}