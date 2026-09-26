// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/YLenguajeParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class YLenguajeParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ESTRUCTURAS=1, ESTRUCTURA=2, CADENA=3, ENTERO=4, FLOTANTE=5, CARACTER=6, 
		BOOL=7, FUNCIONES=8, DEFINIR=9, SI=10, ENTONCES=11, SINO=12, CONTRARIO=13, 
		ELEGITR=14, CASO=15, ROMPER=16, PARA=17, CONTINUAR=18, MIENTRAS=19, HACER=20, 
		IMPRIMIR=21, LEER=22, VERDADERO=23, FALSO=24, RETORNAR=25, RETORNO_FUNC=26, 
		DOS_PUNTOS=27, LCORCH=28, RCORCH=29, LPAREN=30, RPAREN=31, COMA=32, LLLAVE=33, 
		RLLAVE=34, PUNTO=35, PUNTO_COMA=36, IGUAL=37, NO_IGUAL=38, MENOR_IGUAL=39, 
		MAYOR_IGUAL=40, MENOR=41, MAYOR=42, AND=43, OR=44, NOT=45, INCREMENTO=46, 
		DECREMENTO=47, ASIG=48, SUMA=49, RESTA=50, MULT=51, DIV=52, ID=53, INT=54, 
		DECIMAL=55, STRING=56, CHAR=57, ESC=58, LINE_COMMENT=59, BLOCK_COMMENT=60, 
		NEWLINE=61, TAB=62, WS=63, INDENT=64, DEDENT=65;
	public static final int
		RULE_inicio = 0, RULE_instruccion = 1, RULE_bloq_estruc = 2, RULE_esctruc = 3, 
		RULE_bloq_func = 4, RULE_bloc_func = 5, RULE_params = 6, RULE_bloc_llaves = 7, 
		RULE_val_arreglo = 8, RULE_instrucciones = 9, RULE_bloc_si = 10, RULE_bloque = 11, 
		RULE_definiciones = 12, RULE_asignaciones = 13, RULE_expresion = 14, RULE_tipos = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "instruccion", "bloq_estruc", "esctruc", "bloq_func", "bloc_func", 
			"params", "bloc_llaves", "val_arreglo", "instrucciones", "bloc_si", "bloque", 
			"definiciones", "asignaciones", "expresion", "tipos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'%estructuras'", "'estructura'", "'cadena'", "'entero'", "'flotante'", 
			"'caracter'", "'bool'", "'%funciones'", "'definir'", "'si'", "'entonces'", 
			"'sino'", "'contrario'", "'elegir'", "'caso'", "'romper'", "'para'", 
			"'continuar'", "'mientras'", "'hacer'", "'imprimir'", "'leer'", "'verdadero'", 
			"'falso'", "'retornar'", "'->'", "':'", "'['", "']'", "'('", "')'", "','", 
			"'{'", "'}'", "'.'", "';'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", 
			"'&&'", "'||'", "'!'", "'++'", "'--'", "'='", "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ESTRUCTURAS", "ESTRUCTURA", "CADENA", "ENTERO", "FLOTANTE", "CARACTER", 
			"BOOL", "FUNCIONES", "DEFINIR", "SI", "ENTONCES", "SINO", "CONTRARIO", 
			"ELEGITR", "CASO", "ROMPER", "PARA", "CONTINUAR", "MIENTRAS", "HACER", 
			"IMPRIMIR", "LEER", "VERDADERO", "FALSO", "RETORNAR", "RETORNO_FUNC", 
			"DOS_PUNTOS", "LCORCH", "RCORCH", "LPAREN", "RPAREN", "COMA", "LLLAVE", 
			"RLLAVE", "PUNTO", "PUNTO_COMA", "IGUAL", "NO_IGUAL", "MENOR_IGUAL", 
			"MAYOR_IGUAL", "MENOR", "MAYOR", "AND", "OR", "NOT", "INCREMENTO", "DECREMENTO", 
			"ASIG", "SUMA", "RESTA", "MULT", "DIV", "ID", "INT", "DECIMAL", "STRING", 
			"CHAR", "ESC", "LINE_COMMENT", "BLOCK_COMMENT", "NEWLINE", "TAB", "WS", 
			"INDENT", "DEDENT"
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

	public YLenguajeParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicioContext extends ParserRuleContext {
		public InstruccionContext instruccion() {
			return getRuleContext(InstruccionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(YLenguajeParserParser.EOF, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			instruccion();
			setState(33);
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
	public static class InstruccionContext extends ParserRuleContext {
		public Bloq_estrucContext bloq_estruc() {
			return getRuleContext(Bloq_estrucContext.class,0);
		}
		public Bloq_funcContext bloq_func() {
			return getRuleContext(Bloq_funcContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterInstruccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitInstruccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruccion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ESTRUCTURAS) {
				{
				setState(35);
				bloq_estruc();
				}
			}

			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FUNCIONES) {
				{
				setState(38);
				bloq_func();
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
	public static class Bloq_estrucContext extends ParserRuleContext {
		public TerminalNode ESTRUCTURAS() { return getToken(YLenguajeParserParser.ESTRUCTURAS, 0); }
		public TerminalNode NEWLINE() { return getToken(YLenguajeParserParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YLenguajeParserParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YLenguajeParserParser.DEDENT, 0); }
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
		enterRule(_localctx, 4, RULE_bloq_estruc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(ESTRUCTURAS);
			setState(42);
			match(NEWLINE);
			setState(43);
			match(INDENT);
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				esctruc();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ESTRUCTURA );
			setState(49);
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
		public TerminalNode ESTRUCTURA() { return getToken(YLenguajeParserParser.ESTRUCTURA, 0); }
		public TerminalNode ID() { return getToken(YLenguajeParserParser.ID, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(YLenguajeParserParser.DOS_PUNTOS, 0); }
		public TerminalNode NEWLINE() { return getToken(YLenguajeParserParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YLenguajeParserParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YLenguajeParserParser.DEDENT, 0); }
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
		enterRule(_localctx, 6, RULE_esctruc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(ESTRUCTURA);
			setState(52);
			match(ID);
			setState(53);
			match(DOS_PUNTOS);
			setState(54);
			match(NEWLINE);
			setState(55);
			match(INDENT);
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				definiciones();
				}
				}
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199254741240L) != 0) );
			setState(61);
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
		public TerminalNode FUNCIONES() { return getToken(YLenguajeParserParser.FUNCIONES, 0); }
		public TerminalNode NEWLINE() { return getToken(YLenguajeParserParser.NEWLINE, 0); }
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
		enterRule(_localctx, 8, RULE_bloq_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(FUNCIONES);
			setState(64);
			match(NEWLINE);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINIR) {
				{
				{
				setState(65);
				bloc_func();
				}
				}
				setState(70);
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
	public static class Bloc_funcContext extends ParserRuleContext {
		public TerminalNode DEFINIR() { return getToken(YLenguajeParserParser.DEFINIR, 0); }
		public List<TerminalNode> ID() { return getTokens(YLenguajeParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParserParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(YLenguajeParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(YLenguajeParserParser.RPAREN, 0); }
		public TerminalNode RETORNO_FUNC() { return getToken(YLenguajeParserParser.RETORNO_FUNC, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(YLenguajeParserParser.DOS_PUNTOS, 0); }
		public TerminalNode NEWLINE() { return getToken(YLenguajeParserParser.NEWLINE, 0); }
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
		enterRule(_localctx, 10, RULE_bloc_func);
		int _la;
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(DEFINIR);
				setState(72);
				match(ID);
				setState(73);
				match(LPAREN);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199254741240L) != 0)) {
					{
					setState(74);
					params();
					}
				}

				setState(77);
				match(RPAREN);
				setState(78);
				match(RETORNO_FUNC);
				setState(81);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(79);
					tipos();
					}
					break;
				case ID:
					{
					setState(80);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(83);
				match(DOS_PUNTOS);
				setState(84);
				match(NEWLINE);
				setState(85);
				bloque();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(DEFINIR);
				setState(87);
				match(ID);
				setState(88);
				match(LPAREN);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199254741240L) != 0)) {
					{
					setState(89);
					params();
					}
				}

				setState(92);
				match(RPAREN);
				setState(93);
				match(DOS_PUNTOS);
				setState(94);
				match(NEWLINE);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INDENT) {
					{
					setState(95);
					bloque();
					}
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
	public static class ParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(YLenguajeParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParserParser.ID, i);
		}
		public List<TiposContext> tipos() {
			return getRuleContexts(TiposContext.class);
		}
		public TiposContext tipos(int i) {
			return getRuleContext(TiposContext.class,i);
		}
		public List<TerminalNode> LCORCH() { return getTokens(YLenguajeParserParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(YLenguajeParserParser.LCORCH, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(YLenguajeParserParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(YLenguajeParserParser.RCORCH, i);
		}
		public List<TerminalNode> COMA() { return getTokens(YLenguajeParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(YLenguajeParserParser.COMA, i);
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
		enterRule(_localctx, 12, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CADENA:
			case ENTERO:
			case FLOTANTE:
			case CARACTER:
			case BOOL:
				{
				setState(100);
				tipos();
				}
				break;
			case ID:
				{
				setState(101);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(104);
			match(ID);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LCORCH) {
				{
				{
				setState(105);
				match(LCORCH);
				setState(106);
				expresion(0);
				setState(107);
				match(RCORCH);
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(114);
				match(COMA);
				setState(117);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(115);
					tipos();
					}
					break;
				case ID:
					{
					setState(116);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(119);
				match(ID);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LCORCH) {
					{
					{
					setState(120);
					match(LCORCH);
					setState(121);
					expresion(0);
					setState(122);
					match(RCORCH);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(133);
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
		public List<TerminalNode> LLLAVE() { return getTokens(YLenguajeParserParser.LLLAVE); }
		public TerminalNode LLLAVE(int i) {
			return getToken(YLenguajeParserParser.LLLAVE, i);
		}
		public List<Val_arregloContext> val_arreglo() {
			return getRuleContexts(Val_arregloContext.class);
		}
		public Val_arregloContext val_arreglo(int i) {
			return getRuleContext(Val_arregloContext.class,i);
		}
		public List<TerminalNode> RLLAVE() { return getTokens(YLenguajeParserParser.RLLAVE); }
		public TerminalNode RLLAVE(int i) {
			return getToken(YLenguajeParserParser.RLLAVE, i);
		}
		public List<TerminalNode> COMA() { return getTokens(YLenguajeParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(YLenguajeParserParser.COMA, i);
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
		enterRule(_localctx, 14, RULE_bloc_llaves);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(LLLAVE);
			setState(135);
			val_arreglo();
			setState(136);
			match(RLLAVE);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(137);
				match(COMA);
				setState(138);
				match(LLLAVE);
				setState(139);
				val_arreglo();
				setState(140);
				match(RLLAVE);
				}
				}
				setState(146);
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
		public List<TerminalNode> COMA() { return getTokens(YLenguajeParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(YLenguajeParserParser.COMA, i);
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
		enterRule(_localctx, 16, RULE_val_arreglo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			expresion(0);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(148);
				match(COMA);
				setState(149);
				expresion(0);
				}
				}
				setState(154);
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
		public TerminalNode IMPRIMIR() { return getToken(YLenguajeParserParser.IMPRIMIR, 0); }
		public TerminalNode LPAREN() { return getToken(YLenguajeParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(YLenguajeParserParser.RPAREN, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YLenguajeParserParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YLenguajeParserParser.NEWLINE, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode SI() { return getToken(YLenguajeParserParser.SI, 0); }
		public TerminalNode ENTONCES() { return getToken(YLenguajeParserParser.ENTONCES, 0); }
		public Bloc_siContext bloc_si() {
			return getRuleContext(Bloc_siContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode MIENTRAS() { return getToken(YLenguajeParserParser.MIENTRAS, 0); }
		public TerminalNode HACER() { return getToken(YLenguajeParserParser.HACER, 0); }
		public List<TerminalNode> DOS_PUNTOS() { return getTokens(YLenguajeParserParser.DOS_PUNTOS); }
		public TerminalNode DOS_PUNTOS(int i) {
			return getToken(YLenguajeParserParser.DOS_PUNTOS, i);
		}
		public TerminalNode PARA() { return getToken(YLenguajeParserParser.PARA, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(YLenguajeParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParserParser.ID, i);
		}
		public TerminalNode ASIG() { return getToken(YLenguajeParserParser.ASIG, 0); }
		public TerminalNode INCREMENTO() { return getToken(YLenguajeParserParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(YLenguajeParserParser.DECREMENTO, 0); }
		public TerminalNode RETORNAR() { return getToken(YLenguajeParserParser.RETORNAR, 0); }
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
		enterRule(_localctx, 18, RULE_instrucciones);
		int _la;
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				definiciones();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				asignaciones();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(IMPRIMIR);
				setState(158);
				match(LPAREN);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 280384262279004160L) != 0)) {
					{
					setState(159);
					expresion(0);
					}
				}

				setState(162);
				match(RPAREN);
				setState(163);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(164);
				match(SI);
				setState(165);
				match(LPAREN);
				setState(166);
				expresion(0);
				setState(167);
				match(RPAREN);
				setState(168);
				match(ENTONCES);
				setState(169);
				match(NEWLINE);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INDENT) {
					{
					setState(170);
					bloque();
					}
				}

				setState(173);
				bloc_si();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				match(MIENTRAS);
				setState(176);
				match(LPAREN);
				setState(177);
				expresion(0);
				setState(178);
				match(RPAREN);
				setState(179);
				match(HACER);
				setState(180);
				match(NEWLINE);
				setState(181);
				bloque();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(183);
				match(HACER);
				setState(184);
				match(DOS_PUNTOS);
				setState(185);
				match(NEWLINE);
				setState(186);
				bloque();
				setState(187);
				match(MIENTRAS);
				setState(188);
				match(LPAREN);
				setState(189);
				expresion(0);
				setState(190);
				match(RPAREN);
				setState(191);
				match(NEWLINE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(193);
				match(PARA);
				setState(194);
				match(LPAREN);
				setState(195);
				tipos();
				setState(196);
				match(ID);
				setState(197);
				match(ASIG);
				setState(198);
				expresion(0);
				setState(199);
				match(DOS_PUNTOS);
				setState(200);
				expresion(0);
				setState(201);
				match(DOS_PUNTOS);
				setState(202);
				match(ID);
				setState(203);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(204);
				match(RPAREN);
				setState(205);
				match(DOS_PUNTOS);
				setState(206);
				match(NEWLINE);
				setState(207);
				bloque();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(209);
				match(RETORNAR);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 280384262279004160L) != 0)) {
					{
					setState(210);
					expresion(0);
					}
				}

				setState(213);
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
		public List<TerminalNode> SINO() { return getTokens(YLenguajeParserParser.SINO); }
		public TerminalNode SINO(int i) {
			return getToken(YLenguajeParserParser.SINO, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(YLenguajeParserParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(YLenguajeParserParser.LPAREN, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(YLenguajeParserParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(YLenguajeParserParser.RPAREN, i);
		}
		public List<TerminalNode> ENTONCES() { return getTokens(YLenguajeParserParser.ENTONCES); }
		public TerminalNode ENTONCES(int i) {
			return getToken(YLenguajeParserParser.ENTONCES, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YLenguajeParserParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YLenguajeParserParser.NEWLINE, i);
		}
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode CONTRARIO() { return getToken(YLenguajeParserParser.CONTRARIO, 0); }
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
		enterRule(_localctx, 20, RULE_bloc_si);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SINO) {
				{
				{
				setState(216);
				match(SINO);
				setState(217);
				match(LPAREN);
				setState(218);
				expresion(0);
				setState(219);
				match(RPAREN);
				setState(220);
				match(ENTONCES);
				setState(221);
				match(NEWLINE);
				setState(222);
				bloque();
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONTRARIO) {
				{
				setState(229);
				match(CONTRARIO);
				setState(230);
				match(NEWLINE);
				setState(231);
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
		public TerminalNode INDENT() { return getToken(YLenguajeParserParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YLenguajeParserParser.DEDENT, 0); }
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
		enterRule(_localctx, 22, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(INDENT);
			setState(236); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(235);
				instrucciones();
				}
				}
				setState(238); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199292097784L) != 0) );
			setState(240);
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
		public List<TerminalNode> ID() { return getTokens(YLenguajeParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParserParser.ID, i);
		}
		public TerminalNode ASIG() { return getToken(YLenguajeParserParser.ASIG, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(YLenguajeParserParser.NEWLINE, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public Bloc_llavesContext bloc_llaves() {
			return getRuleContext(Bloc_llavesContext.class,0);
		}
		public List<TerminalNode> LCORCH() { return getTokens(YLenguajeParserParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(YLenguajeParserParser.LCORCH, i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(YLenguajeParserParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(YLenguajeParserParser.RCORCH, i);
		}
		public TerminalNode LLLAVE() { return getToken(YLenguajeParserParser.LLLAVE, 0); }
		public Val_arregloContext val_arreglo() {
			return getRuleContext(Val_arregloContext.class,0);
		}
		public TerminalNode RLLAVE() { return getToken(YLenguajeParserParser.RLLAVE, 0); }
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
		enterRule(_localctx, 24, RULE_definiciones);
		int _la;
		try {
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(242);
					tipos();
					}
					break;
				case ID:
					{
					setState(243);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(246);
				match(ID);
				setState(247);
				match(ASIG);
				setState(248);
				expresion(0);
				setState(249);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(251);
					tipos();
					}
					break;
				case ID:
					{
					setState(252);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(255);
				match(ID);
				setState(260); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(256);
					match(LCORCH);
					setState(257);
					expresion(0);
					setState(258);
					match(RCORCH);
					}
					}
					setState(262); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(264);
				match(ASIG);
				setState(265);
				bloc_llaves();
				setState(266);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(270);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(268);
					tipos();
					}
					break;
				case ID:
					{
					setState(269);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(272);
				match(ID);
				setState(273);
				match(ASIG);
				setState(274);
				match(LLLAVE);
				setState(275);
				val_arreglo();
				setState(276);
				match(RLLAVE);
				setState(277);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(281);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(279);
					tipos();
					}
					break;
				case ID:
					{
					setState(280);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(283);
				match(ID);
				setState(284);
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
		public List<TerminalNode> ID() { return getTokens(YLenguajeParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParserParser.ID, i);
		}
		public TerminalNode PUNTO() { return getToken(YLenguajeParserParser.PUNTO, 0); }
		public TerminalNode ASIG() { return getToken(YLenguajeParserParser.ASIG, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(YLenguajeParserParser.NEWLINE, 0); }
		public List<TerminalNode> LCORCH() { return getTokens(YLenguajeParserParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(YLenguajeParserParser.LCORCH, i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(YLenguajeParserParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(YLenguajeParserParser.RCORCH, i);
		}
		public TerminalNode INCREMENTO() { return getToken(YLenguajeParserParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(YLenguajeParserParser.DECREMENTO, 0); }
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
		enterRule(_localctx, 26, RULE_asignaciones);
		int _la;
		try {
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				match(ID);
				setState(288);
				match(PUNTO);
				setState(289);
				match(ID);
				setState(290);
				match(ASIG);
				setState(291);
				expresion(0);
				setState(292);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				match(ID);
				setState(295);
				match(PUNTO);
				setState(296);
				match(ID);
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
				match(ASIG);
				setState(306);
				expresion(0);
				setState(307);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				match(ID);
				setState(314); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(310);
					match(LCORCH);
					setState(311);
					expresion(0);
					setState(312);
					match(RCORCH);
					}
					}
					setState(316); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(318);
				match(ASIG);
				setState(319);
				expresion(0);
				setState(320);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(322);
				match(ID);
				setState(323);
				match(ASIG);
				setState(324);
				expresion(0);
				setState(325);
				match(NEWLINE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(327);
				match(ID);
				setState(328);
				match(INCREMENTO);
				setState(329);
				match(NEWLINE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(330);
				match(ID);
				setState(331);
				match(DECREMENTO);
				setState(332);
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
		public TerminalNode RESTA() { return getToken(YLenguajeParserParser.RESTA, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(YLenguajeParserParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(YLenguajeParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(YLenguajeParserParser.RPAREN, 0); }
		public List<TerminalNode> ID() { return getTokens(YLenguajeParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParserParser.ID, i);
		}
		public List<TerminalNode> LCORCH() { return getTokens(YLenguajeParserParser.LCORCH); }
		public TerminalNode LCORCH(int i) {
			return getToken(YLenguajeParserParser.LCORCH, i);
		}
		public List<TerminalNode> RCORCH() { return getTokens(YLenguajeParserParser.RCORCH); }
		public TerminalNode RCORCH(int i) {
			return getToken(YLenguajeParserParser.RCORCH, i);
		}
		public TerminalNode PUNTO() { return getToken(YLenguajeParserParser.PUNTO, 0); }
		public TerminalNode LEER() { return getToken(YLenguajeParserParser.LEER, 0); }
		public TerminalNode VERDADERO() { return getToken(YLenguajeParserParser.VERDADERO, 0); }
		public TerminalNode FALSO() { return getToken(YLenguajeParserParser.FALSO, 0); }
		public TerminalNode INT() { return getToken(YLenguajeParserParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(YLenguajeParserParser.DECIMAL, 0); }
		public TerminalNode STRING() { return getToken(YLenguajeParserParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(YLenguajeParserParser.CHAR, 0); }
		public TerminalNode MULT() { return getToken(YLenguajeParserParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(YLenguajeParserParser.DIV, 0); }
		public TerminalNode SUMA() { return getToken(YLenguajeParserParser.SUMA, 0); }
		public TerminalNode IGUAL() { return getToken(YLenguajeParserParser.IGUAL, 0); }
		public TerminalNode NO_IGUAL() { return getToken(YLenguajeParserParser.NO_IGUAL, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(YLenguajeParserParser.MENOR_IGUAL, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(YLenguajeParserParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR() { return getToken(YLenguajeParserParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(YLenguajeParserParser.MAYOR, 0); }
		public TerminalNode AND() { return getToken(YLenguajeParserParser.AND, 0); }
		public TerminalNode OR() { return getToken(YLenguajeParserParser.OR, 0); }
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(336);
				match(RESTA);
				setState(337);
				expresion(19);
				}
				break;
			case 2:
				{
				setState(338);
				match(NOT);
				setState(339);
				expresion(18);
				}
				break;
			case 3:
				{
				setState(340);
				match(LPAREN);
				setState(341);
				expresion(0);
				setState(342);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(344);
				match(ID);
				setState(349); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(345);
						match(LCORCH);
						setState(346);
						expresion(0);
						setState(347);
						match(RCORCH);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(351); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				{
				setState(353);
				match(ID);
				setState(354);
				match(PUNTO);
				setState(355);
				match(ID);
				}
				break;
			case 6:
				{
				setState(356);
				match(LEER);
				setState(357);
				match(LPAREN);
				setState(358);
				match(RPAREN);
				}
				break;
			case 7:
				{
				setState(359);
				match(VERDADERO);
				}
				break;
			case 8:
				{
				setState(360);
				match(FALSO);
				}
				break;
			case 9:
				{
				setState(361);
				match(ID);
				}
				break;
			case 10:
				{
				setState(362);
				match(INT);
				}
				break;
			case 11:
				{
				setState(363);
				match(DECIMAL);
				}
				break;
			case 12:
				{
				setState(364);
				match(STRING);
				}
				break;
			case 13:
				{
				setState(365);
				match(CHAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(388);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(386);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(368);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(369);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(370);
						expresion(17);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(371);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(372);
						_la = _input.LA(1);
						if ( !(_la==SUMA || _la==RESTA) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(373);
						expresion(16);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(374);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(375);
						_la = _input.LA(1);
						if ( !(_la==IGUAL || _la==NO_IGUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(376);
						expresion(15);
						}
						break;
					case 4:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(377);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(378);
						_la = _input.LA(1);
						if ( !(_la==MENOR_IGUAL || _la==MAYOR_IGUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(379);
						expresion(14);
						}
						break;
					case 5:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(380);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(381);
						_la = _input.LA(1);
						if ( !(_la==MENOR || _la==MAYOR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(382);
						expresion(13);
						}
						break;
					case 6:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(383);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(384);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(385);
						expresion(12);
						}
						break;
					}
					} 
				}
				setState(390);
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
		public TerminalNode CADENA() { return getToken(YLenguajeParserParser.CADENA, 0); }
		public TerminalNode ENTERO() { return getToken(YLenguajeParserParser.ENTERO, 0); }
		public TerminalNode FLOTANTE() { return getToken(YLenguajeParserParser.FLOTANTE, 0); }
		public TerminalNode CARACTER() { return getToken(YLenguajeParserParser.CARACTER, 0); }
		public TerminalNode BOOL() { return getToken(YLenguajeParserParser.BOOL, 0); }
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
		enterRule(_localctx, 30, RULE_tipos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
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
		case 14:
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
		"\u0004\u0001A\u018a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0003\u0001%\b\u0001"+
		"\u0001\u0001\u0003\u0001(\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0004\u0002.\b\u0002\u000b\u0002\f\u0002/\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0004\u0003:\b\u0003\u000b\u0003\f\u0003;\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004C\b\u0004\n\u0004\f\u0004"+
		"F\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"L\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"R\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005[\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005a\b\u0005\u0003\u0005c\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0003\u0006g\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006n\b\u0006\n\u0006\f\u0006q\t"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006v\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006}\b"+
		"\u0006\n\u0006\f\u0006\u0080\t\u0006\u0005\u0006\u0082\b\u0006\n\u0006"+
		"\f\u0006\u0085\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u008f\b\u0007"+
		"\n\u0007\f\u0007\u0092\t\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u0097\b"+
		"\b\n\b\f\b\u009a\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a1"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00ac\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00d4\b\t\u0001\t\u0003\t\u00d7"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00e1\b\n\n\n\f\n\u00e4\t\n\u0001\n\u0001\n\u0001\n\u0003\n\u00e9\b"+
		"\n\u0001\u000b\u0001\u000b\u0004\u000b\u00ed\b\u000b\u000b\u000b\f\u000b"+
		"\u00ee\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\f\u00f5\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00fe\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u0105\b\f\u000b\f\f\f\u0106"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u010f\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u011a\b\f\u0001\f\u0001\f\u0003\f\u011e\b\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0004\r\u012e\b\r\u000b\r\f\r\u012f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r\u013b"+
		"\b\r\u000b\r\f\r\u013c\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u014e\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u015e\b\u000e\u000b"+
		"\u000e\f\u000e\u015f\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u016f\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0183"+
		"\b\u000e\n\u000e\f\u000e\u0186\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0000\u0001\u001c\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e\u0000\b\u0001\u0000./\u0001\u0000"+
		"34\u0001\u000012\u0001\u0000%&\u0001\u0000\'(\u0001\u0000)*\u0001\u0000"+
		"+,\u0001\u0000\u0003\u0007\u01b9\u0000 \u0001\u0000\u0000\u0000\u0002"+
		"$\u0001\u0000\u0000\u0000\u0004)\u0001\u0000\u0000\u0000\u00063\u0001"+
		"\u0000\u0000\u0000\b?\u0001\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000"+
		"\ff\u0001\u0000\u0000\u0000\u000e\u0086\u0001\u0000\u0000\u0000\u0010"+
		"\u0093\u0001\u0000\u0000\u0000\u0012\u00d6\u0001\u0000\u0000\u0000\u0014"+
		"\u00e2\u0001\u0000\u0000\u0000\u0016\u00ea\u0001\u0000\u0000\u0000\u0018"+
		"\u011d\u0001\u0000\u0000\u0000\u001a\u014d\u0001\u0000\u0000\u0000\u001c"+
		"\u016e\u0001\u0000\u0000\u0000\u001e\u0187\u0001\u0000\u0000\u0000 !\u0003"+
		"\u0002\u0001\u0000!\"\u0005\u0000\u0000\u0001\"\u0001\u0001\u0000\u0000"+
		"\u0000#%\u0003\u0004\u0002\u0000$#\u0001\u0000\u0000\u0000$%\u0001\u0000"+
		"\u0000\u0000%\'\u0001\u0000\u0000\u0000&(\u0003\b\u0004\u0000\'&\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(\u0003\u0001\u0000\u0000"+
		"\u0000)*\u0005\u0001\u0000\u0000*+\u0005=\u0000\u0000+-\u0005@\u0000\u0000"+
		",.\u0003\u0006\u0003\u0000-,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u000012\u0005A\u0000\u00002\u0005\u0001\u0000\u0000\u000034\u0005"+
		"\u0002\u0000\u000045\u00055\u0000\u000056\u0005\u001b\u0000\u000067\u0005"+
		"=\u0000\u000079\u0005@\u0000\u00008:\u0003\u0018\f\u000098\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0005A\u0000\u0000>\u0007"+
		"\u0001\u0000\u0000\u0000?@\u0005\b\u0000\u0000@D\u0005=\u0000\u0000AC"+
		"\u0003\n\u0005\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000E\t\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000GH\u0005\t\u0000\u0000HI\u00055\u0000"+
		"\u0000IK\u0005\u001e\u0000\u0000JL\u0003\f\u0006\u0000KJ\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0005\u001f"+
		"\u0000\u0000NQ\u0005\u001a\u0000\u0000OR\u0003\u001e\u000f\u0000PR\u0005"+
		"5\u0000\u0000QO\u0001\u0000\u0000\u0000QP\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000ST\u0005\u001b\u0000\u0000TU\u0005=\u0000\u0000Uc\u0003"+
		"\u0016\u000b\u0000VW\u0005\t\u0000\u0000WX\u00055\u0000\u0000XZ\u0005"+
		"\u001e\u0000\u0000Y[\u0003\f\u0006\u0000ZY\u0001\u0000\u0000\u0000Z[\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0005\u001f\u0000\u0000"+
		"]^\u0005\u001b\u0000\u0000^`\u0005=\u0000\u0000_a\u0003\u0016\u000b\u0000"+
		"`_\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000"+
		"\u0000bG\u0001\u0000\u0000\u0000bV\u0001\u0000\u0000\u0000c\u000b\u0001"+
		"\u0000\u0000\u0000dg\u0003\u001e\u000f\u0000eg\u00055\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"ho\u00055\u0000\u0000ij\u0005\u001c\u0000\u0000jk\u0003\u001c\u000e\u0000"+
		"kl\u0005\u001d\u0000\u0000ln\u0001\u0000\u0000\u0000mi\u0001\u0000\u0000"+
		"\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000"+
		"\u0000\u0000p\u0083\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"ru\u0005 \u0000\u0000sv\u0003\u001e\u000f\u0000tv\u00055\u0000\u0000u"+
		"s\u0001\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000w~\u00055\u0000\u0000xy\u0005\u001c\u0000\u0000yz\u0003\u001c\u000e"+
		"\u0000z{\u0005\u001d\u0000\u0000{}\u0001\u0000\u0000\u0000|x\u0001\u0000"+
		"\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0081r\u0001\u0000\u0000\u0000\u0082\u0085\u0001"+
		"\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\r\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005!\u0000\u0000\u0087\u0088\u0003\u0010\b"+
		"\u0000\u0088\u0090\u0005\"\u0000\u0000\u0089\u008a\u0005 \u0000\u0000"+
		"\u008a\u008b\u0005!\u0000\u0000\u008b\u008c\u0003\u0010\b\u0000\u008c"+
		"\u008d\u0005\"\u0000\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u0089"+
		"\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u000f"+
		"\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0098"+
		"\u0003\u001c\u000e\u0000\u0094\u0095\u0005 \u0000\u0000\u0095\u0097\u0003"+
		"\u001c\u000e\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u009a\u0001"+
		"\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001"+
		"\u0000\u0000\u0000\u0099\u0011\u0001\u0000\u0000\u0000\u009a\u0098\u0001"+
		"\u0000\u0000\u0000\u009b\u00d7\u0003\u0018\f\u0000\u009c\u00d7\u0003\u001a"+
		"\r\u0000\u009d\u009e\u0005\u0015\u0000\u0000\u009e\u00a0\u0005\u001e\u0000"+
		"\u0000\u009f\u00a1\u0003\u001c\u000e\u0000\u00a0\u009f\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0005\u001f\u0000\u0000\u00a3\u00d7\u0005=\u0000\u0000"+
		"\u00a4\u00a5\u0005\n\u0000\u0000\u00a5\u00a6\u0005\u001e\u0000\u0000\u00a6"+
		"\u00a7\u0003\u001c\u000e\u0000\u00a7\u00a8\u0005\u001f\u0000\u0000\u00a8"+
		"\u00a9\u0005\u000b\u0000\u0000\u00a9\u00ab\u0005=\u0000\u0000\u00aa\u00ac"+
		"\u0003\u0016\u000b\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0003\u0014\n\u0000\u00ae\u00d7\u0001\u0000\u0000\u0000\u00af\u00b0\u0005"+
		"\u0013\u0000\u0000\u00b0\u00b1\u0005\u001e\u0000\u0000\u00b1\u00b2\u0003"+
		"\u001c\u000e\u0000\u00b2\u00b3\u0005\u001f\u0000\u0000\u00b3\u00b4\u0005"+
		"\u0014\u0000\u0000\u00b4\u00b5\u0005=\u0000\u0000\u00b5\u00b6\u0003\u0016"+
		"\u000b\u0000\u00b6\u00d7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0014"+
		"\u0000\u0000\u00b8\u00b9\u0005\u001b\u0000\u0000\u00b9\u00ba\u0005=\u0000"+
		"\u0000\u00ba\u00bb\u0003\u0016\u000b\u0000\u00bb\u00bc\u0005\u0013\u0000"+
		"\u0000\u00bc\u00bd\u0005\u001e\u0000\u0000\u00bd\u00be\u0003\u001c\u000e"+
		"\u0000\u00be\u00bf\u0005\u001f\u0000\u0000\u00bf\u00c0\u0005=\u0000\u0000"+
		"\u00c0\u00d7\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005\u0011\u0000\u0000"+
		"\u00c2\u00c3\u0005\u001e\u0000\u0000\u00c3\u00c4\u0003\u001e\u000f\u0000"+
		"\u00c4\u00c5\u00055\u0000\u0000\u00c5\u00c6\u00050\u0000\u0000\u00c6\u00c7"+
		"\u0003\u001c\u000e\u0000\u00c7\u00c8\u0005\u001b\u0000\u0000\u00c8\u00c9"+
		"\u0003\u001c\u000e\u0000\u00c9\u00ca\u0005\u001b\u0000\u0000\u00ca\u00cb"+
		"\u00055\u0000\u0000\u00cb\u00cc\u0007\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"\u001f\u0000\u0000\u00cd\u00ce\u0005\u001b\u0000\u0000\u00ce\u00cf\u0005"+
		"=\u0000\u0000\u00cf\u00d0\u0003\u0016\u000b\u0000\u00d0\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d3\u0005\u0019\u0000\u0000\u00d2\u00d4\u0003\u001c"+
		"\u000e\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7\u0005=\u0000"+
		"\u0000\u00d6\u009b\u0001\u0000\u0000\u0000\u00d6\u009c\u0001\u0000\u0000"+
		"\u0000\u00d6\u009d\u0001\u0000\u0000\u0000\u00d6\u00a4\u0001\u0000\u0000"+
		"\u0000\u00d6\u00af\u0001\u0000\u0000\u0000\u00d6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00d6\u00c1\u0001\u0000\u0000\u0000\u00d6\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d7\u0013\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\f\u0000\u0000"+
		"\u00d9\u00da\u0005\u001e\u0000\u0000\u00da\u00db\u0003\u001c\u000e\u0000"+
		"\u00db\u00dc\u0005\u001f\u0000\u0000\u00dc\u00dd\u0005\u000b\u0000\u0000"+
		"\u00dd\u00de\u0005=\u0000\u0000\u00de\u00df\u0003\u0016\u000b\u0000\u00df"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e0\u00d8\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e8\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005\r\u0000\u0000\u00e6\u00e7"+
		"\u0005=\u0000\u0000\u00e7\u00e9\u0003\u0016\u000b\u0000\u00e8\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u0015\u0001"+
		"\u0000\u0000\u0000\u00ea\u00ec\u0005@\u0000\u0000\u00eb\u00ed\u0003\u0012"+
		"\t\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005A\u0000\u0000"+
		"\u00f1\u0017\u0001\u0000\u0000\u0000\u00f2\u00f5\u0003\u001e\u000f\u0000"+
		"\u00f3\u00f5\u00055\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f7\u00055\u0000\u0000\u00f7\u00f8\u00050\u0000\u0000\u00f8\u00f9\u0003"+
		"\u001c\u000e\u0000\u00f9\u00fa\u0005=\u0000\u0000\u00fa\u011e\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fe\u0003\u001e\u000f\u0000\u00fc\u00fe\u00055\u0000"+
		"\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0104\u00055\u0000\u0000"+
		"\u0100\u0101\u0005\u001c\u0000\u0000\u0101\u0102\u0003\u001c\u000e\u0000"+
		"\u0102\u0103\u0005\u001d\u0000\u0000\u0103\u0105\u0001\u0000\u0000\u0000"+
		"\u0104\u0100\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000"+
		"\u0106\u0104\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0109\u00050\u0000\u0000\u0109"+
		"\u010a\u0003\u000e\u0007\u0000\u010a\u010b\u0005=\u0000\u0000\u010b\u011e"+
		"\u0001\u0000\u0000\u0000\u010c\u010f\u0003\u001e\u000f\u0000\u010d\u010f"+
		"\u00055\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010d\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111\u0005"+
		"5\u0000\u0000\u0111\u0112\u00050\u0000\u0000\u0112\u0113\u0005!\u0000"+
		"\u0000\u0113\u0114\u0003\u0010\b\u0000\u0114\u0115\u0005\"\u0000\u0000"+
		"\u0115\u0116\u0005=\u0000\u0000\u0116\u011e\u0001\u0000\u0000\u0000\u0117"+
		"\u011a\u0003\u001e\u000f\u0000\u0118\u011a\u00055\u0000\u0000\u0119\u0117"+
		"\u0001\u0000\u0000\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a\u011b"+
		"\u0001\u0000\u0000\u0000\u011b\u011c\u00055\u0000\u0000\u011c\u011e\u0005"+
		"=\u0000\u0000\u011d\u00f4\u0001\u0000\u0000\u0000\u011d\u00fd\u0001\u0000"+
		"\u0000\u0000\u011d\u010e\u0001\u0000\u0000\u0000\u011d\u0119\u0001\u0000"+
		"\u0000\u0000\u011e\u0019\u0001\u0000\u0000\u0000\u011f\u0120\u00055\u0000"+
		"\u0000\u0120\u0121\u0005#\u0000\u0000\u0121\u0122\u00055\u0000\u0000\u0122"+
		"\u0123\u00050\u0000\u0000\u0123\u0124\u0003\u001c\u000e\u0000\u0124\u0125"+
		"\u0005=\u0000\u0000\u0125\u014e\u0001\u0000\u0000\u0000\u0126\u0127\u0005"+
		"5\u0000\u0000\u0127\u0128\u0005#\u0000\u0000\u0128\u012d\u00055\u0000"+
		"\u0000\u0129\u012a\u0005\u001c\u0000\u0000\u012a\u012b\u0003\u001c\u000e"+
		"\u0000\u012b\u012c\u0005\u001d\u0000\u0000\u012c\u012e\u0001\u0000\u0000"+
		"\u0000\u012d\u0129\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000"+
		"\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u00050\u0000\u0000"+
		"\u0132\u0133\u0003\u001c\u000e\u0000\u0133\u0134\u0005=\u0000\u0000\u0134"+
		"\u014e\u0001\u0000\u0000\u0000\u0135\u013a\u00055\u0000\u0000\u0136\u0137"+
		"\u0005\u001c\u0000\u0000\u0137\u0138\u0003\u001c\u000e\u0000\u0138\u0139"+
		"\u0005\u001d\u0000\u0000\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u0136"+
		"\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c\u013a"+
		"\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013e"+
		"\u0001\u0000\u0000\u0000\u013e\u013f\u00050\u0000\u0000\u013f\u0140\u0003"+
		"\u001c\u000e\u0000\u0140\u0141\u0005=\u0000\u0000\u0141\u014e\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\u00055\u0000\u0000\u0143\u0144\u00050\u0000\u0000"+
		"\u0144\u0145\u0003\u001c\u000e\u0000\u0145\u0146\u0005=\u0000\u0000\u0146"+
		"\u014e\u0001\u0000\u0000\u0000\u0147\u0148\u00055\u0000\u0000\u0148\u0149"+
		"\u0005.\u0000\u0000\u0149\u014e\u0005=\u0000\u0000\u014a\u014b\u00055"+
		"\u0000\u0000\u014b\u014c\u0005/\u0000\u0000\u014c\u014e\u0005=\u0000\u0000"+
		"\u014d\u011f\u0001\u0000\u0000\u0000\u014d\u0126\u0001\u0000\u0000\u0000"+
		"\u014d\u0135\u0001\u0000\u0000\u0000\u014d\u0142\u0001\u0000\u0000\u0000"+
		"\u014d\u0147\u0001\u0000\u0000\u0000\u014d\u014a\u0001\u0000\u0000\u0000"+
		"\u014e\u001b\u0001\u0000\u0000\u0000\u014f\u0150\u0006\u000e\uffff\uffff"+
		"\u0000\u0150\u0151\u00052\u0000\u0000\u0151\u016f\u0003\u001c\u000e\u0013"+
		"\u0152\u0153\u0005-\u0000\u0000\u0153\u016f\u0003\u001c\u000e\u0012\u0154"+
		"\u0155\u0005\u001e\u0000\u0000\u0155\u0156\u0003\u001c\u000e\u0000\u0156"+
		"\u0157\u0005\u001f\u0000\u0000\u0157\u016f\u0001\u0000\u0000\u0000\u0158"+
		"\u015d\u00055\u0000\u0000\u0159\u015a\u0005\u001c\u0000\u0000\u015a\u015b"+
		"\u0003\u001c\u000e\u0000\u015b\u015c\u0005\u001d\u0000\u0000\u015c\u015e"+
		"\u0001\u0000\u0000\u0000\u015d\u0159\u0001\u0000\u0000\u0000\u015e\u015f"+
		"\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160"+
		"\u0001\u0000\u0000\u0000\u0160\u016f\u0001\u0000\u0000\u0000\u0161\u0162"+
		"\u00055\u0000\u0000\u0162\u0163\u0005#\u0000\u0000\u0163\u016f\u00055"+
		"\u0000\u0000\u0164\u0165\u0005\u0016\u0000\u0000\u0165\u0166\u0005\u001e"+
		"\u0000\u0000\u0166\u016f\u0005\u001f\u0000\u0000\u0167\u016f\u0005\u0017"+
		"\u0000\u0000\u0168\u016f\u0005\u0018\u0000\u0000\u0169\u016f\u00055\u0000"+
		"\u0000\u016a\u016f\u00056\u0000\u0000\u016b\u016f\u00057\u0000\u0000\u016c"+
		"\u016f\u00058\u0000\u0000\u016d\u016f\u00059\u0000\u0000\u016e\u014f\u0001"+
		"\u0000\u0000\u0000\u016e\u0152\u0001\u0000\u0000\u0000\u016e\u0154\u0001"+
		"\u0000\u0000\u0000\u016e\u0158\u0001\u0000\u0000\u0000\u016e\u0161\u0001"+
		"\u0000\u0000\u0000\u016e\u0164\u0001\u0000\u0000\u0000\u016e\u0167\u0001"+
		"\u0000\u0000\u0000\u016e\u0168\u0001\u0000\u0000\u0000\u016e\u0169\u0001"+
		"\u0000\u0000\u0000\u016e\u016a\u0001\u0000\u0000\u0000\u016e\u016b\u0001"+
		"\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016d\u0001"+
		"\u0000\u0000\u0000\u016f\u0184\u0001\u0000\u0000\u0000\u0170\u0171\n\u0010"+
		"\u0000\u0000\u0171\u0172\u0007\u0001\u0000\u0000\u0172\u0183\u0003\u001c"+
		"\u000e\u0011\u0173\u0174\n\u000f\u0000\u0000\u0174\u0175\u0007\u0002\u0000"+
		"\u0000\u0175\u0183\u0003\u001c\u000e\u0010\u0176\u0177\n\u000e\u0000\u0000"+
		"\u0177\u0178\u0007\u0003\u0000\u0000\u0178\u0183\u0003\u001c\u000e\u000f"+
		"\u0179\u017a\n\r\u0000\u0000\u017a\u017b\u0007\u0004\u0000\u0000\u017b"+
		"\u0183\u0003\u001c\u000e\u000e\u017c\u017d\n\f\u0000\u0000\u017d\u017e"+
		"\u0007\u0005\u0000\u0000\u017e\u0183\u0003\u001c\u000e\r\u017f\u0180\n"+
		"\u000b\u0000\u0000\u0180\u0181\u0007\u0006\u0000\u0000\u0181\u0183\u0003"+
		"\u001c\u000e\f\u0182\u0170\u0001\u0000\u0000\u0000\u0182\u0173\u0001\u0000"+
		"\u0000\u0000\u0182\u0176\u0001\u0000\u0000\u0000\u0182\u0179\u0001\u0000"+
		"\u0000\u0000\u0182\u017c\u0001\u0000\u0000\u0000\u0182\u017f\u0001\u0000"+
		"\u0000\u0000\u0183\u0186\u0001\u0000\u0000\u0000\u0184\u0182\u0001\u0000"+
		"\u0000\u0000\u0184\u0185\u0001\u0000\u0000\u0000\u0185\u001d\u0001\u0000"+
		"\u0000\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0187\u0188\u0007\u0007"+
		"\u0000\u0000\u0188\u001f\u0001\u0000\u0000\u0000%$\'/;DKQZ`bfou~\u0083"+
		"\u0090\u0098\u00a0\u00ab\u00d3\u00d6\u00e2\u00e8\u00ee\u00f4\u00fd\u0106"+
		"\u010e\u0119\u011d\u012f\u013c\u014d\u015f\u016e\u0182\u0184";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}