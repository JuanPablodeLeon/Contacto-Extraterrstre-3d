// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/ZetarianoParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

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
		RULE_bloque_si = 4, RULE_bloque_switch = 5, RULE_declaracion = 6, RULE_asignacion = 7, 
		RULE_lvalue = 8, RULE_params = 9, RULE_param_var = 10, RULE_expresion = 11, 
		RULE_tipos = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "bloc_main", "instrucciones", "instruccion", "bloque_si", "bloque_switch", 
			"declaracion", "asignacion", "lvalue", "params", "param_var", "expresion", 
			"tipos"
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
			setState(26);
			bloc_main();
			setState(27);
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
			setState(29);
			match(PUBLIC);
			setState(30);
			match(CLASS);
			setState(31);
			match(ID);
			setState(32);
			match(LLLAVE);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376151711994L) != 0)) {
				{
				{
				setState(33);
				instrucciones();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
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
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(PUBLIC);
				setState(42);
				match(ID);
				setState(43);
				match(LPAREN);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376151711992L) != 0)) {
					{
					setState(44);
					param_var();
					}
				}

				setState(47);
				match(RPAREN);
				setState(48);
				match(LLLAVE);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970216184L) != 0)) {
					{
					{
					setState(49);
					instruccion();
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(55);
				match(RLLAVE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(PUBLIC);
				setState(57);
				match(VOID);
				setState(58);
				match(ID);
				setState(59);
				match(LPAREN);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376151711992L) != 0)) {
					{
					setState(60);
					param_var();
					}
				}

				setState(63);
				match(RPAREN);
				setState(64);
				match(LLLAVE);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970216184L) != 0)) {
					{
					{
					setState(65);
					instruccion();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71);
				match(RLLAVE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				match(PUBLIC);
				setState(75);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(73);
					tipos();
					}
					break;
				case ID:
					{
					setState(74);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(77);
				match(ID);
				setState(78);
				match(LPAREN);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376151711992L) != 0)) {
					{
					setState(79);
					param_var();
					}
				}

				setState(82);
				match(RPAREN);
				setState(83);
				match(LLLAVE);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970216184L) != 0)) {
					{
					{
					setState(84);
					instruccion();
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(90);
				match(RLLAVE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(92); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(91);
						declaracion();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(94); 
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
		public List<TerminalNode> ID() { return getTokens(ZetarianoParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ZetarianoParserParser.ID, i);
		}
		public TerminalNode DEFAULT() { return getToken(ZetarianoParserParser.DEFAULT, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(ZetarianoParserParser.DOS_PUNTOS, 0); }
		public TerminalNode BREAK() { return getToken(ZetarianoParserParser.BREAK, 0); }
		public List<TerminalNode> PUNTO_COMA() { return getTokens(ZetarianoParserParser.PUNTO_COMA); }
		public TerminalNode PUNTO_COMA(int i) {
			return getToken(ZetarianoParserParser.PUNTO_COMA, i);
		}
		public List<Bloque_switchContext> bloque_switch() {
			return getRuleContexts(Bloque_switchContext.class);
		}
		public Bloque_switchContext bloque_switch(int i) {
			return getRuleContext(Bloque_switchContext.class,i);
		}
		public TerminalNode FOR() { return getToken(ZetarianoParserParser.FOR, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public TerminalNode ASIGNACION() { return getToken(ZetarianoParserParser.ASIGNACION, 0); }
		public TerminalNode INCREMENTO() { return getToken(ZetarianoParserParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(ZetarianoParserParser.DECREMENTO, 0); }
		public TerminalNode WHILE() { return getToken(ZetarianoParserParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(ZetarianoParserParser.DO, 0); }
		public TerminalNode PRINTLN() { return getToken(ZetarianoParserParser.PRINTLN, 0); }
		public TerminalNode PRINT() { return getToken(ZetarianoParserParser.PRINT, 0); }
		public TerminalNode READLN() { return getToken(ZetarianoParserParser.READLN, 0); }
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
			int _alt;
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				declaracion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				asignacion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				match(IF);
				setState(101);
				match(LPAREN);
				setState(102);
				expresion(0);
				setState(103);
				match(RPAREN);
				setState(104);
				match(LLLAVE);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970216184L) != 0)) {
					{
					{
					setState(105);
					instruccion();
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(111);
				match(RLLAVE);
				setState(112);
				bloque_si();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				match(IF);
				setState(115);
				match(LPAREN);
				setState(116);
				expresion(0);
				setState(117);
				match(RPAREN);
				setState(118);
				instruccion();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
				match(IF);
				setState(121);
				match(LPAREN);
				setState(122);
				expresion(0);
				setState(123);
				match(RPAREN);
				setState(124);
				instruccion();
				setState(125);
				match(ELSE);
				setState(126);
				instruccion();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				match(SWITCH);
				setState(129);
				match(LPAREN);
				setState(130);
				match(ID);
				setState(131);
				match(RPAREN);
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(132);
					bloque_switch();
					}
					}
					setState(135); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CASE );
				setState(137);
				match(DEFAULT);
				setState(138);
				match(DOS_PUNTOS);
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(139);
						instruccion();
						}
						} 
					}
					setState(144);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(145);
				match(BREAK);
				setState(146);
				match(PUNTO_COMA);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(148);
				match(FOR);
				setState(149);
				match(LPAREN);
				setState(162);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					{
					setState(150);
					tipos();
					setState(151);
					match(ID);
					setState(152);
					match(ASIGNACION);
					setState(153);
					expresion(0);
					setState(154);
					match(PUNTO_COMA);
					setState(155);
					expresion(0);
					setState(156);
					match(PUNTO_COMA);
					setState(157);
					match(ID);
					setState(158);
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
					setState(160);
					match(PUNTO_COMA);
					setState(161);
					match(PUNTO_COMA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(164);
				match(RPAREN);
				setState(165);
				match(LLLAVE);
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(166);
					instruccion();
					}
					}
					setState(169); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970216184L) != 0) );
				setState(171);
				match(RLLAVE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(173);
				match(WHILE);
				setState(174);
				match(LPAREN);
				setState(175);
				expresion(0);
				setState(176);
				match(RPAREN);
				setState(177);
				match(LLLAVE);
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178);
					instruccion();
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970216184L) != 0) );
				setState(183);
				match(RLLAVE);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(185);
				match(DO);
				setState(186);
				match(LLLAVE);
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(187);
					instruccion();
					}
					}
					setState(190); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970216184L) != 0) );
				setState(192);
				match(RLLAVE);
				setState(193);
				match(WHILE);
				setState(194);
				match(LPAREN);
				setState(195);
				expresion(0);
				setState(196);
				match(RPAREN);
				setState(197);
				match(PUNTO_COMA);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(199);
				match(PRINTLN);
				setState(200);
				match(LPAREN);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903333888L) != 0)) {
					{
					setState(201);
					expresion(0);
					}
				}

				setState(204);
				match(RPAREN);
				setState(205);
				match(PUNTO_COMA);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(206);
				match(PRINT);
				setState(207);
				match(LPAREN);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903333888L) != 0)) {
					{
					setState(208);
					expresion(0);
					}
				}

				setState(211);
				match(RPAREN);
				setState(212);
				match(PUNTO_COMA);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(213);
				match(READLN);
				setState(214);
				match(LPAREN);
				setState(215);
				match(RPAREN);
				setState(216);
				match(PUNTO_COMA);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(217);
				match(BREAK);
				setState(218);
				match(PUNTO_COMA);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(219);
				match(CONTINUE);
				setState(220);
				match(PUNTO_COMA);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(221);
				match(RETURN);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903333888L) != 0)) {
					{
					setState(222);
					expresion(0);
					}
				}

				setState(225);
				match(PUNTO_COMA);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(226);
				expresion(0);
				setState(227);
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
			setState(247);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(231);
					match(ELSE);
					setState(232);
					match(IF);
					setState(233);
					match(LPAREN);
					setState(234);
					expresion(0);
					setState(235);
					match(RPAREN);
					setState(236);
					match(LLLAVE);
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970216184L) != 0)) {
						{
						{
						setState(237);
						instruccion();
						}
						}
						setState(242);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(243);
					match(RLLAVE);
					}
					} 
				}
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(250);
				match(ELSE);
				setState(251);
				match(LLLAVE);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228970216184L) != 0)) {
					{
					{
					setState(252);
					instruccion();
					}
					}
					setState(257);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(258);
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
		public TerminalNode BREAK() { return getToken(ZetarianoParserParser.BREAK, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParserParser.PUNTO_COMA, 0); }
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
		enterRule(_localctx, 10, RULE_bloque_switch);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(CASE);
			setState(262);
			expresion(0);
			setState(263);
			match(DOS_PUNTOS);
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(264);
					instruccion();
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BREAK) {
				{
				setState(270);
				match(BREAK);
				setState(271);
				match(PUNTO_COMA);
				}
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
		enterRule(_localctx, 12, RULE_declaracion);
		int _la;
		try {
			setState(350);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(274);
					tipos();
					}
					break;
				case ID:
					{
					setState(275);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(278);
				match(ID);
				setState(279);
				match(ASIGNACION);
				setState(280);
				expresion(0);
				setState(281);
				match(PUNTO_COMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(283);
					tipos();
					}
					break;
				case ID:
					{
					setState(284);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(289); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(287);
					match(LCORCH);
					setState(288);
					match(RCORCH);
					}
					}
					setState(291); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(293);
				match(ID);
				setState(294);
				match(ASIGNACION);
				setState(295);
				match(NEW);
				setState(296);
				tipos();
				setState(301); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(297);
					match(LCORCH);
					setState(298);
					expresion(0);
					setState(299);
					match(RCORCH);
					}
					}
					setState(303); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(305);
				match(PUNTO_COMA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(307);
					tipos();
					}
					break;
				case ID:
					{
					setState(308);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(311);
				match(LCORCH);
				setState(312);
				match(RCORCH);
				setState(313);
				match(ID);
				setState(314);
				match(ASIGNACION);
				setState(315);
				match(LLLAVE);
				setState(316);
				params();
				setState(317);
				match(RLLAVE);
				setState(318);
				match(PUNTO_COMA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(322);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(320);
					tipos();
					}
					break;
				case ID:
					{
					setState(321);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(324);
				match(ID);
				setState(325);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(326);
				match(ID);
				setState(327);
				match(ASIGNACION);
				setState(328);
				match(NEW);
				setState(329);
				match(ID);
				setState(330);
				match(LPAREN);
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903333888L) != 0)) {
					{
					setState(331);
					params();
					}
				}

				setState(334);
				match(RPAREN);
				setState(335);
				match(PUNTO_COMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(338);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(336);
					tipos();
					}
					break;
				case ID:
					{
					setState(337);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(340);
				match(ID);
				setState(341);
				match(ASIGNACION);
				setState(342);
				match(NEW);
				setState(343);
				match(ID);
				setState(344);
				match(LPAREN);
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903333888L) != 0)) {
					{
					setState(345);
					params();
					}
				}

				setState(348);
				match(RPAREN);
				setState(349);
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
		public TerminalNode LCORCH() { return getToken(ZetarianoParserParser.LCORCH, 0); }
		public TerminalNode RCORCH() { return getToken(ZetarianoParserParser.RCORCH, 0); }
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
		enterRule(_localctx, 14, RULE_asignacion);
		try {
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				match(ID);
				setState(353);
				match(SUMA_IGL);
				setState(354);
				expresion(0);
				setState(355);
				match(PUNTO_COMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				match(ID);
				setState(358);
				match(RESTA_IGL);
				setState(359);
				expresion(0);
				setState(360);
				match(PUNTO_COMA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(362);
				match(ID);
				setState(363);
				match(MULT_IGL);
				setState(364);
				expresion(0);
				setState(365);
				match(PUNTO_COMA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(367);
				match(ID);
				setState(368);
				match(ASIGNACION);
				setState(369);
				match(LPAREN);
				setState(370);
				expresion(0);
				setState(371);
				match(RPAREN);
				setState(372);
				match(INTERRG);
				setState(373);
				expresion(0);
				setState(374);
				match(DOS_PUNTOS);
				setState(375);
				expresion(0);
				setState(376);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(378);
				match(ID);
				setState(379);
				match(LCORCH);
				setState(380);
				expresion(0);
				setState(381);
				match(RCORCH);
				setState(382);
				match(ASIGNACION);
				setState(383);
				expresion(0);
				setState(384);
				match(PUNTO_COMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(386);
				lvalue();
				setState(387);
				match(ASIGNACION);
				setState(388);
				expresion(0);
				setState(389);
				match(PUNTO_COMA);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(391);
				match(ID);
				setState(392);
				match(INCREMENTO);
				setState(393);
				match(PUNTO_COMA);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(394);
				match(ID);
				setState(395);
				match(DECREMENTO);
				setState(396);
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
		enterRule(_localctx, 16, RULE_lvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(ID);
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUNTO || _la==LCORCH) {
				{
				setState(406);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PUNTO:
					{
					setState(400);
					match(PUNTO);
					setState(401);
					match(ID);
					}
					break;
				case LCORCH:
					{
					setState(402);
					match(LCORCH);
					setState(403);
					expresion(0);
					setState(404);
					match(RCORCH);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(410);
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
		enterRule(_localctx, 18, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			expresion(0);
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(412);
				match(COMA);
				setState(413);
				expresion(0);
				}
				}
				setState(418);
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
		enterRule(_localctx, 20, RULE_param_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case INT:
			case BOOLEAN:
			case DOUBLE:
			case CHAR:
				{
				setState(419);
				tipos();
				}
				break;
			case ID:
				{
				setState(420);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(423);
			expresion(0);
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(424);
				match(COMA);
				setState(427);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case INT:
				case BOOLEAN:
				case DOUBLE:
				case CHAR:
					{
					setState(425);
					tipos();
					}
					break;
				case ID:
					{
					setState(426);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(429);
				expresion(0);
				}
				}
				setState(434);
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
		public TerminalNode LCORCH() { return getToken(ZetarianoParserParser.LCORCH, 0); }
		public TerminalNode RCORCH() { return getToken(ZetarianoParserParser.RCORCH, 0); }
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(436);
				match(RESTA);
				setState(437);
				expresion(22);
				}
				break;
			case 2:
				{
				setState(438);
				match(NOT);
				setState(439);
				expresion(21);
				}
				break;
			case 3:
				{
				setState(440);
				match(LPAREN);
				setState(441);
				expresion(0);
				setState(442);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(444);
				match(ID);
				setState(445);
				match(LPAREN);
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903333888L) != 0)) {
					{
					setState(446);
					params();
					}
				}

				setState(449);
				match(RPAREN);
				}
				break;
			case 5:
				{
				setState(450);
				match(TRUE);
				}
				break;
			case 6:
				{
				setState(451);
				match(FALSE);
				}
				break;
			case 7:
				{
				setState(452);
				match(NULL_VAL);
				}
				break;
			case 8:
				{
				setState(453);
				match(ID);
				}
				break;
			case 9:
				{
				setState(454);
				match(DOUBLES);
				}
				break;
			case 10:
				{
				setState(455);
				match(INTEGER);
				}
				break;
			case 11:
				{
				setState(456);
				match(CHARS);
				}
				break;
			case 12:
				{
				setState(457);
				match(STRINGS);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(499);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(497);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(460);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(461);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(462);
						expresion(17);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(463);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(464);
						match(MOD);
						setState(465);
						expresion(16);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(466);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(467);
						_la = _input.LA(1);
						if ( !(_la==SUMA || _la==RESTA) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(468);
						expresion(15);
						}
						break;
					case 4:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(469);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(470);
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
						setState(471);
						expresion(14);
						}
						break;
					case 5:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(472);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(473);
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
						setState(474);
						expresion(13);
						}
						break;
					case 6:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(475);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(476);
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
						setState(477);
						expresion(12);
						}
						break;
					case 7:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(478);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(479);
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
						setState(480);
						expresion(11);
						}
						break;
					case 8:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(481);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(482);
						match(PUNTO);
						setState(483);
						match(ID);
						}
						break;
					case 9:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(484);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(485);
						match(PUNTO);
						setState(486);
						match(ID);
						setState(487);
						match(LPAREN);
						setState(489);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8944219228903333888L) != 0)) {
							{
							setState(488);
							params();
							}
						}

						setState(491);
						match(RPAREN);
						}
						break;
					case 10:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(492);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(493);
						match(LCORCH);
						setState(494);
						expresion(0);
						setState(495);
						match(RCORCH);
						}
						break;
					}
					} 
				}
				setState(501);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		enterRule(_localctx, 24, RULE_tipos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
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
		case 11:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 19);
		case 8:
			return precpred(_ctx, 18);
		case 9:
			return precpred(_ctx, 17);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001B\u01f9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001#\b\u0001\n\u0001\f\u0001"+
		"&\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002.\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u00023\b\u0002\n\u0002\f\u00026\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002>\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002C\b\u0002\n\u0002\f\u0002"+
		"F\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"L\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002Q\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002V\b\u0002\n\u0002\f\u0002Y\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0004\u0002]\b\u0002\u000b\u0002\f\u0002"+
		"^\u0003\u0002a\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003k\b\u0003"+
		"\n\u0003\f\u0003n\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0004\u0003\u0086\b\u0003\u000b\u0003\f\u0003\u0087\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003\u008d\b\u0003\n\u0003\f\u0003\u0090\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"\u00a3\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u00a8\b"+
		"\u0003\u000b\u0003\f\u0003\u00a9\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u00b4"+
		"\b\u0003\u000b\u0003\f\u0003\u00b5\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0004\u0003\u00bd\b\u0003\u000b\u0003\f\u0003"+
		"\u00be\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00cb"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003\u00d2\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u00e0\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u00e6\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00ef"+
		"\b\u0004\n\u0004\f\u0004\u00f2\t\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u00f6\b\u0004\n\u0004\f\u0004\u00f9\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u00fe\b\u0004\n\u0004\f\u0004\u0101\t\u0004\u0001\u0004"+
		"\u0003\u0004\u0104\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u010a\b\u0005\n\u0005\f\u0005\u010d\t\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u0111\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u0115"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u011e\b\u0006\u0001\u0006\u0001\u0006\u0004"+
		"\u0006\u0122\b\u0006\u000b\u0006\f\u0006\u0123\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0004\u0006\u012e\b\u0006\u000b\u0006\f\u0006\u012f\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0136\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0143\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u014d\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u0153\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u015b\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u015f\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u018e\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u0197\b\b\n\b\f\b\u019a\t\b\u0001\t\u0001\t"+
		"\u0001\t\u0005\t\u019f\b\t\n\t\f\t\u01a2\t\t\u0001\n\u0001\n\u0003\n\u01a6"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u01ac\b\n\u0001\n\u0005\n"+
		"\u01af\b\n\n\n\f\n\u01b2\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u01c0\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u01cb\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u01ea\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u01f2"+
		"\b\u000b\n\u000b\f\u000b\u01f5\t\u000b\u0001\f\u0001\f\u0001\f\u0000\u0001"+
		"\u0016\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u0000\b\u0001\u0000/0\u0001\u000067\u0001\u000045\u0001\u0000&\'\u0001"+
		"\u0000()\u0001\u0000*+\u0001\u0000,-\u0001\u0000\u0003\u0007\u0248\u0000"+
		"\u001a\u0001\u0000\u0000\u0000\u0002\u001d\u0001\u0000\u0000\u0000\u0004"+
		"`\u0001\u0000\u0000\u0000\u0006\u00e5\u0001\u0000\u0000\u0000\b\u00f7"+
		"\u0001\u0000\u0000\u0000\n\u0105\u0001\u0000\u0000\u0000\f\u015e\u0001"+
		"\u0000\u0000\u0000\u000e\u018d\u0001\u0000\u0000\u0000\u0010\u018f\u0001"+
		"\u0000\u0000\u0000\u0012\u019b\u0001\u0000\u0000\u0000\u0014\u01a5\u0001"+
		"\u0000\u0000\u0000\u0016\u01ca\u0001\u0000\u0000\u0000\u0018\u01f6\u0001"+
		"\u0000\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000\u001b\u001c\u0005"+
		"\u0000\u0000\u0001\u001c\u0001\u0001\u0000\u0000\u0000\u001d\u001e\u0005"+
		"\u0001\u0000\u0000\u001e\u001f\u0005\u0002\u0000\u0000\u001f \u0005:\u0000"+
		"\u0000 $\u0005\u001d\u0000\u0000!#\u0003\u0004\u0002\u0000\"!\u0001\u0000"+
		"\u0000\u0000#&\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001"+
		"\u0000\u0000\u0000%\'\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000"+
		"\'(\u0005\u001e\u0000\u0000(\u0003\u0001\u0000\u0000\u0000)*\u0005\u0001"+
		"\u0000\u0000*+\u0005:\u0000\u0000+-\u0005\u001b\u0000\u0000,.\u0003\u0014"+
		"\n\u0000-,\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0001\u0000"+
		"\u0000\u0000/0\u0005\u001c\u0000\u000004\u0005\u001d\u0000\u000013\u0003"+
		"\u0006\u0003\u000021\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000\u0000"+
		"\u000064\u0001\u0000\u0000\u00007a\u0005\u001e\u0000\u000089\u0005\u0001"+
		"\u0000\u00009:\u0005\b\u0000\u0000:;\u0005:\u0000\u0000;=\u0005\u001b"+
		"\u0000\u0000<>\u0003\u0014\n\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000"+
		"\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0005\u001c\u0000\u0000@D\u0005"+
		"\u001d\u0000\u0000AC\u0003\u0006\u0003\u0000BA\u0001\u0000\u0000\u0000"+
		"CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EG\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000Ga\u0005\u001e"+
		"\u0000\u0000HK\u0005\u0001\u0000\u0000IL\u0003\u0018\f\u0000JL\u0005:"+
		"\u0000\u0000KI\u0001\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MN\u0005:\u0000\u0000NP\u0005\u001b\u0000\u0000OQ\u0003"+
		"\u0014\n\u0000PO\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000RS\u0005\u001c\u0000\u0000SW\u0005\u001d\u0000\u0000"+
		"TV\u0003\u0006\u0003\u0000UT\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000Za\u0005\u001e\u0000\u0000[]\u0003"+
		"\f\u0006\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\"+
		"\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000"+
		"\u0000`)\u0001\u0000\u0000\u0000`8\u0001\u0000\u0000\u0000`H\u0001\u0000"+
		"\u0000\u0000`\\\u0001\u0000\u0000\u0000a\u0005\u0001\u0000\u0000\u0000"+
		"b\u00e6\u0003\f\u0006\u0000c\u00e6\u0003\u000e\u0007\u0000de\u0005\u000b"+
		"\u0000\u0000ef\u0005\u001b\u0000\u0000fg\u0003\u0016\u000b\u0000gh\u0005"+
		"\u001c\u0000\u0000hl\u0005\u001d\u0000\u0000ik\u0003\u0006\u0003\u0000"+
		"ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000"+
		"\u0000\u0000op\u0005\u001e\u0000\u0000pq\u0003\b\u0004\u0000q\u00e6\u0001"+
		"\u0000\u0000\u0000rs\u0005\u000b\u0000\u0000st\u0005\u001b\u0000\u0000"+
		"tu\u0003\u0016\u000b\u0000uv\u0005\u001c\u0000\u0000vw\u0003\u0006\u0003"+
		"\u0000w\u00e6\u0001\u0000\u0000\u0000xy\u0005\u000b\u0000\u0000yz\u0005"+
		"\u001b\u0000\u0000z{\u0003\u0016\u000b\u0000{|\u0005\u001c\u0000\u0000"+
		"|}\u0003\u0006\u0003\u0000}~\u0005\f\u0000\u0000~\u007f\u0003\u0006\u0003"+
		"\u0000\u007f\u00e6\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u000f\u0000"+
		"\u0000\u0081\u0082\u0005\u001b\u0000\u0000\u0082\u0083\u0005:\u0000\u0000"+
		"\u0083\u0085\u0005\u001c\u0000\u0000\u0084\u0086\u0003\n\u0005\u0000\u0085"+
		"\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u0011\u0000\u0000\u008a"+
		"\u008e\u0005\"\u0000\u0000\u008b\u008d\u0003\u0006\u0003\u0000\u008c\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091"+
		"\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005\u0012\u0000\u0000\u0092\u0093\u0005\u001f\u0000\u0000\u0093\u00e6"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u0013\u0000\u0000\u0095\u00a2"+
		"\u0005\u001b\u0000\u0000\u0096\u0097\u0003\u0018\f\u0000\u0097\u0098\u0005"+
		":\u0000\u0000\u0098\u0099\u00059\u0000\u0000\u0099\u009a\u0003\u0016\u000b"+
		"\u0000\u009a\u009b\u0005\u001f\u0000\u0000\u009b\u009c\u0003\u0016\u000b"+
		"\u0000\u009c\u009d\u0005\u001f\u0000\u0000\u009d\u009e\u0005:\u0000\u0000"+
		"\u009e\u009f\u0007\u0000\u0000\u0000\u009f\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0005\u001f\u0000\u0000\u00a1\u00a3\u0005\u001f\u0000\u0000"+
		"\u00a2\u0096\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\u001c\u0000\u0000"+
		"\u00a5\u00a7\u0005\u001d\u0000\u0000\u00a6\u00a8\u0003\u0006\u0003\u0000"+
		"\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u001e\u0000\u0000"+
		"\u00ac\u00e6\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0015\u0000\u0000"+
		"\u00ae\u00af\u0005\u001b\u0000\u0000\u00af\u00b0\u0003\u0016\u000b\u0000"+
		"\u00b0\u00b1\u0005\u001c\u0000\u0000\u00b1\u00b3\u0005\u001d\u0000\u0000"+
		"\u00b2\u00b4\u0003\u0006\u0003\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0005\u001e\u0000\u0000\u00b8\u00e6\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0005\u0016\u0000\u0000\u00ba\u00bc\u0005\u001d\u0000\u0000"+
		"\u00bb\u00bd\u0003\u0006\u0003\u0000\u00bc\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000"+
		"\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c1\u0005\u001e\u0000\u0000\u00c1\u00c2\u0005\u0015\u0000\u0000"+
		"\u00c2\u00c3\u0005\u001b\u0000\u0000\u00c3\u00c4\u0003\u0016\u000b\u0000"+
		"\u00c4\u00c5\u0005\u001c\u0000\u0000\u00c5\u00c6\u0005\u001f\u0000\u0000"+
		"\u00c6\u00e6\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000"+
		"\u00c8\u00ca\u0005\u001b\u0000\u0000\u00c9\u00cb\u0003\u0016\u000b\u0000"+
		"\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u001c\u0000\u0000"+
		"\u00cd\u00e6\u0005\u001f\u0000\u0000\u00ce\u00cf\u0005\u0018\u0000\u0000"+
		"\u00cf\u00d1\u0005\u001b\u0000\u0000\u00d0\u00d2\u0003\u0016\u000b\u0000"+
		"\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u001c\u0000\u0000"+
		"\u00d4\u00e6\u0005\u001f\u0000\u0000\u00d5\u00d6\u0005\u0019\u0000\u0000"+
		"\u00d6\u00d7\u0005\u001b\u0000\u0000\u00d7\u00d8\u0005\u001c\u0000\u0000"+
		"\u00d8\u00e6\u0005\u001f\u0000\u0000\u00d9\u00da\u0005\u0012\u0000\u0000"+
		"\u00da\u00e6\u0005\u001f\u0000\u0000\u00db\u00dc\u0005\u0014\u0000\u0000"+
		"\u00dc\u00e6\u0005\u001f\u0000\u0000\u00dd\u00df\u0005\t\u0000\u0000\u00de"+
		"\u00e0\u0003\u0016\u000b\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e6\u0005\u001f\u0000\u0000\u00e2\u00e3\u0003\u0016\u000b\u0000\u00e3"+
		"\u00e4\u0005\u001f\u0000\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000\u00e5"+
		"b\u0001\u0000\u0000\u0000\u00e5c\u0001\u0000\u0000\u0000\u00e5d\u0001"+
		"\u0000\u0000\u0000\u00e5r\u0001\u0000\u0000\u0000\u00e5x\u0001\u0000\u0000"+
		"\u0000\u00e5\u0080\u0001\u0000\u0000\u0000\u00e5\u0094\u0001\u0000\u0000"+
		"\u0000\u00e5\u00ad\u0001\u0000\u0000\u0000\u00e5\u00b9\u0001\u0000\u0000"+
		"\u0000\u00e5\u00c7\u0001\u0000\u0000\u0000\u00e5\u00ce\u0001\u0000\u0000"+
		"\u0000\u00e5\u00d5\u0001\u0000\u0000\u0000\u00e5\u00d9\u0001\u0000\u0000"+
		"\u0000\u00e5\u00db\u0001\u0000\u0000\u0000\u00e5\u00dd\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e2\u0001\u0000\u0000\u0000\u00e6\u0007\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0005\f\u0000\u0000\u00e8\u00e9\u0005\u000b\u0000\u0000"+
		"\u00e9\u00ea\u0005\u001b\u0000\u0000\u00ea\u00eb\u0003\u0016\u000b\u0000"+
		"\u00eb\u00ec\u0005\u001c\u0000\u0000\u00ec\u00f0\u0005\u001d\u0000\u0000"+
		"\u00ed\u00ef\u0003\u0006\u0003\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005\u001e\u0000\u0000"+
		"\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5\u00e7\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f9\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u0103\u0001\u0000\u0000\u0000"+
		"\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005\f\u0000\u0000\u00fb"+
		"\u00ff\u0005\u001d\u0000\u0000\u00fc\u00fe\u0003\u0006\u0003\u0000\u00fd"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff"+
		"\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100"+
		"\u0102\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102"+
		"\u0104\u0005\u001e\u0000\u0000\u0103\u00fa\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0001\u0000\u0000\u0000\u0104\t\u0001\u0000\u0000\u0000\u0105\u0106"+
		"\u0005\u0010\u0000\u0000\u0106\u0107\u0003\u0016\u000b\u0000\u0107\u010b"+
		"\u0005\"\u0000\u0000\u0108\u010a\u0003\u0006\u0003\u0000\u0109\u0108\u0001"+
		"\u0000\u0000\u0000\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u0110\u0001"+
		"\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u010f\u0005"+
		"\u0012\u0000\u0000\u010f\u0111\u0005\u001f\u0000\u0000\u0110\u010e\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u000b\u0001"+
		"\u0000\u0000\u0000\u0112\u0115\u0003\u0018\f\u0000\u0113\u0115\u0005:"+
		"\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0113\u0001\u0000"+
		"\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0117\u0005:\u0000"+
		"\u0000\u0117\u0118\u00059\u0000\u0000\u0118\u0119\u0003\u0016\u000b\u0000"+
		"\u0119\u011a\u0005\u001f\u0000\u0000\u011a\u015f\u0001\u0000\u0000\u0000"+
		"\u011b\u011e\u0003\u0018\f\u0000\u011c\u011e\u0005:\u0000\u0000\u011d"+
		"\u011b\u0001\u0000\u0000\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011e"+
		"\u0121\u0001\u0000\u0000\u0000\u011f\u0120\u0005$\u0000\u0000\u0120\u0122"+
		"\u0005%\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0122\u0123\u0001"+
		"\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0123\u0124\u0001"+
		"\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0126\u0005"+
		":\u0000\u0000\u0126\u0127\u00059\u0000\u0000\u0127\u0128\u0005\n\u0000"+
		"\u0000\u0128\u012d\u0003\u0018\f\u0000\u0129\u012a\u0005$\u0000\u0000"+
		"\u012a\u012b\u0003\u0016\u000b\u0000\u012b\u012c\u0005%\u0000\u0000\u012c"+
		"\u012e\u0001\u0000\u0000\u0000\u012d\u0129\u0001\u0000\u0000\u0000\u012e"+
		"\u012f\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f"+
		"\u0130\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131"+
		"\u0132\u0005\u001f\u0000\u0000\u0132\u015f\u0001\u0000\u0000\u0000\u0133"+
		"\u0136\u0003\u0018\f\u0000\u0134\u0136\u0005:\u0000\u0000\u0135\u0133"+
		"\u0001\u0000\u0000\u0000\u0135\u0134\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\u0001\u0000\u0000\u0000\u0137\u0138\u0005$\u0000\u0000\u0138\u0139\u0005"+
		"%\u0000\u0000\u0139\u013a\u0005:\u0000\u0000\u013a\u013b\u00059\u0000"+
		"\u0000\u013b\u013c\u0005\u001d\u0000\u0000\u013c\u013d\u0003\u0012\t\u0000"+
		"\u013d\u013e\u0005\u001e\u0000\u0000\u013e\u013f\u0005\u001f\u0000\u0000"+
		"\u013f\u015f\u0001\u0000\u0000\u0000\u0140\u0143\u0003\u0018\f\u0000\u0141"+
		"\u0143\u0005:\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0142\u0141"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0145"+
		"\u0005:\u0000\u0000\u0145\u015f\u0005\u001f\u0000\u0000\u0146\u0147\u0005"+
		":\u0000\u0000\u0147\u0148\u00059\u0000\u0000\u0148\u0149\u0005\n\u0000"+
		"\u0000\u0149\u014a\u0005:\u0000\u0000\u014a\u014c\u0005\u001b\u0000\u0000"+
		"\u014b\u014d\u0003\u0012\t\u0000\u014c\u014b\u0001\u0000\u0000\u0000\u014c"+
		"\u014d\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e"+
		"\u014f\u0005\u001c\u0000\u0000\u014f\u015f\u0005\u001f\u0000\u0000\u0150"+
		"\u0153\u0003\u0018\f\u0000\u0151\u0153\u0005:\u0000\u0000\u0152\u0150"+
		"\u0001\u0000\u0000\u0000\u0152\u0151\u0001\u0000\u0000\u0000\u0153\u0154"+
		"\u0001\u0000\u0000\u0000\u0154\u0155\u0005:\u0000\u0000\u0155\u0156\u0005"+
		"9\u0000\u0000\u0156\u0157\u0005\n\u0000\u0000\u0157\u0158\u0005:\u0000"+
		"\u0000\u0158\u015a\u0005\u001b\u0000\u0000\u0159\u015b\u0003\u0012\t\u0000"+
		"\u015a\u0159\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000"+
		"\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u015d\u0005\u001c\u0000\u0000"+
		"\u015d\u015f\u0005\u001f\u0000\u0000\u015e\u0114\u0001\u0000\u0000\u0000"+
		"\u015e\u011d\u0001\u0000\u0000\u0000\u015e\u0135\u0001\u0000\u0000\u0000"+
		"\u015e\u0142\u0001\u0000\u0000\u0000\u015e\u0146\u0001\u0000\u0000\u0000"+
		"\u015e\u0152\u0001\u0000\u0000\u0000\u015f\r\u0001\u0000\u0000\u0000\u0160"+
		"\u0161\u0005:\u0000\u0000\u0161\u0162\u00051\u0000\u0000\u0162\u0163\u0003"+
		"\u0016\u000b\u0000\u0163\u0164\u0005\u001f\u0000\u0000\u0164\u018e\u0001"+
		"\u0000\u0000\u0000\u0165\u0166\u0005:\u0000\u0000\u0166\u0167\u00052\u0000"+
		"\u0000\u0167\u0168\u0003\u0016\u000b\u0000\u0168\u0169\u0005\u001f\u0000"+
		"\u0000\u0169\u018e\u0001\u0000\u0000\u0000\u016a\u016b\u0005:\u0000\u0000"+
		"\u016b\u016c\u00053\u0000\u0000\u016c\u016d\u0003\u0016\u000b\u0000\u016d"+
		"\u016e\u0005\u001f\u0000\u0000\u016e\u018e\u0001\u0000\u0000\u0000\u016f"+
		"\u0170\u0005:\u0000\u0000\u0170\u0171\u00059\u0000\u0000\u0171\u0172\u0005"+
		"\u001b\u0000\u0000\u0172\u0173\u0003\u0016\u000b\u0000\u0173\u0174\u0005"+
		"\u001c\u0000\u0000\u0174\u0175\u0005!\u0000\u0000\u0175\u0176\u0003\u0016"+
		"\u000b\u0000\u0176\u0177\u0005\"\u0000\u0000\u0177\u0178\u0003\u0016\u000b"+
		"\u0000\u0178\u0179\u0005\u001f\u0000\u0000\u0179\u018e\u0001\u0000\u0000"+
		"\u0000\u017a\u017b\u0005:\u0000\u0000\u017b\u017c\u0005$\u0000\u0000\u017c"+
		"\u017d\u0003\u0016\u000b\u0000\u017d\u017e\u0005%\u0000\u0000\u017e\u017f"+
		"\u00059\u0000\u0000\u017f\u0180\u0003\u0016\u000b\u0000\u0180\u0181\u0005"+
		"\u001f\u0000\u0000\u0181\u018e\u0001\u0000\u0000\u0000\u0182\u0183\u0003"+
		"\u0010\b\u0000\u0183\u0184\u00059\u0000\u0000\u0184\u0185\u0003\u0016"+
		"\u000b\u0000\u0185\u0186\u0005\u001f\u0000\u0000\u0186\u018e\u0001\u0000"+
		"\u0000\u0000\u0187\u0188\u0005:\u0000\u0000\u0188\u0189\u0005/\u0000\u0000"+
		"\u0189\u018e\u0005\u001f\u0000\u0000\u018a\u018b\u0005:\u0000\u0000\u018b"+
		"\u018c\u00050\u0000\u0000\u018c\u018e\u0005\u001f\u0000\u0000\u018d\u0160"+
		"\u0001\u0000\u0000\u0000\u018d\u0165\u0001\u0000\u0000\u0000\u018d\u016a"+
		"\u0001\u0000\u0000\u0000\u018d\u016f\u0001\u0000\u0000\u0000\u018d\u017a"+
		"\u0001\u0000\u0000\u0000\u018d\u0182\u0001\u0000\u0000\u0000\u018d\u0187"+
		"\u0001\u0000\u0000\u0000\u018d\u018a\u0001\u0000\u0000\u0000\u018e\u000f"+
		"\u0001\u0000\u0000\u0000\u018f\u0198\u0005:\u0000\u0000\u0190\u0191\u0005"+
		"#\u0000\u0000\u0191\u0197\u0005:\u0000\u0000\u0192\u0193\u0005$\u0000"+
		"\u0000\u0193\u0194\u0003\u0016\u000b\u0000\u0194\u0195\u0005%\u0000\u0000"+
		"\u0195\u0197\u0001\u0000\u0000\u0000\u0196\u0190\u0001\u0000\u0000\u0000"+
		"\u0196\u0192\u0001\u0000\u0000\u0000\u0197\u019a\u0001\u0000\u0000\u0000"+
		"\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000"+
		"\u0199\u0011\u0001\u0000\u0000\u0000\u019a\u0198\u0001\u0000\u0000\u0000"+
		"\u019b\u01a0\u0003\u0016\u000b\u0000\u019c\u019d\u0005 \u0000\u0000\u019d"+
		"\u019f\u0003\u0016\u000b\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019f"+
		"\u01a2\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a0"+
		"\u01a1\u0001\u0000\u0000\u0000\u01a1\u0013\u0001\u0000\u0000\u0000\u01a2"+
		"\u01a0\u0001\u0000\u0000\u0000\u01a3\u01a6\u0003\u0018\f\u0000\u01a4\u01a6"+
		"\u0005:\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a4\u0001"+
		"\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7\u01b0\u0003"+
		"\u0016\u000b\u0000\u01a8\u01ab\u0005 \u0000\u0000\u01a9\u01ac\u0003\u0018"+
		"\f\u0000\u01aa\u01ac\u0005:\u0000\u0000\u01ab\u01a9\u0001\u0000\u0000"+
		"\u0000\u01ab\u01aa\u0001\u0000\u0000\u0000\u01ac\u01ad\u0001\u0000\u0000"+
		"\u0000\u01ad\u01af\u0003\u0016\u000b\u0000\u01ae\u01a8\u0001\u0000\u0000"+
		"\u0000\u01af\u01b2\u0001\u0000\u0000\u0000\u01b0\u01ae\u0001\u0000\u0000"+
		"\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000\u01b1\u0015\u0001\u0000\u0000"+
		"\u0000\u01b2\u01b0\u0001\u0000\u0000\u0000\u01b3\u01b4\u0006\u000b\uffff"+
		"\uffff\u0000\u01b4\u01b5\u00055\u0000\u0000\u01b5\u01cb\u0003\u0016\u000b"+
		"\u0016\u01b6\u01b7\u0005.\u0000\u0000\u01b7\u01cb\u0003\u0016\u000b\u0015"+
		"\u01b8\u01b9\u0005\u001b\u0000\u0000\u01b9\u01ba\u0003\u0016\u000b\u0000"+
		"\u01ba\u01bb\u0005\u001c\u0000\u0000\u01bb\u01cb\u0001\u0000\u0000\u0000"+
		"\u01bc\u01bd\u0005:\u0000\u0000\u01bd\u01bf\u0005\u001b\u0000\u0000\u01be"+
		"\u01c0\u0003\u0012\t\u0000\u01bf\u01be\u0001\u0000\u0000\u0000\u01bf\u01c0"+
		"\u0001\u0000\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01cb"+
		"\u0005\u001c\u0000\u0000\u01c2\u01cb\u0005\r\u0000\u0000\u01c3\u01cb\u0005"+
		"\u000e\u0000\u0000\u01c4\u01cb\u0005\u001a\u0000\u0000\u01c5\u01cb\u0005"+
		":\u0000\u0000\u01c6\u01cb\u0005<\u0000\u0000\u01c7\u01cb\u0005;\u0000"+
		"\u0000\u01c8\u01cb\u0005>\u0000\u0000\u01c9\u01cb\u0005=\u0000\u0000\u01ca"+
		"\u01b3\u0001\u0000\u0000\u0000\u01ca\u01b6\u0001\u0000\u0000\u0000\u01ca"+
		"\u01b8\u0001\u0000\u0000\u0000\u01ca\u01bc\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c2\u0001\u0000\u0000\u0000\u01ca\u01c3\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c4\u0001\u0000\u0000\u0000\u01ca\u01c5\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c6\u0001\u0000\u0000\u0000\u01ca\u01c7\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c8\u0001\u0000\u0000\u0000\u01ca\u01c9\u0001\u0000\u0000\u0000\u01cb"+
		"\u01f3\u0001\u0000\u0000\u0000\u01cc\u01cd\n\u0010\u0000\u0000\u01cd\u01ce"+
		"\u0007\u0001\u0000\u0000\u01ce\u01f2\u0003\u0016\u000b\u0011\u01cf\u01d0"+
		"\n\u000f\u0000\u0000\u01d0\u01d1\u00058\u0000\u0000\u01d1\u01f2\u0003"+
		"\u0016\u000b\u0010\u01d2\u01d3\n\u000e\u0000\u0000\u01d3\u01d4\u0007\u0002"+
		"\u0000\u0000\u01d4\u01f2\u0003\u0016\u000b\u000f\u01d5\u01d6\n\r\u0000"+
		"\u0000\u01d6\u01d7\u0007\u0003\u0000\u0000\u01d7\u01f2\u0003\u0016\u000b"+
		"\u000e\u01d8\u01d9\n\f\u0000\u0000\u01d9\u01da\u0007\u0004\u0000\u0000"+
		"\u01da\u01f2\u0003\u0016\u000b\r\u01db\u01dc\n\u000b\u0000\u0000\u01dc"+
		"\u01dd\u0007\u0005\u0000\u0000\u01dd\u01f2\u0003\u0016\u000b\f\u01de\u01df"+
		"\n\n\u0000\u0000\u01df\u01e0\u0007\u0006\u0000\u0000\u01e0\u01f2\u0003"+
		"\u0016\u000b\u000b\u01e1\u01e2\n\u0013\u0000\u0000\u01e2\u01e3\u0005#"+
		"\u0000\u0000\u01e3\u01f2\u0005:\u0000\u0000\u01e4\u01e5\n\u0012\u0000"+
		"\u0000\u01e5\u01e6\u0005#\u0000\u0000\u01e6\u01e7\u0005:\u0000\u0000\u01e7"+
		"\u01e9\u0005\u001b\u0000\u0000\u01e8\u01ea\u0003\u0012\t\u0000\u01e9\u01e8"+
		"\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000\u0000\u01ea\u01eb"+
		"\u0001\u0000\u0000\u0000\u01eb\u01f2\u0005\u001c\u0000\u0000\u01ec\u01ed"+
		"\n\u0011\u0000\u0000\u01ed\u01ee\u0005$\u0000\u0000\u01ee\u01ef\u0003"+
		"\u0016\u000b\u0000\u01ef\u01f0\u0005%\u0000\u0000\u01f0\u01f2\u0001\u0000"+
		"\u0000\u0000\u01f1\u01cc\u0001\u0000\u0000\u0000\u01f1\u01cf\u0001\u0000"+
		"\u0000\u0000\u01f1\u01d2\u0001\u0000\u0000\u0000\u01f1\u01d5\u0001\u0000"+
		"\u0000\u0000\u01f1\u01d8\u0001\u0000\u0000\u0000\u01f1\u01db\u0001\u0000"+
		"\u0000\u0000\u01f1\u01de\u0001\u0000\u0000\u0000\u01f1\u01e1\u0001\u0000"+
		"\u0000\u0000\u01f1\u01e4\u0001\u0000\u0000\u0000\u01f1\u01ec\u0001\u0000"+
		"\u0000\u0000\u01f2\u01f5\u0001\u0000\u0000\u0000\u01f3\u01f1\u0001\u0000"+
		"\u0000\u0000\u01f3\u01f4\u0001\u0000\u0000\u0000\u01f4\u0017\u0001\u0000"+
		"\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f6\u01f7\u0007\u0007"+
		"\u0000\u0000\u01f7\u0019\u0001\u0000\u0000\u00001$-4=DKPW^`l\u0087\u008e"+
		"\u00a2\u00a9\u00b5\u00be\u00ca\u00d1\u00df\u00e5\u00f0\u00f7\u00ff\u0103"+
		"\u010b\u0110\u0114\u011d\u0123\u012f\u0135\u0142\u014c\u0152\u015a\u015e"+
		"\u018d\u0196\u0198\u01a0\u01a5\u01ab\u01b0\u01bf\u01ca\u01e9\u01f1\u01f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}