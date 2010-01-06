lexer grammar ATL_ANTLR3;
@members {

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

}
@header {package org.eclipse.m2m.atl.dsls.tcs.injector;}

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
T67 : 'do' ;
T68 : 'if' ;
T69 : 'else' ;
T70 : 'for' ;
T71 : 'iterate' ;
T72 : 'OclUndefined' ;
T73 : 'true' ;
T74 : 'false' ;
T75 : 'then' ;
T76 : 'endif' ;
T77 : 'super' ;
T78 : 'let' ;
T79 : 'Bag' ;
T80 : 'Set' ;
T81 : 'OrderedSet' ;
T82 : 'Sequence' ;
T83 : 'Map' ;
T84 : 'Tuple' ;
T85 : 'OclType' ;
T86 : 'OclAny' ;
T87 : 'TupleType' ;
T88 : 'Integer' ;
T89 : 'Real' ;
T90 : 'Boolean' ;
T91 : 'String' ;
T92 : 'Collection' ;
T93 : 'not' ;
T94 : 'div' ;
T95 : 'mod' ;
T96 : 'and' ;
T97 : 'or' ;
T98 : 'xor' ;
T99 : 'implies' ;

// $ANTLR src "ATL_ANTLR3.g" 1078
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "ATL_ANTLR3.g" 1087
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "ATL_ANTLR3.g" 1093
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "ATL_ANTLR3.g" 1098
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

// $ANTLR src "ATL_ANTLR3.g" 1109
fragment
SNAME
//	options {
//		testLiterals = true;
//	}
//	:	(ALPHA) (ALPHA | DIGIT | {LA(2) == ':'}?':' ':')*
//TODO:	:	(ALPHA) (ALPHA | DIGIT | {input.LA(2) == ':'}?':' ':')*
	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "ATL_ANTLR3.g" 1119
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

// $ANTLR src "ATL_ANTLR3.g" 1133
INT
	:	(DIGIT)+
//		(('.' DIGIT)=> '.' (DIGIT)+ {$setType(FLOAT);})?
	;

	// $ANTLR src "ATL_ANTLR3.g" 1138
FLOAT	:	DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?	;	// cannot accept DIGIT '.' because it would conflict with Navigation

// $ANTLR src "ATL_ANTLR3.g" 1140
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
	

// $ANTLR src "ATL_ANTLR3.g" 1187
LSQUARE @init {}
	:	'['
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1195
RSQUARE @init {}
	:	']'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1203
EXCL @init {}
	:	'!'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1211
COMA @init {}
	:	','
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1219
LPAREN @init {}
	:	'('
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1227
RPAREN @init {}
	:	')'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1235
LCURLY @init {}
	:	'{'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1243
RCURLY @init {}
	:	'}'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1251
SEMI @init {}
	:	';'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1259
COLON @init {}
	:	':'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1267
PIPE @init {}
	:	'|'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1275
SHARP @init {}
	:	'#'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1283
QMARK @init {}
	:	'?'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1291
AROBAS @init {}
	:	'@'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1299
POINT @init {}
	:	'.'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1307
RARROW @init {}
	:	'->'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1315
MINUS @init {}
	:	'-'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1323
STAR @init {}
	:	'*'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1331
SLASH @init {}
	:	'/'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1339
PLUS @init {}
	:	'+'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1347
EQ @init {}
	:	'='
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1355
GT @init {}
	:	'>'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1363
LT @init {}
	:	'<'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1371
GE @init {}
	:	'>='
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1379
LE @init {}
	:	'<='
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1387
NE @init {}
	:	'<>'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1395
LARROW @init {}
	:	'<-'
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1403
ASSIGNARROW @init {}
	:	'<:='
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1411
COMMENT @init {}
	:	(('--' (~('\r'| '\n'))*))
        {
            
        }

	;

// $ANTLR src "ATL_ANTLR3.g" 1419
STRING @init {}
	:	(('\'' (options {greedy = false;} : (('\\'! ~ '\n')| '\n'| ~('\\'| '\n')))* '\''))
        {
            
        }

	;
