grammar FracLang;

program: (command? ';')* EOF; 

command: display | assignment;

display: 'display' expr;

assignment: ID '<=' expr;

expr: 
        op= ('+'|'-') expr #ExprUnary
        | expr op= ('*'|':') expr #ExprMultDiv
        | expr op= ('+'|'-') expr #ExprAddSub
        |'(' expr ')' #ExprPar
     |   FRACTION #ExprFraction
     | 'read' STRING #ExprRead
    |   ID #ExprID
    ;

FRACTION: [0-9]+('/' [0-9]+)?;

ID: [a-z]+;
WS: [ \t\r\n]+ -> skip;
STRING: '"'.*?'"';
Comment: '--' .*? '\n' -> skip;
Error: .;