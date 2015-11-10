// Generated from TheLang.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TheLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, ASSIGN=3, SEMI=4, GT=5, GE=6, LT=7, LE=8, EQ=9, NEQ=10, PLUS=11, 
		MINUS=12, MUL=13, DIV=14, NOT=15, LPAREN=16, RPAREN=17, LBRACE=18, RBRACE=19, 
		LBRACKET=20, RBRACKET=21, COLON=22, IF=23, THEN=24, ELSE=25, FI=26, WHILE=27, 
		DO=28, OD=29, SKIP=30, WRITE=31, READ=32, PROGRAM=33, END=34, TRUE=35, 
		FALSE=36, INT=37, LOW=38, HIGH=39, COMMENT=40, INTEGER=41, IDENTIFIER=42, 
		WS=43;
	public static final int
		RULE_aexpr = 0, RULE_aexpr1 = 1, RULE_aexpr2 = 2, RULE_aexpr3 = 3, RULE_bexpr = 4, 
		RULE_bexpr1 = 5, RULE_bexpr2 = 6, RULE_opr = 7, RULE_decl = 8, RULE_level = 9, 
		RULE_stmt = 10, RULE_assignStmt = 11, RULE_assignArrayStmt = 12, RULE_skipStmt = 13, 
		RULE_readStmt = 14, RULE_readArrayStmt = 15, RULE_writeStmt = 16, RULE_ifStmt = 17, 
		RULE_whileStmt = 18, RULE_program = 19;
	public static final String[] ruleNames = {
		"aexpr", "aexpr1", "aexpr2", "aexpr3", "bexpr", "bexpr1", "bexpr2", "opr", 
		"decl", "level", "stmt", "assignStmt", "assignArrayStmt", "skipStmt", 
		"readStmt", "readArrayStmt", "writeStmt", "ifStmt", "whileStmt", "program"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'&'", "'|'", "':='", "';'", "'>'", "'>='", "'<'", "'<='", "'='", 
		"'!='", "'+'", "'-'", "'*'", "'/'", "'!'", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "':'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", 
		"'od'", "'skip'", "'write'", "'read'", "'program'", "'end'", "'true'", 
		"'false'", "'int'", "'low'", "'high'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "OR", "ASSIGN", "SEMI", "GT", "GE", "LT", "LE", "EQ", "NEQ", 
		"PLUS", "MINUS", "MUL", "DIV", "NOT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"LBRACKET", "RBRACKET", "COLON", "IF", "THEN", "ELSE", "FI", "WHILE", 
		"DO", "OD", "SKIP", "WRITE", "READ", "PROGRAM", "END", "TRUE", "FALSE", 
		"INT", "LOW", "HIGH", "COMMENT", "INTEGER", "IDENTIFIER", "WS"
	};
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
	public String getGrammarFileName() { return "TheLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TheLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AexprContext extends ParserRuleContext {
		public List<Aexpr1Context> aexpr1() {
			return getRuleContexts(Aexpr1Context.class);
		}
		public Aexpr1Context aexpr1(int i) {
			return getRuleContext(Aexpr1Context.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(TheLangParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(TheLangParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(TheLangParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(TheLangParser.MINUS, i);
		}
		public AexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAexpr(this);
		}
	}

	public final AexprContext aexpr() throws RecognitionException {
		AexprContext _localctx = new AexprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_aexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			aexpr1();
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(45);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(41);
					match(PLUS);
					setState(42);
					aexpr1();
					}
					break;
				case MINUS:
					{
					setState(43);
					match(MINUS);
					setState(44);
					aexpr1();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Aexpr1Context extends ParserRuleContext {
		public List<Aexpr2Context> aexpr2() {
			return getRuleContexts(Aexpr2Context.class);
		}
		public Aexpr2Context aexpr2(int i) {
			return getRuleContext(Aexpr2Context.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(TheLangParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(TheLangParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(TheLangParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(TheLangParser.DIV, i);
		}
		public Aexpr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAexpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAexpr1(this);
		}
	}

	public final Aexpr1Context aexpr1() throws RecognitionException {
		Aexpr1Context _localctx = new Aexpr1Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_aexpr1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			aexpr2();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				setState(55);
				switch (_input.LA(1)) {
				case MUL:
					{
					setState(51);
					match(MUL);
					setState(52);
					aexpr2();
					}
					break;
				case DIV:
					{
					setState(53);
					match(DIV);
					setState(54);
					aexpr2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Aexpr2Context extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(TheLangParser.MINUS, 0); }
		public Aexpr3Context aexpr3() {
			return getRuleContext(Aexpr3Context.class,0);
		}
		public Aexpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAexpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAexpr2(this);
		}
	}

	public final Aexpr2Context aexpr2() throws RecognitionException {
		Aexpr2Context _localctx = new Aexpr2Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_aexpr2);
		try {
			setState(63);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(MINUS);
				setState(61);
				aexpr3();
				}
				break;
			case LPAREN:
			case INTEGER:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				aexpr3();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Aexpr3Context extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(TheLangParser.LBRACKET, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(TheLangParser.RBRACKET, 0); }
		public TerminalNode INTEGER() { return getToken(TheLangParser.INTEGER, 0); }
		public TerminalNode LPAREN() { return getToken(TheLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TheLangParser.RPAREN, 0); }
		public Aexpr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAexpr3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAexpr3(this);
		}
	}

	public final Aexpr3Context aexpr3() throws RecognitionException {
		Aexpr3Context _localctx = new Aexpr3Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_aexpr3);
		int _la;
		try {
			setState(77);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(IDENTIFIER);
				setState(70);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(66);
					match(LBRACKET);
					setState(67);
					aexpr();
					setState(68);
					match(RBRACKET);
					}
				}

				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(INTEGER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(LPAREN);
				setState(74);
				aexpr();
				setState(75);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BexprContext extends ParserRuleContext {
		public List<Bexpr1Context> bexpr1() {
			return getRuleContexts(Bexpr1Context.class);
		}
		public Bexpr1Context bexpr1(int i) {
			return getRuleContext(Bexpr1Context.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(TheLangParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(TheLangParser.OR, i);
		}
		public BexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterBexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitBexpr(this);
		}
	}

	public final BexprContext bexpr() throws RecognitionException {
		BexprContext _localctx = new BexprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bexpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			bexpr1();
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(80);
					match(OR);
					setState(81);
					bexpr1();
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class Bexpr1Context extends ParserRuleContext {
		public List<Bexpr2Context> bexpr2() {
			return getRuleContexts(Bexpr2Context.class);
		}
		public Bexpr2Context bexpr2(int i) {
			return getRuleContext(Bexpr2Context.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(TheLangParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(TheLangParser.AND, i);
		}
		public Bexpr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterBexpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitBexpr1(this);
		}
	}

	public final Bexpr1Context bexpr1() throws RecognitionException {
		Bexpr1Context _localctx = new Bexpr1Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_bexpr1);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			bexpr2();
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88);
					match(AND);
					setState(89);
					bexpr2();
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class Bexpr2Context extends ParserRuleContext {
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public OprContext opr() {
			return getRuleContext(OprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(TheLangParser.NOT, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(TheLangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(TheLangParser.FALSE, 0); }
		public TerminalNode LPAREN() { return getToken(TheLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TheLangParser.RPAREN, 0); }
		public Bexpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterBexpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitBexpr2(this);
		}
	}

	public final Bexpr2Context bexpr2() throws RecognitionException {
		Bexpr2Context _localctx = new Bexpr2Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_bexpr2);
		try {
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				aexpr();
				setState(96);
				opr();
				setState(97);
				aexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(NOT);
				setState(100);
				bexpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				match(LPAREN);
				setState(104);
				bexpr();
				setState(105);
				match(RPAREN);
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

	public static class OprContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(TheLangParser.GT, 0); }
		public TerminalNode GE() { return getToken(TheLangParser.GE, 0); }
		public TerminalNode LT() { return getToken(TheLangParser.LT, 0); }
		public TerminalNode LE() { return getToken(TheLangParser.LE, 0); }
		public TerminalNode EQ() { return getToken(TheLangParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(TheLangParser.NEQ, 0); }
		public OprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterOpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitOpr(this);
		}
	}

	public final OprContext opr() throws RecognitionException {
		OprContext _localctx = new OprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_opr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TheLangParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public LevelContext level() {
			return getRuleContext(LevelContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(TheLangParser.LBRACKET, 0); }
		public TerminalNode INTEGER() { return getToken(TheLangParser.INTEGER, 0); }
		public TerminalNode RBRACKET() { return getToken(TheLangParser.RBRACKET, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if (_la==LOW || _la==HIGH) {
				{
				setState(111);
				level();
				}
			}

			setState(114);
			match(INT);
			setState(115);
			match(IDENTIFIER);
			setState(119);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(116);
				match(LBRACKET);
				setState(117);
				match(INTEGER);
				setState(118);
				match(RBRACKET);
				}
			}

			setState(121);
			match(SEMI);
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

	public static class LevelContext extends ParserRuleContext {
		public TerminalNode LOW() { return getToken(TheLangParser.LOW, 0); }
		public TerminalNode HIGH() { return getToken(TheLangParser.HIGH, 0); }
		public LevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterLevel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitLevel(this);
		}
	}

	public final LevelContext level() throws RecognitionException {
		LevelContext _localctx = new LevelContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_level);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !(_la==LOW || _la==HIGH) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class StmtContext extends ParserRuleContext {
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public AssignArrayStmtContext assignArrayStmt() {
			return getRuleContext(AssignArrayStmtContext.class,0);
		}
		public SkipStmtContext skipStmt() {
			return getRuleContext(SkipStmtContext.class,0);
		}
		public ReadStmtContext readStmt() {
			return getRuleContext(ReadStmtContext.class,0);
		}
		public ReadArrayStmtContext readArrayStmt() {
			return getRuleContext(ReadArrayStmtContext.class,0);
		}
		public WriteStmtContext writeStmt() {
			return getRuleContext(WriteStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmt);
		try {
			setState(133);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				assignStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				assignArrayStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				skipStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				readStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				readArrayStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(130);
				writeStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(131);
				ifStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(132);
				whileStmt();
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

	public static class AssignStmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(TheLangParser.ASSIGN, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAssignStmt(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(IDENTIFIER);
			setState(136);
			match(ASSIGN);
			setState(137);
			aexpr();
			setState(138);
			match(SEMI);
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

	public static class AssignArrayStmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(TheLangParser.LBRACKET, 0); }
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(TheLangParser.RBRACKET, 0); }
		public TerminalNode ASSIGN() { return getToken(TheLangParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public AssignArrayStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignArrayStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAssignArrayStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAssignArrayStmt(this);
		}
	}

	public final AssignArrayStmtContext assignArrayStmt() throws RecognitionException {
		AssignArrayStmtContext _localctx = new AssignArrayStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignArrayStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(IDENTIFIER);
			setState(141);
			match(LBRACKET);
			setState(142);
			aexpr();
			setState(143);
			match(RBRACKET);
			setState(144);
			match(ASSIGN);
			setState(145);
			aexpr();
			setState(146);
			match(SEMI);
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

	public static class SkipStmtContext extends ParserRuleContext {
		public TerminalNode SKIP() { return getToken(TheLangParser.SKIP, 0); }
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public SkipStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterSkipStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitSkipStmt(this);
		}
	}

	public final SkipStmtContext skipStmt() throws RecognitionException {
		SkipStmtContext _localctx = new SkipStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_skipStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(SKIP);
			setState(149);
			match(SEMI);
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

	public static class ReadStmtContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(TheLangParser.READ, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public ReadStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterReadStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitReadStmt(this);
		}
	}

	public final ReadStmtContext readStmt() throws RecognitionException {
		ReadStmtContext _localctx = new ReadStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_readStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(READ);
			setState(152);
			match(IDENTIFIER);
			setState(153);
			match(SEMI);
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

	public static class ReadArrayStmtContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(TheLangParser.READ, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(TheLangParser.LBRACKET, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(TheLangParser.RBRACKET, 0); }
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public ReadArrayStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readArrayStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterReadArrayStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitReadArrayStmt(this);
		}
	}

	public final ReadArrayStmtContext readArrayStmt() throws RecognitionException {
		ReadArrayStmtContext _localctx = new ReadArrayStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_readArrayStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(READ);
			setState(156);
			match(IDENTIFIER);
			setState(157);
			match(LBRACKET);
			setState(158);
			aexpr();
			setState(159);
			match(RBRACKET);
			setState(160);
			match(SEMI);
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

	public static class WriteStmtContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(TheLangParser.WRITE, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public WriteStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterWriteStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitWriteStmt(this);
		}
	}

	public final WriteStmtContext writeStmt() throws RecognitionException {
		WriteStmtContext _localctx = new WriteStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_writeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(WRITE);
			setState(163);
			aexpr();
			setState(164);
			match(SEMI);
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TheLangParser.IF, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(TheLangParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(TheLangParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(TheLangParser.FI, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(IF);
			setState(167);
			bexpr();
			setState(168);
			match(THEN);
			setState(170); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(169);
				stmt();
				}
				}
				setState(172); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(174);
			match(ELSE);
			setState(176); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(175);
				stmt();
				}
				}
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(180);
			match(FI);
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(TheLangParser.WHILE, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode DO() { return getToken(TheLangParser.DO, 0); }
		public TerminalNode OD() { return getToken(TheLangParser.OD, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitWhileStmt(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_whileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(WHILE);
			setState(183);
			bexpr();
			setState(184);
			match(DO);
			setState(186); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(185);
				stmt();
				}
				}
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(190);
			match(OD);
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

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(TheLangParser.PROGRAM, 0); }
		public TerminalNode END() { return getToken(TheLangParser.END, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(PROGRAM);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << LOW) | (1L << HIGH))) != 0)) {
				{
				{
				setState(193);
				decl();
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(199);
				stmt();
				}
				}
				setState(202); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(204);
			match(END);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u00d1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\7\2\60\n\2\f\2\16\2"+
		"\63\13\2\3\3\3\3\3\3\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\4\3\4\3\4\5\4B"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\5\5I\n\5\3\5\3\5\3\5\3\5\3\5\5\5P\n\5\3\6\3\6"+
		"\3\6\7\6U\n\6\f\6\16\6X\13\6\3\7\3\7\3\7\7\7]\n\7\f\7\16\7`\13\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bn\n\b\3\t\3\t\3\n\5\ns\n"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\nz\n\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u0088\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\6\23\u00ad\n\23"+
		"\r\23\16\23\u00ae\3\23\3\23\6\23\u00b3\n\23\r\23\16\23\u00b4\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\6\24\u00bd\n\24\r\24\16\24\u00be\3\24\3\24\3\25\3"+
		"\25\7\25\u00c5\n\25\f\25\16\25\u00c8\13\25\3\25\6\25\u00cb\n\25\r\25\16"+
		"\25\u00cc\3\25\3\25\3\25\2\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(\2\4\3\2\7\f\3\2()\u00d8\2*\3\2\2\2\4\64\3\2\2\2\6A\3\2\2\2\bO\3"+
		"\2\2\2\nQ\3\2\2\2\fY\3\2\2\2\16m\3\2\2\2\20o\3\2\2\2\22r\3\2\2\2\24}\3"+
		"\2\2\2\26\u0087\3\2\2\2\30\u0089\3\2\2\2\32\u008e\3\2\2\2\34\u0096\3\2"+
		"\2\2\36\u0099\3\2\2\2 \u009d\3\2\2\2\"\u00a4\3\2\2\2$\u00a8\3\2\2\2&\u00b8"+
		"\3\2\2\2(\u00c2\3\2\2\2*\61\5\4\3\2+,\7\r\2\2,\60\5\4\3\2-.\7\16\2\2."+
		"\60\5\4\3\2/+\3\2\2\2/-\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2"+
		"\2\62\3\3\2\2\2\63\61\3\2\2\2\64;\5\6\4\2\65\66\7\17\2\2\66:\5\6\4\2\67"+
		"8\7\20\2\28:\5\6\4\29\65\3\2\2\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2"+
		"\2\2<\5\3\2\2\2=;\3\2\2\2>?\7\16\2\2?B\5\b\5\2@B\5\b\5\2A>\3\2\2\2A@\3"+
		"\2\2\2B\7\3\2\2\2CH\7,\2\2DE\7\26\2\2EF\5\2\2\2FG\7\27\2\2GI\3\2\2\2H"+
		"D\3\2\2\2HI\3\2\2\2IP\3\2\2\2JP\7+\2\2KL\7\22\2\2LM\5\2\2\2MN\7\23\2\2"+
		"NP\3\2\2\2OC\3\2\2\2OJ\3\2\2\2OK\3\2\2\2P\t\3\2\2\2QV\5\f\7\2RS\7\4\2"+
		"\2SU\5\f\7\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\13\3\2\2\2XV\3\2"+
		"\2\2Y^\5\16\b\2Z[\7\3\2\2[]\5\16\b\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^"+
		"_\3\2\2\2_\r\3\2\2\2`^\3\2\2\2ab\5\2\2\2bc\5\20\t\2cd\5\2\2\2dn\3\2\2"+
		"\2ef\7\21\2\2fn\5\n\6\2gn\7%\2\2hn\7&\2\2ij\7\22\2\2jk\5\n\6\2kl\7\23"+
		"\2\2ln\3\2\2\2ma\3\2\2\2me\3\2\2\2mg\3\2\2\2mh\3\2\2\2mi\3\2\2\2n\17\3"+
		"\2\2\2op\t\2\2\2p\21\3\2\2\2qs\5\24\13\2rq\3\2\2\2rs\3\2\2\2st\3\2\2\2"+
		"tu\7\'\2\2uy\7,\2\2vw\7\26\2\2wx\7+\2\2xz\7\27\2\2yv\3\2\2\2yz\3\2\2\2"+
		"z{\3\2\2\2{|\7\6\2\2|\23\3\2\2\2}~\t\3\2\2~\25\3\2\2\2\177\u0088\5\30"+
		"\r\2\u0080\u0088\5\32\16\2\u0081\u0088\5\34\17\2\u0082\u0088\5\36\20\2"+
		"\u0083\u0088\5 \21\2\u0084\u0088\5\"\22\2\u0085\u0088\5$\23\2\u0086\u0088"+
		"\5&\24\2\u0087\177\3\2\2\2\u0087\u0080\3\2\2\2\u0087\u0081\3\2\2\2\u0087"+
		"\u0082\3\2\2\2\u0087\u0083\3\2\2\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2"+
		"\2\2\u0087\u0086\3\2\2\2\u0088\27\3\2\2\2\u0089\u008a\7,\2\2\u008a\u008b"+
		"\7\5\2\2\u008b\u008c\5\2\2\2\u008c\u008d\7\6\2\2\u008d\31\3\2\2\2\u008e"+
		"\u008f\7,\2\2\u008f\u0090\7\26\2\2\u0090\u0091\5\2\2\2\u0091\u0092\7\27"+
		"\2\2\u0092\u0093\7\5\2\2\u0093\u0094\5\2\2\2\u0094\u0095\7\6\2\2\u0095"+
		"\33\3\2\2\2\u0096\u0097\7 \2\2\u0097\u0098\7\6\2\2\u0098\35\3\2\2\2\u0099"+
		"\u009a\7\"\2\2\u009a\u009b\7,\2\2\u009b\u009c\7\6\2\2\u009c\37\3\2\2\2"+
		"\u009d\u009e\7\"\2\2\u009e\u009f\7,\2\2\u009f\u00a0\7\26\2\2\u00a0\u00a1"+
		"\5\2\2\2\u00a1\u00a2\7\27\2\2\u00a2\u00a3\7\6\2\2\u00a3!\3\2\2\2\u00a4"+
		"\u00a5\7!\2\2\u00a5\u00a6\5\2\2\2\u00a6\u00a7\7\6\2\2\u00a7#\3\2\2\2\u00a8"+
		"\u00a9\7\31\2\2\u00a9\u00aa\5\n\6\2\u00aa\u00ac\7\32\2\2\u00ab\u00ad\5"+
		"\26\f\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\7\33\2\2\u00b1\u00b3\5"+
		"\26\f\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\34\2\2\u00b7%\3\2\2\2"+
		"\u00b8\u00b9\7\35\2\2\u00b9\u00ba\5\n\6\2\u00ba\u00bc\7\36\2\2\u00bb\u00bd"+
		"\5\26\f\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2"+
		"\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\37\2\2\u00c1\'"+
		"\3\2\2\2\u00c2\u00c6\7#\2\2\u00c3\u00c5\5\22\n\2\u00c4\u00c3\3\2\2\2\u00c5"+
		"\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca\3\2"+
		"\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cb\5\26\f\2\u00ca\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00cf\7$\2\2\u00cf)\3\2\2\2\24/\619;AHOV^mry\u0087\u00ae\u00b4"+
		"\u00be\u00c6\u00cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}