// $ANTLR 3.2 Sep 23, 2009 12:02:23 ACG_ANTLR3.g 2019-12-05 18:11:16
package org.eclipse.m2m.atl.dsls.tcs.injector;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ACG_ANTLR3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "LCURLY", "RCURLY", "COLONCOLON", "LPAREN", "COMA", "RPAREN", "EQ", "SEMI", "PIPE", "LSQUARE", "RSQUARE", "COLON", "POINT", "RARROW", "MINUS", "STAR", "SLASH", "PLUS", "GT", "LT", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "FLOAT", "EXCL", "SHARP", "QMARK", "LARROW", "COMMENT", "'acg'", "'startsWith'", "'function'", "'attribute'", "'asm'", "'name'", "'code'", "'mode'", "'foreach'", "'in'", "'variable'", "'named'", "'operation'", "'context'", "'if'", "'else'", "'let'", "'analyze'", "'report'", "'critic'", "'error'", "'warning'", "'field'", "'param'", "'new'", "'newin'", "'delete'", "'dup'", "'dup_x1'", "'pop'", "'swap'", "'iterate'", "'enditerate'", "'getasm'", "'findme'", "'pusht'", "'pushf'", "'push'", "'pushi'", "'pushd'", "'load'", "'store'", "'call'", "'pcall'", "'supercall'", "'get'", "'set'", "'goto'", "'self'", "'last'", "'then'", "'endif'", "'OclUndefined'", "'Sequence'", "'true'", "'false'", "'not'", "'div'", "'mod'", "'isa'", "'and'", "'or'", "'xor'", "'implies'"
    };
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

    // delegates
    // delegators


        public ACG_ANTLR3Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ACG_ANTLR3Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ACG_ANTLR3Parser.tokenNames; }
    public String getGrammarFileName() { return "ACG_ANTLR3.g"; }


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



    // $ANTLR start "main"
    // ACG_ANTLR3.g:60:1: main returns [Object ret2] : ( (ret= aCG ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:61:2: ( ( (ret= aCG ) EOF ) )
            // ACG_ANTLR3.g:61:4: ( (ret= aCG ) EOF )
            {
            // ACG_ANTLR3.g:61:4: ( (ret= aCG ) EOF )
            // ACG_ANTLR3.g:61:5: (ret= aCG ) EOF
            {
            // ACG_ANTLR3.g:61:5: (ret= aCG )
            // ACG_ANTLR3.g:61:6: ret= aCG
            {
            pushFollow(FOLLOW_aCG_in_main46);
            ret=aCG();

            state._fsp--;


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
    // $ANTLR end "main"


    // $ANTLR start "identifier"
    // ACG_ANTLR3.g:68:1: identifier returns [Object ret2] : ast= NAME ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ACG_ANTLR3.g:69:2: (ast= NAME )
            // ACG_ANTLR3.g:69:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier82); 
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
    // $ANTLR end "identifier"


    // $ANTLR start "identifierOrKeyword"
    // ACG_ANTLR3.g:76:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'acg' | 'startsWith' | 'function' | 'attribute' | 'asm' | 'name' | 'code' | 'mode' | 'foreach' | 'in' | 'variable' | 'named' | 'operation' | 'context' | 'if' | 'else' | 'let' | 'analyze' | 'report' | 'critic' | 'error' | 'warning' | 'field' | 'param' | 'new' | 'newin' | 'delete' | 'dup' | 'dup_x1' | 'pop' | 'swap' | 'iterate' | 'enditerate' | 'getasm' | 'findme' | 'pusht' | 'pushf' | 'push' | 'pushi' | 'pushd' | 'load' | 'store' | 'call' | 'pcall' | 'supercall' | 'get' | 'set' | 'goto' | 'self' | 'last' | 'then' | 'endif' | 'OclUndefined' | 'Sequence' | 'true' | 'false' | 'not' | 'div' | 'mod' | 'isa' | 'and' | 'or' | 'xor' | 'implies' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ACG_ANTLR3.g:77:2: ( (ast= NAME | 'acg' | 'startsWith' | 'function' | 'attribute' | 'asm' | 'name' | 'code' | 'mode' | 'foreach' | 'in' | 'variable' | 'named' | 'operation' | 'context' | 'if' | 'else' | 'let' | 'analyze' | 'report' | 'critic' | 'error' | 'warning' | 'field' | 'param' | 'new' | 'newin' | 'delete' | 'dup' | 'dup_x1' | 'pop' | 'swap' | 'iterate' | 'enditerate' | 'getasm' | 'findme' | 'pusht' | 'pushf' | 'push' | 'pushi' | 'pushd' | 'load' | 'store' | 'call' | 'pcall' | 'supercall' | 'get' | 'set' | 'goto' | 'self' | 'last' | 'then' | 'endif' | 'OclUndefined' | 'Sequence' | 'true' | 'false' | 'not' | 'div' | 'mod' | 'isa' | 'and' | 'or' | 'xor' | 'implies' ) )
            // ACG_ANTLR3.g:77:4: (ast= NAME | 'acg' | 'startsWith' | 'function' | 'attribute' | 'asm' | 'name' | 'code' | 'mode' | 'foreach' | 'in' | 'variable' | 'named' | 'operation' | 'context' | 'if' | 'else' | 'let' | 'analyze' | 'report' | 'critic' | 'error' | 'warning' | 'field' | 'param' | 'new' | 'newin' | 'delete' | 'dup' | 'dup_x1' | 'pop' | 'swap' | 'iterate' | 'enditerate' | 'getasm' | 'findme' | 'pusht' | 'pushf' | 'push' | 'pushi' | 'pushd' | 'load' | 'store' | 'call' | 'pcall' | 'supercall' | 'get' | 'set' | 'goto' | 'self' | 'last' | 'then' | 'endif' | 'OclUndefined' | 'Sequence' | 'true' | 'false' | 'not' | 'div' | 'mod' | 'isa' | 'and' | 'or' | 'xor' | 'implies' )
            {
            // ACG_ANTLR3.g:77:4: (ast= NAME | 'acg' | 'startsWith' | 'function' | 'attribute' | 'asm' | 'name' | 'code' | 'mode' | 'foreach' | 'in' | 'variable' | 'named' | 'operation' | 'context' | 'if' | 'else' | 'let' | 'analyze' | 'report' | 'critic' | 'error' | 'warning' | 'field' | 'param' | 'new' | 'newin' | 'delete' | 'dup' | 'dup_x1' | 'pop' | 'swap' | 'iterate' | 'enditerate' | 'getasm' | 'findme' | 'pusht' | 'pushf' | 'push' | 'pushi' | 'pushd' | 'load' | 'store' | 'call' | 'pcall' | 'supercall' | 'get' | 'set' | 'goto' | 'self' | 'last' | 'then' | 'endif' | 'OclUndefined' | 'Sequence' | 'true' | 'false' | 'not' | 'div' | 'mod' | 'isa' | 'and' | 'or' | 'xor' | 'implies' )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ACG_ANTLR3.g:77:5: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword117); 
                    ret = ast.getText(); ei.setToken((Object)ast);

                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:77:64: 'acg'
                    {
                    match(input,42,FOLLOW_42_in_identifierOrKeyword122); 
                    ret = "acg";

                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:77:86: 'startsWith'
                    {
                    match(input,43,FOLLOW_43_in_identifierOrKeyword127); 
                    ret = "startsWith";

                    }
                    break;
                case 4 :
                    // ACG_ANTLR3.g:77:122: 'function'
                    {
                    match(input,44,FOLLOW_44_in_identifierOrKeyword132); 
                    ret = "function";

                    }
                    break;
                case 5 :
                    // ACG_ANTLR3.g:77:154: 'attribute'
                    {
                    match(input,45,FOLLOW_45_in_identifierOrKeyword137); 
                    ret = "attribute";

                    }
                    break;
                case 6 :
                    // ACG_ANTLR3.g:77:188: 'asm'
                    {
                    match(input,46,FOLLOW_46_in_identifierOrKeyword142); 
                    ret = "asm";

                    }
                    break;
                case 7 :
                    // ACG_ANTLR3.g:77:210: 'name'
                    {
                    match(input,47,FOLLOW_47_in_identifierOrKeyword147); 
                    ret = "name";

                    }
                    break;
                case 8 :
                    // ACG_ANTLR3.g:77:234: 'code'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword152); 
                    ret = "code";

                    }
                    break;
                case 9 :
                    // ACG_ANTLR3.g:77:258: 'mode'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword157); 
                    ret = "mode";

                    }
                    break;
                case 10 :
                    // ACG_ANTLR3.g:77:282: 'foreach'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword162); 
                    ret = "foreach";

                    }
                    break;
                case 11 :
                    // ACG_ANTLR3.g:77:312: 'in'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword167); 
                    ret = "in";

                    }
                    break;
                case 12 :
                    // ACG_ANTLR3.g:77:332: 'variable'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword172); 
                    ret = "variable";

                    }
                    break;
                case 13 :
                    // ACG_ANTLR3.g:77:364: 'named'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword177); 
                    ret = "named";

                    }
                    break;
                case 14 :
                    // ACG_ANTLR3.g:77:390: 'operation'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword182); 
                    ret = "operation";

                    }
                    break;
                case 15 :
                    // ACG_ANTLR3.g:77:424: 'context'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword187); 
                    ret = "context";

                    }
                    break;
                case 16 :
                    // ACG_ANTLR3.g:77:454: 'if'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword192); 
                    ret = "if";

                    }
                    break;
                case 17 :
                    // ACG_ANTLR3.g:77:474: 'else'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword197); 
                    ret = "else";

                    }
                    break;
                case 18 :
                    // ACG_ANTLR3.g:77:498: 'let'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword202); 
                    ret = "let";

                    }
                    break;
                case 19 :
                    // ACG_ANTLR3.g:77:520: 'analyze'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword207); 
                    ret = "analyze";

                    }
                    break;
                case 20 :
                    // ACG_ANTLR3.g:77:550: 'report'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword212); 
                    ret = "report";

                    }
                    break;
                case 21 :
                    // ACG_ANTLR3.g:77:578: 'critic'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword217); 
                    ret = "critic";

                    }
                    break;
                case 22 :
                    // ACG_ANTLR3.g:77:606: 'error'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword222); 
                    ret = "error";

                    }
                    break;
                case 23 :
                    // ACG_ANTLR3.g:77:632: 'warning'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword227); 
                    ret = "warning";

                    }
                    break;
                case 24 :
                    // ACG_ANTLR3.g:77:662: 'field'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword232); 
                    ret = "field";

                    }
                    break;
                case 25 :
                    // ACG_ANTLR3.g:77:688: 'param'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword237); 
                    ret = "param";

                    }
                    break;
                case 26 :
                    // ACG_ANTLR3.g:77:714: 'new'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword242); 
                    ret = "new";

                    }
                    break;
                case 27 :
                    // ACG_ANTLR3.g:77:736: 'newin'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword247); 
                    ret = "newin";

                    }
                    break;
                case 28 :
                    // ACG_ANTLR3.g:77:762: 'delete'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword252); 
                    ret = "delete";

                    }
                    break;
                case 29 :
                    // ACG_ANTLR3.g:77:790: 'dup'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword257); 
                    ret = "dup";

                    }
                    break;
                case 30 :
                    // ACG_ANTLR3.g:77:812: 'dup_x1'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword262); 
                    ret = "dup_x1";

                    }
                    break;
                case 31 :
                    // ACG_ANTLR3.g:77:840: 'pop'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword267); 
                    ret = "pop";

                    }
                    break;
                case 32 :
                    // ACG_ANTLR3.g:77:862: 'swap'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword272); 
                    ret = "swap";

                    }
                    break;
                case 33 :
                    // ACG_ANTLR3.g:77:886: 'iterate'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword277); 
                    ret = "iterate";

                    }
                    break;
                case 34 :
                    // ACG_ANTLR3.g:77:916: 'enditerate'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword282); 
                    ret = "enditerate";

                    }
                    break;
                case 35 :
                    // ACG_ANTLR3.g:77:952: 'getasm'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword287); 
                    ret = "getasm";

                    }
                    break;
                case 36 :
                    // ACG_ANTLR3.g:77:980: 'findme'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword292); 
                    ret = "findme";

                    }
                    break;
                case 37 :
                    // ACG_ANTLR3.g:77:1008: 'pusht'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword297); 
                    ret = "pusht";

                    }
                    break;
                case 38 :
                    // ACG_ANTLR3.g:77:1034: 'pushf'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword302); 
                    ret = "pushf";

                    }
                    break;
                case 39 :
                    // ACG_ANTLR3.g:77:1060: 'push'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword307); 
                    ret = "push";

                    }
                    break;
                case 40 :
                    // ACG_ANTLR3.g:77:1084: 'pushi'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword312); 
                    ret = "pushi";

                    }
                    break;
                case 41 :
                    // ACG_ANTLR3.g:77:1110: 'pushd'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword317); 
                    ret = "pushd";

                    }
                    break;
                case 42 :
                    // ACG_ANTLR3.g:77:1136: 'load'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword322); 
                    ret = "load";

                    }
                    break;
                case 43 :
                    // ACG_ANTLR3.g:77:1160: 'store'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword327); 
                    ret = "store";

                    }
                    break;
                case 44 :
                    // ACG_ANTLR3.g:77:1186: 'call'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword332); 
                    ret = "call";

                    }
                    break;
                case 45 :
                    // ACG_ANTLR3.g:77:1210: 'pcall'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword337); 
                    ret = "pcall";

                    }
                    break;
                case 46 :
                    // ACG_ANTLR3.g:77:1236: 'supercall'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword342); 
                    ret = "supercall";

                    }
                    break;
                case 47 :
                    // ACG_ANTLR3.g:77:1270: 'get'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword347); 
                    ret = "get";

                    }
                    break;
                case 48 :
                    // ACG_ANTLR3.g:77:1292: 'set'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword352); 
                    ret = "set";

                    }
                    break;
                case 49 :
                    // ACG_ANTLR3.g:77:1314: 'goto'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword357); 
                    ret = "goto";

                    }
                    break;
                case 50 :
                    // ACG_ANTLR3.g:77:1338: 'self'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword362); 
                    ret = "self";

                    }
                    break;
                case 51 :
                    // ACG_ANTLR3.g:77:1362: 'last'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword367); 
                    ret = "last";

                    }
                    break;
                case 52 :
                    // ACG_ANTLR3.g:77:1386: 'then'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword372); 
                    ret = "then";

                    }
                    break;
                case 53 :
                    // ACG_ANTLR3.g:77:1410: 'endif'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword377); 
                    ret = "endif";

                    }
                    break;
                case 54 :
                    // ACG_ANTLR3.g:77:1436: 'OclUndefined'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword382); 
                    ret = "OclUndefined";

                    }
                    break;
                case 55 :
                    // ACG_ANTLR3.g:77:1476: 'Sequence'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword387); 
                    ret = "Sequence";

                    }
                    break;
                case 56 :
                    // ACG_ANTLR3.g:77:1508: 'true'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword392); 
                    ret = "true";

                    }
                    break;
                case 57 :
                    // ACG_ANTLR3.g:77:1532: 'false'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword397); 
                    ret = "false";

                    }
                    break;
                case 58 :
                    // ACG_ANTLR3.g:77:1558: 'not'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword402); 
                    ret = "not";

                    }
                    break;
                case 59 :
                    // ACG_ANTLR3.g:77:1580: 'div'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword407); 
                    ret = "div";

                    }
                    break;
                case 60 :
                    // ACG_ANTLR3.g:77:1602: 'mod'
                    {
                    match(input,100,FOLLOW_100_in_identifierOrKeyword412); 
                    ret = "mod";

                    }
                    break;
                case 61 :
                    // ACG_ANTLR3.g:77:1624: 'isa'
                    {
                    match(input,101,FOLLOW_101_in_identifierOrKeyword417); 
                    ret = "isa";

                    }
                    break;
                case 62 :
                    // ACG_ANTLR3.g:77:1646: 'and'
                    {
                    match(input,102,FOLLOW_102_in_identifierOrKeyword422); 
                    ret = "and";

                    }
                    break;
                case 63 :
                    // ACG_ANTLR3.g:77:1668: 'or'
                    {
                    match(input,103,FOLLOW_103_in_identifierOrKeyword427); 
                    ret = "or";

                    }
                    break;
                case 64 :
                    // ACG_ANTLR3.g:77:1688: 'xor'
                    {
                    match(input,104,FOLLOW_104_in_identifierOrKeyword432); 
                    ret = "xor";

                    }
                    break;
                case 65 :
                    // ACG_ANTLR3.g:77:1710: 'implies'
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
    // $ANTLR end "identifierOrKeyword"


    // $ANTLR start "stringSymbol"
    // ACG_ANTLR3.g:84:1: stringSymbol returns [Object ret2] : ast= STRING ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ACG_ANTLR3.g:85:2: (ast= STRING )
            // ACG_ANTLR3.g:85:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol472); 
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
    // $ANTLR end "stringSymbol"


    // $ANTLR start "integerSymbol"
    // ACG_ANTLR3.g:92:1: integerSymbol returns [Object ret2] : ast= INT ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ACG_ANTLR3.g:93:2: (ast= INT )
            // ACG_ANTLR3.g:93:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol506); 
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
    // $ANTLR end "integerSymbol"


    // $ANTLR start "aCG"
    // ACG_ANTLR3.g:100:1: aCG returns [Object ret2] : ( 'acg' temp= identifier 'startsWith' temp= identifier LCURLY ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) ) RCURLY ) ;
    public final Object aCG() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("ACG", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:101:2: ( ( 'acg' temp= identifier 'startsWith' temp= identifier LCURLY ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) ) RCURLY ) )
            // ACG_ANTLR3.g:101:4: ( 'acg' temp= identifier 'startsWith' temp= identifier LCURLY ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) ) RCURLY )
            {
            // ACG_ANTLR3.g:101:4: ( 'acg' temp= identifier 'startsWith' temp= identifier LCURLY ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) ) RCURLY )
            // ACG_ANTLR3.g:101:5: 'acg' temp= identifier 'startsWith' temp= identifier LCURLY ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) ) RCURLY
            {
            match(input,42,FOLLOW_42_in_aCG539); 
            pushFollow(FOLLOW_identifier_in_aCG543);
            temp=identifier();

            state._fsp--;

            ei.set(ret, "metamodel", temp);
            match(input,43,FOLLOW_43_in_aCG547); 
            pushFollow(FOLLOW_identifier_in_aCG551);
            temp=identifier();

            state._fsp--;

            ei.set(ret, "startsWith", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_aCG555); 
            // ACG_ANTLR3.g:101:132: ( ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? ) )
            // ACG_ANTLR3.g:101:133: ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? )
            {
            // ACG_ANTLR3.g:101:133: ( ( (temp= aCGElement ( (temp= aCGElement ) )* ) )? )
            // ACG_ANTLR3.g:101:134: ( (temp= aCGElement ( (temp= aCGElement ) )* ) )?
            {
            // ACG_ANTLR3.g:101:134: ( (temp= aCGElement ( (temp= aCGElement ) )* ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NAME||(LA3_0>=44 && LA3_0<=46)||LA3_0==48) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ACG_ANTLR3.g:101:135: (temp= aCGElement ( (temp= aCGElement ) )* )
                    {
                    // ACG_ANTLR3.g:101:135: (temp= aCGElement ( (temp= aCGElement ) )* )
                    // ACG_ANTLR3.g:101:136: temp= aCGElement ( (temp= aCGElement ) )*
                    {
                    pushFollow(FOLLOW_aCGElement_in_aCG563);
                    temp=aCGElement();

                    state._fsp--;

                    ei.set(ret, "elements", temp);
                    // ACG_ANTLR3.g:101:185: ( (temp= aCGElement ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==NAME||(LA2_0>=44 && LA2_0<=46)||LA2_0==48) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:101:186: (temp= aCGElement )
                    	    {
                    	    // ACG_ANTLR3.g:101:186: (temp= aCGElement )
                    	    // ACG_ANTLR3.g:101:187: temp= aCGElement
                    	    {
                    	    pushFollow(FOLLOW_aCGElement_in_aCG571);
                    	    temp=aCGElement();

                    	    state._fsp--;

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

            match(input,RCURLY,FOLLOW_RCURLY_in_aCG583); 

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
    // $ANTLR end "aCG"


    // $ANTLR start "aCGElement"
    // ACG_ANTLR3.g:111:1: aCGElement returns [Object ret2] : ( (ret= function | ret= attribute | ret= node ) ) ;
    public final Object aCGElement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:112:2: ( ( (ret= function | ret= attribute | ret= node ) ) )
            // ACG_ANTLR3.g:112:4: ( (ret= function | ret= attribute | ret= node ) )
            {
            // ACG_ANTLR3.g:112:4: ( (ret= function | ret= attribute | ret= node ) )
            // ACG_ANTLR3.g:112:5: (ret= function | ret= attribute | ret= node )
            {
            // ACG_ANTLR3.g:112:5: (ret= function | ret= attribute | ret= node )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ACG_ANTLR3.g:112:6: ret= function
                    {
                    pushFollow(FOLLOW_function_in_aCGElement618);
                    ret=function();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:112:20: ret= attribute
                    {
                    pushFollow(FOLLOW_attribute_in_aCGElement623);
                    ret=attribute();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:112:35: ret= node
                    {
                    pushFollow(FOLLOW_node_in_aCGElement628);
                    ret=node();

                    state._fsp--;


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
    // $ANTLR end "aCGElement"


    // $ANTLR start "function"
    // ACG_ANTLR3.g:120:1: function returns [Object ret2] : ( 'function' temp= identifier COLONCOLON temp= identifier LPAREN ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () ) RPAREN EQ temp= expression SEMI ) ;
    public final Object function() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("Function", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:121:2: ( ( 'function' temp= identifier COLONCOLON temp= identifier LPAREN ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () ) RPAREN EQ temp= expression SEMI ) )
            // ACG_ANTLR3.g:121:4: ( 'function' temp= identifier COLONCOLON temp= identifier LPAREN ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () ) RPAREN EQ temp= expression SEMI )
            {
            // ACG_ANTLR3.g:121:4: ( 'function' temp= identifier COLONCOLON temp= identifier LPAREN ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () ) RPAREN EQ temp= expression SEMI )
            // ACG_ANTLR3.g:121:5: 'function' temp= identifier COLONCOLON temp= identifier LPAREN ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () ) RPAREN EQ temp= expression SEMI
            {
            match(input,44,FOLLOW_44_in_function661); 
            pushFollow(FOLLOW_identifier_in_function665);
            temp=identifier();

            state._fsp--;

            ei.set(ret, "context", temp);
            match(input,COLONCOLON,FOLLOW_COLONCOLON_in_function669); 
            pushFollow(FOLLOW_identifier_in_function673);
            temp=identifier();

            state._fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_function677); 
            // ACG_ANTLR3.g:121:127: ( ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) ) | () )
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
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ACG_ANTLR3.g:121:128: ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) )
                    {
                    // ACG_ANTLR3.g:121:128: ( ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) ) )
                    // ACG_ANTLR3.g:121:129: ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )
                    {
                    // ACG_ANTLR3.g:121:129: ( (temp= parameter ( ( ( COMA ) temp= parameter ) )* ) )
                    // ACG_ANTLR3.g:121:130: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    {
                    // ACG_ANTLR3.g:121:130: (temp= parameter ( ( ( COMA ) temp= parameter ) )* )
                    // ACG_ANTLR3.g:121:131: temp= parameter ( ( ( COMA ) temp= parameter ) )*
                    {
                    pushFollow(FOLLOW_parameter_in_function685);
                    temp=parameter();

                    state._fsp--;

                    ei.set(ret, "parameters", temp);
                    // ACG_ANTLR3.g:121:181: ( ( ( COMA ) temp= parameter ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==COMA) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:121:182: ( ( COMA ) temp= parameter )
                    	    {
                    	    // ACG_ANTLR3.g:121:182: ( ( COMA ) temp= parameter )
                    	    // ACG_ANTLR3.g:121:183: ( COMA ) temp= parameter
                    	    {
                    	    // ACG_ANTLR3.g:121:183: ( COMA )
                    	    // ACG_ANTLR3.g:121:184: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_function692); 

                    	    }

                    	    pushFollow(FOLLOW_parameter_in_function697);
                    	    temp=parameter();

                    	    state._fsp--;

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
                    // ACG_ANTLR3.g:121:250: ()
                    {
                    // ACG_ANTLR3.g:121:250: ()
                    // ACG_ANTLR3.g:121:251: 
                    {
                    }



                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_function716); 
            match(input,EQ,FOLLOW_EQ_in_function718); 
            pushFollow(FOLLOW_expression_in_function722);
            temp=expression();

            state._fsp--;

            ei.set(ret, "body", temp);
            match(input,SEMI,FOLLOW_SEMI_in_function726); 

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
    // $ANTLR end "function"


    // $ANTLR start "attribute"
    // ACG_ANTLR3.g:131:1: attribute returns [Object ret2] : ( 'attribute' temp= identifier COLONCOLON temp= identifier EQ temp= expression SEMI ) ;
    public final Object attribute() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("Attribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:132:2: ( ( 'attribute' temp= identifier COLONCOLON temp= identifier EQ temp= expression SEMI ) )
            // ACG_ANTLR3.g:132:4: ( 'attribute' temp= identifier COLONCOLON temp= identifier EQ temp= expression SEMI )
            {
            // ACG_ANTLR3.g:132:4: ( 'attribute' temp= identifier COLONCOLON temp= identifier EQ temp= expression SEMI )
            // ACG_ANTLR3.g:132:5: 'attribute' temp= identifier COLONCOLON temp= identifier EQ temp= expression SEMI
            {
            match(input,45,FOLLOW_45_in_attribute758); 
            pushFollow(FOLLOW_identifier_in_attribute762);
            temp=identifier();

            state._fsp--;

            ei.set(ret, "context", temp);
            match(input,COLONCOLON,FOLLOW_COLONCOLON_in_attribute766); 
            pushFollow(FOLLOW_identifier_in_attribute770);
            temp=identifier();

            state._fsp--;

            ei.set(ret, "name", temp);
            match(input,EQ,FOLLOW_EQ_in_attribute774); 
            pushFollow(FOLLOW_expression_in_attribute778);
            temp=expression();

            state._fsp--;

            ei.set(ret, "body", temp);
            match(input,SEMI,FOLLOW_SEMI_in_attribute782); 

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
    // $ANTLR end "attribute"


    // $ANTLR start "parameter"
    // ACG_ANTLR3.g:142:1: parameter returns [Object ret2] : (temp= identifier ) ;
    public final Object parameter() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("Parameter", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:143:2: ( (temp= identifier ) )
            // ACG_ANTLR3.g:143:4: (temp= identifier )
            {
            // ACG_ANTLR3.g:143:4: (temp= identifier )
            // ACG_ANTLR3.g:143:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_parameter816);
            temp=identifier();

            state._fsp--;

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
    // $ANTLR end "parameter"


    // $ANTLR start "node"
    // ACG_ANTLR3.g:153:1: node returns [Object ret2] : ( (ret= aSMNode | ret= codeNode | ret= simpleNode ) ) ;
    public final Object node() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:154:2: ( ( (ret= aSMNode | ret= codeNode | ret= simpleNode ) ) )
            // ACG_ANTLR3.g:154:4: ( (ret= aSMNode | ret= codeNode | ret= simpleNode ) )
            {
            // ACG_ANTLR3.g:154:4: ( (ret= aSMNode | ret= codeNode | ret= simpleNode ) )
            // ACG_ANTLR3.g:154:5: (ret= aSMNode | ret= codeNode | ret= simpleNode )
            {
            // ACG_ANTLR3.g:154:5: (ret= aSMNode | ret= codeNode | ret= simpleNode )
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
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ACG_ANTLR3.g:154:6: ret= aSMNode
                    {
                    pushFollow(FOLLOW_aSMNode_in_node853);
                    ret=aSMNode();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:154:19: ret= codeNode
                    {
                    pushFollow(FOLLOW_codeNode_in_node858);
                    ret=codeNode();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:154:33: ret= simpleNode
                    {
                    pushFollow(FOLLOW_simpleNode_in_node863);
                    ret=simpleNode();

                    state._fsp--;


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
    // $ANTLR end "node"


    // $ANTLR start "aSMNode"
    // ACG_ANTLR3.g:162:1: aSMNode returns [Object ret2] : ( 'asm' temp= identifier 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object aSMNode() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("ASMNode", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:163:2: ( ( 'asm' temp= identifier 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ACG_ANTLR3.g:163:4: ( 'asm' temp= identifier 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ACG_ANTLR3.g:163:4: ( 'asm' temp= identifier 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ACG_ANTLR3.g:163:5: 'asm' temp= identifier 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,46,FOLLOW_46_in_aSMNode896); 
            pushFollow(FOLLOW_identifier_in_aSMNode900);
            temp=identifier();

            state._fsp--;

            ei.set(ret, "element", temp);
            match(input,47,FOLLOW_47_in_aSMNode904); 
            pushFollow(FOLLOW_expression_in_aSMNode908);
            temp=expression();

            state._fsp--;

            ei.set(ret, "name", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_aSMNode912); 
            // ACG_ANTLR3.g:163:118: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ACG_ANTLR3.g:163:119: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ACG_ANTLR3.g:163:119: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ACG_ANTLR3.g:163:120: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ACG_ANTLR3.g:163:120: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NAME||LA9_0==LSQUARE||LA9_0==50||LA9_0==52||LA9_0==54||LA9_0==56||(LA9_0>=58 && LA9_0<=60)||(LA9_0>=64 && LA9_0<=89)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ACG_ANTLR3.g:163:121: (temp= statement ( (temp= statement ) )* )
                    {
                    // ACG_ANTLR3.g:163:121: (temp= statement ( (temp= statement ) )* )
                    // ACG_ANTLR3.g:163:122: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_aSMNode920);
                    temp=statement();

                    state._fsp--;

                    ei.set(ret, "statements", temp);
                    // ACG_ANTLR3.g:163:172: ( (temp= statement ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==NAME||LA8_0==LSQUARE||LA8_0==50||LA8_0==52||LA8_0==54||LA8_0==56||(LA8_0>=58 && LA8_0<=60)||(LA8_0>=64 && LA8_0<=89)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:163:173: (temp= statement )
                    	    {
                    	    // ACG_ANTLR3.g:163:173: (temp= statement )
                    	    // ACG_ANTLR3.g:163:174: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_aSMNode928);
                    	    temp=statement();

                    	    state._fsp--;

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

            match(input,RCURLY,FOLLOW_RCURLY_in_aSMNode940); 

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
    // $ANTLR end "aSMNode"


    // $ANTLR start "codeNode"
    // ACG_ANTLR3.g:173:1: codeNode returns [Object ret2] : ( 'code' temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object codeNode() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("CodeNode", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:174:2: ( ( 'code' temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ACG_ANTLR3.g:174:4: ( 'code' temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ACG_ANTLR3.g:174:4: ( 'code' temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ACG_ANTLR3.g:174:5: 'code' temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,48,FOLLOW_48_in_codeNode972); 
            pushFollow(FOLLOW_identifier_in_codeNode976);
            temp=identifier();

            state._fsp--;

            ei.set(ret, "element", temp);
            // ACG_ANTLR3.g:174:60: ( ( 'mode' temp= identifier ) | () )
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
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ACG_ANTLR3.g:174:61: ( 'mode' temp= identifier )
                    {
                    // ACG_ANTLR3.g:174:61: ( 'mode' temp= identifier )
                    // ACG_ANTLR3.g:174:62: 'mode' temp= identifier
                    {
                    match(input,49,FOLLOW_49_in_codeNode982); 
                    pushFollow(FOLLOW_identifier_in_codeNode986);
                    temp=identifier();

                    state._fsp--;

                    ei.set(ret, "mode", temp);

                    }



                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:174:119: ()
                    {
                    // ACG_ANTLR3.g:174:119: ()
                    // ACG_ANTLR3.g:174:120: 
                    {
                    }



                    }
                    break;

            }

            // ACG_ANTLR3.g:174:126: ( ( PIPE temp= expression ) | () )
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
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ACG_ANTLR3.g:174:127: ( PIPE temp= expression )
                    {
                    // ACG_ANTLR3.g:174:127: ( PIPE temp= expression )
                    // ACG_ANTLR3.g:174:128: PIPE temp= expression
                    {
                    match(input,PIPE,FOLLOW_PIPE_in_codeNode1002); 
                    pushFollow(FOLLOW_expression_in_codeNode1006);
                    temp=expression();

                    state._fsp--;

                    ei.set(ret, "guard", temp);

                    }



                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:174:184: ()
                    {
                    // ACG_ANTLR3.g:174:184: ()
                    // ACG_ANTLR3.g:174:185: 
                    {
                    }



                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_codeNode1020); 
            // ACG_ANTLR3.g:174:198: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ACG_ANTLR3.g:174:199: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ACG_ANTLR3.g:174:199: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ACG_ANTLR3.g:174:200: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ACG_ANTLR3.g:174:200: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NAME||LA13_0==LSQUARE||LA13_0==50||LA13_0==52||LA13_0==54||LA13_0==56||(LA13_0>=58 && LA13_0<=60)||(LA13_0>=64 && LA13_0<=89)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ACG_ANTLR3.g:174:201: (temp= statement ( (temp= statement ) )* )
                    {
                    // ACG_ANTLR3.g:174:201: (temp= statement ( (temp= statement ) )* )
                    // ACG_ANTLR3.g:174:202: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_codeNode1028);
                    temp=statement();

                    state._fsp--;

                    ei.set(ret, "statements", temp);
                    // ACG_ANTLR3.g:174:252: ( (temp= statement ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==NAME||LA12_0==LSQUARE||LA12_0==50||LA12_0==52||LA12_0==54||LA12_0==56||(LA12_0>=58 && LA12_0<=60)||(LA12_0>=64 && LA12_0<=89)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:174:253: (temp= statement )
                    	    {
                    	    // ACG_ANTLR3.g:174:253: (temp= statement )
                    	    // ACG_ANTLR3.g:174:254: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_codeNode1036);
                    	    temp=statement();

                    	    state._fsp--;

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

            match(input,RCURLY,FOLLOW_RCURLY_in_codeNode1048); 

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
    // $ANTLR end "codeNode"


    // $ANTLR start "simpleNode"
    // ACG_ANTLR3.g:184:1: simpleNode returns [Object ret2] : (temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object simpleNode() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("SimpleNode", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:185:2: ( (temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ACG_ANTLR3.g:185:4: (temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ACG_ANTLR3.g:185:4: (temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ACG_ANTLR3.g:185:5: temp= identifier ( ( 'mode' temp= identifier ) | () ) ( ( PIPE temp= expression ) | () ) LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            pushFollow(FOLLOW_identifier_in_simpleNode1082);
            temp=identifier();

            state._fsp--;

            ei.set(ret, "element", temp);
            // ACG_ANTLR3.g:185:53: ( ( 'mode' temp= identifier ) | () )
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
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ACG_ANTLR3.g:185:54: ( 'mode' temp= identifier )
                    {
                    // ACG_ANTLR3.g:185:54: ( 'mode' temp= identifier )
                    // ACG_ANTLR3.g:185:55: 'mode' temp= identifier
                    {
                    match(input,49,FOLLOW_49_in_simpleNode1088); 
                    pushFollow(FOLLOW_identifier_in_simpleNode1092);
                    temp=identifier();

                    state._fsp--;

                    ei.set(ret, "mode", temp);

                    }



                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:185:112: ()
                    {
                    // ACG_ANTLR3.g:185:112: ()
                    // ACG_ANTLR3.g:185:113: 
                    {
                    }



                    }
                    break;

            }

            // ACG_ANTLR3.g:185:119: ( ( PIPE temp= expression ) | () )
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
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ACG_ANTLR3.g:185:120: ( PIPE temp= expression )
                    {
                    // ACG_ANTLR3.g:185:120: ( PIPE temp= expression )
                    // ACG_ANTLR3.g:185:121: PIPE temp= expression
                    {
                    match(input,PIPE,FOLLOW_PIPE_in_simpleNode1108); 
                    pushFollow(FOLLOW_expression_in_simpleNode1112);
                    temp=expression();

                    state._fsp--;

                    ei.set(ret, "guard", temp);

                    }



                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:185:177: ()
                    {
                    // ACG_ANTLR3.g:185:177: ()
                    // ACG_ANTLR3.g:185:178: 
                    {
                    }



                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_simpleNode1126); 
            // ACG_ANTLR3.g:185:191: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ACG_ANTLR3.g:185:192: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ACG_ANTLR3.g:185:192: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ACG_ANTLR3.g:185:193: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ACG_ANTLR3.g:185:193: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==NAME||LA17_0==LSQUARE||LA17_0==50||LA17_0==52||LA17_0==54||LA17_0==56||(LA17_0>=58 && LA17_0<=60)||(LA17_0>=64 && LA17_0<=89)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ACG_ANTLR3.g:185:194: (temp= statement ( (temp= statement ) )* )
                    {
                    // ACG_ANTLR3.g:185:194: (temp= statement ( (temp= statement ) )* )
                    // ACG_ANTLR3.g:185:195: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_simpleNode1134);
                    temp=statement();

                    state._fsp--;

                    ei.set(ret, "statements", temp);
                    // ACG_ANTLR3.g:185:245: ( (temp= statement ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==NAME||LA16_0==LSQUARE||LA16_0==50||LA16_0==52||LA16_0==54||LA16_0==56||(LA16_0>=58 && LA16_0<=60)||(LA16_0>=64 && LA16_0<=89)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:185:246: (temp= statement )
                    	    {
                    	    // ACG_ANTLR3.g:185:246: (temp= statement )
                    	    // ACG_ANTLR3.g:185:247: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_simpleNode1142);
                    	    temp=statement();

                    	    state._fsp--;

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

            match(input,RCURLY,FOLLOW_RCURLY_in_simpleNode1154); 

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
    // $ANTLR end "simpleNode"


    // $ANTLR start "statement"
    // ACG_ANTLR3.g:195:1: statement returns [Object ret2] : ( (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat ) ) ;
    public final Object statement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:196:2: ( ( (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat ) ) )
            // ACG_ANTLR3.g:196:4: ( (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat ) )
            {
            // ACG_ANTLR3.g:196:4: ( (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat ) )
            // ACG_ANTLR3.g:196:5: (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat )
            {
            // ACG_ANTLR3.g:196:5: (ret= compoundStat | ret= reportStat | ret= fieldStat | ret= paramStat | ret= emitStat )
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
                        new NoViableAltException("", 18, 2, input);

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
            case 87:
            case 88:
            case 89:
                {
                alt18=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ACG_ANTLR3.g:196:6: ret= compoundStat
                    {
                    pushFollow(FOLLOW_compoundStat_in_statement1189);
                    ret=compoundStat();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:196:24: ret= reportStat
                    {
                    pushFollow(FOLLOW_reportStat_in_statement1194);
                    ret=reportStat();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:196:40: ret= fieldStat
                    {
                    pushFollow(FOLLOW_fieldStat_in_statement1199);
                    ret=fieldStat();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // ACG_ANTLR3.g:196:55: ret= paramStat
                    {
                    pushFollow(FOLLOW_paramStat_in_statement1204);
                    ret=paramStat();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // ACG_ANTLR3.g:196:70: ret= emitStat
                    {
                    pushFollow(FOLLOW_emitStat_in_statement1209);
                    ret=emitStat();

                    state._fsp--;


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
    // $ANTLR end "statement"


    // $ANTLR start "compoundStat"
    // ACG_ANTLR3.g:204:1: compoundStat returns [Object ret2] : ( (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat ) ) ;
    public final Object compoundStat() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:205:2: ( ( (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat ) ) )
            // ACG_ANTLR3.g:205:4: ( (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat ) )
            {
            // ACG_ANTLR3.g:205:4: ( (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat ) )
            // ACG_ANTLR3.g:205:5: (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat )
            {
            // ACG_ANTLR3.g:205:5: (ret= forEachStat | ret= onceStat | ret= variableStat | ret= operationStat | ret= conditionalStat | ret= letStat | ret= analyzeStat )
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
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ACG_ANTLR3.g:205:6: ret= forEachStat
                    {
                    pushFollow(FOLLOW_forEachStat_in_compoundStat1245);
                    ret=forEachStat();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:205:23: ret= onceStat
                    {
                    pushFollow(FOLLOW_onceStat_in_compoundStat1250);
                    ret=onceStat();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:205:37: ret= variableStat
                    {
                    pushFollow(FOLLOW_variableStat_in_compoundStat1255);
                    ret=variableStat();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // ACG_ANTLR3.g:205:55: ret= operationStat
                    {
                    pushFollow(FOLLOW_operationStat_in_compoundStat1260);
                    ret=operationStat();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // ACG_ANTLR3.g:205:74: ret= conditionalStat
                    {
                    pushFollow(FOLLOW_conditionalStat_in_compoundStat1265);
                    ret=conditionalStat();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // ACG_ANTLR3.g:205:95: ret= letStat
                    {
                    pushFollow(FOLLOW_letStat_in_compoundStat1270);
                    ret=letStat();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // ACG_ANTLR3.g:205:108: ret= analyzeStat
                    {
                    pushFollow(FOLLOW_analyzeStat_in_compoundStat1275);
                    ret=analyzeStat();

                    state._fsp--;


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
    // $ANTLR end "compoundStat"


    // $ANTLR start "forEachStat"
    // ACG_ANTLR3.g:213:1: forEachStat returns [Object ret2] : ( 'foreach' LPAREN temp= variableDecl 'in' temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object forEachStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("ForEachStat", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:214:2: ( ( 'foreach' LPAREN temp= variableDecl 'in' temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ACG_ANTLR3.g:214:4: ( 'foreach' LPAREN temp= variableDecl 'in' temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ACG_ANTLR3.g:214:4: ( 'foreach' LPAREN temp= variableDecl 'in' temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ACG_ANTLR3.g:214:5: 'foreach' LPAREN temp= variableDecl 'in' temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,50,FOLLOW_50_in_forEachStat1308); 
            match(input,LPAREN,FOLLOW_LPAREN_in_forEachStat1310); 
            pushFollow(FOLLOW_variableDecl_in_forEachStat1314);
            temp=variableDecl();

            state._fsp--;

            ei.set(ret, "iterator", temp);
            match(input,51,FOLLOW_51_in_forEachStat1318); 
            pushFollow(FOLLOW_expression_in_forEachStat1322);
            temp=expression();

            state._fsp--;

            ei.set(ret, "collection", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_forEachStat1326); 
            match(input,LCURLY,FOLLOW_LCURLY_in_forEachStat1328); 
            // ACG_ANTLR3.g:214:143: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ACG_ANTLR3.g:214:144: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ACG_ANTLR3.g:214:144: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ACG_ANTLR3.g:214:145: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ACG_ANTLR3.g:214:145: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NAME||LA21_0==LSQUARE||LA21_0==50||LA21_0==52||LA21_0==54||LA21_0==56||(LA21_0>=58 && LA21_0<=60)||(LA21_0>=64 && LA21_0<=89)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ACG_ANTLR3.g:214:146: (temp= statement ( (temp= statement ) )* )
                    {
                    // ACG_ANTLR3.g:214:146: (temp= statement ( (temp= statement ) )* )
                    // ACG_ANTLR3.g:214:147: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_forEachStat1336);
                    temp=statement();

                    state._fsp--;

                    ei.set(ret, "statements", temp);
                    // ACG_ANTLR3.g:214:197: ( (temp= statement ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==NAME||LA20_0==LSQUARE||LA20_0==50||LA20_0==52||LA20_0==54||LA20_0==56||(LA20_0>=58 && LA20_0<=60)||(LA20_0>=64 && LA20_0<=89)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:214:198: (temp= statement )
                    	    {
                    	    // ACG_ANTLR3.g:214:198: (temp= statement )
                    	    // ACG_ANTLR3.g:214:199: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_forEachStat1344);
                    	    temp=statement();

                    	    state._fsp--;

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

            match(input,RCURLY,FOLLOW_RCURLY_in_forEachStat1356); 

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
    // $ANTLR end "forEachStat"


    // $ANTLR start "onceStat"
    // ACG_ANTLR3.g:224:1: onceStat returns [Object ret2] : ( LSQUARE ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RSQUARE ) ;
    public final Object onceStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("OnceStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:225:2: ( ( LSQUARE ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RSQUARE ) )
            // ACG_ANTLR3.g:225:4: ( LSQUARE ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RSQUARE )
            {
            // ACG_ANTLR3.g:225:4: ( LSQUARE ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RSQUARE )
            // ACG_ANTLR3.g:225:5: LSQUARE ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RSQUARE
            {
            match(input,LSQUARE,FOLLOW_LSQUARE_in_onceStat1388); 
            // ACG_ANTLR3.g:225:13: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ACG_ANTLR3.g:225:14: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ACG_ANTLR3.g:225:14: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ACG_ANTLR3.g:225:15: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ACG_ANTLR3.g:225:15: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==NAME||LA23_0==LSQUARE||LA23_0==50||LA23_0==52||LA23_0==54||LA23_0==56||(LA23_0>=58 && LA23_0<=60)||(LA23_0>=64 && LA23_0<=89)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ACG_ANTLR3.g:225:16: (temp= statement ( (temp= statement ) )* )
                    {
                    // ACG_ANTLR3.g:225:16: (temp= statement ( (temp= statement ) )* )
                    // ACG_ANTLR3.g:225:17: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_onceStat1396);
                    temp=statement();

                    state._fsp--;

                    ei.set(ret, "statements", temp);
                    // ACG_ANTLR3.g:225:67: ( (temp= statement ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==NAME||LA22_0==LSQUARE||LA22_0==50||LA22_0==52||LA22_0==54||LA22_0==56||(LA22_0>=58 && LA22_0<=60)||(LA22_0>=64 && LA22_0<=89)) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:225:68: (temp= statement )
                    	    {
                    	    // ACG_ANTLR3.g:225:68: (temp= statement )
                    	    // ACG_ANTLR3.g:225:69: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_onceStat1404);
                    	    temp=statement();

                    	    state._fsp--;

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

            match(input,RSQUARE,FOLLOW_RSQUARE_in_onceStat1416); 

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
    // $ANTLR end "onceStat"


    // $ANTLR start "variableStat"
    // ACG_ANTLR3.g:235:1: variableStat returns [Object ret2] : ( 'variable' temp= expression 'named' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object variableStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("VariableStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:236:2: ( ( 'variable' temp= expression 'named' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ACG_ANTLR3.g:236:4: ( 'variable' temp= expression 'named' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ACG_ANTLR3.g:236:4: ( 'variable' temp= expression 'named' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ACG_ANTLR3.g:236:5: 'variable' temp= expression 'named' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,52,FOLLOW_52_in_variableStat1448); 
            pushFollow(FOLLOW_expression_in_variableStat1452);
            temp=expression();

            state._fsp--;

            ei.set(ret, "definition", temp);
            match(input,53,FOLLOW_53_in_variableStat1456); 
            pushFollow(FOLLOW_expression_in_variableStat1460);
            temp=expression();

            state._fsp--;

            ei.set(ret, "name", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_variableStat1464); 
            // ACG_ANTLR3.g:236:127: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ACG_ANTLR3.g:236:128: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ACG_ANTLR3.g:236:128: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ACG_ANTLR3.g:236:129: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ACG_ANTLR3.g:236:129: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==NAME||LA25_0==LSQUARE||LA25_0==50||LA25_0==52||LA25_0==54||LA25_0==56||(LA25_0>=58 && LA25_0<=60)||(LA25_0>=64 && LA25_0<=89)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ACG_ANTLR3.g:236:130: (temp= statement ( (temp= statement ) )* )
                    {
                    // ACG_ANTLR3.g:236:130: (temp= statement ( (temp= statement ) )* )
                    // ACG_ANTLR3.g:236:131: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_variableStat1472);
                    temp=statement();

                    state._fsp--;

                    ei.set(ret, "statements", temp);
                    // ACG_ANTLR3.g:236:181: ( (temp= statement ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==NAME||LA24_0==LSQUARE||LA24_0==50||LA24_0==52||LA24_0==54||LA24_0==56||(LA24_0>=58 && LA24_0<=60)||(LA24_0>=64 && LA24_0<=89)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:236:182: (temp= statement )
                    	    {
                    	    // ACG_ANTLR3.g:236:182: (temp= statement )
                    	    // ACG_ANTLR3.g:236:183: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_variableStat1480);
                    	    temp=statement();

                    	    state._fsp--;

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

            match(input,RCURLY,FOLLOW_RCURLY_in_variableStat1492); 

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
    // $ANTLR end "variableStat"


    // $ANTLR start "operationStat"
    // ACG_ANTLR3.g:246:1: operationStat returns [Object ret2] : ( 'operation' 'context' temp= expression 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object operationStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("OperationStat", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:247:2: ( ( 'operation' 'context' temp= expression 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ACG_ANTLR3.g:247:4: ( 'operation' 'context' temp= expression 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ACG_ANTLR3.g:247:4: ( 'operation' 'context' temp= expression 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ACG_ANTLR3.g:247:5: 'operation' 'context' temp= expression 'name' temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,54,FOLLOW_54_in_operationStat1524); 
            match(input,55,FOLLOW_55_in_operationStat1526); 
            pushFollow(FOLLOW_expression_in_operationStat1530);
            temp=expression();

            state._fsp--;

            ei.set(ret, "context", temp);
            match(input,47,FOLLOW_47_in_operationStat1534); 
            pushFollow(FOLLOW_expression_in_operationStat1538);
            temp=expression();

            state._fsp--;

            ei.set(ret, "name", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_operationStat1542); 
            // ACG_ANTLR3.g:247:134: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ACG_ANTLR3.g:247:135: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ACG_ANTLR3.g:247:135: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ACG_ANTLR3.g:247:136: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ACG_ANTLR3.g:247:136: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==NAME||LA27_0==LSQUARE||LA27_0==50||LA27_0==52||LA27_0==54||LA27_0==56||(LA27_0>=58 && LA27_0<=60)||(LA27_0>=64 && LA27_0<=89)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ACG_ANTLR3.g:247:137: (temp= statement ( (temp= statement ) )* )
                    {
                    // ACG_ANTLR3.g:247:137: (temp= statement ( (temp= statement ) )* )
                    // ACG_ANTLR3.g:247:138: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_operationStat1550);
                    temp=statement();

                    state._fsp--;

                    ei.set(ret, "statements", temp);
                    // ACG_ANTLR3.g:247:188: ( (temp= statement ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==NAME||LA26_0==LSQUARE||LA26_0==50||LA26_0==52||LA26_0==54||LA26_0==56||(LA26_0>=58 && LA26_0<=60)||(LA26_0>=64 && LA26_0<=89)) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:247:189: (temp= statement )
                    	    {
                    	    // ACG_ANTLR3.g:247:189: (temp= statement )
                    	    // ACG_ANTLR3.g:247:190: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_operationStat1558);
                    	    temp=statement();

                    	    state._fsp--;

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

            match(input,RCURLY,FOLLOW_RCURLY_in_operationStat1570); 

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
    // $ANTLR end "operationStat"


    // $ANTLR start "conditionalStat"
    // ACG_ANTLR3.g:257:1: conditionalStat returns [Object ret2] : ( 'if' LPAREN temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) ) ;
    public final Object conditionalStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("ConditionalStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:258:2: ( ( 'if' LPAREN temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) ) )
            // ACG_ANTLR3.g:258:4: ( 'if' LPAREN temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) )
            {
            // ACG_ANTLR3.g:258:4: ( 'if' LPAREN temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) )
            // ACG_ANTLR3.g:258:5: 'if' LPAREN temp= expression RPAREN LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () )
            {
            match(input,56,FOLLOW_56_in_conditionalStat1602); 
            match(input,LPAREN,FOLLOW_LPAREN_in_conditionalStat1604); 
            pushFollow(FOLLOW_expression_in_conditionalStat1608);
            temp=expression();

            state._fsp--;

            ei.set(ret, "condition", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_conditionalStat1612); 
            match(input,LCURLY,FOLLOW_LCURLY_in_conditionalStat1614); 
            // ACG_ANTLR3.g:258:81: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ACG_ANTLR3.g:258:82: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ACG_ANTLR3.g:258:82: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ACG_ANTLR3.g:258:83: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ACG_ANTLR3.g:258:83: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==NAME||LA29_0==LSQUARE||LA29_0==50||LA29_0==52||LA29_0==54||LA29_0==56||(LA29_0>=58 && LA29_0<=60)||(LA29_0>=64 && LA29_0<=89)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ACG_ANTLR3.g:258:84: (temp= statement ( (temp= statement ) )* )
                    {
                    // ACG_ANTLR3.g:258:84: (temp= statement ( (temp= statement ) )* )
                    // ACG_ANTLR3.g:258:85: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_conditionalStat1622);
                    temp=statement();

                    state._fsp--;

                    ei.set(ret, "statements", temp);
                    // ACG_ANTLR3.g:258:135: ( (temp= statement ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==NAME||LA28_0==LSQUARE||LA28_0==50||LA28_0==52||LA28_0==54||LA28_0==56||(LA28_0>=58 && LA28_0<=60)||(LA28_0>=64 && LA28_0<=89)) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:258:136: (temp= statement )
                    	    {
                    	    // ACG_ANTLR3.g:258:136: (temp= statement )
                    	    // ACG_ANTLR3.g:258:137: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_conditionalStat1630);
                    	    temp=statement();

                    	    state._fsp--;

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

            match(input,RCURLY,FOLLOW_RCURLY_in_conditionalStat1642); 
            // ACG_ANTLR3.g:258:202: ( ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==57) ) {
                alt32=1;
            }
            else if ( (LA32_0==NAME||LA32_0==RCURLY||(LA32_0>=LSQUARE && LA32_0<=RSQUARE)||LA32_0==50||LA32_0==52||LA32_0==54||LA32_0==56||(LA32_0>=58 && LA32_0<=60)||(LA32_0>=64 && LA32_0<=89)) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ACG_ANTLR3.g:258:203: ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    {
                    // ACG_ANTLR3.g:258:203: ( 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    // ACG_ANTLR3.g:258:204: 'else' LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
                    {
                    match(input,57,FOLLOW_57_in_conditionalStat1646); 
                    match(input,LCURLY,FOLLOW_LCURLY_in_conditionalStat1648); 
                    // ACG_ANTLR3.g:258:218: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
                    // ACG_ANTLR3.g:258:219: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    {
                    // ACG_ANTLR3.g:258:219: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    // ACG_ANTLR3.g:258:220: ( (temp= statement ( (temp= statement ) )* ) )?
                    {
                    // ACG_ANTLR3.g:258:220: ( (temp= statement ( (temp= statement ) )* ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==NAME||LA31_0==LSQUARE||LA31_0==50||LA31_0==52||LA31_0==54||LA31_0==56||(LA31_0>=58 && LA31_0<=60)||(LA31_0>=64 && LA31_0<=89)) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ACG_ANTLR3.g:258:221: (temp= statement ( (temp= statement ) )* )
                            {
                            // ACG_ANTLR3.g:258:221: (temp= statement ( (temp= statement ) )* )
                            // ACG_ANTLR3.g:258:222: temp= statement ( (temp= statement ) )*
                            {
                            pushFollow(FOLLOW_statement_in_conditionalStat1656);
                            temp=statement();

                            state._fsp--;

                            ei.set(ret, "elseStatements", temp);
                            // ACG_ANTLR3.g:258:276: ( (temp= statement ) )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==NAME||LA30_0==LSQUARE||LA30_0==50||LA30_0==52||LA30_0==54||LA30_0==56||(LA30_0>=58 && LA30_0<=60)||(LA30_0>=64 && LA30_0<=89)) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // ACG_ANTLR3.g:258:277: (temp= statement )
                            	    {
                            	    // ACG_ANTLR3.g:258:277: (temp= statement )
                            	    // ACG_ANTLR3.g:258:278: temp= statement
                            	    {
                            	    pushFollow(FOLLOW_statement_in_conditionalStat1664);
                            	    temp=statement();

                            	    state._fsp--;

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

                    match(input,RCURLY,FOLLOW_RCURLY_in_conditionalStat1676); 

                    }



                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:258:352: ()
                    {
                    // ACG_ANTLR3.g:258:352: ()
                    // ACG_ANTLR3.g:258:353: 
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
    // $ANTLR end "conditionalStat"


    // $ANTLR start "letStat"
    // ACG_ANTLR3.g:268:1: letStat returns [Object ret2] : ( 'let' temp= variableDecl EQ temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) ;
    public final Object letStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("LetStat", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:269:2: ( ( 'let' temp= variableDecl EQ temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) )
            // ACG_ANTLR3.g:269:4: ( 'let' temp= variableDecl EQ temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            {
            // ACG_ANTLR3.g:269:4: ( 'let' temp= variableDecl EQ temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
            // ACG_ANTLR3.g:269:5: 'let' temp= variableDecl EQ temp= expression LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
            {
            match(input,58,FOLLOW_58_in_letStat1718); 
            pushFollow(FOLLOW_variableDecl_in_letStat1722);
            temp=variableDecl();

            state._fsp--;

            ei.set(ret, "variable", temp);
            match(input,EQ,FOLLOW_EQ_in_letStat1726); 
            pushFollow(FOLLOW_expression_in_letStat1730);
            temp=expression();

            state._fsp--;

            ei.set(ret, "value", temp);
            match(input,LCURLY,FOLLOW_LCURLY_in_letStat1734); 
            // ACG_ANTLR3.g:269:118: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
            // ACG_ANTLR3.g:269:119: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            {
            // ACG_ANTLR3.g:269:119: ( ( (temp= statement ( (temp= statement ) )* ) )? )
            // ACG_ANTLR3.g:269:120: ( (temp= statement ( (temp= statement ) )* ) )?
            {
            // ACG_ANTLR3.g:269:120: ( (temp= statement ( (temp= statement ) )* ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==NAME||LA34_0==LSQUARE||LA34_0==50||LA34_0==52||LA34_0==54||LA34_0==56||(LA34_0>=58 && LA34_0<=60)||(LA34_0>=64 && LA34_0<=89)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ACG_ANTLR3.g:269:121: (temp= statement ( (temp= statement ) )* )
                    {
                    // ACG_ANTLR3.g:269:121: (temp= statement ( (temp= statement ) )* )
                    // ACG_ANTLR3.g:269:122: temp= statement ( (temp= statement ) )*
                    {
                    pushFollow(FOLLOW_statement_in_letStat1742);
                    temp=statement();

                    state._fsp--;

                    ei.set(ret, "statements", temp);
                    // ACG_ANTLR3.g:269:172: ( (temp= statement ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==NAME||LA33_0==LSQUARE||LA33_0==50||LA33_0==52||LA33_0==54||LA33_0==56||(LA33_0>=58 && LA33_0<=60)||(LA33_0>=64 && LA33_0<=89)) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:269:173: (temp= statement )
                    	    {
                    	    // ACG_ANTLR3.g:269:173: (temp= statement )
                    	    // ACG_ANTLR3.g:269:174: temp= statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_letStat1750);
                    	    temp=statement();

                    	    state._fsp--;

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

            match(input,RCURLY,FOLLOW_RCURLY_in_letStat1762); 

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
    // $ANTLR end "letStat"


    // $ANTLR start "analyzeStat"
    // ACG_ANTLR3.g:279:1: analyzeStat returns [Object ret2] : ( 'analyze' temp= expression ( ( 'mode' temp= identifier ) | () ) ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) ) ;
    public final Object analyzeStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("AnalyzeStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:280:2: ( ( 'analyze' temp= expression ( ( 'mode' temp= identifier ) | () ) ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) ) )
            // ACG_ANTLR3.g:280:4: ( 'analyze' temp= expression ( ( 'mode' temp= identifier ) | () ) ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) )
            {
            // ACG_ANTLR3.g:280:4: ( 'analyze' temp= expression ( ( 'mode' temp= identifier ) | () ) ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () ) )
            // ACG_ANTLR3.g:280:5: 'analyze' temp= expression ( ( 'mode' temp= identifier ) | () ) ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () )
            {
            match(input,59,FOLLOW_59_in_analyzeStat1794); 
            pushFollow(FOLLOW_expression_in_analyzeStat1798);
            temp=expression();

            state._fsp--;

            ei.set(ret, "target", temp);
            // ACG_ANTLR3.g:280:62: ( ( 'mode' temp= identifier ) | () )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==49) ) {
                alt35=1;
            }
            else if ( (LA35_0==NAME||(LA35_0>=LCURLY && LA35_0<=RCURLY)||(LA35_0>=LSQUARE && LA35_0<=RSQUARE)||LA35_0==50||LA35_0==52||LA35_0==54||LA35_0==56||(LA35_0>=58 && LA35_0<=60)||(LA35_0>=64 && LA35_0<=89)) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ACG_ANTLR3.g:280:63: ( 'mode' temp= identifier )
                    {
                    // ACG_ANTLR3.g:280:63: ( 'mode' temp= identifier )
                    // ACG_ANTLR3.g:280:64: 'mode' temp= identifier
                    {
                    match(input,49,FOLLOW_49_in_analyzeStat1804); 
                    pushFollow(FOLLOW_identifier_in_analyzeStat1808);
                    temp=identifier();

                    state._fsp--;

                    ei.set(ret, "mode", temp);

                    }



                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:280:121: ()
                    {
                    // ACG_ANTLR3.g:280:121: ()
                    // ACG_ANTLR3.g:280:122: 
                    {
                    }



                    }
                    break;

            }

            // ACG_ANTLR3.g:280:128: ( ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY ) | () )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==LCURLY) ) {
                alt38=1;
            }
            else if ( (LA38_0==NAME||LA38_0==RCURLY||(LA38_0>=LSQUARE && LA38_0<=RSQUARE)||LA38_0==50||LA38_0==52||LA38_0==54||LA38_0==56||(LA38_0>=58 && LA38_0<=60)||(LA38_0>=64 && LA38_0<=89)) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ACG_ANTLR3.g:280:129: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    {
                    // ACG_ANTLR3.g:280:129: ( LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY )
                    // ACG_ANTLR3.g:280:130: LCURLY ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) ) RCURLY
                    {
                    match(input,LCURLY,FOLLOW_LCURLY_in_analyzeStat1824); 
                    // ACG_ANTLR3.g:280:137: ( ( ( (temp= statement ( (temp= statement ) )* ) )? ) )
                    // ACG_ANTLR3.g:280:138: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    {
                    // ACG_ANTLR3.g:280:138: ( ( (temp= statement ( (temp= statement ) )* ) )? )
                    // ACG_ANTLR3.g:280:139: ( (temp= statement ( (temp= statement ) )* ) )?
                    {
                    // ACG_ANTLR3.g:280:139: ( (temp= statement ( (temp= statement ) )* ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==NAME||LA37_0==LSQUARE||LA37_0==50||LA37_0==52||LA37_0==54||LA37_0==56||(LA37_0>=58 && LA37_0<=60)||(LA37_0>=64 && LA37_0<=89)) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ACG_ANTLR3.g:280:140: (temp= statement ( (temp= statement ) )* )
                            {
                            // ACG_ANTLR3.g:280:140: (temp= statement ( (temp= statement ) )* )
                            // ACG_ANTLR3.g:280:141: temp= statement ( (temp= statement ) )*
                            {
                            pushFollow(FOLLOW_statement_in_analyzeStat1832);
                            temp=statement();

                            state._fsp--;

                            ei.set(ret, "statements", temp);
                            // ACG_ANTLR3.g:280:191: ( (temp= statement ) )*
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==NAME||LA36_0==LSQUARE||LA36_0==50||LA36_0==52||LA36_0==54||LA36_0==56||(LA36_0>=58 && LA36_0<=60)||(LA36_0>=64 && LA36_0<=89)) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // ACG_ANTLR3.g:280:192: (temp= statement )
                            	    {
                            	    // ACG_ANTLR3.g:280:192: (temp= statement )
                            	    // ACG_ANTLR3.g:280:193: temp= statement
                            	    {
                            	    pushFollow(FOLLOW_statement_in_analyzeStat1840);
                            	    temp=statement();

                            	    state._fsp--;

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

                    match(input,RCURLY,FOLLOW_RCURLY_in_analyzeStat1852); 

                    }



                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:280:263: ()
                    {
                    // ACG_ANTLR3.g:280:263: ()
                    // ACG_ANTLR3.g:280:264: 
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
    // $ANTLR end "analyzeStat"


    // $ANTLR start "reportStat"
    // ACG_ANTLR3.g:290:1: reportStat returns [Object ret2] : ( 'report' temp= severity temp= expression ) ;
    public final Object reportStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("ReportStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:291:2: ( ( 'report' temp= severity temp= expression ) )
            // ACG_ANTLR3.g:291:4: ( 'report' temp= severity temp= expression )
            {
            // ACG_ANTLR3.g:291:4: ( 'report' temp= severity temp= expression )
            // ACG_ANTLR3.g:291:5: 'report' temp= severity temp= expression
            {
            match(input,60,FOLLOW_60_in_reportStat1894); 
            pushFollow(FOLLOW_severity_in_reportStat1898);
            temp=severity();

            state._fsp--;

            ei.set(ret, "severity", temp);
            pushFollow(FOLLOW_expression_in_reportStat1904);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "reportStat"


    // $ANTLR start "severity"
    // ACG_ANTLR3.g:301:1: severity returns [Object ret2] : ( ( 'critic' ) | ( 'error' ) | ( 'warning' ) ) ;
    public final Object severity() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ACG_ANTLR3.g:302:2: ( ( ( 'critic' ) | ( 'error' ) | ( 'warning' ) ) )
            // ACG_ANTLR3.g:302:4: ( ( 'critic' ) | ( 'error' ) | ( 'warning' ) )
            {
            // ACG_ANTLR3.g:302:4: ( ( 'critic' ) | ( 'error' ) | ( 'warning' ) )
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
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ACG_ANTLR3.g:302:5: ( 'critic' )
                    {
                    // ACG_ANTLR3.g:302:5: ( 'critic' )
                    // ACG_ANTLR3.g:302:6: 'critic'
                    {
                    match(input,61,FOLLOW_61_in_severity1939); 

                    }

                    ret = ei.createEnumLiteral("critic");

                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:302:57: ( 'error' )
                    {
                    // ACG_ANTLR3.g:302:57: ( 'error' )
                    // ACG_ANTLR3.g:302:58: 'error'
                    {
                    match(input,62,FOLLOW_62_in_severity1946); 

                    }

                    ret = ei.createEnumLiteral("error");

                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:302:107: ( 'warning' )
                    {
                    // ACG_ANTLR3.g:302:107: ( 'warning' )
                    // ACG_ANTLR3.g:302:108: 'warning'
                    {
                    match(input,63,FOLLOW_63_in_severity1953); 

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
    // $ANTLR end "severity"


    // $ANTLR start "fieldStat"
    // ACG_ANTLR3.g:309:1: fieldStat returns [Object ret2] : ( 'field' temp= expression COLON temp= expression ) ;
    public final Object fieldStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("FieldStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:310:2: ( ( 'field' temp= expression COLON temp= expression ) )
            // ACG_ANTLR3.g:310:4: ( 'field' temp= expression COLON temp= expression )
            {
            // ACG_ANTLR3.g:310:4: ( 'field' temp= expression COLON temp= expression )
            // ACG_ANTLR3.g:310:5: 'field' temp= expression COLON temp= expression
            {
            match(input,64,FOLLOW_64_in_fieldStat1988); 
            pushFollow(FOLLOW_expression_in_fieldStat1992);
            temp=expression();

            state._fsp--;

            ei.set(ret, "name", temp);
            match(input,COLON,FOLLOW_COLON_in_fieldStat1996); 
            pushFollow(FOLLOW_expression_in_fieldStat2000);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "fieldStat"


    // $ANTLR start "paramStat"
    // ACG_ANTLR3.g:320:1: paramStat returns [Object ret2] : ( 'param' temp= expression COLON temp= expression ) ;
    public final Object paramStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("ParamStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:321:2: ( ( 'param' temp= expression COLON temp= expression ) )
            // ACG_ANTLR3.g:321:4: ( 'param' temp= expression COLON temp= expression )
            {
            // ACG_ANTLR3.g:321:4: ( 'param' temp= expression COLON temp= expression )
            // ACG_ANTLR3.g:321:5: 'param' temp= expression COLON temp= expression
            {
            match(input,65,FOLLOW_65_in_paramStat2034); 
            pushFollow(FOLLOW_expression_in_paramStat2038);
            temp=expression();

            state._fsp--;

            ei.set(ret, "name", temp);
            match(input,COLON,FOLLOW_COLON_in_paramStat2042); 
            pushFollow(FOLLOW_expression_in_paramStat2046);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "paramStat"


    // $ANTLR start "emitStat"
    // ACG_ANTLR3.g:331:1: emitStat returns [Object ret2] : ( (ret= labelStat | ret= newStat | ret= newinStat | ret= deleteStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat ) ) ;
    public final Object emitStat() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:332:2: ( ( (ret= labelStat | ret= newStat | ret= newinStat | ret= deleteStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat ) ) )
            // ACG_ANTLR3.g:332:4: ( (ret= labelStat | ret= newStat | ret= newinStat | ret= deleteStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat ) )
            {
            // ACG_ANTLR3.g:332:4: ( (ret= labelStat | ret= newStat | ret= newinStat | ret= deleteStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat ) )
            // ACG_ANTLR3.g:332:5: (ret= labelStat | ret= newStat | ret= newinStat | ret= deleteStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat )
            {
            // ACG_ANTLR3.g:332:5: (ret= labelStat | ret= newStat | ret= newinStat | ret= deleteStat | ret= dupStat | ret= dupX1Stat | ret= popStat | ret= swapStat | ret= iterateStat | ret= endIterateStat | ret= getAsmStat | ret= findMEStat | ret= pushTStat | ret= pushFStat | ret= emitWithOperandStat | ret= emitWithLabelRefStat )
            int alt40=16;
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
                {
                alt40=13;
                }
                break;
            case 78:
                {
                alt40=14;
                }
                break;
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
                {
                alt40=15;
                }
                break;
            case 56:
            case 89:
                {
                alt40=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ACG_ANTLR3.g:332:6: ret= labelStat
                    {
                    pushFollow(FOLLOW_labelStat_in_emitStat2083);
                    ret=labelStat();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:332:21: ret= newStat
                    {
                    pushFollow(FOLLOW_newStat_in_emitStat2088);
                    ret=newStat();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:332:34: ret= newinStat
                    {
                    pushFollow(FOLLOW_newinStat_in_emitStat2093);
                    ret=newinStat();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // ACG_ANTLR3.g:332:49: ret= deleteStat
                    {
                    pushFollow(FOLLOW_deleteStat_in_emitStat2098);
                    ret=deleteStat();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // ACG_ANTLR3.g:332:65: ret= dupStat
                    {
                    pushFollow(FOLLOW_dupStat_in_emitStat2103);
                    ret=dupStat();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // ACG_ANTLR3.g:332:78: ret= dupX1Stat
                    {
                    pushFollow(FOLLOW_dupX1Stat_in_emitStat2108);
                    ret=dupX1Stat();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // ACG_ANTLR3.g:332:93: ret= popStat
                    {
                    pushFollow(FOLLOW_popStat_in_emitStat2113);
                    ret=popStat();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // ACG_ANTLR3.g:332:106: ret= swapStat
                    {
                    pushFollow(FOLLOW_swapStat_in_emitStat2118);
                    ret=swapStat();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // ACG_ANTLR3.g:332:120: ret= iterateStat
                    {
                    pushFollow(FOLLOW_iterateStat_in_emitStat2123);
                    ret=iterateStat();

                    state._fsp--;


                    }
                    break;
                case 10 :
                    // ACG_ANTLR3.g:332:137: ret= endIterateStat
                    {
                    pushFollow(FOLLOW_endIterateStat_in_emitStat2128);
                    ret=endIterateStat();

                    state._fsp--;


                    }
                    break;
                case 11 :
                    // ACG_ANTLR3.g:332:157: ret= getAsmStat
                    {
                    pushFollow(FOLLOW_getAsmStat_in_emitStat2133);
                    ret=getAsmStat();

                    state._fsp--;


                    }
                    break;
                case 12 :
                    // ACG_ANTLR3.g:332:173: ret= findMEStat
                    {
                    pushFollow(FOLLOW_findMEStat_in_emitStat2138);
                    ret=findMEStat();

                    state._fsp--;


                    }
                    break;
                case 13 :
                    // ACG_ANTLR3.g:332:189: ret= pushTStat
                    {
                    pushFollow(FOLLOW_pushTStat_in_emitStat2143);
                    ret=pushTStat();

                    state._fsp--;


                    }
                    break;
                case 14 :
                    // ACG_ANTLR3.g:332:204: ret= pushFStat
                    {
                    pushFollow(FOLLOW_pushFStat_in_emitStat2148);
                    ret=pushFStat();

                    state._fsp--;


                    }
                    break;
                case 15 :
                    // ACG_ANTLR3.g:332:219: ret= emitWithOperandStat
                    {
                    pushFollow(FOLLOW_emitWithOperandStat_in_emitStat2153);
                    ret=emitWithOperandStat();

                    state._fsp--;


                    }
                    break;
                case 16 :
                    // ACG_ANTLR3.g:332:244: ret= emitWithLabelRefStat
                    {
                    pushFollow(FOLLOW_emitWithLabelRefStat_in_emitStat2158);
                    ret=emitWithLabelRefStat();

                    state._fsp--;


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
    // $ANTLR end "emitStat"


    // $ANTLR start "labelStat"
    // ACG_ANTLR3.g:340:1: labelStat returns [Object ret2] : (temp= identifier ( ( LPAREN temp= expression RPAREN ) | () ) COLON ) ;
    public final Object labelStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("LabelStat", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:341:2: ( (temp= identifier ( ( LPAREN temp= expression RPAREN ) | () ) COLON ) )
            // ACG_ANTLR3.g:341:4: (temp= identifier ( ( LPAREN temp= expression RPAREN ) | () ) COLON )
            {
            // ACG_ANTLR3.g:341:4: (temp= identifier ( ( LPAREN temp= expression RPAREN ) | () ) COLON )
            // ACG_ANTLR3.g:341:5: temp= identifier ( ( LPAREN temp= expression RPAREN ) | () ) COLON
            {
            pushFollow(FOLLOW_identifier_in_labelStat2193);
            temp=identifier();

            state._fsp--;

            ei.set(ret, "name", temp);
            // ACG_ANTLR3.g:341:50: ( ( LPAREN temp= expression RPAREN ) | () )
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
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ACG_ANTLR3.g:341:51: ( LPAREN temp= expression RPAREN )
                    {
                    // ACG_ANTLR3.g:341:51: ( LPAREN temp= expression RPAREN )
                    // ACG_ANTLR3.g:341:52: LPAREN temp= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_labelStat2199); 
                    pushFollow(FOLLOW_expression_in_labelStat2203);
                    temp=expression();

                    state._fsp--;

                    ei.set(ret, "id", temp);
                    match(input,RPAREN,FOLLOW_RPAREN_in_labelStat2207); 

                    }



                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:341:114: ()
                    {
                    // ACG_ANTLR3.g:341:114: ()
                    // ACG_ANTLR3.g:341:115: 
                    {
                    }



                    }
                    break;

            }

            match(input,COLON,FOLLOW_COLON_in_labelStat2219); 

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
    // $ANTLR end "labelStat"


    // $ANTLR start "newStat"
    // ACG_ANTLR3.g:351:1: newStat returns [Object ret2] : ( 'new' ) ;
    public final Object newStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("NewStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:352:2: ( ( 'new' ) )
            // ACG_ANTLR3.g:352:4: ( 'new' )
            {
            // ACG_ANTLR3.g:352:4: ( 'new' )
            // ACG_ANTLR3.g:352:5: 'new'
            {
            match(input,66,FOLLOW_66_in_newStat2251); 

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
    // $ANTLR end "newStat"


    // $ANTLR start "newinStat"
    // ACG_ANTLR3.g:362:1: newinStat returns [Object ret2] : ( 'newin' ) ;
    public final Object newinStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("NewinStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:363:2: ( ( 'newin' ) )
            // ACG_ANTLR3.g:363:4: ( 'newin' )
            {
            // ACG_ANTLR3.g:363:4: ( 'newin' )
            // ACG_ANTLR3.g:363:5: 'newin'
            {
            match(input,67,FOLLOW_67_in_newinStat2283); 

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
    // $ANTLR end "newinStat"


    // $ANTLR start "deleteStat"
    // ACG_ANTLR3.g:373:1: deleteStat returns [Object ret2] : ( 'delete' ) ;
    public final Object deleteStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("DeleteStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:374:2: ( ( 'delete' ) )
            // ACG_ANTLR3.g:374:4: ( 'delete' )
            {
            // ACG_ANTLR3.g:374:4: ( 'delete' )
            // ACG_ANTLR3.g:374:5: 'delete'
            {
            match(input,68,FOLLOW_68_in_deleteStat2315); 

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
    // $ANTLR end "deleteStat"


    // $ANTLR start "dupStat"
    // ACG_ANTLR3.g:384:1: dupStat returns [Object ret2] : ( 'dup' ) ;
    public final Object dupStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("DupStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:385:2: ( ( 'dup' ) )
            // ACG_ANTLR3.g:385:4: ( 'dup' )
            {
            // ACG_ANTLR3.g:385:4: ( 'dup' )
            // ACG_ANTLR3.g:385:5: 'dup'
            {
            match(input,69,FOLLOW_69_in_dupStat2347); 

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
    // $ANTLR end "dupStat"


    // $ANTLR start "dupX1Stat"
    // ACG_ANTLR3.g:395:1: dupX1Stat returns [Object ret2] : ( 'dup_x1' ) ;
    public final Object dupX1Stat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("DupX1Stat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:396:2: ( ( 'dup_x1' ) )
            // ACG_ANTLR3.g:396:4: ( 'dup_x1' )
            {
            // ACG_ANTLR3.g:396:4: ( 'dup_x1' )
            // ACG_ANTLR3.g:396:5: 'dup_x1'
            {
            match(input,70,FOLLOW_70_in_dupX1Stat2379); 

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
    // $ANTLR end "dupX1Stat"


    // $ANTLR start "popStat"
    // ACG_ANTLR3.g:406:1: popStat returns [Object ret2] : ( 'pop' ) ;
    public final Object popStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("PopStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:407:2: ( ( 'pop' ) )
            // ACG_ANTLR3.g:407:4: ( 'pop' )
            {
            // ACG_ANTLR3.g:407:4: ( 'pop' )
            // ACG_ANTLR3.g:407:5: 'pop'
            {
            match(input,71,FOLLOW_71_in_popStat2411); 

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
    // $ANTLR end "popStat"


    // $ANTLR start "swapStat"
    // ACG_ANTLR3.g:417:1: swapStat returns [Object ret2] : ( 'swap' ) ;
    public final Object swapStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("SwapStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:418:2: ( ( 'swap' ) )
            // ACG_ANTLR3.g:418:4: ( 'swap' )
            {
            // ACG_ANTLR3.g:418:4: ( 'swap' )
            // ACG_ANTLR3.g:418:5: 'swap'
            {
            match(input,72,FOLLOW_72_in_swapStat2443); 

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
    // $ANTLR end "swapStat"


    // $ANTLR start "iterateStat"
    // ACG_ANTLR3.g:428:1: iterateStat returns [Object ret2] : ( 'iterate' ) ;
    public final Object iterateStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("IterateStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:429:2: ( ( 'iterate' ) )
            // ACG_ANTLR3.g:429:4: ( 'iterate' )
            {
            // ACG_ANTLR3.g:429:4: ( 'iterate' )
            // ACG_ANTLR3.g:429:5: 'iterate'
            {
            match(input,73,FOLLOW_73_in_iterateStat2475); 

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
    // $ANTLR end "iterateStat"


    // $ANTLR start "endIterateStat"
    // ACG_ANTLR3.g:439:1: endIterateStat returns [Object ret2] : ( 'enditerate' ) ;
    public final Object endIterateStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("EndIterateStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:440:2: ( ( 'enditerate' ) )
            // ACG_ANTLR3.g:440:4: ( 'enditerate' )
            {
            // ACG_ANTLR3.g:440:4: ( 'enditerate' )
            // ACG_ANTLR3.g:440:5: 'enditerate'
            {
            match(input,74,FOLLOW_74_in_endIterateStat2507); 

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
    // $ANTLR end "endIterateStat"


    // $ANTLR start "getAsmStat"
    // ACG_ANTLR3.g:450:1: getAsmStat returns [Object ret2] : ( 'getasm' ) ;
    public final Object getAsmStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("GetAsmStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:451:2: ( ( 'getasm' ) )
            // ACG_ANTLR3.g:451:4: ( 'getasm' )
            {
            // ACG_ANTLR3.g:451:4: ( 'getasm' )
            // ACG_ANTLR3.g:451:5: 'getasm'
            {
            match(input,75,FOLLOW_75_in_getAsmStat2539); 

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
    // $ANTLR end "getAsmStat"


    // $ANTLR start "findMEStat"
    // ACG_ANTLR3.g:461:1: findMEStat returns [Object ret2] : ( 'findme' ) ;
    public final Object findMEStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("FindMEStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:462:2: ( ( 'findme' ) )
            // ACG_ANTLR3.g:462:4: ( 'findme' )
            {
            // ACG_ANTLR3.g:462:4: ( 'findme' )
            // ACG_ANTLR3.g:462:5: 'findme'
            {
            match(input,76,FOLLOW_76_in_findMEStat2571); 

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
    // $ANTLR end "findMEStat"


    // $ANTLR start "pushTStat"
    // ACG_ANTLR3.g:472:1: pushTStat returns [Object ret2] : ( 'pusht' ) ;
    public final Object pushTStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("PushTStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:473:2: ( ( 'pusht' ) )
            // ACG_ANTLR3.g:473:4: ( 'pusht' )
            {
            // ACG_ANTLR3.g:473:4: ( 'pusht' )
            // ACG_ANTLR3.g:473:5: 'pusht'
            {
            match(input,77,FOLLOW_77_in_pushTStat2603); 

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
    // $ANTLR end "pushTStat"


    // $ANTLR start "pushFStat"
    // ACG_ANTLR3.g:483:1: pushFStat returns [Object ret2] : ( 'pushf' ) ;
    public final Object pushFStat() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("PushFStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:484:2: ( ( 'pushf' ) )
            // ACG_ANTLR3.g:484:4: ( 'pushf' )
            {
            // ACG_ANTLR3.g:484:4: ( 'pushf' )
            // ACG_ANTLR3.g:484:5: 'pushf'
            {
            match(input,78,FOLLOW_78_in_pushFStat2635); 

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
    // $ANTLR end "pushFStat"


    // $ANTLR start "emitWithOperandStat"
    // ACG_ANTLR3.g:494:1: emitWithOperandStat returns [Object ret2] : ( (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= pCallStat | ret= superCallStat | ret= getStat | ret= setStat ) ) ;
    public final Object emitWithOperandStat() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:495:2: ( ( (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= pCallStat | ret= superCallStat | ret= getStat | ret= setStat ) ) )
            // ACG_ANTLR3.g:495:4: ( (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= pCallStat | ret= superCallStat | ret= getStat | ret= setStat ) )
            {
            // ACG_ANTLR3.g:495:4: ( (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= pCallStat | ret= superCallStat | ret= getStat | ret= setStat ) )
            // ACG_ANTLR3.g:495:5: (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= pCallStat | ret= superCallStat | ret= getStat | ret= setStat )
            {
            // ACG_ANTLR3.g:495:5: (ret= pushStat | ret= pushIStat | ret= pushDStat | ret= loadStat | ret= storeStat | ret= callStat | ret= pCallStat | ret= superCallStat | ret= getStat | ret= setStat )
            int alt42=10;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt42=1;
                }
                break;
            case 80:
                {
                alt42=2;
                }
                break;
            case 81:
                {
                alt42=3;
                }
                break;
            case 82:
                {
                alt42=4;
                }
                break;
            case 83:
                {
                alt42=5;
                }
                break;
            case 84:
                {
                alt42=6;
                }
                break;
            case 85:
                {
                alt42=7;
                }
                break;
            case 86:
                {
                alt42=8;
                }
                break;
            case 87:
                {
                alt42=9;
                }
                break;
            case 88:
                {
                alt42=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ACG_ANTLR3.g:495:6: ret= pushStat
                    {
                    pushFollow(FOLLOW_pushStat_in_emitWithOperandStat2670);
                    ret=pushStat();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:495:20: ret= pushIStat
                    {
                    pushFollow(FOLLOW_pushIStat_in_emitWithOperandStat2675);
                    ret=pushIStat();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:495:35: ret= pushDStat
                    {
                    pushFollow(FOLLOW_pushDStat_in_emitWithOperandStat2680);
                    ret=pushDStat();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // ACG_ANTLR3.g:495:50: ret= loadStat
                    {
                    pushFollow(FOLLOW_loadStat_in_emitWithOperandStat2685);
                    ret=loadStat();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // ACG_ANTLR3.g:495:64: ret= storeStat
                    {
                    pushFollow(FOLLOW_storeStat_in_emitWithOperandStat2690);
                    ret=storeStat();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // ACG_ANTLR3.g:495:79: ret= callStat
                    {
                    pushFollow(FOLLOW_callStat_in_emitWithOperandStat2695);
                    ret=callStat();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // ACG_ANTLR3.g:495:93: ret= pCallStat
                    {
                    pushFollow(FOLLOW_pCallStat_in_emitWithOperandStat2700);
                    ret=pCallStat();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // ACG_ANTLR3.g:495:108: ret= superCallStat
                    {
                    pushFollow(FOLLOW_superCallStat_in_emitWithOperandStat2705);
                    ret=superCallStat();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // ACG_ANTLR3.g:495:127: ret= getStat
                    {
                    pushFollow(FOLLOW_getStat_in_emitWithOperandStat2710);
                    ret=getStat();

                    state._fsp--;


                    }
                    break;
                case 10 :
                    // ACG_ANTLR3.g:495:140: ret= setStat
                    {
                    pushFollow(FOLLOW_setStat_in_emitWithOperandStat2715);
                    ret=setStat();

                    state._fsp--;


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
    // $ANTLR end "emitWithOperandStat"


    // $ANTLR start "pushStat"
    // ACG_ANTLR3.g:503:1: pushStat returns [Object ret2] : ( 'push' temp= expression ) ;
    public final Object pushStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("PushStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:504:2: ( ( 'push' temp= expression ) )
            // ACG_ANTLR3.g:504:4: ( 'push' temp= expression )
            {
            // ACG_ANTLR3.g:504:4: ( 'push' temp= expression )
            // ACG_ANTLR3.g:504:5: 'push' temp= expression
            {
            match(input,79,FOLLOW_79_in_pushStat2748); 
            pushFollow(FOLLOW_expression_in_pushStat2752);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "pushStat"


    // $ANTLR start "pushIStat"
    // ACG_ANTLR3.g:514:1: pushIStat returns [Object ret2] : ( 'pushi' temp= expression ) ;
    public final Object pushIStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("PushIStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:515:2: ( ( 'pushi' temp= expression ) )
            // ACG_ANTLR3.g:515:4: ( 'pushi' temp= expression )
            {
            // ACG_ANTLR3.g:515:4: ( 'pushi' temp= expression )
            // ACG_ANTLR3.g:515:5: 'pushi' temp= expression
            {
            match(input,80,FOLLOW_80_in_pushIStat2786); 
            pushFollow(FOLLOW_expression_in_pushIStat2790);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "pushIStat"


    // $ANTLR start "pushDStat"
    // ACG_ANTLR3.g:525:1: pushDStat returns [Object ret2] : ( 'pushd' temp= expression ) ;
    public final Object pushDStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("PushDStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:526:2: ( ( 'pushd' temp= expression ) )
            // ACG_ANTLR3.g:526:4: ( 'pushd' temp= expression )
            {
            // ACG_ANTLR3.g:526:4: ( 'pushd' temp= expression )
            // ACG_ANTLR3.g:526:5: 'pushd' temp= expression
            {
            match(input,81,FOLLOW_81_in_pushDStat2824); 
            pushFollow(FOLLOW_expression_in_pushDStat2828);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "pushDStat"


    // $ANTLR start "loadStat"
    // ACG_ANTLR3.g:536:1: loadStat returns [Object ret2] : ( 'load' temp= expression ) ;
    public final Object loadStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("LoadStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:537:2: ( ( 'load' temp= expression ) )
            // ACG_ANTLR3.g:537:4: ( 'load' temp= expression )
            {
            // ACG_ANTLR3.g:537:4: ( 'load' temp= expression )
            // ACG_ANTLR3.g:537:5: 'load' temp= expression
            {
            match(input,82,FOLLOW_82_in_loadStat2862); 
            pushFollow(FOLLOW_expression_in_loadStat2866);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "loadStat"


    // $ANTLR start "storeStat"
    // ACG_ANTLR3.g:547:1: storeStat returns [Object ret2] : ( 'store' temp= expression ) ;
    public final Object storeStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("StoreStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:548:2: ( ( 'store' temp= expression ) )
            // ACG_ANTLR3.g:548:4: ( 'store' temp= expression )
            {
            // ACG_ANTLR3.g:548:4: ( 'store' temp= expression )
            // ACG_ANTLR3.g:548:5: 'store' temp= expression
            {
            match(input,83,FOLLOW_83_in_storeStat2900); 
            pushFollow(FOLLOW_expression_in_storeStat2904);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "storeStat"


    // $ANTLR start "callStat"
    // ACG_ANTLR3.g:558:1: callStat returns [Object ret2] : ( 'call' temp= expression ) ;
    public final Object callStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("CallStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:559:2: ( ( 'call' temp= expression ) )
            // ACG_ANTLR3.g:559:4: ( 'call' temp= expression )
            {
            // ACG_ANTLR3.g:559:4: ( 'call' temp= expression )
            // ACG_ANTLR3.g:559:5: 'call' temp= expression
            {
            match(input,84,FOLLOW_84_in_callStat2938); 
            pushFollow(FOLLOW_expression_in_callStat2942);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "callStat"


    // $ANTLR start "pCallStat"
    // ACG_ANTLR3.g:569:1: pCallStat returns [Object ret2] : ( 'pcall' temp= expression ) ;
    public final Object pCallStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("PCallStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:570:2: ( ( 'pcall' temp= expression ) )
            // ACG_ANTLR3.g:570:4: ( 'pcall' temp= expression )
            {
            // ACG_ANTLR3.g:570:4: ( 'pcall' temp= expression )
            // ACG_ANTLR3.g:570:5: 'pcall' temp= expression
            {
            match(input,85,FOLLOW_85_in_pCallStat2976); 
            pushFollow(FOLLOW_expression_in_pCallStat2980);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "pCallStat"


    // $ANTLR start "superCallStat"
    // ACG_ANTLR3.g:580:1: superCallStat returns [Object ret2] : ( 'supercall' temp= expression ) ;
    public final Object superCallStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("SuperCallStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:581:2: ( ( 'supercall' temp= expression ) )
            // ACG_ANTLR3.g:581:4: ( 'supercall' temp= expression )
            {
            // ACG_ANTLR3.g:581:4: ( 'supercall' temp= expression )
            // ACG_ANTLR3.g:581:5: 'supercall' temp= expression
            {
            match(input,86,FOLLOW_86_in_superCallStat3014); 
            pushFollow(FOLLOW_expression_in_superCallStat3018);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "superCallStat"


    // $ANTLR start "getStat"
    // ACG_ANTLR3.g:591:1: getStat returns [Object ret2] : ( 'get' temp= expression ) ;
    public final Object getStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("GetStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:592:2: ( ( 'get' temp= expression ) )
            // ACG_ANTLR3.g:592:4: ( 'get' temp= expression )
            {
            // ACG_ANTLR3.g:592:4: ( 'get' temp= expression )
            // ACG_ANTLR3.g:592:5: 'get' temp= expression
            {
            match(input,87,FOLLOW_87_in_getStat3052); 
            pushFollow(FOLLOW_expression_in_getStat3056);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "getStat"


    // $ANTLR start "setStat"
    // ACG_ANTLR3.g:602:1: setStat returns [Object ret2] : ( 'set' temp= expression ) ;
    public final Object setStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("SetStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:603:2: ( ( 'set' temp= expression ) )
            // ACG_ANTLR3.g:603:4: ( 'set' temp= expression )
            {
            // ACG_ANTLR3.g:603:4: ( 'set' temp= expression )
            // ACG_ANTLR3.g:603:5: 'set' temp= expression
            {
            match(input,88,FOLLOW_88_in_setStat3090); 
            pushFollow(FOLLOW_expression_in_setStat3094);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "setStat"


    // $ANTLR start "emitWithLabelRefStat"
    // ACG_ANTLR3.g:613:1: emitWithLabelRefStat returns [Object ret2] : ( (ret= gotoStat | ret= ifStat ) ) ;
    public final Object emitWithLabelRefStat() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:614:2: ( ( (ret= gotoStat | ret= ifStat ) ) )
            // ACG_ANTLR3.g:614:4: ( (ret= gotoStat | ret= ifStat ) )
            {
            // ACG_ANTLR3.g:614:4: ( (ret= gotoStat | ret= ifStat ) )
            // ACG_ANTLR3.g:614:5: (ret= gotoStat | ret= ifStat )
            {
            // ACG_ANTLR3.g:614:5: (ret= gotoStat | ret= ifStat )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==89) ) {
                alt43=1;
            }
            else if ( (LA43_0==56) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ACG_ANTLR3.g:614:6: ret= gotoStat
                    {
                    pushFollow(FOLLOW_gotoStat_in_emitWithLabelRefStat3131);
                    ret=gotoStat();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:614:20: ret= ifStat
                    {
                    pushFollow(FOLLOW_ifStat_in_emitWithLabelRefStat3136);
                    ret=ifStat();

                    state._fsp--;


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
    // $ANTLR end "emitWithLabelRefStat"


    // $ANTLR start "gotoStat"
    // ACG_ANTLR3.g:622:1: gotoStat returns [Object ret2] : ( 'goto' temp= identifier ) ;
    public final Object gotoStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("GotoStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:623:2: ( ( 'goto' temp= identifier ) )
            // ACG_ANTLR3.g:623:4: ( 'goto' temp= identifier )
            {
            // ACG_ANTLR3.g:623:4: ( 'goto' temp= identifier )
            // ACG_ANTLR3.g:623:5: 'goto' temp= identifier
            {
            match(input,89,FOLLOW_89_in_gotoStat3169); 
            pushFollow(FOLLOW_identifier_in_gotoStat3173);
            temp=identifier();

            state._fsp--;

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
    // $ANTLR end "gotoStat"


    // $ANTLR start "ifStat"
    // ACG_ANTLR3.g:633:1: ifStat returns [Object ret2] : ( 'if' temp= identifier ) ;
    public final Object ifStat() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("IfStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:634:2: ( ( 'if' temp= identifier ) )
            // ACG_ANTLR3.g:634:4: ( 'if' temp= identifier )
            {
            // ACG_ANTLR3.g:634:4: ( 'if' temp= identifier )
            // ACG_ANTLR3.g:634:5: 'if' temp= identifier
            {
            match(input,56,FOLLOW_56_in_ifStat3207); 
            pushFollow(FOLLOW_identifier_in_ifStat3211);
            temp=identifier();

            state._fsp--;

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
    // $ANTLR end "ifStat"


    // $ANTLR start "variableDecl"
    // ACG_ANTLR3.g:644:1: variableDecl returns [Object ret2] : (temp= identifier ) ;
    public final Object variableDecl() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("VariableDecl", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:645:2: ( (temp= identifier ) )
            // ACG_ANTLR3.g:645:4: (temp= identifier )
            {
            // ACG_ANTLR3.g:645:4: (temp= identifier )
            // ACG_ANTLR3.g:645:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_variableDecl3247);
            temp=identifier();

            state._fsp--;

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
    // $ANTLR end "variableDecl"


    // $ANTLR start "expression"
    // ACG_ANTLR3.g:655:1: expression returns [Object ret2] : (ret= priority_5 | ret= letExp ) ;
    public final Object expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:656:2: ( (ret= priority_5 | ret= letExp ) )
            // ACG_ANTLR3.g:656:4: (ret= priority_5 | ret= letExp )
            {
            // ACG_ANTLR3.g:656:4: (ret= priority_5 | ret= letExp )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=NAME && LA44_0<=INT)||LA44_0==LPAREN||LA44_0==MINUS||LA44_0==56||(LA44_0>=90 && LA44_0<=91)||(LA44_0>=94 && LA44_0<=98)) ) {
                alt44=1;
            }
            else if ( (LA44_0==58) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ACG_ANTLR3.g:656:5: ret= priority_5
                    {
                    pushFollow(FOLLOW_priority_5_in_expression3283);
                    ret=priority_5();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:656:21: ret= letExp
                    {
                    pushFollow(FOLLOW_letExp_in_expression3288);
                    ret=letExp();

                    state._fsp--;


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
    // $ANTLR end "expression"


    // $ANTLR start "variableExp"
    // ACG_ANTLR3.g:663:1: variableExp returns [Object ret2] : (temp= identifier ) ;
    public final Object variableExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("VariableExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:664:2: ( (temp= identifier ) )
            // ACG_ANTLR3.g:664:4: (temp= identifier )
            {
            // ACG_ANTLR3.g:664:4: (temp= identifier )
            // ACG_ANTLR3.g:664:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_variableExp3322);
            temp=identifier();

            state._fsp--;

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
    // $ANTLR end "variableExp"


    // $ANTLR start "selfExp"
    // ACG_ANTLR3.g:674:1: selfExp returns [Object ret2] : ( 'self' ) ;
    public final Object selfExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("SelfExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:675:2: ( ( 'self' ) )
            // ACG_ANTLR3.g:675:4: ( 'self' )
            {
            // ACG_ANTLR3.g:675:4: ( 'self' )
            // ACG_ANTLR3.g:675:5: 'self'
            {
            match(input,90,FOLLOW_90_in_selfExp3356); 

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
    // $ANTLR end "selfExp"


    // $ANTLR start "lastExp"
    // ACG_ANTLR3.g:685:1: lastExp returns [Object ret2] : ( 'last' ) ;
    public final Object lastExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("LastExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:686:2: ( ( 'last' ) )
            // ACG_ANTLR3.g:686:4: ( 'last' )
            {
            // ACG_ANTLR3.g:686:4: ( 'last' )
            // ACG_ANTLR3.g:686:5: 'last'
            {
            match(input,91,FOLLOW_91_in_lastExp3388); 

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
    // $ANTLR end "lastExp"


    // $ANTLR start "ifExp"
    // ACG_ANTLR3.g:696:1: ifExp returns [Object ret2] : ( 'if' temp= expression 'then' temp= expression 'else' temp= expression 'endif' ) ;
    public final Object ifExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("IfExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:697:2: ( ( 'if' temp= expression 'then' temp= expression 'else' temp= expression 'endif' ) )
            // ACG_ANTLR3.g:697:4: ( 'if' temp= expression 'then' temp= expression 'else' temp= expression 'endif' )
            {
            // ACG_ANTLR3.g:697:4: ( 'if' temp= expression 'then' temp= expression 'else' temp= expression 'endif' )
            // ACG_ANTLR3.g:697:5: 'if' temp= expression 'then' temp= expression 'else' temp= expression 'endif'
            {
            match(input,56,FOLLOW_56_in_ifExp3420); 
            pushFollow(FOLLOW_expression_in_ifExp3424);
            temp=expression();

            state._fsp--;

            ei.set(ret, "condition", temp);
            match(input,92,FOLLOW_92_in_ifExp3428); 
            pushFollow(FOLLOW_expression_in_ifExp3432);
            temp=expression();

            state._fsp--;

            ei.set(ret, "thenExp", temp);
            match(input,57,FOLLOW_57_in_ifExp3436); 
            pushFollow(FOLLOW_expression_in_ifExp3440);
            temp=expression();

            state._fsp--;

            ei.set(ret, "elseExp", temp);
            match(input,93,FOLLOW_93_in_ifExp3444); 

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
    // $ANTLR end "ifExp"


    // $ANTLR start "isAExp"
    // ACG_ANTLR3.g:707:1: isAExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifier ) ;
    public final Object isAExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("IsAExp", false, false) : null;
        try {
            // ACG_ANTLR3.g:708:2: ( (temp= identifier ) )
            // ACG_ANTLR3.g:708:4: (temp= identifier )
            {
            // ACG_ANTLR3.g:708:4: (temp= identifier )
            // ACG_ANTLR3.g:708:5: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_isAExp3479);
            temp=identifier();

            state._fsp--;

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
    // $ANTLR end "isAExp"


    // $ANTLR start "letExp"
    // ACG_ANTLR3.g:720:1: letExp returns [Object ret2] : ( 'let' temp= variableDecl EQ temp= expression 'in' temp= expression ) ;
    public final Object letExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("LetExp", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:721:2: ( ( 'let' temp= variableDecl EQ temp= expression 'in' temp= expression ) )
            // ACG_ANTLR3.g:721:4: ( 'let' temp= variableDecl EQ temp= expression 'in' temp= expression )
            {
            // ACG_ANTLR3.g:721:4: ( 'let' temp= variableDecl EQ temp= expression 'in' temp= expression )
            // ACG_ANTLR3.g:721:5: 'let' temp= variableDecl EQ temp= expression 'in' temp= expression
            {
            match(input,58,FOLLOW_58_in_letExp3513); 
            pushFollow(FOLLOW_variableDecl_in_letExp3517);
            temp=variableDecl();

            state._fsp--;

            ei.set(ret, "variable", temp);
            match(input,EQ,FOLLOW_EQ_in_letExp3521); 
            pushFollow(FOLLOW_expression_in_letExp3525);
            temp=expression();

            state._fsp--;

            ei.set(ret, "value", temp);
            match(input,51,FOLLOW_51_in_letExp3529); 
            pushFollow(FOLLOW_expression_in_letExp3533);
            temp=expression();

            state._fsp--;

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
    // $ANTLR end "letExp"


    // $ANTLR start "navigationExp"
    // ACG_ANTLR3.g:731:1: navigationExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword ) ;
    public final Object navigationExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("NavigationExp", false, false) : null;
        try {
            // ACG_ANTLR3.g:732:2: ( (temp= identifierOrKeyword ) )
            // ACG_ANTLR3.g:732:4: (temp= identifierOrKeyword )
            {
            // ACG_ANTLR3.g:732:4: (temp= identifierOrKeyword )
            // ACG_ANTLR3.g:732:5: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_navigationExp3570);
            temp=identifierOrKeyword();

            state._fsp--;

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
    // $ANTLR end "navigationExp"


    // $ANTLR start "iteratorExp"
    // ACG_ANTLR3.g:744:1: iteratorExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword LPAREN temp= variableDecl PIPE temp= expression RPAREN ) ;
    public final Object iteratorExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("IteratorExp", true, false) : null;
        try {
            // ACG_ANTLR3.g:745:2: ( (temp= identifierOrKeyword LPAREN temp= variableDecl PIPE temp= expression RPAREN ) )
            // ACG_ANTLR3.g:745:4: (temp= identifierOrKeyword LPAREN temp= variableDecl PIPE temp= expression RPAREN )
            {
            // ACG_ANTLR3.g:745:4: (temp= identifierOrKeyword LPAREN temp= variableDecl PIPE temp= expression RPAREN )
            // ACG_ANTLR3.g:745:5: temp= identifierOrKeyword LPAREN temp= variableDecl PIPE temp= expression RPAREN
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_iteratorExp3607);
            temp=identifierOrKeyword();

            state._fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_iteratorExp3611); 
            pushFollow(FOLLOW_variableDecl_in_iteratorExp3615);
            temp=variableDecl();

            state._fsp--;

            ei.set(ret, "iterator", temp);
            match(input,PIPE,FOLLOW_PIPE_in_iteratorExp3619); 
            pushFollow(FOLLOW_expression_in_iteratorExp3623);
            temp=expression();

            state._fsp--;

            ei.set(ret, "body", temp);
            match(input,RPAREN,FOLLOW_RPAREN_in_iteratorExp3627); 

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
    // $ANTLR end "iteratorExp"


    // $ANTLR start "operationCallExp"
    // ACG_ANTLR3.g:757:1: operationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : (temp= identifierOrKeyword LPAREN ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RPAREN ) ;
    public final Object operationCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("OperationCallExp", false, false) : null;
        try {
            // ACG_ANTLR3.g:758:2: ( (temp= identifierOrKeyword LPAREN ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RPAREN ) )
            // ACG_ANTLR3.g:758:4: (temp= identifierOrKeyword LPAREN ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RPAREN )
            {
            // ACG_ANTLR3.g:758:4: (temp= identifierOrKeyword LPAREN ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RPAREN )
            // ACG_ANTLR3.g:758:5: temp= identifierOrKeyword LPAREN ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RPAREN
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_operationCallExp3662);
            temp=identifierOrKeyword();

            state._fsp--;

            ei.set(ret, "name", temp);
            match(input,LPAREN,FOLLOW_LPAREN_in_operationCallExp3666); 
            // ACG_ANTLR3.g:758:66: ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=NAME && LA46_0<=INT)||LA46_0==LPAREN||LA46_0==MINUS||LA46_0==56||LA46_0==58||(LA46_0>=90 && LA46_0<=91)||(LA46_0>=94 && LA46_0<=98)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ACG_ANTLR3.g:758:67: (temp= expression ( ( ( COMA ) temp= expression ) )* )
                    {
                    // ACG_ANTLR3.g:758:67: (temp= expression ( ( ( COMA ) temp= expression ) )* )
                    // ACG_ANTLR3.g:758:68: temp= expression ( ( ( COMA ) temp= expression ) )*
                    {
                    pushFollow(FOLLOW_expression_in_operationCallExp3672);
                    temp=expression();

                    state._fsp--;

                    ei.set(ret, "arguments", temp);
                    // ACG_ANTLR3.g:758:118: ( ( ( COMA ) temp= expression ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==COMA) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:758:119: ( ( COMA ) temp= expression )
                    	    {
                    	    // ACG_ANTLR3.g:758:119: ( ( COMA ) temp= expression )
                    	    // ACG_ANTLR3.g:758:120: ( COMA ) temp= expression
                    	    {
                    	    // ACG_ANTLR3.g:758:120: ( COMA )
                    	    // ACG_ANTLR3.g:758:121: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_operationCallExp3679); 

                    	    }

                    	    pushFollow(FOLLOW_expression_in_operationCallExp3684);
                    	    temp=expression();

                    	    state._fsp--;

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

            match(input,RPAREN,FOLLOW_RPAREN_in_operationCallExp3694); 

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
    // $ANTLR end "operationCallExp"


    // $ANTLR start "operatorCallExp"
    // ACG_ANTLR3.g:770:1: operatorCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object operatorCallExp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("OperatorCallExp", false, false) : null;
        try {
            // ACG_ANTLR3.g:771:2: ()
            // ACG_ANTLR3.g:772:9: 
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
    // $ANTLR end "operatorCallExp"


    // $ANTLR start "literalExp"
    // ACG_ANTLR3.g:782:1: literalExp returns [Object ret2] : ( (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp ) ) ;
    public final Object literalExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:783:2: ( ( (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp ) ) )
            // ACG_ANTLR3.g:783:4: ( (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp ) )
            {
            // ACG_ANTLR3.g:783:4: ( (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp ) )
            // ACG_ANTLR3.g:783:5: (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp )
            {
            // ACG_ANTLR3.g:783:5: (ret= oclUndefinedExp | ret= collectionExp | ret= booleanExp | ret= integerExp | ret= stringExp )
            int alt47=5;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt47=1;
                }
                break;
            case 95:
                {
                alt47=2;
                }
                break;
            case 96:
            case 97:
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
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ACG_ANTLR3.g:783:6: ret= oclUndefinedExp
                    {
                    pushFollow(FOLLOW_oclUndefinedExp_in_literalExp3758);
                    ret=oclUndefinedExp();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:783:27: ret= collectionExp
                    {
                    pushFollow(FOLLOW_collectionExp_in_literalExp3763);
                    ret=collectionExp();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:783:46: ret= booleanExp
                    {
                    pushFollow(FOLLOW_booleanExp_in_literalExp3768);
                    ret=booleanExp();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // ACG_ANTLR3.g:783:62: ret= integerExp
                    {
                    pushFollow(FOLLOW_integerExp_in_literalExp3773);
                    ret=integerExp();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // ACG_ANTLR3.g:783:78: ret= stringExp
                    {
                    pushFollow(FOLLOW_stringExp_in_literalExp3778);
                    ret=stringExp();

                    state._fsp--;


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
    // $ANTLR end "literalExp"


    // $ANTLR start "oclUndefinedExp"
    // ACG_ANTLR3.g:791:1: oclUndefinedExp returns [Object ret2] : ( 'OclUndefined' ) ;
    public final Object oclUndefinedExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("OclUndefinedExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:792:2: ( ( 'OclUndefined' ) )
            // ACG_ANTLR3.g:792:4: ( 'OclUndefined' )
            {
            // ACG_ANTLR3.g:792:4: ( 'OclUndefined' )
            // ACG_ANTLR3.g:792:5: 'OclUndefined'
            {
            match(input,94,FOLLOW_94_in_oclUndefinedExp3811); 

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
    // $ANTLR end "oclUndefinedExp"


    // $ANTLR start "collectionExp"
    // ACG_ANTLR3.g:802:1: collectionExp returns [Object ret2] : (ret= sequenceExp ) ;
    public final Object collectionExp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:803:2: ( (ret= sequenceExp ) )
            // ACG_ANTLR3.g:803:4: (ret= sequenceExp )
            {
            // ACG_ANTLR3.g:803:4: (ret= sequenceExp )
            // ACG_ANTLR3.g:803:5: ret= sequenceExp
            {
            pushFollow(FOLLOW_sequenceExp_in_collectionExp3845);
            ret=sequenceExp();

            state._fsp--;


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
    // $ANTLR end "collectionExp"


    // $ANTLR start "sequenceExp"
    // ACG_ANTLR3.g:811:1: sequenceExp returns [Object ret2] : ( 'Sequence' LCURLY ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RCURLY ) ;
    public final Object sequenceExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("SequenceExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:812:2: ( ( 'Sequence' LCURLY ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RCURLY ) )
            // ACG_ANTLR3.g:812:4: ( 'Sequence' LCURLY ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RCURLY )
            {
            // ACG_ANTLR3.g:812:4: ( 'Sequence' LCURLY ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RCURLY )
            // ACG_ANTLR3.g:812:5: 'Sequence' LCURLY ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )? RCURLY
            {
            match(input,95,FOLLOW_95_in_sequenceExp3877); 
            match(input,LCURLY,FOLLOW_LCURLY_in_sequenceExp3879); 
            // ACG_ANTLR3.g:812:23: ( (temp= expression ( ( ( COMA ) temp= expression ) )* ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=NAME && LA49_0<=INT)||LA49_0==LPAREN||LA49_0==MINUS||LA49_0==56||LA49_0==58||(LA49_0>=90 && LA49_0<=91)||(LA49_0>=94 && LA49_0<=98)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ACG_ANTLR3.g:812:24: (temp= expression ( ( ( COMA ) temp= expression ) )* )
                    {
                    // ACG_ANTLR3.g:812:24: (temp= expression ( ( ( COMA ) temp= expression ) )* )
                    // ACG_ANTLR3.g:812:25: temp= expression ( ( ( COMA ) temp= expression ) )*
                    {
                    pushFollow(FOLLOW_expression_in_sequenceExp3885);
                    temp=expression();

                    state._fsp--;

                    ei.set(ret, "elements", temp);
                    // ACG_ANTLR3.g:812:74: ( ( ( COMA ) temp= expression ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==COMA) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ACG_ANTLR3.g:812:75: ( ( COMA ) temp= expression )
                    	    {
                    	    // ACG_ANTLR3.g:812:75: ( ( COMA ) temp= expression )
                    	    // ACG_ANTLR3.g:812:76: ( COMA ) temp= expression
                    	    {
                    	    // ACG_ANTLR3.g:812:76: ( COMA )
                    	    // ACG_ANTLR3.g:812:77: COMA
                    	    {
                    	    match(input,COMA,FOLLOW_COMA_in_sequenceExp3892); 

                    	    }

                    	    pushFollow(FOLLOW_expression_in_sequenceExp3897);
                    	    temp=expression();

                    	    state._fsp--;

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

            match(input,RCURLY,FOLLOW_RCURLY_in_sequenceExp3907); 

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
    // $ANTLR end "sequenceExp"


    // $ANTLR start "booleanExp"
    // ACG_ANTLR3.g:822:1: booleanExp returns [Object ret2] : ( ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object booleanExp() throws RecognitionException {
        Object ret2 = null;

        Object ret=(state.backtracking==0) ? ei.create("BooleanExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:823:2: ( ( ( ( 'true' ) | ( 'false' ) ) ) )
            // ACG_ANTLR3.g:823:4: ( ( ( 'true' ) | ( 'false' ) ) )
            {
            // ACG_ANTLR3.g:823:4: ( ( ( 'true' ) | ( 'false' ) ) )
            // ACG_ANTLR3.g:823:5: ( ( 'true' ) | ( 'false' ) )
            {
            // ACG_ANTLR3.g:823:5: ( ( 'true' ) | ( 'false' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==96) ) {
                alt50=1;
            }
            else if ( (LA50_0==97) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ACG_ANTLR3.g:823:6: ( 'true' )
                    {
                    // ACG_ANTLR3.g:823:6: ( 'true' )
                    // ACG_ANTLR3.g:823:7: 'true'
                    {
                    match(input,96,FOLLOW_96_in_booleanExp3941); 

                    }

                    ei.set(ret, "value", java.lang.Boolean.TRUE);

                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:823:64: ( 'false' )
                    {
                    // ACG_ANTLR3.g:823:64: ( 'false' )
                    // ACG_ANTLR3.g:823:65: 'false'
                    {
                    match(input,97,FOLLOW_97_in_booleanExp3948); 

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
    // $ANTLR end "booleanExp"


    // $ANTLR start "integerExp"
    // ACG_ANTLR3.g:833:1: integerExp returns [Object ret2] : (temp= integerSymbol ) ;
    public final Object integerExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("IntegerExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:834:2: ( (temp= integerSymbol ) )
            // ACG_ANTLR3.g:834:4: (temp= integerSymbol )
            {
            // ACG_ANTLR3.g:834:4: (temp= integerSymbol )
            // ACG_ANTLR3.g:834:5: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_integerExp3986);
            temp=integerSymbol();

            state._fsp--;

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
    // $ANTLR end "integerExp"


    // $ANTLR start "stringExp"
    // ACG_ANTLR3.g:844:1: stringExp returns [Object ret2] : (temp= stringSymbol ) ;
    public final Object stringExp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        Object ret=(state.backtracking==0) ? ei.create("StringExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:845:2: ( (temp= stringSymbol ) )
            // ACG_ANTLR3.g:845:4: (temp= stringSymbol )
            {
            // ACG_ANTLR3.g:845:4: (temp= stringSymbol )
            // ACG_ANTLR3.g:845:5: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_stringExp4022);
            temp=stringSymbol();

            state._fsp--;

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
    // $ANTLR end "stringExp"


    // $ANTLR start "priority_0"
    // ACG_ANTLR3.g:855:1: priority_0 returns [Object ret2] : (ret= primary_expression ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )* ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:856:2: ( (ret= primary_expression ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )* ) )
            // ACG_ANTLR3.g:856:4: (ret= primary_expression ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )* )
            {
            // ACG_ANTLR3.g:856:4: (ret= primary_expression ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )* )
            // ACG_ANTLR3.g:856:5: ret= primary_expression ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )*
            {
            pushFollow(FOLLOW_primary_expression_in_priority_04058);
            ret=primary_expression();

            state._fsp--;

            // ACG_ANTLR3.g:856:28: ( ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( ((LA53_0>=POINT && LA53_0<=RARROW)) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ACG_ANTLR3.g:856:29: ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) )
            	    {
            	    // ACG_ANTLR3.g:856:29: ( ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) ) | ( RARROW ret= iteratorExp[opName, ret, firstToken] ) )
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
            	            new NoViableAltException("", 52, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt52) {
            	        case 1 :
            	            // ACG_ANTLR3.g:856:30: ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) )
            	            {
            	            // ACG_ANTLR3.g:856:30: ( POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] ) )
            	            // ACG_ANTLR3.g:856:31: POINT (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )
            	            {
            	            match(input,POINT,FOLLOW_POINT_in_priority_04063); 
            	            opName = ".";
            	            // ACG_ANTLR3.g:856:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )
            	            int alt51=2;
            	            alt51 = dfa51.predict(input);
            	            switch (alt51) {
            	                case 1 :
            	                    // ACG_ANTLR3.g:856:54: ret= navigationExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_navigationExp_in_priority_04070);
            	                    ret=navigationExp(opName, ret, firstToken);

            	                    state._fsp--;


            	                    }
            	                    break;
            	                case 2 :
            	                    // ACG_ANTLR3.g:856:99: ret= operationCallExp[opName, ret, firstToken]
            	                    {
            	                    pushFollow(FOLLOW_operationCallExp_in_priority_04077);
            	                    ret=operationCallExp(opName, ret, firstToken);

            	                    state._fsp--;


            	                    }
            	                    break;

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ACG_ANTLR3.g:856:149: ( RARROW ret= iteratorExp[opName, ret, firstToken] )
            	            {
            	            // ACG_ANTLR3.g:856:149: ( RARROW ret= iteratorExp[opName, ret, firstToken] )
            	            // ACG_ANTLR3.g:856:150: RARROW ret= iteratorExp[opName, ret, firstToken]
            	            {
            	            match(input,RARROW,FOLLOW_RARROW_in_priority_04085); 
            	            opName = "->";
            	            pushFollow(FOLLOW_iteratorExp_in_priority_04091);
            	            ret=iteratorExp(opName, ret, firstToken);

            	            state._fsp--;


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
    // $ANTLR end "priority_0"


    // $ANTLR start "priority_1"
    // ACG_ANTLR3.g:863:1: priority_1 returns [Object ret2] : ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) ;
    public final Object priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:864:2: ( ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) ) )
            // ACG_ANTLR3.g:864:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            {
            // ACG_ANTLR3.g:864:4: ( ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) ) | (ret= priority_0 ) )
            int alt54=3;
            switch ( input.LA(1) ) {
            case 98:
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
            case 90:
            case 91:
            case 94:
            case 95:
            case 96:
            case 97:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ACG_ANTLR3.g:864:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // ACG_ANTLR3.g:864:5: ( 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // ACG_ANTLR3.g:864:6: 'not' (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,98,FOLLOW_98_in_priority_14130); 
                    opName = "not";
                    // ACG_ANTLR3.g:864:30: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // ACG_ANTLR3.g:864:31: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_14137);
                    ret=operatorCallExp(opName, right, firstToken);

                    state._fsp--;

                    pushFollow(FOLLOW_priority_0_in_priority_14142);
                    right=priority_0();

                    state._fsp--;

                    ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
                    	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

                    }


                    }


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:865:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    {
                    // ACG_ANTLR3.g:865:71: ( MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 ) )
                    // ACG_ANTLR3.g:865:72: MINUS (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_priority_14150); 
                    opName = "-";
                    // ACG_ANTLR3.g:865:94: (ret= operatorCallExp[opName, right, firstToken] right= priority_0 )
                    // ACG_ANTLR3.g:865:95: ret= operatorCallExp[opName, right, firstToken] right= priority_0
                    {
                    pushFollow(FOLLOW_operatorCallExp_in_priority_14157);
                    ret=operatorCallExp(opName, right, firstToken);

                    state._fsp--;

                    pushFollow(FOLLOW_priority_0_in_priority_14162);
                    right=priority_0();

                    state._fsp--;

                    ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
                    	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

                    }


                    }


                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:866:71: (ret= priority_0 )
                    {
                    // ACG_ANTLR3.g:866:71: (ret= priority_0 )
                    // ACG_ANTLR3.g:866:72: ret= priority_0
                    {
                    pushFollow(FOLLOW_priority_0_in_priority_14172);
                    ret=priority_0();

                    state._fsp--;


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
    // $ANTLR end "priority_1"


    // $ANTLR start "priority_2"
    // ACG_ANTLR3.g:873:1: priority_2 returns [Object ret2] : (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ;
    public final Object priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:874:2: ( (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            // ACG_ANTLR3.g:874:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            {
            // ACG_ANTLR3.g:874:4: (ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            // ACG_ANTLR3.g:874:5: ret= priority_1 ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_1_in_priority_24207);
            ret=priority_1();

            state._fsp--;

            // ACG_ANTLR3.g:874:20: ( ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( ((LA56_0>=STAR && LA56_0<=SLASH)||(LA56_0>=99 && LA56_0<=100)) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ACG_ANTLR3.g:874:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
            	    {
            	    // ACG_ANTLR3.g:874:21: ( ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) | ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) ) )
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
            	    case 99:
            	        {
            	        alt55=3;
            	        }
            	        break;
            	    case 100:
            	        {
            	        alt55=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 55, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt55) {
            	        case 1 :
            	            // ACG_ANTLR3.g:874:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ACG_ANTLR3.g:874:22: ( STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ACG_ANTLR3.g:874:23: STAR (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,STAR,FOLLOW_STAR_in_priority_24212); 
            	            opName = "*";
            	            // ACG_ANTLR3.g:874:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ACG_ANTLR3.g:874:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_24219);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_24224);
            	            right=priority_1();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ACG_ANTLR3.g:875:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ACG_ANTLR3.g:875:71: ( SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ACG_ANTLR3.g:875:72: SLASH (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,SLASH,FOLLOW_SLASH_in_priority_24232); 
            	            opName = "/";
            	            // ACG_ANTLR3.g:875:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ACG_ANTLR3.g:875:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_24239);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_24244);
            	            right=priority_1();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ACG_ANTLR3.g:876:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ACG_ANTLR3.g:876:71: ( 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ACG_ANTLR3.g:876:72: 'div' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,99,FOLLOW_99_in_priority_24252); 
            	            opName = "div";
            	            // ACG_ANTLR3.g:876:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ACG_ANTLR3.g:876:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_24259);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_24264);
            	            right=priority_1();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ACG_ANTLR3.g:877:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            {
            	            // ACG_ANTLR3.g:877:71: ( 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 ) )
            	            // ACG_ANTLR3.g:877:72: 'mod' (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            {
            	            match(input,100,FOLLOW_100_in_priority_24272); 
            	            opName = "mod";
            	            // ACG_ANTLR3.g:877:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_1 )
            	            // ACG_ANTLR3.g:877:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_1
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_24279);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_1_in_priority_24284);
            	            right=priority_1();

            	            state._fsp--;

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
    // $ANTLR end "priority_2"


    // $ANTLR start "priority_3"
    // ACG_ANTLR3.g:885:1: priority_3 returns [Object ret2] : (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) ;
    public final Object priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:886:2: ( (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* ) )
            // ACG_ANTLR3.g:886:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            {
            // ACG_ANTLR3.g:886:4: (ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            // ACG_ANTLR3.g:886:5: ret= priority_2 ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_2_in_priority_34325);
            ret=priority_2();

            state._fsp--;

            // ACG_ANTLR3.g:886:20: ( ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==MINUS||LA58_0==PLUS) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ACG_ANTLR3.g:886:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
            	    {
            	    // ACG_ANTLR3.g:886:21: ( ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) | ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) ) )
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
            	            new NoViableAltException("", 57, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt57) {
            	        case 1 :
            	            // ACG_ANTLR3.g:886:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // ACG_ANTLR3.g:886:22: ( PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // ACG_ANTLR3.g:886:23: PLUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_priority_34330); 
            	            opName = "+";
            	            // ACG_ANTLR3.g:886:44: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // ACG_ANTLR3.g:886:45: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_34337);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_2_in_priority_34342);
            	            right=priority_2();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ACG_ANTLR3.g:887:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            {
            	            // ACG_ANTLR3.g:887:71: ( MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 ) )
            	            // ACG_ANTLR3.g:887:72: MINUS (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_priority_34350); 
            	            opName = "-";
            	            // ACG_ANTLR3.g:887:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_2 )
            	            // ACG_ANTLR3.g:887:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_2
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_34357);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_2_in_priority_34362);
            	            right=priority_2();

            	            state._fsp--;

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
    // $ANTLR end "priority_3"


    // $ANTLR start "priority_4"
    // ACG_ANTLR3.g:895:1: priority_4 returns [Object ret2] : (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )* ) ;
    public final Object priority_4() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:896:2: ( (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )* ) )
            // ACG_ANTLR3.g:896:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )* )
            {
            // ACG_ANTLR3.g:896:4: (ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )* )
            // ACG_ANTLR3.g:896:5: ret= priority_3 ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )*
            {
            pushFollow(FOLLOW_priority_3_in_priority_44403);
            ret=priority_3();

            state._fsp--;

            // ACG_ANTLR3.g:896:20: ( ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==EQ||(LA60_0>=GT && LA60_0<=NE)||LA60_0==101) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ACG_ANTLR3.g:896:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) )
            	    {
            	    // ACG_ANTLR3.g:896:21: ( ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) ) | ( 'isa' ret= isAExp[opName, ret, firstToken] ) )
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
            	    case 101:
            	        {
            	        alt59=7;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 59, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt59) {
            	        case 1 :
            	            // ACG_ANTLR3.g:896:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ACG_ANTLR3.g:896:22: ( EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ACG_ANTLR3.g:896:23: EQ (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,EQ,FOLLOW_EQ_in_priority_44408); 
            	            opName = "=";
            	            // ACG_ANTLR3.g:896:42: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ACG_ANTLR3.g:896:43: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44415);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44420);
            	            right=priority_3();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ACG_ANTLR3.g:897:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ACG_ANTLR3.g:897:71: ( GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ACG_ANTLR3.g:897:72: GT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GT,FOLLOW_GT_in_priority_44428); 
            	            opName = ">";
            	            // ACG_ANTLR3.g:897:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ACG_ANTLR3.g:897:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44435);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44440);
            	            right=priority_3();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ACG_ANTLR3.g:898:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ACG_ANTLR3.g:898:71: ( LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ACG_ANTLR3.g:898:72: LT (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LT,FOLLOW_LT_in_priority_44448); 
            	            opName = "<";
            	            // ACG_ANTLR3.g:898:91: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ACG_ANTLR3.g:898:92: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44455);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44460);
            	            right=priority_3();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ACG_ANTLR3.g:899:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ACG_ANTLR3.g:899:71: ( GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ACG_ANTLR3.g:899:72: GE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,GE,FOLLOW_GE_in_priority_44468); 
            	            opName = ">=";
            	            // ACG_ANTLR3.g:899:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ACG_ANTLR3.g:899:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44475);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44480);
            	            right=priority_3();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 5 :
            	            // ACG_ANTLR3.g:900:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ACG_ANTLR3.g:900:71: ( LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ACG_ANTLR3.g:900:72: LE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,LE,FOLLOW_LE_in_priority_44488); 
            	            opName = "<=";
            	            // ACG_ANTLR3.g:900:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ACG_ANTLR3.g:900:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44495);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44500);
            	            right=priority_3();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 6 :
            	            // ACG_ANTLR3.g:901:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            {
            	            // ACG_ANTLR3.g:901:71: ( NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 ) )
            	            // ACG_ANTLR3.g:901:72: NE (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            {
            	            match(input,NE,FOLLOW_NE_in_priority_44508); 
            	            opName = "<>";
            	            // ACG_ANTLR3.g:901:92: (ret= operatorCallExp[opName, ret, firstToken] right= priority_3 )
            	            // ACG_ANTLR3.g:901:93: ret= operatorCallExp[opName, ret, firstToken] right= priority_3
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_44515);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_3_in_priority_44520);
            	            right=priority_3();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 7 :
            	            // ACG_ANTLR3.g:902:71: ( 'isa' ret= isAExp[opName, ret, firstToken] )
            	            {
            	            // ACG_ANTLR3.g:902:71: ( 'isa' ret= isAExp[opName, ret, firstToken] )
            	            // ACG_ANTLR3.g:902:72: 'isa' ret= isAExp[opName, ret, firstToken]
            	            {
            	            match(input,101,FOLLOW_101_in_priority_44528); 
            	            opName = "isa";
            	            pushFollow(FOLLOW_isAExp_in_priority_44534);
            	            ret=isAExp(opName, ret, firstToken);

            	            state._fsp--;


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
    // $ANTLR end "priority_4"


    // $ANTLR start "priority_5"
    // ACG_ANTLR3.g:909:1: priority_5 returns [Object ret2] : (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ;
    public final Object priority_5() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ACG_ANTLR3.g:910:2: ( (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            // ACG_ANTLR3.g:910:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            {
            // ACG_ANTLR3.g:910:4: (ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            // ACG_ANTLR3.g:910:5: ret= priority_4 ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_4_in_priority_54574);
            ret=priority_4();

            state._fsp--;

            // ACG_ANTLR3.g:910:20: ( ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( ((LA62_0>=102 && LA62_0<=105)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ACG_ANTLR3.g:910:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // ACG_ANTLR3.g:910:21: ( ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) | ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) ) )
            	    int alt61=4;
            	    switch ( input.LA(1) ) {
            	    case 102:
            	        {
            	        alt61=1;
            	        }
            	        break;
            	    case 103:
            	        {
            	        alt61=2;
            	        }
            	        break;
            	    case 104:
            	        {
            	        alt61=3;
            	        }
            	        break;
            	    case 105:
            	        {
            	        alt61=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 61, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt61) {
            	        case 1 :
            	            // ACG_ANTLR3.g:910:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ACG_ANTLR3.g:910:22: ( 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ACG_ANTLR3.g:910:23: 'and' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,102,FOLLOW_102_in_priority_54579); 
            	            opName = "and";
            	            // ACG_ANTLR3.g:910:47: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ACG_ANTLR3.g:910:48: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_54586);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_54591);
            	            right=priority_4();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ACG_ANTLR3.g:911:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ACG_ANTLR3.g:911:71: ( 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ACG_ANTLR3.g:911:72: 'or' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,103,FOLLOW_103_in_priority_54599); 
            	            opName = "or";
            	            // ACG_ANTLR3.g:911:94: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ACG_ANTLR3.g:911:95: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_54606);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_54611);
            	            right=priority_4();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ACG_ANTLR3.g:912:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ACG_ANTLR3.g:912:71: ( 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ACG_ANTLR3.g:912:72: 'xor' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,104,FOLLOW_104_in_priority_54619); 
            	            opName = "xor";
            	            // ACG_ANTLR3.g:912:96: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ACG_ANTLR3.g:912:97: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_54626);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_54631);
            	            right=priority_4();

            	            state._fsp--;

            	            ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
            	            	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});

            	            }


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ACG_ANTLR3.g:913:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            {
            	            // ACG_ANTLR3.g:913:71: ( 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 ) )
            	            // ACG_ANTLR3.g:913:72: 'implies' (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            {
            	            match(input,105,FOLLOW_105_in_priority_54639); 
            	            opName = "implies";
            	            // ACG_ANTLR3.g:913:104: (ret= operatorCallExp[opName, ret, firstToken] right= priority_4 )
            	            // ACG_ANTLR3.g:913:105: ret= operatorCallExp[opName, ret, firstToken] right= priority_4
            	            {
            	            pushFollow(FOLLOW_operatorCallExp_in_priority_54646);
            	            ret=operatorCallExp(opName, ret, firstToken);

            	            state._fsp--;

            	            pushFollow(FOLLOW_priority_4_in_priority_54651);
            	            right=priority_4();

            	            state._fsp--;

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
    // $ANTLR end "priority_5"


    // $ANTLR start "primary_expression"
    // ACG_ANTLR3.g:921:1: primary_expression returns [Object ret2] : ( ( LPAREN ret= expression RPAREN ) | ret= variableExp | ret= selfExp | ret= lastExp | ret= ifExp | ret= literalExp ) ;
    public final Object primary_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ACG_ANTLR3.g:922:2: ( ( ( LPAREN ret= expression RPAREN ) | ret= variableExp | ret= selfExp | ret= lastExp | ret= ifExp | ret= literalExp ) )
            // ACG_ANTLR3.g:922:4: ( ( LPAREN ret= expression RPAREN ) | ret= variableExp | ret= selfExp | ret= lastExp | ret= ifExp | ret= literalExp )
            {
            // ACG_ANTLR3.g:922:4: ( ( LPAREN ret= expression RPAREN ) | ret= variableExp | ret= selfExp | ret= lastExp | ret= ifExp | ret= literalExp )
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
            case 90:
                {
                alt63=3;
                }
                break;
            case 91:
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
            case 94:
            case 95:
            case 96:
            case 97:
                {
                alt63=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // ACG_ANTLR3.g:922:5: ( LPAREN ret= expression RPAREN )
                    {
                    // ACG_ANTLR3.g:922:5: ( LPAREN ret= expression RPAREN )
                    // ACG_ANTLR3.g:922:6: LPAREN ret= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_expression4691); 
                    pushFollow(FOLLOW_expression_in_primary_expression4695);
                    ret=expression();

                    state._fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_expression4697); 

                    }


                    }
                    break;
                case 2 :
                    // ACG_ANTLR3.g:922:37: ret= variableExp
                    {
                    pushFollow(FOLLOW_variableExp_in_primary_expression4703);
                    ret=variableExp();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ACG_ANTLR3.g:922:54: ret= selfExp
                    {
                    pushFollow(FOLLOW_selfExp_in_primary_expression4708);
                    ret=selfExp();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // ACG_ANTLR3.g:922:67: ret= lastExp
                    {
                    pushFollow(FOLLOW_lastExp_in_primary_expression4713);
                    ret=lastExp();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // ACG_ANTLR3.g:922:80: ret= ifExp
                    {
                    pushFollow(FOLLOW_ifExp_in_primary_expression4718);
                    ret=ifExp();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // ACG_ANTLR3.g:922:91: ret= literalExp
                    {
                    pushFollow(FOLLOW_literalExp_in_primary_expression4723);
                    ret=literalExp();

                    state._fsp--;


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
    // $ANTLR end "primary_expression"

    // Delegated rules


    protected DFA51 dfa51 = new DFA51(this);
    static final String DFA51_eotS =
        "\104\uffff";
    static final String DFA51_eofS =
        "\104\uffff";
    static final String DFA51_minS =
        "\102\4\2\uffff";
    static final String DFA51_maxS =
        "\102\151\2\uffff";
    static final String DFA51_acceptS =
        "\102\uffff\1\2\1\1";
    static final String DFA51_specialS =
        "\104\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\1\45\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
            "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1"+
            "\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1"+
            "\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1"+
            "\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1"+
            "\74\1\75\1\76\1\77\1\100\1\101",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "\1\103\2\uffff\2\103\1\uffff\1\102\4\103\1\uffff\16\103\21"+
            "\uffff\1\103\1\uffff\6\103\1\uffff\5\103\3\uffff\32\103\2\uffff"+
            "\2\103\5\uffff\7\103",
            "",
            ""
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "856:53: (ret= navigationExp[opName, ret, firstToken] | ret= operationCallExp[opName, ret, firstToken] )";
        }
    }
 

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
    public static final BitSet FOLLOW_103_in_identifierOrKeyword427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_identifierOrKeyword432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_identifierOrKeyword437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_aCG539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_aCG543 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_aCG547 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_aCG551 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_aCG555 = new BitSet(new long[]{0x0001700000000110L});
    public static final BitSet FOLLOW_aCGElement_in_aCG563 = new BitSet(new long[]{0x0001700000000110L});
    public static final BitSet FOLLOW_aCGElement_in_aCG571 = new BitSet(new long[]{0x0001700000000110L});
    public static final BitSet FOLLOW_RCURLY_in_aCG583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_aCGElement618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_aCGElement623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_node_in_aCGElement628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_function661 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_function665 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLONCOLON_in_function669 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_function673 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_function677 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_parameter_in_function685 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMA_in_function692 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parameter_in_function697 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_function716 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_function718 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_function722 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_function726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_attribute758 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_attribute762 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLONCOLON_in_attribute766 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_attribute770 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_attribute774 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_attribute778 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_attribute782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_parameter816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aSMNode_in_node853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_codeNode_in_node858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleNode_in_node863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_aSMNode896 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_aSMNode900 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_aSMNode904 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_aSMNode908 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_aSMNode912 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_aSMNode920 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_aSMNode928 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_aSMNode940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_codeNode972 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_codeNode976 = new BitSet(new long[]{0x0002000000008080L});
    public static final BitSet FOLLOW_49_in_codeNode982 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_codeNode986 = new BitSet(new long[]{0x0000000000008080L});
    public static final BitSet FOLLOW_PIPE_in_codeNode1002 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_codeNode1006 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_codeNode1020 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_codeNode1028 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_codeNode1036 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_codeNode1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleNode1082 = new BitSet(new long[]{0x0002000000008080L});
    public static final BitSet FOLLOW_49_in_simpleNode1088 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_simpleNode1092 = new BitSet(new long[]{0x0000000000008080L});
    public static final BitSet FOLLOW_PIPE_in_simpleNode1108 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_simpleNode1112 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_simpleNode1126 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_simpleNode1134 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_simpleNode1142 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_simpleNode1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundStat_in_statement1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_reportStat_in_statement1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldStat_in_statement1199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_paramStat_in_statement1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emitStat_in_statement1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forEachStat_in_compoundStat1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_onceStat_in_compoundStat1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableStat_in_compoundStat1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationStat_in_compoundStat1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalStat_in_compoundStat1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStat_in_compoundStat1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_analyzeStat_in_compoundStat1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_forEachStat1308 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_forEachStat1310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDecl_in_forEachStat1314 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_forEachStat1318 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_forEachStat1322 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_forEachStat1326 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_forEachStat1328 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_forEachStat1336 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_forEachStat1344 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_forEachStat1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_onceStat1388 = new BitSet(new long[]{0x1D54000000030010L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_onceStat1396 = new BitSet(new long[]{0x1D54000000030010L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_onceStat1404 = new BitSet(new long[]{0x1D54000000030010L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RSQUARE_in_onceStat1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_variableStat1448 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_variableStat1452 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_variableStat1456 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_variableStat1460 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_variableStat1464 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_variableStat1472 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_variableStat1480 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_variableStat1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_operationStat1524 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_operationStat1526 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_operationStat1530 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_operationStat1534 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_operationStat1538 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_operationStat1542 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_operationStat1550 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_operationStat1558 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_operationStat1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conditionalStat1602 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_conditionalStat1604 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_conditionalStat1608 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_conditionalStat1612 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_conditionalStat1614 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_conditionalStat1622 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_conditionalStat1630 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_conditionalStat1642 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_conditionalStat1646 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_conditionalStat1648 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_conditionalStat1656 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_conditionalStat1664 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_conditionalStat1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_letStat1718 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDecl_in_letStat1722 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_letStat1726 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_letStat1730 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_letStat1734 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_letStat1742 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_letStat1750 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_letStat1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_analyzeStat1794 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_analyzeStat1798 = new BitSet(new long[]{0x0002000000000082L});
    public static final BitSet FOLLOW_49_in_analyzeStat1804 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_analyzeStat1808 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_LCURLY_in_analyzeStat1824 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_analyzeStat1832 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_statement_in_analyzeStat1840 = new BitSet(new long[]{0x1D54000000010110L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_RCURLY_in_analyzeStat1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_reportStat1894 = new BitSet(new long[]{0xE000000000000000L});
    public static final BitSet FOLLOW_severity_in_reportStat1898 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_reportStat1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_severity1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_severity1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_severity1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_fieldStat1988 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_fieldStat1992 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_fieldStat1996 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_fieldStat2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_paramStat2034 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_paramStat2038 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_paramStat2042 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_paramStat2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelStat_in_emitStat2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newStat_in_emitStat2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newinStat_in_emitStat2093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStat_in_emitStat2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dupStat_in_emitStat2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dupX1Stat_in_emitStat2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_popStat_in_emitStat2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_swapStat_in_emitStat2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterateStat_in_emitStat2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_endIterateStat_in_emitStat2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getAsmStat_in_emitStat2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_findMEStat_in_emitStat2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushTStat_in_emitStat2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushFStat_in_emitStat2148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emitWithOperandStat_in_emitStat2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emitWithLabelRefStat_in_emitStat2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_labelStat2193 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_LPAREN_in_labelStat2199 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_labelStat2203 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_labelStat2207 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_labelStat2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_newStat2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_newinStat2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_deleteStat2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_dupStat2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_dupX1Stat2379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_popStat2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_swapStat2443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_iterateStat2475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_endIterateStat2507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_getAsmStat2539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_findMEStat2571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_pushTStat2603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_pushFStat2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushStat_in_emitWithOperandStat2670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushIStat_in_emitWithOperandStat2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pushDStat_in_emitWithOperandStat2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loadStat_in_emitWithOperandStat2685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_storeStat_in_emitWithOperandStat2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callStat_in_emitWithOperandStat2695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pCallStat_in_emitWithOperandStat2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_superCallStat_in_emitWithOperandStat2705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getStat_in_emitWithOperandStat2710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setStat_in_emitWithOperandStat2715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_pushStat2748 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_pushStat2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_pushIStat2786 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_pushIStat2790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_pushDStat2824 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_pushDStat2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_loadStat2862 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_loadStat2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_storeStat2900 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_storeStat2904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_callStat2938 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_callStat2942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_pCallStat2976 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_pCallStat2980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_superCallStat3014 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_superCallStat3018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_getStat3052 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_getStat3056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_setStat3090 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_setStat3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gotoStat_in_emitWithLabelRefStat3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_emitWithLabelRefStat3136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_gotoStat3169 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_gotoStat3173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ifStat3207 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_ifStat3211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableDecl3247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_5_in_expression3283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letExp_in_expression3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variableExp3322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_selfExp3356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_lastExp3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ifExp3420 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_ifExp3424 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_ifExp3428 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_ifExp3432 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ifExp3436 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_ifExp3440 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_ifExp3444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_isAExp3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_letExp3513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDecl_in_letExp3517 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_letExp3521 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_letExp3525 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_letExp3529 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_letExp3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_navigationExp3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_iteratorExp3607 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_iteratorExp3611 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_variableDecl_in_iteratorExp3615 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_PIPE_in_iteratorExp3619 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_iteratorExp3623 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_iteratorExp3627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_operationCallExp3662 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_operationCallExp3666 = new BitSet(new long[]{0x0500000000201470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_operationCallExp3672 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_COMA_in_operationCallExp3679 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_operationCallExp3684 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RPAREN_in_operationCallExp3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclUndefinedExp_in_literalExp3758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionExp_in_literalExp3763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanExp_in_literalExp3768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerExp_in_literalExp3773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExp_in_literalExp3778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_oclUndefinedExp3811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sequenceExp_in_collectionExp3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_sequenceExp3877 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_sequenceExp3879 = new BitSet(new long[]{0x0500000000200570L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_sequenceExp3885 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_COMA_in_sequenceExp3892 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_sequenceExp3897 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_RCURLY_in_sequenceExp3907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_booleanExp3941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_booleanExp3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_integerExp3986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_stringExp4022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_in_priority_04058 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_POINT_in_priority_04063 = new BitSet(new long[]{0xFFFFFC0000000010L,0x000003FFFFFFFFFFL});
    public static final BitSet FOLLOW_navigationExp_in_priority_04070 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_operationCallExp_in_priority_04077 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_RARROW_in_priority_04085 = new BitSet(new long[]{0xFFFFFC0000000010L,0x000003FFFFFFFFFFL});
    public static final BitSet FOLLOW_iteratorExp_in_priority_04091 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_98_in_priority_14130 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_14137 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_0_in_priority_14142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_priority_14150 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_14157 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_0_in_priority_14162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_0_in_priority_14172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_1_in_priority_24207 = new BitSet(new long[]{0x0000000000C00002L,0x0000001800000000L});
    public static final BitSet FOLLOW_STAR_in_priority_24212 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_24219 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_1_in_priority_24224 = new BitSet(new long[]{0x0000000000C00002L,0x0000001800000000L});
    public static final BitSet FOLLOW_SLASH_in_priority_24232 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_24239 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_1_in_priority_24244 = new BitSet(new long[]{0x0000000000C00002L,0x0000001800000000L});
    public static final BitSet FOLLOW_99_in_priority_24252 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_24259 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_1_in_priority_24264 = new BitSet(new long[]{0x0000000000C00002L,0x0000001800000000L});
    public static final BitSet FOLLOW_100_in_priority_24272 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_24279 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_1_in_priority_24284 = new BitSet(new long[]{0x0000000000C00002L,0x0000001800000000L});
    public static final BitSet FOLLOW_priority_2_in_priority_34325 = new BitSet(new long[]{0x0000000001200002L});
    public static final BitSet FOLLOW_PLUS_in_priority_34330 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_34337 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_2_in_priority_34342 = new BitSet(new long[]{0x0000000001200002L});
    public static final BitSet FOLLOW_MINUS_in_priority_34350 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_34357 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_2_in_priority_34362 = new BitSet(new long[]{0x0000000001200002L});
    public static final BitSet FOLLOW_priority_3_in_priority_44403 = new BitSet(new long[]{0x000000003E002002L,0x0000002000000000L});
    public static final BitSet FOLLOW_EQ_in_priority_44408 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44415 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44420 = new BitSet(new long[]{0x000000003E002002L,0x0000002000000000L});
    public static final BitSet FOLLOW_GT_in_priority_44428 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44435 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44440 = new BitSet(new long[]{0x000000003E002002L,0x0000002000000000L});
    public static final BitSet FOLLOW_LT_in_priority_44448 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44455 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44460 = new BitSet(new long[]{0x000000003E002002L,0x0000002000000000L});
    public static final BitSet FOLLOW_GE_in_priority_44468 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44475 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44480 = new BitSet(new long[]{0x000000003E002002L,0x0000002000000000L});
    public static final BitSet FOLLOW_LE_in_priority_44488 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44495 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44500 = new BitSet(new long[]{0x000000003E002002L,0x0000002000000000L});
    public static final BitSet FOLLOW_NE_in_priority_44508 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_44515 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_3_in_priority_44520 = new BitSet(new long[]{0x000000003E002002L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_priority_44528 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_isAExp_in_priority_44534 = new BitSet(new long[]{0x000000003E002002L,0x0000002000000000L});
    public static final BitSet FOLLOW_priority_4_in_priority_54574 = new BitSet(new long[]{0x0000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_102_in_priority_54579 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_54586 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_4_in_priority_54591 = new BitSet(new long[]{0x0000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_103_in_priority_54599 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_54606 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_4_in_priority_54611 = new BitSet(new long[]{0x0000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_104_in_priority_54619 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_54626 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_4_in_priority_54631 = new BitSet(new long[]{0x0000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_105_in_priority_54639 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_operatorCallExp_in_priority_54646 = new BitSet(new long[]{0x0100000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_priority_4_in_priority_54651 = new BitSet(new long[]{0x0000000000000002L,0x000003C000000000L});
    public static final BitSet FOLLOW_LPAREN_in_primary_expression4691 = new BitSet(new long[]{0x0500000000200470L,0x00000007CC000000L});
    public static final BitSet FOLLOW_expression_in_primary_expression4695 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_expression4697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableExp_in_primary_expression4703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selfExp_in_primary_expression4708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lastExp_in_primary_expression4713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifExp_in_primary_expression4718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalExp_in_primary_expression4723 = new BitSet(new long[]{0x0000000000000002L});

}