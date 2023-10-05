grammar Calculator;
program:
		stat* EOF
	;
stat:
		expr? NEWLINE		#ProcessExpr
	|	assignment? NEWLINE	#ProcessAssignment
	;

assignment:
		ID '=' expr
	;

expr:
		'-' expr 					#unaryMinus
	|	'+' expr 					#unaryPlus
	|	expr op=('*'|'/'|'%') expr  #ExprMultDivMod
	|	expr op=('+'|'-') expr  	#ExprAddSub
	|	Integer  					#ExprInteger
	|	ID							#ExprId
	|	'(' expr ')'				#ExprParent
	;

Integer: [0-9]+;
ID: [a-zA-Z_]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;