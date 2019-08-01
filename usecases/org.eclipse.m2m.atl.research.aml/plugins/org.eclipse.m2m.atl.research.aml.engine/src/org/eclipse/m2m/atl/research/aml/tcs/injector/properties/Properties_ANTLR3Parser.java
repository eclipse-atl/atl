/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
public class Properties_ANTLR3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "EQUALEOL", "STRING", "INT", "FLOAT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "LSQUARE", "RSQUARE", "EXCL", "COMA", "LPAREN", "RPAREN", "LCURLY", "RCURLY", "SEMI", "COLON", "PIPE", "SHARP", "QMARK", "COLONCOLON", "POINT", "RARROW", "MINUS", "STAR", "SLASH", "PLUS", "EQ", "GT", "LT", "GE", "LE", "NE", "LARROW", "COMMENT"
    };
    public static final int GE=38;
    public static final int LT=37;
    public static final int STAR=32;
    public static final int LSQUARE=15;
    public static final int SHARP=26;
    public static final int POINT=29;
    public static final int ESC=14;
    public static final int RARROW=30;
    public static final int EQUALEOL=5;
    public static final int LARROW=41;
    public static final int LCURLY=21;
    public static final int INT=7;
    public static final int FLOAT=8;
    public static final int EXCL=17;
    public static final int MINUS=31;
    public static final int RSQUARE=16;
    public static final int EOF=-1;
    public static final int COMA=18;
    public static final int SEMI=23;
    public static final int ALPHA=12;
    public static final int LPAREN=19;
    public static final int COLON=24;
    public static final int COLONCOLON=28;
    public static final int RPAREN=20;
    public static final int NAME=4;
    public static final int SLASH=33;
    public static final int WS=10;
    public static final int SNAME=13;
    public static final int RCURLY=22;
    public static final int GT=36;
    public static final int PLUS=34;
    public static final int PIPE=25;
    public static final int NL=9;
    public static final int DIGIT=11;
    public static final int EQ=35;
    public static final int COMMENT=42;
    public static final int QMARK=27;
    public static final int LE=39;
    public static final int STRING=6;
    public static final int NE=40;

        public Properties_ANTLR3Parser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g"; }


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
        Properties_ANTLR3Lexer lex = new 
        Properties_ANTLR3Lexer(input);
    						CommonTokenStream tokens = new CommonTokenStream(lex);
    						tokens.discardTokenType(WS);
    						tokens.discardTokenType(COMMENT);
    						tokens.discardTokenType(NL);
    						
        Properties_ANTLR3Parser parser = new 
        Properties_ANTLR3Parser(tokens);
    						parser.main();
    					}



    // $ANTLR start main
    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:60:1: main returns [Object ret2] : ( (ret= propertiesFile ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:61:2: ( ( (ret= propertiesFile ) EOF ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:61:4: ( (ret= propertiesFile ) EOF )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:61:4: ( (ret= propertiesFile ) EOF )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:61:5: (ret= propertiesFile ) EOF
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:61:5: (ret= propertiesFile )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:61:6: ret= propertiesFile
            {
            pushFollow(FOLLOW_propertiesFile_in_main46);
            ret=propertiesFile();
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:68:1: identifier returns [Object ret2] : ast= NAME ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:69:2: (ast= NAME )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:69:4: ast= NAME
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


    // $ANTLR start equalEOLSymbol
    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:76:1: equalEOLSymbol returns [Object ret2] : ast= EQUALEOL ;
    public final Object equalEOLSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:77:2: (ast= EQUALEOL )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:77:4: ast= EQUALEOL
            {
            ast=(Token)input.LT(1);
            match(input,EQUALEOL,FOLLOW_EQUALEOL_in_equalEOLSymbol116); 
            ret = ast.getText().substring(1); ei.setToken((Object)ast);

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
    // $ANTLR end equalEOLSymbol


    // $ANTLR start stringSymbol
    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:84:1: stringSymbol returns [Object ret2] : ast= STRING ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:85:2: (ast= STRING )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:85:4: ast= STRING
            {
            ast=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_stringSymbol150); 
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:92:1: integerSymbol returns [Object ret2] : ast= INT ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:93:2: (ast= INT )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:93:4: ast= INT
            {
            ast=(Token)input.LT(1);
            match(input,INT,FOLLOW_INT_in_integerSymbol184); 
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
    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:100:1: floatSymbol returns [Object ret2] : ast= FLOAT ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:101:2: (ast= FLOAT )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:101:4: ast= FLOAT
            {
            ast=(Token)input.LT(1);
            match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol218); 
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


    // $ANTLR start propertiesFile
    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:108:1: propertiesFile returns [Object ret2] : ( ( (temp= property ( (temp= property ) )* ) )? ) ;
    public final Object propertiesFile() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("PropertiesFile", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:2: ( ( ( (temp= property ( (temp= property ) )* ) )? ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:4: ( ( (temp= property ( (temp= property ) )* ) )? )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:4: ( ( (temp= property ( (temp= property ) )* ) )? )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:5: ( (temp= property ( (temp= property ) )* ) )?
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:5: ( (temp= property ( (temp= property ) )* ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:6: (temp= property ( (temp= property ) )* )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:6: (temp= property ( (temp= property ) )* )
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:7: temp= property ( (temp= property ) )*
                    {
                    pushFollow(FOLLOW_property_in_propertiesFile255);
                    temp=property();
                    _fsp--;

                    ei.set(ret, "properties", temp);
                    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:56: ( (temp= property ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==NAME) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:57: (temp= property )
                    	    {
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:57: (temp= property )
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:109:58: temp= property
                    	    {
                    	    pushFollow(FOLLOW_property_in_propertiesFile263);
                    	    temp=property();
                    	    _fsp--;

                    	    ei.set(ret, "properties", temp);

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


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
    // $ANTLR end propertiesFile


    // $ANTLR start property
    // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:119:1: property returns [Object ret2] : (temp= identifier temp= equalEOLSymbol ) ;
    public final Object property() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(backtracking==0) ? ei.create("Property", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:120:2: ( (temp= identifier temp= equalEOLSymbol ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:120:4: (temp= identifier temp= equalEOLSymbol )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:120:4: (temp= identifier temp= equalEOLSymbol )
            // C:\\dev\\runtime-workspaceEclipse3.4\\Properties\\Syntax\\Properties_ANTLR3.g:120:5: temp= identifier temp= equalEOLSymbol
            {
            pushFollow(FOLLOW_identifier_in_property305);
            temp=identifier();
            _fsp--;

            ei.set(ret, "name", temp);
            pushFollow(FOLLOW_equalEOLSymbol_in_property311);
            temp=equalEOLSymbol();
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
    // $ANTLR end property


 

    public static final BitSet FOLLOW_propertiesFile_in_main46 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifier82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALEOL_in_equalEOLSymbol116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_propertiesFile255 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_property_in_propertiesFile263 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_property305 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_equalEOLSymbol_in_property311 = new BitSet(new long[]{0x0000000000000002L});

}