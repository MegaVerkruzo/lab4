// Generated from /home/alexey/00university/05semester/01translation_methods/_real03lab/src/main/java/org/grunskii/Latex.g4 by ANTLR 4.13.1
package org.grunskii;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LatexParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEFT_BRACKET=1, RIGHT_BRACKET=2, DOLLAR=3, UPPER=4, LOWER=5, WHITESPACE=6, 
		LETTER=7, SYMBOL=8;
	public static final int
		RULE_entry = 0, RULE_formula = 1, RULE_lower = 2, RULE_upper = 3, RULE_iSymbol = 4, 
		RULE_symbol = 5, RULE_iText = 6, RULE_text = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"entry", "formula", "lower", "upper", "iSymbol", "symbol", "iText", "text"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'$'", "'^'", "'_'", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LEFT_BRACKET", "RIGHT_BRACKET", "DOLLAR", "UPPER", "LOWER", "WHITESPACE", 
			"LETTER", "SYMBOL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Latex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LatexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EntryContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LatexParser.EOF, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<TerminalNode> LOWER() { return getTokens(LatexParser.LOWER); }
		public TerminalNode LOWER(int i) {
			return getToken(LatexParser.LOWER, i);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexVisitor ) return ((LatexVisitor<? extends T>)visitor).visitEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
			case UPPER:
			case LOWER:
			case WHITESPACE:
			case LETTER:
			case SYMBOL:
				{
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(19);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(16);
						formula();
						}
						break;
					case 2:
						{
						setState(17);
						text();
						}
						break;
					case 3:
						{
						setState(18);
						match(LOWER);
						}
						break;
					}
					}
					setState(21); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 504L) != 0) );
				setState(23);
				match(EOF);
				}
				break;
			case EOF:
				{
				setState(24);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormulaContext extends ParserRuleContext {
		public List<TerminalNode> DOLLAR() { return getTokens(LatexParser.DOLLAR); }
		public TerminalNode DOLLAR(int i) {
			return getToken(LatexParser.DOLLAR, i);
		}
		public List<LowerContext> lower() {
			return getRuleContexts(LowerContext.class);
		}
		public LowerContext lower(int i) {
			return getRuleContext(LowerContext.class,i);
		}
		public List<UpperContext> upper() {
			return getRuleContexts(UpperContext.class);
		}
		public UpperContext upper(int i) {
			return getRuleContext(UpperContext.class,i);
		}
		public List<ITextContext> iText() {
			return getRuleContexts(ITextContext.class);
		}
		public ITextContext iText(int i) {
			return getRuleContext(ITextContext.class,i);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexVisitor ) return ((LatexVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_formula);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(DOLLAR);
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(32); 
				_errHandler.sync(this);
				_alt = 1+1;
				do {
					switch (_alt) {
					case 1+1:
						{
						setState(32);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
						case 1:
							{
							setState(28);
							lower();
							}
							break;
						case 2:
							{
							setState(29);
							upper();
							}
							break;
						case 3:
							{
							setState(30);
							iText();
							}
							break;
						case 4:
							{
							setState(31);
							text();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(34); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			setState(38);
			match(DOLLAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LowerContext extends ParserRuleContext {
		public TerminalNode LOWER() { return getToken(LatexParser.LOWER, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(LatexParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LatexParser.RIGHT_BRACKET, 0); }
		public List<ITextContext> iText() {
			return getRuleContexts(ITextContext.class);
		}
		public ITextContext iText(int i) {
			return getRuleContext(ITextContext.class,i);
		}
		public List<LowerContext> lower() {
			return getRuleContexts(LowerContext.class);
		}
		public LowerContext lower(int i) {
			return getRuleContext(LowerContext.class,i);
		}
		public List<UpperContext> upper() {
			return getRuleContexts(UpperContext.class);
		}
		public UpperContext upper(int i) {
			return getRuleContext(UpperContext.class,i);
		}
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public ISymbolContext iSymbol() {
			return getRuleContext(ISymbolContext.class,0);
		}
		public LowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lower; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterLower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitLower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexVisitor ) return ((LatexVisitor<? extends T>)visitor).visitLower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerContext lower() throws RecognitionException {
		LowerContext _localctx = new LowerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lower);
		int _la;
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(LOWER);
				setState(41);
				match(LEFT_BRACKET);
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(46);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(42);
						iText();
						}
						break;
					case LOWER:
						{
						setState(43);
						lower();
						}
						break;
					case UPPER:
						{
						setState(44);
						upper();
						}
						break;
					case SYMBOL:
						{
						setState(45);
						symbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(48); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 432L) != 0) );
				setState(50);
				match(RIGHT_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(LOWER);
				setState(57);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LOWER:
					{
					setState(53);
					lower();
					}
					break;
				case UPPER:
					{
					setState(54);
					upper();
					}
					break;
				case LETTER:
					{
					setState(55);
					iSymbol();
					}
					break;
				case SYMBOL:
					{
					setState(56);
					symbol();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpperContext extends ParserRuleContext {
		public TerminalNode UPPER() { return getToken(LatexParser.UPPER, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(LatexParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LatexParser.RIGHT_BRACKET, 0); }
		public List<ITextContext> iText() {
			return getRuleContexts(ITextContext.class);
		}
		public ITextContext iText(int i) {
			return getRuleContext(ITextContext.class,i);
		}
		public List<LowerContext> lower() {
			return getRuleContexts(LowerContext.class);
		}
		public LowerContext lower(int i) {
			return getRuleContext(LowerContext.class,i);
		}
		public List<UpperContext> upper() {
			return getRuleContexts(UpperContext.class);
		}
		public UpperContext upper(int i) {
			return getRuleContext(UpperContext.class,i);
		}
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public ISymbolContext iSymbol() {
			return getRuleContext(ISymbolContext.class,0);
		}
		public UpperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterUpper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitUpper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexVisitor ) return ((LatexVisitor<? extends T>)visitor).visitUpper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpperContext upper() throws RecognitionException {
		UpperContext _localctx = new UpperContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_upper);
		int _la;
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(UPPER);
				setState(62);
				match(LEFT_BRACKET);
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(67);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(63);
						iText();
						}
						break;
					case LOWER:
						{
						setState(64);
						lower();
						}
						break;
					case UPPER:
						{
						setState(65);
						upper();
						}
						break;
					case SYMBOL:
						{
						setState(66);
						symbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(69); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 432L) != 0) );
				setState(71);
				match(RIGHT_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(UPPER);
				setState(78);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case UPPER:
					{
					setState(74);
					upper();
					}
					break;
				case LOWER:
					{
					setState(75);
					lower();
					}
					break;
				case LETTER:
					{
					setState(76);
					iSymbol();
					}
					break;
				case SYMBOL:
					{
					setState(77);
					symbol();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ISymbolContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(LatexParser.LETTER, 0); }
		public ISymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterISymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitISymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexVisitor ) return ((LatexVisitor<? extends T>)visitor).visitISymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ISymbolContext iSymbol() throws RecognitionException {
		ISymbolContext _localctx = new ISymbolContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_iSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(LETTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(LatexParser.SYMBOL, 0); }
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexVisitor ) return ((LatexVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_symbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ITextContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(LatexParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(LatexParser.LETTER, i);
		}
		public ITextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterIText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitIText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexVisitor ) return ((LatexVisitor<? extends T>)visitor).visitIText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ITextContext iText() throws RecognitionException {
		ITextContext _localctx = new ITextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_iText);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(86);
					match(LETTER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(89); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(LatexParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(LatexParser.LETTER, i);
		}
		public List<TerminalNode> SYMBOL() { return getTokens(LatexParser.SYMBOL); }
		public TerminalNode SYMBOL(int i) {
			return getToken(LatexParser.SYMBOL, i);
		}
		public List<TerminalNode> LOWER() { return getTokens(LatexParser.LOWER); }
		public TerminalNode LOWER(int i) {
			return getToken(LatexParser.LOWER, i);
		}
		public List<TerminalNode> UPPER() { return getTokens(LatexParser.UPPER); }
		public TerminalNode UPPER(int i) {
			return getToken(LatexParser.UPPER, i);
		}
		public List<TerminalNode> DOLLAR() { return getTokens(LatexParser.DOLLAR); }
		public TerminalNode DOLLAR(int i) {
			return getToken(LatexParser.DOLLAR, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(LatexParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(LatexParser.WHITESPACE, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatexListener ) ((LatexListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LatexVisitor ) return ((LatexVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_text);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(91);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 504L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(94); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\ba\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u0014\b\u0000\u000b\u0000\f"+
		"\u0000\u0015\u0001\u0000\u0001\u0000\u0003\u0000\u001a\b\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001!\b\u0001"+
		"\u000b\u0001\f\u0001\"\u0003\u0001%\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004"+
		"\u0002/\b\u0002\u000b\u0002\f\u00020\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002:\b\u0002"+
		"\u0003\u0002<\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0004\u0003D\b\u0003\u000b\u0003\f\u0003E\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003O\b\u0003\u0003\u0003Q\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u0006X\b\u0006\u000b\u0006"+
		"\f\u0006Y\u0001\u0007\u0004\u0007]\b\u0007\u000b\u0007\f\u0007^\u0001"+
		"\u0007\u0002\"^\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0001"+
		"\u0001\u0000\u0003\bs\u0000\u0019\u0001\u0000\u0000\u0000\u0002\u001b"+
		"\u0001\u0000\u0000\u0000\u0004;\u0001\u0000\u0000\u0000\u0006P\u0001\u0000"+
		"\u0000\u0000\bR\u0001\u0000\u0000\u0000\nT\u0001\u0000\u0000\u0000\fW"+
		"\u0001\u0000\u0000\u0000\u000e\\\u0001\u0000\u0000\u0000\u0010\u0014\u0003"+
		"\u0002\u0001\u0000\u0011\u0014\u0003\u000e\u0007\u0000\u0012\u0014\u0005"+
		"\u0005\u0000\u0000\u0013\u0010\u0001\u0000\u0000\u0000\u0013\u0011\u0001"+
		"\u0000\u0000\u0000\u0013\u0012\u0001\u0000\u0000\u0000\u0014\u0015\u0001"+
		"\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001"+
		"\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u001a\u0005"+
		"\u0000\u0000\u0001\u0018\u001a\u0005\u0000\u0000\u0001\u0019\u0013\u0001"+
		"\u0000\u0000\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u0001\u0001"+
		"\u0000\u0000\u0000\u001b$\u0005\u0003\u0000\u0000\u001c!\u0003\u0004\u0002"+
		"\u0000\u001d!\u0003\u0006\u0003\u0000\u001e!\u0003\f\u0006\u0000\u001f"+
		"!\u0003\u000e\u0007\u0000 \u001c\u0001\u0000\u0000\u0000 \u001d\u0001"+
		"\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 \u001f\u0001\u0000\u0000"+
		"\u0000!\"\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000\" \u0001"+
		"\u0000\u0000\u0000#%\u0001\u0000\u0000\u0000$ \u0001\u0000\u0000\u0000"+
		"$%\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0005\u0003\u0000"+
		"\u0000\'\u0003\u0001\u0000\u0000\u0000()\u0005\u0005\u0000\u0000).\u0005"+
		"\u0001\u0000\u0000*/\u0003\f\u0006\u0000+/\u0003\u0004\u0002\u0000,/\u0003"+
		"\u0006\u0003\u0000-/\u0003\n\u0005\u0000.*\u0001\u0000\u0000\u0000.+\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000.-\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000"+
		"\u000012\u0001\u0000\u0000\u000023\u0005\u0002\u0000\u00003<\u0001\u0000"+
		"\u0000\u000049\u0005\u0005\u0000\u00005:\u0003\u0004\u0002\u00006:\u0003"+
		"\u0006\u0003\u00007:\u0003\b\u0004\u00008:\u0003\n\u0005\u000095\u0001"+
		"\u0000\u0000\u000096\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		"98\u0001\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;(\u0001\u0000\u0000"+
		"\u0000;4\u0001\u0000\u0000\u0000<\u0005\u0001\u0000\u0000\u0000=>\u0005"+
		"\u0004\u0000\u0000>C\u0005\u0001\u0000\u0000?D\u0003\f\u0006\u0000@D\u0003"+
		"\u0004\u0002\u0000AD\u0003\u0006\u0003\u0000BD\u0003\n\u0005\u0000C?\u0001"+
		"\u0000\u0000\u0000C@\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"CB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0005\u0002"+
		"\u0000\u0000HQ\u0001\u0000\u0000\u0000IN\u0005\u0004\u0000\u0000JO\u0003"+
		"\u0006\u0003\u0000KO\u0003\u0004\u0002\u0000LO\u0003\b\u0004\u0000MO\u0003"+
		"\n\u0005\u0000NJ\u0001\u0000\u0000\u0000NK\u0001\u0000\u0000\u0000NL\u0001"+
		"\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000OQ\u0001\u0000\u0000\u0000"+
		"P=\u0001\u0000\u0000\u0000PI\u0001\u0000\u0000\u0000Q\u0007\u0001\u0000"+
		"\u0000\u0000RS\u0005\u0007\u0000\u0000S\t\u0001\u0000\u0000\u0000TU\u0005"+
		"\b\u0000\u0000U\u000b\u0001\u0000\u0000\u0000VX\u0005\u0007\u0000\u0000"+
		"WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000Z\r\u0001\u0000\u0000\u0000[]\u0007\u0000"+
		"\u0000\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_\u000f\u0001\u0000\u0000"+
		"\u0000\u0010\u0013\u0015\u0019 \"$.09;CENPY^";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}