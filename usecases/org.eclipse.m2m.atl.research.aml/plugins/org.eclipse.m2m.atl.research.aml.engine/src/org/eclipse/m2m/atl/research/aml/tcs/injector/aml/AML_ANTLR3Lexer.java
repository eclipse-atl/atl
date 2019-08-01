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

// $ANTLR 3.0.1 C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g 2009-10-16 16:58:53
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
public class AML_ANTLR3Lexer extends Lexer {
    public static final int LT=29;
    public static final int STAR=25;
    public static final int LSQUARE=12;
    public static final int EXCL=19;
    public static final int EOF=-1;
    public static final int RPAREN=16;
    public static final int NAME=4;
    public static final int NL=33;
    public static final int EQ=11;
    public static final int COMMENT=41;
    public static final int NE=32;
    public static final int GE=30;
    public static final int SHARP=21;
    public static final int T49=49;
    public static final int LCURLY=8;
    public static final int T48=48;
    public static final int INT=6;
    public static final int T100=100;
    public static final int T43=43;
    public static final int T42=42;
    public static final int T102=102;
    public static final int T101=101;
    public static final int T47=47;
    public static final int ALPHA=36;
    public static final int T46=46;
    public static final int T45=45;
    public static final int T44=44;
    public static final int COLONCOLON=40;
    public static final int T105=105;
    public static final int WS=34;
    public static final int T103=103;
    public static final int T104=104;
    public static final int SNAME=37;
    public static final int T50=50;
    public static final int T59=59;
    public static final int GT=28;
    public static final int T52=52;
    public static final int T51=51;
    public static final int T54=54;
    public static final int QMARK=39;
    public static final int T53=53;
    public static final int T56=56;
    public static final int T55=55;
    public static final int T58=58;
    public static final int T57=57;
    public static final int T75=75;
    public static final int T76=76;
    public static final int T73=73;
    public static final int T74=74;
    public static final int T79=79;
    public static final int T77=77;
    public static final int T78=78;
    public static final int POINT=22;
    public static final int ESC=38;
    public static final int LARROW=17;
    public static final int FLOAT=7;
    public static final int T72=72;
    public static final int LPAREN=15;
    public static final int T71=71;
    public static final int T70=70;
    public static final int T62=62;
    public static final int T63=63;
    public static final int T64=64;
    public static final int T65=65;
    public static final int SLASH=26;
    public static final int T66=66;
    public static final int T67=67;
    public static final int T68=68;
    public static final int T69=69;
    public static final int PIPE=20;
    public static final int PLUS=27;
    public static final int DIGIT=35;
    public static final int T61=61;
    public static final int T60=60;
    public static final int T99=99;
    public static final int T97=97;
    public static final int T98=98;
    public static final int T95=95;
    public static final int T96=96;
    public static final int RARROW=23;
    public static final int MINUS=24;
    public static final int RSQUARE=14;
    public static final int T94=94;
    public static final int Tokens=106;
    public static final int T93=93;
    public static final int COMA=13;
    public static final int T92=92;
    public static final int SEMI=18;
    public static final int T91=91;
    public static final int T90=90;
    public static final int COLON=10;
    public static final int T88=88;
    public static final int T89=89;
    public static final int T84=84;
    public static final int T85=85;
    public static final int T86=86;
    public static final int T87=87;
    public static final int RCURLY=9;
    public static final int T81=81;
    public static final int T80=80;
    public static final int T83=83;
    public static final int T82=82;
    public static final int LE=31;
    public static final int STRING=5;
    
    
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
    

