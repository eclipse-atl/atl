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
// $ANTLR 3.0.1 D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g 2009-03-04 15:46:31
package org.eclipse.m2m.atl.dsls.tcs.injector;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public class ACG_ANTLR3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "LCURLY", "RCURLY", "COLONCOLON", "LPAREN", "COMA", "RPAREN", "EQ", "SEMI", "PIPE", "LSQUARE", "RSQUARE", "COLON", "POINT", "RARROW", "MINUS", "STAR", "SLASH", "PLUS", "GT", "LT", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "FLOAT", "EXCL", "SHARP", "QMARK", "LARROW", "COMMENT", "'acg'", "'startsWith'", "'function'", "'attribute'", "'asm'", "'name'", "'code'", "'mode'", "'foreach'", "'in'", "'variable'", "'named'", "'operation'", "'context'", "'if'", "'else'", "'let'", "'analyze'", "'report'", "'critic'", "'error'", "'warning'", "'field'", "'param'", "'new'", "'dup'", "'dup_x1'", "'pop'", "'swap'", "'iterate'", "'enditerate'", "'getasm'", "'findme'", "'pusht'", "'pushf'", "'push'", "'pushi'", "'pushd'", "'load'", "'store'", "'call'", "'supercall'", "'get'", "'set'", "'goto'", "'self'", "'last'", "'then'", "'endif'", "'OclUndefined'", "'Sequence'", "'true'", "'false'", "'not'", "'div'", "'mod'", "'isa'", "'and'", "'or'", "'xor'", "'implies'"
    };
    public static final int GE=27;
    public static final int LT=26;
    public static final int STAR=22;
    public static final int LSQUARE=16;
    public static final int SHARP=38;
    public static final int POINT=19;
    public static final int ESC=35;
    public static final int RARROW=20;
    public static final int LARROW=40;
    public static final int LCURLY=7;
    public static final int EXCL=37;
    public static final int FLOAT=36;
    public static final int INT=6;
    public static final int MINUS=21;
    public static final int RSQUARE=17;
    public static final int EOF=-1;
    public static final int COMA=11;
    public static final int SEMI=14;
    public static final int ALPHA=33;
    public static final int LPAREN=10;
    public static final int COLON=18;
    public static final int COLONCOLON=9;
    public static final int RPAREN=12;
    public static final int NAME=4;
    public static final int WS=31;
    public static final int SLASH=23;
    public static final int SNAME=34;
    public static final int RCURLY=8;
    public static final int GT=25;
    public static final int PLUS=24;
    public static final int PIPE=15;
    public static final int DIGIT=32;
    public static final int NL=30;
    public static final int EQ=13;
    public static final int COMMENT=41;
    public static final int QMARK=39;
    public static final int LE=28;
    public static final int STRING=5;
    public static final int NE=29;

        public ACG_ANTLR3Parser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g"; }


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
        ACG_ANTLR3Lexer lex = new 
        ACG_ANTLR3Lexer(input);
    						CommonTokenStream tokens = new CommonTokenStream(lex);
    						tokens.discardTokenType(WS);
    						tokens.discardTokenType(COMMENT);
    						tokens.discardTokenType(NL);
    						
        ACG_ANTLR3Parser parser = new 
        ACG_ANTLR3Parser(tokens);
    						parser.main();
    					}



    // $ANTLR start main
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:60:1: main returns [Object ret2] : ( (ret= aCG ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:61:2: ( ( (ret= aCG ) EOF ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:61:4: ( (ret= aCG ) EOF )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:61:4: ( (ret= aCG ) EOF )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:61:5: (ret= aCG ) EOF
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:61:5: (ret= aCG )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:61:6: ret= aCG
            {
            pushFollow(FOLLOW_aCG_in_main46);
            ret=aCG();
            _fsp--;


            }

            match(input,EOF,FOLLOW_EOF_in_main49); 

            }


                        ret2=ret;
                    

            }

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
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:68:1: identifier returns [Object ret2] : ast= NAME ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:69:2: (ast= NAME )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:69:4: ast= NAME
            {
            ast=(Token)input.LT(1);
            match(input,NAME,FOLLOW_NAME_in_identifier82); 
            ret = ast.getText(); ei.setToken((Object)ast);

                        ret2=ret;
                    

            }

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
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:76:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'acg' | 'startsWith' | 'function' | 'attribute' | 'asm' | 'name' | 'code' | 'mode' | 'foreach' | 'in' | 'variable' | 'named' | 'operation' | 'context' | 'if' | 'else' | 'let' | 'analyze' | 'report' | 'critic' | 'error' | 'warning' | 'field' | 'param' | 'new' | 'dup' | 'dup_x1' | 'pop' | 'swap' | 'iterate' | 'enditerate' | 'getasm' | 'findme' | 'pusht' | 'pushf' | 'push' | 'pushi' | 'pushd' | 'load' | 'store' | 'call' | 'supercall' | 'get' | 'set' | 'goto' | 'self' | 'last' | 'then' | 'endif' | 'OclUndefined' | 'Sequence' | 'true' | 'false' | 'not' | 'div' | 'mod' | 'isa' | 'and' | 'or' | 'xor' | 'implies' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:2: ( (ast= NAME | 'acg' | 'startsWith' | 'function' | 'attribute' | 'asm' | 'name' | 'code' | 'mode' | 'foreach' | 'in' | 'variable' | 'named' | 'operation' | 'context' | 'if' | 'else' | 'let' | 'analyze' | 'report' | 'critic' | 'error' | 'warning' | 'field' | 'param' | 'new' | 'dup' | 'dup_x1' | 'pop' | 'swap' | 'iterate' | 'enditerate' | 'getasm' | 'findme' | 'pusht' | 'pushf' | 'push' | 'pushi' | 'pushd' | 'load' | 'store' | 'call' | 'supercall' | 'get' | 'set' | 'goto' | 'self' | 'last' | 'then' | 'endif' | 'OclUndefined' | 'Sequence' | 'true' | 'false' | 'not' | 'div' | 'mod' | 'isa' | 'and' | 'or' | 'xor' | 'implies' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:4: (ast= NAME | 'acg' | 'startsWith' | 'function' | 'attribute' | 'asm' | 'name' | 'code' | 'mode' | 'foreach' | 'in' | 'variable' | 'named' | 'operation' | 'context' | 'if' | 'else' | 'let' | 'analyze' | 'report' | 'critic' | 'error' | 'warning' | 'field' | 'param' | 'new' | 'dup' | 'dup_x1' | 'pop' | 'swap' | 'iterate' | 'enditerate' | 'getasm' | 'findme' | 'pusht' | 'pushf' | 'push' | 'pushi' | 'pushd' | 'load' | 'store' | 'call' | 'supercall' | 'get' | 'set' | 'goto' | 'self' | 'last' | 'then' | 'endif' | 'OclUndefined' | 'Sequence' | 'true' | 'false' | 'not' | 'div' | 'mod' | 'isa' | 'and' | 'or' | 'xor' | 'implies' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:4: (ast= NAME | 'acg' | 'startsWith' | 'function' | 'attribute' | 'asm' | 'name' | 'code' | 'mode' | 'foreach' | 'in' | 'variable' | 'named' | 'operation' | 'context' | 'if' | 'else' | 'let' | 'analyze' | 'report' | 'critic' | 'error' | 'warning' | 'field' | 'param' | 'new' | 'dup' | 'dup_x1' | 'pop' | 'swap' | 'iterate' | 'enditerate' | 'getasm' | 'findme' | 'pusht' | 'pushf' | 'push' | 'pushi' | 'pushd' | 'load' | 'store' | 'call' | 'supercall' | 'get' | 'set' | 'goto' | 'self' | 'last' | 'then' | 'endif' | 'OclUndefined' | 'Sequence' | 'true' | 'false' | 'not' | 'div' | 'mod' | 'isa' | 'and' | 'or' | 'xor' | 'implies' )
            int alt1=62;
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
            case 99:
                {
                alt1=59;
                }
                break;
            case 100:
                {
                alt1=60;
                }
                break;
            case 101:
                {
                alt1=61;
                }
                break;
            case 102:
                {
                alt1=62;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("77:4: (ast= NAME | 'acg' | 'startsWith' | 'function' | 'attribute' | 'asm' | 'name' | 'code' | 'mode' | 'foreach' | 'in' | 'variable' | 'named' | 'operation' | 'context' | 'if' | 'else' | 'let' | 'analyze' | 'report' | 'critic' | 'error' | 'warning' | 'field' | 'param' | 'new' | 'dup' | 'dup_x1' | 'pop' | 'swap' | 'iterate' | 'enditerate' | 'getasm' | 'findme' | 'pusht' | 'pushf' | 'push' | 'pushi' | 'pushd' | 'load' | 'store' | 'call' | 'supercall' | 'get' | 'set' | 'goto' | 'self' | 'last' | 'then' | 'endif' | 'OclUndefined' | 'Sequence' | 'true' | 'false' | 'not' | 'div' | 'mod' | 'isa' | 'and' | 'or' | 'xor' | 'implies' )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:5: ast= NAME
                    {
                    ast=(Token)input.LT(1);
                    match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword117); 
                    ret = ast.getText(); ei.setToken((Object)ast);

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:64: 'acg'
                    {
                    match(input,42,FOLLOW_42_in_identifierOrKeyword122); 
                    ret = "acg";

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:86: 'startsWith'
                    {
                    match(input,43,FOLLOW_43_in_identifierOrKeyword127); 
                    ret = "startsWith";

                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:122: 'function'
                    {
                    match(input,44,FOLLOW_44_in_identifierOrKeyword132); 
                    ret = "function";

                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:154: 'attribute'
                    {
                    match(input,45,FOLLOW_45_in_identifierOrKeyword137); 
                    ret = "attribute";

                    }
                    break;
                case 6 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:188: 'asm'
                    {
                    match(input,46,FOLLOW_46_in_identifierOrKeyword142); 
                    ret = "asm";

                    }
                    break;
                case 7 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:210: 'name'
                    {
                    match(input,47,FOLLOW_47_in_identifierOrKeyword147); 
                    ret = "name";

                    }
                    break;
                case 8 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:234: 'code'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword152); 
                    ret = "code";

                    }
                    break;
                case 9 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:258: 'mode'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword157); 
                    ret = "mode";

                    }
                    break;
                case 10 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:282: 'foreach'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword162); 
                    ret = "foreach";

                    }
                    break;
                case 11 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:312: 'in'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword167); 
                    ret = "in";

                    }
                    break;
                case 12 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:332: 'variable'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword172); 
                    ret = "variable";

                    }
                    break;
                case 13 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:364: 'named'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword177); 
                    ret = "named";

                    }
                    break;
                case 14 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:390: 'operation'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword182); 
                    ret = "operation";

                    }
                    break;
                case 15 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:424: 'context'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword187); 
                    ret = "context";

                    }
                    break;
                case 16 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:454: 'if'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword192); 
                    ret = "if";

                    }
                    break;
                case 17 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:474: 'else'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword197); 
                    ret = "else";

                    }
                    break;
                case 18 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:498: 'let'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword202); 
                    ret = "let";

                    }
                    break;
                case 19 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:520: 'analyze'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword207); 
                    ret = "analyze";

                    }
                    break;
                case 20 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:550: 'report'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword212); 
                    ret = "report";

                    }
                    break;
                case 21 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:578: 'critic'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword217); 
                    ret = "critic";

                    }
                    break;
                case 22 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:606: 'error'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword222); 
                    ret = "error";

                    }
                    break;
                case 23 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:632: 'warning'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword227); 
                    ret = "warning";

                    }
                    break;
                case 24 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:662: 'field'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword232); 
                    ret = "field";

                    }
                    break;
                case 25 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:688: 'param'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword237); 
                    ret = "param";

                    }
                    break;
                case 26 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:714: 'new'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword242); 
                    ret = "new";

                    }
                    break;
                case 27 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:736: 'dup'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword247); 
                    ret = "dup";

                    }
                    break;
                case 28 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:758: 'dup_x1'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword252); 
                    ret = "dup_x1";

                    }
                    break;
                case 29 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:786: 'pop'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword257); 
                    ret = "pop";

                    }
                    break;
                case 30 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:808: 'swap'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword262); 
                    ret = "swap";

                    }
                    break;
                case 31 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:832: 'iterate'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword267); 
                    ret = "iterate";

                    }
                    break;
                case 32 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:862: 'enditerate'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword272); 
                    ret = "enditerate";

                    }
                    break;
                case 33 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:898: 'getasm'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword277); 
                    ret = "getasm";

                    }
                    break;
                case 34 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:926: 'findme'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword282); 
                    ret = "findme";

                    }
                    break;
                case 35 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:954: 'pusht'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword287); 
                    ret = "pusht";

                    }
                    break;
                case 36 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:980: 'pushf'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword292); 
                    ret = "pushf";

                    }
                    break;
                case 37 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1006: 'push'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword297); 
                    ret = "push";

                    }
                    break;
                case 38 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1030: 'pushi'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword302); 
                    ret = "pushi";

                    }
                    break;
                case 39 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1056: 'pushd'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword307); 
                    ret = "pushd";

                    }
                    break;
                case 40 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1082: 'load'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword312); 
                    ret = "load";

                    }
                    break;
                case 41 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1106: 'store'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword317); 
                    ret = "store";

                    }
                    break;
                case 42 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1132: 'call'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword322); 
                    ret = "call";

                    }
                    break;
                case 43 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1156: 'supercall'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword327); 
                    ret = "supercall";

                    }
                    break;
                case 44 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1190: 'get'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword332); 
                    ret = "get";

                    }
                    break;
                case 45 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1212: 'set'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword337); 
                    ret = "set";

                    }
                    break;
                case 46 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1234: 'goto'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword342); 
                    ret = "goto";

                    }
                    break;
                case 47 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1258: 'self'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword347); 
                    ret = "self";

                    }
                    break;
                case 48 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1282: 'last'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword352); 
                    ret = "last";

                    }
                    break;
                case 49 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1306: 'then'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword357); 
                    ret = "then";

                    }
                    break;
                case 50 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1330: 'endif'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword362); 
                    ret = "endif";

                    }
                    break;
                case 51 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1356: 'OclUndefined'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword367); 
                    ret = "OclUndefined";

                    }
                    break;
                case 52 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1396: 'Sequence'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword372); 
                    ret = "Sequence";

                    }
                    break;
                case 53 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1428: 'true'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword377); 
                    ret = "true";

                    }
                    break;
                case 54 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1452: 'false'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword382); 
                    ret = "false";

                    }
                    break;
                case 55 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1478: 'not'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword387); 
                    ret = "not";

                    }
                    break;
                case 56 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1500: 'div'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword392); 
                    ret = "div";

                    }
                    break;
                case 57 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1522: 'mod'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword397); 
                    ret = "mod";

                    }
                    break;
                case 58 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1544: 'isa'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword402); 
                    ret = "isa";

                    }
                    break;
                case 59 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1566: 'and'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword407); 
                    ret = "and";

                    }
                    break;
                case 60 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1588: 'or'
                    {
                    match(input,100,FOLLOW_100_in_identifierOrKeyword412); 
                    ret = "or";

                    }
                    break;
                case 61 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1608: 'xor'
                    {
                    match(input,101,FOLLOW_101_in_identifierOrKeyword417); 
                    ret = "xor";

                    }
                    break;
                case 62 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:77:1630: 'implies'
                    {
                    match(input,102,FOLLOW_102_in_identifierOrKeyword422); 
                    ret = "implies";

                    }
                    break;

            }


                        ret2=ret;
                    

            }

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
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:84:1: stringSymbol returns [Object ret2] : ast= STRING ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:85:2: (ast= STRING )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:85:4: ast= STRING
            {
            ast=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_stringSymbol457); 
            ret = ei.unescapeString(ast.getText(), 1); ei.setToken((Object)ast);

                        ret2=ret;
                    

            }

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
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:92:1: integerSymbol returns [Object ret2] : ast= INT ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:93:2: (ast= INT )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:93:4: ast= INT
            {
            ast=(Token)input.LT(1);
            match(input,INT,FOLLOW_INT_in_integerSymbol491); 
            ret = Integer.valueOf(ast.getText()); ei.setToken((Object)ast);

                        ret2=ret;
                    

            }

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


    // $ANTLR start aCG
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:100:1: aCG returns [Object ret2] : ( 'acg' temp= identifier 'startsWith' temp= identifier LCURLY ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) ) RCURLY ) ;
    public final Object aCG() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ACG", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:2: ( ( 'acg' temp= identifier 'startsWith' temp= identifier LCURLY ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:4: ( 'acg' temp= identifier 'startsWith' temp= identifier LCURLY ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:4: ( 'acg' temp= identifier 'startsWith' temp= identifier LCURLY ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:5: 'acg' temp= identifier 'startsWith' temp= identifier LCURLY ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) ) RCURLY
            {
            match(input,42,FOLLOW_42_in_aCG524); 
            pushFollow(FOLLOW_identifier_in_aCG528);
            temp=identifier();
            _fsp--;

            ei.set(ret, "metamodel", temp);
            match(input,43,FOLLOW_43_in_aCG532); 
            pushFollow(FOLLOW_identifier_in_aCG536);
            temp=identifier();
            _fsp--;

            ei.set(ret, "startsWith", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_aCG540); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:132: ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:133: ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:133: ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:134: ( (temp= aCGElement ( (temp= aCGElement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:134: ( (temp= aCGElement ( (temp= aCGElement ) )* ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NAME||(LA3_0>=44 && LA3_0<=46)||LA3_0==48) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:135: (temp= aCGElement ( (temp= aCGElement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:135: (temp= aCGElement ( (temp= aCGElement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:136: temp= aCGElement ( (temp= aCGElement ) )*
                    {
                    pushFollow(FOLLOW_aCGElement_in_aCG548);
                    temp=aCGElement();
                    _fsp--;

                    ei.set(ret, "elements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:185: ( (temp= aCGElement ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==NAME||(LA2_0>=44 && LA2_0<=46)||LA2_0==48) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:186: (temp= aCGElement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:186: (temp= aCGElement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:101:187: temp= aCGElement
                    	    {
                    	    pushFollow(FOLLOW_aCGElement_in_aCG556);
                    	    temp=aCGElement();
                    	    _fsp--;

                    	    ei.set(ret, "elements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_aCG568); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end aCG


    // $ANTLR start aCGElement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:111:1: aCGElement returns [Object ret2] : ( (ret= function | ret= attribute | ret= node ) ) ;
    public final Object aCGElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:112:2: ( ( (ret= function | ret= attribute | ret= node ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:112:4: ( (ret= function | ret= attribute | ret= node ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:112:4: ( (ret= function | ret= attribute | ret= node ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:112:5: (ret= function | ret= attribute | ret= node )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:112:5: (ret= function | ret= attribute | ret= node )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt4=1;
                }
                break;
            case 45:
                {
                alt4=2;
                }
                break;
            case NAME:
            case 46:
            case 48:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("112:5: (ret= function | ret= attribute | ret= node )", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:112:6: ret= function
                    {
                    pushFollow(FOLLOW_function_in_aCGElement603);
                    ret=function();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:112:20: ret= attribute
                    {
                    pushFollow(FOLLOW_attribute_in_aCGElement608);
                    ret=attribute();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:112:35: ret= node
                    {
                    pushFollow(FOLLOW_node_in_aCGElement613);
                    ret=node();
                    _fsp--;


                    }
                    break;

            }


            }


                        ei.addToContext(ret, false);
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end aCGElement


    // $ANTLR start function
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:120:1: function returns [Object ret2] : ( 'function' temp= identifier COLONCOLON temp= identifier LPAREN ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () ) RPAREN EQ temp= expression SEMI ) ;
    public final Object function() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Function", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:2: ( ( 'function' temp= identifier COLONCOLON temp= identifier LPAREN ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () ) RPAREN EQ temp= expression SEMI ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:4: ( 'function' temp= identifier COLONCOLON temp= identifier LPAREN ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () ) RPAREN EQ temp= expression SEMI )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:4: ( 'function' temp= identifier COLONCOLON temp= identifier LPAREN ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () ) RPAREN EQ temp= expression SEMI )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:5: 'function' temp= identifier COLONCOLON temp= identifier LPAREN ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () ) RPAREN EQ temp= expression SEMI
            {
            match(input,44,FOLLOW_44_in_function646); 
            pushFollow(FOLLOW_identifier_in_function650);
            temp=identifier();
            _fsp--;

            ei.set(ret, "context", temp);
            match(input,COLONCOLON,FOLLOW_COLONCOLON_in_function654); 
            pushFollow(FOLLOW_identifier_in_function658);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_function662); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:127: ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                alt6=1;
            }
            else if ( (LA6_0==RPAREN) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("121:127: ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:128: ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:128: ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:129: ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:129: ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:130: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:130: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:131: temp= parameter ( ( ( COMA ) temp= parameter ) )*
                    {
                    pushFollow(FOLLOW_parameter_in_function670);
                    temp=parameter();
                    _fsp--;

                    ei.set(ret, "parameters", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:181: ( ( ( COMA ) temp= parameter ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==COMA) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:182: ( ( COMA ) temp= parameter )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:182: ( ( COMA ) temp= parameter )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:183: ( COMA ) temp= parameter
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:183: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:184: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_function677); 

                    	    }

                    	    pushFollow(FOLLOW_parameter_in_function682);
                    	    temp=parameter();
                    	    _fsp--;

                    	    ei.set(ret, "parameters", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }


                    }


                    }



                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:250: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:250: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:121:251: 
                    {
                    }



                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_function701); 
            match(input,EQ,FOLLOW_EQ_in_function703); 
            pushFollow(FOLLOW_expression_in_function707);
            temp=expression();
            _fsp--;

            ei.set(ret, "body", temp);
            match(input,SEMI,FOLLOW_SEMI_in_function711); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end function


    // $ANTLR start attribute
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:131:1: attribute returns [Object ret2] : ( 'attribute' temp= identifier COLONCOLON temp= identifier EQ temp= expression SEMI ) ;
    public final Object attribute() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Attribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:132:2: ( ( 'attribute' temp= identifier COLONCOLON temp= identifier EQ temp= expression SEMI ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:132:4: ( 'attribute' temp= identifier COLONCOLON temp= identifier EQ temp= expression SEMI )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:132:4: ( 'attribute' temp= identifier COLONCOLON temp= identifier EQ temp= expression SEMI )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:132:5: 'attribute' temp= identifier COLONCOLON temp= identifier EQ temp= expression SEMI
            {
            match(input,45,FOLLOW_45_in_attribute743); 
            pushFollow(FOLLOW_identifier_in_attribute747);
            temp=identifier();
            _fsp--;

            ei.set(ret, "context", temp);
            match(input,COLONCOLON,FOLLOW_COLONCOLON_in_attribute751); 
            pushFollow(FOLLOW_identifier_in_attribute755);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,EQ,FOLLOW_EQ_in_attribute759); 
            pushFollow(FOLLOW_expression_in_attribute763);
            temp=expression();
            _fsp--;

            ei.set(ret, "body", temp);
            match(input,SEMI,FOLLOW_SEMI_in_attribute767); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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


    // $ANTLR start parameter
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:142:1: parameter returns [Object ret2] : (temp= identifier ) ;
    public final Object parameter() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Parameter", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:143:2: ( (temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:143:4: (temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:143:4: (temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:143:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_parameter801);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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


    // $ANTLR start node
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:153:1: node returns [Object ret2] : ( (ret= aSMNode | ret= codeNode | ret= simpleNode ) ) ;
    public final Object node() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:154:2: ( ( (ret= aSMNode | ret= codeNode | ret= simpleNode ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:154:4: ( (ret= aSMNode | ret= codeNode | ret= simpleNode ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:154:4: ( (ret= aSMNode | ret= codeNode | ret= simpleNode ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:154:5: (ret= aSMNode | ret= codeNode | ret= simpleNode )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:154:5: (ret= aSMNode | ret= codeNode | ret= simpleNode )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt7=1;
                }
                break;
            case 48:
                {
                alt7=2;
                }
                break;
            case NAME:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("154:5: (ret= aSMNode | ret= codeNode | ret= simpleNode )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:154:6: ret= aSMNode
                    {
                    pushFollow(FOLLOW_aSMNode_in_node838);
                    ret=aSMNode();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:154:19: ret= codeNode
                    {
                    pushFollow(FOLLOW_codeNode_in_node843);
                    ret=codeNode();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:154:33: ret= simpleNode
                    {
                    pushFollow(FOLLOW_simpleNode_in_node848);
                    ret=simpleNode();
                    _fsp--;


                    }
                    break;

            }


            }


                        ei.addToContext(ret, false);
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end node


    // $ANTLR start aSMNode
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:162:1: aSMNode returns [Object ret2] : ( 'asm' temp= identifier 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object aSMNode() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ASMNode", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:2: ( ( 'asm' temp= identifier 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:4: ( 'asm' temp= identifier 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:4: ( 'asm' temp= identifier 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:5: 'asm' temp= identifier 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,46,FOLLOW_46_in_aSMNode881); 
            pushFollow(FOLLOW_identifier_in_aSMNode885);
            temp=identifier();
            _fsp--;

            ei.set(ret, "element", temp);
            match(input,47,FOLLOW_47_in_aSMNode889); 
            pushFollow(FOLLOW_expression_in_aSMNode893);
            temp=expression();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_aSMNode897); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:118: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:119: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:119: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:120: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:120: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NAME||LA9_0==LSQUARE||LA9_0==50||LA9_0==52||LA9_0==54||LA9_0==56||(LA9_0>=58 && LA9_0<=60)||(LA9_0>=64 && LA9_0<=86)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:121: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:121: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:122: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_aSMNode905);
                    temp=statement();
                    _fsp--;

                    ei.set(ret, "statements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:172: ( (temp= statement ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==NAME||LA8_0==LSQUARE||LA8_0==50||LA8_0==52||LA8_0==54||LA8_0==56||(LA8_0>=58 && LA8_0<=60)||(LA8_0>=64 && LA8_0<=86)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:173: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:173: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:163:174: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_aSMNode913);
                    	    temp=statement();
                    	    _fsp--;

                    	    ei.set(ret, "statements", temp);

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

            match(input,RCURLY,FOLLOW_RCURLY_in_aSMNode925); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end aSMNode


    // $ANTLR start codeNode
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:173:1: codeNode returns [Object ret2] : ( 'code' temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object codeNode() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CodeNode", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:2: ( ( 'code' temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:4: ( 'code' temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:4: ( 'code' temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:5: 'code' temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,48,FOLLOW_48_in_codeNode957); 
            pushFollow(FOLLOW_identifier_in_codeNode961);
            temp=identifier();
            _fsp--;

            ei.set(ret, "element", temp);
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:60: ( ( 'mode' temp= identifier ) | () )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==49) ) {
                alt10=1;
            }
            else if ( (LA10_0==LCURLY||LA10_0==PIPE) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("174:60: ( ( 'mode' temp= identifier ) | () )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:61: ( 'mode' temp= identifier )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:61: ( 'mode' temp= identifier )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:62: 'mode' temp= identifier
                    {
                    match(input,49,FOLLOW_49_in_codeNode967); 
                    pushFollow(FOLLOW_identifier_in_codeNode971);
                    temp=identifier();
                    _fsp--;

                    ei.set(ret, "mode", temp);

                    }



                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:119: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:119: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:120: 
                    {
                    }



                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:126: ( ( PIPE temp= expression ) | () )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==PIPE) ) {
                alt11=1;
            }
            else if ( (LA11_0==LCURLY) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("174:126: ( ( PIPE temp= expression ) | () )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:127: ( PIPE temp= expression )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:127: ( PIPE temp= expression )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:128: PIPE temp= expression
                    {
                    match(input,PIPE,FOLLOW_PIPE_in_codeNode987); 
                    pushFollow(FOLLOW_expression_in_codeNode991);
                    temp=expression();
                    _fsp--;

                    ei.set(ret, "guard", temp);

                    }



                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:184: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:184: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:185: 
                    {
                    }



                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_codeNode1005); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:198: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:199: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:199: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:200: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:200: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NAME||LA13_0==LSQUARE||LA13_0==50||LA13_0==52||LA13_0==54||LA13_0==56||(LA13_0>=58 && LA13_0<=60)||(LA13_0>=64 && LA13_0<=86)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:201: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:201: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:202: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_codeNode1013);
                    temp=statement();
                    _fsp--;

                    ei.set(ret, "statements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:252: ( (temp= statement ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==NAME||LA12_0==LSQUARE||LA12_0==50||LA12_0==52||LA12_0==54||LA12_0==56||(LA12_0>=58 && LA12_0<=60)||(LA12_0>=64 && LA12_0<=86)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:253: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:253: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:174:254: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_codeNode1021);
                    	    temp=statement();
                    	    _fsp--;

                    	    ei.set(ret, "statements", temp);

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

            match(input,RCURLY,FOLLOW_RCURLY_in_codeNode1033); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end codeNode


    // $ANTLR start simpleNode
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:184:1: simpleNode returns [Object ret2] : (temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object simpleNode() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SimpleNode", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:2: ( (temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:4: (temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:4: (temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:5: temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            pushFollow(FOLLOW_identifier_in_simpleNode1067);
            temp=identifier();
            _fsp--;

            ei.set(ret, "element", temp);
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:53: ( ( 'mode' temp= identifier ) | () )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==49) ) {
                alt14=1;
            }
            else if ( (LA14_0==LCURLY||LA14_0==PIPE) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("185:53: ( ( 'mode' temp= identifier ) | () )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:54: ( 'mode' temp= identifier )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:54: ( 'mode' temp= identifier )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:55: 'mode' temp= identifier
                    {
                    match(input,49,FOLLOW_49_in_simpleNode1073); 
                    pushFollow(FOLLOW_identifier_in_simpleNode1077);
                    temp=identifier();
                    _fsp--;

                    ei.set(ret, "mode", temp);

                    }



                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:112: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:112: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:113: 
                    {
                    }



                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:119: ( ( PIPE temp= expression ) | () )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==PIPE) ) {
                alt15=1;
            }
            else if ( (LA15_0==LCURLY) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("185:119: ( ( PIPE temp= expression ) | () )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:120: ( PIPE temp= expression )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:120: ( PIPE temp= expression )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:121: PIPE temp= expression
                    {
                    match(input,PIPE,FOLLOW_PIPE_in_simpleNode1093); 
                    pushFollow(FOLLOW_expression_in_simpleNode1097);
                    temp=expression();
                    _fsp--;

                    ei.set(ret, "guard", temp);

                    }



                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:177: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:177: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:178: 
                    {
                    }



                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_simpleNode1111); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:191: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:192: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:192: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:193: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:193: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==NAME||LA17_0==LSQUARE||LA17_0==50||LA17_0==52||LA17_0==54||LA17_0==56||(LA17_0>=58 && LA17_0<=60)||(LA17_0>=64 && LA17_0<=86)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:194: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:194: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:195: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_simpleNode1119);
                    temp=statement();
                    _fsp--;

                    ei.set(ret, "statements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:245: ( (temp= statement ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==NAME||LA16_0==LSQUARE||LA16_0==50||LA16_0==52||LA16_0==54||LA16_0==56||(LA16_0>=58 && LA16_0<=60)||(LA16_0>=64 && LA16_0<=86)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:246: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:246: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:185:247: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_simpleNode1127);
                    	    temp=statement();
                    	    _fsp--;

                    	    ei.set(ret, "statements", temp);

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

            match(input,RCURLY,FOLLOW_RCURLY_in_simpleNode1139); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end simpleNode


    // $ANTLR start statement
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:195:1: statement returns [Object ret2] : ( (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat ) ) ;
    public final Object statement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:196:2: ( ( (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:196:4: ( (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:196:4: ( (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:196:5: (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:196:5: (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat )
            int alt18=5;
            switch ( input.LA(1) ) {
            case LSQUARE:
            case 50:
            case 52:
            case 54:
            case 58:
            case 59:
                {
                alt18=1;
                }
                break;
            case 56:
                {
                int LA18_2 = input.LA(2);

                if ( (LA18_2==LPAREN) ) {
                    alt18=1;
                }
                else if ( (LA18_2==NAME) ) {
                    alt18=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("196:5: (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat )", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case 60:
                {
                alt18=2;
                }
                break;
            case 64:
                {
                alt18=3;
                }
                break;
            case 65:
                {
                alt18=4;
                }
                break;
            case NAME:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
                {
                alt18=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("196:5: (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat )", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:196:6: ret= compoundStat
                    {
                    pushFollow(FOLLOW_compoundStat_in_statement1174);
                    ret=compoundStat();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:196:24: ret= reportStat
                    {
                    pushFollow(FOLLOW_reportStat_in_statement1179);
                    ret=reportStat();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:196:40: ret= fieldStat
                    {
                    pushFollow(FOLLOW_fieldStat_in_statement1184);
                    ret=fieldStat();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:196:55: ret= paramStat
                    {
                    pushFollow(FOLLOW_paramStat_in_statement1189);
                    ret=paramStat();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:196:70: ret= emitStat
                    {
                    pushFollow(FOLLOW_emitStat_in_statement1194);
                    ret=emitStat();
                    _fsp--;


                    }
                    break;

            }


            }


                        ei.addToContext(ret, false);
                        ret2=ret;
                    

            }

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


    // $ANTLR start compoundStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:204:1: compoundStat returns [Object ret2] : ( (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat ) ) ;
    public final Object compoundStat() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:2: ( ( (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:4: ( (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:4: ( (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:5: (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:5: (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat )
            int alt19=7;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt19=1;
                }
                break;
            case LSQUARE:
                {
                alt19=2;
                }
                break;
            case 52:
                {
                alt19=3;
                }
                break;
            case 54:
                {
                alt19=4;
                }
                break;
            case 56:
                {
                alt19=5;
                }
                break;
            case 58:
                {
                alt19=6;
                }
                break;
            case 59:
                {
                alt19=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("205:5: (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat )", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:6: ret= forEachStat
                    {
                    pushFollow(FOLLOW_forEachStat_in_compoundStat1230);
                    ret=forEachStat();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:23: ret= onceStat
                    {
                    pushFollow(FOLLOW_onceStat_in_compoundStat1235);
                    ret=onceStat();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:37: ret= variableStat
                    {
                    pushFollow(FOLLOW_variableStat_in_compoundStat1240);
                    ret=variableStat();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:55: ret= operationStat
                    {
                    pushFollow(FOLLOW_operationStat_in_compoundStat1245);
                    ret=operationStat();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:74: ret= conditionalStat
                    {
                    pushFollow(FOLLOW_conditionalStat_in_compoundStat1250);
                    ret=conditionalStat();
                    _fsp--;


                    }
                    break;
                case 6 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:95: ret= letStat
                    {
                    pushFollow(FOLLOW_letStat_in_compoundStat1255);
                    ret=letStat();
                    _fsp--;


                    }
                    break;
                case 7 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:205:108: ret= analyzeStat
                    {
                    pushFollow(FOLLOW_analyzeStat_in_compoundStat1260);
                    ret=analyzeStat();
                    _fsp--;


                    }
                    break;

            }


            }


                        ei.addToContext(ret, false);
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end compoundStat


    // $ANTLR start forEachStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:213:1: forEachStat returns [Object ret2] : ( 'foreach' LPAREN temp= variableDecl 'in' temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object forEachStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ForEachStat", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:2: ( ( 'foreach' LPAREN temp= variableDecl 'in' temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:4: ( 'foreach' LPAREN temp= variableDecl 'in' temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:4: ( 'foreach' LPAREN temp= variableDecl 'in' temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:5: 'foreach' LPAREN temp= variableDecl 'in' temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,50,FOLLOW_50_in_forEachStat1293); 
            match(input,LPAREN,FOLLOW_LPAREN_in_forEachStat1295); 
            pushFollow(FOLLOW_variableDecl_in_forEachStat1299);
            temp=variableDecl();
            _fsp--;

            ei.set(ret, "iterator", temp);
            match(input,51,FOLLOW_51_in_forEachStat1303); 
            pushFollow(FOLLOW_expression_in_forEachStat1307);
            temp=expression();
            _fsp--;

            ei.set(ret, "collection", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_forEachStat1311); 
            match(input,LCURLY,FOLLOW_LCURLY_in_forEachStat1313); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:143: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:144: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:144: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:145: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:145: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NAME||LA21_0==LSQUARE||LA21_0==50||LA21_0==52||LA21_0==54||LA21_0==56||(LA21_0>=58 && LA21_0<=60)||(LA21_0>=64 && LA21_0<=86)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:146: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:146: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:147: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_forEachStat1321);
                    temp=statement();
                    _fsp--;

                    ei.set(ret, "statements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:197: ( (temp= statement ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==NAME||LA20_0==LSQUARE||LA20_0==50||LA20_0==52||LA20_0==54||LA20_0==56||(LA20_0>=58 && LA20_0<=60)||(LA20_0>=64 && LA20_0<=86)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:198: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:198: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:214:199: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_forEachStat1329);
                    	    temp=statement();
                    	    _fsp--;

                    	    ei.set(ret, "statements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_forEachStat1341); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end forEachStat


    // $ANTLR start onceStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:224:1: onceStat returns [Object ret2] : ( LSQUARE ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RSQUARE ) ;
    public final Object onceStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OnceStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:2: ( ( LSQUARE ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RSQUARE ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:4: ( LSQUARE ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RSQUARE )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:4: ( LSQUARE ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RSQUARE )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:5: LSQUARE ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RSQUARE
            {
            match(input,LSQUARE,FOLLOW_LSQUARE_in_onceStat1373); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:13: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:14: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:14: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:15: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:15: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==NAME||LA23_0==LSQUARE||LA23_0==50||LA23_0==52||LA23_0==54||LA23_0==56||(LA23_0>=58 && LA23_0<=60)||(LA23_0>=64 && LA23_0<=86)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:16: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:16: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:17: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_onceStat1381);
                    temp=statement();
                    _fsp--;

                    ei.set(ret, "statements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:67: ( (temp= statement ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==NAME||LA22_0==LSQUARE||LA22_0==50||LA22_0==52||LA22_0==54||LA22_0==56||(LA22_0>=58 && LA22_0<=60)||(LA22_0>=64 && LA22_0<=86)) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:68: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:68: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:225:69: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_onceStat1389);
                    	    temp=statement();
                    	    _fsp--;

                    	    ei.set(ret, "statements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RSQUARE,FOLLOW_RSQUARE_in_onceStat1401); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end onceStat


    // $ANTLR start variableStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:235:1: variableStat returns [Object ret2] : ( 'variable' temp= expression 'named' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object variableStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:2: ( ( 'variable' temp= expression 'named' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:4: ( 'variable' temp= expression 'named' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:4: ( 'variable' temp= expression 'named' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:5: 'variable' temp= expression 'named' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,52,FOLLOW_52_in_variableStat1433); 
            pushFollow(FOLLOW_expression_in_variableStat1437);
            temp=expression();
            _fsp--;

            ei.set(ret, "definition", temp);
            match(input,53,FOLLOW_53_in_variableStat1441); 
            pushFollow(FOLLOW_expression_in_variableStat1445);
            temp=expression();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_variableStat1449); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:127: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:128: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:128: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:129: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:129: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==NAME||LA25_0==LSQUARE||LA25_0==50||LA25_0==52||LA25_0==54||LA25_0==56||(LA25_0>=58 && LA25_0<=60)||(LA25_0>=64 && LA25_0<=86)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:130: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:130: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:131: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_variableStat1457);
                    temp=statement();
                    _fsp--;

                    ei.set(ret, "statements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:181: ( (temp= statement ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==NAME||LA24_0==LSQUARE||LA24_0==50||LA24_0==52||LA24_0==54||LA24_0==56||(LA24_0>=58 && LA24_0<=60)||(LA24_0>=64 && LA24_0<=86)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:182: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:182: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:236:183: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_variableStat1465);
                    	    temp=statement();
                    	    _fsp--;

                    	    ei.set(ret, "statements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_variableStat1477); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end variableStat


    // $ANTLR start operationStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:246:1: operationStat returns [Object ret2] : ( 'operation' 'context' temp= expression 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object operationStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OperationStat", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:2: ( ( 'operation' 'context' temp= expression 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:4: ( 'operation' 'context' temp= expression 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:4: ( 'operation' 'context' temp= expression 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:5: 'operation' 'context' temp= expression 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,54,FOLLOW_54_in_operationStat1509); 
            match(input,55,FOLLOW_55_in_operationStat1511); 
            pushFollow(FOLLOW_expression_in_operationStat1515);
            temp=expression();
            _fsp--;

            ei.set(ret, "context", temp);
            match(input,47,FOLLOW_47_in_operationStat1519); 
            pushFollow(FOLLOW_expression_in_operationStat1523);
            temp=expression();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_operationStat1527); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:134: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:135: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:135: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:136: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:136: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==NAME||LA27_0==LSQUARE||LA27_0==50||LA27_0==52||LA27_0==54||LA27_0==56||(LA27_0>=58 && LA27_0<=60)||(LA27_0>=64 && LA27_0<=86)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:137: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:137: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:138: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_operationStat1535);
                    temp=statement();
                    _fsp--;

                    ei.set(ret, "statements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:188: ( (temp= statement ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==NAME||LA26_0==LSQUARE||LA26_0==50||LA26_0==52||LA26_0==54||LA26_0==56||(LA26_0>=58 && LA26_0<=60)||(LA26_0>=64 && LA26_0<=86)) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:189: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:189: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:247:190: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_operationStat1543);
                    	    temp=statement();
                    	    _fsp--;

                    	    ei.set(ret, "statements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_operationStat1555); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end operationStat


    // $ANTLR start conditionalStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:257:1: conditionalStat returns [Object ret2] : ( 'if' LPAREN temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) ) ;
    public final Object conditionalStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ConditionalStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:2: ( ( 'if' LPAREN temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:4: ( 'if' LPAREN temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:4: ( 'if' LPAREN temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:5: 'if' LPAREN temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () )
            {
            match(input,56,FOLLOW_56_in_conditionalStat1587); 
            match(input,LPAREN,FOLLOW_LPAREN_in_conditionalStat1589); 
            pushFollow(FOLLOW_expression_in_conditionalStat1593);
            temp=expression();
            _fsp--;

            ei.set(ret, "condition", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_conditionalStat1597); 
            match(input,LCURLY,FOLLOW_LCURLY_in_conditionalStat1599); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:81: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:82: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:82: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:83: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:83: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==NAME||LA29_0==LSQUARE||LA29_0==50||LA29_0==52||LA29_0==54||LA29_0==56||(LA29_0>=58 && LA29_0<=60)||(LA29_0>=64 && LA29_0<=86)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:84: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:84: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:85: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_conditionalStat1607);
                    temp=statement();
                    _fsp--;

                    ei.set(ret, "statements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:135: ( (temp= statement ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==NAME||LA28_0==LSQUARE||LA28_0==50||LA28_0==52||LA28_0==54||LA28_0==56||(LA28_0>=58 && LA28_0<=60)||(LA28_0>=64 && LA28_0<=86)) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:136: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:136: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:137: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_conditionalStat1615);
                    	    temp=statement();
                    	    _fsp--;

                    	    ei.set(ret, "statements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_conditionalStat1627); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:202: ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==57) ) {
                alt32=1;
            }
            else if ( (LA32_0==NAME||LA32_0==RCURLY||(LA32_0>=LSQUARE && LA32_0<=RSQUARE)||LA32_0==50||LA32_0==52||LA32_0==54||LA32_0==56||(LA32_0>=58 && LA32_0<=60)||(LA32_0>=64 && LA32_0<=86)) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("258:202: ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () )", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:203: ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:203: ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:204: 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
                    {
                    match(input,57,FOLLOW_57_in_conditionalStat1631); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_conditionalStat1633); 
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:218: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:219: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:219: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:220: ( (temp= statement ( (temp= statement ) )* ) )?
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:220: ( (temp= statement ( (temp= statement ) )* ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==NAME||LA31_0==LSQUARE||LA31_0==50||LA31_0==52||LA31_0==54||LA31_0==56||(LA31_0>=58 && LA31_0<=60)||(LA31_0>=64 && LA31_0<=86)) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:221: (temp= statement ( (temp= statement ) )* )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:221: (temp= statement ( (temp= statement ) )* )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:222: temp= statement ( (temp= statement ) )*
                            {
                            pushFollow(FOLLOW_statement_in_conditionalStat1641);
                            temp=statement();
                            _fsp--;

                            ei.set(ret, "elseStatements", temp);
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:276: ( (temp= statement ) )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==NAME||LA30_0==LSQUARE||LA30_0==50||LA30_0==52||LA30_0==54||LA30_0==56||(LA30_0>=58 && LA30_0<=60)||(LA30_0>=64 && LA30_0<=86)) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:277: (temp= statement )
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:277: (temp= statement )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:278: temp= statement
                            	    {
                            	    pushFollow(FOLLOW_statement_in_conditionalStat1649);
                            	    temp=statement();
                            	    _fsp--;

                            	    ei.set(ret, "elseStatements", temp);

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop30;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_conditionalStat1661); 

                    }



                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:352: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:352: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:258:353: 
                    {
                    }



                    }
                    break;

            }


            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end conditionalStat


    // $ANTLR start letStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:268:1: letStat returns [Object ret2] : ( 'let' temp= variableDecl EQ temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object letStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LetStat", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:2: ( ( 'let' temp= variableDecl EQ temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:4: ( 'let' temp= variableDecl EQ temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:4: ( 'let' temp= variableDecl EQ temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:5: 'let' temp= variableDecl EQ temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,58,FOLLOW_58_in_letStat1703); 
            pushFollow(FOLLOW_variableDecl_in_letStat1707);
            temp=variableDecl();
            _fsp--;

            ei.set(ret, "variable", temp);
            match(input,EQ,FOLLOW_EQ_in_letStat1711); 
            pushFollow(FOLLOW_expression_in_letStat1715);
            temp=expression();
            _fsp--;

            ei.set(ret, "value", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_letStat1719); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:118: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:119: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:119: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:120: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:120: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==NAME||LA34_0==LSQUARE||LA34_0==50||LA34_0==52||LA34_0==54||LA34_0==56||(LA34_0>=58 && LA34_0<=60)||(LA34_0>=64 && LA34_0<=86)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:121: (temp= statement ( (temp= statement ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:121: (temp= statement ( (temp= statement ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:122: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_letStat1727);
                    temp=statement();
                    _fsp--;

                    ei.set(ret, "statements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:172: ( (temp= statement ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==NAME||LA33_0==LSQUARE||LA33_0==50||LA33_0==52||LA33_0==54||LA33_0==56||(LA33_0>=58 && LA33_0<=60)||(LA33_0>=64 && LA33_0<=86)) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:173: (temp= statement )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:173: (temp= statement )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:269:174: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_letStat1735);
                    	    temp=statement();
                    	    _fsp--;

                    	    ei.set(ret, "statements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_letStat1747); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end letStat


    // $ANTLR start analyzeStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:279:1: analyzeStat returns [Object ret2] : ( 'analyze' temp= expression ( ( 'mode' temp= identifier ) | () ) ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) ) ;
    public final Object analyzeStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("AnalyzeStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:2: ( ( 'analyze' temp= expression ( ( 'mode' temp= identifier ) | () ) ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:4: ( 'analyze' temp= expression ( ( 'mode' temp= identifier ) | () ) ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:4: ( 'analyze' temp= expression ( ( 'mode' temp= identifier ) | () ) ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:5: 'analyze' temp= expression ( ( 'mode' temp= identifier ) | () ) ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () )
            {
            match(input,59,FOLLOW_59_in_analyzeStat1779); 
            pushFollow(FOLLOW_expression_in_analyzeStat1783);
            temp=expression();
            _fsp--;

            ei.set(ret, "target", temp);
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:62: ( ( 'mode' temp= identifier ) | () )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==49) ) {
                alt35=1;
            }
            else if ( (LA35_0==NAME||(LA35_0>=LCURLY && LA35_0<=RCURLY)||(LA35_0>=LSQUARE && LA35_0<=RSQUARE)||LA35_0==50||LA35_0==52||LA35_0==54||LA35_0==56||(LA35_0>=58 && LA35_0<=60)||(LA35_0>=64 && LA35_0<=86)) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("280:62: ( ( 'mode' temp= identifier ) | () )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:63: ( 'mode' temp= identifier )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:63: ( 'mode' temp= identifier )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:64: 'mode' temp= identifier
                    {
                    match(input,49,FOLLOW_49_in_analyzeStat1789); 
                    pushFollow(FOLLOW_identifier_in_analyzeStat1793);
                    temp=identifier();
                    _fsp--;

                    ei.set(ret, "mode", temp);

                    }



                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:121: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:121: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:122: 
                    {
                    }



                    }
                    break;

            }

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:128: ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==LCURLY) ) {
                alt38=1;
            }
            else if ( (LA38_0==NAME||LA38_0==RCURLY||(LA38_0>=LSQUARE && LA38_0<=RSQUARE)||LA38_0==50||LA38_0==52||LA38_0==54||LA38_0==56||(LA38_0>=58 && LA38_0<=60)||(LA38_0>=64 && LA38_0<=86)) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("280:128: ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:129: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:129: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:130: LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
                    {
                    match(input,LCURLY,FOLLOW_LCURLY_in_analyzeStat1809); 
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:137: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:138: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:138: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:139: ( (temp= statement ( (temp= statement ) )* ) )?
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:139: ( (temp= statement ( (temp= statement ) )* ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==NAME||LA37_0==LSQUARE||LA37_0==50||LA37_0==52||LA37_0==54||LA37_0==56||(LA37_0>=58 && LA37_0<=60)||(LA37_0>=64 && LA37_0<=86)) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:140: (temp= statement ( (temp= statement ) )* )
                            {
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:140: (temp= statement ( (temp= statement ) )* )
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:141: temp= statement ( (temp= statement ) )*
                            {
                            pushFollow(FOLLOW_statement_in_analyzeStat1817);
                            temp=statement();
                            _fsp--;

                            ei.set(ret, "statements", temp);
                            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:191: ( (temp= statement ) )*
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==NAME||LA36_0==LSQUARE||LA36_0==50||LA36_0==52||LA36_0==54||LA36_0==56||(LA36_0>=58 && LA36_0<=60)||(LA36_0>=64 && LA36_0<=86)) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:192: (temp= statement )
                            	    {
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:192: (temp= statement )
                            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:193: temp= statement
                            	    {
                            	    pushFollow(FOLLOW_statement_in_analyzeStat1825);
                            	    temp=statement();
                            	    _fsp--;

                            	    ei.set(ret, "statements", temp);

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


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_analyzeStat1837); 

                    }



                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:263: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:263: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:280:264: 
                    {
                    }



                    }
                    break;

            }


            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end analyzeStat


    // $ANTLR start reportStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:290:1: reportStat returns [Object ret2] : ( 'report' temp= severity temp= expression ) ;
    public final Object reportStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ReportStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:291:2: ( ( 'report' temp= severity temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:291:4: ( 'report' temp= severity temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:291:4: ( 'report' temp= severity temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:291:5: 'report' temp= severity temp= expression
            {
            match(input,60,FOLLOW_60_in_reportStat1879); 
            pushFollow(FOLLOW_severity_in_reportStat1883);
            temp=severity();
            _fsp--;

            ei.set(ret, "severity", temp);
            pushFollow(FOLLOW_expression_in_reportStat1889);
            temp=expression();
            _fsp--;

            ei.set(ret, "message", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end reportStat


    // $ANTLR start severity
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:301:1: severity returns [Object ret2] : ( ( 'critic' ) | ( 'error' ) | ( 'warning' ) ) ;
    public final Object severity() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:2: ( ( ( 'critic' ) | ( 'error' ) | ( 'warning' ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:4: ( ( 'critic' ) | ( 'error' ) | ( 'warning' ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:4: ( ( 'critic' ) | ( 'error' ) | ( 'warning' ) )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt39=1;
                }
                break;
            case 62:
                {
                alt39=2;
                }
                break;
            case 63:
                {
                alt39=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("302:4: ( ( 'critic' ) | ( 'error' ) | ( 'warning' ) )", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:5: ( 'critic' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:5: ( 'critic' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:6: 'critic'
                    {
                    match(input,61,FOLLOW_61_in_severity1924); 

                    }

                    ret = ei.createEnumLiteral("critic");

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:57: ( 'error' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:57: ( 'error' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:58: 'error'
                    {
                    match(input,62,FOLLOW_62_in_severity1931); 

                    }

                    ret = ei.createEnumLiteral("error");

                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:107: ( 'warning' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:107: ( 'warning' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:302:108: 'warning'
                    {
                    match(input,63,FOLLOW_63_in_severity1938); 

                    }

                    ret = ei.createEnumLiteral("warning");

                    }
                    break;

            }


                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end severity


    // $ANTLR start fieldStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:309:1: fieldStat returns [Object ret2] : ( 'field' temp= expression COLON temp= expression ) ;
    public final Object fieldStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("FieldStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:310:2: ( ( 'field' temp= expression COLON temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:310:4: ( 'field' temp= expression COLON temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:310:4: ( 'field' temp= expression COLON temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:310:5: 'field' temp= expression COLON temp= expression
            {
            match(input,64,FOLLOW_64_in_fieldStat1973); 
            pushFollow(FOLLOW_expression_in_fieldStat1977);
            temp=expression();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,COLON,FOLLOW_COLON_in_fieldStat1981); 
            pushFollow(FOLLOW_expression_in_fieldStat1985);
            temp=expression();
            _fsp--;

            ei.set(ret, "type", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end fieldStat


    // $ANTLR start paramStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:320:1: paramStat returns [Object ret2] : ( 'param' temp= expression COLON temp= expression ) ;
    public final Object paramStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ParamStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:321:2: ( ( 'param' temp= expression COLON temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:321:4: ( 'param' temp= expression COLON temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:321:4: ( 'param' temp= expression COLON temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:321:5: 'param' temp= expression COLON temp= expression
            {
            match(input,65,FOLLOW_65_in_paramStat2019); 
            pushFollow(FOLLOW_expression_in_paramStat2023);
            temp=expression();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,COLON,FOLLOW_COLON_in_paramStat2027); 
            pushFollow(FOLLOW_expression_in_paramStat2031);
            temp=expression();
            _fsp--;

            ei.set(ret, "type", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end paramStat


    // $ANTLR start emitStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:331:1: emitStat returns [Object ret2] : ( (ret= labelStat | ret= newStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat ) ) ;
    public final Object emitStat() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:2: ( ( (ret= labelStat | ret= newStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:4: ( (ret= labelStat | ret= newStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:4: ( (ret= labelStat | ret= newStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:5: (ret= labelStat | ret= newStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:5: (ret= labelStat | ret= newStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat )
            int alt40=14;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt40=1;
                }
                break;
            case 66:
                {
                alt40=2;
                }
                break;
            case 67:
                {
                alt40=3;
                }
                break;
            case 68:
                {
                alt40=4;
                }
                break;
            case 69:
                {
                alt40=5;
                }
                break;
            case 70:
                {
                alt40=6;
                }
                break;
            case 71:
                {
                alt40=7;
                }
                break;
            case 72:
                {
                alt40=8;
                }
                break;
            case 73:
                {
                alt40=9;
                }
                break;
            case 74:
                {
                alt40=10;
                }
                break;
            case 75:
                {
                alt40=11;
                }
                break;
            case 76:
                {
                alt40=12;
                }
                break;
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
                {
                alt40=13;
                }
                break;
            case 56:
            case 86:
                {
                alt40=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("332:5: (ret= labelStat | ret= newStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat )", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:6: ret= labelStat
                    {
                    pushFollow(FOLLOW_labelStat_in_emitStat2068);
                    ret=labelStat();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:21: ret= newStat
                    {
                    pushFollow(FOLLOW_newStat_in_emitStat2073);
                    ret=newStat();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:34: ret= dupStat
                    {
                    pushFollow(FOLLOW_dupStat_in_emitStat2078);
                    ret=dupStat();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:47: ret= dupX1Stat
                    {
                    pushFollow(FOLLOW_dupX1Stat_in_emitStat2083);
                    ret=dupX1Stat();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:62: ret= popStat
                    {
                    pushFollow(FOLLOW_popStat_in_emitStat2088);
                    ret=popStat();
                    _fsp--;


                    }
                    break;
                case 6 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:75: ret= swapStat
                    {
                    pushFollow(FOLLOW_swapStat_in_emitStat2093);
                    ret=swapStat();
                    _fsp--;


                    }
                    break;
                case 7 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:89: ret= iterateStat
                    {
                    pushFollow(FOLLOW_iterateStat_in_emitStat2098);
                    ret=iterateStat();
                    _fsp--;


                    }
                    break;
                case 8 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:106: ret= endIterateStat
                    {
                    pushFollow(FOLLOW_endIterateStat_in_emitStat2103);
                    ret=endIterateStat();
                    _fsp--;


                    }
                    break;
                case 9 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:126: ret= getAsmStat
                    {
                    pushFollow(FOLLOW_getAsmStat_in_emitStat2108);
                    ret=getAsmStat();
                    _fsp--;


                    }
                    break;
                case 10 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:142: ret= findMEStat
                    {
                    pushFollow(FOLLOW_findMEStat_in_emitStat2113);
                    ret=findMEStat();
                    _fsp--;


                    }
                    break;
                case 11 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:158: ret= pushTStat
                    {
                    pushFollow(FOLLOW_pushTStat_in_emitStat2118);
                    ret=pushTStat();
                    _fsp--;


                    }
                    break;
                case 12 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:173: ret= pushFStat
                    {
                    pushFollow(FOLLOW_pushFStat_in_emitStat2123);
                    ret=pushFStat();
                    _fsp--;


                    }
                    break;
                case 13 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:188: ret= emitWithOperandStat
                    {
                    pushFollow(FOLLOW_emitWithOperandStat_in_emitStat2128);
                    ret=emitWithOperandStat();
                    _fsp--;


                    }
                    break;
                case 14 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:332:213: ret= emitWithLabelRefStat
                    {
                    pushFollow(FOLLOW_emitWithLabelRefStat_in_emitStat2133);
                    ret=emitWithLabelRefStat();
                    _fsp--;


                    }
                    break;

            }


            }


                        ei.addToContext(ret, false);
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end emitStat


    // $ANTLR start labelStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:340:1: labelStat returns [Object ret2] : (temp= identifier ( ( LPAREN temp= expression RPAREN ) | () ) COLON ) ;
    public final Object labelStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LabelStat", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:2: ( (temp= identifier ( ( LPAREN temp= expression RPAREN ) | () ) COLON ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:4: (temp= identifier ( ( LPAREN temp= expression RPAREN ) | () ) COLON )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:4: (temp= identifier ( ( LPAREN temp= expression RPAREN ) | () ) COLON )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:5: temp= identifier ( ( LPAREN temp= expression RPAREN ) | () ) COLON
            {
            pushFollow(FOLLOW_identifier_in_labelStat2168);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:50: ( ( LPAREN temp= expression RPAREN ) | () )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==LPAREN) ) {
                alt41=1;
            }
            else if ( (LA41_0==COLON) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("341:50: ( ( LPAREN temp= expression RPAREN ) | () )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:51: ( LPAREN temp= expression RPAREN )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:51: ( LPAREN temp= expression RPAREN )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:52: LPAREN temp= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_labelStat2174); 
                    pushFollow(FOLLOW_expression_in_labelStat2178);
                    temp=expression();
                    _fsp--;

                    ei.set(ret, "id", temp);
                    match(input,RPAREN,FOLLOW_RPAREN_in_labelStat2182); 

                    }



                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:114: ()
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:114: ()
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:341:115: 
                    {
                    }



                    }
                    break;

            }

            match(input,COLON,FOLLOW_COLON_in_labelStat2194); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end labelStat


    // $ANTLR start newStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:351:1: newStat returns [Object ret2] : ( 'new' ) ;
    public final Object newStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("NewStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:352:2: ( ( 'new' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:352:4: ( 'new' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:352:4: ( 'new' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:352:5: 'new'
            {
            match(input,66,FOLLOW_66_in_newStat2226); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end newStat


    // $ANTLR start dupStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:362:1: dupStat returns [Object ret2] : ( 'dup' ) ;
    public final Object dupStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("DupStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:363:2: ( ( 'dup' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:363:4: ( 'dup' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:363:4: ( 'dup' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:363:5: 'dup'
            {
            match(input,67,FOLLOW_67_in_dupStat2258); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end dupStat


    // $ANTLR start dupX1Stat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:373:1: dupX1Stat returns [Object ret2] : ( 'dup_x1' ) ;
    public final Object dupX1Stat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("DupX1Stat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:374:2: ( ( 'dup_x1' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:374:4: ( 'dup_x1' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:374:4: ( 'dup_x1' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:374:5: 'dup_x1'
            {
            match(input,68,FOLLOW_68_in_dupX1Stat2290); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end dupX1Stat


    // $ANTLR start popStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:384:1: popStat returns [Object ret2] : ( 'pop' ) ;
    public final Object popStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("PopStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:385:2: ( ( 'pop' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:385:4: ( 'pop' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:385:4: ( 'pop' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:385:5: 'pop'
            {
            match(input,69,FOLLOW_69_in_popStat2322); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end popStat


    // $ANTLR start swapStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:395:1: swapStat returns [Object ret2] : ( 'swap' ) ;
    public final Object swapStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("SwapStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:396:2: ( ( 'swap' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:396:4: ( 'swap' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:396:4: ( 'swap' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:396:5: 'swap'
            {
            match(input,70,FOLLOW_70_in_swapStat2354); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end swapStat


    // $ANTLR start iterateStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:406:1: iterateStat returns [Object ret2] : ( 'iterate' ) ;
    public final Object iterateStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("IterateStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:407:2: ( ( 'iterate' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:407:4: ( 'iterate' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:407:4: ( 'iterate' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:407:5: 'iterate'
            {
            match(input,71,FOLLOW_71_in_iterateStat2386); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end iterateStat


    // $ANTLR start endIterateStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:417:1: endIterateStat returns [Object ret2] : ( 'enditerate' ) ;
    public final Object endIterateStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("EndIterateStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:418:2: ( ( 'enditerate' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:418:4: ( 'enditerate' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:418:4: ( 'enditerate' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:418:5: 'enditerate'
            {
            match(input,72,FOLLOW_72_in_endIterateStat2418); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end endIterateStat


    // $ANTLR start getAsmStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:428:1: getAsmStat returns [Object ret2] : ( 'getasm' ) ;
    public final Object getAsmStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("GetAsmStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:429:2: ( ( 'getasm' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:429:4: ( 'getasm' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:429:4: ( 'getasm' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:429:5: 'getasm'
            {
            match(input,73,FOLLOW_73_in_getAsmStat2450); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end getAsmStat


    // $ANTLR start findMEStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:439:1: findMEStat returns [Object ret2] : ( 'findme' ) ;
    public final Object findMEStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("FindMEStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:440:2: ( ( 'findme' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:440:4: ( 'findme' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:440:4: ( 'findme' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:440:5: 'findme'
            {
            match(input,74,FOLLOW_74_in_findMEStat2482); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end findMEStat


    // $ANTLR start pushTStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:450:1: pushTStat returns [Object ret2] : ( 'pusht' ) ;
    public final Object pushTStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("PushTStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:451:2: ( ( 'pusht' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:451:4: ( 'pusht' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:451:4: ( 'pusht' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:451:5: 'pusht'
            {
            match(input,75,FOLLOW_75_in_pushTStat2514); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end pushTStat


    // $ANTLR start pushFStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:461:1: pushFStat returns [Object ret2] : ( 'pushf' ) ;
    public final Object pushFStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("PushFStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:462:2: ( ( 'pushf' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:462:4: ( 'pushf' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:462:4: ( 'pushf' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:462:5: 'pushf'
            {
            match(input,76,FOLLOW_76_in_pushFStat2546); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end pushFStat


    // $ANTLR start emitWithOperandStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:472:1: emitWithOperandStat returns [Object ret2] : ( (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= superCallStat | ret= getStat | ret= setStat ) ) ;
    public final Object emitWithOperandStat() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:2: ( ( (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= superCallStat | ret= getStat | ret= setStat ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:4: ( (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= superCallStat | ret= getStat | ret= setStat ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:4: ( (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= superCallStat | ret= getStat | ret= setStat ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:5: (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= superCallStat | ret= getStat | ret= setStat )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:5: (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= superCallStat | ret= getStat | ret= setStat )
            int alt42=9;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt42=1;
                }
                break;
            case 78:
                {
                alt42=2;
                }
                break;
            case 79:
                {
                alt42=3;
                }
                break;
            case 80:
                {
                alt42=4;
                }
                break;
            case 81:
                {
                alt42=5;
                }
                break;
            case 82:
                {
                alt42=6;
                }
                break;
            case 83:
                {
                alt42=7;
                }
                break;
            case 84:
                {
                alt42=8;
                }
                break;
            case 85:
                {
                alt42=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("473:5: (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= superCallStat | ret= getStat | ret= setStat )", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:6: ret= pushStat
                    {
                    pushFollow(FOLLOW_pushStat_in_emitWithOperandStat2581);
                    ret=pushStat();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:20: ret= pushIStat
                    {
                    pushFollow(FOLLOW_pushIStat_in_emitWithOperandStat2586);
                    ret=pushIStat();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:35: ret= pushDStat
                    {
                    pushFollow(FOLLOW_pushDStat_in_emitWithOperandStat2591);
                    ret=pushDStat();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:50: ret= loadStat
                    {
                    pushFollow(FOLLOW_loadStat_in_emitWithOperandStat2596);
                    ret=loadStat();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:64: ret= storeStat
                    {
                    pushFollow(FOLLOW_storeStat_in_emitWithOperandStat2601);
                    ret=storeStat();
                    _fsp--;


                    }
                    break;
                case 6 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:79: ret= callStat
                    {
                    pushFollow(FOLLOW_callStat_in_emitWithOperandStat2606);
                    ret=callStat();
                    _fsp--;


                    }
                    break;
                case 7 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:93: ret= superCallStat
                    {
                    pushFollow(FOLLOW_superCallStat_in_emitWithOperandStat2611);
                    ret=superCallStat();
                    _fsp--;


                    }
                    break;
                case 8 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:112: ret= getStat
                    {
                    pushFollow(FOLLOW_getStat_in_emitWithOperandStat2616);
                    ret=getStat();
                    _fsp--;


                    }
                    break;
                case 9 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:473:125: ret= setStat
                    {
                    pushFollow(FOLLOW_setStat_in_emitWithOperandStat2621);
                    ret=setStat();
                    _fsp--;


                    }
                    break;

            }


            }


                        ei.addToContext(ret, false);
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end emitWithOperandStat


    // $ANTLR start pushStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:481:1: pushStat returns [Object ret2] : ( 'push' temp= expression ) ;
    public final Object pushStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("PushStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:482:2: ( ( 'push' temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:482:4: ( 'push' temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:482:4: ( 'push' temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:482:5: 'push' temp= expression
            {
            match(input,77,FOLLOW_77_in_pushStat2654); 
            pushFollow(FOLLOW_expression_in_pushStat2658);
            temp=expression();
            _fsp--;

            ei.set(ret, "operand", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end pushStat


    // $ANTLR start pushIStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:492:1: pushIStat returns [Object ret2] : ( 'pushi' temp= expression ) ;
    public final Object pushIStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("PushIStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:493:2: ( ( 'pushi' temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:493:4: ( 'pushi' temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:493:4: ( 'pushi' temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:493:5: 'pushi' temp= expression
            {
            match(input,78,FOLLOW_78_in_pushIStat2692); 
            pushFollow(FOLLOW_expression_in_pushIStat2696);
            temp=expression();
            _fsp--;

            ei.set(ret, "operand", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end pushIStat


    // $ANTLR start pushDStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:503:1: pushDStat returns [Object ret2] : ( 'pushd' temp= expression ) ;
    public final Object pushDStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("PushDStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:504:2: ( ( 'pushd' temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:504:4: ( 'pushd' temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:504:4: ( 'pushd' temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:504:5: 'pushd' temp= expression
            {
            match(input,79,FOLLOW_79_in_pushDStat2730); 
            pushFollow(FOLLOW_expression_in_pushDStat2734);
            temp=expression();
            _fsp--;

            ei.set(ret, "operand", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end pushDStat


    // $ANTLR start loadStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:514:1: loadStat returns [Object ret2] : ( 'load' temp= expression ) ;
    public final Object loadStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LoadStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:515:2: ( ( 'load' temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:515:4: ( 'load' temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:515:4: ( 'load' temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:515:5: 'load' temp= expression
            {
            match(input,80,FOLLOW_80_in_loadStat2768); 
            pushFollow(FOLLOW_expression_in_loadStat2772);
            temp=expression();
            _fsp--;

            ei.set(ret, "operand", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end loadStat


    // $ANTLR start storeStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:525:1: storeStat returns [Object ret2] : ( 'store' temp= expression ) ;
    public final Object storeStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("StoreStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:526:2: ( ( 'store' temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:526:4: ( 'store' temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:526:4: ( 'store' temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:526:5: 'store' temp= expression
            {
            match(input,81,FOLLOW_81_in_storeStat2806); 
            pushFollow(FOLLOW_expression_in_storeStat2810);
            temp=expression();
            _fsp--;

            ei.set(ret, "operand", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end storeStat


    // $ANTLR start callStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:536:1: callStat returns [Object ret2] : ( 'call' temp= expression ) ;
    public final Object callStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CallStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:537:2: ( ( 'call' temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:537:4: ( 'call' temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:537:4: ( 'call' temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:537:5: 'call' temp= expression
            {
            match(input,82,FOLLOW_82_in_callStat2844); 
            pushFollow(FOLLOW_expression_in_callStat2848);
            temp=expression();
            _fsp--;

            ei.set(ret, "operand", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end callStat


    // $ANTLR start superCallStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:547:1: superCallStat returns [Object ret2] : ( 'supercall' temp= expression ) ;
    public final Object superCallStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SuperCallStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:548:2: ( ( 'supercall' temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:548:4: ( 'supercall' temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:548:4: ( 'supercall' temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:548:5: 'supercall' temp= expression
            {
            match(input,83,FOLLOW_83_in_superCallStat2882); 
            pushFollow(FOLLOW_expression_in_superCallStat2886);
            temp=expression();
            _fsp--;

            ei.set(ret, "operand", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end superCallStat


    // $ANTLR start getStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:558:1: getStat returns [Object ret2] : ( 'get' temp= expression ) ;
    public final Object getStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("GetStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:559:2: ( ( 'get' temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:559:4: ( 'get' temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:559:4: ( 'get' temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:559:5: 'get' temp= expression
            {
            match(input,84,FOLLOW_84_in_getStat2920); 
            pushFollow(FOLLOW_expression_in_getStat2924);
            temp=expression();
            _fsp--;

            ei.set(ret, "operand", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end getStat


    // $ANTLR start setStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:569:1: setStat returns [Object ret2] : ( 'set' temp= expression ) ;
    public final Object setStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SetStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:570:2: ( ( 'set' temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:570:4: ( 'set' temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:570:4: ( 'set' temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:570:5: 'set' temp= expression
            {
            match(input,85,FOLLOW_85_in_setStat2958); 
            pushFollow(FOLLOW_expression_in_setStat2962);
            temp=expression();
            _fsp--;

            ei.set(ret, "operand", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end setStat


    // $ANTLR start emitWithLabelRefStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:580:1: emitWithLabelRefStat returns [Object ret2] : ( (ret= gotoStat | ret= ifStat ) ) ;
    public final Object emitWithLabelRefStat() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:581:2: ( ( (ret= gotoStat | ret= ifStat ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:581:4: ( (ret= gotoStat | ret= ifStat ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:581:4: ( (ret= gotoStat | ret= ifStat ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:581:5: (ret= gotoStat | ret= ifStat )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:581:5: (ret= gotoStat | ret= ifStat )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==86) ) {
                alt43=1;
            }
            else if ( (LA43_0==56) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("581:5: (ret= gotoStat | ret= ifStat )", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:581:6: ret= gotoStat
                    {
                    pushFollow(FOLLOW_gotoStat_in_emitWithLabelRefStat2999);
                    ret=gotoStat();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:581:20: ret= ifStat
                    {
                    pushFollow(FOLLOW_ifStat_in_emitWithLabelRefStat3004);
                    ret=ifStat();
                    _fsp--;


                    }
                    break;

            }


            }


                        ei.addToContext(ret, false);
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end emitWithLabelRefStat


    // $ANTLR start gotoStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:589:1: gotoStat returns [Object ret2] : ( 'goto' temp= identifier ) ;
    public final Object gotoStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("GotoStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:590:2: ( ( 'goto' temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:590:4: ( 'goto' temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:590:4: ( 'goto' temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:590:5: 'goto' temp= identifier
            {
            match(input,86,FOLLOW_86_in_gotoStat3037); 
            pushFollow(FOLLOW_identifier_in_gotoStat3041);
            temp=identifier();
            _fsp--;

            ei.setRef(ret, "label", "LabelStat", "name", temp, null, "never", null, false, null);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end gotoStat


    // $ANTLR start ifStat
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:600:1: ifStat returns [Object ret2] : ( 'if' temp= identifier ) ;
    public final Object ifStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IfStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:601:2: ( ( 'if' temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:601:4: ( 'if' temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:601:4: ( 'if' temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:601:5: 'if' temp= identifier
            {
            match(input,56,FOLLOW_56_in_ifStat3075); 
            pushFollow(FOLLOW_identifier_in_ifStat3079);
            temp=identifier();
            _fsp--;

            ei.setRef(ret, "label", "LabelStat", "name", temp, null, "never", null, false, null);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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


    // $ANTLR start variableDecl
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:611:1: variableDecl returns [Object ret2] : (temp= identifier ) ;
    public final Object variableDecl() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableDecl", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:612:2: ( (temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:612:4: (temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:612:4: (temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:612:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_variableDecl3115);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end variableDecl


    // $ANTLR start expression
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:622:1: expression returns [Object ret2] : (ret= priority_5 | ret= letExp ) ;
    public final Object expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:623:2: ( (ret= priority_5 | ret= letExp ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:623:4: (ret= priority_5 | ret= letExp )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:623:4: (ret= priority_5 | ret= letExp )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=NAME && LA44_0<=INT)||LA44_0==LPAREN||LA44_0==MINUS||LA44_0==56||(LA44_0>=87 && LA44_0<=88)||(LA44_0>=91 && LA44_0<=95)) ) {
                alt44=1;
            }
            else if ( (LA44_0==58) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("623:4: (ret= priority_5 | ret= letExp )", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:623:5: ret= priority_5
                    {
                    pushFollow(FOLLOW_priority_5_in_expression3151);
                    ret=priority_5();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:623:21: ret= letExp
                    {
                    pushFollow(FOLLOW_letExp_in_expression3156);
                    ret=letExp();
                    _fsp--;


                    }
                    break;

            }


                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end expression


    // $ANTLR start variableExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:630:1: variableExp returns [Object ret2] : (temp= identifier ) ;
    public final Object variableExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:631:2: ( (temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:631:4: (temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:631:4: (temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:631:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_variableExp3190);
            temp=identifier();
            _fsp--;

            ei.setRef(ret, "variable", "VariableDecl", "name", temp, null, "never", null, false, null);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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


    // $ANTLR start selfExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:641:1: selfExp returns [Object ret2] : ( 'self' ) ;
    public final Object selfExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("SelfExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:642:2: ( ( 'self' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:642:4: ( 'self' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:642:4: ( 'self' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:642:5: 'self'
            {
            match(input,87,FOLLOW_87_in_selfExp3224); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end selfExp


    // $ANTLR start lastExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:652:1: lastExp returns [Object ret2] : ( 'last' ) ;
    public final Object lastExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("LastExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:653:2: ( ( 'last' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:653:4: ( 'last' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:653:4: ( 'last' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:653:5: 'last'
            {
            match(input,88,FOLLOW_88_in_lastExp3256); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end lastExp


    // $ANTLR start ifExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:663:1: ifExp returns [Object ret2] : ( 'if' temp= expression 'then' temp= expression 'else' temp= expression 'endif' ) ;
    public final Object ifExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IfExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:664:2: ( ( 'if' temp= expression 'then' temp= expression 'else' temp= expression 'endif' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:664:4: ( 'if' temp= expression 'then' temp= expression 'else' temp= expression 'endif' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:664:4: ( 'if' temp= expression 'then' temp= expression 'else' temp= expression 'endif' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:664:5: 'if' temp= expression 'then' temp= expression 'else' temp= expression 'endif'
            {
            match(input,56,FOLLOW_56_in_ifExp3288); 
            pushFollow(FOLLOW_expression_in_ifExp3292);
            temp=expression();
            _fsp--;

            ei.set(ret, "condition", temp);
            match(input,89,FOLLOW_89_in_ifExp3296); 
            pushFollow(FOLLOW_expression_in_ifExp3300);
            temp=expression();
            _fsp--;

            ei.set(ret, "thenExp", temp);
            match(input,57,FOLLOW_57_in_ifExp3304); 
            pushFollow(FOLLOW_expression_in_ifExp3308);
            temp=expression();
            _fsp--;

            ei.set(ret, "elseExp", temp);
            match(input,90,FOLLOW_90_in_ifExp3312); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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


    // $ANTLR start isAExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:674:1: isAExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifier ) ;
    public final Object isAExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IsAExp", false, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:675:2: ( (temp= identifier ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:675:4: (temp= identifier )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:675:4: (temp= identifier )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:675:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_isAExp3347);
            temp=identifier();
            _fsp--;

            ei.set(ret, "type", temp);

            }


                        // discard operator name
                        ei.set(ret, "source", left);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ei.leaveContext(false);
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end isAExp


    // $ANTLR start letExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:687:1: letExp returns [Object ret2] : ( 'let' temp= variableDecl EQ temp= expression 'in' temp= expression ) ;
    public final Object letExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LetExp", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:688:2: ( ( 'let' temp= variableDecl EQ temp= expression 'in' temp= expression ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:688:4: ( 'let' temp= variableDecl EQ temp= expression 'in' temp= expression )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:688:4: ( 'let' temp= variableDecl EQ temp= expression 'in' temp= expression )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:688:5: 'let' temp= variableDecl EQ temp= expression 'in' temp= expression
            {
            match(input,58,FOLLOW_58_in_letExp3381); 
            pushFollow(FOLLOW_variableDecl_in_letExp3385);
            temp=variableDecl();
            _fsp--;

            ei.set(ret, "variable", temp);
            match(input,EQ,FOLLOW_EQ_in_letExp3389); 
            pushFollow(FOLLOW_expression_in_letExp3393);
            temp=expression();
            _fsp--;

            ei.set(ret, "value", temp);
            match(input,51,FOLLOW_51_in_letExp3397); 
            pushFollow(FOLLOW_expression_in_letExp3401);
            temp=expression();
            _fsp--;

            ei.set(ret, "in", temp);

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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


    // $ANTLR start navigationExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:698:1: navigationExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword ) ;
    public final Object navigationExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("NavigationExp", false, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:699:2: ( (temp= identifierOrKeyword ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:699:4: (temp= identifierOrKeyword )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:699:4: (temp= identifierOrKeyword )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:699:5: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_navigationExp3438);
            temp=identifierOrKeyword();
            _fsp--;

            ei.set(ret, "name", temp);

            }


                        // discard operator name
                        ei.set(ret, "source", left);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ei.leaveContext(false);
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end navigationExp


    // $ANTLR start iteratorExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:711:1: iteratorExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword LPAREN temp= variableDecl PIPE temp= expression RPAREN ) ;
    public final Object iteratorExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IteratorExp", true, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:712:2: ( (temp= identifierOrKeyword LPAREN temp= variableDecl PIPE temp= expression RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:712:4: (temp= identifierOrKeyword LPAREN temp= variableDecl PIPE temp= expression RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:712:4: (temp= identifierOrKeyword LPAREN temp= variableDecl PIPE temp= expression RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:712:5: temp= identifierOrKeyword LPAREN temp= variableDecl PIPE temp= expression RPAREN
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_iteratorExp3475);
            temp=identifierOrKeyword();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_iteratorExp3479); 
            pushFollow(FOLLOW_variableDecl_in_iteratorExp3483);
            temp=variableDecl();
            _fsp--;

            ei.set(ret, "iterator", temp);
            match(input,PIPE,FOLLOW_PIPE_in_iteratorExp3487); 
            pushFollow(FOLLOW_expression_in_iteratorExp3491);
            temp=expression();
            _fsp--;

            ei.set(ret, "body", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_iteratorExp3495); 

            }


                        // discard operator name
                        ei.set(ret, "source", left);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ei.leaveContext(true);
                        ret2=ret;
                    

            }

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


    // $ANTLR start operationCallExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:724:1: operationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword LPAREN ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RPAREN ) ;
    public final Object operationCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OperationCallExp", false, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:2: ( (temp= identifierOrKeyword LPAREN ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RPAREN ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:4: (temp= identifierOrKeyword LPAREN ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RPAREN )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:4: (temp= identifierOrKeyword LPAREN ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RPAREN )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:5: temp= identifierOrKeyword LPAREN ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_operationCallExp3530);
            temp=identifierOrKeyword();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_operationCallExp3534); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:66: ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=NAME && LA46_0<=INT)||LA46_0==LPAREN||LA46_0==MINUS||LA46_0==56||LA46_0==58||(LA46_0>=87 && LA46_0<=88)||(LA46_0>=91 && LA46_0<=95)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:67: (temp= expression ( ( ( COMA ) temp= expression ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:67: (temp= expression ( ( ( COMA ) temp= expression ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:68: temp= expression ( ( ( COMA ) temp= expression ) )*
                    {
                    pushFollow(FOLLOW_expression_in_operationCallExp3540);
                    temp=expression();
                    _fsp--;

                    ei.set(ret, "arguments", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:118: ( ( ( COMA ) temp= expression ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==COMA) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:119: ( ( COMA ) temp= expression )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:119: ( ( COMA ) temp= expression )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:120: ( COMA ) temp= expression
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:120: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:725:121: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_operationCallExp3547); 

                    	    }

                    	    pushFollow(FOLLOW_expression_in_operationCallExp3552);
                    	    temp=expression();
                    	    _fsp--;

                    	    ei.set(ret, "arguments", temp);

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

            match(input,RPAREN,FOLLOW_RPAREN_in_operationCallExp3562); 

            }


                        // discard operator name
                        ei.set(ret, "source", left);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ei.leaveContext(false);
                        ret2=ret;
                    

            }

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


    // $ANTLR start operatorCallExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:737:1: operatorCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object operatorCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OperatorCallExp", false, false) : null;
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:738:2: ()
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:739:9: 
            {

                        ei.set(ret, "name", opName);
                        ei.set(ret, "source", left);
                        // post actions performed in calling rule (i.e., priority_<n>)
                        ei.leaveContext(false);
                        ret2=ret;
                    

            }

        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end operatorCallExp


    // $ANTLR start literalExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:749:1: literalExp returns [Object ret2] : ( (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp ) ) ;
    public final Object literalExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:750:2: ( ( (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:750:4: ( (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:750:4: ( (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:750:5: (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:750:5: (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp )
            int alt47=5;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt47=1;
                }
                break;
            case 92:
                {
                alt47=2;
                }
                break;
            case 93:
            case 94:
                {
                alt47=3;
                }
                break;
            case INT:
                {
                alt47=4;
                }
                break;
            case STRING:
                {
                alt47=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("750:5: (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp )", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:750:6: ret= oclUndefinedExp
                    {
                    pushFollow(FOLLOW_oclUndefinedExp_in_literalExp3626);
                    ret=oclUndefinedExp();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:750:27: ret= collectionExp
                    {
                    pushFollow(FOLLOW_collectionExp_in_literalExp3631);
                    ret=collectionExp();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:750:46: ret= booleanExp
                    {
                    pushFollow(FOLLOW_booleanExp_in_literalExp3636);
                    ret=booleanExp();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:750:62: ret= integerExp
                    {
                    pushFollow(FOLLOW_integerExp_in_literalExp3641);
                    ret=integerExp();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:750:78: ret= stringExp
                    {
                    pushFollow(FOLLOW_stringExp_in_literalExp3646);
                    ret=stringExp();
                    _fsp--;


                    }
                    break;

            }


            }


                        ei.addToContext(ret, false);
                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end literalExp


    // $ANTLR start oclUndefinedExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:758:1: oclUndefinedExp returns [Object ret2] : ( 'OclUndefined' ) ;
    public final Object oclUndefinedExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclUndefinedExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:759:2: ( ( 'OclUndefined' ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:759:4: ( 'OclUndefined' )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:759:4: ( 'OclUndefined' )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:759:5: 'OclUndefined'
            {
            match(input,91,FOLLOW_91_in_oclUndefinedExp3679); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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


    // $ANTLR start collectionExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:769:1: collectionExp returns [Object ret2] : (ret= sequenceExp ) ;
    public final Object collectionExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:770:2: ( (ret= sequenceExp ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:770:4: (ret= sequenceExp )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:770:4: (ret= sequenceExp )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:770:5: ret= sequenceExp
            {
            pushFollow(FOLLOW_sequenceExp_in_collectionExp3713);
            ret=sequenceExp();
            _fsp--;


            }


                        ei.addToContext(ret, false);
                        ret2=ret;
                    

            }

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


    // $ANTLR start sequenceExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:778:1: sequenceExp returns [Object ret2] : ( 'Sequence' LCURLY ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RCURLY ) ;
    public final Object sequenceExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SequenceExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:2: ( ( 'Sequence' LCURLY ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RCURLY ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:4: ( 'Sequence' LCURLY ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RCURLY )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:4: ( 'Sequence' LCURLY ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RCURLY )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:5: 'Sequence' LCURLY ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RCURLY
            {
            match(input,92,FOLLOW_92_in_sequenceExp3745); 
            match(input,LCURLY,FOLLOW_LCURLY_in_sequenceExp3747); 
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:23: ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=NAME && LA49_0<=INT)||LA49_0==LPAREN||LA49_0==MINUS||LA49_0==56||LA49_0==58||(LA49_0>=87 && LA49_0<=88)||(LA49_0>=91 && LA49_0<=95)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:24: (temp= expression ( ( ( COMA ) temp= expression ) )* )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:24: (temp= expression ( ( ( COMA ) temp= expression ) )* )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:25: temp= expression ( ( ( COMA ) temp= expression ) )*
                    {
                    pushFollow(FOLLOW_expression_in_sequenceExp3753);
                    temp=expression();
                    _fsp--;

                    ei.set(ret, "elements", temp);
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:74: ( ( ( COMA ) temp= expression ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==COMA) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:75: ( ( COMA ) temp= expression )
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:75: ( ( COMA ) temp= expression )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:76: ( COMA ) temp= expression
                    	    {
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:76: ( COMA )
                    	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:779:77: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_sequenceExp3760); 

                    	    }

                    	    pushFollow(FOLLOW_expression_in_sequenceExp3765);
                    	    temp=expression();
                    	    _fsp--;

                    	    ei.set(ret, "elements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_sequenceExp3775); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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


    // $ANTLR start booleanExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:789:1: booleanExp returns [Object ret2] : ( ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object booleanExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("BooleanExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:2: ( ( ( ( 'true' ) | ( 'false' ) ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:4: ( ( ( 'true' ) | ( 'false' ) ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:4: ( ( ( 'true' ) | ( 'false' ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:5: ( ( 'true' ) | ( 'false' ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:5: ( ( 'true' ) | ( 'false' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==93) ) {
                alt50=1;
            }
            else if ( (LA50_0==94) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("790:5: ( ( 'true' ) | ( 'false' ) )", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:6: ( 'true' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:6: ( 'true' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:7: 'true'
                    {
                    match(input,93,FOLLOW_93_in_booleanExp3809); 

                    }

                    ei.set(ret, "value", java.lang.Boolean.TRUE);

                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:64: ( 'false' )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:64: ( 'false' )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:790:65: 'false'
                    {
                    match(input,94,FOLLOW_94_in_booleanExp3816); 

                    }

                    ei.set(ret, "value", java.lang.Boolean.FALSE);

                    }
                    break;

            }


            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:800:1: integerExp returns [Object ret2] : (temp= integerSymbol ) ;
    public final Object integerExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IntegerExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:801:2: ( (temp= integerSymbol ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:801:4: (temp= integerSymbol )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:801:4: (temp= integerSymbol )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:801:5: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_integerExp3854);
            temp=integerSymbol();
            _fsp--;

            ei.set(ret, "value", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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


    // $ANTLR start stringExp
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:811:1: stringExp returns [Object ret2] : (temp= stringSymbol ) ;
    public final Object stringExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("StringExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:812:2: ( (temp= stringSymbol ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:812:4: (temp= stringSymbol )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:812:4: (temp= stringSymbol )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:812:5: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_stringExp3890);
            temp=stringSymbol();
            _fsp--;

            ei.set(ret, "value", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
                        ret2=ret;
                    

            }

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


    // $ANTLR start priority_0
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:822:1: priority_0 returns [Object ret2] : (ret= primary_expression ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )* ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:2: ( (ret= primary_expression ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:4: (ret= primary_expression ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:4: (ret= primary_expression ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:5: ret= primary_expression ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )*
            {
            pushFollow(FOLLOW_primary_expression_in_priority_03926);
            ret=primary_expression();
            _fsp--;

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:28: ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( ((LA53_0>=POINT && LA53_0<=RARROW)) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:29: ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:29: ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) )
            	    int alt52=2;
            	    int LA52_0 = input.LA(1);

            	    if ( (LA52_0==POINT) ) {
            	        alt52=1;
            	    }
            	    else if ( (LA52_0==RARROW) ) {
            	        alt52=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("823:29: ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) )", 52, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt52) {
            	        case 1 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:30: ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:30: ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:31: POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )
            	            {
            	            match(input,POINT,FOLLOW_POINT_in_priority_03931); 
            	            opName = ".";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )
            	            int alt51=2;
            	            switch ( input.LA(1) ) {
            	            case NAME:
            	                {
            	                int LA51_1 = input.LA(2);

            	                if ( (LA51_1==NAME||(LA51_1>=LCURLY && LA51_1<=RCURLY)||(LA51_1>=COMA && LA51_1<=SEMI)||(LA51_1>=LSQUARE && LA51_1<=NE)||LA51_1==47||(LA51_1>=49 && LA51_1<=54)||(LA51_1>=56 && LA51_1<=60)||(LA51_1>=64 && LA51_1<=86)||(LA51_1>=89 && LA51_1<=90)||(LA51_1>=96 && LA51_1<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_1==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 1, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 42:
            	                {
            	                int LA51_2 = input.LA(2);

            	                if ( (LA51_2==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_2==NAME||(LA51_2>=LCURLY && LA51_2<=RCURLY)||(LA51_2>=COMA && LA51_2<=SEMI)||(LA51_2>=LSQUARE && LA51_2<=NE)||LA51_2==47||(LA51_2>=49 && LA51_2<=54)||(LA51_2>=56 && LA51_2<=60)||(LA51_2>=64 && LA51_2<=86)||(LA51_2>=89 && LA51_2<=90)||(LA51_2>=96 && LA51_2<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 2, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 43:
            	                {
            	                int LA51_3 = input.LA(2);

            	                if ( (LA51_3==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_3==NAME||(LA51_3>=LCURLY && LA51_3<=RCURLY)||(LA51_3>=COMA && LA51_3<=SEMI)||(LA51_3>=LSQUARE && LA51_3<=NE)||LA51_3==47||(LA51_3>=49 && LA51_3<=54)||(LA51_3>=56 && LA51_3<=60)||(LA51_3>=64 && LA51_3<=86)||(LA51_3>=89 && LA51_3<=90)||(LA51_3>=96 && LA51_3<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 3, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 44:
            	                {
            	                int LA51_4 = input.LA(2);

            	                if ( (LA51_4==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_4==NAME||(LA51_4>=LCURLY && LA51_4<=RCURLY)||(LA51_4>=COMA && LA51_4<=SEMI)||(LA51_4>=LSQUARE && LA51_4<=NE)||LA51_4==47||(LA51_4>=49 && LA51_4<=54)||(LA51_4>=56 && LA51_4<=60)||(LA51_4>=64 && LA51_4<=86)||(LA51_4>=89 && LA51_4<=90)||(LA51_4>=96 && LA51_4<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 4, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 45:
            	                {
            	                int LA51_5 = input.LA(2);

            	                if ( (LA51_5==NAME||(LA51_5>=LCURLY && LA51_5<=RCURLY)||(LA51_5>=COMA && LA51_5<=SEMI)||(LA51_5>=LSQUARE && LA51_5<=NE)||LA51_5==47||(LA51_5>=49 && LA51_5<=54)||(LA51_5>=56 && LA51_5<=60)||(LA51_5>=64 && LA51_5<=86)||(LA51_5>=89 && LA51_5<=90)||(LA51_5>=96 && LA51_5<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_5==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 5, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 46:
            	                {
            	                int LA51_6 = input.LA(2);

            	                if ( (LA51_6==NAME||(LA51_6>=LCURLY && LA51_6<=RCURLY)||(LA51_6>=COMA && LA51_6<=SEMI)||(LA51_6>=LSQUARE && LA51_6<=NE)||LA51_6==47||(LA51_6>=49 && LA51_6<=54)||(LA51_6>=56 && LA51_6<=60)||(LA51_6>=64 && LA51_6<=86)||(LA51_6>=89 && LA51_6<=90)||(LA51_6>=96 && LA51_6<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_6==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 6, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 47:
            	                {
            	                int LA51_7 = input.LA(2);

            	                if ( (LA51_7==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_7==NAME||(LA51_7>=LCURLY && LA51_7<=RCURLY)||(LA51_7>=COMA && LA51_7<=SEMI)||(LA51_7>=LSQUARE && LA51_7<=NE)||LA51_7==47||(LA51_7>=49 && LA51_7<=54)||(LA51_7>=56 && LA51_7<=60)||(LA51_7>=64 && LA51_7<=86)||(LA51_7>=89 && LA51_7<=90)||(LA51_7>=96 && LA51_7<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 7, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 48:
            	                {
            	                int LA51_8 = input.LA(2);

            	                if ( (LA51_8==NAME||(LA51_8>=LCURLY && LA51_8<=RCURLY)||(LA51_8>=COMA && LA51_8<=SEMI)||(LA51_8>=LSQUARE && LA51_8<=NE)||LA51_8==47||(LA51_8>=49 && LA51_8<=54)||(LA51_8>=56 && LA51_8<=60)||(LA51_8>=64 && LA51_8<=86)||(LA51_8>=89 && LA51_8<=90)||(LA51_8>=96 && LA51_8<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_8==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 8, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 49:
            	                {
            	                int LA51_9 = input.LA(2);

            	                if ( (LA51_9==NAME||(LA51_9>=LCURLY && LA51_9<=RCURLY)||(LA51_9>=COMA && LA51_9<=SEMI)||(LA51_9>=LSQUARE && LA51_9<=NE)||LA51_9==47||(LA51_9>=49 && LA51_9<=54)||(LA51_9>=56 && LA51_9<=60)||(LA51_9>=64 && LA51_9<=86)||(LA51_9>=89 && LA51_9<=90)||(LA51_9>=96 && LA51_9<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_9==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 9, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 50:
            	                {
            	                int LA51_10 = input.LA(2);

            	                if ( (LA51_10==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_10==NAME||(LA51_10>=LCURLY && LA51_10<=RCURLY)||(LA51_10>=COMA && LA51_10<=SEMI)||(LA51_10>=LSQUARE && LA51_10<=NE)||LA51_10==47||(LA51_10>=49 && LA51_10<=54)||(LA51_10>=56 && LA51_10<=60)||(LA51_10>=64 && LA51_10<=86)||(LA51_10>=89 && LA51_10<=90)||(LA51_10>=96 && LA51_10<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 10, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 51:
            	                {
            	                int LA51_11 = input.LA(2);

            	                if ( (LA51_11==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_11==NAME||(LA51_11>=LCURLY && LA51_11<=RCURLY)||(LA51_11>=COMA && LA51_11<=SEMI)||(LA51_11>=LSQUARE && LA51_11<=NE)||LA51_11==47||(LA51_11>=49 && LA51_11<=54)||(LA51_11>=56 && LA51_11<=60)||(LA51_11>=64 && LA51_11<=86)||(LA51_11>=89 && LA51_11<=90)||(LA51_11>=96 && LA51_11<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 11, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 52:
            	                {
            	                int LA51_12 = input.LA(2);

            	                if ( (LA51_12==NAME||(LA51_12>=LCURLY && LA51_12<=RCURLY)||(LA51_12>=COMA && LA51_12<=SEMI)||(LA51_12>=LSQUARE && LA51_12<=NE)||LA51_12==47||(LA51_12>=49 && LA51_12<=54)||(LA51_12>=56 && LA51_12<=60)||(LA51_12>=64 && LA51_12<=86)||(LA51_12>=89 && LA51_12<=90)||(LA51_12>=96 && LA51_12<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_12==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 12, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 53:
            	                {
            	                int LA51_13 = input.LA(2);

            	                if ( (LA51_13==NAME||(LA51_13>=LCURLY && LA51_13<=RCURLY)||(LA51_13>=COMA && LA51_13<=SEMI)||(LA51_13>=LSQUARE && LA51_13<=NE)||LA51_13==47||(LA51_13>=49 && LA51_13<=54)||(LA51_13>=56 && LA51_13<=60)||(LA51_13>=64 && LA51_13<=86)||(LA51_13>=89 && LA51_13<=90)||(LA51_13>=96 && LA51_13<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_13==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 13, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 54:
            	                {
            	                int LA51_14 = input.LA(2);

            	                if ( (LA51_14==NAME||(LA51_14>=LCURLY && LA51_14<=RCURLY)||(LA51_14>=COMA && LA51_14<=SEMI)||(LA51_14>=LSQUARE && LA51_14<=NE)||LA51_14==47||(LA51_14>=49 && LA51_14<=54)||(LA51_14>=56 && LA51_14<=60)||(LA51_14>=64 && LA51_14<=86)||(LA51_14>=89 && LA51_14<=90)||(LA51_14>=96 && LA51_14<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_14==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 14, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 55:
            	                {
            	                int LA51_15 = input.LA(2);

            	                if ( (LA51_15==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_15==NAME||(LA51_15>=LCURLY && LA51_15<=RCURLY)||(LA51_15>=COMA && LA51_15<=SEMI)||(LA51_15>=LSQUARE && LA51_15<=NE)||LA51_15==47||(LA51_15>=49 && LA51_15<=54)||(LA51_15>=56 && LA51_15<=60)||(LA51_15>=64 && LA51_15<=86)||(LA51_15>=89 && LA51_15<=90)||(LA51_15>=96 && LA51_15<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 15, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 56:
            	                {
            	                int LA51_16 = input.LA(2);

            	                if ( (LA51_16==NAME||(LA51_16>=LCURLY && LA51_16<=RCURLY)||(LA51_16>=COMA && LA51_16<=SEMI)||(LA51_16>=LSQUARE && LA51_16<=NE)||LA51_16==47||(LA51_16>=49 && LA51_16<=54)||(LA51_16>=56 && LA51_16<=60)||(LA51_16>=64 && LA51_16<=86)||(LA51_16>=89 && LA51_16<=90)||(LA51_16>=96 && LA51_16<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_16==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 16, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 57:
            	                {
            	                int LA51_17 = input.LA(2);

            	                if ( (LA51_17==NAME||(LA51_17>=LCURLY && LA51_17<=RCURLY)||(LA51_17>=COMA && LA51_17<=SEMI)||(LA51_17>=LSQUARE && LA51_17<=NE)||LA51_17==47||(LA51_17>=49 && LA51_17<=54)||(LA51_17>=56 && LA51_17<=60)||(LA51_17>=64 && LA51_17<=86)||(LA51_17>=89 && LA51_17<=90)||(LA51_17>=96 && LA51_17<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_17==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 17, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 58:
            	                {
            	                int LA51_18 = input.LA(2);

            	                if ( (LA51_18==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_18==NAME||(LA51_18>=LCURLY && LA51_18<=RCURLY)||(LA51_18>=COMA && LA51_18<=SEMI)||(LA51_18>=LSQUARE && LA51_18<=NE)||LA51_18==47||(LA51_18>=49 && LA51_18<=54)||(LA51_18>=56 && LA51_18<=60)||(LA51_18>=64 && LA51_18<=86)||(LA51_18>=89 && LA51_18<=90)||(LA51_18>=96 && LA51_18<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 18, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 59:
            	                {
            	                int LA51_19 = input.LA(2);

            	                if ( (LA51_19==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_19==NAME||(LA51_19>=LCURLY && LA51_19<=RCURLY)||(LA51_19>=COMA && LA51_19<=SEMI)||(LA51_19>=LSQUARE && LA51_19<=NE)||LA51_19==47||(LA51_19>=49 && LA51_19<=54)||(LA51_19>=56 && LA51_19<=60)||(LA51_19>=64 && LA51_19<=86)||(LA51_19>=89 && LA51_19<=90)||(LA51_19>=96 && LA51_19<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 19, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 60:
            	                {
            	                int LA51_20 = input.LA(2);

            	                if ( (LA51_20==NAME||(LA51_20>=LCURLY && LA51_20<=RCURLY)||(LA51_20>=COMA && LA51_20<=SEMI)||(LA51_20>=LSQUARE && LA51_20<=NE)||LA51_20==47||(LA51_20>=49 && LA51_20<=54)||(LA51_20>=56 && LA51_20<=60)||(LA51_20>=64 && LA51_20<=86)||(LA51_20>=89 && LA51_20<=90)||(LA51_20>=96 && LA51_20<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_20==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 20, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 61:
            	                {
            	                int LA51_21 = input.LA(2);

            	                if ( (LA51_21==NAME||(LA51_21>=LCURLY && LA51_21<=RCURLY)||(LA51_21>=COMA && LA51_21<=SEMI)||(LA51_21>=LSQUARE && LA51_21<=NE)||LA51_21==47||(LA51_21>=49 && LA51_21<=54)||(LA51_21>=56 && LA51_21<=60)||(LA51_21>=64 && LA51_21<=86)||(LA51_21>=89 && LA51_21<=90)||(LA51_21>=96 && LA51_21<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_21==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 21, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 62:
            	                {
            	                int LA51_22 = input.LA(2);

            	                if ( (LA51_22==NAME||(LA51_22>=LCURLY && LA51_22<=RCURLY)||(LA51_22>=COMA && LA51_22<=SEMI)||(LA51_22>=LSQUARE && LA51_22<=NE)||LA51_22==47||(LA51_22>=49 && LA51_22<=54)||(LA51_22>=56 && LA51_22<=60)||(LA51_22>=64 && LA51_22<=86)||(LA51_22>=89 && LA51_22<=90)||(LA51_22>=96 && LA51_22<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_22==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 22, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 63:
            	                {
            	                int LA51_23 = input.LA(2);

            	                if ( (LA51_23==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_23==NAME||(LA51_23>=LCURLY && LA51_23<=RCURLY)||(LA51_23>=COMA && LA51_23<=SEMI)||(LA51_23>=LSQUARE && LA51_23<=NE)||LA51_23==47||(LA51_23>=49 && LA51_23<=54)||(LA51_23>=56 && LA51_23<=60)||(LA51_23>=64 && LA51_23<=86)||(LA51_23>=89 && LA51_23<=90)||(LA51_23>=96 && LA51_23<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 23, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 64:
            	                {
            	                int LA51_24 = input.LA(2);

            	                if ( (LA51_24==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_24==NAME||(LA51_24>=LCURLY && LA51_24<=RCURLY)||(LA51_24>=COMA && LA51_24<=SEMI)||(LA51_24>=LSQUARE && LA51_24<=NE)||LA51_24==47||(LA51_24>=49 && LA51_24<=54)||(LA51_24>=56 && LA51_24<=60)||(LA51_24>=64 && LA51_24<=86)||(LA51_24>=89 && LA51_24<=90)||(LA51_24>=96 && LA51_24<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 24, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 65:
            	                {
            	                int LA51_25 = input.LA(2);

            	                if ( (LA51_25==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_25==NAME||(LA51_25>=LCURLY && LA51_25<=RCURLY)||(LA51_25>=COMA && LA51_25<=SEMI)||(LA51_25>=LSQUARE && LA51_25<=NE)||LA51_25==47||(LA51_25>=49 && LA51_25<=54)||(LA51_25>=56 && LA51_25<=60)||(LA51_25>=64 && LA51_25<=86)||(LA51_25>=89 && LA51_25<=90)||(LA51_25>=96 && LA51_25<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 25, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 66:
            	                {
            	                int LA51_26 = input.LA(2);

            	                if ( (LA51_26==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_26==NAME||(LA51_26>=LCURLY && LA51_26<=RCURLY)||(LA51_26>=COMA && LA51_26<=SEMI)||(LA51_26>=LSQUARE && LA51_26<=NE)||LA51_26==47||(LA51_26>=49 && LA51_26<=54)||(LA51_26>=56 && LA51_26<=60)||(LA51_26>=64 && LA51_26<=86)||(LA51_26>=89 && LA51_26<=90)||(LA51_26>=96 && LA51_26<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 26, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 67:
            	                {
            	                int LA51_27 = input.LA(2);

            	                if ( (LA51_27==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_27==NAME||(LA51_27>=LCURLY && LA51_27<=RCURLY)||(LA51_27>=COMA && LA51_27<=SEMI)||(LA51_27>=LSQUARE && LA51_27<=NE)||LA51_27==47||(LA51_27>=49 && LA51_27<=54)||(LA51_27>=56 && LA51_27<=60)||(LA51_27>=64 && LA51_27<=86)||(LA51_27>=89 && LA51_27<=90)||(LA51_27>=96 && LA51_27<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 27, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 68:
            	                {
            	                int LA51_28 = input.LA(2);

            	                if ( (LA51_28==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_28==NAME||(LA51_28>=LCURLY && LA51_28<=RCURLY)||(LA51_28>=COMA && LA51_28<=SEMI)||(LA51_28>=LSQUARE && LA51_28<=NE)||LA51_28==47||(LA51_28>=49 && LA51_28<=54)||(LA51_28>=56 && LA51_28<=60)||(LA51_28>=64 && LA51_28<=86)||(LA51_28>=89 && LA51_28<=90)||(LA51_28>=96 && LA51_28<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 28, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 69:
            	                {
            	                int LA51_29 = input.LA(2);

            	                if ( (LA51_29==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_29==NAME||(LA51_29>=LCURLY && LA51_29<=RCURLY)||(LA51_29>=COMA && LA51_29<=SEMI)||(LA51_29>=LSQUARE && LA51_29<=NE)||LA51_29==47||(LA51_29>=49 && LA51_29<=54)||(LA51_29>=56 && LA51_29<=60)||(LA51_29>=64 && LA51_29<=86)||(LA51_29>=89 && LA51_29<=90)||(LA51_29>=96 && LA51_29<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 29, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 70:
            	                {
            	                int LA51_30 = input.LA(2);

            	                if ( (LA51_30==NAME||(LA51_30>=LCURLY && LA51_30<=RCURLY)||(LA51_30>=COMA && LA51_30<=SEMI)||(LA51_30>=LSQUARE && LA51_30<=NE)||LA51_30==47||(LA51_30>=49 && LA51_30<=54)||(LA51_30>=56 && LA51_30<=60)||(LA51_30>=64 && LA51_30<=86)||(LA51_30>=89 && LA51_30<=90)||(LA51_30>=96 && LA51_30<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_30==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 30, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 71:
            	                {
            	                int LA51_31 = input.LA(2);

            	                if ( (LA51_31==NAME||(LA51_31>=LCURLY && LA51_31<=RCURLY)||(LA51_31>=COMA && LA51_31<=SEMI)||(LA51_31>=LSQUARE && LA51_31<=NE)||LA51_31==47||(LA51_31>=49 && LA51_31<=54)||(LA51_31>=56 && LA51_31<=60)||(LA51_31>=64 && LA51_31<=86)||(LA51_31>=89 && LA51_31<=90)||(LA51_31>=96 && LA51_31<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_31==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 31, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 72:
            	                {
            	                int LA51_32 = input.LA(2);

            	                if ( (LA51_32==NAME||(LA51_32>=LCURLY && LA51_32<=RCURLY)||(LA51_32>=COMA && LA51_32<=SEMI)||(LA51_32>=LSQUARE && LA51_32<=NE)||LA51_32==47||(LA51_32>=49 && LA51_32<=54)||(LA51_32>=56 && LA51_32<=60)||(LA51_32>=64 && LA51_32<=86)||(LA51_32>=89 && LA51_32<=90)||(LA51_32>=96 && LA51_32<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_32==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 32, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 73:
            	                {
            	                int LA51_33 = input.LA(2);

            	                if ( (LA51_33==NAME||(LA51_33>=LCURLY && LA51_33<=RCURLY)||(LA51_33>=COMA && LA51_33<=SEMI)||(LA51_33>=LSQUARE && LA51_33<=NE)||LA51_33==47||(LA51_33>=49 && LA51_33<=54)||(LA51_33>=56 && LA51_33<=60)||(LA51_33>=64 && LA51_33<=86)||(LA51_33>=89 && LA51_33<=90)||(LA51_33>=96 && LA51_33<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_33==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 33, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 74:
            	                {
            	                int LA51_34 = input.LA(2);

            	                if ( (LA51_34==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_34==NAME||(LA51_34>=LCURLY && LA51_34<=RCURLY)||(LA51_34>=COMA && LA51_34<=SEMI)||(LA51_34>=LSQUARE && LA51_34<=NE)||LA51_34==47||(LA51_34>=49 && LA51_34<=54)||(LA51_34>=56 && LA51_34<=60)||(LA51_34>=64 && LA51_34<=86)||(LA51_34>=89 && LA51_34<=90)||(LA51_34>=96 && LA51_34<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 34, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 75:
            	                {
            	                int LA51_35 = input.LA(2);

            	                if ( (LA51_35==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_35==NAME||(LA51_35>=LCURLY && LA51_35<=RCURLY)||(LA51_35>=COMA && LA51_35<=SEMI)||(LA51_35>=LSQUARE && LA51_35<=NE)||LA51_35==47||(LA51_35>=49 && LA51_35<=54)||(LA51_35>=56 && LA51_35<=60)||(LA51_35>=64 && LA51_35<=86)||(LA51_35>=89 && LA51_35<=90)||(LA51_35>=96 && LA51_35<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 35, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 76:
            	                {
            	                int LA51_36 = input.LA(2);

            	                if ( (LA51_36==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_36==NAME||(LA51_36>=LCURLY && LA51_36<=RCURLY)||(LA51_36>=COMA && LA51_36<=SEMI)||(LA51_36>=LSQUARE && LA51_36<=NE)||LA51_36==47||(LA51_36>=49 && LA51_36<=54)||(LA51_36>=56 && LA51_36<=60)||(LA51_36>=64 && LA51_36<=86)||(LA51_36>=89 && LA51_36<=90)||(LA51_36>=96 && LA51_36<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 36, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 77:
            	                {
            	                int LA51_37 = input.LA(2);

            	                if ( (LA51_37==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_37==NAME||(LA51_37>=LCURLY && LA51_37<=RCURLY)||(LA51_37>=COMA && LA51_37<=SEMI)||(LA51_37>=LSQUARE && LA51_37<=NE)||LA51_37==47||(LA51_37>=49 && LA51_37<=54)||(LA51_37>=56 && LA51_37<=60)||(LA51_37>=64 && LA51_37<=86)||(LA51_37>=89 && LA51_37<=90)||(LA51_37>=96 && LA51_37<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 37, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 78:
            	                {
            	                int LA51_38 = input.LA(2);

            	                if ( (LA51_38==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_38==NAME||(LA51_38>=LCURLY && LA51_38<=RCURLY)||(LA51_38>=COMA && LA51_38<=SEMI)||(LA51_38>=LSQUARE && LA51_38<=NE)||LA51_38==47||(LA51_38>=49 && LA51_38<=54)||(LA51_38>=56 && LA51_38<=60)||(LA51_38>=64 && LA51_38<=86)||(LA51_38>=89 && LA51_38<=90)||(LA51_38>=96 && LA51_38<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 38, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 79:
            	                {
            	                int LA51_39 = input.LA(2);

            	                if ( (LA51_39==NAME||(LA51_39>=LCURLY && LA51_39<=RCURLY)||(LA51_39>=COMA && LA51_39<=SEMI)||(LA51_39>=LSQUARE && LA51_39<=NE)||LA51_39==47||(LA51_39>=49 && LA51_39<=54)||(LA51_39>=56 && LA51_39<=60)||(LA51_39>=64 && LA51_39<=86)||(LA51_39>=89 && LA51_39<=90)||(LA51_39>=96 && LA51_39<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_39==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 39, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 80:
            	                {
            	                int LA51_40 = input.LA(2);

            	                if ( (LA51_40==NAME||(LA51_40>=LCURLY && LA51_40<=RCURLY)||(LA51_40>=COMA && LA51_40<=SEMI)||(LA51_40>=LSQUARE && LA51_40<=NE)||LA51_40==47||(LA51_40>=49 && LA51_40<=54)||(LA51_40>=56 && LA51_40<=60)||(LA51_40>=64 && LA51_40<=86)||(LA51_40>=89 && LA51_40<=90)||(LA51_40>=96 && LA51_40<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_40==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 40, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 81:
            	                {
            	                int LA51_41 = input.LA(2);

            	                if ( (LA51_41==NAME||(LA51_41>=LCURLY && LA51_41<=RCURLY)||(LA51_41>=COMA && LA51_41<=SEMI)||(LA51_41>=LSQUARE && LA51_41<=NE)||LA51_41==47||(LA51_41>=49 && LA51_41<=54)||(LA51_41>=56 && LA51_41<=60)||(LA51_41>=64 && LA51_41<=86)||(LA51_41>=89 && LA51_41<=90)||(LA51_41>=96 && LA51_41<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_41==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 41, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 82:
            	                {
            	                int LA51_42 = input.LA(2);

            	                if ( (LA51_42==NAME||(LA51_42>=LCURLY && LA51_42<=RCURLY)||(LA51_42>=COMA && LA51_42<=SEMI)||(LA51_42>=LSQUARE && LA51_42<=NE)||LA51_42==47||(LA51_42>=49 && LA51_42<=54)||(LA51_42>=56 && LA51_42<=60)||(LA51_42>=64 && LA51_42<=86)||(LA51_42>=89 && LA51_42<=90)||(LA51_42>=96 && LA51_42<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_42==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 42, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 83:
            	                {
            	                int LA51_43 = input.LA(2);

            	                if ( (LA51_43==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_43==NAME||(LA51_43>=LCURLY && LA51_43<=RCURLY)||(LA51_43>=COMA && LA51_43<=SEMI)||(LA51_43>=LSQUARE && LA51_43<=NE)||LA51_43==47||(LA51_43>=49 && LA51_43<=54)||(LA51_43>=56 && LA51_43<=60)||(LA51_43>=64 && LA51_43<=86)||(LA51_43>=89 && LA51_43<=90)||(LA51_43>=96 && LA51_43<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 43, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 84:
            	                {
            	                int LA51_44 = input.LA(2);

            	                if ( (LA51_44==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_44==NAME||(LA51_44>=LCURLY && LA51_44<=RCURLY)||(LA51_44>=COMA && LA51_44<=SEMI)||(LA51_44>=LSQUARE && LA51_44<=NE)||LA51_44==47||(LA51_44>=49 && LA51_44<=54)||(LA51_44>=56 && LA51_44<=60)||(LA51_44>=64 && LA51_44<=86)||(LA51_44>=89 && LA51_44<=90)||(LA51_44>=96 && LA51_44<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 44, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 85:
            	                {
            	                int LA51_45 = input.LA(2);

            	                if ( (LA51_45==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_45==NAME||(LA51_45>=LCURLY && LA51_45<=RCURLY)||(LA51_45>=COMA && LA51_45<=SEMI)||(LA51_45>=LSQUARE && LA51_45<=NE)||LA51_45==47||(LA51_45>=49 && LA51_45<=54)||(LA51_45>=56 && LA51_45<=60)||(LA51_45>=64 && LA51_45<=86)||(LA51_45>=89 && LA51_45<=90)||(LA51_45>=96 && LA51_45<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 45, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 86:
            	                {
            	                int LA51_46 = input.LA(2);

            	                if ( (LA51_46==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_46==NAME||(LA51_46>=LCURLY && LA51_46<=RCURLY)||(LA51_46>=COMA && LA51_46<=SEMI)||(LA51_46>=LSQUARE && LA51_46<=NE)||LA51_46==47||(LA51_46>=49 && LA51_46<=54)||(LA51_46>=56 && LA51_46<=60)||(LA51_46>=64 && LA51_46<=86)||(LA51_46>=89 && LA51_46<=90)||(LA51_46>=96 && LA51_46<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 46, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 87:
            	                {
            	                int LA51_47 = input.LA(2);

            	                if ( (LA51_47==NAME||(LA51_47>=LCURLY && LA51_47<=RCURLY)||(LA51_47>=COMA && LA51_47<=SEMI)||(LA51_47>=LSQUARE && LA51_47<=NE)||LA51_47==47||(LA51_47>=49 && LA51_47<=54)||(LA51_47>=56 && LA51_47<=60)||(LA51_47>=64 && LA51_47<=86)||(LA51_47>=89 && LA51_47<=90)||(LA51_47>=96 && LA51_47<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_47==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 47, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 88:
            	                {
            	                int LA51_48 = input.LA(2);

            	                if ( (LA51_48==NAME||(LA51_48>=LCURLY && LA51_48<=RCURLY)||(LA51_48>=COMA && LA51_48<=SEMI)||(LA51_48>=LSQUARE && LA51_48<=NE)||LA51_48==47||(LA51_48>=49 && LA51_48<=54)||(LA51_48>=56 && LA51_48<=60)||(LA51_48>=64 && LA51_48<=86)||(LA51_48>=89 && LA51_48<=90)||(LA51_48>=96 && LA51_48<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_48==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 48, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 89:
            	                {
            	                int LA51_49 = input.LA(2);

            	                if ( (LA51_49==NAME||(LA51_49>=LCURLY && LA51_49<=RCURLY)||(LA51_49>=COMA && LA51_49<=SEMI)||(LA51_49>=LSQUARE && LA51_49<=NE)||LA51_49==47||(LA51_49>=49 && LA51_49<=54)||(LA51_49>=56 && LA51_49<=60)||(LA51_49>=64 && LA51_49<=86)||(LA51_49>=89 && LA51_49<=90)||(LA51_49>=96 && LA51_49<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_49==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 49, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 90:
            	                {
            	                int LA51_50 = input.LA(2);

            	                if ( (LA51_50==NAME||(LA51_50>=LCURLY && LA51_50<=RCURLY)||(LA51_50>=COMA && LA51_50<=SEMI)||(LA51_50>=LSQUARE && LA51_50<=NE)||LA51_50==47||(LA51_50>=49 && LA51_50<=54)||(LA51_50>=56 && LA51_50<=60)||(LA51_50>=64 && LA51_50<=86)||(LA51_50>=89 && LA51_50<=90)||(LA51_50>=96 && LA51_50<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_50==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 50, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 91:
            	                {
            	                int LA51_51 = input.LA(2);

            	                if ( (LA51_51==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_51==NAME||(LA51_51>=LCURLY && LA51_51<=RCURLY)||(LA51_51>=COMA && LA51_51<=SEMI)||(LA51_51>=LSQUARE && LA51_51<=NE)||LA51_51==47||(LA51_51>=49 && LA51_51<=54)||(LA51_51>=56 && LA51_51<=60)||(LA51_51>=64 && LA51_51<=86)||(LA51_51>=89 && LA51_51<=90)||(LA51_51>=96 && LA51_51<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 51, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 92:
            	                {
            	                int LA51_52 = input.LA(2);

            	                if ( (LA51_52==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_52==NAME||(LA51_52>=LCURLY && LA51_52<=RCURLY)||(LA51_52>=COMA && LA51_52<=SEMI)||(LA51_52>=LSQUARE && LA51_52<=NE)||LA51_52==47||(LA51_52>=49 && LA51_52<=54)||(LA51_52>=56 && LA51_52<=60)||(LA51_52>=64 && LA51_52<=86)||(LA51_52>=89 && LA51_52<=90)||(LA51_52>=96 && LA51_52<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 52, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 93:
            	                {
            	                int LA51_53 = input.LA(2);

            	                if ( (LA51_53==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_53==NAME||(LA51_53>=LCURLY && LA51_53<=RCURLY)||(LA51_53>=COMA && LA51_53<=SEMI)||(LA51_53>=LSQUARE && LA51_53<=NE)||LA51_53==47||(LA51_53>=49 && LA51_53<=54)||(LA51_53>=56 && LA51_53<=60)||(LA51_53>=64 && LA51_53<=86)||(LA51_53>=89 && LA51_53<=90)||(LA51_53>=96 && LA51_53<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 53, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 94:
            	                {
            	                int LA51_54 = input.LA(2);

            	                if ( (LA51_54==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_54==NAME||(LA51_54>=LCURLY && LA51_54<=RCURLY)||(LA51_54>=COMA && LA51_54<=SEMI)||(LA51_54>=LSQUARE && LA51_54<=NE)||LA51_54==47||(LA51_54>=49 && LA51_54<=54)||(LA51_54>=56 && LA51_54<=60)||(LA51_54>=64 && LA51_54<=86)||(LA51_54>=89 && LA51_54<=90)||(LA51_54>=96 && LA51_54<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 54, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 95:
            	                {
            	                int LA51_55 = input.LA(2);

            	                if ( (LA51_55==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_55==NAME||(LA51_55>=LCURLY && LA51_55<=RCURLY)||(LA51_55>=COMA && LA51_55<=SEMI)||(LA51_55>=LSQUARE && LA51_55<=NE)||LA51_55==47||(LA51_55>=49 && LA51_55<=54)||(LA51_55>=56 && LA51_55<=60)||(LA51_55>=64 && LA51_55<=86)||(LA51_55>=89 && LA51_55<=90)||(LA51_55>=96 && LA51_55<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 55, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 96:
            	                {
            	                int LA51_56 = input.LA(2);

            	                if ( (LA51_56==NAME||(LA51_56>=LCURLY && LA51_56<=RCURLY)||(LA51_56>=COMA && LA51_56<=SEMI)||(LA51_56>=LSQUARE && LA51_56<=NE)||LA51_56==47||(LA51_56>=49 && LA51_56<=54)||(LA51_56>=56 && LA51_56<=60)||(LA51_56>=64 && LA51_56<=86)||(LA51_56>=89 && LA51_56<=90)||(LA51_56>=96 && LA51_56<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_56==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 56, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 97:
            	                {
            	                int LA51_57 = input.LA(2);

            	                if ( (LA51_57==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_57==NAME||(LA51_57>=LCURLY && LA51_57<=RCURLY)||(LA51_57>=COMA && LA51_57<=SEMI)||(LA51_57>=LSQUARE && LA51_57<=NE)||LA51_57==47||(LA51_57>=49 && LA51_57<=54)||(LA51_57>=56 && LA51_57<=60)||(LA51_57>=64 && LA51_57<=86)||(LA51_57>=89 && LA51_57<=90)||(LA51_57>=96 && LA51_57<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 57, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 98:
            	                {
            	                int LA51_58 = input.LA(2);

            	                if ( (LA51_58==NAME||(LA51_58>=LCURLY && LA51_58<=RCURLY)||(LA51_58>=COMA && LA51_58<=SEMI)||(LA51_58>=LSQUARE && LA51_58<=NE)||LA51_58==47||(LA51_58>=49 && LA51_58<=54)||(LA51_58>=56 && LA51_58<=60)||(LA51_58>=64 && LA51_58<=86)||(LA51_58>=89 && LA51_58<=90)||(LA51_58>=96 && LA51_58<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_58==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 58, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 99:
            	                {
            	                int LA51_59 = input.LA(2);

            	                if ( (LA51_59==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_59==NAME||(LA51_59>=LCURLY && LA51_59<=RCURLY)||(LA51_59>=COMA && LA51_59<=SEMI)||(LA51_59>=LSQUARE && LA51_59<=NE)||LA51_59==47||(LA51_59>=49 && LA51_59<=54)||(LA51_59>=56 && LA51_59<=60)||(LA51_59>=64 && LA51_59<=86)||(LA51_59>=89 && LA51_59<=90)||(LA51_59>=96 && LA51_59<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 59, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 100:
            	                {
            	                int LA51_60 = input.LA(2);

            	                if ( (LA51_60==NAME||(LA51_60>=LCURLY && LA51_60<=RCURLY)||(LA51_60>=COMA && LA51_60<=SEMI)||(LA51_60>=LSQUARE && LA51_60<=NE)||LA51_60==47||(LA51_60>=49 && LA51_60<=54)||(LA51_60>=56 && LA51_60<=60)||(LA51_60>=64 && LA51_60<=86)||(LA51_60>=89 && LA51_60<=90)||(LA51_60>=96 && LA51_60<=102)) ) {
            	                    alt51=1;
            	                }
            	                else if ( (LA51_60==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 60, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 101:
            	                {
            	                int LA51_61 = input.LA(2);

            	                if ( (LA51_61==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_61==NAME||(LA51_61>=LCURLY && LA51_61<=RCURLY)||(LA51_61>=COMA && LA51_61<=SEMI)||(LA51_61>=LSQUARE && LA51_61<=NE)||LA51_61==47||(LA51_61>=49 && LA51_61<=54)||(LA51_61>=56 && LA51_61<=60)||(LA51_61>=64 && LA51_61<=86)||(LA51_61>=89 && LA51_61<=90)||(LA51_61>=96 && LA51_61<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 61, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 102:
            	                {
            	                int LA51_62 = input.LA(2);

            	                if ( (LA51_62==LPAREN) ) {
            	                    alt51=2;
            	                }
            	                else if ( (LA51_62==NAME||(LA51_62>=LCURLY && LA51_62<=RCURLY)||(LA51_62>=COMA && LA51_62<=SEMI)||(LA51_62>=LSQUARE && LA51_62<=NE)||LA51_62==47||(LA51_62>=49 && LA51_62<=54)||(LA51_62>=56 && LA51_62<=60)||(LA51_62>=64 && LA51_62<=86)||(LA51_62>=89 && LA51_62<=90)||(LA51_62>=96 && LA51_62<=102)) ) {
            	                    alt51=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 62, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            default:
            	                NoViableAltException nvae =
            	                    new NoViableAltException("823:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )", 51, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt51) {
            	                case 1 :
            	                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:54: ret= navigationExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_navigationExp_in_priority_03938);
            	                    ret=navigationExp(opName,  ret,  firstToken);
            	                    _fsp--;


            	                    }
            	                    break;
            	                case 2 :
            	                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:99: ret= operationCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_operationCallExp_in_priority_03945);
            	                    ret=operationCallExp(opName,  ret,  firstToken);
            	                    _fsp--;


            	                    }
            	                    break;

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:149: ( RARROW ret= iteratorExp[opName, ret, firstToken] )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:149: ( RARROW ret= iteratorExp[opName, ret, firstToken] )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:823:150: RARROW ret= iteratorExp[opName, ret, firstToken]
            	            {
            	            match(input,RARROW,FOLLOW_RARROW_in_priority_03953); 
            	            opName = "->";
            	            pushFollow(FOLLOW_iteratorExp_in_priority_03959);
            	            ret=iteratorExp(opName,  ret,  firstToken);
            	            _fsp--;


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }


                        ret2=ret;
                    

            }

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
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:830:1: priority_1 returns [Object ret2] : ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) ;
    public final Object priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:831:2: ( ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:831:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:831:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            int alt54=3;
            switch ( input.LA(1) ) {
            case 95:
                {
                alt54=1;
                }
                break;
            case MINUS:
                {
                alt54=2;
                }
                break;
            case NAME:
            case STRING:
            case INT:
            case LPAREN:
            case 56:
            case 87:
            case 88:
            case 91:
            case 92:
            case 93:
            case 94:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("831:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:831:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:831:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:831:6: 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,95,FOLLOW_95_in_priority_13998); 
                    opName = "not";
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:831:30: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:831:31: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_14005);
                    ret=operatorCallExp(opName,  right,  firstToken);
                    _fsp--;

                    pushFollow(FOLLOW_priority_0_in_priority_14010);
                    right=priority_0();
                    _fsp--;

                    ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
                    	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

                    }


                    }


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:832:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:832:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:832:72: MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_priority_14018); 
                    opName = "-";
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:832:94: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:832:95: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_14025);
                    ret=operatorCallExp(opName,  right,  firstToken);
                    _fsp--;

                    pushFollow(FOLLOW_priority_0_in_priority_14030);
                    right=priority_0();
                    _fsp--;

                    ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
                    	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

                    }


                    }


                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:833:71: (ret= priority_0 )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:833:71: (ret= priority_0 )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:833:72: ret= priority_0
                    {
                    pushFollow(FOLLOW_priority_0_in_priority_14040);
                    ret=priority_0();
                    _fsp--;


                    }


                    }
                    break;

            }


                        ret2=ret;
                    

            }

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
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:840:1: priority_2 returns [Object ret2] : (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ;
    public final Object priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:2: ( (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:5: ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_1_in_priority_24075);
            ret=priority_1();
            _fsp--;

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:20: ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( ((LA56_0>=STAR && LA56_0<=SLASH)||(LA56_0>=96 && LA56_0<=97)) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    int alt55=4;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt55=1;
            	        }
            	        break;
            	    case SLASH:
            	        {
            	        alt55=2;
            	        }
            	        break;
            	    case 96:
            	        {
            	        alt55=3;
            	        }
            	        break;
            	    case 97:
            	        {
            	        alt55=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("841:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )", 55, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt55) {
            	        case 1 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:23: STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,STAR,FOLLOW_STAR_in_priority_24080); 
            	            opName = "*";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:841:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_24087);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_24092);
            	            right=priority_1();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:842:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:842:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:842:72: SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,SLASH,FOLLOW_SLASH_in_priority_24100); 
            	            opName = "/";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:842:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:842:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_24107);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_24112);
            	            right=priority_1();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:843:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:843:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:843:72: 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,96,FOLLOW_96_in_priority_24120); 
            	            opName = "div";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:843:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:843:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_24127);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_24132);
            	            right=priority_1();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:844:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:844:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:844:72: 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,97,FOLLOW_97_in_priority_24140); 
            	            opName = "mod";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:844:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:844:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_24147);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_24152);
            	            right=priority_1();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


                        ret2=ret;
                    

            }

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
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:852:1: priority_3 returns [Object ret2] : (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) ;
    public final Object priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:2: ( (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:5: ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_2_in_priority_34193);
            ret=priority_2();
            _fsp--;

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:20: ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==MINUS||LA58_0==PLUS) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    int alt57=2;
            	    int LA57_0 = input.LA(1);

            	    if ( (LA57_0==PLUS) ) {
            	        alt57=1;
            	    }
            	    else if ( (LA57_0==MINUS) ) {
            	        alt57=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("853:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )", 57, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt57) {
            	        case 1 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:23: PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_priority_34198); 
            	            opName = "+";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:853:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_34205);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_2_in_priority_34210);
            	            right=priority_2();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:854:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:854:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:854:72: MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_priority_34218); 
            	            opName = "-";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:854:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:854:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_34225);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_2_in_priority_34230);
            	            right=priority_2();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }


                        ret2=ret;
                    

            }

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
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:862:1: priority_4 returns [Object ret2] : (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )* ) ;
    public final Object priority_4() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:2: ( (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:5: ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )*
            {
            pushFollow(FOLLOW_priority_3_in_priority_44271);
            ret=priority_3();
            _fsp--;

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:20: ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==EQ||(LA60_0>=GT && LA60_0<=NE)||LA60_0==98) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) )
            	    int alt59=7;
            	    switch ( input.LA(1) ) {
            	    case EQ:
            	        {
            	        alt59=1;
            	        }
            	        break;
            	    case GT:
            	        {
            	        alt59=2;
            	        }
            	        break;
            	    case LT:
            	        {
            	        alt59=3;
            	        }
            	        break;
            	    case GE:
            	        {
            	        alt59=4;
            	        }
            	        break;
            	    case LE:
            	        {
            	        alt59=5;
            	        }
            	        break;
            	    case NE:
            	        {
            	        alt59=6;
            	        }
            	        break;
            	    case 98:
            	        {
            	        alt59=7;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("863:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) )", 59, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt59) {
            	        case 1 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:23: EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,EQ,FOLLOW_EQ_in_priority_44276); 
            	            opName = "=";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:42: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:863:43: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44283);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44288);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:864:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:864:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:864:72: GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GT,FOLLOW_GT_in_priority_44296); 
            	            opName = ">";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:864:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:864:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44303);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44308);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:865:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:865:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:865:72: LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LT,FOLLOW_LT_in_priority_44316); 
            	            opName = "<";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:865:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:865:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44323);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44328);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:866:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:866:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:866:72: GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GE,FOLLOW_GE_in_priority_44336); 
            	            opName = ">=";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:866:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:866:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44343);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44348);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 5 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:867:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:867:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:867:72: LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LE,FOLLOW_LE_in_priority_44356); 
            	            opName = "<=";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:867:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:867:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44363);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44368);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 6 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:868:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:868:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:868:72: NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,NE,FOLLOW_NE_in_priority_44376); 
            	            opName = "<>";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:868:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:868:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44383);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44388);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 7 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:869:71: ( 'isa' ret= isAExp[opName, ret, firstToken] )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:869:71: ( 'isa' ret= isAExp[opName, ret, firstToken] )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:869:72: 'isa' ret= isAExp[opName, ret, firstToken]
            	            {
            	            match(input,98,FOLLOW_98_in_priority_44396); 
            	            opName = "isa";
            	            pushFollow(FOLLOW_isAExp_in_priority_44402);
            	            ret=isAExp(opName,  ret,  firstToken);
            	            _fsp--;


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }


                        ret2=ret;
                    

            }

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
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:876:1: priority_5 returns [Object ret2] : (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ;
    public final Object priority_5() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:2: ( (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:5: ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_4_in_priority_54442);
            ret=priority_4();
            _fsp--;

            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:20: ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( ((LA62_0>=99 && LA62_0<=102)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    int alt61=4;
            	    switch ( input.LA(1) ) {
            	    case 99:
            	        {
            	        alt61=1;
            	        }
            	        break;
            	    case 100:
            	        {
            	        alt61=2;
            	        }
            	        break;
            	    case 101:
            	        {
            	        alt61=3;
            	        }
            	        break;
            	    case 102:
            	        {
            	        alt61=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("877:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )", 61, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt61) {
            	        case 1 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:23: 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,99,FOLLOW_99_in_priority_54447); 
            	            opName = "and";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:47: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:877:48: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_54454);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_54459);
            	            right=priority_4();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:878:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:878:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:878:72: 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,100,FOLLOW_100_in_priority_54467); 
            	            opName = "or";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:878:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:878:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_54474);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_54479);
            	            right=priority_4();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:879:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:879:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:879:72: 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,101,FOLLOW_101_in_priority_54487); 
            	            opName = "xor";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:879:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:879:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_54494);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_54499);
            	            right=priority_4();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:880:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:880:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:880:72: 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,102,FOLLOW_102_in_priority_54507); 
            	            opName = "implies";
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:880:104: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:880:105: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_54514);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_54519);
            	            right=priority_4();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            }


                        ret2=ret;
                    

            }

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


    // $ANTLR start primary_expression
    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:888:1: primary_expression returns [Object ret2] : ( ( LPAREN ret= expression RPAREN ) | ret= variableExp | ret= selfExp | ret= lastExp | ret= ifExp | ret= literalExp ) ;
    public final Object primary_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:2: ( ( ( LPAREN ret= expression RPAREN ) | ret= variableExp | ret= selfExp | ret= lastExp | ret= ifExp | ret= literalExp ) )
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:4: ( ( LPAREN ret= expression RPAREN ) | ret= variableExp | ret= selfExp | ret= lastExp | ret= ifExp | ret= literalExp )
            {
            // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:4: ( ( LPAREN ret= expression RPAREN ) | ret= variableExp | ret= selfExp | ret= lastExp | ret= ifExp | ret= literalExp )
            int alt63=6;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt63=1;
                }
                break;
            case NAME:
                {
                alt63=2;
                }
                break;
            case 87:
                {
                alt63=3;
                }
                break;
            case 88:
                {
                alt63=4;
                }
                break;
            case 56:
                {
                alt63=5;
                }
                break;
            case STRING:
            case INT:
            case 91:
            case 92:
            case 93:
            case 94:
                {
                alt63=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("889:4: ( ( LPAREN ret= expression RPAREN ) | ret= variableExp | ret= selfExp | ret= lastExp | ret= ifExp | ret= literalExp )", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:5: ( LPAREN ret= expression RPAREN )
                    {
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:5: ( LPAREN ret= expression RPAREN )
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:6: LPAREN ret= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_expression4559); 
                    pushFollow(FOLLOW_expression_in_primary_expression4563);
                    ret=expression();
                    _fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_expression4565); 

                    }


                    }
                    break;
                case 2 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:37: ret= variableExp
                    {
                    pushFollow(FOLLOW_variableExp_in_primary_expression4571);
                    ret=variableExp();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:54: ret= selfExp
                    {
                    pushFollow(FOLLOW_selfExp_in_primary_expression4576);
                    ret=selfExp();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:67: ret= lastExp
                    {
                    pushFollow(FOLLOW_lastExp_in_primary_expression4581);
                    ret=lastExp();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:80: ret= ifExp
                    {
                    pushFollow(FOLLOW_ifExp_in_primary_expression4586);
                    ret=ifExp();
                    _fsp--;


                    }
                    break;
                case 6 :
                    // D:\\dev\\workspaces\\3.3.2\\TCS\\ACG\\Syntax\\ACG_ANTLR3.g:889:91: ret= literalExp
                    {
                    pushFollow(FOLLOW_literalExp_in_primary_expression4591);
                    ret=literalExp();
                    _fsp--;


                    }
                    break;

            }


                        ret2=ret;
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end primary_expression


 

    public static final BitSet FOLLOW_aCG_in_main46 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifier82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_identifierOrKeyword122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_identifierOrKeyword127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_identifierOrKeyword132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_identifierOrKeyword137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_identifierOrKeyword142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_identifierOrKeyword147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_identifierOrKeyword152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_identifierOrKeyword167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_identifierOrKeyword172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_identifierOrKeyword177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_identifierOrKeyword182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_identifierOrKeyword187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_identifierOrKeyword192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_identifierOrKeyword197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_identifierOrKeyword202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_identifierOrKeyword207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_identifierOrKeyword212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_identifierOrKeyword217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_identifierOrKeyword222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_identifierOrKeyword227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_identifierOrKeyword232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_identifierOrKeyword237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_identifierOrKeyword242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_identifierOrKeyword247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_identifierOrKeyword252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_identifierOrKeyword257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_identifierOrKeyword262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_identifierOrKeyword267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_identifierOrKeyword272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_identifierOrKeyword277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_identifierOrKeyword282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_identifierOrKeyword287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_identifierOrKeyword292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_identifierOrKeyword297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_identifierOrKeyword302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_identifierOrKeyword307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_identifierOrKeyword312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_identifierOrKeyword317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_identifierOrKeyword322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_identifierOrKeyword327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_identifierOrKeyword332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_identifierOrKeyword337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_identifierOrKeyword342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_identifierOrKeyword347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_identifierOrKeyword352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_identifierOrKeyword357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_identifierOrKeyword362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_identifierOrKeyword367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_identifierOrKeyword372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_identifierOrKeyword377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_identifierOrKeyword382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_identifierOrKeyword387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_identifierOrKeyword392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_identifierOrKeyword397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_identifierOrKeyword402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_identifierOrKeyword407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_identifierOrKeyword412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_identifierOrKeyword417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_identifierOrKeyword422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_aCG524 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_aCG528 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_aCG532 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_aCG536 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_aCG540 = new BitSet(new long[]{0x0001700000000110L});
    public static final BitSet FOLLOW_aCGElement_in_aCG548 = new BitSet(new long[]{0x0001700000000110L});
    public static final BitSet FOLLOW_aCGElement_in_aCG556 = new BitSet(new long[]{0x0001700000000110L});
    public static final BitSet FOLLOW_RCURLY_in_aCG568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_aCGElement603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_aCGElement608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_node_in_aCGElement613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_function646 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_function650 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLONCOLON_in_function654 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_function658 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_function662 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_parameter_in_function670 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMA_in_function677 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parameter_in_function682 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_function701 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_function703 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_function707 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_function711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_attribute743 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_attribute747 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLONCOLON_in_attribute751 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_attribute755 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_attribute759 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_attribute763 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_attribute767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_parameter801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aSMNode_in_node838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_codeNode_in_node843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleNode_in_node848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_aSMNode881 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_aSMNode885 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_aSMNode889 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_aSMNode893 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_aSMNode897 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_aSMNode905 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_aSMNode913 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_aSMNode925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_codeNode957 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_codeNode961 = new BitSet(new long[]{0x0002000000008080L});
    public static final BitSet FOLLOW_49_in_codeNode967 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_codeNode971 = new BitSet(new long[]{0x0000000000008080L});
    public static final BitSet FOLLOW_PIPE_in_codeNode987 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_codeNode991 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_codeNode1005 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_codeNode1013 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_codeNode1021 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_codeNode1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleNode1067 = new BitSet(new long[]{0x0002000000008080L});
    public static final BitSet FOLLOW_49_in_simpleNode1073 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleNode1077 = new BitSet(new long[]{0x0000000000008080L});
    public static final BitSet FOLLOW_PIPE_in_simpleNode1093 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_simpleNode1097 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_simpleNode1111 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_simpleNode1119 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_simpleNode1127 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_simpleNode1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundStat_in_statement1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reportStat_in_statement1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldStat_in_statement1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_paramStat_in_statement1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emitStat_in_statement1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forEachStat_in_compoundStat1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_onceStat_in_compoundStat1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableStat_in_compoundStat1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationStat_in_compoundStat1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalStat_in_compoundStat1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStat_in_compoundStat1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_analyzeStat_in_compoundStat1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_forEachStat1293 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_forEachStat1295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDecl_in_forEachStat1299 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_forEachStat1303 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_forEachStat1307 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_forEachStat1311 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_forEachStat1313 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_forEachStat1321 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_forEachStat1329 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_forEachStat1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_onceStat1373 = new BitSet(new long[]{0x1D54000000030010L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_onceStat1381 = new BitSet(new long[]{0x1D54000000030010L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_onceStat1389 = new BitSet(new long[]{0x1D54000000030010L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RSQUARE_in_onceStat1401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_variableStat1433 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_variableStat1437 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_variableStat1441 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_variableStat1445 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_variableStat1449 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_variableStat1457 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_variableStat1465 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_variableStat1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_operationStat1509 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_operationStat1511 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_operationStat1515 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_operationStat1519 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_operationStat1523 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_operationStat1527 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_operationStat1535 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_operationStat1543 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_operationStat1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conditionalStat1587 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_conditionalStat1589 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_conditionalStat1593 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_conditionalStat1597 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_conditionalStat1599 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_conditionalStat1607 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_conditionalStat1615 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_conditionalStat1627 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_conditionalStat1631 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_conditionalStat1633 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_conditionalStat1641 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_conditionalStat1649 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_conditionalStat1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_letStat1703 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDecl_in_letStat1707 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_letStat1711 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_letStat1715 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_letStat1719 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_letStat1727 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_letStat1735 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_letStat1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_analyzeStat1779 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_analyzeStat1783 = new BitSet(new long[]{0x0002000000000082L});
    public static final BitSet FOLLOW_49_in_analyzeStat1789 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_analyzeStat1793 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_LCURLY_in_analyzeStat1809 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_analyzeStat1817 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_statement_in_analyzeStat1825 = new BitSet(new long[]{0x1D54000000010110L,0x00000000007FFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_analyzeStat1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_reportStat1879 = new BitSet(new long[]{0xE000000000000000L});
    public static final BitSet FOLLOW_severity_in_reportStat1883 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_reportStat1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_severity1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_severity1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_severity1938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_fieldStat1973 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_fieldStat1977 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_fieldStat1981 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_fieldStat1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_paramStat2019 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_paramStat2023 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_paramStat2027 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_paramStat2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelStat_in_emitStat2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newStat_in_emitStat2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dupStat_in_emitStat2078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dupX1Stat_in_emitStat2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_popStat_in_emitStat2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_swapStat_in_emitStat2093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterateStat_in_emitStat2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_endIterateStat_in_emitStat2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getAsmStat_in_emitStat2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_findMEStat_in_emitStat2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushTStat_in_emitStat2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushFStat_in_emitStat2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emitWithOperandStat_in_emitStat2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emitWithLabelRefStat_in_emitStat2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_labelStat2168 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_LPAREN_in_labelStat2174 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_labelStat2178 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_labelStat2182 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_labelStat2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_newStat2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_dupStat2258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_dupX1Stat2290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_popStat2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_swapStat2354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_iterateStat2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_endIterateStat2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_getAsmStat2450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_findMEStat2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_pushTStat2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_pushFStat2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushStat_in_emitWithOperandStat2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushIStat_in_emitWithOperandStat2586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushDStat_in_emitWithOperandStat2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loadStat_in_emitWithOperandStat2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_storeStat_in_emitWithOperandStat2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callStat_in_emitWithOperandStat2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_superCallStat_in_emitWithOperandStat2611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getStat_in_emitWithOperandStat2616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setStat_in_emitWithOperandStat2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_pushStat2654 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_pushStat2658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_pushIStat2692 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_pushIStat2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_pushDStat2730 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_pushDStat2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_loadStat2768 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_loadStat2772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_storeStat2806 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_storeStat2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_callStat2844 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_callStat2848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_superCallStat2882 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_superCallStat2886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_getStat2920 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_getStat2924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_setStat2958 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_setStat2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gotoStat_in_emitWithLabelRefStat2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_emitWithLabelRefStat3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_gotoStat3037 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_gotoStat3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ifStat3075 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_ifStat3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableDecl3115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_5_in_expression3151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letExp_in_expression3156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableExp3190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_selfExp3224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_lastExp3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ifExp3288 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_ifExp3292 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_ifExp3296 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_ifExp3300 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ifExp3304 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_ifExp3308 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ifExp3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_isAExp3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_letExp3381 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDecl_in_letExp3385 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_letExp3389 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_letExp3393 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_letExp3397 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_letExp3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_navigationExp3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_iteratorExp3475 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_iteratorExp3479 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDecl_in_iteratorExp3483 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_PIPE_in_iteratorExp3487 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_iteratorExp3491 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_iteratorExp3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_operationCallExp3530 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_operationCallExp3534 = new BitSet(new long[]{0x0500000000201470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_operationCallExp3540 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMA_in_operationCallExp3547 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_operationCallExp3552 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_operationCallExp3562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclUndefinedExp_in_literalExp3626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionExp_in_literalExp3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanExp_in_literalExp3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerExp_in_literalExp3641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExp_in_literalExp3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_oclUndefinedExp3679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceExp_in_collectionExp3713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_sequenceExp3745 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_sequenceExp3747 = new BitSet(new long[]{0x0500000000200570L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_sequenceExp3753 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_COMA_in_sequenceExp3760 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_sequenceExp3765 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_RCURLY_in_sequenceExp3775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_booleanExp3809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_booleanExp3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_integerExp3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_stringExp3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_in_priority_03926 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_POINT_in_priority_03931 = new BitSet(new long[]{0xFFFFFC0000000010L,0x0000007FFFFFFFFFL});
    public static final BitSet FOLLOW_navigationExp_in_priority_03938 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_operationCallExp_in_priority_03945 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_RARROW_in_priority_03953 = new BitSet(new long[]{0xFFFFFC0000000010L,0x0000007FFFFFFFFFL});
    public static final BitSet FOLLOW_iteratorExp_in_priority_03959 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_95_in_priority_13998 = new BitSet(new long[]{0x0100000000000470L,0x0000000079800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_14005 = new BitSet(new long[]{0x0100000000000470L,0x0000000079800000L});
    public static final BitSet FOLLOW_priority_0_in_priority_14010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_priority_14018 = new BitSet(new long[]{0x0100000000000470L,0x0000000079800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_14025 = new BitSet(new long[]{0x0100000000000470L,0x0000000079800000L});
    public static final BitSet FOLLOW_priority_0_in_priority_14030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_0_in_priority_14040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_1_in_priority_24075 = new BitSet(new long[]{0x0000000000C00002L,0x0000000300000000L});
    public static final BitSet FOLLOW_STAR_in_priority_24080 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_24087 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_1_in_priority_24092 = new BitSet(new long[]{0x0000000000C00002L,0x0000000300000000L});
    public static final BitSet FOLLOW_SLASH_in_priority_24100 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_24107 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_1_in_priority_24112 = new BitSet(new long[]{0x0000000000C00002L,0x0000000300000000L});
    public static final BitSet FOLLOW_96_in_priority_24120 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_24127 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_1_in_priority_24132 = new BitSet(new long[]{0x0000000000C00002L,0x0000000300000000L});
    public static final BitSet FOLLOW_97_in_priority_24140 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_24147 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_1_in_priority_24152 = new BitSet(new long[]{0x0000000000C00002L,0x0000000300000000L});
    public static final BitSet FOLLOW_priority_2_in_priority_34193 = new BitSet(new long[]{0x0000000001200002L});
    public static final BitSet FOLLOW_PLUS_in_priority_34198 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_34205 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_2_in_priority_34210 = new BitSet(new long[]{0x0000000001200002L});
    public static final BitSet FOLLOW_MINUS_in_priority_34218 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_34225 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_2_in_priority_34230 = new BitSet(new long[]{0x0000000001200002L});
    public static final BitSet FOLLOW_priority_3_in_priority_44271 = new BitSet(new long[]{0x000000003E002002L,0x0000000400000000L});
    public static final BitSet FOLLOW_EQ_in_priority_44276 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44283 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44288 = new BitSet(new long[]{0x000000003E002002L,0x0000000400000000L});
    public static final BitSet FOLLOW_GT_in_priority_44296 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44303 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44308 = new BitSet(new long[]{0x000000003E002002L,0x0000000400000000L});
    public static final BitSet FOLLOW_LT_in_priority_44316 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44323 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44328 = new BitSet(new long[]{0x000000003E002002L,0x0000000400000000L});
    public static final BitSet FOLLOW_GE_in_priority_44336 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44343 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44348 = new BitSet(new long[]{0x000000003E002002L,0x0000000400000000L});
    public static final BitSet FOLLOW_LE_in_priority_44356 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44363 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44368 = new BitSet(new long[]{0x000000003E002002L,0x0000000400000000L});
    public static final BitSet FOLLOW_NE_in_priority_44376 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44383 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44388 = new BitSet(new long[]{0x000000003E002002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_priority_44396 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_isAExp_in_priority_44402 = new BitSet(new long[]{0x000000003E002002L,0x0000000400000000L});
    public static final BitSet FOLLOW_priority_4_in_priority_54442 = new BitSet(new long[]{0x0000000000000002L,0x0000007800000000L});
    public static final BitSet FOLLOW_99_in_priority_54447 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_54454 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_4_in_priority_54459 = new BitSet(new long[]{0x0000000000000002L,0x0000007800000000L});
    public static final BitSet FOLLOW_100_in_priority_54467 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_54474 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_4_in_priority_54479 = new BitSet(new long[]{0x0000000000000002L,0x0000007800000000L});
    public static final BitSet FOLLOW_101_in_priority_54487 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_54494 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_4_in_priority_54499 = new BitSet(new long[]{0x0000000000000002L,0x0000007800000000L});
    public static final BitSet FOLLOW_102_in_priority_54507 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_54514 = new BitSet(new long[]{0x0100000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_priority_4_in_priority_54519 = new BitSet(new long[]{0x0000000000000002L,0x0000007800000000L});
    public static final BitSet FOLLOW_LPAREN_in_primary_expression4559 = new BitSet(new long[]{0x0500000000200470L,0x00000000F9800000L});
    public static final BitSet FOLLOW_expression_in_primary_expression4563 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_expression4565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExp_in_primary_expression4571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selfExp_in_primary_expression4576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lastExp_in_primary_expression4581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifExp_in_primary_expression4586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalExp_in_primary_expression4591 = new BitSet(new long[]{0x0000000000000002L});

}