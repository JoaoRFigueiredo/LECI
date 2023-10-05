grammar BigIntCalc;

program: stat*EOF;

stat: (show | assignment)';';

show: 'show' expr;

assignment: expr '->' ID;

expr: 
    op=('+'|'-') expr   #ExprUnary
    |expr op=('*'|'div'|'mod') expr #ExprMulDivMod
    |expr op=('+'|'-') expr #ExprAddSub
    | '(' expr ')' #ExprPar
    |BIGINT  #ExprBig
    |ID #ExprID
    ;


BIGINT: [0-9]+;
ID: [a-zA-Z][a-zA-Z0-9]*;
WS: [ \r\t\n]+ -> skip;
COMENT: '#' .*? '\n' -> skip;
Error: .;