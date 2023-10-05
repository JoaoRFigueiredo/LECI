grammar Calculator;

program:
    stat* EOF
    ;
stat : 
    expr? NEWLINE
    ;

expr :
    expr op=('*'|'/'|'%') expr  #ExprMultDivMod
    | expr op=('+'|'-') expr     #ExprAddSub
    | expr Integer              #ExprInteger
    | '(' expr ')'               #ExprParent
    ;

Integer : [0-9]+;
NEWLINE: '\r' ? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;