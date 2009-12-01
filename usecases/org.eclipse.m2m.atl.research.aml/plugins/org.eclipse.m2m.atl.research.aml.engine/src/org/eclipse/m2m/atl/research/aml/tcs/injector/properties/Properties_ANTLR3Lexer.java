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

// $ANTLR 3.0.1 C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g 2009-10-06 16:55:39
package org.eclipse.m2m.atl.research.aml.tcs.injector.properties;

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
public class Properties_ANTLR3Lexer extends Lexer {
    public static final int LT=37;
    public static final int STAR=32;
    public static final int LSQUARE=15;
    public static final int POINT=29;
    public static final int ESC=14;
    public static final int LARROW=41;
    public static final int EXCL=17;
    public static final int FLOAT=8;
    public static final int EOF=-1;
    public static final int LPAREN=19;
    public static final int RPAREN=20;
    public static final int NAME=4;
    public static final int SLASH=33;
    public static final int PLUS=34;
    public static final int PIPE=25;
    public static final int NL=9;
    public static final int DIGIT=11;
    public static final int EQ=35;
    public static final int COMMENT=42;
    public static final int NE=40;
    public static final int GE=38;
    public static final int SHARP=26;
    public static final int RARROW=30;
    public static final int EQUALEOL=5;
    public static final int LCURLY=21;
    public static final int INT=7;
    public static final int RSQUARE=16;
    public static final int MINUS=31;
    public static final int COMA=18;
    public static final int Tokens=43;
    public static final int SEMI=23;
    public static final int ALPHA=12;
    public static final int COLON=24;
    public static final int COLONCOLON=28;
    public static final int WS=10;
    public static final int SNAME=13;
    public static final int RCURLY=22;
    public static final int GT=36;
    public static final int QMARK=27;
    public static final int LE=39;
    public static final int STRING=6;
    
    
    	private void newline() {}
    
