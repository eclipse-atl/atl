lexer grammar Properties_ANTLR3;
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

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 133
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 142
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 148
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 153
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

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 164
fragment
SNAME
//	options {
//		testLiterals = true;
//	}
	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 172
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

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 186
INT
	:	(DIGIT)+
//		(('.' DIGIT)=> '.' (DIGIT)+ {$setType(FLOAT);})?
	;

	// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 191
FLOAT	:	DIGIT+ '.' DIGIT*	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 193
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
	

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 240
LSQUARE @init {}
	:	'['
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 248
RSQUARE @init {}
	:	']'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 256
EXCL @init {}
	:	'!'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 264
COMA @init {}
	:	','
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 272
LPAREN @init {}
	:	'('
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 280
RPAREN @init {}
	:	')'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 288
LCURLY @init {}
	:	'{'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 296
RCURLY @init {}
	:	'}'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 304
SEMI @init {}
	:	';'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 312
COLON @init {}
	:	':'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 320
PIPE @init {}
	:	'|'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 328
SHARP @init {}
	:	'#'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 336
QMARK @init {}
	:	'?'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 344
COLONCOLON @init {}
	:	'::'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 352
POINT @init {}
	:	'.'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 360
RARROW @init {}
	:	'->'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 368
MINUS @init {}
	:	'-'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 376
STAR @init {}
	:	'*'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 384
SLASH @init {}
	:	'/'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 392
PLUS @init {}
	:	'+'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 400
EQ @init {}
	:	'='
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 408
GT @init {}
	:	'>'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 416
LT @init {}
	:	'<'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 424
GE @init {}
	:	'>='
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 432
LE @init {}
	:	'<='
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 440
NE @init {}
	:	'<>'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 448
LARROW @init {}
	:	'<-'
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 456
COMMENT @init {}
	:	(('#' (~('\r'| '\n'))*))
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 464
STRING @init {}
	:	(('\'' (options {greedy = false;} : (('\\'! ~ '\n')| '\n'| ~('\\'| '\n')))* '\''))
        {
            
        }

	;

// $ANTLR src "C:\dev\runtime-workspaceEclipse3.4\Properties\Syntax\Properties_ANTLR3.g" 472
EQUALEOL @init {}
	:	(('=' (~('\r'| '\n'))*))
        {
            
        }

	;
