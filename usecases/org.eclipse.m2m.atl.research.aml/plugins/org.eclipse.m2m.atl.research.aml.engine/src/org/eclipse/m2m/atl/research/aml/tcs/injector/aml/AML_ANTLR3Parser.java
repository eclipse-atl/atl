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

// $ANTLR 3.0.1 C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g 2009-10-16 16:58:52
package org.eclipse.m2m.atl.research.aml.tcs.injector.aml;

import org.antlr.runtime.*;
import org.eclipse.m2m.atl.dsls.tcs.injector.TCSRuntime;
import org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class AML_ANTLR3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "LCURLY", "RCURLY", "COLON", "EQ", "LSQUARE", "COMA", "RSQUARE", "LPAREN", "RPAREN", "LARROW", "SEMI", "EXCL", "PIPE", "SHARP", "POINT", "RARROW", "MINUS", "STAR", "SLASH", "PLUS", "GT", "LT", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "QMARK", "COLONCOLON", "COMMENT", "'strategy'", "'models'", "'modelsFlow'", "'create'", "'ATLLibraries'", "'JavaLibraries'", "'using'", "'sim'", "'aggr'", "'sel'", "'uses'", "'from'", "'when'", "'leftType'", "'rightType'", "'in'", "'is'", "'to'", "'mapsTo'", "'EqualModel'", "'WeavingModel'", "'thisModule'", "'thisRight'", "'thisLeft'", "'thisEqual'", "'thisWeight'", "'thisSim'", "'thisInstances'", "'Summation'", "'thisEqualModel'", "'name'", "'path'", "'imports'", "'super'", "'iterate'", "'OclUndefined'", "'true'", "'false'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'Bag'", "'Set'", "'OrderedSet'", "'Sequence'", "'Map'", "'Tuple'", "'OclType'", "'OclAny'", "'TupleType'", "'Integer'", "'Real'", "'Boolean'", "'String'", "'Collection'", "'not'", "'div'", "'mod'", "'and'", "'or'", "'xor'", "'implies'"
    };
    public static final int GE=30;
    public static final int LT=29;
    public static final int STAR=25;
    public static final int LSQUARE=12;
    public static final int SHARP=21;
    public static final int POINT=22;
    public static final int ESC=38;
    public static final int RARROW=23;
    public static final int LARROW=17;
    public static final int LCURLY=8;
    public static final int FLOAT=7;
    public static final int INT=6;
    public static final int EXCL=19;
    public static final int MINUS=24;
    public static final int RSQUARE=14;
    public static final int EOF=-1;
    public static final int COMA=13;
    public static final int SEMI=18;
    public static final int ALPHA=36;
    public static final int LPAREN=15;
    public static final int COLON=10;
    public static final int COLONCOLON=40;
    public static final int RPAREN=16;
    public static final int NAME=4;
    public static final int WS=34;
    public static final int SLASH=26;
    public static final int SNAME=37;
    public static final int RCURLY=9;
    public static final int GT=28;
    public static final int PLUS=27;
    public static final int PIPE=20;
    public static final int DIGIT=35;
    public static final int NL=33;
    public static final int EQ=11;
    public static final int COMMENT=41;
    public static final int QMARK=39;
    public static final int LE=31;
    public static final int STRING=5;
    public static final int NE=32;

        public AML_ANTLR3Parser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g"; }


        public TCSRuntime ei = null;
        
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
        AML_ANTLR3Lexer lex = new 
        AML_ANTLR3Lexer(input);
    						CommonTokenStream tokens = new CommonTokenStream(lex);
    						tokens.discardTokenType(WS);
    						tokens.discardTokenType(COMMENT);
    						tokens.discardTokenType(NL);
    						
        AML_ANTLR3Parser parser = new 
        AML_ANTLR3Parser(tokens);
    						parser.main();
    					}



    // $ANTLR start main
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:60:1: main returns [Object ret2] : ( (ret= matcher ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:61:2: ( ( (ret= matcher ) EOF ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:61:4: ( (ret= matcher ) EOF )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:61:4: ( (ret= matcher ) EOF )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:61:5: (ret= matcher ) EOF
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:61:5: (ret= matcher )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:61:6: ret= matcher
            {
            pushFollow(FOLLOW_matcher_in_main46);
            ret=matcher();
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:68:1: identifier returns [Object ret2] : ast= NAME ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:69:2: (ast= NAME )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:69:4: ast= NAME
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:76:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'strategy' | 'models' | 'modelsFlow' | 'create' | 'ATLLibraries' | 'JavaLibraries' | 'using' | 'sim' | 'aggr' | 'sel' | 'uses' | 'from' | 'when' | 'leftType' | 'rightType' | 'in' | 'is' | 'to' | 'mapsTo' | 'EqualModel' | 'WeavingModel' | 'thisModule' | 'thisRight' | 'thisLeft' | 'thisEqual' | 'thisWeight' | 'thisSim' | 'thisInstances' | 'Summation' | 'thisEqualModel' | 'name' | 'path' | 'imports' | 'super' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'if' | 'then' | 'else' | 'endif' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:2: ( (ast= NAME | 'strategy' | 'models' | 'modelsFlow' | 'create' | 'ATLLibraries' | 'JavaLibraries' | 'using' | 'sim' | 'aggr' | 'sel' | 'uses' | 'from' | 'when' | 'leftType' | 'rightType' | 'in' | 'is' | 'to' | 'mapsTo' | 'EqualModel' | 'WeavingModel' | 'thisModule' | 'thisRight' | 'thisLeft' | 'thisEqual' | 'thisWeight' | 'thisSim' | 'thisInstances' | 'Summation' | 'thisEqualModel' | 'name' | 'path' | 'imports' | 'super' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'if' | 'then' | 'else' | 'endif' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:4: (ast= NAME | 'strategy' | 'models' | 'modelsFlow' | 'create' | 'ATLLibraries' | 'JavaLibraries' | 'using' | 'sim' | 'aggr' | 'sel' | 'uses' | 'from' | 'when' | 'leftType' | 'rightType' | 'in' | 'is' | 'to' | 'mapsTo' | 'EqualModel' | 'WeavingModel' | 'thisModule' | 'thisRight' | 'thisLeft' | 'thisEqual' | 'thisWeight' | 'thisSim' | 'thisInstances' | 'Summation' | 'thisEqualModel' | 'name' | 'path' | 'imports' | 'super' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'if' | 'then' | 'else' | 'endif' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:4: (ast= NAME | 'strategy' | 'models' | 'modelsFlow' | 'create' | 'ATLLibraries' | 'JavaLibraries' | 'using' | 'sim' | 'aggr' | 'sel' | 'uses' | 'from' | 'when' | 'leftType' | 'rightType' | 'in' | 'is' | 'to' | 'mapsTo' | 'EqualModel' | 'WeavingModel' | 'thisModule' | 'thisRight' | 'thisLeft' | 'thisEqual' | 'thisWeight' | 'thisSim' | 'thisInstances' | 'Summation' | 'thisEqualModel' | 'name' | 'path' | 'imports' | 'super' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'if' | 'then' | 'else' | 'endif' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )
            int alt1=65;
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
            case 103:
                {
                alt1=63;
                }
                break;
            case 104:
                {
                alt1=64;
                }
                break;
            case 105:
                {
                alt1=65;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("77:4: (ast= NAME | 'strategy' | 'models' | 'modelsFlow' | 'create' | 'ATLLibraries' | 'JavaLibraries' | 'using' | 'sim' | 'aggr' | 'sel' | 'uses' | 'from' | 'when' | 'leftType' | 'rightType' | 'in' | 'is' | 'to' | 'mapsTo' | 'EqualModel' | 'WeavingModel' | 'thisModule' | 'thisRight' | 'thisLeft' | 'thisEqual' | 'thisWeight' | 'thisSim' | 'thisInstances' | 'Summation' | 'thisEqualModel' | 'name' | 'path' | 'imports' | 'super' | 'iterate' | 'OclUndefined' | 'true' | 'false' | 'if' | 'then' | 'else' | 'endif' | 'let' | 'Bag' | 'Set' | 'OrderedSet' | 'Sequence' | 'Map' | 'Tuple' | 'OclType' | 'OclAny' | 'TupleType' | 'Integer' | 'Real' | 'Boolean' | 'String' | 'Collection' | 'not' | 'div' | 'mod' | 'and' | 'or' | 'xor' | 'implies' )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:5: ast= NAME
                    {
                    ast=(Token)input.LT(1);
                    match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword117); 
                    ret = ast.getText(); ei.setToken((Object)ast);

                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:64: 'strategy'
                    {
                    match(input,42,FOLLOW_42_in_identifierOrKeyword122); 
                    ret = "strategy";

                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:96: 'models'
                    {
                    match(input,43,FOLLOW_43_in_identifierOrKeyword127); 
                    ret = "models";

                    }
                    break;
                case 4 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:124: 'modelsFlow'
                    {
                    match(input,44,FOLLOW_44_in_identifierOrKeyword132); 
                    ret = "modelsFlow";

                    }
                    break;
                case 5 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:160: 'create'
                    {
                    match(input,45,FOLLOW_45_in_identifierOrKeyword137); 
                    ret = "create";

                    }
                    break;
                case 6 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:188: 'ATLLibraries'
                    {
                    match(input,46,FOLLOW_46_in_identifierOrKeyword142); 
                    ret = "ATLLibraries";

                    }
                    break;
                case 7 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:228: 'JavaLibraries'
                    {
                    match(input,47,FOLLOW_47_in_identifierOrKeyword147); 
                    ret = "JavaLibraries";

                    }
                    break;
                case 8 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:270: 'using'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword152); 
                    ret = "using";

                    }
                    break;
                case 9 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:296: 'sim'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword157); 
                    ret = "sim";

                    }
                    break;
                case 10 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:318: 'aggr'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword162); 
                    ret = "aggr";

                    }
                    break;
                case 11 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:342: 'sel'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword167); 
                    ret = "sel";

                    }
                    break;
                case 12 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:364: 'uses'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword172); 
                    ret = "uses";

                    }
                    break;
                case 13 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:388: 'from'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword177); 
                    ret = "from";

                    }
                    break;
                case 14 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:412: 'when'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword182); 
                    ret = "when";

                    }
                    break;
                case 15 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:436: 'leftType'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword187); 
                    ret = "leftType";

                    }
                    break;
                case 16 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:468: 'rightType'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword192); 
                    ret = "rightType";

                    }
                    break;
                case 17 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:502: 'in'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword197); 
                    ret = "in";

                    }
                    break;
                case 18 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:522: 'is'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword202); 
                    ret = "is";

                    }
                    break;
                case 19 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:542: 'to'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword207); 
                    ret = "to";

                    }
                    break;
                case 20 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:562: 'mapsTo'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword212); 
                    ret = "mapsTo";

                    }
                    break;
                case 21 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:590: 'EqualModel'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword217); 
                    ret = "EqualModel";

                    }
                    break;
                case 22 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:626: 'WeavingModel'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword222); 
                    ret = "WeavingModel";

                    }
                    break;
                case 23 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:666: 'thisModule'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword227); 
                    ret = "thisModule";

                    }
                    break;
                case 24 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:702: 'thisRight'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword232); 
                    ret = "thisRight";

                    }
                    break;
                case 25 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:736: 'thisLeft'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword237); 
                    ret = "thisLeft";

                    }
                    break;
                case 26 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:768: 'thisEqual'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword242); 
                    ret = "thisEqual";

                    }
                    break;
                case 27 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:802: 'thisWeight'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword247); 
                    ret = "thisWeight";

                    }
                    break;
                case 28 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:838: 'thisSim'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword252); 
                    ret = "thisSim";

                    }
                    break;
                case 29 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:868: 'thisInstances'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword257); 
                    ret = "thisInstances";

                    }
                    break;
                case 30 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:910: 'Summation'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword262); 
                    ret = "Summation";

                    }
                    break;
                case 31 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:944: 'thisEqualModel'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword267); 
                    ret = "thisEqualModel";

                    }
                    break;
                case 32 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:988: 'name'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword272); 
                    ret = "name";

                    }
                    break;
                case 33 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1012: 'path'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword277); 
                    ret = "path";

                    }
                    break;
                case 34 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1036: 'imports'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword282); 
                    ret = "imports";

                    }
                    break;
                case 35 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1066: 'super'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword287); 
                    ret = "super";

                    }
                    break;
                case 36 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1092: 'iterate'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword292); 
                    ret = "iterate";

                    }
                    break;
                case 37 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1122: 'OclUndefined'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword297); 
                    ret = "OclUndefined";

                    }
                    break;
                case 38 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1162: 'true'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword302); 
                    ret = "true";

                    }
                    break;
                case 39 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1186: 'false'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword307); 
                    ret = "false";

                    }
                    break;
                case 40 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1212: 'if'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword312); 
                    ret = "if";

                    }
                    break;
                case 41 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1232: 'then'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword317); 
                    ret = "then";

                    }
                    break;
                case 42 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1256: 'else'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword322); 
                    ret = "else";

                    }
                    break;
                case 43 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1280: 'endif'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword327); 
                    ret = "endif";

                    }
                    break;
                case 44 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1306: 'let'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword332); 
                    ret = "let";

                    }
                    break;
                case 45 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1328: 'Bag'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword337); 
                    ret = "Bag";

                    }
                    break;
                case 46 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1350: 'Set'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword342); 
                    ret = "Set";

                    }
                    break;
                case 47 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1372: 'OrderedSet'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword347); 
                    ret = "OrderedSet";

                    }
                    break;
                case 48 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1408: 'Sequence'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword352); 
                    ret = "Sequence";

                    }
                    break;
                case 49 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1440: 'Map'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword357); 
                    ret = "Map";

                    }
                    break;
                case 50 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1462: 'Tuple'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword362); 
                    ret = "Tuple";

                    }
                    break;
                case 51 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1488: 'OclType'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword367); 
                    ret = "OclType";

                    }
                    break;
                case 52 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1518: 'OclAny'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword372); 
                    ret = "OclAny";

                    }
                    break;
                case 53 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1546: 'TupleType'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword377); 
                    ret = "TupleType";

                    }
                    break;
                case 54 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1580: 'Integer'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword382); 
                    ret = "Integer";

                    }
                    break;
                case 55 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1610: 'Real'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword387); 
                    ret = "Real";

                    }
                    break;
                case 56 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1634: 'Boolean'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword392); 
                    ret = "Boolean";

                    }
                    break;
                case 57 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1664: 'String'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword397); 
                    ret = "String";

                    }
                    break;
                case 58 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1692: 'Collection'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword402); 
                    ret = "Collection";

                    }
                    break;
                case 59 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1728: 'not'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword407); 
                    ret = "not";

                    }
                    break;
                case 60 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1750: 'div'
                    {
                    match(input,100,FOLLOW_100_in_identifierOrKeyword412); 
                    ret = "div";

                    }
                    break;
                case 61 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1772: 'mod'
                    {
                    match(input,101,FOLLOW_101_in_identifierOrKeyword417); 
                    ret = "mod";

                    }
                    break;
                case 62 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1794: 'and'
                    {
                    match(input,102,FOLLOW_102_in_identifierOrKeyword422); 
                    ret = "and";

                    }
                    break;
                case 63 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1816: 'or'
                    {
                    match(input,103,FOLLOW_103_in_identifierOrKeyword427); 
                    ret = "or";

                    }
                    break;
                case 64 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1836: 'xor'
                    {
                    match(input,104,FOLLOW_104_in_identifierOrKeyword432); 
                    ret = "xor";

                    }
                    break;
                case 65 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:1858: 'implies'
                    {
                    match(input,105,FOLLOW_105_in_identifierOrKeyword437); 
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:84:1: stringSymbol returns [Object ret2] : ast= STRING ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:85:2: (ast= STRING )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:85:4: ast= STRING
            {
            ast=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_stringSymbol472); 
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:92:1: integerSymbol returns [Object ret2] : ast= INT ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:93:2: (ast= INT )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:93:4: ast= INT
            {
            ast=(Token)input.LT(1);
            match(input,INT,FOLLOW_INT_in_integerSymbol506); 
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


    // $ANTLR start floatSymbol
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:100:1: floatSymbol returns [Object ret2] : ast= FLOAT ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:101:2: (ast= FLOAT )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:101:4: ast= FLOAT
            {
            ast=(Token)input.LT(1);
            match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol540); 
            ret = Double.valueOf(ast.getText()); ei.setToken((Object)ast);

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
    // $ANTLR end floatSymbol


    // $ANTLR start matcher
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:108:1: matcher returns [Object ret2] : ( 'strategy' temp= identifier LCURLY ( ( ( (temp= matcherRef ( (temp= matcherRef ) )* ) )? ( (temp= method ( (temp= method ) )* ) )? ( ( ( (temp= modelsBlock ) ) ) | () ) ( ( ( (temp= modelsFlowsBlock ) ) ) | () ) ) ) RCURLY ) ;
    public final Object matcher() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Matcher", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:2: ( ( 'strategy' temp= identifier LCURLY ( ( ( (temp= matcherRef ( (temp= matcherRef ) )* ) )? ( (temp= method ( (temp= method ) )* ) )? ( ( ( (temp= modelsBlock ) ) ) | () ) ( ( ( (temp= modelsFlowsBlock ) ) ) | () ) ) ) RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:4: ( 'strategy' temp= identifier LCURLY ( ( ( (temp= matcherRef ( (temp= matcherRef ) )* ) )? ( (temp= method ( (temp= method ) )* ) )? ( ( ( (temp= modelsBlock ) ) ) | () ) ( ( ( (temp= modelsFlowsBlock ) ) ) | () ) ) ) RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:4: ( 'strategy' temp= identifier LCURLY ( ( ( (temp= matcherRef ( (temp= matcherRef ) )* ) )? ( (temp= method ( (temp= method ) )* ) )? ( ( ( (temp= modelsBlock ) ) ) | () ) ( ( ( (temp= modelsFlowsBlock ) ) ) | () ) ) ) RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:5: 'strategy' temp= identifier LCURLY ( ( ( (temp= matcherRef ( (temp= matcherRef ) )* ) )? ( (temp= method ( (temp= method ) )* ) )? ( ( ( (temp= modelsBlock ) ) ) | () ) ( ( ( (temp= modelsFlowsBlock ) ) ) | () ) ) ) RCURLY
            {
            match(input,42,FOLLOW_42_in_matcher573); 
            pushFollow(FOLLOW_identifier_in_matcher577);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_matcher581); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:68: ( ( ( (temp= matcherRef ( (temp= matcherRef ) )* ) )? ( (temp= method ( (temp= method ) )* ) )? ( ( ( (temp= modelsBlock ) ) ) | () ) ( ( ( (temp= modelsFlowsBlock ) ) ) | () ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:69: ( ( (temp= matcherRef ( (temp= matcherRef ) )* ) )? ( (temp= method ( (temp= method ) )* ) )? ( ( ( (temp= modelsBlock ) ) ) | () ) ( ( ( (temp= modelsFlowsBlock ) ) ) | () ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:69: ( ( (temp= matcherRef ( (temp= matcherRef ) )* ) )? ( (temp= method ( (temp= method ) )* ) )? ( ( ( (temp= modelsBlock ) ) ) | () ) ( ( ( (temp= modelsFlowsBlock ) ) ) | () ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:70: ( (temp= matcherRef ( (temp= matcherRef ) )* ) )? ( (temp= method ( (temp= method ) )* ) )? ( ( ( (temp= modelsBlock ) ) ) | () ) ( ( ( (temp= modelsFlowsBlock ) ) ) | () )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:70: ( (temp= matcherRef ( (temp= matcherRef ) )* ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==74) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:71: (temp= matcherRef ( (temp= matcherRef ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:71: (temp= matcherRef ( (temp= matcherRef ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:72: temp= matcherRef ( (temp= matcherRef ) )*
                    {
                    pushFollow(FOLLOW_matcherRef_in_matcher589);
                    temp=matcherRef();
                    _fsp--;

                    ei.set(ret, "matchers", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:121: ( (temp= matcherRef ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==74) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:122: (temp= matcherRef )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:122: (temp= matcherRef )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:123: temp= matcherRef
                    	    {
                    	    pushFollow(FOLLOW_matcherRef_in_matcher597);
                    	    temp=matcherRef();
                    	    _fsp--;

                    	    ei.set(ret, "matchers", temp);

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

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:178: ( (temp= method ( (temp= method ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==45||(LA5_0>=49 && LA5_0<=52)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:179: (temp= method ( (temp= method ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:179: (temp= method ( (temp= method ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:180: temp= method ( (temp= method ) )*
                    {
                    pushFollow(FOLLOW_method_in_matcher611);
                    temp=method();
                    _fsp--;

                    ei.set(ret, "methods", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:224: ( (temp= method ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==45||(LA4_0>=49 && LA4_0<=52)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:225: (temp= method )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:225: (temp= method )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:226: temp= method
                    	    {
                    	    pushFollow(FOLLOW_method_in_matcher619);
                    	    temp=method();
                    	    _fsp--;

                    	    ei.set(ret, "methods", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:276: ( ( ( (temp= modelsBlock ) ) ) | () )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==43) ) {
                alt6=1;
            }
            else if ( (LA6_0==RCURLY||LA6_0==44) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("109:276: ( ( ( (temp= modelsBlock ) ) ) | () )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:277: ( ( (temp= modelsBlock ) ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:277: ( ( (temp= modelsBlock ) ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:278: ( (temp= modelsBlock ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:278: ( (temp= modelsBlock ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:279: (temp= modelsBlock )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:279: (temp= modelsBlock )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:280: temp= modelsBlock
                    {
                    pushFollow(FOLLOW_modelsBlock_in_matcher635);
                    temp=modelsBlock();
                    _fsp--;

                    ei.set(ret, "modelsBlock", temp);

                    }


                    }


                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:340: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:340: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:341: 
                    {
                    }



                    }
                    break;

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:347: ( ( ( (temp= modelsFlowsBlock ) ) ) | () )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==44) ) {
                alt7=1;
            }
            else if ( (LA7_0==RCURLY) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("109:347: ( ( ( (temp= modelsFlowsBlock ) ) ) | () )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:348: ( ( (temp= modelsFlowsBlock ) ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:348: ( ( (temp= modelsFlowsBlock ) ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:349: ( (temp= modelsFlowsBlock ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:349: ( (temp= modelsFlowsBlock ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:350: (temp= modelsFlowsBlock )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:350: (temp= modelsFlowsBlock )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:351: temp= modelsFlowsBlock
                    {
                    pushFollow(FOLLOW_modelsFlowsBlock_in_matcher657);
                    temp=modelsFlowsBlock();
                    _fsp--;

                    ei.set(ret, "modelsFlowsBlock", temp);

                    }


                    }


                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:421: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:421: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:109:422: 
                    {
                    }



                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_matcher675); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end matcher


    // $ANTLR start modelsBlock
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:119:1: modelsBlock returns [Object ret2] : ( 'models' LCURLY ( ( ( (temp= model ( (temp= model ) )* ) )? ) ) RCURLY ) ;
    public final Object modelsBlock() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ModelsBlock", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:2: ( ( 'models' LCURLY ( ( ( (temp= model ( (temp= model ) )* ) )? ) ) RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:4: ( 'models' LCURLY ( ( ( (temp= model ( (temp= model ) )* ) )? ) ) RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:4: ( 'models' LCURLY ( ( ( (temp= model ( (temp= model ) )* ) )? ) ) RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:5: 'models' LCURLY ( ( ( (temp= model ( (temp= model ) )* ) )? ) ) RCURLY
            {
            match(input,43,FOLLOW_43_in_modelsBlock707); 
            match(input,LCURLY,FOLLOW_LCURLY_in_modelsBlock709); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:21: ( ( ( (temp= model ( (temp= model ) )* ) )? ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:22: ( ( (temp= model ( (temp= model ) )* ) )? )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:22: ( ( (temp= model ( (temp= model ) )* ) )? )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:23: ( (temp= model ( (temp= model ) )* ) )?
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:23: ( (temp= model ( (temp= model ) )* ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NAME) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:24: (temp= model ( (temp= model ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:24: (temp= model ( (temp= model ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:25: temp= model ( (temp= model ) )*
                    {
                    pushFollow(FOLLOW_model_in_modelsBlock717);
                    temp=model();
                    _fsp--;

                    ei.set(ret, "models", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:67: ( (temp= model ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==NAME) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:68: (temp= model )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:68: (temp= model )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:120:69: temp= model
                    	    {
                    	    pushFollow(FOLLOW_model_in_modelsBlock725);
                    	    temp=model();
                    	    _fsp--;

                    	    ei.set(ret, "models", temp);

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

            match(input,RCURLY,FOLLOW_RCURLY_in_modelsBlock737); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end modelsBlock


    // $ANTLR start modelsFlowsBlock
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:130:1: modelsFlowsBlock returns [Object ret2] : ( 'modelsFlow' LCURLY ( ( ( (temp= methodCall ( (temp= methodCall ) )* ) )? ) ) RCURLY ) ;
    public final Object modelsFlowsBlock() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ModelsFlowsBlock", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:2: ( ( 'modelsFlow' LCURLY ( ( ( (temp= methodCall ( (temp= methodCall ) )* ) )? ) ) RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:4: ( 'modelsFlow' LCURLY ( ( ( (temp= methodCall ( (temp= methodCall ) )* ) )? ) ) RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:4: ( 'modelsFlow' LCURLY ( ( ( (temp= methodCall ( (temp= methodCall ) )* ) )? ) ) RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:5: 'modelsFlow' LCURLY ( ( ( (temp= methodCall ( (temp= methodCall ) )* ) )? ) ) RCURLY
            {
            match(input,44,FOLLOW_44_in_modelsFlowsBlock769); 
            match(input,LCURLY,FOLLOW_LCURLY_in_modelsFlowsBlock771); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:25: ( ( ( (temp= methodCall ( (temp= methodCall ) )* ) )? ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:26: ( ( (temp= methodCall ( (temp= methodCall ) )* ) )? )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:26: ( ( (temp= methodCall ( (temp= methodCall ) )* ) )? )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:27: ( (temp= methodCall ( (temp= methodCall ) )* ) )?
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:27: ( (temp= methodCall ( (temp= methodCall ) )* ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NAME) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:28: (temp= methodCall ( (temp= methodCall ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:28: (temp= methodCall ( (temp= methodCall ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:29: temp= methodCall ( (temp= methodCall ) )*
                    {
                    pushFollow(FOLLOW_methodCall_in_modelsFlowsBlock779);
                    temp=methodCall();
                    _fsp--;

                    ei.set(ret, "modelsFlows", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:81: ( (temp= methodCall ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==NAME) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:82: (temp= methodCall )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:82: (temp= methodCall )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:131:83: temp= methodCall
                    	    {
                    	    pushFollow(FOLLOW_methodCall_in_modelsFlowsBlock787);
                    	    temp=methodCall();
                    	    _fsp--;

                    	    ei.set(ret, "modelsFlows", temp);

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


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_modelsFlowsBlock799); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end modelsFlowsBlock


    // $ANTLR start modelFlowExpression
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:141:1: modelFlowExpression returns [Object ret2] : ( (ret= weightedModelExp | ret= methodCall | ret= mappingModelRefExp ) ) ;
    public final Object modelFlowExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:142:2: ( ( (ret= weightedModelExp | ret= methodCall | ret= mappingModelRefExp ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:142:4: ( (ret= weightedModelExp | ret= methodCall | ret= mappingModelRefExp ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:142:4: ( (ret= weightedModelExp | ret= methodCall | ret= mappingModelRefExp ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:142:5: (ret= weightedModelExp | ret= methodCall | ret= mappingModelRefExp )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:142:5: (ret= weightedModelExp | ret= methodCall | ret= mappingModelRefExp )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==FLOAT) ) {
                alt12=1;
            }
            else if ( (LA12_0==NAME) ) {
                int LA12_2 = input.LA(2);

                if ( ((LA12_2>=COMA && LA12_2<=RSQUARE)) ) {
                    alt12=3;
                }
                else if ( ((LA12_2>=COLON && LA12_2<=LSQUARE)) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("142:5: (ret= weightedModelExp | ret= methodCall | ret= mappingModelRefExp )", 12, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("142:5: (ret= weightedModelExp | ret= methodCall | ret= mappingModelRefExp )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:142:6: ret= weightedModelExp
                    {
                    pushFollow(FOLLOW_weightedModelExp_in_modelFlowExpression834);
                    ret=weightedModelExp();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:142:28: ret= methodCall
                    {
                    pushFollow(FOLLOW_methodCall_in_modelFlowExpression839);
                    ret=methodCall();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:142:44: ret= mappingModelRefExp
                    {
                    pushFollow(FOLLOW_mappingModelRefExp_in_modelFlowExpression844);
                    ret=mappingModelRefExp();
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
    // $ANTLR end modelFlowExpression


    // $ANTLR start weightedModelExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:150:1: weightedModelExp returns [Object ret2] : (temp= floatSymbol COLON temp= modelFlowExpression ) ;
    public final Object weightedModelExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("WeightedModelExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:151:2: ( (temp= floatSymbol COLON temp= modelFlowExpression ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:151:4: (temp= floatSymbol COLON temp= modelFlowExpression )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:151:4: (temp= floatSymbol COLON temp= modelFlowExpression )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:151:5: temp= floatSymbol COLON temp= modelFlowExpression
            {
            pushFollow(FOLLOW_floatSymbol_in_weightedModelExp879);
            temp=floatSymbol();
            _fsp--;

            ei.set(ret, "weight", temp);
            match(input,COLON,FOLLOW_COLON_in_weightedModelExp883); 
            pushFollow(FOLLOW_modelFlowExpression_in_weightedModelExp887);
            temp=modelFlowExpression();
            _fsp--;

            ei.set(ret, "modelFlowExp", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end weightedModelExp


    // $ANTLR start methodCall
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:161:1: methodCall returns [Object ret2] : ( ( ( ( (temp= mappingModel EQ ) ) ) | () ) temp= identifier LSQUARE ( (temp= modelFlowExpression ( ( ( COMA ) temp= modelFlowExpression ) )* ) ) RSQUARE ( ( LPAREN ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )? RPAREN ) | () ) ) ;
    public final Object methodCall() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MethodCall", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:2: ( ( ( ( ( (temp= mappingModel EQ ) ) ) | () ) temp= identifier LSQUARE ( (temp= modelFlowExpression ( ( ( COMA ) temp= modelFlowExpression ) )* ) ) RSQUARE ( ( LPAREN ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )? RPAREN ) | () ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:4: ( ( ( ( (temp= mappingModel EQ ) ) ) | () ) temp= identifier LSQUARE ( (temp= modelFlowExpression ( ( ( COMA ) temp= modelFlowExpression ) )* ) ) RSQUARE ( ( LPAREN ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )? RPAREN ) | () ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:4: ( ( ( ( (temp= mappingModel EQ ) ) ) | () ) temp= identifier LSQUARE ( (temp= modelFlowExpression ( ( ( COMA ) temp= modelFlowExpression ) )* ) ) RSQUARE ( ( LPAREN ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )? RPAREN ) | () ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:5: ( ( ( (temp= mappingModel EQ ) ) ) | () ) temp= identifier LSQUARE ( (temp= modelFlowExpression ( ( ( COMA ) temp= modelFlowExpression ) )* ) ) RSQUARE ( ( LPAREN ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )? RPAREN ) | () )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:5: ( ( ( (temp= mappingModel EQ ) ) ) | () )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NAME) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==LSQUARE) ) {
                    alt13=2;
                }
                else if ( ((LA13_1>=COLON && LA13_1<=EQ)) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("162:5: ( ( ( (temp= mappingModel EQ ) ) ) | () )", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("162:5: ( ( ( (temp= mappingModel EQ ) ) ) | () )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:6: ( ( (temp= mappingModel EQ ) ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:6: ( ( (temp= mappingModel EQ ) ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:7: ( (temp= mappingModel EQ ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:7: ( (temp= mappingModel EQ ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:8: (temp= mappingModel EQ )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:8: (temp= mappingModel EQ )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:9: temp= mappingModel EQ
                    {
                    pushFollow(FOLLOW_mappingModel_in_methodCall927);
                    temp=mappingModel();
                    _fsp--;

                    ei.set(ret, "outMappingModel", temp);
                    match(input,EQ,FOLLOW_EQ_in_methodCall931); 

                    }


                    }


                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:77: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:77: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:78: 
                    {
                    }



                    }
                    break;

            }

            pushFollow(FOLLOW_identifier_in_methodCall947);
            temp=identifier();
            _fsp--;

            ei.setRef(ret, "method", "Method", "name", temp, "#all", "never", null, false, null);
            match(input,LSQUARE,FOLLOW_LSQUARE_in_methodCall951); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:196: ( (temp= modelFlowExpression ( ( ( COMA ) temp= modelFlowExpression ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:197: (temp= modelFlowExpression ( ( ( COMA ) temp= modelFlowExpression ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:197: (temp= modelFlowExpression ( ( ( COMA ) temp= modelFlowExpression ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:198: temp= modelFlowExpression ( ( ( COMA ) temp= modelFlowExpression ) )*
            {
            pushFollow(FOLLOW_modelFlowExpression_in_methodCall957);
            temp=modelFlowExpression();
            _fsp--;

            ei.set(ret, "inMappingModel", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:262: ( ( ( COMA ) temp= modelFlowExpression ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==COMA) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:263: ( ( COMA ) temp= modelFlowExpression )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:263: ( ( COMA ) temp= modelFlowExpression )
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:264: ( COMA ) temp= modelFlowExpression
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:264: ( COMA )
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:265: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_methodCall964); 

            	    }

            	    pushFollow(FOLLOW_modelFlowExpression_in_methodCall969);
            	    temp=modelFlowExpression();
            	    _fsp--;

            	    ei.set(ret, "inMappingModel", temp);

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            match(input,RSQUARE,FOLLOW_RSQUARE_in_methodCall978); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:348: ( ( LPAREN ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )? RPAREN ) | () )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LPAREN) ) {
                alt17=1;
            }
            else if ( (LA17_0==NAME||LA17_0==RCURLY||(LA17_0>=COMA && LA17_0<=RSQUARE)) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("162:348: ( ( LPAREN ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )? RPAREN ) | () )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:349: ( LPAREN ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )? RPAREN )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:349: ( LPAREN ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )? RPAREN )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:350: LPAREN ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_methodCall982); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:357: ( (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==NAME) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:358: (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:358: (temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:359: temp= modelRefExp ( ( ( COMA ) temp= modelRefExp ) )*
                            {
                            pushFollow(FOLLOW_modelRefExp_in_methodCall988);
                            temp=modelRefExp();
                            _fsp--;

                            ei.set(ret, "arguments", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:410: ( ( ( COMA ) temp= modelRefExp ) )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==COMA) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:411: ( ( COMA ) temp= modelRefExp )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:411: ( ( COMA ) temp= modelRefExp )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:412: ( COMA ) temp= modelRefExp
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:412: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:413: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_methodCall995); 

                            	    }

                            	    pushFollow(FOLLOW_modelRefExp_in_methodCall1000);
                            	    temp=modelRefExp();
                            	    _fsp--;

                            	    ei.set(ret, "arguments", temp);

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop15;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_methodCall1010); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:488: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:488: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:162:489: 
                    {
                    }



                    }
                    break;

            }


            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end methodCall


    // $ANTLR start modelRefExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:172:1: modelRefExp returns [Object ret2] : (temp= identifier ) ;
    public final Object modelRefExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ModelRefExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:173:2: ( (temp= identifier ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:173:4: (temp= identifier )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:173:4: (temp= identifier )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:173:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_modelRefExp1054);
            temp=identifier();
            _fsp--;

            ei.setRef(ret, "referredModel", "Model", "name", temp, null, "never", null, false, null);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end modelRefExp


    // $ANTLR start mappingModelRefExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:183:1: mappingModelRefExp returns [Object ret2] : (temp= identifier ) ;
    public final Object mappingModelRefExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MappingModelRefExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:184:2: ( (temp= identifier ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:184:4: (temp= identifier )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:184:4: (temp= identifier )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:184:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_mappingModelRefExp1090);
            temp=identifier();
            _fsp--;

            ei.setRef(ret, "referredMappingModel", "MappingModel", "name", temp, null, "never", null, false, null);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end mappingModelRefExp


    // $ANTLR start mElement
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:194:1: mElement returns [Object ret2] : ( (ret= matcher | ret= method ) ) ;
    public final Object mElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:195:2: ( ( (ret= matcher | ret= method ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:195:4: ( (ret= matcher | ret= method ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:195:4: ( (ret= matcher | ret= method ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:195:5: (ret= matcher | ret= method )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:195:5: (ret= matcher | ret= method )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==42) ) {
                alt18=1;
            }
            else if ( (LA18_0==45||(LA18_0>=49 && LA18_0<=52)) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("195:5: (ret= matcher | ret= method )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:195:6: ret= matcher
                    {
                    pushFollow(FOLLOW_matcher_in_mElement1127);
                    ret=matcher();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:195:19: ret= method
                    {
                    pushFollow(FOLLOW_method_in_mElement1132);
                    ret=method();
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
    // $ANTLR end mElement


    // $ANTLR start method
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:203:1: method returns [Object ret2] : ( (ret= createEqual | ret= simEqual | ret= aggrEqual | ret= selEqual | ret= externalMethod ) ) ;
    public final Object method() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:204:2: ( ( (ret= createEqual | ret= simEqual | ret= aggrEqual | ret= selEqual | ret= externalMethod ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:204:4: ( (ret= createEqual | ret= simEqual | ret= aggrEqual | ret= selEqual | ret= externalMethod ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:204:4: ( (ret= createEqual | ret= simEqual | ret= aggrEqual | ret= selEqual | ret= externalMethod ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:204:5: (ret= createEqual | ret= simEqual | ret= aggrEqual | ret= selEqual | ret= externalMethod )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:204:5: (ret= createEqual | ret= simEqual | ret= aggrEqual | ret= selEqual | ret= externalMethod )
            int alt19=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt19=1;
                }
                break;
            case 49:
                {
                alt19=2;
                }
                break;
            case 50:
                {
                alt19=3;
                }
                break;
            case 51:
                {
                alt19=4;
                }
                break;
            case 52:
                {
                alt19=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("204:5: (ret= createEqual | ret= simEqual | ret= aggrEqual | ret= selEqual | ret= externalMethod )", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:204:6: ret= createEqual
                    {
                    pushFollow(FOLLOW_createEqual_in_method1168);
                    ret=createEqual();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:204:23: ret= simEqual
                    {
                    pushFollow(FOLLOW_simEqual_in_method1173);
                    ret=simEqual();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:204:37: ret= aggrEqual
                    {
                    pushFollow(FOLLOW_aggrEqual_in_method1178);
                    ret=aggrEqual();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:204:52: ret= selEqual
                    {
                    pushFollow(FOLLOW_selEqual_in_method1183);
                    ret=selEqual();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:204:66: ret= externalMethod
                    {
                    pushFollow(FOLLOW_externalMethod_in_method1188);
                    ret=externalMethod();
                    _fsp--;


                    }
                    break;

            }


            }


                        ei.addToContext(ret, true);
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
    // $ANTLR end method


    // $ANTLR start createEqual
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:212:1: createEqual returns [Object ret2] : ( 'create' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) ) RCURLY ) ;
    public final Object createEqual() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CreateEqual", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:2: ( ( 'create' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) ) RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:4: ( 'create' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) ) RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:4: ( 'create' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) ) RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:5: 'create' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) ) RCURLY
            {
            match(input,45,FOLLOW_45_in_createEqual1221); 
            pushFollow(FOLLOW_identifier_in_createEqual1225);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_createEqual1229); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:66: ( (temp= model ( ( ( COMA ) temp= model ) )* ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NAME) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:67: (temp= model ( ( ( COMA ) temp= model ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:67: (temp= model ( ( ( COMA ) temp= model ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:68: temp= model ( ( ( COMA ) temp= model ) )*
                    {
                    pushFollow(FOLLOW_model_in_createEqual1235);
                    temp=model();
                    _fsp--;

                    ei.set(ret, "arguments", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:113: ( ( ( COMA ) temp= model ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==COMA) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:114: ( ( COMA ) temp= model )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:114: ( ( COMA ) temp= model )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:115: ( COMA ) temp= model
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:115: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:116: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_createEqual1242); 

                    	    }

                    	    pushFollow(FOLLOW_model_in_createEqual1247);
                    	    temp=model();
                    	    _fsp--;

                    	    ei.set(ret, "arguments", temp);

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

            match(input,RPAREN,FOLLOW_RPAREN_in_createEqual1257); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:180: ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==46) ) {
                alt24=1;
            }
            else if ( (LA24_0==LCURLY||LA24_0==47) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("213:180: ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:181: ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:181: ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:182: 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY
                    {
                    match(input,46,FOLLOW_46_in_createEqual1261); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_createEqual1263); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:204: ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:205: ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:205: ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:206: ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:206: ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==LPAREN) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:207: (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:207: (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:208: temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )*
                            {
                            pushFollow(FOLLOW_aTLLibraryRef_in_createEqual1271);
                            temp=aTLLibraryRef();
                            _fsp--;

                            ei.set(ret, "ATLLibraries", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:264: ( ( ( COMA ) temp= aTLLibraryRef ) )*
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( (LA22_0==COMA) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:265: ( ( COMA ) temp= aTLLibraryRef )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:265: ( ( COMA ) temp= aTLLibraryRef )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:266: ( COMA ) temp= aTLLibraryRef
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:266: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:267: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_createEqual1278); 

                            	    }

                            	    pushFollow(FOLLOW_aTLLibraryRef_in_createEqual1283);
                            	    temp=aTLLibraryRef();
                            	    _fsp--;

                            	    ei.set(ret, "ATLLibraries", temp);

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

                    match(input,RCURLY,FOLLOW_RCURLY_in_createEqual1295); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:349: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:349: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:350: 
                    {
                    }



                    }
                    break;

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:356: ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==47) ) {
                alt27=1;
            }
            else if ( (LA27_0==LCURLY) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("213:356: ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:357: ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:357: ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:358: 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY
                    {
                    match(input,47,FOLLOW_47_in_createEqual1309); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_createEqual1311); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:381: ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:382: ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:382: ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:383: ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:383: ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==LPAREN) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:384: (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:384: (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:385: temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )*
                            {
                            pushFollow(FOLLOW_javaLibraryRef_in_createEqual1319);
                            temp=javaLibraryRef();
                            _fsp--;

                            ei.set(ret, "javaLibraries", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:443: ( ( ( COMA ) temp= javaLibraryRef ) )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==COMA) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:444: ( ( COMA ) temp= javaLibraryRef )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:444: ( ( COMA ) temp= javaLibraryRef )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:445: ( COMA ) temp= javaLibraryRef
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:445: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:446: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_createEqual1326); 

                            	    }

                            	    pushFollow(FOLLOW_javaLibraryRef_in_createEqual1331);
                            	    temp=javaLibraryRef();
                            	    _fsp--;

                            	    ei.set(ret, "javaLibraries", temp);

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop25;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_createEqual1343); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:530: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:530: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:531: 
                    {
                    }



                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_createEqual1355); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:544: ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:545: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:545: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:546: temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            {
            pushFollow(FOLLOW_inPattern_in_createEqual1361);
            temp=inPattern();
            _fsp--;

            ei.set(ret, "inPattern", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:595: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==48) ) {
                alt30=1;
            }
            else if ( (LA30_0==RCURLY) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("213:595: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:596: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:596: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:597: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,48,FOLLOW_48_in_createEqual1367); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_createEqual1369); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:612: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:613: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:613: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:614: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:614: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==NAME) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:615: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:615: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:616: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_createEqual1377);
                            temp=ruleVariableDeclaration();
                            _fsp--;

                            ei.set(ret, "variables", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:679: ( (temp= ruleVariableDeclaration ) )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( (LA28_0==NAME) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:680: (temp= ruleVariableDeclaration )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:680: (temp= ruleVariableDeclaration )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:681: temp= ruleVariableDeclaration
                            	    {
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_createEqual1385);
                            	    temp=ruleVariableDeclaration();
                            	    _fsp--;

                            	    ei.set(ret, "variables", temp);

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

                    match(input,RCURLY,FOLLOW_RCURLY_in_createEqual1397); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:764: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:764: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:213:765: 
                    {
                    }



                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_createEqual1411); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end createEqual


    // $ANTLR start simEqual
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:223:1: simEqual returns [Object ret2] : ( 'sim' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) ) RCURLY ) ;
    public final Object simEqual() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SimEqual", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:2: ( ( 'sim' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) ) RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:4: ( 'sim' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) ) RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:4: ( 'sim' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) ) RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:5: 'sim' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) ) RCURLY
            {
            match(input,49,FOLLOW_49_in_simEqual1443); 
            pushFollow(FOLLOW_identifier_in_simEqual1447);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_simEqual1451); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:63: ( (temp= model ( ( ( COMA ) temp= model ) )* ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==NAME) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:64: (temp= model ( ( ( COMA ) temp= model ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:64: (temp= model ( ( ( COMA ) temp= model ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:65: temp= model ( ( ( COMA ) temp= model ) )*
                    {
                    pushFollow(FOLLOW_model_in_simEqual1457);
                    temp=model();
                    _fsp--;

                    ei.set(ret, "arguments", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:110: ( ( ( COMA ) temp= model ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==COMA) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:111: ( ( COMA ) temp= model )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:111: ( ( COMA ) temp= model )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:112: ( COMA ) temp= model
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:112: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:113: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_simEqual1464); 

                    	    }

                    	    pushFollow(FOLLOW_model_in_simEqual1469);
                    	    temp=model();
                    	    _fsp--;

                    	    ei.set(ret, "arguments", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_simEqual1479); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:177: ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==46) ) {
                alt35=1;
            }
            else if ( (LA35_0==LCURLY||LA35_0==47) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("224:177: ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:178: ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:178: ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:179: 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY
                    {
                    match(input,46,FOLLOW_46_in_simEqual1483); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_simEqual1485); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:201: ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:202: ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:202: ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:203: ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:203: ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==LPAREN) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:204: (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:204: (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:205: temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )*
                            {
                            pushFollow(FOLLOW_aTLLibraryRef_in_simEqual1493);
                            temp=aTLLibraryRef();
                            _fsp--;

                            ei.set(ret, "ATLLibraries", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:261: ( ( ( COMA ) temp= aTLLibraryRef ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==COMA) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:262: ( ( COMA ) temp= aTLLibraryRef )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:262: ( ( COMA ) temp= aTLLibraryRef )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:263: ( COMA ) temp= aTLLibraryRef
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:263: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:264: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_simEqual1500); 

                            	    }

                            	    pushFollow(FOLLOW_aTLLibraryRef_in_simEqual1505);
                            	    temp=aTLLibraryRef();
                            	    _fsp--;

                            	    ei.set(ret, "ATLLibraries", temp);

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

                    match(input,RCURLY,FOLLOW_RCURLY_in_simEqual1517); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:346: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:346: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:347: 
                    {
                    }



                    }
                    break;

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:353: ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==47) ) {
                alt38=1;
            }
            else if ( (LA38_0==LCURLY) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("224:353: ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:354: ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:354: ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:355: 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY
                    {
                    match(input,47,FOLLOW_47_in_simEqual1531); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_simEqual1533); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:378: ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:379: ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:379: ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:380: ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:380: ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==LPAREN) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:381: (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:381: (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:382: temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )*
                            {
                            pushFollow(FOLLOW_javaLibraryRef_in_simEqual1541);
                            temp=javaLibraryRef();
                            _fsp--;

                            ei.set(ret, "javaLibraries", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:440: ( ( ( COMA ) temp= javaLibraryRef ) )*
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==COMA) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:441: ( ( COMA ) temp= javaLibraryRef )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:441: ( ( COMA ) temp= javaLibraryRef )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:442: ( COMA ) temp= javaLibraryRef
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:442: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:443: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_simEqual1548); 

                            	    }

                            	    pushFollow(FOLLOW_javaLibraryRef_in_simEqual1553);
                            	    temp=javaLibraryRef();
                            	    _fsp--;

                            	    ei.set(ret, "javaLibraries", temp);

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

                    match(input,RCURLY,FOLLOW_RCURLY_in_simEqual1565); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:527: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:527: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:528: 
                    {
                    }



                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_simEqual1577); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:541: ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:542: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:542: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:543: temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim
            {
            pushFollow(FOLLOW_inPattern_in_simEqual1583);
            temp=inPattern();
            _fsp--;

            ei.set(ret, "inPattern", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:592: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==48) ) {
                alt41=1;
            }
            else if ( (LA41_0==58) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("224:592: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:593: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:593: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:594: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,48,FOLLOW_48_in_simEqual1589); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_simEqual1591); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:609: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:610: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:610: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:611: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:611: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==NAME) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:612: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:612: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:613: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_simEqual1599);
                            temp=ruleVariableDeclaration();
                            _fsp--;

                            ei.set(ret, "variables", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:676: ( (temp= ruleVariableDeclaration ) )*
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);

                                if ( (LA39_0==NAME) ) {
                                    alt39=1;
                                }


                                switch (alt39) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:677: (temp= ruleVariableDeclaration )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:677: (temp= ruleVariableDeclaration )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:678: temp= ruleVariableDeclaration
                            	    {
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_simEqual1607);
                            	    temp=ruleVariableDeclaration();
                            	    _fsp--;

                            	    ei.set(ret, "variables", temp);

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop39;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_simEqual1619); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:761: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:761: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:224:762: 
                    {
                    }



                    }
                    break;

            }

            pushFollow(FOLLOW_sim_in_simEqual1633);
            temp=sim();
            _fsp--;

            ei.set(ret, "sim", temp);

            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_simEqual1639); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end simEqual


    // $ANTLR start aggrEqual
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:234:1: aggrEqual returns [Object ret2] : ( 'aggr' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) ) RCURLY ) ;
    public final Object aggrEqual() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("AggrEqual", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:2: ( ( 'aggr' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) ) RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:4: ( 'aggr' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) ) RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:4: ( 'aggr' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) ) RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:5: 'aggr' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) ) RCURLY
            {
            match(input,50,FOLLOW_50_in_aggrEqual1671); 
            pushFollow(FOLLOW_identifier_in_aggrEqual1675);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_aggrEqual1679); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:64: ( (temp= model ( ( ( COMA ) temp= model ) )* ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==NAME) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:65: (temp= model ( ( ( COMA ) temp= model ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:65: (temp= model ( ( ( COMA ) temp= model ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:66: temp= model ( ( ( COMA ) temp= model ) )*
                    {
                    pushFollow(FOLLOW_model_in_aggrEqual1685);
                    temp=model();
                    _fsp--;

                    ei.set(ret, "arguments", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:111: ( ( ( COMA ) temp= model ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==COMA) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:112: ( ( COMA ) temp= model )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:112: ( ( COMA ) temp= model )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:113: ( COMA ) temp= model
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:113: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:114: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_aggrEqual1692); 

                    	    }

                    	    pushFollow(FOLLOW_model_in_aggrEqual1697);
                    	    temp=model();
                    	    _fsp--;

                    	    ei.set(ret, "arguments", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_aggrEqual1707); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:178: ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==46) ) {
                alt46=1;
            }
            else if ( (LA46_0==LCURLY||LA46_0==47) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("235:178: ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () )", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:179: ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:179: ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:180: 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY
                    {
                    match(input,46,FOLLOW_46_in_aggrEqual1711); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_aggrEqual1713); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:202: ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:203: ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:203: ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:204: ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:204: ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==LPAREN) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:205: (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:205: (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:206: temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )*
                            {
                            pushFollow(FOLLOW_aTLLibraryRef_in_aggrEqual1721);
                            temp=aTLLibraryRef();
                            _fsp--;

                            ei.set(ret, "ATLLibraries", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:262: ( ( ( COMA ) temp= aTLLibraryRef ) )*
                            loop44:
                            do {
                                int alt44=2;
                                int LA44_0 = input.LA(1);

                                if ( (LA44_0==COMA) ) {
                                    alt44=1;
                                }


                                switch (alt44) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:263: ( ( COMA ) temp= aTLLibraryRef )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:263: ( ( COMA ) temp= aTLLibraryRef )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:264: ( COMA ) temp= aTLLibraryRef
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:264: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:265: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_aggrEqual1728); 

                            	    }

                            	    pushFollow(FOLLOW_aTLLibraryRef_in_aggrEqual1733);
                            	    temp=aTLLibraryRef();
                            	    _fsp--;

                            	    ei.set(ret, "ATLLibraries", temp);

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop44;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_aggrEqual1745); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:347: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:347: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:348: 
                    {
                    }



                    }
                    break;

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:354: ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==47) ) {
                alt49=1;
            }
            else if ( (LA49_0==LCURLY) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("235:354: ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:355: ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:355: ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:356: 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY
                    {
                    match(input,47,FOLLOW_47_in_aggrEqual1759); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_aggrEqual1761); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:379: ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:380: ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:380: ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:381: ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:381: ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==LPAREN) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:382: (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:382: (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:383: temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )*
                            {
                            pushFollow(FOLLOW_javaLibraryRef_in_aggrEqual1769);
                            temp=javaLibraryRef();
                            _fsp--;

                            ei.set(ret, "javaLibraries", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:441: ( ( ( COMA ) temp= javaLibraryRef ) )*
                            loop47:
                            do {
                                int alt47=2;
                                int LA47_0 = input.LA(1);

                                if ( (LA47_0==COMA) ) {
                                    alt47=1;
                                }


                                switch (alt47) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:442: ( ( COMA ) temp= javaLibraryRef )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:442: ( ( COMA ) temp= javaLibraryRef )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:443: ( COMA ) temp= javaLibraryRef
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:443: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:444: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_aggrEqual1776); 

                            	    }

                            	    pushFollow(FOLLOW_javaLibraryRef_in_aggrEqual1781);
                            	    temp=javaLibraryRef();
                            	    _fsp--;

                            	    ei.set(ret, "javaLibraries", temp);

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop47;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_aggrEqual1793); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:528: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:528: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:529: 
                    {
                    }



                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_aggrEqual1805); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:542: ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:543: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:543: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:544: temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) temp= sim
            {
            pushFollow(FOLLOW_inPattern_in_aggrEqual1811);
            temp=inPattern();
            _fsp--;

            ei.set(ret, "inPattern", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:593: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==48) ) {
                alt52=1;
            }
            else if ( (LA52_0==58) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("235:593: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:594: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:594: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:595: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,48,FOLLOW_48_in_aggrEqual1817); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_aggrEqual1819); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:610: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:611: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:611: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:612: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:612: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==NAME) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:613: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:613: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:614: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_aggrEqual1827);
                            temp=ruleVariableDeclaration();
                            _fsp--;

                            ei.set(ret, "variables", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:677: ( (temp= ruleVariableDeclaration ) )*
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==NAME) ) {
                                    alt50=1;
                                }


                                switch (alt50) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:678: (temp= ruleVariableDeclaration )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:678: (temp= ruleVariableDeclaration )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:679: temp= ruleVariableDeclaration
                            	    {
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_aggrEqual1835);
                            	    temp=ruleVariableDeclaration();
                            	    _fsp--;

                            	    ei.set(ret, "variables", temp);

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop50;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_aggrEqual1847); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:762: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:762: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:235:763: 
                    {
                    }



                    }
                    break;

            }

            pushFollow(FOLLOW_sim_in_aggrEqual1861);
            temp=sim();
            _fsp--;

            ei.set(ret, "sim", temp);

            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_aggrEqual1867); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end aggrEqual


    // $ANTLR start selEqual
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:245:1: selEqual returns [Object ret2] : ( 'sel' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) ) RCURLY ) ;
    public final Object selEqual() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SelEqual", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:2: ( ( 'sel' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) ) RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:4: ( 'sel' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) ) RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:4: ( 'sel' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) ) RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:5: 'sel' temp= identifier LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) LCURLY ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) ) RCURLY
            {
            match(input,51,FOLLOW_51_in_selEqual1899); 
            pushFollow(FOLLOW_identifier_in_selEqual1903);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_selEqual1907); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:63: ( (temp= model ( ( ( COMA ) temp= model ) )* ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==NAME) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:64: (temp= model ( ( ( COMA ) temp= model ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:64: (temp= model ( ( ( COMA ) temp= model ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:65: temp= model ( ( ( COMA ) temp= model ) )*
                    {
                    pushFollow(FOLLOW_model_in_selEqual1913);
                    temp=model();
                    _fsp--;

                    ei.set(ret, "arguments", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:110: ( ( ( COMA ) temp= model ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==COMA) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:111: ( ( COMA ) temp= model )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:111: ( ( COMA ) temp= model )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:112: ( COMA ) temp= model
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:112: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:113: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_selEqual1920); 

                    	    }

                    	    pushFollow(FOLLOW_model_in_selEqual1925);
                    	    temp=model();
                    	    _fsp--;

                    	    ei.set(ret, "arguments", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_selEqual1935); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:177: ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==46) ) {
                alt57=1;
            }
            else if ( (LA57_0==LCURLY||LA57_0==47) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("246:177: ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () )", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:178: ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:178: ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:179: 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY
                    {
                    match(input,46,FOLLOW_46_in_selEqual1939); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_selEqual1941); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:201: ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:202: ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:202: ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:203: ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:203: ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==LPAREN) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:204: (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:204: (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:205: temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )*
                            {
                            pushFollow(FOLLOW_aTLLibraryRef_in_selEqual1949);
                            temp=aTLLibraryRef();
                            _fsp--;

                            ei.set(ret, "ATLLibraries", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:261: ( ( ( COMA ) temp= aTLLibraryRef ) )*
                            loop55:
                            do {
                                int alt55=2;
                                int LA55_0 = input.LA(1);

                                if ( (LA55_0==COMA) ) {
                                    alt55=1;
                                }


                                switch (alt55) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:262: ( ( COMA ) temp= aTLLibraryRef )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:262: ( ( COMA ) temp= aTLLibraryRef )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:263: ( COMA ) temp= aTLLibraryRef
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:263: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:264: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_selEqual1956); 

                            	    }

                            	    pushFollow(FOLLOW_aTLLibraryRef_in_selEqual1961);
                            	    temp=aTLLibraryRef();
                            	    _fsp--;

                            	    ei.set(ret, "ATLLibraries", temp);

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

                    match(input,RCURLY,FOLLOW_RCURLY_in_selEqual1973); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:346: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:346: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:347: 
                    {
                    }



                    }
                    break;

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:353: ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==47) ) {
                alt60=1;
            }
            else if ( (LA60_0==LCURLY) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("246:353: ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:354: ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:354: ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:355: 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY
                    {
                    match(input,47,FOLLOW_47_in_selEqual1987); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_selEqual1989); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:378: ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:379: ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:379: ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:380: ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:380: ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==LPAREN) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:381: (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:381: (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:382: temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )*
                            {
                            pushFollow(FOLLOW_javaLibraryRef_in_selEqual1997);
                            temp=javaLibraryRef();
                            _fsp--;

                            ei.set(ret, "javaLibraries", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:440: ( ( ( COMA ) temp= javaLibraryRef ) )*
                            loop58:
                            do {
                                int alt58=2;
                                int LA58_0 = input.LA(1);

                                if ( (LA58_0==COMA) ) {
                                    alt58=1;
                                }


                                switch (alt58) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:441: ( ( COMA ) temp= javaLibraryRef )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:441: ( ( COMA ) temp= javaLibraryRef )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:442: ( COMA ) temp= javaLibraryRef
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:442: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:443: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_selEqual2004); 

                            	    }

                            	    pushFollow(FOLLOW_javaLibraryRef_in_selEqual2009);
                            	    temp=javaLibraryRef();
                            	    _fsp--;

                            	    ei.set(ret, "javaLibraries", temp);

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop58;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RCURLY,FOLLOW_RCURLY_in_selEqual2021); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:527: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:527: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:528: 
                    {
                    }



                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_selEqual2033); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:541: ( (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:542: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:542: (temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:543: temp= inPattern ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            {
            pushFollow(FOLLOW_inPattern_in_selEqual2039);
            temp=inPattern();
            _fsp--;

            ei.set(ret, "inPattern", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:592: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==48) ) {
                alt63=1;
            }
            else if ( (LA63_0==RCURLY) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("246:592: ( ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY ) | () )", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:593: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:593: ( 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:594: 'using' LCURLY ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) ) RCURLY
                    {
                    match(input,48,FOLLOW_48_in_selEqual2045); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_selEqual2047); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:609: ( ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:610: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:610: ( ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:611: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:611: ( (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==NAME) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:612: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:612: (temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:613: temp= ruleVariableDeclaration ( (temp= ruleVariableDeclaration ) )*
                            {
                            pushFollow(FOLLOW_ruleVariableDeclaration_in_selEqual2055);
                            temp=ruleVariableDeclaration();
                            _fsp--;

                            ei.set(ret, "variables", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:676: ( (temp= ruleVariableDeclaration ) )*
                            loop61:
                            do {
                                int alt61=2;
                                int LA61_0 = input.LA(1);

                                if ( (LA61_0==NAME) ) {
                                    alt61=1;
                                }


                                switch (alt61) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:677: (temp= ruleVariableDeclaration )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:677: (temp= ruleVariableDeclaration )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:678: temp= ruleVariableDeclaration
                            	    {
                            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_selEqual2063);
                            	    temp=ruleVariableDeclaration();
                            	    _fsp--;

                            	    ei.set(ret, "variables", temp);

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

                    match(input,RCURLY,FOLLOW_RCURLY_in_selEqual2075); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:761: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:761: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:246:762: 
                    {
                    }



                    }
                    break;

            }


            }


            }

            match(input,RCURLY,FOLLOW_RCURLY_in_selEqual2089); 

            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end selEqual


    // $ANTLR start externalMethod
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:256:1: externalMethod returns [Object ret2] : ( 'uses' temp= identifier LSQUARE ( (temp= mappingModel ( ( ( COMA ) temp= mappingModel ) )* ) ) RSQUARE LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ) ;
    public final Object externalMethod() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ExternalMethod", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:2: ( ( 'uses' temp= identifier LSQUARE ( (temp= mappingModel ( ( ( COMA ) temp= mappingModel ) )* ) ) RSQUARE LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:4: ( 'uses' temp= identifier LSQUARE ( (temp= mappingModel ( ( ( COMA ) temp= mappingModel ) )* ) ) RSQUARE LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:4: ( 'uses' temp= identifier LSQUARE ( (temp= mappingModel ( ( ( COMA ) temp= mappingModel ) )* ) ) RSQUARE LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:5: 'uses' temp= identifier LSQUARE ( (temp= mappingModel ( ( ( COMA ) temp= mappingModel ) )* ) ) RSQUARE LPAREN ( (temp= model ( ( ( COMA ) temp= model ) )* ) )? RPAREN ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () ) ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            {
            match(input,52,FOLLOW_52_in_externalMethod2121); 
            pushFollow(FOLLOW_identifier_in_externalMethod2125);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LSQUARE,FOLLOW_LSQUARE_in_externalMethod2129); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:65: ( (temp= mappingModel ( ( ( COMA ) temp= mappingModel ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:66: (temp= mappingModel ( ( ( COMA ) temp= mappingModel ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:66: (temp= mappingModel ( ( ( COMA ) temp= mappingModel ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:67: temp= mappingModel ( ( ( COMA ) temp= mappingModel ) )*
            {
            pushFollow(FOLLOW_mappingModel_in_externalMethod2135);
            temp=mappingModel();
            _fsp--;

            ei.set(ret, "inMappingModel", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:124: ( ( ( COMA ) temp= mappingModel ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==COMA) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:125: ( ( COMA ) temp= mappingModel )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:125: ( ( COMA ) temp= mappingModel )
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:126: ( COMA ) temp= mappingModel
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:126: ( COMA )
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:127: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_externalMethod2142); 

            	    }

            	    pushFollow(FOLLOW_mappingModel_in_externalMethod2147);
            	    temp=mappingModel();
            	    _fsp--;

            	    ei.set(ret, "inMappingModel", temp);

            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            }


            }

            match(input,RSQUARE,FOLLOW_RSQUARE_in_externalMethod2156); 
            match(input,LPAREN,FOLLOW_LPAREN_in_externalMethod2158); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:210: ( (temp= model ( ( ( COMA ) temp= model ) )* ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==NAME) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:211: (temp= model ( ( ( COMA ) temp= model ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:211: (temp= model ( ( ( COMA ) temp= model ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:212: temp= model ( ( ( COMA ) temp= model ) )*
                    {
                    pushFollow(FOLLOW_model_in_externalMethod2164);
                    temp=model();
                    _fsp--;

                    ei.set(ret, "arguments", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:257: ( ( ( COMA ) temp= model ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==COMA) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:258: ( ( COMA ) temp= model )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:258: ( ( COMA ) temp= model )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:259: ( COMA ) temp= model
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:259: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:260: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_externalMethod2171); 

                    	    }

                    	    pushFollow(FOLLOW_model_in_externalMethod2176);
                    	    temp=model();
                    	    _fsp--;

                    	    ei.set(ret, "arguments", temp);

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

            match(input,RPAREN,FOLLOW_RPAREN_in_externalMethod2186); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:324: ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==46) ) {
                alt69=1;
            }
            else if ( (LA69_0==EOF||LA69_0==RCURLY||(LA69_0>=43 && LA69_0<=45)||LA69_0==47||(LA69_0>=49 && LA69_0<=52)) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("257:324: ( ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY ) | () )", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:325: ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:325: ( 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:326: 'ATLLibraries' LCURLY ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) ) RCURLY
                    {
                    match(input,46,FOLLOW_46_in_externalMethod2190); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_externalMethod2192); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:348: ( ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:349: ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:349: ( ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:350: ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:350: ( (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==LPAREN) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:351: (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:351: (temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:352: temp= aTLLibraryRef ( ( ( COMA ) temp= aTLLibraryRef ) )*
                            {
                            pushFollow(FOLLOW_aTLLibraryRef_in_externalMethod2200);
                            temp=aTLLibraryRef();
                            _fsp--;

                            ei.set(ret, "ATLLibraries", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:408: ( ( ( COMA ) temp= aTLLibraryRef ) )*
                            loop67:
                            do {
                                int alt67=2;
                                int LA67_0 = input.LA(1);

                                if ( (LA67_0==COMA) ) {
                                    alt67=1;
                                }


                                switch (alt67) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:409: ( ( COMA ) temp= aTLLibraryRef )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:409: ( ( COMA ) temp= aTLLibraryRef )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:410: ( COMA ) temp= aTLLibraryRef
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:410: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:411: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_externalMethod2207); 

                            	    }

                            	    pushFollow(FOLLOW_aTLLibraryRef_in_externalMethod2212);
                            	    temp=aTLLibraryRef();
                            	    _fsp--;

                            	    ei.set(ret, "ATLLibraries", temp);

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

                    match(input,RCURLY,FOLLOW_RCURLY_in_externalMethod2224); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:493: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:493: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:494: 
                    {
                    }



                    }
                    break;

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:500: ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==47) ) {
                alt72=1;
            }
            else if ( (LA72_0==EOF||LA72_0==RCURLY||(LA72_0>=43 && LA72_0<=45)||(LA72_0>=49 && LA72_0<=52)) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("257:500: ( ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY ) | () )", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:501: ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:501: ( 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:502: 'JavaLibraries' LCURLY ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) ) RCURLY
                    {
                    match(input,47,FOLLOW_47_in_externalMethod2238); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_externalMethod2240); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:525: ( ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:526: ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:526: ( ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:527: ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:527: ( (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==LPAREN) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:528: (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:528: (temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:529: temp= javaLibraryRef ( ( ( COMA ) temp= javaLibraryRef ) )*
                            {
                            pushFollow(FOLLOW_javaLibraryRef_in_externalMethod2248);
                            temp=javaLibraryRef();
                            _fsp--;

                            ei.set(ret, "javaLibraries", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:587: ( ( ( COMA ) temp= javaLibraryRef ) )*
                            loop70:
                            do {
                                int alt70=2;
                                int LA70_0 = input.LA(1);

                                if ( (LA70_0==COMA) ) {
                                    alt70=1;
                                }


                                switch (alt70) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:588: ( ( COMA ) temp= javaLibraryRef )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:588: ( ( COMA ) temp= javaLibraryRef )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:589: ( COMA ) temp= javaLibraryRef
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:589: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:590: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_externalMethod2255); 

                            	    }

                            	    pushFollow(FOLLOW_javaLibraryRef_in_externalMethod2260);
                            	    temp=javaLibraryRef();
                            	    _fsp--;

                            	    ei.set(ret, "javaLibraries", temp);

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

                    match(input,RCURLY,FOLLOW_RCURLY_in_externalMethod2272); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:674: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:674: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:257:675: 
                    {
                    }



                    }
                    break;

            }


            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end externalMethod


    // $ANTLR start inPattern
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:267:1: inPattern returns [Object ret2] : ( ( ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) ) ) | () ) ( ( 'when' ( (temp= oclExpression ) ) ) | () ) ) ;
    public final Object inPattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("InPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:2: ( ( ( ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) ) ) | () ) ( ( 'when' ( (temp= oclExpression ) ) ) | () ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:4: ( ( ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) ) ) | () ) ( ( 'when' ( (temp= oclExpression ) ) ) | () ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:4: ( ( ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) ) ) | () ) ( ( 'when' ( (temp= oclExpression ) ) ) | () ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:5: ( ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) ) ) | () ) ( ( 'when' ( (temp= oclExpression ) ) ) | () )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:5: ( ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) ) ) | () )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==53) ) {
                alt74=1;
            }
            else if ( (LA74_0==RCURLY||LA74_0==48||LA74_0==54||LA74_0==58) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("268:5: ( ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) ) ) | () )", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:6: ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:6: ( 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:7: 'from' ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) )
                    {
                    match(input,53,FOLLOW_53_in_inPattern2316); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:14: ( ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:15: ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:15: ( ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:16: ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:16: ( (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:17: (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:17: (temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:18: temp= inPatternElement ( ( ( COMA ) temp= inPatternElement ) )*
                    {
                    pushFollow(FOLLOW_inPatternElement_in_inPattern2324);
                    temp=inPatternElement();
                    _fsp--;

                    ei.set(ret, "elements", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:73: ( ( ( COMA ) temp= inPatternElement ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==COMA) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:74: ( ( COMA ) temp= inPatternElement )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:74: ( ( COMA ) temp= inPatternElement )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:75: ( COMA ) temp= inPatternElement
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:75: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:76: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_inPattern2331); 

                    	    }

                    	    pushFollow(FOLLOW_inPatternElement_in_inPattern2336);
                    	    temp=inPatternElement();
                    	    _fsp--;

                    	    ei.set(ret, "elements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);


                    }


                    }


                    }


                    }


                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:149: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:149: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:150: 
                    {
                    }



                    }
                    break;

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:156: ( ( 'when' ( (temp= oclExpression ) ) ) | () )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==54) ) {
                alt75=1;
            }
            else if ( (LA75_0==RCURLY||LA75_0==48||LA75_0==58) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("268:156: ( ( 'when' ( (temp= oclExpression ) ) ) | () )", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:157: ( 'when' ( (temp= oclExpression ) ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:157: ( 'when' ( (temp= oclExpression ) ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:158: 'when' ( (temp= oclExpression ) )
                    {
                    match(input,54,FOLLOW_54_in_inPattern2359); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:165: ( (temp= oclExpression ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:166: (temp= oclExpression )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:166: (temp= oclExpression )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:167: temp= oclExpression
                    {
                    pushFollow(FOLLOW_oclExpression_in_inPattern2365);
                    temp=oclExpression();
                    _fsp--;

                    ei.set(ret, "filter", temp);

                    }


                    }


                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:224: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:224: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:268:225: 
                    {
                    }



                    }
                    break;

            }


            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end inPattern


    // $ANTLR start equalInPattern
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:278:1: equalInPattern returns [Object ret2] : ( 'leftType' COLON temp= equalMetaElement 'rightType' COLON temp= equalMetaElement ) ;
    public final Object equalInPattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("EqualInPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:279:2: ( ( 'leftType' COLON temp= equalMetaElement 'rightType' COLON temp= equalMetaElement ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:279:4: ( 'leftType' COLON temp= equalMetaElement 'rightType' COLON temp= equalMetaElement )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:279:4: ( 'leftType' COLON temp= equalMetaElement 'rightType' COLON temp= equalMetaElement )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:279:5: 'leftType' COLON temp= equalMetaElement 'rightType' COLON temp= equalMetaElement
            {
            match(input,55,FOLLOW_55_in_equalInPattern2411); 
            match(input,COLON,FOLLOW_COLON_in_equalInPattern2413); 
            pushFollow(FOLLOW_equalMetaElement_in_equalInPattern2417);
            temp=equalMetaElement();
            _fsp--;

            ei.set(ret, "leftElement", temp);
            match(input,56,FOLLOW_56_in_equalInPattern2421); 
            match(input,COLON,FOLLOW_COLON_in_equalInPattern2423); 
            pushFollow(FOLLOW_equalMetaElement_in_equalInPattern2427);
            temp=equalMetaElement();
            _fsp--;

            ei.set(ret, "rightElement", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end equalInPattern


    // $ANTLR start inPatternElement
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:289:1: inPatternElement returns [Object ret2] : (ret= simpleInPatternElement ) ;
    public final Object inPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:290:2: ( (ret= simpleInPatternElement ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:290:4: (ret= simpleInPatternElement )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:290:4: (ret= simpleInPatternElement )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:290:5: ret= simpleInPatternElement
            {
            pushFollow(FOLLOW_simpleInPatternElement_in_inPatternElement2463);
            ret=simpleInPatternElement();
            _fsp--;


            }


                        ei.addToContext(ret, true);
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
    // $ANTLR end inPatternElement


    // $ANTLR start simpleInPatternElement
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:298:1: simpleInPatternElement returns [Object ret2] : (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) ) ;
    public final Object simpleInPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SimpleInPatternElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:2: ( (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:4: (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:4: (temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:5: temp= identifier COLON temp= oclType ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () )
            {
            pushFollow(FOLLOW_identifier_in_simpleInPatternElement2497);
            temp=identifier();
            _fsp--;

            ei.set(ret, "varName", temp);
            match(input,COLON,FOLLOW_COLON_in_simpleInPatternElement2501); 
            pushFollow(FOLLOW_oclType_in_simpleInPatternElement2505);
            temp=oclType();
            _fsp--;

            ei.set(ret, "type", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:101: ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==57) ) {
                alt78=1;
            }
            else if ( (LA78_0==RCURLY||LA78_0==COMA||LA78_0==48||LA78_0==54||LA78_0==58) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("299:101: ( ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? ) | () )", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:102: ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:102: ( 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:103: 'in' ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )?
                    {
                    match(input,57,FOLLOW_57_in_simpleInPatternElement2511); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:108: ( (temp= identifier ( ( ( COMA ) temp= identifier ) )* ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==NAME) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:109: (temp= identifier ( ( ( COMA ) temp= identifier ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:109: (temp= identifier ( ( ( COMA ) temp= identifier ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:110: temp= identifier ( ( ( COMA ) temp= identifier ) )*
                            {
                            pushFollow(FOLLOW_identifier_in_simpleInPatternElement2517);
                            temp=identifier();
                            _fsp--;

                            ei.setRef(ret, "models", "Model", "name", temp, "#all", "never", null, false, null);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:213: ( ( ( COMA ) temp= identifier ) )*
                            loop76:
                            do {
                                int alt76=2;
                                int LA76_0 = input.LA(1);

                                if ( (LA76_0==COMA) ) {
                                    int LA76_1 = input.LA(2);

                                    if ( (LA76_1==NAME) ) {
                                        int LA76_3 = input.LA(3);

                                        if ( (LA76_3==RCURLY||LA76_3==COMA||LA76_3==48||LA76_3==54||LA76_3==58) ) {
                                            alt76=1;
                                        }


                                    }


                                }


                                switch (alt76) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:214: ( ( COMA ) temp= identifier )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:214: ( ( COMA ) temp= identifier )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:215: ( COMA ) temp= identifier
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:215: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:216: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_simpleInPatternElement2524); 

                            	    }

                            	    pushFollow(FOLLOW_identifier_in_simpleInPatternElement2529);
                            	    temp=identifier();
                            	    _fsp--;

                            	    ei.setRef(ret, "models", "Model", "name", temp, "#all", "never", null, false, null);

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
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:336: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:336: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:299:337: 
                    {
                    }



                    }
                    break;

            }


            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end simpleInPatternElement


    // $ANTLR start sim
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:309:1: sim returns [Object ret2] : ( 'is' temp= oclExpression ) ;
    public final Object sim() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Sim", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:310:2: ( ( 'is' temp= oclExpression ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:310:4: ( 'is' temp= oclExpression )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:310:4: ( 'is' temp= oclExpression )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:310:5: 'is' temp= oclExpression
            {
            match(input,58,FOLLOW_58_in_sim2579); 
            pushFollow(FOLLOW_oclExpression_in_sim2583);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "value", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end sim


    // $ANTLR start outPattern
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:320:1: outPattern returns [Object ret2] : ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) ) ;
    public final Object outPattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OutPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:2: ( ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:4: ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:4: ( 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:5: 'to' ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) )
            {
            match(input,59,FOLLOW_59_in_outPattern2617); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:10: ( ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:11: ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:11: ( ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:12: ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:12: ( (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:13: (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:13: (temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:14: temp= outPatternElement ( ( ( COMA ) temp= outPatternElement ) )*
            {
            pushFollow(FOLLOW_outPatternElement_in_outPattern2625);
            temp=outPatternElement();
            _fsp--;

            ei.set(ret, "elements", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:70: ( ( ( COMA ) temp= outPatternElement ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==COMA) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:71: ( ( COMA ) temp= outPatternElement )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:71: ( ( COMA ) temp= outPatternElement )
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:72: ( COMA ) temp= outPatternElement
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:72: ( COMA )
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:321:73: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_outPattern2632); 

            	    }

            	    pushFollow(FOLLOW_outPatternElement_in_outPattern2637);
            	    temp=outPatternElement();
            	    _fsp--;

            	    ei.set(ret, "elements", temp);

            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);


            }


            }


            }


            }


            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end outPattern


    // $ANTLR start outPatternElement
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:331:1: outPatternElement returns [Object ret2] : (ret= simpleOutPatternElement ) ;
    public final Object outPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:332:2: ( (ret= simpleOutPatternElement ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:332:4: (ret= simpleOutPatternElement )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:332:4: (ret= simpleOutPatternElement )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:332:5: ret= simpleOutPatternElement
            {
            pushFollow(FOLLOW_simpleOutPatternElement_in_outPatternElement2680);
            ret=simpleOutPatternElement();
            _fsp--;


            }


                        ei.addToContext(ret, true);
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
    // $ANTLR end outPatternElement


    // $ANTLR start simpleOutPatternElement
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:340:1: simpleOutPatternElement returns [Object ret2] : (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) ) ;
    public final Object simpleOutPatternElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SimpleOutPatternElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:2: ( (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:4: (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:4: (temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:5: temp= identifier COLON temp= oclType ( ( 'in' temp= identifier ) | () ) ( ( 'mapsTo' temp= identifier ) | () ) ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )
            {
            pushFollow(FOLLOW_identifier_in_simpleOutPatternElement2714);
            temp=identifier();
            _fsp--;

            ei.set(ret, "varName", temp);
            match(input,COLON,FOLLOW_COLON_in_simpleOutPatternElement2718); 
            pushFollow(FOLLOW_oclType_in_simpleOutPatternElement2722);
            temp=oclType();
            _fsp--;

            ei.set(ret, "type", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:101: ( ( 'in' temp= identifier ) | () )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==57) ) {
                alt80=1;
            }
            else if ( (LA80_0==EOF||LA80_0==COMA||LA80_0==LPAREN||LA80_0==60) ) {
                alt80=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("341:101: ( ( 'in' temp= identifier ) | () )", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:102: ( 'in' temp= identifier )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:102: ( 'in' temp= identifier )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:103: 'in' temp= identifier
                    {
                    match(input,57,FOLLOW_57_in_simpleOutPatternElement2728); 
                    pushFollow(FOLLOW_identifier_in_simpleOutPatternElement2732);
                    temp=identifier();
                    _fsp--;

                    ei.setRef(ret, "model", "Model", "name", temp, "#all", "never", null, false, null);

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:215: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:215: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:216: 
                    {
                    }



                    }
                    break;

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:222: ( ( 'mapsTo' temp= identifier ) | () )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==60) ) {
                alt81=1;
            }
            else if ( (LA81_0==EOF||LA81_0==COMA||LA81_0==LPAREN) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("341:222: ( ( 'mapsTo' temp= identifier ) | () )", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:223: ( 'mapsTo' temp= identifier )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:223: ( 'mapsTo' temp= identifier )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:224: 'mapsTo' temp= identifier
                    {
                    match(input,60,FOLLOW_60_in_simpleOutPatternElement2748); 
                    pushFollow(FOLLOW_identifier_in_simpleOutPatternElement2752);
                    temp=identifier();
                    _fsp--;

                    ei.setRef(ret, "sourceElement", "InPatternElement", "varName", temp, null, "never", null, false, null);

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:360: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:360: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:361: 
                    {
                    }



                    }
                    break;

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:367: ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==LPAREN) ) {
                alt84=1;
            }
            else if ( (LA84_0==EOF||LA84_0==COMA) ) {
                alt84=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("341:367: ( ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN ) | () )", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:368: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:368: ( LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:369: LPAREN ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) ) RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_simpleOutPatternElement2768); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:376: ( ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:377: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:377: ( ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )? )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:378: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:378: ( (temp= binding ( ( ( COMA ) temp= binding ) )* ) )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==NAME||(LA83_0>=42 && LA83_0<=105)) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:379: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:379: (temp= binding ( ( ( COMA ) temp= binding ) )* )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:380: temp= binding ( ( ( COMA ) temp= binding ) )*
                            {
                            pushFollow(FOLLOW_binding_in_simpleOutPatternElement2776);
                            temp=binding();
                            _fsp--;

                            ei.set(ret, "bindings", temp);
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:426: ( ( ( COMA ) temp= binding ) )*
                            loop82:
                            do {
                                int alt82=2;
                                int LA82_0 = input.LA(1);

                                if ( (LA82_0==COMA) ) {
                                    alt82=1;
                                }


                                switch (alt82) {
                            	case 1 :
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:427: ( ( COMA ) temp= binding )
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:427: ( ( COMA ) temp= binding )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:428: ( COMA ) temp= binding
                            	    {
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:428: ( COMA )
                            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:429: COMA
                            	    {
                            	    match(input,COMA,FOLLOW_COMA_in_simpleOutPatternElement2783); 

                            	    }

                            	    pushFollow(FOLLOW_binding_in_simpleOutPatternElement2788);
                            	    temp=binding();
                            	    _fsp--;

                            	    ei.set(ret, "bindings", temp);

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop82;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_simpleOutPatternElement2800); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:501: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:501: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:341:502: 
                    {
                    }



                    }
                    break;

            }


            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end simpleOutPatternElement


    // $ANTLR start binding
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:351:1: binding returns [Object ret2] : (temp= identifierOrKeyword LARROW temp= oclExpression ) ;
    public final Object binding() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Binding", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:352:2: ( (temp= identifierOrKeyword LARROW temp= oclExpression ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:352:4: (temp= identifierOrKeyword LARROW temp= oclExpression )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:352:4: (temp= identifierOrKeyword LARROW temp= oclExpression )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:352:5: temp= identifierOrKeyword LARROW temp= oclExpression
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_binding2844);
            temp=identifierOrKeyword();
            _fsp--;

            ei.set(ret, "propertyName", temp);
            match(input,LARROW,FOLLOW_LARROW_in_binding2848); 
            pushFollow(FOLLOW_oclExpression_in_binding2852);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "value", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end binding


    // $ANTLR start ruleVariableDeclaration
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:362:1: ruleVariableDeclaration returns [Object ret2] : (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI ) ;
    public final Object ruleVariableDeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("RuleVariableDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:363:2: ( (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:363:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:363:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:363:5: temp= identifier COLON temp= oclType EQ temp= oclExpression SEMI
            {
            pushFollow(FOLLOW_identifier_in_ruleVariableDeclaration2888);
            temp=identifier();
            _fsp--;

            ei.set(ret, "varName", temp);
            match(input,COLON,FOLLOW_COLON_in_ruleVariableDeclaration2892); 
            pushFollow(FOLLOW_oclType_in_ruleVariableDeclaration2896);
            temp=oclType();
            _fsp--;

            ei.set(ret, "type", temp);
            match(input,EQ,FOLLOW_EQ_in_ruleVariableDeclaration2900); 
            pushFollow(FOLLOW_oclExpression_in_ruleVariableDeclaration2904);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "initExpression", temp);
            match(input,SEMI,FOLLOW_SEMI_in_ruleVariableDeclaration2908); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end ruleVariableDeclaration


    // $ANTLR start model
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:373:1: model returns [Object ret2] : ( (ret= inputModel | ret= mappingModel | ret= weavingModel ) ) ;
    public final Object model() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:374:2: ( ( (ret= inputModel | ret= mappingModel | ret= weavingModel ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:374:4: ( (ret= inputModel | ret= mappingModel | ret= weavingModel ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:374:4: ( (ret= inputModel | ret= mappingModel | ret= weavingModel ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:374:5: (ret= inputModel | ret= mappingModel | ret= weavingModel )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:374:5: (ret= inputModel | ret= mappingModel | ret= weavingModel )
            int alt85=3;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==NAME) ) {
                int LA85_1 = input.LA(2);

                if ( (LA85_1==COLON) ) {
                    switch ( input.LA(3) ) {
                    case 62:
                        {
                        alt85=3;
                        }
                        break;
                    case 61:
                        {
                        alt85=2;
                        }
                        break;
                    case NAME:
                        {
                        alt85=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("374:5: (ret= inputModel | ret= mappingModel | ret= weavingModel )", 85, 2, input);

                        throw nvae;
                    }

                }
                else if ( (LA85_1==NAME||LA85_1==RCURLY||LA85_1==COMA||LA85_1==RPAREN) ) {
                    alt85=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("374:5: (ret= inputModel | ret= mappingModel | ret= weavingModel )", 85, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("374:5: (ret= inputModel | ret= mappingModel | ret= weavingModel )", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:374:6: ret= inputModel
                    {
                    pushFollow(FOLLOW_inputModel_in_model2943);
                    ret=inputModel();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:374:22: ret= mappingModel
                    {
                    pushFollow(FOLLOW_mappingModel_in_model2948);
                    ret=mappingModel();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:374:40: ret= weavingModel
                    {
                    pushFollow(FOLLOW_weavingModel_in_model2953);
                    ret=weavingModel();
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
    // $ANTLR end model


    // $ANTLR start inputModel
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:382:1: inputModel returns [Object ret2] : (temp= identifier COLON temp= identifier ) ;
    public final Object inputModel() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("InputModel", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:383:2: ( (temp= identifier COLON temp= identifier ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:383:4: (temp= identifier COLON temp= identifier )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:383:4: (temp= identifier COLON temp= identifier )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:383:5: temp= identifier COLON temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_inputModel2988);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,COLON,FOLLOW_COLON_in_inputModel2992); 
            pushFollow(FOLLOW_identifier_in_inputModel2996);
            temp=identifier();
            _fsp--;

            ei.setRef(ret, "referenceModel", "ReferenceModel", "name", temp, "#all", "ifmissing", null, false, null);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end inputModel


    // $ANTLR start mappingModel
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:393:1: mappingModel returns [Object ret2] : (temp= identifier ( ( COLON 'EqualModel' LPAREN temp= inputModel COMA temp= inputModel RPAREN ) | () ) ) ;
    public final Object mappingModel() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MappingModel", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:2: ( (temp= identifier ( ( COLON 'EqualModel' LPAREN temp= inputModel COMA temp= inputModel RPAREN ) | () ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:4: (temp= identifier ( ( COLON 'EqualModel' LPAREN temp= inputModel COMA temp= inputModel RPAREN ) | () ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:4: (temp= identifier ( ( COLON 'EqualModel' LPAREN temp= inputModel COMA temp= inputModel RPAREN ) | () ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:5: temp= identifier ( ( COLON 'EqualModel' LPAREN temp= inputModel COMA temp= inputModel RPAREN ) | () )
            {
            pushFollow(FOLLOW_identifier_in_mappingModel3032);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:50: ( ( COLON 'EqualModel' LPAREN temp= inputModel COMA temp= inputModel RPAREN ) | () )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==COLON) ) {
                alt86=1;
            }
            else if ( (LA86_0==NAME||LA86_0==RCURLY||LA86_0==EQ||(LA86_0>=COMA && LA86_0<=RSQUARE)||LA86_0==RPAREN) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("394:50: ( ( COLON 'EqualModel' LPAREN temp= inputModel COMA temp= inputModel RPAREN ) | () )", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:51: ( COLON 'EqualModel' LPAREN temp= inputModel COMA temp= inputModel RPAREN )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:51: ( COLON 'EqualModel' LPAREN temp= inputModel COMA temp= inputModel RPAREN )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:52: COLON 'EqualModel' LPAREN temp= inputModel COMA temp= inputModel RPAREN
                    {
                    match(input,COLON,FOLLOW_COLON_in_mappingModel3038); 
                    match(input,61,FOLLOW_61_in_mappingModel3040); 
                    match(input,LPAREN,FOLLOW_LPAREN_in_mappingModel3042); 
                    pushFollow(FOLLOW_inputModel_in_mappingModel3046);
                    temp=inputModel();
                    _fsp--;

                    ei.set(ret, "leftModel", temp);
                    match(input,COMA,FOLLOW_COMA_in_mappingModel3050); 
                    pushFollow(FOLLOW_inputModel_in_mappingModel3054);
                    temp=inputModel();
                    _fsp--;

                    ei.set(ret, "rightModel", temp);
                    match(input,RPAREN,FOLLOW_RPAREN_in_mappingModel3058); 

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:196: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:196: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:394:197: 
                    {
                    }



                    }
                    break;

            }


            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end mappingModel


    // $ANTLR start weavingModel
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:404:1: weavingModel returns [Object ret2] : (temp= identifier COLON 'WeavingModel' LPAREN temp= referenceModel RPAREN LPAREN ( (temp= inputModel ( ( ( COMA ) temp= inputModel ) )* ) )? RPAREN ) ;
    public final Object weavingModel() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("WeavingModel", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:2: ( (temp= identifier COLON 'WeavingModel' LPAREN temp= referenceModel RPAREN LPAREN ( (temp= inputModel ( ( ( COMA ) temp= inputModel ) )* ) )? RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:4: (temp= identifier COLON 'WeavingModel' LPAREN temp= referenceModel RPAREN LPAREN ( (temp= inputModel ( ( ( COMA ) temp= inputModel ) )* ) )? RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:4: (temp= identifier COLON 'WeavingModel' LPAREN temp= referenceModel RPAREN LPAREN ( (temp= inputModel ( ( ( COMA ) temp= inputModel ) )* ) )? RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:5: temp= identifier COLON 'WeavingModel' LPAREN temp= referenceModel RPAREN LPAREN ( (temp= inputModel ( ( ( COMA ) temp= inputModel ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifier_in_weavingModel3102);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,COLON,FOLLOW_COLON_in_weavingModel3106); 
            match(input,62,FOLLOW_62_in_weavingModel3108); 
            match(input,LPAREN,FOLLOW_LPAREN_in_weavingModel3110); 
            pushFollow(FOLLOW_referenceModel_in_weavingModel3114);
            temp=referenceModel();
            _fsp--;

            ei.set(ret, "referenceModel", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_weavingModel3118); 
            match(input,LPAREN,FOLLOW_LPAREN_in_weavingModel3120); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:151: ( (temp= inputModel ( ( ( COMA ) temp= inputModel ) )* ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==NAME) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:152: (temp= inputModel ( ( ( COMA ) temp= inputModel ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:152: (temp= inputModel ( ( ( COMA ) temp= inputModel ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:153: temp= inputModel ( ( ( COMA ) temp= inputModel ) )*
                    {
                    pushFollow(FOLLOW_inputModel_in_weavingModel3126);
                    temp=inputModel();
                    _fsp--;

                    ei.set(ret, "wovenModels", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:205: ( ( ( COMA ) temp= inputModel ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==COMA) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:206: ( ( COMA ) temp= inputModel )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:206: ( ( COMA ) temp= inputModel )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:207: ( COMA ) temp= inputModel
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:207: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:405:208: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_weavingModel3133); 

                    	    }

                    	    pushFollow(FOLLOW_inputModel_in_weavingModel3138);
                    	    temp=inputModel();
                    	    _fsp--;

                    	    ei.set(ret, "wovenModels", temp);

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

            match(input,RPAREN,FOLLOW_RPAREN_in_weavingModel3148); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end weavingModel


    // $ANTLR start referenceModel
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:415:1: referenceModel returns [Object ret2] : (temp= identifier ) ;
    public final Object referenceModel() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ReferenceModel", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:416:2: ( (temp= identifier ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:416:4: (temp= identifier )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:416:4: (temp= identifier )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:416:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_referenceModel3182);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end referenceModel


    // $ANTLR start metaElement
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:426:1: metaElement returns [Object ret2] : (temp= identifier EXCL temp= identifier ) ;
    public final Object metaElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MetaElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:427:2: ( (temp= identifier EXCL temp= identifier ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:427:4: (temp= identifier EXCL temp= identifier )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:427:4: (temp= identifier EXCL temp= identifier )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:427:5: temp= identifier EXCL temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_metaElement3218);
            temp=identifier();
            _fsp--;

            ei.setRef(ret, "referenceModel", "ReferenceModel", "name", temp, "#all", "ifmissing", null, false, null);
            match(input,EXCL,FOLLOW_EXCL_in_metaElement3222); 
            pushFollow(FOLLOW_identifier_in_metaElement3226);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end metaElement


    // $ANTLR start equalMetaElement
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:437:1: equalMetaElement returns [Object ret2] : (temp= identifier ) ;
    public final Object equalMetaElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("EqualMetaElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:438:2: ( (temp= identifier ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:438:4: (temp= identifier )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:438:4: (temp= identifier )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:438:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_equalMetaElement3262);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end equalMetaElement


    // $ANTLR start oclExpression
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:448:1: oclExpression returns [Object ret2] : (ret= priority_5 | ret= letExp ) ;
    public final Object oclExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:449:2: ( (ret= priority_5 | ret= letExp ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:449:4: (ret= priority_5 | ret= letExp )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:449:4: (ret= priority_5 | ret= letExp )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( ((LA89_0>=NAME && LA89_0<=FLOAT)||LA89_0==LPAREN||LA89_0==SHARP||LA89_0==MINUS||(LA89_0>=63 && LA89_0<=71)||LA89_0==75||(LA89_0>=77 && LA89_0<=80)||(LA89_0>=85 && LA89_0<=99)) ) {
                alt89=1;
            }
            else if ( (LA89_0==84) ) {
                alt89=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("449:4: (ret= priority_5 | ret= letExp )", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:449:5: ret= priority_5
                    {
                    pushFollow(FOLLOW_priority_5_in_oclExpression3298);
                    ret=priority_5();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:449:21: ret= letExp
                    {
                    pushFollow(FOLLOW_letExp_in_oclExpression3303);
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
    // $ANTLR end oclExpression


    // $ANTLR start thisModuleExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:456:1: thisModuleExp returns [Object ret2] : ( 'thisModule' ) ;
    public final Object thisModuleExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("ThisModuleExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:457:2: ( ( 'thisModule' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:457:4: ( 'thisModule' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:457:4: ( 'thisModule' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:457:5: 'thisModule'
            {
            match(input,63,FOLLOW_63_in_thisModuleExp3335); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end thisModuleExp


    // $ANTLR start thisNodeExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:467:1: thisNodeExp returns [Object ret2] : ( (ret= thisRightExp | ret= thisLeftExp ) ) ;
    public final Object thisNodeExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:468:2: ( ( (ret= thisRightExp | ret= thisLeftExp ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:468:4: ( (ret= thisRightExp | ret= thisLeftExp ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:468:4: ( (ret= thisRightExp | ret= thisLeftExp ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:468:5: (ret= thisRightExp | ret= thisLeftExp )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:468:5: (ret= thisRightExp | ret= thisLeftExp )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==64) ) {
                alt90=1;
            }
            else if ( (LA90_0==65) ) {
                alt90=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("468:5: (ret= thisRightExp | ret= thisLeftExp )", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:468:6: ret= thisRightExp
                    {
                    pushFollow(FOLLOW_thisRightExp_in_thisNodeExp3370);
                    ret=thisRightExp();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:468:24: ret= thisLeftExp
                    {
                    pushFollow(FOLLOW_thisLeftExp_in_thisNodeExp3375);
                    ret=thisLeftExp();
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
    // $ANTLR end thisNodeExp


    // $ANTLR start thisRightExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:476:1: thisRightExp returns [Object ret2] : ( 'thisRight' ) ;
    public final Object thisRightExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("ThisRightExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:477:2: ( ( 'thisRight' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:477:4: ( 'thisRight' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:477:4: ( 'thisRight' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:477:5: 'thisRight'
            {
            match(input,64,FOLLOW_64_in_thisRightExp3408); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end thisRightExp


    // $ANTLR start thisLeftExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:487:1: thisLeftExp returns [Object ret2] : ( 'thisLeft' ) ;
    public final Object thisLeftExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("ThisLeftExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:488:2: ( ( 'thisLeft' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:488:4: ( 'thisLeft' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:488:4: ( 'thisLeft' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:488:5: 'thisLeft'
            {
            match(input,65,FOLLOW_65_in_thisLeftExp3440); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end thisLeftExp


    // $ANTLR start thisEqualExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:498:1: thisEqualExp returns [Object ret2] : ( 'thisEqual' ) ;
    public final Object thisEqualExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("ThisEqualExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:499:2: ( ( 'thisEqual' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:499:4: ( 'thisEqual' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:499:4: ( 'thisEqual' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:499:5: 'thisEqual'
            {
            match(input,66,FOLLOW_66_in_thisEqualExp3472); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end thisEqualExp


    // $ANTLR start thisWeightExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:509:1: thisWeightExp returns [Object ret2] : ( 'thisWeight' ) ;
    public final Object thisWeightExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("ThisWeightExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:510:2: ( ( 'thisWeight' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:510:4: ( 'thisWeight' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:510:4: ( 'thisWeight' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:510:5: 'thisWeight'
            {
            match(input,67,FOLLOW_67_in_thisWeightExp3504); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end thisWeightExp


    // $ANTLR start thisSimExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:520:1: thisSimExp returns [Object ret2] : ( 'thisSim' ) ;
    public final Object thisSimExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("ThisSimExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:521:2: ( ( 'thisSim' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:521:4: ( 'thisSim' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:521:4: ( 'thisSim' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:521:5: 'thisSim'
            {
            match(input,68,FOLLOW_68_in_thisSimExp3536); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end thisSimExp


    // $ANTLR start thisInstancesExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:531:1: thisInstancesExp returns [Object ret2] : ( 'thisInstances' LPAREN temp= oclExpression RPAREN ) ;
    public final Object thisInstancesExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ThisInstancesExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:532:2: ( ( 'thisInstances' LPAREN temp= oclExpression RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:532:4: ( 'thisInstances' LPAREN temp= oclExpression RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:532:4: ( 'thisInstances' LPAREN temp= oclExpression RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:532:5: 'thisInstances' LPAREN temp= oclExpression RPAREN
            {
            match(input,69,FOLLOW_69_in_thisInstancesExp3568); 
            match(input,LPAREN,FOLLOW_LPAREN_in_thisInstancesExp3570); 
            pushFollow(FOLLOW_oclExpression_in_thisInstancesExp3574);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "instancesOp", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_thisInstancesExp3578); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end thisInstancesExp


    // $ANTLR start summationExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:542:1: summationExp returns [Object ret2] : ( 'Summation' LPAREN temp= oclExpression RPAREN ) ;
    public final Object summationExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SummationExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:543:2: ( ( 'Summation' LPAREN temp= oclExpression RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:543:4: ( 'Summation' LPAREN temp= oclExpression RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:543:4: ( 'Summation' LPAREN temp= oclExpression RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:543:5: 'Summation' LPAREN temp= oclExpression RPAREN
            {
            match(input,70,FOLLOW_70_in_summationExp3610); 
            match(input,LPAREN,FOLLOW_LPAREN_in_summationExp3612); 
            pushFollow(FOLLOW_oclExpression_in_summationExp3616);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "sumExpression", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_summationExp3620); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end summationExp


    // $ANTLR start thisEqualModelExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:553:1: thisEqualModelExp returns [Object ret2] : ( 'thisEqualModel' ) ;
    public final Object thisEqualModelExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("ThisEqualModelExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:554:2: ( ( 'thisEqualModel' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:554:4: ( 'thisEqualModel' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:554:4: ( 'thisEqualModel' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:554:5: 'thisEqualModel'
            {
            match(input,71,FOLLOW_71_in_thisEqualModelExp3652); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end thisEqualModelExp


    // $ANTLR start libraryRef
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:564:1: libraryRef returns [Object ret2] : ( (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef ) ) ;
    public final Object libraryRef() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:565:2: ( ( (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:565:4: ( (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:565:4: ( (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )
            int alt91=3;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==LPAREN) ) {
                int LA91_1 = input.LA(2);

                if ( (LA91_1==72) ) {
                    int LA91_2 = input.LA(3);

                    if ( (LA91_2==EQ) ) {
                        int LA91_3 = input.LA(4);

                        if ( (LA91_3==STRING) ) {
                            int LA91_4 = input.LA(5);

                            if ( (LA91_4==COMA) ) {
                                int LA91_5 = input.LA(6);

                                if ( (LA91_5==73) ) {
                                    int LA91_6 = input.LA(7);

                                    if ( (LA91_6==EQ) ) {
                                        int LA91_7 = input.LA(8);

                                        if ( (LA91_7==STRING) ) {
                                            int LA91_8 = input.LA(9);

                                            if ( (LA91_8==RPAREN) ) {
                                                alt91=1;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )", 91, 8, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )", 91, 7, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )", 91, 6, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )", 91, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )", 91, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )", 91, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )", 91, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )", 91, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("565:5: (ret= aTLLibraryRef | ret= javaLibraryRef | ret= aMLLibraryRef )", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:565:6: ret= aTLLibraryRef
                    {
                    pushFollow(FOLLOW_aTLLibraryRef_in_libraryRef3687);
                    ret=aTLLibraryRef();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:565:25: ret= javaLibraryRef
                    {
                    pushFollow(FOLLOW_javaLibraryRef_in_libraryRef3692);
                    ret=javaLibraryRef();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:565:45: ret= aMLLibraryRef
                    {
                    pushFollow(FOLLOW_aMLLibraryRef_in_libraryRef3697);
                    ret=aMLLibraryRef();
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
    // $ANTLR end libraryRef


    // $ANTLR start aTLLibraryRef
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:573:1: aTLLibraryRef returns [Object ret2] : ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN ) ;
    public final Object aTLLibraryRef() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("ATLLibraryRef", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:574:2: ( ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:574:4: ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:574:4: ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:574:5: LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_aTLLibraryRef3730); 
            match(input,72,FOLLOW_72_in_aTLLibraryRef3732); 
            match(input,EQ,FOLLOW_EQ_in_aTLLibraryRef3734); 
            pushFollow(FOLLOW_stringSymbol_in_aTLLibraryRef3738);
            temp=stringSymbol();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,COMA,FOLLOW_COMA_in_aTLLibraryRef3742); 
            match(input,73,FOLLOW_73_in_aTLLibraryRef3744); 
            match(input,EQ,FOLLOW_EQ_in_aTLLibraryRef3746); 
            pushFollow(FOLLOW_stringSymbol_in_aTLLibraryRef3750);
            temp=stringSymbol();
            _fsp--;

            ei.set(ret, "path", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_aTLLibraryRef3754); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end aTLLibraryRef


    // $ANTLR start javaLibraryRef
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:584:1: javaLibraryRef returns [Object ret2] : ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN ) ;
    public final Object javaLibraryRef() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("JavaLibraryRef", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:585:2: ( ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:585:4: ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:585:4: ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:585:5: LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_javaLibraryRef3786); 
            match(input,72,FOLLOW_72_in_javaLibraryRef3788); 
            match(input,EQ,FOLLOW_EQ_in_javaLibraryRef3790); 
            pushFollow(FOLLOW_stringSymbol_in_javaLibraryRef3794);
            temp=stringSymbol();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,COMA,FOLLOW_COMA_in_javaLibraryRef3798); 
            match(input,73,FOLLOW_73_in_javaLibraryRef3800); 
            match(input,EQ,FOLLOW_EQ_in_javaLibraryRef3802); 
            pushFollow(FOLLOW_stringSymbol_in_javaLibraryRef3806);
            temp=stringSymbol();
            _fsp--;

            ei.set(ret, "path", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_javaLibraryRef3810); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end javaLibraryRef


    // $ANTLR start aMLLibraryRef
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:595:1: aMLLibraryRef returns [Object ret2] : ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN ) ;
    public final Object aMLLibraryRef() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("AMLLibraryRef", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:596:2: ( ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:596:4: ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:596:4: ( LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:596:5: LPAREN 'name' EQ temp= stringSymbol COMA 'path' EQ temp= stringSymbol RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_aMLLibraryRef3842); 
            match(input,72,FOLLOW_72_in_aMLLibraryRef3844); 
            match(input,EQ,FOLLOW_EQ_in_aMLLibraryRef3846); 
            pushFollow(FOLLOW_stringSymbol_in_aMLLibraryRef3850);
            temp=stringSymbol();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,COMA,FOLLOW_COMA_in_aMLLibraryRef3854); 
            match(input,73,FOLLOW_73_in_aMLLibraryRef3856); 
            match(input,EQ,FOLLOW_EQ_in_aMLLibraryRef3858); 
            pushFollow(FOLLOW_stringSymbol_in_aMLLibraryRef3862);
            temp=stringSymbol();
            _fsp--;

            ei.set(ret, "path", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_aMLLibraryRef3866); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end aMLLibraryRef


    // $ANTLR start matcherRef
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:606:1: matcherRef returns [Object ret2] : ( 'imports' temp= identifier SEMI ) ;
    public final Object matcherRef() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MatcherRef", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:607:2: ( ( 'imports' temp= identifier SEMI ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:607:4: ( 'imports' temp= identifier SEMI )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:607:4: ( 'imports' temp= identifier SEMI )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:607:5: 'imports' temp= identifier SEMI
            {
            match(input,74,FOLLOW_74_in_matcherRef3898); 
            pushFollow(FOLLOW_identifier_in_matcherRef3902);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,SEMI,FOLLOW_SEMI_in_matcherRef3906); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end matcherRef


    // $ANTLR start variableExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:617:1: variableExp returns [Object ret2] : (temp= identifier ) ;
    public final Object variableExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:618:2: ( (temp= identifier ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:618:4: (temp= identifier )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:618:4: (temp= identifier )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:618:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_variableExp3940);
            temp=identifier();
            _fsp--;

            ei.setRef(ret, "referredVariable", "VariableDeclaration", "varName", temp, null, "never", null, false, null);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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


    // $ANTLR start superExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:628:1: superExp returns [Object ret2] : ( 'super' ) ;
    public final Object superExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("SuperExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:629:2: ( ( 'super' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:629:4: ( 'super' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:629:4: ( 'super' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:629:5: 'super'
            {
            match(input,75,FOLLOW_75_in_superExp3974); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end superExp


    // $ANTLR start iteratorExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:639:1: iteratorExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN ) ;
    public final Object iteratorExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IteratorExp", true, false) : null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:2: ( (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:4: (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:4: (temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:5: temp= identifier LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) PIPE ( (temp= oclExpression ) ) RPAREN
            {
            pushFollow(FOLLOW_identifier_in_iteratorExp4009);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_iteratorExp4013); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:57: ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:58: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:58: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:59: temp= iterator ( ( ( COMA ) temp= iterator ) )*
            {
            pushFollow(FOLLOW_iterator_in_iteratorExp4019);
            temp=iterator();
            _fsp--;

            ei.set(ret, "iterators", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:107: ( ( ( COMA ) temp= iterator ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==COMA) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:108: ( ( COMA ) temp= iterator )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:108: ( ( COMA ) temp= iterator )
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:109: ( COMA ) temp= iterator
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:109: ( COMA )
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:110: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_iteratorExp4026); 

            	    }

            	    pushFollow(FOLLOW_iterator_in_iteratorExp4031);
            	    temp=iterator();
            	    _fsp--;

            	    ei.set(ret, "iterators", temp);

            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);


            }


            }

            match(input,PIPE,FOLLOW_PIPE_in_iteratorExp4040); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:174: ( (temp= oclExpression ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:175: (temp= oclExpression )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:175: (temp= oclExpression )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:640:176: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_iteratorExp4046);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "body", temp);

            }


            }

            match(input,RPAREN,FOLLOW_RPAREN_in_iteratorExp4052); 

            }


                        // discard operator name
                        ei.set(ret, "source", left);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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


    // $ANTLR start iterateExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:652:1: iterateExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN ) ;
    public final Object iterateExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IterateExp", true, false) : null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:2: ( ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:4: ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:4: ( 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:5: 'iterate' LPAREN ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) ) SEMI temp= variableDeclaration PIPE ( (temp= oclExpression ) ) RPAREN
            {
            match(input,76,FOLLOW_76_in_iterateExp4085); 
            match(input,LPAREN,FOLLOW_LPAREN_in_iterateExp4087); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:22: ( (temp= iterator ( ( ( COMA ) temp= iterator ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:23: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:23: (temp= iterator ( ( ( COMA ) temp= iterator ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:24: temp= iterator ( ( ( COMA ) temp= iterator ) )*
            {
            pushFollow(FOLLOW_iterator_in_iterateExp4093);
            temp=iterator();
            _fsp--;

            ei.set(ret, "iterators", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:72: ( ( ( COMA ) temp= iterator ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==COMA) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:73: ( ( COMA ) temp= iterator )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:73: ( ( COMA ) temp= iterator )
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:74: ( COMA ) temp= iterator
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:74: ( COMA )
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:75: COMA
            	    {
            	    match(input,COMA,FOLLOW_COMA_in_iterateExp4100); 

            	    }

            	    pushFollow(FOLLOW_iterator_in_iterateExp4105);
            	    temp=iterator();
            	    _fsp--;

            	    ei.set(ret, "iterators", temp);

            	    }


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);


            }


            }

            match(input,SEMI,FOLLOW_SEMI_in_iterateExp4114); 
            pushFollow(FOLLOW_variableDeclaration_in_iterateExp4118);
            temp=variableDeclaration();
            _fsp--;

            ei.set(ret, "result", temp);
            match(input,PIPE,FOLLOW_PIPE_in_iterateExp4122); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:200: ( (temp= oclExpression ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:201: (temp= oclExpression )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:201: (temp= oclExpression )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:653:202: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_iterateExp4128);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "body", temp);

            }


            }

            match(input,RPAREN,FOLLOW_RPAREN_in_iterateExp4134); 

            }


                        // discard operator name
                        ei.set(ret, "source", left);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end iterateExp


    // $ANTLR start collectionOperationCallExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:665:1: collectionOperationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) ;
    public final Object collectionOperationCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CollectionOperationCallExp", false, false) : null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:2: ( (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:4: (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:4: (temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:5: temp= identifier LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifier_in_collectionOperationCallExp4169);
            temp=identifier();
            _fsp--;

            ei.set(ret, "operationName", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_collectionOperationCallExp4173); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:66: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( ((LA95_0>=NAME && LA95_0<=FLOAT)||LA95_0==LPAREN||LA95_0==SHARP||LA95_0==MINUS||(LA95_0>=63 && LA95_0<=71)||LA95_0==75||(LA95_0>=77 && LA95_0<=80)||(LA95_0>=84 && LA95_0<=99)) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:67: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:67: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:68: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_collectionOperationCallExp4179);
                    temp=oclExpression();
                    _fsp--;

                    ei.set(ret, "arguments", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:121: ( ( ( COMA ) temp= oclExpression ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==COMA) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:122: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:122: ( ( COMA ) temp= oclExpression )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:123: ( COMA ) temp= oclExpression
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:123: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:666:124: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_collectionOperationCallExp4186); 

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_collectionOperationCallExp4191);
                    	    temp=oclExpression();
                    	    _fsp--;

                    	    ei.set(ret, "arguments", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop94;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_collectionOperationCallExp4201); 

            }


                        // discard operator name
                        ei.set(ret, "source", left);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end collectionOperationCallExp


    // $ANTLR start operationCallExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:678:1: operationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) ;
    public final Object operationCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OperationCallExp", false, false) : null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:2: ( (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:4: (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:4: (temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:5: temp= identifierOrKeyword LPAREN ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_operationCallExp4236);
            temp=identifierOrKeyword();
            _fsp--;

            ei.set(ret, "operationName", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_operationCallExp4240); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:75: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( ((LA97_0>=NAME && LA97_0<=FLOAT)||LA97_0==LPAREN||LA97_0==SHARP||LA97_0==MINUS||(LA97_0>=63 && LA97_0<=71)||LA97_0==75||(LA97_0>=77 && LA97_0<=80)||(LA97_0>=84 && LA97_0<=99)) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:76: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:76: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:77: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_operationCallExp4246);
                    temp=oclExpression();
                    _fsp--;

                    ei.set(ret, "arguments", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:130: ( ( ( COMA ) temp= oclExpression ) )*
                    loop96:
                    do {
                        int alt96=2;
                        int LA96_0 = input.LA(1);

                        if ( (LA96_0==COMA) ) {
                            alt96=1;
                        }


                        switch (alt96) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:131: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:131: ( ( COMA ) temp= oclExpression )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:132: ( COMA ) temp= oclExpression
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:132: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:679:133: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_operationCallExp4253); 

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_operationCallExp4258);
                    	    temp=oclExpression();
                    	    _fsp--;

                    	    ei.set(ret, "arguments", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop96;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_operationCallExp4268); 

            }


                        // discard operator name
                        ei.set(ret, "source", left);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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


    // $ANTLR start navigationOrAttributeCallExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:691:1: navigationOrAttributeCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword ) ;
    public final Object navigationOrAttributeCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("NavigationOrAttributeCallExp", false, false) : null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:692:2: ( (temp= identifierOrKeyword ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:692:4: (temp= identifierOrKeyword )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:692:4: (temp= identifierOrKeyword )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:692:5: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_navigationOrAttributeCallExp4303);
            temp=identifierOrKeyword();
            _fsp--;

            ei.set(ret, "name", temp);

            }


                        // discard operator name
                        ei.set(ret, "source", left);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end navigationOrAttributeCallExp


    // $ANTLR start operatorCallExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:704:1: operatorCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object operatorCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OperatorCallExp", false, false) : null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:705:2: ()
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:706:9: 
            {

                        ei.set(ret, "operationName", opName);
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


    // $ANTLR start iterator
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:716:1: iterator returns [Object ret2] : (temp= identifier ) ;
    public final Object iterator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Iterator", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:717:2: ( (temp= identifier ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:717:4: (temp= identifier )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:717:4: (temp= identifier )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:717:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_iterator4368);
            temp=identifier();
            _fsp--;

            ei.set(ret, "varName", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end iterator


    // $ANTLR start oclUndefinedExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:727:1: oclUndefinedExp returns [Object ret2] : ( 'OclUndefined' ) ;
    public final Object oclUndefinedExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclUndefinedExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:728:2: ( ( 'OclUndefined' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:728:4: ( 'OclUndefined' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:728:4: ( 'OclUndefined' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:728:5: 'OclUndefined'
            {
            match(input,77,FOLLOW_77_in_oclUndefinedExp4402); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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


    // $ANTLR start primitiveExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:738:1: primitiveExp returns [Object ret2] : ( (ret= numericExp | ret= booleanExp | ret= stringExp ) ) ;
    public final Object primitiveExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:739:2: ( ( (ret= numericExp | ret= booleanExp | ret= stringExp ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:739:4: ( (ret= numericExp | ret= booleanExp | ret= stringExp ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:739:4: ( (ret= numericExp | ret= booleanExp | ret= stringExp ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:739:5: (ret= numericExp | ret= booleanExp | ret= stringExp )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:739:5: (ret= numericExp | ret= booleanExp | ret= stringExp )
            int alt98=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
                {
                alt98=1;
                }
                break;
            case 78:
            case 79:
                {
                alt98=2;
                }
                break;
            case STRING:
                {
                alt98=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("739:5: (ret= numericExp | ret= booleanExp | ret= stringExp )", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:739:6: ret= numericExp
                    {
                    pushFollow(FOLLOW_numericExp_in_primitiveExp4437);
                    ret=numericExp();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:739:22: ret= booleanExp
                    {
                    pushFollow(FOLLOW_booleanExp_in_primitiveExp4442);
                    ret=booleanExp();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:739:38: ret= stringExp
                    {
                    pushFollow(FOLLOW_stringExp_in_primitiveExp4447);
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
    // $ANTLR end primitiveExp


    // $ANTLR start numericExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:747:1: numericExp returns [Object ret2] : ( (ret= integerExp | ret= realExp ) ) ;
    public final Object numericExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:748:2: ( ( (ret= integerExp | ret= realExp ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:748:4: ( (ret= integerExp | ret= realExp ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:748:4: ( (ret= integerExp | ret= realExp ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:748:5: (ret= integerExp | ret= realExp )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:748:5: (ret= integerExp | ret= realExp )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==INT) ) {
                alt99=1;
            }
            else if ( (LA99_0==FLOAT) ) {
                alt99=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("748:5: (ret= integerExp | ret= realExp )", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:748:6: ret= integerExp
                    {
                    pushFollow(FOLLOW_integerExp_in_numericExp4483);
                    ret=integerExp();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:748:22: ret= realExp
                    {
                    pushFollow(FOLLOW_realExp_in_numericExp4488);
                    ret=realExp();
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
    // $ANTLR end numericExp


    // $ANTLR start booleanExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:756:1: booleanExp returns [Object ret2] : ( ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object booleanExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("BooleanExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:2: ( ( ( ( 'true' ) | ( 'false' ) ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:4: ( ( ( 'true' ) | ( 'false' ) ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:4: ( ( ( 'true' ) | ( 'false' ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:5: ( ( 'true' ) | ( 'false' ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:5: ( ( 'true' ) | ( 'false' ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==78) ) {
                alt100=1;
            }
            else if ( (LA100_0==79) ) {
                alt100=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("757:5: ( ( 'true' ) | ( 'false' ) )", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:6: ( 'true' )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:6: ( 'true' )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:7: 'true'
                    {
                    match(input,78,FOLLOW_78_in_booleanExp4523); 

                    }

                    ei.set(ret, "booleanSymbol", java.lang.Boolean.TRUE);

                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:72: ( 'false' )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:72: ( 'false' )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:757:73: 'false'
                    {
                    match(input,79,FOLLOW_79_in_booleanExp4530); 

                    }

                    ei.set(ret, "booleanSymbol", java.lang.Boolean.FALSE);

                    }
                    break;

            }


            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:767:1: integerExp returns [Object ret2] : (temp= integerSymbol ) ;
    public final Object integerExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IntegerExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:768:2: ( (temp= integerSymbol ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:768:4: (temp= integerSymbol )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:768:4: (temp= integerSymbol )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:768:5: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_integerExp4568);
            temp=integerSymbol();
            _fsp--;

            ei.set(ret, "integerSymbol", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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


    // $ANTLR start realExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:778:1: realExp returns [Object ret2] : (temp= floatSymbol ) ;
    public final Object realExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("RealExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:779:2: ( (temp= floatSymbol ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:779:4: (temp= floatSymbol )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:779:4: (temp= floatSymbol )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:779:5: temp= floatSymbol
            {
            pushFollow(FOLLOW_floatSymbol_in_realExp4604);
            temp=floatSymbol();
            _fsp--;

            ei.set(ret, "realSymbol", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end realExp


    // $ANTLR start stringExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:789:1: stringExp returns [Object ret2] : (temp= stringSymbol ) ;
    public final Object stringExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("StringExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:790:2: ( (temp= stringSymbol ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:790:4: (temp= stringSymbol )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:790:4: (temp= stringSymbol )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:790:5: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_stringExp4640);
            temp=stringSymbol();
            _fsp--;

            ei.set(ret, "stringSymbol", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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


    // $ANTLR start ifExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:800:1: ifExp returns [Object ret2] : ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' ) ;
    public final Object ifExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("IfExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:2: ( ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:4: ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:4: ( 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:5: 'if' temp= oclExpression 'then' ( (temp= oclExpression ) ) 'else' ( (temp= oclExpression ) ) 'endif'
            {
            match(input,80,FOLLOW_80_in_ifExp4674); 
            pushFollow(FOLLOW_oclExpression_in_ifExp4678);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "condition", temp);
            match(input,81,FOLLOW_81_in_ifExp4682); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:70: ( (temp= oclExpression ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:71: (temp= oclExpression )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:71: (temp= oclExpression )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:72: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_ifExp4688);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "thenExpression", temp);

            }


            }

            match(input,82,FOLLOW_82_in_ifExp4694); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:139: ( (temp= oclExpression ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:140: (temp= oclExpression )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:140: (temp= oclExpression )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:801:141: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_ifExp4700);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "elseExpression", temp);

            }


            }

            match(input,83,FOLLOW_83_in_ifExp4706); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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


    // $ANTLR start letExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:811:1: letExp returns [Object ret2] : ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) ) ;
    public final Object letExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("LetExp", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:812:2: ( ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:812:4: ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:812:4: ( 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:812:5: 'let' temp= variableDeclaration 'in' ( (temp= oclExpression ) )
            {
            match(input,84,FOLLOW_84_in_letExp4738); 
            pushFollow(FOLLOW_variableDeclaration_in_letExp4742);
            temp=variableDeclaration();
            _fsp--;

            ei.set(ret, "variable", temp);
            match(input,57,FOLLOW_57_in_letExp4746); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:812:74: ( (temp= oclExpression ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:812:75: (temp= oclExpression )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:812:75: (temp= oclExpression )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:812:76: temp= oclExpression
            {
            pushFollow(FOLLOW_oclExpression_in_letExp4752);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "in", temp);

            }


            }


            }


                        ei.leaveContext(true);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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


    // $ANTLR start variableDeclaration
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:822:1: variableDeclaration returns [Object ret2] : (temp= identifier COLON temp= oclType EQ temp= oclExpression ) ;
    public final Object variableDeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("VariableDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:823:2: ( (temp= identifier COLON temp= oclType EQ temp= oclExpression ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:823:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:823:4: (temp= identifier COLON temp= oclType EQ temp= oclExpression )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:823:5: temp= identifier COLON temp= oclType EQ temp= oclExpression
            {
            pushFollow(FOLLOW_identifier_in_variableDeclaration4790);
            temp=identifier();
            _fsp--;

            ei.set(ret, "varName", temp);
            match(input,COLON,FOLLOW_COLON_in_variableDeclaration4794); 
            pushFollow(FOLLOW_oclType_in_variableDeclaration4798);
            temp=oclType();
            _fsp--;

            ei.set(ret, "type", temp);
            match(input,EQ,FOLLOW_EQ_in_variableDeclaration4802); 
            pushFollow(FOLLOW_oclExpression_in_variableDeclaration4806);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "initExpression", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end variableDeclaration


    // $ANTLR start enumLiteralExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:833:1: enumLiteralExp returns [Object ret2] : ( SHARP temp= identifier ) ;
    public final Object enumLiteralExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("EnumLiteralExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:834:2: ( ( SHARP temp= identifier ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:834:4: ( SHARP temp= identifier )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:834:4: ( SHARP temp= identifier )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:834:5: SHARP temp= identifier
            {
            match(input,SHARP,FOLLOW_SHARP_in_enumLiteralExp4840); 
            pushFollow(FOLLOW_identifier_in_enumLiteralExp4844);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end enumLiteralExp


    // $ANTLR start collectionExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:844:1: collectionExp returns [Object ret2] : ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) ) ;
    public final Object collectionExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:845:2: ( ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:845:4: ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:845:4: ( (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:845:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:845:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )
            int alt101=4;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt101=1;
                }
                break;
            case 86:
                {
                alt101=2;
                }
                break;
            case 87:
                {
                alt101=3;
                }
                break;
            case 88:
                {
                alt101=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("845:5: (ret= bagExp | ret= setExp | ret= orderedSetExp | ret= sequenceExp )", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:845:6: ret= bagExp
                    {
                    pushFollow(FOLLOW_bagExp_in_collectionExp4881);
                    ret=bagExp();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:845:18: ret= setExp
                    {
                    pushFollow(FOLLOW_setExp_in_collectionExp4886);
                    ret=setExp();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:845:30: ret= orderedSetExp
                    {
                    pushFollow(FOLLOW_orderedSetExp_in_collectionExp4891);
                    ret=orderedSetExp();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:845:49: ret= sequenceExp
                    {
                    pushFollow(FOLLOW_sequenceExp_in_collectionExp4896);
                    ret=sequenceExp();
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
    // $ANTLR end collectionExp


    // $ANTLR start bagExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:853:1: bagExp returns [Object ret2] : ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object bagExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BagExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:2: ( ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:4: ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:4: ( 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:5: 'Bag' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,85,FOLLOW_85_in_bagExp4929); 
            match(input,LCURLY,FOLLOW_LCURLY_in_bagExp4931); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:18: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( ((LA103_0>=NAME && LA103_0<=FLOAT)||LA103_0==LPAREN||LA103_0==SHARP||LA103_0==MINUS||(LA103_0>=63 && LA103_0<=71)||LA103_0==75||(LA103_0>=77 && LA103_0<=80)||(LA103_0>=84 && LA103_0<=99)) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:20: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_bagExp4937);
                    temp=oclExpression();
                    _fsp--;

                    ei.set(ret, "elements", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:72: ( ( ( COMA ) temp= oclExpression ) )*
                    loop102:
                    do {
                        int alt102=2;
                        int LA102_0 = input.LA(1);

                        if ( (LA102_0==COMA) ) {
                            alt102=1;
                        }


                        switch (alt102) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:73: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:73: ( ( COMA ) temp= oclExpression )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:74: ( COMA ) temp= oclExpression
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:74: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:854:75: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_bagExp4944); 

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_bagExp4949);
                    	    temp=oclExpression();
                    	    _fsp--;

                    	    ei.set(ret, "elements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop102;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_bagExp4959); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end bagExp


    // $ANTLR start setExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:864:1: setExp returns [Object ret2] : ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object setExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SetExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:2: ( ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:4: ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:4: ( 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:5: 'Set' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,86,FOLLOW_86_in_setExp4991); 
            match(input,LCURLY,FOLLOW_LCURLY_in_setExp4993); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:18: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( ((LA105_0>=NAME && LA105_0<=FLOAT)||LA105_0==LPAREN||LA105_0==SHARP||LA105_0==MINUS||(LA105_0>=63 && LA105_0<=71)||LA105_0==75||(LA105_0>=77 && LA105_0<=80)||(LA105_0>=84 && LA105_0<=99)) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:19: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:20: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_setExp4999);
                    temp=oclExpression();
                    _fsp--;

                    ei.set(ret, "elements", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:72: ( ( ( COMA ) temp= oclExpression ) )*
                    loop104:
                    do {
                        int alt104=2;
                        int LA104_0 = input.LA(1);

                        if ( (LA104_0==COMA) ) {
                            alt104=1;
                        }


                        switch (alt104) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:73: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:73: ( ( COMA ) temp= oclExpression )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:74: ( COMA ) temp= oclExpression
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:74: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:865:75: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_setExp5006); 

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_setExp5011);
                    	    temp=oclExpression();
                    	    _fsp--;

                    	    ei.set(ret, "elements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop104;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_setExp5021); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end setExp


    // $ANTLR start orderedSetExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:875:1: orderedSetExp returns [Object ret2] : ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object orderedSetExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OrderedSetExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:2: ( ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:4: ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:4: ( 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:5: 'OrderedSet' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,87,FOLLOW_87_in_orderedSetExp5053); 
            match(input,LCURLY,FOLLOW_LCURLY_in_orderedSetExp5055); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:25: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( ((LA107_0>=NAME && LA107_0<=FLOAT)||LA107_0==LPAREN||LA107_0==SHARP||LA107_0==MINUS||(LA107_0>=63 && LA107_0<=71)||LA107_0==75||(LA107_0>=77 && LA107_0<=80)||(LA107_0>=84 && LA107_0<=99)) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:26: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:26: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:27: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_orderedSetExp5061);
                    temp=oclExpression();
                    _fsp--;

                    ei.set(ret, "elements", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:79: ( ( ( COMA ) temp= oclExpression ) )*
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( (LA106_0==COMA) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:80: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:80: ( ( COMA ) temp= oclExpression )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:81: ( COMA ) temp= oclExpression
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:81: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:876:82: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_orderedSetExp5068); 

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_orderedSetExp5073);
                    	    temp=oclExpression();
                    	    _fsp--;

                    	    ei.set(ret, "elements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop106;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_orderedSetExp5083); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end orderedSetExp


    // $ANTLR start sequenceExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:886:1: sequenceExp returns [Object ret2] : ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) ;
    public final Object sequenceExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SequenceExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:2: ( ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:4: ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:4: ( 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:5: 'Sequence' LCURLY ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )? RCURLY
            {
            match(input,88,FOLLOW_88_in_sequenceExp5115); 
            match(input,LCURLY,FOLLOW_LCURLY_in_sequenceExp5117); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:23: ( (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( ((LA109_0>=NAME && LA109_0<=FLOAT)||LA109_0==LPAREN||LA109_0==SHARP||LA109_0==MINUS||(LA109_0>=63 && LA109_0<=71)||LA109_0==75||(LA109_0>=77 && LA109_0<=80)||(LA109_0>=84 && LA109_0<=99)) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:24: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:24: (temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:25: temp= oclExpression ( ( ( COMA ) temp= oclExpression ) )*
                    {
                    pushFollow(FOLLOW_oclExpression_in_sequenceExp5123);
                    temp=oclExpression();
                    _fsp--;

                    ei.set(ret, "elements", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:77: ( ( ( COMA ) temp= oclExpression ) )*
                    loop108:
                    do {
                        int alt108=2;
                        int LA108_0 = input.LA(1);

                        if ( (LA108_0==COMA) ) {
                            alt108=1;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:78: ( ( COMA ) temp= oclExpression )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:78: ( ( COMA ) temp= oclExpression )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:79: ( COMA ) temp= oclExpression
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:79: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:887:80: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_sequenceExp5130); 

                    	    }

                    	    pushFollow(FOLLOW_oclExpression_in_sequenceExp5135);
                    	    temp=oclExpression();
                    	    _fsp--;

                    	    ei.set(ret, "elements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop108;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_sequenceExp5145); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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


    // $ANTLR start mapExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:897:1: mapExp returns [Object ret2] : ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY ) ;
    public final Object mapExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:2: ( ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:4: ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:4: ( 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:5: 'Map' LCURLY ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )? RCURLY
            {
            match(input,89,FOLLOW_89_in_mapExp5177); 
            match(input,LCURLY,FOLLOW_LCURLY_in_mapExp5179); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:18: ( (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==LPAREN) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:19: (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:19: (temp= mapElement ( ( ( COMA ) temp= mapElement ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:20: temp= mapElement ( ( ( COMA ) temp= mapElement ) )*
                    {
                    pushFollow(FOLLOW_mapElement_in_mapExp5185);
                    temp=mapElement();
                    _fsp--;

                    ei.set(ret, "elements", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:69: ( ( ( COMA ) temp= mapElement ) )*
                    loop110:
                    do {
                        int alt110=2;
                        int LA110_0 = input.LA(1);

                        if ( (LA110_0==COMA) ) {
                            alt110=1;
                        }


                        switch (alt110) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:70: ( ( COMA ) temp= mapElement )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:70: ( ( COMA ) temp= mapElement )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:71: ( COMA ) temp= mapElement
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:71: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:898:72: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_mapExp5192); 

                    	    }

                    	    pushFollow(FOLLOW_mapElement_in_mapExp5197);
                    	    temp=mapElement();
                    	    _fsp--;

                    	    ei.set(ret, "elements", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop110;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_mapExp5207); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end mapExp


    // $ANTLR start mapElement
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:908:1: mapElement returns [Object ret2] : ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN ) ;
    public final Object mapElement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:909:2: ( ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:909:4: ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:909:4: ( LPAREN temp= oclExpression COMA temp= oclExpression RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:909:5: LPAREN temp= oclExpression COMA temp= oclExpression RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_mapElement5239); 
            pushFollow(FOLLOW_oclExpression_in_mapElement5243);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "key", temp);
            match(input,COMA,FOLLOW_COMA_in_mapElement5247); 
            pushFollow(FOLLOW_oclExpression_in_mapElement5251);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "value", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_mapElement5255); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end mapElement


    // $ANTLR start tupleExp
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:919:1: tupleExp returns [Object ret2] : ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY ) ;
    public final Object tupleExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:2: ( ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:4: ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:4: ( 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:5: 'Tuple' LCURLY ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )? RCURLY
            {
            match(input,90,FOLLOW_90_in_tupleExp5287); 
            match(input,LCURLY,FOLLOW_LCURLY_in_tupleExp5289); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:20: ( (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==NAME||(LA113_0>=42 && LA113_0<=105)) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:21: (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:21: (temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:22: temp= tuplePart ( ( ( COMA ) temp= tuplePart ) )*
                    {
                    pushFollow(FOLLOW_tuplePart_in_tupleExp5295);
                    temp=tuplePart();
                    _fsp--;

                    ei.set(ret, "tuplePart", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:71: ( ( ( COMA ) temp= tuplePart ) )*
                    loop112:
                    do {
                        int alt112=2;
                        int LA112_0 = input.LA(1);

                        if ( (LA112_0==COMA) ) {
                            alt112=1;
                        }


                        switch (alt112) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:72: ( ( COMA ) temp= tuplePart )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:72: ( ( COMA ) temp= tuplePart )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:73: ( COMA ) temp= tuplePart
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:73: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:920:74: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_tupleExp5302); 

                    	    }

                    	    pushFollow(FOLLOW_tuplePart_in_tupleExp5307);
                    	    temp=tuplePart();
                    	    _fsp--;

                    	    ei.set(ret, "tuplePart", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop112;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RCURLY,FOLLOW_RCURLY_in_tupleExp5317); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end tupleExp


    // $ANTLR start tuplePart
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:930:1: tuplePart returns [Object ret2] : (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression ) ;
    public final Object tuplePart() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TuplePart", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:2: ( (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:4: (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:4: (temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:5: temp= identifierOrKeyword ( ( COLON temp= oclType ) | () ) EQ temp= oclExpression
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tuplePart5351);
            temp=identifierOrKeyword();
            _fsp--;

            ei.set(ret, "varName", temp);
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:62: ( ( COLON temp= oclType ) | () )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==COLON) ) {
                alt114=1;
            }
            else if ( (LA114_0==EQ) ) {
                alt114=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("931:62: ( ( COLON temp= oclType ) | () )", 114, 0, input);

                throw nvae;
            }
            switch (alt114) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:63: ( COLON temp= oclType )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:63: ( COLON temp= oclType )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:64: COLON temp= oclType
                    {
                    match(input,COLON,FOLLOW_COLON_in_tuplePart5357); 
                    pushFollow(FOLLOW_oclType_in_tuplePart5361);
                    temp=oclType();
                    _fsp--;

                    ei.set(ret, "type", temp);

                    }



                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:117: ()
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:117: ()
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:931:118: 
                    {
                    }



                    }
                    break;

            }

            match(input,EQ,FOLLOW_EQ_in_tuplePart5375); 
            pushFollow(FOLLOW_oclExpression_in_tuplePart5379);
            temp=oclExpression();
            _fsp--;

            ei.set(ret, "initExpression", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end tuplePart


    // $ANTLR start oclType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:941:1: oclType returns [Object ret2] : ( (ret= metaElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) ) ;
    public final Object oclType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:2: ( ( (ret= metaElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:4: ( (ret= metaElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:4: ( (ret= metaElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:5: (ret= metaElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:5: (ret= metaElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )
            int alt115=7;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt115=1;
                }
                break;
            case 92:
                {
                alt115=2;
                }
                break;
            case 93:
                {
                alt115=3;
                }
                break;
            case 89:
                {
                alt115=4;
                }
                break;
            case 94:
            case 95:
            case 96:
            case 97:
                {
                alt115=5;
                }
                break;
            case 85:
            case 86:
            case 87:
            case 88:
            case 98:
                {
                alt115=6;
                }
                break;
            case 91:
                {
                alt115=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("942:5: (ret= metaElement | ret= oclAnyType | ret= tupleType | ret= mapType | ret= primitive | ret= collectionType | ret= oclType_abstractContents )", 115, 0, input);

                throw nvae;
            }

            switch (alt115) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:6: ret= metaElement
                    {
                    pushFollow(FOLLOW_metaElement_in_oclType5416);
                    ret=metaElement();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:23: ret= oclAnyType
                    {
                    pushFollow(FOLLOW_oclAnyType_in_oclType5421);
                    ret=oclAnyType();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:39: ret= tupleType
                    {
                    pushFollow(FOLLOW_tupleType_in_oclType5426);
                    ret=tupleType();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:54: ret= mapType
                    {
                    pushFollow(FOLLOW_mapType_in_oclType5431);
                    ret=mapType();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:67: ret= primitive
                    {
                    pushFollow(FOLLOW_primitive_in_oclType5436);
                    ret=primitive();
                    _fsp--;


                    }
                    break;
                case 6 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:82: ret= collectionType
                    {
                    pushFollow(FOLLOW_collectionType_in_oclType5441);
                    ret=collectionType();
                    _fsp--;


                    }
                    break;
                case 7 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:942:102: ret= oclType_abstractContents
                    {
                    pushFollow(FOLLOW_oclType_abstractContents_in_oclType5446);
                    ret=oclType_abstractContents();
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
    // $ANTLR end oclType


    // $ANTLR start oclAnyType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:950:1: oclAnyType returns [Object ret2] : ( 'OclAny' ) ;
    public final Object oclAnyType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclAnyType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:951:2: ( ( 'OclAny' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:951:4: ( 'OclAny' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:951:4: ( 'OclAny' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:951:5: 'OclAny'
            {
            match(input,92,FOLLOW_92_in_oclAnyType5479); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end oclAnyType


    // $ANTLR start tupleType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:961:1: tupleType returns [Object ret2] : ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN ) ;
    public final Object tupleType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:2: ( ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:4: ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:4: ( 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:5: 'TupleType' LPAREN ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )? RPAREN
            {
            match(input,93,FOLLOW_93_in_tupleType5511); 
            match(input,LPAREN,FOLLOW_LPAREN_in_tupleType5513); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:24: ( (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* ) )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==NAME) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:25: (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:25: (temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:26: temp= tupleTypeAttribute ( ( ( COMA ) temp= tupleTypeAttribute ) )*
                    {
                    pushFollow(FOLLOW_tupleTypeAttribute_in_tupleType5519);
                    temp=tupleTypeAttribute();
                    _fsp--;

                    ei.set(ret, "attributes", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:85: ( ( ( COMA ) temp= tupleTypeAttribute ) )*
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( (LA116_0==COMA) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:86: ( ( COMA ) temp= tupleTypeAttribute )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:86: ( ( COMA ) temp= tupleTypeAttribute )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:87: ( COMA ) temp= tupleTypeAttribute
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:87: ( COMA )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:962:88: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_tupleType5526); 

                    	    }

                    	    pushFollow(FOLLOW_tupleTypeAttribute_in_tupleType5531);
                    	    temp=tupleTypeAttribute();
                    	    _fsp--;

                    	    ei.set(ret, "attributes", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop116;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_tupleType5541); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end tupleType


    // $ANTLR start tupleTypeAttribute
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:972:1: tupleTypeAttribute returns [Object ret2] : (temp= identifier COLON temp= oclType ) ;
    public final Object tupleTypeAttribute() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("TupleTypeAttribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:973:2: ( (temp= identifier COLON temp= oclType ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:973:4: (temp= identifier COLON temp= oclType )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:973:4: (temp= identifier COLON temp= oclType )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:973:5: temp= identifier COLON temp= oclType
            {
            pushFollow(FOLLOW_identifier_in_tupleTypeAttribute5575);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            match(input,COLON,FOLLOW_COLON_in_tupleTypeAttribute5579); 
            pushFollow(FOLLOW_oclType_in_tupleTypeAttribute5583);
            temp=oclType();
            _fsp--;

            ei.set(ret, "type", temp);

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end tupleTypeAttribute


    // $ANTLR start mapType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:983:1: mapType returns [Object ret2] : ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN ) ;
    public final Object mapType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("MapType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:984:2: ( ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:984:4: ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:984:4: ( 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:984:5: 'Map' LPAREN temp= oclType COMA temp= oclType RPAREN
            {
            match(input,89,FOLLOW_89_in_mapType5617); 
            match(input,LPAREN,FOLLOW_LPAREN_in_mapType5619); 
            pushFollow(FOLLOW_oclType_in_mapType5623);
            temp=oclType();
            _fsp--;

            ei.set(ret, "keyType", temp);
            match(input,COMA,FOLLOW_COMA_in_mapType5627); 
            pushFollow(FOLLOW_oclType_in_mapType5631);
            temp=oclType();
            _fsp--;

            ei.set(ret, "valueType", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_mapType5635); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end mapType


    // $ANTLR start primitive
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:994:1: primitive returns [Object ret2] : ( (ret= numericType | ret= booleanType | ret= stringType ) ) ;
    public final Object primitive() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:995:2: ( ( (ret= numericType | ret= booleanType | ret= stringType ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:995:4: ( (ret= numericType | ret= booleanType | ret= stringType ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:995:4: ( (ret= numericType | ret= booleanType | ret= stringType ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:995:5: (ret= numericType | ret= booleanType | ret= stringType )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:995:5: (ret= numericType | ret= booleanType | ret= stringType )
            int alt118=3;
            switch ( input.LA(1) ) {
            case 94:
            case 95:
                {
                alt118=1;
                }
                break;
            case 96:
                {
                alt118=2;
                }
                break;
            case 97:
                {
                alt118=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("995:5: (ret= numericType | ret= booleanType | ret= stringType )", 118, 0, input);

                throw nvae;
            }

            switch (alt118) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:995:6: ret= numericType
                    {
                    pushFollow(FOLLOW_numericType_in_primitive5670);
                    ret=numericType();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:995:23: ret= booleanType
                    {
                    pushFollow(FOLLOW_booleanType_in_primitive5675);
                    ret=booleanType();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:995:40: ret= stringType
                    {
                    pushFollow(FOLLOW_stringType_in_primitive5680);
                    ret=stringType();
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
    // $ANTLR end primitive


    // $ANTLR start numericType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1003:1: numericType returns [Object ret2] : ( (ret= integerType | ret= realType ) ) ;
    public final Object numericType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1004:2: ( ( (ret= integerType | ret= realType ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1004:4: ( (ret= integerType | ret= realType ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1004:4: ( (ret= integerType | ret= realType ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1004:5: (ret= integerType | ret= realType )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1004:5: (ret= integerType | ret= realType )
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==94) ) {
                alt119=1;
            }
            else if ( (LA119_0==95) ) {
                alt119=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1004:5: (ret= integerType | ret= realType )", 119, 0, input);

                throw nvae;
            }
            switch (alt119) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1004:6: ret= integerType
                    {
                    pushFollow(FOLLOW_integerType_in_numericType5716);
                    ret=integerType();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1004:23: ret= realType
                    {
                    pushFollow(FOLLOW_realType_in_numericType5721);
                    ret=realType();
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
    // $ANTLR end numericType


    // $ANTLR start integerType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1012:1: integerType returns [Object ret2] : ( 'Integer' ) ;
    public final Object integerType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("IntegerType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1013:2: ( ( 'Integer' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1013:4: ( 'Integer' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1013:4: ( 'Integer' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1013:5: 'Integer'
            {
            match(input,94,FOLLOW_94_in_integerType5754); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end integerType


    // $ANTLR start realType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1023:1: realType returns [Object ret2] : ( 'Real' ) ;
    public final Object realType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("RealType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1024:2: ( ( 'Real' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1024:4: ( 'Real' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1024:4: ( 'Real' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1024:5: 'Real'
            {
            match(input,95,FOLLOW_95_in_realType5786); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end realType


    // $ANTLR start booleanType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1034:1: booleanType returns [Object ret2] : ( 'Boolean' ) ;
    public final Object booleanType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("BooleanType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1035:2: ( ( 'Boolean' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1035:4: ( 'Boolean' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1035:4: ( 'Boolean' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1035:5: 'Boolean'
            {
            match(input,96,FOLLOW_96_in_booleanType5818); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end booleanType


    // $ANTLR start stringType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1045:1: stringType returns [Object ret2] : ( 'String' ) ;
    public final Object stringType() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("StringType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1046:2: ( ( 'String' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1046:4: ( 'String' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1046:4: ( 'String' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1046:5: 'String'
            {
            match(input,97,FOLLOW_97_in_stringType5850); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end stringType


    // $ANTLR start collectionType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1056:1: collectionType returns [Object ret2] : ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) ) ;
    public final Object collectionType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1057:2: ( ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1057:4: ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1057:4: ( (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1057:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1057:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )
            int alt120=5;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt120=1;
                }
                break;
            case 86:
                {
                alt120=2;
                }
                break;
            case 87:
                {
                alt120=3;
                }
                break;
            case 88:
                {
                alt120=4;
                }
                break;
            case 98:
                {
                alt120=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1057:5: (ret= bagType | ret= setType | ret= orderedSetType | ret= sequenceType | ret= collectionType_abstractContents )", 120, 0, input);

                throw nvae;
            }

            switch (alt120) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1057:6: ret= bagType
                    {
                    pushFollow(FOLLOW_bagType_in_collectionType5885);
                    ret=bagType();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1057:19: ret= setType
                    {
                    pushFollow(FOLLOW_setType_in_collectionType5890);
                    ret=setType();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1057:32: ret= orderedSetType
                    {
                    pushFollow(FOLLOW_orderedSetType_in_collectionType5895);
                    ret=orderedSetType();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1057:52: ret= sequenceType
                    {
                    pushFollow(FOLLOW_sequenceType_in_collectionType5900);
                    ret=sequenceType();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1057:70: ret= collectionType_abstractContents
                    {
                    pushFollow(FOLLOW_collectionType_abstractContents_in_collectionType5905);
                    ret=collectionType_abstractContents();
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
    // $ANTLR end collectionType


    // $ANTLR start bagType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1065:1: bagType returns [Object ret2] : ( 'Bag' LPAREN temp= oclType RPAREN ) ;
    public final Object bagType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("BagType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1066:2: ( ( 'Bag' LPAREN temp= oclType RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1066:4: ( 'Bag' LPAREN temp= oclType RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1066:4: ( 'Bag' LPAREN temp= oclType RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1066:5: 'Bag' LPAREN temp= oclType RPAREN
            {
            match(input,85,FOLLOW_85_in_bagType5938); 
            match(input,LPAREN,FOLLOW_LPAREN_in_bagType5940); 
            pushFollow(FOLLOW_oclType_in_bagType5944);
            temp=oclType();
            _fsp--;

            ei.set(ret, "elementType", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_bagType5948); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end bagType


    // $ANTLR start setType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1076:1: setType returns [Object ret2] : ( 'Set' LPAREN temp= oclType RPAREN ) ;
    public final Object setType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SetType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1077:2: ( ( 'Set' LPAREN temp= oclType RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1077:4: ( 'Set' LPAREN temp= oclType RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1077:4: ( 'Set' LPAREN temp= oclType RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1077:5: 'Set' LPAREN temp= oclType RPAREN
            {
            match(input,86,FOLLOW_86_in_setType5980); 
            match(input,LPAREN,FOLLOW_LPAREN_in_setType5982); 
            pushFollow(FOLLOW_oclType_in_setType5986);
            temp=oclType();
            _fsp--;

            ei.set(ret, "elementType", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_setType5990); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end setType


    // $ANTLR start orderedSetType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1087:1: orderedSetType returns [Object ret2] : ( 'OrderedSet' LPAREN temp= oclType RPAREN ) ;
    public final Object orderedSetType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("OrderedSetType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1088:2: ( ( 'OrderedSet' LPAREN temp= oclType RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1088:4: ( 'OrderedSet' LPAREN temp= oclType RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1088:4: ( 'OrderedSet' LPAREN temp= oclType RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1088:5: 'OrderedSet' LPAREN temp= oclType RPAREN
            {
            match(input,87,FOLLOW_87_in_orderedSetType6022); 
            match(input,LPAREN,FOLLOW_LPAREN_in_orderedSetType6024); 
            pushFollow(FOLLOW_oclType_in_orderedSetType6028);
            temp=oclType();
            _fsp--;

            ei.set(ret, "elementType", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_orderedSetType6032); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end orderedSetType


    // $ANTLR start sequenceType
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1098:1: sequenceType returns [Object ret2] : ( 'Sequence' LPAREN temp= oclType RPAREN ) ;
    public final Object sequenceType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("SequenceType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1099:2: ( ( 'Sequence' LPAREN temp= oclType RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1099:4: ( 'Sequence' LPAREN temp= oclType RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1099:4: ( 'Sequence' LPAREN temp= oclType RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1099:5: 'Sequence' LPAREN temp= oclType RPAREN
            {
            match(input,88,FOLLOW_88_in_sequenceType6064); 
            match(input,LPAREN,FOLLOW_LPAREN_in_sequenceType6066); 
            pushFollow(FOLLOW_oclType_in_sequenceType6070);
            temp=oclType();
            _fsp--;

            ei.set(ret, "elementType", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_sequenceType6074); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end sequenceType


    // $ANTLR start priority_0
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1109:1: priority_0 returns [Object ret2] : (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:2: ( (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:4: (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:4: (ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:5: ret= primary_oclExpression ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_oclExpression_in_priority_06108);
            ret=primary_oclExpression();
            _fsp--;

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:31: ( ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) ) )*
            loop124:
            do {
                int alt124=2;
                int LA124_0 = input.LA(1);

                if ( ((LA124_0>=POINT && LA124_0<=RARROW)) ) {
                    alt124=1;
                }


                switch (alt124) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )
            	    int alt123=2;
            	    int LA123_0 = input.LA(1);

            	    if ( (LA123_0==POINT) ) {
            	        alt123=1;
            	    }
            	    else if ( (LA123_0==RARROW) ) {
            	        alt123=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("1110:32: ( ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) ) | ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) ) )", 123, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt123) {
            	        case 1 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:33: ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:33: ( POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:34: POINT (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )
            	            {
            	            match(input,POINT,FOLLOW_POINT_in_priority_06113); 
            	            opName = ".";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )
            	            int alt121=2;
            	            switch ( input.LA(1) ) {
            	            case NAME:
            	                {
            	                int LA121_1 = input.LA(2);

            	                if ( (LA121_1==RCURLY||LA121_1==EQ||LA121_1==COMA||LA121_1==RPAREN||LA121_1==SEMI||LA121_1==PIPE||(LA121_1>=POINT && LA121_1<=NE)||LA121_1==48||(LA121_1>=57 && LA121_1<=58)||(LA121_1>=81 && LA121_1<=83)||(LA121_1>=100 && LA121_1<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_1==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 1, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 42:
            	                {
            	                int LA121_2 = input.LA(2);

            	                if ( (LA121_2==RCURLY||LA121_2==EQ||LA121_2==COMA||LA121_2==RPAREN||LA121_2==SEMI||LA121_2==PIPE||(LA121_2>=POINT && LA121_2<=NE)||LA121_2==48||(LA121_2>=57 && LA121_2<=58)||(LA121_2>=81 && LA121_2<=83)||(LA121_2>=100 && LA121_2<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_2==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 2, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 43:
            	                {
            	                int LA121_3 = input.LA(2);

            	                if ( (LA121_3==RCURLY||LA121_3==EQ||LA121_3==COMA||LA121_3==RPAREN||LA121_3==SEMI||LA121_3==PIPE||(LA121_3>=POINT && LA121_3<=NE)||LA121_3==48||(LA121_3>=57 && LA121_3<=58)||(LA121_3>=81 && LA121_3<=83)||(LA121_3>=100 && LA121_3<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_3==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 3, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 44:
            	                {
            	                int LA121_4 = input.LA(2);

            	                if ( (LA121_4==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_4==RCURLY||LA121_4==EQ||LA121_4==COMA||LA121_4==RPAREN||LA121_4==SEMI||LA121_4==PIPE||(LA121_4>=POINT && LA121_4<=NE)||LA121_4==48||(LA121_4>=57 && LA121_4<=58)||(LA121_4>=81 && LA121_4<=83)||(LA121_4>=100 && LA121_4<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 4, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 45:
            	                {
            	                int LA121_5 = input.LA(2);

            	                if ( (LA121_5==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_5==RCURLY||LA121_5==EQ||LA121_5==COMA||LA121_5==RPAREN||LA121_5==SEMI||LA121_5==PIPE||(LA121_5>=POINT && LA121_5<=NE)||LA121_5==48||(LA121_5>=57 && LA121_5<=58)||(LA121_5>=81 && LA121_5<=83)||(LA121_5>=100 && LA121_5<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 5, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 46:
            	                {
            	                int LA121_6 = input.LA(2);

            	                if ( (LA121_6==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_6==RCURLY||LA121_6==EQ||LA121_6==COMA||LA121_6==RPAREN||LA121_6==SEMI||LA121_6==PIPE||(LA121_6>=POINT && LA121_6<=NE)||LA121_6==48||(LA121_6>=57 && LA121_6<=58)||(LA121_6>=81 && LA121_6<=83)||(LA121_6>=100 && LA121_6<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 6, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 47:
            	                {
            	                int LA121_7 = input.LA(2);

            	                if ( (LA121_7==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_7==RCURLY||LA121_7==EQ||LA121_7==COMA||LA121_7==RPAREN||LA121_7==SEMI||LA121_7==PIPE||(LA121_7>=POINT && LA121_7<=NE)||LA121_7==48||(LA121_7>=57 && LA121_7<=58)||(LA121_7>=81 && LA121_7<=83)||(LA121_7>=100 && LA121_7<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 7, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 48:
            	                {
            	                int LA121_8 = input.LA(2);

            	                if ( (LA121_8==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_8==RCURLY||LA121_8==EQ||LA121_8==COMA||LA121_8==RPAREN||LA121_8==SEMI||LA121_8==PIPE||(LA121_8>=POINT && LA121_8<=NE)||LA121_8==48||(LA121_8>=57 && LA121_8<=58)||(LA121_8>=81 && LA121_8<=83)||(LA121_8>=100 && LA121_8<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 8, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 49:
            	                {
            	                int LA121_9 = input.LA(2);

            	                if ( (LA121_9==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_9==RCURLY||LA121_9==EQ||LA121_9==COMA||LA121_9==RPAREN||LA121_9==SEMI||LA121_9==PIPE||(LA121_9>=POINT && LA121_9<=NE)||LA121_9==48||(LA121_9>=57 && LA121_9<=58)||(LA121_9>=81 && LA121_9<=83)||(LA121_9>=100 && LA121_9<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 9, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 50:
            	                {
            	                int LA121_10 = input.LA(2);

            	                if ( (LA121_10==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_10==RCURLY||LA121_10==EQ||LA121_10==COMA||LA121_10==RPAREN||LA121_10==SEMI||LA121_10==PIPE||(LA121_10>=POINT && LA121_10<=NE)||LA121_10==48||(LA121_10>=57 && LA121_10<=58)||(LA121_10>=81 && LA121_10<=83)||(LA121_10>=100 && LA121_10<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 10, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 51:
            	                {
            	                int LA121_11 = input.LA(2);

            	                if ( (LA121_11==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_11==RCURLY||LA121_11==EQ||LA121_11==COMA||LA121_11==RPAREN||LA121_11==SEMI||LA121_11==PIPE||(LA121_11>=POINT && LA121_11<=NE)||LA121_11==48||(LA121_11>=57 && LA121_11<=58)||(LA121_11>=81 && LA121_11<=83)||(LA121_11>=100 && LA121_11<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 11, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 52:
            	                {
            	                int LA121_12 = input.LA(2);

            	                if ( (LA121_12==RCURLY||LA121_12==EQ||LA121_12==COMA||LA121_12==RPAREN||LA121_12==SEMI||LA121_12==PIPE||(LA121_12>=POINT && LA121_12<=NE)||LA121_12==48||(LA121_12>=57 && LA121_12<=58)||(LA121_12>=81 && LA121_12<=83)||(LA121_12>=100 && LA121_12<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_12==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 12, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 53:
            	                {
            	                int LA121_13 = input.LA(2);

            	                if ( (LA121_13==RCURLY||LA121_13==EQ||LA121_13==COMA||LA121_13==RPAREN||LA121_13==SEMI||LA121_13==PIPE||(LA121_13>=POINT && LA121_13<=NE)||LA121_13==48||(LA121_13>=57 && LA121_13<=58)||(LA121_13>=81 && LA121_13<=83)||(LA121_13>=100 && LA121_13<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_13==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 13, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 54:
            	                {
            	                int LA121_14 = input.LA(2);

            	                if ( (LA121_14==RCURLY||LA121_14==EQ||LA121_14==COMA||LA121_14==RPAREN||LA121_14==SEMI||LA121_14==PIPE||(LA121_14>=POINT && LA121_14<=NE)||LA121_14==48||(LA121_14>=57 && LA121_14<=58)||(LA121_14>=81 && LA121_14<=83)||(LA121_14>=100 && LA121_14<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_14==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 14, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 55:
            	                {
            	                int LA121_15 = input.LA(2);

            	                if ( (LA121_15==RCURLY||LA121_15==EQ||LA121_15==COMA||LA121_15==RPAREN||LA121_15==SEMI||LA121_15==PIPE||(LA121_15>=POINT && LA121_15<=NE)||LA121_15==48||(LA121_15>=57 && LA121_15<=58)||(LA121_15>=81 && LA121_15<=83)||(LA121_15>=100 && LA121_15<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_15==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 15, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 56:
            	                {
            	                int LA121_16 = input.LA(2);

            	                if ( (LA121_16==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_16==RCURLY||LA121_16==EQ||LA121_16==COMA||LA121_16==RPAREN||LA121_16==SEMI||LA121_16==PIPE||(LA121_16>=POINT && LA121_16<=NE)||LA121_16==48||(LA121_16>=57 && LA121_16<=58)||(LA121_16>=81 && LA121_16<=83)||(LA121_16>=100 && LA121_16<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 16, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 57:
            	                {
            	                int LA121_17 = input.LA(2);

            	                if ( (LA121_17==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_17==RCURLY||LA121_17==EQ||LA121_17==COMA||LA121_17==RPAREN||LA121_17==SEMI||LA121_17==PIPE||(LA121_17>=POINT && LA121_17<=NE)||LA121_17==48||(LA121_17>=57 && LA121_17<=58)||(LA121_17>=81 && LA121_17<=83)||(LA121_17>=100 && LA121_17<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 17, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 58:
            	                {
            	                int LA121_18 = input.LA(2);

            	                if ( (LA121_18==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_18==RCURLY||LA121_18==EQ||LA121_18==COMA||LA121_18==RPAREN||LA121_18==SEMI||LA121_18==PIPE||(LA121_18>=POINT && LA121_18<=NE)||LA121_18==48||(LA121_18>=57 && LA121_18<=58)||(LA121_18>=81 && LA121_18<=83)||(LA121_18>=100 && LA121_18<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 18, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 59:
            	                {
            	                int LA121_19 = input.LA(2);

            	                if ( (LA121_19==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_19==RCURLY||LA121_19==EQ||LA121_19==COMA||LA121_19==RPAREN||LA121_19==SEMI||LA121_19==PIPE||(LA121_19>=POINT && LA121_19<=NE)||LA121_19==48||(LA121_19>=57 && LA121_19<=58)||(LA121_19>=81 && LA121_19<=83)||(LA121_19>=100 && LA121_19<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 19, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 60:
            	                {
            	                int LA121_20 = input.LA(2);

            	                if ( (LA121_20==RCURLY||LA121_20==EQ||LA121_20==COMA||LA121_20==RPAREN||LA121_20==SEMI||LA121_20==PIPE||(LA121_20>=POINT && LA121_20<=NE)||LA121_20==48||(LA121_20>=57 && LA121_20<=58)||(LA121_20>=81 && LA121_20<=83)||(LA121_20>=100 && LA121_20<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_20==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 20, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 61:
            	                {
            	                int LA121_21 = input.LA(2);

            	                if ( (LA121_21==RCURLY||LA121_21==EQ||LA121_21==COMA||LA121_21==RPAREN||LA121_21==SEMI||LA121_21==PIPE||(LA121_21>=POINT && LA121_21<=NE)||LA121_21==48||(LA121_21>=57 && LA121_21<=58)||(LA121_21>=81 && LA121_21<=83)||(LA121_21>=100 && LA121_21<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_21==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 21, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 62:
            	                {
            	                int LA121_22 = input.LA(2);

            	                if ( (LA121_22==RCURLY||LA121_22==EQ||LA121_22==COMA||LA121_22==RPAREN||LA121_22==SEMI||LA121_22==PIPE||(LA121_22>=POINT && LA121_22<=NE)||LA121_22==48||(LA121_22>=57 && LA121_22<=58)||(LA121_22>=81 && LA121_22<=83)||(LA121_22>=100 && LA121_22<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_22==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 22, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 63:
            	                {
            	                int LA121_23 = input.LA(2);

            	                if ( (LA121_23==RCURLY||LA121_23==EQ||LA121_23==COMA||LA121_23==RPAREN||LA121_23==SEMI||LA121_23==PIPE||(LA121_23>=POINT && LA121_23<=NE)||LA121_23==48||(LA121_23>=57 && LA121_23<=58)||(LA121_23>=81 && LA121_23<=83)||(LA121_23>=100 && LA121_23<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_23==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 23, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 64:
            	                {
            	                int LA121_24 = input.LA(2);

            	                if ( (LA121_24==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_24==RCURLY||LA121_24==EQ||LA121_24==COMA||LA121_24==RPAREN||LA121_24==SEMI||LA121_24==PIPE||(LA121_24>=POINT && LA121_24<=NE)||LA121_24==48||(LA121_24>=57 && LA121_24<=58)||(LA121_24>=81 && LA121_24<=83)||(LA121_24>=100 && LA121_24<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 24, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 65:
            	                {
            	                int LA121_25 = input.LA(2);

            	                if ( (LA121_25==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_25==RCURLY||LA121_25==EQ||LA121_25==COMA||LA121_25==RPAREN||LA121_25==SEMI||LA121_25==PIPE||(LA121_25>=POINT && LA121_25<=NE)||LA121_25==48||(LA121_25>=57 && LA121_25<=58)||(LA121_25>=81 && LA121_25<=83)||(LA121_25>=100 && LA121_25<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 25, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 66:
            	                {
            	                int LA121_26 = input.LA(2);

            	                if ( (LA121_26==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_26==RCURLY||LA121_26==EQ||LA121_26==COMA||LA121_26==RPAREN||LA121_26==SEMI||LA121_26==PIPE||(LA121_26>=POINT && LA121_26<=NE)||LA121_26==48||(LA121_26>=57 && LA121_26<=58)||(LA121_26>=81 && LA121_26<=83)||(LA121_26>=100 && LA121_26<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 26, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 67:
            	                {
            	                int LA121_27 = input.LA(2);

            	                if ( (LA121_27==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_27==RCURLY||LA121_27==EQ||LA121_27==COMA||LA121_27==RPAREN||LA121_27==SEMI||LA121_27==PIPE||(LA121_27>=POINT && LA121_27<=NE)||LA121_27==48||(LA121_27>=57 && LA121_27<=58)||(LA121_27>=81 && LA121_27<=83)||(LA121_27>=100 && LA121_27<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 27, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 68:
            	                {
            	                int LA121_28 = input.LA(2);

            	                if ( (LA121_28==RCURLY||LA121_28==EQ||LA121_28==COMA||LA121_28==RPAREN||LA121_28==SEMI||LA121_28==PIPE||(LA121_28>=POINT && LA121_28<=NE)||LA121_28==48||(LA121_28>=57 && LA121_28<=58)||(LA121_28>=81 && LA121_28<=83)||(LA121_28>=100 && LA121_28<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_28==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 28, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 69:
            	                {
            	                int LA121_29 = input.LA(2);

            	                if ( (LA121_29==RCURLY||LA121_29==EQ||LA121_29==COMA||LA121_29==RPAREN||LA121_29==SEMI||LA121_29==PIPE||(LA121_29>=POINT && LA121_29<=NE)||LA121_29==48||(LA121_29>=57 && LA121_29<=58)||(LA121_29>=81 && LA121_29<=83)||(LA121_29>=100 && LA121_29<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_29==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 29, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 70:
            	                {
            	                int LA121_30 = input.LA(2);

            	                if ( (LA121_30==RCURLY||LA121_30==EQ||LA121_30==COMA||LA121_30==RPAREN||LA121_30==SEMI||LA121_30==PIPE||(LA121_30>=POINT && LA121_30<=NE)||LA121_30==48||(LA121_30>=57 && LA121_30<=58)||(LA121_30>=81 && LA121_30<=83)||(LA121_30>=100 && LA121_30<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_30==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 30, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 71:
            	                {
            	                int LA121_31 = input.LA(2);

            	                if ( (LA121_31==RCURLY||LA121_31==EQ||LA121_31==COMA||LA121_31==RPAREN||LA121_31==SEMI||LA121_31==PIPE||(LA121_31>=POINT && LA121_31<=NE)||LA121_31==48||(LA121_31>=57 && LA121_31<=58)||(LA121_31>=81 && LA121_31<=83)||(LA121_31>=100 && LA121_31<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_31==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 31, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 72:
            	                {
            	                int LA121_32 = input.LA(2);

            	                if ( (LA121_32==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_32==RCURLY||LA121_32==EQ||LA121_32==COMA||LA121_32==RPAREN||LA121_32==SEMI||LA121_32==PIPE||(LA121_32>=POINT && LA121_32<=NE)||LA121_32==48||(LA121_32>=57 && LA121_32<=58)||(LA121_32>=81 && LA121_32<=83)||(LA121_32>=100 && LA121_32<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 32, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 73:
            	                {
            	                int LA121_33 = input.LA(2);

            	                if ( (LA121_33==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_33==RCURLY||LA121_33==EQ||LA121_33==COMA||LA121_33==RPAREN||LA121_33==SEMI||LA121_33==PIPE||(LA121_33>=POINT && LA121_33<=NE)||LA121_33==48||(LA121_33>=57 && LA121_33<=58)||(LA121_33>=81 && LA121_33<=83)||(LA121_33>=100 && LA121_33<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 33, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 74:
            	                {
            	                int LA121_34 = input.LA(2);

            	                if ( (LA121_34==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_34==RCURLY||LA121_34==EQ||LA121_34==COMA||LA121_34==RPAREN||LA121_34==SEMI||LA121_34==PIPE||(LA121_34>=POINT && LA121_34<=NE)||LA121_34==48||(LA121_34>=57 && LA121_34<=58)||(LA121_34>=81 && LA121_34<=83)||(LA121_34>=100 && LA121_34<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 34, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 75:
            	                {
            	                int LA121_35 = input.LA(2);

            	                if ( (LA121_35==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_35==RCURLY||LA121_35==EQ||LA121_35==COMA||LA121_35==RPAREN||LA121_35==SEMI||LA121_35==PIPE||(LA121_35>=POINT && LA121_35<=NE)||LA121_35==48||(LA121_35>=57 && LA121_35<=58)||(LA121_35>=81 && LA121_35<=83)||(LA121_35>=100 && LA121_35<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 35, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 76:
            	                {
            	                int LA121_36 = input.LA(2);

            	                if ( (LA121_36==RCURLY||LA121_36==EQ||LA121_36==COMA||LA121_36==RPAREN||LA121_36==SEMI||LA121_36==PIPE||(LA121_36>=POINT && LA121_36<=NE)||LA121_36==48||(LA121_36>=57 && LA121_36<=58)||(LA121_36>=81 && LA121_36<=83)||(LA121_36>=100 && LA121_36<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_36==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 36, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 77:
            	                {
            	                int LA121_37 = input.LA(2);

            	                if ( (LA121_37==RCURLY||LA121_37==EQ||LA121_37==COMA||LA121_37==RPAREN||LA121_37==SEMI||LA121_37==PIPE||(LA121_37>=POINT && LA121_37<=NE)||LA121_37==48||(LA121_37>=57 && LA121_37<=58)||(LA121_37>=81 && LA121_37<=83)||(LA121_37>=100 && LA121_37<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_37==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 37, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 78:
            	                {
            	                int LA121_38 = input.LA(2);

            	                if ( (LA121_38==RCURLY||LA121_38==EQ||LA121_38==COMA||LA121_38==RPAREN||LA121_38==SEMI||LA121_38==PIPE||(LA121_38>=POINT && LA121_38<=NE)||LA121_38==48||(LA121_38>=57 && LA121_38<=58)||(LA121_38>=81 && LA121_38<=83)||(LA121_38>=100 && LA121_38<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_38==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 38, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 79:
            	                {
            	                int LA121_39 = input.LA(2);

            	                if ( (LA121_39==RCURLY||LA121_39==EQ||LA121_39==COMA||LA121_39==RPAREN||LA121_39==SEMI||LA121_39==PIPE||(LA121_39>=POINT && LA121_39<=NE)||LA121_39==48||(LA121_39>=57 && LA121_39<=58)||(LA121_39>=81 && LA121_39<=83)||(LA121_39>=100 && LA121_39<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_39==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 39, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 80:
            	                {
            	                int LA121_40 = input.LA(2);

            	                if ( (LA121_40==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_40==RCURLY||LA121_40==EQ||LA121_40==COMA||LA121_40==RPAREN||LA121_40==SEMI||LA121_40==PIPE||(LA121_40>=POINT && LA121_40<=NE)||LA121_40==48||(LA121_40>=57 && LA121_40<=58)||(LA121_40>=81 && LA121_40<=83)||(LA121_40>=100 && LA121_40<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 40, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 81:
            	                {
            	                int LA121_41 = input.LA(2);

            	                if ( (LA121_41==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_41==RCURLY||LA121_41==EQ||LA121_41==COMA||LA121_41==RPAREN||LA121_41==SEMI||LA121_41==PIPE||(LA121_41>=POINT && LA121_41<=NE)||LA121_41==48||(LA121_41>=57 && LA121_41<=58)||(LA121_41>=81 && LA121_41<=83)||(LA121_41>=100 && LA121_41<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 41, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 82:
            	                {
            	                int LA121_42 = input.LA(2);

            	                if ( (LA121_42==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_42==RCURLY||LA121_42==EQ||LA121_42==COMA||LA121_42==RPAREN||LA121_42==SEMI||LA121_42==PIPE||(LA121_42>=POINT && LA121_42<=NE)||LA121_42==48||(LA121_42>=57 && LA121_42<=58)||(LA121_42>=81 && LA121_42<=83)||(LA121_42>=100 && LA121_42<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 42, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 83:
            	                {
            	                int LA121_43 = input.LA(2);

            	                if ( (LA121_43==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_43==RCURLY||LA121_43==EQ||LA121_43==COMA||LA121_43==RPAREN||LA121_43==SEMI||LA121_43==PIPE||(LA121_43>=POINT && LA121_43<=NE)||LA121_43==48||(LA121_43>=57 && LA121_43<=58)||(LA121_43>=81 && LA121_43<=83)||(LA121_43>=100 && LA121_43<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 43, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 84:
            	                {
            	                int LA121_44 = input.LA(2);

            	                if ( (LA121_44==RCURLY||LA121_44==EQ||LA121_44==COMA||LA121_44==RPAREN||LA121_44==SEMI||LA121_44==PIPE||(LA121_44>=POINT && LA121_44<=NE)||LA121_44==48||(LA121_44>=57 && LA121_44<=58)||(LA121_44>=81 && LA121_44<=83)||(LA121_44>=100 && LA121_44<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_44==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 44, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 85:
            	                {
            	                int LA121_45 = input.LA(2);

            	                if ( (LA121_45==RCURLY||LA121_45==EQ||LA121_45==COMA||LA121_45==RPAREN||LA121_45==SEMI||LA121_45==PIPE||(LA121_45>=POINT && LA121_45<=NE)||LA121_45==48||(LA121_45>=57 && LA121_45<=58)||(LA121_45>=81 && LA121_45<=83)||(LA121_45>=100 && LA121_45<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_45==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 45, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 86:
            	                {
            	                int LA121_46 = input.LA(2);

            	                if ( (LA121_46==RCURLY||LA121_46==EQ||LA121_46==COMA||LA121_46==RPAREN||LA121_46==SEMI||LA121_46==PIPE||(LA121_46>=POINT && LA121_46<=NE)||LA121_46==48||(LA121_46>=57 && LA121_46<=58)||(LA121_46>=81 && LA121_46<=83)||(LA121_46>=100 && LA121_46<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_46==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 46, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 87:
            	                {
            	                int LA121_47 = input.LA(2);

            	                if ( (LA121_47==RCURLY||LA121_47==EQ||LA121_47==COMA||LA121_47==RPAREN||LA121_47==SEMI||LA121_47==PIPE||(LA121_47>=POINT && LA121_47<=NE)||LA121_47==48||(LA121_47>=57 && LA121_47<=58)||(LA121_47>=81 && LA121_47<=83)||(LA121_47>=100 && LA121_47<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_47==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 47, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 88:
            	                {
            	                int LA121_48 = input.LA(2);

            	                if ( (LA121_48==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_48==RCURLY||LA121_48==EQ||LA121_48==COMA||LA121_48==RPAREN||LA121_48==SEMI||LA121_48==PIPE||(LA121_48>=POINT && LA121_48<=NE)||LA121_48==48||(LA121_48>=57 && LA121_48<=58)||(LA121_48>=81 && LA121_48<=83)||(LA121_48>=100 && LA121_48<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 48, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 89:
            	                {
            	                int LA121_49 = input.LA(2);

            	                if ( (LA121_49==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_49==RCURLY||LA121_49==EQ||LA121_49==COMA||LA121_49==RPAREN||LA121_49==SEMI||LA121_49==PIPE||(LA121_49>=POINT && LA121_49<=NE)||LA121_49==48||(LA121_49>=57 && LA121_49<=58)||(LA121_49>=81 && LA121_49<=83)||(LA121_49>=100 && LA121_49<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 49, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 90:
            	                {
            	                int LA121_50 = input.LA(2);

            	                if ( (LA121_50==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_50==RCURLY||LA121_50==EQ||LA121_50==COMA||LA121_50==RPAREN||LA121_50==SEMI||LA121_50==PIPE||(LA121_50>=POINT && LA121_50<=NE)||LA121_50==48||(LA121_50>=57 && LA121_50<=58)||(LA121_50>=81 && LA121_50<=83)||(LA121_50>=100 && LA121_50<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 50, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 91:
            	                {
            	                int LA121_51 = input.LA(2);

            	                if ( (LA121_51==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_51==RCURLY||LA121_51==EQ||LA121_51==COMA||LA121_51==RPAREN||LA121_51==SEMI||LA121_51==PIPE||(LA121_51>=POINT && LA121_51<=NE)||LA121_51==48||(LA121_51>=57 && LA121_51<=58)||(LA121_51>=81 && LA121_51<=83)||(LA121_51>=100 && LA121_51<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 51, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 92:
            	                {
            	                int LA121_52 = input.LA(2);

            	                if ( (LA121_52==RCURLY||LA121_52==EQ||LA121_52==COMA||LA121_52==RPAREN||LA121_52==SEMI||LA121_52==PIPE||(LA121_52>=POINT && LA121_52<=NE)||LA121_52==48||(LA121_52>=57 && LA121_52<=58)||(LA121_52>=81 && LA121_52<=83)||(LA121_52>=100 && LA121_52<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_52==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 52, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 93:
            	                {
            	                int LA121_53 = input.LA(2);

            	                if ( (LA121_53==RCURLY||LA121_53==EQ||LA121_53==COMA||LA121_53==RPAREN||LA121_53==SEMI||LA121_53==PIPE||(LA121_53>=POINT && LA121_53<=NE)||LA121_53==48||(LA121_53>=57 && LA121_53<=58)||(LA121_53>=81 && LA121_53<=83)||(LA121_53>=100 && LA121_53<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_53==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 53, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 94:
            	                {
            	                int LA121_54 = input.LA(2);

            	                if ( (LA121_54==RCURLY||LA121_54==EQ||LA121_54==COMA||LA121_54==RPAREN||LA121_54==SEMI||LA121_54==PIPE||(LA121_54>=POINT && LA121_54<=NE)||LA121_54==48||(LA121_54>=57 && LA121_54<=58)||(LA121_54>=81 && LA121_54<=83)||(LA121_54>=100 && LA121_54<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_54==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 54, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 95:
            	                {
            	                int LA121_55 = input.LA(2);

            	                if ( (LA121_55==RCURLY||LA121_55==EQ||LA121_55==COMA||LA121_55==RPAREN||LA121_55==SEMI||LA121_55==PIPE||(LA121_55>=POINT && LA121_55<=NE)||LA121_55==48||(LA121_55>=57 && LA121_55<=58)||(LA121_55>=81 && LA121_55<=83)||(LA121_55>=100 && LA121_55<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_55==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 55, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 96:
            	                {
            	                int LA121_56 = input.LA(2);

            	                if ( (LA121_56==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_56==RCURLY||LA121_56==EQ||LA121_56==COMA||LA121_56==RPAREN||LA121_56==SEMI||LA121_56==PIPE||(LA121_56>=POINT && LA121_56<=NE)||LA121_56==48||(LA121_56>=57 && LA121_56<=58)||(LA121_56>=81 && LA121_56<=83)||(LA121_56>=100 && LA121_56<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 56, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 97:
            	                {
            	                int LA121_57 = input.LA(2);

            	                if ( (LA121_57==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_57==RCURLY||LA121_57==EQ||LA121_57==COMA||LA121_57==RPAREN||LA121_57==SEMI||LA121_57==PIPE||(LA121_57>=POINT && LA121_57<=NE)||LA121_57==48||(LA121_57>=57 && LA121_57<=58)||(LA121_57>=81 && LA121_57<=83)||(LA121_57>=100 && LA121_57<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 57, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 98:
            	                {
            	                int LA121_58 = input.LA(2);

            	                if ( (LA121_58==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_58==RCURLY||LA121_58==EQ||LA121_58==COMA||LA121_58==RPAREN||LA121_58==SEMI||LA121_58==PIPE||(LA121_58>=POINT && LA121_58<=NE)||LA121_58==48||(LA121_58>=57 && LA121_58<=58)||(LA121_58>=81 && LA121_58<=83)||(LA121_58>=100 && LA121_58<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 58, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 99:
            	                {
            	                int LA121_59 = input.LA(2);

            	                if ( (LA121_59==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_59==RCURLY||LA121_59==EQ||LA121_59==COMA||LA121_59==RPAREN||LA121_59==SEMI||LA121_59==PIPE||(LA121_59>=POINT && LA121_59<=NE)||LA121_59==48||(LA121_59>=57 && LA121_59<=58)||(LA121_59>=81 && LA121_59<=83)||(LA121_59>=100 && LA121_59<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 59, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 100:
            	                {
            	                int LA121_60 = input.LA(2);

            	                if ( (LA121_60==RCURLY||LA121_60==EQ||LA121_60==COMA||LA121_60==RPAREN||LA121_60==SEMI||LA121_60==PIPE||(LA121_60>=POINT && LA121_60<=NE)||LA121_60==48||(LA121_60>=57 && LA121_60<=58)||(LA121_60>=81 && LA121_60<=83)||(LA121_60>=100 && LA121_60<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_60==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 60, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 101:
            	                {
            	                int LA121_61 = input.LA(2);

            	                if ( (LA121_61==RCURLY||LA121_61==EQ||LA121_61==COMA||LA121_61==RPAREN||LA121_61==SEMI||LA121_61==PIPE||(LA121_61>=POINT && LA121_61<=NE)||LA121_61==48||(LA121_61>=57 && LA121_61<=58)||(LA121_61>=81 && LA121_61<=83)||(LA121_61>=100 && LA121_61<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_61==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 61, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 102:
            	                {
            	                int LA121_62 = input.LA(2);

            	                if ( (LA121_62==RCURLY||LA121_62==EQ||LA121_62==COMA||LA121_62==RPAREN||LA121_62==SEMI||LA121_62==PIPE||(LA121_62>=POINT && LA121_62<=NE)||LA121_62==48||(LA121_62>=57 && LA121_62<=58)||(LA121_62>=81 && LA121_62<=83)||(LA121_62>=100 && LA121_62<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_62==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 62, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 103:
            	                {
            	                int LA121_63 = input.LA(2);

            	                if ( (LA121_63==RCURLY||LA121_63==EQ||LA121_63==COMA||LA121_63==RPAREN||LA121_63==SEMI||LA121_63==PIPE||(LA121_63>=POINT && LA121_63<=NE)||LA121_63==48||(LA121_63>=57 && LA121_63<=58)||(LA121_63>=81 && LA121_63<=83)||(LA121_63>=100 && LA121_63<=105)) ) {
            	                    alt121=2;
            	                }
            	                else if ( (LA121_63==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 63, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 104:
            	                {
            	                int LA121_64 = input.LA(2);

            	                if ( (LA121_64==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_64==RCURLY||LA121_64==EQ||LA121_64==COMA||LA121_64==RPAREN||LA121_64==SEMI||LA121_64==PIPE||(LA121_64>=POINT && LA121_64<=NE)||LA121_64==48||(LA121_64>=57 && LA121_64<=58)||(LA121_64>=81 && LA121_64<=83)||(LA121_64>=100 && LA121_64<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 64, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            case 105:
            	                {
            	                int LA121_65 = input.LA(2);

            	                if ( (LA121_65==LPAREN) ) {
            	                    alt121=1;
            	                }
            	                else if ( (LA121_65==RCURLY||LA121_65==EQ||LA121_65==COMA||LA121_65==RPAREN||LA121_65==SEMI||LA121_65==PIPE||(LA121_65>=POINT && LA121_65<=NE)||LA121_65==48||(LA121_65>=57 && LA121_65<=58)||(LA121_65>=81 && LA121_65<=83)||(LA121_65>=100 && LA121_65<=105)) ) {
            	                    alt121=2;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 65, input);

            	                    throw nvae;
            	                }
            	                }
            	                break;
            	            default:
            	                NoViableAltException nvae =
            	                    new NoViableAltException("1110:56: (ret= operationCallExp[opName, ret, firstToken] | ret= navigationOrAttributeCallExp[opName, ret, firstToken] )", 121, 0, input);

            	                throw nvae;
            	            }

            	            switch (alt121) {
            	                case 1 :
            	                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:57: ret= operationCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_operationCallExp_in_priority_06120);
            	                    ret=operationCallExp(opName,  ret,  firstToken);
            	                    _fsp--;


            	                    }
            	                    break;
            	                case 2 :
            	                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:105: ret= navigationOrAttributeCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_navigationOrAttributeCallExp_in_priority_06127);
            	                    ret=navigationOrAttributeCallExp(opName,  ret,  firstToken);
            	                    _fsp--;


            	                    }
            	                    break;

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:167: ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:167: ( RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:168: RARROW (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )
            	            {
            	            match(input,RARROW,FOLLOW_RARROW_in_priority_06135); 
            	            opName = "->";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:192: (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )
            	            int alt122=3;
            	            alt122 = dfa122.predict(input);
            	            switch (alt122) {
            	                case 1 :
            	                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:193: ret= iteratorExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_iteratorExp_in_priority_06142);
            	                    ret=iteratorExp(opName,  ret,  firstToken);
            	                    _fsp--;


            	                    }
            	                    break;
            	                case 2 :
            	                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:236: ret= iterateExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_iterateExp_in_priority_06149);
            	                    ret=iterateExp(opName,  ret,  firstToken);
            	                    _fsp--;


            	                    }
            	                    break;
            	                case 3 :
            	                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1110:278: ret= collectionOperationCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_collectionOperationCallExp_in_priority_06156);
            	                    ret=collectionOperationCallExp(opName,  ret,  firstToken);
            	                    _fsp--;


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
            	    break loop124;
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1117:1: priority_1 returns [Object ret2] : ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) ;
    public final Object priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1118:2: ( ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1118:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1118:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            int alt125=3;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt125=1;
                }
                break;
            case MINUS:
                {
                alt125=2;
                }
                break;
            case NAME:
            case STRING:
            case INT:
            case FLOAT:
            case LPAREN:
            case SHARP:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 75:
            case 77:
            case 78:
            case 79:
            case 80:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
                {
                alt125=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1118:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )", 125, 0, input);

                throw nvae;
            }

            switch (alt125) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1118:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1118:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1118:6: 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,99,FOLLOW_99_in_priority_16196); 
                    opName = "not";
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1118:30: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1118:31: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_16203);
                    ret=operatorCallExp(opName,  right,  firstToken);
                    _fsp--;

                    pushFollow(FOLLOW_priority_0_in_priority_16208);
                    right=priority_0();
                    _fsp--;

                    ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
                    	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

                    }


                    }


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1119:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1119:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1119:72: MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_priority_16216); 
                    opName = "-";
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1119:94: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1119:95: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_16223);
                    ret=operatorCallExp(opName,  right,  firstToken);
                    _fsp--;

                    pushFollow(FOLLOW_priority_0_in_priority_16228);
                    right=priority_0();
                    _fsp--;

                    ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
                    	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

                    }


                    }


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1120:71: (ret= priority_0 )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1120:71: (ret= priority_0 )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1120:72: ret= priority_0
                    {
                    pushFollow(FOLLOW_priority_0_in_priority_16238);
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1127:1: priority_2 returns [Object ret2] : (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ;
    public final Object priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:2: ( (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:5: ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_1_in_priority_26273);
            ret=priority_1();
            _fsp--;

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:20: ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            loop127:
            do {
                int alt127=2;
                int LA127_0 = input.LA(1);

                if ( ((LA127_0>=STAR && LA127_0<=SLASH)||(LA127_0>=100 && LA127_0<=101)) ) {
                    alt127=1;
                }


                switch (alt127) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    int alt126=4;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt126=1;
            	        }
            	        break;
            	    case SLASH:
            	        {
            	        alt126=2;
            	        }
            	        break;
            	    case 100:
            	        {
            	        alt126=3;
            	        }
            	        break;
            	    case 101:
            	        {
            	        alt126=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("1128:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )", 126, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt126) {
            	        case 1 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:23: STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,STAR,FOLLOW_STAR_in_priority_26278); 
            	            opName = "*";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1128:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_26285);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_26290);
            	            right=priority_1();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1129:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1129:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1129:72: SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,SLASH,FOLLOW_SLASH_in_priority_26298); 
            	            opName = "/";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1129:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1129:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_26305);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_26310);
            	            right=priority_1();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1130:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1130:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1130:72: 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,100,FOLLOW_100_in_priority_26318); 
            	            opName = "div";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1130:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1130:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_26325);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_26330);
            	            right=priority_1();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1131:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1131:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1131:72: 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,101,FOLLOW_101_in_priority_26338); 
            	            opName = "mod";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1131:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1131:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_26345);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_26350);
            	            right=priority_1();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop127;
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1139:1: priority_3 returns [Object ret2] : (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) ;
    public final Object priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:2: ( (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:5: ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_2_in_priority_36391);
            ret=priority_2();
            _fsp--;

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:20: ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            loop129:
            do {
                int alt129=2;
                int LA129_0 = input.LA(1);

                if ( (LA129_0==MINUS||LA129_0==PLUS) ) {
                    alt129=1;
                }


                switch (alt129) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    int alt128=2;
            	    int LA128_0 = input.LA(1);

            	    if ( (LA128_0==PLUS) ) {
            	        alt128=1;
            	    }
            	    else if ( (LA128_0==MINUS) ) {
            	        alt128=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("1140:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )", 128, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt128) {
            	        case 1 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:23: PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_priority_36396); 
            	            opName = "+";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1140:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_36403);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_2_in_priority_36408);
            	            right=priority_2();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1141:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1141:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1141:72: MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_priority_36416); 
            	            opName = "-";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1141:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1141:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_36423);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_2_in_priority_36428);
            	            right=priority_2();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop129;
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1149:1: priority_4 returns [Object ret2] : (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* ) ;
    public final Object priority_4() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:2: ( (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:5: ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_3_in_priority_46469);
            ret=priority_3();
            _fsp--;

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:20: ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) ) )*
            loop131:
            do {
                int alt131=2;
                int LA131_0 = input.LA(1);

                if ( (LA131_0==EQ||(LA131_0>=GT && LA131_0<=NE)) ) {
                    alt131=1;
                }


                switch (alt131) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )
            	    int alt130=6;
            	    switch ( input.LA(1) ) {
            	    case EQ:
            	        {
            	        alt130=1;
            	        }
            	        break;
            	    case GT:
            	        {
            	        alt130=2;
            	        }
            	        break;
            	    case LT:
            	        {
            	        alt130=3;
            	        }
            	        break;
            	    case GE:
            	        {
            	        alt130=4;
            	        }
            	        break;
            	    case LE:
            	        {
            	        alt130=5;
            	        }
            	        break;
            	    case NE:
            	        {
            	        alt130=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("1150:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) )", 130, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt130) {
            	        case 1 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:23: EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,EQ,FOLLOW_EQ_in_priority_46474); 
            	            opName = "=";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:42: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1150:43: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_46481);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_46486);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1151:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1151:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1151:72: GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GT,FOLLOW_GT_in_priority_46494); 
            	            opName = ">";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1151:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1151:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_46501);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_46506);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1152:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1152:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1152:72: LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LT,FOLLOW_LT_in_priority_46514); 
            	            opName = "<";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1152:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1152:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_46521);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_46526);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1153:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1153:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1153:72: GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GE,FOLLOW_GE_in_priority_46534); 
            	            opName = ">=";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1153:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1153:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_46541);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_46546);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 5 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1154:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1154:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1154:72: LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LE,FOLLOW_LE_in_priority_46554); 
            	            opName = "<=";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1154:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1154:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_46561);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_46566);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 6 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1155:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1155:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1155:72: NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,NE,FOLLOW_NE_in_priority_46574); 
            	            opName = "<>";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1155:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1155:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_46581);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_46586);
            	            right=priority_3();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop131;
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1163:1: priority_5 returns [Object ret2] : (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ;
    public final Object priority_5() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:2: ( (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:5: ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_4_in_priority_56627);
            ret=priority_4();
            _fsp--;

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:20: ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            loop133:
            do {
                int alt133=2;
                int LA133_0 = input.LA(1);

                if ( ((LA133_0>=102 && LA133_0<=105)) ) {
                    alt133=1;
                }


                switch (alt133) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    int alt132=4;
            	    switch ( input.LA(1) ) {
            	    case 102:
            	        {
            	        alt132=1;
            	        }
            	        break;
            	    case 103:
            	        {
            	        alt132=2;
            	        }
            	        break;
            	    case 104:
            	        {
            	        alt132=3;
            	        }
            	        break;
            	    case 105:
            	        {
            	        alt132=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("1164:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )", 132, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt132) {
            	        case 1 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:23: 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,102,FOLLOW_102_in_priority_56632); 
            	            opName = "and";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:47: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1164:48: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_56639);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_56644);
            	            right=priority_4();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1165:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1165:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1165:72: 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,103,FOLLOW_103_in_priority_56652); 
            	            opName = "or";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1165:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1165:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_56659);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_56664);
            	            right=priority_4();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1166:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1166:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1166:72: 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,104,FOLLOW_104_in_priority_56672); 
            	            opName = "xor";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1166:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1166:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_56679);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_56684);
            	            right=priority_4();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1167:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1167:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1167:72: 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,105,FOLLOW_105_in_priority_56692); 
            	            opName = "implies";
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1167:104: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1167:105: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_56699);
            	            ret=operatorCallExp(opName,  ret,  firstToken);
            	            _fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_56704);
            	            right=priority_4();
            	            _fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop133;
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


    // $ANTLR start oclType_abstractContents
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1175:1: oclType_abstractContents returns [Object ret2] : ( 'OclType' ) ;
    public final Object oclType_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object ret=(backtracking==0) ? ei.create("OclType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1176:2: ( ( 'OclType' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1176:4: ( 'OclType' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1176:4: ( 'OclType' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1176:5: 'OclType'
            {
            match(input,91,FOLLOW_91_in_oclType_abstractContents6743); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end oclType_abstractContents


    // $ANTLR start collectionType_abstractContents
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1186:1: collectionType_abstractContents returns [Object ret2] : ( 'Collection' LPAREN temp= oclType RPAREN ) ;
    public final Object collectionType_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("CollectionType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1187:2: ( ( 'Collection' LPAREN temp= oclType RPAREN ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1187:4: ( 'Collection' LPAREN temp= oclType RPAREN )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1187:4: ( 'Collection' LPAREN temp= oclType RPAREN )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1187:5: 'Collection' LPAREN temp= oclType RPAREN
            {
            match(input,98,FOLLOW_98_in_collectionType_abstractContents6775); 
            match(input,LPAREN,FOLLOW_LPAREN_in_collectionType_abstractContents6777); 
            pushFollow(FOLLOW_oclType_in_collectionType_abstractContents6781);
            temp=oclType();
            _fsp--;

            ei.set(ret, "elementType", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_collectionType_abstractContents6785); 

            }


                        ei.leaveContext(false);
                        if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
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
    // $ANTLR end collectionType_abstractContents


    // $ANTLR start primary_oclExpression
    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1197:1: primary_oclExpression returns [Object ret2] : ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType ) ;
    public final Object primary_oclExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:2: ( ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )
            int alt134=19;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt134=1;
                }
                break;
            case NAME:
                {
                int LA134_2 = input.LA(2);

                if ( (LA134_2==EXCL) ) {
                    alt134=19;
                }
                else if ( (LA134_2==RCURLY||LA134_2==EQ||LA134_2==COMA||LA134_2==RPAREN||LA134_2==SEMI||LA134_2==PIPE||(LA134_2>=POINT && LA134_2<=NE)||LA134_2==48||(LA134_2>=57 && LA134_2<=58)||(LA134_2>=81 && LA134_2<=83)||(LA134_2>=100 && LA134_2<=105)) ) {
                    alt134=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1198:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 134, 2, input);

                    throw nvae;
                }
                }
                break;
            case 63:
                {
                alt134=3;
                }
                break;
            case 64:
            case 65:
                {
                alt134=4;
                }
                break;
            case 66:
                {
                alt134=5;
                }
                break;
            case 67:
                {
                alt134=6;
                }
                break;
            case 68:
                {
                alt134=7;
                }
                break;
            case 69:
                {
                alt134=8;
                }
                break;
            case 70:
                {
                alt134=9;
                }
                break;
            case 71:
                {
                alt134=10;
                }
                break;
            case 75:
                {
                alt134=11;
                }
                break;
            case 77:
                {
                alt134=12;
                }
                break;
            case STRING:
            case INT:
            case FLOAT:
            case 78:
            case 79:
                {
                alt134=13;
                }
                break;
            case 80:
                {
                alt134=14;
                }
                break;
            case SHARP:
                {
                alt134=15;
                }
                break;
            case 85:
                {
                int LA134_16 = input.LA(2);

                if ( (LA134_16==LPAREN) ) {
                    alt134=19;
                }
                else if ( (LA134_16==LCURLY) ) {
                    alt134=16;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1198:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 134, 16, input);

                    throw nvae;
                }
                }
                break;
            case 86:
                {
                int LA134_17 = input.LA(2);

                if ( (LA134_17==LPAREN) ) {
                    alt134=19;
                }
                else if ( (LA134_17==LCURLY) ) {
                    alt134=16;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1198:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 134, 17, input);

                    throw nvae;
                }
                }
                break;
            case 87:
                {
                int LA134_18 = input.LA(2);

                if ( (LA134_18==LPAREN) ) {
                    alt134=19;
                }
                else if ( (LA134_18==LCURLY) ) {
                    alt134=16;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1198:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 134, 18, input);

                    throw nvae;
                }
                }
                break;
            case 88:
                {
                int LA134_19 = input.LA(2);

                if ( (LA134_19==LPAREN) ) {
                    alt134=19;
                }
                else if ( (LA134_19==LCURLY) ) {
                    alt134=16;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1198:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 134, 19, input);

                    throw nvae;
                }
                }
                break;
            case 89:
                {
                int LA134_20 = input.LA(2);

                if ( (LA134_20==LCURLY) ) {
                    alt134=17;
                }
                else if ( (LA134_20==LPAREN) ) {
                    alt134=19;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1198:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 134, 20, input);

                    throw nvae;
                }
                }
                break;
            case 90:
                {
                alt134=18;
                }
                break;
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
                {
                alt134=19;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1198:4: ( ( LPAREN ret= oclExpression RPAREN ) | ret= variableExp | ret= thisModuleExp | ret= thisNodeExp | ret= thisEqualExp | ret= thisWeightExp | ret= thisSimExp | ret= thisInstancesExp | ret= summationExp | ret= thisEqualModelExp | ret= superExp | ret= oclUndefinedExp | ret= primitiveExp | ret= ifExp | ret= enumLiteralExp | ret= collectionExp | ret= mapExp | ret= tupleExp | ret= oclType )", 134, 0, input);

                throw nvae;
            }

            switch (alt134) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:5: ( LPAREN ret= oclExpression RPAREN )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:5: ( LPAREN ret= oclExpression RPAREN )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:6: LPAREN ret= oclExpression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_oclExpression6818); 
                    pushFollow(FOLLOW_oclExpression_in_primary_oclExpression6822);
                    ret=oclExpression();
                    _fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_oclExpression6824); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:40: ret= variableExp
                    {
                    pushFollow(FOLLOW_variableExp_in_primary_oclExpression6830);
                    ret=variableExp();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:57: ret= thisModuleExp
                    {
                    pushFollow(FOLLOW_thisModuleExp_in_primary_oclExpression6835);
                    ret=thisModuleExp();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:76: ret= thisNodeExp
                    {
                    pushFollow(FOLLOW_thisNodeExp_in_primary_oclExpression6840);
                    ret=thisNodeExp();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:93: ret= thisEqualExp
                    {
                    pushFollow(FOLLOW_thisEqualExp_in_primary_oclExpression6845);
                    ret=thisEqualExp();
                    _fsp--;


                    }
                    break;
                case 6 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:111: ret= thisWeightExp
                    {
                    pushFollow(FOLLOW_thisWeightExp_in_primary_oclExpression6850);
                    ret=thisWeightExp();
                    _fsp--;


                    }
                    break;
                case 7 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:130: ret= thisSimExp
                    {
                    pushFollow(FOLLOW_thisSimExp_in_primary_oclExpression6855);
                    ret=thisSimExp();
                    _fsp--;


                    }
                    break;
                case 8 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:146: ret= thisInstancesExp
                    {
                    pushFollow(FOLLOW_thisInstancesExp_in_primary_oclExpression6860);
                    ret=thisInstancesExp();
                    _fsp--;


                    }
                    break;
                case 9 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:168: ret= summationExp
                    {
                    pushFollow(FOLLOW_summationExp_in_primary_oclExpression6865);
                    ret=summationExp();
                    _fsp--;


                    }
                    break;
                case 10 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:186: ret= thisEqualModelExp
                    {
                    pushFollow(FOLLOW_thisEqualModelExp_in_primary_oclExpression6870);
                    ret=thisEqualModelExp();
                    _fsp--;


                    }
                    break;
                case 11 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:209: ret= superExp
                    {
                    pushFollow(FOLLOW_superExp_in_primary_oclExpression6875);
                    ret=superExp();
                    _fsp--;


                    }
                    break;
                case 12 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:223: ret= oclUndefinedExp
                    {
                    pushFollow(FOLLOW_oclUndefinedExp_in_primary_oclExpression6880);
                    ret=oclUndefinedExp();
                    _fsp--;


                    }
                    break;
                case 13 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:244: ret= primitiveExp
                    {
                    pushFollow(FOLLOW_primitiveExp_in_primary_oclExpression6885);
                    ret=primitiveExp();
                    _fsp--;


                    }
                    break;
                case 14 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:262: ret= ifExp
                    {
                    pushFollow(FOLLOW_ifExp_in_primary_oclExpression6890);
                    ret=ifExp();
                    _fsp--;


                    }
                    break;
                case 15 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:273: ret= enumLiteralExp
                    {
                    pushFollow(FOLLOW_enumLiteralExp_in_primary_oclExpression6895);
                    ret=enumLiteralExp();
                    _fsp--;


                    }
                    break;
                case 16 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:293: ret= collectionExp
                    {
                    pushFollow(FOLLOW_collectionExp_in_primary_oclExpression6900);
                    ret=collectionExp();
                    _fsp--;


                    }
                    break;
                case 17 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:312: ret= mapExp
                    {
                    pushFollow(FOLLOW_mapExp_in_primary_oclExpression6905);
                    ret=mapExp();
                    _fsp--;


                    }
                    break;
                case 18 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:324: ret= tupleExp
                    {
                    pushFollow(FOLLOW_tupleExp_in_primary_oclExpression6910);
                    ret=tupleExp();
                    _fsp--;


                    }
                    break;
                case 19 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1198:338: ret= oclType
                    {
                    pushFollow(FOLLOW_oclType_in_primary_oclExpression6915);
                    ret=oclType();
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
    // $ANTLR end primary_oclExpression


    protected DFA122 dfa122 = new DFA122(this);
    static final String DFA122_eotS =
        "\11\uffff";
    static final String DFA122_eofS =
        "\11\uffff";
    static final String DFA122_minS =
        "\1\4\1\17\1\uffff\1\4\1\13\1\uffff\1\4\1\uffff\1\13";
    static final String DFA122_maxS =
        "\1\114\1\17\1\uffff\1\143\1\151\1\uffff\1\143\1\uffff\1\151";
    static final String DFA122_acceptS =
        "\2\uffff\1\2\2\uffff\1\3\1\uffff\1\1\1\uffff";
    static final String DFA122_specialS =
        "\11\uffff}>";
    static final String[] DFA122_transitionS = {
            "\1\1\107\uffff\1\2",
            "\1\3",
            "",
            "\1\4\3\5\7\uffff\2\5\4\uffff\1\5\2\uffff\1\5\46\uffff\11\5\3"+
            "\uffff\1\5\1\uffff\4\5\3\uffff\20\5",
            "\1\5\1\uffff\1\6\2\uffff\1\5\2\uffff\1\5\1\7\1\uffff\13\5\103"+
            "\uffff\6\5",
            "",
            "\1\10\3\5\7\uffff\1\5\5\uffff\1\5\2\uffff\1\5\46\uffff\11\5"+
            "\3\uffff\1\5\1\uffff\4\5\3\uffff\20\5",
            "",
            "\1\5\1\uffff\1\6\2\uffff\1\5\2\uffff\1\5\1\7\1\uffff\13\5\103"+
            "\uffff\6\5"
    };

    static final short[] DFA122_eot = DFA.unpackEncodedString(DFA122_eotS);
    static final short[] DFA122_eof = DFA.unpackEncodedString(DFA122_eofS);
    static final char[] DFA122_min = DFA.unpackEncodedStringToUnsignedChars(DFA122_minS);
    static final char[] DFA122_max = DFA.unpackEncodedStringToUnsignedChars(DFA122_maxS);
    static final short[] DFA122_accept = DFA.unpackEncodedString(DFA122_acceptS);
    static final short[] DFA122_special = DFA.unpackEncodedString(DFA122_specialS);
    static final short[][] DFA122_transition;

    static {
        int numStates = DFA122_transitionS.length;
        DFA122_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA122_transition[i] = DFA.unpackEncodedString(DFA122_transitionS[i]);
        }
    }

    class DFA122 extends DFA {

        public DFA122(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 122;
            this.eot = DFA122_eot;
            this.eof = DFA122_eof;
            this.min = DFA122_min;
            this.max = DFA122_max;
            this.accept = DFA122_accept;
            this.special = DFA122_special;
            this.transition = DFA122_transition;
        }
        public String getDescription() {
            return "1110:192: (ret= iteratorExp[opName, ret, firstToken] | ret= iterateExp[opName, ret, firstToken] | ret= collectionOperationCallExp[opName, ret, firstToken] )";
        }
    }
 

    public static final BitSet FOLLOW_matcher_in_main46 = new BitSet(new long[]{0x0000000000000000L});
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
    public static final BitSet FOLLOW_103_in_identifierOrKeyword427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_identifierOrKeyword432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_identifierOrKeyword437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_matcher573 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_matcher577 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_matcher581 = new BitSet(new long[]{0x001E380000000200L,0x0000000000000400L});
    public static final BitSet FOLLOW_matcherRef_in_matcher589 = new BitSet(new long[]{0x001E380000000200L,0x0000000000000400L});
    public static final BitSet FOLLOW_matcherRef_in_matcher597 = new BitSet(new long[]{0x001E380000000200L,0x0000000000000400L});
    public static final BitSet FOLLOW_method_in_matcher611 = new BitSet(new long[]{0x001E380000000200L});
    public static final BitSet FOLLOW_method_in_matcher619 = new BitSet(new long[]{0x001E380000000200L});
    public static final BitSet FOLLOW_modelsBlock_in_matcher635 = new BitSet(new long[]{0x0000100000000200L});
    public static final BitSet FOLLOW_modelsFlowsBlock_in_matcher657 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RCURLY_in_matcher675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_modelsBlock707 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_modelsBlock709 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_model_in_modelsBlock717 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_model_in_modelsBlock725 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_RCURLY_in_modelsBlock737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_modelsFlowsBlock769 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_modelsFlowsBlock771 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_methodCall_in_modelsFlowsBlock779 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_methodCall_in_modelsFlowsBlock787 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_RCURLY_in_modelsFlowsBlock799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_weightedModelExp_in_modelFlowExpression834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodCall_in_modelFlowExpression839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mappingModelRefExp_in_modelFlowExpression844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatSymbol_in_weightedModelExp879 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_weightedModelExp883 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_modelFlowExpression_in_weightedModelExp887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mappingModel_in_methodCall927 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_methodCall931 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_methodCall947 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LSQUARE_in_methodCall951 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_modelFlowExpression_in_methodCall957 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_COMA_in_methodCall964 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_modelFlowExpression_in_methodCall969 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_RSQUARE_in_methodCall978 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_LPAREN_in_methodCall982 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_modelRefExp_in_methodCall988 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_methodCall995 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_modelRefExp_in_methodCall1000 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_methodCall1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_modelRefExp1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_mappingModelRefExp1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_matcher_in_mElement1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_mElement1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createEqual_in_method1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simEqual_in_method1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aggrEqual_in_method1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selEqual_in_method1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_externalMethod_in_method1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_createEqual1221 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_createEqual1225 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_createEqual1229 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_model_in_createEqual1235 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_createEqual1242 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_model_in_createEqual1247 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_createEqual1257 = new BitSet(new long[]{0x0000C00000000100L});
    public static final BitSet FOLLOW_46_in_createEqual1261 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_createEqual1263 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_createEqual1271 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_createEqual1278 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_createEqual1283 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_createEqual1295 = new BitSet(new long[]{0x0000800000000100L});
    public static final BitSet FOLLOW_47_in_createEqual1309 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_createEqual1311 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_javaLibraryRef_in_createEqual1319 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_createEqual1326 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_javaLibraryRef_in_createEqual1331 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_createEqual1343 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_createEqual1355 = new BitSet(new long[]{0x0061000000000200L});
    public static final BitSet FOLLOW_inPattern_in_createEqual1361 = new BitSet(new long[]{0x0001000000000200L});
    public static final BitSet FOLLOW_48_in_createEqual1367 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_createEqual1369 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_createEqual1377 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_createEqual1385 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_RCURLY_in_createEqual1397 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RCURLY_in_createEqual1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_simEqual1443 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simEqual1447 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_simEqual1451 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_model_in_simEqual1457 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_simEqual1464 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_model_in_simEqual1469 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_simEqual1479 = new BitSet(new long[]{0x0000C00000000100L});
    public static final BitSet FOLLOW_46_in_simEqual1483 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_simEqual1485 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_simEqual1493 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_simEqual1500 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_simEqual1505 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_simEqual1517 = new BitSet(new long[]{0x0000800000000100L});
    public static final BitSet FOLLOW_47_in_simEqual1531 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_simEqual1533 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_javaLibraryRef_in_simEqual1541 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_simEqual1548 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_javaLibraryRef_in_simEqual1553 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_simEqual1565 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_simEqual1577 = new BitSet(new long[]{0x0461000000000000L});
    public static final BitSet FOLLOW_inPattern_in_simEqual1583 = new BitSet(new long[]{0x0401000000000000L});
    public static final BitSet FOLLOW_48_in_simEqual1589 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_simEqual1591 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_simEqual1599 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_simEqual1607 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_RCURLY_in_simEqual1619 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_sim_in_simEqual1633 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RCURLY_in_simEqual1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_aggrEqual1671 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_aggrEqual1675 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_aggrEqual1679 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_model_in_aggrEqual1685 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_aggrEqual1692 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_model_in_aggrEqual1697 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_aggrEqual1707 = new BitSet(new long[]{0x0000C00000000100L});
    public static final BitSet FOLLOW_46_in_aggrEqual1711 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_aggrEqual1713 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_aggrEqual1721 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_aggrEqual1728 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_aggrEqual1733 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_aggrEqual1745 = new BitSet(new long[]{0x0000800000000100L});
    public static final BitSet FOLLOW_47_in_aggrEqual1759 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_aggrEqual1761 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_javaLibraryRef_in_aggrEqual1769 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_aggrEqual1776 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_javaLibraryRef_in_aggrEqual1781 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_aggrEqual1793 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_aggrEqual1805 = new BitSet(new long[]{0x0461000000000000L});
    public static final BitSet FOLLOW_inPattern_in_aggrEqual1811 = new BitSet(new long[]{0x0401000000000000L});
    public static final BitSet FOLLOW_48_in_aggrEqual1817 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_aggrEqual1819 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_aggrEqual1827 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_aggrEqual1835 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_RCURLY_in_aggrEqual1847 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_sim_in_aggrEqual1861 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RCURLY_in_aggrEqual1867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_selEqual1899 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_selEqual1903 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_selEqual1907 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_model_in_selEqual1913 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_selEqual1920 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_model_in_selEqual1925 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_selEqual1935 = new BitSet(new long[]{0x0000C00000000100L});
    public static final BitSet FOLLOW_46_in_selEqual1939 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_selEqual1941 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_selEqual1949 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_selEqual1956 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_selEqual1961 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_selEqual1973 = new BitSet(new long[]{0x0000800000000100L});
    public static final BitSet FOLLOW_47_in_selEqual1987 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_selEqual1989 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_javaLibraryRef_in_selEqual1997 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_selEqual2004 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_javaLibraryRef_in_selEqual2009 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_selEqual2021 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_selEqual2033 = new BitSet(new long[]{0x0061000000000200L});
    public static final BitSet FOLLOW_inPattern_in_selEqual2039 = new BitSet(new long[]{0x0001000000000200L});
    public static final BitSet FOLLOW_48_in_selEqual2045 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_selEqual2047 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_selEqual2055 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_selEqual2063 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_RCURLY_in_selEqual2075 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RCURLY_in_selEqual2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_externalMethod2121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_externalMethod2125 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LSQUARE_in_externalMethod2129 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_mappingModel_in_externalMethod2135 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_COMA_in_externalMethod2142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_mappingModel_in_externalMethod2147 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_RSQUARE_in_externalMethod2156 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_externalMethod2158 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_model_in_externalMethod2164 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_externalMethod2171 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_model_in_externalMethod2176 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_externalMethod2186 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_46_in_externalMethod2190 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_externalMethod2192 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_externalMethod2200 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_externalMethod2207 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_externalMethod2212 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_externalMethod2224 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_externalMethod2238 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_externalMethod2240 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_javaLibraryRef_in_externalMethod2248 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_externalMethod2255 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_javaLibraryRef_in_externalMethod2260 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_externalMethod2272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_inPattern2316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inPatternElement_in_inPattern2324 = new BitSet(new long[]{0x0040000000002002L});
    public static final BitSet FOLLOW_COMA_in_inPattern2331 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inPatternElement_in_inPattern2336 = new BitSet(new long[]{0x0040000000002002L});
    public static final BitSet FOLLOW_54_in_inPattern2359 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_inPattern2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_equalInPattern2411 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_equalInPattern2413 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_equalMetaElement_in_equalInPattern2417 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_equalInPattern2421 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_equalInPattern2423 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_equalMetaElement_in_equalInPattern2427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleInPatternElement_in_inPatternElement2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2497 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_simpleInPatternElement2501 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_simpleInPatternElement2505 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_simpleInPatternElement2511 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2517 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_COMA_in_simpleInPatternElement2524 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleInPatternElement2529 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_58_in_sim2579 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_sim2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_outPattern2617 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_outPatternElement_in_outPattern2625 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_COMA_in_outPattern2632 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_outPatternElement_in_outPattern2637 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_simpleOutPatternElement_in_outPatternElement2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2714 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_simpleOutPatternElement2718 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_simpleOutPatternElement2722 = new BitSet(new long[]{0x1200000000008002L});
    public static final BitSet FOLLOW_57_in_simpleOutPatternElement2728 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2732 = new BitSet(new long[]{0x1000000000008002L});
    public static final BitSet FOLLOW_60_in_simpleOutPatternElement2748 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleOutPatternElement2752 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_LPAREN_in_simpleOutPatternElement2768 = new BitSet(new long[]{0xFFFFFC0000010010L,0x000003FFFFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_simpleOutPatternElement2776 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_simpleOutPatternElement2783 = new BitSet(new long[]{0xFFFFFC0000000010L,0x000003FFFFFFFFFFL});
    public static final BitSet FOLLOW_binding_in_simpleOutPatternElement2788 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_simpleOutPatternElement2800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_binding2844 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_LARROW_in_binding2848 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_binding2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ruleVariableDeclaration2888 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_ruleVariableDeclaration2892 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_ruleVariableDeclaration2896 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_ruleVariableDeclaration2900 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_ruleVariableDeclaration2904 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_SEMI_in_ruleVariableDeclaration2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inputModel_in_model2943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mappingModel_in_model2948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_weavingModel_in_model2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_inputModel2988 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_inputModel2992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_inputModel2996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_mappingModel3032 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COLON_in_mappingModel3038 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_mappingModel3040 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_mappingModel3042 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inputModel_in_mappingModel3046 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COMA_in_mappingModel3050 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inputModel_in_mappingModel3054 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_mappingModel3058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_weavingModel3102 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_weavingModel3106 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_weavingModel3108 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_weavingModel3110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_referenceModel_in_weavingModel3114 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_weavingModel3118 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_weavingModel3120 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_inputModel_in_weavingModel3126 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_weavingModel3133 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inputModel_in_weavingModel3138 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_weavingModel3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_referenceModel3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_metaElement3218 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_EXCL_in_metaElement3222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_metaElement3226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_equalMetaElement3262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_5_in_oclExpression3298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letExp_in_oclExpression3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_thisModuleExp3335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thisRightExp_in_thisNodeExp3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thisLeftExp_in_thisNodeExp3375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_thisRightExp3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_thisLeftExp3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_thisEqualExp3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_thisWeightExp3504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_thisSimExp3536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_thisInstancesExp3568 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_thisInstancesExp3570 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_thisInstancesExp3574 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_thisInstancesExp3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_summationExp3610 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_summationExp3612 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_summationExp3616 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_summationExp3620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_thisEqualModelExp3652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aTLLibraryRef_in_libraryRef3687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_javaLibraryRef_in_libraryRef3692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aMLLibraryRef_in_libraryRef3697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_aTLLibraryRef3730 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_aTLLibraryRef3732 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_aTLLibraryRef3734 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_aTLLibraryRef3738 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COMA_in_aTLLibraryRef3742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_aTLLibraryRef3744 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_aTLLibraryRef3746 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_aTLLibraryRef3750 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_aTLLibraryRef3754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_javaLibraryRef3786 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_javaLibraryRef3788 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_javaLibraryRef3790 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_javaLibraryRef3794 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COMA_in_javaLibraryRef3798 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_javaLibraryRef3800 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_javaLibraryRef3802 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_javaLibraryRef3806 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_javaLibraryRef3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_aMLLibraryRef3842 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_aMLLibraryRef3844 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_aMLLibraryRef3846 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_aMLLibraryRef3850 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COMA_in_aMLLibraryRef3854 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_aMLLibraryRef3856 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_aMLLibraryRef3858 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_aMLLibraryRef3862 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_aMLLibraryRef3866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_matcherRef3898 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_matcherRef3902 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_SEMI_in_matcherRef3906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableExp3940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_superExp3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_iteratorExp4009 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_iteratorExp4013 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iteratorExp4019 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_COMA_in_iteratorExp4026 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iteratorExp4031 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_PIPE_in_iteratorExp4040 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_iteratorExp4046 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_iteratorExp4052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_iterateExp4085 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_iterateExp4087 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iterateExp4093 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_COMA_in_iterateExp4100 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_iterator_in_iterateExp4105 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_SEMI_in_iterateExp4114 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclaration_in_iterateExp4118 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_PIPE_in_iterateExp4122 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_iterateExp4128 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_iterateExp4134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_collectionOperationCallExp4169 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionOperationCallExp4173 = new BitSet(new long[]{0x80000000012180F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_collectionOperationCallExp4179 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_collectionOperationCallExp4186 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_collectionOperationCallExp4191 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_collectionOperationCallExp4201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_operationCallExp4236 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_operationCallExp4240 = new BitSet(new long[]{0x80000000012180F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_operationCallExp4246 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_operationCallExp4253 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_operationCallExp4258 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_operationCallExp4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_navigationOrAttributeCallExp4303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_iterator4368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_oclUndefinedExp4402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericExp_in_primitiveExp4437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanExp_in_primitiveExp4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExp_in_primitiveExp4447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerExp_in_numericExp4483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realExp_in_numericExp4488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_booleanExp4523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_booleanExp4530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_integerExp4568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatSymbol_in_realExp4604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_stringExp4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ifExp4674 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_ifExp4678 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_ifExp4682 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_ifExp4688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_ifExp4694 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_ifExp4700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_ifExp4706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_letExp4738 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDeclaration_in_letExp4742 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_letExp4746 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_letExp4752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableDeclaration4790 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_variableDeclaration4794 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_variableDeclaration4798 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_variableDeclaration4802 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_variableDeclaration4806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_enumLiteralExp4840 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_enumLiteralExp4844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bagExp_in_collectionExp4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setExp_in_collectionExp4886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orderedSetExp_in_collectionExp4891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceExp_in_collectionExp4896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_bagExp4929 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_bagExp4931 = new BitSet(new long[]{0x80000000012082F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_bagExp4937 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_bagExp4944 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_bagExp4949 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_bagExp4959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_setExp4991 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_setExp4993 = new BitSet(new long[]{0x80000000012082F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_setExp4999 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_setExp5006 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_setExp5011 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_setExp5021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_orderedSetExp5053 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_orderedSetExp5055 = new BitSet(new long[]{0x80000000012082F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_orderedSetExp5061 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_orderedSetExp5068 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_orderedSetExp5073 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_orderedSetExp5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_sequenceExp5115 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_sequenceExp5117 = new BitSet(new long[]{0x80000000012082F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_sequenceExp5123 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_sequenceExp5130 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_sequenceExp5135 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_sequenceExp5145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_mapExp5177 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_mapExp5179 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_mapElement_in_mapExp5185 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_mapExp5192 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_mapElement_in_mapExp5197 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_mapExp5207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_mapElement5239 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_mapElement5243 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COMA_in_mapElement5247 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_mapElement5251 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_mapElement5255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_tupleExp5287 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_tupleExp5289 = new BitSet(new long[]{0xFFFFFC0000000210L,0x000003FFFFFFFFFFL});
    public static final BitSet FOLLOW_tuplePart_in_tupleExp5295 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_tupleExp5302 = new BitSet(new long[]{0xFFFFFC0000000010L,0x000003FFFFFFFFFFL});
    public static final BitSet FOLLOW_tuplePart_in_tupleExp5307 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RCURLY_in_tupleExp5317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tuplePart5351 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COLON_in_tuplePart5357 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_tuplePart5361 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tuplePart5375 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_tuplePart5379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_metaElement_in_oclType5416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclAnyType_in_oclType5421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleType_in_oclType5426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapType_in_oclType5431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitive_in_oclType5436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_oclType5441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclType_abstractContents_in_oclType5446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_oclAnyType5479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_tupleType5511 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_tupleType5513 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_tupleTypeAttribute_in_tupleType5519 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COMA_in_tupleType5526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_tupleTypeAttribute_in_tupleType5531 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_RPAREN_in_tupleType5541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tupleTypeAttribute5575 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_tupleTypeAttribute5579 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_tupleTypeAttribute5583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_mapType5617 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_mapType5619 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_mapType5623 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COMA_in_mapType5627 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_mapType5631 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_mapType5635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericType_in_primitive5670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanType_in_primitive5675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringType_in_primitive5680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerType_in_numericType5716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realType_in_numericType5721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_integerType5754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_realType5786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_booleanType5818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_stringType5850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bagType_in_collectionType5885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setType_in_collectionType5890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orderedSetType_in_collectionType5895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceType_in_collectionType5900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_abstractContents_in_collectionType5905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_bagType5938 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_bagType5940 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_bagType5944 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_bagType5948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_setType5980 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_setType5982 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_setType5986 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_setType5990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_orderedSetType6022 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_orderedSetType6024 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_orderedSetType6028 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_orderedSetType6032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_sequenceType6064 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_sequenceType6066 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_sequenceType6070 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_sequenceType6074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_oclExpression_in_priority_06108 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_POINT_in_priority_06113 = new BitSet(new long[]{0xFFFFFC0000000010L,0x000003FFFFFFFFFFL});
    public static final BitSet FOLLOW_operationCallExp_in_priority_06120 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_navigationOrAttributeCallExp_in_priority_06127 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_RARROW_in_priority_06135 = new BitSet(new long[]{0x0000000000000010L,0x0000000000001000L});
    public static final BitSet FOLLOW_iteratorExp_in_priority_06142 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_iterateExp_in_priority_06149 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_collectionOperationCallExp_in_priority_06156 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_99_in_priority_16196 = new BitSet(new long[]{0x80000000002080F0L,0x00000007FFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_16203 = new BitSet(new long[]{0x80000000002080F0L,0x00000007FFE1E8FFL});
    public static final BitSet FOLLOW_priority_0_in_priority_16208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_priority_16216 = new BitSet(new long[]{0x80000000002080F0L,0x00000007FFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_16223 = new BitSet(new long[]{0x80000000002080F0L,0x00000007FFE1E8FFL});
    public static final BitSet FOLLOW_priority_0_in_priority_16228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_0_in_priority_16238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_1_in_priority_26273 = new BitSet(new long[]{0x0000000006000002L,0x0000003000000000L});
    public static final BitSet FOLLOW_STAR_in_priority_26278 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_26285 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_1_in_priority_26290 = new BitSet(new long[]{0x0000000006000002L,0x0000003000000000L});
    public static final BitSet FOLLOW_SLASH_in_priority_26298 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_26305 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_1_in_priority_26310 = new BitSet(new long[]{0x0000000006000002L,0x0000003000000000L});
    public static final BitSet FOLLOW_100_in_priority_26318 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_26325 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_1_in_priority_26330 = new BitSet(new long[]{0x0000000006000002L,0x0000003000000000L});
    public static final BitSet FOLLOW_101_in_priority_26338 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_26345 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_1_in_priority_26350 = new BitSet(new long[]{0x0000000006000002L,0x0000003000000000L});
    public static final BitSet FOLLOW_priority_2_in_priority_36391 = new BitSet(new long[]{0x0000000009000002L});
    public static final BitSet FOLLOW_PLUS_in_priority_36396 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_36403 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_2_in_priority_36408 = new BitSet(new long[]{0x0000000009000002L});
    public static final BitSet FOLLOW_MINUS_in_priority_36416 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_36423 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_2_in_priority_36428 = new BitSet(new long[]{0x0000000009000002L});
    public static final BitSet FOLLOW_priority_3_in_priority_46469 = new BitSet(new long[]{0x00000001F0000802L});
    public static final BitSet FOLLOW_EQ_in_priority_46474 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_46481 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_3_in_priority_46486 = new BitSet(new long[]{0x00000001F0000802L});
    public static final BitSet FOLLOW_GT_in_priority_46494 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_46501 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_3_in_priority_46506 = new BitSet(new long[]{0x00000001F0000802L});
    public static final BitSet FOLLOW_LT_in_priority_46514 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_46521 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_3_in_priority_46526 = new BitSet(new long[]{0x00000001F0000802L});
    public static final BitSet FOLLOW_GE_in_priority_46534 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_46541 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_3_in_priority_46546 = new BitSet(new long[]{0x00000001F0000802L});
    public static final BitSet FOLLOW_LE_in_priority_46554 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_46561 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_3_in_priority_46566 = new BitSet(new long[]{0x00000001F0000802L});
    public static final BitSet FOLLOW_NE_in_priority_46574 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_46581 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_3_in_priority_46586 = new BitSet(new long[]{0x00000001F0000802L});
    public static final BitSet FOLLOW_priority_4_in_priority_56627 = new BitSet(new long[]{0x0000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_102_in_priority_56632 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_56639 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_4_in_priority_56644 = new BitSet(new long[]{0x0000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_103_in_priority_56652 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_56659 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_4_in_priority_56664 = new BitSet(new long[]{0x0000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_104_in_priority_56672 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_56679 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_4_in_priority_56684 = new BitSet(new long[]{0x0000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_105_in_priority_56692 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_56699 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFE1E8FFL});
    public static final BitSet FOLLOW_priority_4_in_priority_56704 = new BitSet(new long[]{0x0000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_91_in_oclType_abstractContents6743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_collectionType_abstractContents6775 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionType_abstractContents6777 = new BitSet(new long[]{0x0000000000000010L,0x00000007FBE00000L});
    public static final BitSet FOLLOW_oclType_in_collectionType_abstractContents6781 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_collectionType_abstractContents6785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_oclExpression6818 = new BitSet(new long[]{0x80000000012080F0L,0x0000000FFFF1E8FFL});
    public static final BitSet FOLLOW_oclExpression_in_primary_oclExpression6822 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_oclExpression6824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExp_in_primary_oclExpression6830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thisModuleExp_in_primary_oclExpression6835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thisNodeExp_in_primary_oclExpression6840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thisEqualExp_in_primary_oclExpression6845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thisWeightExp_in_primary_oclExpression6850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thisSimExp_in_primary_oclExpression6855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thisInstancesExp_in_primary_oclExpression6860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_summationExp_in_primary_oclExpression6865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thisEqualModelExp_in_primary_oclExpression6870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_superExp_in_primary_oclExpression6875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclUndefinedExp_in_primary_oclExpression6880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveExp_in_primary_oclExpression6885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifExp_in_primary_oclExpression6890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumLiteralExp_in_primary_oclExpression6895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionExp_in_primary_oclExpression6900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapExp_in_primary_oclExpression6905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleExp_in_primary_oclExpression6910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclType_in_primary_oclExpression6915 = new BitSet(new long[]{0x0000000000000002L});

}