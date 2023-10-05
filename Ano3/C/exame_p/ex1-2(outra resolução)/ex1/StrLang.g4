grammar StrLang;

program: stat*EOF;

stat: (print | assignment);

print: 'print' expr;    //expr, expr, expr

assignment: ID ':' expr;


expr:
    expr op=('+'|'-') expr  #ExprAddSub
    |'trim' expr #ExprTrim
    | '(' expr ')'  #ExprPar
    | expr'/'expr'/'expr    #ExprReplace
    |'input(' STRING ')' #ExprInput
    |STRING #ExprString
    |ID #ExprID
    ;


STRING: '"' .*? '"';
ID: [a-zA-Z0-9]+;
WS: [ \r\t\n]+ ->skip;
COMENT: '//' .*? '\n' -> skip;
ERROR: .;