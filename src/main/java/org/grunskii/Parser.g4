grammar Parser;

entry: start WS* map WS* rules WS* ;

// start
start: IMPORTS_WORD WS* COLON WS* LP WS* importList WS* RP WS* ;
importList: IMPORT_WORD WS* string SEMICOLON WS* importList? WS* ;

// tokens
map: TOKENS_WORD WS* COLON WS* LP WS* tokenList WS* RP WS* ;
tokenList: tokenName WS* COLON WS* (DOUBLE_QUOTE WS* symbols WS* DOUBLE_QUOTE | regexp) WS* SEMICOLON WS* tokenList? WS* ;
tokenName: SINGLE_QUOTE WS* string WS* SINGLE_QUOTE WS* ;
regexp: REGEX_WORD WS* DOUBLE_QUOTE WS* symbols WS* DOUBLE_QUOTE WS* ;

// rules
rules: RULES_WORD WS* COLON WS* LP WS* ruleList WS* RP WS* ;
ruleList: string WS* COLON WS* argumentList WS* EQUAL WS* LP WS* subRuleList WS* RP WS* ruleList? WS* ;
argumentList: (LP WS* argument WS* RP WS* ARROW WS* argumentList | resultArgument) WS* ;
argument: string WS* COLON WS* string WS* ;
resultArgument: LP WS* string WS* RP WS* ;
subRuleList: subRuleArgumentList? WS* BIG_ARROW WS* LP symbols RP WS* SEMICOLON WS* subRuleList? WS* ;
subRuleArgumentList: (tokenName | LANGLE WS* string WS* COLON WS* type WS* RANGLE) WS* subRuleArgumentList? WS* ;
type: (tokenName | string WS* (LP WS* functionArguments WS* RP WS* )?) WS* ;
functionArguments: LP symbols RP WS* SEMICOLON WS* functionArguments? WS*;

symbols: (SYMBOL | LETTER | '.' | '_' | '"' | SEMICOLON | WS)+;
string: (LETTER | '.' | '_')+;

WS: [ \t\r\n];

IMPORTS_WORD: 'imports';
RULES_WORD: 'rules';
TOKENS_WORD: 'tokens';
IMPORT_WORD: 'import';
REGEX_WORD: 'regex';
SEMICOLON: ';';
DOUBLE_QUOTE: '"';
SINGLE_QUOTE: '\'';
COLON: ':';
LP: '{{';
RP: '}}';
EQUAL: '=';
LANGLE: '<';
RANGLE: '>';
ARROW: '->';
BIG_ARROW: EQUAL RANGLE;

SYMBOL: ~([a-zA-Z]);
LETTER: [a-zA-Z];

