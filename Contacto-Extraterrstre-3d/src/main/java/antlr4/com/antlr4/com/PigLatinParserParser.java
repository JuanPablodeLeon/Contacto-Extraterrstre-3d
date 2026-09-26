// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/PigLatinParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PigLatinParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IMPORT=1, VARIABILES=2, ESTO=3, BOOL=4, NUMERUS=5, TEXTUM=6, MAIOR=7, 
		FINISUP=8, DECIMALIS=9, LITTERA=10, SERIES=11, FALSUS=12, VERUM=13, NOVUS=14, 
		SI=15, FINIS=16, ALITER=17, DUM=18, FACERE=19, PER=20, NON=21, PERGE=22, 
		INTERRUMPE=23, IMPRIMIR=24, LEER=25, DOS_PUNTOS=26, LCORCH=27, RCORCH=28, 
		LLLAVE=29, RLLAVE=30, LPAREN=31, RPAREN=32, COMA=33, PUNTO=34, PUNTO_COMA=35, 
		SUMA_INCR=36, RESTA_DECR=37, SUMA=38, RESTA=39, MULTI=40, DIV=41, IGUAL=42, 
		NO_IGUAL=43, MENRO_IGUAL=44, MAYOR_IGUAL=45, MENOR=46, MAYOR=47, ASIGNACION=48, 
		AND=49, OR=50, ID=51, INT=52, DOUBLE=53, STRING=54, CHARS=55, ESC=56, 
		LINE_COMMENT=57, BLOCK_COMMENT=58, WS=59;
	public static final int
		RULE_inicio = 0, RULE_instrucciones = 1, RULE_bloque_imports = 2, RULE_vars_par = 3, 
		RULE_bloque_vars = 4, RULE_tipos_varios = 5, RULE_bloque_varios = 6, RULE_bloque_objt = 7, 
		RULE_bloque_main = 8, RULE_instruccion = 9, RULE_bloque_si = 10, RULE_bloque_impr = 11, 
		RULE_bloque_leer = 12, RULE_bloque_asignacion = 13, RULE_auto_cambio = 14, 
		RULE_expresion = 15, RULE_tipos = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "instrucciones", "bloque_imports", "vars_par", "bloque_vars", 
			"tipos_varios", "bloque_varios", "bloque_objt", "bloque_main", "instruccion", 
			"bloque_si", "bloque_impr", "bloque_leer", "bloque_asignacion", "auto_cambio", 
			"expresion", "tipos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'VARIABILES>'", "'esto'", "'bool'", "'numerus'", "'textum'", 
			"'MAIOR>'", "'FINIS'", "'decimalis'", "'littera'", "'series'", "'falsus'", 
			"'verum'", "'novus'", "'si'", "'finis'", "'aliter'", "'dum'", "'facere'", 
			"'per'", "'non'", "'perge'", "'interrumpe'", "'>>'", "'<<'", "':'", "'['", 
			"']'", "'{'", "'}'", "'('", "')'", "','", "'.'", "';'", "'++'", "'--'", 
			"'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", 
			"'='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IMPORT", "VARIABILES", "ESTO", "BOOL", "NUMERUS", "TEXTUM", "MAIOR", 
			"FINISUP", "DECIMALIS", "LITTERA", "SERIES", "FALSUS", "VERUM", "NOVUS", 
			"SI", "FINIS", "ALITER", "DUM", "FACERE", "PER", "NON", "PERGE", "INTERRUMPE", 
			"IMPRIMIR", "LEER", "DOS_PUNTOS", "LCORCH", "RCORCH", "LLLAVE", "RLLAVE", 
			"LPAREN", "RPAREN", "COMA", "PUNTO", "PUNTO_COMA", "SUMA_INCR", "RESTA_DECR", 
			"SUMA", "RESTA", "MULTI", "DIV", "IGUAL", "NO_IGUAL", "MENRO_IGUAL", 
			"MAYOR_IGUAL", "MENOR", "MAYOR", "ASIGNACION", "AND", "OR", "ID", "INT", 
			"DOUBLE", "STRING", "CHARS", "ESC", "LINE_COMMENT", "BLOCK_COMMENT", 
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
	public String getGrammarFileName() { return "PigLatinParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PigLatinParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicioContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PigLatinParserParser.EOF, 0); }
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public InicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterInicio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitInicio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitInicio(this);
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
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 134L) != 0)) {
				{
				setState(34);
				instrucciones();
				}
			}

			setState(37);
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
	public static class InstruccionesContext extends ParserRuleContext {
		public Bloque_mainContext bloque_main() {
			return getRuleContext(Bloque_mainContext.class,0);
		}
		public TerminalNode FINISUP() { return getToken(PigLatinParserParser.FINISUP, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParserParser.PUNTO_COMA, 0); }
		public List<Bloque_importsContext> bloque_imports() {
			return getRuleContexts(Bloque_importsContext.class);
		}
		public Bloque_importsContext bloque_imports(int i) {
			return getRuleContext(Bloque_importsContext.class,i);
		}
		public Vars_parContext vars_par() {
			return getRuleContext(Vars_parContext.class,0);
		}
		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterInstrucciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitInstrucciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitInstrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instrucciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(39);
				bloque_imports();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABILES) {
				{
				setState(45);
				vars_par();
				}
			}

			setState(48);
			bloque_main();
			setState(49);
			match(FINISUP);
			setState(50);
			match(PUNTO_COMA);
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
	public static class Bloque_importsContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(PigLatinParserParser.IMPORT, 0); }
		public List<TerminalNode> ID() { return getTokens(PigLatinParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParserParser.ID, i);
		}
		public List<TerminalNode> PUNTO() { return getTokens(PigLatinParserParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(PigLatinParserParser.PUNTO, i);
		}
		public Bloque_importsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBloque_imports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBloque_imports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBloque_imports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_importsContext bloque_imports() throws RecognitionException {
		Bloque_importsContext _localctx = new Bloque_importsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloque_imports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(IMPORT);
			setState(53);
			match(ID);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUNTO) {
				{
				{
				setState(54);
				match(PUNTO);
				setState(55);
				match(ID);
				}
				}
				setState(60);
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
	public static class Vars_parContext extends ParserRuleContext {
		public TerminalNode VARIABILES() { return getToken(PigLatinParserParser.VARIABILES, 0); }
		public List<Bloque_varsContext> bloque_vars() {
			return getRuleContexts(Bloque_varsContext.class);
		}
		public Bloque_varsContext bloque_vars(int i) {
			return getRuleContext(Bloque_varsContext.class,i);
		}
		public Vars_parContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars_par; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterVars_par(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitVars_par(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitVars_par(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vars_parContext vars_par() throws RecognitionException {
		Vars_parContext _localctx = new Vars_parContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vars_par);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(VARIABILES);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESTO || _la==SERIES) {
				{
				{
				setState(62);
				bloque_vars();
				}
				}
				setState(67);
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
	public static class Bloque_varsContext extends ParserRuleContext {
		public TerminalNode ESTO() { return getToken(PigLatinParserParser.ESTO, 0); }
		public List<TerminalNode> ID() { return getTokens(PigLatinParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParserParser.ID, i);
		}
		public TerminalNode DOS_PUNTOS() { return getToken(PigLatinParserParser.DOS_PUNTOS, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParserParser.PUNTO_COMA, 0); }
		public TerminalNode SERIES() { return getToken(PigLatinParserParser.SERIES, 0); }
		public TerminalNode LCORCH() { return getToken(PigLatinParserParser.LCORCH, 0); }
		public TerminalNode RCORCH() { return getToken(PigLatinParserParser.RCORCH, 0); }
		public Tipos_variosContext tipos_varios() {
			return getRuleContext(Tipos_variosContext.class,0);
		}
		public TerminalNode LLLAVE() { return getToken(PigLatinParserParser.LLLAVE, 0); }
		public Bloque_variosContext bloque_varios() {
			return getRuleContext(Bloque_variosContext.class,0);
		}
		public TerminalNode RLLAVE() { return getToken(PigLatinParserParser.RLLAVE, 0); }
		public TerminalNode NOVUS() { return getToken(PigLatinParserParser.NOVUS, 0); }
		public TerminalNode LPAREN() { return getToken(PigLatinParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PigLatinParserParser.RPAREN, 0); }
		public Bloque_objtContext bloque_objt() {
			return getRuleContext(Bloque_objtContext.class,0);
		}
		public Bloque_varsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBloque_vars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBloque_vars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBloque_vars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_varsContext bloque_vars() throws RecognitionException {
		Bloque_varsContext _localctx = new Bloque_varsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloque_vars);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(ESTO);
				setState(69);
				match(ID);
				setState(70);
				match(DOS_PUNTOS);
				setState(71);
				tipos();
				setState(72);
				expresion(0);
				setState(73);
				match(PUNTO_COMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(ESTO);
				setState(76);
				match(ID);
				setState(77);
				match(DOS_PUNTOS);
				setState(78);
				expresion(0);
				setState(79);
				match(PUNTO_COMA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(SERIES);
				setState(82);
				match(ID);
				setState(83);
				match(LCORCH);
				setState(84);
				expresion(0);
				setState(85);
				match(RCORCH);
				setState(86);
				match(DOS_PUNTOS);
				setState(87);
				tipos_varios();
				setState(88);
				match(LLLAVE);
				setState(89);
				bloque_varios();
				setState(90);
				match(RLLAVE);
				setState(91);
				match(PUNTO_COMA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				match(SERIES);
				setState(94);
				match(ID);
				setState(95);
				match(LCORCH);
				setState(96);
				expresion(0);
				setState(97);
				match(RCORCH);
				setState(98);
				match(DOS_PUNTOS);
				setState(99);
				tipos_varios();
				setState(100);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				match(ESTO);
				setState(103);
				match(ID);
				setState(104);
				match(DOS_PUNTOS);
				setState(105);
				match(ID);
				setState(106);
				match(LLLAVE);
				setState(107);
				bloque_varios();
				setState(108);
				match(RLLAVE);
				setState(109);
				match(PUNTO_COMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(111);
				match(ESTO);
				setState(112);
				match(ID);
				setState(113);
				match(DOS_PUNTOS);
				setState(114);
				match(NOVUS);
				setState(115);
				match(ID);
				setState(116);
				match(LPAREN);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346129667696L) != 0)) {
					{
					setState(117);
					bloque_objt();
					}
				}

				setState(120);
				match(RPAREN);
				setState(121);
				match(PUNTO_COMA);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(122);
				match(SERIES);
				setState(123);
				match(ID);
				setState(124);
				match(LCORCH);
				setState(125);
				expresion(0);
				setState(126);
				match(RCORCH);
				setState(127);
				match(DOS_PUNTOS);
				setState(128);
				match(ID);
				setState(129);
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
	public static class Tipos_variosContext extends ParserRuleContext {
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public TerminalNode ID() { return getToken(PigLatinParserParser.ID, 0); }
		public Tipos_variosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipos_varios; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterTipos_varios(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitTipos_varios(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitTipos_varios(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipos_variosContext tipos_varios() throws RecognitionException {
		Tipos_variosContext _localctx = new Tipos_variosContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tipos_varios);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case NUMERUS:
			case TEXTUM:
			case DECIMALIS:
			case LITTERA:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				tipos();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
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
	public static class Bloque_variosContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> LLLAVE() { return getTokens(PigLatinParserParser.LLLAVE); }
		public TerminalNode LLLAVE(int i) {
			return getToken(PigLatinParserParser.LLLAVE, i);
		}
		public List<Bloque_variosContext> bloque_varios() {
			return getRuleContexts(Bloque_variosContext.class);
		}
		public Bloque_variosContext bloque_varios(int i) {
			return getRuleContext(Bloque_variosContext.class,i);
		}
		public List<TerminalNode> RLLAVE() { return getTokens(PigLatinParserParser.RLLAVE); }
		public TerminalNode RLLAVE(int i) {
			return getToken(PigLatinParserParser.RLLAVE, i);
		}
		public List<TerminalNode> COMA() { return getTokens(PigLatinParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParserParser.COMA, i);
		}
		public Bloque_variosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_varios; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBloque_varios(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBloque_varios(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBloque_varios(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_variosContext bloque_varios() throws RecognitionException {
		Bloque_variosContext _localctx = new Bloque_variosContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bloque_varios);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case NUMERUS:
			case TEXTUM:
			case DECIMALIS:
			case LITTERA:
			case FALSUS:
			case VERUM:
			case NON:
			case LPAREN:
			case RESTA:
			case ID:
			case INT:
			case DOUBLE:
			case STRING:
			case CHARS:
				{
				setState(137);
				expresion(0);
				}
				break;
			case LLLAVE:
				{
				setState(138);
				match(LLLAVE);
				setState(139);
				bloque_varios();
				setState(140);
				match(RLLAVE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(144);
				match(COMA);
				setState(150);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case NUMERUS:
				case TEXTUM:
				case DECIMALIS:
				case LITTERA:
				case FALSUS:
				case VERUM:
				case NON:
				case LPAREN:
				case RESTA:
				case ID:
				case INT:
				case DOUBLE:
				case STRING:
				case CHARS:
					{
					setState(145);
					expresion(0);
					}
					break;
				case LLLAVE:
					{
					setState(146);
					match(LLLAVE);
					setState(147);
					bloque_varios();
					setState(148);
					match(RLLAVE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(156);
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
	public static class Bloque_objtContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> NOVUS() { return getTokens(PigLatinParserParser.NOVUS); }
		public TerminalNode NOVUS(int i) {
			return getToken(PigLatinParserParser.NOVUS, i);
		}
		public List<TerminalNode> ID() { return getTokens(PigLatinParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParserParser.ID, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(PigLatinParserParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(PigLatinParserParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(PigLatinParserParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(PigLatinParserParser.RPAREN, i);
		}
		public List<TerminalNode> COMA() { return getTokens(PigLatinParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParserParser.COMA, i);
		}
		public List<Bloque_objtContext> bloque_objt() {
			return getRuleContexts(Bloque_objtContext.class);
		}
		public Bloque_objtContext bloque_objt(int i) {
			return getRuleContext(Bloque_objtContext.class,i);
		}
		public Bloque_objtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_objt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBloque_objt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBloque_objt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBloque_objt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_objtContext bloque_objt() throws RecognitionException {
		Bloque_objtContext _localctx = new Bloque_objtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bloque_objt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case NUMERUS:
			case TEXTUM:
			case DECIMALIS:
			case LITTERA:
			case FALSUS:
			case VERUM:
			case NON:
			case LPAREN:
			case RESTA:
			case ID:
			case INT:
			case DOUBLE:
			case STRING:
			case CHARS:
				{
				setState(157);
				expresion(0);
				}
				break;
			case NOVUS:
				{
				setState(158);
				match(NOVUS);
				setState(159);
				match(ID);
				setState(160);
				match(LPAREN);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346129667696L) != 0)) {
					{
					setState(161);
					bloque_objt();
					}
				}

				setState(164);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(167);
				match(COMA);
				setState(176);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case NUMERUS:
				case TEXTUM:
				case DECIMALIS:
				case LITTERA:
				case FALSUS:
				case VERUM:
				case NON:
				case LPAREN:
				case RESTA:
				case ID:
				case INT:
				case DOUBLE:
				case STRING:
				case CHARS:
					{
					setState(168);
					expresion(0);
					}
					break;
				case NOVUS:
					{
					setState(169);
					match(NOVUS);
					setState(170);
					match(ID);
					setState(171);
					match(LPAREN);
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346129667696L) != 0)) {
						{
						setState(172);
						bloque_objt();
						}
					}

					setState(175);
					match(RPAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(182);
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
	public static class Bloque_mainContext extends ParserRuleContext {
		public TerminalNode MAIOR() { return getToken(PigLatinParserParser.MAIOR, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public Bloque_mainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBloque_main(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBloque_main(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBloque_main(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_mainContext bloque_main() throws RecognitionException {
		Bloque_mainContext _localctx = new Bloque_mainContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bloque_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(MAIOR);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346194433648L) != 0)) {
				{
				{
				setState(184);
				instruccion();
				}
				}
				setState(189);
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
	public static class InstruccionContext extends ParserRuleContext {
		public Bloque_imprContext bloque_impr() {
			return getRuleContext(Bloque_imprContext.class,0);
		}
		public Bloque_leerContext bloque_leer() {
			return getRuleContext(Bloque_leerContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> PUNTO_COMA() { return getTokens(PigLatinParserParser.PUNTO_COMA); }
		public TerminalNode PUNTO_COMA(int i) {
			return getToken(PigLatinParserParser.PUNTO_COMA, i);
		}
		public TerminalNode SI() { return getToken(PigLatinParserParser.SI, 0); }
		public TerminalNode LPAREN() { return getToken(PigLatinParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PigLatinParserParser.RPAREN, 0); }
		public TerminalNode LLLAVE() { return getToken(PigLatinParserParser.LLLAVE, 0); }
		public TerminalNode RLLAVE() { return getToken(PigLatinParserParser.RLLAVE, 0); }
		public Bloque_siContext bloque_si() {
			return getRuleContext(Bloque_siContext.class,0);
		}
		public TerminalNode FINIS() { return getToken(PigLatinParserParser.FINIS, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public TerminalNode DUM() { return getToken(PigLatinParserParser.DUM, 0); }
		public TerminalNode FACERE() { return getToken(PigLatinParserParser.FACERE, 0); }
		public TerminalNode PER() { return getToken(PigLatinParserParser.PER, 0); }
		public TerminalNode ESTO() { return getToken(PigLatinParserParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParserParser.ID, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(PigLatinParserParser.DOS_PUNTOS, 0); }
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public Auto_cambioContext auto_cambio() {
			return getRuleContext(Auto_cambioContext.class,0);
		}
		public Bloque_asignacionContext bloque_asignacion() {
			return getRuleContext(Bloque_asignacionContext.class,0);
		}
		public TerminalNode PERGE() { return getToken(PigLatinParserParser.PERGE, 0); }
		public TerminalNode INTERRUMPE() { return getToken(PigLatinParserParser.INTERRUMPE, 0); }
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterInstruccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitInstruccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instruccion);
		int _la;
		try {
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				bloque_impr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				bloque_leer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				expresion(0);
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(193);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
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
				match(LLLAVE);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346194433648L) != 0)) {
					{
					{
					setState(201);
					instruccion();
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(207);
				match(RLLAVE);
				setState(208);
				bloque_si();
				setState(209);
				match(FINIS);
				setState(210);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				match(DUM);
				setState(213);
				match(LPAREN);
				setState(214);
				expresion(0);
				setState(215);
				match(RPAREN);
				setState(216);
				match(LLLAVE);
				setState(218); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(217);
					instruccion();
					}
					}
					setState(220); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346194433648L) != 0) );
				setState(222);
				match(RLLAVE);
				setState(223);
				match(FINIS);
				setState(224);
				match(PUNTO_COMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(226);
				match(FACERE);
				setState(227);
				match(LLLAVE);
				setState(229); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(228);
					instruccion();
					}
					}
					setState(231); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346194433648L) != 0) );
				setState(233);
				match(RLLAVE);
				setState(234);
				match(DUM);
				setState(235);
				match(LPAREN);
				setState(236);
				expresion(0);
				setState(237);
				match(RPAREN);
				setState(238);
				match(PUNTO_COMA);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(240);
				match(PER);
				setState(241);
				match(LPAREN);
				setState(242);
				match(ESTO);
				setState(243);
				match(ID);
				setState(244);
				match(DOS_PUNTOS);
				setState(245);
				tipos();
				setState(246);
				expresion(0);
				setState(247);
				match(PUNTO_COMA);
				setState(248);
				expresion(0);
				setState(249);
				match(PUNTO_COMA);
				setState(250);
				auto_cambio();
				setState(251);
				match(RPAREN);
				setState(252);
				match(LLLAVE);
				setState(254); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(253);
					instruccion();
					}
					}
					setState(256); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346194433648L) != 0) );
				setState(258);
				match(RLLAVE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(260);
				bloque_asignacion();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(261);
				match(PERGE);
				setState(262);
				match(PUNTO_COMA);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(263);
				match(INTERRUMPE);
				setState(264);
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
		public List<TerminalNode> ALITER() { return getTokens(PigLatinParserParser.ALITER); }
		public TerminalNode ALITER(int i) {
			return getToken(PigLatinParserParser.ALITER, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(PigLatinParserParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(PigLatinParserParser.LPAREN, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(PigLatinParserParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(PigLatinParserParser.RPAREN, i);
		}
		public List<TerminalNode> LLLAVE() { return getTokens(PigLatinParserParser.LLLAVE); }
		public TerminalNode LLLAVE(int i) {
			return getToken(PigLatinParserParser.LLLAVE, i);
		}
		public List<TerminalNode> RLLAVE() { return getTokens(PigLatinParserParser.RLLAVE); }
		public TerminalNode RLLAVE(int i) {
			return getToken(PigLatinParserParser.RLLAVE, i);
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
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBloque_si(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBloque_si(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBloque_si(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_siContext bloque_si() throws RecognitionException {
		Bloque_siContext _localctx = new Bloque_siContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bloque_si);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(267);
					match(ALITER);
					setState(268);
					match(LPAREN);
					setState(269);
					expresion(0);
					setState(270);
					match(RPAREN);
					setState(271);
					match(LLLAVE);
					setState(275);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346194433648L) != 0)) {
						{
						{
						setState(272);
						instruccion();
						}
						}
						setState(277);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(278);
					match(RLLAVE);
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALITER) {
				{
				setState(285);
				match(ALITER);
				setState(286);
				match(LLLAVE);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346194433648L) != 0)) {
					{
					{
					setState(287);
					instruccion();
					}
					}
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(293);
				match(RLLAVE);
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
	public static class Bloque_imprContext extends ParserRuleContext {
		public Bloque_imprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_impr; }
	 
		public Bloque_imprContext() { }
		public void copyFrom(Bloque_imprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Impresion_ConsolaContext extends Bloque_imprContext {
		public List<TerminalNode> IMPRIMIR() { return getTokens(PigLatinParserParser.IMPRIMIR); }
		public TerminalNode IMPRIMIR(int i) {
			return getToken(PigLatinParserParser.IMPRIMIR, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParserParser.PUNTO_COMA, 0); }
		public Impresion_ConsolaContext(Bloque_imprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterImpresion_Consola(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitImpresion_Consola(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitImpresion_Consola(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_imprContext bloque_impr() throws RecognitionException {
		Bloque_imprContext _localctx = new Bloque_imprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bloque_impr);
		int _la;
		try {
			_localctx = new Impresion_ConsolaContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(IMPRIMIR);
			setState(297);
			expresion(0);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPRIMIR) {
				{
				{
				setState(298);
				match(IMPRIMIR);
				setState(299);
				expresion(0);
				}
				}
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(305);
			match(PUNTO_COMA);
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
	public static class Bloque_leerContext extends ParserRuleContext {
		public Bloque_leerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_leer; }
	 
		public Bloque_leerContext() { }
		public void copyFrom(Bloque_leerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Lectura_TextoContext extends Bloque_leerContext {
		public TerminalNode LEER() { return getToken(PigLatinParserParser.LEER, 0); }
		public TerminalNode ID() { return getToken(PigLatinParserParser.ID, 0); }
		public Lectura_TextoContext(Bloque_leerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLectura_Texto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLectura_Texto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLectura_Texto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_leerContext bloque_leer() throws RecognitionException {
		Bloque_leerContext _localctx = new Bloque_leerContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bloque_leer);
		int _la;
		try {
			_localctx = new Lectura_TextoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(307);
				match(ID);
				}
			}

			setState(310);
			match(LEER);
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
	public static class Bloque_asignacionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParserParser.ID, i);
		}
		public TerminalNode ASIGNACION() { return getToken(PigLatinParserParser.ASIGNACION, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParserParser.PUNTO_COMA, 0); }
		public TerminalNode LCORCH() { return getToken(PigLatinParserParser.LCORCH, 0); }
		public TerminalNode RCORCH() { return getToken(PigLatinParserParser.RCORCH, 0); }
		public TerminalNode PUNTO() { return getToken(PigLatinParserParser.PUNTO, 0); }
		public Auto_cambioContext auto_cambio() {
			return getRuleContext(Auto_cambioContext.class,0);
		}
		public Bloque_asignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBloque_asignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBloque_asignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBloque_asignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bloque_asignacionContext bloque_asignacion() throws RecognitionException {
		Bloque_asignacionContext _localctx = new Bloque_asignacionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_bloque_asignacion);
		try {
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				match(ID);
				setState(313);
				match(ASIGNACION);
				setState(314);
				expresion(0);
				setState(315);
				match(PUNTO_COMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				match(ID);
				setState(318);
				match(LCORCH);
				setState(319);
				expresion(0);
				setState(320);
				match(RCORCH);
				setState(321);
				match(ASIGNACION);
				setState(322);
				expresion(0);
				setState(323);
				match(PUNTO_COMA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(325);
				match(ID);
				setState(326);
				match(PUNTO);
				setState(327);
				match(ID);
				setState(328);
				match(ASIGNACION);
				setState(329);
				expresion(0);
				setState(330);
				match(PUNTO_COMA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(332);
				match(ID);
				setState(333);
				match(LCORCH);
				setState(334);
				expresion(0);
				setState(335);
				match(RCORCH);
				setState(336);
				match(PUNTO);
				setState(337);
				match(ID);
				setState(338);
				match(ASIGNACION);
				setState(339);
				expresion(0);
				setState(340);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(342);
				auto_cambio();
				setState(343);
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
	public static class Auto_cambioContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PigLatinParserParser.ID, 0); }
		public TerminalNode SUMA_INCR() { return getToken(PigLatinParserParser.SUMA_INCR, 0); }
		public TerminalNode RESTA_DECR() { return getToken(PigLatinParserParser.RESTA_DECR, 0); }
		public Auto_cambioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_auto_cambio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAuto_cambio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAuto_cambio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAuto_cambio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Auto_cambioContext auto_cambio() throws RecognitionException {
		Auto_cambioContext _localctx = new Auto_cambioContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_auto_cambio);
		try {
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				match(ID);
				setState(348);
				match(SUMA_INCR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				match(ID);
				setState(350);
				match(RESTA_DECR);
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
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Llmada_Elemnto_FUnc_SerieContext extends ExpresionContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParserParser.ID, i);
		}
		public List<TerminalNode> PUNTO() { return getTokens(PigLatinParserParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(PigLatinParserParser.PUNTO, i);
		}
		public TerminalNode LCORCH() { return getToken(PigLatinParserParser.LCORCH, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode RCORCH() { return getToken(PigLatinParserParser.RCORCH, 0); }
		public TerminalNode LPAREN() { return getToken(PigLatinParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PigLatinParserParser.RPAREN, 0); }
		public List<TerminalNode> COMA() { return getTokens(PigLatinParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParserParser.COMA, i);
		}
		public Llmada_Elemnto_FUnc_SerieContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLlmada_Elemnto_FUnc_Serie(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLlmada_Elemnto_FUnc_Serie(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLlmada_Elemnto_FUnc_Serie(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Llamada_Series_ValorContext extends ExpresionContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParserParser.ID, i);
		}
		public TerminalNode PUNTO() { return getToken(PigLatinParserParser.PUNTO, 0); }
		public TerminalNode LCORCH() { return getToken(PigLatinParserParser.LCORCH, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RCORCH() { return getToken(PigLatinParserParser.RCORCH, 0); }
		public Llamada_Series_ValorContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLlamada_Series_Valor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLlamada_Series_Valor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLlamada_Series_Valor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentesisContext extends ExpresionContext {
		public TerminalNode LPAREN() { return getToken(PigLatinParserParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PigLatinParserParser.RPAREN, 0); }
		public ParentesisContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterParentesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitParentesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitParentesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalsusValorContext extends ExpresionContext {
		public TerminalNode FALSUS() { return getToken(PigLatinParserParser.FALSUS, 0); }
		public FalsusValorContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFalsusValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFalsusValor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFalsusValor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntValContext extends ExpresionContext {
		public TerminalNode INT() { return getToken(PigLatinParserParser.INT, 0); }
		public IntValContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterIntVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitIntVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitIntVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Llamada_Series_StructuraContext extends ExpresionContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParserParser.ID, i);
		}
		public TerminalNode LCORCH() { return getToken(PigLatinParserParser.LCORCH, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RCORCH() { return getToken(PigLatinParserParser.RCORCH, 0); }
		public TerminalNode PUNTO() { return getToken(PigLatinParserParser.PUNTO, 0); }
		public Llamada_Series_StructuraContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLlamada_Series_Structura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLlamada_Series_Structura(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLlamada_Series_Structura(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharValContext extends ExpresionContext {
		public TerminalNode CHARS() { return getToken(PigLatinParserParser.CHARS, 0); }
		public CharValContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCharVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCharVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCharVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SumaRestaContext extends ExpresionContext {
		public Token ops1;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode SUMA() { return getToken(PigLatinParserParser.SUMA, 0); }
		public TerminalNode RESTA() { return getToken(PigLatinParserParser.RESTA, 0); }
		public SumaRestaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSumaResta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSumaResta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSumaResta(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegacionContext extends ExpresionContext {
		public TerminalNode NON() { return getToken(PigLatinParserParser.NON, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public NegacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterNegacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitNegacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitNegacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Llamada_Elemento_SeriesContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(PigLatinParserParser.ID, 0); }
		public TerminalNode LCORCH() { return getToken(PigLatinParserParser.LCORCH, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RCORCH() { return getToken(PigLatinParserParser.RCORCH, 0); }
		public Llamada_Elemento_SeriesContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLlamada_Elemento_Series(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLlamada_Elemento_Series(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLlamada_Elemento_Series(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultDivContext extends ExpresionContext {
		public Token ops1;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MULTI() { return getToken(PigLatinParserParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(PigLatinParserParser.DIV, 0); }
		public MultDivContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitMultDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Llamada_Actio_ExpContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(PigLatinParserParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(PigLatinParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PigLatinParserParser.RPAREN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(PigLatinParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParserParser.COMA, i);
		}
		public Llamada_Actio_ExpContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLlamada_Actio_Exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLlamada_Actio_Exp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLlamada_Actio_Exp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IgualNoIgualContext extends ExpresionContext {
		public Token ops1;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode IGUAL() { return getToken(PigLatinParserParser.IGUAL, 0); }
		public TerminalNode NO_IGUAL() { return getToken(PigLatinParserParser.NO_IGUAL, 0); }
		public IgualNoIgualContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterIgualNoIgual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitIgualNoIgual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitIgualNoIgual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MenorMayorContext extends ExpresionContext {
		public Token ops1;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MENOR() { return getToken(PigLatinParserParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(PigLatinParserParser.MAYOR, 0); }
		public MenorMayorContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterMenorMayor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitMenorMayor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitMenorMayor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Llamada_Ratio_TipoContext extends ExpresionContext {
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public TerminalNode ID() { return getToken(PigLatinParserParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(PigLatinParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PigLatinParserParser.RPAREN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(PigLatinParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParserParser.COMA, i);
		}
		public Llamada_Ratio_TipoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLlamada_Ratio_Tipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLlamada_Ratio_Tipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLlamada_Ratio_Tipo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleValContext extends ExpresionContext {
		public TerminalNode DOUBLE() { return getToken(PigLatinParserParser.DOUBLE, 0); }
		public DoubleValContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDoubleVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDoubleVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDoubleVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Llamada_Propiedad_StructuraContext extends ExpresionContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParserParser.ID, i);
		}
		public TerminalNode PUNTO() { return getToken(PigLatinParserParser.PUNTO, 0); }
		public Llamada_Propiedad_StructuraContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLlamada_Propiedad_Structura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLlamada_Propiedad_Structura(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLlamada_Propiedad_Structura(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringValContext extends ExpresionContext {
		public TerminalNode STRING() { return getToken(PigLatinParserParser.STRING, 0); }
		public StringValContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStringVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStringVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStringVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentificadorContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(PigLatinParserParser.ID, 0); }
		public IdentificadorContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterIdentificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitIdentificador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MenorMayorIgualContext extends ExpresionContext {
		public Token ops1;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MENRO_IGUAL() { return getToken(PigLatinParserParser.MENRO_IGUAL, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(PigLatinParserParser.MAYOR_IGUAL, 0); }
		public MenorMayorIgualContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterMenorMayorIgual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitMenorMayorIgual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitMenorMayorIgual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LLamada_Propiedad_FuncionContext extends ExpresionContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParserParser.ID, i);
		}
		public TerminalNode PUNTO() { return getToken(PigLatinParserParser.PUNTO, 0); }
		public TerminalNode LPAREN() { return getToken(PigLatinParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PigLatinParserParser.RPAREN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(PigLatinParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParserParser.COMA, i);
		}
		public LLamada_Propiedad_FuncionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLLamada_Propiedad_Funcion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLLamada_Propiedad_Funcion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLLamada_Propiedad_Funcion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VerumValorContext extends ExpresionContext {
		public TerminalNode VERUM() { return getToken(PigLatinParserParser.VERUM, 0); }
		public VerumValorContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterVerumValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitVerumValor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitVerumValor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndOrContext extends ExpresionContext {
		public Token ops1;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode AND() { return getToken(PigLatinParserParser.AND, 0); }
		public TerminalNode OR() { return getToken(PigLatinParserParser.OR, 0); }
		public AndOrContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAndOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAndOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAndOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UmenosContext extends ExpresionContext {
		public TerminalNode RESTA() { return getToken(PigLatinParserParser.RESTA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public UmenosContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterUmenos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitUmenos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitUmenos(this);
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
			setState(455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				_localctx = new UmenosContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(354);
				match(RESTA);
				setState(355);
				expresion(24);
				}
				break;
			case 2:
				{
				_localctx = new NegacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(356);
				match(NON);
				setState(357);
				expresion(23);
				}
				break;
			case 3:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(358);
				match(LPAREN);
				setState(359);
				expresion(0);
				setState(360);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new Llamada_Elemento_SeriesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(362);
				match(ID);
				setState(363);
				match(LCORCH);
				setState(364);
				expresion(0);
				setState(365);
				match(RCORCH);
				}
				break;
			case 5:
				{
				_localctx = new Llmada_Elemnto_FUnc_SerieContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(367);
				match(ID);
				setState(368);
				match(PUNTO);
				setState(369);
				match(ID);
				setState(370);
				match(LCORCH);
				setState(371);
				expresion(0);
				setState(372);
				match(RCORCH);
				setState(373);
				match(PUNTO);
				setState(374);
				match(ID);
				setState(375);
				match(LPAREN);
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346129651312L) != 0)) {
					{
					setState(376);
					expresion(0);
					setState(381);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(377);
						match(COMA);
						setState(378);
						expresion(0);
						}
						}
						setState(383);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(386);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new Llamada_Propiedad_StructuraContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(388);
				match(ID);
				setState(389);
				match(PUNTO);
				setState(390);
				match(ID);
				}
				break;
			case 7:
				{
				_localctx = new LLamada_Propiedad_FuncionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(391);
				match(ID);
				setState(392);
				match(PUNTO);
				setState(393);
				match(ID);
				setState(394);
				match(LPAREN);
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346129651312L) != 0)) {
					{
					setState(395);
					expresion(0);
					setState(400);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(396);
						match(COMA);
						setState(397);
						expresion(0);
						}
						}
						setState(402);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(405);
				match(RPAREN);
				}
				break;
			case 8:
				{
				_localctx = new Llamada_Actio_ExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(406);
				match(ID);
				setState(407);
				match(LPAREN);
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346129651312L) != 0)) {
					{
					setState(408);
					expresion(0);
					setState(413);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(409);
						match(COMA);
						setState(410);
						expresion(0);
						}
						}
						setState(415);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(418);
				match(RPAREN);
				}
				break;
			case 9:
				{
				_localctx = new Llamada_Ratio_TipoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(419);
				tipos();
				setState(420);
				match(ID);
				setState(421);
				match(LPAREN);
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806346129651312L) != 0)) {
					{
					setState(422);
					expresion(0);
					setState(427);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(423);
						match(COMA);
						setState(424);
						expresion(0);
						}
						}
						setState(429);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(432);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new Llamada_Series_StructuraContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(434);
				match(ID);
				setState(435);
				match(LCORCH);
				setState(436);
				expresion(0);
				setState(437);
				match(RCORCH);
				setState(438);
				match(PUNTO);
				setState(439);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new Llamada_Series_ValorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(441);
				match(ID);
				setState(442);
				match(PUNTO);
				setState(443);
				match(ID);
				setState(444);
				match(LCORCH);
				setState(445);
				expresion(0);
				setState(446);
				match(RCORCH);
				}
				break;
			case 12:
				{
				_localctx = new VerumValorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(448);
				match(VERUM);
				}
				break;
			case 13:
				{
				_localctx = new FalsusValorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(449);
				match(FALSUS);
				}
				break;
			case 14:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(450);
				match(ID);
				}
				break;
			case 15:
				{
				_localctx = new DoubleValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(451);
				match(DOUBLE);
				}
				break;
			case 16:
				{
				_localctx = new IntValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(452);
				match(INT);
				}
				break;
			case 17:
				{
				_localctx = new CharValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(453);
				match(CHARS);
				}
				break;
			case 18:
				{
				_localctx = new StringValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(454);
				match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(477);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(475);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(457);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(458);
						((MultDivContext)_localctx).ops1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULTI || _la==DIV) ) {
							((MultDivContext)_localctx).ops1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(459);
						expresion(22);
						}
						break;
					case 2:
						{
						_localctx = new SumaRestaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(460);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(461);
						((SumaRestaContext)_localctx).ops1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SUMA || _la==RESTA) ) {
							((SumaRestaContext)_localctx).ops1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(462);
						expresion(21);
						}
						break;
					case 3:
						{
						_localctx = new IgualNoIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(463);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(464);
						((IgualNoIgualContext)_localctx).ops1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==IGUAL || _la==NO_IGUAL) ) {
							((IgualNoIgualContext)_localctx).ops1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(465);
						expresion(20);
						}
						break;
					case 4:
						{
						_localctx = new MenorMayorIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(466);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(467);
						((MenorMayorIgualContext)_localctx).ops1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MENRO_IGUAL || _la==MAYOR_IGUAL) ) {
							((MenorMayorIgualContext)_localctx).ops1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(468);
						expresion(19);
						}
						break;
					case 5:
						{
						_localctx = new MenorMayorContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(469);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(470);
						((MenorMayorContext)_localctx).ops1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MENOR || _la==MAYOR) ) {
							((MenorMayorContext)_localctx).ops1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(471);
						expresion(18);
						}
						break;
					case 6:
						{
						_localctx = new AndOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(472);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(473);
						((AndOrContext)_localctx).ops1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((AndOrContext)_localctx).ops1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(474);
						expresion(17);
						}
						break;
					}
					} 
				}
				setState(479);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		public TerminalNode NUMERUS() { return getToken(PigLatinParserParser.NUMERUS, 0); }
		public TerminalNode TEXTUM() { return getToken(PigLatinParserParser.TEXTUM, 0); }
		public TerminalNode BOOL() { return getToken(PigLatinParserParser.BOOL, 0); }
		public TerminalNode DECIMALIS() { return getToken(PigLatinParserParser.DECIMALIS, 0); }
		public TerminalNode LITTERA() { return getToken(PigLatinParserParser.LITTERA, 0); }
		public TiposContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterTipos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitTipos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitTipos(this);
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
			setState(480);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1648L) != 0)) ) {
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
			return precpred(_ctx, 21);
		case 1:
			return precpred(_ctx, 20);
		case 2:
			return precpred(_ctx, 19);
		case 3:
			return precpred(_ctx, 18);
		case 4:
			return precpred(_ctx, 17);
		case 5:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001;\u01e3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0003\u0000$\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0005\u0001)\b\u0001\n\u0001\f\u0001,\t\u0001"+
		"\u0001\u0001\u0003\u0001/\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"9\b\u0002\n\u0002\f\u0002<\t\u0002\u0001\u0003\u0001\u0003\u0005\u0003"+
		"@\b\u0003\n\u0003\f\u0003C\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"w\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u0084\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005\u0088\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u008f\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u0097\b\u0006\u0005\u0006\u0099\b\u0006"+
		"\n\u0006\f\u0006\u009c\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00a3\b\u0007\u0001\u0007\u0003\u0007\u00a6"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00ae\b\u0007\u0001\u0007\u0003\u0007\u00b1\b\u0007"+
		"\u0005\u0007\u00b3\b\u0007\n\u0007\f\u0007\u00b6\t\u0007\u0001\b\u0001"+
		"\b\u0005\b\u00ba\b\b\n\b\f\b\u00bd\t\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0003\t\u00c3\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u00cb\b\t\n\t\f\t\u00ce\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00db\b\t\u000b"+
		"\t\f\t\u00dc\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004"+
		"\t\u00e6\b\t\u000b\t\f\t\u00e7\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00ff"+
		"\b\t\u000b\t\f\t\u0100\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0003\t\u010a\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\n\u0112\b\n\n\n\f\n\u0115\t\n\u0001\n\u0001\n\u0005\n\u0119\b"+
		"\n\n\n\f\n\u011c\t\n\u0001\n\u0001\n\u0001\n\u0005\n\u0121\b\n\n\n\f\n"+
		"\u0124\t\n\u0001\n\u0003\n\u0127\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u012d\b\u000b\n\u000b\f\u000b\u0130\t\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0003\f\u0135\b\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u015a\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0160\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u017c\b\u000f\n\u000f\f\u000f\u017f\t\u000f\u0003\u000f"+
		"\u0181\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000f\u018f\b\u000f\n\u000f\f\u000f\u0192\t\u000f\u0003"+
		"\u000f\u0194\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u019c\b\u000f\n\u000f\f\u000f\u019f\t\u000f"+
		"\u0003\u000f\u01a1\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u01aa\b\u000f\n\u000f"+
		"\f\u000f\u01ad\t\u000f\u0003\u000f\u01af\b\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01c8\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u01dc\b\u000f\n\u000f\f\u000f\u01df\t\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0000\u0001\u001e\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0007\u0001\u0000()"+
		"\u0001\u0000&\'\u0001\u0000*+\u0001\u0000,-\u0001\u0000./\u0001\u0000"+
		"12\u0002\u0000\u0004\u0006\t\n\u021f\u0000#\u0001\u0000\u0000\u0000\u0002"+
		"*\u0001\u0000\u0000\u0000\u00044\u0001\u0000\u0000\u0000\u0006=\u0001"+
		"\u0000\u0000\u0000\b\u0083\u0001\u0000\u0000\u0000\n\u0087\u0001\u0000"+
		"\u0000\u0000\f\u008e\u0001\u0000\u0000\u0000\u000e\u00a5\u0001\u0000\u0000"+
		"\u0000\u0010\u00b7\u0001\u0000\u0000\u0000\u0012\u0109\u0001\u0000\u0000"+
		"\u0000\u0014\u011a\u0001\u0000\u0000\u0000\u0016\u0128\u0001\u0000\u0000"+
		"\u0000\u0018\u0134\u0001\u0000\u0000\u0000\u001a\u0159\u0001\u0000\u0000"+
		"\u0000\u001c\u015f\u0001\u0000\u0000\u0000\u001e\u01c7\u0001\u0000\u0000"+
		"\u0000 \u01e0\u0001\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001"+
		"\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000"+
		"%&\u0005\u0000\u0000\u0001&\u0001\u0001\u0000\u0000\u0000\')\u0003\u0004"+
		"\u0002\u0000(\'\u0001\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001"+
		"\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000"+
		",*\u0001\u0000\u0000\u0000-/\u0003\u0006\u0003\u0000.-\u0001\u0000\u0000"+
		"\u0000./\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000001\u0003\u0010"+
		"\b\u000012\u0005\b\u0000\u000023\u0005#\u0000\u00003\u0003\u0001\u0000"+
		"\u0000\u000045\u0005\u0001\u0000\u00005:\u00053\u0000\u000067\u0005\""+
		"\u0000\u000079\u00053\u0000\u000086\u0001\u0000\u0000\u00009<\u0001\u0000"+
		"\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;\u0005"+
		"\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=A\u0005\u0002\u0000"+
		"\u0000>@\u0003\b\u0004\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000"+
		"\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B\u0007\u0001"+
		"\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DE\u0005\u0003\u0000\u0000"+
		"EF\u00053\u0000\u0000FG\u0005\u001a\u0000\u0000GH\u0003 \u0010\u0000H"+
		"I\u0003\u001e\u000f\u0000IJ\u0005#\u0000\u0000J\u0084\u0001\u0000\u0000"+
		"\u0000KL\u0005\u0003\u0000\u0000LM\u00053\u0000\u0000MN\u0005\u001a\u0000"+
		"\u0000NO\u0003\u001e\u000f\u0000OP\u0005#\u0000\u0000P\u0084\u0001\u0000"+
		"\u0000\u0000QR\u0005\u000b\u0000\u0000RS\u00053\u0000\u0000ST\u0005\u001b"+
		"\u0000\u0000TU\u0003\u001e\u000f\u0000UV\u0005\u001c\u0000\u0000VW\u0005"+
		"\u001a\u0000\u0000WX\u0003\n\u0005\u0000XY\u0005\u001d\u0000\u0000YZ\u0003"+
		"\f\u0006\u0000Z[\u0005\u001e\u0000\u0000[\\\u0005#\u0000\u0000\\\u0084"+
		"\u0001\u0000\u0000\u0000]^\u0005\u000b\u0000\u0000^_\u00053\u0000\u0000"+
		"_`\u0005\u001b\u0000\u0000`a\u0003\u001e\u000f\u0000ab\u0005\u001c\u0000"+
		"\u0000bc\u0005\u001a\u0000\u0000cd\u0003\n\u0005\u0000de\u0005#\u0000"+
		"\u0000e\u0084\u0001\u0000\u0000\u0000fg\u0005\u0003\u0000\u0000gh\u0005"+
		"3\u0000\u0000hi\u0005\u001a\u0000\u0000ij\u00053\u0000\u0000jk\u0005\u001d"+
		"\u0000\u0000kl\u0003\f\u0006\u0000lm\u0005\u001e\u0000\u0000mn\u0005#"+
		"\u0000\u0000n\u0084\u0001\u0000\u0000\u0000op\u0005\u0003\u0000\u0000"+
		"pq\u00053\u0000\u0000qr\u0005\u001a\u0000\u0000rs\u0005\u000e\u0000\u0000"+
		"st\u00053\u0000\u0000tv\u0005\u001f\u0000\u0000uw\u0003\u000e\u0007\u0000"+
		"vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000"+
		"\u0000xy\u0005 \u0000\u0000y\u0084\u0005#\u0000\u0000z{\u0005\u000b\u0000"+
		"\u0000{|\u00053\u0000\u0000|}\u0005\u001b\u0000\u0000}~\u0003\u001e\u000f"+
		"\u0000~\u007f\u0005\u001c\u0000\u0000\u007f\u0080\u0005\u001a\u0000\u0000"+
		"\u0080\u0081\u00053\u0000\u0000\u0081\u0082\u0005#\u0000\u0000\u0082\u0084"+
		"\u0001\u0000\u0000\u0000\u0083D\u0001\u0000\u0000\u0000\u0083K\u0001\u0000"+
		"\u0000\u0000\u0083Q\u0001\u0000\u0000\u0000\u0083]\u0001\u0000\u0000\u0000"+
		"\u0083f\u0001\u0000\u0000\u0000\u0083o\u0001\u0000\u0000\u0000\u0083z"+
		"\u0001\u0000\u0000\u0000\u0084\t\u0001\u0000\u0000\u0000\u0085\u0088\u0003"+
		" \u0010\u0000\u0086\u0088\u00053\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u000b\u0001\u0000\u0000"+
		"\u0000\u0089\u008f\u0003\u001e\u000f\u0000\u008a\u008b\u0005\u001d\u0000"+
		"\u0000\u008b\u008c\u0003\f\u0006\u0000\u008c\u008d\u0005\u001e\u0000\u0000"+
		"\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u0089\u0001\u0000\u0000\u0000"+
		"\u008e\u008a\u0001\u0000\u0000\u0000\u008f\u009a\u0001\u0000\u0000\u0000"+
		"\u0090\u0096\u0005!\u0000\u0000\u0091\u0097\u0003\u001e\u000f\u0000\u0092"+
		"\u0093\u0005\u001d\u0000\u0000\u0093\u0094\u0003\f\u0006\u0000\u0094\u0095"+
		"\u0005\u001e\u0000\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096\u0091"+
		"\u0001\u0000\u0000\u0000\u0096\u0092\u0001\u0000\u0000\u0000\u0097\u0099"+
		"\u0001\u0000\u0000\u0000\u0098\u0090\u0001\u0000\u0000\u0000\u0099\u009c"+
		"\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\r\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009d\u00a6\u0003\u001e\u000f\u0000\u009e\u009f\u0005"+
		"\u000e\u0000\u0000\u009f\u00a0\u00053\u0000\u0000\u00a0\u00a2\u0005\u001f"+
		"\u0000\u0000\u00a1\u00a3\u0003\u000e\u0007\u0000\u00a2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a6\u0005 \u0000\u0000\u00a5\u009d\u0001\u0000\u0000"+
		"\u0000\u00a5\u009e\u0001\u0000\u0000\u0000\u00a6\u00b4\u0001\u0000\u0000"+
		"\u0000\u00a7\u00b0\u0005!\u0000\u0000\u00a8\u00b1\u0003\u001e\u000f\u0000"+
		"\u00a9\u00aa\u0005\u000e\u0000\u0000\u00aa\u00ab\u00053\u0000\u0000\u00ab"+
		"\u00ad\u0005\u001f\u0000\u0000\u00ac\u00ae\u0003\u000e\u0007\u0000\u00ad"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae"+
		"\u00af\u0001\u0000\u0000\u0000\u00af\u00b1\u0005 \u0000\u0000\u00b0\u00a8"+
		"\u0001\u0000\u0000\u0000\u00b0\u00a9\u0001\u0000\u0000\u0000\u00b1\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b2\u00a7\u0001\u0000\u0000\u0000\u00b3\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b5\u000f\u0001\u0000\u0000\u0000\u00b6\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b7\u00bb\u0005\u0007\u0000\u0000\u00b8\u00ba"+
		"\u0003\u0012\t\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bc\u0011\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001"+
		"\u0000\u0000\u0000\u00be\u010a\u0003\u0016\u000b\u0000\u00bf\u010a\u0003"+
		"\u0018\f\u0000\u00c0\u00c2\u0003\u001e\u000f\u0000\u00c1\u00c3\u0005#"+
		"\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c3\u010a\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u000f"+
		"\u0000\u0000\u00c5\u00c6\u0005\u001f\u0000\u0000\u00c6\u00c7\u0003\u001e"+
		"\u000f\u0000\u00c7\u00c8\u0005 \u0000\u0000\u00c8\u00cc\u0005\u001d\u0000"+
		"\u0000\u00c9\u00cb\u0003\u0012\t\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000"+
		"\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000"+
		"\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u001e\u0000\u0000"+
		"\u00d0\u00d1\u0003\u0014\n\u0000\u00d1\u00d2\u0005\u0010\u0000\u0000\u00d2"+
		"\u00d3\u0005#\u0000\u0000\u00d3\u010a\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0005\u0012\u0000\u0000\u00d5\u00d6\u0005\u001f\u0000\u0000\u00d6\u00d7"+
		"\u0003\u001e\u000f\u0000\u00d7\u00d8\u0005 \u0000\u0000\u00d8\u00da\u0005"+
		"\u001d\u0000\u0000\u00d9\u00db\u0003\u0012\t\u0000\u00da\u00d9\u0001\u0000"+
		"\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000"+
		"\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000"+
		"\u0000\u0000\u00de\u00df\u0005\u001e\u0000\u0000\u00df\u00e0\u0005\u0010"+
		"\u0000\u0000\u00e0\u00e1\u0005#\u0000\u0000\u00e1\u010a\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e3\u0005\u0013\u0000\u0000\u00e3\u00e5\u0005\u001d\u0000"+
		"\u0000\u00e4\u00e6\u0003\u0012\t\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0005\u001e\u0000\u0000\u00ea\u00eb\u0005\u0012\u0000\u0000"+
		"\u00eb\u00ec\u0005\u001f\u0000\u0000\u00ec\u00ed\u0003\u001e\u000f\u0000"+
		"\u00ed\u00ee\u0005 \u0000\u0000\u00ee\u00ef\u0005#\u0000\u0000\u00ef\u010a"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005\u0014\u0000\u0000\u00f1\u00f2"+
		"\u0005\u001f\u0000\u0000\u00f2\u00f3\u0005\u0003\u0000\u0000\u00f3\u00f4"+
		"\u00053\u0000\u0000\u00f4\u00f5\u0005\u001a\u0000\u0000\u00f5\u00f6\u0003"+
		" \u0010\u0000\u00f6\u00f7\u0003\u001e\u000f\u0000\u00f7\u00f8\u0005#\u0000"+
		"\u0000\u00f8\u00f9\u0003\u001e\u000f\u0000\u00f9\u00fa\u0005#\u0000\u0000"+
		"\u00fa\u00fb\u0003\u001c\u000e\u0000\u00fb\u00fc\u0005 \u0000\u0000\u00fc"+
		"\u00fe\u0005\u001d\u0000\u0000\u00fd\u00ff\u0003\u0012\t\u0000\u00fe\u00fd"+
		"\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u00fe"+
		"\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0102"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0005\u001e\u0000\u0000\u0103\u010a"+
		"\u0001\u0000\u0000\u0000\u0104\u010a\u0003\u001a\r\u0000\u0105\u0106\u0005"+
		"\u0016\u0000\u0000\u0106\u010a\u0005#\u0000\u0000\u0107\u0108\u0005\u0017"+
		"\u0000\u0000\u0108\u010a\u0005#\u0000\u0000\u0109\u00be\u0001\u0000\u0000"+
		"\u0000\u0109\u00bf\u0001\u0000\u0000\u0000\u0109\u00c0\u0001\u0000\u0000"+
		"\u0000\u0109\u00c4\u0001\u0000\u0000\u0000\u0109\u00d4\u0001\u0000\u0000"+
		"\u0000\u0109\u00e2\u0001\u0000\u0000\u0000\u0109\u00f0\u0001\u0000\u0000"+
		"\u0000\u0109\u0104\u0001\u0000\u0000\u0000\u0109\u0105\u0001\u0000\u0000"+
		"\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u010a\u0013\u0001\u0000\u0000"+
		"\u0000\u010b\u010c\u0005\u0011\u0000\u0000\u010c\u010d\u0005\u001f\u0000"+
		"\u0000\u010d\u010e\u0003\u001e\u000f\u0000\u010e\u010f\u0005 \u0000\u0000"+
		"\u010f\u0113\u0005\u001d\u0000\u0000\u0110\u0112\u0003\u0012\t\u0000\u0111"+
		"\u0110\u0001\u0000\u0000\u0000\u0112\u0115\u0001\u0000\u0000\u0000\u0113"+
		"\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114"+
		"\u0116\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0116"+
		"\u0117\u0005\u001e\u0000\u0000\u0117\u0119\u0001\u0000\u0000\u0000\u0118"+
		"\u010b\u0001\u0000\u0000\u0000\u0119\u011c\u0001\u0000\u0000\u0000\u011a"+
		"\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b"+
		"\u0126\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0005\u0011\u0000\u0000\u011e\u0122\u0005\u001d\u0000\u0000\u011f"+
		"\u0121\u0003\u0012\t\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0121\u0124"+
		"\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0122\u0123"+
		"\u0001\u0000\u0000\u0000\u0123\u0125\u0001\u0000\u0000\u0000\u0124\u0122"+
		"\u0001\u0000\u0000\u0000\u0125\u0127\u0005\u001e\u0000\u0000\u0126\u011d"+
		"\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0015"+
		"\u0001\u0000\u0000\u0000\u0128\u0129\u0005\u0018\u0000\u0000\u0129\u012e"+
		"\u0003\u001e\u000f\u0000\u012a\u012b\u0005\u0018\u0000\u0000\u012b\u012d"+
		"\u0003\u001e\u000f\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012d\u0130"+
		"\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012e\u012f"+
		"\u0001\u0000\u0000\u0000\u012f\u0131\u0001\u0000\u0000\u0000\u0130\u012e"+
		"\u0001\u0000\u0000\u0000\u0131\u0132\u0005#\u0000\u0000\u0132\u0017\u0001"+
		"\u0000\u0000\u0000\u0133\u0135\u00053\u0000\u0000\u0134\u0133\u0001\u0000"+
		"\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000"+
		"\u0000\u0000\u0136\u0137\u0005\u0019\u0000\u0000\u0137\u0019\u0001\u0000"+
		"\u0000\u0000\u0138\u0139\u00053\u0000\u0000\u0139\u013a\u00050\u0000\u0000"+
		"\u013a\u013b\u0003\u001e\u000f\u0000\u013b\u013c\u0005#\u0000\u0000\u013c"+
		"\u015a\u0001\u0000\u0000\u0000\u013d\u013e\u00053\u0000\u0000\u013e\u013f"+
		"\u0005\u001b\u0000\u0000\u013f\u0140\u0003\u001e\u000f\u0000\u0140\u0141"+
		"\u0005\u001c\u0000\u0000\u0141\u0142\u00050\u0000\u0000\u0142\u0143\u0003"+
		"\u001e\u000f\u0000\u0143\u0144\u0005#\u0000\u0000\u0144\u015a\u0001\u0000"+
		"\u0000\u0000\u0145\u0146\u00053\u0000\u0000\u0146\u0147\u0005\"\u0000"+
		"\u0000\u0147\u0148\u00053\u0000\u0000\u0148\u0149\u00050\u0000\u0000\u0149"+
		"\u014a\u0003\u001e\u000f\u0000\u014a\u014b\u0005#\u0000\u0000\u014b\u015a"+
		"\u0001\u0000\u0000\u0000\u014c\u014d\u00053\u0000\u0000\u014d\u014e\u0005"+
		"\u001b\u0000\u0000\u014e\u014f\u0003\u001e\u000f\u0000\u014f\u0150\u0005"+
		"\u001c\u0000\u0000\u0150\u0151\u0005\"\u0000\u0000\u0151\u0152\u00053"+
		"\u0000\u0000\u0152\u0153\u00050\u0000\u0000\u0153\u0154\u0003\u001e\u000f"+
		"\u0000\u0154\u0155\u0005#\u0000\u0000\u0155\u015a\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u0003\u001c\u000e\u0000\u0157\u0158\u0005#\u0000\u0000\u0158"+
		"\u015a\u0001\u0000\u0000\u0000\u0159\u0138\u0001\u0000\u0000\u0000\u0159"+
		"\u013d\u0001\u0000\u0000\u0000\u0159\u0145\u0001\u0000\u0000\u0000\u0159"+
		"\u014c\u0001\u0000\u0000\u0000\u0159\u0156\u0001\u0000\u0000\u0000\u015a"+
		"\u001b\u0001\u0000\u0000\u0000\u015b\u015c\u00053\u0000\u0000\u015c\u0160"+
		"\u0005$\u0000\u0000\u015d\u015e\u00053\u0000\u0000\u015e\u0160\u0005%"+
		"\u0000\u0000\u015f\u015b\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000"+
		"\u0000\u0000\u0160\u001d\u0001\u0000\u0000\u0000\u0161\u0162\u0006\u000f"+
		"\uffff\uffff\u0000\u0162\u0163\u0005\'\u0000\u0000\u0163\u01c8\u0003\u001e"+
		"\u000f\u0018\u0164\u0165\u0005\u0015\u0000\u0000\u0165\u01c8\u0003\u001e"+
		"\u000f\u0017\u0166\u0167\u0005\u001f\u0000\u0000\u0167\u0168\u0003\u001e"+
		"\u000f\u0000\u0168\u0169\u0005 \u0000\u0000\u0169\u01c8\u0001\u0000\u0000"+
		"\u0000\u016a\u016b\u00053\u0000\u0000\u016b\u016c\u0005\u001b\u0000\u0000"+
		"\u016c\u016d\u0003\u001e\u000f\u0000\u016d\u016e\u0005\u001c\u0000\u0000"+
		"\u016e\u01c8\u0001\u0000\u0000\u0000\u016f\u0170\u00053\u0000\u0000\u0170"+
		"\u0171\u0005\"\u0000\u0000\u0171\u0172\u00053\u0000\u0000\u0172\u0173"+
		"\u0005\u001b\u0000\u0000\u0173\u0174\u0003\u001e\u000f\u0000\u0174\u0175"+
		"\u0005\u001c\u0000\u0000\u0175\u0176\u0005\"\u0000\u0000\u0176\u0177\u0005"+
		"3\u0000\u0000\u0177\u0180\u0005\u001f\u0000\u0000\u0178\u017d\u0003\u001e"+
		"\u000f\u0000\u0179\u017a\u0005!\u0000\u0000\u017a\u017c\u0003\u001e\u000f"+
		"\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017c\u017f\u0001\u0000\u0000"+
		"\u0000\u017d\u017b\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000"+
		"\u0000\u017e\u0181\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000"+
		"\u0000\u0180\u0178\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000"+
		"\u0000\u0181\u0182\u0001\u0000\u0000\u0000\u0182\u0183\u0005 \u0000\u0000"+
		"\u0183\u01c8\u0001\u0000\u0000\u0000\u0184\u0185\u00053\u0000\u0000\u0185"+
		"\u0186\u0005\"\u0000\u0000\u0186\u01c8\u00053\u0000\u0000\u0187\u0188"+
		"\u00053\u0000\u0000\u0188\u0189\u0005\"\u0000\u0000\u0189\u018a\u0005"+
		"3\u0000\u0000\u018a\u0193\u0005\u001f\u0000\u0000\u018b\u0190\u0003\u001e"+
		"\u000f\u0000\u018c\u018d\u0005!\u0000\u0000\u018d\u018f\u0003\u001e\u000f"+
		"\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018f\u0192\u0001\u0000\u0000"+
		"\u0000\u0190\u018e\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000"+
		"\u0000\u0191\u0194\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000\u0000"+
		"\u0000\u0193\u018b\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000"+
		"\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195\u01c8\u0005 \u0000\u0000"+
		"\u0196\u0197\u00053\u0000\u0000\u0197\u01a0\u0005\u001f\u0000\u0000\u0198"+
		"\u019d\u0003\u001e\u000f\u0000\u0199\u019a\u0005!\u0000\u0000\u019a\u019c"+
		"\u0003\u001e\u000f\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019c\u019f"+
		"\u0001\u0000\u0000\u0000\u019d\u019b\u0001\u0000\u0000\u0000\u019d\u019e"+
		"\u0001\u0000\u0000\u0000\u019e\u01a1\u0001\u0000\u0000\u0000\u019f\u019d"+
		"\u0001\u0000\u0000\u0000\u01a0\u0198\u0001\u0000\u0000\u0000\u01a0\u01a1"+
		"\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2\u01c8"+
		"\u0005 \u0000\u0000\u01a3\u01a4\u0003 \u0010\u0000\u01a4\u01a5\u00053"+
		"\u0000\u0000\u01a5\u01ae\u0005\u001f\u0000\u0000\u01a6\u01ab\u0003\u001e"+
		"\u000f\u0000\u01a7\u01a8\u0005!\u0000\u0000\u01a8\u01aa\u0003\u001e\u000f"+
		"\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01aa\u01ad\u0001\u0000\u0000"+
		"\u0000\u01ab\u01a9\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000"+
		"\u0000\u01ac\u01af\u0001\u0000\u0000\u0000\u01ad\u01ab\u0001\u0000\u0000"+
		"\u0000\u01ae\u01a6\u0001\u0000\u0000\u0000\u01ae\u01af\u0001\u0000\u0000"+
		"\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b1\u0005 \u0000\u0000"+
		"\u01b1\u01c8\u0001\u0000\u0000\u0000\u01b2\u01b3\u00053\u0000\u0000\u01b3"+
		"\u01b4\u0005\u001b\u0000\u0000\u01b4\u01b5\u0003\u001e\u000f\u0000\u01b5"+
		"\u01b6\u0005\u001c\u0000\u0000\u01b6\u01b7\u0005\"\u0000\u0000\u01b7\u01b8"+
		"\u00053\u0000\u0000\u01b8\u01c8\u0001\u0000\u0000\u0000\u01b9\u01ba\u0005"+
		"3\u0000\u0000\u01ba\u01bb\u0005\"\u0000\u0000\u01bb\u01bc\u00053\u0000"+
		"\u0000\u01bc\u01bd\u0005\u001b\u0000\u0000\u01bd\u01be\u0003\u001e\u000f"+
		"\u0000\u01be\u01bf\u0005\u001c\u0000\u0000\u01bf\u01c8\u0001\u0000\u0000"+
		"\u0000\u01c0\u01c8\u0005\r\u0000\u0000\u01c1\u01c8\u0005\f\u0000\u0000"+
		"\u01c2\u01c8\u00053\u0000\u0000\u01c3\u01c8\u00055\u0000\u0000\u01c4\u01c8"+
		"\u00054\u0000\u0000\u01c5\u01c8\u00057\u0000\u0000\u01c6\u01c8\u00056"+
		"\u0000\u0000\u01c7\u0161\u0001\u0000\u0000\u0000\u01c7\u0164\u0001\u0000"+
		"\u0000\u0000\u01c7\u0166\u0001\u0000\u0000\u0000\u01c7\u016a\u0001\u0000"+
		"\u0000\u0000\u01c7\u016f\u0001\u0000\u0000\u0000\u01c7\u0184\u0001\u0000"+
		"\u0000\u0000\u01c7\u0187\u0001\u0000\u0000\u0000\u01c7\u0196\u0001\u0000"+
		"\u0000\u0000\u01c7\u01a3\u0001\u0000\u0000\u0000\u01c7\u01b2\u0001\u0000"+
		"\u0000\u0000\u01c7\u01b9\u0001\u0000\u0000\u0000\u01c7\u01c0\u0001\u0000"+
		"\u0000\u0000\u01c7\u01c1\u0001\u0000\u0000\u0000\u01c7\u01c2\u0001\u0000"+
		"\u0000\u0000\u01c7\u01c3\u0001\u0000\u0000\u0000\u01c7\u01c4\u0001\u0000"+
		"\u0000\u0000\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c7\u01c6\u0001\u0000"+
		"\u0000\u0000\u01c8\u01dd\u0001\u0000\u0000\u0000\u01c9\u01ca\n\u0015\u0000"+
		"\u0000\u01ca\u01cb\u0007\u0000\u0000\u0000\u01cb\u01dc\u0003\u001e\u000f"+
		"\u0016\u01cc\u01cd\n\u0014\u0000\u0000\u01cd\u01ce\u0007\u0001\u0000\u0000"+
		"\u01ce\u01dc\u0003\u001e\u000f\u0015\u01cf\u01d0\n\u0013\u0000\u0000\u01d0"+
		"\u01d1\u0007\u0002\u0000\u0000\u01d1\u01dc\u0003\u001e\u000f\u0014\u01d2"+
		"\u01d3\n\u0012\u0000\u0000\u01d3\u01d4\u0007\u0003\u0000\u0000\u01d4\u01dc"+
		"\u0003\u001e\u000f\u0013\u01d5\u01d6\n\u0011\u0000\u0000\u01d6\u01d7\u0007"+
		"\u0004\u0000\u0000\u01d7\u01dc\u0003\u001e\u000f\u0012\u01d8\u01d9\n\u0010"+
		"\u0000\u0000\u01d9\u01da\u0007\u0005\u0000\u0000\u01da\u01dc\u0003\u001e"+
		"\u000f\u0011\u01db\u01c9\u0001\u0000\u0000\u0000\u01db\u01cc\u0001\u0000"+
		"\u0000\u0000\u01db\u01cf\u0001\u0000\u0000\u0000\u01db\u01d2\u0001\u0000"+
		"\u0000\u0000\u01db\u01d5\u0001\u0000\u0000\u0000\u01db\u01d8\u0001\u0000"+
		"\u0000\u0000\u01dc\u01df\u0001\u0000\u0000\u0000\u01dd\u01db\u0001\u0000"+
		"\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de\u001f\u0001\u0000"+
		"\u0000\u0000\u01df\u01dd\u0001\u0000\u0000\u0000\u01e0\u01e1\u0007\u0006"+
		"\u0000\u0000\u01e1!\u0001\u0000\u0000\u0000*#*.:Av\u0083\u0087\u008e\u0096"+
		"\u009a\u00a2\u00a5\u00ad\u00b0\u00b4\u00bb\u00c2\u00cc\u00dc\u00e7\u0100"+
		"\u0109\u0113\u011a\u0122\u0126\u012e\u0134\u0159\u015f\u017d\u0180\u0190"+
		"\u0193\u019d\u01a0\u01ab\u01ae\u01c7\u01db\u01dd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}