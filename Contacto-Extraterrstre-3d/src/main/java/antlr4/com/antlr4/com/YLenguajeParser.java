// Generated from src/main/java/antlr4/com/YLenguajeParser.g4 by ANTLR 4.13.2
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
public class YLenguajeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, ESTRUCTURAS=3, ESTRUCTURA=4, CADENA=5, ENTERO=6, FLOTANTE=7, 
		CARACTER=8, BOOL=9, FUNCIONES=10, DEFINIR=11, SI=12, ENTONCES=13, SINO=14, 
		CONTRARIO=15, ELEGITR=16, CASO=17, ROMPER=18, PARA=19, CONTINUAR=20, MIENTRAS=21, 
		HACER=22, IMPRIMIR=23, LEER=24, VERDADERO=25, FALSO=26, RETORNAR=27, RETORNO_FUNC=28, 
		DOS_PUNTOS=29, LCORCH=30, RCORCH=31, LPAREN=32, RPAREN=33, COMA=34, LLLAVE=35, 
		RLLAVE=36, PUNTO=37, PUNTO_COMA=38, IGUAL=39, NO_IGUAL=40, MENOR_IGUAL=41, 
		MAYOR_IGUAL=42, MENOR=43, MAYOR=44, AND=45, OR=46, NOT=47, INCREMENTO=48, 
		DECREMENTO=49, ASIG=50, SUMA=51, RESTA=52, MULT=53, DIV=54, ID=55, INT=56, 
		DECIMAL=57, STRING=58, CHAR=59, LINE_COMMENT=60, BLOCK_COMMENT=61, NEWLINE=62, 
		WS=63;
	public static final int
		RULE_inicio = 0, RULE_bloq_estruc = 1, RULE_esctruc = 2, RULE_bloq_func = 3, 
		RULE_bloc_func = 4, RULE_params = 5, RULE_bloc_llaves = 6, RULE_val_arreglo = 7, 
		RULE_instrucciones = 8, RULE_bloc_si = 9, RULE_bloque = 10, RULE_definiciones = 11, 
		RULE_asignaciones = 12, RULE_expresion = 13, RULE_tipos = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "bloq_estruc", "esctruc", "bloq_func", "bloc_func", "params", 
			"bloc_llaves", "val_arreglo", "instrucciones", "bloc_si", "bloque", "definiciones", 
			"asignaciones", "expresion", "tipos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'%estructuras'", "'estructura'", "'cadena'", "'entero'", 
			"'flotante'", "'caracter'", "'bool'", "'%funciones'", "'definir'", "'si'", 
			"'entonces'", "'sino'", "'contrario'", "'elegir'", "'caso'", "'romper'", 
			"'para'", "'continuar'", "'mientras'", "'hacer'", "'imprimir'", "'leer'", 
			"'verdadero'", "'falso'", "'retornar'", "'->'", "':'", "'['", "']'", 
			"'('", "')'", "','", "'{'", "'}'", "'.'", "';'", "'=='", "'!='", "'<='", 
			"'>='", "'<'", "'>'", "'&&'", "'||'", "'!'", "'++'", "'--'", "'='", "'+'", 
			"'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "ESTRUCTURAS", "ESTRUCTURA", "CADENA", "ENTERO", 
			"FLOTANTE", "CARACTER", "BOOL", "FUNCIONES", "DEFINIR", "SI", "ENTONCES", 
			"SINO", "CONTRARIO", "ELEGITR", "CASO", "ROMPER", "PARA", "CONTINUAR", 
			"MIENTRAS", "HACER", "IMPRIMIR", "LEER", "VERDADERO", "FALSO", "RETORNAR", 
			"RETORNO_FUNC", "DOS_PUNTOS", "LCORCH", "RCORCH", "LPAREN", "RPAREN", 
			"COMA", "LLLAVE", "RLLAVE", "PUNTO", "PUNTO_COMA", "IGUAL", "NO_IGUAL", 
			"MENOR_IGUAL", "MAYOR_IGUAL", "MENOR", "MAYOR", "AND", "OR", "NOT", "INCREMENTO", 
			"DECREMENTO", "ASIG", "SUMA", "RESTA", "MULT", "DIV", "ID", "INT", "DECIMAL", 
			"STRING", "CHAR", "LINE_COMMENT", "BLOCK_COMMENT", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "YLenguajeParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public YLenguajeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicioContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(YLenguajeParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YLenguajeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YLenguajeParser.NEWLINE, i);
		}
		public Bloq_estrucContext bloq_estruc() {
			return getRuleContext(Bloq_estrucContext.class,0);
		}
		public Bloq_funcContext bloq_func() {
			return getRuleContext(Bloq_funcContext.class,0);
		}
		public InicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterInicio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitInicio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitInicio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicioContext inicio() throws RecognitionException {
		InicioContext _localctx = new InicioContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_inicio);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(30);
					match(NEWLINE);
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ESTRUCTURAS) {
				{
				setState(36);
				bloq_estruc();
				}
			}

			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNCIONES) {
				{
				setState(39);
				bloq_func();
				}
			}

			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(42);
				match(NEWLINE);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
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
	public static class Bloq_estrucContext extends ParserRuleContext {
		public TerminalNode ESTRUCTURAS() { return getToken(YLenguajeParser.ESTRUCTURAS, 0); }
		public TerminalNode NEWLINE() { return getToken(YLenguajeParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YLenguajeParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YLenguajeParser.DEDENT, 0); }
		public List<EsctrucContext> esctruc() {
			return getRuleContexts(EsctrucContext.class);
		}
		public EsctrucContext esctruc(int i) {
			return getRuleContext(EsctrucContext.class,i);
		}
		public Bloq_estrucContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloq_estruc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterBloq_estruc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitBloq_estruc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitBloq_estruc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloq_estrucContext bloq_estruc() throws RecognitionException {
		Bloq_estrucContext _localctx = new Bloq_estrucContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloq_estruc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(ESTRUCTURAS);
			setState(51);
			match(NEWLINE);
			setState(52);
			match(INDENT);
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(53);
				esctruc();
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ESTRUCTURA );
			setState(58);
			match(DEDENT);
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
	public static class EsctrucContext extends ParserRuleContext {
		public TerminalNode ESTRUCTURA() { return getToken(YLenguajeParser.ESTRUCTURA, 0); }
		public TerminalNode ID() { return getToken(YLenguajeParser.ID, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(YLenguajeParser.DOS_PUNTOS, 0); }
		public TerminalNode NEWLINE() { return getToken(YLenguajeParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YLenguajeParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YLenguajeParser.DEDENT, 0); }
		public List<DefinicionesContext> definiciones() {
			return getRuleContexts(DefinicionesContext.class);
		}
		public DefinicionesContext definiciones(int i) {
			return getRuleContext(DefinicionesContext.class,i);
		}
		public EsctrucContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_esctruc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterEsctruc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitEsctruc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitEsctruc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EsctrucContext esctruc() throws RecognitionException {
		EsctrucContext _localctx = new EsctrucContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_esctruc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(ESTRUCTURA);
			setState(61);
			match(ID);
			setState(62);
			match(DOS_PUNTOS);
			setState(63);
			match(NEWLINE);
			setState(64);
			match(INDENT);
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				definiciones();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36028797018964960L) != 0) );
			setState(70);
			match(DEDENT);
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
	public static class Bloq_funcContext extends ParserRuleContext {
		public TerminalNode FUNCIONES() { return getToken(YLenguajeParser.FUNCIONES, 0); }
		public TerminalNode NEWLINE() { return getToken(YLenguajeParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YLenguajeParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YLenguajeParser.DEDENT, 0); }
		public List<Bloc_funcContext> bloc_func() {
			return getRuleContexts(Bloc_funcContext.class);
		}
		public Bloc_funcContext bloc_func(int i) {
			return getRuleContext(Bloc_funcContext.class,i);
		}
		public Bloq_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloq_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterBloq_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitBloq_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitBloq_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloq_funcContext bloq_func() throws RecognitionException {
		Bloq_funcContext _localctx = new Bloq_funcContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bloq_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(FUNCIONES);
			setState(73);
			match(NEWLINE);
			setState(74);
			match(INDENT);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				bloc_func();
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DEFINIR );
			setState(80);
			match(DEDENT);
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
	public static class Bloc_funcContext extends ParserRuleContext {
		public TerminalNode DEFINIR() { return getToken(YLenguajeParser.DEFINIR, 0); }
		public List<TerminalNode> ID() { return getTokens(YLenguajeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(YLenguajeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(YLenguajeParser.RPAREN, 0); }
		public TerminalNode RETORNO_FUNC() { return getToken(YLenguajeParser.RETORNO_FUNC, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(YLenguajeParser.DOS_PUNTOS, 0); }
		public TerminalNode NEWLINE() { return getToken(YLenguajeParser.NEWLINE, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Bloc_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterBloc_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitBloc_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitBloc_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloc_funcContext bloc_func() throws RecognitionException {
		Bloc_funcContext _localctx = new Bloc_funcContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloc_func);
		int _la;
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				match(DEFINIR);
				setState(83);
				match(ID);
				setState(84);
				match(LPAREN);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36028797018964960L) != 0)) {
					{
					setState(85);
					params();
					}
				}

				setState(88);
				match(RPAREN);
				setState(89);
				match(RETORNO_FUNC);
				setState(92);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(90);
					tipos();
					}
					break;
				case ID:
					{
					setState(91);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(94);
				match(DOS_PUNTOS);
				setState(95);
				match(NEWLINE);
				setState(96);
				bloque();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(DEFINIR);
				setState(98);
				match(ID);
				setState(99);
				match(LPAREN);
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36028797018964960L) != 0)) {
					{
					setState(100);
					params();
					}
				}

				setState(103);
				match(RPAREN);
				setState(104);
				match(DOS_PUNTOS);
				setState(105);
				match(NEWLINE);
				setState(106);
				bloque();
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
	public static class ParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(YLenguajeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParser.ID, i);
		}
		public List<TiposContext> tipos() {
			return getRuleContexts(TiposContext.class);
		}
		public TiposContext tipos(int i) {
			return getRuleContext(TiposContext.class,i);
		}
		public List<TerminalNode> LCORCH() { return getTokens(YLenguajeParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(YLenguajeParser.LCORCH, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(YLenguajeParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(YLenguajeParser.RCORCH, i);
		}
		public List<TerminalNode> COMA() { return getTokens(YLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(YLenguajeParser.COMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CADENA:
			case ENTERO:
			case FLOTANTE:
			case CARACTER:
			case BOOL:
				{
				setState(109);
				tipos();
				}
				break;
			case ID:
				{
				setState(110);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(113);
			match(ID);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LCORCH) {
				{
				{
				setState(114);
				match(LCORCH);
				setState(115);
				expresion(0);
				setState(116);
				match(RCORCH);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(123);
				match(COMA);
				setState(126);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(124);
					tipos();
					}
					break;
				case ID:
					{
					setState(125);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(128);
				match(ID);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LCORCH) {
					{
					{
					setState(129);
					match(LCORCH);
					setState(130);
					expresion(0);
					setState(131);
					match(RCORCH);
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(142);
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
	public static class Bloc_llavesContext extends ParserRuleContext {
		public List<TerminalNode> LLLAVE() { return getTokens(YLenguajeParser.LLLAVE); }
		public TerminalNode LLLAVE(int i) {
			return getToken(YLenguajeParser.LLLAVE, i);
		}
		public List<Val_arregloContext> val_arreglo() {
			return getRuleContexts(Val_arregloContext.class);
		}
		public Val_arregloContext val_arreglo(int i) {
			return getRuleContext(Val_arregloContext.class,i);
		}
		public List<TerminalNode> RLLAVE() { return getTokens(YLenguajeParser.RLLAVE); }
		public TerminalNode RLLAVE(int i) {
			return getToken(YLenguajeParser.RLLAVE, i);
		}
		public List<TerminalNode> COMA() { return getTokens(YLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(YLenguajeParser.COMA, i);
		}
		public Bloc_llavesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc_llaves; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterBloc_llaves(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitBloc_llaves(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitBloc_llaves(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloc_llavesContext bloc_llaves() throws RecognitionException {
		Bloc_llavesContext _localctx = new Bloc_llavesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bloc_llaves);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(LLLAVE);
			setState(144);
			val_arreglo();
			setState(145);
			match(RLLAVE);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(146);
				match(COMA);
				setState(147);
				match(LLLAVE);
				setState(148);
				val_arreglo();
				setState(149);
				match(RLLAVE);
				}
				}
				setState(155);
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
	public static class Val_arregloContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(YLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(YLenguajeParser.COMA, i);
		}
		public Val_arregloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val_arreglo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterVal_arreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitVal_arreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitVal_arreglo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Val_arregloContext val_arreglo() throws RecognitionException {
		Val_arregloContext _localctx = new Val_arregloContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_val_arreglo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			expresion(0);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(157);
				match(COMA);
				setState(158);
				expresion(0);
				}
				}
				setState(163);
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
	public static class InstruccionesContext extends ParserRuleContext {
		public DefinicionesContext definiciones() {
			return getRuleContext(DefinicionesContext.class,0);
		}
		public AsignacionesContext asignaciones() {
			return getRuleContext(AsignacionesContext.class,0);
		}
		public TerminalNode IMPRIMIR() { return getToken(YLenguajeParser.IMPRIMIR, 0); }
		public TerminalNode LPAREN() { return getToken(YLenguajeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(YLenguajeParser.RPAREN, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YLenguajeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YLenguajeParser.NEWLINE, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode SI() { return getToken(YLenguajeParser.SI, 0); }
		public TerminalNode ENTONCES() { return getToken(YLenguajeParser.ENTONCES, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Bloc_siContext bloc_si() {
			return getRuleContext(Bloc_siContext.class,0);
		}
		public TerminalNode MIENTRAS() { return getToken(YLenguajeParser.MIENTRAS, 0); }
		public TerminalNode HACER() { return getToken(YLenguajeParser.HACER, 0); }
		public List<TerminalNode> DOS_PUNTOS() { return getTokens(YLenguajeParser.DOS_PUNTOS); }
		public TerminalNode DOS_PUNTOS(int i) {
			return getToken(YLenguajeParser.DOS_PUNTOS, i);
		}
		public TerminalNode PARA() { return getToken(YLenguajeParser.PARA, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(YLenguajeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParser.ID, i);
		}
		public TerminalNode ASIG() { return getToken(YLenguajeParser.ASIG, 0); }
		public TerminalNode INCREMENTO() { return getToken(YLenguajeParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(YLenguajeParser.DECREMENTO, 0); }
		public TerminalNode RETORNAR() { return getToken(YLenguajeParser.RETORNAR, 0); }
		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterInstrucciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitInstrucciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitInstrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instrucciones);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				definiciones();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				asignaciones();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				match(IMPRIMIR);
				setState(167);
				match(LPAREN);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1121537049116016640L) != 0)) {
					{
					setState(168);
					expresion(0);
					}
				}

				setState(171);
				match(RPAREN);
				setState(172);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				match(SI);
				setState(174);
				match(LPAREN);
				setState(175);
				expresion(0);
				setState(176);
				match(RPAREN);
				setState(177);
				match(ENTONCES);
				setState(178);
				match(NEWLINE);
				setState(179);
				bloque();
				setState(180);
				bloc_si();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				match(MIENTRAS);
				setState(183);
				match(LPAREN);
				setState(184);
				expresion(0);
				setState(185);
				match(RPAREN);
				setState(186);
				match(HACER);
				setState(187);
				match(NEWLINE);
				setState(188);
				bloque();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(190);
				match(HACER);
				setState(191);
				match(DOS_PUNTOS);
				setState(192);
				match(NEWLINE);
				setState(193);
				bloque();
				setState(194);
				match(MIENTRAS);
				setState(195);
				match(LPAREN);
				setState(196);
				expresion(0);
				setState(197);
				match(RPAREN);
				setState(198);
				match(NEWLINE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(200);
				match(PARA);
				setState(201);
				match(LPAREN);
				setState(202);
				tipos();
				setState(203);
				match(ID);
				setState(204);
				match(ASIG);
				setState(205);
				expresion(0);
				setState(206);
				match(DOS_PUNTOS);
				setState(207);
				expresion(0);
				setState(208);
				match(DOS_PUNTOS);
				setState(209);
				match(ID);
				setState(210);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(211);
				match(RPAREN);
				setState(212);
				match(DOS_PUNTOS);
				setState(213);
				match(NEWLINE);
				setState(214);
				bloque();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(216);
				match(RETORNAR);
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1121537049116016640L) != 0)) {
					{
					setState(217);
					expresion(0);
					}
				}

				setState(220);
				match(NEWLINE);
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
	public static class Bloc_siContext extends ParserRuleContext {
		public List<TerminalNode> SINO() { return getTokens(YLenguajeParser.SINO); }
		public TerminalNode SINO(int i) {
			return getToken(YLenguajeParser.SINO, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(YLenguajeParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(YLenguajeParser.LPAREN, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(YLenguajeParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(YLenguajeParser.RPAREN, i);
		}
		public List<TerminalNode> ENTONCES() { return getTokens(YLenguajeParser.ENTONCES); }
		public TerminalNode ENTONCES(int i) {
			return getToken(YLenguajeParser.ENTONCES, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YLenguajeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YLenguajeParser.NEWLINE, i);
		}
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode CONTRARIO() { return getToken(YLenguajeParser.CONTRARIO, 0); }
		public Bloc_siContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc_si; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterBloc_si(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitBloc_si(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitBloc_si(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloc_siContext bloc_si() throws RecognitionException {
		Bloc_siContext _localctx = new Bloc_siContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bloc_si);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SINO) {
				{
				{
				setState(223);
				match(SINO);
				setState(224);
				match(LPAREN);
				setState(225);
				expresion(0);
				setState(226);
				match(RPAREN);
				setState(227);
				match(ENTONCES);
				setState(228);
				match(NEWLINE);
				setState(229);
				bloque();
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONTRARIO) {
				{
				setState(236);
				match(CONTRARIO);
				setState(237);
				match(NEWLINE);
				setState(238);
				bloque();
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
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode INDENT() { return getToken(YLenguajeParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YLenguajeParser.DEDENT, 0); }
		public List<InstruccionesContext> instrucciones() {
			return getRuleContexts(InstruccionesContext.class);
		}
		public InstruccionesContext instrucciones(int i) {
			return getRuleContext(InstruccionesContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(INDENT);
			setState(243); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(242);
				instrucciones();
				}
				}
				setState(245); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36028797168391136L) != 0) );
			setState(247);
			match(DEDENT);
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
	public static class DefinicionesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(YLenguajeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParser.ID, i);
		}
		public TerminalNode ASIG() { return getToken(YLenguajeParser.ASIG, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(YLenguajeParser.NEWLINE, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public Bloc_llavesContext bloc_llaves() {
			return getRuleContext(Bloc_llavesContext.class,0);
		}
		public List<TerminalNode> LCORCH() { return getTokens(YLenguajeParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(YLenguajeParser.LCORCH, i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(YLenguajeParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(YLenguajeParser.RCORCH, i);
		}
		public TerminalNode LLLAVE() { return getToken(YLenguajeParser.LLLAVE, 0); }
		public Val_arregloContext val_arreglo() {
			return getRuleContext(Val_arregloContext.class,0);
		}
		public TerminalNode RLLAVE() { return getToken(YLenguajeParser.RLLAVE, 0); }
		public DefinicionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definiciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterDefiniciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitDefiniciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitDefiniciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinicionesContext definiciones() throws RecognitionException {
		DefinicionesContext _localctx = new DefinicionesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_definiciones);
		int _la;
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(249);
					tipos();
					}
					break;
				case ID:
					{
					setState(250);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(253);
				match(ID);
				setState(254);
				match(ASIG);
				setState(255);
				expresion(0);
				setState(256);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(258);
					tipos();
					}
					break;
				case ID:
					{
					setState(259);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(262);
				match(ID);
				setState(267); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(263);
					match(LCORCH);
					setState(264);
					expresion(0);
					setState(265);
					match(RCORCH);
					}
					}
					setState(269); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(271);
				match(ASIG);
				setState(272);
				bloc_llaves();
				setState(273);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(277);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(275);
					tipos();
					}
					break;
				case ID:
					{
					setState(276);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(279);
				match(ID);
				setState(280);
				match(ASIG);
				setState(281);
				match(LLLAVE);
				setState(282);
				val_arreglo();
				setState(283);
				match(RLLAVE);
				setState(284);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(288);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(286);
					tipos();
					}
					break;
				case ID:
					{
					setState(287);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(290);
				match(ID);
				setState(291);
				match(NEWLINE);
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
	public static class AsignacionesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(YLenguajeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParser.ID, i);
		}
		public TerminalNode PUNTO() { return getToken(YLenguajeParser.PUNTO, 0); }
		public TerminalNode ASIG() { return getToken(YLenguajeParser.ASIG, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(YLenguajeParser.NEWLINE, 0); }
		public List<TerminalNode> LCORCH() { return getTokens(YLenguajeParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(YLenguajeParser.LCORCH, i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(YLenguajeParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(YLenguajeParser.RCORCH, i);
		}
		public TerminalNode INCREMENTO() { return getToken(YLenguajeParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(YLenguajeParser.DECREMENTO, 0); }
		public AsignacionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignaciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterAsignaciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitAsignaciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitAsignaciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionesContext asignaciones() throws RecognitionException {
		AsignacionesContext _localctx = new AsignacionesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_asignaciones);
		int _la;
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(ID);
				setState(295);
				match(PUNTO);
				setState(296);
				match(ID);
				setState(297);
				match(ASIG);
				setState(298);
				expresion(0);
				setState(299);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				match(ID);
				setState(302);
				match(PUNTO);
				setState(303);
				match(ID);
				setState(308); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(304);
					match(LCORCH);
					setState(305);
					expresion(0);
					setState(306);
					match(RCORCH);
					}
					}
					setState(310); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(312);
				match(ASIG);
				setState(313);
				expresion(0);
				setState(314);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				match(ID);
				setState(321); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(317);
					match(LCORCH);
					setState(318);
					expresion(0);
					setState(319);
					match(RCORCH);
					}
					}
					setState(323); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(325);
				match(ASIG);
				setState(326);
				expresion(0);
				setState(327);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(329);
				match(ID);
				setState(330);
				match(ASIG);
				setState(331);
				expresion(0);
				setState(332);
				match(NEWLINE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(334);
				match(ID);
				setState(335);
				match(INCREMENTO);
				setState(336);
				match(NEWLINE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(337);
				match(ID);
				setState(338);
				match(DECREMENTO);
				setState(339);
				match(NEWLINE);
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
	public static class ExpresionContext extends ParserRuleContext {
		public TerminalNode RESTA() { return getToken(YLenguajeParser.RESTA, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(YLenguajeParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(YLenguajeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(YLenguajeParser.RPAREN, 0); }
		public List<TerminalNode> ID() { return getTokens(YLenguajeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParser.ID, i);
		}
		public List<TerminalNode> LCORCH() { return getTokens(YLenguajeParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(YLenguajeParser.LCORCH, i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(YLenguajeParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(YLenguajeParser.RCORCH, i);
		}
		public TerminalNode PUNTO() { return getToken(YLenguajeParser.PUNTO, 0); }
		public TerminalNode LEER() { return getToken(YLenguajeParser.LEER, 0); }
		public TerminalNode VERDADERO() { return getToken(YLenguajeParser.VERDADERO, 0); }
		public TerminalNode FALSO() { return getToken(YLenguajeParser.FALSO, 0); }
		public TerminalNode INT() { return getToken(YLenguajeParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(YLenguajeParser.DECIMAL, 0); }
		public TerminalNode STRING() { return getToken(YLenguajeParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(YLenguajeParser.CHAR, 0); }
		public TerminalNode MULT() { return getToken(YLenguajeParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(YLenguajeParser.DIV, 0); }
		public TerminalNode SUMA() { return getToken(YLenguajeParser.SUMA, 0); }
		public TerminalNode IGUAL() { return getToken(YLenguajeParser.IGUAL, 0); }
		public TerminalNode NO_IGUAL() { return getToken(YLenguajeParser.NO_IGUAL, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(YLenguajeParser.MENOR_IGUAL, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(YLenguajeParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR() { return getToken(YLenguajeParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(YLenguajeParser.MAYOR, 0); }
		public TerminalNode AND() { return getToken(YLenguajeParser.AND, 0); }
		public TerminalNode OR() { return getToken(YLenguajeParser.OR, 0); }
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitExpresion(this);
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
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(343);
				match(RESTA);
				setState(344);
				expresion(19);
				}
				break;
			case 2:
				{
				setState(345);
				match(NOT);
				setState(346);
				expresion(18);
				}
				break;
			case 3:
				{
				setState(347);
				match(LPAREN);
				setState(348);
				expresion(0);
				setState(349);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(351);
				match(ID);
				setState(356); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(352);
						match(LCORCH);
						setState(353);
						expresion(0);
						setState(354);
						match(RCORCH);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(358); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				{
				setState(360);
				match(ID);
				setState(361);
				match(PUNTO);
				setState(362);
				match(ID);
				}
				break;
			case 6:
				{
				setState(363);
				match(LEER);
				setState(364);
				match(LPAREN);
				setState(365);
				match(RPAREN);
				}
				break;
			case 7:
				{
				setState(366);
				match(VERDADERO);
				}
				break;
			case 8:
				{
				setState(367);
				match(FALSO);
				}
				break;
			case 9:
				{
				setState(368);
				match(ID);
				}
				break;
			case 10:
				{
				setState(369);
				match(INT);
				}
				break;
			case 11:
				{
				setState(370);
				match(DECIMAL);
				}
				break;
			case 12:
				{
				setState(371);
				match(STRING);
				}
				break;
			case 13:
				{
				setState(372);
				match(CHAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(395);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(393);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(375);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(376);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(377);
						expresion(17);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(378);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(379);
						_la = _input.LA(1);
						if ( !(_la==SUMA || _la==RESTA) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(380);
						expresion(16);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(381);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(382);
						_la = _input.LA(1);
						if ( !(_la==IGUAL || _la==NO_IGUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(383);
						expresion(15);
						}
						break;
					case 4:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(384);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(385);
						_la = _input.LA(1);
						if ( !(_la==MENOR_IGUAL || _la==MAYOR_IGUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(386);
						expresion(14);
						}
						break;
					case 5:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(387);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(388);
						_la = _input.LA(1);
						if ( !(_la==MENOR || _la==MAYOR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(389);
						expresion(13);
						}
						break;
					case 6:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(390);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(391);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(392);
						expresion(12);
						}
						break;
					}
					} 
				}
				setState(397);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		public TerminalNode CADENA() { return getToken(YLenguajeParser.CADENA, 0); }
		public TerminalNode ENTERO() { return getToken(YLenguajeParser.ENTERO, 0); }
		public TerminalNode FLOTANTE() { return getToken(YLenguajeParser.FLOTANTE, 0); }
		public TerminalNode CARACTER() { return getToken(YLenguajeParser.CARACTER, 0); }
		public TerminalNode BOOL() { return getToken(YLenguajeParser.BOOL, 0); }
		public TiposContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterTipos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitTipos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitTipos(this);
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
			setState(398);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 992L) != 0)) ) {
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001?\u0191\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0003\u0000&\b\u0000\u0001"+
		"\u0000\u0003\u0000)\b\u0000\u0001\u0000\u0005\u0000,\b\u0000\n\u0000\f"+
		"\u0000/\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u00017\b\u0001\u000b\u0001\f\u00018\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0004\u0002C\b\u0002\u000b\u0002\f\u0002D\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003M\b"+
		"\u0003\u000b\u0003\f\u0003N\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004W\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004]\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004f\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004l\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005p\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005w\b\u0005"+
		"\n\u0005\f\u0005z\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u007f\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u0086\b\u0005\n\u0005\f\u0005\u0089\t\u0005\u0005\u0005\u008b"+
		"\b\u0005\n\u0005\f\u0005\u008e\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"\u0098\b\u0006\n\u0006\f\u0006\u009b\t\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u00a0\b\u0007\n\u0007\f\u0007\u00a3\t\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00aa\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00db\b\b\u0001\b\u0003\b\u00de\b\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00e8\b\t\n\t\f\t\u00eb\t\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00f0\b\t\u0001\n\u0001\n\u0004\n\u00f4\b\n"+
		"\u000b\n\f\n\u00f5\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00fc\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u0105\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u010c\b\u000b\u000b\u000b"+
		"\f\u000b\u010d\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0116\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u0121\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0125\b"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u0135\b\f\u000b"+
		"\f\f\f\u0136\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0004\f\u0142\b\f\u000b\f\f\f\u0143\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u0155\b\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0004\r\u0165\b\r\u000b\r\f\r\u0166\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u0176\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\u018a\b\r\n\r\f\r\u018d\t\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0000\u0001\u001a\u000f\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\b\u0001\u0000"+
		"01\u0001\u000056\u0001\u000034\u0001\u0000\'(\u0001\u0000)*\u0001\u0000"+
		"+,\u0001\u0000-.\u0001\u0000\u0005\t\u01c1\u0000!\u0001\u0000\u0000\u0000"+
		"\u00022\u0001\u0000\u0000\u0000\u0004<\u0001\u0000\u0000\u0000\u0006H"+
		"\u0001\u0000\u0000\u0000\bk\u0001\u0000\u0000\u0000\no\u0001\u0000\u0000"+
		"\u0000\f\u008f\u0001\u0000\u0000\u0000\u000e\u009c\u0001\u0000\u0000\u0000"+
		"\u0010\u00dd\u0001\u0000\u0000\u0000\u0012\u00e9\u0001\u0000\u0000\u0000"+
		"\u0014\u00f1\u0001\u0000\u0000\u0000\u0016\u0124\u0001\u0000\u0000\u0000"+
		"\u0018\u0154\u0001\u0000\u0000\u0000\u001a\u0175\u0001\u0000\u0000\u0000"+
		"\u001c\u018e\u0001\u0000\u0000\u0000\u001e \u0005>\u0000\u0000\u001f\u001e"+
		"\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001"+
		"\u0000\u0000\u0000$&\u0003\u0002\u0001\u0000%$\u0001\u0000\u0000\u0000"+
		"%&\u0001\u0000\u0000\u0000&(\u0001\u0000\u0000\u0000\')\u0003\u0006\u0003"+
		"\u0000(\'\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)-\u0001\u0000"+
		"\u0000\u0000*,\u0005>\u0000\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000"+
		"\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.0\u0001"+
		"\u0000\u0000\u0000/-\u0001\u0000\u0000\u000001\u0005\u0000\u0000\u0001"+
		"1\u0001\u0001\u0000\u0000\u000023\u0005\u0003\u0000\u000034\u0005>\u0000"+
		"\u000046\u0005\u0001\u0000\u000057\u0003\u0004\u0002\u000065\u0001\u0000"+
		"\u0000\u000078\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0005\u0002\u0000\u0000"+
		";\u0003\u0001\u0000\u0000\u0000<=\u0005\u0004\u0000\u0000=>\u00057\u0000"+
		"\u0000>?\u0005\u001d\u0000\u0000?@\u0005>\u0000\u0000@B\u0005\u0001\u0000"+
		"\u0000AC\u0003\u0016\u000b\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FG\u0005\u0002\u0000\u0000G\u0005\u0001\u0000\u0000"+
		"\u0000HI\u0005\n\u0000\u0000IJ\u0005>\u0000\u0000JL\u0005\u0001\u0000"+
		"\u0000KM\u0003\b\u0004\u0000LK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000PQ\u0005\u0002\u0000\u0000Q\u0007\u0001\u0000\u0000\u0000"+
		"RS\u0005\u000b\u0000\u0000ST\u00057\u0000\u0000TV\u0005 \u0000\u0000U"+
		"W\u0003\n\u0005\u0000VU\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000XY\u0005!\u0000\u0000Y\\\u0005\u001c\u0000\u0000"+
		"Z]\u0003\u001c\u000e\u0000[]\u00057\u0000\u0000\\Z\u0001\u0000\u0000\u0000"+
		"\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0005\u001d\u0000"+
		"\u0000_`\u0005>\u0000\u0000`l\u0003\u0014\n\u0000ab\u0005\u000b\u0000"+
		"\u0000bc\u00057\u0000\u0000ce\u0005 \u0000\u0000df\u0003\n\u0005\u0000"+
		"ed\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000gh\u0005!\u0000\u0000hi\u0005\u001d\u0000\u0000ij\u0005>\u0000\u0000"+
		"jl\u0003\u0014\n\u0000kR\u0001\u0000\u0000\u0000ka\u0001\u0000\u0000\u0000"+
		"l\t\u0001\u0000\u0000\u0000mp\u0003\u001c\u000e\u0000np\u00057\u0000\u0000"+
		"om\u0001\u0000\u0000\u0000on\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000qx\u00057\u0000\u0000rs\u0005\u001e\u0000\u0000st\u0003\u001a\r"+
		"\u0000tu\u0005\u001f\u0000\u0000uw\u0001\u0000\u0000\u0000vr\u0001\u0000"+
		"\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000y\u008c\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000"+
		"\u0000{~\u0005\"\u0000\u0000|\u007f\u0003\u001c\u000e\u0000}\u007f\u0005"+
		"7\u0000\u0000~|\u0001\u0000\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u0087\u00057\u0000\u0000\u0081\u0082"+
		"\u0005\u001e\u0000\u0000\u0082\u0083\u0003\u001a\r\u0000\u0083\u0084\u0005"+
		"\u001f\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0081\u0001"+
		"\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008b\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a{\u0001\u0000"+
		"\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u000b\u0001\u0000"+
		"\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0090\u0005#\u0000"+
		"\u0000\u0090\u0091\u0003\u000e\u0007\u0000\u0091\u0099\u0005$\u0000\u0000"+
		"\u0092\u0093\u0005\"\u0000\u0000\u0093\u0094\u0005#\u0000\u0000\u0094"+
		"\u0095\u0003\u000e\u0007\u0000\u0095\u0096\u0005$\u0000\u0000\u0096\u0098"+
		"\u0001\u0000\u0000\u0000\u0097\u0092\u0001\u0000\u0000\u0000\u0098\u009b"+
		"\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\r\u0001\u0000\u0000\u0000\u009b\u0099\u0001"+
		"\u0000\u0000\u0000\u009c\u00a1\u0003\u001a\r\u0000\u009d\u009e\u0005\""+
		"\u0000\u0000\u009e\u00a0\u0003\u001a\r\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u000f\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00de\u0003\u0016\u000b"+
		"\u0000\u00a5\u00de\u0003\u0018\f\u0000\u00a6\u00a7\u0005\u0017\u0000\u0000"+
		"\u00a7\u00a9\u0005 \u0000\u0000\u00a8\u00aa\u0003\u001a\r\u0000\u00a9"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005!\u0000\u0000\u00ac\u00de"+
		"\u0005>\u0000\u0000\u00ad\u00ae\u0005\f\u0000\u0000\u00ae\u00af\u0005"+
		" \u0000\u0000\u00af\u00b0\u0003\u001a\r\u0000\u00b0\u00b1\u0005!\u0000"+
		"\u0000\u00b1\u00b2\u0005\r\u0000\u0000\u00b2\u00b3\u0005>\u0000\u0000"+
		"\u00b3\u00b4\u0003\u0014\n\u0000\u00b4\u00b5\u0003\u0012\t\u0000\u00b5"+
		"\u00de\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0015\u0000\u0000\u00b7"+
		"\u00b8\u0005 \u0000\u0000\u00b8\u00b9\u0003\u001a\r\u0000\u00b9\u00ba"+
		"\u0005!\u0000\u0000\u00ba\u00bb\u0005\u0016\u0000\u0000\u00bb\u00bc\u0005"+
		">\u0000\u0000\u00bc\u00bd\u0003\u0014\n\u0000\u00bd\u00de\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0005\u0016\u0000\u0000\u00bf\u00c0\u0005\u001d"+
		"\u0000\u0000\u00c0\u00c1\u0005>\u0000\u0000\u00c1\u00c2\u0003\u0014\n"+
		"\u0000\u00c2\u00c3\u0005\u0015\u0000\u0000\u00c3\u00c4\u0005 \u0000\u0000"+
		"\u00c4\u00c5\u0003\u001a\r\u0000\u00c5\u00c6\u0005!\u0000\u0000\u00c6"+
		"\u00c7\u0005>\u0000\u0000\u00c7\u00de\u0001\u0000\u0000\u0000\u00c8\u00c9"+
		"\u0005\u0013\u0000\u0000\u00c9\u00ca\u0005 \u0000\u0000\u00ca\u00cb\u0003"+
		"\u001c\u000e\u0000\u00cb\u00cc\u00057\u0000\u0000\u00cc\u00cd\u00052\u0000"+
		"\u0000\u00cd\u00ce\u0003\u001a\r\u0000\u00ce\u00cf\u0005\u001d\u0000\u0000"+
		"\u00cf\u00d0\u0003\u001a\r\u0000\u00d0\u00d1\u0005\u001d\u0000\u0000\u00d1"+
		"\u00d2\u00057\u0000\u0000\u00d2\u00d3\u0007\u0000\u0000\u0000\u00d3\u00d4"+
		"\u0005!\u0000\u0000\u00d4\u00d5\u0005\u001d\u0000\u0000\u00d5\u00d6\u0005"+
		">\u0000\u0000\u00d6\u00d7\u0003\u0014\n\u0000\u00d7\u00de\u0001\u0000"+
		"\u0000\u0000\u00d8\u00da\u0005\u001b\u0000\u0000\u00d9\u00db\u0003\u001a"+
		"\r\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000"+
		"\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00de\u0005>\u0000\u0000"+
		"\u00dd\u00a4\u0001\u0000\u0000\u0000\u00dd\u00a5\u0001\u0000\u0000\u0000"+
		"\u00dd\u00a6\u0001\u0000\u0000\u0000\u00dd\u00ad\u0001\u0000\u0000\u0000"+
		"\u00dd\u00b6\u0001\u0000\u0000\u0000\u00dd\u00be\u0001\u0000\u0000\u0000"+
		"\u00dd\u00c8\u0001\u0000\u0000\u0000\u00dd\u00d8\u0001\u0000\u0000\u0000"+
		"\u00de\u0011\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u000e\u0000\u0000"+
		"\u00e0\u00e1\u0005 \u0000\u0000\u00e1\u00e2\u0003\u001a\r\u0000\u00e2"+
		"\u00e3\u0005!\u0000\u0000\u00e3\u00e4\u0005\r\u0000\u0000\u00e4\u00e5"+
		"\u0005>\u0000\u0000\u00e5\u00e6\u0003\u0014\n\u0000\u00e6\u00e8\u0001"+
		"\u0000\u0000\u0000\u00e7\u00df\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001"+
		"\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001"+
		"\u0000\u0000\u0000\u00ea\u00ef\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ed\u0005\u000f\u0000\u0000\u00ed\u00ee\u0005"+
		">\u0000\u0000\u00ee\u00f0\u0003\u0014\n\u0000\u00ef\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u0013\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f3\u0005\u0001\u0000\u0000\u00f2\u00f4\u0003\u0010"+
		"\b\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u0002\u0000"+
		"\u0000\u00f8\u0015\u0001\u0000\u0000\u0000\u00f9\u00fc\u0003\u001c\u000e"+
		"\u0000\u00fa\u00fc\u00057\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fe\u00057\u0000\u0000\u00fe\u00ff\u00052\u0000\u0000\u00ff\u0100"+
		"\u0003\u001a\r\u0000\u0100\u0101\u0005>\u0000\u0000\u0101\u0125\u0001"+
		"\u0000\u0000\u0000\u0102\u0105\u0003\u001c\u000e\u0000\u0103\u0105\u0005"+
		"7\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104\u0103\u0001\u0000"+
		"\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u010b\u00057\u0000"+
		"\u0000\u0107\u0108\u0005\u001e\u0000\u0000\u0108\u0109\u0003\u001a\r\u0000"+
		"\u0109\u010a\u0005\u001f\u0000\u0000\u010a\u010c\u0001\u0000\u0000\u0000"+
		"\u010b\u0107\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000"+
		"\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000"+
		"\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0110\u00052\u0000\u0000\u0110"+
		"\u0111\u0003\f\u0006\u0000\u0111\u0112\u0005>\u0000\u0000\u0112\u0125"+
		"\u0001\u0000\u0000\u0000\u0113\u0116\u0003\u001c\u000e\u0000\u0114\u0116"+
		"\u00057\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0114\u0001"+
		"\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0005"+
		"7\u0000\u0000\u0118\u0119\u00052\u0000\u0000\u0119\u011a\u0005#\u0000"+
		"\u0000\u011a\u011b\u0003\u000e\u0007\u0000\u011b\u011c\u0005$\u0000\u0000"+
		"\u011c\u011d\u0005>\u0000\u0000\u011d\u0125\u0001\u0000\u0000\u0000\u011e"+
		"\u0121\u0003\u001c\u000e\u0000\u011f\u0121\u00057\u0000\u0000\u0120\u011e"+
		"\u0001\u0000\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u00057\u0000\u0000\u0123\u0125\u0005"+
		">\u0000\u0000\u0124\u00fb\u0001\u0000\u0000\u0000\u0124\u0104\u0001\u0000"+
		"\u0000\u0000\u0124\u0115\u0001\u0000\u0000\u0000\u0124\u0120\u0001\u0000"+
		"\u0000\u0000\u0125\u0017\u0001\u0000\u0000\u0000\u0126\u0127\u00057\u0000"+
		"\u0000\u0127\u0128\u0005%\u0000\u0000\u0128\u0129\u00057\u0000\u0000\u0129"+
		"\u012a\u00052\u0000\u0000\u012a\u012b\u0003\u001a\r\u0000\u012b\u012c"+
		"\u0005>\u0000\u0000\u012c\u0155\u0001\u0000\u0000\u0000\u012d\u012e\u0005"+
		"7\u0000\u0000\u012e\u012f\u0005%\u0000\u0000\u012f\u0134\u00057\u0000"+
		"\u0000\u0130\u0131\u0005\u001e\u0000\u0000\u0131\u0132\u0003\u001a\r\u0000"+
		"\u0132\u0133\u0005\u001f\u0000\u0000\u0133\u0135\u0001\u0000\u0000\u0000"+
		"\u0134\u0130\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000"+
		"\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000"+
		"\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0139\u00052\u0000\u0000\u0139"+
		"\u013a\u0003\u001a\r\u0000\u013a\u013b\u0005>\u0000\u0000\u013b\u0155"+
		"\u0001\u0000\u0000\u0000\u013c\u0141\u00057\u0000\u0000\u013d\u013e\u0005"+
		"\u001e\u0000\u0000\u013e\u013f\u0003\u001a\r\u0000\u013f\u0140\u0005\u001f"+
		"\u0000\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141\u013d\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000"+
		"\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000"+
		"\u0000\u0000\u0145\u0146\u00052\u0000\u0000\u0146\u0147\u0003\u001a\r"+
		"\u0000\u0147\u0148\u0005>\u0000\u0000\u0148\u0155\u0001\u0000\u0000\u0000"+
		"\u0149\u014a\u00057\u0000\u0000\u014a\u014b\u00052\u0000\u0000\u014b\u014c"+
		"\u0003\u001a\r\u0000\u014c\u014d\u0005>\u0000\u0000\u014d\u0155\u0001"+
		"\u0000\u0000\u0000\u014e\u014f\u00057\u0000\u0000\u014f\u0150\u00050\u0000"+
		"\u0000\u0150\u0155\u0005>\u0000\u0000\u0151\u0152\u00057\u0000\u0000\u0152"+
		"\u0153\u00051\u0000\u0000\u0153\u0155\u0005>\u0000\u0000\u0154\u0126\u0001"+
		"\u0000\u0000\u0000\u0154\u012d\u0001\u0000\u0000\u0000\u0154\u013c\u0001"+
		"\u0000\u0000\u0000\u0154\u0149\u0001\u0000\u0000\u0000\u0154\u014e\u0001"+
		"\u0000\u0000\u0000\u0154\u0151\u0001\u0000\u0000\u0000\u0155\u0019\u0001"+
		"\u0000\u0000\u0000\u0156\u0157\u0006\r\uffff\uffff\u0000\u0157\u0158\u0005"+
		"4\u0000\u0000\u0158\u0176\u0003\u001a\r\u0013\u0159\u015a\u0005/\u0000"+
		"\u0000\u015a\u0176\u0003\u001a\r\u0012\u015b\u015c\u0005 \u0000\u0000"+
		"\u015c\u015d\u0003\u001a\r\u0000\u015d\u015e\u0005!\u0000\u0000\u015e"+
		"\u0176\u0001\u0000\u0000\u0000\u015f\u0164\u00057\u0000\u0000\u0160\u0161"+
		"\u0005\u001e\u0000\u0000\u0161\u0162\u0003\u001a\r\u0000\u0162\u0163\u0005"+
		"\u001f\u0000\u0000\u0163\u0165\u0001\u0000\u0000\u0000\u0164\u0160\u0001"+
		"\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000\u0166\u0164\u0001"+
		"\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u0176\u0001"+
		"\u0000\u0000\u0000\u0168\u0169\u00057\u0000\u0000\u0169\u016a\u0005%\u0000"+
		"\u0000\u016a\u0176\u00057\u0000\u0000\u016b\u016c\u0005\u0018\u0000\u0000"+
		"\u016c\u016d\u0005 \u0000\u0000\u016d\u0176\u0005!\u0000\u0000\u016e\u0176"+
		"\u0005\u0019\u0000\u0000\u016f\u0176\u0005\u001a\u0000\u0000\u0170\u0176"+
		"\u00057\u0000\u0000\u0171\u0176\u00058\u0000\u0000\u0172\u0176\u00059"+
		"\u0000\u0000\u0173\u0176\u0005:\u0000\u0000\u0174\u0176\u0005;\u0000\u0000"+
		"\u0175\u0156\u0001\u0000\u0000\u0000\u0175\u0159\u0001\u0000\u0000\u0000"+
		"\u0175\u015b\u0001\u0000\u0000\u0000\u0175\u015f\u0001\u0000\u0000\u0000"+
		"\u0175\u0168\u0001\u0000\u0000\u0000\u0175\u016b\u0001\u0000\u0000\u0000"+
		"\u0175\u016e\u0001\u0000\u0000\u0000\u0175\u016f\u0001\u0000\u0000\u0000"+
		"\u0175\u0170\u0001\u0000\u0000\u0000\u0175\u0171\u0001\u0000\u0000\u0000"+
		"\u0175\u0172\u0001\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000"+
		"\u0175\u0174\u0001\u0000\u0000\u0000\u0176\u018b\u0001\u0000\u0000\u0000"+
		"\u0177\u0178\n\u0010\u0000\u0000\u0178\u0179\u0007\u0001\u0000\u0000\u0179"+
		"\u018a\u0003\u001a\r\u0011\u017a\u017b\n\u000f\u0000\u0000\u017b\u017c"+
		"\u0007\u0002\u0000\u0000\u017c\u018a\u0003\u001a\r\u0010\u017d\u017e\n"+
		"\u000e\u0000\u0000\u017e\u017f\u0007\u0003\u0000\u0000\u017f\u018a\u0003"+
		"\u001a\r\u000f\u0180\u0181\n\r\u0000\u0000\u0181\u0182\u0007\u0004\u0000"+
		"\u0000\u0182\u018a\u0003\u001a\r\u000e\u0183\u0184\n\f\u0000\u0000\u0184"+
		"\u0185\u0007\u0005\u0000\u0000\u0185\u018a\u0003\u001a\r\r\u0186\u0187"+
		"\n\u000b\u0000\u0000\u0187\u0188\u0007\u0006\u0000\u0000\u0188\u018a\u0003"+
		"\u001a\r\f\u0189\u0177\u0001\u0000\u0000\u0000\u0189\u017a\u0001\u0000"+
		"\u0000\u0000\u0189\u017d\u0001\u0000\u0000\u0000\u0189\u0180\u0001\u0000"+
		"\u0000\u0000\u0189\u0183\u0001\u0000\u0000\u0000\u0189\u0186\u0001\u0000"+
		"\u0000\u0000\u018a\u018d\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000"+
		"\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u001b\u0001\u0000"+
		"\u0000\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018e\u018f\u0007\u0007"+
		"\u0000\u0000\u018f\u001d\u0001\u0000\u0000\u0000%!%(-8DNV\\ekox~\u0087"+
		"\u008c\u0099\u00a1\u00a9\u00da\u00dd\u00e9\u00ef\u00f5\u00fb\u0104\u010d"+
		"\u0115\u0120\u0124\u0136\u0143\u0154\u0166\u0175\u0189\u018b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}