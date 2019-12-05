// $ANTLR 3.2 Sep 23, 2009 12:02:23 ACG_ANTLR3.g 2019-12-05 18:11:16
package org.eclipse.m2m.atl.dsls.tcs.injector;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ACG_ANTLR3Lexer extends Lexer {
    public static final int T__50=50;
    public static final int QMARK=39;
    public static final int MINUS=21;
    public static final int RSQUARE=17;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int COMA=11;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int LPAREN=10;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int SEMI=14;
    public static final int COLONCOLON=9;
    public static final int COMMENT=41;
    public static final int ESC=35;
    public static final int RCURLY=8;
    public static final int LCURLY=7;
    public static final int RARROW=20;
    public static final int T__48=48;
    public static final int STAR=22;
    public static final int T__49=49;
    public static final int LARROW=40;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int STRING=5;
    public static final int LE=28;
    public static final int SHARP=38;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int EXCL=37;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int LT=26;
    public static final int ALPHA=33;
    public static final int PIPE=15;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RPAREN=12;
    public static final int EQ=13;
    public static final int NAME=4;
    public static final int NE=29;
    public static final int NL=30;
    public static final int PLUS=24;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int FLOAT=36;
    public static final int T__72=72;
    public static final int INT=6;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int WS=31;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int GE=27;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int SLASH=23;
    public static final int SNAME=34;
    public static final int COLON=18;
    public static final int GT=25;
    public static final int DIGIT=32;
    public static final int LSQUARE=16;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int POINT=19;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__105=105;


    	private void newline() {}

    	public org.eclipse.m2m.atl.dsls.tcs.injector.TCSRuntime ei = null;

    	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    		ei.reportError((Exception)e);
    	}

    	public Token emit() {
    		org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken ret = null;

    		ret = new org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken(input, state.type, state.channel, state.tokenStartCharIndex, getCharIndex()-1);
    		ret.setLine(state.tokenStartLine);
    		ret.setText(state.text);
    	  	ret.setCharPositionInLine(state.tokenStartCharPositionInLine);
    		ret.setEndLine(getLine());
    		ret.setEndColumn(getCharPositionInLine());
    		emit(ret);

    		return ret;
    	}



    // delegates
    // delegators

    public ACG_ANTLR3Lexer() {;} 
    public ACG_ANTLR3Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ACG_ANTLR3Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "ACG_ANTLR3.g"; }

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:30:7: ( 'acg' )
            // ACG_ANTLR3.g:30:9: 'acg'
            {
            match("acg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:31:7: ( 'startsWith' )
            // ACG_ANTLR3.g:31:9: 'startsWith'
            {
            match("startsWith"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:32:7: ( 'function' )
            // ACG_ANTLR3.g:32:9: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:33:7: ( 'attribute' )
            // ACG_ANTLR3.g:33:9: 'attribute'
            {
            match("attribute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:34:7: ( 'asm' )
            // ACG_ANTLR3.g:34:9: 'asm'
            {
            match("asm"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:35:7: ( 'name' )
            // ACG_ANTLR3.g:35:9: 'name'
            {
            match("name"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:36:7: ( 'code' )
            // ACG_ANTLR3.g:36:9: 'code'
            {
            match("code"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:37:7: ( 'mode' )
            // ACG_ANTLR3.g:37:9: 'mode'
            {
            match("mode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:38:7: ( 'foreach' )
            // ACG_ANTLR3.g:38:9: 'foreach'
            {
            match("foreach"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:39:7: ( 'in' )
            // ACG_ANTLR3.g:39:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:40:7: ( 'variable' )
            // ACG_ANTLR3.g:40:9: 'variable'
            {
            match("variable"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:41:7: ( 'named' )
            // ACG_ANTLR3.g:41:9: 'named'
            {
            match("named"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:42:7: ( 'operation' )
            // ACG_ANTLR3.g:42:9: 'operation'
            {
            match("operation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:43:7: ( 'context' )
            // ACG_ANTLR3.g:43:9: 'context'
            {
            match("context"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:44:7: ( 'if' )
            // ACG_ANTLR3.g:44:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:45:7: ( 'else' )
            // ACG_ANTLR3.g:45:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:46:7: ( 'let' )
            // ACG_ANTLR3.g:46:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:47:7: ( 'analyze' )
            // ACG_ANTLR3.g:47:9: 'analyze'
            {
            match("analyze"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:48:7: ( 'report' )
            // ACG_ANTLR3.g:48:9: 'report'
            {
            match("report"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:49:7: ( 'critic' )
            // ACG_ANTLR3.g:49:9: 'critic'
            {
            match("critic"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:50:7: ( 'error' )
            // ACG_ANTLR3.g:50:9: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:51:7: ( 'warning' )
            // ACG_ANTLR3.g:51:9: 'warning'
            {
            match("warning"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:52:7: ( 'field' )
            // ACG_ANTLR3.g:52:9: 'field'
            {
            match("field"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:53:7: ( 'param' )
            // ACG_ANTLR3.g:53:9: 'param'
            {
            match("param"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:54:7: ( 'new' )
            // ACG_ANTLR3.g:54:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:55:7: ( 'newin' )
            // ACG_ANTLR3.g:55:9: 'newin'
            {
            match("newin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:56:7: ( 'delete' )
            // ACG_ANTLR3.g:56:9: 'delete'
            {
            match("delete"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:57:7: ( 'dup' )
            // ACG_ANTLR3.g:57:9: 'dup'
            {
            match("dup"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:58:7: ( 'dup_x1' )
            // ACG_ANTLR3.g:58:9: 'dup_x1'
            {
            match("dup_x1"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:59:7: ( 'pop' )
            // ACG_ANTLR3.g:59:9: 'pop'
            {
            match("pop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:60:7: ( 'swap' )
            // ACG_ANTLR3.g:60:9: 'swap'
            {
            match("swap"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:61:7: ( 'iterate' )
            // ACG_ANTLR3.g:61:9: 'iterate'
            {
            match("iterate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:62:7: ( 'enditerate' )
            // ACG_ANTLR3.g:62:9: 'enditerate'
            {
            match("enditerate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:63:7: ( 'getasm' )
            // ACG_ANTLR3.g:63:9: 'getasm'
            {
            match("getasm"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:64:7: ( 'findme' )
            // ACG_ANTLR3.g:64:9: 'findme'
            {
            match("findme"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:65:7: ( 'pusht' )
            // ACG_ANTLR3.g:65:9: 'pusht'
            {
            match("pusht"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:66:7: ( 'pushf' )
            // ACG_ANTLR3.g:66:9: 'pushf'
            {
            match("pushf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:67:7: ( 'push' )
            // ACG_ANTLR3.g:67:9: 'push'
            {
            match("push"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:68:7: ( 'pushi' )
            // ACG_ANTLR3.g:68:9: 'pushi'
            {
            match("pushi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:69:7: ( 'pushd' )
            // ACG_ANTLR3.g:69:9: 'pushd'
            {
            match("pushd"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:70:7: ( 'load' )
            // ACG_ANTLR3.g:70:9: 'load'
            {
            match("load"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:71:7: ( 'store' )
            // ACG_ANTLR3.g:71:9: 'store'
            {
            match("store"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:72:7: ( 'call' )
            // ACG_ANTLR3.g:72:9: 'call'
            {
            match("call"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:73:7: ( 'pcall' )
            // ACG_ANTLR3.g:73:9: 'pcall'
            {
            match("pcall"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:74:7: ( 'supercall' )
            // ACG_ANTLR3.g:74:9: 'supercall'
            {
            match("supercall"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:75:7: ( 'get' )
            // ACG_ANTLR3.g:75:9: 'get'
            {
            match("get"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:76:7: ( 'set' )
            // ACG_ANTLR3.g:76:9: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:77:7: ( 'goto' )
            // ACG_ANTLR3.g:77:9: 'goto'
            {
            match("goto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:78:7: ( 'self' )
            // ACG_ANTLR3.g:78:9: 'self'
            {
            match("self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:79:7: ( 'last' )
            // ACG_ANTLR3.g:79:9: 'last'
            {
            match("last"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:80:7: ( 'then' )
            // ACG_ANTLR3.g:80:9: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:81:7: ( 'endif' )
            // ACG_ANTLR3.g:81:9: 'endif'
            {
            match("endif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:82:7: ( 'OclUndefined' )
            // ACG_ANTLR3.g:82:9: 'OclUndefined'
            {
            match("OclUndefined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:83:7: ( 'Sequence' )
            // ACG_ANTLR3.g:83:9: 'Sequence'
            {
            match("Sequence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:84:7: ( 'true' )
            // ACG_ANTLR3.g:84:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:85:7: ( 'false' )
            // ACG_ANTLR3.g:85:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:86:7: ( 'not' )
            // ACG_ANTLR3.g:86:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:87:7: ( 'div' )
            // ACG_ANTLR3.g:87:9: 'div'
            {
            match("div"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:88:8: ( 'mod' )
            // ACG_ANTLR3.g:88:10: 'mod'
            {
            match("mod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:89:8: ( 'isa' )
            // ACG_ANTLR3.g:89:10: 'isa'
            {
            match("isa"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:90:8: ( 'and' )
            // ACG_ANTLR3.g:90:10: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:91:8: ( 'or' )
            // ACG_ANTLR3.g:91:10: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:92:8: ( 'xor' )
            // ACG_ANTLR3.g:92:10: 'xor'
            {
            match("xor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:93:8: ( 'implies' )
            // ACG_ANTLR3.g:93:10: 'implies'
            {
            match("implies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:931:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ACG_ANTLR3.g:931:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ACG_ANTLR3.g:931:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ACG_ANTLR3.g:931:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:932:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:933:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // ACG_ANTLR3.g:934:5: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

            newline();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:940:2: ( ( ' ' | '\\t' ) )
            // ACG_ANTLR3.g:940:4: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // ACG_ANTLR3.g:947:2: ( '0' .. '9' )
            // ACG_ANTLR3.g:947:4: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // ACG_ANTLR3.g:952:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ACG_ANTLR3.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "SNAME"
    public final void mSNAME() throws RecognitionException {
        try {
            // ACG_ANTLR3.g:966:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ACG_ANTLR3.g:966:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ACG_ANTLR3.g:966:4: ( ALPHA )
            // ACG_ANTLR3.g:966:5: ALPHA
            {
            mALPHA(); 

            }

            // ACG_ANTLR3.g:966:12: ( ALPHA | DIGIT )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')||(LA2_0>='\u00C0' && LA2_0<='\u00D6')||(LA2_0>='\u00D8' && LA2_0<='\u00F6')||(LA2_0>='\u00F8' && LA2_0<='\u00FF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ACG_ANTLR3.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
    // $ANTLR end "SNAME"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:970:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ACG_ANTLR3.g:970:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ACG_ANTLR3.g:970:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ACG_ANTLR3.g:971:4: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:973:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); 
                    // ACG_ANTLR3.g:974:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
                        else if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                            alt3=3;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:974:6: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ACG_ANTLR3.g:975:6: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // ACG_ANTLR3.g:976:6: ~ ( '\\\\' | '\\\"' | '\\n' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:984:2: ( ( DIGIT )+ )
            // ACG_ANTLR3.g:984:4: ( DIGIT )+
            {
            // ACG_ANTLR3.g:984:4: ( DIGIT )+
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
            	    // ACG_ANTLR3.g:984:5: DIGIT
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:988:7: ( ( DIGIT )+ '.' ( DIGIT )* )
            // ACG_ANTLR3.g:988:9: ( DIGIT )+ '.' ( DIGIT )*
            {
            // ACG_ANTLR3.g:988:9: ( DIGIT )+
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
            	    // ACG_ANTLR3.g:988:9: DIGIT
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
            // ACG_ANTLR3.g:988:20: ( DIGIT )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ACG_ANTLR3.g:988:20: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // ACG_ANTLR3.g:992:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ACG_ANTLR3.g:992:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // ACG_ANTLR3.g:993:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
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
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ACG_ANTLR3.g:993:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:994:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:995:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // ACG_ANTLR3.g:996:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // ACG_ANTLR3.g:997:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // ACG_ANTLR3.g:998:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // ACG_ANTLR3.g:999:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // ACG_ANTLR3.g:1000:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // ACG_ANTLR3.g:1001:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ACG_ANTLR3.g:1001:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
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
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // ACG_ANTLR3.g:1002:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ACG_ANTLR3.g:1002:5: ( '0' .. '3' )
                            // ACG_ANTLR3.g:1002:6: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // ACG_ANTLR3.g:1003:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // ACG_ANTLR3.g:1007:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ACG_ANTLR3.g:1007:7: ( '0' .. '7' )
                                    // ACG_ANTLR3.g:1007:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // ACG_ANTLR3.g:1008:6: ( '0' .. '7' )?
                                    int alt8=2;
                                    int LA8_0 = input.LA(1);

                                    if ( ((LA8_0>='0' && LA8_0<='7')) ) {
                                        alt8=1;
                                    }
                                    switch (alt8) {
                                        case 1 :
                                            // ACG_ANTLR3.g:1012:8: '0' .. '7'
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
                            // ACG_ANTLR3.g:1015:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ACG_ANTLR3.g:1015:6: ( '4' .. '7' )
                            // ACG_ANTLR3.g:1015:7: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // ACG_ANTLR3.g:1016:5: ( ( '0' .. '7' ) )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // ACG_ANTLR3.g:1020:7: ( '0' .. '7' )
                                    {
                                    // ACG_ANTLR3.g:1020:7: ( '0' .. '7' )
                                    // ACG_ANTLR3.g:1020:8: '0' .. '7'
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
    // $ANTLR end "ESC"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1036:2: ( ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) ) )
            // ACG_ANTLR3.g:1036:4: ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) )
            {
            // ACG_ANTLR3.g:1036:4: ( ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' ) )
            // ACG_ANTLR3.g:1036:5: ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' )
            {
            // ACG_ANTLR3.g:1036:5: ( '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\'' )
            // ACG_ANTLR3.g:1036:6: '\\'' ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )* '\\''
            {
            match('\''); 
            // ACG_ANTLR3.g:1036:11: ( options {greedy=false; } : ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='\'') ) {
                    alt14=2;
                }
                else if ( ((LA14_0>='\u0000' && LA14_0<='&')||(LA14_0>='(' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ACG_ANTLR3.g:1036:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )
            	    {
            	    // ACG_ANTLR3.g:1036:40: ( ( '\\\\' ~ '\\n' ) | '\\n' | ~ ( '\\\\' | '\\n' ) )
            	    int alt13=3;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0=='\\') ) {
            	        alt13=1;
            	    }
            	    else if ( (LA13_0=='\n') ) {
            	        alt13=2;
            	    }
            	    else if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
            	        alt13=3;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // ACG_ANTLR3.g:1036:41: ( '\\\\' ~ '\\n' )
            	            {
            	            // ACG_ANTLR3.g:1036:41: ( '\\\\' ~ '\\n' )
            	            // ACG_ANTLR3.g:1036:42: '\\\\' ~ '\\n'
            	            {
            	            match('\\'); 
            	            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFF') ) {
            	                input.consume();

            	            }
            	            else {
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                recover(mse);
            	                throw mse;}


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ACG_ANTLR3.g:1036:56: '\\n'
            	            {
            	            match('\n'); 

            	            }
            	            break;
            	        case 3 :
            	            // ACG_ANTLR3.g:1036:62: ~ ( '\\\\' | '\\n' )
            	            {
            	            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	                input.consume();

            	            }
            	            else {
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                recover(mse);
            	                throw mse;}


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match('\''); 

            }


            }


                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1045:2: ( '[' )
            // ACG_ANTLR3.g:1045:4: '['
            {
            match('['); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LSQUARE"

    // $ANTLR start "RSQUARE"
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1053:2: ( ']' )
            // ACG_ANTLR3.g:1053:4: ']'
            {
            match(']'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RSQUARE"

    // $ANTLR start "EXCL"
    public final void mEXCL() throws RecognitionException {
        try {
            int _type = EXCL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1061:2: ( '!' )
            // ACG_ANTLR3.g:1061:4: '!'
            {
            match('!'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCL"

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1069:2: ( ',' )
            // ACG_ANTLR3.g:1069:4: ','
            {
            match(','); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMA"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1077:2: ( '(' )
            // ACG_ANTLR3.g:1077:4: '('
            {
            match('('); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1085:2: ( ')' )
            // ACG_ANTLR3.g:1085:4: ')'
            {
            match(')'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1093:2: ( '{' )
            // ACG_ANTLR3.g:1093:4: '{'
            {
            match('{'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1101:2: ( '}' )
            // ACG_ANTLR3.g:1101:4: '}'
            {
            match('}'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1109:2: ( ';' )
            // ACG_ANTLR3.g:1109:4: ';'
            {
            match(';'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1117:2: ( ':' )
            // ACG_ANTLR3.g:1117:4: ':'
            {
            match(':'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1125:2: ( '|' )
            // ACG_ANTLR3.g:1125:4: '|'
            {
            match('|'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIPE"

    // $ANTLR start "SHARP"
    public final void mSHARP() throws RecognitionException {
        try {
            int _type = SHARP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1133:2: ( '#' )
            // ACG_ANTLR3.g:1133:4: '#'
            {
            match('#'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHARP"

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1141:2: ( '?' )
            // ACG_ANTLR3.g:1141:4: '?'
            {
            match('?'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QMARK"

    // $ANTLR start "COLONCOLON"
    public final void mCOLONCOLON() throws RecognitionException {
        try {
            int _type = COLONCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1149:2: ( '::' )
            // ACG_ANTLR3.g:1149:4: '::'
            {
            match("::"); 


                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLONCOLON"

    // $ANTLR start "POINT"
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1157:2: ( '.' )
            // ACG_ANTLR3.g:1157:4: '.'
            {
            match('.'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POINT"

    // $ANTLR start "RARROW"
    public final void mRARROW() throws RecognitionException {
        try {
            int _type = RARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1165:2: ( '->' )
            // ACG_ANTLR3.g:1165:4: '->'
            {
            match("->"); 


                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RARROW"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1173:2: ( '-' )
            // ACG_ANTLR3.g:1173:4: '-'
            {
            match('-'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1181:2: ( '*' )
            // ACG_ANTLR3.g:1181:4: '*'
            {
            match('*'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1189:2: ( '/' )
            // ACG_ANTLR3.g:1189:4: '/'
            {
            match('/'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1197:2: ( '+' )
            // ACG_ANTLR3.g:1197:4: '+'
            {
            match('+'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1205:2: ( '=' )
            // ACG_ANTLR3.g:1205:4: '='
            {
            match('='); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1213:2: ( '>' )
            // ACG_ANTLR3.g:1213:4: '>'
            {
            match('>'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1221:2: ( '<' )
            // ACG_ANTLR3.g:1221:4: '<'
            {
            match('<'); 

                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1229:2: ( '>=' )
            // ACG_ANTLR3.g:1229:4: '>='
            {
            match(">="); 


                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1237:2: ( '<=' )
            // ACG_ANTLR3.g:1237:4: '<='
            {
            match("<="); 


                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "NE"
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1245:2: ( '<>' )
            // ACG_ANTLR3.g:1245:4: '<>'
            {
            match("<>"); 


                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NE"

    // $ANTLR start "LARROW"
    public final void mLARROW() throws RecognitionException {
        try {
            int _type = LARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1253:2: ( '<-' )
            // ACG_ANTLR3.g:1253:4: '<-'
            {
            match("<-"); 


                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LARROW"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ACG_ANTLR3.g:1261:2: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // ACG_ANTLR3.g:1261:4: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // ACG_ANTLR3.g:1261:4: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // ACG_ANTLR3.g:1261:5: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // ACG_ANTLR3.g:1261:5: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // ACG_ANTLR3.g:1261:6: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); 

            // ACG_ANTLR3.g:1261:11: (~ ( '\\r' | '\\n' ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ACG_ANTLR3.g:1261:12: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }


                        
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    public void mTokens() throws RecognitionException {
        // ACG_ANTLR3.g:1:8: ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | NL | WS | NAME | INT | FLOAT | STRING | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | SHARP | QMARK | COLONCOLON | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | COMMENT )
        int alt16=98;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ACG_ANTLR3.g:1:10: T__42
                {
                mT__42(); 

                }
                break;
            case 2 :
                // ACG_ANTLR3.g:1:16: T__43
                {
                mT__43(); 

                }
                break;
            case 3 :
                // ACG_ANTLR3.g:1:22: T__44
                {
                mT__44(); 

                }
                break;
            case 4 :
                // ACG_ANTLR3.g:1:28: T__45
                {
                mT__45(); 

                }
                break;
            case 5 :
                // ACG_ANTLR3.g:1:34: T__46
                {
                mT__46(); 

                }
                break;
            case 6 :
                // ACG_ANTLR3.g:1:40: T__47
                {
                mT__47(); 

                }
                break;
            case 7 :
                // ACG_ANTLR3.g:1:46: T__48
                {
                mT__48(); 

                }
                break;
            case 8 :
                // ACG_ANTLR3.g:1:52: T__49
                {
                mT__49(); 

                }
                break;
            case 9 :
                // ACG_ANTLR3.g:1:58: T__50
                {
                mT__50(); 

                }
                break;
            case 10 :
                // ACG_ANTLR3.g:1:64: T__51
                {
                mT__51(); 

                }
                break;
            case 11 :
                // ACG_ANTLR3.g:1:70: T__52
                {
                mT__52(); 

                }
                break;
            case 12 :
                // ACG_ANTLR3.g:1:76: T__53
                {
                mT__53(); 

                }
                break;
            case 13 :
                // ACG_ANTLR3.g:1:82: T__54
                {
                mT__54(); 

                }
                break;
            case 14 :
                // ACG_ANTLR3.g:1:88: T__55
                {
                mT__55(); 

                }
                break;
            case 15 :
                // ACG_ANTLR3.g:1:94: T__56
                {
                mT__56(); 

                }
                break;
            case 16 :
                // ACG_ANTLR3.g:1:100: T__57
                {
                mT__57(); 

                }
                break;
            case 17 :
                // ACG_ANTLR3.g:1:106: T__58
                {
                mT__58(); 

                }
                break;
            case 18 :
                // ACG_ANTLR3.g:1:112: T__59
                {
                mT__59(); 

                }
                break;
            case 19 :
                // ACG_ANTLR3.g:1:118: T__60
                {
                mT__60(); 

                }
                break;
            case 20 :
                // ACG_ANTLR3.g:1:124: T__61
                {
                mT__61(); 

                }
                break;
            case 21 :
                // ACG_ANTLR3.g:1:130: T__62
                {
                mT__62(); 

                }
                break;
            case 22 :
                // ACG_ANTLR3.g:1:136: T__63
                {
                mT__63(); 

                }
                break;
            case 23 :
                // ACG_ANTLR3.g:1:142: T__64
                {
                mT__64(); 

                }
                break;
            case 24 :
                // ACG_ANTLR3.g:1:148: T__65
                {
                mT__65(); 

                }
                break;
            case 25 :
                // ACG_ANTLR3.g:1:154: T__66
                {
                mT__66(); 

                }
                break;
            case 26 :
                // ACG_ANTLR3.g:1:160: T__67
                {
                mT__67(); 

                }
                break;
            case 27 :
                // ACG_ANTLR3.g:1:166: T__68
                {
                mT__68(); 

                }
                break;
            case 28 :
                // ACG_ANTLR3.g:1:172: T__69
                {
                mT__69(); 

                }
                break;
            case 29 :
                // ACG_ANTLR3.g:1:178: T__70
                {
                mT__70(); 

                }
                break;
            case 30 :
                // ACG_ANTLR3.g:1:184: T__71
                {
                mT__71(); 

                }
                break;
            case 31 :
                // ACG_ANTLR3.g:1:190: T__72
                {
                mT__72(); 

                }
                break;
            case 32 :
                // ACG_ANTLR3.g:1:196: T__73
                {
                mT__73(); 

                }
                break;
            case 33 :
                // ACG_ANTLR3.g:1:202: T__74
                {
                mT__74(); 

                }
                break;
            case 34 :
                // ACG_ANTLR3.g:1:208: T__75
                {
                mT__75(); 

                }
                break;
            case 35 :
                // ACG_ANTLR3.g:1:214: T__76
                {
                mT__76(); 

                }
                break;
            case 36 :
                // ACG_ANTLR3.g:1:220: T__77
                {
                mT__77(); 

                }
                break;
            case 37 :
                // ACG_ANTLR3.g:1:226: T__78
                {
                mT__78(); 

                }
                break;
            case 38 :
                // ACG_ANTLR3.g:1:232: T__79
                {
                mT__79(); 

                }
                break;
            case 39 :
                // ACG_ANTLR3.g:1:238: T__80
                {
                mT__80(); 

                }
                break;
            case 40 :
                // ACG_ANTLR3.g:1:244: T__81
                {
                mT__81(); 

                }
                break;
            case 41 :
                // ACG_ANTLR3.g:1:250: T__82
                {
                mT__82(); 

                }
                break;
            case 42 :
                // ACG_ANTLR3.g:1:256: T__83
                {
                mT__83(); 

                }
                break;
            case 43 :
                // ACG_ANTLR3.g:1:262: T__84
                {
                mT__84(); 

                }
                break;
            case 44 :
                // ACG_ANTLR3.g:1:268: T__85
                {
                mT__85(); 

                }
                break;
            case 45 :
                // ACG_ANTLR3.g:1:274: T__86
                {
                mT__86(); 

                }
                break;
            case 46 :
                // ACG_ANTLR3.g:1:280: T__87
                {
                mT__87(); 

                }
                break;
            case 47 :
                // ACG_ANTLR3.g:1:286: T__88
                {
                mT__88(); 

                }
                break;
            case 48 :
                // ACG_ANTLR3.g:1:292: T__89
                {
                mT__89(); 

                }
                break;
            case 49 :
                // ACG_ANTLR3.g:1:298: T__90
                {
                mT__90(); 

                }
                break;
            case 50 :
                // ACG_ANTLR3.g:1:304: T__91
                {
                mT__91(); 

                }
                break;
            case 51 :
                // ACG_ANTLR3.g:1:310: T__92
                {
                mT__92(); 

                }
                break;
            case 52 :
                // ACG_ANTLR3.g:1:316: T__93
                {
                mT__93(); 

                }
                break;
            case 53 :
                // ACG_ANTLR3.g:1:322: T__94
                {
                mT__94(); 

                }
                break;
            case 54 :
                // ACG_ANTLR3.g:1:328: T__95
                {
                mT__95(); 

                }
                break;
            case 55 :
                // ACG_ANTLR3.g:1:334: T__96
                {
                mT__96(); 

                }
                break;
            case 56 :
                // ACG_ANTLR3.g:1:340: T__97
                {
                mT__97(); 

                }
                break;
            case 57 :
                // ACG_ANTLR3.g:1:346: T__98
                {
                mT__98(); 

                }
                break;
            case 58 :
                // ACG_ANTLR3.g:1:352: T__99
                {
                mT__99(); 

                }
                break;
            case 59 :
                // ACG_ANTLR3.g:1:358: T__100
                {
                mT__100(); 

                }
                break;
            case 60 :
                // ACG_ANTLR3.g:1:365: T__101
                {
                mT__101(); 

                }
                break;
            case 61 :
                // ACG_ANTLR3.g:1:372: T__102
                {
                mT__102(); 

                }
                break;
            case 62 :
                // ACG_ANTLR3.g:1:379: T__103
                {
                mT__103(); 

                }
                break;
            case 63 :
                // ACG_ANTLR3.g:1:386: T__104
                {
                mT__104(); 

                }
                break;
            case 64 :
                // ACG_ANTLR3.g:1:393: T__105
                {
                mT__105(); 

                }
                break;
            case 65 :
                // ACG_ANTLR3.g:1:400: NL
                {
                mNL(); 

                }
                break;
            case 66 :
                // ACG_ANTLR3.g:1:403: WS
                {
                mWS(); 

                }
                break;
            case 67 :
                // ACG_ANTLR3.g:1:406: NAME
                {
                mNAME(); 

                }
                break;
            case 68 :
                // ACG_ANTLR3.g:1:411: INT
                {
                mINT(); 

                }
                break;
            case 69 :
                // ACG_ANTLR3.g:1:415: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 70 :
                // ACG_ANTLR3.g:1:421: STRING
                {
                mSTRING(); 

                }
                break;
            case 71 :
                // ACG_ANTLR3.g:1:428: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 72 :
                // ACG_ANTLR3.g:1:436: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 73 :
                // ACG_ANTLR3.g:1:444: EXCL
                {
                mEXCL(); 

                }
                break;
            case 74 :
                // ACG_ANTLR3.g:1:449: COMA
                {
                mCOMA(); 

                }
                break;
            case 75 :
                // ACG_ANTLR3.g:1:454: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 76 :
                // ACG_ANTLR3.g:1:461: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 77 :
                // ACG_ANTLR3.g:1:468: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 78 :
                // ACG_ANTLR3.g:1:475: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 79 :
                // ACG_ANTLR3.g:1:482: SEMI
                {
                mSEMI(); 

                }
                break;
            case 80 :
                // ACG_ANTLR3.g:1:487: COLON
                {
                mCOLON(); 

                }
                break;
            case 81 :
                // ACG_ANTLR3.g:1:493: PIPE
                {
                mPIPE(); 

                }
                break;
            case 82 :
                // ACG_ANTLR3.g:1:498: SHARP
                {
                mSHARP(); 

                }
                break;
            case 83 :
                // ACG_ANTLR3.g:1:504: QMARK
                {
                mQMARK(); 

                }
                break;
            case 84 :
                // ACG_ANTLR3.g:1:510: COLONCOLON
                {
                mCOLONCOLON(); 

                }
                break;
            case 85 :
                // ACG_ANTLR3.g:1:521: POINT
                {
                mPOINT(); 

                }
                break;
            case 86 :
                // ACG_ANTLR3.g:1:527: RARROW
                {
                mRARROW(); 

                }
                break;
            case 87 :
                // ACG_ANTLR3.g:1:534: MINUS
                {
                mMINUS(); 

                }
                break;
            case 88 :
                // ACG_ANTLR3.g:1:540: STAR
                {
                mSTAR(); 

                }
                break;
            case 89 :
                // ACG_ANTLR3.g:1:545: SLASH
                {
                mSLASH(); 

                }
                break;
            case 90 :
                // ACG_ANTLR3.g:1:551: PLUS
                {
                mPLUS(); 

                }
                break;
            case 91 :
                // ACG_ANTLR3.g:1:556: EQ
                {
                mEQ(); 

                }
                break;
            case 92 :
                // ACG_ANTLR3.g:1:559: GT
                {
                mGT(); 

                }
                break;
            case 93 :
                // ACG_ANTLR3.g:1:562: LT
                {
                mLT(); 

                }
                break;
            case 94 :
                // ACG_ANTLR3.g:1:565: GE
                {
                mGE(); 

                }
                break;
            case 95 :
                // ACG_ANTLR3.g:1:568: LE
                {
                mLE(); 

                }
                break;
            case 96 :
                // ACG_ANTLR3.g:1:571: NE
                {
                mNE(); 

                }
                break;
            case 97 :
                // ACG_ANTLR3.g:1:574: LARROW
                {
                mLARROW(); 

                }
                break;
            case 98 :
                // ACG_ANTLR3.g:1:581: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\24\27\3\uffff\1\140\12\uffff\1\143\4\uffff\1\146\4\uffff"+
        "\1\150\1\154\23\27\1\u0085\1\u0086\5\27\1\u008c\26\27\15\uffff\1"+
        "\u00a3\1\27\1\u00a5\1\27\1\u00a7\4\27\1\u00ac\7\27\1\u00b5\1\u00b6"+
        "\4\27\1\u00bc\2\uffff\1\27\1\u00be\3\27\1\uffff\3\27\1\u00c5\5\27"+
        "\1\u00cb\3\27\1\u00d0\1\u00d1\1\u00d3\5\27\1\u00d9\1\uffff\1\27"+
        "\1\uffff\1\27\1\uffff\2\27\1\u00de\1\27\1\uffff\1\u00e0\5\27\1\u00e7"+
        "\1\27\2\uffff\1\u00e9\2\27\1\u00ec\1\u00ed\1\uffff\1\27\1\uffff"+
        "\3\27\1\u00f2\2\27\1\uffff\1\u00f6\1\u00f7\3\27\1\uffff\1\u00ff"+
        "\3\27\2\uffff\1\27\1\uffff\1\u0104\1\u0105\1\u0106\2\27\1\uffff"+
        "\3\27\1\u010c\1\uffff\1\27\1\uffff\2\27\1\u0110\1\27\1\u0112\1\u0113"+
        "\1\uffff\1\u0114\1\uffff\2\27\2\uffff\4\27\1\uffff\1\u011b\1\27"+
        "\1\u011d\2\uffff\2\27\1\u0120\1\u0121\1\u0122\1\u0123\1\u0124\1"+
        "\uffff\1\u0125\3\27\3\uffff\5\27\1\uffff\3\27\1\uffff\1\u0131\3"+
        "\uffff\1\27\1\u0133\4\27\1\uffff\1\27\1\uffff\1\u0139\1\27\6\uffff"+
        "\1\u013b\1\u013c\1\u013d\3\27\1\u0141\3\27\1\u0145\1\uffff\1\u0146"+
        "\1\uffff\1\u0147\1\u0148\3\27\1\uffff\1\u014c\3\uffff\3\27\1\uffff"+
        "\2\27\1\u0152\4\uffff\1\u0153\2\27\1\uffff\1\27\1\u0157\1\u0158"+
        "\1\27\1\u015a\2\uffff\1\u015b\2\27\2\uffff\1\u015e\2\uffff\1\u015f"+
        "\1\27\2\uffff\1\27\1\u0162\1\uffff";
    static final String DFA16_eofS =
        "\u0163\uffff";
    static final String DFA16_minS =
        "\1\11\1\143\1\145\3\141\1\157\1\146\1\141\1\160\1\154\1\141\1\145"+
        "\2\141\2\145\1\150\1\143\1\145\1\157\3\uffff\1\56\12\uffff\1\72"+
        "\4\uffff\1\55\4\uffff\1\75\1\55\1\147\1\164\1\155\3\141\1\160\1"+
        "\154\1\156\1\162\1\145\1\154\1\155\1\167\1\164\1\144\1\151\1\154"+
        "\1\144\2\60\1\145\1\141\1\160\1\162\1\145\1\60\1\163\1\162\1\144"+
        "\1\164\1\141\1\163\1\160\2\162\1\160\1\163\1\141\1\154\1\160\1\166"+
        "\2\164\1\145\1\165\1\154\1\161\1\162\15\uffff\1\60\1\162\1\60\1"+
        "\154\1\60\2\162\1\160\1\145\1\60\1\146\1\143\1\145\1\154\1\144\1"+
        "\163\1\145\2\60\1\145\2\164\1\154\1\60\2\uffff\1\162\1\60\1\154"+
        "\1\151\1\162\1\uffff\1\145\1\157\1\151\1\60\1\144\1\164\1\157\1"+
        "\156\1\141\1\60\1\150\1\154\1\145\3\60\1\157\1\156\1\145\1\125\1"+
        "\165\1\60\1\uffff\1\151\1\uffff\1\171\1\uffff\1\164\1\145\1\60\1"+
        "\162\1\uffff\1\60\1\164\1\141\1\144\1\155\1\145\1\60\1\156\2\uffff"+
        "\1\60\1\145\1\151\2\60\1\uffff\1\141\1\uffff\1\151\2\141\1\60\1"+
        "\162\1\146\1\uffff\2\60\1\162\1\151\1\155\1\uffff\1\60\1\154\1\164"+
        "\1\170\2\uffff\1\163\1\uffff\3\60\1\156\1\145\1\uffff\1\142\1\172"+
        "\1\163\1\60\1\uffff\1\143\1\uffff\1\151\1\143\1\60\1\145\2\60\1"+
        "\uffff\1\60\1\uffff\1\170\1\143\2\uffff\1\164\1\145\1\142\1\164"+
        "\1\uffff\1\60\1\145\1\60\2\uffff\1\164\1\156\5\60\1\uffff\1\60\1"+
        "\145\1\61\1\155\3\uffff\1\144\1\156\1\165\1\145\1\127\1\uffff\1"+
        "\141\1\157\1\150\1\uffff\1\60\3\uffff\1\164\1\60\1\145\1\163\1\154"+
        "\1\151\1\uffff\1\162\1\uffff\1\60\1\147\6\uffff\3\60\1\145\1\143"+
        "\1\164\1\60\1\151\1\154\1\156\1\60\1\uffff\1\60\1\uffff\2\60\1\145"+
        "\1\157\1\141\1\uffff\1\60\3\uffff\1\146\2\145\1\uffff\1\164\1\154"+
        "\1\60\4\uffff\1\60\1\156\1\164\1\uffff\1\151\2\60\1\150\1\60\2\uffff"+
        "\1\60\1\145\1\156\2\uffff\1\60\2\uffff\1\60\1\145\2\uffff\1\144"+
        "\1\60\1\uffff";
    static final String DFA16_maxS =
        "\1\u00ff\1\164\1\167\1\165\1\157\1\162\1\157\1\164\1\141\2\162\1"+
        "\157\1\145\1\141\2\165\1\157\1\162\1\143\1\145\1\157\3\uffff\1\71"+
        "\12\uffff\1\72\4\uffff\1\76\4\uffff\1\75\1\76\1\147\1\164\1\155"+
        "\1\144\1\157\1\141\1\160\1\164\1\156\1\162\1\156\1\154\1\155\1\167"+
        "\1\164\1\156\1\151\1\154\1\144\2\u00ff\1\145\1\141\1\160\1\162\1"+
        "\145\1\u00ff\1\163\1\162\1\144\1\164\1\141\1\163\1\160\2\162\1\160"+
        "\1\163\1\141\1\154\1\160\1\166\2\164\1\145\1\165\1\154\1\161\1\162"+
        "\15\uffff\1\u00ff\1\162\1\u00ff\1\154\1\u00ff\2\162\1\160\1\145"+
        "\1\u00ff\1\146\1\143\1\145\1\154\1\144\1\163\1\145\2\u00ff\1\145"+
        "\2\164\1\154\1\u00ff\2\uffff\1\162\1\u00ff\1\154\1\151\1\162\1\uffff"+
        "\1\145\1\157\1\151\1\u00ff\1\144\1\164\1\157\1\156\1\141\1\u00ff"+
        "\1\150\1\154\1\145\3\u00ff\1\157\1\156\1\145\1\125\1\165\1\u00ff"+
        "\1\uffff\1\151\1\uffff\1\171\1\uffff\1\164\1\145\1\u00ff\1\162\1"+
        "\uffff\1\u00ff\1\164\1\141\1\144\1\155\1\145\1\u00ff\1\156\2\uffff"+
        "\1\u00ff\1\145\1\151\2\u00ff\1\uffff\1\141\1\uffff\1\151\2\141\1"+
        "\u00ff\1\162\1\164\1\uffff\2\u00ff\1\162\1\151\1\155\1\uffff\1\u00ff"+
        "\1\154\1\164\1\170\2\uffff\1\163\1\uffff\3\u00ff\1\156\1\145\1\uffff"+
        "\1\142\1\172\1\163\1\u00ff\1\uffff\1\143\1\uffff\1\151\1\143\1\u00ff"+
        "\1\145\2\u00ff\1\uffff\1\u00ff\1\uffff\1\170\1\143\2\uffff\1\164"+
        "\1\145\1\142\1\164\1\uffff\1\u00ff\1\145\1\u00ff\2\uffff\1\164\1"+
        "\156\5\u00ff\1\uffff\1\u00ff\1\145\1\61\1\155\3\uffff\1\144\1\156"+
        "\1\165\1\145\1\127\1\uffff\1\141\1\157\1\150\1\uffff\1\u00ff\3\uffff"+
        "\1\164\1\u00ff\1\145\1\163\1\154\1\151\1\uffff\1\162\1\uffff\1\u00ff"+
        "\1\147\6\uffff\3\u00ff\1\145\1\143\1\164\1\u00ff\1\151\1\154\1\156"+
        "\1\u00ff\1\uffff\1\u00ff\1\uffff\2\u00ff\1\145\1\157\1\141\1\uffff"+
        "\1\u00ff\3\uffff\1\146\2\145\1\uffff\1\164\1\154\1\u00ff\4\uffff"+
        "\1\u00ff\1\156\1\164\1\uffff\1\151\2\u00ff\1\150\1\u00ff\2\uffff"+
        "\1\u00ff\1\145\1\156\2\uffff\1\u00ff\2\uffff\1\u00ff\1\145\2\uffff"+
        "\1\144\1\u00ff\1\uffff";
    static final String DFA16_acceptS =
        "\25\uffff\1\101\1\102\1\103\1\uffff\1\106\1\107\1\110\1\111\1\112"+
        "\1\113\1\114\1\115\1\116\1\117\1\uffff\1\121\1\122\1\123\1\125\1"+
        "\uffff\1\130\1\131\1\132\1\133\63\uffff\1\104\1\105\1\124\1\120"+
        "\1\126\1\142\1\127\1\136\1\134\1\137\1\140\1\141\1\135\30\uffff"+
        "\1\12\1\17\5\uffff\1\76\26\uffff\1\1\1\uffff\1\5\1\uffff\1\75\4"+
        "\uffff\1\57\10\uffff\1\31\1\71\5\uffff\1\73\1\uffff\1\74\6\uffff"+
        "\1\21\5\uffff\1\36\4\uffff\1\34\1\72\1\uffff\1\56\5\uffff\1\77\4"+
        "\uffff\1\37\1\uffff\1\61\6\uffff\1\6\1\uffff\1\7\2\uffff\1\53\1"+
        "\10\4\uffff\1\20\3\uffff\1\51\1\62\7\uffff\1\46\4\uffff\1\60\1\63"+
        "\1\67\5\uffff\1\52\3\uffff\1\27\1\uffff\1\70\1\14\1\32\6\uffff\1"+
        "\25\1\uffff\1\64\2\uffff\1\30\1\44\1\45\1\47\1\50\1\54\13\uffff"+
        "\1\43\1\uffff\1\24\5\uffff\1\23\1\uffff\1\33\1\35\1\42\3\uffff\1"+
        "\22\3\uffff\1\11\1\16\1\40\1\100\3\uffff\1\26\5\uffff\1\3\1\13\3"+
        "\uffff\1\66\1\4\1\uffff\1\55\1\15\2\uffff\1\2\1\41\2\uffff\1\65";
    static final String DFA16_specialS =
        "\u0163\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\26\1\25\2\uffff\1\25\22\uffff\1\26\1\34\1\27\1\45\3\uffff"+
            "\1\31\1\36\1\37\1\51\1\53\1\35\1\50\1\47\1\52\12\30\1\43\1\42"+
            "\1\56\1\54\1\55\1\46\1\uffff\16\27\1\22\3\27\1\23\7\27\1\32"+
            "\1\uffff\1\33\1\uffff\1\27\1\uffff\1\1\1\27\1\5\1\17\1\12\1"+
            "\3\1\20\1\27\1\7\2\27\1\13\1\6\1\4\1\11\1\16\1\27\1\14\1\2\1"+
            "\21\1\27\1\10\1\15\1\24\2\27\1\40\1\44\1\41\102\uffff\27\27"+
            "\1\uffff\37\27\1\uffff\10\27",
            "\1\57\12\uffff\1\62\4\uffff\1\61\1\60",
            "\1\66\16\uffff\1\63\1\65\1\uffff\1\64",
            "\1\72\7\uffff\1\71\5\uffff\1\70\5\uffff\1\67",
            "\1\73\3\uffff\1\74\11\uffff\1\75",
            "\1\100\15\uffff\1\76\2\uffff\1\77",
            "\1\101",
            "\1\103\6\uffff\1\106\1\102\4\uffff\1\105\1\104",
            "\1\107",
            "\1\110\1\uffff\1\111",
            "\1\112\1\uffff\1\114\3\uffff\1\113",
            "\1\117\3\uffff\1\115\11\uffff\1\116",
            "\1\120",
            "\1\121",
            "\1\122\1\uffff\1\125\13\uffff\1\123\5\uffff\1\124",
            "\1\126\3\uffff\1\130\13\uffff\1\127",
            "\1\131\11\uffff\1\132",
            "\1\133\11\uffff\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "",
            "",
            "\1\141\1\uffff\12\30",
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
            "\1\142",
            "",
            "",
            "",
            "",
            "\1\145\20\uffff\1\144",
            "",
            "",
            "",
            "",
            "\1\147",
            "\1\153\17\uffff\1\151\1\152",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160\2\uffff\1\161",
            "\1\162\15\uffff\1\163",
            "\1\164",
            "\1\165",
            "\1\167\7\uffff\1\166",
            "\1\170",
            "\1\171",
            "\1\172\10\uffff\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080\11\uffff\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
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
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00a4",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00a6",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\10\27\1\u00b4\21"+
            "\27\105\uffff\27\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27\1\u00bb\25\27"+
            "\105\uffff\27\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "",
            "\1\u00bd",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\12\27\7\uffff\32\27\4\uffff\1\u00cf\1\uffff\32\27\105\uffff"+
            "\27\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\1\u00d2\31\27\105"+
            "\uffff\27\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "\1\u00da",
            "",
            "\1\u00db",
            "",
            "\1\u00dc",
            "\1\u00dd",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00df",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\3\27\1\u00e6\26\27"+
            "\105\uffff\27\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00e8",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00ea",
            "\1\u00eb",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "\1\u00ee",
            "",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00f3",
            "\1\u00f5\15\uffff\1\u00f4",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\3\27\1\u00fe\1\27"+
            "\1\u00fc\2\27\1\u00fd\12\27\1\u00fb\6\27\105\uffff\27\27\1\uffff"+
            "\37\27\1\uffff\10\27",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "",
            "",
            "\1\u0103",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u0107",
            "\1\u0108",
            "",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "\1\u010d",
            "",
            "\1\u010e",
            "\1\u010f",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u0111",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "\1\u0115",
            "\1\u0116",
            "",
            "",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u011c",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "",
            "\1\u011e",
            "\1\u011f",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "",
            "",
            "",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "",
            "",
            "\1\u0132",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "",
            "\1\u0138",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u013a",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "",
            "",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "",
            "\1\u0150",
            "\1\u0151",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u0154",
            "\1\u0155",
            "",
            "\1\u0156",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u0159",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u015c",
            "\1\u015d",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
            "\1\u0160",
            "",
            "",
            "\1\u0161",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\27"+
            "\27\1\uffff\37\27\1\uffff\10\27",
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
            return "1:1: Tokens : ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | NL | WS | NAME | INT | FLOAT | STRING | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | SHARP | QMARK | COLONCOLON | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | COMMENT );";
        }
    }
 

}