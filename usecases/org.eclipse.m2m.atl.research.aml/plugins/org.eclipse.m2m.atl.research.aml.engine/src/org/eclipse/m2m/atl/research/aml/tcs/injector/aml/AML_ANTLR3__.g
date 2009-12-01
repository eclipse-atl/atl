lexer grammar AML_ANTLR3;
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

T42 : 'strategy' ;
T43 : 'models' ;
T44 : 'modelsFlow' ;
T45 : 'create' ;
T46 : 'ATLLibraries' ;
T47 : 'JavaLibraries' ;
T48 : 'using' ;
T49 : 'sim' ;
T50 : 'aggr' ;
T51 : 'sel' ;
T52 : 'uses' ;
T53 : 'from' ;
T54 : 'when' ;
T55 : 'leftType' ;
T56 : 'rightType' ;
T57 : 'in' ;
T58 : 'is' ;
T59 : 'to' ;
T60 : 'mapsTo' ;
T61 : 'EqualModel' ;
T62 : 'WeavingModel' ;
T63 : 'thisModule' ;
T64 : 'thisRight' ;
T65 : 'thisLeft' ;
T66 : 'thisEqual' ;
T67 : 'thisWeight' ;
T68 : 'thisSim' ;
T69 : 'thisInstances' ;
T70 : 'Summation' ;
T71 : 'thisEqualModel' ;
T72 : 'name' ;
T73 : 'path' ;
T74 : 'imports' ;
T75 : 'super' ;
T76 : 'iterate' ;
T77 : 'OclUndefined' ;
T78 : 'true' ;
T79 : 'false' ;
T80 : 'if' ;
T81 : 'then' ;
T82 : 'else' ;
T83 : 'endif' ;
T84 : 'let' ;
T85 : 'Bag' ;
T86 : 'Set' ;
T87 : 'OrderedSet' ;
T88 : 'Sequence' ;
T89 : 'Map' ;
T90 : 'Tuple' ;
T91 : 'OclType' ;
T92 : 'OclAny' ;
T93 : 'TupleType' ;
T94 : 'Integer' ;
T95 : 'Real' ;
T96 : 'Boolean' ;
T97 : 'String' ;
T98 : 'Collection' ;
T99 : 'not' ;
T100 : 'div' ;
T101 : 'mod' ;
T102 : 'and' ;
T103 : 'or' ;
T104 : 'xor' ;
T105 : 'implies' ;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1208
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1217
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1223
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1228
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

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1239
fragment
SNAME
//	options {
//		testLiterals = true;
//	}
	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1247
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

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1261
INT
	:	(DIGIT)+
//		(('.' DIGIT)=> '.' (DIGIT)+ {$setType(FLOAT);})?
	;

	// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1266
FLOAT	:	DIGIT+ '.' DIGIT*	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1268
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
	

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1315
LSQUARE @init {}
	:	'['
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1323
RSQUARE @init {}
	:	']'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1331
EXCL @init {}
	:	'!'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1339
COMA @init {}
	:	','
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1347
LPAREN @init {}
	:	'('
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1355
RPAREN @init {}
	:	')'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1363
LCURLY @init {}
	:	'{'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1371
RCURLY @init {}
	:	'}'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1379
SEMI @init {}
	:	';'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1387
COLON @init {}
	:	':'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1395
PIPE @init {}
	:	'|'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1403
SHARP @init {}
	:	'#'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1411
QMARK @init {}
	:	'?'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1419
COLONCOLON @init {}
	:	'::'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1427
POINT @init {}
	:	'.'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1435
RARROW @init {}
	:	'->'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1443
MINUS @init {}
	:	'-'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1451
STAR @init {}
	:	'*'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1459
SLASH @init {}
	:	'/'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1467
PLUS @init {}
	:	'+'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1475
EQ @init {}
	:	'='
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1483
GT @init {}
	:	'>'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1491
LT @init {}
	:	'<'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1499
GE @init {}
	:	'>='
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1507
LE @init {}
	:	'<='
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1515
NE @init {}
	:	'<>'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1523
LARROW @init {}
	:	'<-'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1531
COMMENT @init {}
	:	(('--' (~('\r'| '\n'))*))
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\AML\Syntax\AML_ANTLR3.g" 1539
STRING @init {}
	:	(('\'' (options {greedy = false;} : (('\\'! ~ '\n')| '\n'| ~('\\'| '\n')))* '\''))
        {
            
        }

	;
