/*
 * ANTRL (http://www.antlr.org/) grammar for the project language. You will
 * probably want to adapt the file to generate parser for your language of
 * choice and use your own data structures (or define tree parser to traverse
 * the tree generated by ANTLR).
 *
 * Note that this has not been throughly tested, so let us know if there are
 * any problems.
 */

grammar TheLang;

options {
  language= Java;  /* Change this to generate parser for some other language. */
}


  AND: '&';
  OR: '|';
  ASSIGN: ':=';
  SEMI: ';';
  GT: '>';
  GE: '>=';
  LT: '<';
  LE: '<=';
  EQ: '=';
  NEQ: '!=';
  PLUS: '+';
  MINUS: '-';
  MUL: '*';
  DIV: '/';
  NOT: '!';
  LPAREN: '(';
  RPAREN: ')';
  LBRACE: '{';
  RBRACE: '}';
  LBRACKET: '[';
  RBRACKET: ']';
  COLON: ':';
  IF: 'if';
  THEN: 'then';
  ELSE: 'else';
  FI: 'fi';
  WHILE: 'while';
  DO: 'do';
  OD: 'od';
  SKIP: 'skip';
  WRITE: 'write';
  READ: 'read';
  PROGRAM: 'program';
  END: 'end';
  TRUE: 'true';
  FALSE: 'false';
  INT: 'int';
  LOW: 'low';
  HIGH: 'high';


aexpr : aexpr1 (PLUS aexpr1 | MINUS aexpr1)* ;

aexpr1 : aexpr2 (MUL aexpr2 | DIV aexpr2)* ;

aexpr2 : MINUS aexpr3
       | aexpr3
       ;

aexpr3 : IDENTIFIER (LBRACKET aexpr RBRACKET)?
       | INTEGER
       | LPAREN aexpr RPAREN
       ;

bexpr : bexpr1 (OR bexpr1)*
      ;

bexpr1 : bexpr2 (AND bexpr2)*
       ;

bexpr2 : aexpr opr aexpr
       | NOT bexpr
       | TRUE
       | FALSE
       | LPAREN bexpr RPAREN
       ;

opr : GT
    | GE
    | LT
    | LE
    | EQ
    | NEQ
    ;

decl : level? INT IDENTIFIER (LBRACKET INTEGER RBRACKET)? SEMI ;

level : LOW | HIGH ;

stmt : assignStmt
     | assignArrayStmt
     | skipStmt
     | readStmt
     | readArrayStmt
     | writeStmt
     | ifStmt
     | whileStmt
     ;

assignStmt : IDENTIFIER ASSIGN aexpr SEMI ;

assignArrayStmt : IDENTIFIER LBRACKET aexpr RBRACKET ASSIGN aexpr SEMI ;

skipStmt : SKIP SEMI ;

readStmt : READ IDENTIFIER SEMI ;

readArrayStmt : READ IDENTIFIER LBRACKET aexpr RBRACKET SEMI ;

writeStmt : WRITE aexpr SEMI ;

ifStmt : IF bexpr THEN stmt+ ELSE stmt+ FI ;

whileStmt : WHILE bexpr DO stmt+ OD ;

program : PROGRAM decl* stmt+ END ;


COMMENT : '(*' .*? '*)' -> skip;

INTEGER : ('0' | '1'..'9' '0'..'9'*);

IDENTIFIER : LETTER (LETTER|'0'..'9')* ;

fragment
LETTER : 'A'..'Z'
       | 'a'..'z'
       | '_'
       ;

WS : (' '|'\r'|'\t'|'\u000C'|'\n') { skip(); } ;
