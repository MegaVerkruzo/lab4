grammar Latex;

entry: ((formula | text | '_')+ EOF | EOF);
formula: DOLLAR ((lower | upper | iText | text)+?)? DOLLAR;
lower: LOWER LEFT_BRACKET (iText | lower | upper | symbol)+ RIGHT_BRACKET
     | LOWER (lower | upper | iSymbol | symbol)
     ;
upper: UPPER LEFT_BRACKET (iText | lower | upper | symbol)+ RIGHT_BRACKET
     | UPPER (upper | lower | iSymbol | symbol)
     ;

iSymbol: LETTER;
symbol: SYMBOL;
iText: LETTER+;

text: (LETTER | SYMBOL | LOWER | UPPER | DOLLAR | WHITESPACE)+?;

LEFT_BRACKET: '{';
RIGHT_BRACKET: '}';
DOLLAR: '$';
UPPER: '^';
LOWER: '_';
WHITESPACE: ' ';
LETTER: [a-zA-Z];
SYMBOL: '\\'? .;

//entry: (formula | text)+ EOF;
//
//formula: '$' (lower | upper | formattedWord | text | WHITESPACE)+ '$';
//
//lower: '_' (formattedSymbol | SYMBOL);
//upper: '^' (formattedSymbol | SYMBOL);
//formattedSymbol: LETTER;
//formattedWord: LETTERS;
//text: TEXT?;

//log: dateTime WHITESPACE level WHITESPACE message NEWLINE;

//dateTime: DATE WHITESPACE TIME;
//level: 'INFO' | 'FINE' | 'SEVERE';
//message: (TEXT | WHITESPACE)+;
//
//fragment DIGIT : [0-9];
////fragment TWODIGIT: DIGIT DIGIT;
////
////NEWLINE: ('\r'? '\n' | '\r');
////DATE: TWODIGIT TWODIGIT '-' LETTER LETTER LETTER '-' TWODIGIT;
////TIME: TWODIGIT ':' TWODIGIT ':' TWODIGIT;
////TEXT: LETTER+;
//LETTER: [a-zA-Z];
//DIGITS: DIGIT+;
//LETTERS: LETTER+;
////TEXT                : ~[\])]+;
////SYMBOL                : ~[\])];
