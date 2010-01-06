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
// $ANTLR 3.0.1 ATL_ANTLR3.g 2010-01-05 17:17:13
package org.eclipse.m2m.atl.dsls.tcs.injector;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ATL_ANTLR3Lexer extends Lexer {
    public static final int LT=28;
    public static final int STAR=24;
    public static final int LSQUARE=38;
    public static final int EXCL=19;
    public static final int EOF=-1;
    public static final int RPAREN=13;
    public static final int NAME=4;
    public static final int NL=32;
    public static final int EQ=10;
    public static final int COMMENT=42;
    public static final int NE=31;
    public static final int GE=29;
    public static final int ASSIGNARROW=17;
    public static final int SHARP=21;
    public static final int T49=49;
    public static final int LCURLY=14;
    public static final int T48=48;
    public static final int INT=6;
    public static final int T43=43;
    public static final int T47=47;
    public static final int ALPHA=35;
    public static final int T46=46;
    public static final int T45=45;
    public static final int T44=44;
    public static final int WS=33;
    public static final int SNAME=36;
    public static final int T50=50;
    public static final int T59=59;
    public static final int GT=27;
    public static final int T52=52;
    public static final int T51=51;
    public static final int T54=54;
    public static final int QMARK=40;
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
    public static final int AROBAS=41;
    public static final int ESC=37;
    public static final int LARROW=18;
    public static final int FLOAT=7;
    public static final int T72=72;
    public static final int LPAREN=12;
    public static final int T71=71;
    public static final int T70=70;
    public static final int T62=62;
    public static final int T63=63;
    public static final int T64=64;
    public static final int T65=65;
    public static final int SLASH=25;
    public static final int T66=66;
    public static final int T67=67;
    public static final int T68=68;
    public static final int T69=69;
    public static final int PIPE=20;
    public static final int PLUS=26;
    public static final int DIGIT=34;
    public static final int T61=61;
    public static final int T60=60;
    public static final int T99=99;
    public static final int T97=97;
    public static final int T98=98;
    public static final int T95=95;
    public static final int T96=96;
    public static final int RARROW=16;
    public static final int MINUS=23;
    public static final int RSQUARE=39;
    public static final int T94=94;
    public static final int Tokens=100;
    public static final int T93=93;
    public static final int COMA=9;
    public static final int T92=92;
    public static final int SEMI=8;
    public static final int T91=91;
    public static final int T90=90;
    public static final int COLON=11;
    public static final int T88=88;
    public static final int T89=89;
    public static final int T84=84;
    public static final int T85=85;
    public static final int T86=86;
    public static final int T87=87;
    public static final int RCURLY=15;
    public static final int T81=81;
    public static final int T80=80;
    public static final int T83=83;
    public static final int T82=82;
    public static final int LE=30;
    public static final int STRING=5;
    
    
    	private void newline() {}
    
    	public org.eclipse.m2m.atl.dsls.tcs.injector.TCSRuntime ei = null;
    
    	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    		ei.reportError((Exception)e);
    	}
    
    	public Token emit() {
    		org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken ret = null;
    
    		ret = new org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken(input, type, channel, tokenStartCharIndex, getCharIndex()-1);
    		ret.setLine(tokenStartLine);
    		ret.setText(text);
    	  	ret.setCharPositionInLine(tokenStartCharPositionInLine);
    		ret.setEndLine(getLine());
    		ret.setEndColumn(getCharPositionInLine());
    		emit(ret);
    
    		return ret;
    	}
    

    public ATL_ANTLR3Lexer() {;} 
    public ATL_ANTLR3Lexer(CharStream input) {
        super(input);
        ruleMemo = new HashMap[98+1];
     }
    public String getGrammarFileName() { return "ATL_ANTLR3.g"; }

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // ATL_ANTLR3.g:29:5: ( 'module' )
            // ATL_ANTLR3.g:29:7: 'module'
            {
            match("module"); if (failed) return ;


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
            // ATL_ANTLR3.g:30:5: ( 'create' )
            // ATL_ANTLR3.g:30:7: 'create'
            {
            match("create"); if (failed) return ;


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
            // ATL_ANTLR3.g:31:5: ( 'refining' )
            // ATL_ANTLR3.g:31:7: 'refining'
            {
            match("refining"); if (failed) return ;


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
            // ATL_ANTLR3.g:32:5: ( 'from' )
            // ATL_ANTLR3.g:32:7: 'from'
            {
            match("from"); if (failed) return ;


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
            // ATL_ANTLR3.g:33:5: ( 'library' )
            // ATL_ANTLR3.g:33:7: 'library'
            {
            match("library"); if (failed) return ;


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
            // ATL_ANTLR3.g:34:5: ( 'query' )
            // ATL_ANTLR3.g:34:7: 'query'
            {
            match("query"); if (failed) return ;


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
            // ATL_ANTLR3.g:35:5: ( 'uses' )
            // ATL_ANTLR3.g:35:7: 'uses'
            {
            match("uses"); if (failed) return ;


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
            // ATL_ANTLR3.g:36:5: ( 'helper' )
            // ATL_ANTLR3.g:36:7: 'helper'
            {
            match("helper"); if (failed) return ;


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
            // ATL_ANTLR3.g:37:5: ( 'def' )
            // ATL_ANTLR3.g:37:7: 'def'
            {
            match("def"); if (failed) return ;


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
            // ATL_ANTLR3.g:38:5: ( 'context' )
            // ATL_ANTLR3.g:38:7: 'context'
            {
            match("context"); if (failed) return ;


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
            // ATL_ANTLR3.g:39:5: ( 'nodefault' )
            // ATL_ANTLR3.g:39:7: 'nodefault'
            {
            match("nodefault"); if (failed) return ;


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
            // ATL_ANTLR3.g:40:5: ( 'abstract' )
            // ATL_ANTLR3.g:40:7: 'abstract'
            {
            match("abstract"); if (failed) return ;


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
            // ATL_ANTLR3.g:41:5: ( 'rule' )
            // ATL_ANTLR3.g:41:7: 'rule'
            {
            match("rule"); if (failed) return ;


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
            // ATL_ANTLR3.g:42:5: ( 'extends' )
            // ATL_ANTLR3.g:42:7: 'extends'
            {
            match("extends"); if (failed) return ;


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
            // ATL_ANTLR3.g:43:5: ( 'using' )
            // ATL_ANTLR3.g:43:7: 'using'
            {
            match("using"); if (failed) return ;


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
            // ATL_ANTLR3.g:44:5: ( 'unique' )
            // ATL_ANTLR3.g:44:7: 'unique'
            {
            match("unique"); if (failed) return ;


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
            // ATL_ANTLR3.g:45:5: ( 'lazy' )
            // ATL_ANTLR3.g:45:7: 'lazy'
            {
            match("lazy"); if (failed) return ;


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
            // ATL_ANTLR3.g:46:5: ( 'entrypoint' )
            // ATL_ANTLR3.g:46:7: 'entrypoint'
            {
            match("entrypoint"); if (failed) return ;


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
            // ATL_ANTLR3.g:47:5: ( 'endpoint' )
            // ATL_ANTLR3.g:47:7: 'endpoint'
            {
            match("endpoint"); if (failed) return ;


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
            // ATL_ANTLR3.g:48:5: ( 'in' )
            // ATL_ANTLR3.g:48:7: 'in'
            {
            match("in"); if (failed) return ;


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
            // ATL_ANTLR3.g:49:5: ( 'to' )
            // ATL_ANTLR3.g:49:7: 'to'
            {
            match("to"); if (failed) return ;


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
            // ATL_ANTLR3.g:50:5: ( 'mapsTo' )
            // ATL_ANTLR3.g:50:7: 'mapsTo'
            {
            match("mapsTo"); if (failed) return ;


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
            // ATL_ANTLR3.g:51:5: ( 'distinct' )
            // ATL_ANTLR3.g:51:7: 'distinct'
            {
            match("distinct"); if (failed) return ;


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
            // ATL_ANTLR3.g:52:5: ( 'foreach' )
            // ATL_ANTLR3.g:52:7: 'foreach'
            {
            match("foreach"); if (failed) return ;


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
            // ATL_ANTLR3.g:53:5: ( 'do' )
            // ATL_ANTLR3.g:53:7: 'do'
            {
            match("do"); if (failed) return ;


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
            // ATL_ANTLR3.g:54:5: ( 'if' )
            // ATL_ANTLR3.g:54:7: 'if'
            {
            match("if"); if (failed) return ;


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
            // ATL_ANTLR3.g:55:5: ( 'else' )
            // ATL_ANTLR3.g:55:7: 'else'
            {
            match("else"); if (failed) return ;


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
            // ATL_ANTLR3.g:56:5: ( 'for' )
            // ATL_ANTLR3.g:56:7: 'for'
            {
            match("for"); if (failed) return ;


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
            // ATL_ANTLR3.g:57:5: ( 'iterate' )
            // ATL_ANTLR3.g:57:7: 'iterate'
            {
            match("iterate"); if (failed) return ;


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
            // ATL_ANTLR3.g:58:5: ( 'OclUndefined' )
            // ATL_ANTLR3.g:58:7: 'OclUndefined'
            {
            match("OclUndefined"); if (failed) return ;


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
            // ATL_ANTLR3.g:59:5: ( 'true' )
            // ATL_ANTLR3.g:59:7: 'true'
            {
            match("true"); if (failed) return ;


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
            // ATL_ANTLR3.g:60:5: ( 'false' )
            // ATL_ANTLR3.g:60:7: 'false'
            {
            match("false"); if (failed) return ;


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
            // ATL_ANTLR3.g:61:5: ( 'then' )
            // ATL_ANTLR3.g:61:7: 'then'
            {
            match("then"); if (failed) return ;


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
            // ATL_ANTLR3.g:62:5: ( 'endif' )
            // ATL_ANTLR3.g:62:7: 'endif'
            {
            match("endif"); if (failed) return ;


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
            // ATL_ANTLR3.g:63:5: ( 'super' )
            // ATL_ANTLR3.g:63:7: 'super'
            {
            match("super"); if (failed) return ;


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
            // ATL_ANTLR3.g:64:5: ( 'let' )
            // ATL_ANTLR3.g:64:7: 'let'
            {
            match("let"); if (failed) return ;


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
            // ATL_ANTLR3.g:65:5: ( 'Bag' )
            // ATL_ANTLR3.g:65:7: 'Bag'
            {
            match("Bag"); if (failed) return ;


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
            // ATL_ANTLR3.g:66:5: ( 'Set' )
            // ATL_ANTLR3.g:66:7: 'Set'
            {
            match("Set"); if (failed) return ;


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
            // ATL_ANTLR3.g:67:5: ( 'OrderedSet' )
            // ATL_ANTLR3.g:67:7: 'OrderedSet'
            {
            match("OrderedSet"); if (failed) return ;


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
            // ATL_ANTLR3.g:68:5: ( 'Sequence' )
            // ATL_ANTLR3.g:68:7: 'Sequence'
            {
            match("Sequence"); if (failed) return ;


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
            // ATL_ANTLR3.g:69:5: ( 'Map' )
            // ATL_ANTLR3.g:69:7: 'Map'
            {
            match("Map"); if (failed) return ;


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
            // ATL_ANTLR3.g:70:5: ( 'Tuple' )
            // ATL_ANTLR3.g:70:7: 'Tuple'
            {
            match("Tuple"); if (failed) return ;


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
            // ATL_ANTLR3.g:71:5: ( 'OclType' )
            // ATL_ANTLR3.g:71:7: 'OclType'
            {
            match("OclType"); if (failed) return ;


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
            // ATL_ANTLR3.g:72:5: ( 'OclAny' )
            // ATL_ANTLR3.g:72:7: 'OclAny'
            {
            match("OclAny"); if (failed) return ;


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
            // ATL_ANTLR3.g:73:5: ( 'TupleType' )
            // ATL_ANTLR3.g:73:7: 'TupleType'
            {
            match("TupleType"); if (failed) return ;


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
            // ATL_ANTLR3.g:74:5: ( 'Integer' )
            // ATL_ANTLR3.g:74:7: 'Integer'
            {
            match("Integer"); if (failed) return ;


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
            // ATL_ANTLR3.g:75:5: ( 'Real' )
            // ATL_ANTLR3.g:75:7: 'Real'
            {
            match("Real"); if (failed) return ;


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
            // ATL_ANTLR3.g:76:5: ( 'Boolean' )
            // ATL_ANTLR3.g:76:7: 'Boolean'
            {
            match("Boolean"); if (failed) return ;


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
            // ATL_ANTLR3.g:77:5: ( 'String' )
            // ATL_ANTLR3.g:77:7: 'String'
            {
            match("String"); if (failed) return ;


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
            // ATL_ANTLR3.g:78:5: ( 'Collection' )
            // ATL_ANTLR3.g:78:7: 'Collection'
            {
            match("Collection"); if (failed) return ;


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
            // ATL_ANTLR3.g:79:5: ( 'not' )
            // ATL_ANTLR3.g:79:7: 'not'
            {
            match("not"); if (failed) return ;


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
            // ATL_ANTLR3.g:80:5: ( 'div' )
            // ATL_ANTLR3.g:80:7: 'div'
            {
            match("div"); if (failed) return ;


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
            // ATL_ANTLR3.g:81:5: ( 'mod' )
            // ATL_ANTLR3.g:81:7: 'mod'
            {
            match("mod"); if (failed) return ;


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
            // ATL_ANTLR3.g:82:5: ( 'and' )
            // ATL_ANTLR3.g:82:7: 'and'
            {
            match("and"); if (failed) return ;


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
            // ATL_ANTLR3.g:83:5: ( 'or' )
            // ATL_ANTLR3.g:83:7: 'or'
            {
            match("or"); if (failed) return ;


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
            // ATL_ANTLR3.g:84:5: ( 'xor' )
            // ATL_ANTLR3.g:84:7: 'xor'
            {
            match("xor"); if (failed) return ;


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
            // ATL_ANTLR3.g:85:5: ( 'implies' )
            // ATL_ANTLR3.g:85:7: 'implies'
            {
            match("implies"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T99

    // $ANTLR start NL
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            // ATL_ANTLR3.g:1079:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ATL_ANTLR3.g:1079:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ATL_ANTLR3.g:1079:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1079:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ATL_ANTLR3.g:1079:6: '\\r' '\\n'
                    {
                    match('\r'); if (failed) return ;
                    match('\n'); if (failed) return ;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1080:5: '\\n' '\\r'
                    {
                    match('\n'); if (failed) return ;
                    match('\r'); if (failed) return ;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:1081:5: '\\r'
                    {
                    match('\r'); if (failed) return ;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:1082:5: '\\n'
                    {
                    match('\n'); if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
              newline();
            }

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
            // ATL_ANTLR3.g:1088:2: ( ( ' ' | '\\t' ) )
            // ATL_ANTLR3.g:1088:4: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();
            failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
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
            // ATL_ANTLR3.g:1095:2: ( '0' .. '9' )
            // ATL_ANTLR3.g:1095:4: '0' .. '9'
            {
            matchRange('0','9'); if (failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end DIGIT

    // $ANTLR start ALPHA
    public final void mALPHA() throws RecognitionException {
        try {
            // ATL_ANTLR3.g:1100:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ATL_ANTLR3.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
                input.consume();
            failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
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
            // ATL_ANTLR3.g:1116:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ATL_ANTLR3.g:1116:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ATL_ANTLR3.g:1116:4: ( ALPHA )
            // ATL_ANTLR3.g:1116:5: ALPHA
            {
            mALPHA(); if (failed) return ;

            }

            // ATL_ANTLR3.g:1116:12: ( ALPHA | DIGIT )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')||(LA2_0>='\u00C0' && LA2_0<='\u00D6')||(LA2_0>='\u00D8' && LA2_0<='\u00F6')||(LA2_0>='\u00F8' && LA2_0<='\u00FF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ATL_ANTLR3.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
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
            // ATL_ANTLR3.g:1120:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ATL_ANTLR3.g:1120:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ATL_ANTLR3.g:1120:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='\"') ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1120:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ATL_ANTLR3.g:1121:4: SNAME
                    {
                    mSNAME(); if (failed) return ;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1123:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); if (failed) return ;
                    // ATL_ANTLR3.g:1124:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
                    	    // ATL_ANTLR3.g:1124:6: ESC
                    	    {
                    	    mESC(); if (failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // ATL_ANTLR3.g:1125:6: '\\n'
                    	    {
                    	    match('\n'); if (failed) return ;
                    	    if ( backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // ATL_ANTLR3.g:1126:6: ~ ( '\\\\' | '\\\"' | '\\n' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();
                    	    failed=false;
                    	    }
                    	    else {
                    	        if (backtracking>0) {failed=true; return ;}
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

                    match('\"'); if (failed) return ;
                    if ( backtracking==0 ) {
                      setText(ei.unescapeString(getText(), 1));
                    }

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
            // ATL_ANTLR3.g:1134:2: ( ( DIGIT )+ )
            // ATL_ANTLR3.g:1134:4: ( DIGIT )+
            {
            // ATL_ANTLR3.g:1134:4: ( DIGIT )+
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
            	    // ATL_ANTLR3.g:1134:5: DIGIT
            	    {
            	    mDIGIT(); if (failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (backtracking>0) {failed=true; return ;}
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
            // ATL_ANTLR3.g:1138:7: ( ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )? )
            // ATL_ANTLR3.g:1138:9: ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            {
            // ATL_ANTLR3.g:1138:9: ( DIGIT )+
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
            	    // ATL_ANTLR3.g:1138:9: DIGIT
            	    {
            	    mDIGIT(); if (failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // ATL_ANTLR3.g:1138:16: ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='.') && (synpred1())) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ATL_ANTLR3.g:1138:17: ( '.' DIGIT )=> '.' ( DIGIT )+
                    {
                    match('.'); if (failed) return ;
                    // ATL_ANTLR3.g:1138:34: ( DIGIT )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ATL_ANTLR3.g:1138:34: DIGIT
                    	    {
                    	    mDIGIT(); if (failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (backtracking>0) {failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }
                    break;

            }


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
            // ATL_ANTLR3.g:1142:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ATL_ANTLR3.g:1142:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); if (failed) return ;
            // ATL_ANTLR3.g:1143:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            int alt13=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt13=1;
                }
                break;
            case 'r':
                {
                alt13=2;
                }
                break;
            case 't':
                {
                alt13=3;
                }
                break;
            case 'b':
                {
                alt13=4;
                }
                break;
            case 'f':
                {
                alt13=5;
                }
                break;
            case '\"':
                {
                alt13=6;
                }
                break;
            case '\'':
                {
                alt13=7;
                }
                break;
            case '\\':
                {
                alt13=8;
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
                alt13=9;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1143:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ATL_ANTLR3.g:1143:5: 'n'
                    {
                    match('n'); if (failed) return ;

                    }
                    break;
                case 2 :
                    // ATL_ANTLR3.g:1144:5: 'r'
                    {
                    match('r'); if (failed) return ;

                    }
                    break;
                case 3 :
                    // ATL_ANTLR3.g:1145:5: 't'
                    {
                    match('t'); if (failed) return ;

                    }
                    break;
                case 4 :
                    // ATL_ANTLR3.g:1146:5: 'b'
                    {
                    match('b'); if (failed) return ;

                    }
                    break;
                case 5 :
                    // ATL_ANTLR3.g:1147:5: 'f'
                    {
                    match('f'); if (failed) return ;

                    }
                    break;
                case 6 :
                    // ATL_ANTLR3.g:1148:5: '\"'
                    {
                    match('\"'); if (failed) return ;

                    }
                    break;
                case 7 :
                    // ATL_ANTLR3.g:1149:5: '\\''
                    {
                    match('\''); if (failed) return ;

                    }
                    break;
                case 8 :
                    // ATL_ANTLR3.g:1150:5: '\\\\'
                    {
                    match('\\'); if (failed) return ;

                    }
                    break;
                case 9 :
                    // ATL_ANTLR3.g:1151:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ATL_ANTLR3.g:1151:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>='0' && LA12_0<='3')) ) {
                        alt12=1;
                    }
                    else if ( ((LA12_0>='4' && LA12_0<='7')) ) {
                        alt12=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("1151:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ATL_ANTLR3.g:1152:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ATL_ANTLR3.g:1152:5: ( '0' .. '3' )
                            // ATL_ANTLR3.g:1152:6: '0' .. '3'
                            {
                            matchRange('0','3'); if (failed) return ;

                            }

                            // ATL_ANTLR3.g:1153:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // ATL_ANTLR3.g:1157:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ATL_ANTLR3.g:1157:7: ( '0' .. '7' )
                                    // ATL_ANTLR3.g:1157:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); if (failed) return ;

                                    }

                                    // ATL_ANTLR3.g:1158:6: ( '0' .. '7' )?
                                    int alt9=2;
                                    int LA9_0 = input.LA(1);

                                    if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                                        alt9=1;
                                    }
                                    switch (alt9) {
                                        case 1 :
                                            // ATL_ANTLR3.g:1162:8: '0' .. '7'
                                            {
                                            matchRange('0','7'); if (failed) return ;

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ATL_ANTLR3.g:1165:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ATL_ANTLR3.g:1165:6: ( '4' .. '7' )
                            // ATL_ANTLR3.g:1165:7: '4' .. '7'
                            {
                            matchRange('4','7'); if (failed) return ;

                            }

                            // ATL_ANTLR3.g:1166:5: ( ( '0' .. '7' ) )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // ATL_ANTLR3.g:1170:7: ( '0' .. '7' )
                                    {
                                    // ATL_ANTLR3.g:1170:7: ( '0' .. '7' )
                                    // ATL_ANTLR3.g:1170:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); if (failed) return ;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    if ( backtracking==0 ) {
                      
                      //					String s = getText();
                      //					int i;
                      //					int ret = 0;
                      //					String ans;
                      //					for (i=0; i<s.length(); ++i)
                      //						ret = ret*8 + s.charAt(i) - '0';
                      //					ans = String.valueOf((char) ret);
                      //					setText(ans);
                      				
                    }

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
            // ATL_ANTLR3.g:1188:2: ( '[' )
            // ATL_ANTLR3.g:1188:4: '['
            {
            match('['); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1196:2: ( ']' )
            // ATL_ANTLR3.g:1196:4: ']'
            {
            match(']'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1204:2: ( '!' )
            // ATL_ANTLR3.g:1204:4: '!'
            {
            match('!'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1212:2: ( ',' )
            // ATL_ANTLR3.g:1212:4: ','
            {
            match(','); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1220:2: ( '(' )
            // ATL_ANTLR3.g:1220:4: '('
            {
            match('('); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1228:2: ( ')' )
            // ATL_ANTLR3.g:1228:4: ')'
            {
            match(')'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1236:2: ( '{' )
            // ATL_ANTLR3.g:1236:4: '{'
            {
            match('{'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1244:2: ( '}' )
            // ATL_ANTLR3.g:1244:4: '}'
            {
            match('}'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1252:2: ( ';' )
            // ATL_ANTLR3.g:1252:4: ';'
            {
            match(';'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1260:2: ( ':' )
            // ATL_ANTLR3.g:1260:4: ':'
            {
            match(':'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1268:2: ( '|' )
            // ATL_ANTLR3.g:1268:4: '|'
            {
            match('|'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1276:2: ( '#' )
            // ATL_ANTLR3.g:1276:4: '#'
            {
            match('#'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1284:2: ( '?' )
            // ATL_ANTLR3.g:1284:4: '?'
            {
            match('?'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QMARK

    // $ANTLR start AROBAS
    public final void mAROBAS() throws RecognitionException {
        try {
            int _type = AROBAS;
            // ATL_ANTLR3.g:1292:2: ( '@' )
            // ATL_ANTLR3.g:1292:4: '@'
            {
            match('@'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AROBAS

    // $ANTLR start POINT
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            // ATL_ANTLR3.g:1300:2: ( '.' )
            // ATL_ANTLR3.g:1300:4: '.'
            {
            match('.'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1308:2: ( '->' )
            // ATL_ANTLR3.g:1308:4: '->'
            {
            match("->"); if (failed) return ;

            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1316:2: ( '-' )
            // ATL_ANTLR3.g:1316:4: '-'
            {
            match('-'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1324:2: ( '*' )
            // ATL_ANTLR3.g:1324:4: '*'
            {
            match('*'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1332:2: ( '/' )
            // ATL_ANTLR3.g:1332:4: '/'
            {
            match('/'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1340:2: ( '+' )
            // ATL_ANTLR3.g:1340:4: '+'
            {
            match('+'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1348:2: ( '=' )
            // ATL_ANTLR3.g:1348:4: '='
            {
            match('='); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1356:2: ( '>' )
            // ATL_ANTLR3.g:1356:4: '>'
            {
            match('>'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1364:2: ( '<' )
            // ATL_ANTLR3.g:1364:4: '<'
            {
            match('<'); if (failed) return ;
            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1372:2: ( '>=' )
            // ATL_ANTLR3.g:1372:4: '>='
            {
            match(">="); if (failed) return ;

            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1380:2: ( '<=' )
            // ATL_ANTLR3.g:1380:4: '<='
            {
            match("<="); if (failed) return ;

            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1388:2: ( '<>' )
            // ATL_ANTLR3.g:1388:4: '<>'
            {
            match("<>"); if (failed) return ;

            if ( backtracking==0 ) {

                          
                      
            }

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
            // ATL_ANTLR3.g:1396:2: ( '<-' )
            // ATL_ANTLR3.g:1396:4: '<-'
            {
            match("<-"); if (failed) return ;

            if ( backtracking==0 ) {

                          
                      
            }

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LARROW

    // $ANTLR start ASSIGNARROW
    public final void mASSIGNARROW() throws RecognitionException {
        try {
            int _type = ASSIGNARROW;
            // ATL_ANTLR3.g:1404:2: ( '<:=' )
            // ATL_ANTLR3.g:1404:4: '<:='
            {
            match("<:="); if (failed) return ;

            if ( backtracking==0 ) {

                          
                      
            }

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ASSIGNARROW

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // ATL_ANTLR3.g:1412:2: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // ATL_ANTLR3.g:1412:4: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // ATL_ANTLR3.g:1412:4: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // ATL_ANTLR3.g:1412:5: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // ATL_ANTLR3.g:1412:5: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // ATL_ANTLR3.g:1412:6: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); if (failed) return ;

            // ATL_ANTLR3.g:1412:11: (~ ( '\\r' | '\\n' ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\uFFFE')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ATL_ANTLR3.g:1412:12: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {

                          
                      
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
            // ATL_ANTLR3.g:1420:2: ( ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) ) )
            // ATL_ANTLR3.g:1420:4: ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) )
            {
            // ATL_ANTLR3.g:1420:4: ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) )
            // ATL_ANTLR3.g:1420:5: ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' )
            {
            // ATL_ANTLR3.g:1420:5: ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' )
            // ATL_ANTLR3.g:1420:6: '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\''
            {
            match('\''); if (failed) return ;
            // ATL_ANTLR3.g:1420:11: ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='\'') ) {
                    alt16=2;
                }
                else if ( ((LA16_0>='\u0000' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='\uFFFE')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ATL_ANTLR3.g:1420:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )
            	    {
            	    // ATL_ANTLR3.g:1420:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )
            	    int alt15=3;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0=='\\') ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0=='\n') ) {
            	        alt15=2;
            	    }
            	    else if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFE')) ) {
            	        alt15=3;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1420:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )", 15, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // ATL_ANTLR3.g:1420:41: ( '\\\\' ~ '\\n' )
            	            {
            	            // ATL_ANTLR3.g:1420:41: ( '\\\\' ~ '\\n' )
            	            // ATL_ANTLR3.g:1420:42: '\\\\' ~ '\\n'
            	            {
            	            match('\\'); if (failed) return ;
            	            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFE') ) {
            	                input.consume();
            	            failed=false;
            	            }
            	            else {
            	                if (backtracking>0) {failed=true; return ;}
            	                MismatchedSetException mse =
            	                    new MismatchedSetException(null,input);
            	                recover(mse);    throw mse;
            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ATL_ANTLR3.g:1420:57: '\\n'
            	            {
            	            match('\n'); if (failed) return ;

            	            }
            	            break;
            	        case 3 :
            	            // ATL_ANTLR3.g:1420:63: ~ ( '\\\\' | '\\n' )
            	            {
            	            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	                input.consume();
            	            failed=false;
            	            }
            	            else {
            	                if (backtracking>0) {failed=true; return ;}
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
            	    break loop16;
                }
            } while (true);

            match('\''); if (failed) return ;

            }


            }

            if ( backtracking==0 ) {

                          
                      
            }

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    public void mTokens() throws RecognitionException {
        // ATL_ANTLR3.g:1:8: ( T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | NL | WS | NAME | INT | FLOAT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | SHARP | QMARK | AROBAS | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | ASSIGNARROW | COMMENT | STRING )
        int alt17=92;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // ATL_ANTLR3.g:1:10: T43
                {
                mT43(); if (failed) return ;

                }
                break;
            case 2 :
                // ATL_ANTLR3.g:1:14: T44
                {
                mT44(); if (failed) return ;

                }
                break;
            case 3 :
                // ATL_ANTLR3.g:1:18: T45
                {
                mT45(); if (failed) return ;

                }
                break;
            case 4 :
                // ATL_ANTLR3.g:1:22: T46
                {
                mT46(); if (failed) return ;

                }
                break;
            case 5 :
                // ATL_ANTLR3.g:1:26: T47
                {
                mT47(); if (failed) return ;

                }
                break;
            case 6 :
                // ATL_ANTLR3.g:1:30: T48
                {
                mT48(); if (failed) return ;

                }
                break;
            case 7 :
                // ATL_ANTLR3.g:1:34: T49
                {
                mT49(); if (failed) return ;

                }
                break;
            case 8 :
                // ATL_ANTLR3.g:1:38: T50
                {
                mT50(); if (failed) return ;

                }
                break;
            case 9 :
                // ATL_ANTLR3.g:1:42: T51
                {
                mT51(); if (failed) return ;

                }
                break;
            case 10 :
                // ATL_ANTLR3.g:1:46: T52
                {
                mT52(); if (failed) return ;

                }
                break;
            case 11 :
                // ATL_ANTLR3.g:1:50: T53
                {
                mT53(); if (failed) return ;

                }
                break;
            case 12 :
                // ATL_ANTLR3.g:1:54: T54
                {
                mT54(); if (failed) return ;

                }
                break;
            case 13 :
                // ATL_ANTLR3.g:1:58: T55
                {
                mT55(); if (failed) return ;

                }
                break;
            case 14 :
                // ATL_ANTLR3.g:1:62: T56
                {
                mT56(); if (failed) return ;

                }
                break;
            case 15 :
                // ATL_ANTLR3.g:1:66: T57
                {
                mT57(); if (failed) return ;

                }
                break;
            case 16 :
                // ATL_ANTLR3.g:1:70: T58
                {
                mT58(); if (failed) return ;

                }
                break;
            case 17 :
                // ATL_ANTLR3.g:1:74: T59
                {
                mT59(); if (failed) return ;

                }
                break;
            case 18 :
                // ATL_ANTLR3.g:1:78: T60
                {
                mT60(); if (failed) return ;

                }
                break;
            case 19 :
                // ATL_ANTLR3.g:1:82: T61
                {
                mT61(); if (failed) return ;

                }
                break;
            case 20 :
                // ATL_ANTLR3.g:1:86: T62
                {
                mT62(); if (failed) return ;

                }
                break;
            case 21 :
                // ATL_ANTLR3.g:1:90: T63
                {
                mT63(); if (failed) return ;

                }
                break;
            case 22 :
                // ATL_ANTLR3.g:1:94: T64
                {
                mT64(); if (failed) return ;

                }
                break;
            case 23 :
                // ATL_ANTLR3.g:1:98: T65
                {
                mT65(); if (failed) return ;

                }
                break;
            case 24 :
                // ATL_ANTLR3.g:1:102: T66
                {
                mT66(); if (failed) return ;

                }
                break;
            case 25 :
                // ATL_ANTLR3.g:1:106: T67
                {
                mT67(); if (failed) return ;

                }
                break;
            case 26 :
                // ATL_ANTLR3.g:1:110: T68
                {
                mT68(); if (failed) return ;

                }
                break;
            case 27 :
                // ATL_ANTLR3.g:1:114: T69
                {
                mT69(); if (failed) return ;

                }
                break;
            case 28 :
                // ATL_ANTLR3.g:1:118: T70
                {
                mT70(); if (failed) return ;

                }
                break;
            case 29 :
                // ATL_ANTLR3.g:1:122: T71
                {
                mT71(); if (failed) return ;

                }
                break;
            case 30 :
                // ATL_ANTLR3.g:1:126: T72
                {
                mT72(); if (failed) return ;

                }
                break;
            case 31 :
                // ATL_ANTLR3.g:1:130: T73
                {
                mT73(); if (failed) return ;

                }
                break;
            case 32 :
                // ATL_ANTLR3.g:1:134: T74
                {
                mT74(); if (failed) return ;

                }
                break;
            case 33 :
                // ATL_ANTLR3.g:1:138: T75
                {
                mT75(); if (failed) return ;

                }
                break;
            case 34 :
                // ATL_ANTLR3.g:1:142: T76
                {
                mT76(); if (failed) return ;

                }
                break;
            case 35 :
                // ATL_ANTLR3.g:1:146: T77
                {
                mT77(); if (failed) return ;

                }
                break;
            case 36 :
                // ATL_ANTLR3.g:1:150: T78
                {
                mT78(); if (failed) return ;

                }
                break;
            case 37 :
                // ATL_ANTLR3.g:1:154: T79
                {
                mT79(); if (failed) return ;

                }
                break;
            case 38 :
                // ATL_ANTLR3.g:1:158: T80
                {
                mT80(); if (failed) return ;

                }
                break;
            case 39 :
                // ATL_ANTLR3.g:1:162: T81
                {
                mT81(); if (failed) return ;

                }
                break;
            case 40 :
                // ATL_ANTLR3.g:1:166: T82
                {
                mT82(); if (failed) return ;

                }
                break;
            case 41 :
                // ATL_ANTLR3.g:1:170: T83
                {
                mT83(); if (failed) return ;

                }
                break;
            case 42 :
                // ATL_ANTLR3.g:1:174: T84
                {
                mT84(); if (failed) return ;

                }
                break;
            case 43 :
                // ATL_ANTLR3.g:1:178: T85
                {
                mT85(); if (failed) return ;

                }
                break;
            case 44 :
                // ATL_ANTLR3.g:1:182: T86
                {
                mT86(); if (failed) return ;

                }
                break;
            case 45 :
                // ATL_ANTLR3.g:1:186: T87
                {
                mT87(); if (failed) return ;

                }
                break;
            case 46 :
                // ATL_ANTLR3.g:1:190: T88
                {
                mT88(); if (failed) return ;

                }
                break;
            case 47 :
                // ATL_ANTLR3.g:1:194: T89
                {
                mT89(); if (failed) return ;

                }
                break;
            case 48 :
                // ATL_ANTLR3.g:1:198: T90
                {
                mT90(); if (failed) return ;

                }
                break;
            case 49 :
                // ATL_ANTLR3.g:1:202: T91
                {
                mT91(); if (failed) return ;

                }
                break;
            case 50 :
                // ATL_ANTLR3.g:1:206: T92
                {
                mT92(); if (failed) return ;

                }
                break;
            case 51 :
                // ATL_ANTLR3.g:1:210: T93
                {
                mT93(); if (failed) return ;

                }
                break;
            case 52 :
                // ATL_ANTLR3.g:1:214: T94
                {
                mT94(); if (failed) return ;

                }
                break;
            case 53 :
                // ATL_ANTLR3.g:1:218: T95
                {
                mT95(); if (failed) return ;

                }
                break;
            case 54 :
                // ATL_ANTLR3.g:1:222: T96
                {
                mT96(); if (failed) return ;

                }
                break;
            case 55 :
                // ATL_ANTLR3.g:1:226: T97
                {
                mT97(); if (failed) return ;

                }
                break;
            case 56 :
                // ATL_ANTLR3.g:1:230: T98
                {
                mT98(); if (failed) return ;

                }
                break;
            case 57 :
                // ATL_ANTLR3.g:1:234: T99
                {
                mT99(); if (failed) return ;

                }
                break;
            case 58 :
                // ATL_ANTLR3.g:1:238: NL
                {
                mNL(); if (failed) return ;

                }
                break;
            case 59 :
                // ATL_ANTLR3.g:1:241: WS
                {
                mWS(); if (failed) return ;

                }
                break;
            case 60 :
                // ATL_ANTLR3.g:1:244: NAME
                {
                mNAME(); if (failed) return ;

                }
                break;
            case 61 :
                // ATL_ANTLR3.g:1:249: INT
                {
                mINT(); if (failed) return ;

                }
                break;
            case 62 :
                // ATL_ANTLR3.g:1:253: FLOAT
                {
                mFLOAT(); if (failed) return ;

                }
                break;
            case 63 :
                // ATL_ANTLR3.g:1:259: LSQUARE
                {
                mLSQUARE(); if (failed) return ;

                }
                break;
            case 64 :
                // ATL_ANTLR3.g:1:267: RSQUARE
                {
                mRSQUARE(); if (failed) return ;

                }
                break;
            case 65 :
                // ATL_ANTLR3.g:1:275: EXCL
                {
                mEXCL(); if (failed) return ;

                }
                break;
            case 66 :
                // ATL_ANTLR3.g:1:280: COMA
                {
                mCOMA(); if (failed) return ;

                }
                break;
            case 67 :
                // ATL_ANTLR3.g:1:285: LPAREN
                {
                mLPAREN(); if (failed) return ;

                }
                break;
            case 68 :
                // ATL_ANTLR3.g:1:292: RPAREN
                {
                mRPAREN(); if (failed) return ;

                }
                break;
            case 69 :
                // ATL_ANTLR3.g:1:299: LCURLY
                {
                mLCURLY(); if (failed) return ;

                }
                break;
            case 70 :
                // ATL_ANTLR3.g:1:306: RCURLY
                {
                mRCURLY(); if (failed) return ;

                }
                break;
            case 71 :
                // ATL_ANTLR3.g:1:313: SEMI
                {
                mSEMI(); if (failed) return ;

                }
                break;
            case 72 :
                // ATL_ANTLR3.g:1:318: COLON
                {
                mCOLON(); if (failed) return ;

                }
                break;
            case 73 :
                // ATL_ANTLR3.g:1:324: PIPE
                {
                mPIPE(); if (failed) return ;

                }
                break;
            case 74 :
                // ATL_ANTLR3.g:1:329: SHARP
                {
                mSHARP(); if (failed) return ;

                }
                break;
            case 75 :
                // ATL_ANTLR3.g:1:335: QMARK
                {
                mQMARK(); if (failed) return ;

                }
                break;
            case 76 :
                // ATL_ANTLR3.g:1:341: AROBAS
                {
                mAROBAS(); if (failed) return ;

                }
                break;
            case 77 :
                // ATL_ANTLR3.g:1:348: POINT
                {
                mPOINT(); if (failed) return ;

                }
                break;
            case 78 :
                // ATL_ANTLR3.g:1:354: RARROW
                {
                mRARROW(); if (failed) return ;

                }
                break;
            case 79 :
                // ATL_ANTLR3.g:1:361: MINUS
                {
                mMINUS(); if (failed) return ;

                }
                break;
            case 80 :
                // ATL_ANTLR3.g:1:367: STAR
                {
                mSTAR(); if (failed) return ;

                }
                break;
            case 81 :
                // ATL_ANTLR3.g:1:372: SLASH
                {
                mSLASH(); if (failed) return ;

                }
                break;
            case 82 :
                // ATL_ANTLR3.g:1:378: PLUS
                {
                mPLUS(); if (failed) return ;

                }
                break;
            case 83 :
                // ATL_ANTLR3.g:1:383: EQ
                {
                mEQ(); if (failed) return ;

                }
                break;
            case 84 :
                // ATL_ANTLR3.g:1:386: GT
                {
                mGT(); if (failed) return ;

                }
                break;
            case 85 :
                // ATL_ANTLR3.g:1:389: LT
                {
                mLT(); if (failed) return ;

                }
                break;
            case 86 :
                // ATL_ANTLR3.g:1:392: GE
                {
                mGE(); if (failed) return ;

                }
                break;
            case 87 :
                // ATL_ANTLR3.g:1:395: LE
                {
                mLE(); if (failed) return ;

                }
                break;
            case 88 :
                // ATL_ANTLR3.g:1:398: NE
                {
                mNE(); if (failed) return ;

                }
                break;
            case 89 :
                // ATL_ANTLR3.g:1:401: LARROW
                {
                mLARROW(); if (failed) return ;

                }
                break;
            case 90 :
                // ATL_ANTLR3.g:1:408: ASSIGNARROW
                {
                mASSIGNARROW(); if (failed) return ;

                }
                break;
            case 91 :
                // ATL_ANTLR3.g:1:420: COMMENT
                {
                mCOMMENT(); if (failed) return ;

                }
                break;
            case 92 :
                // ATL_ANTLR3.g:1:428: STRING
                {
                mSTRING(); if (failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // ATL_ANTLR3.g:1138:17: ( '.' DIGIT )
        // ATL_ANTLR3.g:1138:18: '.' DIGIT
        {
        match('.'); if (failed) return ;
        mDIGIT(); if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\1\uffff\31\34\3\uffff\1\143\17\uffff\1\147\4\uffff\1\151\1\156"+
        "\1\uffff\21\34\1\u0081\7\34\1\u008c\1\34\1\u008e\1\34\1\u0090\16"+
        "\34\1\u00a0\1\34\14\uffff\1\u00a3\6\34\1\u00ab\3\34\1\u00af\5\34"+
        "\1\u00b5\1\uffff\1\u00b6\2\34\1\u00b9\1\34\1\u00bb\4\34\1\uffff"+
        "\1\34\1\uffff\1\34\1\uffff\5\34\1\u00ca\2\34\1\u00cd\1\34\1\u00cf"+
        "\4\34\1\uffff\1\u00d4\1\34\1\uffff\4\34\1\u00da\1\u00db\1\34\1\uffff"+
        "\2\34\1\u00df\1\uffff\1\34\1\u00e1\3\34\2\uffff\2\34\1\uffff\1\34"+
        "\1\uffff\4\34\1\u00ec\2\34\1\u00ef\1\u00f0\5\34\1\uffff\2\34\1\uffff"+
        "\1\34\1\uffff\2\34\1\u00fb\1\34\1\uffff\5\34\2\uffff\1\34\1\u0103"+
        "\1\34\1\uffff\1\u0105\1\uffff\1\u0106\6\34\1\u010d\2\34\1\uffff"+
        "\2\34\2\uffff\4\34\1\u0116\3\34\1\u011b\1\34\1\uffff\1\34\1\u011e"+
        "\1\u011f\1\u0120\3\34\1\uffff\1\34\2\uffff\1\u0125\1\u0126\4\34"+
        "\1\uffff\5\34\1\u0130\2\34\1\uffff\2\34\1\u0135\1\34\1\uffff\2\34"+
        "\3\uffff\1\u0139\1\34\1\u013b\1\u013c\2\uffff\3\34\1\u0140\2\34"+
        "\1\u0143\1\u0144\1\34\1\uffff\1\u0146\1\34\1\u0148\1\34\1\uffff"+
        "\1\34\1\u014b\1\34\1\uffff\1\u014d\2\uffff\1\u014e\1\34\1\u0150"+
        "\1\uffff\1\u0151\1\34\2\uffff\1\34\1\uffff\1\34\1\uffff\1\u0155"+
        "\1\34\1\uffff\1\34\2\uffff\1\u0158\2\uffff\3\34\1\uffff\1\u015c"+
        "\1\34\1\uffff\1\u015e\1\34\1\u0160\1\uffff\1\u0161\1\uffff\1\34"+
        "\2\uffff\1\u0163\1\uffff";
    static final String DFA17_eofS =
        "\u0164\uffff";
    static final String DFA17_minS =
        "\1\11\1\141\1\157\1\145\2\141\1\165\1\156\2\145\1\157\1\142\1\154"+
        "\1\146\1\150\1\143\1\165\1\141\1\145\1\141\1\165\1\156\1\145\1\157"+
        "\1\162\1\157\3\uffff\1\56\17\uffff\1\55\4\uffff\1\75\1\55\1\uffff"+
        "\1\144\1\160\1\145\1\156\1\146\1\154\1\157\1\162\1\154\1\142\1\172"+
        "\1\164\2\145\1\151\1\154\1\146\1\60\1\163\1\144\1\163\1\144\1\164"+
        "\1\144\1\163\1\60\1\145\1\60\1\160\1\60\1\145\1\165\1\154\1\144"+
        "\1\160\1\147\1\157\1\161\1\162\2\160\1\164\1\141\1\154\1\60\1\162"+
        "\14\uffff\1\60\1\163\1\141\1\164\1\151\1\145\1\155\1\60\1\163\1"+
        "\162\1\171\1\60\1\162\1\163\1\156\1\161\1\160\1\60\1\uffff\1\60"+
        "\1\164\1\145\1\60\1\164\1\60\1\145\1\151\1\162\1\145\1\uffff\1\162"+
        "\1\uffff\1\154\1\uffff\1\156\1\145\1\101\2\145\1\60\1\154\1\165"+
        "\1\60\1\151\1\60\1\154\1\145\2\154\1\uffff\1\60\1\154\1\uffff\1"+
        "\124\1\164\1\145\1\156\2\60\1\141\1\uffff\1\145\1\141\1\60\1\uffff"+
        "\1\171\1\60\1\147\1\165\1\145\2\uffff\1\151\1\146\1\uffff\1\162"+
        "\1\uffff\1\156\1\146\1\157\1\171\1\60\1\141\1\151\2\60\2\156\1\171"+
        "\2\162\1\uffff\2\145\1\uffff\1\156\1\uffff\1\145\1\147\1\60\1\145"+
        "\1\uffff\1\145\1\157\1\145\1\170\1\151\2\uffff\1\143\1\60\1\162"+
        "\1\uffff\1\60\1\uffff\1\60\1\145\1\162\1\156\2\141\1\144\1\60\1"+
        "\151\1\160\1\uffff\1\164\1\145\2\uffff\1\144\1\171\1\160\1\145\1"+
        "\60\1\141\1\156\1\147\1\60\1\145\1\uffff\1\143\3\60\1\164\1\156"+
        "\1\150\1\uffff\1\171\2\uffff\2\60\1\143\1\165\1\143\1\163\1\uffff"+
        "\1\156\1\157\1\145\1\163\1\145\1\60\1\145\1\144\1\uffff\1\156\1"+
        "\143\1\60\1\171\1\uffff\1\162\1\164\3\uffff\1\60\1\147\2\60\2\uffff"+
        "\1\164\1\154\1\164\1\60\1\164\1\151\2\60\1\146\1\uffff\1\60\1\123"+
        "\1\60\1\145\1\uffff\1\160\1\60\1\151\1\uffff\1\60\2\uffff\1\60\1"+
        "\164\1\60\1\uffff\1\60\1\156\2\uffff\1\151\1\uffff\1\145\1\uffff"+
        "\1\60\1\145\1\uffff\1\157\2\uffff\1\60\2\uffff\1\164\1\156\1\164"+
        "\1\uffff\1\60\1\156\1\uffff\1\60\1\145\1\60\1\uffff\1\60\1\uffff"+
        "\1\144\2\uffff\1\60\1\uffff";
    static final String DFA17_maxS =
        "\1\u00ff\1\157\1\162\1\165\1\162\1\151\1\165\1\163\1\145\2\157\1"+
        "\156\1\170\1\164\2\162\1\165\1\157\1\164\1\141\1\165\1\156\1\145"+
        "\1\157\1\162\1\157\3\uffff\1\71\17\uffff\1\76\4\uffff\1\75\1\76"+
        "\1\uffff\1\144\1\160\1\145\1\156\1\146\1\154\1\157\1\162\1\154\1"+
        "\142\1\172\1\164\1\145\2\151\1\154\1\146\1\u00ff\1\166\1\164\1\163"+
        "\1\144\2\164\1\163\1\u00ff\1\145\1\u00ff\1\160\1\u00ff\1\145\1\165"+
        "\1\154\1\144\1\160\1\147\1\157\1\164\1\162\2\160\1\164\1\141\1\154"+
        "\1\u00ff\1\162\14\uffff\1\u00ff\1\163\1\141\1\164\1\151\1\145\1"+
        "\155\1\u00ff\1\163\1\162\1\171\1\u00ff\1\162\1\163\1\156\1\161\1"+
        "\160\1\u00ff\1\uffff\1\u00ff\1\164\1\145\1\u00ff\1\164\1\u00ff\1"+
        "\145\1\160\1\162\1\145\1\uffff\1\162\1\uffff\1\154\1\uffff\1\156"+
        "\1\145\1\125\2\145\1\u00ff\1\154\1\165\1\u00ff\1\151\1\u00ff\1\154"+
        "\1\145\2\154\1\uffff\1\u00ff\1\154\1\uffff\1\124\1\164\1\145\1\156"+
        "\2\u00ff\1\141\1\uffff\1\145\1\141\1\u00ff\1\uffff\1\171\1\u00ff"+
        "\1\147\1\165\1\145\2\uffff\1\151\1\146\1\uffff\1\162\1\uffff\1\156"+
        "\1\146\1\157\1\171\1\u00ff\1\141\1\151\2\u00ff\2\156\1\171\2\162"+
        "\1\uffff\2\145\1\uffff\1\156\1\uffff\1\145\1\147\1\u00ff\1\145\1"+
        "\uffff\1\145\1\157\1\145\1\170\1\151\2\uffff\1\143\1\u00ff\1\162"+
        "\1\uffff\1\u00ff\1\uffff\1\u00ff\1\145\1\162\1\156\2\141\1\144\1"+
        "\u00ff\1\151\1\160\1\uffff\1\164\1\145\2\uffff\1\144\1\171\1\160"+
        "\1\145\1\u00ff\1\141\1\156\1\147\1\u00ff\1\145\1\uffff\1\143\3\u00ff"+
        "\1\164\1\156\1\150\1\uffff\1\171\2\uffff\2\u00ff\1\143\1\165\1\143"+
        "\1\163\1\uffff\1\156\1\157\1\145\1\163\1\145\1\u00ff\1\145\1\144"+
        "\1\uffff\1\156\1\143\1\u00ff\1\171\1\uffff\1\162\1\164\3\uffff\1"+
        "\u00ff\1\147\2\u00ff\2\uffff\1\164\1\154\1\164\1\u00ff\1\164\1\151"+
        "\2\u00ff\1\146\1\uffff\1\u00ff\1\123\1\u00ff\1\145\1\uffff\1\160"+
        "\1\u00ff\1\151\1\uffff\1\u00ff\2\uffff\1\u00ff\1\164\1\u00ff\1\uffff"+
        "\1\u00ff\1\156\2\uffff\1\151\1\uffff\1\145\1\uffff\1\u00ff\1\145"+
        "\1\uffff\1\157\2\uffff\1\u00ff\2\uffff\1\164\1\156\1\164\1\uffff"+
        "\1\u00ff\1\156\1\uffff\1\u00ff\1\145\1\u00ff\1\uffff\1\u00ff\1\uffff"+
        "\1\144\2\uffff\1\u00ff\1\uffff";
    static final String DFA17_acceptS =
        "\32\uffff\1\72\1\73\1\74\1\uffff\1\77\1\100\1\101\1\102\1\103\1"+
        "\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\uffff"+
        "\1\120\1\121\1\122\1\123\2\uffff\1\134\56\uffff\1\75\1\76\1\133"+
        "\1\116\1\117\1\126\1\124\1\131\1\132\1\127\1\130\1\125\22\uffff"+
        "\1\31\12\uffff\1\32\1\uffff\1\24\1\uffff\1\25\17\uffff\1\67\2\uffff"+
        "\1\65\7\uffff\1\34\3\uffff\1\44\5\uffff\1\11\1\64\2\uffff\1\63\1"+
        "\uffff\1\66\16\uffff\1\45\2\uffff\1\46\1\uffff\1\51\4\uffff\1\70"+
        "\5\uffff\1\15\1\4\3\uffff\1\21\1\uffff\1\7\12\uffff\1\33\2\uffff"+
        "\1\41\1\37\12\uffff\1\57\7\uffff\1\40\1\uffff\1\6\1\17\6\uffff\1"+
        "\42\10\uffff\1\43\4\uffff\1\52\2\uffff\1\1\1\26\1\2\4\uffff\1\20"+
        "\1\10\11\uffff\1\54\4\uffff\1\61\3\uffff\1\12\1\uffff\1\30\1\5\3"+
        "\uffff\1\16\2\uffff\1\35\1\71\1\uffff\1\53\1\uffff\1\60\2\uffff"+
        "\1\56\1\uffff\1\3\1\27\1\uffff\1\14\1\23\3\uffff\1\50\2\uffff\1"+
        "\13\3\uffff\1\55\1\uffff\1\22\1\uffff\1\47\1\62\1\uffff\1\36";
    static final String DFA17_specialS =
        "\u0164\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\33\1\32\2\uffff\1\32\22\uffff\1\33\1\40\1\34\1\51\3\uffff"+
            "\1\64\1\42\1\43\1\56\1\60\1\41\1\55\1\54\1\57\12\35\1\47\1\46"+
            "\1\63\1\61\1\62\1\52\1\53\1\34\1\21\1\27\5\34\1\25\3\34\1\23"+
            "\1\34\1\17\2\34\1\26\1\22\1\24\6\34\1\36\1\uffff\1\37\1\uffff"+
            "\1\34\1\uffff\1\13\1\34\1\2\1\11\1\14\1\4\1\34\1\10\1\15\2\34"+
            "\1\5\1\1\1\12\1\30\1\34\1\6\1\3\1\20\1\16\1\7\2\34\1\31\2\34"+
            "\1\44\1\50\1\45\102\uffff\27\34\1\uffff\37\34\1\uffff\10\34",
            "\1\66\15\uffff\1\65",
            "\1\70\2\uffff\1\67",
            "\1\71\17\uffff\1\72",
            "\1\75\15\uffff\1\74\2\uffff\1\73",
            "\1\77\3\uffff\1\100\3\uffff\1\76",
            "\1\101",
            "\1\103\4\uffff\1\102",
            "\1\104",
            "\1\105\3\uffff\1\107\5\uffff\1\106",
            "\1\110",
            "\1\111\13\uffff\1\112",
            "\1\115\1\uffff\1\114\11\uffff\1\113",
            "\1\116\6\uffff\1\121\1\120\5\uffff\1\117",
            "\1\123\6\uffff\1\122\2\uffff\1\124",
            "\1\125\16\uffff\1\126",
            "\1\127",
            "\1\130\15\uffff\1\131",
            "\1\132\16\uffff\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "",
            "",
            "",
            "\1\144\1\uffff\12\35",
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
            "\1\145\20\uffff\1\146",
            "",
            "",
            "",
            "",
            "\1\150",
            "\1\152\14\uffff\1\153\2\uffff\1\154\1\155",
            "",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174\3\uffff\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0083\2\uffff\1\u0082",
            "\1\u0084\17\uffff\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089\17\uffff\1\u008a",
            "\1\u008b",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u008d",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u008f",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098\2\uffff\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00a1",
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
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\24\34\1\u00a2\5\34"+
            "\105\uffff\27\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\4\34\1\u00aa\25\34"+
            "\105\uffff\27\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00b7",
            "\1\u00b8",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00ba",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00bc",
            "\1\u00bd\6\uffff\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "",
            "\1\u00c1",
            "",
            "\1\u00c2",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c6\22\uffff\1\u00c7\1\u00c5",
            "\1\u00c8",
            "\1\u00c9",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00cb",
            "\1\u00cc",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00ce",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00d5",
            "",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00dc",
            "",
            "\1\u00dd",
            "\1\u00de",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "",
            "\1\u00e0",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "",
            "",
            "\1\u00e5",
            "\1\u00e6",
            "",
            "\1\u00e7",
            "",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00ed",
            "\1\u00ee",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "",
            "\1\u00f6",
            "\1\u00f7",
            "",
            "\1\u00f8",
            "",
            "\1\u00f9",
            "\1\u00fa",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u00fc",
            "",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "",
            "",
            "\1\u0102",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0104",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u010e",
            "\1\u010f",
            "",
            "\1\u0110",
            "\1\u0111",
            "",
            "",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\12\34\7\uffff\23\34\1\u011a\6\34\4\uffff\1\34\1\uffff\32\34"+
            "\105\uffff\27\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u011c",
            "",
            "\1\u011d",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "",
            "\1\u0124",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0131",
            "\1\u0132",
            "",
            "\1\u0133",
            "\1\u0134",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0136",
            "",
            "\1\u0137",
            "\1\u0138",
            "",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u013a",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "",
            "",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0141",
            "\1\u0142",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0145",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0147",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0149",
            "",
            "\1\u014a",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u014c",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u014f",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0152",
            "",
            "",
            "\1\u0153",
            "",
            "\1\u0154",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u0156",
            "",
            "\1\u0157",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "",
            "",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u015d",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "\1\u015f",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
            "",
            "\1\u0162",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34\105\uffff\27"+
            "\34\1\uffff\37\34\1\uffff\10\34",
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
            return "1:1: Tokens : ( T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | NL | WS | NAME | INT | FLOAT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | SHARP | QMARK | AROBAS | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | ASSIGNARROW | COMMENT | STRING );";
        }
    }
 

}