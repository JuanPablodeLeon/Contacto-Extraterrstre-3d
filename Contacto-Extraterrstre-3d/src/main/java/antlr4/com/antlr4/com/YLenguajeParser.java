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
		HACER=22, IMPRIMIR=23, LEER=24, VERDADERO=25, FALSO=26, RETORNAR=27, SIEMPRE=28, 
		RETORNO_FUNC=29, DOS_PUNTOS=30, LCORCH=31, RCORCH=32, LPAREN=33, RPAREN=34, 
		COMA=35, LLLAVE=36, RLLAVE=37, PUNTO=38, PUNTO_COMA=39, IGUAL=40, NO_IGUAL=41, 
		MENOR_IGUAL=42, MAYOR_IGUAL=43, MENOR=44, MAYOR=45, AND=46, OR=47, NOT=48, 
		INCREMENTO=49, DECREMENTO=50, ADD_ASSIGN=51, SUB_ASSIGN=52, MUL_ASSIGN=53, 
		DIV_ASSIGN=54, ASIG=55, SUMA=56, RESTA=57, MULT=58, DIV=59, MOD=60, ID=61, 
		INT=62, DECIMAL=63, STRING=64, CHAR=65, LINE_COMMENT=66, BLOCK_COMMENT=67, 
		NEWLINE=68, TAB=69;
	public static final int
		RULE_inicio = 0, RULE_bloq_estruc = 1, RULE_esctruc = 2, RULE_bloq_func = 3, 
		RULE_bloc_func = 4, RULE_params = 5, RULE_tipos_params = 6, RULE_bloc_llaves = 7, 
		RULE_val_arreglo = 8, RULE_instrucciones = 9, RULE_bloc_si = 10, RULE_bloque = 11, 
		RULE_llamada = 12, RULE_bloque_elegir = 13, RULE_definiciones = 14, RULE_asignaciones = 15, 
		RULE_expresion = 16, RULE_tipos = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "bloq_estruc", "esctruc", "bloq_func", "bloc_func", "params", 
			"tipos_params", "bloc_llaves", "val_arreglo", "instrucciones", "bloc_si", 
			"bloque", "llamada", "bloque_elegir", "definiciones", "asignaciones", 
			"expresion", "tipos"
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
			"'+='", "'-='", "'*='", "'/='", "'='", "'+'", "'-'", "'*'", "'/'", "'%'"
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
			"NOT", "INCREMENTO", "DECREMENTO", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
			"DIV_ASSIGN", "ASIG", "SUMA", "RESTA", "MULT", "DIV", "MOD", "ID", "INT", 
			"DECIMAL", "STRING", "CHAR", "LINE_COMMENT", "BLOCK_COMMENT", "NEWLINE", 
			"TAB"
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(36);
				match(NEWLINE);
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ESTRUCTURAS) {
				{
				setState(42);
				bloq_estruc();
				}
			}

			setState(45);
			bloq_func();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(46);
				match(NEWLINE);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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
			setState(54);
			match(ESTRUCTURAS);
			setState(55);
			match(NEWLINE);
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INDENT:
				{
				setState(56);
				match(INDENT);
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(57);
					esctruc();
					}
					}
					setState(60); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ESTRUCTURA );
				setState(62);
				match(DEDENT);
				}
				break;
			case ESTRUCTURA:
			case FUNCIONES:
				{
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ESTRUCTURA) {
					{
					{
					setState(64);
					esctruc();
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
			setState(72);
			match(ESTRUCTURA);
			setState(73);
			match(ID);
			setState(74);
			match(DOS_PUNTOS);
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
				definiciones();
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2305843009213694944L) != 0) );
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
			setState(84);
			match(FUNCIONES);
			setState(85);
			match(NEWLINE);
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INDENT:
				{
				setState(86);
				match(INDENT);
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(87);
					bloc_func();
					}
					}
					setState(90); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DEFINIR );
				setState(92);
				match(DEDENT);
				}
				break;
			case EOF:
			case DEFINIR:
			case NEWLINE:
				{
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DEFINIR) {
					{
					{
					setState(94);
					bloc_func();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(DEFINIR);
				setState(103);
				match(ID);
				setState(104);
				match(LPAREN);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2305843080080655328L) != 0)) {
					{
					setState(105);
					params();
					}
				}

				setState(108);
				match(RPAREN);
				setState(109);
				match(RETORNO_FUNC);
				setState(112);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(110);
					tipos();
					}
					break;
				case ID:
					{
					setState(111);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(114);
				match(DOS_PUNTOS);
				setState(115);
				match(NEWLINE);
				setState(116);
				bloque();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(DEFINIR);
				setState(118);
				match(ID);
				setState(119);
				match(LPAREN);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2305843080080655328L) != 0)) {
					{
					setState(120);
					params();
					}
				}

				setState(123);
				match(RPAREN);
				setState(124);
				match(DOS_PUNTOS);
				setState(125);
				match(NEWLINE);
				setState(126);
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
			setState(129);
			tipos_params();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(130);
				match(COMA);
				setState(131);
				tipos_params();
				}
				}
				setState(136);
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
			setState(156);
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
				setState(139);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(137);
					tipos();
					}
					break;
				case ID:
					{
					setState(138);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(141);
				match(ID);
				}
				break;
			case LCORCH:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(LCORCH);
				setState(143);
				match(RCORCH);
				setState(146);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(144);
					tipos();
					}
					break;
				case ID:
					{
					setState(145);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(148);
				match(ID);
				}
				break;
			case LLLAVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				match(LLLAVE);
				setState(150);
				match(RLLAVE);
				setState(153);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(151);
					tipos();
					}
					break;
				case ID:
					{
					setState(152);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(155);
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
			setState(158);
			match(LLLAVE);
			setState(159);
			val_arreglo();
			setState(160);
			match(RLLAVE);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(161);
				match(COMA);
				setState(162);
				match(LLLAVE);
				setState(163);
				val_arreglo();
				setState(164);
				match(RLLAVE);
				}
				}
				setState(170);
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
			setState(171);
			expresion(0);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(172);
				match(COMA);
				setState(173);
				expresion(0);
				}
				}
				setState(178);
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
		public LlamadaContext llamada() {
			return getRuleContext(LlamadaContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YLenguajeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YLenguajeParser.NEWLINE, i);
		}
		public TerminalNode LEER() { return getToken(YLenguajeParser.LEER, 0); }
		public TerminalNode LPAREN() { return getToken(YLenguajeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(YLenguajeParser.RPAREN, 0); }
		public TerminalNode IMPRIMIR() { return getToken(YLenguajeParser.IMPRIMIR, 0); }
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
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				definiciones();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				asignaciones();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				llamada();
				setState(182);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				match(LEER);
				setState(185);
				match(LPAREN);
				setState(186);
				match(RPAREN);
				setState(187);
				match(NEWLINE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(188);
				match(NEWLINE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(189);
				match(IMPRIMIR);
				setState(190);
				match(LPAREN);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 4269214269959L) != 0)) {
					{
					setState(191);
					expresion(0);
					}
				}

				setState(194);
				match(RPAREN);
				setState(195);
				match(NEWLINE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(196);
				match(SI);
				setState(197);
				match(LPAREN);
				setState(198);
				expresion(0);
				setState(199);
				match(RPAREN);
				setState(200);
				match(ENTONCES);
				setState(201);
				match(NEWLINE);
				setState(202);
				bloque();
				setState(203);
				bloc_si();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(205);
				match(MIENTRAS);
				setState(206);
				match(LPAREN);
				setState(207);
				expresion(0);
				setState(208);
				match(RPAREN);
				setState(209);
				match(HACER);
				setState(210);
				match(NEWLINE);
				setState(211);
				bloque();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(213);
				match(HACER);
				setState(214);
				match(DOS_PUNTOS);
				setState(215);
				match(NEWLINE);
				setState(216);
				bloque();
				setState(217);
				match(MIENTRAS);
				setState(218);
				match(LPAREN);
				setState(219);
				expresion(0);
				setState(220);
				match(RPAREN);
				setState(221);
				match(NEWLINE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(223);
				match(PARA);
				setState(224);
				match(LPAREN);
				setState(225);
				tipos();
				setState(226);
				match(ID);
				setState(227);
				match(ASIG);
				setState(228);
				expresion(0);
				setState(229);
				match(PUNTO_COMA);
				setState(230);
				expresion(0);
				setState(231);
				match(PUNTO_COMA);
				setState(232);
				match(ID);
				setState(233);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(234);
				match(RPAREN);
				setState(235);
				match(DOS_PUNTOS);
				setState(236);
				match(NEWLINE);
				setState(237);
				bloque();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(239);
				match(ELEGITR);
				setState(240);
				match(LPAREN);
				setState(241);
				expresion(0);
				setState(242);
				match(RPAREN);
				setState(243);
				match(DOS_PUNTOS);
				setState(244);
				match(NEWLINE);
				setState(245);
				match(INDENT);
				setState(246);
				bloque_elegir();
				setState(247);
				match(DEDENT);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(249);
				match(RETORNAR);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 4269214269959L) != 0)) {
					{
					setState(250);
					expresion(0);
					}
				}

				setState(253);
				match(NEWLINE);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(254);
				match(ROMPER);
				setState(255);
				match(NEWLINE);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(256);
				match(CONTINUAR);
				setState(257);
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
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SINO) {
				{
				{
				setState(260);
				match(SINO);
				setState(261);
				match(LPAREN);
				setState(262);
				expresion(0);
				setState(263);
				match(RPAREN);
				setState(264);
				match(ENTONCES);
				setState(265);
				match(NEWLINE);
				setState(266);
				bloque();
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONTRARIO) {
				{
				setState(273);
				match(CONTRARIO);
				setState(274);
				match(NEWLINE);
				setState(275);
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
			setState(278);
			match(INDENT);
			setState(280); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(279);
				instrucciones();
				}
				}
				setState(282); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -9151314442811610977L) != 0) );
			setState(284);
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
	public static class LlamadaContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(YLenguajeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YLenguajeParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(YLenguajeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(YLenguajeParser.RPAREN, 0); }
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
		public TerminalNode PUNTO() { return getToken(YLenguajeParser.PUNTO, 0); }
		public LlamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).enterLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YLenguajeParserListener ) ((YLenguajeParserListener)listener).exitLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YLenguajeParserVisitor ) return ((YLenguajeParserVisitor<? extends T>)visitor).visitLlamada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadaContext llamada() throws RecognitionException {
		LlamadaContext _localctx = new LlamadaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_llamada);
		int _la;
		try {
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(ID);
				setState(287);
				match(LPAREN);
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 4269214269959L) != 0)) {
					{
					setState(288);
					expresion(0);
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(289);
						match(COMA);
						setState(290);
						expresion(0);
						}
						}
						setState(295);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(298);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				match(ID);
				setState(300);
				match(PUNTO);
				setState(301);
				match(ID);
				setState(302);
				match(LPAREN);
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 4269214269959L) != 0)) {
					{
					setState(303);
					expresion(0);
					setState(308);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(304);
						match(COMA);
						setState(305);
						expresion(0);
						}
						}
						setState(310);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(313);
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
		enterRule(_localctx, 26, RULE_bloque_elegir);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(316);
				match(CASO);
				setState(317);
				expresion(0);
				setState(318);
				match(DOS_PUNTOS);
				setState(319);
				match(NEWLINE);
				setState(320);
				bloque();
				}
				}
				setState(324); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASO );
			setState(326);
			match(SIEMPRE);
			setState(327);
			match(DOS_PUNTOS);
			setState(328);
			match(NEWLINE);
			setState(329);
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
		enterRule(_localctx, 28, RULE_definiciones);
		int _la;
		try {
			setState(389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(331);
					tipos();
					}
					break;
				case ID:
					{
					setState(332);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(335);
				match(ID);
				setState(336);
				match(ASIG);
				setState(337);
				expresion(0);
				setState(338);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(340);
					tipos();
					}
					break;
				case ID:
					{
					setState(341);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
				bloc_llaves();
				setState(355);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(359);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(357);
					tipos();
					}
					break;
				case ID:
					{
					setState(358);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(361);
				match(ID);
				setState(362);
				match(ASIG);
				setState(363);
				match(LLLAVE);
				setState(364);
				val_arreglo();
				setState(365);
				match(RLLAVE);
				setState(366);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(370);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(368);
					tipos();
					}
					break;
				case ID:
					{
					setState(369);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(372);
				match(ID);
				setState(373);
				match(NEWLINE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(376);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CADENA:
				case ENTERO:
				case FLOTANTE:
				case CARACTER:
				case BOOL:
					{
					setState(374);
					tipos();
					}
					break;
				case ID:
					{
					setState(375);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(378);
				match(ID);
				setState(383); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(379);
					match(LCORCH);
					setState(380);
					expresion(0);
					setState(381);
					match(RCORCH);
					}
					}
					setState(385); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(387);
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
		public TerminalNode ADD_ASSIGN() { return getToken(YLenguajeParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(YLenguajeParser.SUB_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(YLenguajeParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(YLenguajeParser.DIV_ASSIGN, 0); }
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
		enterRule(_localctx, 30, RULE_asignaciones);
		int _la;
		try {
			setState(508);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				match(ID);
				setState(392);
				match(PUNTO);
				setState(393);
				match(ID);
				setState(394);
				match(ASIG);
				setState(395);
				expresion(0);
				setState(396);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				match(ID);
				setState(399);
				match(PUNTO);
				setState(400);
				match(ID);
				setState(405); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(401);
					match(LCORCH);
					setState(402);
					expresion(0);
					setState(403);
					match(RCORCH);
					}
					}
					setState(407); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(409);
				match(ASIG);
				setState(410);
				expresion(0);
				setState(411);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(413);
				match(ID);
				setState(418); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(414);
					match(LCORCH);
					setState(415);
					expresion(0);
					setState(416);
					match(RCORCH);
					}
					}
					setState(420); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(422);
				match(ASIG);
				setState(423);
				expresion(0);
				setState(424);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(426);
				match(ID);
				setState(427);
				match(ASIG);
				setState(428);
				expresion(0);
				setState(429);
				match(NEWLINE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(431);
				match(ID);
				setState(432);
				match(INCREMENTO);
				setState(433);
				match(NEWLINE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(434);
				match(ID);
				setState(435);
				match(DECREMENTO);
				setState(436);
				match(NEWLINE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(437);
				match(ID);
				setState(438);
				match(PUNTO);
				setState(439);
				match(ID);
				setState(440);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(441);
				match(NEWLINE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(442);
				match(ID);
				setState(443);
				match(PUNTO);
				setState(444);
				match(ID);
				setState(449); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(445);
					match(LCORCH);
					setState(446);
					expresion(0);
					setState(447);
					match(RCORCH);
					}
					}
					setState(451); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(453);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(454);
				match(NEWLINE);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(456);
				match(ID);
				setState(461); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(457);
					match(LCORCH);
					setState(458);
					expresion(0);
					setState(459);
					match(RCORCH);
					}
					}
					setState(463); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(465);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(466);
				match(NEWLINE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(468);
				match(ID);
				setState(469);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33776997205278720L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(470);
				expresion(0);
				setState(471);
				match(NEWLINE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(473);
				match(ID);
				setState(474);
				match(PUNTO);
				setState(475);
				match(ID);
				setState(476);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33776997205278720L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(477);
				expresion(0);
				setState(478);
				match(NEWLINE);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(480);
				match(ID);
				setState(481);
				match(PUNTO);
				setState(482);
				match(ID);
				setState(487); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(483);
					match(LCORCH);
					setState(484);
					expresion(0);
					setState(485);
					match(RCORCH);
					}
					}
					setState(489); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(491);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33776997205278720L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(492);
				expresion(0);
				setState(493);
				match(NEWLINE);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(495);
				match(ID);
				setState(500); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(496);
					match(LCORCH);
					setState(497);
					expresion(0);
					setState(498);
					match(RCORCH);
					}
					}
					setState(502); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LCORCH );
				setState(504);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33776997205278720L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(505);
				expresion(0);
				setState(506);
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
		public List<TerminalNode> COMA() { return getTokens(YLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(YLenguajeParser.COMA, i);
		}
		public TerminalNode LEER() { return getToken(YLenguajeParser.LEER, 0); }
		public TerminalNode VERDADERO() { return getToken(YLenguajeParser.VERDADERO, 0); }
		public TerminalNode FALSO() { return getToken(YLenguajeParser.FALSO, 0); }
		public TerminalNode INT() { return getToken(YLenguajeParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(YLenguajeParser.DECIMAL, 0); }
		public TerminalNode STRING() { return getToken(YLenguajeParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(YLenguajeParser.CHAR, 0); }
		public TerminalNode MULT() { return getToken(YLenguajeParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(YLenguajeParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(YLenguajeParser.MOD, 0); }
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(511);
				match(RESTA);
				setState(512);
				expresion(22);
				}
				break;
			case 2:
				{
				setState(513);
				match(NOT);
				setState(514);
				expresion(21);
				}
				break;
			case 3:
				{
				setState(515);
				match(LPAREN);
				setState(516);
				expresion(0);
				setState(517);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(519);
				match(ID);
				setState(524); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(520);
						match(LCORCH);
						setState(521);
						expresion(0);
						setState(522);
						match(RCORCH);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(526); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				{
				setState(528);
				match(ID);
				setState(529);
				match(PUNTO);
				setState(530);
				match(ID);
				}
				break;
			case 6:
				{
				setState(531);
				match(ID);
				setState(532);
				match(PUNTO);
				setState(533);
				match(ID);
				setState(538); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(534);
						match(LCORCH);
						setState(535);
						expresion(0);
						setState(536);
						match(RCORCH);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(540); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 7:
				{
				setState(542);
				match(ID);
				setState(543);
				match(LPAREN);
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 4269214269959L) != 0)) {
					{
					setState(544);
					expresion(0);
					setState(549);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(545);
						match(COMA);
						setState(546);
						expresion(0);
						}
						}
						setState(551);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(554);
				match(RPAREN);
				}
				break;
			case 8:
				{
				setState(555);
				match(ID);
				setState(556);
				match(PUNTO);
				setState(557);
				match(ID);
				setState(558);
				match(LPAREN);
				setState(567);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 4269214269959L) != 0)) {
					{
					setState(559);
					expresion(0);
					setState(564);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(560);
						match(COMA);
						setState(561);
						expresion(0);
						}
						}
						setState(566);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(569);
				match(RPAREN);
				}
				break;
			case 9:
				{
				setState(570);
				match(LEER);
				setState(571);
				match(LPAREN);
				setState(572);
				match(RPAREN);
				}
				break;
			case 10:
				{
				setState(573);
				match(VERDADERO);
				}
				break;
			case 11:
				{
				setState(574);
				match(FALSO);
				}
				break;
			case 12:
				{
				setState(575);
				match(ID);
				}
				break;
			case 13:
				{
				setState(576);
				match(INT);
				}
				break;
			case 14:
				{
				setState(577);
				match(DECIMAL);
				}
				break;
			case 15:
				{
				setState(578);
				match(STRING);
				}
				break;
			case 16:
				{
				setState(579);
				match(CHAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(602);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(600);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(582);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(583);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017612633061982208L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(584);
						expresion(20);
						}
						break;
					case 2:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(585);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(586);
						_la = _input.LA(1);
						if ( !(_la==SUMA || _la==RESTA) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(587);
						expresion(19);
						}
						break;
					case 3:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(588);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(589);
						_la = _input.LA(1);
						if ( !(_la==IGUAL || _la==NO_IGUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(590);
						expresion(18);
						}
						break;
					case 4:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(591);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(592);
						_la = _input.LA(1);
						if ( !(_la==MENOR_IGUAL || _la==MAYOR_IGUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(593);
						expresion(17);
						}
						break;
					case 5:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(594);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(595);
						_la = _input.LA(1);
						if ( !(_la==MENOR || _la==MAYOR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(596);
						expresion(16);
						}
						break;
					case 6:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(597);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(598);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(599);
						expresion(15);
						}
						break;
					}
					} 
				}
				setState(604);
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
		enterRule(_localctx, 34, RULE_tipos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
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
		case 16:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001E\u0260\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0005\u0000"+
		"&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0000\u0003\u0000,\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u00003\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004"+
		"\u0001;\b\u0001\u000b\u0001\f\u0001<\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001B\b\u0001\n\u0001\f\u0001E\t\u0001\u0003\u0001G\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004"+
		"\u0002O\b\u0002\u000b\u0002\f\u0002P\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003Y\b\u0003\u000b\u0003"+
		"\f\u0003Z\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003`\b\u0003\n\u0003"+
		"\f\u0003c\t\u0003\u0003\u0003e\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004k\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004q\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004z\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0080\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0085\b\u0005\n\u0005"+
		"\f\u0005\u0088\t\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u008c\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u0093\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u009a\b\u0006\u0001\u0006\u0003\u0006\u009d\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u00a7\b\u0007\n\u0007\f\u0007\u00aa\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0005\b\u00af\b\b\n\b\f\b\u00b2\t\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00c1\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00fc"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0103\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u010d"+
		"\b\n\n\n\f\n\u0110\t\n\u0001\n\u0001\n\u0001\n\u0003\n\u0115\b\n\u0001"+
		"\u000b\u0001\u000b\u0004\u000b\u0119\b\u000b\u000b\u000b\f\u000b\u011a"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u0124\b\f\n\f\f\f\u0127\t\f\u0003\f\u0129\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0133\b\f\n\f\f\f\u0136"+
		"\t\f\u0003\f\u0138\b\f\u0001\f\u0003\f\u013b\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0004\r\u0143\b\r\u000b\r\f\r\u0144\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e\u014e"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u0157\b\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u015e\b\u000e\u000b\u000e\f"+
		"\u000e\u015f\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u0168\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0173\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0179\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0004\u000e\u0180\b\u000e\u000b\u000e\f\u000e\u0181\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u0186\b\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0004"+
		"\u000f\u0196\b\u000f\u000b\u000f\f\u000f\u0197\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0004\u000f\u01a3\b\u000f\u000b\u000f\f\u000f\u01a4\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u01c2\b\u000f\u000b\u000f\f"+
		"\u000f\u01c3\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u01ce\b\u000f\u000b\u000f"+
		"\f\u000f\u01cf\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f"+
		"\u01e8\b\u000f\u000b\u000f\f\u000f\u01e9\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0004\u000f\u01f5\b\u000f\u000b\u000f\f\u000f\u01f6\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01fd\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0004\u0010\u020d\b\u0010\u000b\u0010\f\u0010\u020e\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u021b\b\u0010\u000b"+
		"\u0010\f\u0010\u021c\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u0224\b\u0010\n\u0010\f\u0010\u0227\t\u0010\u0003\u0010"+
		"\u0229\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0233\b\u0010\n\u0010"+
		"\f\u0010\u0236\t\u0010\u0003\u0010\u0238\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0245\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u0259\b\u0010\n\u0010\f\u0010\u025c\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0000\u0001 \u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\t\u0001\u000012\u0001\u0000"+
		"36\u0001\u0000:<\u0001\u000089\u0001\u0000()\u0001\u0000*+\u0001\u0000"+
		",-\u0001\u0000./\u0001\u0000\u0005\t\u02b3\u0000\'\u0001\u0000\u0000\u0000"+
		"\u00026\u0001\u0000\u0000\u0000\u0004H\u0001\u0000\u0000\u0000\u0006T"+
		"\u0001\u0000\u0000\u0000\b\u007f\u0001\u0000\u0000\u0000\n\u0081\u0001"+
		"\u0000\u0000\u0000\f\u009c\u0001\u0000\u0000\u0000\u000e\u009e\u0001\u0000"+
		"\u0000\u0000\u0010\u00ab\u0001\u0000\u0000\u0000\u0012\u0102\u0001\u0000"+
		"\u0000\u0000\u0014\u010e\u0001\u0000\u0000\u0000\u0016\u0116\u0001\u0000"+
		"\u0000\u0000\u0018\u013a\u0001\u0000\u0000\u0000\u001a\u0142\u0001\u0000"+
		"\u0000\u0000\u001c\u0185\u0001\u0000\u0000\u0000\u001e\u01fc\u0001\u0000"+
		"\u0000\u0000 \u0244\u0001\u0000\u0000\u0000\"\u025d\u0001\u0000\u0000"+
		"\u0000$&\u0005D\u0000\u0000%$\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000"+
		"\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(+\u0001\u0000"+
		"\u0000\u0000)\'\u0001\u0000\u0000\u0000*,\u0003\u0002\u0001\u0000+*\u0001"+
		"\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000"+
		"-1\u0003\u0006\u0003\u0000.0\u0005D\u0000\u0000/.\u0001\u0000\u0000\u0000"+
		"03\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000"+
		"\u000024\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000045\u0005\u0000"+
		"\u0000\u00015\u0001\u0001\u0000\u0000\u000067\u0005\u0003\u0000\u0000"+
		"7F\u0005D\u0000\u00008:\u0005\u0001\u0000\u00009;\u0003\u0004\u0002\u0000"+
		":9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0005\u0002"+
		"\u0000\u0000?G\u0001\u0000\u0000\u0000@B\u0003\u0004\u0002\u0000A@\u0001"+
		"\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000F8\u0001\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000G\u0003\u0001"+
		"\u0000\u0000\u0000HI\u0005\u0004\u0000\u0000IJ\u0005=\u0000\u0000JK\u0005"+
		"\u001e\u0000\u0000KL\u0005D\u0000\u0000LN\u0005\u0001\u0000\u0000MO\u0003"+
		"\u001c\u000e\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000"+
		"PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000RS\u0005\u0002\u0000\u0000S\u0005\u0001\u0000\u0000\u0000TU\u0005"+
		"\n\u0000\u0000Ud\u0005D\u0000\u0000VX\u0005\u0001\u0000\u0000WY\u0003"+
		"\b\u0004\u0000XW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001"+
		"\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\]\u0005\u0002\u0000\u0000]e\u0001\u0000\u0000\u0000^`\u0003\b\u0004"+
		"\u0000_^\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001"+
		"\u0000\u0000\u0000dV\u0001\u0000\u0000\u0000da\u0001\u0000\u0000\u0000"+
		"e\u0007\u0001\u0000\u0000\u0000fg\u0005\u000b\u0000\u0000gh\u0005=\u0000"+
		"\u0000hj\u0005!\u0000\u0000ik\u0003\n\u0005\u0000ji\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0005\"\u0000"+
		"\u0000mp\u0005\u001d\u0000\u0000nq\u0003\"\u0011\u0000oq\u0005=\u0000"+
		"\u0000pn\u0001\u0000\u0000\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000rs\u0005\u001e\u0000\u0000st\u0005D\u0000\u0000t\u0080\u0003"+
		"\u0016\u000b\u0000uv\u0005\u000b\u0000\u0000vw\u0005=\u0000\u0000wy\u0005"+
		"!\u0000\u0000xz\u0003\n\u0005\u0000yx\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0005\"\u0000\u0000|}\u0005"+
		"\u001e\u0000\u0000}~\u0005D\u0000\u0000~\u0080\u0003\u0016\u000b\u0000"+
		"\u007ff\u0001\u0000\u0000\u0000\u007fu\u0001\u0000\u0000\u0000\u0080\t"+
		"\u0001\u0000\u0000\u0000\u0081\u0086\u0003\f\u0006\u0000\u0082\u0083\u0005"+
		"#\u0000\u0000\u0083\u0085\u0003\f\u0006\u0000\u0084\u0082\u0001\u0000"+
		"\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u000b\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008c\u0003\"\u0011"+
		"\u0000\u008a\u008c\u0005=\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000"+
		"\u008d\u009d\u0005=\u0000\u0000\u008e\u008f\u0005\u001f\u0000\u0000\u008f"+
		"\u0092\u0005 \u0000\u0000\u0090\u0093\u0003\"\u0011\u0000\u0091\u0093"+
		"\u0005=\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0091\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u009d\u0005"+
		"=\u0000\u0000\u0095\u0096\u0005$\u0000\u0000\u0096\u0099\u0005%\u0000"+
		"\u0000\u0097\u009a\u0003\"\u0011\u0000\u0098\u009a\u0005=\u0000\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0005=\u0000\u0000\u009c"+
		"\u008b\u0001\u0000\u0000\u0000\u009c\u008e\u0001\u0000\u0000\u0000\u009c"+
		"\u0095\u0001\u0000\u0000\u0000\u009d\r\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0005$\u0000\u0000\u009f\u00a0\u0003\u0010\b\u0000\u00a0\u00a8\u0005"+
		"%\u0000\u0000\u00a1\u00a2\u0005#\u0000\u0000\u00a2\u00a3\u0005$\u0000"+
		"\u0000\u00a3\u00a4\u0003\u0010\b\u0000\u00a4\u00a5\u0005%\u0000\u0000"+
		"\u00a5\u00a7\u0001\u0000\u0000\u0000\u00a6\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u000f\u0001\u0000\u0000\u0000"+
		"\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab\u00b0\u0003 \u0010\u0000\u00ac"+
		"\u00ad\u0005#\u0000\u0000\u00ad\u00af\u0003 \u0010\u0000\u00ae\u00ac\u0001"+
		"\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u0011\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u0103\u0003"+
		"\u001c\u000e\u0000\u00b4\u0103\u0003\u001e\u000f\u0000\u00b5\u00b6\u0003"+
		"\u0018\f\u0000\u00b6\u00b7\u0005D\u0000\u0000\u00b7\u0103\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0005\u0018\u0000\u0000\u00b9\u00ba\u0005!\u0000"+
		"\u0000\u00ba\u00bb\u0005\"\u0000\u0000\u00bb\u0103\u0005D\u0000\u0000"+
		"\u00bc\u0103\u0005D\u0000\u0000\u00bd\u00be\u0005\u0017\u0000\u0000\u00be"+
		"\u00c0\u0005!\u0000\u0000\u00bf\u00c1\u0003 \u0010\u0000\u00c0\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0005\"\u0000\u0000\u00c3\u0103\u0005D"+
		"\u0000\u0000\u00c4\u00c5\u0005\f\u0000\u0000\u00c5\u00c6\u0005!\u0000"+
		"\u0000\u00c6\u00c7\u0003 \u0010\u0000\u00c7\u00c8\u0005\"\u0000\u0000"+
		"\u00c8\u00c9\u0005\r\u0000\u0000\u00c9\u00ca\u0005D\u0000\u0000\u00ca"+
		"\u00cb\u0003\u0016\u000b\u0000\u00cb\u00cc\u0003\u0014\n\u0000\u00cc\u0103"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0015\u0000\u0000\u00ce\u00cf"+
		"\u0005!\u0000\u0000\u00cf\u00d0\u0003 \u0010\u0000\u00d0\u00d1\u0005\""+
		"\u0000\u0000\u00d1\u00d2\u0005\u0016\u0000\u0000\u00d2\u00d3\u0005D\u0000"+
		"\u0000\u00d3\u00d4\u0003\u0016\u000b\u0000\u00d4\u0103\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d6\u0005\u0016\u0000\u0000\u00d6\u00d7\u0005\u001e\u0000"+
		"\u0000\u00d7\u00d8\u0005D\u0000\u0000\u00d8\u00d9\u0003\u0016\u000b\u0000"+
		"\u00d9\u00da\u0005\u0015\u0000\u0000\u00da\u00db\u0005!\u0000\u0000\u00db"+
		"\u00dc\u0003 \u0010\u0000\u00dc\u00dd\u0005\"\u0000\u0000\u00dd\u00de"+
		"\u0005D\u0000\u0000\u00de\u0103\u0001\u0000\u0000\u0000\u00df\u00e0\u0005"+
		"\u0013\u0000\u0000\u00e0\u00e1\u0005!\u0000\u0000\u00e1\u00e2\u0003\""+
		"\u0011\u0000\u00e2\u00e3\u0005=\u0000\u0000\u00e3\u00e4\u00057\u0000\u0000"+
		"\u00e4\u00e5\u0003 \u0010\u0000\u00e5\u00e6\u0005\'\u0000\u0000\u00e6"+
		"\u00e7\u0003 \u0010\u0000\u00e7\u00e8\u0005\'\u0000\u0000\u00e8\u00e9"+
		"\u0005=\u0000\u0000\u00e9\u00ea\u0007\u0000\u0000\u0000\u00ea\u00eb\u0005"+
		"\"\u0000\u0000\u00eb\u00ec\u0005\u001e\u0000\u0000\u00ec\u00ed\u0005D"+
		"\u0000\u0000\u00ed\u00ee\u0003\u0016\u000b\u0000\u00ee\u0103\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u0005\u0010\u0000\u0000\u00f0\u00f1\u0005!\u0000"+
		"\u0000\u00f1\u00f2\u0003 \u0010\u0000\u00f2\u00f3\u0005\"\u0000\u0000"+
		"\u00f3\u00f4\u0005\u001e\u0000\u0000\u00f4\u00f5\u0005D\u0000\u0000\u00f5"+
		"\u00f6\u0005\u0001\u0000\u0000\u00f6\u00f7\u0003\u001a\r\u0000\u00f7\u00f8"+
		"\u0005\u0002\u0000\u0000\u00f8\u0103\u0001\u0000\u0000\u0000\u00f9\u00fb"+
		"\u0005\u001b\u0000\u0000\u00fa\u00fc\u0003 \u0010\u0000\u00fb\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fd\u0103\u0005D\u0000\u0000\u00fe\u00ff\u0005\u0012"+
		"\u0000\u0000\u00ff\u0103\u0005D\u0000\u0000\u0100\u0101\u0005\u0014\u0000"+
		"\u0000\u0101\u0103\u0005D\u0000\u0000\u0102\u00b3\u0001\u0000\u0000\u0000"+
		"\u0102\u00b4\u0001\u0000\u0000\u0000\u0102\u00b5\u0001\u0000\u0000\u0000"+
		"\u0102\u00b8\u0001\u0000\u0000\u0000\u0102\u00bc\u0001\u0000\u0000\u0000"+
		"\u0102\u00bd\u0001\u0000\u0000\u0000\u0102\u00c4\u0001\u0000\u0000\u0000"+
		"\u0102\u00cd\u0001\u0000\u0000\u0000\u0102\u00d5\u0001\u0000\u0000\u0000"+
		"\u0102\u00df\u0001\u0000\u0000\u0000\u0102\u00ef\u0001\u0000\u0000\u0000"+
		"\u0102\u00f9\u0001\u0000\u0000\u0000\u0102\u00fe\u0001\u0000\u0000\u0000"+
		"\u0102\u0100\u0001\u0000\u0000\u0000\u0103\u0013\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0005\u000e\u0000\u0000\u0105\u0106\u0005!\u0000\u0000\u0106"+
		"\u0107\u0003 \u0010\u0000\u0107\u0108\u0005\"\u0000\u0000\u0108\u0109"+
		"\u0005\r\u0000\u0000\u0109\u010a\u0005D\u0000\u0000\u010a\u010b\u0003"+
		"\u0016\u000b\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c\u0104\u0001"+
		"\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010c\u0001"+
		"\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0114\u0001"+
		"\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0112\u0005"+
		"\u000f\u0000\u0000\u0112\u0113\u0005D\u0000\u0000\u0113\u0115\u0003\u0016"+
		"\u000b\u0000\u0114\u0111\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000"+
		"\u0000\u0000\u0115\u0015\u0001\u0000\u0000\u0000\u0116\u0118\u0005\u0001"+
		"\u0000\u0000\u0117\u0119\u0003\u0012\t\u0000\u0118\u0117\u0001\u0000\u0000"+
		"\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000"+
		"\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0005\u0002\u0000\u0000\u011d\u0017\u0001\u0000\u0000"+
		"\u0000\u011e\u011f\u0005=\u0000\u0000\u011f\u0128\u0005!\u0000\u0000\u0120"+
		"\u0125\u0003 \u0010\u0000\u0121\u0122\u0005#\u0000\u0000\u0122\u0124\u0003"+
		" \u0010\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000"+
		"\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000"+
		"\u0000\u0000\u0126\u0129\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000"+
		"\u0000\u0000\u0128\u0120\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000"+
		"\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u013b\u0005\"\u0000"+
		"\u0000\u012b\u012c\u0005=\u0000\u0000\u012c\u012d\u0005&\u0000\u0000\u012d"+
		"\u012e\u0005=\u0000\u0000\u012e\u0137\u0005!\u0000\u0000\u012f\u0134\u0003"+
		" \u0010\u0000\u0130\u0131\u0005#\u0000\u0000\u0131\u0133\u0003 \u0010"+
		"\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0133\u0136\u0001\u0000\u0000"+
		"\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000"+
		"\u0000\u0135\u0138\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000"+
		"\u0000\u0137\u012f\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000"+
		"\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013b\u0005\"\u0000\u0000"+
		"\u013a\u011e\u0001\u0000\u0000\u0000\u013a\u012b\u0001\u0000\u0000\u0000"+
		"\u013b\u0019\u0001\u0000\u0000\u0000\u013c\u013d\u0005\u0011\u0000\u0000"+
		"\u013d\u013e\u0003 \u0010\u0000\u013e\u013f\u0005\u001e\u0000\u0000\u013f"+
		"\u0140\u0005D\u0000\u0000\u0140\u0141\u0003\u0016\u000b\u0000\u0141\u0143"+
		"\u0001\u0000\u0000\u0000\u0142\u013c\u0001\u0000\u0000\u0000\u0143\u0144"+
		"\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0144\u0145"+
		"\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u0147"+
		"\u0005\u001c\u0000\u0000\u0147\u0148\u0005\u001e\u0000\u0000\u0148\u0149"+
		"\u0005D\u0000\u0000\u0149\u014a\u0003\u0016\u000b\u0000\u014a\u001b\u0001"+
		"\u0000\u0000\u0000\u014b\u014e\u0003\"\u0011\u0000\u014c\u014e\u0005="+
		"\u0000\u0000\u014d\u014b\u0001\u0000\u0000\u0000\u014d\u014c\u0001\u0000"+
		"\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f\u0150\u0005=\u0000"+
		"\u0000\u0150\u0151\u00057\u0000\u0000\u0151\u0152\u0003 \u0010\u0000\u0152"+
		"\u0153\u0005D\u0000\u0000\u0153\u0186\u0001\u0000\u0000\u0000\u0154\u0157"+
		"\u0003\"\u0011\u0000\u0155\u0157\u0005=\u0000\u0000\u0156\u0154\u0001"+
		"\u0000\u0000\u0000\u0156\u0155\u0001\u0000\u0000\u0000\u0157\u0158\u0001"+
		"\u0000\u0000\u0000\u0158\u015d\u0005=\u0000\u0000\u0159\u015a\u0005\u001f"+
		"\u0000\u0000\u015a\u015b\u0003 \u0010\u0000\u015b\u015c\u0005 \u0000\u0000"+
		"\u015c\u015e\u0001\u0000\u0000\u0000\u015d\u0159\u0001\u0000\u0000\u0000"+
		"\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000"+
		"\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000"+
		"\u0161\u0162\u00057\u0000\u0000\u0162\u0163\u0003\u000e\u0007\u0000\u0163"+
		"\u0164\u0005D\u0000\u0000\u0164\u0186\u0001\u0000\u0000\u0000\u0165\u0168"+
		"\u0003\"\u0011\u0000\u0166\u0168\u0005=\u0000\u0000\u0167\u0165\u0001"+
		"\u0000\u0000\u0000\u0167\u0166\u0001\u0000\u0000\u0000\u0168\u0169\u0001"+
		"\u0000\u0000\u0000\u0169\u016a\u0005=\u0000\u0000\u016a\u016b\u00057\u0000"+
		"\u0000\u016b\u016c\u0005$\u0000\u0000\u016c\u016d\u0003\u0010\b\u0000"+
		"\u016d\u016e\u0005%\u0000\u0000\u016e\u016f\u0005D\u0000\u0000\u016f\u0186"+
		"\u0001\u0000\u0000\u0000\u0170\u0173\u0003\"\u0011\u0000\u0171\u0173\u0005"+
		"=\u0000\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0172\u0171\u0001\u0000"+
		"\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0175\u0005=\u0000"+
		"\u0000\u0175\u0186\u0005D\u0000\u0000\u0176\u0179\u0003\"\u0011\u0000"+
		"\u0177\u0179\u0005=\u0000\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0178"+
		"\u0177\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a"+
		"\u017f\u0005=\u0000\u0000\u017b\u017c\u0005\u001f\u0000\u0000\u017c\u017d"+
		"\u0003 \u0010\u0000\u017d\u017e\u0005 \u0000\u0000\u017e\u0180\u0001\u0000"+
		"\u0000\u0000\u017f\u017b\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000"+
		"\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000"+
		"\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0184\u0005D\u0000"+
		"\u0000\u0184\u0186\u0001\u0000\u0000\u0000\u0185\u014d\u0001\u0000\u0000"+
		"\u0000\u0185\u0156\u0001\u0000\u0000\u0000\u0185\u0167\u0001\u0000\u0000"+
		"\u0000\u0185\u0172\u0001\u0000\u0000\u0000\u0185\u0178\u0001\u0000\u0000"+
		"\u0000\u0186\u001d\u0001\u0000\u0000\u0000\u0187\u0188\u0005=\u0000\u0000"+
		"\u0188\u0189\u0005&\u0000\u0000\u0189\u018a\u0005=\u0000\u0000\u018a\u018b"+
		"\u00057\u0000\u0000\u018b\u018c\u0003 \u0010\u0000\u018c\u018d\u0005D"+
		"\u0000\u0000\u018d\u01fd\u0001\u0000\u0000\u0000\u018e\u018f\u0005=\u0000"+
		"\u0000\u018f\u0190\u0005&\u0000\u0000\u0190\u0195\u0005=\u0000\u0000\u0191"+
		"\u0192\u0005\u001f\u0000\u0000\u0192\u0193\u0003 \u0010\u0000\u0193\u0194"+
		"\u0005 \u0000\u0000\u0194\u0196\u0001\u0000\u0000\u0000\u0195\u0191\u0001"+
		"\u0000\u0000\u0000\u0196\u0197\u0001\u0000\u0000\u0000\u0197\u0195\u0001"+
		"\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000\u0198\u0199\u0001"+
		"\u0000\u0000\u0000\u0199\u019a\u00057\u0000\u0000\u019a\u019b\u0003 \u0010"+
		"\u0000\u019b\u019c\u0005D\u0000\u0000\u019c\u01fd\u0001\u0000\u0000\u0000"+
		"\u019d\u01a2\u0005=\u0000\u0000\u019e\u019f\u0005\u001f\u0000\u0000\u019f"+
		"\u01a0\u0003 \u0010\u0000\u01a0\u01a1\u0005 \u0000\u0000\u01a1\u01a3\u0001"+
		"\u0000\u0000\u0000\u01a2\u019e\u0001\u0000\u0000\u0000\u01a3\u01a4\u0001"+
		"\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001"+
		"\u0000\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6\u01a7\u0005"+
		"7\u0000\u0000\u01a7\u01a8\u0003 \u0010\u0000\u01a8\u01a9\u0005D\u0000"+
		"\u0000\u01a9\u01fd\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005=\u0000\u0000"+
		"\u01ab\u01ac\u00057\u0000\u0000\u01ac\u01ad\u0003 \u0010\u0000\u01ad\u01ae"+
		"\u0005D\u0000\u0000\u01ae\u01fd\u0001\u0000\u0000\u0000\u01af\u01b0\u0005"+
		"=\u0000\u0000\u01b0\u01b1\u00051\u0000\u0000\u01b1\u01fd\u0005D\u0000"+
		"\u0000\u01b2\u01b3\u0005=\u0000\u0000\u01b3\u01b4\u00052\u0000\u0000\u01b4"+
		"\u01fd\u0005D\u0000\u0000\u01b5\u01b6\u0005=\u0000\u0000\u01b6\u01b7\u0005"+
		"&\u0000\u0000\u01b7\u01b8\u0005=\u0000\u0000\u01b8\u01b9\u0007\u0000\u0000"+
		"\u0000\u01b9\u01fd\u0005D\u0000\u0000\u01ba\u01bb\u0005=\u0000\u0000\u01bb"+
		"\u01bc\u0005&\u0000\u0000\u01bc\u01c1\u0005=\u0000\u0000\u01bd\u01be\u0005"+
		"\u001f\u0000\u0000\u01be\u01bf\u0003 \u0010\u0000\u01bf\u01c0\u0005 \u0000"+
		"\u0000\u01c0\u01c2\u0001\u0000\u0000\u0000\u01c1\u01bd\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c6\u0007\u0000\u0000\u0000\u01c6\u01c7\u0005D\u0000\u0000"+
		"\u01c7\u01fd\u0001\u0000\u0000\u0000\u01c8\u01cd\u0005=\u0000\u0000\u01c9"+
		"\u01ca\u0005\u001f\u0000\u0000\u01ca\u01cb\u0003 \u0010\u0000\u01cb\u01cc"+
		"\u0005 \u0000\u0000\u01cc\u01ce\u0001\u0000\u0000\u0000\u01cd\u01c9\u0001"+
		"\u0000\u0000\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf\u01cd\u0001"+
		"\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0\u01d1\u0001"+
		"\u0000\u0000\u0000\u01d1\u01d2\u0007\u0000\u0000\u0000\u01d2\u01d3\u0005"+
		"D\u0000\u0000\u01d3\u01fd\u0001\u0000\u0000\u0000\u01d4\u01d5\u0005=\u0000"+
		"\u0000\u01d5\u01d6\u0007\u0001\u0000\u0000\u01d6\u01d7\u0003 \u0010\u0000"+
		"\u01d7\u01d8\u0005D\u0000\u0000\u01d8\u01fd\u0001\u0000\u0000\u0000\u01d9"+
		"\u01da\u0005=\u0000\u0000\u01da\u01db\u0005&\u0000\u0000\u01db\u01dc\u0005"+
		"=\u0000\u0000\u01dc\u01dd\u0007\u0001\u0000\u0000\u01dd\u01de\u0003 \u0010"+
		"\u0000\u01de\u01df\u0005D\u0000\u0000\u01df\u01fd\u0001\u0000\u0000\u0000"+
		"\u01e0\u01e1\u0005=\u0000\u0000\u01e1\u01e2\u0005&\u0000\u0000\u01e2\u01e7"+
		"\u0005=\u0000\u0000\u01e3\u01e4\u0005\u001f\u0000\u0000\u01e4\u01e5\u0003"+
		" \u0010\u0000\u01e5\u01e6\u0005 \u0000\u0000\u01e6\u01e8\u0001\u0000\u0000"+
		"\u0000\u01e7\u01e3\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000"+
		"\u0000\u01e9\u01e7\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000"+
		"\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb\u01ec\u0007\u0001\u0000"+
		"\u0000\u01ec\u01ed\u0003 \u0010\u0000\u01ed\u01ee\u0005D\u0000\u0000\u01ee"+
		"\u01fd\u0001\u0000\u0000\u0000\u01ef\u01f4\u0005=\u0000\u0000\u01f0\u01f1"+
		"\u0005\u001f\u0000\u0000\u01f1\u01f2\u0003 \u0010\u0000\u01f2\u01f3\u0005"+
		" \u0000\u0000\u01f3\u01f5\u0001\u0000\u0000\u0000\u01f4\u01f0\u0001\u0000"+
		"\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000\u01f6\u01f4\u0001\u0000"+
		"\u0000\u0000\u01f6\u01f7\u0001\u0000\u0000\u0000\u01f7\u01f8\u0001\u0000"+
		"\u0000\u0000\u01f8\u01f9\u0007\u0001\u0000\u0000\u01f9\u01fa\u0003 \u0010"+
		"\u0000\u01fa\u01fb\u0005D\u0000\u0000\u01fb\u01fd\u0001\u0000\u0000\u0000"+
		"\u01fc\u0187\u0001\u0000\u0000\u0000\u01fc\u018e\u0001\u0000\u0000\u0000"+
		"\u01fc\u019d\u0001\u0000\u0000\u0000\u01fc\u01aa\u0001\u0000\u0000\u0000"+
		"\u01fc\u01af\u0001\u0000\u0000\u0000\u01fc\u01b2\u0001\u0000\u0000\u0000"+
		"\u01fc\u01b5\u0001\u0000\u0000\u0000\u01fc\u01ba\u0001\u0000\u0000\u0000"+
		"\u01fc\u01c8\u0001\u0000\u0000\u0000\u01fc\u01d4\u0001\u0000\u0000\u0000"+
		"\u01fc\u01d9\u0001\u0000\u0000\u0000\u01fc\u01e0\u0001\u0000\u0000\u0000"+
		"\u01fc\u01ef\u0001\u0000\u0000\u0000\u01fd\u001f\u0001\u0000\u0000\u0000"+
		"\u01fe\u01ff\u0006\u0010\uffff\uffff\u0000\u01ff\u0200\u00059\u0000\u0000"+
		"\u0200\u0245\u0003 \u0010\u0016\u0201\u0202\u00050\u0000\u0000\u0202\u0245"+
		"\u0003 \u0010\u0015\u0203\u0204\u0005!\u0000\u0000\u0204\u0205\u0003 "+
		"\u0010\u0000\u0205\u0206\u0005\"\u0000\u0000\u0206\u0245\u0001\u0000\u0000"+
		"\u0000\u0207\u020c\u0005=\u0000\u0000\u0208\u0209\u0005\u001f\u0000\u0000"+
		"\u0209\u020a\u0003 \u0010\u0000\u020a\u020b\u0005 \u0000\u0000\u020b\u020d"+
		"\u0001\u0000\u0000\u0000\u020c\u0208\u0001\u0000\u0000\u0000\u020d\u020e"+
		"\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000\u0000\u0000\u020e\u020f"+
		"\u0001\u0000\u0000\u0000\u020f\u0245\u0001\u0000\u0000\u0000\u0210\u0211"+
		"\u0005=\u0000\u0000\u0211\u0212\u0005&\u0000\u0000\u0212\u0245\u0005="+
		"\u0000\u0000\u0213\u0214\u0005=\u0000\u0000\u0214\u0215\u0005&\u0000\u0000"+
		"\u0215\u021a\u0005=\u0000\u0000\u0216\u0217\u0005\u001f\u0000\u0000\u0217"+
		"\u0218\u0003 \u0010\u0000\u0218\u0219\u0005 \u0000\u0000\u0219\u021b\u0001"+
		"\u0000\u0000\u0000\u021a\u0216\u0001\u0000\u0000\u0000\u021b\u021c\u0001"+
		"\u0000\u0000\u0000\u021c\u021a\u0001\u0000\u0000\u0000\u021c\u021d\u0001"+
		"\u0000\u0000\u0000\u021d\u0245\u0001\u0000\u0000\u0000\u021e\u021f\u0005"+
		"=\u0000\u0000\u021f\u0228\u0005!\u0000\u0000\u0220\u0225\u0003 \u0010"+
		"\u0000\u0221\u0222\u0005#\u0000\u0000\u0222\u0224\u0003 \u0010\u0000\u0223"+
		"\u0221\u0001\u0000\u0000\u0000\u0224\u0227\u0001\u0000\u0000\u0000\u0225"+
		"\u0223\u0001\u0000\u0000\u0000\u0225\u0226\u0001\u0000\u0000\u0000\u0226"+
		"\u0229\u0001\u0000\u0000\u0000\u0227\u0225\u0001\u0000\u0000\u0000\u0228"+
		"\u0220\u0001\u0000\u0000\u0000\u0228\u0229\u0001\u0000\u0000\u0000\u0229"+
		"\u022a\u0001\u0000\u0000\u0000\u022a\u0245\u0005\"\u0000\u0000\u022b\u022c"+
		"\u0005=\u0000\u0000\u022c\u022d\u0005&\u0000\u0000\u022d\u022e\u0005="+
		"\u0000\u0000\u022e\u0237\u0005!\u0000\u0000\u022f\u0234\u0003 \u0010\u0000"+
		"\u0230\u0231\u0005#\u0000\u0000\u0231\u0233\u0003 \u0010\u0000\u0232\u0230"+
		"\u0001\u0000\u0000\u0000\u0233\u0236\u0001\u0000\u0000\u0000\u0234\u0232"+
		"\u0001\u0000\u0000\u0000\u0234\u0235\u0001\u0000\u0000\u0000\u0235\u0238"+
		"\u0001\u0000\u0000\u0000\u0236\u0234\u0001\u0000\u0000\u0000\u0237\u022f"+
		"\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238\u0239"+
		"\u0001\u0000\u0000\u0000\u0239\u0245\u0005\"\u0000\u0000\u023a\u023b\u0005"+
		"\u0018\u0000\u0000\u023b\u023c\u0005!\u0000\u0000\u023c\u0245\u0005\""+
		"\u0000\u0000\u023d\u0245\u0005\u0019\u0000\u0000\u023e\u0245\u0005\u001a"+
		"\u0000\u0000\u023f\u0245\u0005=\u0000\u0000\u0240\u0245\u0005>\u0000\u0000"+
		"\u0241\u0245\u0005?\u0000\u0000\u0242\u0245\u0005@\u0000\u0000\u0243\u0245"+
		"\u0005A\u0000\u0000\u0244\u01fe\u0001\u0000\u0000\u0000\u0244\u0201\u0001"+
		"\u0000\u0000\u0000\u0244\u0203\u0001\u0000\u0000\u0000\u0244\u0207\u0001"+
		"\u0000\u0000\u0000\u0244\u0210\u0001\u0000\u0000\u0000\u0244\u0213\u0001"+
		"\u0000\u0000\u0000\u0244\u021e\u0001\u0000\u0000\u0000\u0244\u022b\u0001"+
		"\u0000\u0000\u0000\u0244\u023a\u0001\u0000\u0000\u0000\u0244\u023d\u0001"+
		"\u0000\u0000\u0000\u0244\u023e\u0001\u0000\u0000\u0000\u0244\u023f\u0001"+
		"\u0000\u0000\u0000\u0244\u0240\u0001\u0000\u0000\u0000\u0244\u0241\u0001"+
		"\u0000\u0000\u0000\u0244\u0242\u0001\u0000\u0000\u0000\u0244\u0243\u0001"+
		"\u0000\u0000\u0000\u0245\u025a\u0001\u0000\u0000\u0000\u0246\u0247\n\u0013"+
		"\u0000\u0000\u0247\u0248\u0007\u0002\u0000\u0000\u0248\u0259\u0003 \u0010"+
		"\u0014\u0249\u024a\n\u0012\u0000\u0000\u024a\u024b\u0007\u0003\u0000\u0000"+
		"\u024b\u0259\u0003 \u0010\u0013\u024c\u024d\n\u0011\u0000\u0000\u024d"+
		"\u024e\u0007\u0004\u0000\u0000\u024e\u0259\u0003 \u0010\u0012\u024f\u0250"+
		"\n\u0010\u0000\u0000\u0250\u0251\u0007\u0005\u0000\u0000\u0251\u0259\u0003"+
		" \u0010\u0011\u0252\u0253\n\u000f\u0000\u0000\u0253\u0254\u0007\u0006"+
		"\u0000\u0000\u0254\u0259\u0003 \u0010\u0010\u0255\u0256\n\u000e\u0000"+
		"\u0000\u0256\u0257\u0007\u0007\u0000\u0000\u0257\u0259\u0003 \u0010\u000f"+
		"\u0258\u0246\u0001\u0000\u0000\u0000\u0258\u0249\u0001\u0000\u0000\u0000"+
		"\u0258\u024c\u0001\u0000\u0000\u0000\u0258\u024f\u0001\u0000\u0000\u0000"+
		"\u0258\u0252\u0001\u0000\u0000\u0000\u0258\u0255\u0001\u0000\u0000\u0000"+
		"\u0259\u025c\u0001\u0000\u0000\u0000\u025a\u0258\u0001\u0000\u0000\u0000"+
		"\u025a\u025b\u0001\u0000\u0000\u0000\u025b!\u0001\u0000\u0000\u0000\u025c"+
		"\u025a\u0001\u0000\u0000\u0000\u025d\u025e\u0007\b\u0000\u0000\u025e#"+
		"\u0001\u0000\u0000\u00009\'+1<CFPZadjpy\u007f\u0086\u008b\u0092\u0099"+
		"\u009c\u00a8\u00b0\u00c0\u00fb\u0102\u010e\u0114\u011a\u0125\u0128\u0134"+
		"\u0137\u013a\u0144\u014d\u0156\u015f\u0167\u0172\u0178\u0181\u0185\u0197"+
		"\u01a4\u01c3\u01cf\u01e9\u01f6\u01fc\u020e\u021c\u0225\u0228\u0234\u0237"+
		"\u0244\u0258\u025a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}