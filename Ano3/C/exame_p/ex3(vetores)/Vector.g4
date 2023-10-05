grammar Vector;

program: stat*EOF;

stat: (show | assignment)';';

show: 'show' expr;

assignment: expr '->' ID;

expr:
    op=('+'|'-') expr #ExprUnary
    | expr op=('*'|'.') expr #ExprMultInter
    | expr op=('+'|'-') expr #ExprAddSub
    // | expr '.' expr #ExprIntProd
    | '(' expr ')' #ExprPar
    | NUMBER  #ExprNumber
    | VECTOR #ExprArray
    | ID    #ExprID
    ;

VECTOR:'[' NUMBER (',' NUMBER)* ']';
NUMBER: INT | FLOAT;
FLOAT: [0-9]+ '.' [0-9]+;
INT: [0-9]+;
ID: [a-z][a-z0-9]*;
Comment: '#' .*? '\n' -> skip;
WS: [ \t\r\n]+ -> skip;
ERROR: .;