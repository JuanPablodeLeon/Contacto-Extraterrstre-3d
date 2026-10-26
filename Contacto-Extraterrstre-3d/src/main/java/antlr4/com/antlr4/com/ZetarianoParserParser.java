// Generated from src/main/java/antlr4/com/ZetarianoParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ZetarianoParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUBLIC=1, CLASS=2, STRING=3, INT=4, BOOLEAN=5, DOUBLE=6, CHAR=7, VOID=8, 
		RETURN=9, NEW=10, IF=11, ELSE=12, TRUE=13, FALSE=14, SWITCH=15, CASE=16, 
		DEFAULT=17, BREAK=18, FOR=19, CONTINUE=20, WHILE=21, DO=22, PRINTLN=23, 
		PRINT=24, READLN=25, NULL_VAL=26, LPAREN=27, RPAREN=28, LLLAVE=29, RLLAVE=30, 
		PUNTO_COMA=31, COMA=32, INTERRG=33, DOS_PUNTOS=34, PUNTO=35, LCORCH=36, 
		RCORCH=37, IGUAL=38, NO_IGUAL=39, MAYOR_IGUAL=40, MENOR_IGUAL=41, MAYOR=42, 
		MENOR=43, AND=44, OR=45, NOT=46, INCREMENTO=47, DECREMENTO=48, SUMA_IGL=49, 
		RESTA_IGL=50, MULT_IGL=51, SUMA=52, RESTA=53, MULT=54, DIV=55, MOD=56, 
		ASIGNACION=57, ID=58, INTEGER=59, DOUBLES=60, STRINGS=61, CHARS=62, ESC=63, 
		LINE_COMMENT=64, BLOCK_COMMENT=65, WS=66;
	public static final int
		RULE_inicio = 0, RULE_bloc_main = 1, RULE_instrucciones = 2, RULE_instruccion = 3, 
		RULE_bloque_si = 4, RULE_switch_cuerpo = 5, RULE_bloque_switch = 6, RULE_bloque_default = 7, 
		RULE_declaracion = 8, RULE_asignacion = 9, RULE_lvalue = 10, RULE_params = 11, 
		RULE_param_var = 12, RULE_expresion = 13, RULE_tipos = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "bloc_main", "instrucciones", "instruccion", "bloque_si", "switch_cuerpo", 
			"bloque_switch", "bloque_default", "declaracion", "asignacion", "lvalue", 
			"params", "param_var", "expresion", "tipos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'public'", "'class'", "'String'", "'int'", "'boolean'", "'double'", 
			"'char'", "'void'", "'return'", "'new'", "'if'", "'else'", "'true'", 
			"'false'", "'switch'", "'case'", "'default'", "'break'", "'for'", "'continue'", 
			"'while'", "'do'", "'println'", "'print'", "'readln'", "'null'", "'('", 
			"')'", "'{'", "'}'", "';'", "','", "'?'", "':'", "'.'", "'['", "']'", 
			"'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'&&'", "'||'", "'!'", 
			"'++'", "'--'", "'+='", "'-='", "'*='", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUBLIC", "CLASS", "STRING", "INT", "BOOLEAN", "DOUBLE", "CHAR", 
			"VOID", "RETURN", "NEW", "IF", "ELSE", "TRUE", "FALSE", "SWITCH", "CASE", 
			"DEFAULT", "BREAK", "FOR", "CONTINUE", "WHILE", "DO", "PRINTLN", "PRINT", 
			"READLN", "NULL_VAL", "LPAREN", "RPAREN", "LLLAVE", "RLLAVE", "PUNTO_COMA", 
			"COMA", "INTERRG", "DOS_PUNTOS", "PUNTO", "LCORCH", "RCORCH", "IGUAL", 
			"NO_IGUAL", "MAYOR_IGUAL", "MENOR_IGUAL", "MAYOR", "MENOR", "AND", "OR", 
			"NOT", "INCREMENTO", "DECREMENTO", "SUMA_IGL", "RESTA_IGL", "MULT_IGL", 
			"SUMA", "RESTA", "MULT", "DIV", "MOD", "ASIGNACION", "ID", "INTEGER", 
			"DOUBLES", "STRINGS", "CHARS", "ESC", "LINE_COMMENT", "BLOCK_COMMENT", 
			"WS"
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
	public String getGrammarFileName() { return "ZetarianoParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ZetarianoParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicioContext extends ParserRuleContext {
		public Bloc_mainContext bloc_main() {
			return getRuleContext(Bloc_mainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ZetarianoParserParser.EOF, 0); }
		public InicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterInicio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitInicio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitInicio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicioContext inicio() throws RecognitionException {
		InicioContext _localctx = new InicioContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_inicio);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			bloc_main();
			setState(31);
			match(EOF);
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
	public static class Bloc_mainContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(ZetarianoParserParser.PUBLIC, 0); }
		public TerminalNode CLASS() { return getToken(ZetarianoParserParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(ZetarianoParserParser.ID, 0); }
		public TerminalNode LLLAVE() { return getToken(ZetarianoParserParser.LLLAVE, 0); }
		public TerminalNode RLLAVE() { return getToken(ZetarianoParserParser.RLLAVE, 0); }
		public List<InstruccionesContext> instrucciones() {
			return getRuleContexts(InstruccionesContext.class);
		}
		public InstruccionesContext instrucciones(int i) {
			return getRuleContext(InstruccionesContext.class,i);
		}
		public Bloc_mainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterBloc_main(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitBloc_main(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitBloc_main(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloc_mainContext bloc_main() throws RecognitionException {
		Bloc_mainContext _localctx = new Bloc_mainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloc_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(PUBLIC);
			setState(34);
			match(CLASS);
			setState(35);
			match(ID);
			setState(36);
			match(LLLAVE);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376151711994L) != 0)) {
				{
				{
				setState(37);
				instrucciones();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(RLLAVE);
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
	public static class InstruccionesContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(ZetarianoParserParser.PUBLIC, 0); }
		public List<TerminalNode> ID() { return getTokens(ZetarianoParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ZetarianoParserParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(ZetarianoParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ZetarianoParserParser.RPAREN, 0); }
		public TerminalNode LLLAVE() { return getToken(ZetarianoParserParser.LLLAVE, 0); }
		public TerminalNode RLLAVE() { return getToken(ZetarianoParserParser.RLLAVE, 0); }
		public Param_varContext param_var() {
			return getRuleContext(Param_varContext.class,0);
		}
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public TerminalNode VOID() { return getToken(ZetarianoParserParser.VOID, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterInstrucciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitInstrucciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitInstrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instrucciones);
		int _la;
		try {
			int _alt;
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(PUBLIC);
				setState(46);
				match(ID);
				setState(47);
				match(LPAREN);
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376151711992L) != 0)) {
					{
					setState(48);
					param_var();
					}
				}

				setState(51);
				match(RPAREN);
				setState(52);
				match(LLLAVE);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970217208L) != 0)) {
					{
					{
					setState(53);
					instruccion();
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(59);
				match(RLLAVE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(PUBLIC);
				setState(61);
				match(VOID);
				setState(62);
				match(ID);
				setState(63);
				match(LPAREN);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376151711992L) != 0)) {
					{
					setState(64);
					param_var();
					}
				}

				setState(67);
				match(RPAREN);
				setState(68);
				match(LLLAVE);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970217208L) != 0)) {
					{
					{
					setState(69);
					instruccion();
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(75);
				match(RLLAVE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(PUBLIC);
				setState(79);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(77);
					tipos();
					}
					break;
				case ID:
					{
					setState(78);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(81);
				match(ID);
				setState(82);
				match(LPAREN);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376151711992L) != 0)) {
					{
					setState(83);
					param_var();
					}
				}

				setState(86);
				match(RPAREN);
				setState(87);
				match(LLLAVE);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970217208L) != 0)) {
					{
					{
					setState(88);
					instruccion();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(94);
				match(RLLAVE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(96); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(95);
						declaracion();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(98); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
	public static class InstruccionContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public TerminalNode IF() { return getToken(ZetarianoParserParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(ZetarianoParserParser.LPAREN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ZetarianoParserParser.RPAREN, 0); }
		public TerminalNode LLLAVE() { return getToken(ZetarianoParserParser.LLLAVE, 0); }
		public TerminalNode RLLAVE() { return getToken(ZetarianoParserParser.RLLAVE, 0); }
		public Bloque_siContext bloque_si() {
			return getRuleContext(Bloque_siContext.class,0);
		}
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ZetarianoParserParser.ELSE, 0); }
		public TerminalNode SWITCH() { return getToken(ZetarianoParserParser.SWITCH, 0); }
		public Switch_cuerpoContext switch_cuerpo() {
			return getRuleContext(Switch_cuerpoContext.class,0);
		}
		public TerminalNode FOR() { return getToken(ZetarianoParserParser.FOR, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(ZetarianoParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ZetarianoParserParser.ID, i);
		}
		public TerminalNode ASIGNACION() { return getToken(ZetarianoParserParser.ASIGNACION, 0); }
		public List<TerminalNode> PUNTO_COMA() { return getTokens(ZetarianoParserParser.PUNTO_COMA); }
		public TerminalNode PUNTO_COMA(int i) {
			return getToken(ZetarianoParserParser.PUNTO_COMA, i);
		}
		public TerminalNode INCREMENTO() { return getToken(ZetarianoParserParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(ZetarianoParserParser.DECREMENTO, 0); }
		public TerminalNode WHILE() { return getToken(ZetarianoParserParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(ZetarianoParserParser.DO, 0); }
		public TerminalNode PRINTLN() { return getToken(ZetarianoParserParser.PRINTLN, 0); }
		public TerminalNode PRINT() { return getToken(ZetarianoParserParser.PRINT, 0); }
		public TerminalNode READLN() { return getToken(ZetarianoParserParser.READLN, 0); }
		public TerminalNode BREAK() { return getToken(ZetarianoParserParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(ZetarianoParserParser.CONTINUE, 0); }
		public TerminalNode RETURN() { return getToken(ZetarianoParserParser.RETURN, 0); }
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterInstruccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitInstruccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruccion);
		int _la;
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				declaracion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				asignacion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				match(IF);
				setState(105);
				match(LPAREN);
				setState(106);
				expresion(0);
				setState(107);
				match(RPAREN);
				setState(108);
				match(LLLAVE);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970217208L) != 0)) {
					{
					{
					setState(109);
					instruccion();
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(115);
				match(RLLAVE);
				setState(116);
				bloque_si();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(IF);
				setState(119);
				match(LPAREN);
				setState(120);
				expresion(0);
				setState(121);
				match(RPAREN);
				setState(122);
				instruccion();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				match(IF);
				setState(125);
				match(LPAREN);
				setState(126);
				expresion(0);
				setState(127);
				match(RPAREN);
				setState(128);
				instruccion();
				setState(129);
				match(ELSE);
				setState(130);
				instruccion();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(132);
				match(SWITCH);
				setState(133);
				match(LPAREN);
				setState(134);
				expresion(0);
				setState(135);
				match(RPAREN);
				setState(136);
				switch_cuerpo();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(138);
				match(FOR);
				setState(139);
				match(LPAREN);
				setState(152);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					{
					setState(140);
					tipos();
					setState(141);
					match(ID);
					setState(142);
					match(ASIGNACION);
					setState(143);
					expresion(0);
					setState(144);
					match(PUNTO_COMA);
					setState(145);
					expresion(0);
					setState(146);
					match(PUNTO_COMA);
					setState(147);
					match(ID);
					setState(148);
					_la = _input.LA(1);
					if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
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
				case PUNTO_COMA:
					{
					{
					setState(150);
					match(PUNTO_COMA);
					setState(151);
					match(PUNTO_COMA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(154);
				match(RPAREN);
				setState(164);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LLLAVE:
					{
					setState(155);
					match(LLLAVE);
					setState(157); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(156);
						instruccion();
						}
						}
						setState(159); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970217208L) != 0) );
					setState(161);
					match(RLLAVE);
					}
					break;
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
				case RETURN:
				case NEW:
				case IF:
				case TRUE:
				case FALSE:
				case SWITCH:
				case BREAK:
				case FOR:
				case CONTINUE:
				case WHILE:
				case DO:
				case PRINTLN:
				case PRINT:
				case READLN:
				case NULL_VAL:
				case LPAREN:
				case NOT:
				case RESTA:
				case ID:
				case INTEGER:
				case DOUBLES:
				case STRINGS:
				case CHARS:
					{
					setState(163);
					instruccion();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(166);
				match(WHILE);
				setState(167);
				match(LPAREN);
				setState(168);
				expresion(0);
				setState(169);
				match(RPAREN);
				setState(179);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LLLAVE:
					{
					setState(170);
					match(LLLAVE);
					setState(172); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(171);
						instruccion();
						}
						}
						setState(174); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970217208L) != 0) );
					setState(176);
					match(RLLAVE);
					}
					break;
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
				case RETURN:
				case NEW:
				case IF:
				case TRUE:
				case FALSE:
				case SWITCH:
				case BREAK:
				case FOR:
				case CONTINUE:
				case WHILE:
				case DO:
				case PRINTLN:
				case PRINT:
				case READLN:
				case NULL_VAL:
				case LPAREN:
				case NOT:
				case RESTA:
				case ID:
				case INTEGER:
				case DOUBLES:
				case STRINGS:
				case CHARS:
					{
					setState(178);
					instruccion();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(181);
				match(DO);
				setState(182);
				match(LLLAVE);
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(183);
					instruccion();
					}
					}
					setState(186); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970217208L) != 0) );
				setState(188);
				match(RLLAVE);
				setState(189);
				match(WHILE);
				setState(190);
				match(LPAREN);
				setState(191);
				expresion(0);
				setState(192);
				match(RPAREN);
				setState(193);
				match(PUNTO_COMA);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(195);
				match(PRINTLN);
				setState(196);
				match(LPAREN);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903334912L) != 0)) {
					{
					setState(197);
					expresion(0);
					}
				}

				setState(200);
				match(RPAREN);
				setState(201);
				match(PUNTO_COMA);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(202);
				match(PRINT);
				setState(203);
				match(LPAREN);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903334912L) != 0)) {
					{
					setState(204);
					expresion(0);
					}
				}

				setState(207);
				match(RPAREN);
				setState(208);
				match(PUNTO_COMA);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(209);
				match(READLN);
				setState(210);
				match(LPAREN);
				setState(211);
				match(RPAREN);
				setState(212);
				match(PUNTO_COMA);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(213);
				match(BREAK);
				setState(214);
				match(PUNTO_COMA);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(215);
				match(CONTINUE);
				setState(216);
				match(PUNTO_COMA);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(217);
				match(RETURN);
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903334912L) != 0)) {
					{
					setState(218);
					expresion(0);
					}
				}

				setState(221);
				match(PUNTO_COMA);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(222);
				expresion(0);
				setState(223);
				match(PUNTO_COMA);
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
	public static class Bloque_siContext extends ParserRuleContext {
		public List<TerminalNode> ELSE() { return getTokens(ZetarianoParserParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(ZetarianoParserParser.ELSE, i);
		}
		public List<TerminalNode> IF() { return getTokens(ZetarianoParserParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(ZetarianoParserParser.IF, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(ZetarianoParserParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(ZetarianoParserParser.LPAREN, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ZetarianoParserParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(ZetarianoParserParser.RPAREN, i);
		}
		public List<TerminalNode> LLLAVE() { return getTokens(ZetarianoParserParser.LLLAVE); }
		public TerminalNode LLLAVE(int i) {
			return getToken(ZetarianoParserParser.LLLAVE, i);
		}
		public List<TerminalNode> RLLAVE() { return getTokens(ZetarianoParserParser.RLLAVE); }
		public TerminalNode RLLAVE(int i) {
			return getToken(ZetarianoParserParser.RLLAVE, i);
		}
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public Bloque_siContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_si; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterBloque_si(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitBloque_si(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitBloque_si(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_siContext bloque_si() throws RecognitionException {
		Bloque_siContext _localctx = new Bloque_siContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloque_si);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(227);
					match(ELSE);
					setState(228);
					match(IF);
					setState(229);
					match(LPAREN);
					setState(230);
					expresion(0);
					setState(231);
					match(RPAREN);
					setState(232);
					match(LLLAVE);
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970217208L) != 0)) {
						{
						{
						setState(233);
						instruccion();
						}
						}
						setState(238);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(239);
					match(RLLAVE);
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(246);
				match(ELSE);
				setState(247);
				match(LLLAVE);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970217208L) != 0)) {
					{
					{
					setState(248);
					instruccion();
					}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(254);
				match(RLLAVE);
				}
				break;
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
	public static class Switch_cuerpoContext extends ParserRuleContext {
		public TerminalNode LLLAVE() { return getToken(ZetarianoParserParser.LLLAVE, 0); }
		public TerminalNode RLLAVE() { return getToken(ZetarianoParserParser.RLLAVE, 0); }
		public List<Bloque_switchContext> bloque_switch() {
			return getRuleContexts(Bloque_switchContext.class);
		}
		public Bloque_switchContext bloque_switch(int i) {
			return getRuleContext(Bloque_switchContext.class,i);
		}
		public Bloque_defaultContext bloque_default() {
			return getRuleContext(Bloque_defaultContext.class,0);
		}
		public Switch_cuerpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_cuerpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSwitch_cuerpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSwitch_cuerpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSwitch_cuerpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_cuerpoContext switch_cuerpo() throws RecognitionException {
		Switch_cuerpoContext _localctx = new Switch_cuerpoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_switch_cuerpo);
		int _la;
		try {
			int _alt;
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LLLAVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				match(LLLAVE);
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE) {
					{
					{
					setState(258);
					bloque_switch();
					}
					}
					setState(263);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DEFAULT) {
					{
					setState(264);
					bloque_default();
					}
				}

				setState(267);
				match(RLLAVE);
				}
				break;
			case CASE:
				enterOuterAlt(_localctx, 2);
				{
				setState(269); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(268);
						bloque_switch();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(271); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(274);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(273);
					bloque_default();
					}
					break;
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Bloque_switchContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(ZetarianoParserParser.CASE, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode DOS_PUNTOS() { return getToken(ZetarianoParserParser.DOS_PUNTOS, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public Bloque_switchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_switch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterBloque_switch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitBloque_switch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitBloque_switch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_switchContext bloque_switch() throws RecognitionException {
		Bloque_switchContext _localctx = new Bloque_switchContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bloque_switch);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(CASE);
			setState(279);
			expresion(0);
			setState(280);
			match(DOS_PUNTOS);
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(281);
					instruccion();
					}
					} 
				}
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
	public static class Bloque_defaultContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(ZetarianoParserParser.DEFAULT, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(ZetarianoParserParser.DOS_PUNTOS, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public Bloque_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterBloque_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitBloque_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitBloque_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_defaultContext bloque_default() throws RecognitionException {
		Bloque_defaultContext _localctx = new Bloque_defaultContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bloque_default);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(DEFAULT);
			setState(288);
			match(DOS_PUNTOS);
			setState(292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(289);
					instruccion();
					}
					} 
				}
				setState(294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
	public static class DeclaracionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ZetarianoParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ZetarianoParserParser.ID, i);
		}
		public TerminalNode ASIGNACION() { return getToken(ZetarianoParserParser.ASIGNACION, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParserParser.PUNTO_COMA, 0); }
		public List<TiposContext> tipos() {
			return getRuleContexts(TiposContext.class);
		}
		public TiposContext tipos(int i) {
			return getRuleContext(TiposContext.class,i);
		}
		public TerminalNode NEW() { return getToken(ZetarianoParserParser.NEW, 0); }
		public List<TerminalNode> LCORCH() { return getTokens(ZetarianoParserParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(ZetarianoParserParser.LCORCH, i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(ZetarianoParserParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(ZetarianoParserParser.RCORCH, i);
		}
		public TerminalNode LLLAVE() { return getToken(ZetarianoParserParser.LLLAVE, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RLLAVE() { return getToken(ZetarianoParserParser.RLLAVE, 0); }
		public TerminalNode LPAREN() { return getToken(ZetarianoParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ZetarianoParserParser.RPAREN, 0); }
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaracion);
		int _la;
		try {
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(295);
					tipos();
					}
					break;
				case ID:
					{
					setState(296);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(299);
				match(ID);
				setState(300);
				match(ASIGNACION);
				setState(301);
				expresion(0);
				setState(302);
				match(PUNTO_COMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(304);
					tipos();
					}
					break;
				case ID:
					{
					setState(305);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(310); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(308);
					match(LCORCH);
					setState(309);
					match(RCORCH);
					}
					}
					setState(312); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(314);
				match(ID);
				setState(315);
				match(ASIGNACION);
				setState(316);
				match(NEW);
				setState(317);
				tipos();
				setState(322); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(318);
					match(LCORCH);
					setState(319);
					expresion(0);
					setState(320);
					match(RCORCH);
					}
					}
					setState(324); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(326);
				match(PUNTO_COMA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(328);
					tipos();
					}
					break;
				case ID:
					{
					setState(329);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(332);
				match(LCORCH);
				setState(333);
				match(RCORCH);
				setState(334);
				match(ID);
				setState(335);
				match(ASIGNACION);
				setState(336);
				match(LLLAVE);
				setState(337);
				params();
				setState(338);
				match(RLLAVE);
				setState(339);
				match(PUNTO_COMA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(343);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(341);
					tipos();
					}
					break;
				case ID:
					{
					setState(342);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(347); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(345);
					match(LCORCH);
					setState(346);
					match(RCORCH);
					}
					}
					setState(349); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(351);
				match(ID);
				setState(352);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(355);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(353);
					tipos();
					}
					break;
				case ID:
					{
					setState(354);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(357);
				match(ID);
				setState(358);
				match(PUNTO_COMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(361);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(359);
					tipos();
					}
					break;
				case ID:
					{
					setState(360);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(363);
				match(ID);
				setState(364);
				match(ASIGNACION);
				setState(365);
				match(NEW);
				setState(366);
				match(ID);
				setState(367);
				match(LPAREN);
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903334912L) != 0)) {
					{
					setState(368);
					params();
					}
				}

				setState(371);
				match(RPAREN);
				setState(372);
				match(PUNTO_COMA);
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
	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ZetarianoParserParser.ID, 0); }
		public TerminalNode SUMA_IGL() { return getToken(ZetarianoParserParser.SUMA_IGL, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParserParser.PUNTO_COMA, 0); }
		public TerminalNode RESTA_IGL() { return getToken(ZetarianoParserParser.RESTA_IGL, 0); }
		public TerminalNode MULT_IGL() { return getToken(ZetarianoParserParser.MULT_IGL, 0); }
		public TerminalNode ASIGNACION() { return getToken(ZetarianoParserParser.ASIGNACION, 0); }
		public TerminalNode LPAREN() { return getToken(ZetarianoParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ZetarianoParserParser.RPAREN, 0); }
		public TerminalNode INTERRG() { return getToken(ZetarianoParserParser.INTERRG, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(ZetarianoParserParser.DOS_PUNTOS, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode INCREMENTO() { return getToken(ZetarianoParserParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(ZetarianoParserParser.DECREMENTO, 0); }
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_asignacion);
		try {
			setState(412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				match(ID);
				setState(376);
				match(SUMA_IGL);
				setState(377);
				expresion(0);
				setState(378);
				match(PUNTO_COMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(380);
				match(ID);
				setState(381);
				match(RESTA_IGL);
				setState(382);
				expresion(0);
				setState(383);
				match(PUNTO_COMA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(385);
				match(ID);
				setState(386);
				match(MULT_IGL);
				setState(387);
				expresion(0);
				setState(388);
				match(PUNTO_COMA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(390);
				match(ID);
				setState(391);
				match(ASIGNACION);
				setState(392);
				match(LPAREN);
				setState(393);
				expresion(0);
				setState(394);
				match(RPAREN);
				setState(395);
				match(INTERRG);
				setState(396);
				expresion(0);
				setState(397);
				match(DOS_PUNTOS);
				setState(398);
				expresion(0);
				setState(399);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(401);
				lvalue();
				setState(402);
				match(ASIGNACION);
				setState(403);
				expresion(0);
				setState(404);
				match(PUNTO_COMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(406);
				match(ID);
				setState(407);
				match(INCREMENTO);
				setState(408);
				match(PUNTO_COMA);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(409);
				match(ID);
				setState(410);
				match(DECREMENTO);
				setState(411);
				match(PUNTO_COMA);
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
	public static class LvalueContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ZetarianoParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ZetarianoParserParser.ID, i);
		}
		public List<TerminalNode> PUNTO() { return getTokens(ZetarianoParserParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(ZetarianoParserParser.PUNTO, i);
		}
		public List<TerminalNode> LCORCH() { return getTokens(ZetarianoParserParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(ZetarianoParserParser.LCORCH, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(ZetarianoParserParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(ZetarianoParserParser.RCORCH, i);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitLvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitLvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			match(ID);
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUNTO || _la==LCORCH) {
				{
				setState(421);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PUNTO:
					{
					setState(415);
					match(PUNTO);
					setState(416);
					match(ID);
					}
					break;
				case LCORCH:
					{
					setState(417);
					match(LCORCH);
					setState(418);
					expresion(0);
					setState(419);
					match(RCORCH);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(425);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(ZetarianoParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ZetarianoParserParser.COMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			expresion(0);
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(427);
				match(COMA);
				setState(428);
				expresion(0);
				}
				}
				setState(433);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Param_varContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TiposContext> tipos() {
			return getRuleContexts(TiposContext.class);
		}
		public TiposContext tipos(int i) {
			return getRuleContext(TiposContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(ZetarianoParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ZetarianoParserParser.ID, i);
		}
		public List<TerminalNode> COMA() { return getTokens(ZetarianoParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ZetarianoParserParser.COMA, i);
		}
		public Param_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterParam_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitParam_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitParam_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_varContext param_var() throws RecognitionException {
		Param_varContext _localctx = new Param_varContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_param_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case INT:
			case BOOLEAN:
			case DOUBLE:
			case CHAR:
				{
				setState(434);
				tipos();
				}
				break;
			case ID:
				{
				setState(435);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(438);
			expresion(0);
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(439);
				match(COMA);
				setState(442);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(440);
					tipos();
					}
					break;
				case ID:
					{
					setState(441);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(444);
				expresion(0);
				}
				}
				setState(449);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public Token ops1;
		public TerminalNode RESTA() { return getToken(ZetarianoParserParser.RESTA, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(ZetarianoParserParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(ZetarianoParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ZetarianoParserParser.RPAREN, 0); }
		public TerminalNode NEW() { return getToken(ZetarianoParserParser.NEW, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public List<TerminalNode> LCORCH() { return getTokens(ZetarianoParserParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(ZetarianoParserParser.LCORCH, i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(ZetarianoParserParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(ZetarianoParserParser.RCORCH, i);
		}
		public TerminalNode ID() { return getToken(ZetarianoParserParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(ZetarianoParserParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ZetarianoParserParser.FALSE, 0); }
		public TerminalNode NULL_VAL() { return getToken(ZetarianoParserParser.NULL_VAL, 0); }
		public TerminalNode DOUBLES() { return getToken(ZetarianoParserParser.DOUBLES, 0); }
		public TerminalNode INTEGER() { return getToken(ZetarianoParserParser.INTEGER, 0); }
		public TerminalNode CHARS() { return getToken(ZetarianoParserParser.CHARS, 0); }
		public TerminalNode STRINGS() { return getToken(ZetarianoParserParser.STRINGS, 0); }
		public TerminalNode INTERRG() { return getToken(ZetarianoParserParser.INTERRG, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(ZetarianoParserParser.DOS_PUNTOS, 0); }
		public TerminalNode MULT() { return getToken(ZetarianoParserParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(ZetarianoParserParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(ZetarianoParserParser.MOD, 0); }
		public TerminalNode SUMA() { return getToken(ZetarianoParserParser.SUMA, 0); }
		public TerminalNode IGUAL() { return getToken(ZetarianoParserParser.IGUAL, 0); }
		public TerminalNode NO_IGUAL() { return getToken(ZetarianoParserParser.NO_IGUAL, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(ZetarianoParserParser.MENOR_IGUAL, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(ZetarianoParserParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR() { return getToken(ZetarianoParserParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(ZetarianoParserParser.MAYOR, 0); }
		public TerminalNode AND() { return getToken(ZetarianoParserParser.AND, 0); }
		public TerminalNode OR() { return getToken(ZetarianoParserParser.OR, 0); }
		public TerminalNode PUNTO() { return getToken(ZetarianoParserParser.PUNTO, 0); }
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(451);
				match(RESTA);
				setState(452);
				expresion(22);
				}
				break;
			case 2:
				{
				setState(453);
				match(NOT);
				setState(454);
				expresion(21);
				}
				break;
			case 3:
				{
				setState(455);
				match(LPAREN);
				setState(456);
				expresion(0);
				setState(457);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(459);
				match(NEW);
				setState(460);
				tipos();
				setState(465); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(461);
						match(LCORCH);
						setState(462);
						expresion(0);
						setState(463);
						match(RCORCH);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(467); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				{
				setState(469);
				match(NEW);
				setState(470);
				match(ID);
				setState(471);
				match(LPAREN);
				setState(473);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903334912L) != 0)) {
					{
					setState(472);
					params();
					}
				}

				setState(475);
				match(RPAREN);
				}
				break;
			case 6:
				{
				setState(476);
				match(ID);
				setState(477);
				match(LPAREN);
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903334912L) != 0)) {
					{
					setState(478);
					params();
					}
				}

				setState(481);
				match(RPAREN);
				}
				break;
			case 7:
				{
				setState(482);
				match(TRUE);
				}
				break;
			case 8:
				{
				setState(483);
				match(FALSE);
				}
				break;
			case 9:
				{
				setState(484);
				match(NULL_VAL);
				}
				break;
			case 10:
				{
				setState(485);
				match(ID);
				}
				break;
			case 11:
				{
				setState(486);
				match(DOUBLES);
				}
				break;
			case 12:
				{
				setState(487);
				match(INTEGER);
				}
				break;
			case 13:
				{
				setState(488);
				match(CHARS);
				}
				break;
			case 14:
				{
				setState(489);
				match(STRINGS);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(537);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(535);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(492);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(493);
						match(INTERRG);
						setState(494);
						expresion(0);
						setState(495);
						match(DOS_PUNTOS);
						setState(496);
						expresion(20);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(498);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(499);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(500);
						expresion(17);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(501);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(502);
						match(MOD);
						setState(503);
						expresion(16);
						}
						break;
					case 4:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(504);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(505);
						_la = _input.LA(1);
						if ( !(_la==SUMA || _la==RESTA) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(506);
						expresion(15);
						}
						break;
					case 5:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(507);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(508);
						((ExpresionContext)_localctx).ops1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==IGUAL || _la==NO_IGUAL) ) {
							((ExpresionContext)_localctx).ops1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(509);
						expresion(14);
						}
						break;
					case 6:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(510);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(511);
						((ExpresionContext)_localctx).ops1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MAYOR_IGUAL || _la==MENOR_IGUAL) ) {
							((ExpresionContext)_localctx).ops1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(512);
						expresion(13);
						}
						break;
					case 7:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(513);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(514);
						((ExpresionContext)_localctx).ops1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MAYOR || _la==MENOR) ) {
							((ExpresionContext)_localctx).ops1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(515);
						expresion(12);
						}
						break;
					case 8:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(516);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(517);
						((ExpresionContext)_localctx).ops1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((ExpresionContext)_localctx).ops1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(518);
						expresion(11);
						}
						break;
					case 9:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(519);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(520);
						match(PUNTO);
						setState(521);
						match(ID);
						}
						break;
					case 10:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(522);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(523);
						match(PUNTO);
						setState(524);
						match(ID);
						setState(525);
						match(LPAREN);
						setState(527);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903334912L) != 0)) {
							{
							setState(526);
							params();
							}
						}

						setState(529);
						match(RPAREN);
						}
						break;
					case 11:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(530);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(531);
						match(LCORCH);
						setState(532);
						expresion(0);
						setState(533);
						match(RCORCH);
						}
						break;
					}
					} 
				}
				setState(539);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TiposContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ZetarianoParserParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(ZetarianoParserParser.DOUBLE, 0); }
		public TerminalNode BOOLEAN() { return getToken(ZetarianoParserParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(ZetarianoParserParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(ZetarianoParserParser.STRING, 0); }
		public TiposContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterTipos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitTipos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitTipos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TiposContext tipos() throws RecognitionException {
		TiposContext _localctx = new TiposContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 248L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 25);
		case 9:
			return precpred(_ctx, 24);
		case 10:
			return precpred(_ctx, 23);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001B\u021f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001\'\b\u0001\n\u0001\f\u0001*\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00022\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00027\b\u0002\n\u0002\f\u0002"+
		":\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002B\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002G\b\u0002\n\u0002\f\u0002J\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002P\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002U\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002Z\b\u0002\n\u0002\f\u0002]\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0004\u0002a\b\u0002\u000b\u0002\f\u0002b\u0003\u0002e\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003o\b\u0003\n\u0003\f\u0003r\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u0099\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004"+
		"\u0003\u009e\b\u0003\u000b\u0003\f\u0003\u009f\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003\u00a5\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u00ad\b\u0003\u000b\u0003"+
		"\f\u0003\u00ae\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00b4\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u00b9\b\u0003\u000b"+
		"\u0003\f\u0003\u00ba\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003\u00c7\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u00ce\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00dc\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00e2\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004\u00eb\b\u0004\n\u0004\f\u0004\u00ee\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004\u00f2\b\u0004\n\u0004\f\u0004\u00f5\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004\u00fa\b\u0004\n\u0004\f\u0004\u00fd\t\u0004"+
		"\u0001\u0004\u0003\u0004\u0100\b\u0004\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u0104\b\u0005\n\u0005\f\u0005\u0107\t\u0005\u0001\u0005\u0003\u0005\u010a"+
		"\b\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u010e\b\u0005\u000b\u0005"+
		"\f\u0005\u010f\u0001\u0005\u0003\u0005\u0113\b\u0005\u0003\u0005\u0115"+
		"\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u011b"+
		"\b\u0006\n\u0006\f\u0006\u011e\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u0123\b\u0007\n\u0007\f\u0007\u0126\t\u0007\u0001\b\u0001"+
		"\b\u0003\b\u012a\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u0133\b\b\u0001\b\u0001\b\u0004\b\u0137\b\b\u000b\b\f\b\u0138"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004"+
		"\b\u0143\b\b\u000b\b\f\b\u0144\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b"+
		"\u014b\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u0158\b\b\u0001\b\u0001\b\u0004\b\u015c"+
		"\b\b\u000b\b\f\b\u015d\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0164\b"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u016a\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u0172\b\b\u0001\b\u0001\b\u0003\b\u0176"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u019d\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u01a6\b\n\n\n\f\n\u01a9\t\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u01ae\b\u000b\n\u000b\f\u000b\u01b1\t\u000b\u0001"+
		"\f\u0001\f\u0003\f\u01b5\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01bb"+
		"\b\f\u0001\f\u0005\f\u01be\b\f\n\f\f\f\u01c1\t\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0004\r\u01d2\b\r\u000b\r\f\r\u01d3\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u01da\b\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u01e0\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u01eb\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u0210\b\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u0218\b\r\n\r\f\r\u021b\t\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0000\u0001\u001a\u000f\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\b\u0001\u0000"+
		"/0\u0001\u000067\u0001\u000045\u0001\u0000&\'\u0001\u0000()\u0001\u0000"+
		"*+\u0001\u0000,-\u0001\u0000\u0003\u0007\u0276\u0000\u001e\u0001\u0000"+
		"\u0000\u0000\u0002!\u0001\u0000\u0000\u0000\u0004d\u0001\u0000\u0000\u0000"+
		"\u0006\u00e1\u0001\u0000\u0000\u0000\b\u00f3\u0001\u0000\u0000\u0000\n"+
		"\u0114\u0001\u0000\u0000\u0000\f\u0116\u0001\u0000\u0000\u0000\u000e\u011f"+
		"\u0001\u0000\u0000\u0000\u0010\u0175\u0001\u0000\u0000\u0000\u0012\u019c"+
		"\u0001\u0000\u0000\u0000\u0014\u019e\u0001\u0000\u0000\u0000\u0016\u01aa"+
		"\u0001\u0000\u0000\u0000\u0018\u01b4\u0001\u0000\u0000\u0000\u001a\u01ea"+
		"\u0001\u0000\u0000\u0000\u001c\u021c\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0003\u0002\u0001\u0000\u001f \u0005\u0000\u0000\u0001 \u0001\u0001\u0000"+
		"\u0000\u0000!\"\u0005\u0001\u0000\u0000\"#\u0005\u0002\u0000\u0000#$\u0005"+
		":\u0000\u0000$(\u0005\u001d\u0000\u0000%\'\u0003\u0004\u0002\u0000&%\u0001"+
		"\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)+\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000"+
		"\u0000+,\u0005\u001e\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-.\u0005"+
		"\u0001\u0000\u0000./\u0005:\u0000\u0000/1\u0005\u001b\u0000\u000002\u0003"+
		"\u0018\f\u000010\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000023\u0001"+
		"\u0000\u0000\u000034\u0005\u001c\u0000\u000048\u0005\u001d\u0000\u0000"+
		"57\u0003\u0006\u0003\u000065\u0001\u0000\u0000\u00007:\u0001\u0000\u0000"+
		"\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0001\u0000"+
		"\u0000\u0000:8\u0001\u0000\u0000\u0000;e\u0005\u001e\u0000\u0000<=\u0005"+
		"\u0001\u0000\u0000=>\u0005\b\u0000\u0000>?\u0005:\u0000\u0000?A\u0005"+
		"\u001b\u0000\u0000@B\u0003\u0018\f\u0000A@\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0005\u001c\u0000\u0000"+
		"DH\u0005\u001d\u0000\u0000EG\u0003\u0006\u0003\u0000FE\u0001\u0000\u0000"+
		"\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000Ke\u0005"+
		"\u001e\u0000\u0000LO\u0005\u0001\u0000\u0000MP\u0003\u001c\u000e\u0000"+
		"NP\u0005:\u0000\u0000OM\u0001\u0000\u0000\u0000ON\u0001\u0000\u0000\u0000"+
		"PQ\u0001\u0000\u0000\u0000QR\u0005:\u0000\u0000RT\u0005\u001b\u0000\u0000"+
		"SU\u0003\u0018\f\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000VW\u0005\u001c\u0000\u0000W[\u0005\u001d\u0000"+
		"\u0000XZ\u0003\u0006\u0003\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000"+
		"\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001"+
		"\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^e\u0005\u001e\u0000\u0000"+
		"_a\u0003\u0010\b\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000"+
		"\u0000d-\u0001\u0000\u0000\u0000d<\u0001\u0000\u0000\u0000dL\u0001\u0000"+
		"\u0000\u0000d`\u0001\u0000\u0000\u0000e\u0005\u0001\u0000\u0000\u0000"+
		"f\u00e2\u0003\u0010\b\u0000g\u00e2\u0003\u0012\t\u0000hi\u0005\u000b\u0000"+
		"\u0000ij\u0005\u001b\u0000\u0000jk\u0003\u001a\r\u0000kl\u0005\u001c\u0000"+
		"\u0000lp\u0005\u001d\u0000\u0000mo\u0003\u0006\u0003\u0000nm\u0001\u0000"+
		"\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001"+
		"\u0000\u0000\u0000qs\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000"+
		"st\u0005\u001e\u0000\u0000tu\u0003\b\u0004\u0000u\u00e2\u0001\u0000\u0000"+
		"\u0000vw\u0005\u000b\u0000\u0000wx\u0005\u001b\u0000\u0000xy\u0003\u001a"+
		"\r\u0000yz\u0005\u001c\u0000\u0000z{\u0003\u0006\u0003\u0000{\u00e2\u0001"+
		"\u0000\u0000\u0000|}\u0005\u000b\u0000\u0000}~\u0005\u001b\u0000\u0000"+
		"~\u007f\u0003\u001a\r\u0000\u007f\u0080\u0005\u001c\u0000\u0000\u0080"+
		"\u0081\u0003\u0006\u0003\u0000\u0081\u0082\u0005\f\u0000\u0000\u0082\u0083"+
		"\u0003\u0006\u0003\u0000\u0083\u00e2\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0005\u000f\u0000\u0000\u0085\u0086\u0005\u001b\u0000\u0000\u0086\u0087"+
		"\u0003\u001a\r\u0000\u0087\u0088\u0005\u001c\u0000\u0000\u0088\u0089\u0003"+
		"\n\u0005\u0000\u0089\u00e2\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0013"+
		"\u0000\u0000\u008b\u0098\u0005\u001b\u0000\u0000\u008c\u008d\u0003\u001c"+
		"\u000e\u0000\u008d\u008e\u0005:\u0000\u0000\u008e\u008f\u00059\u0000\u0000"+
		"\u008f\u0090\u0003\u001a\r\u0000\u0090\u0091\u0005\u001f\u0000\u0000\u0091"+
		"\u0092\u0003\u001a\r\u0000\u0092\u0093\u0005\u001f\u0000\u0000\u0093\u0094"+
		"\u0005:\u0000\u0000\u0094\u0095\u0007\u0000\u0000\u0000\u0095\u0099\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0005\u001f\u0000\u0000\u0097\u0099\u0005"+
		"\u001f\u0000\u0000\u0098\u008c\u0001\u0000\u0000\u0000\u0098\u0096\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u00a4\u0005"+
		"\u001c\u0000\u0000\u009b\u009d\u0005\u001d\u0000\u0000\u009c\u009e\u0003"+
		"\u0006\u0003\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005"+
		"\u001e\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a5\u0003"+
		"\u0006\u0003\u0000\u00a4\u009b\u0001\u0000\u0000\u0000\u00a4\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a5\u00e2\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005"+
		"\u0015\u0000\u0000\u00a7\u00a8\u0005\u001b\u0000\u0000\u00a8\u00a9\u0003"+
		"\u001a\r\u0000\u00a9\u00b3\u0005\u001c\u0000\u0000\u00aa\u00ac\u0005\u001d"+
		"\u0000\u0000\u00ab\u00ad\u0003\u0006\u0003\u0000\u00ac\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\u0005\u001e\u0000\u0000\u00b1\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b4\u0003\u0006\u0003\u0000\u00b3\u00aa\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00e2\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0005\u0016\u0000\u0000\u00b6\u00b8\u0005\u001d"+
		"\u0000\u0000\u00b7\u00b9\u0003\u0006\u0003\u0000\u00b8\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u0005\u001e\u0000\u0000\u00bd\u00be\u0005\u0015"+
		"\u0000\u0000\u00be\u00bf\u0005\u001b\u0000\u0000\u00bf\u00c0\u0003\u001a"+
		"\r\u0000\u00c0\u00c1\u0005\u001c\u0000\u0000\u00c1\u00c2\u0005\u001f\u0000"+
		"\u0000\u00c2\u00e2\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u0017\u0000"+
		"\u0000\u00c4\u00c6\u0005\u001b\u0000\u0000\u00c5\u00c7\u0003\u001a\r\u0000"+
		"\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u001c\u0000\u0000"+
		"\u00c9\u00e2\u0005\u001f\u0000\u0000\u00ca\u00cb\u0005\u0018\u0000\u0000"+
		"\u00cb\u00cd\u0005\u001b\u0000\u0000\u00cc\u00ce\u0003\u001a\r\u0000\u00cd"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u001c\u0000\u0000\u00d0"+
		"\u00e2\u0005\u001f\u0000\u0000\u00d1\u00d2\u0005\u0019\u0000\u0000\u00d2"+
		"\u00d3\u0005\u001b\u0000\u0000\u00d3\u00d4\u0005\u001c\u0000\u0000\u00d4"+
		"\u00e2\u0005\u001f\u0000\u0000\u00d5\u00d6\u0005\u0012\u0000\u0000\u00d6"+
		"\u00e2\u0005\u001f\u0000\u0000\u00d7\u00d8\u0005\u0014\u0000\u0000\u00d8"+
		"\u00e2\u0005\u001f\u0000\u0000\u00d9\u00db\u0005\t\u0000\u0000\u00da\u00dc"+
		"\u0003\u001a\r\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00db\u00dc\u0001"+
		"\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00e2\u0005"+
		"\u001f\u0000\u0000\u00de\u00df\u0003\u001a\r\u0000\u00df\u00e0\u0005\u001f"+
		"\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1f\u0001\u0000\u0000"+
		"\u0000\u00e1g\u0001\u0000\u0000\u0000\u00e1h\u0001\u0000\u0000\u0000\u00e1"+
		"v\u0001\u0000\u0000\u0000\u00e1|\u0001\u0000\u0000\u0000\u00e1\u0084\u0001"+
		"\u0000\u0000\u0000\u00e1\u008a\u0001\u0000\u0000\u0000\u00e1\u00a6\u0001"+
		"\u0000\u0000\u0000\u00e1\u00b5\u0001\u0000\u0000\u0000\u00e1\u00c3\u0001"+
		"\u0000\u0000\u0000\u00e1\u00ca\u0001\u0000\u0000\u0000\u00e1\u00d1\u0001"+
		"\u0000\u0000\u0000\u00e1\u00d5\u0001\u0000\u0000\u0000\u00e1\u00d7\u0001"+
		"\u0000\u0000\u0000\u00e1\u00d9\u0001\u0000\u0000\u0000\u00e1\u00de\u0001"+
		"\u0000\u0000\u0000\u00e2\u0007\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005"+
		"\f\u0000\u0000\u00e4\u00e5\u0005\u000b\u0000\u0000\u00e5\u00e6\u0005\u001b"+
		"\u0000\u0000\u00e6\u00e7\u0003\u001a\r\u0000\u00e7\u00e8\u0005\u001c\u0000"+
		"\u0000\u00e8\u00ec\u0005\u001d\u0000\u0000\u00e9\u00eb\u0003\u0006\u0003"+
		"\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ef\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0005\u001e\u0000\u0000\u00f0\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f1\u00e3\u0001\u0000\u0000\u0000\u00f2\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f4\u00ff\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0005\f\u0000\u0000\u00f7\u00fb\u0005\u001d\u0000\u0000"+
		"\u00f8\u00fa\u0003\u0006\u0003\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fe\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u0100\u0005\u001e\u0000\u0000"+
		"\u00ff\u00f6\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000"+
		"\u0100\t\u0001\u0000\u0000\u0000\u0101\u0105\u0005\u001d\u0000\u0000\u0102"+
		"\u0104\u0003\f\u0006\u0000\u0103\u0102\u0001\u0000\u0000\u0000\u0104\u0107"+
		"\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0106"+
		"\u0001\u0000\u0000\u0000\u0106\u0109\u0001\u0000\u0000\u0000\u0107\u0105"+
		"\u0001\u0000\u0000\u0000\u0108\u010a\u0003\u000e\u0007\u0000\u0109\u0108"+
		"\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010b"+
		"\u0001\u0000\u0000\u0000\u010b\u0115\u0005\u001e\u0000\u0000\u010c\u010e"+
		"\u0003\f\u0006\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001"+
		"\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110\u0001"+
		"\u0000\u0000\u0000\u0110\u0112\u0001\u0000\u0000\u0000\u0111\u0113\u0003"+
		"\u000e\u0007\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0112\u0113\u0001"+
		"\u0000\u0000\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114\u0101\u0001"+
		"\u0000\u0000\u0000\u0114\u010d\u0001\u0000\u0000\u0000\u0115\u000b\u0001"+
		"\u0000\u0000\u0000\u0116\u0117\u0005\u0010\u0000\u0000\u0117\u0118\u0003"+
		"\u001a\r\u0000\u0118\u011c\u0005\"\u0000\u0000\u0119\u011b\u0003\u0006"+
		"\u0003\u0000\u011a\u0119\u0001\u0000\u0000\u0000\u011b\u011e\u0001\u0000"+
		"\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000"+
		"\u0000\u0000\u011d\r\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000"+
		"\u0000\u011f\u0120\u0005\u0011\u0000\u0000\u0120\u0124\u0005\"\u0000\u0000"+
		"\u0121\u0123\u0003\u0006\u0003\u0000\u0122\u0121\u0001\u0000\u0000\u0000"+
		"\u0123\u0126\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000"+
		"\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u000f\u0001\u0000\u0000\u0000"+
		"\u0126\u0124\u0001\u0000\u0000\u0000\u0127\u012a\u0003\u001c\u000e\u0000"+
		"\u0128\u012a\u0005:\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129"+
		"\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b"+
		"\u012c\u0005:\u0000\u0000\u012c\u012d\u00059\u0000\u0000\u012d\u012e\u0003"+
		"\u001a\r\u0000\u012e\u012f\u0005\u001f\u0000\u0000\u012f\u0176\u0001\u0000"+
		"\u0000\u0000\u0130\u0133\u0003\u001c\u000e\u0000\u0131\u0133\u0005:\u0000"+
		"\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0131\u0001\u0000\u0000"+
		"\u0000\u0133\u0136\u0001\u0000\u0000\u0000\u0134\u0135\u0005$\u0000\u0000"+
		"\u0135\u0137\u0005%\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0137"+
		"\u0138\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138"+
		"\u0139\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a"+
		"\u013b\u0005:\u0000\u0000\u013b\u013c\u00059\u0000\u0000\u013c\u013d\u0005"+
		"\n\u0000\u0000\u013d\u0142\u0003\u001c\u000e\u0000\u013e\u013f\u0005$"+
		"\u0000\u0000\u013f\u0140\u0003\u001a\r\u0000\u0140\u0141\u0005%\u0000"+
		"\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u013e\u0001\u0000\u0000"+
		"\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000"+
		"\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0005\u001f\u0000\u0000\u0147\u0176\u0001\u0000\u0000"+
		"\u0000\u0148\u014b\u0003\u001c\u000e\u0000\u0149\u014b\u0005:\u0000\u0000"+
		"\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u0149\u0001\u0000\u0000\u0000"+
		"\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014d\u0005$\u0000\u0000\u014d"+
		"\u014e\u0005%\u0000\u0000\u014e\u014f\u0005:\u0000\u0000\u014f\u0150\u0005"+
		"9\u0000\u0000\u0150\u0151\u0005\u001d\u0000\u0000\u0151\u0152\u0003\u0016"+
		"\u000b\u0000\u0152\u0153\u0005\u001e\u0000\u0000\u0153\u0154\u0005\u001f"+
		"\u0000\u0000\u0154\u0176\u0001\u0000\u0000\u0000\u0155\u0158\u0003\u001c"+
		"\u000e\u0000\u0156\u0158\u0005:\u0000\u0000\u0157\u0155\u0001\u0000\u0000"+
		"\u0000\u0157\u0156\u0001\u0000\u0000\u0000\u0158\u015b\u0001\u0000\u0000"+
		"\u0000\u0159\u015a\u0005$\u0000\u0000\u015a\u015c\u0005%\u0000\u0000\u015b"+
		"\u0159\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d"+
		"\u015b\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e"+
		"\u015f\u0001\u0000\u0000\u0000\u015f\u0160\u0005:\u0000\u0000\u0160\u0176"+
		"\u0005\u001f\u0000\u0000\u0161\u0164\u0003\u001c\u000e\u0000\u0162\u0164"+
		"\u0005:\u0000\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0163\u0162\u0001"+
		"\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0166\u0005"+
		":\u0000\u0000\u0166\u0176\u0005\u001f\u0000\u0000\u0167\u016a\u0003\u001c"+
		"\u000e\u0000\u0168\u016a\u0005:\u0000\u0000\u0169\u0167\u0001\u0000\u0000"+
		"\u0000\u0169\u0168\u0001\u0000\u0000\u0000\u016a\u016b\u0001\u0000\u0000"+
		"\u0000\u016b\u016c\u0005:\u0000\u0000\u016c\u016d\u00059\u0000\u0000\u016d"+
		"\u016e\u0005\n\u0000\u0000\u016e\u016f\u0005:\u0000\u0000\u016f\u0171"+
		"\u0005\u001b\u0000\u0000\u0170\u0172\u0003\u0016\u000b\u0000\u0171\u0170"+
		"\u0001\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0173"+
		"\u0001\u0000\u0000\u0000\u0173\u0174\u0005\u001c\u0000\u0000\u0174\u0176"+
		"\u0005\u001f\u0000\u0000\u0175\u0129\u0001\u0000\u0000\u0000\u0175\u0132"+
		"\u0001\u0000\u0000\u0000\u0175\u014a\u0001\u0000\u0000\u0000\u0175\u0157"+
		"\u0001\u0000\u0000\u0000\u0175\u0163\u0001\u0000\u0000\u0000\u0175\u0169"+
		"\u0001\u0000\u0000\u0000\u0176\u0011\u0001\u0000\u0000\u0000\u0177\u0178"+
		"\u0005:\u0000\u0000\u0178\u0179\u00051\u0000\u0000\u0179\u017a\u0003\u001a"+
		"\r\u0000\u017a\u017b\u0005\u001f\u0000\u0000\u017b\u019d\u0001\u0000\u0000"+
		"\u0000\u017c\u017d\u0005:\u0000\u0000\u017d\u017e\u00052\u0000\u0000\u017e"+
		"\u017f\u0003\u001a\r\u0000\u017f\u0180\u0005\u001f\u0000\u0000\u0180\u019d"+
		"\u0001\u0000\u0000\u0000\u0181\u0182\u0005:\u0000\u0000\u0182\u0183\u0005"+
		"3\u0000\u0000\u0183\u0184\u0003\u001a\r\u0000\u0184\u0185\u0005\u001f"+
		"\u0000\u0000\u0185\u019d\u0001\u0000\u0000\u0000\u0186\u0187\u0005:\u0000"+
		"\u0000\u0187\u0188\u00059\u0000\u0000\u0188\u0189\u0005\u001b\u0000\u0000"+
		"\u0189\u018a\u0003\u001a\r\u0000\u018a\u018b\u0005\u001c\u0000\u0000\u018b"+
		"\u018c\u0005!\u0000\u0000\u018c\u018d\u0003\u001a\r\u0000\u018d\u018e"+
		"\u0005\"\u0000\u0000\u018e\u018f\u0003\u001a\r\u0000\u018f\u0190\u0005"+
		"\u001f\u0000\u0000\u0190\u019d\u0001\u0000\u0000\u0000\u0191\u0192\u0003"+
		"\u0014\n\u0000\u0192\u0193\u00059\u0000\u0000\u0193\u0194\u0003\u001a"+
		"\r\u0000\u0194\u0195\u0005\u001f\u0000\u0000\u0195\u019d\u0001\u0000\u0000"+
		"\u0000\u0196\u0197\u0005:\u0000\u0000\u0197\u0198\u0005/\u0000\u0000\u0198"+
		"\u019d\u0005\u001f\u0000\u0000\u0199\u019a\u0005:\u0000\u0000\u019a\u019b"+
		"\u00050\u0000\u0000\u019b\u019d\u0005\u001f\u0000\u0000\u019c\u0177\u0001"+
		"\u0000\u0000\u0000\u019c\u017c\u0001\u0000\u0000\u0000\u019c\u0181\u0001"+
		"\u0000\u0000\u0000\u019c\u0186\u0001\u0000\u0000\u0000\u019c\u0191\u0001"+
		"\u0000\u0000\u0000\u019c\u0196\u0001\u0000\u0000\u0000\u019c\u0199\u0001"+
		"\u0000\u0000\u0000\u019d\u0013\u0001\u0000\u0000\u0000\u019e\u01a7\u0005"+
		":\u0000\u0000\u019f\u01a0\u0005#\u0000\u0000\u01a0\u01a6\u0005:\u0000"+
		"\u0000\u01a1\u01a2\u0005$\u0000\u0000\u01a2\u01a3\u0003\u001a\r\u0000"+
		"\u01a3\u01a4\u0005%\u0000\u0000\u01a4\u01a6\u0001\u0000\u0000\u0000\u01a5"+
		"\u019f\u0001\u0000\u0000\u0000\u01a5\u01a1\u0001\u0000\u0000\u0000\u01a6"+
		"\u01a9\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a7"+
		"\u01a8\u0001\u0000\u0000\u0000\u01a8\u0015\u0001\u0000\u0000\u0000\u01a9"+
		"\u01a7\u0001\u0000\u0000\u0000\u01aa\u01af\u0003\u001a\r\u0000\u01ab\u01ac"+
		"\u0005 \u0000\u0000\u01ac\u01ae\u0003\u001a\r\u0000\u01ad\u01ab\u0001"+
		"\u0000\u0000\u0000\u01ae\u01b1\u0001\u0000\u0000\u0000\u01af\u01ad\u0001"+
		"\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u0017\u0001"+
		"\u0000\u0000\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2\u01b5\u0003"+
		"\u001c\u000e\u0000\u01b3\u01b5\u0005:\u0000\u0000\u01b4\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000"+
		"\u0000\u0000\u01b6\u01bf\u0003\u001a\r\u0000\u01b7\u01ba\u0005 \u0000"+
		"\u0000\u01b8\u01bb\u0003\u001c\u000e\u0000\u01b9\u01bb\u0005:\u0000\u0000"+
		"\u01ba\u01b8\u0001\u0000\u0000\u0000\u01ba\u01b9\u0001\u0000\u0000\u0000"+
		"\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc\u01be\u0003\u001a\r\u0000\u01bd"+
		"\u01b7\u0001\u0000\u0000\u0000\u01be\u01c1\u0001\u0000\u0000\u0000\u01bf"+
		"\u01bd\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0"+
		"\u0019\u0001\u0000\u0000\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c2"+
		"\u01c3\u0006\r\uffff\uffff\u0000\u01c3\u01c4\u00055\u0000\u0000\u01c4"+
		"\u01eb\u0003\u001a\r\u0016\u01c5\u01c6\u0005.\u0000\u0000\u01c6\u01eb"+
		"\u0003\u001a\r\u0015\u01c7\u01c8\u0005\u001b\u0000\u0000\u01c8\u01c9\u0003"+
		"\u001a\r\u0000\u01c9\u01ca\u0005\u001c\u0000\u0000\u01ca\u01eb\u0001\u0000"+
		"\u0000\u0000\u01cb\u01cc\u0005\n\u0000\u0000\u01cc\u01d1\u0003\u001c\u000e"+
		"\u0000\u01cd\u01ce\u0005$\u0000\u0000\u01ce\u01cf\u0003\u001a\r\u0000"+
		"\u01cf\u01d0\u0005%\u0000\u0000\u01d0\u01d2\u0001\u0000\u0000\u0000\u01d1"+
		"\u01cd\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3"+
		"\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4"+
		"\u01eb\u0001\u0000\u0000\u0000\u01d5\u01d6\u0005\n\u0000\u0000\u01d6\u01d7"+
		"\u0005:\u0000\u0000\u01d7\u01d9\u0005\u001b\u0000\u0000\u01d8\u01da\u0003"+
		"\u0016\u000b\u0000\u01d9\u01d8\u0001\u0000\u0000\u0000\u01d9\u01da\u0001"+
		"\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01eb\u0005"+
		"\u001c\u0000\u0000\u01dc\u01dd\u0005:\u0000\u0000\u01dd\u01df\u0005\u001b"+
		"\u0000\u0000\u01de\u01e0\u0003\u0016\u000b\u0000\u01df\u01de\u0001\u0000"+
		"\u0000\u0000\u01df\u01e0\u0001\u0000\u0000\u0000\u01e0\u01e1\u0001\u0000"+
		"\u0000\u0000\u01e1\u01eb\u0005\u001c\u0000\u0000\u01e2\u01eb\u0005\r\u0000"+
		"\u0000\u01e3\u01eb\u0005\u000e\u0000\u0000\u01e4\u01eb\u0005\u001a\u0000"+
		"\u0000\u01e5\u01eb\u0005:\u0000\u0000\u01e6\u01eb\u0005<\u0000\u0000\u01e7"+
		"\u01eb\u0005;\u0000\u0000\u01e8\u01eb\u0005>\u0000\u0000\u01e9\u01eb\u0005"+
		"=\u0000\u0000\u01ea\u01c2\u0001\u0000\u0000\u0000\u01ea\u01c5\u0001\u0000"+
		"\u0000\u0000\u01ea\u01c7\u0001\u0000\u0000\u0000\u01ea\u01cb\u0001\u0000"+
		"\u0000\u0000\u01ea\u01d5\u0001\u0000\u0000\u0000\u01ea\u01dc\u0001\u0000"+
		"\u0000\u0000\u01ea\u01e2\u0001\u0000\u0000\u0000\u01ea\u01e3\u0001\u0000"+
		"\u0000\u0000\u01ea\u01e4\u0001\u0000\u0000\u0000\u01ea\u01e5\u0001\u0000"+
		"\u0000\u0000\u01ea\u01e6\u0001\u0000\u0000\u0000\u01ea\u01e7\u0001\u0000"+
		"\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000\u0000\u01ea\u01e9\u0001\u0000"+
		"\u0000\u0000\u01eb\u0219\u0001\u0000\u0000\u0000\u01ec\u01ed\n\u0013\u0000"+
		"\u0000\u01ed\u01ee\u0005!\u0000\u0000\u01ee\u01ef\u0003\u001a\r\u0000"+
		"\u01ef\u01f0\u0005\"\u0000\u0000\u01f0\u01f1\u0003\u001a\r\u0014\u01f1"+
		"\u0218\u0001\u0000\u0000\u0000\u01f2\u01f3\n\u0010\u0000\u0000\u01f3\u01f4"+
		"\u0007\u0001\u0000\u0000\u01f4\u0218\u0003\u001a\r\u0011\u01f5\u01f6\n"+
		"\u000f\u0000\u0000\u01f6\u01f7\u00058\u0000\u0000\u01f7\u0218\u0003\u001a"+
		"\r\u0010\u01f8\u01f9\n\u000e\u0000\u0000\u01f9\u01fa\u0007\u0002\u0000"+
		"\u0000\u01fa\u0218\u0003\u001a\r\u000f\u01fb\u01fc\n\r\u0000\u0000\u01fc"+
		"\u01fd\u0007\u0003\u0000\u0000\u01fd\u0218\u0003\u001a\r\u000e\u01fe\u01ff"+
		"\n\f\u0000\u0000\u01ff\u0200\u0007\u0004\u0000\u0000\u0200\u0218\u0003"+
		"\u001a\r\r\u0201\u0202\n\u000b\u0000\u0000\u0202\u0203\u0007\u0005\u0000"+
		"\u0000\u0203\u0218\u0003\u001a\r\f\u0204\u0205\n\n\u0000\u0000\u0205\u0206"+
		"\u0007\u0006\u0000\u0000\u0206\u0218\u0003\u001a\r\u000b\u0207\u0208\n"+
		"\u0019\u0000\u0000\u0208\u0209\u0005#\u0000\u0000\u0209\u0218\u0005:\u0000"+
		"\u0000\u020a\u020b\n\u0018\u0000\u0000\u020b\u020c\u0005#\u0000\u0000"+
		"\u020c\u020d\u0005:\u0000\u0000\u020d\u020f\u0005\u001b\u0000\u0000\u020e"+
		"\u0210\u0003\u0016\u000b\u0000\u020f\u020e\u0001\u0000\u0000\u0000\u020f"+
		"\u0210\u0001\u0000\u0000\u0000\u0210\u0211\u0001\u0000\u0000\u0000\u0211"+
		"\u0218\u0005\u001c\u0000\u0000\u0212\u0213\n\u0017\u0000\u0000\u0213\u0214"+
		"\u0005$\u0000\u0000\u0214\u0215\u0003\u001a\r\u0000\u0215\u0216\u0005"+
		"%\u0000\u0000\u0216\u0218\u0001\u0000\u0000\u0000\u0217\u01ec\u0001\u0000"+
		"\u0000\u0000\u0217\u01f2\u0001\u0000\u0000\u0000\u0217\u01f5\u0001\u0000"+
		"\u0000\u0000\u0217\u01f8\u0001\u0000\u0000\u0000\u0217\u01fb\u0001\u0000"+
		"\u0000\u0000\u0217\u01fe\u0001\u0000\u0000\u0000\u0217\u0201\u0001\u0000"+
		"\u0000\u0000\u0217\u0204\u0001\u0000\u0000\u0000\u0217\u0207\u0001\u0000"+
		"\u0000\u0000\u0217\u020a\u0001\u0000\u0000\u0000\u0217\u0212\u0001\u0000"+
		"\u0000\u0000\u0218\u021b\u0001\u0000\u0000\u0000\u0219\u0217\u0001\u0000"+
		"\u0000\u0000\u0219\u021a\u0001\u0000\u0000\u0000\u021a\u001b\u0001\u0000"+
		"\u0000\u0000\u021b\u0219\u0001\u0000\u0000\u0000\u021c\u021d\u0007\u0007"+
		"\u0000\u0000\u021d\u001d\u0001\u0000\u0000\u00009(18AHOT[bdp\u0098\u009f"+
		"\u00a4\u00ae\u00b3\u00ba\u00c6\u00cd\u00db\u00e1\u00ec\u00f3\u00fb\u00ff"+
		"\u0105\u0109\u010f\u0112\u0114\u011c\u0124\u0129\u0132\u0138\u0144\u014a"+
		"\u0157\u015d\u0163\u0169\u0171\u0175\u019c\u01a5\u01a7\u01af\u01b4\u01ba"+
		"\u01bf\u01d3\u01d9\u01df\u01ea\u020f\u0217\u0219";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}