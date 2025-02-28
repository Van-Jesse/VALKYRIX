grammar RiskRule;

expression: logicalOr;
logicalOr: logicalAnd ('||' logicalAnd)*;
logicalAnd: comparison ('&&' comparison)*;
comparison: additive (('<'|'>'|'=='|'!=') additive)?;
additive: multiplicative (('+'|'-') multiplicative)*;
multiplicative: primary (('*'|'/') primary)*;
primary: '(' expression ')' | NUMBER | STRING | identifierPath;
identifierPath: identifier ('.' identifier)*;
identifier: IDENTIFIER;

NUMBER : [0-9]+ ('.' [0-9]+)?;
STRING  : '\'' .*? '\'' | '"' .*? '"';
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;
WS : [ \t\r\n]+ -> skip;
