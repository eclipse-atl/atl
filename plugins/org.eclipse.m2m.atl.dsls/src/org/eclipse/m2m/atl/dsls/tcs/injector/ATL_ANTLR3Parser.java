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
// $ANTLR 3.0.1 ATL_ANTLR3.g 2011-05-04 14:11:57
package org.eclipse.m2m.atl.dsls.tcs.injector;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ATL_ANTLR3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "SEMI", "COMA", "EQ", "COLON", "LPAREN", "RPAREN", "LCURLY", "RCURLY", "RARROW", "ASSIGNARROW", "LARROW", "EXCL", "PIPE", "SHARP", "POINT", "MINUS", "STAR", "SLASH", "PLUS", "GT", "LT", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "LSQUARE", "RSQUARE", "QMARK", "AROBAS", "COMMENT", "'module'", "'create'", "'refining'", "'from'", "'library'", "'query'", "'uses'", "'helper'", "'def'", "'context'", "'nodefault'", "'abstract'", "'rule'", "'extends'", "'using'", "'unique'", "'lazy'", "'entrypoint'", "'endpoint'", "'in'", "'to'", "'mapsTo'", "'distinct'", "'foreach'", "'drop'", "'do'", "'if'", "'else'", "'for'", "'iterate'", "'OclUndefined'", "'true'", "'false'", "'then'", "'endif'", "'super'", "'let'", "'Bag'", "'Set'", "'OrderedSet'", "'Sequence'", "'Map'", "'Tuple'", "'OclType'", "'OclAny'", "'TupleType'", "'Integer'", "'Real'", "'Boolean'", "'String'", "'Collection'", "'not'", "'div'", "'mod'", "'and'", "'or'", "'xor'", "'implies'"
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
            ruleMemo = new HashMap[318+1];
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
    // ATL_ANTLR3.g:79:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'drop' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ATL_ANTLR3.g:80:2: ( (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'drop' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' ) )
            // ATL_ANTLR3.g:80:4: (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'drop' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )
            {
            // ATL_ANTLR3.g:80:4: (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'drop' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )
            int alt1=59;
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
            case 100:
                {
                alt1=59;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("80:4: (ast= NAME | 'module' | 'create' | 'refining' | 'from' | 'library' | 'query' | 'uses' | 'helper' | 'def' | 'context' | 'nodefault' | 'abstract' | 'rule' | 'extends' | 'using' | 'unique' | 'lazy' | 'entrypoint' | 'endpoint' | 'in' | 'to' | 'mapsTo' | 'distinct' | 'foreach' | 'drop' | 'do' | 'if' | 'else' | 'for' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'then' | 'endif' | 'super' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )", 1, 0, input);

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
                    // ATL_ANTLR3.g:80:732: 'drop'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword257); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "drop";
                    }

                    }
                    break;
                case 27 :
                    // ATL_ANTLR3.g:80:756: 'do'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword262); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "do";
                    }

                    }
                    break;
                case 28 :
                    // ATL_ANTLR3.g:80:776: 'if'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword267); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "if";
                    }

                    }
                    break;
                case 29 :
                    // ATL_ANTLR3.g:80:796: 'else'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword272); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "else";
                    }

                    }
                    break;
                case 30 :
                    // ATL_ANTLR3.g:80:820: 'for'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword277); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "for";
                    }

                    }
                    break;
                case 31 :
                    // ATL_ANTLR3.g:80:842: 'iterate'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword282); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "iterate";
                    }

                    }
                    break;
                case 32 :
                    // ATL_ANTLR3.g:80:872: 'OclUndefined'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword287); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OclUndefined";
                    }

                    }
                    break;
                case 33 :
                    // ATL_ANTLR3.g:80:912: 'true'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword292); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 34 :
                    // ATL_ANTLR3.g:80:936: 'false'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword297); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 35 :
                    // ATL_ANTLR3.g:80:962: 'then'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword302); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "then";
                    }

                    }
                    break;
                case 36 :
                    // ATL_ANTLR3.g:80:986: 'endif'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword307); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "endif";
                    }

                    }
                    break;
                case 37 :
                    // ATL_ANTLR3.g:80:1012: 'super'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword312); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "super";
                    }

                    }
                    break;
                case 38 :
                    // ATL_ANTLR3.g:80:1038: 'let'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword317); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "let";
                    }

                    }
                    break;
                case 39 :
                    // ATL_ANTLR3.g:80:1060: 'Bag'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword322); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Bag";
                    }

                    }
                    break;
                case 40 :
                    // ATL_ANTLR3.g:80:1082: 'Set'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword327); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Set";
                    }

                    }
                    break;
                case 41 :
                    // ATL_ANTLR3.g:80:1104: 'OrderedSet'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword332); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OrderedSet";
                    }

                    }
                    break;
                case 42 :
                    // ATL_ANTLR3.g:80:1140: 'Sequence'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword337); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Sequence";
                    }

                    }
                    break;
                case 43 :
                    // ATL_ANTLR3.g:80:1172: 'Map'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword342); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Map";
                    }

                    }
                    break;
                case 44 :
                    // ATL_ANTLR3.g:80:1194: 'Tuple'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword347); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Tuple";
                    }

                    }
                    break;
                case 45 :
                    // ATL_ANTLR3.g:80:1220: 'OclType'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword352); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OclType";
                    }

                    }
                    break;
                case 46 :
                    // ATL_ANTLR3.g:80:1250: 'OclAny'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword357); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "OclAny";
                    }

                    }
                    break;
                case 47 :
                    // ATL_ANTLR3.g:80:1278: 'TupleType'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword362); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "TupleType";
                    }

                    }
                    break;
                case 48 :
                    // ATL_ANTLR3.g:80:1312: 'Integer'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword367); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Integer";
                    }

                    }
                    break;
                case 49 :
                    // ATL_ANTLR3.g:80:1342: 'Real'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword372); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Real";
                    }

                    }
                    break;
                case 50 :
                    // ATL_ANTLR3.g:80:1366: 'Boolean'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword377); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Boolean";
                    }

                    }
                    break;
                case 51 :
                    // ATL_ANTLR3.g:80:1396: 'String'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword382); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "String";
                    }

                    }
                    break;
                case 52 :
                    // ATL_ANTLR3.g:80:1424: 'Collection'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword387); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "Collection";
                    }

                    }
                    break;
                case 53 :
                    // ATL_ANTLR3.g:80:1460: 'not'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword392); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "not";
                    }

                    }
                    break;
                case 54 :
                    // ATL_ANTLR3.g:80:1482: 'div'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword397); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "div";
                    }

                    }
                    break;
                case 55 :
                    // ATL_ANTLR3.g:80:1504: 'mod'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword402); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "mod";
                    }

                    }
                    break;
                case 56 :
                    // ATL_ANTLR3.g:80:1526: 'and'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword407); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 57 :
                    // ATL_ANTLR3.g:80:1548: 'or'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword412); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "or";
                    }

                    }
                    break;
                case 58 :
                    // ATL_ANTLR3.g:80:1568: 'xor'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword417); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ret = "xor";
                    }

                    }
                    break;
                case 59 :
                    // ATL_ANTLR3.g:80:1590: 'implies'
                    {
                    match(input,100,FOLLOW_100_in_identifierOrKeyword422); if (failed) return ret2;
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
            match(input,STRING,FOLLOW_STRING_in_stringSymbol457); if (failed) return ret2;
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
            match(input,INT,FOLLOW_INT_in_integerSymbol491); if (failed) return ret2;
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
            match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol525); if (failed) return ret2;
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
                    pushFollow(FOLLOW_module_in_unit561);
                    ret=module();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:112:18: ret= library
                    {
                    pushFollow(FOLLOW_library_in_unit566);
                    ret=library();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:112:31: ret= query
                    {
                    pushFollow(FOLLOW_query_in_unit571);
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
            match(input,43,FOLLOW_43_in_module604); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_module608);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_module612); if (failed) return ret2;
            match(input,44,FOLLOW_44_in_module614); if (failed) return ret2;
            // ATL_ANTLR3.g:121:73: ( (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* ) )
            // ATL_ANTLR3.g:121:74: (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* )
            {
            // ATL_ANTLR3.g:121:74: (temp= oclModel ( ( ( COMA ) temp= oclModel ) )* )
            // ATL_ANTLR3.g:121:75: temp= oclModel ( ( ( COMA ) temp= oclModel ) )*
            {
            pushFollow(FOLLOW_oclModel_in_module620);
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
            	    match(input,COMA,FOLLOW_COMA_in_module627); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_oclModel_in_module632);
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
                    match(input,45,FOLLOW_45_in_module643); if (failed) return ret2;

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
                    match(input,46,FOLLOW_46_in_module650); if (failed) return ret2;

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
            pushFollow(FOLLOW_oclModel_in_module660);
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
            	    match(input,COMA,FOLLOW_COMA_in_module667); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_oclModel_in_module672);
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

            match(input,SEMI,FOLLOW_SEMI_in_module681); if (failed) return ret2;
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
                    pushFollow(FOLLOW_libraryRef_in_module689);
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
                    	    pushFollow(FOLLOW_libraryRef_in_module697);
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
                    pushFollow(FOLLOW_moduleElement_in_module711);
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
                    	    pushFollow(FOLLOW_moduleElement_in_module719);
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
            match(input,47,FOLLOW_47_in_library761); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_library765);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_library769); if (failed) return ret2;
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
                    pushFollow(FOLLOW_libraryRef_in_library777);
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
                    	    pushFollow(FOLLOW_libraryRef_in_library785);
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
                    pushFollow(FOLLOW_helper_in_library799);
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
                    	    pushFollow(FOLLOW_helper_in_library807);
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
            match(input,48,FOLLOW_48_in_query849); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_query853);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_query857); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_query861);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "body", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_query865); if (failed) return ret2;
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
                    pushFollow(FOLLOW_libraryRef_in_query873);
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
                    	    pushFollow(FOLLOW_libraryRef_in_query881);
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
                    pushFollow(FOLLOW_helper_in_query895);
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
                    	    pushFollow(FOLLOW_helper_in_query903);
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
            match(input,49,FOLLOW_49_in_libraryRef945); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_libraryRef949);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_libraryRef953); if (failed) return ret2;

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
                    pushFollow(FOLLOW_helper_in_moduleElement988);
                    ret=helper();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:165:18: ret= rule
                    {
                    pushFollow(FOLLOW_rule_in_moduleElement993);
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
            match(input,50,FOLLOW_50_in_helper1026); if (failed) return ret2;
            pushFollow(FOLLOW_oclFeatureDefinition_in_helper1030);
            temp=oclFeatureDefinition();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "definition", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_helper1034); if (failed) return ret2;

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
                    pushFollow(FOLLOW_oclContextDefinition_in_oclFeatureDefinition1070);
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

            match(input,51,FOLLOW_51_in_oclFeatureDefinition1084); if (failed) return ret2;
            match(input,COLON,FOLLOW_COLON_in_oclFeatureDefinition1086); if (failed) return ret2;
            pushFollow(FOLLOW_oclFeature_in_oclFeatureDefinition1090);
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
            match(input,52,FOLLOW_52_in_oclContextDefinition1124); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_oclContextDefinition1128);
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
                    pushFollow(FOLLOW_operation_in_oclFeature1165);
                    ret=operation();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:207:21: ret= attribute
                    {
                    pushFollow(FOLLOW_attribute_in_oclFeature1170);
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
            pushFollow(FOLLOW_identifier_in_operation1205);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_operation1209); if (failed) return ret2;
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
                    pushFollow(FOLLOW_parameter_in_operation1215);
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
                    	    match(input,COMA,FOLLOW_COMA_in_operation1222); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_parameter_in_operation1227);
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

            match(input,RPAREN,FOLLOW_RPAREN_in_operation1237); if (failed) return ret2;
            match(input,COLON,FOLLOW_COLON_in_operation1239); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_operation1243);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "returnType", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_operation1247); if (failed) return ret2;
            // ATL_ANTLR3.g:216:238: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:216:239: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:216:239: (temp= oclExpression )
            // ATL_ANTLR3.g:216:240: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_operation1253);
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
            pushFollow(FOLLOW_identifier_in_parameter1291);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_parameter1295); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_parameter1299);
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
            pushFollow(FOLLOW_identifier_in_attribute1335);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_attribute1339); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_attribute1343);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_attribute1347); if (failed) return ret2;
            // ATL_ANTLR3.g:238:101: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:238:102: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:238:102: (temp= oclExpression )
            // ATL_ANTLR3.g:238:103: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_attribute1353);
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
                    pushFollow(FOLLOW_calledRule_in_rule1392);
                    ret=calledRule();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:249:22: ret= matchedRule
                    {
                    pushFollow(FOLLOW_matchedRule_in_rule1397);
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
                    pushFollow(FOLLOW_lazyMatchedRule_in_matchedRule1433);
                    ret=lazyMatchedRule();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:258:27: ret= matchedRule_abstractContents
                    {
                    pushFollow(FOLLOW_matchedRule_abstractContents_in_matchedRule1438);
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
                    match(input,58,FOLLOW_58_in_lazyMatchedRule1473); if (failed) return ret2;

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

            match(input,59,FOLLOW_59_in_lazyMatchedRule1485); if (failed) return ret2;
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
                    match(input,54,FOLLOW_54_in_lazyMatchedRule1489); if (failed) return ret2;

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
                    match(input,45,FOLLOW_45_in_lazyMatchedRule1503); if (failed) return ret2;

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

            match(input,55,FOLLOW_55_in_lazyMatchedRule1515); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_lazyMatchedRule1519);
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
                    match(input,56,FOLLOW_56_in_lazyMatchedRule1525); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_lazyMatchedRule1529);
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

            match(input,LCURLY,FOLLOW_LCURLY_in_lazyMatchedRule1543); if (failed) return ret2;
            // ATL_ANTLR3.g:267:576: ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) )
            // ATL_ANTLR3.g:267:577: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            {
            // ATL_ANTLR3.g:267:577: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            // ATL_ANTLR3.g:267:578: temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () )
            {
            pushFollow(FOLLOW_inPattern_in_lazyMatchedRule1549);
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
            else if ( (LA31_0==RCURLY||LA31_0==63||LA31_0==68) ) {
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
                    match(input,57,FOLLOW_57_in_lazyMatchedRule1555); if (failed) return ret2;
                    match(input,LCURLY,FOLLOW_LCURLY_in_lazyMatchedRule1557); if (failed) return ret2;
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
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1565);
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
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1573);
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

                    match(input,RCURLY,FOLLOW_RCURLY_in_lazyMatchedRule1585); if (failed) return ret2;

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
            else if ( (LA32_0==RCURLY||LA32_0==68) ) {
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
                    pushFollow(FOLLOW_outPattern_in_lazyMatchedRule1601);
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

            if ( (LA33_0==68) ) {
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
                    pushFollow(FOLLOW_actionBlock_in_lazyMatchedRule1619);
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

            match(input,RCURLY,FOLLOW_RCURLY_in_lazyMatchedRule1635); if (failed) return ret2;

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
            pushFollow(FOLLOW_identifier_in_ruleVariableDeclaration1669);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_ruleVariableDeclaration1673); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_ruleVariableDeclaration1677);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_ruleVariableDeclaration1681); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_ruleVariableDeclaration1685);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "initExpression", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_ruleVariableDeclaration1689); if (failed) return ret2;

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
                    match(input,60,FOLLOW_60_in_calledRule1723); if (failed) return ret2;

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
                    match(input,61,FOLLOW_61_in_calledRule1737); if (failed) return ret2;

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

            match(input,55,FOLLOW_55_in_calledRule1749); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_calledRule1753);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_calledRule1757); if (failed) return ret2;
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
                    pushFollow(FOLLOW_parameter_in_calledRule1763);
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
                    	    match(input,COMA,FOLLOW_COMA_in_calledRule1770); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_parameter_in_calledRule1775);
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

            match(input,RPAREN,FOLLOW_RPAREN_in_calledRule1785); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_calledRule1787); if (failed) return ret2;
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
            else if ( (LA40_0==RCURLY||LA40_0==63||LA40_0==68) ) {
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
                    match(input,57,FOLLOW_57_in_calledRule1793); if (failed) return ret2;
                    match(input,LCURLY,FOLLOW_LCURLY_in_calledRule1795); if (failed) return ret2;
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
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_calledRule1803);
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
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_calledRule1811);
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

                    match(input,RCURLY,FOLLOW_RCURLY_in_calledRule1823); if (failed) return ret2;

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
            else if ( (LA41_0==RCURLY||LA41_0==68) ) {
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
                    pushFollow(FOLLOW_outPattern_in_calledRule1839);
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

            if ( (LA42_0==68) ) {
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
                    pushFollow(FOLLOW_actionBlock_in_calledRule1857);
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

            match(input,RCURLY,FOLLOW_RCURLY_in_calledRule1873); if (failed) return ret2;

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
            match(input,46,FOLLOW_46_in_inPattern1905); if (failed) return ret2;
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
            pushFollow(FOLLOW_inPatternElement_in_inPattern1913);
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
            	    match(input,COMA,FOLLOW_COMA_in_inPattern1920); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_inPatternElement_in_inPattern1925);
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
            else if ( (LA44_0==RCURLY||LA44_0==57||LA44_0==63||LA44_0==68) ) {
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
                    match(input,LPAREN,FOLLOW_LPAREN_in_inPattern1936); if (failed) return ret2;
                    // ATL_ANTLR3.g:300:149: ( (temp= oclExpression ) )
                    // ATL_ANTLR3.g:300:150: (temp= oclExpression )
                    {
                    // ATL_ANTLR3.g:300:150: (temp= oclExpression )
                    // ATL_ANTLR3.g:300:151: temp= oclExpression
                    {
                    pushFollow(FOLLOW_oclExpression_in_inPattern1942);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "filter", temp);
                    }

                    }


                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_inPattern1948); if (failed) return ret2;

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
            pushFollow(FOLLOW_simpleInPatternElement_in_inPatternElement1994);
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
            pushFollow(FOLLOW_identifier_in_simpleInPatternElement2028);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_simpleInPatternElement2032); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_simpleInPatternElement2036);
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
            else if ( (LA47_0==EOF||LA47_0==COMA||LA47_0==LPAREN||LA47_0==RCURLY||LA47_0==57||LA47_0==63||LA47_0==68) ) {
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
                    match(input,62,FOLLOW_62_in_simpleInPatternElement2042); if (failed) return ret2;
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
                            pushFollow(FOLLOW_identifier_in_simpleInPatternElement2048);
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

                                        if ( (LA45_3==EOF||LA45_3==COMA||LA45_3==LPAREN||LA45_3==RCURLY||LA45_3==57||LA45_3==63||LA45_3==68) ) {
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
                            	    match(input,COMA,FOLLOW_COMA_in_simpleInPatternElement2055); if (failed) return ret2;

                            	    }

                            	    pushFollow(FOLLOW_identifier_in_simpleInPatternElement2060);
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
    // ATL_ANTLR3.g:330:1: outPattern returns [Object ret2] : ( 'to' ( (temp= dropPattern ) | () ) ( ( ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () ) ) ) ) ;
    public final Object outPattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OutPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:331:2: ( ( 'to' ( (temp= dropPattern ) | () ) ( ( ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () ) ) ) ) )
            // ATL_ANTLR3.g:331:4: ( 'to' ( (temp= dropPattern ) | () ) ( ( ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () ) ) ) )
            {
            // ATL_ANTLR3.g:331:4: ( 'to' ( (temp= dropPattern ) | () ) ( ( ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () ) ) ) )
            // ATL_ANTLR3.g:331:5: 'to' ( (temp= dropPattern ) | () ) ( ( ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () ) ) )
            {
            match(input,63,FOLLOW_63_in_outPattern2110); if (failed) return ret2;
            // ATL_ANTLR3.g:331:10: ( (temp= dropPattern ) | () )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==67) ) {
                alt48=1;
            }
            else if ( (LA48_0==EOF||LA48_0==NAME||LA48_0==RCURLY||LA48_0==68) ) {
                alt48=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("331:10: ( (temp= dropPattern ) | () )", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ATL_ANTLR3.g:331:11: (temp= dropPattern )
                    {
                    // ATL_ANTLR3.g:331:11: (temp= dropPattern )
                    // ATL_ANTLR3.g:331:12: temp= dropPattern
                    {
                    pushFollow(FOLLOW_dropPattern_in_outPattern2116);
                    temp=dropPattern();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "dropPattern", temp);
                    }

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:331:70: ()
                    {
                    // ATL_ANTLR3.g:331:70: ()
                    // ATL_ANTLR3.g:331:71: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:331:77: ( ( ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () ) ) )
            // ATL_ANTLR3.g:331:78: ( ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () ) )
            {
            // ATL_ANTLR3.g:331:78: ( ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () ) )
            // ATL_ANTLR3.g:331:79: ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () )
            {
            // ATL_ANTLR3.g:331:79: ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==NAME) ) {
                alt50=1;
            }
            else if ( (LA50_0==EOF||LA50_0==RCURLY||LA50_0==68) ) {
                alt50=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("331:79: ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) | () )", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ATL_ANTLR3.g:331:80: ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) )
                    {
                    // ATL_ANTLR3.g:331:80: ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) )
                    // ATL_ANTLR3.g:331:81: ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) )
                    {
                    // ATL_ANTLR3.g:331:81: ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) )
                    // ATL_ANTLR3.g:331:82: (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* )
                    {
                    // ATL_ANTLR3.g:331:82: (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* )
                    // ATL_ANTLR3.g:331:83: temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )*
                    {
                    pushFollow(FOLLOW_outPatternElement_in_outPattern2138);
                    temp=outPatternElement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:331:139: ( ( ( COMA ) temp= outPatternElement ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==COMA) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:331:140: ( ( COMA ) temp= outPatternElement )
                    	    {
                    	    // ATL_ANTLR3.g:331:140: ( ( COMA ) temp= outPatternElement )
                    	    // ATL_ANTLR3.g:331:141: ( COMA ) temp= outPatternElement
                    	    {
                    	    // ATL_ANTLR3.g:331:141: ( COMA )
                    	    // ATL_ANTLR3.g:331:142: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_outPattern2145); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_outPatternElement_in_outPattern2150);
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
                    	    break loop49;
                        }
                    } while (true);


                    }


                    }


                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:331:214: ()
                    {
                    // ATL_ANTLR3.g:331:214: ()
                    // ATL_ANTLR3.g:331:215: 
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
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==NAME) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==COLON) ) {
                    int LA51_2 = input.LA(3);

                    if ( (LA51_2==65) ) {
                        alt51=2;
                    }
                    else if ( (LA51_2==NAME||(LA51_2>=80 && LA51_2<=84)||(LA51_2>=86 && LA51_2<=93)) ) {
                        alt51=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("342:5: (ret= simpleOutPatternElement | ret= forEachOutPatternElement )", 51, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("342:5: (ret= simpleOutPatternElement | ret= forEachOutPatternElement )", 51, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("342:5: (ret= simpleOutPatternElement | ret= forEachOutPatternElement )", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ATL_ANTLR3.g:342:6: ret= simpleOutPatternElement
                    {
                    pushFollow(FOLLOW_simpleOutPatternElement_in_outPatternElement2204);
                    ret=simpleOutPatternElement();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:342:35: ret= forEachOutPatternElement
                    {
                    pushFollow(FOLLOW_forEachOutPatternElement_in_outPatternElement2209);
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
            pushFollow(FOLLOW_identifier_in_simpleOutPatternElement2244);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_simpleOutPatternElement2248); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_simpleOutPatternElement2252);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            // ATL_ANTLR3.g:351:101: ( ( 'in' temp= identifier ) | () )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==62) ) {
                alt52=1;
            }
            else if ( (LA52_0==EOF||LA52_0==COMA||LA52_0==LPAREN||(LA52_0>=RCURLY && LA52_0<=RARROW)||LA52_0==64||LA52_0==68) ) {
                alt52=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("351:101: ( ( 'in' temp= identifier ) | () )", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ATL_ANTLR3.g:351:102: ( 'in' temp= identifier )
                    {
                    // ATL_ANTLR3.g:351:102: ( 'in' temp= identifier )
                    // ATL_ANTLR3.g:351:103: 'in' temp= identifier
                    {
                    match(input,62,FOLLOW_62_in_simpleOutPatternElement2258); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_simpleOutPatternElement2262);
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
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==64) ) {
                alt53=1;
            }
            else if ( (LA53_0==EOF||LA53_0==COMA||LA53_0==LPAREN||(LA53_0>=RCURLY && LA53_0<=RARROW)||LA53_0==68) ) {
                alt53=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("351:225: ( ( 'mapsTo' temp= identifier ) | () )", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ATL_ANTLR3.g:351:226: ( 'mapsTo' temp= identifier )
                    {
                    // ATL_ANTLR3.g:351:226: ( 'mapsTo' temp= identifier )
                    // ATL_ANTLR3.g:351:227: 'mapsTo' temp= identifier
                    {
                    match(input,64,FOLLOW_64_in_simpleOutPatternElement2278); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_simpleOutPatternElement2282);
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
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RARROW) ) {
                alt56=1;
            }
            else if ( (LA56_0==EOF||LA56_0==COMA||LA56_0==LPAREN||LA56_0==RCURLY||LA56_0==68) ) {
                alt56=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("351:370: ( ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) | () )", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ATL_ANTLR3.g:351:371: ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
                    {
                    // ATL_ANTLR3.g:351:371: ( RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
                    // ATL_ANTLR3.g:351:372: RARROW LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
                    {
                    match(input,RARROW,FOLLOW_RARROW_in_simpleOutPatternElement2298); if (failed) return ret2;
                    match(input,LPAREN,FOLLOW_LPAREN_in_simpleOutPatternElement2300); if (failed) return ret2;
                    // ATL_ANTLR3.g:351:386: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( ((LA55_0>=NAME && LA55_0<=FLOAT)||LA55_0==LPAREN||LA55_0==SHARP||LA55_0==MINUS||LA55_0==69||(LA55_0>=73 && LA55_0<=75)||(LA55_0>=78 && LA55_0<=94)) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // ATL_ANTLR3.g:351:387: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                            {
                            // ATL_ANTLR3.g:351:387: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                            // ATL_ANTLR3.g:351:388: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                            {
                            pushFollow(FOLLOW_oclExpression_in_simpleOutPatternElement2306);
                            temp=oclExpression();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "reverseBindings", temp);
                            }
                            // ATL_ANTLR3.g:351:447: ( ( ( COMA ) temp= oclExpression ) )*
                            loop54:
                            do {
                                int alt54=2;
                                int LA54_0 = input.LA(1);

                                if ( (LA54_0==COMA) ) {
                                    alt54=1;
                                }


                                switch (alt54) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:351:448: ( ( COMA ) temp= oclExpression )
                            	    {
                            	    // ATL_ANTLR3.g:351:448: ( ( COMA ) temp= oclExpression )
                            	    // ATL_ANTLR3.g:351:449: ( COMA ) temp= oclExpression
                            	    {
                            	    // ATL_ANTLR3.g:351:449: ( COMA )
                            	    // ATL_ANTLR3.g:351:450: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_simpleOutPatternElement2313); if (failed) return ret2;

                            	    }

                            	    pushFollow(FOLLOW_oclExpression_in_simpleOutPatternElement2318);
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
                            	    break loop54;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_simpleOutPatternElement2328); if (failed) return ret2;

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
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==LPAREN) ) {
                alt59=1;
            }
            else if ( (LA59_0==EOF||LA59_0==COMA||LA59_0==RCURLY||LA59_0==68) ) {
                alt59=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("351:540: ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ATL_ANTLR3.g:351:541: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    {
                    // ATL_ANTLR3.g:351:541: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    // ATL_ANTLR3.g:351:542: LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_simpleOutPatternElement2342); if (failed) return ret2;
                    // ATL_ANTLR3.g:351:549: ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) )
                    // ATL_ANTLR3.g:351:550: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:351:550: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    // ATL_ANTLR3.g:351:551: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    {
                    // ATL_ANTLR3.g:351:551: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==NAME||(LA58_0>=43 && LA58_0<=100)) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // ATL_ANTLR3.g:351:552: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            {
                            // ATL_ANTLR3.g:351:552: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            // ATL_ANTLR3.g:351:553: temp= binding ( ( ( COMA ) temp= binding ) )*
                            {
                            pushFollow(FOLLOW_binding_in_simpleOutPatternElement2350);
                            temp=binding();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "bindings", temp);
                            }
                            // ATL_ANTLR3.g:351:599: ( ( ( COMA ) temp= binding ) )*
                            loop57:
                            do {
                                int alt57=2;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==COMA) ) {
                                    alt57=1;
                                }


                                switch (alt57) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:351:600: ( ( COMA ) temp= binding )
                            	    {
                            	    // ATL_ANTLR3.g:351:600: ( ( COMA ) temp= binding )
                            	    // ATL_ANTLR3.g:351:601: ( COMA ) temp= binding
                            	    {
                            	    // ATL_ANTLR3.g:351:601: ( COMA )
                            	    // ATL_ANTLR3.g:351:602: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_simpleOutPatternElement2357); if (failed) return ret2;

                            	    }

                            	    pushFollow(FOLLOW_binding_in_simpleOutPatternElement2362);
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
                            	    break loop57;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_simpleOutPatternElement2374); if (failed) return ret2;

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
            pushFollow(FOLLOW_identifier_in_forEachOutPatternElement2418);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_forEachOutPatternElement2422); if (failed) return ret2;
            match(input,65,FOLLOW_65_in_forEachOutPatternElement2424); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_forEachOutPatternElement2428);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            match(input,66,FOLLOW_66_in_forEachOutPatternElement2432); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_forEachOutPatternElement2434); if (failed) return ret2;
            pushFollow(FOLLOW_iterator_in_forEachOutPatternElement2438);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterator", temp);
            }
            match(input,62,FOLLOW_62_in_forEachOutPatternElement2442); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_forEachOutPatternElement2446);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "collection", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_forEachOutPatternElement2450); if (failed) return ret2;
            // ATL_ANTLR3.g:362:242: ( ( 'mapsTo' temp= identifier ) | () )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==64) ) {
                alt60=1;
            }
            else if ( (LA60_0==EOF||LA60_0==COMA||LA60_0==LPAREN||LA60_0==RCURLY||LA60_0==68) ) {
                alt60=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("362:242: ( ( 'mapsTo' temp= identifier ) | () )", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ATL_ANTLR3.g:362:243: ( 'mapsTo' temp= identifier )
                    {
                    // ATL_ANTLR3.g:362:243: ( 'mapsTo' temp= identifier )
                    // ATL_ANTLR3.g:362:244: 'mapsTo' temp= identifier
                    {
                    match(input,64,FOLLOW_64_in_forEachOutPatternElement2454); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_forEachOutPatternElement2458);
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
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==LPAREN) ) {
                alt63=1;
            }
            else if ( (LA63_0==EOF||LA63_0==COMA||LA63_0==RCURLY||LA63_0==68) ) {
                alt63=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("362:387: ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ATL_ANTLR3.g:362:388: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    {
                    // ATL_ANTLR3.g:362:388: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    // ATL_ANTLR3.g:362:389: LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_forEachOutPatternElement2474); if (failed) return ret2;
                    // ATL_ANTLR3.g:362:396: ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) )
                    // ATL_ANTLR3.g:362:397: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:362:397: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    // ATL_ANTLR3.g:362:398: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    {
                    // ATL_ANTLR3.g:362:398: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==NAME||(LA62_0>=43 && LA62_0<=100)) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // ATL_ANTLR3.g:362:399: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            {
                            // ATL_ANTLR3.g:362:399: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            // ATL_ANTLR3.g:362:400: temp= binding ( ( ( COMA ) temp= binding ) )*
                            {
                            pushFollow(FOLLOW_binding_in_forEachOutPatternElement2482);
                            temp=binding();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "bindings", temp);
                            }
                            // ATL_ANTLR3.g:362:446: ( ( ( COMA ) temp= binding ) )*
                            loop61:
                            do {
                                int alt61=2;
                                int LA61_0 = input.LA(1);

                                if ( (LA61_0==COMA) ) {
                                    alt61=1;
                                }


                                switch (alt61) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:362:447: ( ( COMA ) temp= binding )
                            	    {
                            	    // ATL_ANTLR3.g:362:447: ( ( COMA ) temp= binding )
                            	    // ATL_ANTLR3.g:362:448: ( COMA ) temp= binding
                            	    {
                            	    // ATL_ANTLR3.g:362:448: ( COMA )
                            	    // ATL_ANTLR3.g:362:449: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_forEachOutPatternElement2489); if (failed) return ret2;

                            	    }

                            	    pushFollow(FOLLOW_binding_in_forEachOutPatternElement2494);
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
                            	    break loop61;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_forEachOutPatternElement2506); if (failed) return ret2;

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
            pushFollow(FOLLOW_identifierOrKeyword_in_binding2550);
            temp=identifierOrKeyword();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "propertyName", temp);
            }
            // ATL_ANTLR3.g:373:67: ( ( ASSIGNARROW ) | ( LARROW ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==ASSIGNARROW) ) {
                alt64=1;
            }
            else if ( (LA64_0==LARROW) ) {
                alt64=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("373:67: ( ( ASSIGNARROW ) | ( LARROW ) )", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ATL_ANTLR3.g:373:68: ( ASSIGNARROW )
                    {
                    // ATL_ANTLR3.g:373:68: ( ASSIGNARROW )
                    // ATL_ANTLR3.g:373:69: ASSIGNARROW
                    {
                    match(input,ASSIGNARROW,FOLLOW_ASSIGNARROW_in_binding2556); if (failed) return ret2;

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
                    match(input,LARROW,FOLLOW_LARROW_in_binding2563); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAssignment", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_oclExpression_in_binding2571);
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


    // $ANTLR start dropPattern
    // ATL_ANTLR3.g:383:1: dropPattern returns [Object ret2] : ( 'drop' ) ;
    public final Object dropPattern() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("DropPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:384:2: ( ( 'drop' ) )
            // ATL_ANTLR3.g:384:4: ( 'drop' )
            {
            // ATL_ANTLR3.g:384:4: ( 'drop' )
            // ATL_ANTLR3.g:384:5: 'drop'
            {
            match(input,67,FOLLOW_67_in_dropPattern2605); if (failed) return ret2;

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
    // $ANTLR end dropPattern


    // $ANTLR start actionBlock
    // ATL_ANTLR3.g:394:1: actionBlock returns [Object ret2] : ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object actionBlock() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ActionBlock", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:395:2: ( ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ATL_ANTLR3.g:395:4: ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ATL_ANTLR3.g:395:4: ( 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ATL_ANTLR3.g:395:5: 'do' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,68,FOLLOW_68_in_actionBlock2637); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_actionBlock2639); if (failed) return ret2;
            // ATL_ANTLR3.g:395:17: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ATL_ANTLR3.g:395:18: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ATL_ANTLR3.g:395:18: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ATL_ANTLR3.g:395:19: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ATL_ANTLR3.g:395:19: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=NAME && LA66_0<=FLOAT)||LA66_0==LPAREN||LA66_0==SHARP||LA66_0==MINUS||LA66_0==69||LA66_0==71||(LA66_0>=73 && LA66_0<=75)||(LA66_0>=78 && LA66_0<=94)) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ATL_ANTLR3.g:395:20: (temp= statement ( (temp= statement ) )* )
                    {
                    // ATL_ANTLR3.g:395:20: (temp= statement ( (temp= statement ) )* )
                    // ATL_ANTLR3.g:395:21: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_actionBlock2647);
                    temp=statement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "statements", temp);
                    }
                    // ATL_ANTLR3.g:395:71: ( (temp= statement ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( ((LA65_0>=NAME && LA65_0<=FLOAT)||LA65_0==LPAREN||LA65_0==SHARP||LA65_0==MINUS||LA65_0==69||LA65_0==71||(LA65_0>=73 && LA65_0<=75)||(LA65_0>=78 && LA65_0<=94)) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:395:72: (temp= statement )
                    	    {
                    	    // ATL_ANTLR3.g:395:72: (temp= statement )
                    	    // ATL_ANTLR3.g:395:73: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_actionBlock2655);
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
                    	    break loop65;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_actionBlock2667); if (failed) return ret2;

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
    // ATL_ANTLR3.g:405:1: statement returns [Object ret2] : ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) ) ;
    public final Object statement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:406:2: ( ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) ) )
            // ATL_ANTLR3.g:406:4: ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) )
            {
            // ATL_ANTLR3.g:406:4: ( (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat ) )
            // ATL_ANTLR3.g:406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )
            {
            // ATL_ANTLR3.g:406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )
            int alt67=4;
            switch ( input.LA(1) ) {
            case 69:
                {
                int LA67_1 = input.LA(2);

                if ( (synpred125()) ) {
                    alt67=1;
                }
                else if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 1, input);

                    throw nvae;
                }
                }
                break;
            case 94:
                {
                int LA67_2 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 2, input);

                    throw nvae;
                }
                }
                break;
            case MINUS:
                {
                int LA67_3 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 3, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                int LA67_4 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 4, input);

                    throw nvae;
                }
                }
                break;
            case NAME:
                {
                int LA67_5 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 5, input);

                    throw nvae;
                }
                }
                break;
            case 73:
                {
                int LA67_6 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 6, input);

                    throw nvae;
                }
                }
                break;
            case INT:
                {
                int LA67_7 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 7, input);

                    throw nvae;
                }
                }
                break;
            case FLOAT:
                {
                int LA67_8 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 8, input);

                    throw nvae;
                }
                }
                break;
            case 74:
                {
                int LA67_9 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 9, input);

                    throw nvae;
                }
                }
                break;
            case 75:
                {
                int LA67_10 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 10, input);

                    throw nvae;
                }
                }
                break;
            case STRING:
                {
                int LA67_11 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 11, input);

                    throw nvae;
                }
                }
                break;
            case 78:
                {
                int LA67_12 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 12, input);

                    throw nvae;
                }
                }
                break;
            case SHARP:
                {
                int LA67_13 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 13, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                int LA67_14 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 14, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA67_15 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 15, input);

                    throw nvae;
                }
                }
                break;
            case 82:
                {
                int LA67_16 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 16, input);

                    throw nvae;
                }
                }
                break;
            case 83:
                {
                int LA67_17 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 17, input);

                    throw nvae;
                }
                }
                break;
            case 84:
                {
                int LA67_18 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 18, input);

                    throw nvae;
                }
                }
                break;
            case 85:
                {
                int LA67_19 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 19, input);

                    throw nvae;
                }
                }
                break;
            case 87:
                {
                int LA67_20 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 20, input);

                    throw nvae;
                }
                }
                break;
            case 88:
                {
                int LA67_21 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 21, input);

                    throw nvae;
                }
                }
                break;
            case 89:
                {
                int LA67_22 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 22, input);

                    throw nvae;
                }
                }
                break;
            case 90:
                {
                int LA67_23 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 23, input);

                    throw nvae;
                }
                }
                break;
            case 91:
                {
                int LA67_24 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 24, input);

                    throw nvae;
                }
                }
                break;
            case 92:
                {
                int LA67_25 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 25, input);

                    throw nvae;
                }
                }
                break;
            case 93:
                {
                int LA67_26 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 26, input);

                    throw nvae;
                }
                }
                break;
            case 86:
                {
                int LA67_27 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 27, input);

                    throw nvae;
                }
                }
                break;
            case 79:
                {
                int LA67_28 = input.LA(2);

                if ( (synpred126()) ) {
                    alt67=2;
                }
                else if ( (synpred127()) ) {
                    alt67=3;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 28, input);

                    throw nvae;
                }
                }
                break;
            case 71:
                {
                alt67=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("406:5: (ret= ifStat | ret= expressionStat | ret= bindingStat | ret= forStat )", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // ATL_ANTLR3.g:406:6: ret= ifStat
                    {
                    pushFollow(FOLLOW_ifStat_in_statement2702);
                    ret=ifStat();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:406:18: ret= expressionStat
                    {
                    pushFollow(FOLLOW_expressionStat_in_statement2707);
                    ret=expressionStat();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:406:38: ret= bindingStat
                    {
                    pushFollow(FOLLOW_bindingStat_in_statement2712);
                    ret=bindingStat();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:406:55: ret= forStat
                    {
                    pushFollow(FOLLOW_forStat_in_statement2717);
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
    // ATL_ANTLR3.g:414:1: bindingStat returns [Object ret2] : (temp= oclExpression ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression SEMI ) ;
    public final Object bindingStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BindingStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:415:2: ( (temp= oclExpression ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression SEMI ) )
            // ATL_ANTLR3.g:415:4: (temp= oclExpression ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression SEMI )
            {
            // ATL_ANTLR3.g:415:4: (temp= oclExpression ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression SEMI )
            // ATL_ANTLR3.g:415:5: temp= oclExpression ( ( ASSIGNARROW ) | ( LARROW ) ) temp= oclExpression SEMI
            {
            pushFollow(FOLLOW_oclExpression_in_bindingStat2752);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "source", temp);
            }
            // ATL_ANTLR3.g:415:55: ( ( ASSIGNARROW ) | ( LARROW ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==ASSIGNARROW) ) {
                alt68=1;
            }
            else if ( (LA68_0==LARROW) ) {
                alt68=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("415:55: ( ( ASSIGNARROW ) | ( LARROW ) )", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ATL_ANTLR3.g:415:56: ( ASSIGNARROW )
                    {
                    // ATL_ANTLR3.g:415:56: ( ASSIGNARROW )
                    // ATL_ANTLR3.g:415:57: ASSIGNARROW
                    {
                    match(input,ASSIGNARROW,FOLLOW_ASSIGNARROW_in_bindingStat2758); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAssignment", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:415:126: ( LARROW )
                    {
                    // ATL_ANTLR3.g:415:126: ( LARROW )
                    // ATL_ANTLR3.g:415:127: LARROW
                    {
                    match(input,LARROW,FOLLOW_LARROW_in_bindingStat2765); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAssignment", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_oclExpression_in_bindingStat2773);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "value", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_bindingStat2777); if (failed) return ret2;

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
    // ATL_ANTLR3.g:425:1: expressionStat returns [Object ret2] : (temp= oclExpression SEMI ) ;
    public final Object expressionStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ExpressionStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:426:2: ( (temp= oclExpression SEMI ) )
            // ATL_ANTLR3.g:426:4: (temp= oclExpression SEMI )
            {
            // ATL_ANTLR3.g:426:4: (temp= oclExpression SEMI )
            // ATL_ANTLR3.g:426:5: temp= oclExpression SEMI
            {
            pushFollow(FOLLOW_oclExpression_in_expressionStat2811);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "expression", temp);
            }
            match(input,SEMI,FOLLOW_SEMI_in_expressionStat2815); if (failed) return ret2;

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
    // ATL_ANTLR3.g:436:1: ifStat returns [Object ret2] : ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) ) ;
    public final Object ifStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IfStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:437:2: ( ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) ) )
            // ATL_ANTLR3.g:437:4: ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) )
            {
            // ATL_ANTLR3.g:437:4: ( 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () ) )
            // ATL_ANTLR3.g:437:5: 'if' LPAREN temp= oclExpression RPAREN ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )
            {
            match(input,69,FOLLOW_69_in_ifStat2847); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_ifStat2849); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_ifStat2853);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "condition", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ifStat2857); if (failed) return ret2;
            // ATL_ANTLR3.g:437:77: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=NAME && LA71_0<=FLOAT)||LA71_0==LPAREN||LA71_0==SHARP||LA71_0==MINUS||LA71_0==69||LA71_0==71||(LA71_0>=73 && LA71_0<=75)||(LA71_0>=78 && LA71_0<=94)) ) {
                alt71=1;
            }
            else if ( (LA71_0==LCURLY) ) {
                alt71=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("437:77: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ATL_ANTLR3.g:437:78: ( ( (temp= statement ) ) )
                    {
                    // ATL_ANTLR3.g:437:78: ( ( (temp= statement ) ) )
                    // ATL_ANTLR3.g:437:79: ( (temp= statement ) )
                    {
                    // ATL_ANTLR3.g:437:79: ( (temp= statement ) )
                    // ATL_ANTLR3.g:437:80: (temp= statement )
                    {
                    // ATL_ANTLR3.g:437:80: (temp= statement )
                    // ATL_ANTLR3.g:437:81: temp= statement
                    {
                    pushFollow(FOLLOW_statement_in_ifStat2865);
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
                    // ATL_ANTLR3.g:437:142: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    {
                    // ATL_ANTLR3.g:437:142: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    // ATL_ANTLR3.g:437:143: LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
                    {
                    match(input,LCURLY,FOLLOW_LCURLY_in_ifStat2876); if (failed) return ret2;
                    // ATL_ANTLR3.g:437:150: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
                    // ATL_ANTLR3.g:437:151: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:437:151: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    // ATL_ANTLR3.g:437:152: ( (temp= statement ( (temp= statement ) )* ) )?
                    {
                    // ATL_ANTLR3.g:437:152: ( (temp= statement ( (temp= statement ) )* ) )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( ((LA70_0>=NAME && LA70_0<=FLOAT)||LA70_0==LPAREN||LA70_0==SHARP||LA70_0==MINUS||LA70_0==69||LA70_0==71||(LA70_0>=73 && LA70_0<=75)||(LA70_0>=78 && LA70_0<=94)) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // ATL_ANTLR3.g:437:153: (temp= statement ( (temp= statement ) )* )
                            {
                            // ATL_ANTLR3.g:437:153: (temp= statement ( (temp= statement ) )* )
                            // ATL_ANTLR3.g:437:154: temp= statement ( (temp= statement ) )*
                            {
                            pushFollow(FOLLOW_statement_in_ifStat2884);
                            temp=statement();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "thenStatements", temp);
                            }
                            // ATL_ANTLR3.g:437:208: ( (temp= statement ) )*
                            loop69:
                            do {
                                int alt69=2;
                                int LA69_0 = input.LA(1);

                                if ( ((LA69_0>=NAME && LA69_0<=FLOAT)||LA69_0==LPAREN||LA69_0==SHARP||LA69_0==MINUS||LA69_0==69||LA69_0==71||(LA69_0>=73 && LA69_0<=75)||(LA69_0>=78 && LA69_0<=94)) ) {
                                    alt69=1;
                                }


                                switch (alt69) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:437:209: (temp= statement )
                            	    {
                            	    // ATL_ANTLR3.g:437:209: (temp= statement )
                            	    // ATL_ANTLR3.g:437:210: temp= statement
                            	    {
                            	    pushFollow(FOLLOW_statement_in_ifStat2892);
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
                            	    break loop69;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_ifStat2904); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:437:284: ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==70) ) {
                int LA75_1 = input.LA(2);

                if ( (synpred135()) ) {
                    alt75=1;
                }
                else if ( (true) ) {
                    alt75=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("437:284: ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )", 75, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA75_0==EOF||(LA75_0>=NAME && LA75_0<=FLOAT)||LA75_0==LPAREN||LA75_0==RCURLY||LA75_0==SHARP||LA75_0==MINUS||LA75_0==69||LA75_0==71||(LA75_0>=73 && LA75_0<=75)||(LA75_0>=78 && LA75_0<=94)) ) {
                alt75=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("437:284: ( ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) ) | () )", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ATL_ANTLR3.g:437:285: ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) )
                    {
                    // ATL_ANTLR3.g:437:285: ( 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ) )
                    // ATL_ANTLR3.g:437:286: 'else' ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
                    {
                    match(input,70,FOLLOW_70_in_ifStat2912); if (failed) return ret2;
                    // ATL_ANTLR3.g:437:293: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( ((LA74_0>=NAME && LA74_0<=FLOAT)||LA74_0==LPAREN||LA74_0==SHARP||LA74_0==MINUS||LA74_0==69||LA74_0==71||(LA74_0>=73 && LA74_0<=75)||(LA74_0>=78 && LA74_0<=94)) ) {
                        alt74=1;
                    }
                    else if ( (LA74_0==LCURLY) ) {
                        alt74=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("437:293: ( ( ( (temp= statement ) ) ) | ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )", 74, 0, input);

                        throw nvae;
                    }
                    switch (alt74) {
                        case 1 :
                            // ATL_ANTLR3.g:437:294: ( ( (temp= statement ) ) )
                            {
                            // ATL_ANTLR3.g:437:294: ( ( (temp= statement ) ) )
                            // ATL_ANTLR3.g:437:295: ( (temp= statement ) )
                            {
                            // ATL_ANTLR3.g:437:295: ( (temp= statement ) )
                            // ATL_ANTLR3.g:437:296: (temp= statement )
                            {
                            // ATL_ANTLR3.g:437:296: (temp= statement )
                            // ATL_ANTLR3.g:437:297: temp= statement
                            {
                            pushFollow(FOLLOW_statement_in_ifStat2920);
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
                            // ATL_ANTLR3.g:437:358: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                            {
                            // ATL_ANTLR3.g:437:358: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                            // ATL_ANTLR3.g:437:359: LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
                            {
                            match(input,LCURLY,FOLLOW_LCURLY_in_ifStat2931); if (failed) return ret2;
                            // ATL_ANTLR3.g:437:366: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
                            // ATL_ANTLR3.g:437:367: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                            {
                            // ATL_ANTLR3.g:437:367: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                            // ATL_ANTLR3.g:437:368: ( (temp= statement ( (temp= statement ) )* ) )?
                            {
                            // ATL_ANTLR3.g:437:368: ( (temp= statement ( (temp= statement ) )* ) )?
                            int alt73=2;
                            int LA73_0 = input.LA(1);

                            if ( ((LA73_0>=NAME && LA73_0<=FLOAT)||LA73_0==LPAREN||LA73_0==SHARP||LA73_0==MINUS||LA73_0==69||LA73_0==71||(LA73_0>=73 && LA73_0<=75)||(LA73_0>=78 && LA73_0<=94)) ) {
                                alt73=1;
                            }
                            switch (alt73) {
                                case 1 :
                                    // ATL_ANTLR3.g:437:369: (temp= statement ( (temp= statement ) )* )
                                    {
                                    // ATL_ANTLR3.g:437:369: (temp= statement ( (temp= statement ) )* )
                                    // ATL_ANTLR3.g:437:370: temp= statement ( (temp= statement ) )*
                                    {
                                    pushFollow(FOLLOW_statement_in_ifStat2939);
                                    temp=statement();
                                    _fsp--;
                                    if (failed) return ret2;
                                    if ( backtracking==0 ) {
                                      ei.set(ret, "elseStatements", temp);
                                    }
                                    // ATL_ANTLR3.g:437:424: ( (temp= statement ) )*
                                    loop72:
                                    do {
                                        int alt72=2;
                                        int LA72_0 = input.LA(1);

                                        if ( ((LA72_0>=NAME && LA72_0<=FLOAT)||LA72_0==LPAREN||LA72_0==SHARP||LA72_0==MINUS||LA72_0==69||LA72_0==71||(LA72_0>=73 && LA72_0<=75)||(LA72_0>=78 && LA72_0<=94)) ) {
                                            alt72=1;
                                        }


                                        switch (alt72) {
                                    	case 1 :
                                    	    // ATL_ANTLR3.g:437:425: (temp= statement )
                                    	    {
                                    	    // ATL_ANTLR3.g:437:425: (temp= statement )
                                    	    // ATL_ANTLR3.g:437:426: temp= statement
                                    	    {
                                    	    pushFollow(FOLLOW_statement_in_ifStat2947);
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
                                    	    break loop72;
                                        }
                                    } while (true);


                                    }


                                    }
                                    break;

                            }


                            }


                            }

                            match(input,RCURLY,FOLLOW_RCURLY_in_ifStat2959); if (failed) return ret2;

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
                    // ATL_ANTLR3.g:437:505: ()
                    {
                    // ATL_ANTLR3.g:437:505: ()
                    // ATL_ANTLR3.g:437:506: 
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
    // ATL_ANTLR3.g:447:1: forStat returns [Object ret2] : ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object forStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ForStat", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:448:2: ( ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ATL_ANTLR3.g:448:4: ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ATL_ANTLR3.g:448:4: ( 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ATL_ANTLR3.g:448:5: 'for' LPAREN temp= iterator 'in' temp= oclExpression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,71,FOLLOW_71_in_forStat3005); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_forStat3007); if (failed) return ret2;
            pushFollow(FOLLOW_iterator_in_forStat3011);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterator", temp);
            }
            match(input,62,FOLLOW_62_in_forStat3015); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_forStat3019);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "collection", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_forStat3023); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_forStat3025); if (failed) return ret2;
            // ATL_ANTLR3.g:448:138: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ATL_ANTLR3.g:448:139: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ATL_ANTLR3.g:448:139: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ATL_ANTLR3.g:448:140: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ATL_ANTLR3.g:448:140: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=NAME && LA77_0<=FLOAT)||LA77_0==LPAREN||LA77_0==SHARP||LA77_0==MINUS||LA77_0==69||LA77_0==71||(LA77_0>=73 && LA77_0<=75)||(LA77_0>=78 && LA77_0<=94)) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ATL_ANTLR3.g:448:141: (temp= statement ( (temp= statement ) )* )
                    {
                    // ATL_ANTLR3.g:448:141: (temp= statement ( (temp= statement ) )* )
                    // ATL_ANTLR3.g:448:142: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_forStat3033);
                    temp=statement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "statements", temp);
                    }
                    // ATL_ANTLR3.g:448:192: ( (temp= statement ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( ((LA76_0>=NAME && LA76_0<=FLOAT)||LA76_0==LPAREN||LA76_0==SHARP||LA76_0==MINUS||LA76_0==69||LA76_0==71||(LA76_0>=73 && LA76_0<=75)||(LA76_0>=78 && LA76_0<=94)) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:448:193: (temp= statement )
                    	    {
                    	    // ATL_ANTLR3.g:448:193: (temp= statement )
                    	    // ATL_ANTLR3.g:448:194: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_forStat3041);
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
                    	    break loop76;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_forStat3053); if (failed) return ret2;

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
    // ATL_ANTLR3.g:458:1: oclModel returns [Object ret2] : (temp= identifier COLON temp= identifier ) ;
    public final Object oclModel() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OclModel", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:459:2: ( (temp= identifier COLON temp= identifier ) )
            // ATL_ANTLR3.g:459:4: (temp= identifier COLON temp= identifier )
            {
            // ATL_ANTLR3.g:459:4: (temp= identifier COLON temp= identifier )
            // ATL_ANTLR3.g:459:5: temp= identifier COLON temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_oclModel3087);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_oclModel3091); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_oclModel3095);
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
    // ATL_ANTLR3.g:469:1: oclModelElement returns [Object ret2] : (temp= identifier EXCL temp= identifier ) ;
    public final Object oclModelElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OclModelElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:470:2: ( (temp= identifier EXCL temp= identifier ) )
            // ATL_ANTLR3.g:470:4: (temp= identifier EXCL temp= identifier )
            {
            // ATL_ANTLR3.g:470:4: (temp= identifier EXCL temp= identifier )
            // ATL_ANTLR3.g:470:5: temp= identifier EXCL temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_oclModelElement3131);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.setRef(ret, "model", "OclModel", "name", temp, "#all", "ifmissing", null, false, null);
            }
            match(input,EXCL,FOLLOW_EXCL_in_oclModelElement3135); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_oclModelElement3139);
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
    // ATL_ANTLR3.g:480:1: oclExpression returns [Object ret2] : (ret= priority_5 | ret= letExp ) ;
    public final Object oclExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:481:2: ( (ret= priority_5 | ret= letExp ) )
            // ATL_ANTLR3.g:481:4: (ret= priority_5 | ret= letExp )
            {
            // ATL_ANTLR3.g:481:4: (ret= priority_5 | ret= letExp )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=NAME && LA78_0<=FLOAT)||LA78_0==LPAREN||LA78_0==SHARP||LA78_0==MINUS||LA78_0==69||(LA78_0>=73 && LA78_0<=75)||LA78_0==78||(LA78_0>=80 && LA78_0<=94)) ) {
                alt78=1;
            }
            else if ( (LA78_0==79) ) {
                alt78=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("481:4: (ret= priority_5 | ret= letExp )", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ATL_ANTLR3.g:481:5: ret= priority_5
                    {
                    pushFollow(FOLLOW_priority_5_in_oclExpression3175);
                    ret=priority_5();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:481:21: ret= letExp
                    {
                    pushFollow(FOLLOW_letExp_in_oclExpression3180);
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
    // ATL_ANTLR3.g:488:1: iteratorExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN ) ;
    public final Object iteratorExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IteratorExp", true, false) : null;
        try {
            // ATL_ANTLR3.g:489:2: ( (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN ) )
            // ATL_ANTLR3.g:489:4: (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN )
            {
            // ATL_ANTLR3.g:489:4: (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN )
            // ATL_ANTLR3.g:489:5: temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN
            {
            pushFollow(FOLLOW_identifier_in_iteratorExp3215);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_iteratorExp3219); if (failed) return ret2;
            // ATL_ANTLR3.g:489:57: ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) )
            // ATL_ANTLR3.g:489:58: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            {
            // ATL_ANTLR3.g:489:58: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            // ATL_ANTLR3.g:489:59: temp= iterator ( ( ( COMA ) temp= iterator ) )*
            {
            pushFollow(FOLLOW_iterator_in_iteratorExp3225);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterators", temp);
            }
            // ATL_ANTLR3.g:489:107: ( ( ( COMA ) temp= iterator ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==COMA) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // ATL_ANTLR3.g:489:108: ( ( COMA ) temp= iterator )
            	    {
            	    // ATL_ANTLR3.g:489:108: ( ( COMA ) temp= iterator )
            	    // ATL_ANTLR3.g:489:109: ( COMA ) temp= iterator
            	    {
            	    // ATL_ANTLR3.g:489:109: ( COMA )
            	    // ATL_ANTLR3.g:489:110: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_iteratorExp3232); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_iterator_in_iteratorExp3237);
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
            	    break loop79;
                }
            } while (true);


            }


            }

            match(input,PIPE,FOLLOW_PIPE_in_iteratorExp3246); if (failed) return ret2;
            // ATL_ANTLR3.g:489:174: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:489:175: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:489:175: (temp= oclExpression )
            // ATL_ANTLR3.g:489:176: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_iteratorExp3252);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "body", temp);
            }

            }


            }

            match(input,RPAREN,FOLLOW_RPAREN_in_iteratorExp3258); if (failed) return ret2;

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
    // ATL_ANTLR3.g:501:1: iterateExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN ) ;
    public final Object iterateExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IterateExp", true, false) : null;
        try {
            // ATL_ANTLR3.g:502:2: ( ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN ) )
            // ATL_ANTLR3.g:502:4: ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN )
            {
            // ATL_ANTLR3.g:502:4: ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN )
            // ATL_ANTLR3.g:502:5: 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN
            {
            match(input,72,FOLLOW_72_in_iterateExp3291); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_iterateExp3293); if (failed) return ret2;
            // ATL_ANTLR3.g:502:22: ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) )
            // ATL_ANTLR3.g:502:23: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            {
            // ATL_ANTLR3.g:502:23: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            // ATL_ANTLR3.g:502:24: temp= iterator ( ( ( COMA ) temp= iterator ) )*
            {
            pushFollow(FOLLOW_iterator_in_iterateExp3299);
            temp=iterator();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "iterators", temp);
            }
            // ATL_ANTLR3.g:502:72: ( ( ( COMA ) temp= iterator ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==COMA) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // ATL_ANTLR3.g:502:73: ( ( COMA ) temp= iterator )
            	    {
            	    // ATL_ANTLR3.g:502:73: ( ( COMA ) temp= iterator )
            	    // ATL_ANTLR3.g:502:74: ( COMA ) temp= iterator
            	    {
            	    // ATL_ANTLR3.g:502:74: ( COMA )
            	    // ATL_ANTLR3.g:502:75: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_iterateExp3306); if (failed) return ret2;

            	    }

            	    pushFollow(FOLLOW_iterator_in_iterateExp3311);
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
            	    break loop80;
                }
            } while (true);


            }


            }

            match(input,SEMI,FOLLOW_SEMI_in_iterateExp3320); if (failed) return ret2;
            pushFollow(FOLLOW_variableDeclaration_in_iterateExp3324);
            temp=variableDeclaration();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "result", temp);
            }
            match(input,PIPE,FOLLOW_PIPE_in_iterateExp3328); if (failed) return ret2;
            // ATL_ANTLR3.g:502:200: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:502:201: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:502:201: (temp= oclExpression )
            // ATL_ANTLR3.g:502:202: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_iterateExp3334);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "body", temp);
            }

            }


            }

            match(input,RPAREN,FOLLOW_RPAREN_in_iterateExp3340); if (failed) return ret2;

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
    // ATL_ANTLR3.g:514:1: collectionOperationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) ;
    public final Object collectionOperationCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CollectionOperationCallExp", false, false) : null;
        try {
            // ATL_ANTLR3.g:515:2: ( (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) )
            // ATL_ANTLR3.g:515:4: (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            {
            // ATL_ANTLR3.g:515:4: (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            // ATL_ANTLR3.g:515:5: temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifier_in_collectionOperationCallExp3375);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "operationName", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_collectionOperationCallExp3379); if (failed) return ret2;
            // ATL_ANTLR3.g:515:66: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=NAME && LA82_0<=FLOAT)||LA82_0==LPAREN||LA82_0==SHARP||LA82_0==MINUS||LA82_0==69||(LA82_0>=73 && LA82_0<=75)||(LA82_0>=78 && LA82_0<=94)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ATL_ANTLR3.g:515:67: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:515:67: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:515:68: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_collectionOperationCallExp3385);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "arguments", temp);
                    }
                    // ATL_ANTLR3.g:515:121: ( ( ( COMA ) temp= oclExpression ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==COMA) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:515:122: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:515:122: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:515:123: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:515:123: ( COMA )
                    	    // ATL_ANTLR3.g:515:124: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_collectionOperationCallExp3392); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_collectionOperationCallExp3397);
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

            match(input,RPAREN,FOLLOW_RPAREN_in_collectionOperationCallExp3407); if (failed) return ret2;

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
    // ATL_ANTLR3.g:527:1: operationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) ;
    public final Object operationCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OperationCallExp", false, false) : null;
        try {
            // ATL_ANTLR3.g:528:2: ( (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) )
            // ATL_ANTLR3.g:528:4: (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            {
            // ATL_ANTLR3.g:528:4: (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            // ATL_ANTLR3.g:528:5: temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_operationCallExp3442);
            temp=identifierOrKeyword();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "operationName", temp);
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_operationCallExp3446); if (failed) return ret2;
            // ATL_ANTLR3.g:528:75: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=NAME && LA84_0<=FLOAT)||LA84_0==LPAREN||LA84_0==SHARP||LA84_0==MINUS||LA84_0==69||(LA84_0>=73 && LA84_0<=75)||(LA84_0>=78 && LA84_0<=94)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ATL_ANTLR3.g:528:76: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:528:76: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:528:77: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_operationCallExp3452);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "arguments", temp);
                    }
                    // ATL_ANTLR3.g:528:130: ( ( ( COMA ) temp= oclExpression ) )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==COMA) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:528:131: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:528:131: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:528:132: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:528:132: ( COMA )
                    	    // ATL_ANTLR3.g:528:133: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_operationCallExp3459); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_operationCallExp3464);
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
                    	    break loop83;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_operationCallExp3474); if (failed) return ret2;

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
    // ATL_ANTLR3.g:540:1: navigationOrAttributeCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword ) ;
    public final Object navigationOrAttributeCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("NavigationOrAttributeCallExp", false, false) : null;
        try {
            // ATL_ANTLR3.g:541:2: ( (temp= identifierOrKeyword ) )
            // ATL_ANTLR3.g:541:4: (temp= identifierOrKeyword )
            {
            // ATL_ANTLR3.g:541:4: (temp= identifierOrKeyword )
            // ATL_ANTLR3.g:541:5: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_navigationOrAttributeCallExp3509);
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
    // ATL_ANTLR3.g:553:1: operatorCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object operatorCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OperatorCallExp", false, false) : null;
        try {
            // ATL_ANTLR3.g:554:2: ()
            // ATL_ANTLR3.g:555:9: 
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
    // ATL_ANTLR3.g:565:1: iterator returns [Object ret2] : (temp= identifier ) ;
    public final Object iterator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Iterator", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:566:2: ( (temp= identifier ) )
            // ATL_ANTLR3.g:566:4: (temp= identifier )
            {
            // ATL_ANTLR3.g:566:4: (temp= identifier )
            // ATL_ANTLR3.g:566:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_iterator3574);
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
    // ATL_ANTLR3.g:576:1: oclUndefinedExp returns [Object ret2] : ( 'OclUndefined' ) ;
    public final Object oclUndefinedExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclUndefinedExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:577:2: ( ( 'OclUndefined' ) )
            // ATL_ANTLR3.g:577:4: ( 'OclUndefined' )
            {
            // ATL_ANTLR3.g:577:4: ( 'OclUndefined' )
            // ATL_ANTLR3.g:577:5: 'OclUndefined'
            {
            match(input,73,FOLLOW_73_in_oclUndefinedExp3608); if (failed) return ret2;

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
    // ATL_ANTLR3.g:587:1: primitiveExp returns [Object ret2] : ( (ret= numericExp | ret= booleanExp | ret= stringExp ) ) ;
    public final Object primitiveExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:588:2: ( ( (ret= numericExp | ret= booleanExp | ret= stringExp ) ) )
            // ATL_ANTLR3.g:588:4: ( (ret= numericExp | ret= booleanExp | ret= stringExp ) )
            {
            // ATL_ANTLR3.g:588:4: ( (ret= numericExp | ret= booleanExp | ret= stringExp ) )
            // ATL_ANTLR3.g:588:5: (ret= numericExp | ret= booleanExp | ret= stringExp )
            {
            // ATL_ANTLR3.g:588:5: (ret= numericExp | ret= booleanExp | ret= stringExp )
            int alt85=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
                {
                alt85=1;
                }
                break;
            case 74:
            case 75:
                {
                alt85=2;
                }
                break;
            case STRING:
                {
                alt85=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("588:5: (ret= numericExp | ret= booleanExp | ret= stringExp )", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // ATL_ANTLR3.g:588:6: ret= numericExp
                    {
                    pushFollow(FOLLOW_numericExp_in_primitiveExp3643);
                    ret=numericExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:588:22: ret= booleanExp
                    {
                    pushFollow(FOLLOW_booleanExp_in_primitiveExp3648);
                    ret=booleanExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:588:38: ret= stringExp
                    {
                    pushFollow(FOLLOW_stringExp_in_primitiveExp3653);
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
    // ATL_ANTLR3.g:596:1: numericExp returns [Object ret2] : ( (ret= integerExp | ret= realExp ) ) ;
    public final Object numericExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:597:2: ( ( (ret= integerExp | ret= realExp ) ) )
            // ATL_ANTLR3.g:597:4: ( (ret= integerExp | ret= realExp ) )
            {
            // ATL_ANTLR3.g:597:4: ( (ret= integerExp | ret= realExp ) )
            // ATL_ANTLR3.g:597:5: (ret= integerExp | ret= realExp )
            {
            // ATL_ANTLR3.g:597:5: (ret= integerExp | ret= realExp )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==INT) ) {
                alt86=1;
            }
            else if ( (LA86_0==FLOAT) ) {
                alt86=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("597:5: (ret= integerExp | ret= realExp )", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // ATL_ANTLR3.g:597:6: ret= integerExp
                    {
                    pushFollow(FOLLOW_integerExp_in_numericExp3689);
                    ret=integerExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:597:22: ret= realExp
                    {
                    pushFollow(FOLLOW_realExp_in_numericExp3694);
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
    // ATL_ANTLR3.g:605:1: booleanExp returns [Object ret2] : ( ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object booleanExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("BooleanExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:606:2: ( ( ( ( 'true' ) | ( 'false' ) ) ) )
            // ATL_ANTLR3.g:606:4: ( ( ( 'true' ) | ( 'false' ) ) )
            {
            // ATL_ANTLR3.g:606:4: ( ( ( 'true' ) | ( 'false' ) ) )
            // ATL_ANTLR3.g:606:5: ( ( 'true' ) | ( 'false' ) )
            {
            // ATL_ANTLR3.g:606:5: ( ( 'true' ) | ( 'false' ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==74) ) {
                alt87=1;
            }
            else if ( (LA87_0==75) ) {
                alt87=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("606:5: ( ( 'true' ) | ( 'false' ) )", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ATL_ANTLR3.g:606:6: ( 'true' )
                    {
                    // ATL_ANTLR3.g:606:6: ( 'true' )
                    // ATL_ANTLR3.g:606:7: 'true'
                    {
                    match(input,74,FOLLOW_74_in_booleanExp3729); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "booleanSymbol", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:606:72: ( 'false' )
                    {
                    // ATL_ANTLR3.g:606:72: ( 'false' )
                    // ATL_ANTLR3.g:606:73: 'false'
                    {
                    match(input,75,FOLLOW_75_in_booleanExp3736); if (failed) return ret2;

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
    // ATL_ANTLR3.g:616:1: integerExp returns [Object ret2] : (temp= integerSymbol ) ;
    public final Object integerExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IntegerExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:617:2: ( (temp= integerSymbol ) )
            // ATL_ANTLR3.g:617:4: (temp= integerSymbol )
            {
            // ATL_ANTLR3.g:617:4: (temp= integerSymbol )
            // ATL_ANTLR3.g:617:5: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_integerExp3774);
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
    // ATL_ANTLR3.g:627:1: realExp returns [Object ret2] : (temp= floatSymbol ) ;
    public final Object realExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("RealExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:628:2: ( (temp= floatSymbol ) )
            // ATL_ANTLR3.g:628:4: (temp= floatSymbol )
            {
            // ATL_ANTLR3.g:628:4: (temp= floatSymbol )
            // ATL_ANTLR3.g:628:5: temp= floatSymbol
            {
            pushFollow(FOLLOW_floatSymbol_in_realExp3810);
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
    // ATL_ANTLR3.g:638:1: stringExp returns [Object ret2] : (temp= stringSymbol ) ;
    public final Object stringExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("StringExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:639:2: ( (temp= stringSymbol ) )
            // ATL_ANTLR3.g:639:4: (temp= stringSymbol )
            {
            // ATL_ANTLR3.g:639:4: (temp= stringSymbol )
            // ATL_ANTLR3.g:639:5: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_stringExp3846);
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
    // ATL_ANTLR3.g:649:1: ifExp returns [Object ret2] : ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' ) ;
    public final Object ifExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IfExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:650:2: ( ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' ) )
            // ATL_ANTLR3.g:650:4: ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' )
            {
            // ATL_ANTLR3.g:650:4: ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' )
            // ATL_ANTLR3.g:650:5: 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif'
            {
            match(input,69,FOLLOW_69_in_ifExp3880); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_ifExp3884);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "condition", temp);
            }
            match(input,76,FOLLOW_76_in_ifExp3888); if (failed) return ret2;
            // ATL_ANTLR3.g:650:70: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:650:71: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:650:71: (temp= oclExpression )
            // ATL_ANTLR3.g:650:72: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_ifExp3894);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "thenExpression", temp);
            }

            }


            }

            match(input,70,FOLLOW_70_in_ifExp3900); if (failed) return ret2;
            // ATL_ANTLR3.g:650:139: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:650:140: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:650:140: (temp= oclExpression )
            // ATL_ANTLR3.g:650:141: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_ifExp3906);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elseExpression", temp);
            }

            }


            }

            match(input,77,FOLLOW_77_in_ifExp3912); if (failed) return ret2;

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
    // ATL_ANTLR3.g:660:1: variableExp returns [Object ret2] : (temp= identifier ) ;
    public final Object variableExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:661:2: ( (temp= identifier ) )
            // ATL_ANTLR3.g:661:4: (temp= identifier )
            {
            // ATL_ANTLR3.g:661:4: (temp= identifier )
            // ATL_ANTLR3.g:661:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_variableExp3946);
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
    // ATL_ANTLR3.g:671:1: superExp returns [Object ret2] : ( 'super' ) ;
    public final Object superExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("SuperExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:672:2: ( ( 'super' ) )
            // ATL_ANTLR3.g:672:4: ( 'super' )
            {
            // ATL_ANTLR3.g:672:4: ( 'super' )
            // ATL_ANTLR3.g:672:5: 'super'
            {
            match(input,78,FOLLOW_78_in_superExp3980); if (failed) return ret2;

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
    // ATL_ANTLR3.g:682:1: letExp returns [Object ret2] : ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) ) ;
    public final Object letExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LetExp", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:683:2: ( ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) ) )
            // ATL_ANTLR3.g:683:4: ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) )
            {
            // ATL_ANTLR3.g:683:4: ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) )
            // ATL_ANTLR3.g:683:5: 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) )
            {
            match(input,79,FOLLOW_79_in_letExp4012); if (failed) return ret2;
            pushFollow(FOLLOW_variableDeclaration_in_letExp4016);
            temp=variableDeclaration();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "variable", temp);
            }
            match(input,62,FOLLOW_62_in_letExp4020); if (failed) return ret2;
            // ATL_ANTLR3.g:683:74: ( (temp= oclExpression ) )
            // ATL_ANTLR3.g:683:75: (temp= oclExpression )
            {
            // ATL_ANTLR3.g:683:75: (temp= oclExpression )
            // ATL_ANTLR3.g:683:76: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_letExp4026);
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
    // ATL_ANTLR3.g:693:1: variableDeclaration returns [Object ret2] : (temp= identifier COLON temp= oclType EQ temp= oclExpression ) ;
    public final Object variableDeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:694:2: ( (temp= identifier COLON temp= oclType EQ temp= oclExpression ) )
            // ATL_ANTLR3.g:694:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression )
            {
            // ATL_ANTLR3.g:694:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression )
            // ATL_ANTLR3.g:694:5: temp= identifier COLON temp= oclType EQ temp= oclExpression
            {
            pushFollow(FOLLOW_identifier_in_variableDeclaration4064);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_variableDeclaration4068); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_variableDeclaration4072);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "type", temp);
            }
            match(input,EQ,FOLLOW_EQ_in_variableDeclaration4076); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_variableDeclaration4080);
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
    // ATL_ANTLR3.g:704:1: enumLiteralExp returns [Object ret2] : ( SHARP temp= identifier ) ;
    public final Object enumLiteralExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("EnumLiteralExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:705:2: ( ( SHARP temp= identifier ) )
            // ATL_ANTLR3.g:705:4: ( SHARP temp= identifier )
            {
            // ATL_ANTLR3.g:705:4: ( SHARP temp= identifier )
            // ATL_ANTLR3.g:705:5: SHARP temp= identifier
            {
            match(input,SHARP,FOLLOW_SHARP_in_enumLiteralExp4114); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_enumLiteralExp4118);
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
    // ATL_ANTLR3.g:715:1: collectionExp returns [Object ret2] : ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) ) ;
    public final Object collectionExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:716:2: ( ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) ) )
            // ATL_ANTLR3.g:716:4: ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) )
            {
            // ATL_ANTLR3.g:716:4: ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) )
            // ATL_ANTLR3.g:716:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )
            {
            // ATL_ANTLR3.g:716:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )
            int alt88=4;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt88=1;
                }
                break;
            case 81:
                {
                alt88=2;
                }
                break;
            case 82:
                {
                alt88=3;
                }
                break;
            case 83:
                {
                alt88=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("716:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ATL_ANTLR3.g:716:6: ret= bagExp
                    {
                    pushFollow(FOLLOW_bagExp_in_collectionExp4155);
                    ret=bagExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:716:18: ret= setExp
                    {
                    pushFollow(FOLLOW_setExp_in_collectionExp4160);
                    ret=setExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:716:30: ret= orderedSetExp
                    {
                    pushFollow(FOLLOW_orderedSetExp_in_collectionExp4165);
                    ret=orderedSetExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:716:49: ret= sequenceExp
                    {
                    pushFollow(FOLLOW_sequenceExp_in_collectionExp4170);
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
    // ATL_ANTLR3.g:724:1: bagExp returns [Object ret2] : ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object bagExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BagExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:725:2: ( ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:725:4: ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:725:4: ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:725:5: 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,80,FOLLOW_80_in_bagExp4203); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_bagExp4205); if (failed) return ret2;
            // ATL_ANTLR3.g:725:18: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=NAME && LA90_0<=FLOAT)||LA90_0==LPAREN||LA90_0==SHARP||LA90_0==MINUS||LA90_0==69||(LA90_0>=73 && LA90_0<=75)||(LA90_0>=78 && LA90_0<=94)) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ATL_ANTLR3.g:725:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:725:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:725:20: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_bagExp4211);
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
                    	    match(input,COMA,FOLLOW_COMA_in_bagExp4218); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_bagExp4223);
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

            match(input,RCURLY,FOLLOW_RCURLY_in_bagExp4233); if (failed) return ret2;

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
    // ATL_ANTLR3.g:735:1: setExp returns [Object ret2] : ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object setExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SetExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:736:2: ( ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:736:4: ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:736:4: ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:736:5: 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,81,FOLLOW_81_in_setExp4265); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_setExp4267); if (failed) return ret2;
            // ATL_ANTLR3.g:736:18: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( ((LA92_0>=NAME && LA92_0<=FLOAT)||LA92_0==LPAREN||LA92_0==SHARP||LA92_0==MINUS||LA92_0==69||(LA92_0>=73 && LA92_0<=75)||(LA92_0>=78 && LA92_0<=94)) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ATL_ANTLR3.g:736:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:736:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:736:20: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_setExp4273);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:736:72: ( ( ( COMA ) temp= oclExpression ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==COMA) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:736:73: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:736:73: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:736:74: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:736:74: ( COMA )
                    	    // ATL_ANTLR3.g:736:75: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_setExp4280); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_setExp4285);
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

            match(input,RCURLY,FOLLOW_RCURLY_in_setExp4295); if (failed) return ret2;

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
    // ATL_ANTLR3.g:746:1: orderedSetExp returns [Object ret2] : ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object orderedSetExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OrderedSetExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:747:2: ( ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:747:4: ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:747:4: ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:747:5: 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,82,FOLLOW_82_in_orderedSetExp4327); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_orderedSetExp4329); if (failed) return ret2;
            // ATL_ANTLR3.g:747:25: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( ((LA94_0>=NAME && LA94_0<=FLOAT)||LA94_0==LPAREN||LA94_0==SHARP||LA94_0==MINUS||LA94_0==69||(LA94_0>=73 && LA94_0<=75)||(LA94_0>=78 && LA94_0<=94)) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ATL_ANTLR3.g:747:26: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:747:26: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:747:27: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_orderedSetExp4335);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:747:79: ( ( ( COMA ) temp= oclExpression ) )*
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==COMA) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:747:80: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:747:80: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:747:81: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:747:81: ( COMA )
                    	    // ATL_ANTLR3.g:747:82: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_orderedSetExp4342); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_orderedSetExp4347);
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

            match(input,RCURLY,FOLLOW_RCURLY_in_orderedSetExp4357); if (failed) return ret2;

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
    // ATL_ANTLR3.g:757:1: sequenceExp returns [Object ret2] : ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object sequenceExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SequenceExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:758:2: ( ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:758:4: ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:758:4: ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:758:5: 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,83,FOLLOW_83_in_sequenceExp4389); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_sequenceExp4391); if (failed) return ret2;
            // ATL_ANTLR3.g:758:23: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( ((LA96_0>=NAME && LA96_0<=FLOAT)||LA96_0==LPAREN||LA96_0==SHARP||LA96_0==MINUS||LA96_0==69||(LA96_0>=73 && LA96_0<=75)||(LA96_0>=78 && LA96_0<=94)) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ATL_ANTLR3.g:758:24: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // ATL_ANTLR3.g:758:24: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // ATL_ANTLR3.g:758:25: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_sequenceExp4397);
                    temp=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:758:77: ( ( ( COMA ) temp= oclExpression ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==COMA) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:758:78: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // ATL_ANTLR3.g:758:78: ( ( COMA ) temp= oclExpression )
                    	    // ATL_ANTLR3.g:758:79: ( COMA ) temp= oclExpression
                    	    {
                    	    // ATL_ANTLR3.g:758:79: ( COMA )
                    	    // ATL_ANTLR3.g:758:80: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_sequenceExp4404); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_sequenceExp4409);
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
                    	    break loop95;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_sequenceExp4419); if (failed) return ret2;

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
    // ATL_ANTLR3.g:768:1: mapExp returns [Object ret2] : ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY ) ;
    public final Object mapExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:769:2: ( ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:769:4: ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:769:4: ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:769:5: 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY
            {
            match(input,84,FOLLOW_84_in_mapExp4451); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_mapExp4453); if (failed) return ret2;
            // ATL_ANTLR3.g:769:18: ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==LPAREN) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ATL_ANTLR3.g:769:19: (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* )
                    {
                    // ATL_ANTLR3.g:769:19: (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* )
                    // ATL_ANTLR3.g:769:20: temp= mapElement ( ( ( COMA ) temp= mapElement ) )*
                    {
                    pushFollow(FOLLOW_mapElement_in_mapExp4459);
                    temp=mapElement();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "elements", temp);
                    }
                    // ATL_ANTLR3.g:769:69: ( ( ( COMA ) temp= mapElement ) )*
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==COMA) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:769:70: ( ( COMA ) temp= mapElement )
                    	    {
                    	    // ATL_ANTLR3.g:769:70: ( ( COMA ) temp= mapElement )
                    	    // ATL_ANTLR3.g:769:71: ( COMA ) temp= mapElement
                    	    {
                    	    // ATL_ANTLR3.g:769:71: ( COMA )
                    	    // ATL_ANTLR3.g:769:72: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_mapExp4466); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_mapElement_in_mapExp4471);
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
                    	    break loop97;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_mapExp4481); if (failed) return ret2;

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
    // ATL_ANTLR3.g:779:1: mapElement returns [Object ret2] : ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN ) ;
    public final Object mapElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:780:2: ( ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN ) )
            // ATL_ANTLR3.g:780:4: ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN )
            {
            // ATL_ANTLR3.g:780:4: ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN )
            // ATL_ANTLR3.g:780:5: LPAREN temp= oclExpression COMA temp= oclExpression RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_mapElement4513); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_mapElement4517);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "key", temp);
            }
            match(input,COMA,FOLLOW_COMA_in_mapElement4521); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_mapElement4525);
            temp=oclExpression();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "value", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_mapElement4529); if (failed) return ret2;

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
    // ATL_ANTLR3.g:790:1: tupleExp returns [Object ret2] : ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY ) ;
    public final Object tupleExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:791:2: ( ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY ) )
            // ATL_ANTLR3.g:791:4: ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY )
            {
            // ATL_ANTLR3.g:791:4: ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY )
            // ATL_ANTLR3.g:791:5: 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY
            {
            match(input,85,FOLLOW_85_in_tupleExp4561); if (failed) return ret2;
            match(input,LCURLY,FOLLOW_LCURLY_in_tupleExp4563); if (failed) return ret2;
            // ATL_ANTLR3.g:791:20: ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==NAME||(LA100_0>=43 && LA100_0<=100)) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ATL_ANTLR3.g:791:21: (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* )
                    {
                    // ATL_ANTLR3.g:791:21: (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* )
                    // ATL_ANTLR3.g:791:22: temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )*
                    {
                    pushFollow(FOLLOW_tuplePart_in_tupleExp4569);
                    temp=tuplePart();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "tuplePart", temp);
                    }
                    // ATL_ANTLR3.g:791:71: ( ( ( COMA ) temp= tuplePart ) )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==COMA) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:791:72: ( ( COMA ) temp= tuplePart )
                    	    {
                    	    // ATL_ANTLR3.g:791:72: ( ( COMA ) temp= tuplePart )
                    	    // ATL_ANTLR3.g:791:73: ( COMA ) temp= tuplePart
                    	    {
                    	    // ATL_ANTLR3.g:791:73: ( COMA )
                    	    // ATL_ANTLR3.g:791:74: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_tupleExp4576); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_tuplePart_in_tupleExp4581);
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
                    	    break loop99;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_tupleExp4591); if (failed) return ret2;

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
    // ATL_ANTLR3.g:801:1: tuplePart returns [Object ret2] : (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression ) ;
    public final Object tuplePart() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TuplePart", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:802:2: ( (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression ) )
            // ATL_ANTLR3.g:802:4: (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression )
            {
            // ATL_ANTLR3.g:802:4: (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression )
            // ATL_ANTLR3.g:802:5: temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tuplePart4625);
            temp=identifierOrKeyword();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "varName", temp);
            }
            // ATL_ANTLR3.g:802:62: ( ( COLON temp= oclType ) | () )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==COLON) ) {
                alt101=1;
            }
            else if ( (LA101_0==EQ) ) {
                alt101=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("802:62: ( ( COLON temp= oclType ) | () )", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // ATL_ANTLR3.g:802:63: ( COLON temp= oclType )
                    {
                    // ATL_ANTLR3.g:802:63: ( COLON temp= oclType )
                    // ATL_ANTLR3.g:802:64: COLON temp= oclType
                    {
                    match(input,COLON,FOLLOW_COLON_in_tuplePart4631); if (failed) return ret2;
                    pushFollow(FOLLOW_oclType_in_tuplePart4635);
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
                    // ATL_ANTLR3.g:802:117: ()
                    {
                    // ATL_ANTLR3.g:802:117: ()
                    // ATL_ANTLR3.g:802:118: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            match(input,EQ,FOLLOW_EQ_in_tuplePart4649); if (failed) return ret2;
            pushFollow(FOLLOW_oclExpression_in_tuplePart4653);
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
    // ATL_ANTLR3.g:812:1: oclType returns [Object ret2] : ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) ) ;
    public final Object oclType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:813:2: ( ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) ) )
            // ATL_ANTLR3.g:813:4: ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) )
            {
            // ATL_ANTLR3.g:813:4: ( (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) )
            // ATL_ANTLR3.g:813:5: (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )
            {
            // ATL_ANTLR3.g:813:5: (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )
            int alt102=7;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt102=1;
                }
                break;
            case 87:
                {
                alt102=2;
                }
                break;
            case 88:
                {
                alt102=3;
                }
                break;
            case 84:
                {
                alt102=4;
                }
                break;
            case 89:
            case 90:
            case 91:
            case 92:
                {
                alt102=5;
                }
                break;
            case 80:
            case 81:
            case 82:
            case 83:
            case 93:
                {
                alt102=6;
                }
                break;
            case 86:
                {
                alt102=7;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("813:5: (ret= oclModelElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // ATL_ANTLR3.g:813:6: ret= oclModelElement
                    {
                    pushFollow(FOLLOW_oclModelElement_in_oclType4690);
                    ret=oclModelElement();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:813:27: ret= oclAnyType
                    {
                    pushFollow(FOLLOW_oclAnyType_in_oclType4695);
                    ret=oclAnyType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:813:43: ret= tupleType
                    {
                    pushFollow(FOLLOW_tupleType_in_oclType4700);
                    ret=tupleType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:813:58: ret= mapType
                    {
                    pushFollow(FOLLOW_mapType_in_oclType4705);
                    ret=mapType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 5 :
                    // ATL_ANTLR3.g:813:71: ret= primitive
                    {
                    pushFollow(FOLLOW_primitive_in_oclType4710);
                    ret=primitive();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 6 :
                    // ATL_ANTLR3.g:813:86: ret= collectionType
                    {
                    pushFollow(FOLLOW_collectionType_in_oclType4715);
                    ret=collectionType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 7 :
                    // ATL_ANTLR3.g:813:106: ret= oclType_abstractContents
                    {
                    pushFollow(FOLLOW_oclType_abstractContents_in_oclType4720);
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
    // ATL_ANTLR3.g:821:1: oclAnyType returns [Object ret2] : ( 'OclAny' ) ;
    public final Object oclAnyType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclAnyType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:822:2: ( ( 'OclAny' ) )
            // ATL_ANTLR3.g:822:4: ( 'OclAny' )
            {
            // ATL_ANTLR3.g:822:4: ( 'OclAny' )
            // ATL_ANTLR3.g:822:5: 'OclAny'
            {
            match(input,87,FOLLOW_87_in_oclAnyType4753); if (failed) return ret2;

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
    // ATL_ANTLR3.g:832:1: tupleType returns [Object ret2] : ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN ) ;
    public final Object tupleType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:833:2: ( ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN ) )
            // ATL_ANTLR3.g:833:4: ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN )
            {
            // ATL_ANTLR3.g:833:4: ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN )
            // ATL_ANTLR3.g:833:5: 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN
            {
            match(input,88,FOLLOW_88_in_tupleType4785); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_tupleType4787); if (failed) return ret2;
            // ATL_ANTLR3.g:833:24: ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==NAME) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // ATL_ANTLR3.g:833:25: (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* )
                    {
                    // ATL_ANTLR3.g:833:25: (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* )
                    // ATL_ANTLR3.g:833:26: temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )*
                    {
                    pushFollow(FOLLOW_tupleTypeAttribute_in_tupleType4793);
                    temp=tupleTypeAttribute();
                    _fsp--;
                    if (failed) return ret2;
                    if ( backtracking==0 ) {
                      ei.set(ret, "attributes", temp);
                    }
                    // ATL_ANTLR3.g:833:85: ( ( ( COMA ) temp= tupleTypeAttribute ) )*
                    loop103:
                    do {
                        int alt103=2;
                        int LA103_0 = input.LA(1);

                        if ( (LA103_0==COMA) ) {
                            alt103=1;
                        }


                        switch (alt103) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:833:86: ( ( COMA ) temp= tupleTypeAttribute )
                    	    {
                    	    // ATL_ANTLR3.g:833:86: ( ( COMA ) temp= tupleTypeAttribute )
                    	    // ATL_ANTLR3.g:833:87: ( COMA ) temp= tupleTypeAttribute
                    	    {
                    	    // ATL_ANTLR3.g:833:87: ( COMA )
                    	    // ATL_ANTLR3.g:833:88: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_tupleType4800); if (failed) return ret2;

                    	    }

                    	    pushFollow(FOLLOW_tupleTypeAttribute_in_tupleType4805);
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
                    	    break loop103;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_tupleType4815); if (failed) return ret2;

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
    // ATL_ANTLR3.g:843:1: tupleTypeAttribute returns [Object ret2] : (temp= identifier COLON temp= oclType ) ;
    public final Object tupleTypeAttribute() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleTypeAttribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:844:2: ( (temp= identifier COLON temp= oclType ) )
            // ATL_ANTLR3.g:844:4: (temp= identifier COLON temp= oclType )
            {
            // ATL_ANTLR3.g:844:4: (temp= identifier COLON temp= oclType )
            // ATL_ANTLR3.g:844:5: temp= identifier COLON temp= oclType
            {
            pushFollow(FOLLOW_identifier_in_tupleTypeAttribute4849);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            match(input,COLON,FOLLOW_COLON_in_tupleTypeAttribute4853); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_tupleTypeAttribute4857);
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
    // ATL_ANTLR3.g:854:1: mapType returns [Object ret2] : ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN ) ;
    public final Object mapType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:855:2: ( ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:855:4: ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:855:4: ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN )
            // ATL_ANTLR3.g:855:5: 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN
            {
            match(input,84,FOLLOW_84_in_mapType4891); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_mapType4893); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_mapType4897);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "keyType", temp);
            }
            match(input,COMA,FOLLOW_COMA_in_mapType4901); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_mapType4905);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "valueType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_mapType4909); if (failed) return ret2;

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
    // ATL_ANTLR3.g:865:1: primitive returns [Object ret2] : ( (ret= numericType | ret= booleanType | ret= stringType ) ) ;
    public final Object primitive() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:866:2: ( ( (ret= numericType | ret= booleanType | ret= stringType ) ) )
            // ATL_ANTLR3.g:866:4: ( (ret= numericType | ret= booleanType | ret= stringType ) )
            {
            // ATL_ANTLR3.g:866:4: ( (ret= numericType | ret= booleanType | ret= stringType ) )
            // ATL_ANTLR3.g:866:5: (ret= numericType | ret= booleanType | ret= stringType )
            {
            // ATL_ANTLR3.g:866:5: (ret= numericType | ret= booleanType | ret= stringType )
            int alt105=3;
            switch ( input.LA(1) ) {
            case 89:
            case 90:
                {
                alt105=1;
                }
                break;
            case 91:
                {
                alt105=2;
                }
                break;
            case 92:
                {
                alt105=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("866:5: (ret= numericType | ret= booleanType | ret= stringType )", 105, 0, input);

                throw nvae;
            }

            switch (alt105) {
                case 1 :
                    // ATL_ANTLR3.g:866:6: ret= numericType
                    {
                    pushFollow(FOLLOW_numericType_in_primitive4944);
                    ret=numericType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:866:23: ret= booleanType
                    {
                    pushFollow(FOLLOW_booleanType_in_primitive4949);
                    ret=booleanType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:866:40: ret= stringType
                    {
                    pushFollow(FOLLOW_stringType_in_primitive4954);
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
    // ATL_ANTLR3.g:874:1: numericType returns [Object ret2] : ( (ret= integerType | ret= realType ) ) ;
    public final Object numericType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:875:2: ( ( (ret= integerType | ret= realType ) ) )
            // ATL_ANTLR3.g:875:4: ( (ret= integerType | ret= realType ) )
            {
            // ATL_ANTLR3.g:875:4: ( (ret= integerType | ret= realType ) )
            // ATL_ANTLR3.g:875:5: (ret= integerType | ret= realType )
            {
            // ATL_ANTLR3.g:875:5: (ret= integerType | ret= realType )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==89) ) {
                alt106=1;
            }
            else if ( (LA106_0==90) ) {
                alt106=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("875:5: (ret= integerType | ret= realType )", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // ATL_ANTLR3.g:875:6: ret= integerType
                    {
                    pushFollow(FOLLOW_integerType_in_numericType4990);
                    ret=integerType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:875:23: ret= realType
                    {
                    pushFollow(FOLLOW_realType_in_numericType4995);
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
    // ATL_ANTLR3.g:883:1: integerType returns [Object ret2] : ( 'Integer' ) ;
    public final Object integerType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("IntegerType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:884:2: ( ( 'Integer' ) )
            // ATL_ANTLR3.g:884:4: ( 'Integer' )
            {
            // ATL_ANTLR3.g:884:4: ( 'Integer' )
            // ATL_ANTLR3.g:884:5: 'Integer'
            {
            match(input,89,FOLLOW_89_in_integerType5028); if (failed) return ret2;

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
    // ATL_ANTLR3.g:894:1: realType returns [Object ret2] : ( 'Real' ) ;
    public final Object realType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("RealType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:895:2: ( ( 'Real' ) )
            // ATL_ANTLR3.g:895:4: ( 'Real' )
            {
            // ATL_ANTLR3.g:895:4: ( 'Real' )
            // ATL_ANTLR3.g:895:5: 'Real'
            {
            match(input,90,FOLLOW_90_in_realType5060); if (failed) return ret2;

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
    // ATL_ANTLR3.g:905:1: booleanType returns [Object ret2] : ( 'Boolean' ) ;
    public final Object booleanType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("BooleanType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:906:2: ( ( 'Boolean' ) )
            // ATL_ANTLR3.g:906:4: ( 'Boolean' )
            {
            // ATL_ANTLR3.g:906:4: ( 'Boolean' )
            // ATL_ANTLR3.g:906:5: 'Boolean'
            {
            match(input,91,FOLLOW_91_in_booleanType5092); if (failed) return ret2;

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
    // ATL_ANTLR3.g:916:1: stringType returns [Object ret2] : ( 'String' ) ;
    public final Object stringType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("StringType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:917:2: ( ( 'String' ) )
            // ATL_ANTLR3.g:917:4: ( 'String' )
            {
            // ATL_ANTLR3.g:917:4: ( 'String' )
            // ATL_ANTLR3.g:917:5: 'String'
            {
            match(input,92,FOLLOW_92_in_stringType5124); if (failed) return ret2;

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
    // ATL_ANTLR3.g:927:1: collectionType returns [Object ret2] : ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) ) ;
    public final Object collectionType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:928:2: ( ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) ) )
            // ATL_ANTLR3.g:928:4: ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) )
            {
            // ATL_ANTLR3.g:928:4: ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) )
            // ATL_ANTLR3.g:928:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )
            {
            // ATL_ANTLR3.g:928:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )
            int alt107=5;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt107=1;
                }
                break;
            case 81:
                {
                alt107=2;
                }
                break;
            case 82:
                {
                alt107=3;
                }
                break;
            case 83:
                {
                alt107=4;
                }
                break;
            case 93:
                {
                alt107=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("928:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // ATL_ANTLR3.g:928:6: ret= bagType
                    {
                    pushFollow(FOLLOW_bagType_in_collectionType5159);
                    ret=bagType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:928:19: ret= setType
                    {
                    pushFollow(FOLLOW_setType_in_collectionType5164);
                    ret=setType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:928:32: ret= orderedSetType
                    {
                    pushFollow(FOLLOW_orderedSetType_in_collectionType5169);
                    ret=orderedSetType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:928:52: ret= sequenceType
                    {
                    pushFollow(FOLLOW_sequenceType_in_collectionType5174);
                    ret=sequenceType();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 5 :
                    // ATL_ANTLR3.g:928:70: ret= collectionType_abstractContents
                    {
                    pushFollow(FOLLOW_collectionType_abstractContents_in_collectionType5179);
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
    // ATL_ANTLR3.g:936:1: bagType returns [Object ret2] : ( 'Bag' LPAREN temp= oclType RPAREN ) ;
    public final Object bagType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BagType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:937:2: ( ( 'Bag' LPAREN temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:937:4: ( 'Bag' LPAREN temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:937:4: ( 'Bag' LPAREN temp= oclType RPAREN )
            // ATL_ANTLR3.g:937:5: 'Bag' LPAREN temp= oclType RPAREN
            {
            match(input,80,FOLLOW_80_in_bagType5212); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_bagType5214); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_bagType5218);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_bagType5222); if (failed) return ret2;

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
    // ATL_ANTLR3.g:947:1: setType returns [Object ret2] : ( 'Set' LPAREN temp= oclType RPAREN ) ;
    public final Object setType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SetType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:948:2: ( ( 'Set' LPAREN temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:948:4: ( 'Set' LPAREN temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:948:4: ( 'Set' LPAREN temp= oclType RPAREN )
            // ATL_ANTLR3.g:948:5: 'Set' LPAREN temp= oclType RPAREN
            {
            match(input,81,FOLLOW_81_in_setType5254); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_setType5256); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_setType5260);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_setType5264); if (failed) return ret2;

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
    // ATL_ANTLR3.g:958:1: orderedSetType returns [Object ret2] : ( 'OrderedSet' LPAREN temp= oclType RPAREN ) ;
    public final Object orderedSetType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OrderedSetType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:959:2: ( ( 'OrderedSet' LPAREN temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:959:4: ( 'OrderedSet' LPAREN temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:959:4: ( 'OrderedSet' LPAREN temp= oclType RPAREN )
            // ATL_ANTLR3.g:959:5: 'OrderedSet' LPAREN temp= oclType RPAREN
            {
            match(input,82,FOLLOW_82_in_orderedSetType5296); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_orderedSetType5298); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_orderedSetType5302);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_orderedSetType5306); if (failed) return ret2;

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
    // ATL_ANTLR3.g:969:1: sequenceType returns [Object ret2] : ( 'Sequence' LPAREN temp= oclType RPAREN ) ;
    public final Object sequenceType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SequenceType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:970:2: ( ( 'Sequence' LPAREN temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:970:4: ( 'Sequence' LPAREN temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:970:4: ( 'Sequence' LPAREN temp= oclType RPAREN )
            // ATL_ANTLR3.g:970:5: 'Sequence' LPAREN temp= oclType RPAREN
            {
            match(input,83,FOLLOW_83_in_sequenceType5338); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_sequenceType5340); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_sequenceType5344);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_sequenceType5348); if (failed) return ret2;

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
    // ATL_ANTLR3.g:980:1: priority_0 returns [Object ret2] : (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:981:2: ( (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* ) )
            // ATL_ANTLR3.g:981:4: (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* )
            {
            // ATL_ANTLR3.g:981:4: (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* )
            // ATL_ANTLR3.g:981:5: ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_oclExpression_in_priority_05382);
            ret=primary_oclExpression();
            _fsp--;
            if (failed) return ret2;
            // ATL_ANTLR3.g:981:31: ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==RARROW||LA111_0==POINT) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // ATL_ANTLR3.g:981:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )
            	    {
            	    // ATL_ANTLR3.g:981:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )
            	    int alt110=2;
            	    int LA110_0 = input.LA(1);

            	    if ( (LA110_0==POINT) ) {
            	        alt110=1;
            	    }
            	    else if ( (LA110_0==RARROW) ) {
            	        alt110=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("981:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )", 110, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt110) {
            	        case 1 :
            	            // ATL_ANTLR3.g:981:33: ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) )
            	            {
            	            // ATL_ANTLR3.g:981:33: ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) )
            	            // ATL_ANTLR3.g:981:34: POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )
            	            {
            	            match(input,POINT,FOLLOW_POINT_in_priority_05387); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = ".";
            	            }
            	            // ATL_ANTLR3.g:981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )
            	            int alt108=2;
            	            switch ( input.LA(1) ) {
            	            case NAME:
            	                {
            	                int LA108_1 = input.LA(2);

            	                if ( (LA108_1==EOF||(LA108_1>=SEMI && LA108_1<=EQ)||LA108_1==RPAREN||(LA108_1>=RCURLY && LA108_1<=LARROW)||LA108_1==PIPE||(LA108_1>=POINT && LA108_1<=NE)||LA108_1==62||LA108_1==70||(LA108_1>=76 && LA108_1<=77)||(LA108_1>=95 && LA108_1<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_1==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 1, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 43:
            	                {
            	                int LA108_2 = input.LA(2);

            	                if ( (LA108_2==EOF||(LA108_2>=SEMI && LA108_2<=EQ)||LA108_2==RPAREN||(LA108_2>=RCURLY && LA108_2<=LARROW)||LA108_2==PIPE||(LA108_2>=POINT && LA108_2<=NE)||LA108_2==62||LA108_2==70||(LA108_2>=76 && LA108_2<=77)||(LA108_2>=95 && LA108_2<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_2==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 2, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 44:
            	                {
            	                int LA108_3 = input.LA(2);

            	                if ( (LA108_3==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_3==EOF||(LA108_3>=SEMI && LA108_3<=EQ)||LA108_3==RPAREN||(LA108_3>=RCURLY && LA108_3<=LARROW)||LA108_3==PIPE||(LA108_3>=POINT && LA108_3<=NE)||LA108_3==62||LA108_3==70||(LA108_3>=76 && LA108_3<=77)||(LA108_3>=95 && LA108_3<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 3, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 45:
            	                {
            	                int LA108_4 = input.LA(2);

            	                if ( (LA108_4==EOF||(LA108_4>=SEMI && LA108_4<=EQ)||LA108_4==RPAREN||(LA108_4>=RCURLY && LA108_4<=LARROW)||LA108_4==PIPE||(LA108_4>=POINT && LA108_4<=NE)||LA108_4==62||LA108_4==70||(LA108_4>=76 && LA108_4<=77)||(LA108_4>=95 && LA108_4<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_4==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 4, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 46:
            	                {
            	                int LA108_5 = input.LA(2);

            	                if ( (LA108_5==EOF||(LA108_5>=SEMI && LA108_5<=EQ)||LA108_5==RPAREN||(LA108_5>=RCURLY && LA108_5<=LARROW)||LA108_5==PIPE||(LA108_5>=POINT && LA108_5<=NE)||LA108_5==62||LA108_5==70||(LA108_5>=76 && LA108_5<=77)||(LA108_5>=95 && LA108_5<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_5==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 5, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 47:
            	                {
            	                int LA108_6 = input.LA(2);

            	                if ( (LA108_6==EOF||(LA108_6>=SEMI && LA108_6<=EQ)||LA108_6==RPAREN||(LA108_6>=RCURLY && LA108_6<=LARROW)||LA108_6==PIPE||(LA108_6>=POINT && LA108_6<=NE)||LA108_6==62||LA108_6==70||(LA108_6>=76 && LA108_6<=77)||(LA108_6>=95 && LA108_6<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_6==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 6, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 48:
            	                {
            	                int LA108_7 = input.LA(2);

            	                if ( (LA108_7==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_7==EOF||(LA108_7>=SEMI && LA108_7<=EQ)||LA108_7==RPAREN||(LA108_7>=RCURLY && LA108_7<=LARROW)||LA108_7==PIPE||(LA108_7>=POINT && LA108_7<=NE)||LA108_7==62||LA108_7==70||(LA108_7>=76 && LA108_7<=77)||(LA108_7>=95 && LA108_7<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 7, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 49:
            	                {
            	                int LA108_8 = input.LA(2);

            	                if ( (LA108_8==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_8==EOF||(LA108_8>=SEMI && LA108_8<=EQ)||LA108_8==RPAREN||(LA108_8>=RCURLY && LA108_8<=LARROW)||LA108_8==PIPE||(LA108_8>=POINT && LA108_8<=NE)||LA108_8==62||LA108_8==70||(LA108_8>=76 && LA108_8<=77)||(LA108_8>=95 && LA108_8<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 8, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 50:
            	                {
            	                int LA108_9 = input.LA(2);

            	                if ( (LA108_9==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_9==EOF||(LA108_9>=SEMI && LA108_9<=EQ)||LA108_9==RPAREN||(LA108_9>=RCURLY && LA108_9<=LARROW)||LA108_9==PIPE||(LA108_9>=POINT && LA108_9<=NE)||LA108_9==62||LA108_9==70||(LA108_9>=76 && LA108_9<=77)||(LA108_9>=95 && LA108_9<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 9, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 51:
            	                {
            	                int LA108_10 = input.LA(2);

            	                if ( (LA108_10==EOF||(LA108_10>=SEMI && LA108_10<=EQ)||LA108_10==RPAREN||(LA108_10>=RCURLY && LA108_10<=LARROW)||LA108_10==PIPE||(LA108_10>=POINT && LA108_10<=NE)||LA108_10==62||LA108_10==70||(LA108_10>=76 && LA108_10<=77)||(LA108_10>=95 && LA108_10<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_10==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 10, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 52:
            	                {
            	                int LA108_11 = input.LA(2);

            	                if ( (LA108_11==EOF||(LA108_11>=SEMI && LA108_11<=EQ)||LA108_11==RPAREN||(LA108_11>=RCURLY && LA108_11<=LARROW)||LA108_11==PIPE||(LA108_11>=POINT && LA108_11<=NE)||LA108_11==62||LA108_11==70||(LA108_11>=76 && LA108_11<=77)||(LA108_11>=95 && LA108_11<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_11==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 11, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 53:
            	                {
            	                int LA108_12 = input.LA(2);

            	                if ( (LA108_12==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_12==EOF||(LA108_12>=SEMI && LA108_12<=EQ)||LA108_12==RPAREN||(LA108_12>=RCURLY && LA108_12<=LARROW)||LA108_12==PIPE||(LA108_12>=POINT && LA108_12<=NE)||LA108_12==62||LA108_12==70||(LA108_12>=76 && LA108_12<=77)||(LA108_12>=95 && LA108_12<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 12, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 54:
            	                {
            	                int LA108_13 = input.LA(2);

            	                if ( (LA108_13==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_13==EOF||(LA108_13>=SEMI && LA108_13<=EQ)||LA108_13==RPAREN||(LA108_13>=RCURLY && LA108_13<=LARROW)||LA108_13==PIPE||(LA108_13>=POINT && LA108_13<=NE)||LA108_13==62||LA108_13==70||(LA108_13>=76 && LA108_13<=77)||(LA108_13>=95 && LA108_13<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 13, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 55:
            	                {
            	                int LA108_14 = input.LA(2);

            	                if ( (LA108_14==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_14==EOF||(LA108_14>=SEMI && LA108_14<=EQ)||LA108_14==RPAREN||(LA108_14>=RCURLY && LA108_14<=LARROW)||LA108_14==PIPE||(LA108_14>=POINT && LA108_14<=NE)||LA108_14==62||LA108_14==70||(LA108_14>=76 && LA108_14<=77)||(LA108_14>=95 && LA108_14<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 14, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 56:
            	                {
            	                int LA108_15 = input.LA(2);

            	                if ( (LA108_15==EOF||(LA108_15>=SEMI && LA108_15<=EQ)||LA108_15==RPAREN||(LA108_15>=RCURLY && LA108_15<=LARROW)||LA108_15==PIPE||(LA108_15>=POINT && LA108_15<=NE)||LA108_15==62||LA108_15==70||(LA108_15>=76 && LA108_15<=77)||(LA108_15>=95 && LA108_15<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_15==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 15, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 57:
            	                {
            	                int LA108_16 = input.LA(2);

            	                if ( (LA108_16==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_16==EOF||(LA108_16>=SEMI && LA108_16<=EQ)||LA108_16==RPAREN||(LA108_16>=RCURLY && LA108_16<=LARROW)||LA108_16==PIPE||(LA108_16>=POINT && LA108_16<=NE)||LA108_16==62||LA108_16==70||(LA108_16>=76 && LA108_16<=77)||(LA108_16>=95 && LA108_16<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 16, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 58:
            	                {
            	                int LA108_17 = input.LA(2);

            	                if ( (LA108_17==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_17==EOF||(LA108_17>=SEMI && LA108_17<=EQ)||LA108_17==RPAREN||(LA108_17>=RCURLY && LA108_17<=LARROW)||LA108_17==PIPE||(LA108_17>=POINT && LA108_17<=NE)||LA108_17==62||LA108_17==70||(LA108_17>=76 && LA108_17<=77)||(LA108_17>=95 && LA108_17<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 17, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 59:
            	                {
            	                int LA108_18 = input.LA(2);

            	                if ( (LA108_18==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_18==EOF||(LA108_18>=SEMI && LA108_18<=EQ)||LA108_18==RPAREN||(LA108_18>=RCURLY && LA108_18<=LARROW)||LA108_18==PIPE||(LA108_18>=POINT && LA108_18<=NE)||LA108_18==62||LA108_18==70||(LA108_18>=76 && LA108_18<=77)||(LA108_18>=95 && LA108_18<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 18, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 60:
            	                {
            	                int LA108_19 = input.LA(2);

            	                if ( (LA108_19==EOF||(LA108_19>=SEMI && LA108_19<=EQ)||LA108_19==RPAREN||(LA108_19>=RCURLY && LA108_19<=LARROW)||LA108_19==PIPE||(LA108_19>=POINT && LA108_19<=NE)||LA108_19==62||LA108_19==70||(LA108_19>=76 && LA108_19<=77)||(LA108_19>=95 && LA108_19<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_19==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 19, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 61:
            	                {
            	                int LA108_20 = input.LA(2);

            	                if ( (LA108_20==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_20==EOF||(LA108_20>=SEMI && LA108_20<=EQ)||LA108_20==RPAREN||(LA108_20>=RCURLY && LA108_20<=LARROW)||LA108_20==PIPE||(LA108_20>=POINT && LA108_20<=NE)||LA108_20==62||LA108_20==70||(LA108_20>=76 && LA108_20<=77)||(LA108_20>=95 && LA108_20<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 20, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 62:
            	                {
            	                int LA108_21 = input.LA(2);

            	                if ( (LA108_21==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_21==EOF||(LA108_21>=SEMI && LA108_21<=EQ)||LA108_21==RPAREN||(LA108_21>=RCURLY && LA108_21<=LARROW)||LA108_21==PIPE||(LA108_21>=POINT && LA108_21<=NE)||LA108_21==62||LA108_21==70||(LA108_21>=76 && LA108_21<=77)||(LA108_21>=95 && LA108_21<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 21, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 63:
            	                {
            	                int LA108_22 = input.LA(2);

            	                if ( (LA108_22==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_22==EOF||(LA108_22>=SEMI && LA108_22<=EQ)||LA108_22==RPAREN||(LA108_22>=RCURLY && LA108_22<=LARROW)||LA108_22==PIPE||(LA108_22>=POINT && LA108_22<=NE)||LA108_22==62||LA108_22==70||(LA108_22>=76 && LA108_22<=77)||(LA108_22>=95 && LA108_22<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 22, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 64:
            	                {
            	                int LA108_23 = input.LA(2);

            	                if ( (LA108_23==EOF||(LA108_23>=SEMI && LA108_23<=EQ)||LA108_23==RPAREN||(LA108_23>=RCURLY && LA108_23<=LARROW)||LA108_23==PIPE||(LA108_23>=POINT && LA108_23<=NE)||LA108_23==62||LA108_23==70||(LA108_23>=76 && LA108_23<=77)||(LA108_23>=95 && LA108_23<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_23==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 23, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 65:
            	                {
            	                int LA108_24 = input.LA(2);

            	                if ( (LA108_24==EOF||(LA108_24>=SEMI && LA108_24<=EQ)||LA108_24==RPAREN||(LA108_24>=RCURLY && LA108_24<=LARROW)||LA108_24==PIPE||(LA108_24>=POINT && LA108_24<=NE)||LA108_24==62||LA108_24==70||(LA108_24>=76 && LA108_24<=77)||(LA108_24>=95 && LA108_24<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_24==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 24, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 66:
            	                {
            	                int LA108_25 = input.LA(2);

            	                if ( (LA108_25==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_25==EOF||(LA108_25>=SEMI && LA108_25<=EQ)||LA108_25==RPAREN||(LA108_25>=RCURLY && LA108_25<=LARROW)||LA108_25==PIPE||(LA108_25>=POINT && LA108_25<=NE)||LA108_25==62||LA108_25==70||(LA108_25>=76 && LA108_25<=77)||(LA108_25>=95 && LA108_25<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 25, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 67:
            	                {
            	                int LA108_26 = input.LA(2);

            	                if ( (LA108_26==EOF||(LA108_26>=SEMI && LA108_26<=EQ)||LA108_26==RPAREN||(LA108_26>=RCURLY && LA108_26<=LARROW)||LA108_26==PIPE||(LA108_26>=POINT && LA108_26<=NE)||LA108_26==62||LA108_26==70||(LA108_26>=76 && LA108_26<=77)||(LA108_26>=95 && LA108_26<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_26==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 26, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 68:
            	                {
            	                int LA108_27 = input.LA(2);

            	                if ( (LA108_27==EOF||(LA108_27>=SEMI && LA108_27<=EQ)||LA108_27==RPAREN||(LA108_27>=RCURLY && LA108_27<=LARROW)||LA108_27==PIPE||(LA108_27>=POINT && LA108_27<=NE)||LA108_27==62||LA108_27==70||(LA108_27>=76 && LA108_27<=77)||(LA108_27>=95 && LA108_27<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_27==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 27, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 69:
            	                {
            	                int LA108_28 = input.LA(2);

            	                if ( (LA108_28==EOF||(LA108_28>=SEMI && LA108_28<=EQ)||LA108_28==RPAREN||(LA108_28>=RCURLY && LA108_28<=LARROW)||LA108_28==PIPE||(LA108_28>=POINT && LA108_28<=NE)||LA108_28==62||LA108_28==70||(LA108_28>=76 && LA108_28<=77)||(LA108_28>=95 && LA108_28<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_28==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 28, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 70:
            	                {
            	                int LA108_29 = input.LA(2);

            	                if ( (LA108_29==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_29==EOF||(LA108_29>=SEMI && LA108_29<=EQ)||LA108_29==RPAREN||(LA108_29>=RCURLY && LA108_29<=LARROW)||LA108_29==PIPE||(LA108_29>=POINT && LA108_29<=NE)||LA108_29==62||LA108_29==70||(LA108_29>=76 && LA108_29<=77)||(LA108_29>=95 && LA108_29<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 29, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 71:
            	                {
            	                int LA108_30 = input.LA(2);

            	                if ( (LA108_30==EOF||(LA108_30>=SEMI && LA108_30<=EQ)||LA108_30==RPAREN||(LA108_30>=RCURLY && LA108_30<=LARROW)||LA108_30==PIPE||(LA108_30>=POINT && LA108_30<=NE)||LA108_30==62||LA108_30==70||(LA108_30>=76 && LA108_30<=77)||(LA108_30>=95 && LA108_30<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_30==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 30, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 72:
            	                {
            	                int LA108_31 = input.LA(2);

            	                if ( (LA108_31==EOF||(LA108_31>=SEMI && LA108_31<=EQ)||LA108_31==RPAREN||(LA108_31>=RCURLY && LA108_31<=LARROW)||LA108_31==PIPE||(LA108_31>=POINT && LA108_31<=NE)||LA108_31==62||LA108_31==70||(LA108_31>=76 && LA108_31<=77)||(LA108_31>=95 && LA108_31<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_31==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 31, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 73:
            	                {
            	                int LA108_32 = input.LA(2);

            	                if ( (LA108_32==EOF||(LA108_32>=SEMI && LA108_32<=EQ)||LA108_32==RPAREN||(LA108_32>=RCURLY && LA108_32<=LARROW)||LA108_32==PIPE||(LA108_32>=POINT && LA108_32<=NE)||LA108_32==62||LA108_32==70||(LA108_32>=76 && LA108_32<=77)||(LA108_32>=95 && LA108_32<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_32==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 32, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 74:
            	                {
            	                int LA108_33 = input.LA(2);

            	                if ( (LA108_33==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_33==EOF||(LA108_33>=SEMI && LA108_33<=EQ)||LA108_33==RPAREN||(LA108_33>=RCURLY && LA108_33<=LARROW)||LA108_33==PIPE||(LA108_33>=POINT && LA108_33<=NE)||LA108_33==62||LA108_33==70||(LA108_33>=76 && LA108_33<=77)||(LA108_33>=95 && LA108_33<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 33, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 75:
            	                {
            	                int LA108_34 = input.LA(2);

            	                if ( (LA108_34==EOF||(LA108_34>=SEMI && LA108_34<=EQ)||LA108_34==RPAREN||(LA108_34>=RCURLY && LA108_34<=LARROW)||LA108_34==PIPE||(LA108_34>=POINT && LA108_34<=NE)||LA108_34==62||LA108_34==70||(LA108_34>=76 && LA108_34<=77)||(LA108_34>=95 && LA108_34<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_34==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 34, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 76:
            	                {
            	                int LA108_35 = input.LA(2);

            	                if ( (LA108_35==EOF||(LA108_35>=SEMI && LA108_35<=EQ)||LA108_35==RPAREN||(LA108_35>=RCURLY && LA108_35<=LARROW)||LA108_35==PIPE||(LA108_35>=POINT && LA108_35<=NE)||LA108_35==62||LA108_35==70||(LA108_35>=76 && LA108_35<=77)||(LA108_35>=95 && LA108_35<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_35==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 35, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 77:
            	                {
            	                int LA108_36 = input.LA(2);

            	                if ( (LA108_36==EOF||(LA108_36>=SEMI && LA108_36<=EQ)||LA108_36==RPAREN||(LA108_36>=RCURLY && LA108_36<=LARROW)||LA108_36==PIPE||(LA108_36>=POINT && LA108_36<=NE)||LA108_36==62||LA108_36==70||(LA108_36>=76 && LA108_36<=77)||(LA108_36>=95 && LA108_36<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_36==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 36, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 78:
            	                {
            	                int LA108_37 = input.LA(2);

            	                if ( (LA108_37==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_37==EOF||(LA108_37>=SEMI && LA108_37<=EQ)||LA108_37==RPAREN||(LA108_37>=RCURLY && LA108_37<=LARROW)||LA108_37==PIPE||(LA108_37>=POINT && LA108_37<=NE)||LA108_37==62||LA108_37==70||(LA108_37>=76 && LA108_37<=77)||(LA108_37>=95 && LA108_37<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 37, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 79:
            	                {
            	                int LA108_38 = input.LA(2);

            	                if ( (LA108_38==EOF||(LA108_38>=SEMI && LA108_38<=EQ)||LA108_38==RPAREN||(LA108_38>=RCURLY && LA108_38<=LARROW)||LA108_38==PIPE||(LA108_38>=POINT && LA108_38<=NE)||LA108_38==62||LA108_38==70||(LA108_38>=76 && LA108_38<=77)||(LA108_38>=95 && LA108_38<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_38==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 38, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 80:
            	                {
            	                int LA108_39 = input.LA(2);

            	                if ( (LA108_39==EOF||(LA108_39>=SEMI && LA108_39<=EQ)||LA108_39==RPAREN||(LA108_39>=RCURLY && LA108_39<=LARROW)||LA108_39==PIPE||(LA108_39>=POINT && LA108_39<=NE)||LA108_39==62||LA108_39==70||(LA108_39>=76 && LA108_39<=77)||(LA108_39>=95 && LA108_39<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_39==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 39, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 81:
            	                {
            	                int LA108_40 = input.LA(2);

            	                if ( (LA108_40==EOF||(LA108_40>=SEMI && LA108_40<=EQ)||LA108_40==RPAREN||(LA108_40>=RCURLY && LA108_40<=LARROW)||LA108_40==PIPE||(LA108_40>=POINT && LA108_40<=NE)||LA108_40==62||LA108_40==70||(LA108_40>=76 && LA108_40<=77)||(LA108_40>=95 && LA108_40<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_40==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 40, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 82:
            	                {
            	                int LA108_41 = input.LA(2);

            	                if ( (LA108_41==EOF||(LA108_41>=SEMI && LA108_41<=EQ)||LA108_41==RPAREN||(LA108_41>=RCURLY && LA108_41<=LARROW)||LA108_41==PIPE||(LA108_41>=POINT && LA108_41<=NE)||LA108_41==62||LA108_41==70||(LA108_41>=76 && LA108_41<=77)||(LA108_41>=95 && LA108_41<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_41==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 41, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 83:
            	                {
            	                int LA108_42 = input.LA(2);

            	                if ( (LA108_42==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_42==EOF||(LA108_42>=SEMI && LA108_42<=EQ)||LA108_42==RPAREN||(LA108_42>=RCURLY && LA108_42<=LARROW)||LA108_42==PIPE||(LA108_42>=POINT && LA108_42<=NE)||LA108_42==62||LA108_42==70||(LA108_42>=76 && LA108_42<=77)||(LA108_42>=95 && LA108_42<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 42, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 84:
            	                {
            	                int LA108_43 = input.LA(2);

            	                if ( (LA108_43==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_43==EOF||(LA108_43>=SEMI && LA108_43<=EQ)||LA108_43==RPAREN||(LA108_43>=RCURLY && LA108_43<=LARROW)||LA108_43==PIPE||(LA108_43>=POINT && LA108_43<=NE)||LA108_43==62||LA108_43==70||(LA108_43>=76 && LA108_43<=77)||(LA108_43>=95 && LA108_43<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 43, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 85:
            	                {
            	                int LA108_44 = input.LA(2);

            	                if ( (LA108_44==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_44==EOF||(LA108_44>=SEMI && LA108_44<=EQ)||LA108_44==RPAREN||(LA108_44>=RCURLY && LA108_44<=LARROW)||LA108_44==PIPE||(LA108_44>=POINT && LA108_44<=NE)||LA108_44==62||LA108_44==70||(LA108_44>=76 && LA108_44<=77)||(LA108_44>=95 && LA108_44<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 44, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 86:
            	                {
            	                int LA108_45 = input.LA(2);

            	                if ( (LA108_45==EOF||(LA108_45>=SEMI && LA108_45<=EQ)||LA108_45==RPAREN||(LA108_45>=RCURLY && LA108_45<=LARROW)||LA108_45==PIPE||(LA108_45>=POINT && LA108_45<=NE)||LA108_45==62||LA108_45==70||(LA108_45>=76 && LA108_45<=77)||(LA108_45>=95 && LA108_45<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_45==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 45, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 87:
            	                {
            	                int LA108_46 = input.LA(2);

            	                if ( (LA108_46==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_46==EOF||(LA108_46>=SEMI && LA108_46<=EQ)||LA108_46==RPAREN||(LA108_46>=RCURLY && LA108_46<=LARROW)||LA108_46==PIPE||(LA108_46>=POINT && LA108_46<=NE)||LA108_46==62||LA108_46==70||(LA108_46>=76 && LA108_46<=77)||(LA108_46>=95 && LA108_46<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 46, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 88:
            	                {
            	                int LA108_47 = input.LA(2);

            	                if ( (LA108_47==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_47==EOF||(LA108_47>=SEMI && LA108_47<=EQ)||LA108_47==RPAREN||(LA108_47>=RCURLY && LA108_47<=LARROW)||LA108_47==PIPE||(LA108_47>=POINT && LA108_47<=NE)||LA108_47==62||LA108_47==70||(LA108_47>=76 && LA108_47<=77)||(LA108_47>=95 && LA108_47<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 47, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 89:
            	                {
            	                int LA108_48 = input.LA(2);

            	                if ( (LA108_48==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_48==EOF||(LA108_48>=SEMI && LA108_48<=EQ)||LA108_48==RPAREN||(LA108_48>=RCURLY && LA108_48<=LARROW)||LA108_48==PIPE||(LA108_48>=POINT && LA108_48<=NE)||LA108_48==62||LA108_48==70||(LA108_48>=76 && LA108_48<=77)||(LA108_48>=95 && LA108_48<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 48, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 90:
            	                {
            	                int LA108_49 = input.LA(2);

            	                if ( (LA108_49==EOF||(LA108_49>=SEMI && LA108_49<=EQ)||LA108_49==RPAREN||(LA108_49>=RCURLY && LA108_49<=LARROW)||LA108_49==PIPE||(LA108_49>=POINT && LA108_49<=NE)||LA108_49==62||LA108_49==70||(LA108_49>=76 && LA108_49<=77)||(LA108_49>=95 && LA108_49<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_49==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 49, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 91:
            	                {
            	                int LA108_50 = input.LA(2);

            	                if ( (LA108_50==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_50==EOF||(LA108_50>=SEMI && LA108_50<=EQ)||LA108_50==RPAREN||(LA108_50>=RCURLY && LA108_50<=LARROW)||LA108_50==PIPE||(LA108_50>=POINT && LA108_50<=NE)||LA108_50==62||LA108_50==70||(LA108_50>=76 && LA108_50<=77)||(LA108_50>=95 && LA108_50<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 50, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 92:
            	                {
            	                int LA108_51 = input.LA(2);

            	                if ( (LA108_51==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_51==EOF||(LA108_51>=SEMI && LA108_51<=EQ)||LA108_51==RPAREN||(LA108_51>=RCURLY && LA108_51<=LARROW)||LA108_51==PIPE||(LA108_51>=POINT && LA108_51<=NE)||LA108_51==62||LA108_51==70||(LA108_51>=76 && LA108_51<=77)||(LA108_51>=95 && LA108_51<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 51, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 93:
            	                {
            	                int LA108_52 = input.LA(2);

            	                if ( (LA108_52==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_52==EOF||(LA108_52>=SEMI && LA108_52<=EQ)||LA108_52==RPAREN||(LA108_52>=RCURLY && LA108_52<=LARROW)||LA108_52==PIPE||(LA108_52>=POINT && LA108_52<=NE)||LA108_52==62||LA108_52==70||(LA108_52>=76 && LA108_52<=77)||(LA108_52>=95 && LA108_52<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 52, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 94:
            	                {
            	                int LA108_53 = input.LA(2);

            	                if ( (LA108_53==EOF||(LA108_53>=SEMI && LA108_53<=EQ)||LA108_53==RPAREN||(LA108_53>=RCURLY && LA108_53<=LARROW)||LA108_53==PIPE||(LA108_53>=POINT && LA108_53<=NE)||LA108_53==62||LA108_53==70||(LA108_53>=76 && LA108_53<=77)||(LA108_53>=95 && LA108_53<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_53==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 53, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 95:
            	                {
            	                int LA108_54 = input.LA(2);

            	                if ( (LA108_54==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_54==EOF||(LA108_54>=SEMI && LA108_54<=EQ)||LA108_54==RPAREN||(LA108_54>=RCURLY && LA108_54<=LARROW)||LA108_54==PIPE||(LA108_54>=POINT && LA108_54<=NE)||LA108_54==62||LA108_54==70||(LA108_54>=76 && LA108_54<=77)||(LA108_54>=95 && LA108_54<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 54, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 96:
            	                {
            	                int LA108_55 = input.LA(2);

            	                if ( (LA108_55==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_55==EOF||(LA108_55>=SEMI && LA108_55<=EQ)||LA108_55==RPAREN||(LA108_55>=RCURLY && LA108_55<=LARROW)||LA108_55==PIPE||(LA108_55>=POINT && LA108_55<=NE)||LA108_55==62||LA108_55==70||(LA108_55>=76 && LA108_55<=77)||(LA108_55>=95 && LA108_55<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 55, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 97:
            	                {
            	                int LA108_56 = input.LA(2);

            	                if ( (LA108_56==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_56==EOF||(LA108_56>=SEMI && LA108_56<=EQ)||LA108_56==RPAREN||(LA108_56>=RCURLY && LA108_56<=LARROW)||LA108_56==PIPE||(LA108_56>=POINT && LA108_56<=NE)||LA108_56==62||LA108_56==70||(LA108_56>=76 && LA108_56<=77)||(LA108_56>=95 && LA108_56<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 56, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 98:
            	                {
            	                int LA108_57 = input.LA(2);

            	                if ( (LA108_57==EOF||(LA108_57>=SEMI && LA108_57<=EQ)||LA108_57==RPAREN||(LA108_57>=RCURLY && LA108_57<=LARROW)||LA108_57==PIPE||(LA108_57>=POINT && LA108_57<=NE)||LA108_57==62||LA108_57==70||(LA108_57>=76 && LA108_57<=77)||(LA108_57>=95 && LA108_57<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_57==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 57, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 99:
            	                {
            	                int LA108_58 = input.LA(2);

            	                if ( (LA108_58==EOF||(LA108_58>=SEMI && LA108_58<=EQ)||LA108_58==RPAREN||(LA108_58>=RCURLY && LA108_58<=LARROW)||LA108_58==PIPE||(LA108_58>=POINT && LA108_58<=NE)||LA108_58==62||LA108_58==70||(LA108_58>=76 && LA108_58<=77)||(LA108_58>=95 && LA108_58<=100)) ) {
            	                    alt108=2;
            	                }
            	                else if ( (LA108_58==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 58, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 100:
            	                {
            	                int LA108_59 = input.LA(2);

            	                if ( (LA108_59==LPAREN) ) {
            	                    alt108=1;
            	                }
            	                else if ( (LA108_59==EOF||(LA108_59>=SEMI && LA108_59<=EQ)||LA108_59==RPAREN||(LA108_59>=RCURLY && LA108_59<=LARROW)||LA108_59==PIPE||(LA108_59>=POINT && LA108_59<=NE)||LA108_59==62||LA108_59==70||(LA108_59>=76 && LA108_59<=77)||(LA108_59>=95 && LA108_59<=100)) ) {
            	                    alt108=2;
            	                }
            	                else {
            	                    if (backtracking>0) {failed=true; return ret2;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 59, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            default:
            	                if (backtracking>0) {failed=true; return ret2;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("981:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 108, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt108) {
            	                case 1 :
            	                    // ATL_ANTLR3.g:981:57: ret= operationCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_operationCallExp_in_priority_05394);
            	                    ret=operationCallExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;
            	                case 2 :
            	                    // ATL_ANTLR3.g:981:105: ret= navigationOrAttributeCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_navigationOrAttributeCallExp_in_priority_05401);
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
            	            // ATL_ANTLR3.g:981:167: ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) )
            	            {
            	            // ATL_ANTLR3.g:981:167: ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) )
            	            // ATL_ANTLR3.g:981:168: RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )
            	            {
            	            match(input,RARROW,FOLLOW_RARROW_in_priority_05409); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "->";
            	            }
            	            // ATL_ANTLR3.g:981:192: (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )
            	            int alt109=3;
            	            alt109 = dfa109.predict(input);
            	            switch (alt109) {
            	                case 1 :
            	                    // ATL_ANTLR3.g:981:193: ret= iteratorExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_iteratorExp_in_priority_05416);
            	                    ret=iteratorExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;
            	                case 2 :
            	                    // ATL_ANTLR3.g:981:236: ret= iterateExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_iterateExp_in_priority_05423);
            	                    ret=iterateExp(opName,  ret,  firstToken);
            	                    _fsp--;
            	                    if (failed) return ret2;

            	                    }
            	                    break;
            	                case 3 :
            	                    // ATL_ANTLR3.g:981:278: ret= collectionOperationCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_collectionOperationCallExp_in_priority_05430);
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
            	    break loop111;
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
    // ATL_ANTLR3.g:988:1: priority_1 returns [Object ret2] : ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) ;
    public final Object priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:989:2: ( ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) )
            // ATL_ANTLR3.g:989:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            {
            // ATL_ANTLR3.g:989:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            int alt112=3;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt112=1;
                }
                break;
            case MINUS:
                {
                alt112=2;
                }
                break;
            case NAME:
            case STRING:
            case INT:
            case FLOAT:
            case LPAREN:
            case SHARP:
            case 69:
            case 73:
            case 74:
            case 75:
            case 78:
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
            case 93:
                {
                alt112=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("989:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )", 112, 0, input);

                throw nvae;
            }

            switch (alt112) {
                case 1 :
                    // ATL_ANTLR3.g:989:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // ATL_ANTLR3.g:989:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // ATL_ANTLR3.g:989:6: 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,94,FOLLOW_94_in_priority_15470); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      opName = "not";
                    }
                    // ATL_ANTLR3.g:989:30: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // ATL_ANTLR3.g:989:31: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_15477);
                    ret=operatorCallExp(opName,  right,  firstToken);
                    _fsp--;
                    if (failed) return ret2;
                    pushFollow(FOLLOW_priority_0_in_priority_15482);
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
                    // ATL_ANTLR3.g:990:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // ATL_ANTLR3.g:990:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // ATL_ANTLR3.g:990:72: MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_priority_15490); if (failed) return ret2;
                    if ( backtracking==0 ) {
                      opName = "-";
                    }
                    // ATL_ANTLR3.g:990:94: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // ATL_ANTLR3.g:990:95: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_15497);
                    ret=operatorCallExp(opName,  right,  firstToken);
                    _fsp--;
                    if (failed) return ret2;
                    pushFollow(FOLLOW_priority_0_in_priority_15502);
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
                    // ATL_ANTLR3.g:991:71: (ret= priority_0 )
                    {
                    // ATL_ANTLR3.g:991:71: (ret= priority_0 )
                    // ATL_ANTLR3.g:991:72: ret= priority_0
                    {
                    pushFollow(FOLLOW_priority_0_in_priority_15512);
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
    // ATL_ANTLR3.g:998:1: priority_2 returns [Object ret2] : (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ;
    public final Object priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:999:2: ( (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            // ATL_ANTLR3.g:999:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            {
            // ATL_ANTLR3.g:999:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            // ATL_ANTLR3.g:999:5: ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_1_in_priority_25547);
            ret=priority_1();
            _fsp--;
            if (failed) return ret2;
            // ATL_ANTLR3.g:999:20: ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( ((LA114_0>=STAR && LA114_0<=SLASH)||(LA114_0>=95 && LA114_0<=96)) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // ATL_ANTLR3.g:999:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    {
            	    // ATL_ANTLR3.g:999:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    int alt113=4;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt113=1;
            	        }
            	        break;
            	    case SLASH:
            	        {
            	        alt113=2;
            	        }
            	        break;
            	    case 95:
            	        {
            	        alt113=3;
            	        }
            	        break;
            	    case 96:
            	        {
            	        alt113=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("999:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )", 113, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt113) {
            	        case 1 :
            	            // ATL_ANTLR3.g:999:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ATL_ANTLR3.g:999:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ATL_ANTLR3.g:999:23: STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,STAR,FOLLOW_STAR_in_priority_25552); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "*";
            	            }
            	            // ATL_ANTLR3.g:999:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ATL_ANTLR3.g:999:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25559);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25564);
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
            	            // ATL_ANTLR3.g:1000:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ATL_ANTLR3.g:1000:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ATL_ANTLR3.g:1000:72: SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,SLASH,FOLLOW_SLASH_in_priority_25572); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "/";
            	            }
            	            // ATL_ANTLR3.g:1000:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ATL_ANTLR3.g:1000:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25579);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25584);
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
            	            // ATL_ANTLR3.g:1001:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ATL_ANTLR3.g:1001:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ATL_ANTLR3.g:1001:72: 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,95,FOLLOW_95_in_priority_25592); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "div";
            	            }
            	            // ATL_ANTLR3.g:1001:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ATL_ANTLR3.g:1001:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25599);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25604);
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
            	            // ATL_ANTLR3.g:1002:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ATL_ANTLR3.g:1002:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ATL_ANTLR3.g:1002:72: 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,96,FOLLOW_96_in_priority_25612); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "mod";
            	            }
            	            // ATL_ANTLR3.g:1002:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ATL_ANTLR3.g:1002:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_25619);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_1_in_priority_25624);
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
    // $ANTLR end priority_2


    // $ANTLR start priority_3
    // ATL_ANTLR3.g:1010:1: priority_3 returns [Object ret2] : (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) ;
    public final Object priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1011:2: ( (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) )
            // ATL_ANTLR3.g:1011:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            {
            // ATL_ANTLR3.g:1011:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            // ATL_ANTLR3.g:1011:5: ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_2_in_priority_35665);
            ret=priority_2();
            _fsp--;
            if (failed) return ret2;
            // ATL_ANTLR3.g:1011:20: ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==MINUS||LA116_0==PLUS) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // ATL_ANTLR3.g:1011:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    {
            	    // ATL_ANTLR3.g:1011:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    int alt115=2;
            	    int LA115_0 = input.LA(1);

            	    if ( (LA115_0==PLUS) ) {
            	        alt115=1;
            	    }
            	    else if ( (LA115_0==MINUS) ) {
            	        alt115=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1011:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )", 115, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt115) {
            	        case 1 :
            	            // ATL_ANTLR3.g:1011:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // ATL_ANTLR3.g:1011:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // ATL_ANTLR3.g:1011:23: PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_priority_35670); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "+";
            	            }
            	            // ATL_ANTLR3.g:1011:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // ATL_ANTLR3.g:1011:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_35677);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_2_in_priority_35682);
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
            	            // ATL_ANTLR3.g:1012:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // ATL_ANTLR3.g:1012:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // ATL_ANTLR3.g:1012:72: MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_priority_35690); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "-";
            	            }
            	            // ATL_ANTLR3.g:1012:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // ATL_ANTLR3.g:1012:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_35697);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_2_in_priority_35702);
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
    // $ANTLR end priority_3


    // $ANTLR start priority_4
    // ATL_ANTLR3.g:1020:1: priority_4 returns [Object ret2] : (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* ) ;
    public final Object priority_4() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1021:2: ( (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* ) )
            // ATL_ANTLR3.g:1021:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            {
            // ATL_ANTLR3.g:1021:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            // ATL_ANTLR3.g:1021:5: ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_3_in_priority_45743);
            ret=priority_3();
            _fsp--;
            if (failed) return ret2;
            // ATL_ANTLR3.g:1021:20: ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==EQ||(LA118_0>=GT && LA118_0<=NE)) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // ATL_ANTLR3.g:1021:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ATL_ANTLR3.g:1021:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )
            	    int alt117=6;
            	    switch ( input.LA(1) ) {
            	    case EQ:
            	        {
            	        alt117=1;
            	        }
            	        break;
            	    case GT:
            	        {
            	        alt117=2;
            	        }
            	        break;
            	    case LT:
            	        {
            	        alt117=3;
            	        }
            	        break;
            	    case GE:
            	        {
            	        alt117=4;
            	        }
            	        break;
            	    case LE:
            	        {
            	        alt117=5;
            	        }
            	        break;
            	    case NE:
            	        {
            	        alt117=6;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1021:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )", 117, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt117) {
            	        case 1 :
            	            // ATL_ANTLR3.g:1021:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1021:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1021:23: EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,EQ,FOLLOW_EQ_in_priority_45748); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "=";
            	            }
            	            // ATL_ANTLR3.g:1021:42: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1021:43: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45755);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45760);
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
            	            // ATL_ANTLR3.g:1022:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1022:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1022:72: GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GT,FOLLOW_GT_in_priority_45768); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = ">";
            	            }
            	            // ATL_ANTLR3.g:1022:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1022:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45775);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45780);
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
            	            // ATL_ANTLR3.g:1023:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1023:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1023:72: LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LT,FOLLOW_LT_in_priority_45788); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "<";
            	            }
            	            // ATL_ANTLR3.g:1023:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1023:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45795);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45800);
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
            	            // ATL_ANTLR3.g:1024:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1024:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1024:72: GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GE,FOLLOW_GE_in_priority_45808); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = ">=";
            	            }
            	            // ATL_ANTLR3.g:1024:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1024:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45815);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45820);
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
            	            // ATL_ANTLR3.g:1025:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1025:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1025:72: LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LE,FOLLOW_LE_in_priority_45828); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "<=";
            	            }
            	            // ATL_ANTLR3.g:1025:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1025:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45835);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45840);
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
            	            // ATL_ANTLR3.g:1026:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ATL_ANTLR3.g:1026:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ATL_ANTLR3.g:1026:72: NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,NE,FOLLOW_NE_in_priority_45848); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "<>";
            	            }
            	            // ATL_ANTLR3.g:1026:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ATL_ANTLR3.g:1026:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_45855);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_3_in_priority_45860);
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
    // $ANTLR end priority_4


    // $ANTLR start priority_5
    // ATL_ANTLR3.g:1034:1: priority_5 returns [Object ret2] : (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ;
    public final Object priority_5() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1035:2: ( (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            // ATL_ANTLR3.g:1035:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            {
            // ATL_ANTLR3.g:1035:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            // ATL_ANTLR3.g:1035:5: ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_4_in_priority_55901);
            ret=priority_4();
            _fsp--;
            if (failed) return ret2;
            // ATL_ANTLR3.g:1035:20: ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( ((LA120_0>=97 && LA120_0<=100)) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // ATL_ANTLR3.g:1035:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // ATL_ANTLR3.g:1035:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    int alt119=4;
            	    switch ( input.LA(1) ) {
            	    case 97:
            	        {
            	        alt119=1;
            	        }
            	        break;
            	    case 98:
            	        {
            	        alt119=2;
            	        }
            	        break;
            	    case 99:
            	        {
            	        alt119=3;
            	        }
            	        break;
            	    case 100:
            	        {
            	        alt119=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return ret2;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1035:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )", 119, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt119) {
            	        case 1 :
            	            // ATL_ANTLR3.g:1035:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ATL_ANTLR3.g:1035:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ATL_ANTLR3.g:1035:23: 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,97,FOLLOW_97_in_priority_55906); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "and";
            	            }
            	            // ATL_ANTLR3.g:1035:47: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ATL_ANTLR3.g:1035:48: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55913);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55918);
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
            	            // ATL_ANTLR3.g:1036:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ATL_ANTLR3.g:1036:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ATL_ANTLR3.g:1036:72: 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,98,FOLLOW_98_in_priority_55926); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "or";
            	            }
            	            // ATL_ANTLR3.g:1036:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ATL_ANTLR3.g:1036:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55933);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55938);
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
            	            // ATL_ANTLR3.g:1037:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ATL_ANTLR3.g:1037:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ATL_ANTLR3.g:1037:72: 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,99,FOLLOW_99_in_priority_55946); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "xor";
            	            }
            	            // ATL_ANTLR3.g:1037:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ATL_ANTLR3.g:1037:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55953);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55958);
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
            	            // ATL_ANTLR3.g:1038:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ATL_ANTLR3.g:1038:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ATL_ANTLR3.g:1038:72: 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,100,FOLLOW_100_in_priority_55966); if (failed) return ret2;
            	            if ( backtracking==0 ) {
            	              opName = "implies";
            	            }
            	            // ATL_ANTLR3.g:1038:104: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ATL_ANTLR3.g:1038:105: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_55973);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;
            	            if (failed) return ret2;
            	            pushFollow(FOLLOW_priority_4_in_priority_55978);
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
            	    break loop120;
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
    // ATL_ANTLR3.g:1046:1: matchedRule_abstractContents returns [Object ret2] : ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) ;
    public final Object matchedRule_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MatchedRule", true, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1047:2: ( ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY ) )
            // ATL_ANTLR3.g:1047:4: ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            {
            // ATL_ANTLR3.g:1047:4: ( ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY )
            // ATL_ANTLR3.g:1047:5: ( ( 'nodefault' ) | () ) ( ( 'abstract' ) | () ) ( ( 'refining' ) | () ) 'rule' temp= identifier ( ( 'extends' temp= identifier ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) ) RCURLY
            {
            // ATL_ANTLR3.g:1047:5: ( ( 'nodefault' ) | () )
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==53) ) {
                alt121=1;
            }
            else if ( (LA121_0==45||(LA121_0>=54 && LA121_0<=55)) ) {
                alt121=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1047:5: ( ( 'nodefault' ) | () )", 121, 0, input);

                throw nvae;
            }
            switch (alt121) {
                case 1 :
                    // ATL_ANTLR3.g:1047:6: ( 'nodefault' )
                    {
                    // ATL_ANTLR3.g:1047:6: ( 'nodefault' )
                    // ATL_ANTLR3.g:1047:7: 'nodefault'
                    {
                    match(input,53,FOLLOW_53_in_matchedRule_abstractContents6019); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isNoDefault", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1047:75: ()
                    {
                    // ATL_ANTLR3.g:1047:75: ()
                    // ATL_ANTLR3.g:1047:76: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isNoDefault", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:1047:134: ( ( 'abstract' ) | () )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==54) ) {
                alt122=1;
            }
            else if ( (LA122_0==45||LA122_0==55) ) {
                alt122=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1047:134: ( ( 'abstract' ) | () )", 122, 0, input);

                throw nvae;
            }
            switch (alt122) {
                case 1 :
                    // ATL_ANTLR3.g:1047:135: ( 'abstract' )
                    {
                    // ATL_ANTLR3.g:1047:135: ( 'abstract' )
                    // ATL_ANTLR3.g:1047:136: 'abstract'
                    {
                    match(input,54,FOLLOW_54_in_matchedRule_abstractContents6033); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAbstract", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1047:202: ()
                    {
                    // ATL_ANTLR3.g:1047:202: ()
                    // ATL_ANTLR3.g:1047:203: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isAbstract", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:1047:260: ( ( 'refining' ) | () )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==45) ) {
                alt123=1;
            }
            else if ( (LA123_0==55) ) {
                alt123=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1047:260: ( ( 'refining' ) | () )", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // ATL_ANTLR3.g:1047:261: ( 'refining' )
                    {
                    // ATL_ANTLR3.g:1047:261: ( 'refining' )
                    // ATL_ANTLR3.g:1047:262: 'refining'
                    {
                    match(input,45,FOLLOW_45_in_matchedRule_abstractContents6047); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.TRUE);
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1047:328: ()
                    {
                    // ATL_ANTLR3.g:1047:328: ()
                    // ATL_ANTLR3.g:1047:329: 
                    {
                    }

                    if ( backtracking==0 ) {
                      ei.set(ret, "isRefining", java.lang.Boolean.FALSE);
                    }

                    }
                    break;

            }

            match(input,55,FOLLOW_55_in_matchedRule_abstractContents6059); if (failed) return ret2;
            pushFollow(FOLLOW_identifier_in_matchedRule_abstractContents6063);
            temp=identifier();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "name", temp);
            }
            // ATL_ANTLR3.g:1047:438: ( ( 'extends' temp= identifier ) | () )
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==56) ) {
                alt124=1;
            }
            else if ( (LA124_0==LCURLY) ) {
                alt124=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1047:438: ( ( 'extends' temp= identifier ) | () )", 124, 0, input);

                throw nvae;
            }
            switch (alt124) {
                case 1 :
                    // ATL_ANTLR3.g:1047:439: ( 'extends' temp= identifier )
                    {
                    // ATL_ANTLR3.g:1047:439: ( 'extends' temp= identifier )
                    // ATL_ANTLR3.g:1047:440: 'extends' temp= identifier
                    {
                    match(input,56,FOLLOW_56_in_matchedRule_abstractContents6069); if (failed) return ret2;
                    pushFollow(FOLLOW_identifier_in_matchedRule_abstractContents6073);
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
                    // ATL_ANTLR3.g:1047:564: ()
                    {
                    // ATL_ANTLR3.g:1047:564: ()
                    // ATL_ANTLR3.g:1047:565: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_matchedRule_abstractContents6087); if (failed) return ret2;
            // ATL_ANTLR3.g:1047:578: ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) ) )
            // ATL_ANTLR3.g:1047:579: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            {
            // ATL_ANTLR3.g:1047:579: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () ) )
            // ATL_ANTLR3.g:1047:580: temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ( (temp= outPattern ) | () ) ( (temp= actionBlock ) | () )
            {
            pushFollow(FOLLOW_inPattern_in_matchedRule_abstractContents6093);
            temp=inPattern();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "inPattern", temp);
            }
            // ATL_ANTLR3.g:1047:629: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==57) ) {
                alt127=1;
            }
            else if ( (LA127_0==RCURLY||LA127_0==63||LA127_0==68) ) {
                alt127=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1047:629: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )", 127, 0, input);

                throw nvae;
            }
            switch (alt127) {
                case 1 :
                    // ATL_ANTLR3.g:1047:630: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // ATL_ANTLR3.g:1047:630: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // ATL_ANTLR3.g:1047:631: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,57,FOLLOW_57_in_matchedRule_abstractContents6099); if (failed) return ret2;
                    match(input,LCURLY,FOLLOW_LCURLY_in_matchedRule_abstractContents6101); if (failed) return ret2;
                    // ATL_ANTLR3.g:1047:646: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // ATL_ANTLR3.g:1047:647: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // ATL_ANTLR3.g:1047:647: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // ATL_ANTLR3.g:1047:648: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // ATL_ANTLR3.g:1047:648: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt126=2;
                    int LA126_0 = input.LA(1);

                    if ( (LA126_0==NAME) ) {
                        alt126=1;
                    }
                    switch (alt126) {
                        case 1 :
                            // ATL_ANTLR3.g:1047:649: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // ATL_ANTLR3.g:1047:649: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // ATL_ANTLR3.g:1047:650: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6109);
                            temp=ruleVariableDeclaration();
                            _fsp--;
                            if (failed) return ret2;
                            if ( backtracking==0 ) {
                              ei.set(ret, "variables", temp);
                            }
                            // ATL_ANTLR3.g:1047:713: ( (temp= ruleVariableDeclaration ) )*
                            loop125:
                            do {
                                int alt125=2;
                                int LA125_0 = input.LA(1);

                                if ( (LA125_0==NAME) ) {
                                    alt125=1;
                                }


                                switch (alt125) {
                            	case 1 :
                            	    // ATL_ANTLR3.g:1047:714: (temp= ruleVariableDeclaration )
                            	    {
                            	    // ATL_ANTLR3.g:1047:714: (temp= ruleVariableDeclaration )
                            	    // ATL_ANTLR3.g:1047:715: temp= ruleVariableDeclaration
                            	    {
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6117);
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
                            	    break loop125;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_matchedRule_abstractContents6129); if (failed) return ret2;

                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1047:798: ()
                    {
                    // ATL_ANTLR3.g:1047:798: ()
                    // ATL_ANTLR3.g:1047:799: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:1047:805: ( (temp= outPattern ) | () )
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==63) ) {
                alt128=1;
            }
            else if ( (LA128_0==RCURLY||LA128_0==68) ) {
                alt128=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1047:805: ( (temp= outPattern ) | () )", 128, 0, input);

                throw nvae;
            }
            switch (alt128) {
                case 1 :
                    // ATL_ANTLR3.g:1047:806: (temp= outPattern )
                    {
                    // ATL_ANTLR3.g:1047:806: (temp= outPattern )
                    // ATL_ANTLR3.g:1047:807: temp= outPattern
                    {
                    pushFollow(FOLLOW_outPattern_in_matchedRule_abstractContents6145);
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
                    // ATL_ANTLR3.g:1047:863: ()
                    {
                    // ATL_ANTLR3.g:1047:863: ()
                    // ATL_ANTLR3.g:1047:864: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }

            // ATL_ANTLR3.g:1047:870: ( (temp= actionBlock ) | () )
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==68) ) {
                alt129=1;
            }
            else if ( (LA129_0==RCURLY) ) {
                alt129=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1047:870: ( (temp= actionBlock ) | () )", 129, 0, input);

                throw nvae;
            }
            switch (alt129) {
                case 1 :
                    // ATL_ANTLR3.g:1047:871: (temp= actionBlock )
                    {
                    // ATL_ANTLR3.g:1047:871: (temp= actionBlock )
                    // ATL_ANTLR3.g:1047:872: temp= actionBlock
                    {
                    pushFollow(FOLLOW_actionBlock_in_matchedRule_abstractContents6163);
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
                    // ATL_ANTLR3.g:1047:930: ()
                    {
                    // ATL_ANTLR3.g:1047:930: ()
                    // ATL_ANTLR3.g:1047:931: 
                    {
                    }

                    if ( backtracking==0 ) {
                    }

                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_matchedRule_abstractContents6179); if (failed) return ret2;

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
    // ATL_ANTLR3.g:1057:1: oclType_abstractContents returns [Object ret2] : ( 'OclType' ) ;
    public final Object oclType_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1058:2: ( ( 'OclType' ) )
            // ATL_ANTLR3.g:1058:4: ( 'OclType' )
            {
            // ATL_ANTLR3.g:1058:4: ( 'OclType' )
            // ATL_ANTLR3.g:1058:5: 'OclType'
            {
            match(input,86,FOLLOW_86_in_oclType_abstractContents6211); if (failed) return ret2;

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
    // ATL_ANTLR3.g:1068:1: collectionType_abstractContents returns [Object ret2] : ( 'Collection' LPAREN temp= oclType RPAREN ) ;
    public final Object collectionType_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CollectionType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ATL_ANTLR3.g:1069:2: ( ( 'Collection' LPAREN temp= oclType RPAREN ) )
            // ATL_ANTLR3.g:1069:4: ( 'Collection' LPAREN temp= oclType RPAREN )
            {
            // ATL_ANTLR3.g:1069:4: ( 'Collection' LPAREN temp= oclType RPAREN )
            // ATL_ANTLR3.g:1069:5: 'Collection' LPAREN temp= oclType RPAREN
            {
            match(input,93,FOLLOW_93_in_collectionType_abstractContents6243); if (failed) return ret2;
            match(input,LPAREN,FOLLOW_LPAREN_in_collectionType_abstractContents6245); if (failed) return ret2;
            pushFollow(FOLLOW_oclType_in_collectionType_abstractContents6249);
            temp=oclType();
            _fsp--;
            if (failed) return ret2;
            if ( backtracking==0 ) {
              ei.set(ret, "elementType", temp);
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_collectionType_abstractContents6253); if (failed) return ret2;

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
    // ATL_ANTLR3.g:1079:1: primary_oclExpression returns [Object ret2] : ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType ) ;
    public final Object primary_oclExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ATL_ANTLR3.g:1080:2: ( ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType ) )
            // ATL_ANTLR3.g:1080:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )
            {
            // ATL_ANTLR3.g:1080:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )
            int alt130=11;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt130=1;
                }
                break;
            case NAME:
                {
                int LA130_2 = input.LA(2);

                if ( (LA130_2==EOF||(LA130_2>=SEMI && LA130_2<=EQ)||LA130_2==RPAREN||(LA130_2>=RCURLY && LA130_2<=LARROW)||LA130_2==PIPE||(LA130_2>=POINT && LA130_2<=NE)||LA130_2==62||LA130_2==70||(LA130_2>=76 && LA130_2<=77)||(LA130_2>=95 && LA130_2<=100)) ) {
                    alt130=2;
                }
                else if ( (LA130_2==EXCL) ) {
                    alt130=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1080:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 130, 2, input);

                    throw nvae;
                }
                }
                break;
            case 73:
                {
                alt130=3;
                }
                break;
            case STRING:
            case INT:
            case FLOAT:
            case 74:
            case 75:
                {
                alt130=4;
                }
                break;
            case 69:
                {
                alt130=5;
                }
                break;
            case 78:
                {
                alt130=6;
                }
                break;
            case SHARP:
                {
                alt130=7;
                }
                break;
            case 80:
                {
                int LA130_8 = input.LA(2);

                if ( (LA130_8==LCURLY) ) {
                    alt130=8;
                }
                else if ( (LA130_8==LPAREN) ) {
                    alt130=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1080:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 130, 8, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA130_9 = input.LA(2);

                if ( (LA130_9==LPAREN) ) {
                    alt130=11;
                }
                else if ( (LA130_9==LCURLY) ) {
                    alt130=8;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1080:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 130, 9, input);

                    throw nvae;
                }
                }
                break;
            case 82:
                {
                int LA130_10 = input.LA(2);

                if ( (LA130_10==LCURLY) ) {
                    alt130=8;
                }
                else if ( (LA130_10==LPAREN) ) {
                    alt130=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1080:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 130, 10, input);

                    throw nvae;
                }
                }
                break;
            case 83:
                {
                int LA130_11 = input.LA(2);

                if ( (LA130_11==LPAREN) ) {
                    alt130=11;
                }
                else if ( (LA130_11==LCURLY) ) {
                    alt130=8;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1080:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 130, 11, input);

                    throw nvae;
                }
                }
                break;
            case 84:
                {
                int LA130_12 = input.LA(2);

                if ( (LA130_12==LCURLY) ) {
                    alt130=9;
                }
                else if ( (LA130_12==LPAREN) ) {
                    alt130=11;
                }
                else {
                    if (backtracking>0) {failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("1080:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 130, 12, input);

                    throw nvae;
                }
                }
                break;
            case 85:
                {
                alt130=10;
                }
                break;
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
                {
                alt130=11;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("1080:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= superExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 130, 0, input);

                throw nvae;
            }

            switch (alt130) {
                case 1 :
                    // ATL_ANTLR3.g:1080:5: ( LPAREN ret= oclExpression RPAREN )
                    {
                    // ATL_ANTLR3.g:1080:5: ( LPAREN ret= oclExpression RPAREN )
                    // ATL_ANTLR3.g:1080:6: LPAREN ret= oclExpression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_oclExpression6286); if (failed) return ret2;
                    pushFollow(FOLLOW_oclExpression_in_primary_oclExpression6290);
                    ret=oclExpression();
                    _fsp--;
                    if (failed) return ret2;
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_oclExpression6292); if (failed) return ret2;

                    }


                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1080:40: ret= variableExp
                    {
                    pushFollow(FOLLOW_variableExp_in_primary_oclExpression6298);
                    ret=variableExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:1080:57: ret= oclUndefinedExp
                    {
                    pushFollow(FOLLOW_oclUndefinedExp_in_primary_oclExpression6303);
                    ret=oclUndefinedExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:1080:78: ret= primitiveExp
                    {
                    pushFollow(FOLLOW_primitiveExp_in_primary_oclExpression6308);
                    ret=primitiveExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 5 :
                    // ATL_ANTLR3.g:1080:96: ret= ifExp
                    {
                    pushFollow(FOLLOW_ifExp_in_primary_oclExpression6313);
                    ret=ifExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 6 :
                    // ATL_ANTLR3.g:1080:107: ret= superExp
                    {
                    pushFollow(FOLLOW_superExp_in_primary_oclExpression6318);
                    ret=superExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 7 :
                    // ATL_ANTLR3.g:1080:121: ret= enumLiteralExp
                    {
                    pushFollow(FOLLOW_enumLiteralExp_in_primary_oclExpression6323);
                    ret=enumLiteralExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 8 :
                    // ATL_ANTLR3.g:1080:141: ret= collectionExp
                    {
                    pushFollow(FOLLOW_collectionExp_in_primary_oclExpression6328);
                    ret=collectionExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 9 :
                    // ATL_ANTLR3.g:1080:160: ret= mapExp
                    {
                    pushFollow(FOLLOW_mapExp_in_primary_oclExpression6333);
                    ret=mapExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 10 :
                    // ATL_ANTLR3.g:1080:172: ret= tupleExp
                    {
                    pushFollow(FOLLOW_tupleExp_in_primary_oclExpression6338);
                    ret=tupleExp();
                    _fsp--;
                    if (failed) return ret2;

                    }
                    break;
                case 11 :
                    // ATL_ANTLR3.g:1080:186: ret= oclType
                    {
                    pushFollow(FOLLOW_oclType_in_primary_oclExpression6343);
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

    // $ANTLR start synpred125
    public final void synpred125_fragment() throws RecognitionException {   
        // ATL_ANTLR3.g:406:6: ( ifStat )
        // ATL_ANTLR3.g:406:6: ifStat
        {
        pushFollow(FOLLOW_ifStat_in_synpred1252702);
        ifStat();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred125

    // $ANTLR start synpred126
    public final void synpred126_fragment() throws RecognitionException {   
        // ATL_ANTLR3.g:406:18: ( expressionStat )
        // ATL_ANTLR3.g:406:18: expressionStat
        {
        pushFollow(FOLLOW_expressionStat_in_synpred1262707);
        expressionStat();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred126

    // $ANTLR start synpred127
    public final void synpred127_fragment() throws RecognitionException {   
        // ATL_ANTLR3.g:406:38: ( bindingStat )
        // ATL_ANTLR3.g:406:38: bindingStat
        {
        pushFollow(FOLLOW_bindingStat_in_synpred1272712);
        bindingStat();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred127

    // $ANTLR start synpred135
    public final void synpred135_fragment() throws RecognitionException {   
        // ATL_ANTLR3.g:437:285: ( ( 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) ) ) )
        // ATL_ANTLR3.g:437:285: ( 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) ) )
        {
        // ATL_ANTLR3.g:437:285: ( 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) ) )
        // ATL_ANTLR3.g:437:286: 'else' ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) )
        {
        match(input,70,FOLLOW_70_in_synpred1352912); if (failed) return ;
        // ATL_ANTLR3.g:437:293: ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) )
        int alt163=2;
        int LA163_0 = input.LA(1);

        if ( ((LA163_0>=NAME && LA163_0<=FLOAT)||LA163_0==LPAREN||LA163_0==SHARP||LA163_0==MINUS||LA163_0==69||LA163_0==71||(LA163_0>=73 && LA163_0<=75)||(LA163_0>=78 && LA163_0<=94)) ) {
            alt163=1;
        }
        else if ( (LA163_0==LCURLY) ) {
            alt163=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("437:293: ( ( ( ( statement ) ) ) | ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY ) )", 163, 0, input);

            throw nvae;
        }
        switch (alt163) {
            case 1 :
                // ATL_ANTLR3.g:437:294: ( ( ( statement ) ) )
                {
                // ATL_ANTLR3.g:437:294: ( ( ( statement ) ) )
                // ATL_ANTLR3.g:437:295: ( ( statement ) )
                {
                // ATL_ANTLR3.g:437:295: ( ( statement ) )
                // ATL_ANTLR3.g:437:296: ( statement )
                {
                // ATL_ANTLR3.g:437:296: ( statement )
                // ATL_ANTLR3.g:437:297: statement
                {
                pushFollow(FOLLOW_statement_in_synpred1352920);
                statement();
                _fsp--;
                if (failed) return ;

                }


                }


                }


                }
                break;
            case 2 :
                // ATL_ANTLR3.g:437:358: ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY )
                {
                // ATL_ANTLR3.g:437:358: ( LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY )
                // ATL_ANTLR3.g:437:359: LCURLY ( ( ( ( statement ( ( statement ) )* ) )? ) ) RCURLY
                {
                match(input,LCURLY,FOLLOW_LCURLY_in_synpred1352931); if (failed) return ;
                // ATL_ANTLR3.g:437:366: ( ( ( ( statement ( ( statement ) )* ) )? ) )
                // ATL_ANTLR3.g:437:367: ( ( ( statement ( ( statement ) )* ) )? )
                {
                // ATL_ANTLR3.g:437:367: ( ( ( statement ( ( statement ) )* ) )? )
                // ATL_ANTLR3.g:437:368: ( ( statement ( ( statement ) )* ) )?
                {
                // ATL_ANTLR3.g:437:368: ( ( statement ( ( statement ) )* ) )?
                int alt162=2;
                int LA162_0 = input.LA(1);

                if ( ((LA162_0>=NAME && LA162_0<=FLOAT)||LA162_0==LPAREN||LA162_0==SHARP||LA162_0==MINUS||LA162_0==69||LA162_0==71||(LA162_0>=73 && LA162_0<=75)||(LA162_0>=78 && LA162_0<=94)) ) {
                    alt162=1;
                }
                switch (alt162) {
                    case 1 :
                        // ATL_ANTLR3.g:437:369: ( statement ( ( statement ) )* )
                        {
                        // ATL_ANTLR3.g:437:369: ( statement ( ( statement ) )* )
                        // ATL_ANTLR3.g:437:370: statement ( ( statement ) )*
                        {
                        pushFollow(FOLLOW_statement_in_synpred1352939);
                        statement();
                        _fsp--;
                        if (failed) return ;
                        // ATL_ANTLR3.g:437:424: ( ( statement ) )*
                        loop161:
                        do {
                            int alt161=2;
                            int LA161_0 = input.LA(1);

                            if ( ((LA161_0>=NAME && LA161_0<=FLOAT)||LA161_0==LPAREN||LA161_0==SHARP||LA161_0==MINUS||LA161_0==69||LA161_0==71||(LA161_0>=73 && LA161_0<=75)||(LA161_0>=78 && LA161_0<=94)) ) {
                                alt161=1;
                            }


                            switch (alt161) {
                        	case 1 :
                        	    // ATL_ANTLR3.g:437:425: ( statement )
                        	    {
                        	    // ATL_ANTLR3.g:437:425: ( statement )
                        	    // ATL_ANTLR3.g:437:426: statement
                        	    {
                        	    pushFollow(FOLLOW_statement_in_synpred1352947);
                        	    statement();
                        	    _fsp--;
                        	    if (failed) return ;

                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop161;
                            }
                        } while (true);


                        }


                        }
                        break;

                }


                }


                }

                match(input,RCURLY,FOLLOW_RCURLY_in_synpred1352959); if (failed) return ;

                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred135

    public final boolean synpred135() {
        backtracking++;
        int start = input.mark();
        try {
            synpred135_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred126() {
        backtracking++;
        int start = input.mark();
        try {
            synpred126_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred127() {
        backtracking++;
        int start = input.mark();
        try {
            synpred127_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred125() {
        backtracking++;
        int start = input.mark();
        try {
            synpred125_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


    protected DFA109 dfa109 = new DFA109(this);
    static final String DFA109_eotS =
        "\11\uffff";
    static final String DFA109_eofS =
        "\11\uffff";
    static final String DFA109_minS =
        "\1\4\1\14\1\uffff\1\4\1\uffff\1\11\1\4\1\uffff\1\11";
    static final String DFA109_maxS =
        "\1\110\1\14\1\uffff\1\136\1\uffff\1\144\1\136\1\uffff\1\144";
    static final String DFA109_acceptS =
        "\2\uffff\1\2\1\uffff\1\3\2\uffff\1\1\1\uffff";
    static final String DFA109_specialS =
        "\11\uffff}>";
    static final String[] DFA109_transitionS = {
            "\1\1\103\uffff\1\2",
            "\1\3",
            "",
            "\1\5\3\4\4\uffff\2\4\7\uffff\1\4\1\uffff\1\4\55\uffff\1\4\3"+
            "\uffff\3\4\2\uffff\21\4",
            "",
            "\1\6\1\4\2\uffff\1\4\2\uffff\1\4\2\uffff\1\4\1\7\1\uffff\12"+
            "\4\77\uffff\6\4",
            "\1\10\3\4\4\uffff\1\4\10\uffff\1\4\1\uffff\1\4\55\uffff\1\4"+
            "\3\uffff\3\4\2\uffff\21\4",
            "",
            "\1\6\1\4\2\uffff\1\4\2\uffff\1\4\2\uffff\1\4\1\7\1\uffff\12"+
            "\4\77\uffff\6\4"
    };

    static final short[] DFA109_eot = DFA.unpackEncodedString(DFA109_eotS);
    static final short[] DFA109_eof = DFA.unpackEncodedString(DFA109_eofS);
    static final char[] DFA109_min = DFA.unpackEncodedStringToUnsignedChars(DFA109_minS);
    static final char[] DFA109_max = DFA.unpackEncodedStringToUnsignedChars(DFA109_maxS);
    static final short[] DFA109_accept = DFA.unpackEncodedString(DFA109_acceptS);
    static final short[] DFA109_special = DFA.unpackEncodedString(DFA109_specialS);
    static final short[][] DFA109_transition;

    static {
        int numStates = DFA109_transitionS.length;
        DFA109_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA109_transition[i] = DFA.unpackEncodedString(DFA109_transitionS[i]);
        }
    }

    class DFA109 extends DFA {

        public DFA109(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 109;
            this.eot = DFA109_eot;
            this.eof = DFA109_eof;
            this.min = DFA109_min;
            this.max = DFA109_max;
            this.accept = DFA109_accept;
            this.special = DFA109_special;
            this.transition = DFA109_transition;
        }
        public String getDescription() {
            return "981:192: (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )";
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
    public static final BitSet FOLLOW_100_in_identifierOrKeyword422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_module_in_unit561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_library_in_unit566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_unit571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_module604 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_module608 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_module612 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_module614 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module620 = new BitSet(new long[]{0x0000600000000200L});
    public static final BitSet FOLLOW_COMA_in_module627 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module632 = new BitSet(new long[]{0x0000600000000200L});
    public static final BitSet FOLLOW_45_in_module643 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_46_in_module650 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module660 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_COMA_in_module667 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclModel_in_module672 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_SEMI_in_module681 = new BitSet(new long[]{0x3CE6200000000002L});
    public static final BitSet FOLLOW_libraryRef_in_module689 = new BitSet(new long[]{0x3CE6200000000002L});
    public static final BitSet FOLLOW_libraryRef_in_module697 = new BitSet(new long[]{0x3CE6200000000002L});
    public static final BitSet FOLLOW_moduleElement_in_module711 = new BitSet(new long[]{0x3CE4200000000002L});
    public static final BitSet FOLLOW_moduleElement_in_module719 = new BitSet(new long[]{0x3CE4200000000002L});
    public static final BitSet FOLLOW_47_in_library761 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_library765 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_library769 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_library777 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_library785 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_helper_in_library799 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_helper_in_library807 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_48_in_query849 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_query853 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_query857 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_query861 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_query865 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_query873 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_libraryRef_in_query881 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_helper_in_query895 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_helper_in_query903 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_49_in_libraryRef945 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_libraryRef949 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_libraryRef953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_helper_in_moduleElement988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_moduleElement993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_helper1026 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_oclFeatureDefinition_in_helper1030 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_helper1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclContextDefinition_in_oclFeatureDefinition1070 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_oclFeatureDefinition1084 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_oclFeatureDefinition1086 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_oclFeature_in_oclFeatureDefinition1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_oclContextDefinition1124 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_oclContextDefinition1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operation_in_oclFeature1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_oclFeature1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_operation1205 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_operation1209 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_parameter_in_operation1215 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_operation1222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parameter_in_operation1227 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_operation1237 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_operation1239 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_operation1243 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_operation1247 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_operation1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_parameter1291 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_parameter1295 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_parameter1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_attribute1335 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_attribute1339 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_attribute1343 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_attribute1347 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_attribute1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_calledRule_in_rule1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_matchedRule_in_rule1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lazyMatchedRule_in_matchedRule1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_matchedRule_abstractContents_in_matchedRule1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_lazyMatchedRule1473 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_lazyMatchedRule1485 = new BitSet(new long[]{0x00C0200000000000L});
    public static final BitSet FOLLOW_54_in_lazyMatchedRule1489 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_45_in_lazyMatchedRule1503 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_lazyMatchedRule1515 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lazyMatchedRule1519 = new BitSet(new long[]{0x0100000000004000L});
    public static final BitSet FOLLOW_56_in_lazyMatchedRule1525 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lazyMatchedRule1529 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_lazyMatchedRule1543 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_inPattern_in_lazyMatchedRule1549 = new BitSet(new long[]{0x8200000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_57_in_lazyMatchedRule1555 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_lazyMatchedRule1557 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1565 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_lazyMatchedRule1573 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RCURLY_in_lazyMatchedRule1585 = new BitSet(new long[]{0x8000000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_outPattern_in_lazyMatchedRule1601 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_actionBlock_in_lazyMatchedRule1619 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RCURLY_in_lazyMatchedRule1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ruleVariableDeclaration1669 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_ruleVariableDeclaration1673 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_ruleVariableDeclaration1677 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_ruleVariableDeclaration1681 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_ruleVariableDeclaration1685 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_ruleVariableDeclaration1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_calledRule1723 = new BitSet(new long[]{0x2080000000000000L});
    public static final BitSet FOLLOW_61_in_calledRule1737 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_calledRule1749 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_calledRule1753 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_calledRule1757 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_parameter_in_calledRule1763 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_calledRule1770 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parameter_in_calledRule1775 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_calledRule1785 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_calledRule1787 = new BitSet(new long[]{0x8200000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_57_in_calledRule1793 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_calledRule1795 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_calledRule1803 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_calledRule1811 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RCURLY_in_calledRule1823 = new BitSet(new long[]{0x8000000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_outPattern_in_calledRule1839 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_actionBlock_in_calledRule1857 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RCURLY_in_calledRule1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_inPattern1905 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inPatternElement_in_inPattern1913 = new BitSet(new long[]{0x0000000000001202L});
    public static final BitSet FOLLOW_COMA_in_inPattern1920 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inPatternElement_in_inPattern1925 = new BitSet(new long[]{0x0000000000001202L});
    public static final BitSet FOLLOW_LPAREN_in_inPattern1936 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_inPattern1942 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_inPattern1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleInPatternElement_in_inPatternElement1994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2028 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_simpleInPatternElement2032 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_simpleInPatternElement2036 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_simpleInPatternElement2042 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2048 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_COMA_in_simpleInPatternElement2055 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2060 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_63_in_outPattern2110 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000008L});
    public static final BitSet FOLLOW_dropPattern_in_outPattern2116 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_outPatternElement_in_outPattern2138 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_COMA_in_outPattern2145 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_outPatternElement_in_outPattern2150 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_simpleOutPatternElement_in_outPatternElement2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forEachOutPatternElement_in_outPatternElement2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2244 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_simpleOutPatternElement2248 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_simpleOutPatternElement2252 = new BitSet(new long[]{0x4000000000011002L,0x0000000000000001L});
    public static final BitSet FOLLOW_62_in_simpleOutPatternElement2258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2262 = new BitSet(new long[]{0x0000000000011002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_simpleOutPatternElement2278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2282 = new BitSet(new long[]{0x0000000000011002L});
    public static final BitSet FOLLOW_RARROW_in_simpleOutPatternElement2298 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_simpleOutPatternElement2300 = new BitSet(new long[]{0x0000000000A030F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_simpleOutPatternElement2306 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_simpleOutPatternElement2313 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_simpleOutPatternElement2318 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_simpleOutPatternElement2328 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LPAREN_in_simpleOutPatternElement2342 = new BitSet(new long[]{0xFFFFF80000002010L,0x0000001FFFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_simpleOutPatternElement2350 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_simpleOutPatternElement2357 = new BitSet(new long[]{0xFFFFF80000000010L,0x0000001FFFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_simpleOutPatternElement2362 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_simpleOutPatternElement2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_forEachOutPatternElement2418 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_forEachOutPatternElement2422 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_forEachOutPatternElement2424 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_forEachOutPatternElement2428 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_forEachOutPatternElement2432 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_forEachOutPatternElement2434 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_forEachOutPatternElement2438 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_forEachOutPatternElement2442 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_forEachOutPatternElement2446 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_forEachOutPatternElement2450 = new BitSet(new long[]{0x0000000000001002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_forEachOutPatternElement2454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_forEachOutPatternElement2458 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LPAREN_in_forEachOutPatternElement2474 = new BitSet(new long[]{0xFFFFF80000002010L,0x0000001FFFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_forEachOutPatternElement2482 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_forEachOutPatternElement2489 = new BitSet(new long[]{0xFFFFF80000000010L,0x0000001FFFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_forEachOutPatternElement2494 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_forEachOutPatternElement2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_binding2550 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_ASSIGNARROW_in_binding2556 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_LARROW_in_binding2563 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_binding2571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_dropPattern2605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_actionBlock2637 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_actionBlock2639 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_actionBlock2647 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_actionBlock2655 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_RCURLY_in_actionBlock2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_statement2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStat_in_statement2707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bindingStat_in_statement2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStat_in_statement2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclExpression_in_bindingStat2752 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_ASSIGNARROW_in_bindingStat2758 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_LARROW_in_bindingStat2765 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_bindingStat2773 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_bindingStat2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclExpression_in_expressionStat2811 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_expressionStat2815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ifStat2847 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_ifStat2849 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_ifStat2853 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_ifStat2857 = new BitSet(new long[]{0x0000000000A050F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_ifStat2865 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_LCURLY_in_ifStat2876 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_ifStat2884 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_ifStat2892 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_RCURLY_in_ifStat2904 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ifStat2912 = new BitSet(new long[]{0x0000000000A050F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_ifStat2920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_ifStat2931 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_ifStat2939 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_ifStat2947 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_RCURLY_in_ifStat2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_forStat3005 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_forStat3007 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_forStat3011 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_forStat3015 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_forStat3019 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_forStat3023 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_forStat3025 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_forStat3033 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_forStat3041 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_RCURLY_in_forStat3053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_oclModel3087 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_oclModel3091 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_oclModel3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_oclModelElement3131 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_EXCL_in_oclModelElement3135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_oclModelElement3139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_5_in_oclExpression3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letExp_in_oclExpression3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_iteratorExp3215 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_iteratorExp3219 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iteratorExp3225 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_COMA_in_iteratorExp3232 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iteratorExp3237 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_PIPE_in_iteratorExp3246 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_iteratorExp3252 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_iteratorExp3258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_iterateExp3291 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_iterateExp3293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iterateExp3299 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_COMA_in_iterateExp3306 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iterateExp3311 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_SEMI_in_iterateExp3320 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclaration_in_iterateExp3324 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_PIPE_in_iterateExp3328 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_iterateExp3334 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_iterateExp3340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_collectionOperationCallExp3375 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionOperationCallExp3379 = new BitSet(new long[]{0x0000000000A030F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_collectionOperationCallExp3385 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_collectionOperationCallExp3392 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_collectionOperationCallExp3397 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_collectionOperationCallExp3407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_operationCallExp3442 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_operationCallExp3446 = new BitSet(new long[]{0x0000000000A030F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_operationCallExp3452 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_operationCallExp3459 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_operationCallExp3464 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_operationCallExp3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_navigationOrAttributeCallExp3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_iterator3574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_oclUndefinedExp3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericExp_in_primitiveExp3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanExp_in_primitiveExp3648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExp_in_primitiveExp3653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerExp_in_numericExp3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realExp_in_numericExp3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_booleanExp3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_booleanExp3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_integerExp3774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatSymbol_in_realExp3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_stringExp3846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ifExp3880 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_ifExp3884 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ifExp3888 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_ifExp3894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ifExp3900 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_ifExp3906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ifExp3912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableExp3946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_superExp3980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_letExp4012 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclaration_in_letExp4016 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_letExp4020 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_letExp4026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableDeclaration4064 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_variableDeclaration4068 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_variableDeclaration4072 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_variableDeclaration4076 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_variableDeclaration4080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_enumLiteralExp4114 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_enumLiteralExp4118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bagExp_in_collectionExp4155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setExp_in_collectionExp4160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orderedSetExp_in_collectionExp4165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceExp_in_collectionExp4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_bagExp4203 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_bagExp4205 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_bagExp4211 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_bagExp4218 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_bagExp4223 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_bagExp4233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_setExp4265 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_setExp4267 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_setExp4273 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_setExp4280 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_setExp4285 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_setExp4295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_orderedSetExp4327 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_orderedSetExp4329 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_orderedSetExp4335 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_orderedSetExp4342 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_orderedSetExp4347 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_orderedSetExp4357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_sequenceExp4389 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_sequenceExp4391 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_sequenceExp4397 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_sequenceExp4404 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_sequenceExp4409 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_sequenceExp4419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_mapExp4451 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_mapExp4453 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_mapElement_in_mapExp4459 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_mapExp4466 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mapElement_in_mapExp4471 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_mapExp4481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_mapElement4513 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_mapElement4517 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMA_in_mapElement4521 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_mapElement4525 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_mapElement4529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_tupleExp4561 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_tupleExp4563 = new BitSet(new long[]{0xFFFFF80000008010L,0x0000001FFFFFFFFFL});
    public static final BitSet FOLLOW_tuplePart_in_tupleExp4569 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_COMA_in_tupleExp4576 = new BitSet(new long[]{0xFFFFF80000000010L,0x0000001FFFFFFFFFL});
    public static final BitSet FOLLOW_tuplePart_in_tupleExp4581 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_RCURLY_in_tupleExp4591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tuplePart4625 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COLON_in_tuplePart4631 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_tuplePart4635 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tuplePart4649 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_tuplePart4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclModelElement_in_oclType4690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclAnyType_in_oclType4695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleType_in_oclType4700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapType_in_oclType4705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitive_in_oclType4710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_oclType4715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclType_abstractContents_in_oclType4720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_oclAnyType4753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_tupleType4785 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_tupleType4787 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_tupleTypeAttribute_in_tupleType4793 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_tupleType4800 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_tupleTypeAttribute_in_tupleType4805 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_tupleType4815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tupleTypeAttribute4849 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_tupleTypeAttribute4853 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_tupleTypeAttribute4857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_mapType4891 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_mapType4893 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_mapType4897 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMA_in_mapType4901 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_mapType4905 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_mapType4909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericType_in_primitive4944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanType_in_primitive4949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringType_in_primitive4954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerType_in_numericType4990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realType_in_numericType4995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_integerType5028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_realType5060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_booleanType5092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_stringType5124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bagType_in_collectionType5159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setType_in_collectionType5164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orderedSetType_in_collectionType5169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceType_in_collectionType5174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_abstractContents_in_collectionType5179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_bagType5212 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_bagType5214 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_bagType5218 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_bagType5222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_setType5254 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_setType5256 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_setType5260 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_setType5264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_orderedSetType5296 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_orderedSetType5298 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_orderedSetType5302 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_orderedSetType5306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_sequenceType5338 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_sequenceType5340 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_sequenceType5344 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_sequenceType5348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_oclExpression_in_priority_05382 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_POINT_in_priority_05387 = new BitSet(new long[]{0xFFFFF80000000010L,0x0000001FFFFFFFFFL});
    public static final BitSet FOLLOW_operationCallExp_in_priority_05394 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_navigationOrAttributeCallExp_in_priority_05401 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_RARROW_in_priority_05409 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_iteratorExp_in_priority_05416 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_iterateExp_in_priority_05423 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_collectionOperationCallExp_in_priority_05430 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_94_in_priority_15470 = new BitSet(new long[]{0x00000000002010F0L,0x000000003FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_15477 = new BitSet(new long[]{0x00000000002010F0L,0x000000003FFF4E20L});
    public static final BitSet FOLLOW_priority_0_in_priority_15482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_priority_15490 = new BitSet(new long[]{0x00000000002010F0L,0x000000003FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_15497 = new BitSet(new long[]{0x00000000002010F0L,0x000000003FFF4E20L});
    public static final BitSet FOLLOW_priority_0_in_priority_15502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_0_in_priority_15512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_1_in_priority_25547 = new BitSet(new long[]{0x0000000003000002L,0x0000000180000000L});
    public static final BitSet FOLLOW_STAR_in_priority_25552 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25559 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_1_in_priority_25564 = new BitSet(new long[]{0x0000000003000002L,0x0000000180000000L});
    public static final BitSet FOLLOW_SLASH_in_priority_25572 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25579 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_1_in_priority_25584 = new BitSet(new long[]{0x0000000003000002L,0x0000000180000000L});
    public static final BitSet FOLLOW_95_in_priority_25592 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25599 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_1_in_priority_25604 = new BitSet(new long[]{0x0000000003000002L,0x0000000180000000L});
    public static final BitSet FOLLOW_96_in_priority_25612 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_25619 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_1_in_priority_25624 = new BitSet(new long[]{0x0000000003000002L,0x0000000180000000L});
    public static final BitSet FOLLOW_priority_2_in_priority_35665 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_PLUS_in_priority_35670 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_35677 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_2_in_priority_35682 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_MINUS_in_priority_35690 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_35697 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_2_in_priority_35702 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_priority_3_in_priority_45743 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_EQ_in_priority_45748 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45755 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_3_in_priority_45760 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_GT_in_priority_45768 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45775 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_3_in_priority_45780 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_LT_in_priority_45788 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45795 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_3_in_priority_45800 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_GE_in_priority_45808 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45815 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_3_in_priority_45820 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_LE_in_priority_45828 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45835 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_3_in_priority_45840 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_NE_in_priority_45848 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_45855 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_3_in_priority_45860 = new BitSet(new long[]{0x00000000F8000402L});
    public static final BitSet FOLLOW_priority_4_in_priority_55901 = new BitSet(new long[]{0x0000000000000002L,0x0000001E00000000L});
    public static final BitSet FOLLOW_97_in_priority_55906 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55913 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_4_in_priority_55918 = new BitSet(new long[]{0x0000000000000002L,0x0000001E00000000L});
    public static final BitSet FOLLOW_98_in_priority_55926 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55933 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_4_in_priority_55938 = new BitSet(new long[]{0x0000000000000002L,0x0000001E00000000L});
    public static final BitSet FOLLOW_99_in_priority_55946 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55953 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_4_in_priority_55958 = new BitSet(new long[]{0x0000000000000002L,0x0000001E00000000L});
    public static final BitSet FOLLOW_100_in_priority_55966 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_55973 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFF4E20L});
    public static final BitSet FOLLOW_priority_4_in_priority_55978 = new BitSet(new long[]{0x0000000000000002L,0x0000001E00000000L});
    public static final BitSet FOLLOW_53_in_matchedRule_abstractContents6019 = new BitSet(new long[]{0x00C0200000000000L});
    public static final BitSet FOLLOW_54_in_matchedRule_abstractContents6033 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_45_in_matchedRule_abstractContents6047 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_matchedRule_abstractContents6059 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_matchedRule_abstractContents6063 = new BitSet(new long[]{0x0100000000004000L});
    public static final BitSet FOLLOW_56_in_matchedRule_abstractContents6069 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_matchedRule_abstractContents6073 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_matchedRule_abstractContents6087 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_inPattern_in_matchedRule_abstractContents6093 = new BitSet(new long[]{0x8200000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_57_in_matchedRule_abstractContents6099 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURLY_in_matchedRule_abstractContents6101 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6109 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_matchedRule_abstractContents6117 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_RCURLY_in_matchedRule_abstractContents6129 = new BitSet(new long[]{0x8000000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_outPattern_in_matchedRule_abstractContents6145 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_actionBlock_in_matchedRule_abstractContents6163 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RCURLY_in_matchedRule_abstractContents6179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_oclType_abstractContents6211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_collectionType_abstractContents6243 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionType_abstractContents6245 = new BitSet(new long[]{0x0000000000000010L,0x000000003FDF0000L});
    public static final BitSet FOLLOW_oclType_in_collectionType_abstractContents6249 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_collectionType_abstractContents6253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_oclExpression6286 = new BitSet(new long[]{0x0000000000A010F0L,0x000000007FFFCE20L});
    public static final BitSet FOLLOW_oclExpression_in_primary_oclExpression6290 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_oclExpression6292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExp_in_primary_oclExpression6298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclUndefinedExp_in_primary_oclExpression6303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveExp_in_primary_oclExpression6308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifExp_in_primary_oclExpression6313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_superExp_in_primary_oclExpression6318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumLiteralExp_in_primary_oclExpression6323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionExp_in_primary_oclExpression6328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapExp_in_primary_oclExpression6333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleExp_in_primary_oclExpression6338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclType_in_primary_oclExpression6343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_synpred1252702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStat_in_synpred1262707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bindingStat_in_synpred1272712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred1352912 = new BitSet(new long[]{0x0000000000A050F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_synpred1352920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_synpred1352931 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_synpred1352939 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_statement_in_synpred1352947 = new BitSet(new long[]{0x0000000000A090F0L,0x000000007FFFCEA0L});
    public static final BitSet FOLLOW_RCURLY_in_synpred1352959 = new BitSet(new long[]{0x0000000000000002L});

}