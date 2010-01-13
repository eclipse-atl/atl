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
// $ANTLR 3.0.1 ATL_ANTLR3.g 2010-01-06 13:02:31
package org.eclipse.m2m.atl.dsls.tcs.injector;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ATL_ANTLR3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "SEMI", "COMA", "EQ", "COLON", "LPAREN", "RPAREN", "LCURLY", "RCURLY", "RARROW", "ASSIGNARROW", "LARROW", "EXCL", "PIPE", "SHARP", "POINT", "MINUS", "STAR", "SLASH", "PLUS", "GT", "LT", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "LSQUARE", "RSQUARE", "QMARK", "AROBAS", "COMMENT", "'module'", "'create'", "'refining'", "'from'", "'library'", "'query'", "'uses'", "'helper'", "'def'", "'context'", "'nodefault'", "'abstract'", "'rule'", "'extends'", "'using'", "'unique'", "'lazy'", "'entrypoint'", "'endpoint'", "'in'", "'to'", "'mapsTo'", "'distinct'", "'foreach'", "'do'", "'if'", "'else'", "'for'", "'iterate'", "'OclUndefined'", "'true'", "'false'", "'then'", "'endif'", "'super'", "'let'", "'Bag'", "'Set'", "'OrderedSet'", "'Sequence'", "'Map'", "'Tuple'", "'OclType'", "'OclAny'", "'TupleType'", "'Integer'", "'Real'", "'Boolean'", "'String'", "'Collection'", "'not'", "'div'", "'mod'", "'and'", "'or'", "'xor'", "'implies'"
    };
    public static final int GE=29;
    public static final int LT=28;
    public static final int STAR=24;
    public static final int ASSIGNARROW=17;
    public static final int LSQUARE=38;
    public static final int SHARP=21;
    public static final int POINT=22;
    public static final int AROBAS=41;
    public static final int ESC=37;
    public static final int RARROW=16;
    public static final int LARROW=18;
    public static final int LCURLY=14;
    public static final int FLOAT=7;
    public static final int INT=6;
    public static final int EXCL=19;
    public static final int RSQUARE=39;
    public static final int MINUS=23;
    public static final int EOF=-1;
    public static final int COMA=9;
    public static final int SEMI=8;
    public static final int ALPHA=35;
    public static final int LPAREN=12;
    public static final int COLON=11;
    public static final int RPAREN=13;
    public static final int NAME=4;
    public static final int WS=33;
    public static final int SLASH=25;
    public static final int SNAME=36;
    public static final int RCURLY=15;
    public static final int GT=27;
    public static final int PLUS=26;
    public static final int PIPE=20;
    public static final int DIGIT=34;
    public static final int NL=32;
    public static final int EQ=10;
    public static final int COMMENT=42;
    public static final int QMARK=40;
    public static final int LE=30;
    public static final int STRING=5;
    public static final int NE=31;

        public ATL_ANTLR3Parser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[314+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "ATL_ANTLR3.g"; }


        public org.eclipse.m2m.atl.dsls.tcs.injector.TCSRuntime ei = null;
        
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
    // ATL_ANTLR3.g:63:1: main returns [Object ret2] : ( (ret= unit ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:64:2: ( ( (ret= unit ) EOF ) )
            // ATL_ANTLR3.g:64:4: ( (ret= unit ) EOF )
            {
            // ATL_ANTLR3.g:64:4: ( (ret= unit ) EOF )
            // ATL_ANTLR3.g:64:5: (ret= unit ) EOF
            {
            // ATL_ANTLR3.g:64:5: (ret= unit )
            // ATL_ANTLR3.g:64:6: ret= unit
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
    // ATL_ANTLR3.g:71:1: identifier returns [Object ret2] : ast= NAME ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ATL_ANTLR3.g:72:2: (ast= NAME )
            // ATL_ANTLR3.g:72:4: ast= NAME
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
    // ATL_ANTLR3.g:79:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ATL_ANTLR3.g:80:2: ( (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' ) )
            // ATL_ANTLR3.g:80:4: (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )
            {
            // ATL_ANTLR3.g:80:4: (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )
            int alt1=58;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 43:
                {
                alt1=2;
                }
                break;
            case 44:
                {
                alt1=3;
                }
                break;
            case 45:
                {
                alt1=4;
                }
                break;
            case 46:
                {
                alt1=5;
                }
                break;
            case 47:
                {
                alt1=6;
                }
                break;
            case 48:
                {
                alt1=7;
                }
                break;
            case 49:
                {
                alt1=8;
                }
                break;
            case 50:
                {
                alt1=9;
                }
                break;
            case 51:
                {
                alt1=10;
                }
                break;
            case 52:
                {
                alt1=11;
                }
                break;
            case 53:
                {
                alt1=12;
                }
                break;
            case 54:
                {
                alt1=13;
                }
                break;
            case 55:
                {
                alt1=14;
                }
                break;
            case 56:
                {
                alt1=15;
                }
                break;
            case 57:
                {
                alt1=16;
                }
                break;
            case 58:
                {
                alt1=17;
                }
                break;
            case 59:
                {
                alt1=18;
                }
                break;
            case 60:
                {
                alt1=19;
                }
                break;
            case 61:
                {
                alt1=20;
                }
                break;
            case 62:
                {
                alt1=21;
                }
                break;
            case 63:
                {
                alt1=22;
                }
                break;
            case 64:
                {
                alt1=23;
                }
                break;
            case 65:
                {
                alt1=24;
                }
                break;
            case 66:
                {
                alt1=25;
                }
                break;
            case 67:
                {
                alt1=26;
                }
                break;
            case 68:
                {
                alt1=27;
                }
                break;
            case 69:
                {
                alt1=28;
                }
                break;
            case 70:
                {
                alt1=29;
                }
                break;
            case 71:
                {
                alt1=30;
                }
                break;
            case 72:
                {
                alt1=31;
                }
                break;
            case 73:
                {
                alt1=32;
                }
                break;
            case 74:
                {
                alt1=33;
                }
                break;
            case 75:
                {
                alt1=34;
                }
                break;
            case 76:
                {
                alt1=35;
                }
                break;
            case 77:
                {
                alt1=36;
                }
                break;
            case 78:
                {
                alt1=37;
                }
                break;
            case 79:
                {
                alt1=38;
                }
                break;
            case 80:
                {
                alt1=39;
                }
                break;
            case 81:
                {
                alt1=40;
                }
                break;
            case 82:
                {
                alt1=41;
                }
                break;
            case 83:
                {
                alt1=42;
                }
                break;
            case 84:
                {
                alt1=43;
                }
                break;
            case 85:
                {
                alt1=44;
                }
                break;
            case 86:
                {
                alt1=45;
                }
                break;
            case 87:
                {
                alt1=46;
                }
                break;
            case 88:
                {
                alt1=47;
                }
                break;
            case 89:
                {
                alt1=48;
                }
                break;
            case 90:
                {
                alt1=49;
                }
                break;
            case 91:
                {
                alt1=50;
                }
                break;
            case 92:
                {
                alt1=51;
                }
                break;
            case 93:
                {
                alt1=52;
                }
                break;
            case 94:
                {
                alt1=53;
                }
                break;
            case 95:
                {
                alt1=54;
                }
                break;
            case 96:
                {
                alt1=55;
                }
                break;
            case 97:
                {
                alt1=56;
                }
                break;
            case 98:
                {
                alt1=57;
                }
                break;
            case 99:
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
                    // ATL_ANTLR3.g:80:5: ast= NAME
                    {
                    ast=(Token)input.LT(1);
                    match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword132); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = ast.getText(); ei.setToken((Object)ast);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:80:64: 'module'
                    {
                    match(input,43,FOLLOW_43_in_identifierOrKeyword137); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "module";
                    }

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:80:92: 'create'
                    {
                    match(input,44,FOLLOW_44_in_identifierOrKeyword142); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "create";
                    }

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:80:120: 'refining'
                    {
                    match(input,45,FOLLOW_45_in_identifierOrKeyword147); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "refining";
                    }

                    }
                    break;
                case 5 :
                    // ATL_ANTLR3.g:80:152: 'from'
                    {
                    match(input,46,FOLLOW_46_in_identifierOrKeyword152); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "from";
                    }

                    }
                    break;
                case 6 :
                    // ATL_ANTLR3.g:80:176: 'library'
                    {
                    match(input,47,FOLLOW_47_in_identifierOrKeyword157); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "library";
                    }

                    }
                    break;
                case 7 :
                    // ATL_ANTLR3.g:80:206: 'query'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword162); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "query";
                    }

                    }
                    break;
                case 8 :
                    // ATL_ANTLR3.g:80:232: 'uses'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword167); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "uses";
                    }

                    }
                    break;
                case 9 :
                    // ATL_ANTLR3.g:80:256: 'helper'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword172); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "helper";
                    }

                    }
                    break;
                case 10 :
                    // ATL_ANTLR3.g:80:284: 'def'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword177); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "def";
                    }

                    }
                    break;
                case 11 :
                    // ATL_ANTLR3.g:80:306: 'context'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword182); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "context";
                    }

                    }
                    break;
                case 12 :
                    // ATL_ANTLR3.g:80:336: 'nodefault'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword187); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "nodefault";
                    }

                    }
                    break;
                case 13 :
                    // ATL_ANTLR3.g:80:370: 'abstract'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword192); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 14 :
                    // ATL_ANTLR3.g:80:402: 'rule'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword197); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "rule";
                    }

                    }
                    break;
                case 15 :
                    // ATL_ANTLR3.g:80:426: 'extends'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword202); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "extends";
                    }

                    }
                    break;
                case 16 :
                    // ATL_ANTLR3.g:80:456: 'using'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword207); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "using";
                    }

                    }
                    break;
                case 17 :
                    // ATL_ANTLR3.g:80:482: 'unique'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword212); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "unique";
                    }

                    }
                    break;
                case 18 :
                    // ATL_ANTLR3.g:80:510: 'lazy'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword217); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "lazy";
                    }

                    }
                    break;
                case 19 :
                    // ATL_ANTLR3.g:80:534: 'entrypoint'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword222); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "entrypoint";
                    }

                    }
                    break;
                case 20 :
                    // ATL_ANTLR3.g:80:570: 'endpoint'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword227); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "endpoint";
                    }

                    }
                    break;
                case 21 :
                    // ATL_ANTLR3.g:80:602: 'in'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword232); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "in";
                    }

                    }
                    break;
                case 22 :
                    // ATL_ANTLR3.g:80:622: 'to'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword237); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "to";
                    }

                    }
                    break;
                case 23 :
                    // ATL_ANTLR3.g:80:642: 'mapsTo'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword242); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "mapsTo";
                    }

                    }
                    break;
                case 24 :
                    // ATL_ANTLR3.g:80:670: 'distinct'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword247); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "distinct";
                    }

                    }
                    break;
                case 25 :
                    // ATL_ANTLR3.g:80:702: 'foreach'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword252); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "foreach";
                    }

                    }
                    break;
                case 26 :
                    // ATL_ANTLR3.g:80:732: 'do'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword257); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "do";
                    }

                    }
                    break;
                case 27 :
                    // ATL_ANTLR3.g:80:752: 'if'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword262); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "if";
                    }

                    }
                    break;
                case 28 :
                    // ATL_ANTLR3.g:80:772: 'else'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword267); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "else";
                    }

                    }
                    break;
                case 29 :
                    // ATL_ANTLR3.g:80:796: 'for'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword272); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "for";
                    }

                    }
                    break;
                case 30 :
                    // ATL_ANTLR3.g:80:818: 'iterate'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword277); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "iterate";
                    }

                    }
                    break;
                case 31 :
                    // ATL_ANTLR3.g:80:848: 'OclUndefined'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword282); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OclUndefined";
                    }

                    }
                    break;
                case 32 :
                    // ATL_ANTLR3.g:80:888: 'true'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword287); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 33 :
                    // ATL_ANTLR3.g:80:912: 'false'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword292); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 34 :
                    // ATL_ANTLR3.g:80:938: 'then'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword297); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "then";
                    }

                    }
                    break;
                case 35 :
                    // ATL_ANTLR3.g:80:962: 'endif'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword302); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "endif";
                    }

                    }
                    break;
                case 36 :
                    // ATL_ANTLR3.g:80:988: 'super'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword307); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "super";
                    }

                    }
                    break;
                case 37 :
                    // ATL_ANTLR3.g:80:1014: 'let'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword312); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "let";
                    }

                    }
                    break;
                case 38 :
                    // ATL_ANTLR3.g:80:1036: 'Bag'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword317); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Bag";
                    }

                    }
                    break;
                case 39 :
                    // ATL_ANTLR3.g:80:1058: 'Set'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword322); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Set";
                    }

                    }
                    break;
                case 40 :
                    // ATL_ANTLR3.g:80:1080: 'OrderedSet'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword327); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OrderedSet";
                    }

                    }
                    break;
                case 41 :
                    // ATL_ANTLR3.g:80:1116: 'Sequence'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword332); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Sequence";
                    }

                    }
                    break;
                case 42 :
                    // ATL_ANTLR3.g:80:1148: 'Map'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword337); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Map";
                    }

                    }
                    break;
                case 43 :
                    // ATL_ANTLR3.g:80:1170: 'Tuple'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword342); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Tuple";
                    }

                    }
                    break;
                case 44 :
                    // ATL_ANTLR3.g:80:1196: 'OclType'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword347); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OclType";
                    }

                    }
                    break;
                case 45 :
                    // ATL_ANTLR3.g:80:1226: 'OclAny'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword352); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OclAny";
                    }

                    }
                    break;
                case 46 :
                    // ATL_ANTLR3.g:80:1254: 'TupleType'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword357); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "TupleType";
                    }

                    }
                    break;
                case 47 :
                    // ATL_ANTLR3.g:80:1288: 'Integer'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword362); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Integer";
                    }

                    }
                    break;
                case 48 :
                    // ATL_ANTLR3.g:80:1318: 'Real'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword367); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Real";
                    }

                    }
                    break;
                case 49 :
                    // ATL_ANTLR3.g:80:1342: 'Boolean'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword372); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Boolean";
                    }

                    }
                    break;
                case 50 :
                    // ATL_ANTLR3.g:80:1372: 'String'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword377); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "String";
                    }

                    }
                    break;
                case 51 :
                    // ATL_ANTLR3.g:80:1400: 'Collection'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword382); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Collection";
                    }

                    }
                    break;
                case 52 :
                    // ATL_ANTLR3.g:80:1436: 'not'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword387); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "not";
                    }

                    }
                    break;
                case 53 :
                    // ATL_ANTLR3.g:80:1458: 'div'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword392); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "div";
                    }

                    }
                    break;
                case 54 :
                    // ATL_ANTLR3.g:80:1480: 'mod'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword397); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "mod";
                    }

                    }
                    break;
                case 55 :
                    // ATL_ANTLR3.g:80:1502: 'and'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword402); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 56 :
                    // ATL_ANTLR3.g:80:1524: 'or'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword407); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "or";
                    }

                    }
                    break;
                case 57 :
                    // ATL_ANTLR3.g:80:1544: 'xor'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword412); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "xor";
                    }

                    }
                    break;
                case 58 :
                    // ATL_ANTLR3.g:80:1566: 'implies'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword417); if (failed) return ret2;
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
    // ATL_ANTLR3.g:87:1: stringSymbol returns [Object ret2] : ast= STRING ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ATL_ANTLR3.g:88:2: (ast= STRING )
            // ATL_ANTLR3.g:88:4: ast= STRING
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
    // ATL_ANTLR3.g:95:1: integerSymbol returns [Object ret2] : ast= INT ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ATL_ANTLR3.g:96:2: (ast= INT )
            // ATL_ANTLR3.g:96:4: ast= INT
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
    // ATL_ANTLR3.g:103:1: floatSymbol returns [Object ret2] : ast= FLOAT ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ATL_ANTLR3.g:104:2: (ast= FLOAT )
            // ATL_ANTLR3.g:104:4: ast= FLOAT
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
    // ATL_ANTLR3.g:111:1: unit returns [Object ret2] : ( (ret= module | ret= library | ret= query ) ) ;
    public final Object unit() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:112:2: ( ( (ret= module | ret= library | ret= query ) ) )
            // ATL_ANTLR3.g:112:4: ( (ret= module | ret= library | ret= query ) )
            {
            // ATL_ANTLR3.g:112:4: ( (ret= module | ret= library | ret= query ) )
            // ATL_ANTLR3.g:112:5: (ret= module | ret= library | ret= query )
            {
            // ATL_ANTLR3.g:112:5: (ret= module | ret= library | ret= query )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt2=1;
                }
                break;
            case 47:
                {
                alt2=2;
                }
                break;
            case 48:
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
                    // ATL_ANTLR3.g:112:6: ret= module
                    {
                    pushFollow(FOLLOW_module_in_unit556);
                    ret=module();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:112:18: ret= library
                    {
                    pushFollow(FOLLOW_library_in_unit561);
                    ret=library();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:112:31: ret= query
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
    // ATL_ANTLR3.g:120:1: module returns [Object ret2] : ( 'module' temp= identifier SEMI 'create' ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) ( ( 'refining' ) | ( 'from' ) ) ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) ) ) ;
    public final Object module() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Module", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:121:2: ( ( 'module' temp= identifier SEMI 'create' ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) ( ( 'refining' ) | ( 'from' ) ) ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) ) ) )
            // ATL_ANTLR3.g:121:4: ( 'module' temp= identifier SEMI 'create' ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) ( ( 'refining' ) | ( 'from' ) ) ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) ) )
            {
            // ATL_ANTLR3.g:121:4: ( 'module' temp= identifier SEMI 'create' ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) ( ( 'refining' ) | ( 'from' ) ) ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) ) )
            // ATL_ANTLR3.g:121:5: 'module' temp= identifier SEMI 'create' ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) ( ( 'refining' ) | ( 'from' ) ) ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) ) SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) )
            {
            match(input,43,FOLLOW_43_in_module599); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_module603);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_module607); if (failed) return ret2;
            match(input,44,FOLLOW_44_in_module609); if (failed) return ret2;
            // ATL_ANTLR3.g:121:73: ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) )
            // ATL_ANTLR3.g:121:74: (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* )
            {
            // ATL_ANTLR3.g:121:74: (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* )
            // ATL_ANTLR3.g:121:75: temp= oclModel ( ( ( COMA ) temp= oclModel ) )*
            {
            pushFollow(FOLLOW_oclModel_in_module615);
            temp=oclModel();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "outModels", temp);
            }
            // ATL_ANTLR3.g:121:123: ( ( ( COMA ) temp= oclModel ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==COMA) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ATL_ANTLR3.g:121:124: ( ( COMA ) temp= oclModel )
            	    {
            	    // ATL_ANTLR3.g:121:124: ( ( COMA ) temp= oclModel )
            	    // ATL_ANTLR3.g:121:125: ( COMA ) temp= oclModel
            	    {
            	    // ATL_ANTLR3.g:121:125: ( COMA )
            	    // ATL_ANTLR3.g:121:126: COMA
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

            // ATL_ANTLR3.g:121:185: ( ( 'refining' ) | ( 'from' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==45) ) {
                alt4=1;
            }
            else if ( (LA4_0==46) ) {
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
                    // ATL_ANTLR3.g:121:186: ( 'refining' )
                    {
                    // ATL_ANTLR3.g:121:186: ( 'refining' )
                    // ATL_ANTLR3.g:121:187: 'refining'
                    {
                    match(input,45,FOLLOW_45_in_module638); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:121:253: ( 'from' )
                    {
                    // ATL_ANTLR3.g:121:253: ( 'from' )
                    // ATL_ANTLR3.g:121:254: 'from'
                    {
                    match(input,46,FOLLOW_46_in_module645); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:121:317: ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) )
            // ATL_ANTLR3.g:121:318: (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* )
            {
            // ATL_ANTLR3.g:121:318: (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* )
            // ATL_ANTLR3.g:121:319: temp= oclModel ( ( ( COMA ) temp= oclModel ) )*
            {
            pushFollow(FOLLOW_oclModel_in_module655);
            temp=oclModel();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "inModels", temp);
            }
            // ATL_ANTLR3.g:121:366: ( ( ( COMA ) temp= oclModel ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ATL_ANTLR3.g:121:367: ( ( COMA ) temp= oclModel )
            	    {
            	    // ATL_ANTLR3.g:121:367: ( ( COMA ) temp= oclModel )
            	    // ATL_ANTLR3.g:121:368: ( COMA ) temp= oclModel
            	    {
            	    // ATL_ANTLR3.g:121:368: ( COMA )
            	    // ATL_ANTLR3.g:121:369: COMA
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
            // ATL_ANTLR3.g:121:432: ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? ) )
            // ATL_ANTLR3.g:121:433: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? )
            {
            // ATL_ANTLR3.g:121:433: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )? )
            // ATL_ANTLR3.g:121:434: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= moduleElement ( (temp= moduleElement ) )* ) )?
            {
            // ATL_ANTLR3.g:121:434: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==49) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ATL_ANTLR3.g:121:435: (temp= libraryRef ( (temp= libraryRef ) )* )
                    {
                    // ATL_ANTLR3.g:121:435: (temp= libraryRef ( (temp= libraryRef ) )* )
                    // ATL_ANTLR3.g:121:436: temp= libraryRef ( (temp= libraryRef ) )*
                    {
                    pushFollow(FOLLOW_libraryRef_in_module684);
                    temp=libraryRef();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "libraries", temp);
                    }
                    // ATL_ANTLR3.g:121:486: ( (temp= libraryRef ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==49) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:121:487: (temp= libraryRef )
                    	    {
                    	    // ATL_ANTLR3.g:121:487: (temp= libraryRef )
                    	    // ATL_ANTLR3.g:121:488: temp= libraryRef
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

            // ATL_ANTLR3.g:121:544: ( (temp= moduleElement ( (temp= moduleElement ) )* ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==45||LA9_0==50||(LA9_0>=53 && LA9_0<=55)||(LA9_0>=58 && LA9_0<=61)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ATL_ANTLR3.g:121:545: (temp= moduleElement ( (temp= moduleElement ) )* )
                    {
                    // ATL_ANTLR3.g:121:545: (temp= moduleElement ( (temp= moduleElement ) )* )
                    // ATL_ANTLR3.g:121:546: temp= moduleElement ( (temp= moduleElement ) )*
                    {
                    pushFollow(FOLLOW_moduleElement_in_module706);
                    temp=moduleElement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:121:598: ( (temp= moduleElement ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==45||LA8_0==50||(LA8_0>=53 && LA8_0<=55)||(LA8_0>=58 && LA8_0<=61)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:121:599: (temp= moduleElement )
                    	    {
                    	    // ATL_ANTLR3.g:121:599: (temp= moduleElement )
                    	    // ATL_ANTLR3.g:121:600: temp= moduleElement
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:131:1: library returns [Object ret2] : ( 'library' temp= identifier SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) ) ;
    public final Object library() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Library", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:132:2: ( ( 'library' temp= identifier SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) ) )
            // ATL_ANTLR3.g:132:4: ( 'library' temp= identifier SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) )
            {
            // ATL_ANTLR3.g:132:4: ( 'library' temp= identifier SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) )
            // ATL_ANTLR3.g:132:5: 'library' temp= identifier SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) )
            {
            match(input,47,FOLLOW_47_in_library756); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_library760);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_library764); if (failed) return ret2;
            // ATL_ANTLR3.g:132:65: ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) )
            // ATL_ANTLR3.g:132:66: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? )
            {
            // ATL_ANTLR3.g:132:66: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? )
            // ATL_ANTLR3.g:132:67: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )?
            {
            // ATL_ANTLR3.g:132:67: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==49) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ATL_ANTLR3.g:132:68: (temp= libraryRef ( (temp= libraryRef ) )* )
                    {
                    // ATL_ANTLR3.g:132:68: (temp= libraryRef ( (temp= libraryRef ) )* )
                    // ATL_ANTLR3.g:132:69: temp= libraryRef ( (temp= libraryRef ) )*
                    {
                    pushFollow(FOLLOW_libraryRef_in_library772);
                    temp=libraryRef();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "libraries", temp);
                    }
                    // ATL_ANTLR3.g:132:119: ( (temp= libraryRef ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==49) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:132:120: (temp= libraryRef )
                    	    {
                    	    // ATL_ANTLR3.g:132:120: (temp= libraryRef )
                    	    // ATL_ANTLR3.g:132:121: temp= libraryRef
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

            // ATL_ANTLR3.g:132:177: ( (temp= helper ( (temp= helper ) )* ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==50) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ATL_ANTLR3.g:132:178: (temp= helper ( (temp= helper ) )* )
                    {
                    // ATL_ANTLR3.g:132:178: (temp= helper ( (temp= helper ) )* )
                    // ATL_ANTLR3.g:132:179: temp= helper ( (temp= helper ) )*
                    {
                    pushFollow(FOLLOW_helper_in_library794);
                    temp=helper();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "helpers", temp);
                    }
                    // ATL_ANTLR3.g:132:223: ( (temp= helper ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==50) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:132:224: (temp= helper )
                    	    {
                    	    // ATL_ANTLR3.g:132:224: (temp= helper )
                    	    // ATL_ANTLR3.g:132:225: temp= helper
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:142:1: query returns [Object ret2] : ( 'query' temp= identifier EQ temp= oclExpression SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) ) ;
    public final Object query() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Query", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:143:2: ( ( 'query' temp= identifier EQ temp= oclExpression SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) ) )
            // ATL_ANTLR3.g:143:4: ( 'query' temp= identifier EQ temp= oclExpression SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) )
            {
            // ATL_ANTLR3.g:143:4: ( 'query' temp= identifier EQ temp= oclExpression SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) ) )
            // ATL_ANTLR3.g:143:5: 'query' temp= identifier EQ temp= oclExpression SEMI ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) )
            {
            match(input,48,FOLLOW_48_in_query844); if (failed) return ret2;
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
            // ATL_ANTLR3.g:143:114: ( ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? ) )
            // ATL_ANTLR3.g:143:115: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? )
            {
            // ATL_ANTLR3.g:143:115: ( ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )? )
            // ATL_ANTLR3.g:143:116: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )? ( (temp= helper ( (temp= helper ) )* ) )?
            {
            // ATL_ANTLR3.g:143:116: ( (temp= libraryRef ( (temp= libraryRef ) )* ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==49) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ATL_ANTLR3.g:143:117: (temp= libraryRef ( (temp= libraryRef ) )* )
                    {
                    // ATL_ANTLR3.g:143:117: (temp= libraryRef ( (temp= libraryRef ) )* )
                    // ATL_ANTLR3.g:143:118: temp= libraryRef ( (temp= libraryRef ) )*
                    {
                    pushFollow(FOLLOW_libraryRef_in_query868);
                    temp=libraryRef();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "libraries", temp);
                    }
                    // ATL_ANTLR3.g:143:168: ( (temp= libraryRef ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==49) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:143:169: (temp= libraryRef )
                    	    {
                    	    // ATL_ANTLR3.g:143:169: (temp= libraryRef )
                    	    // ATL_ANTLR3.g:143:170: temp= libraryRef
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

            // ATL_ANTLR3.g:143:226: ( (temp= helper ( (temp= helper ) )* ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==50) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ATL_ANTLR3.g:143:227: (temp= helper ( (temp= helper ) )* )
                    {
                    // ATL_ANTLR3.g:143:227: (temp= helper ( (temp= helper ) )* )
                    // ATL_ANTLR3.g:143:228: temp= helper ( (temp= helper ) )*
                    {
                    pushFollow(FOLLOW_helper_in_query890);
                    temp=helper();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "helpers", temp);
                    }
                    // ATL_ANTLR3.g:143:272: ( (temp= helper ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==50) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:143:273: (temp= helper )
                    	    {
                    	    // ATL_ANTLR3.g:143:273: (temp= helper )
                    	    // ATL_ANTLR3.g:143:274: temp= helper
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:153:1: libraryRef returns [Object ret2] : ( 'uses' temp= identifier SEMI ) ;
    public final Object libraryRef() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LibraryRef", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:154:2: ( ( 'uses' temp= identifier SEMI ) )
            // ATL_ANTLR3.g:154:4: ( 'uses' temp= identifier SEMI )
            {
            // ATL_ANTLR3.g:154:4: ( 'uses' temp= identifier SEMI )
            // ATL_ANTLR3.g:154:5: 'uses' temp= identifier SEMI
            {
            match(input,49,FOLLOW_49_in_libraryRef940); if (failed) return ret2;
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:164:1: moduleElement returns [Object ret2] : ( (ret= helper | ret= rule ) ) ;
    public final Object moduleElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:165:2: ( ( (ret= helper | ret= rule ) ) )
            // ATL_ANTLR3.g:165:4: ( (ret= helper | ret= rule ) )
            {
            // ATL_ANTLR3.g:165:4: ( (ret= helper | ret= rule ) )
            // ATL_ANTLR3.g:165:5: (ret= helper | ret= rule )
            {
            // ATL_ANTLR3.g:165:5: (ret= helper | ret= rule )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            else if ( (LA18_0==45||(LA18_0>=53 && LA18_0<=55)||(LA18_0>=58 && LA18_0<=61)) ) {
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
                    // ATL_ANTLR3.g:165:6: ret= helper
                    {
                    pushFollow(FOLLOW_helper_in_moduleElement983);
                    ret=helper();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:165:18: ret= rule
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
    // ATL_ANTLR3.g:173:1: helper returns [Object ret2] : ( 'helper' temp= oclFeatureDefinition SEMI ) ;
    public final Object helper() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Helper", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:174:2: ( ( 'helper' temp= oclFeatureDefinition SEMI ) )
            // ATL_ANTLR3.g:174:4: ( 'helper' temp= oclFeatureDefinition SEMI )
            {
            // ATL_ANTLR3.g:174:4: ( 'helper' temp= oclFeatureDefinition SEMI )
            // ATL_ANTLR3.g:174:5: 'helper' temp= oclFeatureDefinition SEMI
            {
            match(input,50,FOLLOW_50_in_helper1021); if (failed) return ret2;
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:184:1: oclFeatureDefinition returns [Object ret2] : ( ( (temp= oclContextDefinition ) | () ) 'def' COLON temp= oclFeature ) ;
    public final Object oclFeatureDefinition() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OclFeatureDefinition", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:185:2: ( ( ( (temp= oclContextDefinition ) | () ) 'def' COLON temp= oclFeature ) )
            // ATL_ANTLR3.g:185:4: ( ( (temp= oclContextDefinition ) | () ) 'def' COLON temp= oclFeature )
            {
            // ATL_ANTLR3.g:185:4: ( ( (temp= oclContextDefinition ) | () ) 'def' COLON temp= oclFeature )
            // ATL_ANTLR3.g:185:5: ( (temp= oclContextDefinition ) | () ) 'def' COLON temp= oclFeature
            {
            // ATL_ANTLR3.g:185:5: ( (temp= oclContextDefinition ) | () )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==52) ) {
                alt19=1;
            }
            else if ( (LA19_0==51) ) {
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
                    // ATL_ANTLR3.g:185:6: (temp= oclContextDefinition )
                    {
                    // ATL_ANTLR3.g:185:6: (temp= oclContextDefinition )
                    // ATL_ANTLR3.g:185:7: temp= oclContextDefinition
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
                    // ATL_ANTLR3.g:185:71: ()
                    {
                    // ATL_ANTLR3.g:185:71: ()
                    // ATL_ANTLR3.g:185:72: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            match(input,51,FOLLOW_51_in_oclFeatureDefinition1079); if (failed) return ret2;
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:195:1: oclContextDefinition returns [Object ret2] : ( 'context' temp= oclType ) ;
    public final Object oclContextDefinition() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OclContextDefinition", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:196:2: ( ( 'context' temp= oclType ) )
            // ATL_ANTLR3.g:196:4: ( 'context' temp= oclType )
            {
            // ATL_ANTLR3.g:196:4: ( 'context' temp= oclType )
            // ATL_ANTLR3.g:196:5: 'context' temp= oclType
            {
            match(input,52,FOLLOW_52_in_oclContextDefinition1119); if (failed) return ret2;
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:206:1: oclFeature returns [Object ret2] : ( (ret= operation | ret= attribute ) ) ;
    public final Object oclFeature() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:207:2: ( ( (ret= operation | ret= attribute ) ) )
            // ATL_ANTLR3.g:207:4: ( (ret= operation | ret= attribute ) )
            {
            // ATL_ANTLR3.g:207:4: ( (ret= operation | ret= attribute ) )
            // ATL_ANTLR3.g:207:5: (ret= operation | ret= attribute )
            {
            // ATL_ANTLR3.g:207:5: (ret= operation | ret= attribute )
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
                    // ATL_ANTLR3.g:207:6: ret= operation
                    {
                    pushFollow(FOLLOW_operation_in_oclFeature1160);
                    ret=operation();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:207:21: ret= attribute
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
    // ATL_ANTLR3.g:215:1: operation returns [Object ret2] : (temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN COLON temp= oclType EQ ( (temp= oclExpression ) ) ) ;
    public final Object operation() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Operation", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:216:2: ( (temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN COLON temp= oclType EQ ( (temp= oclExpression ) ) ) )
            // ATL_ANTLR3.g:216:4: (temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN COLON temp= oclType EQ ( (temp= oclExpression ) ) )
            {
            // ATL_ANTLR3.g:216:4: (temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN COLON temp= oclType EQ ( (temp= oclExpression ) ) )
            // ATL_ANTLR3.g:216:5: temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN COLON temp= oclType EQ ( (temp= oclExpression ) )
            {
            pushFollow(FOLLOW_identifier_in_operation1200);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_operation1204); if (failed) return ret2;
            // ATL_ANTLR3.g:216:57: ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NAME) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ATL_ANTLR3.g:216:58: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    {
                    // ATL_ANTLR3.g:216:58: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    // ATL_ANTLR3.g:216:59: temp= parameter ( ( ( COMA ) temp= parameter ) )*
                    {
                    pushFollow(FOLLOW_parameter_in_operation1210);
                    temp=parameter();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "parameters", temp);
                    }
                    // ATL_ANTLR3.g:216:109: ( ( ( COMA ) temp= parameter ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==COMA) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:216:110: ( ( COMA ) temp= parameter )
                    	    {
                    	    // ATL_ANTLR3.g:216:110: ( ( COMA ) temp= parameter )
                    	    // ATL_ANTLR3.g:216:111: ( COMA ) temp= parameter
                    	    {
                    	    // ATL_ANTLR3.g:216:111: ( COMA )
                    	    // ATL_ANTLR3.g:216:112: COMA
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
            // ATL_ANTLR3.g:216:238: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:216:239: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:216:239: (temp= oclExpression )
            // ATL_ANTLR3.g:216:240: temp= oclExpression
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:226:1: parameter returns [Object ret2] : (temp= identifier COLON temp= oclType ) ;
    public final Object parameter() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Parameter", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:227:2: ( (temp= identifier COLON temp= oclType ) )
            // ATL_ANTLR3.g:227:4: (temp= identifier COLON temp= oclType )
            {
            // ATL_ANTLR3.g:227:4: (temp= identifier COLON temp= oclType )
            // ATL_ANTLR3.g:227:5: temp= identifier COLON temp= oclType
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:237:1: attribute returns [Object ret2] : (temp= identifier COLON temp= oclType EQ ( (temp= oclExpression ) ) ) ;
    public final Object attribute() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Attribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:238:2: ( (temp= identifier COLON temp= oclType EQ ( (temp= oclExpression ) ) ) )
            // ATL_ANTLR3.g:238:4: (temp= identifier COLON temp= oclType EQ ( (temp= oclExpression ) ) )
            {
            // ATL_ANTLR3.g:238:4: (temp= identifier COLON temp= oclType EQ ( (temp= oclExpression ) ) )
            // ATL_ANTLR3.g:238:5: temp= identifier COLON temp= oclType EQ ( (temp= oclExpression ) )
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
            // ATL_ANTLR3.g:238:101: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:238:102: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:238:102: (temp= oclExpression )
            // ATL_ANTLR3.g:238:103: temp= oclExpression
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:248:1: rule returns [Object ret2] : ( (ret= calledRule | ret= matchedRule ) ) ;
    public final Object rule() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:249:2: ( ( (ret= calledRule | ret= matchedRule ) ) )
            // ATL_ANTLR3.g:249:4: ( (ret= calledRule | ret= matchedRule ) )
            {
            // ATL_ANTLR3.g:249:4: ( (ret= calledRule | ret= matchedRule ) )
            // ATL_ANTLR3.g:249:5: (ret= calledRule | ret= matchedRule )
            {
            // ATL_ANTLR3.g:249:5: (ret= calledRule | ret= matchedRule )
            int alt23=2;
            switch ( input.LA(1) ) {
            case 60:
            case 61:
                {
                alt23=1;
                }
                break;
            case 55:
                {
                int LA23_2 = input.LA(2);

                if ( (LA23_2==NAME) ) {
                    int LA23_4 = input.LA(3);

                    if ( (LA23_4==LPAREN) ) {
                        alt23=1;
                    }
                    else if ( (LA23_4==LCURLY||LA23_4==56) ) {
                        alt23=2;
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
            case 45:
            case 53:
            case 54:
            case 58:
            case 59:
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
                    // ATL_ANTLR3.g:249:6: ret= calledRule
                    {
                    pushFollow(FOLLOW_calledRule_in_rule1387);
                    ret=calledRule();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:249:22: ret= matchedRule
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
    // ATL_ANTLR3.g:257:1: matchedRule returns [Object ret2] : ( (ret= lazyMatchedRule | ret= matchedRule_abstractContents ) ) ;
    public final Object matchedRule() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:258:2: ( ( (ret= lazyMatchedRule | ret= matchedRule_abstractContents ) ) )
            // ATL_ANTLR3.g:258:4: ( (ret= lazyMatchedRule | ret= matchedRule_abstractContents ) )
            {
            // ATL_ANTLR3.g:258:4: ( (ret= lazyMatchedRule | ret= matchedRule_abstractContents ) )
            // ATL_ANTLR3.g:258:5: (ret= lazyMatchedRule | ret= matchedRule_abstractContents )
            {
            // ATL_ANTLR3.g:258:5: (ret= lazyMatchedRule | ret= matchedRule_abstractContents )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=58 && LA24_0<=59)) ) {
                alt24=1;
            }
            else if ( (LA24_0==45||(LA24_0>=53 && LA24_0<=55)) ) {
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
                    // ATL_ANTLR3.g:258:6: ret= lazyMatchedRule
                    {
                    pushFollow(FOLLOW_lazyMatchedRule_in_matchedRule1428);
                    ret=lazyMatchedRule();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:258:27: ret= matchedRule_abstractContents
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
    // ATL_ANTLR3.g:266:1: lazyMatchedRule returns [Object ret2] : ( ( ( 'unique' ) | () ) 'lazy' ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) ;
    public final Object lazyMatchedRule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LazyMatchedRule", true, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:267:2: ( ( ( ( 'unique' ) | () ) 'lazy' ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) )
            // ATL_ANTLR3.g:267:4: ( ( ( 'unique' ) | () ) 'lazy' ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            {
            // ATL_ANTLR3.g:267:4: ( ( ( 'unique' ) | () ) 'lazy' ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            // ATL_ANTLR3.g:267:5: ( ( 'unique' ) | () ) 'lazy' ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY
            {
            // ATL_ANTLR3.g:267:5: ( ( 'unique' ) | () )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==58) ) {
                alt25=1;
            }
            else if ( (LA25_0==59) ) {
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
                    // ATL_ANTLR3.g:267:6: ( 'unique' )
                    {
                    // ATL_ANTLR3.g:267:6: ( 'unique' )
                    // ATL_ANTLR3.g:267:7: 'unique'
                    {
                    match(input,58,FOLLOW_58_in_lazyMatchedRule1468); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isUnique", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:267:69: ()
                    {
                    // ATL_ANTLR3.g:267:69: ()
                    // ATL_ANTLR3.g:267:70: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isUnique", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            match(input,59,FOLLOW_59_in_lazyMatchedRule1480); if (failed) return ret2;
            // ATL_ANTLR3.g:267:132: ( ( 'abstract' ) | () )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==54) ) {
                alt26=1;
            }
            else if ( (LA26_0==45||LA26_0==55) ) {
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
                    // ATL_ANTLR3.g:267:133: ( 'abstract' )
                    {
                    // ATL_ANTLR3.g:267:133: ( 'abstract' )
                    // ATL_ANTLR3.g:267:134: 'abstract'
                    {
                    match(input,54,FOLLOW_54_in_lazyMatchedRule1484); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAbstract", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:267:200: ()
                    {
                    // ATL_ANTLR3.g:267:200: ()
                    // ATL_ANTLR3.g:267:201: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAbstract", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:267:258: ( ( 'refining' ) | () )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==45) ) {
                alt27=1;
            }
            else if ( (LA27_0==55) ) {
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
                    // ATL_ANTLR3.g:267:259: ( 'refining' )
                    {
                    // ATL_ANTLR3.g:267:259: ( 'refining' )
                    // ATL_ANTLR3.g:267:260: 'refining'
                    {
                    match(input,45,FOLLOW_45_in_lazyMatchedRule1498); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:267:326: ()
                    {
                    // ATL_ANTLR3.g:267:326: ()
                    // ATL_ANTLR3.g:267:327: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            match(input,55,FOLLOW_55_in_lazyMatchedRule1510); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_lazyMatchedRule1514);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            // ATL_ANTLR3.g:267:436: ( ( 'extends' temp= identifier ) | () )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==56) ) {
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
                    // ATL_ANTLR3.g:267:437: ( 'extends' temp= identifier )
                    {
                    // ATL_ANTLR3.g:267:437: ( 'extends' temp= identifier )
                    // ATL_ANTLR3.g:267:438: 'extends' temp= identifier
                    {
                    match(input,56,FOLLOW_56_in_lazyMatchedRule1520); if (failed) return ret2;
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
                    // ATL_ANTLR3.g:267:562: ()
                    {
                    // ATL_ANTLR3.g:267:562: ()
                    // ATL_ANTLR3.g:267:563: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_lazyMatchedRule1538); if (failed) return ret2;
            // ATL_ANTLR3.g:267:576: ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) )
            // ATL_ANTLR3.g:267:577: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            {
            // ATL_ANTLR3.g:267:577: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            // ATL_ANTLR3.g:267:578: temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () )
            {
            pushFollow(FOLLOW_inPattern_in_lazyMatchedRule1544);
            temp=inPattern();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "inPattern", temp);
            }
            // ATL_ANTLR3.g:267:627: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==57) ) {
                alt31=1;
            }
            else if ( (LA31_0==RCURLY||LA31_0==63||LA31_0==67) ) {
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
                    // ATL_ANTLR3.g:267:628: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // ATL_ANTLR3.g:267:628: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // ATL_ANTLR3.g:267:629: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,57,FOLLOW_57_in_lazyMatchedRule1550); if (failed) return ret2;
                    match(input,LCURLY,FOLLOW_LCURLY_in_lazyMatchedRule1552); if (failed) return ret2;
                    // ATL_ANTLR3.g:267:644: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // ATL_ANTLR3.g:267:645: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:267:645: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // ATL_ANTLR3.g:267:646: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // ATL_ANTLR3.g:267:646: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==NAME) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ATL_ANTLR3.g:267:647: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // ATL_ANTLR3.g:267:647: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // ATL_ANTLR3.g:267:648: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1560);
                            temp=ruleVariableDeclaration();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "variables", temp);
                            }
                            // ATL_ANTLR3.g:267:711: ( (temp= ruleVariableDeclaration ) )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==NAME) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:267:712: (temp= ruleVariableDeclaration )
                            	    {
                            	    // ATL_ANTLR3.g:267:712: (temp= ruleVariableDeclaration )
                            	    // ATL_ANTLR3.g:267:713: temp= ruleVariableDeclaration
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
                    // ATL_ANTLR3.g:267:796: ()
                    {
                    // ATL_ANTLR3.g:267:796: ()
                    // ATL_ANTLR3.g:267:797: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:267:803: ( (temp= outPattern ) | () )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==63) ) {
                alt32=1;
            }
            else if ( (LA32_0==RCURLY||LA32_0==67) ) {
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
                    // ATL_ANTLR3.g:267:804: (temp= outPattern )
                    {
                    // ATL_ANTLR3.g:267:804: (temp= outPattern )
                    // ATL_ANTLR3.g:267:805: temp= outPattern
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
                    // ATL_ANTLR3.g:267:861: ()
                    {
                    // ATL_ANTLR3.g:267:861: ()
                    // ATL_ANTLR3.g:267:862: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:267:868: ( (temp= actionBlock ) | () )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==67) ) {
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
                    // ATL_ANTLR3.g:267:869: (temp= actionBlock )
                    {
                    // ATL_ANTLR3.g:267:869: (temp= actionBlock )
                    // ATL_ANTLR3.g:267:870: temp= actionBlock
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
                    // ATL_ANTLR3.g:267:928: ()
                    {
                    // ATL_ANTLR3.g:267:928: ()
                    // ATL_ANTLR3.g:267:929: 
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:277:1: ruleVariableDeclaration returns [Object ret2] : (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI ) ;
    public final Object ruleVariableDeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("RuleVariableDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:278:2: ( (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI ) )
            // ATL_ANTLR3.g:278:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI )
            {
            // ATL_ANTLR3.g:278:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI )
            // ATL_ANTLR3.g:278:5: temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:288:1: calledRule returns [Object ret2] : ( ( ( 'entrypoint' ) | () ) ( ( 'endpoint' ) | () ) 'rule' temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN LCURLY ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) ;
    public final Object calledRule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CalledRule", true, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:289:2: ( ( ( ( 'entrypoint' ) | () ) ( ( 'endpoint' ) | () ) 'rule' temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN LCURLY ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) )
            // ATL_ANTLR3.g:289:4: ( ( ( 'entrypoint' ) | () ) ( ( 'endpoint' ) | () ) 'rule' temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN LCURLY ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            {
            // ATL_ANTLR3.g:289:4: ( ( ( 'entrypoint' ) | () ) ( ( 'endpoint' ) | () ) 'rule' temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN LCURLY ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            // ATL_ANTLR3.g:289:5: ( ( 'entrypoint' ) | () ) ( ( 'endpoint' ) | () ) 'rule' temp= identifier LPAREN ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )? RPAREN LCURLY ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY
            {
            // ATL_ANTLR3.g:289:5: ( ( 'entrypoint' ) | () )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==60) ) {
                alt34=1;
            }
            else if ( (LA34_0==55||LA34_0==61) ) {
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
                    // ATL_ANTLR3.g:289:6: ( 'entrypoint' )
                    {
                    // ATL_ANTLR3.g:289:6: ( 'entrypoint' )
                    // ATL_ANTLR3.g:289:7: 'entrypoint'
                    {
                    match(input,60,FOLLOW_60_in_calledRule1718); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isEntrypoint", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:289:77: ()
                    {
                    // ATL_ANTLR3.g:289:77: ()
                    // ATL_ANTLR3.g:289:78: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isEntrypoint", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:289:137: ( ( 'endpoint' ) | () )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==61) ) {
                alt35=1;
            }
            else if ( (LA35_0==55) ) {
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
                    // ATL_ANTLR3.g:289:138: ( 'endpoint' )
                    {
                    // ATL_ANTLR3.g:289:138: ( 'endpoint' )
                    // ATL_ANTLR3.g:289:139: 'endpoint'
                    {
                    match(input,61,FOLLOW_61_in_calledRule1732); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isEndpoint", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:289:205: ()
                    {
                    // ATL_ANTLR3.g:289:205: ()
                    // ATL_ANTLR3.g:289:206: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isEndpoint", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            match(input,55,FOLLOW_55_in_calledRule1744); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_calledRule1748);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_calledRule1752); if (failed) return ret2;
            // ATL_ANTLR3.g:289:322: ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==NAME) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ATL_ANTLR3.g:289:323: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    {
                    // ATL_ANTLR3.g:289:323: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    // ATL_ANTLR3.g:289:324: temp= parameter ( ( ( COMA ) temp= parameter ) )*
                    {
                    pushFollow(FOLLOW_parameter_in_calledRule1758);
                    temp=parameter();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "parameters", temp);
                    }
                    // ATL_ANTLR3.g:289:374: ( ( ( COMA ) temp= parameter ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==COMA) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:289:375: ( ( COMA ) temp= parameter )
                    	    {
                    	    // ATL_ANTLR3.g:289:375: ( ( COMA ) temp= parameter )
                    	    // ATL_ANTLR3.g:289:376: ( COMA ) temp= parameter
                    	    {
                    	    // ATL_ANTLR3.g:289:376: ( COMA )
                    	    // ATL_ANTLR3.g:289:377: COMA
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
            // ATL_ANTLR3.g:289:453: ( ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) )
            // ATL_ANTLR3.g:289:454: ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            {
            // ATL_ANTLR3.g:289:454: ( ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            // ATL_ANTLR3.g:289:455: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () )
            {
            // ATL_ANTLR3.g:289:455: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==57) ) {
                alt40=1;
            }
            else if ( (LA40_0==RCURLY||LA40_0==63||LA40_0==67) ) {
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
                    // ATL_ANTLR3.g:289:456: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // ATL_ANTLR3.g:289:456: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // ATL_ANTLR3.g:289:457: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,57,FOLLOW_57_in_calledRule1788); if (failed) return ret2;
                    match(input,LCURLY,FOLLOW_LCURLY_in_calledRule1790); if (failed) return ret2;
                    // ATL_ANTLR3.g:289:472: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // ATL_ANTLR3.g:289:473: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:289:473: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // ATL_ANTLR3.g:289:474: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // ATL_ANTLR3.g:289:474: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==NAME) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ATL_ANTLR3.g:289:475: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // ATL_ANTLR3.g:289:475: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // ATL_ANTLR3.g:289:476: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_calledRule1798);
                            temp=ruleVariableDeclaration();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "variables", temp);
                            }
                            // ATL_ANTLR3.g:289:539: ( (temp= ruleVariableDeclaration ) )*
                            loop38:
                            do {
                                int alt38=2;
                                int LA38_0 = input.LA(1);

                                if ( (LA38_0==NAME) ) {
                                    alt38=1;
                                }


                                switch (alt38) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:289:540: (temp= ruleVariableDeclaration )
                            	    {
                            	    // ATL_ANTLR3.g:289:540: (temp= ruleVariableDeclaration )
                            	    // ATL_ANTLR3.g:289:541: temp= ruleVariableDeclaration
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
                    // ATL_ANTLR3.g:289:624: ()
                    {
                    // ATL_ANTLR3.g:289:624: ()
                    // ATL_ANTLR3.g:289:625: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:289:631: ( (temp= outPattern ) | () )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==63) ) {
                alt41=1;
            }
            else if ( (LA41_0==RCURLY||LA41_0==67) ) {
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
                    // ATL_ANTLR3.g:289:632: (temp= outPattern )
                    {
                    // ATL_ANTLR3.g:289:632: (temp= outPattern )
                    // ATL_ANTLR3.g:289:633: temp= outPattern
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
                    // ATL_ANTLR3.g:289:689: ()
                    {
                    // ATL_ANTLR3.g:289:689: ()
                    // ATL_ANTLR3.g:289:690: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:289:696: ( (temp= actionBlock ) | () )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==67) ) {
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
                    // ATL_ANTLR3.g:289:697: (temp= actionBlock )
                    {
                    // ATL_ANTLR3.g:289:697: (temp= actionBlock )
                    // ATL_ANTLR3.g:289:698: temp= actionBlock
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
                    // ATL_ANTLR3.g:289:756: ()
                    {
                    // ATL_ANTLR3.g:289:756: ()
                    // ATL_ANTLR3.g:289:757: 
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:299:1: inPattern returns [Object ret2] : ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) ) ) ;
    public final Object inPattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("InPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:300:2: ( ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) ) ) )
            // ATL_ANTLR3.g:300:4: ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) ) )
            {
            // ATL_ANTLR3.g:300:4: ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) ) )
            // ATL_ANTLR3.g:300:5: 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) )
            {
            match(input,46,FOLLOW_46_in_inPattern1900); if (failed) return ret2;
            // ATL_ANTLR3.g:300:12: ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) ) )
            // ATL_ANTLR3.g:300:13: ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) )
            {
            // ATL_ANTLR3.g:300:13: ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () ) )
            // ATL_ANTLR3.g:300:14: ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () )
            {
            // ATL_ANTLR3.g:300:14: ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) )
            // ATL_ANTLR3.g:300:15: (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* )
            {
            // ATL_ANTLR3.g:300:15: (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* )
            // ATL_ANTLR3.g:300:16: temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )*
            {
            pushFollow(FOLLOW_inPatternElement_in_inPattern1908);
            temp=inPatternElement();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elements", temp);
            }
            // ATL_ANTLR3.g:300:71: ( ( ( COMA ) temp= inPatternElement ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==COMA) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ATL_ANTLR3.g:300:72: ( ( COMA ) temp= inPatternElement )
            	    {
            	    // ATL_ANTLR3.g:300:72: ( ( COMA ) temp= inPatternElement )
            	    // ATL_ANTLR3.g:300:73: ( COMA ) temp= inPatternElement
            	    {
            	    // ATL_ANTLR3.g:300:73: ( COMA )
            	    // ATL_ANTLR3.g:300:74: COMA
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

            // ATL_ANTLR3.g:300:140: ( ( LPAREN ( (temp= oclExpression ) ) RPAREN ) | () )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==LPAREN) ) {
                alt44=1;
            }
            else if ( (LA44_0==RCURLY||LA44_0==57||LA44_0==63||LA44_0==67) ) {
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
                    // ATL_ANTLR3.g:300:141: ( LPAREN ( (temp= oclExpression ) ) RPAREN )
                    {
                    // ATL_ANTLR3.g:300:141: ( LPAREN ( (temp= oclExpression ) ) RPAREN )
                    // ATL_ANTLR3.g:300:142: LPAREN ( (temp= oclExpression ) ) RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_inPattern1931); if (failed) return ret2;
                    // ATL_ANTLR3.g:300:149: ( (temp= oclExpression ) )
                    // ATL_ANTLR3.g:300:150: (temp= oclExpression )
                    {
                    // ATL_ANTLR3.g:300:150: (temp= oclExpression )
                    // ATL_ANTLR3.g:300:151: temp= oclExpression
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
                    // ATL_ANTLR3.g:300:215: ()
                    {
                    // ATL_ANTLR3.g:300:215: ()
                    // ATL_ANTLR3.g:300:216: 
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:310:1: inPatternElement returns [Object ret2] : (ret= simpleInPatternElement ) ;
    public final Object inPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:311:2: ( (ret= simpleInPatternElement ) )
            // ATL_ANTLR3.g:311:4: (ret= simpleInPatternElement )
            {
            // ATL_ANTLR3.g:311:4: (ret= simpleInPatternElement )
            // ATL_ANTLR3.g:311:5: ret= simpleInPatternElement
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
    // ATL_ANTLR3.g:319:1: simpleInPatternElement returns [Object ret2] : (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) ) ;
    public final Object simpleInPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SimpleInPatternElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:320:2: ( (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) ) )
            // ATL_ANTLR3.g:320:4: (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) )
            {
            // ATL_ANTLR3.g:320:4: (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) )
            // ATL_ANTLR3.g:320:5: temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () )
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
            // ATL_ANTLR3.g:320:101: ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==62) ) {
                alt47=1;
            }
            else if ( (LA47_0==EOF||LA47_0==COMA||LA47_0==LPAREN||LA47_0==RCURLY||LA47_0==57||LA47_0==63||LA47_0==67) ) {
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
                    // ATL_ANTLR3.g:320:102: ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:320:102: ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? )
                    // ATL_ANTLR3.g:320:103: 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )?
                    {
                    match(input,62,FOLLOW_62_in_simpleInPatternElement2037); if (failed) return ret2;
                    // ATL_ANTLR3.g:320:108: ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==NAME) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // ATL_ANTLR3.g:320:109: (temp= identifier ( ( ( COMA ) temp= identifier ) )* )
                            {
                            // ATL_ANTLR3.g:320:109: (temp= identifier ( ( ( COMA ) temp= identifier ) )* )
                            // ATL_ANTLR3.g:320:110: temp= identifier ( ( ( COMA ) temp= identifier ) )*
                            {
                            pushFollow(FOLLOW_identifier_in_simpleInPatternElement2043);
                            temp=identifier();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.setRef(ret, "models", "OclModel", "name", temp, "#all", "never", null, false, null);
                            }
                            // ATL_ANTLR3.g:320:216: ( ( ( COMA ) temp= identifier ) )*
                            loop45:
                            do {
                                int alt45=2;
                                int LA45_0 = input.LA(1);

                                if ( (LA45_0==COMA) ) {
                                    int LA45_1 = input.LA(2);

                                    if ( (LA45_1==NAME) ) {
                                        int LA45_3 = input.LA(3);

                                        if ( (LA45_3==EOF||LA45_3==COMA||LA45_3==LPAREN||LA45_3==RCURLY||LA45_3==57||LA45_3==63||LA45_3==67) ) {
                                            alt45=1;
                                        }


                                    }


                                }


                                switch (alt45) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:320:217: ( ( COMA ) temp= identifier )
                            	    {
                            	    // ATL_ANTLR3.g:320:217: ( ( COMA ) temp= identifier )
                            	    // ATL_ANTLR3.g:320:218: ( COMA ) temp= identifier
                            	    {
                            	    // ATL_ANTLR3.g:320:218: ( COMA )
                            	    // ATL_ANTLR3.g:320:219: COMA
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
                    // ATL_ANTLR3.g:320:342: ()
                    {
                    // ATL_ANTLR3.g:320:342: ()
                    // ATL_ANTLR3.g:320:343: 
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:330:1: outPattern returns [Object ret2] : ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) ) ;
    public final Object outPattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OutPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:331:2: ( ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) ) )
            // ATL_ANTLR3.g:331:4: ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) )
            {
            // ATL_ANTLR3.g:331:4: ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) )
            // ATL_ANTLR3.g:331:5: 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) )
            {
            match(input,63,FOLLOW_63_in_outPattern2105); if (failed) return ret2;
            // ATL_ANTLR3.g:331:10: ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) )
            // ATL_ANTLR3.g:331:11: ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) )
            {
            // ATL_ANTLR3.g:331:11: ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) )
            // ATL_ANTLR3.g:331:12: ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) )
            {
            // ATL_ANTLR3.g:331:12: ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) )
            // ATL_ANTLR3.g:331:13: (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* )
            {
            // ATL_ANTLR3.g:331:13: (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* )
            // ATL_ANTLR3.g:331:14: temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )*
            {
            pushFollow(FOLLOW_outPatternElement_in_outPattern2113);
            temp=outPatternElement();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elements", temp);
            }
            // ATL_ANTLR3.g:331:70: ( ( ( COMA ) temp= outPatternElement ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==COMA) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ATL_ANTLR3.g:331:71: ( ( COMA ) temp= outPatternElement )
            	    {
            	    // ATL_ANTLR3.g:331:71: ( ( COMA ) temp= outPatternElement )
            	    // ATL_ANTLR3.g:331:72: ( COMA ) temp= outPatternElement
            	    {
            	    // ATL_ANTLR3.g:331:72: ( COMA )
            	    // ATL_ANTLR3.g:331:73: COMA
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:341:1: outPatternElement returns [Object ret2] : ( (ret= simpleOutPatternElement | ret= forEachOutPatternElement ) ) ;
    public final Object outPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:342:2: ( ( (ret= simpleOutPatternElement | ret= forEachOutPatternElement ) ) )
            // ATL_ANTLR3.g:342:4: ( (ret= simpleOutPatternElement | ret= forEachOutPatternElement ) )
            {
            // ATL_ANTLR3.g:342:4: ( (ret= simpleOutPatternElement | ret= forEachOutPatternElement ) )
            // ATL_ANTLR3.g:342:5: (ret= simpleOutPatternElement | ret= forEachOutPatternElement )
            {
            // ATL_ANTLR3.g:342:5: (ret= simpleOutPatternElement | ret= forEachOutPatternElement )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==NAME) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==COLON) ) {
                    int LA49_2 = input.LA(3);

                    if ( (LA49_2==65) ) {
                        alt49=2;
                    }
                    else if ( (LA49_2==NAME||(LA49_2>=79 && LA49_2<=83)||(LA49_2>=85 && LA49_2<=92)) ) {
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
                    // ATL_ANTLR3.g:342:6: ret= simpleOutPatternElement
                    {
                    pushFollow(FOLLOW_simpleOutPatternElement_in_outPatternElement2169);
                    ret=simpleOutPatternElement();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:342:35: ret= forEachOutPatternElement
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
    // ATL_ANTLR3.g:350:1: simpleOutPatternElement returns [Object ret2] : (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) ) ;
    public final Object simpleOutPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SimpleOutPatternElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:351:2: ( (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) ) )
            // ATL_ANTLR3.g:351:4: (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) )
            {
            // ATL_ANTLR3.g:351:4: (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) )
            // ATL_ANTLR3.g:351:5: temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )
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
            // ATL_ANTLR3.g:351:101: ( ( 'in' temp= identifier ) | () )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==62) ) {
                alt50=1;
            }
            else if ( (LA50_0==EOF||LA50_0==COMA||LA50_0==LPAREN||(LA50_0>=RCURLY && LA50_0<=RARROW)||LA50_0==64||LA50_0==67) ) {
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
                    // ATL_ANTLR3.g:351:102: ( 'in' temp= identifier )
                    {
                    // ATL_ANTLR3.g:351:102: ( 'in' temp= identifier )
                    // ATL_ANTLR3.g:351:103: 'in' temp= identifier
                    {
                    match(input,62,FOLLOW_62_in_simpleOutPatternElement2223); if (failed) return ret2;
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
                    // ATL_ANTLR3.g:351:218: ()
                    {
                    // ATL_ANTLR3.g:351:218: ()
                    // ATL_ANTLR3.g:351:219: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:351:225: ( ( 'mapsTo' temp= identifier ) | () )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==64) ) {
                alt51=1;
            }
            else if ( (LA51_0==EOF||LA51_0==COMA||LA51_0==LPAREN||(LA51_0>=RCURLY && LA51_0<=RARROW)||LA51_0==67) ) {
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
                    // ATL_ANTLR3.g:351:226: ( 'mapsTo' temp= identifier )
                    {
                    // ATL_ANTLR3.g:351:226: ( 'mapsTo' temp= identifier )
                    // ATL_ANTLR3.g:351:227: 'mapsTo' temp= identifier
                    {
                    match(input,64,FOLLOW_64_in_simpleOutPatternElement2243); if (failed) return ret2;
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
                    // ATL_ANTLR3.g:351:363: ()
                    {
                    // ATL_ANTLR3.g:351:363: ()
                    // ATL_ANTLR3.g:351:364: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:351:370: ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RARROW) ) {
                alt54=1;
            }
            else if ( (LA54_0==EOF||LA54_0==COMA||LA54_0==LPAREN||LA54_0==RCURLY||LA54_0==67) ) {
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
                    // ATL_ANTLR3.g:351:371: ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
                    {
                    // ATL_ANTLR3.g:351:371: ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
                    // ATL_ANTLR3.g:351:372: RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
                    {
                    match(input,RARROW,FOLLOW_RARROW_in_simpleOutPatternElement2263); if (failed) return ret2;
                    match(input,LPAREN,FOLLOW_LPAREN_in_simpleOutPatternElement2265); if (failed) return ret2;
                    // ATL_ANTLR3.g:351:386: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( ((LA53_0>=NAME && LA53_0<=FLOAT)||LA53_0==LPAREN||LA53_0==SHARP||LA53_0==MINUS||LA53_0==68||(LA53_0>=72 && LA53_0<=74)||(LA53_0>=77 && LA53_0<=93)) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // ATL_ANTLR3.g:351:387: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                            {
                            // ATL_ANTLR3.g:351:387: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                            // ATL_ANTLR3.g:351:388: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                            {
                            pushFollow(FOLLOW_oclExpression_in_simpleOutPatternElement2271);
                            temp=oclExpression();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "reverseBindings", temp);
                            }
                            // ATL_ANTLR3.g:351:447: ( ( ( COMA ) temp= oclExpression ) )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==COMA) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:351:448: ( ( COMA ) temp= oclExpression )
                            	    {
                            	    // ATL_ANTLR3.g:351:448: ( ( COMA ) temp= oclExpression )
                            	    // ATL_ANTLR3.g:351:449: ( COMA ) temp= oclExpression
                            	    {
                            	    // ATL_ANTLR3.g:351:449: ( COMA )
                            	    // ATL_ANTLR3.g:351:450: COMA
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
                    // ATL_ANTLR3.g:351:533: ()
                    {
                    // ATL_ANTLR3.g:351:533: ()
                    // ATL_ANTLR3.g:351:534: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:351:540: ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==LPAREN) ) {
                alt57=1;
            }
            else if ( (LA57_0==EOF||LA57_0==COMA||LA57_0==RCURLY||LA57_0==67) ) {
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
                    // ATL_ANTLR3.g:351:541: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    {
                    // ATL_ANTLR3.g:351:541: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    // ATL_ANTLR3.g:351:542: LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_simpleOutPatternElement2307); if (failed) return ret2;
                    // ATL_ANTLR3.g:351:549: ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) )
                    // ATL_ANTLR3.g:351:550: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:351:550: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    // ATL_ANTLR3.g:351:551: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    {
                    // ATL_ANTLR3.g:351:551: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==NAME||(LA56_0>=43 && LA56_0<=99)) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // ATL_ANTLR3.g:351:552: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            {
                            // ATL_ANTLR3.g:351:552: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            // ATL_ANTLR3.g:351:553: temp= binding ( ( ( COMA ) temp= binding ) )*
                            {
                            pushFollow(FOLLOW_binding_in_simpleOutPatternElement2315);
                            temp=binding();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "bindings", temp);
                            }
                            // ATL_ANTLR3.g:351:599: ( ( ( COMA ) temp= binding ) )*
                            loop55:
                            do {
                                int alt55=2;
                                int LA55_0 = input.LA(1);

                                if ( (LA55_0==COMA) ) {
                                    alt55=1;
                                }


                                switch (alt55) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:351:600: ( ( COMA ) temp= binding )
                            	    {
                            	    // ATL_ANTLR3.g:351:600: ( ( COMA ) temp= binding )
                            	    // ATL_ANTLR3.g:351:601: ( COMA ) temp= binding
                            	    {
                            	    // ATL_ANTLR3.g:351:601: ( COMA )
                            	    // ATL_ANTLR3.g:351:602: COMA
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
                    // ATL_ANTLR3.g:351:674: ()
                    {
                    // ATL_ANTLR3.g:351:674: ()
                    // ATL_ANTLR3.g:351:675: 
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:361:1: forEachOutPatternElement returns [Object ret2] : (temp= identifier COLON 'distinct' temp= oclType 'foreach' LPAREN temp= iterator 'in' temp= oclExpression RPAREN ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) ) ;
    public final Object forEachOutPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ForEachOutPatternElement", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:362:2: ( (temp= identifier COLON 'distinct' temp= oclType 'foreach' LPAREN temp= iterator 'in' temp= oclExpression RPAREN ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) ) )
            // ATL_ANTLR3.g:362:4: (temp= identifier COLON 'distinct' temp= oclType 'foreach' LPAREN temp= iterator 'in' temp= oclExpression RPAREN ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) )
            {
            // ATL_ANTLR3.g:362:4: (temp= identifier COLON 'distinct' temp= oclType 'foreach' LPAREN temp= iterator 'in' temp= oclExpression RPAREN ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) )
            // ATL_ANTLR3.g:362:5: temp= identifier COLON 'distinct' temp= oclType 'foreach' LPAREN temp= iterator 'in' temp= oclExpression RPAREN ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )
            {
            pushFollow(FOLLOW_identifier_in_forEachOutPatternElement2383);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_forEachOutPatternElement2387); if (failed) return ret2;
            match(input,65,FOLLOW_65_in_forEachOutPatternElement2389); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_forEachOutPatternElement2393);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            match(input,66,FOLLOW_66_in_forEachOutPatternElement2397); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_forEachOutPatternElement2399); if (failed) return ret2;
            pushFollow(FOLLOW_iterator_in_forEachOutPatternElement2403);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterator", temp);
            }
            match(input,62,FOLLOW_62_in_forEachOutPatternElement2407); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_forEachOutPatternElement2411);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "collection", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_forEachOutPatternElement2415); if (failed) return ret2;
            // ATL_ANTLR3.g:362:242: ( ( 'mapsTo' temp= identifier ) | () )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==64) ) {
                alt58=1;
            }
            else if ( (LA58_0==EOF||LA58_0==COMA||LA58_0==LPAREN||LA58_0==RCURLY||LA58_0==67) ) {
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
                    // ATL_ANTLR3.g:362:243: ( 'mapsTo' temp= identifier )
                    {
                    // ATL_ANTLR3.g:362:243: ( 'mapsTo' temp= identifier )
                    // ATL_ANTLR3.g:362:244: 'mapsTo' temp= identifier
                    {
                    match(input,64,FOLLOW_64_in_forEachOutPatternElement2419); if (failed) return ret2;
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
                    // ATL_ANTLR3.g:362:380: ()
                    {
                    // ATL_ANTLR3.g:362:380: ()
                    // ATL_ANTLR3.g:362:381: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:362:387: ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==LPAREN) ) {
                alt61=1;
            }
            else if ( (LA61_0==EOF||LA61_0==COMA||LA61_0==RCURLY||LA61_0==67) ) {
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
                    // ATL_ANTLR3.g:362:388: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    {
                    // ATL_ANTLR3.g:362:388: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    // ATL_ANTLR3.g:362:389: LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_forEachOutPatternElement2439); if (failed) return ret2;
                    // ATL_ANTLR3.g:362:396: ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) )
                    // ATL_ANTLR3.g:362:397: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:362:397: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    // ATL_ANTLR3.g:362:398: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    {
                    // ATL_ANTLR3.g:362:398: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==NAME||(LA60_0>=43 && LA60_0<=99)) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // ATL_ANTLR3.g:362:399: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            {
                            // ATL_ANTLR3.g:362:399: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            // ATL_ANTLR3.g:362:400: temp= binding ( ( ( COMA ) temp= binding ) )*
                            {
                            pushFollow(FOLLOW_binding_in_forEachOutPatternElement2447);
                            temp=binding();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "bindings", temp);
                            }
                            // ATL_ANTLR3.g:362:446: ( ( ( COMA ) temp= binding ) )*
                            loop59:
                            do {
                                int alt59=2;
                                int LA59_0 = input.LA(1);

                                if ( (LA59_0==COMA) ) {
                                    alt59=1;
                                }


                                switch (alt59) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:362:447: ( ( COMA ) temp= binding )
                            	    {
                            	    // ATL_ANTLR3.g:362:447: ( ( COMA ) temp= binding )
                            	    // ATL_ANTLR3.g:362:448: ( COMA ) temp= binding
                            	    {
                            	    // ATL_ANTLR3.g:362:448: ( COMA )
                            	    // ATL_ANTLR3.g:362:449: COMA
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
                    // ATL_ANTLR3.g:362:521: ()
                    {
                    // ATL_ANTLR3.g:362:521: ()
                    // ATL_ANTLR3.g:362:522: 
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:372:1: binding returns [Object ret2] : (temp= identifierOrKeyword ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression ) ;
    public final Object binding() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Binding", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:373:2: ( (temp= identifierOrKeyword ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression ) )
            // ATL_ANTLR3.g:373:4: (temp= identifierOrKeyword ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression )
            {
            // ATL_ANTLR3.g:373:4: (temp= identifierOrKeyword ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression )
            // ATL_ANTLR3.g:373:5: temp= identifierOrKeyword ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_binding2515);
            temp=identifierOrKeyword();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "propertyName", temp);
            }
            // ATL_ANTLR3.g:373:67: ( ( ASSIGNARROW ) | ( LARROW ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==ASSIGNARROW) ) {
                alt62=1;
            }
            else if ( (LA62_0==LARROW) ) {
                alt62=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("373:67: ( ( ASSIGNARROW ) | ( LARROW ) )", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ATL_ANTLR3.g:373:68: ( ASSIGNARROW )
                    {
                    // ATL_ANTLR3.g:373:68: ( ASSIGNARROW )
                    // ATL_ANTLR3.g:373:69: ASSIGNARROW
                    {
                    match(input,ASSIGNARROW,FOLLOW_ASSIGNARROW_in_binding2521); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAssignment", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:373:138: ( LARROW )
                    {
                    // ATL_ANTLR3.g:373:138: ( LARROW )
                    // ATL_ANTLR3.g:373:139: LARROW
                    {
                    match(input,LARROW,FOLLOW_LARROW_in_binding2528); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAssignment", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_oclExpression_in_binding2536);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "value", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:383:1: actionBlock returns [Object ret2] : ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object actionBlock() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ActionBlock", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:384:2: ( ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ATL_ANTLR3.g:384:4: ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ATL_ANTLR3.g:384:4: ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ATL_ANTLR3.g:384:5: 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,67,FOLLOW_67_in_actionBlock2570); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_actionBlock2572); if (failed) return ret2;
            // ATL_ANTLR3.g:384:17: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ATL_ANTLR3.g:384:18: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ATL_ANTLR3.g:384:18: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ATL_ANTLR3.g:384:19: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ATL_ANTLR3.g:384:19: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=NAME && LA64_0<=FLOAT)||LA64_0==LPAREN||LA64_0==SHARP||LA64_0==MINUS||LA64_0==68||LA64_0==70||(LA64_0>=72 && LA64_0<=74)||(LA64_0>=77 && LA64_0<=93)) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ATL_ANTLR3.g:384:20: (temp= statement ( (temp= statement ) )* )
                    {
                    // ATL_ANTLR3.g:384:20: (temp= statement ( (temp= statement ) )* )
                    // ATL_ANTLR3.g:384:21: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_actionBlock2580);
                    temp=statement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "statements", temp);
                    }
                    // ATL_ANTLR3.g:384:71: ( (temp= statement ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( ((LA63_0>=NAME && LA63_0<=FLOAT)||LA63_0==LPAREN||LA63_0==SHARP||LA63_0==MINUS||LA63_0==68||LA63_0==70||(LA63_0>=72 && LA63_0<=74)||(LA63_0>=77 && LA63_0<=93)) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:384:72: (temp= statement )
                    	    {
                    	    // ATL_ANTLR3.g:384:72: (temp= statement )
                    	    // ATL_ANTLR3.g:384:73: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_actionBlock2588);
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
                    	    break loop63;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_actionBlock2600); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:394:1: statement returns [Object ret2] : ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) ) ;
    public final Object statement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:395:2: ( ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) ) )
            // ATL_ANTLR3.g:395:4: ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) )
            {
            // ATL_ANTLR3.g:395:4: ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) )
            // ATL_ANTLR3.g:395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )
            {
            // ATL_ANTLR3.g:395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )
            int alt65=4;
            switch ( input.LA(1) ) {
            case 68:
                {
                int LA65_1 = input.LA(2);

                if ( (synpred122()) ) {
                    alt65=1;
                }
                else if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 1, input);

                    throw nvae;
                }
                }
                break;
            case 93:
                {
                int LA65_2 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 2, input);

                    throw nvae;
                }
                }
                break;
            case MINUS:
                {
                int LA65_3 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 3, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                int LA65_4 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 4, input);

                    throw nvae;
                }
                }
                break;
            case NAME:
                {
                int LA65_5 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 5, input);

                    throw nvae;
                }
                }
                break;
            case 72:
                {
                int LA65_6 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 6, input);

                    throw nvae;
                }
                }
                break;
            case INT:
                {
                int LA65_7 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 7, input);

                    throw nvae;
                }
                }
                break;
            case FLOAT:
                {
                int LA65_8 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 8, input);

                    throw nvae;
                }
                }
                break;
            case 73:
                {
                int LA65_9 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 9, input);

                    throw nvae;
                }
                }
                break;
            case 74:
                {
                int LA65_10 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 10, input);

                    throw nvae;
                }
                }
                break;
            case STRING:
                {
                int LA65_11 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 11, input);

                    throw nvae;
                }
                }
                break;
            case 77:
                {
                int LA65_12 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 12, input);

                    throw nvae;
                }
                }
                break;
            case SHARP:
                {
                int LA65_13 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 13, input);

                    throw nvae;
                }
                }
                break;
            case 79:
                {
                int LA65_14 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 14, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                int LA65_15 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 15, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA65_16 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 16, input);

                    throw nvae;
                }
                }
                break;
            case 82:
                {
                int LA65_17 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 17, input);

                    throw nvae;
                }
                }
                break;
            case 83:
                {
                int LA65_18 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 18, input);

                    throw nvae;
                }
                }
                break;
            case 84:
                {
                int LA65_19 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 19, input);

                    throw nvae;
                }
                }
                break;
            case 86:
                {
                int LA65_20 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 20, input);

                    throw nvae;
                }
                }
                break;
            case 87:
                {
                int LA65_21 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 21, input);

                    throw nvae;
                }
                }
                break;
            case 88:
                {
                int LA65_22 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 22, input);

                    throw nvae;
                }
                }
                break;
            case 89:
                {
                int LA65_23 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 23, input);

                    throw nvae;
                }
                }
                break;
            case 90:
                {
                int LA65_24 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 24, input);

                    throw nvae;
                }
                }
                break;
            case 91:
                {
                int LA65_25 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 25, input);

                    throw nvae;
                }
                }
                break;
            case 92:
                {
                int LA65_26 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 26, input);

                    throw nvae;
                }
                }
                break;
            case 85:
                {
                int LA65_27 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 27, input);

                    throw nvae;
                }
                }
                break;
            case 78:
                {
                int LA65_28 = input.LA(2);

                if ( (synpred123()) ) {
                    alt65=2;
                }
                else if ( (synpred124()) ) {
                    alt65=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 28, input);

                    throw nvae;
                }
                }
                break;
            case 70:
                {
                alt65=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("395:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // ATL_ANTLR3.g:395:6: ret= ifStat
                    {
                    pushFollow(FOLLOW_ifStat_in_statement2635);
                    ret=ifStat();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:395:18: ret= expressionStat
                    {
                    pushFollow(FOLLOW_expressionStat_in_statement2640);
                    ret=expressionStat();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:395:38: ret= bindingStat
                    {
                    pushFollow(FOLLOW_bindingStat_in_statement2645);
                    ret=bindingStat();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:395:55: ret= forStat
                    {
                    pushFollow(FOLLOW_forStat_in_statement2650);
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
    // ATL_ANTLR3.g:403:1: bindingStat returns [Object ret2] : (temp= oclExpression ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression SEMI ) ;
    public final Object bindingStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BindingStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:404:2: ( (temp= oclExpression ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression SEMI ) )
            // ATL_ANTLR3.g:404:4: (temp= oclExpression ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression SEMI )
            {
            // ATL_ANTLR3.g:404:4: (temp= oclExpression ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression SEMI )
            // ATL_ANTLR3.g:404:5: temp= oclExpression ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression SEMI
            {
            pushFollow(FOLLOW_oclExpression_in_bindingStat2685);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "source", temp);
            }
            // ATL_ANTLR3.g:404:55: ( ( ASSIGNARROW ) | ( LARROW ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==ASSIGNARROW) ) {
                alt66=1;
            }
            else if ( (LA66_0==LARROW) ) {
                alt66=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("404:55: ( ( ASSIGNARROW ) | ( LARROW ) )", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ATL_ANTLR3.g:404:56: ( ASSIGNARROW )
                    {
                    // ATL_ANTLR3.g:404:56: ( ASSIGNARROW )
                    // ATL_ANTLR3.g:404:57: ASSIGNARROW
                    {
                    match(input,ASSIGNARROW,FOLLOW_ASSIGNARROW_in_bindingStat2691); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAssignment", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:404:126: ( LARROW )
                    {
                    // ATL_ANTLR3.g:404:126: ( LARROW )
                    // ATL_ANTLR3.g:404:127: LARROW
                    {
                    match(input,LARROW,FOLLOW_LARROW_in_bindingStat2698); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAssignment", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_oclExpression_in_bindingStat2706);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "value", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_bindingStat2710); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:414:1: expressionStat returns [Object ret2] : (temp= oclExpression SEMI ) ;
    public final Object expressionStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ExpressionStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:415:2: ( (temp= oclExpression SEMI ) )
            // ATL_ANTLR3.g:415:4: (temp= oclExpression SEMI )
            {
            // ATL_ANTLR3.g:415:4: (temp= oclExpression SEMI )
            // ATL_ANTLR3.g:415:5: temp= oclExpression SEMI
            {
            pushFollow(FOLLOW_oclExpression_in_expressionStat2744);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "expression", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_expressionStat2748); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:425:1: ifStat returns [Object ret2] : ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) ) ;
    public final Object ifStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IfStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:426:2: ( ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) ) )
            // ATL_ANTLR3.g:426:4: ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) )
            {
            // ATL_ANTLR3.g:426:4: ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) )
            // ATL_ANTLR3.g:426:5: 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )
            {
            match(input,68,FOLLOW_68_in_ifStat2780); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_ifStat2782); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_ifStat2786);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "condition", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ifStat2790); if (failed) return ret2;
            // ATL_ANTLR3.g:426:77: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=NAME && LA69_0<=FLOAT)||LA69_0==LPAREN||LA69_0==SHARP||LA69_0==MINUS||LA69_0==68||LA69_0==70||(LA69_0>=72 && LA69_0<=74)||(LA69_0>=77 && LA69_0<=93)) ) {
                alt69=1;
            }
            else if ( (LA69_0==LCURLY) ) {
                alt69=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("426:77: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ATL_ANTLR3.g:426:78: ( ( (temp= statement ) ) )
                    {
                    // ATL_ANTLR3.g:426:78: ( ( (temp= statement ) ) )
                    // ATL_ANTLR3.g:426:79: ( (temp= statement ) )
                    {
                    // ATL_ANTLR3.g:426:79: ( (temp= statement ) )
                    // ATL_ANTLR3.g:426:80: (temp= statement )
                    {
                    // ATL_ANTLR3.g:426:80: (temp= statement )
                    // ATL_ANTLR3.g:426:81: temp= statement
                    {
                    pushFollow(FOLLOW_statement_in_ifStat2798);
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
                    // ATL_ANTLR3.g:426:142: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    {
                    // ATL_ANTLR3.g:426:142: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    // ATL_ANTLR3.g:426:143: LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
                    {
                    match(input,LCURLY,FOLLOW_LCURLY_in_ifStat2809); if (failed) return ret2;
                    // ATL_ANTLR3.g:426:150: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
                    // ATL_ANTLR3.g:426:151: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:426:151: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    // ATL_ANTLR3.g:426:152: ( (temp= statement ( (temp= statement ) )* ) )?
                    {
                    // ATL_ANTLR3.g:426:152: ( (temp= statement ( (temp= statement ) )* ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( ((LA68_0>=NAME && LA68_0<=FLOAT)||LA68_0==LPAREN||LA68_0==SHARP||LA68_0==MINUS||LA68_0==68||LA68_0==70||(LA68_0>=72 && LA68_0<=74)||(LA68_0>=77 && LA68_0<=93)) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // ATL_ANTLR3.g:426:153: (temp= statement ( (temp= statement ) )* )
                            {
                            // ATL_ANTLR3.g:426:153: (temp= statement ( (temp= statement ) )* )
                            // ATL_ANTLR3.g:426:154: temp= statement ( (temp= statement ) )*
                            {
                            pushFollow(FOLLOW_statement_in_ifStat2817);
                            temp=statement();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "thenStatements", temp);
                            }
                            // ATL_ANTLR3.g:426:208: ( (temp= statement ) )*
                            loop67:
                            do {
                                int alt67=2;
                                int LA67_0 = input.LA(1);

                                if ( ((LA67_0>=NAME && LA67_0<=FLOAT)||LA67_0==LPAREN||LA67_0==SHARP||LA67_0==MINUS||LA67_0==68||LA67_0==70||(LA67_0>=72 && LA67_0<=74)||(LA67_0>=77 && LA67_0<=93)) ) {
                                    alt67=1;
                                }


                                switch (alt67) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:426:209: (temp= statement )
                            	    {
                            	    // ATL_ANTLR3.g:426:209: (temp= statement )
                            	    // ATL_ANTLR3.g:426:210: temp= statement
                            	    {
                            	    pushFollow(FOLLOW_statement_in_ifStat2825);
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
                            	    break loop67;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_ifStat2837); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:426:284: ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==69) ) {
                int LA73_1 = input.LA(2);

                if ( (synpred132()) ) {
                    alt73=1;
                }
                else if ( (true) ) {
                    alt73=2;
                }
                // TODO keep in sync to avoid compilation warnings
//                else {
//                    if (backtracking>0) {failed=true; return ret2;}
//                    NoViableAltException nvae =
//                        new NoViableAltException("426:284: ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )", 73, 1, input);
//
//                    throw nvae;
//                }
            }
            else if ( (LA73_0==EOF||(LA73_0>=NAME && LA73_0<=FLOAT)||LA73_0==LPAREN||LA73_0==RCURLY||LA73_0==SHARP||LA73_0==MINUS||LA73_0==68||LA73_0==70||(LA73_0>=72 && LA73_0<=74)||(LA73_0>=77 && LA73_0<=93)) ) {
                alt73=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("426:284: ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ATL_ANTLR3.g:426:285: ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) )
                    {
                    // ATL_ANTLR3.g:426:285: ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) )
                    // ATL_ANTLR3.g:426:286: 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
                    {
                    match(input,69,FOLLOW_69_in_ifStat2845); if (failed) return ret2;
                    // ATL_ANTLR3.g:426:293: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( ((LA72_0>=NAME && LA72_0<=FLOAT)||LA72_0==LPAREN||LA72_0==SHARP||LA72_0==MINUS||LA72_0==68||LA72_0==70||(LA72_0>=72 && LA72_0<=74)||(LA72_0>=77 && LA72_0<=93)) ) {
                        alt72=1;
                    }
                    else if ( (LA72_0==LCURLY) ) {
                        alt72=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("426:293: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )", 72, 0, input);

                        throw nvae;
                    }
                    switch (alt72) {
                        case 1 :
                            // ATL_ANTLR3.g:426:294: ( ( (temp= statement ) ) )
                            {
                            // ATL_ANTLR3.g:426:294: ( ( (temp= statement ) ) )
                            // ATL_ANTLR3.g:426:295: ( (temp= statement ) )
                            {
                            // ATL_ANTLR3.g:426:295: ( (temp= statement ) )
                            // ATL_ANTLR3.g:426:296: (temp= statement )
                            {
                            // ATL_ANTLR3.g:426:296: (temp= statement )
                            // ATL_ANTLR3.g:426:297: temp= statement
                            {
                            pushFollow(FOLLOW_statement_in_ifStat2853);
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
                            // ATL_ANTLR3.g:426:358: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                            {
                            // ATL_ANTLR3.g:426:358: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                            // ATL_ANTLR3.g:426:359: LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
                            {
                            match(input,LCURLY,FOLLOW_LCURLY_in_ifStat2864); if (failed) return ret2;
                            // ATL_ANTLR3.g:426:366: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
                            // ATL_ANTLR3.g:426:367: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                            {
                            // ATL_ANTLR3.g:426:367: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                            // ATL_ANTLR3.g:426:368: ( (temp= statement ( (temp= statement ) )* ) )?
                            {
                            // ATL_ANTLR3.g:426:368: ( (temp= statement ( (temp= statement ) )* ) )?
                            int alt71=2;
                            int LA71_0 = input.LA(1);

                            if ( ((LA71_0>=NAME && LA71_0<=FLOAT)||LA71_0==LPAREN||LA71_0==SHARP||LA71_0==MINUS||LA71_0==68||LA71_0==70||(LA71_0>=72 && LA71_0<=74)||(LA71_0>=77 && LA71_0<=93)) ) {
                                alt71=1;
                            }
                            switch (alt71) {
                                case 1 :
                                    // ATL_ANTLR3.g:426:369: (temp= statement ( (temp= statement ) )* )
                                    {
                                    // ATL_ANTLR3.g:426:369: (temp= statement ( (temp= statement ) )* )
                                    // ATL_ANTLR3.g:426:370: temp= statement ( (temp= statement ) )*
                                    {
                                    pushFollow(FOLLOW_statement_in_ifStat2872);
                                    temp=statement();
                                    _fsp--;
                                    if (failed) return ret2;
                                    if ( backtracking==0 ) {
                                      ei.set(ret, "elseStatements", temp);
                                    }
                                    // ATL_ANTLR3.g:426:424: ( (temp= statement ) )*
                                    loop70:
                                    do {
                                        int alt70=2;
                                        int LA70_0 = input.LA(1);

                                        if ( ((LA70_0>=NAME && LA70_0<=FLOAT)||LA70_0==LPAREN||LA70_0==SHARP||LA70_0==MINUS||LA70_0==68||LA70_0==70||(LA70_0>=72 && LA70_0<=74)||(LA70_0>=77 && LA70_0<=93)) ) {
                                            alt70=1;
                                        }


                                        switch (alt70) {
                                    	case 1 :
                                    	    // ATL_ANTLR3.g:426:425: (temp= statement )
                                    	    {
                                    	    // ATL_ANTLR3.g:426:425: (temp= statement )
                                    	    // ATL_ANTLR3.g:426:426: temp= statement
                                    	    {
                                    	    pushFollow(FOLLOW_statement_in_ifStat2880);
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
                                    	    break loop70;
                                        }
                                    } while (true);


                                    }


                                    }
                                    break;

                            }


                            }


                            }

                            match(input,RCURLY,FOLLOW_RCURLY_in_ifStat2892); if (failed) return ret2;

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
                    // ATL_ANTLR3.g:426:505: ()
                    {
                    // ATL_ANTLR3.g:426:505: ()
                    // ATL_ANTLR3.g:426:506: 
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:436:1: forStat returns [Object ret2] : ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object forStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ForStat", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:437:2: ( ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ATL_ANTLR3.g:437:4: ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ATL_ANTLR3.g:437:4: ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ATL_ANTLR3.g:437:5: 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,70,FOLLOW_70_in_forStat2938); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_forStat2940); if (failed) return ret2;
            pushFollow(FOLLOW_iterator_in_forStat2944);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterator", temp);
            }
            match(input,62,FOLLOW_62_in_forStat2948); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_forStat2952);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "collection", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_forStat2956); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_forStat2958); if (failed) return ret2;
            // ATL_ANTLR3.g:437:138: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ATL_ANTLR3.g:437:139: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ATL_ANTLR3.g:437:139: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ATL_ANTLR3.g:437:140: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ATL_ANTLR3.g:437:140: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=NAME && LA75_0<=FLOAT)||LA75_0==LPAREN||LA75_0==SHARP||LA75_0==MINUS||LA75_0==68||LA75_0==70||(LA75_0>=72 && LA75_0<=74)||(LA75_0>=77 && LA75_0<=93)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ATL_ANTLR3.g:437:141: (temp= statement ( (temp= statement ) )* )
                    {
                    // ATL_ANTLR3.g:437:141: (temp= statement ( (temp= statement ) )* )
                    // ATL_ANTLR3.g:437:142: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_forStat2966);
                    temp=statement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "statements", temp);
                    }
                    // ATL_ANTLR3.g:437:192: ( (temp= statement ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( ((LA74_0>=NAME && LA74_0<=FLOAT)||LA74_0==LPAREN||LA74_0==SHARP||LA74_0==MINUS||LA74_0==68||LA74_0==70||(LA74_0>=72 && LA74_0<=74)||(LA74_0>=77 && LA74_0<=93)) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:437:193: (temp= statement )
                    	    {
                    	    // ATL_ANTLR3.g:437:193: (temp= statement )
                    	    // ATL_ANTLR3.g:437:194: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_forStat2974);
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
                    	    break loop74;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_forStat2986); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:447:1: oclModel returns [Object ret2] : (temp= identifier COLON temp= identifier ) ;
    public final Object oclModel() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OclModel", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:448:2: ( (temp= identifier COLON temp= identifier ) )
            // ATL_ANTLR3.g:448:4: (temp= identifier COLON temp= identifier )
            {
            // ATL_ANTLR3.g:448:4: (temp= identifier COLON temp= identifier )
            // ATL_ANTLR3.g:448:5: temp= identifier COLON temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_oclModel3020);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_oclModel3024); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_oclModel3028);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.setRef(ret, "metamodel", "OclModel", "name", temp, "#all", "ifmissing", null, false, null);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:458:1: oclModelElement returns [Object ret2] : (temp= identifier EXCL temp= identifier ) ;
    public final Object oclModelElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OclModelElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:459:2: ( (temp= identifier EXCL temp= identifier ) )
            // ATL_ANTLR3.g:459:4: (temp= identifier EXCL temp= identifier )
            {
            // ATL_ANTLR3.g:459:4: (temp= identifier EXCL temp= identifier )
            // ATL_ANTLR3.g:459:5: temp= identifier EXCL temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_oclModelElement3064);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.setRef(ret, "model", "OclModel", "name", temp, "#all", "ifmissing", null, false, null);
            }
            match(input,EXCL,FOLLOW_EXCL_in_oclModelElement3068); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_oclModelElement3072);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:469:1: oclExpression returns [Object ret2] : (ret= priority_5 | ret= letExp ) ;
    public final Object oclExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:470:2: ( (ret= priority_5 | ret= letExp ) )
            // ATL_ANTLR3.g:470:4: (ret= priority_5 | ret= letExp )
            {
            // ATL_ANTLR3.g:470:4: (ret= priority_5 | ret= letExp )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=NAME && LA76_0<=FLOAT)||LA76_0==LPAREN||LA76_0==SHARP||LA76_0==MINUS||LA76_0==68||(LA76_0>=72 && LA76_0<=74)||LA76_0==77||(LA76_0>=79 && LA76_0<=93)) ) {
                alt76=1;
            }
            else if ( (LA76_0==78) ) {
                alt76=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("470:4: (ret= priority_5 | ret= letExp )", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ATL_ANTLR3.g:470:5: ret= priority_5
                    {
                    pushFollow(FOLLOW_priority_5_in_oclExpression3108);
                    ret=priority_5();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:470:21: ret= letExp
                    {
                    pushFollow(FOLLOW_letExp_in_oclExpression3113);
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
    // ATL_ANTLR3.g:477:1: iteratorExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN ) ;
    public final Object iteratorExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IteratorExp", true, false) : null;
        try {
            // ATL_ANTLR3.g:478:2: ( (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN ) )
            // ATL_ANTLR3.g:478:4: (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN )
            {
            // ATL_ANTLR3.g:478:4: (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN )
            // ATL_ANTLR3.g:478:5: temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN
            {
            pushFollow(FOLLOW_identifier_in_iteratorExp3148);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_iteratorExp3152); if (failed) return ret2;
            // ATL_ANTLR3.g:478:57: ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) )
            // ATL_ANTLR3.g:478:58: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            {
            // ATL_ANTLR3.g:478:58: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            // ATL_ANTLR3.g:478:59: temp= iterator ( ( ( COMA ) temp= iterator ) )*
            {
            pushFollow(FOLLOW_iterator_in_iteratorExp3158);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterators", temp);
            }
            // ATL_ANTLR3.g:478:107: ( ( ( COMA ) temp= iterator ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==COMA) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ATL_ANTLR3.g:478:108: ( ( COMA ) temp= iterator )
            	    {
            	    // ATL_ANTLR3.g:478:108: ( ( COMA ) temp= iterator )
            	    // ATL_ANTLR3.g:478:109: ( COMA ) temp= iterator
            	    {
            	    // ATL_ANTLR3.g:478:109: ( COMA )
            	    // ATL_ANTLR3.g:478:110: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_iteratorExp3165); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_iterator_in_iteratorExp3170);
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
            	    break loop77;
                }
            } while (true);


            }


            }

            match(input,PIPE,FOLLOW_PIPE_in_iteratorExp3179); if (failed) return ret2;
            // ATL_ANTLR3.g:478:174: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:478:175: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:478:175: (temp= oclExpression )
            // ATL_ANTLR3.g:478:176: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_iteratorExp3185);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "body", temp);
            }

            }


            }

            match(input,RPAREN,FOLLOW_RPAREN_in_iteratorExp3191); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          // discard operator name
                          ei.set(ret, "source", left);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:490:1: iterateExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN ) ;
    public final Object iterateExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IterateExp", true, false) : null;
        try {
            // ATL_ANTLR3.g:491:2: ( ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN ) )
            // ATL_ANTLR3.g:491:4: ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN )
            {
            // ATL_ANTLR3.g:491:4: ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN )
            // ATL_ANTLR3.g:491:5: 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN
            {
            match(input,71,FOLLOW_71_in_iterateExp3224); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_iterateExp3226); if (failed) return ret2;
            // ATL_ANTLR3.g:491:22: ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) )
            // ATL_ANTLR3.g:491:23: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            {
            // ATL_ANTLR3.g:491:23: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            // ATL_ANTLR3.g:491:24: temp= iterator ( ( ( COMA ) temp= iterator ) )*
            {
            pushFollow(FOLLOW_iterator_in_iterateExp3232);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterators", temp);
            }
            // ATL_ANTLR3.g:491:72: ( ( ( COMA ) temp= iterator ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==COMA) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // ATL_ANTLR3.g:491:73: ( ( COMA ) temp= iterator )
            	    {
            	    // ATL_ANTLR3.g:491:73: ( ( COMA ) temp= iterator )
            	    // ATL_ANTLR3.g:491:74: ( COMA ) temp= iterator
            	    {
            	    // ATL_ANTLR3.g:491:74: ( COMA )
            	    // ATL_ANTLR3.g:491:75: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_iterateExp3239); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_iterator_in_iterateExp3244);
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
            	    break loop78;
                }
            } while (true);


            }


            }

            match(input,SEMI,FOLLOW_SEMI_in_iterateExp3253); if (failed) return ret2;
            pushFollow(FOLLOW_variableDeclaration_in_iterateExp3257);
            temp=variableDeclaration();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "result", temp);
            }
            match(input,PIPE,FOLLOW_PIPE_in_iterateExp3261); if (failed) return ret2;
            // ATL_ANTLR3.g:491:200: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:491:201: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:491:201: (temp= oclExpression )
            // ATL_ANTLR3.g:491:202: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_iterateExp3267);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "body", temp);
            }

            }


            }

            match(input,RPAREN,FOLLOW_RPAREN_in_iterateExp3273); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          // discard operator name
                          ei.set(ret, "source", left);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:503:1: collectionOperationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) ;
    public final Object collectionOperationCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CollectionOperationCallExp", false, false) : null;
        try {
            // ATL_ANTLR3.g:504:2: ( (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) )
            // ATL_ANTLR3.g:504:4: (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            {
            // ATL_ANTLR3.g:504:4: (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            // ATL_ANTLR3.g:504:5: temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifier_in_collectionOperationCallExp3308);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "operationName", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_collectionOperationCallExp3312); if (failed) return ret2;
            // ATL_ANTLR3.g:504:66: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=NAME && LA80_0<=FLOAT)||LA80_0==LPAREN||LA80_0==SHARP||LA80_0==MINUS||LA80_0==68||(LA80_0>=72 && LA80_0<=74)||(LA80_0>=77 && LA80_0<=93)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ATL_ANTLR3.g:504:67: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:504:67: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:504:68: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_collectionOperationCallExp3318);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "arguments", temp);
                    }
                    // ATL_ANTLR3.g:504:121: ( ( ( COMA ) temp= oclExpression ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==COMA) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:504:122: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:504:122: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:504:123: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:504:123: ( COMA )
                    	    // ATL_ANTLR3.g:504:124: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_collectionOperationCallExp3325); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_collectionOperationCallExp3330);
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

            match(input,RPAREN,FOLLOW_RPAREN_in_collectionOperationCallExp3340); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          // discard operator name
                          ei.set(ret, "source", left);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:516:1: operationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) ;
    public final Object operationCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OperationCallExp", false, false) : null;
        try {
            // ATL_ANTLR3.g:517:2: ( (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) )
            // ATL_ANTLR3.g:517:4: (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            {
            // ATL_ANTLR3.g:517:4: (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            // ATL_ANTLR3.g:517:5: temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_operationCallExp3375);
            temp=identifierOrKeyword();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "operationName", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_operationCallExp3379); if (failed) return ret2;
            // ATL_ANTLR3.g:517:75: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=NAME && LA82_0<=FLOAT)||LA82_0==LPAREN||LA82_0==SHARP||LA82_0==MINUS||LA82_0==68||(LA82_0>=72 && LA82_0<=74)||(LA82_0>=77 && LA82_0<=93)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ATL_ANTLR3.g:517:76: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:517:76: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:517:77: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_operationCallExp3385);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "arguments", temp);
                    }
                    // ATL_ANTLR3.g:517:130: ( ( ( COMA ) temp= oclExpression ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==COMA) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:517:131: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:517:131: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:517:132: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:517:132: ( COMA )
                    	    // ATL_ANTLR3.g:517:133: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_operationCallExp3392); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_operationCallExp3397);
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
                    	    break loop81;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_operationCallExp3407); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          // discard operator name
                          ei.set(ret, "source", left);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:529:1: navigationOrAttributeCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword ) ;
    public final Object navigationOrAttributeCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("NavigationOrAttributeCallExp", false, false) : null;
        try {
            // ATL_ANTLR3.g:530:2: ( (temp= identifierOrKeyword ) )
            // ATL_ANTLR3.g:530:4: (temp= identifierOrKeyword )
            {
            // ATL_ANTLR3.g:530:4: (temp= identifierOrKeyword )
            // ATL_ANTLR3.g:530:5: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_navigationOrAttributeCallExp3442);
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:542:1: operatorCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object operatorCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OperatorCallExp", false, false) : null;
        try {
            // ATL_ANTLR3.g:543:2: ()
            // ATL_ANTLR3.g:544:9: 
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
    // ATL_ANTLR3.g:554:1: iterator returns [Object ret2] : (temp= identifier ) ;
    public final Object iterator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Iterator", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:555:2: ( (temp= identifier ) )
            // ATL_ANTLR3.g:555:4: (temp= identifier )
            {
            // ATL_ANTLR3.g:555:4: (temp= identifier )
            // ATL_ANTLR3.g:555:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_iterator3507);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:565:1: oclUndefinedExp returns [Object ret2] : ( 'OclUndefined' ) ;
    public final Object oclUndefinedExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclUndefinedExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:566:2: ( ( 'OclUndefined' ) )
            // ATL_ANTLR3.g:566:4: ( 'OclUndefined' )
            {
            // ATL_ANTLR3.g:566:4: ( 'OclUndefined' )
            // ATL_ANTLR3.g:566:5: 'OclUndefined'
            {
            match(input,72,FOLLOW_72_in_oclUndefinedExp3541); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:576:1: primitiveExp returns [Object ret2] : ( (ret= numericExp | ret= booleanExp | ret= stringExp ) ) ;
    public final Object primitiveExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:577:2: ( ( (ret= numericExp | ret= booleanExp | ret= stringExp ) ) )
            // ATL_ANTLR3.g:577:4: ( (ret= numericExp | ret= booleanExp | ret= stringExp ) )
            {
            // ATL_ANTLR3.g:577:4: ( (ret= numericExp | ret= booleanExp | ret= stringExp ) )
            // ATL_ANTLR3.g:577:5: (ret= numericExp | ret= booleanExp | ret= stringExp )
            {
            // ATL_ANTLR3.g:577:5: (ret= numericExp | ret= booleanExp | ret= stringExp )
            int alt83=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
                {
                alt83=1;
                }
                break;
            case 73:
            case 74:
                {
                alt83=2;
                }
                break;
            case STRING:
                {
                alt83=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("577:5: (ret= numericExp | ret= booleanExp | ret= stringExp )", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // ATL_ANTLR3.g:577:6: ret= numericExp
                    {
                    pushFollow(FOLLOW_numericExp_in_primitiveExp3576);
                    ret=numericExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:577:22: ret= booleanExp
                    {
                    pushFollow(FOLLOW_booleanExp_in_primitiveExp3581);
                    ret=booleanExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:577:38: ret= stringExp
                    {
                    pushFollow(FOLLOW_stringExp_in_primitiveExp3586);
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
    // ATL_ANTLR3.g:585:1: numericExp returns [Object ret2] : ( (ret= integerExp | ret= realExp ) ) ;
    public final Object numericExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:586:2: ( ( (ret= integerExp | ret= realExp ) ) )
            // ATL_ANTLR3.g:586:4: ( (ret= integerExp | ret= realExp ) )
            {
            // ATL_ANTLR3.g:586:4: ( (ret= integerExp | ret= realExp ) )
            // ATL_ANTLR3.g:586:5: (ret= integerExp | ret= realExp )
            {
            // ATL_ANTLR3.g:586:5: (ret= integerExp | ret= realExp )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==INT) ) {
                alt84=1;
            }
            else if ( (LA84_0==FLOAT) ) {
                alt84=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("586:5: (ret= integerExp | ret= realExp )", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // ATL_ANTLR3.g:586:6: ret= integerExp
                    {
                    pushFollow(FOLLOW_integerExp_in_numericExp3622);
                    ret=integerExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:586:22: ret= realExp
                    {
                    pushFollow(FOLLOW_realExp_in_numericExp3627);
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
    // ATL_ANTLR3.g:594:1: booleanExp returns [Object ret2] : ( ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object booleanExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("BooleanExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:595:2: ( ( ( ( 'true' ) | ( 'false' ) ) ) )
            // ATL_ANTLR3.g:595:4: ( ( ( 'true' ) | ( 'false' ) ) )
            {
            // ATL_ANTLR3.g:595:4: ( ( ( 'true' ) | ( 'false' ) ) )
            // ATL_ANTLR3.g:595:5: ( ( 'true' ) | ( 'false' ) )
            {
            // ATL_ANTLR3.g:595:5: ( ( 'true' ) | ( 'false' ) )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==73) ) {
                alt85=1;
            }
            else if ( (LA85_0==74) ) {
                alt85=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("595:5: ( ( 'true' ) | ( 'false' ) )", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // ATL_ANTLR3.g:595:6: ( 'true' )
                    {
                    // ATL_ANTLR3.g:595:6: ( 'true' )
                    // ATL_ANTLR3.g:595:7: 'true'
                    {
                    match(input,73,FOLLOW_73_in_booleanExp3662); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "booleanSymbol", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:595:72: ( 'false' )
                    {
                    // ATL_ANTLR3.g:595:72: ( 'false' )
                    // ATL_ANTLR3.g:595:73: 'false'
                    {
                    match(input,74,FOLLOW_74_in_booleanExp3669); if (failed) return ret2;

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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:605:1: integerExp returns [Object ret2] : (temp= integerSymbol ) ;
    public final Object integerExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IntegerExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:606:2: ( (temp= integerSymbol ) )
            // ATL_ANTLR3.g:606:4: (temp= integerSymbol )
            {
            // ATL_ANTLR3.g:606:4: (temp= integerSymbol )
            // ATL_ANTLR3.g:606:5: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_integerExp3707);
            temp=integerSymbol();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "integerSymbol", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:616:1: realExp returns [Object ret2] : (temp= floatSymbol ) ;
    public final Object realExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("RealExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:617:2: ( (temp= floatSymbol ) )
            // ATL_ANTLR3.g:617:4: (temp= floatSymbol )
            {
            // ATL_ANTLR3.g:617:4: (temp= floatSymbol )
            // ATL_ANTLR3.g:617:5: temp= floatSymbol
            {
            pushFollow(FOLLOW_floatSymbol_in_realExp3743);
            temp=floatSymbol();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "realSymbol", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:627:1: stringExp returns [Object ret2] : (temp= stringSymbol ) ;
    public final Object stringExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("StringExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:628:2: ( (temp= stringSymbol ) )
            // ATL_ANTLR3.g:628:4: (temp= stringSymbol )
            {
            // ATL_ANTLR3.g:628:4: (temp= stringSymbol )
            // ATL_ANTLR3.g:628:5: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_stringExp3779);
            temp=stringSymbol();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "stringSymbol", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:638:1: ifExp returns [Object ret2] : ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' ) ;
    public final Object ifExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IfExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:639:2: ( ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' ) )
            // ATL_ANTLR3.g:639:4: ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' )
            {
            // ATL_ANTLR3.g:639:4: ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' )
            // ATL_ANTLR3.g:639:5: 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif'
            {
            match(input,68,FOLLOW_68_in_ifExp3813); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_ifExp3817);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "condition", temp);
            }
            match(input,75,FOLLOW_75_in_ifExp3821); if (failed) return ret2;
            // ATL_ANTLR3.g:639:70: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:639:71: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:639:71: (temp= oclExpression )
            // ATL_ANTLR3.g:639:72: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_ifExp3827);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "thenExpression", temp);
            }

            }


            }

            match(input,69,FOLLOW_69_in_ifExp3833); if (failed) return ret2;
            // ATL_ANTLR3.g:639:139: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:639:140: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:639:140: (temp= oclExpression )
            // ATL_ANTLR3.g:639:141: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_ifExp3839);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elseExpression", temp);
            }

            }


            }

            match(input,76,FOLLOW_76_in_ifExp3845); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:649:1: variableExp returns [Object ret2] : (temp= identifier ) ;
    public final Object variableExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:650:2: ( (temp= identifier ) )
            // ATL_ANTLR3.g:650:4: (temp= identifier )
            {
            // ATL_ANTLR3.g:650:4: (temp= identifier )
            // ATL_ANTLR3.g:650:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_variableExp3879);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.setRef(ret, "referredVariable", "VariableDeclaration", "varName", temp, null, "ifmissing", null, false, null);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:660:1: superExp returns [Object ret2] : ( 'super' ) ;
    public final Object superExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("SuperExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:661:2: ( ( 'super' ) )
            // ATL_ANTLR3.g:661:4: ( 'super' )
            {
            // ATL_ANTLR3.g:661:4: ( 'super' )
            // ATL_ANTLR3.g:661:5: 'super'
            {
            match(input,77,FOLLOW_77_in_superExp3913); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:671:1: letExp returns [Object ret2] : ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) ) ;
    public final Object letExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LetExp", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:672:2: ( ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) ) )
            // ATL_ANTLR3.g:672:4: ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) )
            {
            // ATL_ANTLR3.g:672:4: ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) )
            // ATL_ANTLR3.g:672:5: 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) )
            {
            match(input,78,FOLLOW_78_in_letExp3945); if (failed) return ret2;
            pushFollow(FOLLOW_variableDeclaration_in_letExp3949);
            temp=variableDeclaration();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "variable", temp);
            }
            match(input,62,FOLLOW_62_in_letExp3953); if (failed) return ret2;
            // ATL_ANTLR3.g:672:74: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:672:75: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:672:75: (temp= oclExpression )
            // ATL_ANTLR3.g:672:76: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_letExp3959);
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
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:682:1: variableDeclaration returns [Object ret2] : (temp= identifier COLON temp= oclType EQ temp= oclExpression ) ;
    public final Object variableDeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:683:2: ( (temp= identifier COLON temp= oclType EQ temp= oclExpression ) )
            // ATL_ANTLR3.g:683:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression )
            {
            // ATL_ANTLR3.g:683:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression )
            // ATL_ANTLR3.g:683:5: temp= identifier COLON temp= oclType EQ temp= oclExpression
            {
            pushFollow(FOLLOW_identifier_in_variableDeclaration3997);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_variableDeclaration4001); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_variableDeclaration4005);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_variableDeclaration4009); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_variableDeclaration4013);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "initExpression", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:693:1: enumLiteralExp returns [Object ret2] : ( SHARP temp= identifier ) ;
    public final Object enumLiteralExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("EnumLiteralExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:694:2: ( ( SHARP temp= identifier ) )
            // ATL_ANTLR3.g:694:4: ( SHARP temp= identifier )
            {
            // ATL_ANTLR3.g:694:4: ( SHARP temp= identifier )
            // ATL_ANTLR3.g:694:5: SHARP temp= identifier
            {
            match(input,SHARP,FOLLOW_SHARP_in_enumLiteralExp4047); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_enumLiteralExp4051);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:704:1: collectionExp returns [Object ret2] : ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) ) ;
    public final Object collectionExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:705:2: ( ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) ) )
            // ATL_ANTLR3.g:705:4: ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) )
            {
            // ATL_ANTLR3.g:705:4: ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) )
            // ATL_ANTLR3.g:705:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )
            {
            // ATL_ANTLR3.g:705:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )
            int alt86=4;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt86=1;
                }
                break;
            case 80:
                {
                alt86=2;
                }
                break;
            case 81:
                {
                alt86=3;
                }
                break;
            case 82:
                {
                alt86=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("705:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // ATL_ANTLR3.g:705:6: ret= bagExp
                    {
                    pushFollow(FOLLOW_bagExp_in_collectionExp4088);
                    ret=bagExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:705:18: ret= setExp
                    {
                    pushFollow(FOLLOW_setExp_in_collectionExp4093);
                    ret=setExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:705:30: ret= orderedSetExp
                    {
                    pushFollow(FOLLOW_orderedSetExp_in_collectionExp4098);
                    ret=orderedSetExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:705:49: ret= sequenceExp
                    {
                    pushFollow(FOLLOW_sequenceExp_in_collectionExp4103);
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
    // ATL_ANTLR3.g:713:1: bagExp returns [Object ret2] : ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object bagExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BagExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:714:2: ( ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:714:4: ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:714:4: ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:714:5: 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,79,FOLLOW_79_in_bagExp4136); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_bagExp4138); if (failed) return ret2;
            // ATL_ANTLR3.g:714:18: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( ((LA88_0>=NAME && LA88_0<=FLOAT)||LA88_0==LPAREN||LA88_0==SHARP||LA88_0==MINUS||LA88_0==68||(LA88_0>=72 && LA88_0<=74)||(LA88_0>=77 && LA88_0<=93)) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ATL_ANTLR3.g:714:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:714:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:714:20: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_bagExp4144);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:714:72: ( ( ( COMA ) temp= oclExpression ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==COMA) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:714:73: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:714:73: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:714:74: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:714:74: ( COMA )
                    	    // ATL_ANTLR3.g:714:75: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_bagExp4151); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_bagExp4156);
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

            match(input,RCURLY,FOLLOW_RCURLY_in_bagExp4166); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:724:1: setExp returns [Object ret2] : ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object setExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SetExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:725:2: ( ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:725:4: ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:725:4: ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:725:5: 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,80,FOLLOW_80_in_setExp4198); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_setExp4200); if (failed) return ret2;
            // ATL_ANTLR3.g:725:18: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=NAME && LA90_0<=FLOAT)||LA90_0==LPAREN||LA90_0==SHARP||LA90_0==MINUS||LA90_0==68||(LA90_0>=72 && LA90_0<=74)||(LA90_0>=77 && LA90_0<=93)) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ATL_ANTLR3.g:725:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:725:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:725:20: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_setExp4206);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:725:72: ( ( ( COMA ) temp= oclExpression ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==COMA) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:725:73: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:725:73: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:725:74: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:725:74: ( COMA )
                    	    // ATL_ANTLR3.g:725:75: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_setExp4213); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_setExp4218);
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

            match(input,RCURLY,FOLLOW_RCURLY_in_setExp4228); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:735:1: orderedSetExp returns [Object ret2] : ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object orderedSetExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OrderedSetExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:736:2: ( ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:736:4: ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:736:4: ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:736:5: 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,81,FOLLOW_81_in_orderedSetExp4260); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_orderedSetExp4262); if (failed) return ret2;
            // ATL_ANTLR3.g:736:25: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( ((LA92_0>=NAME && LA92_0<=FLOAT)||LA92_0==LPAREN||LA92_0==SHARP||LA92_0==MINUS||LA92_0==68||(LA92_0>=72 && LA92_0<=74)||(LA92_0>=77 && LA92_0<=93)) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ATL_ANTLR3.g:736:26: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:736:26: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:736:27: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_orderedSetExp4268);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:736:79: ( ( ( COMA ) temp= oclExpression ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==COMA) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:736:80: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:736:80: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:736:81: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:736:81: ( COMA )
                    	    // ATL_ANTLR3.g:736:82: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_orderedSetExp4275); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_orderedSetExp4280);
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

            match(input,RCURLY,FOLLOW_RCURLY_in_orderedSetExp4290); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:746:1: sequenceExp returns [Object ret2] : ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object sequenceExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SequenceExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:747:2: ( ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:747:4: ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:747:4: ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:747:5: 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,82,FOLLOW_82_in_sequenceExp4322); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_sequenceExp4324); if (failed) return ret2;
            // ATL_ANTLR3.g:747:23: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( ((LA94_0>=NAME && LA94_0<=FLOAT)||LA94_0==LPAREN||LA94_0==SHARP||LA94_0==MINUS||LA94_0==68||(LA94_0>=72 && LA94_0<=74)||(LA94_0>=77 && LA94_0<=93)) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ATL_ANTLR3.g:747:24: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:747:24: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:747:25: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_sequenceExp4330);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:747:77: ( ( ( COMA ) temp= oclExpression ) )*
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==COMA) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:747:78: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:747:78: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:747:79: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:747:79: ( COMA )
                    	    // ATL_ANTLR3.g:747:80: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_sequenceExp4337); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_sequenceExp4342);
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
                    	    break loop93;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_sequenceExp4352); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:757:1: mapExp returns [Object ret2] : ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY ) ;
    public final Object mapExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:758:2: ( ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:758:4: ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:758:4: ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:758:5: 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY
            {
            match(input,83,FOLLOW_83_in_mapExp4384); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_mapExp4386); if (failed) return ret2;
            // ATL_ANTLR3.g:758:18: ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==LPAREN) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ATL_ANTLR3.g:758:19: (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* )
                    {
                    // ATL_ANTLR3.g:758:19: (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* )
                    // ATL_ANTLR3.g:758:20: temp= mapElement ( ( ( COMA ) temp= mapElement ) )*
                    {
                    pushFollow(FOLLOW_mapElement_in_mapExp4392);
                    temp=mapElement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:758:69: ( ( ( COMA ) temp= mapElement ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==COMA) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:758:70: ( ( COMA ) temp= mapElement )
                    	    {
                    	    // ATL_ANTLR3.g:758:70: ( ( COMA ) temp= mapElement )
                    	    // ATL_ANTLR3.g:758:71: ( COMA ) temp= mapElement
                    	    {
                    	    // ATL_ANTLR3.g:758:71: ( COMA )
                    	    // ATL_ANTLR3.g:758:72: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_mapExp4399); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_mapElement_in_mapExp4404);
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
                    	    break loop95;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_mapExp4414); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:768:1: mapElement returns [Object ret2] : ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN ) ;
    public final Object mapElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:769:2: ( ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN ) )
            // ATL_ANTLR3.g:769:4: ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN )
            {
            // ATL_ANTLR3.g:769:4: ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN )
            // ATL_ANTLR3.g:769:5: LPAREN temp= oclExpression COMA temp= oclExpression RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_mapElement4446); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_mapElement4450);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "key", temp);
            }
            match(input,COMA,FOLLOW_COMA_in_mapElement4454); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_mapElement4458);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "value", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_mapElement4462); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:779:1: tupleExp returns [Object ret2] : ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY ) ;
    public final Object tupleExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:780:2: ( ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:780:4: ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:780:4: ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:780:5: 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY
            {
            match(input,84,FOLLOW_84_in_tupleExp4494); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_tupleExp4496); if (failed) return ret2;
            // ATL_ANTLR3.g:780:20: ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==NAME||(LA98_0>=43 && LA98_0<=99)) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ATL_ANTLR3.g:780:21: (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* )
                    {
                    // ATL_ANTLR3.g:780:21: (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* )
                    // ATL_ANTLR3.g:780:22: temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )*
                    {
                    pushFollow(FOLLOW_tuplePart_in_tupleExp4502);
                    temp=tuplePart();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "tuplePart", temp);
                    }
                    // ATL_ANTLR3.g:780:71: ( ( ( COMA ) temp= tuplePart ) )*
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==COMA) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:780:72: ( ( COMA ) temp= tuplePart )
                    	    {
                    	    // ATL_ANTLR3.g:780:72: ( ( COMA ) temp= tuplePart )
                    	    // ATL_ANTLR3.g:780:73: ( COMA ) temp= tuplePart
                    	    {
                    	    // ATL_ANTLR3.g:780:73: ( COMA )
                    	    // ATL_ANTLR3.g:780:74: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_tupleExp4509); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_tuplePart_in_tupleExp4514);
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
                    	    break loop97;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_tupleExp4524); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:790:1: tuplePart returns [Object ret2] : (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression ) ;
    public final Object tuplePart() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TuplePart", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:791:2: ( (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression ) )
            // ATL_ANTLR3.g:791:4: (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression )
            {
            // ATL_ANTLR3.g:791:4: (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression )
            // ATL_ANTLR3.g:791:5: temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tuplePart4558);
            temp=identifierOrKeyword();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            // ATL_ANTLR3.g:791:62: ( ( COLON temp= oclType ) | () )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==COLON) ) {
                alt99=1;
            }
            else if ( (LA99_0==EQ) ) {
                alt99=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("791:62: ( ( COLON temp= oclType ) | () )", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // ATL_ANTLR3.g:791:63: ( COLON temp= oclType )
                    {
                    // ATL_ANTLR3.g:791:63: ( COLON temp= oclType )
                    // ATL_ANTLR3.g:791:64: COLON temp= oclType
                    {
                    match(input,COLON,FOLLOW_COLON_in_tuplePart4564); if (failed) return ret2;
                    pushFollow(FOLLOW_oclType_in_tuplePart4568);
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
                    // ATL_ANTLR3.g:791:117: ()
                    {
                    // ATL_ANTLR3.g:791:117: ()
                    // ATL_ANTLR3.g:791:118: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            match(input,EQ,FOLLOW_EQ_in_tuplePart4582); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_tuplePart4586);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "initExpression", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:801:1: oclType returns [Object ret2] : ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) ) ;
    public final Object oclType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:802:2: ( ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) ) )
            // ATL_ANTLR3.g:802:4: ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) )
            {
            // ATL_ANTLR3.g:802:4: ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) )
            // ATL_ANTLR3.g:802:5: (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )
            {
            // ATL_ANTLR3.g:802:5: (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )
            int alt100=7;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt100=1;
                }
                break;
            case 86:
                {
                alt100=2;
                }
                break;
            case 87:
                {
                alt100=3;
                }
                break;
            case 83:
                {
                alt100=4;
                }
                break;
            case 88:
            case 89:
            case 90:
            case 91:
                {
                alt100=5;
                }
                break;
            case 79:
            case 80:
            case 81:
            case 82:
            case 92:
                {
                alt100=6;
                }
                break;
            case 85:
                {
                alt100=7;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("802:5: (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // ATL_ANTLR3.g:802:6: ret= oclModelElement
                    {
                    pushFollow(FOLLOW_oclModelElement_in_oclType4623);
                    ret=oclModelElement();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:802:27: ret= oclAnyType
                    {
                    pushFollow(FOLLOW_oclAnyType_in_oclType4628);
                    ret=oclAnyType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:802:43: ret= tupleType
                    {
                    pushFollow(FOLLOW_tupleType_in_oclType4633);
                    ret=tupleType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:802:58: ret= mapType
                    {
                    pushFollow(FOLLOW_mapType_in_oclType4638);
                    ret=mapType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 5 :
                    // ATL_ANTLR3.g:802:71: ret= primitive
                    {
                    pushFollow(FOLLOW_primitive_in_oclType4643);
                    ret=primitive();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 6 :
                    // ATL_ANTLR3.g:802:86: ret= collectionType
                    {
                    pushFollow(FOLLOW_collectionType_in_oclType4648);
                    ret=collectionType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 7 :
                    // ATL_ANTLR3.g:802:106: ret= oclType_abstractContents
                    {
                    pushFollow(FOLLOW_oclType_abstractContents_in_oclType4653);
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
    // ATL_ANTLR3.g:810:1: oclAnyType returns [Object ret2] : ( 'OclAny' ) ;
    public final Object oclAnyType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclAnyType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:811:2: ( ( 'OclAny' ) )
            // ATL_ANTLR3.g:811:4: ( 'OclAny' )
            {
            // ATL_ANTLR3.g:811:4: ( 'OclAny' )
            // ATL_ANTLR3.g:811:5: 'OclAny'
            {
            match(input,86,FOLLOW_86_in_oclAnyType4686); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:821:1: tupleType returns [Object ret2] : ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN ) ;
    public final Object tupleType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:822:2: ( ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN ) )
            // ATL_ANTLR3.g:822:4: ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN )
            {
            // ATL_ANTLR3.g:822:4: ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN )
            // ATL_ANTLR3.g:822:5: 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN
            {
            match(input,87,FOLLOW_87_in_tupleType4718); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_tupleType4720); if (failed) return ret2;
            // ATL_ANTLR3.g:822:24: ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==NAME) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // ATL_ANTLR3.g:822:25: (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* )
                    {
                    // ATL_ANTLR3.g:822:25: (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* )
                    // ATL_ANTLR3.g:822:26: temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )*
                    {
                    pushFollow(FOLLOW_tupleTypeAttribute_in_tupleType4726);
                    temp=tupleTypeAttribute();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "attributes", temp);
                    }
                    // ATL_ANTLR3.g:822:85: ( ( ( COMA ) temp= tupleTypeAttribute ) )*
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==COMA) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:822:86: ( ( COMA ) temp= tupleTypeAttribute )
                    	    {
                    	    // ATL_ANTLR3.g:822:86: ( ( COMA ) temp= tupleTypeAttribute )
                    	    // ATL_ANTLR3.g:822:87: ( COMA ) temp= tupleTypeAttribute
                    	    {
                    	    // ATL_ANTLR3.g:822:87: ( COMA )
                    	    // ATL_ANTLR3.g:822:88: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_tupleType4733); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_tupleTypeAttribute_in_tupleType4738);
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
                    	    break loop101;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_tupleType4748); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:832:1: tupleTypeAttribute returns [Object ret2] : (temp= identifier COLON temp= oclType ) ;
    public final Object tupleTypeAttribute() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleTypeAttribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:833:2: ( (temp= identifier COLON temp= oclType ) )
            // ATL_ANTLR3.g:833:4: (temp= identifier COLON temp= oclType )
            {
            // ATL_ANTLR3.g:833:4: (temp= identifier COLON temp= oclType )
            // ATL_ANTLR3.g:833:5: temp= identifier COLON temp= oclType
            {
            pushFollow(FOLLOW_identifier_in_tupleTypeAttribute4782);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_tupleTypeAttribute4786); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_tupleTypeAttribute4790);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:843:1: mapType returns [Object ret2] : ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN ) ;
    public final Object mapType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:844:2: ( ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:844:4: ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:844:4: ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN )
            // ATL_ANTLR3.g:844:5: 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN
            {
            match(input,83,FOLLOW_83_in_mapType4824); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_mapType4826); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_mapType4830);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "keyType", temp);
            }
            match(input,COMA,FOLLOW_COMA_in_mapType4834); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_mapType4838);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "valueType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_mapType4842); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:854:1: primitive returns [Object ret2] : ( (ret= numericType | ret= booleanType | ret= stringType ) ) ;
    public final Object primitive() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:855:2: ( ( (ret= numericType | ret= booleanType | ret= stringType ) ) )
            // ATL_ANTLR3.g:855:4: ( (ret= numericType | ret= booleanType | ret= stringType ) )
            {
            // ATL_ANTLR3.g:855:4: ( (ret= numericType | ret= booleanType | ret= stringType ) )
            // ATL_ANTLR3.g:855:5: (ret= numericType | ret= booleanType | ret= stringType )
            {
            // ATL_ANTLR3.g:855:5: (ret= numericType | ret= booleanType | ret= stringType )
            int alt103=3;
            switch ( input.LA(1) ) {
            case 88:
            case 89:
                {
                alt103=1;
                }
                break;
            case 90:
                {
                alt103=2;
                }
                break;
            case 91:
                {
                alt103=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("855:5: (ret= numericType | ret= booleanType | ret= stringType )", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // ATL_ANTLR3.g:855:6: ret= numericType
                    {
                    pushFollow(FOLLOW_numericType_in_primitive4877);
                    ret=numericType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:855:23: ret= booleanType
                    {
                    pushFollow(FOLLOW_booleanType_in_primitive4882);
                    ret=booleanType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:855:40: ret= stringType
                    {
                    pushFollow(FOLLOW_stringType_in_primitive4887);
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
    // ATL_ANTLR3.g:863:1: numericType returns [Object ret2] : ( (ret= integerType | ret= realType ) ) ;
    public final Object numericType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:864:2: ( ( (ret= integerType | ret= realType ) ) )
            // ATL_ANTLR3.g:864:4: ( (ret= integerType | ret= realType ) )
            {
            // ATL_ANTLR3.g:864:4: ( (ret= integerType | ret= realType ) )
            // ATL_ANTLR3.g:864:5: (ret= integerType | ret= realType )
            {
            // ATL_ANTLR3.g:864:5: (ret= integerType | ret= realType )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==88) ) {
                alt104=1;
            }
            else if ( (LA104_0==89) ) {
                alt104=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("864:5: (ret= integerType | ret= realType )", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // ATL_ANTLR3.g:864:6: ret= integerType
                    {
                    pushFollow(FOLLOW_integerType_in_numericType4923);
                    ret=integerType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:864:23: ret= realType
                    {
                    pushFollow(FOLLOW_realType_in_numericType4928);
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
    // ATL_ANTLR3.g:872:1: integerType returns [Object ret2] : ( 'Integer' ) ;
    public final Object integerType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("IntegerType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:873:2: ( ( 'Integer' ) )
            // ATL_ANTLR3.g:873:4: ( 'Integer' )
            {
            // ATL_ANTLR3.g:873:4: ( 'Integer' )
            // ATL_ANTLR3.g:873:5: 'Integer'
            {
            match(input,88,FOLLOW_88_in_integerType4961); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:883:1: realType returns [Object ret2] : ( 'Real' ) ;
    public final Object realType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("RealType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:884:2: ( ( 'Real' ) )
            // ATL_ANTLR3.g:884:4: ( 'Real' )
            {
            // ATL_ANTLR3.g:884:4: ( 'Real' )
            // ATL_ANTLR3.g:884:5: 'Real'
            {
            match(input,89,FOLLOW_89_in_realType4993); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:894:1: booleanType returns [Object ret2] : ( 'Boolean' ) ;
    public final Object booleanType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("BooleanType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:895:2: ( ( 'Boolean' ) )
            // ATL_ANTLR3.g:895:4: ( 'Boolean' )
            {
            // ATL_ANTLR3.g:895:4: ( 'Boolean' )
            // ATL_ANTLR3.g:895:5: 'Boolean'
            {
            match(input,90,FOLLOW_90_in_booleanType5025); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:905:1: stringType returns [Object ret2] : ( 'String' ) ;
    public final Object stringType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("StringType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:906:2: ( ( 'String' ) )
            // ATL_ANTLR3.g:906:4: ( 'String' )
            {
            // ATL_ANTLR3.g:906:4: ( 'String' )
            // ATL_ANTLR3.g:906:5: 'String'
            {
            match(input,91,FOLLOW_91_in_stringType5057); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:916:1: collectionType returns [Object ret2] : ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) ) ;
    public final Object collectionType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:917:2: ( ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) ) )
            // ATL_ANTLR3.g:917:4: ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) )
            {
            // ATL_ANTLR3.g:917:4: ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) )
            // ATL_ANTLR3.g:917:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )
            {
            // ATL_ANTLR3.g:917:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )
            int alt105=5;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt105=1;
                }
                break;
            case 80:
                {
                alt105=2;
                }
                break;
            case 81:
                {
                alt105=3;
                }
                break;
            case 82:
                {
                alt105=4;
                }
                break;
            case 92:
                {
                alt105=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("917:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )", 105, 0, input);

                throw nvae;
            }

            switch (alt105) {
                case 1 :
                    // ATL_ANTLR3.g:917:6: ret= bagType
                    {
                    pushFollow(FOLLOW_bagType_in_collectionType5092);
                    ret=bagType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:917:19: ret= setType
                    {
                    pushFollow(FOLLOW_setType_in_collectionType5097);
                    ret=setType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:917:32: ret= orderedSetType
                    {
                    pushFollow(FOLLOW_orderedSetType_in_collectionType5102);
                    ret=orderedSetType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:917:52: ret= sequenceType
                    {
                    pushFollow(FOLLOW_sequenceType_in_collectionType5107);
                    ret=sequenceType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 5 :
                    // ATL_ANTLR3.g:917:70: ret= collectionType_abstractContents
                    {
                    pushFollow(FOLLOW_collectionType_abstractContents_in_collectionType5112);
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
    // ATL_ANTLR3.g:925:1: bagType returns [Object ret2] : ( 'Bag' LPAREN temp= oclType RPAREN ) ;
    public final Object bagType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BagType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:926:2: ( ( 'Bag' LPAREN temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:926:4: ( 'Bag' LPAREN temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:926:4: ( 'Bag' LPAREN temp= oclType RPAREN )
            // ATL_ANTLR3.g:926:5: 'Bag' LPAREN temp= oclType RPAREN
            {
            match(input,79,FOLLOW_79_in_bagType5145); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_bagType5147); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_bagType5151);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_bagType5155); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:936:1: setType returns [Object ret2] : ( 'Set' LPAREN temp= oclType RPAREN ) ;
    public final Object setType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SetType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:937:2: ( ( 'Set' LPAREN temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:937:4: ( 'Set' LPAREN temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:937:4: ( 'Set' LPAREN temp= oclType RPAREN )
            // ATL_ANTLR3.g:937:5: 'Set' LPAREN temp= oclType RPAREN
            {
            match(input,80,FOLLOW_80_in_setType5187); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_setType5189); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_setType5193);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_setType5197); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:947:1: orderedSetType returns [Object ret2] : ( 'OrderedSet' LPAREN temp= oclType RPAREN ) ;
    public final Object orderedSetType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OrderedSetType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:948:2: ( ( 'OrderedSet' LPAREN temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:948:4: ( 'OrderedSet' LPAREN temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:948:4: ( 'OrderedSet' LPAREN temp= oclType RPAREN )
            // ATL_ANTLR3.g:948:5: 'OrderedSet' LPAREN temp= oclType RPAREN
            {
            match(input,81,FOLLOW_81_in_orderedSetType5229); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_orderedSetType5231); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_orderedSetType5235);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_orderedSetType5239); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:958:1: sequenceType returns [Object ret2] : ( 'Sequence' LPAREN temp= oclType RPAREN ) ;
    public final Object sequenceType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SequenceType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:959:2: ( ( 'Sequence' LPAREN temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:959:4: ( 'Sequence' LPAREN temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:959:4: ( 'Sequence' LPAREN temp= oclType RPAREN )
            // ATL_ANTLR3.g:959:5: 'Sequence' LPAREN temp= oclType RPAREN
            {
            match(input,82,FOLLOW_82_in_sequenceType5271); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_sequenceType5273); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_sequenceType5277);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_sequenceType5281); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:969:1: priority_0 returns [Object ret2] : (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:970:2: ( (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* ) )
            // ATL_ANTLR3.g:970:4: (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* )
            {
            // ATL_ANTLR3.g:970:4: (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* )
            // ATL_ANTLR3.g:970:5: ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_oclExpression_in_priority_05315);
            ret=primary_oclExpression();
            _fsp--;
            if (failed) return ret2;
            // ATL_ANTLR3.g:970:31: ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==RARROW||LA109_0==POINT) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // ATL_ANTLR3.g:970:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )
            	    {
            	    // ATL_ANTLR3.g:970:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )
            	    int alt108=2;
            	    int LA108_0 = input.LA(1);

            	    if ( (LA108_0==POINT) ) {
            	        alt108=1;
            	    }
            	    else if ( (LA108_0==RARROW) ) {
            	        alt108=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("970:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )", 108, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt108) {
            	        case 1 :
            	            // ATL_ANTLR3.g:970:33: ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) )
            	            {
            	            // ATL_ANTLR3.g:970:33: ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) )
            	            // ATL_ANTLR3.g:970:34: POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )
            	            {
            	            match(input,POINT,FOLLOW_POINT_in_priority_05320); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = ".";
            	            }
            	            // ATL_ANTLR3.g:970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )
            	            int alt106=2;
            	            switch ( input.LA(1) ) {
            	            case NAME:
            	                {
            	                int LA106_1 = input.LA(2);

            	                if ( (LA106_1==EOF||(LA106_1>=SEMI && LA106_1<=EQ)||LA106_1==RPAREN||(LA106_1>=RCURLY && LA106_1<=LARROW)||LA106_1==PIPE||(LA106_1>=POINT && LA106_1<=NE)||LA106_1==62||LA106_1==69||(LA106_1>=75 && LA106_1<=76)||(LA106_1>=94 && LA106_1<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_1==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 1, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 43:
            	                {
            	                int LA106_2 = input.LA(2);

            	                if ( (LA106_2==EOF||(LA106_2>=SEMI && LA106_2<=EQ)||LA106_2==RPAREN||(LA106_2>=RCURLY && LA106_2<=LARROW)||LA106_2==PIPE||(LA106_2>=POINT && LA106_2<=NE)||LA106_2==62||LA106_2==69||(LA106_2>=75 && LA106_2<=76)||(LA106_2>=94 && LA106_2<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_2==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 2, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 44:
            	                {
            	                int LA106_3 = input.LA(2);

            	                if ( (LA106_3==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_3==EOF||(LA106_3>=SEMI && LA106_3<=EQ)||LA106_3==RPAREN||(LA106_3>=RCURLY && LA106_3<=LARROW)||LA106_3==PIPE||(LA106_3>=POINT && LA106_3<=NE)||LA106_3==62||LA106_3==69||(LA106_3>=75 && LA106_3<=76)||(LA106_3>=94 && LA106_3<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 3, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 45:
            	                {
            	                int LA106_4 = input.LA(2);

            	                if ( (LA106_4==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_4==EOF||(LA106_4>=SEMI && LA106_4<=EQ)||LA106_4==RPAREN||(LA106_4>=RCURLY && LA106_4<=LARROW)||LA106_4==PIPE||(LA106_4>=POINT && LA106_4<=NE)||LA106_4==62||LA106_4==69||(LA106_4>=75 && LA106_4<=76)||(LA106_4>=94 && LA106_4<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 4, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 46:
            	                {
            	                int LA106_5 = input.LA(2);

            	                if ( (LA106_5==EOF||(LA106_5>=SEMI && LA106_5<=EQ)||LA106_5==RPAREN||(LA106_5>=RCURLY && LA106_5<=LARROW)||LA106_5==PIPE||(LA106_5>=POINT && LA106_5<=NE)||LA106_5==62||LA106_5==69||(LA106_5>=75 && LA106_5<=76)||(LA106_5>=94 && LA106_5<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_5==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 5, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 47:
            	                {
            	                int LA106_6 = input.LA(2);

            	                if ( (LA106_6==EOF||(LA106_6>=SEMI && LA106_6<=EQ)||LA106_6==RPAREN||(LA106_6>=RCURLY && LA106_6<=LARROW)||LA106_6==PIPE||(LA106_6>=POINT && LA106_6<=NE)||LA106_6==62||LA106_6==69||(LA106_6>=75 && LA106_6<=76)||(LA106_6>=94 && LA106_6<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_6==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 6, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 48:
            	                {
            	                int LA106_7 = input.LA(2);

            	                if ( (LA106_7==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_7==EOF||(LA106_7>=SEMI && LA106_7<=EQ)||LA106_7==RPAREN||(LA106_7>=RCURLY && LA106_7<=LARROW)||LA106_7==PIPE||(LA106_7>=POINT && LA106_7<=NE)||LA106_7==62||LA106_7==69||(LA106_7>=75 && LA106_7<=76)||(LA106_7>=94 && LA106_7<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 7, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 49:
            	                {
            	                int LA106_8 = input.LA(2);

            	                if ( (LA106_8==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_8==EOF||(LA106_8>=SEMI && LA106_8<=EQ)||LA106_8==RPAREN||(LA106_8>=RCURLY && LA106_8<=LARROW)||LA106_8==PIPE||(LA106_8>=POINT && LA106_8<=NE)||LA106_8==62||LA106_8==69||(LA106_8>=75 && LA106_8<=76)||(LA106_8>=94 && LA106_8<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 8, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 50:
            	                {
            	                int LA106_9 = input.LA(2);

            	                if ( (LA106_9==EOF||(LA106_9>=SEMI && LA106_9<=EQ)||LA106_9==RPAREN||(LA106_9>=RCURLY && LA106_9<=LARROW)||LA106_9==PIPE||(LA106_9>=POINT && LA106_9<=NE)||LA106_9==62||LA106_9==69||(LA106_9>=75 && LA106_9<=76)||(LA106_9>=94 && LA106_9<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_9==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 9, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 51:
            	                {
            	                int LA106_10 = input.LA(2);

            	                if ( (LA106_10==EOF||(LA106_10>=SEMI && LA106_10<=EQ)||LA106_10==RPAREN||(LA106_10>=RCURLY && LA106_10<=LARROW)||LA106_10==PIPE||(LA106_10>=POINT && LA106_10<=NE)||LA106_10==62||LA106_10==69||(LA106_10>=75 && LA106_10<=76)||(LA106_10>=94 && LA106_10<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_10==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 10, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 52:
            	                {
            	                int LA106_11 = input.LA(2);

            	                if ( (LA106_11==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_11==EOF||(LA106_11>=SEMI && LA106_11<=EQ)||LA106_11==RPAREN||(LA106_11>=RCURLY && LA106_11<=LARROW)||LA106_11==PIPE||(LA106_11>=POINT && LA106_11<=NE)||LA106_11==62||LA106_11==69||(LA106_11>=75 && LA106_11<=76)||(LA106_11>=94 && LA106_11<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 11, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 53:
            	                {
            	                int LA106_12 = input.LA(2);

            	                if ( (LA106_12==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_12==EOF||(LA106_12>=SEMI && LA106_12<=EQ)||LA106_12==RPAREN||(LA106_12>=RCURLY && LA106_12<=LARROW)||LA106_12==PIPE||(LA106_12>=POINT && LA106_12<=NE)||LA106_12==62||LA106_12==69||(LA106_12>=75 && LA106_12<=76)||(LA106_12>=94 && LA106_12<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 12, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 54:
            	                {
            	                int LA106_13 = input.LA(2);

            	                if ( (LA106_13==EOF||(LA106_13>=SEMI && LA106_13<=EQ)||LA106_13==RPAREN||(LA106_13>=RCURLY && LA106_13<=LARROW)||LA106_13==PIPE||(LA106_13>=POINT && LA106_13<=NE)||LA106_13==62||LA106_13==69||(LA106_13>=75 && LA106_13<=76)||(LA106_13>=94 && LA106_13<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_13==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 13, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 55:
            	                {
            	                int LA106_14 = input.LA(2);

            	                if ( (LA106_14==EOF||(LA106_14>=SEMI && LA106_14<=EQ)||LA106_14==RPAREN||(LA106_14>=RCURLY && LA106_14<=LARROW)||LA106_14==PIPE||(LA106_14>=POINT && LA106_14<=NE)||LA106_14==62||LA106_14==69||(LA106_14>=75 && LA106_14<=76)||(LA106_14>=94 && LA106_14<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_14==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 14, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 56:
            	                {
            	                int LA106_15 = input.LA(2);

            	                if ( (LA106_15==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_15==EOF||(LA106_15>=SEMI && LA106_15<=EQ)||LA106_15==RPAREN||(LA106_15>=RCURLY && LA106_15<=LARROW)||LA106_15==PIPE||(LA106_15>=POINT && LA106_15<=NE)||LA106_15==62||LA106_15==69||(LA106_15>=75 && LA106_15<=76)||(LA106_15>=94 && LA106_15<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 15, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 57:
            	                {
            	                int LA106_16 = input.LA(2);

            	                if ( (LA106_16==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_16==EOF||(LA106_16>=SEMI && LA106_16<=EQ)||LA106_16==RPAREN||(LA106_16>=RCURLY && LA106_16<=LARROW)||LA106_16==PIPE||(LA106_16>=POINT && LA106_16<=NE)||LA106_16==62||LA106_16==69||(LA106_16>=75 && LA106_16<=76)||(LA106_16>=94 && LA106_16<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 16, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 58:
            	                {
            	                int LA106_17 = input.LA(2);

            	                if ( (LA106_17==EOF||(LA106_17>=SEMI && LA106_17<=EQ)||LA106_17==RPAREN||(LA106_17>=RCURLY && LA106_17<=LARROW)||LA106_17==PIPE||(LA106_17>=POINT && LA106_17<=NE)||LA106_17==62||LA106_17==69||(LA106_17>=75 && LA106_17<=76)||(LA106_17>=94 && LA106_17<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_17==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 17, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 59:
            	                {
            	                int LA106_18 = input.LA(2);

            	                if ( (LA106_18==EOF||(LA106_18>=SEMI && LA106_18<=EQ)||LA106_18==RPAREN||(LA106_18>=RCURLY && LA106_18<=LARROW)||LA106_18==PIPE||(LA106_18>=POINT && LA106_18<=NE)||LA106_18==62||LA106_18==69||(LA106_18>=75 && LA106_18<=76)||(LA106_18>=94 && LA106_18<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_18==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 18, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 60:
            	                {
            	                int LA106_19 = input.LA(2);

            	                if ( (LA106_19==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_19==EOF||(LA106_19>=SEMI && LA106_19<=EQ)||LA106_19==RPAREN||(LA106_19>=RCURLY && LA106_19<=LARROW)||LA106_19==PIPE||(LA106_19>=POINT && LA106_19<=NE)||LA106_19==62||LA106_19==69||(LA106_19>=75 && LA106_19<=76)||(LA106_19>=94 && LA106_19<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 19, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 61:
            	                {
            	                int LA106_20 = input.LA(2);

            	                if ( (LA106_20==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_20==EOF||(LA106_20>=SEMI && LA106_20<=EQ)||LA106_20==RPAREN||(LA106_20>=RCURLY && LA106_20<=LARROW)||LA106_20==PIPE||(LA106_20>=POINT && LA106_20<=NE)||LA106_20==62||LA106_20==69||(LA106_20>=75 && LA106_20<=76)||(LA106_20>=94 && LA106_20<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 20, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 62:
            	                {
            	                int LA106_21 = input.LA(2);

            	                if ( (LA106_21==EOF||(LA106_21>=SEMI && LA106_21<=EQ)||LA106_21==RPAREN||(LA106_21>=RCURLY && LA106_21<=LARROW)||LA106_21==PIPE||(LA106_21>=POINT && LA106_21<=NE)||LA106_21==62||LA106_21==69||(LA106_21>=75 && LA106_21<=76)||(LA106_21>=94 && LA106_21<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_21==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 21, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 63:
            	                {
            	                int LA106_22 = input.LA(2);

            	                if ( (LA106_22==EOF||(LA106_22>=SEMI && LA106_22<=EQ)||LA106_22==RPAREN||(LA106_22>=RCURLY && LA106_22<=LARROW)||LA106_22==PIPE||(LA106_22>=POINT && LA106_22<=NE)||LA106_22==62||LA106_22==69||(LA106_22>=75 && LA106_22<=76)||(LA106_22>=94 && LA106_22<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_22==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 22, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 64:
            	                {
            	                int LA106_23 = input.LA(2);

            	                if ( (LA106_23==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_23==EOF||(LA106_23>=SEMI && LA106_23<=EQ)||LA106_23==RPAREN||(LA106_23>=RCURLY && LA106_23<=LARROW)||LA106_23==PIPE||(LA106_23>=POINT && LA106_23<=NE)||LA106_23==62||LA106_23==69||(LA106_23>=75 && LA106_23<=76)||(LA106_23>=94 && LA106_23<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 23, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 65:
            	                {
            	                int LA106_24 = input.LA(2);

            	                if ( (LA106_24==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_24==EOF||(LA106_24>=SEMI && LA106_24<=EQ)||LA106_24==RPAREN||(LA106_24>=RCURLY && LA106_24<=LARROW)||LA106_24==PIPE||(LA106_24>=POINT && LA106_24<=NE)||LA106_24==62||LA106_24==69||(LA106_24>=75 && LA106_24<=76)||(LA106_24>=94 && LA106_24<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 24, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 66:
            	                {
            	                int LA106_25 = input.LA(2);

            	                if ( (LA106_25==EOF||(LA106_25>=SEMI && LA106_25<=EQ)||LA106_25==RPAREN||(LA106_25>=RCURLY && LA106_25<=LARROW)||LA106_25==PIPE||(LA106_25>=POINT && LA106_25<=NE)||LA106_25==62||LA106_25==69||(LA106_25>=75 && LA106_25<=76)||(LA106_25>=94 && LA106_25<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_25==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 25, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 67:
            	                {
            	                int LA106_26 = input.LA(2);

            	                if ( (LA106_26==EOF||(LA106_26>=SEMI && LA106_26<=EQ)||LA106_26==RPAREN||(LA106_26>=RCURLY && LA106_26<=LARROW)||LA106_26==PIPE||(LA106_26>=POINT && LA106_26<=NE)||LA106_26==62||LA106_26==69||(LA106_26>=75 && LA106_26<=76)||(LA106_26>=94 && LA106_26<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_26==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 26, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 68:
            	                {
            	                int LA106_27 = input.LA(2);

            	                if ( (LA106_27==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_27==EOF||(LA106_27>=SEMI && LA106_27<=EQ)||LA106_27==RPAREN||(LA106_27>=RCURLY && LA106_27<=LARROW)||LA106_27==PIPE||(LA106_27>=POINT && LA106_27<=NE)||LA106_27==62||LA106_27==69||(LA106_27>=75 && LA106_27<=76)||(LA106_27>=94 && LA106_27<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 27, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 69:
            	                {
            	                int LA106_28 = input.LA(2);

            	                if ( (LA106_28==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_28==EOF||(LA106_28>=SEMI && LA106_28<=EQ)||LA106_28==RPAREN||(LA106_28>=RCURLY && LA106_28<=LARROW)||LA106_28==PIPE||(LA106_28>=POINT && LA106_28<=NE)||LA106_28==62||LA106_28==69||(LA106_28>=75 && LA106_28<=76)||(LA106_28>=94 && LA106_28<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 28, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 70:
            	                {
            	                int LA106_29 = input.LA(2);

            	                if ( (LA106_29==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_29==EOF||(LA106_29>=SEMI && LA106_29<=EQ)||LA106_29==RPAREN||(LA106_29>=RCURLY && LA106_29<=LARROW)||LA106_29==PIPE||(LA106_29>=POINT && LA106_29<=NE)||LA106_29==62||LA106_29==69||(LA106_29>=75 && LA106_29<=76)||(LA106_29>=94 && LA106_29<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 29, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 71:
            	                {
            	                int LA106_30 = input.LA(2);

            	                if ( (LA106_30==EOF||(LA106_30>=SEMI && LA106_30<=EQ)||LA106_30==RPAREN||(LA106_30>=RCURLY && LA106_30<=LARROW)||LA106_30==PIPE||(LA106_30>=POINT && LA106_30<=NE)||LA106_30==62||LA106_30==69||(LA106_30>=75 && LA106_30<=76)||(LA106_30>=94 && LA106_30<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_30==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 30, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 72:
            	                {
            	                int LA106_31 = input.LA(2);

            	                if ( (LA106_31==EOF||(LA106_31>=SEMI && LA106_31<=EQ)||LA106_31==RPAREN||(LA106_31>=RCURLY && LA106_31<=LARROW)||LA106_31==PIPE||(LA106_31>=POINT && LA106_31<=NE)||LA106_31==62||LA106_31==69||(LA106_31>=75 && LA106_31<=76)||(LA106_31>=94 && LA106_31<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_31==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 31, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 73:
            	                {
            	                int LA106_32 = input.LA(2);

            	                if ( (LA106_32==EOF||(LA106_32>=SEMI && LA106_32<=EQ)||LA106_32==RPAREN||(LA106_32>=RCURLY && LA106_32<=LARROW)||LA106_32==PIPE||(LA106_32>=POINT && LA106_32<=NE)||LA106_32==62||LA106_32==69||(LA106_32>=75 && LA106_32<=76)||(LA106_32>=94 && LA106_32<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_32==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 32, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 74:
            	                {
            	                int LA106_33 = input.LA(2);

            	                if ( (LA106_33==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_33==EOF||(LA106_33>=SEMI && LA106_33<=EQ)||LA106_33==RPAREN||(LA106_33>=RCURLY && LA106_33<=LARROW)||LA106_33==PIPE||(LA106_33>=POINT && LA106_33<=NE)||LA106_33==62||LA106_33==69||(LA106_33>=75 && LA106_33<=76)||(LA106_33>=94 && LA106_33<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 33, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 75:
            	                {
            	                int LA106_34 = input.LA(2);

            	                if ( (LA106_34==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_34==EOF||(LA106_34>=SEMI && LA106_34<=EQ)||LA106_34==RPAREN||(LA106_34>=RCURLY && LA106_34<=LARROW)||LA106_34==PIPE||(LA106_34>=POINT && LA106_34<=NE)||LA106_34==62||LA106_34==69||(LA106_34>=75 && LA106_34<=76)||(LA106_34>=94 && LA106_34<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 34, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 76:
            	                {
            	                int LA106_35 = input.LA(2);

            	                if ( (LA106_35==EOF||(LA106_35>=SEMI && LA106_35<=EQ)||LA106_35==RPAREN||(LA106_35>=RCURLY && LA106_35<=LARROW)||LA106_35==PIPE||(LA106_35>=POINT && LA106_35<=NE)||LA106_35==62||LA106_35==69||(LA106_35>=75 && LA106_35<=76)||(LA106_35>=94 && LA106_35<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_35==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 35, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 77:
            	                {
            	                int LA106_36 = input.LA(2);

            	                if ( (LA106_36==EOF||(LA106_36>=SEMI && LA106_36<=EQ)||LA106_36==RPAREN||(LA106_36>=RCURLY && LA106_36<=LARROW)||LA106_36==PIPE||(LA106_36>=POINT && LA106_36<=NE)||LA106_36==62||LA106_36==69||(LA106_36>=75 && LA106_36<=76)||(LA106_36>=94 && LA106_36<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_36==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 36, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 78:
            	                {
            	                int LA106_37 = input.LA(2);

            	                if ( (LA106_37==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_37==EOF||(LA106_37>=SEMI && LA106_37<=EQ)||LA106_37==RPAREN||(LA106_37>=RCURLY && LA106_37<=LARROW)||LA106_37==PIPE||(LA106_37>=POINT && LA106_37<=NE)||LA106_37==62||LA106_37==69||(LA106_37>=75 && LA106_37<=76)||(LA106_37>=94 && LA106_37<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 37, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 79:
            	                {
            	                int LA106_38 = input.LA(2);

            	                if ( (LA106_38==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_38==EOF||(LA106_38>=SEMI && LA106_38<=EQ)||LA106_38==RPAREN||(LA106_38>=RCURLY && LA106_38<=LARROW)||LA106_38==PIPE||(LA106_38>=POINT && LA106_38<=NE)||LA106_38==62||LA106_38==69||(LA106_38>=75 && LA106_38<=76)||(LA106_38>=94 && LA106_38<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 38, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 80:
            	                {
            	                int LA106_39 = input.LA(2);

            	                if ( (LA106_39==EOF||(LA106_39>=SEMI && LA106_39<=EQ)||LA106_39==RPAREN||(LA106_39>=RCURLY && LA106_39<=LARROW)||LA106_39==PIPE||(LA106_39>=POINT && LA106_39<=NE)||LA106_39==62||LA106_39==69||(LA106_39>=75 && LA106_39<=76)||(LA106_39>=94 && LA106_39<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_39==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 39, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 81:
            	                {
            	                int LA106_40 = input.LA(2);

            	                if ( (LA106_40==EOF||(LA106_40>=SEMI && LA106_40<=EQ)||LA106_40==RPAREN||(LA106_40>=RCURLY && LA106_40<=LARROW)||LA106_40==PIPE||(LA106_40>=POINT && LA106_40<=NE)||LA106_40==62||LA106_40==69||(LA106_40>=75 && LA106_40<=76)||(LA106_40>=94 && LA106_40<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_40==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 40, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 82:
            	                {
            	                int LA106_41 = input.LA(2);

            	                if ( (LA106_41==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_41==EOF||(LA106_41>=SEMI && LA106_41<=EQ)||LA106_41==RPAREN||(LA106_41>=RCURLY && LA106_41<=LARROW)||LA106_41==PIPE||(LA106_41>=POINT && LA106_41<=NE)||LA106_41==62||LA106_41==69||(LA106_41>=75 && LA106_41<=76)||(LA106_41>=94 && LA106_41<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 41, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 83:
            	                {
            	                int LA106_42 = input.LA(2);

            	                if ( (LA106_42==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_42==EOF||(LA106_42>=SEMI && LA106_42<=EQ)||LA106_42==RPAREN||(LA106_42>=RCURLY && LA106_42<=LARROW)||LA106_42==PIPE||(LA106_42>=POINT && LA106_42<=NE)||LA106_42==62||LA106_42==69||(LA106_42>=75 && LA106_42<=76)||(LA106_42>=94 && LA106_42<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 42, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 84:
            	                {
            	                int LA106_43 = input.LA(2);

            	                if ( (LA106_43==EOF||(LA106_43>=SEMI && LA106_43<=EQ)||LA106_43==RPAREN||(LA106_43>=RCURLY && LA106_43<=LARROW)||LA106_43==PIPE||(LA106_43>=POINT && LA106_43<=NE)||LA106_43==62||LA106_43==69||(LA106_43>=75 && LA106_43<=76)||(LA106_43>=94 && LA106_43<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_43==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 43, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 85:
            	                {
            	                int LA106_44 = input.LA(2);

            	                if ( (LA106_44==EOF||(LA106_44>=SEMI && LA106_44<=EQ)||LA106_44==RPAREN||(LA106_44>=RCURLY && LA106_44<=LARROW)||LA106_44==PIPE||(LA106_44>=POINT && LA106_44<=NE)||LA106_44==62||LA106_44==69||(LA106_44>=75 && LA106_44<=76)||(LA106_44>=94 && LA106_44<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_44==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 44, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 86:
            	                {
            	                int LA106_45 = input.LA(2);

            	                if ( (LA106_45==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_45==EOF||(LA106_45>=SEMI && LA106_45<=EQ)||LA106_45==RPAREN||(LA106_45>=RCURLY && LA106_45<=LARROW)||LA106_45==PIPE||(LA106_45>=POINT && LA106_45<=NE)||LA106_45==62||LA106_45==69||(LA106_45>=75 && LA106_45<=76)||(LA106_45>=94 && LA106_45<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 45, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 87:
            	                {
            	                int LA106_46 = input.LA(2);

            	                if ( (LA106_46==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_46==EOF||(LA106_46>=SEMI && LA106_46<=EQ)||LA106_46==RPAREN||(LA106_46>=RCURLY && LA106_46<=LARROW)||LA106_46==PIPE||(LA106_46>=POINT && LA106_46<=NE)||LA106_46==62||LA106_46==69||(LA106_46>=75 && LA106_46<=76)||(LA106_46>=94 && LA106_46<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 46, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 88:
            	                {
            	                int LA106_47 = input.LA(2);

            	                if ( (LA106_47==EOF||(LA106_47>=SEMI && LA106_47<=EQ)||LA106_47==RPAREN||(LA106_47>=RCURLY && LA106_47<=LARROW)||LA106_47==PIPE||(LA106_47>=POINT && LA106_47<=NE)||LA106_47==62||LA106_47==69||(LA106_47>=75 && LA106_47<=76)||(LA106_47>=94 && LA106_47<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_47==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 47, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 89:
            	                {
            	                int LA106_48 = input.LA(2);

            	                if ( (LA106_48==EOF||(LA106_48>=SEMI && LA106_48<=EQ)||LA106_48==RPAREN||(LA106_48>=RCURLY && LA106_48<=LARROW)||LA106_48==PIPE||(LA106_48>=POINT && LA106_48<=NE)||LA106_48==62||LA106_48==69||(LA106_48>=75 && LA106_48<=76)||(LA106_48>=94 && LA106_48<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_48==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 48, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 90:
            	                {
            	                int LA106_49 = input.LA(2);

            	                if ( (LA106_49==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_49==EOF||(LA106_49>=SEMI && LA106_49<=EQ)||LA106_49==RPAREN||(LA106_49>=RCURLY && LA106_49<=LARROW)||LA106_49==PIPE||(LA106_49>=POINT && LA106_49<=NE)||LA106_49==62||LA106_49==69||(LA106_49>=75 && LA106_49<=76)||(LA106_49>=94 && LA106_49<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 49, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 91:
            	                {
            	                int LA106_50 = input.LA(2);

            	                if ( (LA106_50==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_50==EOF||(LA106_50>=SEMI && LA106_50<=EQ)||LA106_50==RPAREN||(LA106_50>=RCURLY && LA106_50<=LARROW)||LA106_50==PIPE||(LA106_50>=POINT && LA106_50<=NE)||LA106_50==62||LA106_50==69||(LA106_50>=75 && LA106_50<=76)||(LA106_50>=94 && LA106_50<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 50, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 92:
            	                {
            	                int LA106_51 = input.LA(2);

            	                if ( (LA106_51==EOF||(LA106_51>=SEMI && LA106_51<=EQ)||LA106_51==RPAREN||(LA106_51>=RCURLY && LA106_51<=LARROW)||LA106_51==PIPE||(LA106_51>=POINT && LA106_51<=NE)||LA106_51==62||LA106_51==69||(LA106_51>=75 && LA106_51<=76)||(LA106_51>=94 && LA106_51<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_51==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 51, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 93:
            	                {
            	                int LA106_52 = input.LA(2);

            	                if ( (LA106_52==EOF||(LA106_52>=SEMI && LA106_52<=EQ)||LA106_52==RPAREN||(LA106_52>=RCURLY && LA106_52<=LARROW)||LA106_52==PIPE||(LA106_52>=POINT && LA106_52<=NE)||LA106_52==62||LA106_52==69||(LA106_52>=75 && LA106_52<=76)||(LA106_52>=94 && LA106_52<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_52==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 52, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 94:
            	                {
            	                int LA106_53 = input.LA(2);

            	                if ( (LA106_53==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_53==EOF||(LA106_53>=SEMI && LA106_53<=EQ)||LA106_53==RPAREN||(LA106_53>=RCURLY && LA106_53<=LARROW)||LA106_53==PIPE||(LA106_53>=POINT && LA106_53<=NE)||LA106_53==62||LA106_53==69||(LA106_53>=75 && LA106_53<=76)||(LA106_53>=94 && LA106_53<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 53, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 95:
            	                {
            	                int LA106_54 = input.LA(2);

            	                if ( (LA106_54==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_54==EOF||(LA106_54>=SEMI && LA106_54<=EQ)||LA106_54==RPAREN||(LA106_54>=RCURLY && LA106_54<=LARROW)||LA106_54==PIPE||(LA106_54>=POINT && LA106_54<=NE)||LA106_54==62||LA106_54==69||(LA106_54>=75 && LA106_54<=76)||(LA106_54>=94 && LA106_54<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 54, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 96:
            	                {
            	                int LA106_55 = input.LA(2);

            	                if ( (LA106_55==EOF||(LA106_55>=SEMI && LA106_55<=EQ)||LA106_55==RPAREN||(LA106_55>=RCURLY && LA106_55<=LARROW)||LA106_55==PIPE||(LA106_55>=POINT && LA106_55<=NE)||LA106_55==62||LA106_55==69||(LA106_55>=75 && LA106_55<=76)||(LA106_55>=94 && LA106_55<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_55==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 55, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 97:
            	                {
            	                int LA106_56 = input.LA(2);

            	                if ( (LA106_56==EOF||(LA106_56>=SEMI && LA106_56<=EQ)||LA106_56==RPAREN||(LA106_56>=RCURLY && LA106_56<=LARROW)||LA106_56==PIPE||(LA106_56>=POINT && LA106_56<=NE)||LA106_56==62||LA106_56==69||(LA106_56>=75 && LA106_56<=76)||(LA106_56>=94 && LA106_56<=99)) ) {
            	                    alt106=2;
            	                }
            	                else if ( (LA106_56==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 56, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 98:
            	                {
            	                int LA106_57 = input.LA(2);

            	                if ( (LA106_57==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_57==EOF||(LA106_57>=SEMI && LA106_57<=EQ)||LA106_57==RPAREN||(LA106_57>=RCURLY && LA106_57<=LARROW)||LA106_57==PIPE||(LA106_57>=POINT && LA106_57<=NE)||LA106_57==62||LA106_57==69||(LA106_57>=75 && LA106_57<=76)||(LA106_57>=94 && LA106_57<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 57, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 99:
            	                {
            	                int LA106_58 = input.LA(2);

            	                if ( (LA106_58==LPAREN) ) {
            	                    alt106=1;
            	                }
            	                else if ( (LA106_58==EOF||(LA106_58>=SEMI && LA106_58<=EQ)||LA106_58==RPAREN||(LA106_58>=RCURLY && LA106_58<=LARROW)||LA106_58==PIPE||(LA106_58>=POINT && LA106_58<=NE)||LA106_58==62||LA106_58==69||(LA106_58>=75 && LA106_58<=76)||(LA106_58>=94 && LA106_58<=99)) ) {
            	                    alt106=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 58, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            default:
            	                if (backtracking>0) {failed=true; return ret2;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("970:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 106, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt106) {
            	                case 1 :
            	                    // ATL_ANTLR3.g:970:57: ret= operationCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_operationCallExp_in_priority_05327);
            	                    ret=operationCallExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;
            	                case 2 :
            	                    // ATL_ANTLR3.g:970:105: ret= navigationOrAttributeCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_navigationOrAttributeCallExp_in_priority_05334);
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
            	            // ATL_ANTLR3.g:970:167: ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) )
            	            {
            	            // ATL_ANTLR3.g:970:167: ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) )
            	            // ATL_ANTLR3.g:970:168: RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )
            	            {
            	            match(input,RARROW,FOLLOW_RARROW_in_priority_05342); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "->";
            	            }
            	            // ATL_ANTLR3.g:970:192: (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )
            	            int alt107=3;
            	            alt107 = dfa107.predict(input);
            	            switch (alt107) {
            	                case 1 :
            	                    // ATL_ANTLR3.g:970:193: ret= iteratorExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_iteratorExp_in_priority_05349);
            	                    ret=iteratorExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;
            	                case 2 :
            	                    // ATL_ANTLR3.g:970:236: ret= iterateExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_iterateExp_in_priority_05356);
            	                    ret=iterateExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;
            	                case 3 :
            	                    // ATL_ANTLR3.g:970:278: ret= collectionOperationCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_collectionOperationCallExp_in_priority_05363);
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
            	    break loop109;
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
    // ATL_ANTLR3.g:977:1: priority_1 returns [Object ret2] : ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) ;
    public final Object priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:978:2: ( ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) )
            // ATL_ANTLR3.g:978:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            {
            // ATL_ANTLR3.g:978:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            int alt110=3;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt110=1;
                }
                break;
            case MINUS:
                {
                alt110=2;
                }
                break;
            case NAME:
            case STRING:
            case INT:
            case FLOAT:
            case LPAREN:
            case SHARP:
            case 68:
            case 72:
            case 73:
            case 74:
            case 77:
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
            case 92:
                {
                alt110=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("978:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )", 110, 0, input);

                throw nvae;
            }

            switch (alt110) {
                case 1 :
                    // ATL_ANTLR3.g:978:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // ATL_ANTLR3.g:978:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // ATL_ANTLR3.g:978:6: 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,93,FOLLOW_93_in_priority_15403); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      opName = "not";
                    }
                    // ATL_ANTLR3.g:978:30: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // ATL_ANTLR3.g:978:31: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_15410);
                    ret=operatorCallExp(opName,  right,  firstToken);
                    _fsp--;
                    if (failed) return ret2;
                    pushFollow(FOLLOW_priority_0_in_priority_15415);
                    right=priority_0();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
                      	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:979:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // ATL_ANTLR3.g:979:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // ATL_ANTLR3.g:979:72: MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_priority_15423); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      opName = "-";
                    }
                    // ATL_ANTLR3.g:979:94: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // ATL_ANTLR3.g:979:95: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_15430);
                    ret=operatorCallExp(opName,  right,  firstToken);
                    _fsp--;
                    if (failed) return ret2;
                    pushFollow(FOLLOW_priority_0_in_priority_15435);
                    right=priority_0();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
                      	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:980:71: (ret= priority_0 )
                    {
                    // ATL_ANTLR3.g:980:71: (ret= priority_0 )
                    // ATL_ANTLR3.g:980:72: ret= priority_0
                    {
                    pushFollow(FOLLOW_priority_0_in_priority_15445);
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
    // ATL_ANTLR3.g:987:1: priority_2 returns [Object ret2] : (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ;
    public final Object priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:988:2: ( (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            // ATL_ANTLR3.g:988:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            {
            // ATL_ANTLR3.g:988:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            // ATL_ANTLR3.g:988:5: ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_1_in_priority_25480);
            ret=priority_1();
            _fsp--;
            if (failed) return ret2;
            // ATL_ANTLR3.g:988:20: ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( ((LA112_0>=STAR && LA112_0<=SLASH)||(LA112_0>=94 && LA112_0<=95)) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // ATL_ANTLR3.g:988:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    {
            	    // ATL_ANTLR3.g:988:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    int alt111=4;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt111=1;
            	        }
            	        break;
            	    case SLASH:
            	        {
            	        alt111=2;
            	        }
            	        break;
            	    case 94:
            	        {
            	        alt111=3;
            	        }
            	        break;
            	    case 95:
            	        {
            	        alt111=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("988:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )", 111, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt111) {
            	        case 1 :
            	            // ATL_ANTLR3.g:988:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ATL_ANTLR3.g:988:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ATL_ANTLR3.g:988:23: STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,STAR,FOLLOW_STAR_in_priority_25485); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "*";
            	            }
            	            // ATL_ANTLR3.g:988:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ATL_ANTLR3.g:988:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25492);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25497);
            	            right=priority_1();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ATL_ANTLR3.g:989:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ATL_ANTLR3.g:989:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ATL_ANTLR3.g:989:72: SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,SLASH,FOLLOW_SLASH_in_priority_25505); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "/";
            	            }
            	            // ATL_ANTLR3.g:989:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ATL_ANTLR3.g:989:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25512);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25517);
            	            right=priority_1();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ATL_ANTLR3.g:990:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ATL_ANTLR3.g:990:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ATL_ANTLR3.g:990:72: 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,94,FOLLOW_94_in_priority_25525); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "div";
            	            }
            	            // ATL_ANTLR3.g:990:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ATL_ANTLR3.g:990:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25532);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25537);
            	            right=priority_1();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ATL_ANTLR3.g:991:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ATL_ANTLR3.g:991:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ATL_ANTLR3.g:991:72: 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,95,FOLLOW_95_in_priority_25545); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "mod";
            	            }
            	            // ATL_ANTLR3.g:991:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ATL_ANTLR3.g:991:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25552);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25557);
            	            right=priority_1();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end priority_2


    // $ANTLR start priority_3
    // ATL_ANTLR3.g:999:1: priority_3 returns [Object ret2] : (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) ;
    public final Object priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1000:2: ( (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) )
            // ATL_ANTLR3.g:1000:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            {
            // ATL_ANTLR3.g:1000:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            // ATL_ANTLR3.g:1000:5: ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_2_in_priority_35598);
            ret=priority_2();
            _fsp--;
            if (failed) return ret2;
            // ATL_ANTLR3.g:1000:20: ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==MINUS||LA114_0==PLUS) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // ATL_ANTLR3.g:1000:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    {
            	    // ATL_ANTLR3.g:1000:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    int alt113=2;
            	    int LA113_0 = input.LA(1);

            	    if ( (LA113_0==PLUS) ) {
            	        alt113=1;
            	    }
            	    else if ( (LA113_0==MINUS) ) {
            	        alt113=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1000:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )", 113, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt113) {
            	        case 1 :
            	            // ATL_ANTLR3.g:1000:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // ATL_ANTLR3.g:1000:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // ATL_ANTLR3.g:1000:23: PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_priority_35603); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "+";
            	            }
            	            // ATL_ANTLR3.g:1000:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // ATL_ANTLR3.g:1000:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_35610);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_2_in_priority_35615);
            	            right=priority_2();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ATL_ANTLR3.g:1001:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // ATL_ANTLR3.g:1001:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // ATL_ANTLR3.g:1001:72: MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_priority_35623); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "-";
            	            }
            	            // ATL_ANTLR3.g:1001:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // ATL_ANTLR3.g:1001:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_35630);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_2_in_priority_35635);
            	            right=priority_2();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end priority_3


    // $ANTLR start priority_4
    // ATL_ANTLR3.g:1009:1: priority_4 returns [Object ret2] : (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* ) ;
    public final Object priority_4() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1010:2: ( (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* ) )
            // ATL_ANTLR3.g:1010:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            {
            // ATL_ANTLR3.g:1010:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            // ATL_ANTLR3.g:1010:5: ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_3_in_priority_45676);
            ret=priority_3();
            _fsp--;
            if (failed) return ret2;
            // ATL_ANTLR3.g:1010:20: ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==EQ||(LA116_0>=GT && LA116_0<=NE)) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // ATL_ANTLR3.g:1010:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ATL_ANTLR3.g:1010:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )
            	    int alt115=6;
            	    switch ( input.LA(1) ) {
            	    case EQ:
            	        {
            	        alt115=1;
            	        }
            	        break;
            	    case GT:
            	        {
            	        alt115=2;
            	        }
            	        break;
            	    case LT:
            	        {
            	        alt115=3;
            	        }
            	        break;
            	    case GE:
            	        {
            	        alt115=4;
            	        }
            	        break;
            	    case LE:
            	        {
            	        alt115=5;
            	        }
            	        break;
            	    case NE:
            	        {
            	        alt115=6;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1010:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )", 115, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt115) {
            	        case 1 :
            	            // ATL_ANTLR3.g:1010:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1010:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1010:23: EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,EQ,FOLLOW_EQ_in_priority_45681); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "=";
            	            }
            	            // ATL_ANTLR3.g:1010:42: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1010:43: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45688);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45693);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ATL_ANTLR3.g:1011:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1011:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1011:72: GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GT,FOLLOW_GT_in_priority_45701); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = ">";
            	            }
            	            // ATL_ANTLR3.g:1011:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1011:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45708);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45713);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ATL_ANTLR3.g:1012:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1012:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1012:72: LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LT,FOLLOW_LT_in_priority_45721); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "<";
            	            }
            	            // ATL_ANTLR3.g:1012:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1012:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45728);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45733);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ATL_ANTLR3.g:1013:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1013:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1013:72: GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GE,FOLLOW_GE_in_priority_45741); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = ">=";
            	            }
            	            // ATL_ANTLR3.g:1013:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1013:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45748);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45753);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 5 :
            	            // ATL_ANTLR3.g:1014:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1014:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1014:72: LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LE,FOLLOW_LE_in_priority_45761); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "<=";
            	            }
            	            // ATL_ANTLR3.g:1014:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1014:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45768);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45773);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 6 :
            	            // ATL_ANTLR3.g:1015:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1015:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1015:72: NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,NE,FOLLOW_NE_in_priority_45781); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "<>";
            	            }
            	            // ATL_ANTLR3.g:1015:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1015:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45788);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45793);
            	            right=priority_3();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end priority_4


    // $ANTLR start priority_5
    // ATL_ANTLR3.g:1023:1: priority_5 returns [Object ret2] : (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ;
    public final Object priority_5() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1024:2: ( (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            // ATL_ANTLR3.g:1024:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            {
            // ATL_ANTLR3.g:1024:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            // ATL_ANTLR3.g:1024:5: ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_4_in_priority_55834);
            ret=priority_4();
            _fsp--;
            if (failed) return ret2;
            // ATL_ANTLR3.g:1024:20: ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( ((LA118_0>=96 && LA118_0<=99)) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // ATL_ANTLR3.g:1024:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // ATL_ANTLR3.g:1024:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    int alt117=4;
            	    switch ( input.LA(1) ) {
            	    case 96:
            	        {
            	        alt117=1;
            	        }
            	        break;
            	    case 97:
            	        {
            	        alt117=2;
            	        }
            	        break;
            	    case 98:
            	        {
            	        alt117=3;
            	        }
            	        break;
            	    case 99:
            	        {
            	        alt117=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1024:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )", 117, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt117) {
            	        case 1 :
            	            // ATL_ANTLR3.g:1024:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ATL_ANTLR3.g:1024:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ATL_ANTLR3.g:1024:23: 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,96,FOLLOW_96_in_priority_55839); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "and";
            	            }
            	            // ATL_ANTLR3.g:1024:47: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ATL_ANTLR3.g:1024:48: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55846);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55851);
            	            right=priority_4();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ATL_ANTLR3.g:1025:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ATL_ANTLR3.g:1025:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ATL_ANTLR3.g:1025:72: 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,97,FOLLOW_97_in_priority_55859); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "or";
            	            }
            	            // ATL_ANTLR3.g:1025:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ATL_ANTLR3.g:1025:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55866);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55871);
            	            right=priority_4();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ATL_ANTLR3.g:1026:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ATL_ANTLR3.g:1026:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ATL_ANTLR3.g:1026:72: 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,98,FOLLOW_98_in_priority_55879); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "xor";
            	            }
            	            // ATL_ANTLR3.g:1026:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ATL_ANTLR3.g:1026:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55886);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55891);
            	            right=priority_4();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	              	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ATL_ANTLR3.g:1027:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ATL_ANTLR3.g:1027:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ATL_ANTLR3.g:1027:72: 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,99,FOLLOW_99_in_priority_55899); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "implies";
            	            }
            	            // ATL_ANTLR3.g:1027:104: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ATL_ANTLR3.g:1027:105: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55906);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55911);
            	            right=priority_4();
            	            _fsp--;
            	            if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
            	    break loop118;
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
    // ATL_ANTLR3.g:1035:1: matchedRule_abstractContents returns [Object ret2] : ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) ;
    public final Object matchedRule_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MatchedRule", true, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1036:2: ( ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) )
            // ATL_ANTLR3.g:1036:4: ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            {
            // ATL_ANTLR3.g:1036:4: ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            // ATL_ANTLR3.g:1036:5: ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY
            {
            // ATL_ANTLR3.g:1036:5: ( ( 'nodefault' ) | () )
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==53) ) {
                alt119=1;
            }
            else if ( (LA119_0==45||(LA119_0>=54 && LA119_0<=55)) ) {
                alt119=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:5: ( ( 'nodefault' ) | () )", 119, 0, input);

                throw nvae;
            }
            switch (alt119) {
                case 1 :
                    // ATL_ANTLR3.g:1036:6: ( 'nodefault' )
                    {
                    // ATL_ANTLR3.g:1036:6: ( 'nodefault' )
                    // ATL_ANTLR3.g:1036:7: 'nodefault'
                    {
                    match(input,53,FOLLOW_53_in_matchedRule_abstractContents5952); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isNoDefault", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1036:75: ()
                    {
                    // ATL_ANTLR3.g:1036:75: ()
                    // ATL_ANTLR3.g:1036:76: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isNoDefault", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:1036:134: ( ( 'abstract' ) | () )
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==54) ) {
                alt120=1;
            }
            else if ( (LA120_0==45||LA120_0==55) ) {
                alt120=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:134: ( ( 'abstract' ) | () )", 120, 0, input);

                throw nvae;
            }
            switch (alt120) {
                case 1 :
                    // ATL_ANTLR3.g:1036:135: ( 'abstract' )
                    {
                    // ATL_ANTLR3.g:1036:135: ( 'abstract' )
                    // ATL_ANTLR3.g:1036:136: 'abstract'
                    {
                    match(input,54,FOLLOW_54_in_matchedRule_abstractContents5966); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAbstract", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1036:202: ()
                    {
                    // ATL_ANTLR3.g:1036:202: ()
                    // ATL_ANTLR3.g:1036:203: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAbstract", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:1036:260: ( ( 'refining' ) | () )
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==45) ) {
                alt121=1;
            }
            else if ( (LA121_0==55) ) {
                alt121=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:260: ( ( 'refining' ) | () )", 121, 0, input);

                throw nvae;
            }
            switch (alt121) {
                case 1 :
                    // ATL_ANTLR3.g:1036:261: ( 'refining' )
                    {
                    // ATL_ANTLR3.g:1036:261: ( 'refining' )
                    // ATL_ANTLR3.g:1036:262: 'refining'
                    {
                    match(input,45,FOLLOW_45_in_matchedRule_abstractContents5980); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1036:328: ()
                    {
                    // ATL_ANTLR3.g:1036:328: ()
                    // ATL_ANTLR3.g:1036:329: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            match(input,55,FOLLOW_55_in_matchedRule_abstractContents5992); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_matchedRule_abstractContents5996);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            // ATL_ANTLR3.g:1036:438: ( ( 'extends' temp= identifier ) | () )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==56) ) {
                alt122=1;
            }
            else if ( (LA122_0==LCURLY) ) {
                alt122=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:438: ( ( 'extends' temp= identifier ) | () )", 122, 0, input);

                throw nvae;
            }
            switch (alt122) {
                case 1 :
                    // ATL_ANTLR3.g:1036:439: ( 'extends' temp= identifier )
                    {
                    // ATL_ANTLR3.g:1036:439: ( 'extends' temp= identifier )
                    // ATL_ANTLR3.g:1036:440: 'extends' temp= identifier
                    {
                    match(input,56,FOLLOW_56_in_matchedRule_abstractContents6002); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_matchedRule_abstractContents6006);
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
                    // ATL_ANTLR3.g:1036:564: ()
                    {
                    // ATL_ANTLR3.g:1036:564: ()
                    // ATL_ANTLR3.g:1036:565: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_matchedRule_abstractContents6020); if (failed) return ret2;
            // ATL_ANTLR3.g:1036:578: ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) )
            // ATL_ANTLR3.g:1036:579: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            {
            // ATL_ANTLR3.g:1036:579: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            // ATL_ANTLR3.g:1036:580: temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () )
            {
            pushFollow(FOLLOW_inPattern_in_matchedRule_abstractContents6026);
            temp=inPattern();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "inPattern", temp);
            }
            // ATL_ANTLR3.g:1036:629: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==57) ) {
                alt125=1;
            }
            else if ( (LA125_0==RCURLY||LA125_0==63||LA125_0==67) ) {
                alt125=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:629: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )", 125, 0, input);

                throw nvae;
            }
            switch (alt125) {
                case 1 :
                    // ATL_ANTLR3.g:1036:630: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // ATL_ANTLR3.g:1036:630: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // ATL_ANTLR3.g:1036:631: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,57,FOLLOW_57_in_matchedRule_abstractContents6032); if (failed) return ret2;
                    match(input,LCURLY,FOLLOW_LCURLY_in_matchedRule_abstractContents6034); if (failed) return ret2;
                    // ATL_ANTLR3.g:1036:646: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // ATL_ANTLR3.g:1036:647: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:1036:647: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // ATL_ANTLR3.g:1036:648: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // ATL_ANTLR3.g:1036:648: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( (LA124_0==NAME) ) {
                        alt124=1;
                    }
                    switch (alt124) {
                        case 1 :
                            // ATL_ANTLR3.g:1036:649: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // ATL_ANTLR3.g:1036:649: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // ATL_ANTLR3.g:1036:650: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6042);
                            temp=ruleVariableDeclaration();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "variables", temp);
                            }
                            // ATL_ANTLR3.g:1036:713: ( (temp= ruleVariableDeclaration ) )*
                            loop123:
                            do {
                                int alt123=2;
                                int LA123_0 = input.LA(1);

                                if ( (LA123_0==NAME) ) {
                                    alt123=1;
                                }


                                switch (alt123) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:1036:714: (temp= ruleVariableDeclaration )
                            	    {
                            	    // ATL_ANTLR3.g:1036:714: (temp= ruleVariableDeclaration )
                            	    // ATL_ANTLR3.g:1036:715: temp= ruleVariableDeclaration
                            	    {
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6050);
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
                            	    break loop123;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_matchedRule_abstractContents6062); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1036:798: ()
                    {
                    // ATL_ANTLR3.g:1036:798: ()
                    // ATL_ANTLR3.g:1036:799: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:1036:805: ( (temp= outPattern ) | () )
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==63) ) {
                alt126=1;
            }
            else if ( (LA126_0==RCURLY||LA126_0==67) ) {
                alt126=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:805: ( (temp= outPattern ) | () )", 126, 0, input);

                throw nvae;
            }
            switch (alt126) {
                case 1 :
                    // ATL_ANTLR3.g:1036:806: (temp= outPattern )
                    {
                    // ATL_ANTLR3.g:1036:806: (temp= outPattern )
                    // ATL_ANTLR3.g:1036:807: temp= outPattern
                    {
                    pushFollow(FOLLOW_outPattern_in_matchedRule_abstractContents6078);
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
                    // ATL_ANTLR3.g:1036:863: ()
                    {
                    // ATL_ANTLR3.g:1036:863: ()
                    // ATL_ANTLR3.g:1036:864: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:1036:870: ( (temp= actionBlock ) | () )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==67) ) {
                alt127=1;
            }
            else if ( (LA127_0==RCURLY) ) {
                alt127=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1036:870: ( (temp= actionBlock ) | () )", 127, 0, input);

                throw nvae;
            }
            switch (alt127) {
                case 1 :
                    // ATL_ANTLR3.g:1036:871: (temp= actionBlock )
                    {
                    // ATL_ANTLR3.g:1036:871: (temp= actionBlock )
                    // ATL_ANTLR3.g:1036:872: temp= actionBlock
                    {
                    pushFollow(FOLLOW_actionBlock_in_matchedRule_abstractContents6096);
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
                    // ATL_ANTLR3.g:1036:930: ()
                    {
                    // ATL_ANTLR3.g:1036:930: ()
                    // ATL_ANTLR3.g:1036:931: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_matchedRule_abstractContents6112); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(true);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:1046:1: oclType_abstractContents returns [Object ret2] : ( 'OclType' ) ;
    public final Object oclType_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1047:2: ( ( 'OclType' ) )
            // ATL_ANTLR3.g:1047:4: ( 'OclType' )
            {
            // ATL_ANTLR3.g:1047:4: ( 'OclType' )
            // ATL_ANTLR3.g:1047:5: 'OclType'
            {
            match(input,85,FOLLOW_85_in_oclType_abstractContents6144); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:1057:1: collectionType_abstractContents returns [Object ret2] : ( 'Collection' LPAREN temp= oclType RPAREN ) ;
    public final Object collectionType_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CollectionType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1058:2: ( ( 'Collection' LPAREN temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:1058:4: ( 'Collection' LPAREN temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:1058:4: ( 'Collection' LPAREN temp= oclType RPAREN )
            // ATL_ANTLR3.g:1058:5: 'Collection' LPAREN temp= oclType RPAREN
            {
            match(input,92,FOLLOW_92_in_collectionType_abstractContents6176); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_collectionType_abstractContents6178); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_collectionType_abstractContents6182);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_collectionType_abstractContents6186); if (failed) return ret2;

            }

            if ( backtracking==0 ) {

                          ei.leaveContext(false);
                          if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // ATL_ANTLR3.g:1068:1: primary_oclExpression returns [Object ret2] : ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType ) ;
    public final Object primary_oclExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:1069:2: ( ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType ) )
            // ATL_ANTLR3.g:1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )
            {
            // ATL_ANTLR3.g:1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )
            int alt128=11;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt128=1;
                }
                break;
            case NAME:
                {
                int LA128_2 = input.LA(2);

                if ( (LA128_2==EXCL) ) {
                    alt128=11;
                }
                else if ( (LA128_2==EOF||(LA128_2>=SEMI && LA128_2<=EQ)||LA128_2==RPAREN||(LA128_2>=RCURLY && LA128_2<=LARROW)||LA128_2==PIPE||(LA128_2>=POINT && LA128_2<=NE)||LA128_2==62||LA128_2==69||(LA128_2>=75 && LA128_2<=76)||(LA128_2>=94 && LA128_2<=99)) ) {
                    alt128=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 128, 2, input);

                    throw nvae;
                }
                }
                break;
            case 72:
                {
                alt128=3;
                }
                break;
            case STRING:
            case INT:
            case FLOAT:
            case 73:
            case 74:
                {
                alt128=4;
                }
                break;
            case 68:
                {
                alt128=5;
                }
                break;
            case 77:
                {
                alt128=6;
                }
                break;
            case SHARP:
                {
                alt128=7;
                }
                break;
            case 79:
                {
                int LA128_8 = input.LA(2);

                if ( (LA128_8==LCURLY) ) {
                    alt128=8;
                }
                else if ( (LA128_8==LPAREN) ) {
                    alt128=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 128, 8, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                int LA128_9 = input.LA(2);

                if ( (LA128_9==LCURLY) ) {
                    alt128=8;
                }
                else if ( (LA128_9==LPAREN) ) {
                    alt128=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 128, 9, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA128_10 = input.LA(2);

                if ( (LA128_10==LCURLY) ) {
                    alt128=8;
                }
                else if ( (LA128_10==LPAREN) ) {
                    alt128=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 128, 10, input);

                    throw nvae;
                }
                }
                break;
            case 82:
                {
                int LA128_11 = input.LA(2);

                if ( (LA128_11==LCURLY) ) {
                    alt128=8;
                }
                else if ( (LA128_11==LPAREN) ) {
                    alt128=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 128, 11, input);

                    throw nvae;
                }
                }
                break;
            case 83:
                {
                int LA128_12 = input.LA(2);

                if ( (LA128_12==LPAREN) ) {
                    alt128=11;
                }
                else if ( (LA128_12==LCURLY) ) {
                    alt128=9;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 128, 12, input);

                    throw nvae;
                }
                }
                break;
            case 84:
                {
                alt128=10;
                }
                break;
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
                {
                alt128=11;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1069:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 128, 0, input);

                throw nvae;
            }

            switch (alt128) {
                case 1 :
                    // ATL_ANTLR3.g:1069:5: ( LPAREN ret= oclExpression RPAREN )
                    {
                    // ATL_ANTLR3.g:1069:5: ( LPAREN ret= oclExpression RPAREN )
                    // ATL_ANTLR3.g:1069:6: LPAREN ret= oclExpression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_oclExpression6219); if (failed) return ret2;
                    pushFollow(FOLLOW_oclExpression_in_primary_oclExpression6223);
                    ret=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_oclExpression6225); if (failed) return ret2;

                    }


                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1069:40: ret= variableExp
                    {
                    pushFollow(FOLLOW_variableExp_in_primary_oclExpression6231);
                    ret=variableExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:1069:57: ret= oclUndefinedExp
                    {
                    pushFollow(FOLLOW_oclUndefinedExp_in_primary_oclExpression6236);
                    ret=oclUndefinedExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:1069:78: ret= primitiveExp
                    {
                    pushFollow(FOLLOW_primitiveExp_in_primary_oclExpression6241);
                    ret=primitiveExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 5 :
                    // ATL_ANTLR3.g:1069:96: ret= ifExp
                    {
                    pushFollow(FOLLOW_ifExp_in_primary_oclExpression6246);
                    ret=ifExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 6 :
                    // ATL_ANTLR3.g:1069:107: ret= superExp
                    {
                    pushFollow(FOLLOW_superExp_in_primary_oclExpression6251);
                    ret=superExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 7 :
                    // ATL_ANTLR3.g:1069:121: ret= enumLiteralExp
                    {
                    pushFollow(FOLLOW_enumLiteralExp_in_primary_oclExpression6256);
                    ret=enumLiteralExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 8 :
                    // ATL_ANTLR3.g:1069:141: ret= collectionExp
                    {
                    pushFollow(FOLLOW_collectionExp_in_primary_oclExpression6261);
                    ret=collectionExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 9 :
                    // ATL_ANTLR3.g:1069:160: ret= mapExp
                    {
                    pushFollow(FOLLOW_mapExp_in_primary_oclExpression6266);
                    ret=mapExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 10 :
                    // ATL_ANTLR3.g:1069:172: ret= tupleExp
                    {
                    pushFollow(FOLLOW_tupleExp_in_primary_oclExpression6271);
                    ret=tupleExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 11 :
                    // ATL_ANTLR3.g:1069:186: ret= oclType
                    {
                    pushFollow(FOLLOW_oclType_in_primary_oclExpression6276);
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

    // $ANTLR start synpred122
    public final void synpred122_fragment() throws RecognitionException {   
        // ATL_ANTLR3.g:395:6: ( ifStat )
        // ATL_ANTLR3.g:395:6: ifStat
        {
        pushFollow(FOLLOW_ifStat_in_synpred1222635);
        ifStat();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred122

    // $ANTLR start synpred123
    public final void synpred123_fragment() throws RecognitionException {   
        // ATL_ANTLR3.g:395:18: ( expressionStat )
        // ATL_ANTLR3.g:395:18: expressionStat
        {
        pushFollow(FOLLOW_expressionStat_in_synpred1232640);
        expressionStat();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred123

    // $ANTLR start synpred124
    public final void synpred124_fragment() throws RecognitionException {   
        // ATL_ANTLR3.g:395:38: ( bindingStat )
        // ATL_ANTLR3.g:395:38: bindingStat
        {
        pushFollow(FOLLOW_bindingStat_in_synpred1242645);
        bindingStat();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred124

    // $ANTLR start synpred132
    public final void synpred132_fragment() throws RecognitionException {   
        // ATL_ANTLR3.g:426:285: ( ( 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) ) ) )
        // ATL_ANTLR3.g:426:285: ( 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) ) )
        {
        // ATL_ANTLR3.g:426:285: ( 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) ) )
        // ATL_ANTLR3.g:426:286: 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) )
        {
        match(input,69,FOLLOW_69_in_synpred1322845); if (failed) return ;
        // ATL_ANTLR3.g:426:293: ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) )
        int alt160=2;
        int LA160_0 = input.LA(1);

        if ( ((LA160_0>=NAME && LA160_0<=FLOAT)||LA160_0==LPAREN||LA160_0==SHARP||LA160_0==MINUS||LA160_0==68||LA160_0==70||(LA160_0>=72 && LA160_0<=74)||(LA160_0>=77 && LA160_0<=93)) ) {
            alt160=1;
        }
        else if ( (LA160_0==LCURLY) ) {
            alt160=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("426:293: ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) )", 160, 0, input);

            throw nvae;
        }
        switch (alt160) {
            case 1 :
                // ATL_ANTLR3.g:426:294: ( ( ( statement ) ) )
                {
                // ATL_ANTLR3.g:426:294: ( ( ( statement ) ) )
                // ATL_ANTLR3.g:426:295: ( ( statement ) )
                {
                // ATL_ANTLR3.g:426:295: ( ( statement ) )
                // ATL_ANTLR3.g:426:296: ( statement )
                {
                // ATL_ANTLR3.g:426:296: ( statement )
                // ATL_ANTLR3.g:426:297: statement
                {
                pushFollow(FOLLOW_statement_in_synpred1322853);
                statement();
                _fsp--;
                if (failed) return ;

                }


                }


                }


                }
                break;
            case 2 :
                // ATL_ANTLR3.g:426:358: ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY )
                {
                // ATL_ANTLR3.g:426:358: ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY )
                // ATL_ANTLR3.g:426:359: LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY
                {
                match(input,LCURLY,FOLLOW_LCURLY_in_synpred1322864); if (failed) return ;
                // ATL_ANTLR3.g:426:366: ( ( ( ( statement ( ( statement ) )* ) )? ) )
                // ATL_ANTLR3.g:426:367: ( ( ( statement ( ( statement ) )* ) )? )
                {
                // ATL_ANTLR3.g:426:367: ( ( ( statement ( ( statement ) )* ) )? )
                // ATL_ANTLR3.g:426:368: ( ( statement ( ( statement ) )* ) )?
                {
                // ATL_ANTLR3.g:426:368: ( ( statement ( ( statement ) )* ) )?
                int alt159=2;
                int LA159_0 = input.LA(1);

                if ( ((LA159_0>=NAME && LA159_0<=FLOAT)||LA159_0==LPAREN||LA159_0==SHARP||LA159_0==MINUS||LA159_0==68||LA159_0==70||(LA159_0>=72 && LA159_0<=74)||(LA159_0>=77 && LA159_0<=93)) ) {
                    alt159=1;
                }
                switch (alt159) {
                    case 1 :
                        // ATL_ANTLR3.g:426:369: ( statement ( ( statement ) )* )
                        {
                        // ATL_ANTLR3.g:426:369: ( statement ( ( statement ) )* )
                        // ATL_ANTLR3.g:426:370: statement ( ( statement ) )*
                        {
                        pushFollow(FOLLOW_statement_in_synpred1322872);
                        statement();
                        _fsp--;
                        if (failed) return ;
                        // ATL_ANTLR3.g:426:424: ( ( statement ) )*
                        loop158:
                        do {
                            int alt158=2;
                            int LA158_0 = input.LA(1);

                            if ( ((LA158_0>=NAME && LA158_0<=FLOAT)||LA158_0==LPAREN||LA158_0==SHARP||LA158_0==MINUS||LA158_0==68||LA158_0==70||(LA158_0>=72 && LA158_0<=74)||(LA158_0>=77 && LA158_0<=93)) ) {
                                alt158=1;
                            }


                            switch (alt158) {
                        	case 1 :
                        	    // ATL_ANTLR3.g:426:425: ( statement )
                        	    {
                        	    // ATL_ANTLR3.g:426:425: ( statement )
                        	    // ATL_ANTLR3.g:426:426: statement
                        	    {
                        	    pushFollow(FOLLOW_statement_in_synpred1322880);
                        	    statement();
                        	    _fsp--;
                        	    if (failed) return ;

                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop158;
                            }
                        } while (true);


                        }


                        }
                        break;

                }


                }


                }

                match(input,RCURLY,FOLLOW_RCURLY_in_synpred1322892); if (failed) return ;

                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred132

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
    public final boolean synpred124() {
        backtracking++;
        int start = input.mark();
        try {
            synpred124_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred132() {
        backtracking++;
        int start = input.mark();
        try {
            synpred132_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


    protected DFA107 dfa107 = new DFA107(this);
    static final String DFA107_eotS =
        "\11\uffff";
    static final String DFA107_eofS =
        "\11\uffff";
    static final String DFA107_minS =
        "\1\4\1\14\1\uffff\1\4\1\11\1\uffff\1\4\1\uffff\1\11";
    static final String DFA107_maxS =
        "\1\107\1\14\1\uffff\1\135\1\143\1\uffff\1\135\1\uffff\1\143";
    static final String DFA107_acceptS =
        "\2\uffff\1\2\2\uffff\1\3\1\uffff\1\1\1\uffff";
    static final String DFA107_specialS =
        "\11\uffff}>";
    static final String[] DFA107_transitionS = {
            "\1\1\102\uffff\1\2",
            "\1\3",
            "",
            "\1\4\3\5\4\uffff\2\5\7\uffff\1\5\1\uffff\1\5\54\uffff\1\5\3"+
            "\uffff\3\5\2\uffff\21\5",
            "\1\6\1\5\2\uffff\1\5\2\uffff\1\5\2\uffff\1\5\1\7\1\uffff\12"+
            "\5\76\uffff\6\5",
            "",
            "\1\10\3\5\4\uffff\1\5\10\uffff\1\5\1\uffff\1\5\54\uffff\1\5"+
            "\3\uffff\3\5\2\uffff\21\5",
            "",
            "\1\6\1\5\2\uffff\1\5\2\uffff\1\5\2\uffff\1\5\1\7\1\uffff\12"+
            "\5\76\uffff\6\5"
    };

    static final short[] DFA107_eot = DFA.unpackEncodedString(DFA107_eotS);
    static final short[] DFA107_eof = DFA.unpackEncodedString(DFA107_eofS);
    static final char[] DFA107_min = DFA.unpackEncodedStringToUnsignedChars(DFA107_minS);
    static final char[] DFA107_max = DFA.unpackEncodedStringToUnsignedChars(DFA107_maxS);
    static final short[] DFA107_accept = DFA.unpackEncodedString(DFA107_acceptS);
    static final short[] DFA107_special = DFA.unpackEncodedString(DFA107_specialS);
    static final short[][] DFA107_transition;

    static {
        int numStates = DFA107_transitionS.length;
        DFA107_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA107_transition[i] = DFA.unpackEncodedString(DFA107_transitionS[i]);
        }
    }

    class DFA107 extends DFA {

        public DFA107(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 107;
            this.eot = DFA107_eot;
            this.eof = DFA107_eof;
            this.min = DFA107_min;
            this.max = DFA107_max;
            this.accept = DFA107_accept;
            this.special = DFA107_special;
            this.transition = DFA107_transition;
        }
        public String getDescription() {
            return "970:192: (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )";
        }
    }
 

    public static final BitSet FOLLOW_unit_in_main61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifier97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_identifierOrKeyword137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_identifierOrKeyword142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_identifierOrKeyword147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_identifierOrKeyword152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_identifierOrKeyword157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_identifierOrKeyword162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_identifierOrKeyword177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_identifierOrKeyword182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_identifierOrKeyword187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_identifierOrKeyword192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_identifierOrKeyword197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_identifierOrKeyword202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_identifierOrKeyword207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_identifierOrKeyword212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_identifierOrKeyword217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_identifierOrKeyword222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_identifierOrKeyword227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_identifierOrKeyword232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_identifierOrKeyword237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_identifierOrKeyword242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_identifierOrKeyword247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_identifierOrKeyword252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_identifierOrKeyword257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_identifierOrKeyword262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_identifierOrKeyword267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_identifierOrKeyword272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_identifierOrKeyword277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_identifierOrKeyword282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_identifierOrKeyword287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_identifierOrKeyword292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_identifierOrKeyword297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_identifierOrKeyword302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_identifierOrKeyword307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_identifierOrKeyword312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_identifierOrKeyword317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_identifierOrKeyword322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_identifierOrKeyword327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_identifierOrKeyword332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_identifierOrKeyword337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_identifierOrKeyword342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_identifierOrKeyword347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_identifierOrKeyword352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_identifierOrKeyword357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_identifierOrKeyword362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_identifierOrKeyword367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_identifierOrKeyword372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_identifierOrKeyword377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_identifierOrKeyword382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_identifierOrKeyword387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_identifierOrKeyword392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_identifierOrKeyword397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_identifierOrKeyword402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_identifierOrKeyword407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_identifierOrKeyword412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_identifierOrKeyword417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_module_in_unit556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_library_in_unit561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_unit566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_module599 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_module603 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_module607 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_module609 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module615 = new BitSet(new long[]{0x0000600000000200L});
    public static final BitSet FOLLOW_COMA_in_module622 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module627 = new BitSet(new long[]{0x0000600000000200L});
    public static final BitSet FOLLOW_45_in_module638 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_46_in_module645 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module655 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_COMA_in_module662 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module667 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_SEMI_in_module676 = new BitSet(new long[]{0x3CE6200000000002L});
    public static final BitSet FOLLOW_libraryRef_in_module684 = new BitSet(new long[]{0x3CE6200000000002L});
    public static final BitSet FOLLOW_libraryRef_in_module692 = new BitSet(new long[]{0x3CE6200000000002L});
    public static final BitSet FOLLOW_moduleElement_in_module706 = new BitSet(new long[]{0x3CE4200000000002L});
    public static final BitSet FOLLOW_moduleElement_in_module714 = new BitSet(new long[]{0x3CE4200000000002L});
    public static final BitSet FOLLOW_47_in_library756 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_library760 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_library764 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_library772 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_library780 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_helper_in_library794 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_helper_in_library802 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_48_in_query844 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_query848 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_query852 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_query856 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_query860 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_query868 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_query876 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_helper_in_query890 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_helper_in_query898 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_49_in_libraryRef940 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_libraryRef944 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_libraryRef948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_helper_in_moduleElement983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_moduleElement988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_helper1021 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_oclFeatureDefinition_in_helper1025 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_helper1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclContextDefinition_in_oclFeatureDefinition1065 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_oclFeatureDefinition1079 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_oclFeatureDefinition1081 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclFeature_in_oclFeatureDefinition1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_oclContextDefinition1119 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_oclContextDefinition1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operation_in_oclFeature1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_oclFeature1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_operation1200 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_operation1204 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_parameter_in_operation1210 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_operation1217 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parameter_in_operation1222 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_operation1232 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_operation1234 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_operation1238 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_operation1242 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_operation1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_parameter1286 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_parameter1290 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_parameter1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_attribute1330 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_attribute1334 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_attribute1338 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_attribute1342 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_attribute1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_calledRule_in_rule1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_matchedRule_in_rule1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lazyMatchedRule_in_matchedRule1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_matchedRule_abstractContents_in_matchedRule1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_lazyMatchedRule1468 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_lazyMatchedRule1480 = new BitSet(new long[]{0x00C0200000000000L});
    public static final BitSet FOLLOW_54_in_lazyMatchedRule1484 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_45_in_lazyMatchedRule1498 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_lazyMatchedRule1510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lazyMatchedRule1514 = new BitSet(new long[]{0x0100000000004000L});
    public static final BitSet FOLLOW_56_in_lazyMatchedRule1520 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lazyMatchedRule1524 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_lazyMatchedRule1538 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_inPattern_in_lazyMatchedRule1544 = new BitSet(new long[]{0x8200000000008000L,0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_lazyMatchedRule1550 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_lazyMatchedRule1552 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1560 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1568 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RCURLY_in_lazyMatchedRule1580 = new BitSet(new long[]{0x8000000000008000L,0x0000000000000008L});
    public static final BitSet FOLLOW_outPattern_in_lazyMatchedRule1596 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000008L});
    public static final BitSet FOLLOW_actionBlock_in_lazyMatchedRule1614 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RCURLY_in_lazyMatchedRule1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ruleVariableDeclaration1664 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_ruleVariableDeclaration1668 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_ruleVariableDeclaration1672 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_ruleVariableDeclaration1676 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_ruleVariableDeclaration1680 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_ruleVariableDeclaration1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_calledRule1718 = new BitSet(new long[]{0x2080000000000000L});
    public static final BitSet FOLLOW_61_in_calledRule1732 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_calledRule1744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_calledRule1748 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_calledRule1752 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_parameter_in_calledRule1758 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_calledRule1765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parameter_in_calledRule1770 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_calledRule1780 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_calledRule1782 = new BitSet(new long[]{0x8200000000008000L,0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_calledRule1788 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_calledRule1790 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_calledRule1798 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_calledRule1806 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RCURLY_in_calledRule1818 = new BitSet(new long[]{0x8000000000008000L,0x0000000000000008L});
    public static final BitSet FOLLOW_outPattern_in_calledRule1834 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000008L});
    public static final BitSet FOLLOW_actionBlock_in_calledRule1852 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RCURLY_in_calledRule1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_inPattern1900 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inPatternElement_in_inPattern1908 = new BitSet(new long[]{0x0000000000001202L});
    public static final BitSet FOLLOW_COMA_in_inPattern1915 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inPatternElement_in_inPattern1920 = new BitSet(new long[]{0x0000000000001202L});
    public static final BitSet FOLLOW_LPAREN_in_inPattern1931 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_inPattern1937 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_inPattern1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleInPatternElement_in_inPatternElement1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2023 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_simpleInPatternElement2027 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_simpleInPatternElement2031 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_simpleInPatternElement2037 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2043 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_COMA_in_simpleInPatternElement2050 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2055 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_63_in_outPattern2105 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_outPatternElement_in_outPattern2113 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_COMA_in_outPattern2120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_outPatternElement_in_outPattern2125 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_simpleOutPatternElement_in_outPatternElement2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forEachOutPatternElement_in_outPatternElement2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2209 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_simpleOutPatternElement2213 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_simpleOutPatternElement2217 = new BitSet(new long[]{0x4000000000011002L,0x0000000000000001L});
    public static final BitSet FOLLOW_62_in_simpleOutPatternElement2223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2227 = new BitSet(new long[]{0x0000000000011002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_simpleOutPatternElement2243 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2247 = new BitSet(new long[]{0x0000000000011002L});
    public static final BitSet FOLLOW_RARROW_in_simpleOutPatternElement2263 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_simpleOutPatternElement2265 = new BitSet(new long[]{0x0000000000A030F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_simpleOutPatternElement2271 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_simpleOutPatternElement2278 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_simpleOutPatternElement2283 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_simpleOutPatternElement2293 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LPAREN_in_simpleOutPatternElement2307 = new BitSet(new long[]{0xFFFFF80000002010L,0x0000000FFFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_simpleOutPatternElement2315 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_simpleOutPatternElement2322 = new BitSet(new long[]{0xFFFFF80000000010L,0x0000000FFFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_simpleOutPatternElement2327 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_simpleOutPatternElement2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_forEachOutPatternElement2383 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_forEachOutPatternElement2387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_forEachOutPatternElement2389 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_forEachOutPatternElement2393 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_forEachOutPatternElement2397 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_forEachOutPatternElement2399 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_forEachOutPatternElement2403 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_forEachOutPatternElement2407 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_forEachOutPatternElement2411 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_forEachOutPatternElement2415 = new BitSet(new long[]{0x0000000000001002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_forEachOutPatternElement2419 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_forEachOutPatternElement2423 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LPAREN_in_forEachOutPatternElement2439 = new BitSet(new long[]{0xFFFFF80000002010L,0x0000000FFFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_forEachOutPatternElement2447 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_forEachOutPatternElement2454 = new BitSet(new long[]{0xFFFFF80000000010L,0x0000000FFFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_forEachOutPatternElement2459 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_forEachOutPatternElement2471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_binding2515 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_ASSIGNARROW_in_binding2521 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_LARROW_in_binding2528 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_binding2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_actionBlock2570 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_actionBlock2572 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_actionBlock2580 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_actionBlock2588 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_RCURLY_in_actionBlock2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_statement2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStat_in_statement2640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bindingStat_in_statement2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStat_in_statement2650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclExpression_in_bindingStat2685 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_ASSIGNARROW_in_bindingStat2691 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_LARROW_in_bindingStat2698 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_bindingStat2706 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_bindingStat2710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclExpression_in_expressionStat2744 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_expressionStat2748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ifStat2780 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_ifStat2782 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_ifStat2786 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_ifStat2790 = new BitSet(new long[]{0x0000000000A050F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_ifStat2798 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_LCURLY_in_ifStat2809 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_ifStat2817 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_ifStat2825 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_RCURLY_in_ifStat2837 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ifStat2845 = new BitSet(new long[]{0x0000000000A050F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_ifStat2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_ifStat2864 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_ifStat2872 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_ifStat2880 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_RCURLY_in_ifStat2892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_forStat2938 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_forStat2940 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_forStat2944 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_forStat2948 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_forStat2952 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_forStat2956 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_forStat2958 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_forStat2966 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_forStat2974 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_RCURLY_in_forStat2986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_oclModel3020 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_oclModel3024 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_oclModel3028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_oclModelElement3064 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_EXCL_in_oclModelElement3068 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_oclModelElement3072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_5_in_oclExpression3108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letExp_in_oclExpression3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_iteratorExp3148 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_iteratorExp3152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iteratorExp3158 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_COMA_in_iteratorExp3165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iteratorExp3170 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_PIPE_in_iteratorExp3179 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_iteratorExp3185 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_iteratorExp3191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_iterateExp3224 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_iterateExp3226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iterateExp3232 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_COMA_in_iterateExp3239 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iterateExp3244 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_SEMI_in_iterateExp3253 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclaration_in_iterateExp3257 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_PIPE_in_iterateExp3261 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_iterateExp3267 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_iterateExp3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_collectionOperationCallExp3308 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionOperationCallExp3312 = new BitSet(new long[]{0x0000000000A030F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_collectionOperationCallExp3318 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_collectionOperationCallExp3325 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_collectionOperationCallExp3330 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_collectionOperationCallExp3340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_operationCallExp3375 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_operationCallExp3379 = new BitSet(new long[]{0x0000000000A030F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_operationCallExp3385 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_operationCallExp3392 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_operationCallExp3397 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_operationCallExp3407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_navigationOrAttributeCallExp3442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_iterator3507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_oclUndefinedExp3541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericExp_in_primitiveExp3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanExp_in_primitiveExp3581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExp_in_primitiveExp3586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerExp_in_numericExp3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realExp_in_numericExp3627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_booleanExp3662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_booleanExp3669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_integerExp3707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatSymbol_in_realExp3743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_stringExp3779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ifExp3813 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_ifExp3817 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ifExp3821 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_ifExp3827 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ifExp3833 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_ifExp3839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ifExp3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableExp3879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_superExp3913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_letExp3945 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclaration_in_letExp3949 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_letExp3953 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_letExp3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableDeclaration3997 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_variableDeclaration4001 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_variableDeclaration4005 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_variableDeclaration4009 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_variableDeclaration4013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_enumLiteralExp4047 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_enumLiteralExp4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bagExp_in_collectionExp4088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setExp_in_collectionExp4093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orderedSetExp_in_collectionExp4098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceExp_in_collectionExp4103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_bagExp4136 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_bagExp4138 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_bagExp4144 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_bagExp4151 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_bagExp4156 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_bagExp4166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_setExp4198 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_setExp4200 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_setExp4206 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_setExp4213 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_setExp4218 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_setExp4228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_orderedSetExp4260 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_orderedSetExp4262 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_orderedSetExp4268 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_orderedSetExp4275 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_orderedSetExp4280 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_orderedSetExp4290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_sequenceExp4322 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_sequenceExp4324 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_sequenceExp4330 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_sequenceExp4337 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_sequenceExp4342 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_sequenceExp4352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_mapExp4384 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_mapExp4386 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_mapElement_in_mapExp4392 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_mapExp4399 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mapElement_in_mapExp4404 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_mapExp4414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_mapElement4446 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_mapElement4450 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMA_in_mapElement4454 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_mapElement4458 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_mapElement4462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_tupleExp4494 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_tupleExp4496 = new BitSet(new long[]{0xFFFFF80000008010L,0x0000000FFFFFFFFFL});
    public static final BitSet FOLLOW_tuplePart_in_tupleExp4502 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_tupleExp4509 = new BitSet(new long[]{0xFFFFF80000000010L,0x0000000FFFFFFFFFL});
    public static final BitSet FOLLOW_tuplePart_in_tupleExp4514 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_tupleExp4524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tuplePart4558 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COLON_in_tuplePart4564 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_tuplePart4568 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tuplePart4582 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_tuplePart4586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclModelElement_in_oclType4623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclAnyType_in_oclType4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleType_in_oclType4633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapType_in_oclType4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitive_in_oclType4643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_oclType4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclType_abstractContents_in_oclType4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_oclAnyType4686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_tupleType4718 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_tupleType4720 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_tupleTypeAttribute_in_tupleType4726 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_tupleType4733 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_tupleTypeAttribute_in_tupleType4738 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_tupleType4748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tupleTypeAttribute4782 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_tupleTypeAttribute4786 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_tupleTypeAttribute4790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_mapType4824 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_mapType4826 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_mapType4830 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMA_in_mapType4834 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_mapType4838 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_mapType4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericType_in_primitive4877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanType_in_primitive4882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringType_in_primitive4887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerType_in_numericType4923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realType_in_numericType4928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_integerType4961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_realType4993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_booleanType5025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_stringType5057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bagType_in_collectionType5092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setType_in_collectionType5097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orderedSetType_in_collectionType5102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceType_in_collectionType5107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_abstractContents_in_collectionType5112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_bagType5145 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_bagType5147 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_bagType5151 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_bagType5155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_setType5187 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_setType5189 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_setType5193 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_setType5197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_orderedSetType5229 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_orderedSetType5231 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_orderedSetType5235 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_orderedSetType5239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_sequenceType5271 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_sequenceType5273 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_sequenceType5277 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_sequenceType5281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_oclExpression_in_priority_05315 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_POINT_in_priority_05320 = new BitSet(new long[]{0xFFFFF80000000010L,0x0000000FFFFFFFFFL});
    public static final BitSet FOLLOW_operationCallExp_in_priority_05327 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_navigationOrAttributeCallExp_in_priority_05334 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_RARROW_in_priority_05342 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000080L});
    public static final BitSet FOLLOW_iteratorExp_in_priority_05349 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_iterateExp_in_priority_05356 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_collectionOperationCallExp_in_priority_05363 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_93_in_priority_15403 = new BitSet(new long[]{0x00000000002010F0L,0x000000001FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_15410 = new BitSet(new long[]{0x00000000002010F0L,0x000000001FFFA710L});
    public static final BitSet FOLLOW_priority_0_in_priority_15415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_priority_15423 = new BitSet(new long[]{0x00000000002010F0L,0x000000001FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_15430 = new BitSet(new long[]{0x00000000002010F0L,0x000000001FFFA710L});
    public static final BitSet FOLLOW_priority_0_in_priority_15435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_0_in_priority_15445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_1_in_priority_25480 = new BitSet(new long[]{0x0000000003000002L,0x00000000C0000000L});
    public static final BitSet FOLLOW_STAR_in_priority_25485 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25492 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_1_in_priority_25497 = new BitSet(new long[]{0x0000000003000002L,0x00000000C0000000L});
    public static final BitSet FOLLOW_SLASH_in_priority_25505 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25512 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_1_in_priority_25517 = new BitSet(new long[]{0x0000000003000002L,0x00000000C0000000L});
    public static final BitSet FOLLOW_94_in_priority_25525 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25532 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_1_in_priority_25537 = new BitSet(new long[]{0x0000000003000002L,0x00000000C0000000L});
    public static final BitSet FOLLOW_95_in_priority_25545 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25552 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_1_in_priority_25557 = new BitSet(new long[]{0x0000000003000002L,0x00000000C0000000L});
    public static final BitSet FOLLOW_priority_2_in_priority_35598 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_PLUS_in_priority_35603 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_35610 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_2_in_priority_35615 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_MINUS_in_priority_35623 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_35630 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_2_in_priority_35635 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_priority_3_in_priority_45676 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_EQ_in_priority_45681 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45688 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_3_in_priority_45693 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_GT_in_priority_45701 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45708 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_3_in_priority_45713 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_LT_in_priority_45721 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45728 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_3_in_priority_45733 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_GE_in_priority_45741 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45748 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_3_in_priority_45753 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_LE_in_priority_45761 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45768 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_3_in_priority_45773 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_NE_in_priority_45781 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45788 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_3_in_priority_45793 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_priority_4_in_priority_55834 = new BitSet(new long[]{0x0000000000000002L,0x0000000F00000000L});
    public static final BitSet FOLLOW_96_in_priority_55839 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55846 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_4_in_priority_55851 = new BitSet(new long[]{0x0000000000000002L,0x0000000F00000000L});
    public static final BitSet FOLLOW_97_in_priority_55859 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55866 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_4_in_priority_55871 = new BitSet(new long[]{0x0000000000000002L,0x0000000F00000000L});
    public static final BitSet FOLLOW_98_in_priority_55879 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55886 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_4_in_priority_55891 = new BitSet(new long[]{0x0000000000000002L,0x0000000F00000000L});
    public static final BitSet FOLLOW_99_in_priority_55899 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55906 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFA710L});
    public static final BitSet FOLLOW_priority_4_in_priority_55911 = new BitSet(new long[]{0x0000000000000002L,0x0000000F00000000L});
    public static final BitSet FOLLOW_53_in_matchedRule_abstractContents5952 = new BitSet(new long[]{0x00C0200000000000L});
    public static final BitSet FOLLOW_54_in_matchedRule_abstractContents5966 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_45_in_matchedRule_abstractContents5980 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_matchedRule_abstractContents5992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_matchedRule_abstractContents5996 = new BitSet(new long[]{0x0100000000004000L});
    public static final BitSet FOLLOW_56_in_matchedRule_abstractContents6002 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_matchedRule_abstractContents6006 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_matchedRule_abstractContents6020 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_inPattern_in_matchedRule_abstractContents6026 = new BitSet(new long[]{0x8200000000008000L,0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_matchedRule_abstractContents6032 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_matchedRule_abstractContents6034 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6042 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6050 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RCURLY_in_matchedRule_abstractContents6062 = new BitSet(new long[]{0x8000000000008000L,0x0000000000000008L});
    public static final BitSet FOLLOW_outPattern_in_matchedRule_abstractContents6078 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000008L});
    public static final BitSet FOLLOW_actionBlock_in_matchedRule_abstractContents6096 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RCURLY_in_matchedRule_abstractContents6112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_oclType_abstractContents6144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_collectionType_abstractContents6176 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionType_abstractContents6178 = new BitSet(new long[]{0x0000000000000010L,0x000000001FEF8000L});
    public static final BitSet FOLLOW_oclType_in_collectionType_abstractContents6182 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_collectionType_abstractContents6186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_oclExpression6219 = new BitSet(new long[]{0x0000000000A010F0L,0x000000003FFFE710L});
    public static final BitSet FOLLOW_oclExpression_in_primary_oclExpression6223 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_oclExpression6225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExp_in_primary_oclExpression6231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclUndefinedExp_in_primary_oclExpression6236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveExp_in_primary_oclExpression6241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifExp_in_primary_oclExpression6246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_superExp_in_primary_oclExpression6251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumLiteralExp_in_primary_oclExpression6256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionExp_in_primary_oclExpression6261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapExp_in_primary_oclExpression6266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleExp_in_primary_oclExpression6271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclType_in_primary_oclExpression6276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_synpred1222635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStat_in_synpred1232640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bindingStat_in_synpred1242645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_synpred1322845 = new BitSet(new long[]{0x0000000000A050F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_synpred1322853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_synpred1322864 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_synpred1322872 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_statement_in_synpred1322880 = new BitSet(new long[]{0x0000000000A090F0L,0x000000003FFFE750L});
    public static final BitSet FOLLOW_RCURLY_in_synpred1322892 = new BitSet(new long[]{0x0000000000000002L});

}