grammar Latex;

entry: ((formula | text | '_')+ EOF | EOF);
formula: DOLLAR ((lower | upper | iText | text)+)? DOLLAR;
lower: LOWER (iSymbol | SYMBOL);
upper: UPPER (iSymbol | SYMBOL);

iSymbol: LETTER;
iText: LETTER+;

text: (LETTER | SYMBOL | WHITESPACE)+;

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
