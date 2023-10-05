grammar FracLang;

program: stat * EOF;

stat: (display | assignment)';';

display: 'display' expr;

assignment: ID '<=' expr;

expr:
    op=('+'|'-') expr #ExprUnary
    | expr op=('*'|':') expr #ExprMulDiv
    | expr op=('+'|'-') expr #ExprAddSub
    | '(' expr ')' #ExprPar
    | 'read' STRING #ExprRead
    | 'reduce' expr #ExprReduce
    |FRACTION    #Exprfraction
    |ID #ExprID
    ;

FRACTION: [0-9]+ ('/'[0-9]+)*;
STRING: '"' .*? '"';
ID: [a-z]+;
WS: [ \r\t\n]+ -> skip;
COMENT: '--' .*? '\n' -> skip;
ERROR: .;