lexer grammar ATL_ANTLR3;
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

T42 : 'module' ;
T43 : 'create' ;
T44 : 'refining' ;
T45 : 'from' ;
T46 : 'library' ;
T47 : 'query' ;
T48 : 'uses' ;
T49 : 'helper' ;
T50 : 'def' ;
T51 : 'context' ;
T52 : 'nodefault' ;
T53 : 'abstract' ;
T54 : 'rule' ;
T55 : 'extends' ;
T56 : 'using' ;
T57 : 'unique' ;
T58 : 'lazy' ;
T59 : 'entrypoint' ;
T60 : 'endpoint' ;
T61 : 'in' ;
T62 : 'to' ;
T63 : 'mapsTo' ;
T64 : 'distinct' ;
T65 : 'foreach' ;
T66 : 'do' ;
T67 : 'if' ;
T68 : 'else' ;
T69 : 'for' ;
T70 : 'iterate' ;
T71 : 'OclUndefined' ;
T72 : 'true' ;
T73 : 'false' ;
T74 : 'then' ;
T75 : 'endif' ;
T76 : 'super' ;
T77 : 'let' ;
T78 : 'Bag' ;
T79 : 'Set' ;
T80 : 'OrderedSet' ;
T81 : 'Sequence' ;
T82 : 'Map' ;
T83 : 'Tuple' ;
T84 : 'OclType' ;
T85 : 'OclAny' ;
T86 : 'TupleType' ;
T87 : 'Integer' ;
T88 : 'Real' ;
T89 : 'Boolean' ;
T90 : 'String' ;
T91 : 'Collection' ;
T92 : 'not' ;
T93 : 'div' ;
T94 : 'mod' ;
T95 : 'and' ;
T96 : 'or' ;
T97 : 'xor' ;
T98 : 'implies' ;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1078
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1087
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1093
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1098
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

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1109
fragment
SNAME
//	options {
//		testLiterals = true;
//	}
//	:	(ALPHA) (ALPHA | DIGIT | {LA(2) == ':'}?':' ':')*
//TODO:	:	(ALPHA) (ALPHA | DIGIT | {input.LA(2) == ':'}?':' ':')*
	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1119
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

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1133
INT
	:	(DIGIT)+
//		(('.' DIGIT)=> '.' (DIGIT)+ {$setType(FLOAT);})?
	;

	// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1138
FLOAT	:	DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?	;	// cannot accept DIGIT '.' because it would conflict with Navigation

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1140
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
	

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1187
LSQUARE @init {}
	:	'['
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1195
RSQUARE @init {}
	:	']'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1203
EXCL @init {}
	:	'!'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1211
COMA @init {}
	:	','
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1219
LPAREN @init {}
	:	'('
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1227
RPAREN @init {}
	:	')'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1235
LCURLY @init {}
	:	'{'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1243
RCURLY @init {}
	:	'}'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1251
SEMI @init {}
	:	';'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1259
COLON @init {}
	:	':'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1267
PIPE @init {}
	:	'|'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1275
SHARP @init {}
	:	'#'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1283
QMARK @init {}
	:	'?'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1291
AROBAS @init {}
	:	'@'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1299
POINT @init {}
	:	'.'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1307
RARROW @init {}
	:	'->'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1315
MINUS @init {}
	:	'-'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1323
STAR @init {}
	:	'*'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1331
SLASH @init {}
	:	'/'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1339
PLUS @init {}
	:	'+'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1347
EQ @init {}
	:	'='
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1355
GT @init {}
	:	'>'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1363
LT @init {}
	:	'<'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1371
GE @init {}
	:	'>='
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1379
LE @init {}
	:	'<='
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1387
NE @init {}
	:	'<>'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1395
LARROW @init {}
	:	'<-'
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1403
COMMENT @init {}
	:	(('--' (~('\r'| '\n'))*))
        {
            
        }

	;

// $ANTLR src "D:\dev\workspaces\3.3.2\TCS\ATL\Syntax\ATL_ANTLR3.g" 1411
STRING @init {}
	:	(('\'' (options {greedy = false;} : (('\\'! ~ '\n')| '\n'| ~('\\'| '\n')))* '\''))
        {
            
        }

	;
