grammar LangComplex;

program: stat*EOF;

stat: (display | assignment)';';


display: 'display' expr;


assignment: ID '<=' expr;

expr:

    op=('+'|'-') expr # ExprUnary
    |expr op=('*'|':') expr #ExprMulDiv
    |expr op=('+'|'-') expr #ExprAddSub
    | '(' expr ')'  #ExprPar
    | '|' expr '|'  #ExprMod
    | 're' expr #ExprGetReal
    | 'im' expr #ExprGetIm
    | expr'*'   #ExprConjugado
    |COMPLEX #ExprComplex
    |REAL  #ExprReal
    |IMAGINARY  #ExprIma
    |ID  #ExprID
    ;

//INT: [0-9]+;
COMPLEX: REAL IMAGINARY;
REAL: [0-9]+ ('.' [0-9]+)?;
IMAGINARY:  [0-9]*'i'; //('+'|'-')?
ID: [a-zA-Z][a-zA-Z0-9]*;
WS: [ \t\r\n] -> skip;
COMENT: '*COM*' .*? '\n' -> skip;
ERROR: .;