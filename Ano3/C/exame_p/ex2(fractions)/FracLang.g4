grammar FracLang;

command: (stat * EOF);

stat: (display | assignment)';';

assignment: ID '<=' expr;

display: 'display' expr;

expr: 
    op= ('+'|'-') expr #ExprUnary
    |expr op= ('*'|':') expr #ExprMultDiv
    |expr op=('+'|'-') expr #ExprAddSub
    |'(' expr ')' #ExprPar
    | 'read' STRING #ExprRead
    | 'reduce' expr #ExprReduce
    |ID          #ExprID
    |Fraction   #ExprFraction
    ;

Fraction: [0-9]+ ('/' [0-9]+)?;


STRING: '"' .*? '"';
ID: [a-z]+;
WS: [ \t\r\n]+ -> skip;
Comment: '--' .*? '\n' -> skip;
Error: .;
