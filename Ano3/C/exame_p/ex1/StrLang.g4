grammar StrLang;

program: stat * EOF;

stat: (print | assignment);

print: 'print' expr ; 

assignment: ID ':' expr ;



expr: 
        expr op= ('+'|'-') expr #ExprAddSub
        | expr '/' expr '/' expr #ExprReplace
        | '(' expr ')' #ExprPar
        | 'trim' expr #ExprTrim
        |STRING    #ExprString
        | ID    #ExprID
        | 'input' '('  expr   ')' #ExprInput
        ;

ID: [a-zA-Z0-9]+;
STRING: '"' .*? '"';
WS: [ \t\r\n]+ -> skip;
COMMENT: '//' .*? '\n' -> skip;
ERROR: .;