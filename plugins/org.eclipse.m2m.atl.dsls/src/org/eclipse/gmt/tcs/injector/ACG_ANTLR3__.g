lexer grammar ACG_ANTLR3;
@members {

	private void newline() {}

	public org.eclipse.gmt.tcs.injector.TCSRuntime ei = null;

	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
		ei.reportError((Exception)e);
	}

	public Token emit() {
		org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken ret = null;

		ret = new org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken(input, type, channel, tokenStartCharIndex, getCharIndex()-1);
		ret.setLine(tokenStartLine);
		ret.setText(text);
	  	ret.setCharPositionInLine(tokenStartCharPositionInLine);
		ret.setEndLine(getLine());
		ret.setEndColumn(getCharPositionInLine());
		emit(ret);

		return ret;
	}

}
@header {package org.eclipse.gmt.tcs.injector;}

T42 : 'acg' ;
T43 : 'startsWith' ;
T44 : 'function' ;
T45 : 'attribute' ;
T46 : 'asm' ;
T47 : 'name' ;
T48 : 'code' ;
T49 : 'mode' ;
T50 : 'foreach' ;
T51 : 'in' ;
T52 : 'variable' ;
T53 : 'named' ;
T54 : 'operation' ;
T55 : 'context' ;
T56 : 'if' ;
T57 : 'else' ;
T58 : 'let' ;
T59 : 'analyze' ;
T60 : 'report' ;
T61 : 'critic' ;
T62 : 'error' ;
T63 : 'warning' ;
T64 : 'field' ;
T65 : 'param' ;
T66 : 'new' ;
T67 : 'dup' ;
T68 : 'dup_x1' ;
T69 : 'pop' ;
T70 : 'swap' ;
T71 : 'iterate' ;
T72 : 'enditerate' ;
T73 : 'getasm' ;
T74 : 'findme' ;
T75 : 'pusht' ;
T76 : 'pushf' ;
T77 : 'push' ;
T78 : 'pushi' ;
T79 : 'pushd' ;
T80 : 'load' ;
T81 : 'store' ;
T82 : 'call' ;
T83 : 'supercall' ;
T84 : 'get' ;
T85 : 'set' ;
T86 : 'goto' ;
T87 : 'self' ;
T88 : 'last' ;
T89 : 'then' ;
T90 : 'endif' ;
T91 : 'OclUndefined' ;
T92 : 'Sequence' ;
T93 : 'true' ;
T94 : 'false' ;
T95 : 'not' ;
T96 : 'div' ;
T97 : 'mod' ;
T98 : 'isa' ;
T99 : 'and' ;
T100 : 'or' ;
T101 : 'xor' ;
T102 : 'implies' ;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 897
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 906
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 912
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 917
fragment
ALPHA
	:	'a'..'z'
	|	'A'..'Z'
	|	'_'
	//For Unicode compatibility (from 0000 to 00ff)
	|	'\u00C0' .. '\u00D6'
	|	'\u00D8' .. '\u00F6'
	|	'\u00F8' .. '\u00FF'
	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 928
fragment
SNAME
//	options {
//		testLiterals = true;
//	}
	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 936
NAME
	:	(
			SNAME
//			s:SNAME {if(s.getType() != SNAME) $setType(s.getType());}
		|	'"'!
			(	ESC
			|	'\n' {newline();}
			|	~('\\'|'\"'|'\n')
			)*
			'"'!
			{setText(ei.unescapeString(getText(), 1));}
		)
	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 950
INT
	:	(DIGIT)+
//		(('.' DIGIT)=> '.' (DIGIT)+ {$setType(FLOAT);})?
	;

	// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 955
FLOAT	:	DIGIT+ '.' DIGIT*	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 957
fragment
ESC
	:	'\\'!
		(	'n' //{setText("\n");}
		|	'r' //{setText("\r");}
		|	't' //{setText("\t");}
		|	'b' //{setText("\b");}
		|	'f' //{setText("\f");}
		|	'"' //{setText("\"");}
		|	'\'' //{setText("\'");}
		|	'\\' //{setText("\\");}
		|	(
				('0'..'3')
				(
//					options {
//						warnWhenFollowAmbig = false;
//					}
				:	('0'..'7')
					(
//						options {
//							warnWhenFollowAmbig = false;
//						}
					:	'0'..'7'
					)?
				)?
			|	('4'..'7')
				(
//					options {
//						warnWhenFollowAmbig = false;
//					}
				:	('0'..'7')
				)?
			)
				{
//					String s = getText();
//					int i;
//					int ret = 0;
//					String ans;
//					for (i=0; i<s.length(); ++i)
//						ret = ret*8 + s.charAt(i) - '0';
//					ans = String.valueOf((char) ret);
//					setText(ans);
				}
		)
	;
	

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1004
LSQUARE @init {}
	:	'['
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1012
RSQUARE @init {}
	:	']'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1020
EXCL @init {}
	:	'!'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1028
COMA @init {}
	:	','
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1036
LPAREN @init {}
	:	'('
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1044
RPAREN @init {}
	:	')'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1052
LCURLY @init {}
	:	'{'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1060
RCURLY @init {}
	:	'}'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1068
SEMI @init {}
	:	';'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1076
COLON @init {}
	:	':'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1084
PIPE @init {}
	:	'|'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1092
SHARP @init {}
	:	'#'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1100
QMARK @init {}
	:	'?'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1108
COLONCOLON @init {}
	:	'::'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1116
POINT @init {}
	:	'.'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1124
RARROW @init {}
	:	'->'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1132
MINUS @init {}
	:	'-'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1140
STAR @init {}
	:	'*'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1148
SLASH @init {}
	:	'/'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1156
PLUS @init {}
	:	'+'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1164
EQ @init {}
	:	'='
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1172
GT @init {}
	:	'>'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1180
LT @init {}
	:	'<'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1188
GE @init {}
	:	'>='
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1196
LE @init {}
	:	'<='
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1204
NE @init {}
	:	'<>'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1212
LARROW @init {}
	:	'<-'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1220
COMMENT @init {}
	:	(('--' (~('\r'| '\n'))*))
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ACG\Syntax\ACG_ANTLR3.g" 1228
STRING @init {}
	:	(('\'' (options {greedy = false;} : (('\\'! ~ '\n')| '\n'| ~('\\'| '\n')))* '\''))
        {
            
        }

	;