    public AML_ANTLR3Lexer() {;} 
    public AML_ANTLR3Lexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g"; }

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:29:5: ( 'strategy' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:29:7: 'strategy'
            {
            match("strategy"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:30:5: ( 'models' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:30:7: 'models'
            {
            match("models"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:31:5: ( 'modelsFlow' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:31:7: 'modelsFlow'
            {
            match("modelsFlow"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:32:5: ( 'create' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:32:7: 'create'
            {
            match("create"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:33:5: ( 'ATLLibraries' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:33:7: 'ATLLibraries'
            {
            match("ATLLibraries"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:34:5: ( 'JavaLibraries' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:34:7: 'JavaLibraries'
            {
            match("JavaLibraries"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:35:5: ( 'using' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:35:7: 'using'
            {
            match("using"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:36:5: ( 'sim' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:36:7: 'sim'
            {
            match("sim"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:37:5: ( 'aggr' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:37:7: 'aggr'
            {
            match("aggr"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public final void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:38:5: ( 'sel' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:38:7: 'sel'
            {
            match("sel"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start T52
    public final void mT52() throws RecognitionException {
        try {
            int _type = T52;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:39:5: ( 'uses' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:39:7: 'uses'
            {
            match("uses"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T52

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:40:5: ( 'from' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:40:7: 'from'
            {
            match("from"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:41:5: ( 'when' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:41:7: 'when'
            {
            match("when"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start T55
    public final void mT55() throws RecognitionException {
        try {
            int _type = T55;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:42:5: ( 'leftType' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:42:7: 'leftType'
            {
            match("leftType"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T55

    // $ANTLR start T56
    public final void mT56() throws RecognitionException {
        try {
            int _type = T56;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:43:5: ( 'rightType' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:43:7: 'rightType'
            {
            match("rightType"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T56

    // $ANTLR start T57
    public final void mT57() throws RecognitionException {
        try {
            int _type = T57;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:44:5: ( 'in' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:44:7: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T57

    // $ANTLR start T58
    public final void mT58() throws RecognitionException {
        try {
            int _type = T58;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:45:5: ( 'is' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:45:7: 'is'
            {
            match("is"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T58

    // $ANTLR start T59
    public final void mT59() throws RecognitionException {
        try {
            int _type = T59;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:46:5: ( 'to' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:46:7: 'to'
            {
            match("to"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T59

    // $ANTLR start T60
    public final void mT60() throws RecognitionException {
        try {
            int _type = T60;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:47:5: ( 'mapsTo' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:47:7: 'mapsTo'
            {
            match("mapsTo"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T60

    // $ANTLR start T61
    public final void mT61() throws RecognitionException {
        try {
            int _type = T61;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:48:5: ( 'EqualModel' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:48:7: 'EqualModel'
            {
            match("EqualModel"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T61

    // $ANTLR start T62
    public final void mT62() throws RecognitionException {
        try {
            int _type = T62;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:49:5: ( 'WeavingModel' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:49:7: 'WeavingModel'
            {
            match("WeavingModel"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T62

    // $ANTLR start T63
    public final void mT63() throws RecognitionException {
        try {
            int _type = T63;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:50:5: ( 'thisModule' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:50:7: 'thisModule'
            {
            match("thisModule"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T63

    // $ANTLR start T64
    public final void mT64() throws RecognitionException {
        try {
            int _type = T64;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:51:5: ( 'thisRight' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:51:7: 'thisRight'
            {
            match("thisRight"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T64

    // $ANTLR start T65
    public final void mT65() throws RecognitionException {
        try {
            int _type = T65;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:52:5: ( 'thisLeft' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:52:7: 'thisLeft'
            {
            match("thisLeft"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T65

    // $ANTLR start T66
    public final void mT66() throws RecognitionException {
        try {
            int _type = T66;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:53:5: ( 'thisEqual' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:53:7: 'thisEqual'
            {
            match("thisEqual"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T66

    // $ANTLR start T67
    public final void mT67() throws RecognitionException {
        try {
            int _type = T67;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:54:5: ( 'thisWeight' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:54:7: 'thisWeight'
            {
            match("thisWeight"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T67

    // $ANTLR start T68
    public final void mT68() throws RecognitionException {
        try {
            int _type = T68;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:55:5: ( 'thisSim' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:55:7: 'thisSim'
            {
            match("thisSim"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T68

    // $ANTLR start T69
    public final void mT69() throws RecognitionException {
        try {
            int _type = T69;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:56:5: ( 'thisInstances' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:56:7: 'thisInstances'
            {
            match("thisInstances"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T69

    // $ANTLR start T70
    public final void mT70() throws RecognitionException {
        try {
            int _type = T70;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:57:5: ( 'Summation' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:57:7: 'Summation'
            {
            match("Summation"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T70

    // $ANTLR start T71
    public final void mT71() throws RecognitionException {
        try {
            int _type = T71;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:58:5: ( 'thisEqualModel' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:58:7: 'thisEqualModel'
            {
            match("thisEqualModel"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T71

    // $ANTLR start T72
    public final void mT72() throws RecognitionException {
        try {
            int _type = T72;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:59:5: ( 'name' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:59:7: 'name'
            {
            match("name"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T72

    // $ANTLR start T73
    public final void mT73() throws RecognitionException {
        try {
            int _type = T73;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:60:5: ( 'path' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:60:7: 'path'
            {
            match("path"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T73

    // $ANTLR start T74
    public final void mT74() throws RecognitionException {
        try {
            int _type = T74;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:61:5: ( 'imports' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:61:7: 'imports'
            {
            match("imports"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T74

    // $ANTLR start T75
    public final void mT75() throws RecognitionException {
        try {
            int _type = T75;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:62:5: ( 'super' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:62:7: 'super'
            {
            match("super"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T75

    // $ANTLR start T76
    public final void mT76() throws RecognitionException {
        try {
            int _type = T76;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:63:5: ( 'iterate' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:63:7: 'iterate'
            {
            match("iterate"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T76

    // $ANTLR start T77
    public final void mT77() throws RecognitionException {
        try {
            int _type = T77;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:64:5: ( 'OclUndefined' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:64:7: 'OclUndefined'
            {
            match("OclUndefined"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T77

    // $ANTLR start T78
    public final void mT78() throws RecognitionException {
        try {
            int _type = T78;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:65:5: ( 'true' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:65:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T78

    // $ANTLR start T79
    public final void mT79() throws RecognitionException {
        try {
            int _type = T79;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:66:5: ( 'false' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:66:7: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T79

    // $ANTLR start T80
    public final void mT80() throws RecognitionException {
        try {
            int _type = T80;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:67:5: ( 'if' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:67:7: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T80

    // $ANTLR start T81
    public final void mT81() throws RecognitionException {
        try {
            int _type = T81;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:68:5: ( 'then' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:68:7: 'then'
            {
            match("then"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T81

    // $ANTLR start T82
    public final void mT82() throws RecognitionException {
        try {
            int _type = T82;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:69:5: ( 'else' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:69:7: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T82

    // $ANTLR start T83
    public final void mT83() throws RecognitionException {
        try {
            int _type = T83;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:70:5: ( 'endif' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:70:7: 'endif'
            {
            match("endif"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T83

    // $ANTLR start T84
    public final void mT84() throws RecognitionException {
        try {
            int _type = T84;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:71:5: ( 'let' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:71:7: 'let'
            {
            match("let"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T84

    // $ANTLR start T85
    public final void mT85() throws RecognitionException {
        try {
            int _type = T85;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:72:5: ( 'Bag' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:72:7: 'Bag'
            {
            match("Bag"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T85

    // $ANTLR start T86
    public final void mT86() throws RecognitionException {
        try {
            int _type = T86;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:73:5: ( 'Set' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:73:7: 'Set'
            {
            match("Set"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T86

    // $ANTLR start T87
    public final void mT87() throws RecognitionException {
        try {
            int _type = T87;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:74:5: ( 'OrderedSet' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:74:7: 'OrderedSet'
            {
            match("OrderedSet"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T87

    // $ANTLR start T88
    public final void mT88() throws RecognitionException {
        try {
            int _type = T88;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:75:5: ( 'Sequence' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:75:7: 'Sequence'
            {
            match("Sequence"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T88

    // $ANTLR start T89
    public final void mT89() throws RecognitionException {
        try {
            int _type = T89;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:76:5: ( 'Map' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:76:7: 'Map'
            {
            match("Map"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T89

    // $ANTLR start T90
    public final void mT90() throws RecognitionException {
        try {
            int _type = T90;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:5: ( 'Tuple' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:77:7: 'Tuple'
            {
            match("Tuple"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T90

    // $ANTLR start T91
    public final void mT91() throws RecognitionException {
        try {
            int _type = T91;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:78:5: ( 'OclType' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:78:7: 'OclType'
            {
            match("OclType"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T91

    // $ANTLR start T92
    public final void mT92() throws RecognitionException {
        try {
            int _type = T92;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:79:5: ( 'OclAny' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:79:7: 'OclAny'
            {
            match("OclAny"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T92

    // $ANTLR start T93
    public final void mT93() throws RecognitionException {
        try {
            int _type = T93;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:80:5: ( 'TupleType' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:80:7: 'TupleType'
            {
            match("TupleType"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T93

    // $ANTLR start T94
    public final void mT94() throws RecognitionException {
        try {
            int _type = T94;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:81:5: ( 'Integer' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:81:7: 'Integer'
            {
            match("Integer"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T94

    // $ANTLR start T95
    public final void mT95() throws RecognitionException {
        try {
            int _type = T95;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:82:5: ( 'Real' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:82:7: 'Real'
            {
            match("Real"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T95

    // $ANTLR start T96
    public final void mT96() throws RecognitionException {
        try {
            int _type = T96;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:83:5: ( 'Boolean' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:83:7: 'Boolean'
            {
            match("Boolean"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T96

    // $ANTLR start T97
    public final void mT97() throws RecognitionException {
        try {
            int _type = T97;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:84:5: ( 'String' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:84:7: 'String'
            {
            match("String"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T97

    // $ANTLR start T98
    public final void mT98() throws RecognitionException {
        try {
            int _type = T98;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:85:5: ( 'Collection' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:85:7: 'Collection'
            {
            match("Collection"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T98

    // $ANTLR start T99
    public final void mT99() throws RecognitionException {
        try {
            int _type = T99;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:86:5: ( 'not' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:86:7: 'not'
            {
            match("not"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T99

    // $ANTLR start T100
    public final void mT100() throws RecognitionException {
        try {
            int _type = T100;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:87:6: ( 'div' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:87:8: 'div'
            {
            match("div"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T100

    // $ANTLR start T101
    public final void mT101() throws RecognitionException {
        try {
            int _type = T101;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:88:6: ( 'mod' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:88:8: 'mod'
            {
            match("mod"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T101

    // $ANTLR start T102
    public final void mT102() throws RecognitionException {
        try {
            int _type = T102;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:89:6: ( 'and' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:89:8: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T102

    // $ANTLR start T103
    public final void mT103() throws RecognitionException {
        try {
            int _type = T103;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:90:6: ( 'or' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:90:8: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T103

    // $ANTLR start T104
    public final void mT104() throws RecognitionException {
        try {
            int _type = T104;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:91:6: ( 'xor' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:91:8: 'xor'
            {
            match("xor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T104

    // $ANTLR start T105
    public final void mT105() throws RecognitionException {
        try {
            int _type = T105;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:92:6: ( 'implies' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:92:8: 'implies'
            {
            match("implies"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T105

    // $ANTLR start NL
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1209:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1209:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1209:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    new NoViableAltException("1209:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1209:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1210:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1211:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1212:5: '\\n'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1218:2: ( ( ' ' | '\\t' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1218:4: ( ' ' | '\\t' )
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1225:2: ( '0' .. '9' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1225:4: '0' .. '9'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1230:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1244:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1244:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1244:4: ( ALPHA )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1244:5: ALPHA
            {
            mALPHA(); 

            }

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1244:12: ( ALPHA | DIGIT )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')||(LA2_0>='\u00C0' && LA2_0<='\u00D6')||(LA2_0>='\u00D8' && LA2_0<='\u00F6')||(LA2_0>='\u00F8' && LA2_0<='\u00FF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1248:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1248:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1248:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
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
                    new NoViableAltException("1248:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1249:4: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1251:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); 
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1252:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1252:6: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1253:6: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1254:6: ~ ( '\\\\' | '\\\"' | '\\n' )
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1262:2: ( ( DIGIT )+ )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1262:4: ( DIGIT )+
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1262:4: ( DIGIT )+
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
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1262:5: DIGIT
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1266:7: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1266:9: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1266:9: ( DIGIT )+
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
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1266:9: DIGIT
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1266:20: ( DIGIT )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1266:20: DIGIT
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1270:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1270:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1271:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
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
                    new NoViableAltException("1271:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1271:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1272:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1273:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1274:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1275:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1276:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1277:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1278:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1279:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1279:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
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
                            new NoViableAltException("1279:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1280:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1280:5: ( '0' .. '3' )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1280:6: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1281:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1285:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1285:7: ( '0' .. '7' )
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1285:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1286:6: ( '0' .. '7' )?
                                    int alt8=2;
                                    int LA8_0 = input.LA(1);

                                    if ( ((LA8_0>='0' && LA8_0<='7')) ) {
                                        alt8=1;
                                    }
                                    switch (alt8) {
                                        case 1 :
                                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1290:8: '0' .. '7'
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
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1293:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1293:6: ( '4' .. '7' )
                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1293:7: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1294:5: ( ( '0' .. '7' ) )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1298:7: ( '0' .. '7' )
                                    {
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1298:7: ( '0' .. '7' )
                                    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1298:8: '0' .. '7'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1316:2: ( '[' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1316:4: '['
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1324:2: ( ']' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1324:4: ']'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1332:2: ( '!' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1332:4: '!'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1340:2: ( ',' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1340:4: ','
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1348:2: ( '(' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1348:4: '('
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1356:2: ( ')' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1356:4: ')'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1364:2: ( '{' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1364:4: '{'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1372:2: ( '}' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1372:4: '}'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1380:2: ( ';' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1380:4: ';'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1388:2: ( ':' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1388:4: ':'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1396:2: ( '|' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1396:4: '|'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1404:2: ( '#' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1404:4: '#'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1412:2: ( '?' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1412:4: '?'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1420:2: ( '::' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1420:4: '::'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1428:2: ( '.' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1428:4: '.'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1436:2: ( '->' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1436:4: '->'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1444:2: ( '-' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1444:4: '-'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1452:2: ( '*' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1452:4: '*'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1460:2: ( '/' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1460:4: '/'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1468:2: ( '+' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1468:4: '+'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1476:2: ( '=' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1476:4: '='
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1484:2: ( '>' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1484:4: '>'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1492:2: ( '<' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1492:4: '<'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1500:2: ( '>=' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1500:4: '>='
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1508:2: ( '<=' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1508:4: '<='
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1516:2: ( '<>' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1516:4: '<>'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1524:2: ( '<-' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1524:4: '<-'
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1532:2: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1532:4: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1532:4: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1532:5: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1532:5: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1532:6: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); 

            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1532:11: (~ ( '\\r' | '\\n' ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFE')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1532:12: ~ ( '\\r' | '\\n' )
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
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:2: ( ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:4: ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:4: ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:5: ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' )
            {
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:5: ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' )
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:6: '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\''
            {
            match('\''); 
            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:11: ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )*
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
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )
            	    {
            	    // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )
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
            	            new NoViableAltException("1540:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )", 14, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:41: ( '\\\\' ~ '\\n' )
            	            {
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:41: ( '\\\\' ~ '\\n' )
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:42: '\\\\' ~ '\\n'
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
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:57: '\\n'
            	            {
            	            match('\n'); 

            	            }
            	            break;
            	        case 3 :
            	            // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1540:63: ~ ( '\\\\' | '\\n' )
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

    public void mTokens() throws RecognitionException {
        // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:8: ( T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | NL | WS | NAME | INT | FLOAT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | SHARP | QMARK | COLONCOLON | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | COMMENT | STRING )
        int alt16=98;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:10: T42
                {
                mT42(); 

                }
                break;
            case 2 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:14: T43
                {
                mT43(); 

                }
                break;
            case 3 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:18: T44
                {
                mT44(); 

                }
                break;
            case 4 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:22: T45
                {
                mT45(); 

                }
                break;
            case 5 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:26: T46
                {
                mT46(); 

                }
                break;
            case 6 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:30: T47
                {
                mT47(); 

                }
                break;
            case 7 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:34: T48
                {
                mT48(); 

                }
                break;
            case 8 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:38: T49
                {
                mT49(); 

                }
                break;
            case 9 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:42: T50
                {
                mT50(); 

                }
                break;
            case 10 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:46: T51
                {
                mT51(); 

                }
                break;
            case 11 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:50: T52
                {
                mT52(); 

                }
                break;
            case 12 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:54: T53
                {
                mT53(); 

                }
                break;
            case 13 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:58: T54
                {
                mT54(); 

                }
                break;
            case 14 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:62: T55
                {
                mT55(); 

                }
                break;
            case 15 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:66: T56
                {
                mT56(); 

                }
                break;
            case 16 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:70: T57
                {
                mT57(); 

                }
                break;
            case 17 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:74: T58
                {
                mT58(); 

                }
                break;
            case 18 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:78: T59
                {
                mT59(); 

                }
                break;
            case 19 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:82: T60
                {
                mT60(); 

                }
                break;
            case 20 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:86: T61
                {
                mT61(); 

                }
                break;
            case 21 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:90: T62
                {
                mT62(); 

                }
                break;
            case 22 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:94: T63
                {
                mT63(); 

                }
                break;
            case 23 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:98: T64
                {
                mT64(); 

                }
                break;
            case 24 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:102: T65
                {
                mT65(); 

                }
                break;
            case 25 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:106: T66
                {
                mT66(); 

                }
                break;
            case 26 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:110: T67
                {
                mT67(); 

                }
                break;
            case 27 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:114: T68
                {
                mT68(); 

                }
                break;
            case 28 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:118: T69
                {
                mT69(); 

                }
                break;
            case 29 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:122: T70
                {
                mT70(); 

                }
                break;
            case 30 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:126: T71
                {
                mT71(); 

                }
                break;
            case 31 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:130: T72
                {
                mT72(); 

                }
                break;
            case 32 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:134: T73
                {
                mT73(); 

                }
                break;
            case 33 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:138: T74
                {
                mT74(); 

                }
                break;
            case 34 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:142: T75
                {
                mT75(); 

                }
                break;
            case 35 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:146: T76
                {
                mT76(); 

                }
                break;
            case 36 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:150: T77
                {
                mT77(); 

                }
                break;
            case 37 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:154: T78
                {
                mT78(); 

                }
                break;
            case 38 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:158: T79
                {
                mT79(); 

                }
                break;
            case 39 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:162: T80
                {
                mT80(); 

                }
                break;
            case 40 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:166: T81
                {
                mT81(); 

                }
                break;
            case 41 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:170: T82
                {
                mT82(); 

                }
                break;
            case 42 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:174: T83
                {
                mT83(); 

                }
                break;
            case 43 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:178: T84
                {
                mT84(); 

                }
                break;
            case 44 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:182: T85
                {
                mT85(); 

                }
                break;
            case 45 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:186: T86
                {
                mT86(); 

                }
                break;
            case 46 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:190: T87
                {
                mT87(); 

                }
                break;
            case 47 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:194: T88
                {
                mT88(); 

                }
                break;
            case 48 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:198: T89
                {
                mT89(); 

                }
                break;
            case 49 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:202: T90
                {
                mT90(); 

                }
                break;
            case 50 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:206: T91
                {
                mT91(); 

                }
                break;
            case 51 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:210: T92
                {
                mT92(); 

                }
                break;
            case 52 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:214: T93
                {
                mT93(); 

                }
                break;
            case 53 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:218: T94
                {
                mT94(); 

                }
                break;
            case 54 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:222: T95
                {
                mT95(); 

                }
                break;
            case 55 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:226: T96
                {
                mT96(); 

                }
                break;
            case 56 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:230: T97
                {
                mT97(); 

                }
                break;
            case 57 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:234: T98
                {
                mT98(); 

                }
                break;
            case 58 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:238: T99
                {
                mT99(); 

                }
                break;
            case 59 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:242: T100
                {
                mT100(); 

                }
                break;
            case 60 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:247: T101
                {
                mT101(); 

                }
                break;
            case 61 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:252: T102
                {
                mT102(); 

                }
                break;
            case 62 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:257: T103
                {
                mT103(); 

                }
                break;
            case 63 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:262: T104
                {
                mT104(); 

                }
                break;
            case 64 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:267: T105
                {
                mT105(); 

                }
                break;
            case 65 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:272: NL
                {
                mNL(); 

                }
                break;
            case 66 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:275: WS
                {
                mWS(); 

                }
                break;
            case 67 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:278: NAME
                {
                mNAME(); 

                }
                break;
            case 68 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:283: INT
                {
                mINT(); 

                }
                break;
            case 69 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:287: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 70 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:293: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 71 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:301: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 72 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:309: EXCL
                {
                mEXCL(); 

                }
                break;
            case 73 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:314: COMA
                {
                mCOMA(); 

                }
                break;
            case 74 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:319: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 75 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:326: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 76 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:333: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 77 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:340: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 78 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:347: SEMI
                {
                mSEMI(); 

                }
                break;
            case 79 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:352: COLON
                {
                mCOLON(); 

                }
                break;
            case 80 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:358: PIPE
                {
                mPIPE(); 

                }
                break;
            case 81 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:363: SHARP
                {
                mSHARP(); 

                }
                break;
            case 82 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:369: QMARK
                {
                mQMARK(); 

                }
                break;
            case 83 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:375: COLONCOLON
                {
                mCOLONCOLON(); 

                }
                break;
            case 84 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:386: POINT
                {
                mPOINT(); 

                }
                break;
            case 85 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:392: RARROW
                {
                mRARROW(); 

                }
                break;
            case 86 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:399: MINUS
                {
                mMINUS(); 

                }
                break;
            case 87 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:405: STAR
                {
                mSTAR(); 

                }
                break;
            case 88 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:410: SLASH
                {
                mSLASH(); 

                }
                break;
            case 89 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:416: PLUS
                {
                mPLUS(); 

                }
                break;
            case 90 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:421: EQ
                {
                mEQ(); 

                }
                break;
            case 91 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:424: GT
                {
                mGT(); 

                }
                break;
            case 92 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:427: LT
                {
                mLT(); 

                }
                break;
            case 93 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:430: GE
                {
                mGE(); 

                }
                break;
            case 94 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:433: LE
                {
                mLE(); 

                }
                break;
            case 95 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:436: NE
                {
                mNE(); 

                }
                break;
            case 96 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:439: LARROW
                {
                mLARROW(); 

                }
                break;
            case 97 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:446: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 98 :
                // C:\\dev\\runtime-workspaceEclipse3.4\\AML\\Syntax\\AML_ANTLR3.g:1:454: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\35\40\3\uffff\1\147\11\uffff\1\152\4\uffff\1\155\4\uffff"+
        "\1\157\1\163\1\uffff\21\40\1\u0087\1\u0088\2\40\1\u008b\1\u008c"+
        "\26\40\1\u00a5\1\40\15\uffff\1\40\1\u00a8\1\u00a9\1\40\1\u00ac\7"+
        "\40\1\u00b4\3\40\1\u00b8\2\40\2\uffff\2\40\2\uffff\7\40\1\u00c5"+
        "\2\40\1\u00c8\5\40\1\u00d0\1\40\1\u00d2\4\40\1\u00d7\1\uffff\1\u00d8"+
        "\1\40\2\uffff\2\40\1\uffff\5\40\1\u00e1\1\u00e2\1\uffff\1\u00e3"+
        "\1\40\1\u00e5\1\uffff\6\40\1\u00f2\1\u00f3\4\40\1\uffff\1\40\1\u00f9"+
        "\1\uffff\1\u00fa\4\40\1\u00ff\1\40\1\uffff\1\40\1\uffff\2\40\1\u0104"+
        "\1\40\2\uffff\1\40\1\u0107\5\40\1\u010d\3\uffff\1\u010e\1\uffff"+
        "\14\40\2\uffff\5\40\2\uffff\4\40\1\uffff\1\u0124\1\40\1\u0127\1"+
        "\40\1\uffff\2\40\1\uffff\1\u012c\1\u012d\1\u012e\2\40\2\uffff\20"+
        "\40\1\u0141\2\40\1\u0144\1\40\1\uffff\2\40\1\uffff\4\40\3\uffff"+
        "\4\40\1\u0150\1\u0151\1\u0152\6\40\1\u0159\4\40\1\uffff\1\u015e"+
        "\1\40\1\uffff\1\40\1\u0161\1\40\1\u0163\1\40\1\u0165\3\40\1\u0169"+
        "\1\40\3\uffff\4\40\1\u016f\1\40\1\uffff\3\40\1\u0174\1\uffff\2\40"+
        "\1\uffff\1\40\1\uffff\1\40\1\uffff\3\40\1\uffff\1\u017c\1\u017d"+
        "\1\u017f\2\40\1\uffff\3\40\1\u0185\1\uffff\2\40\1\u0188\1\40\1\u018a"+
        "\2\40\2\uffff\1\40\1\uffff\1\u018e\1\40\1\u0190\1\u0191\1\40\1\uffff"+
        "\1\40\1\u0194\1\uffff\1\u0195\1\uffff\3\40\1\uffff\1\40\2\uffff"+
        "\2\40\2\uffff\1\u019c\3\40\1\u01a0\1\u01a1\1\uffff\1\u01a2\1\40"+
        "\1\u01a4\3\uffff\1\u01a5\2\uffff";
    static final String DFA16_eofS =
        "\u01a6\uffff";
    static final String DFA16_minS =
        "\1\11\1\145\1\141\1\162\1\124\1\141\1\163\1\147\1\141\1\150\1\145"+
        "\1\151\1\146\1\150\1\161\2\145\2\141\1\143\1\154\2\141\1\165\1\156"+
        "\1\145\1\157\1\151\1\162\1\157\3\uffff\1\56\11\uffff\1\72\4\uffff"+
        "\1\55\4\uffff\1\75\1\55\1\uffff\1\162\1\155\1\154\1\160\1\144\1"+
        "\160\1\145\1\114\1\166\1\145\1\147\1\144\1\157\1\154\1\145\1\146"+
        "\1\147\2\60\1\145\1\160\2\60\1\145\2\165\1\141\1\155\1\161\1\162"+
        "\1\155\2\164\1\154\1\144\1\163\1\144\1\147\1\157\2\160\1\164\1\141"+
        "\1\154\1\166\1\60\1\162\15\uffff\1\141\2\60\1\145\1\60\1\163\1\141"+
        "\1\114\1\141\1\156\1\163\1\162\1\60\1\155\1\163\1\156\1\60\1\164"+
        "\1\150\2\uffff\1\162\1\154\2\uffff\1\163\1\156\1\145\1\141\1\166"+
        "\1\155\1\165\1\60\1\151\1\145\1\60\1\150\1\101\2\145\1\151\1\60"+
        "\1\154\1\60\1\154\1\145\2\154\1\60\1\uffff\1\60\1\164\2\uffff\1"+
        "\162\1\154\1\uffff\1\124\1\164\1\151\1\114\1\147\2\60\1\uffff\1"+
        "\60\1\145\1\60\1\uffff\1\124\1\164\1\141\1\151\1\162\1\105\2\60"+
        "\1\154\1\151\1\141\1\145\1\uffff\1\156\1\60\1\uffff\1\60\1\171\2"+
        "\156\1\162\1\60\1\146\1\uffff\1\145\1\uffff\1\145\1\147\1\60\1\145"+
        "\2\uffff\1\145\1\60\1\163\1\157\1\145\1\142\1\151\1\60\3\uffff\1"+
        "\60\1\uffff\1\171\1\124\1\164\1\145\1\164\1\151\1\161\1\145\1\156"+
        "\1\145\1\157\1\151\2\uffff\1\115\1\156\1\164\1\156\1\147\2\uffff"+
        "\1\160\1\144\1\171\1\145\1\uffff\1\60\1\141\1\60\1\145\1\uffff\1"+
        "\143\1\147\1\uffff\3\60\1\162\1\142\2\uffff\1\160\1\171\1\145\2"+
        "\163\1\147\1\165\1\151\1\163\1\146\1\144\1\155\1\157\1\147\1\151"+
        "\1\143\1\60\2\145\1\60\1\144\1\uffff\1\156\1\171\1\uffff\1\162\1"+
        "\164\1\171\1\154\3\uffff\1\141\1\162\1\145\1\160\3\60\1\150\1\141"+
        "\1\147\2\164\1\165\1\60\1\144\1\115\1\157\1\145\1\uffff\1\60\1\146"+
        "\1\uffff\1\123\1\60\1\160\1\60\1\151\1\60\1\157\1\162\1\141\1\60"+
        "\1\145\3\uffff\1\164\1\154\1\150\1\141\1\60\1\154\1\uffff\1\145"+
        "\1\157\1\156\1\60\1\uffff\1\151\1\145\1\uffff\1\145\1\uffff\1\157"+
        "\1\uffff\1\167\1\151\1\162\1\uffff\3\60\1\164\1\156\1\uffff\1\145"+
        "\1\154\1\144\1\60\1\uffff\1\156\1\164\1\60\1\156\1\60\1\145\1\151"+
        "\2\uffff\1\157\1\uffff\1\60\1\143\2\60\1\145\1\uffff\1\145\1\60"+
        "\1\uffff\1\60\1\uffff\1\163\1\145\1\144\1\uffff\1\145\2\uffff\1"+
        "\154\1\144\2\uffff\1\60\1\163\1\145\1\163\2\60\1\uffff\1\60\1\154"+
        "\1\60\3\uffff\1\60\2\uffff";
    static final String DFA16_maxS =
        "\1\u00ff\1\165\1\157\1\162\1\124\1\141\1\163\1\156\1\162\1\150\1"+
        "\145\1\151\1\164\1\162\1\161\1\145\1\165\1\157\1\141\1\162\1\156"+
        "\1\157\1\141\1\165\1\156\1\145\1\157\1\151\1\162\1\157\3\uffff\1"+
        "\71\11\uffff\1\72\4\uffff\1\76\4\uffff\1\75\1\76\1\uffff\1\162\1"+
        "\155\1\154\1\160\1\144\1\160\1\145\1\114\1\166\1\151\1\147\1\144"+
        "\1\157\1\154\1\145\1\164\1\147\2\u00ff\1\145\1\160\2\u00ff\1\151"+
        "\2\165\1\141\1\155\1\164\1\162\1\155\2\164\1\154\1\144\1\163\1\144"+
        "\1\147\1\157\2\160\1\164\1\141\1\154\1\166\1\u00ff\1\162\15\uffff"+
        "\1\141\2\u00ff\1\145\1\u00ff\1\163\1\141\1\114\1\141\1\156\1\163"+
        "\1\162\1\u00ff\1\155\1\163\1\156\1\u00ff\1\164\1\150\2\uffff\1\162"+
        "\1\157\2\uffff\1\163\1\156\1\145\1\141\1\166\1\155\1\165\1\u00ff"+
        "\1\151\1\145\1\u00ff\1\150\1\125\2\145\1\151\1\u00ff\1\154\1\u00ff"+
        "\1\154\1\145\2\154\1\u00ff\1\uffff\1\u00ff\1\164\2\uffff\1\162\1"+
        "\154\1\uffff\1\124\1\164\1\151\1\114\1\147\2\u00ff\1\uffff\1\u00ff"+
        "\1\145\1\u00ff\1\uffff\1\124\1\164\1\141\1\151\1\162\1\127\2\u00ff"+
        "\1\154\1\151\1\141\1\145\1\uffff\1\156\1\u00ff\1\uffff\1\u00ff\1"+
        "\171\2\156\1\162\1\u00ff\1\146\1\uffff\1\145\1\uffff\1\145\1\147"+
        "\1\u00ff\1\145\2\uffff\1\145\1\u00ff\1\163\1\157\1\145\1\142\1\151"+
        "\1\u00ff\3\uffff\1\u00ff\1\uffff\1\171\1\124\1\164\1\145\1\164\1"+
        "\151\1\161\1\145\1\156\1\145\1\157\1\151\2\uffff\1\115\1\156\1\164"+
        "\1\156\1\147\2\uffff\1\160\1\144\1\171\1\145\1\uffff\1\u00ff\1\141"+
        "\1\u00ff\1\145\1\uffff\1\143\1\147\1\uffff\3\u00ff\1\162\1\142\2"+
        "\uffff\1\160\1\171\1\145\2\163\1\147\1\165\1\151\1\163\1\146\1\144"+
        "\1\155\1\157\1\147\1\151\1\143\1\u00ff\2\145\1\u00ff\1\144\1\uffff"+
        "\1\156\1\171\1\uffff\1\162\1\164\1\171\1\154\3\uffff\1\141\1\162"+
        "\1\145\1\160\3\u00ff\1\150\1\141\1\147\2\164\1\165\1\u00ff\1\144"+
        "\1\115\1\157\1\145\1\uffff\1\u00ff\1\146\1\uffff\1\123\1\u00ff\1"+
        "\160\1\u00ff\1\151\1\u00ff\1\157\1\162\1\141\1\u00ff\1\145\3\uffff"+
        "\1\164\1\154\1\150\1\141\1\u00ff\1\154\1\uffff\1\145\1\157\1\156"+
        "\1\u00ff\1\uffff\1\151\1\145\1\uffff\1\145\1\uffff\1\157\1\uffff"+
        "\1\167\1\151\1\162\1\uffff\3\u00ff\1\164\1\156\1\uffff\1\145\1\154"+
        "\1\144\1\u00ff\1\uffff\1\156\1\164\1\u00ff\1\156\1\u00ff\1\145\1"+
        "\151\2\uffff\1\157\1\uffff\1\u00ff\1\143\2\u00ff\1\145\1\uffff\1"+
        "\145\1\u00ff\1\uffff\1\u00ff\1\uffff\1\163\1\145\1\144\1\uffff\1"+
        "\145\2\uffff\1\154\1\144\2\uffff\1\u00ff\1\163\1\145\1\163\2\u00ff"+
        "\1\uffff\1\u00ff\1\154\1\u00ff\3\uffff\1\u00ff\2\uffff";
    static final String DFA16_acceptS =
        "\36\uffff\1\101\1\102\1\103\1\uffff\1\106\1\107\1\110\1\111\1\112"+
        "\1\113\1\114\1\115\1\116\1\uffff\1\120\1\121\1\122\1\124\1\uffff"+
        "\1\127\1\130\1\131\1\132\2\uffff\1\142\57\uffff\1\104\1\105\1\123"+
        "\1\117\1\141\1\125\1\126\1\135\1\133\1\140\1\136\1\137\1\134\23"+
        "\uffff\1\21\1\20\2\uffff\1\47\1\22\30\uffff\1\76\2\uffff\1\10\1"+
        "\12\2\uffff\1\74\7\uffff\1\75\3\uffff\1\53\14\uffff\1\55\2\uffff"+
        "\1\72\7\uffff\1\54\1\uffff\1\60\4\uffff\1\73\1\77\10\uffff\1\13"+
        "\1\11\1\14\1\uffff\1\15\14\uffff\1\50\1\45\5\uffff\1\37\1\40\4\uffff"+
        "\1\51\4\uffff\1\66\2\uffff\1\42\5\uffff\1\7\1\46\25\uffff\1\52\2"+
        "\uffff\1\61\4\uffff\1\2\1\23\1\4\22\uffff\1\70\2\uffff\1\63\13\uffff"+
        "\1\43\1\100\1\41\6\uffff\1\33\4\uffff\1\62\2\uffff\1\67\1\uffff"+
        "\1\65\1\uffff\1\1\3\uffff\1\16\5\uffff\1\30\4\uffff\1\57\7\uffff"+
        "\1\17\1\27\1\uffff\1\31\5\uffff\1\35\2\uffff\1\64\1\uffff\1\3\3"+
        "\uffff\1\32\1\uffff\1\26\1\24\2\uffff\1\56\1\71\6\uffff\1\5\3\uffff"+
        "\1\25\1\44\1\6\1\uffff\1\34\1\36";
    static final String DFA16_specialS =
        "\u01a6\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\37\1\36\2\uffff\1\36\22\uffff\1\37\1\44\1\40\1\55\3\uffff"+
            "\1\67\1\46\1\47\1\61\1\63\1\45\1\60\1\57\1\62\12\41\1\53\1\52"+
            "\1\66\1\64\1\65\1\56\1\uffff\1\4\1\25\1\32\1\40\1\16\3\40\1"+
            "\30\1\5\2\40\1\26\1\40\1\23\2\40\1\31\1\20\1\27\2\40\1\17\3"+
            "\40\1\42\1\uffff\1\43\1\uffff\1\40\1\uffff\1\7\1\40\1\3\1\33"+
            "\1\24\1\10\2\40\1\14\2\40\1\12\1\2\1\21\1\34\1\22\1\40\1\13"+
            "\1\1\1\15\1\6\1\40\1\11\1\35\2\40\1\50\1\54\1\51\102\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\72\3\uffff\1\71\12\uffff\1\70\1\73",
            "\1\75\15\uffff\1\74",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102\6\uffff\1\103",
            "\1\105\20\uffff\1\104",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\115\6\uffff\1\114\1\112\4\uffff\1\111\1\113",
            "\1\117\6\uffff\1\116\2\uffff\1\120",
            "\1\121",
            "\1\122",
            "\1\124\16\uffff\1\125\1\123",
            "\1\126\15\uffff\1\127",
            "\1\130",
            "\1\131\16\uffff\1\132",
            "\1\133\1\uffff\1\134",
            "\1\135\15\uffff\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "",
            "",
            "",
            "\1\150\1\uffff\12\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\151",
            "",
            "",
            "",
            "",
            "\1\153\20\uffff\1\154",
            "",
            "",
            "",
            "",
            "\1\156",
            "\1\160\17\uffff\1\161\1\162",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\176\3\uffff\1\175",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0085\15\uffff\1\u0084",
            "\1\u0086",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0089",
            "\1\u008a",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u008e\3\uffff\1\u008d",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093\2\uffff\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00a6",
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
            "\1\u00a7",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00aa",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\4\40\1\u00ab\25\40"+
            "\105\uffff\27\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00b9",
            "\1\u00ba",
            "",
            "",
            "\1\u00bb",
            "\1\u00bc\2\uffff\1\u00bd",
            "",
            "",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00c6",
            "\1\u00c7",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00c9",
            "\1\u00cc\22\uffff\1\u00ca\1\u00cb",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00d1",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00d9",
            "",
            "",
            "\1\u00da",
            "\1\u00db",
            "",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00e4",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00ec\3\uffff\1\u00ee\2\uffff\1\u00ef\1\u00f0\4\uffff\1\u00eb"+
            "\1\u00f1\3\uffff\1\u00ed",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "",
            "\1\u00f8",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0100",
            "",
            "\1\u0101",
            "",
            "\1\u0102",
            "\1\u0103",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0105",
            "",
            "",
            "\1\u0106",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "",
            "",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "",
            "",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0125",
            "\12\40\7\uffff\23\40\1\u0126\6\40\4\uffff\1\40\1\uffff\32\40"+
            "\105\uffff\27\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0128",
            "",
            "\1\u0129",
            "\1\u012a",
            "",
            "\12\40\7\uffff\5\40\1\u012b\24\40\4\uffff\1\40\1\uffff\32\40"+
            "\105\uffff\27\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u012f",
            "\1\u0130",
            "",
            "",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0142",
            "\1\u0143",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0145",
            "",
            "\1\u0146",
            "\1\u0147",
            "",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "",
            "",
            "",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u015f",
            "",
            "\1\u0160",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0162",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0164",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u016a",
            "",
            "",
            "",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0170",
            "",
            "\1\u0171",
            "\1\u0172",
            "\1\u0173",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "\1\u0175",
            "\1\u0176",
            "",
            "\1\u0177",
            "",
            "\1\u0178",
            "",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\14\40\1\u017e\15\40\4\uffff\1\40\1\uffff\32\40"+
            "\105\uffff\27\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0180",
            "\1\u0181",
            "",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "\1\u0186",
            "\1\u0187",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0189",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u018b",
            "\1\u018c",
            "",
            "",
            "\1\u018d",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u018f",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u0192",
            "",
            "\1\u0193",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "\1\u0196",
            "\1\u0197",
            "\1\u0198",
            "",
            "\1\u0199",
            "",
            "",
            "\1\u019a",
            "\1\u019b",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "\1\u01a3",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40\105\uffff\27"+
            "\40\1\uffff\37\40\1\uffff\10\40",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | NL | WS | NAME | INT | FLOAT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | SHARP | QMARK | COLONCOLON | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | COMMENT | STRING );";
        }
    }
 

}