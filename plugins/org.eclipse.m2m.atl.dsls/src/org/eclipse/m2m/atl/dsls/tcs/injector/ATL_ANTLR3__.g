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

T43 : 'module' ;
T44 : 'create' ;
T45 : 'refining' ;
T46 : 'from' ;
T47 : 'library' ;
T48 : 'query' ;
T49 : 'uses' ;
T50 : 'helper' ;
T51 : 'def' ;
T52 : 'context' ;
T53 : 'nodefault' ;
T54 : 'abstract' ;
T55 : 'rule' ;
T56 : 'extends' ;
T57 : 'using' ;
T58 : 'unique' ;
T59 : 'lazy' ;
T60 : 'entrypoint' ;
T61 : 'endpoint' ;
T62 : 'in' ;
T63 : 'to' ;
T64 : 'mapsTo' ;
T65 : 'distinct' ;
T66 : 'foreach' ;
T67 : 'drop' ;
T68 : 'do' ;
T69 : 'if' ;
T70 : 'else' ;
T71 : 'for' ;
T72 : 'iterate' ;
T73 : 'OclUndefined' ;
T74 : 'true' ;
T75 : 'false' ;
T76 : 'then' ;
T77 : 'endif' ;
T78 : 'super' ;
T79 : 'let' ;
T80 : 'Bag' ;
T81 : 'Set' ;
T82 : 'OrderedSet' ;
T83 : 'Sequence' ;
T84 : 'Map' ;
T85 : 'Tuple' ;
T86 : 'OclType' ;
T87 : 'OclAny' ;
T88 : 'TupleType' ;
T89 : 'Integer' ;
T90 : 'Real' ;
T91 : 'Boolean' ;
T92 : 'String' ;
T93 : 'Collection' ;
T94 : 'not' ;
T95 : 'div' ;
T96 : 'mod' ;
T97 : 'and' ;
T98 : 'or' ;
T99 : 'xor' ;
T100 : 'implies' ;

// $ANTLR src "ATL_ANTLR3.g" 1089
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "ATL_ANTLR3.g" 1098
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "ATL_ANTLR3.g" 1104
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "ATL_ANTLR3.g" 1109
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

// $ANTLR src "ATL_ANTLR3.g" 1120
fragment
SNAME
//	options {
//		testLiterals = true;
//	}
//	:	(ALPHA) (ALPHA | DIGIT | {LA(2) == ':'}?':' ':')*
//TODO:	:	(ALPHA) (ALPHA | DIGIT | {input.LA(2) == ':'}?':' ':')*
	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "ATL_ANTLR3.g" 1130
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

// $ANTLR src "ATL_ANTLR3.g" 1144
INT
       :       (DIGIT)+
       			// cannot accept DIGIT '.' because it would conflict with Navigation
//             (('.' DIGIT)=> '.' (DIGIT)+ {$setType(FLOAT);})?
             (|{ ((input.LA(2) >= '0') && (input.LA(2) <= '9')) }? => '.' DIGIT+ {$type = FLOAT;})
       ;
 // $ANTLR src "ATL_ANTLR3.g" 1150
fragment FLOAT:;

// $ANTLR src "ATL_ANTLR3.g" 1152
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
	

// $ANTLR src "ATL_ANTLR3.g" 1199
LSQUARE @init {}
	:	'['
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1207
RSQUARE @init {}
	:	']'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1215
EXCL @init {}
	:	'!'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1223
COMA @init {}
	:	','
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1231
LPAREN @init {}
	:	'('
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1239
RPAREN @init {}
	:	')'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1247
LCURLY @init {}
	:	'{'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1255
RCURLY @init {}
	:	'}'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1263
SEMI @init {}
	:	';'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1271
COLON @init {}
	:	':'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1279
PIPE @init {}
	:	'|'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1287
SHARP @init {}
	:	'#'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1295
QMARK @init {}
	:	'?'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1303
AROBAS @init {}
	:	'@'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1311
POINT @init {}
	:	'.'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1319
RARROW @init {}
	:	'->'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1327
MINUS @init {}
	:	'-'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1335
STAR @init {}
	:	'*'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1343
SLASH @init {}
	:	'/'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1351
PLUS @init {}
	:	'+'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1359
EQ @init {}
	:	'='
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1367
GT @init {}
	:	'>'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1375
LT @init {}
	:	'<'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1383
GE @init {}
	:	'>='
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1391
LE @init {}
	:	'<='
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1399
NE @init {}
	:	'<>'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1407
LARROW @init {}
	:	'<-'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1415
ASSIGNARROW @init {}
	:	'<:='
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1423
COMMENT @init {}
	:	(('--' (~('\r'| '\n'))*))
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1431
STRING @init {}
	:	(('\'' (options {greedy = false;} : (('\\'! ~ '\n')| '\n'| ~('\\'| '\n')))* '\''))
        {
            
        }

	;
