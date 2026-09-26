// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/YLenguajeParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

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
		HACER=22, IMPRIMIR=23, LEER=24, VERDADERO=25, FALSO=26, RETORNAR=27, SIEMPRE=28, 
		RETORNO_FUNC=29, DOS_PUNTOS=30, LCORCH=31, RCORCH=32, LPAREN=33, RPAREN=34, 
		COMA=35, LLLAVE=36, RLLAVE=37, PUNTO=38, PUNTO_COMA=39, IGUAL=40, NO_IGUAL=41, 
		MENOR_IGUAL=42, MAYOR_IGUAL=43, MENOR=44, MAYOR=45, AND=46, OR=47, NOT=48, 
		INCREMENTO=49, DECREMENTO=50, ASIG=51, SUMA=52, RESTA=53, MULT=54, DIV=55, 
		ID=56, INT=57, DECIMAL=58, STRING=59, CHAR=60, LINE_COMMENT=61, BLOCK_COMMENT=62, 
		NEWLINE=63, WS=64;
	public static final int
		RULE_inicio = 0, RULE_bloq_estruc = 1, RULE_esctruc = 2, RULE_bloq_func = 3, 
		RULE_bloc_func = 4, RULE_params = 5, RULE_tipos_params = 6, RULE_bloc_llaves = 7, 
		RULE_val_arreglo = 8, RULE_instrucciones = 9, RULE_bloc_si = 10, RULE_bloque = 11, 
		RULE_bloque_elegir = 12, RULE_definiciones = 13, RULE_asignaciones = 14, 
		RULE_expresion = 15, RULE_tipos = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "bloq_estruc", "esctruc", "bloq_func", "bloc_func", "params", 
			"tipos_params", "bloc_llaves", "val_arreglo", "instrucciones", "bloc_si", 
			"bloque", "bloque_elegir", "definiciones", "asignaciones", "expresion", 
			"tipos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'%estructuras'", "'estructura'", "'cadena'", "'entero'", 
			"'flotante'", "'caracter'", "'bool'", "'%funciones'", "'definir'", "'si'", 
			"'entonces'", "'sino'", "'contrario'", "'elegir'", "'caso'", "'romper'", 
			"'para'", "'continuar'", "'mientras'", "'hacer'", "'imprimir'", "'leer'", 
			"'verdadero'", "'falso'", "'retornar'", "'siempre'", "'->'", "':'", "'['", 
			"']'", "'('", "')'", "','", "'{'", "'}'", "'.'", "';'", "'=='", "'!='", 
			"'<='", "'>='", "'<'", "'>'", "'&&'", "'||'", "'!'", "'++'", "'--'", 
			"'='", "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "ESTRUCTURAS", "ESTRUCTURA", "CADENA", "ENTERO", 
			"FLOTANTE", "CARACTER", "BOOL", "FUNCIONES", "DEFINIR", "SI", "ENTONCES", 
			"SINO", "CONTRARIO", "ELEGITR", "CASO", "ROMPER", "PARA", "CONTINUAR", 
			"MIENTRAS", "HACER", "IMPRIMIR", "LEER", "VERDADERO", "FALSO", "RETORNAR", 
			"SIEMPRE", "RETORNO_FUNC", "DOS_PUNTOS", "LCORCH", "RCORCH", "LPAREN", 
			"RPAREN", "COMA", "LLLAVE", "RLLAVE", "PUNTO", "PUNTO_COMA", "IGUAL", 
			"NO_IGUAL", "MENOR_IGUAL", "MAYOR_IGUAL", "MENOR", "MAYOR", "AND", "OR", 
			"NOT", "INCREMENTO", "DECREMENTO", "ASIG", "SUMA", "RESTA", "MULT", "DIV", 
			"ID", "INT", "DECIMAL", "STRING", "CHAR", "LINE_COMMENT", "BLOCK_COMMENT", 
			"NEWLINE", "WS"
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
		public Bloq_funcContext bloq_func() {
			return getRuleContext(Bloq_funcContext.class,0);
		}
		public TerminalNode EOF() { return getToken(YLenguajeParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YLenguajeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YLenguajeParser.NEWLINE, i);
		}
		public Bloq_estrucContext bloq_estruc() {
			return getRuleContext(Bloq_estrucContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(34);
				match(NEWLINE);
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ESTRUCTURAS) {
				{
				setState(40);
				bloq_estruc();
				}
			}

			setState(43);
			bloq_func();
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(44);
				match(NEWLINE);
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
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
			setState(52);
			match(ESTRUCTURAS);
			setState(53);
			match(NEWLINE);
			setState(54);
			match(INDENT);
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				esctruc();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ESTRUCTURA );
			setState(60);
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
			setState(62);
			match(ESTRUCTURA);
			setState(63);
			match(ID);
			setState(64);
			match(DOS_PUNTOS);
			setState(65);
			match(NEWLINE);
			setState(66);
			match(INDENT);
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				definiciones();
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 72057594037928928L) != 0) );
			setState(72);
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
			setState(74);
			match(FUNCIONES);
			setState(75);
			match(NEWLINE);
			setState(76);
			match(INDENT);
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				bloc_func();
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DEFINIR );
			setState(82);
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
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(DEFINIR);
				setState(85);
				match(ID);
				setState(86);
				match(LPAREN);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72057664904889312L) != 0)) {
					{
					setState(87);
					params();
					}
				}

				setState(90);
				match(RPAREN);
				setState(91);
				match(RETORNO_FUNC);
				setState(94);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(92);
					tipos();
					}
					break;
				case ID:
					{
					setState(93);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(96);
				match(DOS_PUNTOS);
				setState(97);
				match(NEWLINE);
				setState(98);
				bloque();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(DEFINIR);
				setState(100);
				match(ID);
				setState(101);
				match(LPAREN);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72057664904889312L) != 0)) {
					{
					setState(102);
					params();
					}
				}

				setState(105);
				match(RPAREN);
				setState(106);
				match(DOS_PUNTOS);
				setState(107);
				match(NEWLINE);
				setState(108);
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
		public List<Tipos_paramsContext> tipos_params() {
			return getRuleContexts(Tipos_paramsContext.class);
		}
		public Tipos_paramsContext tipos_params(int i) {
			return getRuleContext(Tipos_paramsContext.class,i);
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
			tipos_params();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(112);
				match(COMA);
				setState(113);
				tipos_params();
				}
				}
				setState(118);
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
	public static class Tipos_paramsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(YLenguajeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParser.ID, i);
		}
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public TerminalNode LCORCH() { return getToken(YLenguajeParser.LCORCH, 0); }
		public TerminalNode RCORCH() { return getToken(YLenguajeParser.RCORCH, 0); }
		public TerminalNode LLLAVE() { return getToken(YLenguajeParser.LLLAVE, 0); }
		public TerminalNode RLLAVE() { return getToken(YLenguajeParser.RLLAVE, 0); }
		public Tipos_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipos_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterTipos_params(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitTipos_params(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitTipos_params(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipos_paramsContext tipos_params() throws RecognitionException {
		Tipos_paramsContext _localctx = new Tipos_paramsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipos_params);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CADENA:
			case ENTERO:
			case FLOTANTE:
			case CARACTER:
			case BOOL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(119);
					tipos();
					}
					break;
				case ID:
					{
					setState(120);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(123);
				match(ID);
				}
				break;
			case LCORCH:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(LCORCH);
				setState(125);
				match(RCORCH);
				setState(128);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(126);
					tipos();
					}
					break;
				case ID:
					{
					setState(127);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(130);
				match(ID);
				}
				break;
			case LLLAVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(LLLAVE);
				setState(132);
				match(RLLAVE);
				setState(135);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(133);
					tipos();
					}
					break;
				case ID:
					{
					setState(134);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(137);
				match(ID);
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
		enterRule(_localctx, 14, RULE_bloc_llaves);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(LLLAVE);
			setState(141);
			val_arreglo();
			setState(142);
			match(RLLAVE);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(143);
				match(COMA);
				setState(144);
				match(LLLAVE);
				setState(145);
				val_arreglo();
				setState(146);
				match(RLLAVE);
				}
				}
				setState(152);
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
		enterRule(_localctx, 16, RULE_val_arreglo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			expresion(0);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(154);
				match(COMA);
				setState(155);
				expresion(0);
				}
				}
				setState(160);
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
		public TerminalNode DOS_PUNTOS() { return getToken(YLenguajeParser.DOS_PUNTOS, 0); }
		public TerminalNode PARA() { return getToken(YLenguajeParser.PARA, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(YLenguajeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParser.ID, i);
		}
		public TerminalNode ASIG() { return getToken(YLenguajeParser.ASIG, 0); }
		public List<TerminalNode> PUNTO_COMA() { return getTokens(YLenguajeParser.PUNTO_COMA); }
		public TerminalNode PUNTO_COMA(int i) {
			return getToken(YLenguajeParser.PUNTO_COMA, i);
		}
		public TerminalNode INCREMENTO() { return getToken(YLenguajeParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(YLenguajeParser.DECREMENTO, 0); }
		public TerminalNode ELEGITR() { return getToken(YLenguajeParser.ELEGITR, 0); }
		public TerminalNode INDENT() { return getToken(YLenguajeParser.INDENT, 0); }
		public Bloque_elegirContext bloque_elegir() {
			return getRuleContext(Bloque_elegirContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(YLenguajeParser.DEDENT, 0); }
		public TerminalNode RETORNAR() { return getToken(YLenguajeParser.RETORNAR, 0); }
		public TerminalNode ROMPER() { return getToken(YLenguajeParser.ROMPER, 0); }
		public TerminalNode CONTINUAR() { return getToken(YLenguajeParser.CONTINUAR, 0); }
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
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				definiciones();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				asignaciones();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				match(IMPRIMIR);
				setState(164);
				match(LPAREN);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2243074098114592768L) != 0)) {
					{
					setState(165);
					expresion(0);
					}
				}

				setState(168);
				match(RPAREN);
				setState(169);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				match(SI);
				setState(171);
				match(LPAREN);
				setState(172);
				expresion(0);
				setState(173);
				match(RPAREN);
				setState(174);
				match(ENTONCES);
				setState(175);
				match(NEWLINE);
				setState(176);
				bloque();
				setState(177);
				bloc_si();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				match(MIENTRAS);
				setState(180);
				match(LPAREN);
				setState(181);
				expresion(0);
				setState(182);
				match(RPAREN);
				setState(183);
				match(HACER);
				setState(184);
				match(NEWLINE);
				setState(185);
				bloque();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(187);
				match(HACER);
				setState(188);
				match(DOS_PUNTOS);
				setState(189);
				match(NEWLINE);
				setState(190);
				bloque();
				setState(191);
				match(MIENTRAS);
				setState(192);
				match(LPAREN);
				setState(193);
				expresion(0);
				setState(194);
				match(RPAREN);
				setState(195);
				match(NEWLINE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(197);
				match(PARA);
				setState(198);
				match(LPAREN);
				setState(199);
				tipos();
				setState(200);
				match(ID);
				setState(201);
				match(ASIG);
				setState(202);
				expresion(0);
				setState(203);
				match(PUNTO_COMA);
				setState(204);
				expresion(0);
				setState(205);
				match(PUNTO_COMA);
				setState(206);
				match(ID);
				setState(207);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(208);
				match(RPAREN);
				setState(209);
				match(DOS_PUNTOS);
				setState(210);
				match(NEWLINE);
				setState(211);
				bloque();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(213);
				match(ELEGITR);
				setState(214);
				match(LPAREN);
				setState(215);
				expresion(0);
				setState(216);
				match(RPAREN);
				setState(217);
				match(DOS_PUNTOS);
				setState(218);
				match(NEWLINE);
				setState(219);
				match(INDENT);
				setState(220);
				bloque_elegir();
				setState(221);
				match(DEDENT);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(223);
				match(RETORNAR);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2243074098114592768L) != 0)) {
					{
					setState(224);
					expresion(0);
					}
				}

				setState(227);
				match(NEWLINE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(228);
				match(ROMPER);
				setState(229);
				match(NEWLINE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(230);
				match(CONTINUAR);
				setState(231);
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
		enterRule(_localctx, 20, RULE_bloc_si);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SINO) {
				{
				{
				setState(234);
				match(SINO);
				setState(235);
				match(LPAREN);
				setState(236);
				expresion(0);
				setState(237);
				match(RPAREN);
				setState(238);
				match(ENTONCES);
				setState(239);
				match(NEWLINE);
				setState(240);
				bloque();
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONTRARIO) {
				{
				setState(247);
				match(CONTRARIO);
				setState(248);
				match(NEWLINE);
				setState(249);
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
		enterRule(_localctx, 22, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(INDENT);
			setState(254); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(253);
				instrucciones();
				}
				}
				setState(256); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 72057594188731360L) != 0) );
			setState(258);
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
	public static class Bloque_elegirContext extends ParserRuleContext {
		public TerminalNode SIEMPRE() { return getToken(YLenguajeParser.SIEMPRE, 0); }
		public List<TerminalNode> DOS_PUNTOS() { return getTokens(YLenguajeParser.DOS_PUNTOS); }
		public TerminalNode DOS_PUNTOS(int i) {
			return getToken(YLenguajeParser.DOS_PUNTOS, i);
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
		public List<TerminalNode> CASO() { return getTokens(YLenguajeParser.CASO); }
		public TerminalNode CASO(int i) {
			return getToken(YLenguajeParser.CASO, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public Bloque_elegirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_elegir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterBloque_elegir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitBloque_elegir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitBloque_elegir(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_elegirContext bloque_elegir() throws RecognitionException {
		Bloque_elegirContext _localctx = new Bloque_elegirContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bloque_elegir);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(260);
				match(CASO);
				setState(261);
				expresion(0);
				setState(262);
				match(DOS_PUNTOS);
				setState(263);
				match(NEWLINE);
				setState(264);
				bloque();
				}
				}
				setState(268); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASO );
			setState(270);
			match(SIEMPRE);
			setState(271);
			match(DOS_PUNTOS);
			setState(272);
			match(NEWLINE);
			setState(273);
			bloque();
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
		enterRule(_localctx, 26, RULE_definiciones);
		int _la;
		try {
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
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
				expresion(0);
				setState(282);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(284);
					tipos();
					}
					break;
				case ID:
					{
					setState(285);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(288);
				match(ID);
				setState(293); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(289);
					match(LCORCH);
					setState(290);
					expresion(0);
					setState(291);
					match(RCORCH);
					}
					}
					setState(295); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(297);
				match(ASIG);
				setState(298);
				bloc_llaves();
				setState(299);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(303);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(301);
					tipos();
					}
					break;
				case ID:
					{
					setState(302);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(305);
				match(ID);
				setState(306);
				match(ASIG);
				setState(307);
				match(LLLAVE);
				setState(308);
				val_arreglo();
				setState(309);
				match(RLLAVE);
				setState(310);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(314);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(312);
					tipos();
					}
					break;
				case ID:
					{
					setState(313);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(316);
				match(ID);
				setState(317);
				match(NEWLINE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(320);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(318);
					tipos();
					}
					break;
				case ID:
					{
					setState(319);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(322);
				match(ID);
				setState(327); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(323);
					match(LCORCH);
					setState(324);
					expresion(0);
					setState(325);
					match(RCORCH);
					}
					}
					setState(329); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(331);
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
		enterRule(_localctx, 28, RULE_asignaciones);
		int _la;
		try {
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				match(ID);
				setState(336);
				match(PUNTO);
				setState(337);
				match(ID);
				setState(338);
				match(ASIG);
				setState(339);
				expresion(0);
				setState(340);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				match(ID);
				setState(343);
				match(PUNTO);
				setState(344);
				match(ID);
				setState(349); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
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
					setState(351); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(353);
				match(ASIG);
				setState(354);
				expresion(0);
				setState(355);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
				match(ID);
				setState(362); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(358);
					match(LCORCH);
					setState(359);
					expresion(0);
					setState(360);
					match(RCORCH);
					}
					}
					setState(364); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(366);
				match(ASIG);
				setState(367);
				expresion(0);
				setState(368);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(370);
				match(ID);
				setState(371);
				match(ASIG);
				setState(372);
				expresion(0);
				setState(373);
				match(NEWLINE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(375);
				match(ID);
				setState(376);
				match(INCREMENTO);
				setState(377);
				match(NEWLINE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(378);
				match(ID);
				setState(379);
				match(DECREMENTO);
				setState(380);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(384);
				match(RESTA);
				setState(385);
				expresion(19);
				}
				break;
			case 2:
				{
				setState(386);
				match(NOT);
				setState(387);
				expresion(18);
				}
				break;
			case 3:
				{
				setState(388);
				match(LPAREN);
				setState(389);
				expresion(0);
				setState(390);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(392);
				match(ID);
				setState(397); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(393);
						match(LCORCH);
						setState(394);
						expresion(0);
						setState(395);
						match(RCORCH);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(399); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				{
				setState(401);
				match(ID);
				setState(402);
				match(PUNTO);
				setState(403);
				match(ID);
				}
				break;
			case 6:
				{
				setState(404);
				match(LEER);
				setState(405);
				match(LPAREN);
				setState(406);
				match(RPAREN);
				}
				break;
			case 7:
				{
				setState(407);
				match(VERDADERO);
				}
				break;
			case 8:
				{
				setState(408);
				match(FALSO);
				}
				break;
			case 9:
				{
				setState(409);
				match(ID);
				}
				break;
			case 10:
				{
				setState(410);
				match(INT);
				}
				break;
			case 11:
				{
				setState(411);
				match(DECIMAL);
				}
				break;
			case 12:
				{
				setState(412);
				match(STRING);
				}
				break;
			case 13:
				{
				setState(413);
				match(CHAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(436);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(434);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(416);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(417);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(418);
						expresion(17);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(419);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(420);
						_la = _input.LA(1);
						if ( !(_la==SUMA || _la==RESTA) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(421);
						expresion(16);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(422);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(423);
						_la = _input.LA(1);
						if ( !(_la==IGUAL || _la==NO_IGUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(424);
						expresion(15);
						}
						break;
					case 4:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(425);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(426);
						_la = _input.LA(1);
						if ( !(_la==MENOR_IGUAL || _la==MAYOR_IGUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(427);
						expresion(14);
						}
						break;
					case 5:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(428);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(429);
						_la = _input.LA(1);
						if ( !(_la==MENOR || _la==MAYOR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(430);
						expresion(13);
						}
						break;
					case 6:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(431);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(432);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(433);
						expresion(12);
						}
						break;
					}
					} 
				}
				setState(438);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		enterRule(_localctx, 32, RULE_tipos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
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
		case 15:
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
		"\u0004\u0001@\u01ba\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0003\u0000*\b\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000.\b\u0000\n\u0000\f\u00001\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u00019\b\u0001\u000b"+
		"\u0001\f\u0001:\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002E\b\u0002\u000b"+
		"\u0002\f\u0002F\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0004\u0003O\b\u0003\u000b\u0003\f\u0003P\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"Y\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"_\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004h\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004n\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005s\b\u0005\n\u0005\f\u0005v\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0003\u0006z\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u0081\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0088\b\u0006\u0001\u0006"+
		"\u0003\u0006\u008b\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0095\b\u0007"+
		"\n\u0007\f\u0007\u0098\t\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u009d\b"+
		"\b\n\b\f\b\u00a0\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a7"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u00e2\b\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00e9\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u00f3\b\n\n\n\f\n\u00f6\t\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u00fb\b\n\u0001\u000b\u0001\u000b\u0004\u000b\u00ff\b"+
		"\u000b\u000b\u000b\f\u000b\u0100\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u010b\b\f\u000b\f\f\f\u010c"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u0116"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u011f"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r\u0126\b\r\u000b\r"+
		"\f\r\u0127\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0130"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u013b\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0141\b\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r\u0148\b\r\u000b\r\f\r"+
		"\u0149\u0001\r\u0001\r\u0003\r\u014e\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004"+
		"\u000e\u015e\b\u000e\u000b\u000e\f\u000e\u015f\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0004\u000e\u016b\b\u000e\u000b\u000e\f\u000e\u016c\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u017e\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0004\u000f\u018e\b\u000f\u000b\u000f\f\u000f\u018f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u019f\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u01b3\b\u000f\n\u000f\f\u000f\u01b6"+
		"\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0001\u001e\u0011\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \u0000\b\u0001\u000012\u0001\u000067\u0001\u000045\u0001\u0000"+
		"()\u0001\u0000*+\u0001\u0000,-\u0001\u0000./\u0001\u0000\u0005\t\u01ef"+
		"\u0000%\u0001\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u0004>"+
		"\u0001\u0000\u0000\u0000\u0006J\u0001\u0000\u0000\u0000\bm\u0001\u0000"+
		"\u0000\u0000\no\u0001\u0000\u0000\u0000\f\u008a\u0001\u0000\u0000\u0000"+
		"\u000e\u008c\u0001\u0000\u0000\u0000\u0010\u0099\u0001\u0000\u0000\u0000"+
		"\u0012\u00e8\u0001\u0000\u0000\u0000\u0014\u00f4\u0001\u0000\u0000\u0000"+
		"\u0016\u00fc\u0001\u0000\u0000\u0000\u0018\u010a\u0001\u0000\u0000\u0000"+
		"\u001a\u014d\u0001\u0000\u0000\u0000\u001c\u017d\u0001\u0000\u0000\u0000"+
		"\u001e\u019e\u0001\u0000\u0000\u0000 \u01b7\u0001\u0000\u0000\u0000\""+
		"$\u0005?\u0000\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000\u0000"+
		"%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000"+
		"\u0000\'%\u0001\u0000\u0000\u0000(*\u0003\u0002\u0001\u0000)(\u0001\u0000"+
		"\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+/\u0003"+
		"\u0006\u0003\u0000,.\u0005?\u0000\u0000-,\u0001\u0000\u0000\u0000.1\u0001"+
		"\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u0000"+
		"02\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000023\u0005\u0000\u0000"+
		"\u00013\u0001\u0001\u0000\u0000\u000045\u0005\u0003\u0000\u000056\u0005"+
		"?\u0000\u000068\u0005\u0001\u0000\u000079\u0003\u0004\u0002\u000087\u0001"+
		"\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		":;\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0005\u0002\u0000"+
		"\u0000=\u0003\u0001\u0000\u0000\u0000>?\u0005\u0004\u0000\u0000?@\u0005"+
		"8\u0000\u0000@A\u0005\u001e\u0000\u0000AB\u0005?\u0000\u0000BD\u0005\u0001"+
		"\u0000\u0000CE\u0003\u001a\r\u0000DC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0001"+
		"\u0000\u0000\u0000HI\u0005\u0002\u0000\u0000I\u0005\u0001\u0000\u0000"+
		"\u0000JK\u0005\n\u0000\u0000KL\u0005?\u0000\u0000LN\u0005\u0001\u0000"+
		"\u0000MO\u0003\b\u0004\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000RS\u0005\u0002\u0000\u0000S\u0007\u0001\u0000\u0000\u0000"+
		"TU\u0005\u000b\u0000\u0000UV\u00058\u0000\u0000VX\u0005!\u0000\u0000W"+
		"Y\u0003\n\u0005\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z[\u0005\"\u0000\u0000[^\u0005\u001d\u0000\u0000"+
		"\\_\u0003 \u0010\u0000]_\u00058\u0000\u0000^\\\u0001\u0000\u0000\u0000"+
		"^]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0005\u001e\u0000"+
		"\u0000ab\u0005?\u0000\u0000bn\u0003\u0016\u000b\u0000cd\u0005\u000b\u0000"+
		"\u0000de\u00058\u0000\u0000eg\u0005!\u0000\u0000fh\u0003\n\u0005\u0000"+
		"gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000ij\u0005\"\u0000\u0000jk\u0005\u001e\u0000\u0000kl\u0005?\u0000"+
		"\u0000ln\u0003\u0016\u000b\u0000mT\u0001\u0000\u0000\u0000mc\u0001\u0000"+
		"\u0000\u0000n\t\u0001\u0000\u0000\u0000ot\u0003\f\u0006\u0000pq\u0005"+
		"#\u0000\u0000qs\u0003\f\u0006\u0000rp\u0001\u0000\u0000\u0000sv\u0001"+
		"\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"u\u000b\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wz\u0003 \u0010"+
		"\u0000xz\u00058\u0000\u0000yw\u0001\u0000\u0000\u0000yx\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{\u008b\u00058\u0000\u0000|}\u0005\u001f"+
		"\u0000\u0000}\u0080\u0005 \u0000\u0000~\u0081\u0003 \u0010\u0000\u007f"+
		"\u0081\u00058\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u008b\u0005"+
		"8\u0000\u0000\u0083\u0084\u0005$\u0000\u0000\u0084\u0087\u0005%\u0000"+
		"\u0000\u0085\u0088\u0003 \u0010\u0000\u0086\u0088\u00058\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0001\u0000\u0000\u0000\u0089\u008b\u00058\u0000\u0000\u008ay\u0001"+
		"\u0000\u0000\u0000\u008a|\u0001\u0000\u0000\u0000\u008a\u0083\u0001\u0000"+
		"\u0000\u0000\u008b\r\u0001\u0000\u0000\u0000\u008c\u008d\u0005$\u0000"+
		"\u0000\u008d\u008e\u0003\u0010\b\u0000\u008e\u0096\u0005%\u0000\u0000"+
		"\u008f\u0090\u0005#\u0000\u0000\u0090\u0091\u0005$\u0000\u0000\u0091\u0092"+
		"\u0003\u0010\b\u0000\u0092\u0093\u0005%\u0000\u0000\u0093\u0095\u0001"+
		"\u0000\u0000\u0000\u0094\u008f\u0001\u0000\u0000\u0000\u0095\u0098\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0097\u000f\u0001\u0000\u0000\u0000\u0098\u0096\u0001"+
		"\u0000\u0000\u0000\u0099\u009e\u0003\u001e\u000f\u0000\u009a\u009b\u0005"+
		"#\u0000\u0000\u009b\u009d\u0003\u001e\u000f\u0000\u009c\u009a\u0001\u0000"+
		"\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u0011\u0001\u0000"+
		"\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00e9\u0003\u001a"+
		"\r\u0000\u00a2\u00e9\u0003\u001c\u000e\u0000\u00a3\u00a4\u0005\u0017\u0000"+
		"\u0000\u00a4\u00a6\u0005!\u0000\u0000\u00a5\u00a7\u0003\u001e\u000f\u0000"+
		"\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\"\u0000\u0000\u00a9"+
		"\u00e9\u0005?\u0000\u0000\u00aa\u00ab\u0005\f\u0000\u0000\u00ab\u00ac"+
		"\u0005!\u0000\u0000\u00ac\u00ad\u0003\u001e\u000f\u0000\u00ad\u00ae\u0005"+
		"\"\u0000\u0000\u00ae\u00af\u0005\r\u0000\u0000\u00af\u00b0\u0005?\u0000"+
		"\u0000\u00b0\u00b1\u0003\u0016\u000b\u0000\u00b1\u00b2\u0003\u0014\n\u0000"+
		"\u00b2\u00e9\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0015\u0000\u0000"+
		"\u00b4\u00b5\u0005!\u0000\u0000\u00b5\u00b6\u0003\u001e\u000f\u0000\u00b6"+
		"\u00b7\u0005\"\u0000\u0000\u00b7\u00b8\u0005\u0016\u0000\u0000\u00b8\u00b9"+
		"\u0005?\u0000\u0000\u00b9\u00ba\u0003\u0016\u000b\u0000\u00ba\u00e9\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bc\u0005\u0016\u0000\u0000\u00bc\u00bd\u0005"+
		"\u001e\u0000\u0000\u00bd\u00be\u0005?\u0000\u0000\u00be\u00bf\u0003\u0016"+
		"\u000b\u0000\u00bf\u00c0\u0005\u0015\u0000\u0000\u00c0\u00c1\u0005!\u0000"+
		"\u0000\u00c1\u00c2\u0003\u001e\u000f\u0000\u00c2\u00c3\u0005\"\u0000\u0000"+
		"\u00c3\u00c4\u0005?\u0000\u0000\u00c4\u00e9\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005\u0013\u0000\u0000\u00c6\u00c7\u0005!\u0000\u0000\u00c7\u00c8"+
		"\u0003 \u0010\u0000\u00c8\u00c9\u00058\u0000\u0000\u00c9\u00ca\u00053"+
		"\u0000\u0000\u00ca\u00cb\u0003\u001e\u000f\u0000\u00cb\u00cc\u0005\'\u0000"+
		"\u0000\u00cc\u00cd\u0003\u001e\u000f\u0000\u00cd\u00ce\u0005\'\u0000\u0000"+
		"\u00ce\u00cf\u00058\u0000\u0000\u00cf\u00d0\u0007\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0005\"\u0000\u0000\u00d1\u00d2\u0005\u001e\u0000\u0000\u00d2\u00d3"+
		"\u0005?\u0000\u0000\u00d3\u00d4\u0003\u0016\u000b\u0000\u00d4\u00e9\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0005\u0010\u0000\u0000\u00d6\u00d7\u0005"+
		"!\u0000\u0000\u00d7\u00d8\u0003\u001e\u000f\u0000\u00d8\u00d9\u0005\""+
		"\u0000\u0000\u00d9\u00da\u0005\u001e\u0000\u0000\u00da\u00db\u0005?\u0000"+
		"\u0000\u00db\u00dc\u0005\u0001\u0000\u0000\u00dc\u00dd\u0003\u0018\f\u0000"+
		"\u00dd\u00de\u0005\u0002\u0000\u0000\u00de\u00e9\u0001\u0000\u0000\u0000"+
		"\u00df\u00e1\u0005\u001b\u0000\u0000\u00e0\u00e2\u0003\u001e\u000f\u0000"+
		"\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e9\u0005?\u0000\u0000\u00e4"+
		"\u00e5\u0005\u0012\u0000\u0000\u00e5\u00e9\u0005?\u0000\u0000\u00e6\u00e7"+
		"\u0005\u0014\u0000\u0000\u00e7\u00e9\u0005?\u0000\u0000\u00e8\u00a1\u0001"+
		"\u0000\u0000\u0000\u00e8\u00a2\u0001\u0000\u0000\u0000\u00e8\u00a3\u0001"+
		"\u0000\u0000\u0000\u00e8\u00aa\u0001\u0000\u0000\u0000\u00e8\u00b3\u0001"+
		"\u0000\u0000\u0000\u00e8\u00bb\u0001\u0000\u0000\u0000\u00e8\u00c5\u0001"+
		"\u0000\u0000\u0000\u00e8\u00d5\u0001\u0000\u0000\u0000\u00e8\u00df\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e4\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e9\u0013\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005"+
		"\u000e\u0000\u0000\u00eb\u00ec\u0005!\u0000\u0000\u00ec\u00ed\u0003\u001e"+
		"\u000f\u0000\u00ed\u00ee\u0005\"\u0000\u0000\u00ee\u00ef\u0005\r\u0000"+
		"\u0000\u00ef\u00f0\u0005?\u0000\u0000\u00f0\u00f1\u0003\u0016\u000b\u0000"+
		"\u00f1\u00f3\u0001\u0000\u0000\u0000\u00f2\u00ea\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00fa\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u000f\u0000\u0000"+
		"\u00f8\u00f9\u0005?\u0000\u0000\u00f9\u00fb\u0003\u0016\u000b\u0000\u00fa"+
		"\u00f7\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb"+
		"\u0015\u0001\u0000\u0000\u0000\u00fc\u00fe\u0005\u0001\u0000\u0000\u00fd"+
		"\u00ff\u0003\u0012\t\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100"+
		"\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101"+
		"\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0103"+
		"\u0005\u0002\u0000\u0000\u0103\u0017\u0001\u0000\u0000\u0000\u0104\u0105"+
		"\u0005\u0011\u0000\u0000\u0105\u0106\u0003\u001e\u000f\u0000\u0106\u0107"+
		"\u0005\u001e\u0000\u0000\u0107\u0108\u0005?\u0000\u0000\u0108\u0109\u0003"+
		"\u0016\u000b\u0000\u0109\u010b\u0001\u0000\u0000\u0000\u010a\u0104\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010a\u0001"+
		"\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010e\u0001"+
		"\u0000\u0000\u0000\u010e\u010f\u0005\u001c\u0000\u0000\u010f\u0110\u0005"+
		"\u001e\u0000\u0000\u0110\u0111\u0005?\u0000\u0000\u0111\u0112\u0003\u0016"+
		"\u000b\u0000\u0112\u0019\u0001\u0000\u0000\u0000\u0113\u0116\u0003 \u0010"+
		"\u0000\u0114\u0116\u00058\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000"+
		"\u0115\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000"+
		"\u0117\u0118\u00058\u0000\u0000\u0118\u0119\u00053\u0000\u0000\u0119\u011a"+
		"\u0003\u001e\u000f\u0000\u011a\u011b\u0005?\u0000\u0000\u011b\u014e\u0001"+
		"\u0000\u0000\u0000\u011c\u011f\u0003 \u0010\u0000\u011d\u011f\u00058\u0000"+
		"\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011e\u011d\u0001\u0000\u0000"+
		"\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u0125\u00058\u0000\u0000"+
		"\u0121\u0122\u0005\u001f\u0000\u0000\u0122\u0123\u0003\u001e\u000f\u0000"+
		"\u0123\u0124\u0005 \u0000\u0000\u0124\u0126\u0001\u0000\u0000\u0000\u0125"+
		"\u0121\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127"+
		"\u0125\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128"+
		"\u0129\u0001\u0000\u0000\u0000\u0129\u012a\u00053\u0000\u0000\u012a\u012b"+
		"\u0003\u000e\u0007\u0000\u012b\u012c\u0005?\u0000\u0000\u012c\u014e\u0001"+
		"\u0000\u0000\u0000\u012d\u0130\u0003 \u0010\u0000\u012e\u0130\u00058\u0000"+
		"\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u012e\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u00058\u0000\u0000"+
		"\u0132\u0133\u00053\u0000\u0000\u0133\u0134\u0005$\u0000\u0000\u0134\u0135"+
		"\u0003\u0010\b\u0000\u0135\u0136\u0005%\u0000\u0000\u0136\u0137\u0005"+
		"?\u0000\u0000\u0137\u014e\u0001\u0000\u0000\u0000\u0138\u013b\u0003 \u0010"+
		"\u0000\u0139\u013b\u00058\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000"+
		"\u013a\u0139\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000"+
		"\u013c\u013d\u00058\u0000\u0000\u013d\u014e\u0005?\u0000\u0000\u013e\u0141"+
		"\u0003 \u0010\u0000\u013f\u0141\u00058\u0000\u0000\u0140\u013e\u0001\u0000"+
		"\u0000\u0000\u0140\u013f\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000"+
		"\u0000\u0000\u0142\u0147\u00058\u0000\u0000\u0143\u0144\u0005\u001f\u0000"+
		"\u0000\u0144\u0145\u0003\u001e\u000f\u0000\u0145\u0146\u0005 \u0000\u0000"+
		"\u0146\u0148\u0001\u0000\u0000\u0000\u0147\u0143\u0001\u0000\u0000\u0000"+
		"\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000"+
		"\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000"+
		"\u014b\u014c\u0005?\u0000\u0000\u014c\u014e\u0001\u0000\u0000\u0000\u014d"+
		"\u0115\u0001\u0000\u0000\u0000\u014d\u011e\u0001\u0000\u0000\u0000\u014d"+
		"\u012f\u0001\u0000\u0000\u0000\u014d\u013a\u0001\u0000\u0000\u0000\u014d"+
		"\u0140\u0001\u0000\u0000\u0000\u014e\u001b\u0001\u0000\u0000\u0000\u014f"+
		"\u0150\u00058\u0000\u0000\u0150\u0151\u0005&\u0000\u0000\u0151\u0152\u0005"+
		"8\u0000\u0000\u0152\u0153\u00053\u0000\u0000\u0153\u0154\u0003\u001e\u000f"+
		"\u0000\u0154\u0155\u0005?\u0000\u0000\u0155\u017e\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u00058\u0000\u0000\u0157\u0158\u0005&\u0000\u0000\u0158\u015d"+
		"\u00058\u0000\u0000\u0159\u015a\u0005\u001f\u0000\u0000\u015a\u015b\u0003"+
		"\u001e\u000f\u0000\u015b\u015c\u0005 \u0000\u0000\u015c\u015e\u0001\u0000"+
		"\u0000\u0000\u015d\u0159\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000"+
		"\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000"+
		"\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u0162\u00053\u0000"+
		"\u0000\u0162\u0163\u0003\u001e\u000f\u0000\u0163\u0164\u0005?\u0000\u0000"+
		"\u0164\u017e\u0001\u0000\u0000\u0000\u0165\u016a\u00058\u0000\u0000\u0166"+
		"\u0167\u0005\u001f\u0000\u0000\u0167\u0168\u0003\u001e\u000f\u0000\u0168"+
		"\u0169\u0005 \u0000\u0000\u0169\u016b\u0001\u0000\u0000\u0000\u016a\u0166"+
		"\u0001\u0000\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016a"+
		"\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016e"+
		"\u0001\u0000\u0000\u0000\u016e\u016f\u00053\u0000\u0000\u016f\u0170\u0003"+
		"\u001e\u000f\u0000\u0170\u0171\u0005?\u0000\u0000\u0171\u017e\u0001\u0000"+
		"\u0000\u0000\u0172\u0173\u00058\u0000\u0000\u0173\u0174\u00053\u0000\u0000"+
		"\u0174\u0175\u0003\u001e\u000f\u0000\u0175\u0176\u0005?\u0000\u0000\u0176"+
		"\u017e\u0001\u0000\u0000\u0000\u0177\u0178\u00058\u0000\u0000\u0178\u0179"+
		"\u00051\u0000\u0000\u0179\u017e\u0005?\u0000\u0000\u017a\u017b\u00058"+
		"\u0000\u0000\u017b\u017c\u00052\u0000\u0000\u017c\u017e\u0005?\u0000\u0000"+
		"\u017d\u014f\u0001\u0000\u0000\u0000\u017d\u0156\u0001\u0000\u0000\u0000"+
		"\u017d\u0165\u0001\u0000\u0000\u0000\u017d\u0172\u0001\u0000\u0000\u0000"+
		"\u017d\u0177\u0001\u0000\u0000\u0000\u017d\u017a\u0001\u0000\u0000\u0000"+
		"\u017e\u001d\u0001\u0000\u0000\u0000\u017f\u0180\u0006\u000f\uffff\uffff"+
		"\u0000\u0180\u0181\u00055\u0000\u0000\u0181\u019f\u0003\u001e\u000f\u0013"+
		"\u0182\u0183\u00050\u0000\u0000\u0183\u019f\u0003\u001e\u000f\u0012\u0184"+
		"\u0185\u0005!\u0000\u0000\u0185\u0186\u0003\u001e\u000f\u0000\u0186\u0187"+
		"\u0005\"\u0000\u0000\u0187\u019f\u0001\u0000\u0000\u0000\u0188\u018d\u0005"+
		"8\u0000\u0000\u0189\u018a\u0005\u001f\u0000\u0000\u018a\u018b\u0003\u001e"+
		"\u000f\u0000\u018b\u018c\u0005 \u0000\u0000\u018c\u018e\u0001\u0000\u0000"+
		"\u0000\u018d\u0189\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000"+
		"\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000"+
		"\u0000\u0190\u019f\u0001\u0000\u0000\u0000\u0191\u0192\u00058\u0000\u0000"+
		"\u0192\u0193\u0005&\u0000\u0000\u0193\u019f\u00058\u0000\u0000\u0194\u0195"+
		"\u0005\u0018\u0000\u0000\u0195\u0196\u0005!\u0000\u0000\u0196\u019f\u0005"+
		"\"\u0000\u0000\u0197\u019f\u0005\u0019\u0000\u0000\u0198\u019f\u0005\u001a"+
		"\u0000\u0000\u0199\u019f\u00058\u0000\u0000\u019a\u019f\u00059\u0000\u0000"+
		"\u019b\u019f\u0005:\u0000\u0000\u019c\u019f\u0005;\u0000\u0000\u019d\u019f"+
		"\u0005<\u0000\u0000\u019e\u017f\u0001\u0000\u0000\u0000\u019e\u0182\u0001"+
		"\u0000\u0000\u0000\u019e\u0184\u0001\u0000\u0000\u0000\u019e\u0188\u0001"+
		"\u0000\u0000\u0000\u019e\u0191\u0001\u0000\u0000\u0000\u019e\u0194\u0001"+
		"\u0000\u0000\u0000\u019e\u0197\u0001\u0000\u0000\u0000\u019e\u0198\u0001"+
		"\u0000\u0000\u0000\u019e\u0199\u0001\u0000\u0000\u0000\u019e\u019a\u0001"+
		"\u0000\u0000\u0000\u019e\u019b\u0001\u0000\u0000\u0000\u019e\u019c\u0001"+
		"\u0000\u0000\u0000\u019e\u019d\u0001\u0000\u0000\u0000\u019f\u01b4\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a1\n\u0010\u0000\u0000\u01a1\u01a2\u0007\u0001"+
		"\u0000\u0000\u01a2\u01b3\u0003\u001e\u000f\u0011\u01a3\u01a4\n\u000f\u0000"+
		"\u0000\u01a4\u01a5\u0007\u0002\u0000\u0000\u01a5\u01b3\u0003\u001e\u000f"+
		"\u0010\u01a6\u01a7\n\u000e\u0000\u0000\u01a7\u01a8\u0007\u0003\u0000\u0000"+
		"\u01a8\u01b3\u0003\u001e\u000f\u000f\u01a9\u01aa\n\r\u0000\u0000\u01aa"+
		"\u01ab\u0007\u0004\u0000\u0000\u01ab\u01b3\u0003\u001e\u000f\u000e\u01ac"+
		"\u01ad\n\f\u0000\u0000\u01ad\u01ae\u0007\u0005\u0000\u0000\u01ae\u01b3"+
		"\u0003\u001e\u000f\r\u01af\u01b0\n\u000b\u0000\u0000\u01b0\u01b1\u0007"+
		"\u0006\u0000\u0000\u01b1\u01b3\u0003\u001e\u000f\f\u01b2\u01a0\u0001\u0000"+
		"\u0000\u0000\u01b2\u01a3\u0001\u0000\u0000\u0000\u01b2\u01a6\u0001\u0000"+
		"\u0000\u0000\u01b2\u01a9\u0001\u0000\u0000\u0000\u01b2\u01ac\u0001\u0000"+
		"\u0000\u0000\u01b2\u01af\u0001\u0000\u0000\u0000\u01b3\u01b6\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000"+
		"\u0000\u0000\u01b5\u001f\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000"+
		"\u0000\u0000\u01b7\u01b8\u0007\u0007\u0000\u0000\u01b8!\u0001\u0000\u0000"+
		"\u0000\'%)/:FPX^gmty\u0080\u0087\u008a\u0096\u009e\u00a6\u00e1\u00e8\u00f4"+
		"\u00fa\u0100\u010c\u0115\u011e\u0127\u012f\u013a\u0140\u0149\u014d\u015f"+
		"\u016c\u017d\u018f\u019e\u01b2\u01b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}