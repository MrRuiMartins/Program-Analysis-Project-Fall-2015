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
		RULE_bexpr1 = 5, RULE_bexpr2 = 6, RULE_opr = 7, RULE_declArray = 8, RULE_decl = 9, 
		RULE_level = 10, RULE_stmt = 11, RULE_assignStmt = 12, RULE_assignArrayStmt = 13, 
		RULE_skipStmt = 14, RULE_readStmt = 15, RULE_readArrayStmt = 16, RULE_writeStmt = 17, 
		RULE_ifStmt = 18, RULE_whileStmt = 19, RULE_program = 20;
	public static final String[] ruleNames = {
		"aexpr", "aexpr1", "aexpr2", "aexpr3", "bexpr", "bexpr1", "bexpr2", "opr", 
		"declArray", "decl", "level", "stmt", "assignStmt", "assignArrayStmt", 
		"skipStmt", "readStmt", "readArrayStmt", "writeStmt", "ifStmt", "whileStmt", 
		"program"
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
			setState(42);
			aexpr1();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(47);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(43);
					match(PLUS);
					setState(44);
					aexpr1();
					}
					break;
				case MINUS:
					{
					setState(45);
					match(MINUS);
					setState(46);
					aexpr1();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(51);
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
			setState(52);
			aexpr2();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				setState(57);
				switch (_input.LA(1)) {
				case MUL:
					{
					setState(53);
					match(MUL);
					setState(54);
					aexpr2();
					}
					break;
				case DIV:
					{
					setState(55);
					match(DIV);
					setState(56);
					aexpr2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(61);
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
			setState(65);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(MINUS);
				setState(63);
				aexpr3();
				}
				break;
			case LPAREN:
			case INTEGER:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
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
			setState(79);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(IDENTIFIER);
				setState(72);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(68);
					match(LBRACKET);
					setState(69);
					aexpr();
					setState(70);
					match(RBRACKET);
					}
				}

				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(INTEGER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(LPAREN);
				setState(76);
				aexpr();
				setState(77);
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
			setState(81);
			bexpr1();
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(82);
					match(OR);
					setState(83);
					bexpr1();
					}
					} 
				}
				setState(88);
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
			setState(89);
			bexpr2();
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(90);
					match(AND);
					setState(91);
					bexpr2();
					}
					} 
				}
				setState(96);
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
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				aexpr();
				setState(98);
				opr();
				setState(99);
				aexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(NOT);
				setState(102);
				bexpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				match(LPAREN);
				setState(106);
				bexpr();
				setState(107);
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
			setState(111);
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

	public static class DeclArrayContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TheLangParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(TheLangParser.LBRACKET, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(TheLangParser.RBRACKET, 0); }
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public LevelContext level() {
			return getRuleContext(LevelContext.class,0);
		}
		public DeclArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterDeclArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitDeclArray(this);
		}
	}

	public final DeclArrayContext declArray() throws RecognitionException {
		DeclArrayContext _localctx = new DeclArrayContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_la = _input.LA(1);
			if (_la==LOW || _la==HIGH) {
				{
				setState(113);
				level();
				}
			}

			setState(116);
			match(INT);
			setState(117);
			match(IDENTIFIER);
			setState(118);
			match(LBRACKET);
			setState(119);
			aexpr();
			setState(120);
			match(RBRACKET);
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

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TheLangParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public LevelContext level() {
			return getRuleContext(LevelContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if (_la==LOW || _la==HIGH) {
				{
				setState(123);
				level();
				}
			}

			setState(126);
			match(INT);
			setState(127);
			match(IDENTIFIER);
			setState(128);
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
		enterRule(_localctx, 20, RULE_level);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
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
		enterRule(_localctx, 22, RULE_stmt);
		try {
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				assignStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				assignArrayStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				skipStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				readStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				readArrayStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(137);
				writeStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(138);
				ifStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(139);
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
		enterRule(_localctx, 24, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(IDENTIFIER);
			setState(143);
			match(ASSIGN);
			setState(144);
			aexpr();
			setState(145);
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
		enterRule(_localctx, 26, RULE_assignArrayStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(IDENTIFIER);
			setState(148);
			match(LBRACKET);
			setState(149);
			aexpr();
			setState(150);
			match(RBRACKET);
			setState(151);
			match(ASSIGN);
			setState(152);
			aexpr();
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
		enterRule(_localctx, 28, RULE_skipStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(SKIP);
			setState(156);
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
		enterRule(_localctx, 30, RULE_readStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(READ);
			setState(159);
			match(IDENTIFIER);
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
		enterRule(_localctx, 32, RULE_readArrayStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(READ);
			setState(163);
			match(IDENTIFIER);
			setState(164);
			match(LBRACKET);
			setState(165);
			aexpr();
			setState(166);
			match(RBRACKET);
			setState(167);
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
		enterRule(_localctx, 34, RULE_writeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(WRITE);
			setState(170);
			aexpr();
			setState(171);
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
		enterRule(_localctx, 36, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(IF);
			setState(174);
			bexpr();
			setState(175);
			match(THEN);
			setState(177); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(176);
				stmt();
				}
				}
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(181);
			match(ELSE);
			setState(183); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(182);
				stmt();
				}
				}
				setState(185); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(187);
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
		enterRule(_localctx, 38, RULE_whileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(WHILE);
			setState(190);
			bexpr();
			setState(191);
			match(DO);
			setState(193); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(192);
				stmt();
				}
				}
				setState(195); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(197);
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
		public List<DeclArrayContext> declArray() {
			return getRuleContexts(DeclArrayContext.class);
		}
		public DeclArrayContext declArray(int i) {
			return getRuleContext(DeclArrayContext.class,i);
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
		enterRule(_localctx, 40, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(PROGRAM);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << LOW) | (1L << HIGH))) != 0)) {
				{
				setState(202);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(200);
					decl();
					}
					break;
				case 2:
					{
					setState(201);
					declArray();
					}
					break;
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(207);
				stmt();
				}
				}
				setState(210); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(212);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u00d9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\7\2\62\n"+
		"\2\f\2\16\2\65\13\2\3\3\3\3\3\3\3\3\3\3\7\3<\n\3\f\3\16\3?\13\3\3\4\3"+
		"\4\3\4\5\4D\n\4\3\5\3\5\3\5\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\5\3\5\5\5R"+
		"\n\5\3\6\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\3\7\3\7\3\7\7\7_\n\7\f\7\16\7"+
		"b\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bp\n\b\3\t\3"+
		"\t\3\n\5\nu\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\5\13\177\n\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u008f\n\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\6\24\u00b4\n\24\r\24\16\24\u00b5\3\24"+
		"\3\24\6\24\u00ba\n\24\r\24\16\24\u00bb\3\24\3\24\3\25\3\25\3\25\3\25\6"+
		"\25\u00c4\n\25\r\25\16\25\u00c5\3\25\3\25\3\26\3\26\3\26\7\26\u00cd\n"+
		"\26\f\26\16\26\u00d0\13\26\3\26\6\26\u00d3\n\26\r\26\16\26\u00d4\3\26"+
		"\3\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\4\3"+
		"\2\7\f\3\2()\u00e0\2,\3\2\2\2\4\66\3\2\2\2\6C\3\2\2\2\bQ\3\2\2\2\nS\3"+
		"\2\2\2\f[\3\2\2\2\16o\3\2\2\2\20q\3\2\2\2\22t\3\2\2\2\24~\3\2\2\2\26\u0084"+
		"\3\2\2\2\30\u008e\3\2\2\2\32\u0090\3\2\2\2\34\u0095\3\2\2\2\36\u009d\3"+
		"\2\2\2 \u00a0\3\2\2\2\"\u00a4\3\2\2\2$\u00ab\3\2\2\2&\u00af\3\2\2\2(\u00bf"+
		"\3\2\2\2*\u00c9\3\2\2\2,\63\5\4\3\2-.\7\r\2\2.\62\5\4\3\2/\60\7\16\2\2"+
		"\60\62\5\4\3\2\61-\3\2\2\2\61/\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63"+
		"\64\3\2\2\2\64\3\3\2\2\2\65\63\3\2\2\2\66=\5\6\4\2\678\7\17\2\28<\5\6"+
		"\4\29:\7\20\2\2:<\5\6\4\2;\67\3\2\2\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>"+
		"\3\2\2\2>\5\3\2\2\2?=\3\2\2\2@A\7\16\2\2AD\5\b\5\2BD\5\b\5\2C@\3\2\2\2"+
		"CB\3\2\2\2D\7\3\2\2\2EJ\7,\2\2FG\7\26\2\2GH\5\2\2\2HI\7\27\2\2IK\3\2\2"+
		"\2JF\3\2\2\2JK\3\2\2\2KR\3\2\2\2LR\7+\2\2MN\7\22\2\2NO\5\2\2\2OP\7\23"+
		"\2\2PR\3\2\2\2QE\3\2\2\2QL\3\2\2\2QM\3\2\2\2R\t\3\2\2\2SX\5\f\7\2TU\7"+
		"\4\2\2UW\5\f\7\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\13\3\2\2\2Z"+
		"X\3\2\2\2[`\5\16\b\2\\]\7\3\2\2]_\5\16\b\2^\\\3\2\2\2_b\3\2\2\2`^\3\2"+
		"\2\2`a\3\2\2\2a\r\3\2\2\2b`\3\2\2\2cd\5\2\2\2de\5\20\t\2ef\5\2\2\2fp\3"+
		"\2\2\2gh\7\21\2\2hp\5\n\6\2ip\7%\2\2jp\7&\2\2kl\7\22\2\2lm\5\n\6\2mn\7"+
		"\23\2\2np\3\2\2\2oc\3\2\2\2og\3\2\2\2oi\3\2\2\2oj\3\2\2\2ok\3\2\2\2p\17"+
		"\3\2\2\2qr\t\2\2\2r\21\3\2\2\2su\5\26\f\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2"+
		"\2vw\7\'\2\2wx\7,\2\2xy\7\26\2\2yz\5\2\2\2z{\7\27\2\2{|\7\6\2\2|\23\3"+
		"\2\2\2}\177\5\26\f\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081"+
		"\7\'\2\2\u0081\u0082\7,\2\2\u0082\u0083\7\6\2\2\u0083\25\3\2\2\2\u0084"+
		"\u0085\t\3\2\2\u0085\27\3\2\2\2\u0086\u008f\5\32\16\2\u0087\u008f\5\34"+
		"\17\2\u0088\u008f\5\36\20\2\u0089\u008f\5 \21\2\u008a\u008f\5\"\22\2\u008b"+
		"\u008f\5$\23\2\u008c\u008f\5&\24\2\u008d\u008f\5(\25\2\u008e\u0086\3\2"+
		"\2\2\u008e\u0087\3\2\2\2\u008e\u0088\3\2\2\2\u008e\u0089\3\2\2\2\u008e"+
		"\u008a\3\2\2\2\u008e\u008b\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2"+
		"\2\2\u008f\31\3\2\2\2\u0090\u0091\7,\2\2\u0091\u0092\7\5\2\2\u0092\u0093"+
		"\5\2\2\2\u0093\u0094\7\6\2\2\u0094\33\3\2\2\2\u0095\u0096\7,\2\2\u0096"+
		"\u0097\7\26\2\2\u0097\u0098\5\2\2\2\u0098\u0099\7\27\2\2\u0099\u009a\7"+
		"\5\2\2\u009a\u009b\5\2\2\2\u009b\u009c\7\6\2\2\u009c\35\3\2\2\2\u009d"+
		"\u009e\7 \2\2\u009e\u009f\7\6\2\2\u009f\37\3\2\2\2\u00a0\u00a1\7\"\2\2"+
		"\u00a1\u00a2\7,\2\2\u00a2\u00a3\7\6\2\2\u00a3!\3\2\2\2\u00a4\u00a5\7\""+
		"\2\2\u00a5\u00a6\7,\2\2\u00a6\u00a7\7\26\2\2\u00a7\u00a8\5\2\2\2\u00a8"+
		"\u00a9\7\27\2\2\u00a9\u00aa\7\6\2\2\u00aa#\3\2\2\2\u00ab\u00ac\7!\2\2"+
		"\u00ac\u00ad\5\2\2\2\u00ad\u00ae\7\6\2\2\u00ae%\3\2\2\2\u00af\u00b0\7"+
		"\31\2\2\u00b0\u00b1\5\n\6\2\u00b1\u00b3\7\32\2\2\u00b2\u00b4\5\30\r\2"+
		"\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\7\33\2\2\u00b8\u00ba\5\30\r\2"+
		"\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\7\34\2\2\u00be\'\3\2\2\2\u00bf"+
		"\u00c0\7\35\2\2\u00c0\u00c1\5\n\6\2\u00c1\u00c3\7\36\2\2\u00c2\u00c4\5"+
		"\30\r\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\7\37\2\2\u00c8)\3\2\2\2"+
		"\u00c9\u00ce\7#\2\2\u00ca\u00cd\5\24\13\2\u00cb\u00cd\5\22\n\2\u00cc\u00ca"+
		"\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d3\5\30"+
		"\r\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\7$\2\2\u00d7+\3\2\2\2\25"+
		"\61\63;=CJQX`ot~\u008e\u00b5\u00bb\u00c5\u00cc\u00ce\u00d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}