    	public TCSRuntime ei = null;
    
    	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    		ei.reportError((Exception)e);
    	}
    
    	public Token emit() {
    		ANTLR3LocationToken ret = null;
    
    		ret = new ANTLR3LocationToken(input, type, channel, tokenStartCharIndex, getCharIndex()-1);
    		ret.setLine(tokenStartLine);
    		ret.setText(text);
    	  	ret.setCharPositionInLine(tokenStartCharPositionInLine);
    		ret.setEndLine(getLine());
    		ret.setEndColumn(getCharPositionInLine());
    		emit(ret);
    
    		return ret;
    	}
    

    public Properties_ANTLR3Lexer() {;} 
    public Properties_ANTLR3Lexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g"; }

    // $ANTLR start NL
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:134:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:134:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:134:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\r') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='\n') ) {
                    alt1=1;
                }
                else {
                    alt1=3;}
            }
            else if ( (LA1_0=='\n') ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2=='\r') ) {
                    alt1=2;
                }
                else {
                    alt1=4;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("134:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:134:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:135:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:136:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:137:5: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

            newline();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NL

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:143:2: ( ( ' ' | '\\t' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:143:4: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start DIGIT
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:150:2: ( '0' .. '9' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:150:4: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end DIGIT

    // $ANTLR start ALPHA
    public final void mALPHA() throws RecognitionException {
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:155:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end ALPHA

    // $ANTLR start SNAME
    public final void mSNAME() throws RecognitionException {
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:169:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:169:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:169:4: ( ALPHA )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:169:5: ALPHA
            {
            mALPHA(); 

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:169:12: ( ALPHA | DIGIT )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')||(LA2_0>='\u00C0' && LA2_0<='\u00D6')||(LA2_0>='\u00D8' && LA2_0<='\u00F6')||(LA2_0>='\u00F8' && LA2_0<='\u00FF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end SNAME

    // $ANTLR start NAME
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:173:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:173:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:173:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='\"') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("173:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:174:4: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:176:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:177:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
                    loop3:
                    do {
                        int alt3=4;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( (LA3_0=='\n') ) {
                            alt3=2;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFE')) ) {
                            alt3=3;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:177:6: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:178:6: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:179:6: ~ ( '\\\\' | '\\\"' | '\\n' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match('\"'); 
                    setText(ei.unescapeString(getText(), 1));

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NAME

    // $ANTLR start INT
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:187:2: ( ( DIGIT )+ )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:187:4: ( DIGIT )+
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:187:4: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:187:5: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INT

    // $ANTLR start FLOAT
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:191:7: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:191:9: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:191:9: ( DIGIT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:191:9: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            match('.'); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:191:20: ( DIGIT )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:191:20: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOAT

    // $ANTLR start ESC
    public final void mESC() throws RecognitionException {
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:195:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:195:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:196:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            int alt12=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt12=1;
                }
                break;
            case 'r':
                {
                alt12=2;
                }
                break;
            case 't':
                {
                alt12=3;
                }
                break;
            case 'b':
                {
                alt12=4;
                }
                break;
            case 'f':
                {
                alt12=5;
                }
                break;
            case '\"':
                {
                alt12=6;
                }
                break;
            case '\'':
                {
                alt12=7;
                }
                break;
            case '\\':
                {
                alt12=8;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
                {
                alt12=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("196:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:196:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:197:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:198:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:199:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:200:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:201:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:202:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:203:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:204:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:204:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>='0' && LA11_0<='3')) ) {
                        alt11=1;
                    }
                    else if ( ((LA11_0>='4' && LA11_0<='7')) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("204:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:205:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:205:5: ( '0' .. '3' )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:205:6: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:206:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:210:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:210:7: ( '0' .. '7' )
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:210:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:211:6: ( '0' .. '7' )?
                                    int alt8=2;
                                    int LA8_0 = input.LA(1);

                                    if ( ((LA8_0>='0' && LA8_0<='7')) ) {
                                        alt8=1;
                                    }
                                    switch (alt8) {
                                        case 1 :
                                            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:215:8: '0' .. '7'
                                            {
                                            matchRange('0','7'); 

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:218:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:218:6: ( '4' .. '7' )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:218:7: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:219:5: ( ( '0' .. '7' ) )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:223:7: ( '0' .. '7' )
                                    {
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:223:7: ( '0' .. '7' )
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:223:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    
                    //					String s = getText();
                    //					int i;
                    //					int ret = 0;
                    //					String ans;
                    //					for (i=0; i<s.length(); ++i)
                    //						ret = ret*8 + s.charAt(i) - '0';
                    //					ans = String.valueOf((char) ret);
                    //					setText(ans);
                    				

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end ESC

    // $ANTLR start LSQUARE
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:241:2: ( '[' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:241:4: '['
            {
            match('['); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LSQUARE

    // $ANTLR start RSQUARE
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:249:2: ( ']' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:249:4: ']'
            {
            match(']'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RSQUARE

    // $ANTLR start EXCL
    public final void mEXCL() throws RecognitionException {
        try {
            int _type = EXCL;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:257:2: ( '!' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:257:4: '!'
            {
            match('!'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EXCL

    // $ANTLR start COMA
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:265:2: ( ',' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:265:4: ','
            {
            match(','); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMA

    // $ANTLR start LPAREN
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:273:2: ( '(' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:273:4: '('
            {
            match('('); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LPAREN

    // $ANTLR start RPAREN
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:281:2: ( ')' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:281:4: ')'
            {
            match(')'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RPAREN

    // $ANTLR start LCURLY
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:289:2: ( '{' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:289:4: '{'
            {
            match('{'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LCURLY

    // $ANTLR start RCURLY
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:297:2: ( '}' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:297:4: '}'
            {
            match('}'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RCURLY

    // $ANTLR start SEMI
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:305:2: ( ';' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:305:4: ';'
            {
            match(';'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMI

    // $ANTLR start COLON
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:313:2: ( ':' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:313:4: ':'
            {
            match(':'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLON

    // $ANTLR start PIPE
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:321:2: ( '|' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:321:4: '|'
            {
            match('|'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PIPE

    // $ANTLR start SHARP
    public final void mSHARP() throws RecognitionException {
        try {
            int _type = SHARP;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:329:2: ( '#' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:329:4: '#'
            {
            match('#'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SHARP

    // $ANTLR start QMARK
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:337:2: ( '?' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:337:4: '?'
            {
            match('?'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QMARK

    // $ANTLR start COLONCOLON
    public final void mCOLONCOLON() throws RecognitionException {
        try {
            int _type = COLONCOLON;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:345:2: ( '::' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:345:4: '::'
            {
            match("::"); 


                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLONCOLON

    // $ANTLR start POINT
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:353:2: ( '.' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:353:4: '.'
            {
            match('.'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end POINT

    // $ANTLR start RARROW
    public final void mRARROW() throws RecognitionException {
        try {
            int _type = RARROW;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:361:2: ( '->' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:361:4: '->'
            {
            match("->"); 


                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RARROW

    // $ANTLR start MINUS
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:369:2: ( '-' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:369:4: '-'
            {
            match('-'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MINUS

    // $ANTLR start STAR
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:377:2: ( '*' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:377:4: '*'
            {
            match('*'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STAR

    // $ANTLR start SLASH
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:385:2: ( '/' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:385:4: '/'
            {
            match('/'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SLASH

    // $ANTLR start PLUS
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:393:2: ( '+' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:393:4: '+'
            {
            match('+'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PLUS

    // $ANTLR start EQ
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:401:2: ( '=' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:401:4: '='
            {
            match('='); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQ

    // $ANTLR start GT
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:409:2: ( '>' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:409:4: '>'
            {
            match('>'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GT

    // $ANTLR start LT
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:417:2: ( '<' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:417:4: '<'
            {
            match('<'); 

                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LT

    // $ANTLR start GE
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:425:2: ( '>=' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:425:4: '>='
            {
            match(">="); 


                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GE

    // $ANTLR start LE
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:433:2: ( '<=' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:433:4: '<='
            {
            match("<="); 


                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LE

    // $ANTLR start NE
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:441:2: ( '<>' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:441:4: '<>'
            {
            match("<>"); 


                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NE

    // $ANTLR start LARROW
    public final void mLARROW() throws RecognitionException {
        try {
            int _type = LARROW;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:449:2: ( '<-' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:449:4: '<-'
            {
            match("<-"); 


                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LARROW

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:457:2: ( ( ( '#' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:457:4: ( ( '#' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:457:4: ( ( '#' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:457:5: ( '#' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:457:5: ( '#' (~ ( '\\r' | '\\n' ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:457:6: '#' (~ ( '\\r' | '\\n' ) )*
            {
            match('#'); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:457:10: (~ ( '\\r' | '\\n' ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFE')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:457:11: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }


                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMENT

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:2: ( ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:4: ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:4: ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:5: ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:5: ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:6: '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\''
            {
            match('\''); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:11: ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\'') ) {
                    alt15=2;
                }
                else if ( ((LA15_0>='\u0000' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='\uFFFE')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )
            	    int alt14=3;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0=='\\') ) {
            	        alt14=1;
            	    }
            	    else if ( (LA14_0=='\n') ) {
            	        alt14=2;
            	    }
            	    else if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFE')) ) {
            	        alt14=3;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("465:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )", 14, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:41: ( '\\\\' ~ '\\n' )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:41: ( '\\\\' ~ '\\n' )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:42: '\\\\' ~ '\\n'
            	            {
            	            match('\\'); 
            	            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFE') ) {
            	                input.consume();

            	            }
            	            else {
            	                MismatchedSetException mse =
            	                    new MismatchedSetException(null,input);
            	                recover(mse);    throw mse;
            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:57: '\\n'
            	            {
            	            match('\n'); 

            	            }
            	            break;
            	        case 3 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:465:63: ~ ( '\\\\' | '\\n' )
            	            {
            	            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	                input.consume();

            	            }
            	            else {
            	                MismatchedSetException mse =
            	                    new MismatchedSetException(null,input);
            	                recover(mse);    throw mse;
            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match('\''); 

            }


            }


                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start EQUALEOL
    public final void mEQUALEOL() throws RecognitionException {
        try {
            int _type = EQUALEOL;
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:473:2: ( ( ( '=' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:473:4: ( ( '=' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:473:4: ( ( '=' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:473:5: ( '=' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:473:5: ( '=' (~ ( '\\r' | '\\n' ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:473:6: '=' (~ ( '\\r' | '\\n' ) )*
            {
            match('='); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:473:10: (~ ( '\\r' | '\\n' ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\uFFFE')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:473:11: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }


                        
                    

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQUALEOL

    public void mTokens() throws RecognitionException {
        // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:8: ( NL | WS | NAME | INT | FLOAT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | SHARP | QMARK | COLONCOLON | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | COMMENT | STRING | EQUALEOL )
        int alt17=35;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:10: NL
                {
                mNL(); 

                }
                break;
            case 2 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:13: WS
                {
                mWS(); 

                }
                break;
            case 3 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:16: NAME
                {
                mNAME(); 

                }
                break;
            case 4 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:21: INT
                {
                mINT(); 

                }
                break;
            case 5 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:25: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 6 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:31: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 7 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:39: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 8 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:47: EXCL
                {
                mEXCL(); 

                }
                break;
            case 9 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:52: COMA
                {
                mCOMA(); 

                }
                break;
            case 10 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:57: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 11 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:64: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 12 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:71: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 13 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:78: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 14 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:85: SEMI
                {
                mSEMI(); 

                }
                break;
            case 15 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:90: COLON
                {
                mCOLON(); 

                }
                break;
            case 16 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:96: PIPE
                {
                mPIPE(); 

                }
                break;
            case 17 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:101: SHARP
                {
                mSHARP(); 

                }
                break;
            case 18 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:107: QMARK
                {
                mQMARK(); 

                }
                break;
            case 19 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:113: COLONCOLON
                {
                mCOLONCOLON(); 

                }
                break;
            case 20 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:124: POINT
                {
                mPOINT(); 

                }
                break;
            case 21 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:130: RARROW
                {
                mRARROW(); 

                }
                break;
            case 22 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:137: MINUS
                {
                mMINUS(); 

                }
                break;
            case 23 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:143: STAR
                {
                mSTAR(); 

                }
                break;
            case 24 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:148: SLASH
                {
                mSLASH(); 

                }
                break;
            case 25 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:154: PLUS
                {
                mPLUS(); 

                }
                break;
            case 26 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:159: EQ
                {
                mEQ(); 

                }
                break;
            case 27 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:162: GT
                {
                mGT(); 

                }
                break;
            case 28 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:165: LT
                {
                mLT(); 

                }
                break;
            case 29 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:168: GE
                {
                mGE(); 

                }
                break;
            case 30 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:171: LE
                {
                mLE(); 

                }
                break;
            case 31 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:174: NE
                {
                mNE(); 

                }
                break;
            case 32 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:177: LARROW
                {
                mLARROW(); 

                }
                break;
            case 33 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:184: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 34 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:192: STRING
                {
                mSTRING(); 

                }
                break;
            case 35 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:1:199: EQUALEOL
                {
                mEQUALEOL(); 

                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\4\uffff\1\33\11\uffff\1\36\1\uffff\1\40\2\uffff\1\42\3\uffff\1"+
        "\43\1\46\1\52\21\uffff";
    static final String DFA17_eofS =
        "\53\uffff";
    static final String DFA17_minS =
        "\1\11\3\uffff\1\56\11\uffff\1\72\1\uffff\1\0\2\uffff\1\76\3\uffff"+
        "\1\0\1\75\1\55\21\uffff";
    static final String DFA17_maxS =
        "\1\u00ff\3\uffff\1\71\11\uffff\1\72\1\uffff\1\ufffe\2\uffff\1\76"+
        "\3\uffff\1\ufffe\1\75\1\76\21\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\uffff\1\20\1\uffff\1\22\1\24\1\uffff\1\27\1\30\1\31\3"+
        "\uffff\1\42\1\4\1\5\1\23\1\17\1\41\1\21\1\25\1\26\1\32\1\43\1\35"+
        "\1\33\1\40\1\36\1\37\1\34";
    static final String DFA17_specialS =
        "\53\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\2\1\1\2\uffff\1\1\22\uffff\1\2\1\7\1\3\1\20\3\uffff\1\32"+
            "\1\11\1\12\1\24\1\26\1\10\1\23\1\22\1\25\12\4\1\16\1\15\1\31"+
            "\1\27\1\30\1\21\1\uffff\32\3\1\5\1\uffff\1\6\1\uffff\1\3\1\uffff"+
            "\32\3\1\13\1\17\1\14\102\uffff\27\3\1\uffff\37\3\1\uffff\10"+
            "\3",
            "",
            "",
            "",
            "\1\34\1\uffff\12\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\35",
            "",
            "\12\37\1\uffff\2\37\1\uffff\ufff1\37",
            "",
            "",
            "\1\41",
            "",
            "",
            "",
            "\12\44\1\uffff\2\44\1\uffff\ufff1\44",
            "\1\45",
            "\1\47\17\uffff\1\50\1\51",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( NL | WS | NAME | INT | FLOAT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | SHARP | QMARK | COLONCOLON | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | COMMENT | STRING | EQUALEOL );";
        }
    }
 

}