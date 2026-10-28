// Generated from PigLatinParser.g4 by ANTLR 4.13.2
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
public class PigLatinParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IMPORT=1, VARIABILES=2, ESTO=3, BOOL=4, NUMERUS=5, TEXTUM=6, MAIOR=7, 
		FINISUP=8, DECIMALIS=9, LITTERA=10, SERIES=11, FALSUS=12, VERUM=13, NULL_VAL=14, 
		NOVUS=15, SI=16, FINIS=17, ALITER=18, DUM=19, FACERE=20, PER=21, NON=22, 
		PERGE=23, INTERRUMPE=24, IMPRIMIR=25, LEER=26, DOS_PUNTOS=27, LCORCH=28, 
		RCORCH=29, LLLAVE=30, RLLAVE=31, LPAREN=32, RPAREN=33, COMA=34, PUNTO=35, 
		PUNTO_COMA=36, SUMA_INCR=37, RESTA_DECR=38, SUMA=39, RESTA=40, MULTI=41, 
		DIV=42, IGUAL=43, NO_IGUAL=44, MENRO_IGUAL=45, MAYOR_IGUAL=46, MENOR=47, 
		MAYOR=48, ASIGNACION=49, AND=50, OR=51, ID=52, INT=53, DOUBLE=54, STRING=55, 
		CHARS=56, ESC=57, LINE_COMMENT=58, BLOCK_COMMENT=59, WS=60;
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
			"'verum'", "'null'", "'novus'", "'si'", "'finis'", "'aliter'", "'dum'", 
			"'facere'", "'per'", "'non'", "'perge'", "'interrumpe'", "'>>'", "'<<'", 
			"':'", "'['", "']'", "'{'", "'}'", "'('", "')'", "','", "'.'", "';'", 
			"'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'<='", "'>='", 
			"'<'", "'>'", "'='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IMPORT", "VARIABILES", "ESTO", "BOOL", "NUMERUS", "TEXTUM", "MAIOR", 
			"FINISUP", "DECIMALIS", "LITTERA", "SERIES", "FALSUS", "VERUM", "NULL_VAL", 
			"NOVUS", "SI", "FINIS", "ALITER", "DUM", "FACERE", "PER", "NON", "PERGE", 
			"INTERRUMPE", "IMPRIMIR", "LEER", "DOS_PUNTOS", "LCORCH", "RCORCH", "LLLAVE", 
			"RLLAVE", "LPAREN", "RPAREN", "COMA", "PUNTO", "PUNTO_COMA", "SUMA_INCR", 
			"RESTA_DECR", "SUMA", "RESTA", "MULTI", "DIV", "IGUAL", "NO_IGUAL", "MENRO_IGUAL", 
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
		public List<TerminalNode> DOS_PUNTOS() { return getTokens(PigLatinParserParser.DOS_PUNTOS); }
		public TerminalNode DOS_PUNTOS(int i) {
			return getToken(PigLatinParserParser.DOS_PUNTOS, i);
		}
		public TiposContext tipos() {
			return getRuleContext(TiposContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParserParser.PUNTO_COMA, 0); }
		public TerminalNode NOVUS() { return getToken(PigLatinParserParser.NOVUS, 0); }
		public TerminalNode LPAREN() { return getToken(PigLatinParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PigLatinParserParser.RPAREN, 0); }
		public Bloque_objtContext bloque_objt() {
			return getRuleContext(Bloque_objtContext.class,0);
		}
		public Tipos_variosContext tipos_varios() {
			return getRuleContext(Tipos_variosContext.class,0);
		}
		public TerminalNode NULL_VAL() { return getToken(PigLatinParserParser.NULL_VAL, 0); }
		public TerminalNode SERIES() { return getToken(PigLatinParserParser.SERIES, 0); }
		public TerminalNode LCORCH() { return getToken(PigLatinParserParser.LCORCH, 0); }
		public TerminalNode RCORCH() { return getToken(PigLatinParserParser.RCORCH, 0); }
		public TerminalNode LLLAVE() { return getToken(PigLatinParserParser.LLLAVE, 0); }
		public Bloque_variosContext bloque_varios() {
			return getRuleContext(Bloque_variosContext.class,0);
		}
		public TerminalNode RLLAVE() { return getToken(PigLatinParserParser.RLLAVE, 0); }
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
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
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
				match(NOVUS);
				setState(79);
				match(ID);
				setState(80);
				match(LPAREN);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692259337840L) != 0)) {
					{
					setState(81);
					bloque_objt();
					}
				}

				setState(84);
				match(RPAREN);
				setState(85);
				match(PUNTO_COMA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				match(ESTO);
				setState(87);
				match(ID);
				setState(88);
				match(DOS_PUNTOS);
				setState(89);
				match(NOVUS);
				setState(90);
				match(ID);
				setState(91);
				match(LPAREN);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692259337840L) != 0)) {
					{
					setState(92);
					bloque_objt();
					}
				}

				setState(95);
				match(RPAREN);
				setState(96);
				match(DOS_PUNTOS);
				setState(97);
				tipos_varios();
				setState(98);
				match(PUNTO_COMA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				match(ESTO);
				setState(101);
				match(ID);
				setState(102);
				match(DOS_PUNTOS);
				setState(103);
				match(NULL_VAL);
				setState(104);
				match(DOS_PUNTOS);
				setState(105);
				tipos_varios();
				setState(106);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				match(ESTO);
				setState(109);
				match(ID);
				setState(110);
				match(DOS_PUNTOS);
				setState(111);
				expresion(0);
				setState(112);
				match(DOS_PUNTOS);
				setState(113);
				tipos_varios();
				setState(114);
				match(PUNTO_COMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(116);
				match(ESTO);
				setState(117);
				match(ID);
				setState(118);
				match(DOS_PUNTOS);
				setState(119);
				expresion(0);
				setState(120);
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
				tipos_varios();
				setState(129);
				match(LLLAVE);
				setState(130);
				bloque_varios();
				setState(131);
				match(RLLAVE);
				setState(132);
				match(PUNTO_COMA);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(134);
				match(SERIES);
				setState(135);
				match(ID);
				setState(136);
				match(LCORCH);
				setState(137);
				expresion(0);
				setState(138);
				match(RCORCH);
				setState(139);
				match(DOS_PUNTOS);
				setState(140);
				tipos_varios();
				setState(141);
				match(PUNTO_COMA);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(143);
				match(ESTO);
				setState(144);
				match(ID);
				setState(145);
				match(DOS_PUNTOS);
				setState(146);
				match(ID);
				setState(147);
				match(LLLAVE);
				setState(148);
				bloque_varios();
				setState(149);
				match(RLLAVE);
				setState(150);
				match(PUNTO_COMA);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(152);
				match(SERIES);
				setState(153);
				match(ID);
				setState(154);
				match(LCORCH);
				setState(155);
				expresion(0);
				setState(156);
				match(RCORCH);
				setState(157);
				match(DOS_PUNTOS);
				setState(158);
				match(ID);
				setState(159);
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
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case NUMERUS:
			case TEXTUM:
			case DECIMALIS:
			case LITTERA:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				tipos();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
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
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case NUMERUS:
			case TEXTUM:
			case DECIMALIS:
			case LITTERA:
			case FALSUS:
			case VERUM:
			case NULL_VAL:
			case NOVUS:
			case NON:
			case LPAREN:
			case RESTA:
			case ID:
			case INT:
			case DOUBLE:
			case STRING:
			case CHARS:
				{
				setState(167);
				expresion(0);
				}
				break;
			case LLLAVE:
				{
				setState(168);
				match(LLLAVE);
				setState(169);
				bloque_varios();
				setState(170);
				match(RLLAVE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(174);
				match(COMA);
				setState(180);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case NUMERUS:
				case TEXTUM:
				case DECIMALIS:
				case LITTERA:
				case FALSUS:
				case VERUM:
				case NULL_VAL:
				case NOVUS:
				case NON:
				case LPAREN:
				case RESTA:
				case ID:
				case INT:
				case DOUBLE:
				case STRING:
				case CHARS:
					{
					setState(175);
					expresion(0);
					}
					break;
				case LLLAVE:
					{
					setState(176);
					match(LLLAVE);
					setState(177);
					bloque_varios();
					setState(178);
					match(RLLAVE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(186);
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
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(187);
				expresion(0);
				}
				break;
			case 2:
				{
				setState(188);
				match(NOVUS);
				setState(189);
				match(ID);
				setState(190);
				match(LPAREN);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692259337840L) != 0)) {
					{
					setState(191);
					bloque_objt();
					}
				}

				setState(194);
				match(RPAREN);
				}
				break;
			}
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(197);
				match(COMA);
				setState(206);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(198);
					expresion(0);
					}
					break;
				case 2:
					{
					setState(199);
					match(NOVUS);
					setState(200);
					match(ID);
					setState(201);
					match(LPAREN);
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692259337840L) != 0)) {
						{
						setState(202);
						bloque_objt();
						}
					}

					setState(205);
					match(RPAREN);
					}
					break;
				}
				}
				}
				setState(212);
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
			setState(213);
			match(MAIOR);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692388902512L) != 0)) {
				{
				{
				setState(214);
				instruccion();
				}
				}
				setState(219);
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
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				bloque_impr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				bloque_leer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				expresion(0);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(223);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(226);
				match(SI);
				setState(227);
				match(LPAREN);
				setState(228);
				expresion(0);
				setState(229);
				match(RPAREN);
				setState(230);
				match(LLLAVE);
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692388902512L) != 0)) {
					{
					{
					setState(231);
					instruccion();
					}
					}
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(237);
				match(RLLAVE);
				setState(238);
				bloque_si();
				setState(239);
				match(FINIS);
				setState(240);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(242);
				match(DUM);
				setState(243);
				match(LPAREN);
				setState(244);
				expresion(0);
				setState(245);
				match(RPAREN);
				setState(246);
				match(LLLAVE);
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(247);
					instruccion();
					}
					}
					setState(250); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692388902512L) != 0) );
				setState(252);
				match(RLLAVE);
				setState(253);
				match(FINIS);
				setState(254);
				match(PUNTO_COMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(256);
				match(FACERE);
				setState(257);
				match(LLLAVE);
				setState(259); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(258);
					instruccion();
					}
					}
					setState(261); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692388902512L) != 0) );
				setState(263);
				match(RLLAVE);
				setState(264);
				match(DUM);
				setState(265);
				match(LPAREN);
				setState(266);
				expresion(0);
				setState(267);
				match(RPAREN);
				setState(268);
				match(PUNTO_COMA);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(270);
				match(PER);
				setState(271);
				match(LPAREN);
				setState(272);
				match(ESTO);
				setState(273);
				match(ID);
				setState(274);
				match(DOS_PUNTOS);
				setState(275);
				tipos();
				setState(276);
				expresion(0);
				setState(277);
				match(PUNTO_COMA);
				setState(278);
				expresion(0);
				setState(279);
				match(PUNTO_COMA);
				setState(280);
				auto_cambio();
				setState(281);
				match(RPAREN);
				setState(282);
				match(LLLAVE);
				setState(284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(283);
					instruccion();
					}
					}
					setState(286); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692388902512L) != 0) );
				setState(288);
				match(RLLAVE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(290);
				bloque_asignacion();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(291);
				match(PERGE);
				setState(292);
				match(PUNTO_COMA);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(293);
				match(INTERRUMPE);
				setState(294);
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
			setState(312);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(297);
					match(ALITER);
					setState(298);
					match(LPAREN);
					setState(299);
					expresion(0);
					setState(300);
					match(RPAREN);
					setState(301);
					match(LLLAVE);
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692388902512L) != 0)) {
						{
						{
						setState(302);
						instruccion();
						}
						}
						setState(307);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(308);
					match(RLLAVE);
					}
					} 
				}
				setState(314);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALITER) {
				{
				setState(315);
				match(ALITER);
				setState(316);
				match(LLLAVE);
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692388902512L) != 0)) {
					{
					{
					setState(317);
					instruccion();
					}
					}
					setState(322);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(323);
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
			setState(326);
			match(IMPRIMIR);
			setState(327);
			expresion(0);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPRIMIR) {
				{
				{
				setState(328);
				match(IMPRIMIR);
				setState(329);
				expresion(0);
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335);
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
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(337);
				match(ID);
				}
			}

			setState(340);
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
			setState(375);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				match(ID);
				setState(343);
				match(ASIGNACION);
				setState(344);
				expresion(0);
				setState(345);
				match(PUNTO_COMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				match(ID);
				setState(348);
				match(LCORCH);
				setState(349);
				expresion(0);
				setState(350);
				match(RCORCH);
				setState(351);
				match(ASIGNACION);
				setState(352);
				expresion(0);
				setState(353);
				match(PUNTO_COMA);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(355);
				match(ID);
				setState(356);
				match(PUNTO);
				setState(357);
				match(ID);
				setState(358);
				match(ASIGNACION);
				setState(359);
				expresion(0);
				setState(360);
				match(PUNTO_COMA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(362);
				match(ID);
				setState(363);
				match(LCORCH);
				setState(364);
				expresion(0);
				setState(365);
				match(RCORCH);
				setState(366);
				match(PUNTO);
				setState(367);
				match(ID);
				setState(368);
				match(ASIGNACION);
				setState(369);
				expresion(0);
				setState(370);
				match(PUNTO_COMA);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(372);
				auto_cambio();
				setState(373);
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
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				match(ID);
				setState(378);
				match(SUMA_INCR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				match(ID);
				setState(380);
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
	public static class Acceso_IndiceContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode LCORCH() { return getToken(PigLatinParserParser.LCORCH, 0); }
		public TerminalNode RCORCH() { return getToken(PigLatinParserParser.RCORCH, 0); }
		public Acceso_IndiceContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAcceso_Indice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAcceso_Indice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAcceso_Indice(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullValContext extends ExpresionContext {
		public TerminalNode NULL_VAL() { return getToken(PigLatinParserParser.NULL_VAL, 0); }
		public NullValContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterNullVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitNullVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitNullVal(this);
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
	public static class Novus_ExpContext extends ExpresionContext {
		public TerminalNode NOVUS() { return getToken(PigLatinParserParser.NOVUS, 0); }
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
		public Novus_ExpContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterNovus_Exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitNovus_Exp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitNovus_Exp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Metodo_CadenaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PUNTO() { return getToken(PigLatinParserParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParserParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(PigLatinParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PigLatinParserParser.RPAREN, 0); }
		public List<TerminalNode> COMA() { return getTokens(PigLatinParserParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParserParser.COMA, i);
		}
		public Metodo_CadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterMetodo_Cadena(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitMetodo_Cadena(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitMetodo_Cadena(this);
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
	public static class Acceso_CadenaContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO() { return getToken(PigLatinParserParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParserParser.ID, 0); }
		public Acceso_CadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAcceso_Cadena(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAcceso_Cadena(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAcceso_Cadena(this);
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
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				_localctx = new UmenosContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(384);
				match(RESTA);
				setState(385);
				expresion(23);
				}
				break;
			case 2:
				{
				_localctx = new NegacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(386);
				match(NON);
				setState(387);
				expresion(22);
				}
				break;
			case 3:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
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
				_localctx = new Llamada_Actio_ExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(392);
				match(ID);
				setState(393);
				match(LPAREN);
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692259337840L) != 0)) {
					{
					setState(394);
					expresion(0);
					setState(399);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(395);
						match(COMA);
						setState(396);
						expresion(0);
						}
						}
						setState(401);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(404);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new Llamada_Ratio_TipoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(405);
				tipos();
				setState(406);
				match(ID);
				setState(407);
				match(LPAREN);
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692259337840L) != 0)) {
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
			case 6:
				{
				_localctx = new Novus_ExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(420);
				match(NOVUS);
				setState(421);
				match(ID);
				setState(422);
				match(LPAREN);
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692259337840L) != 0)) {
					{
					setState(423);
					expresion(0);
					setState(428);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(424);
						match(COMA);
						setState(425);
						expresion(0);
						}
						}
						setState(430);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(433);
				match(RPAREN);
				}
				break;
			case 7:
				{
				_localctx = new VerumValorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(434);
				match(VERUM);
				}
				break;
			case 8:
				{
				_localctx = new FalsusValorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(435);
				match(FALSUS);
				}
				break;
			case 9:
				{
				_localctx = new NullValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(436);
				match(NULL_VAL);
				}
				break;
			case 10:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(437);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new DoubleValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(438);
				match(DOUBLE);
				}
				break;
			case 12:
				{
				_localctx = new IntValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(439);
				match(INT);
				}
				break;
			case 13:
				{
				_localctx = new CharValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(440);
				match(CHARS);
				}
				break;
			case 14:
				{
				_localctx = new StringValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(441);
				match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(487);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(485);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(444);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(445);
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
						setState(446);
						expresion(18);
						}
						break;
					case 2:
						{
						_localctx = new SumaRestaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(447);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(448);
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
						setState(449);
						expresion(17);
						}
						break;
					case 3:
						{
						_localctx = new IgualNoIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(450);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(451);
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
						setState(452);
						expresion(16);
						}
						break;
					case 4:
						{
						_localctx = new MenorMayorIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(453);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(454);
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
						setState(455);
						expresion(15);
						}
						break;
					case 5:
						{
						_localctx = new MenorMayorContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(456);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(457);
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
						setState(458);
						expresion(14);
						}
						break;
					case 6:
						{
						_localctx = new AndOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(459);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(460);
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
						setState(461);
						expresion(13);
						}
						break;
					case 7:
						{
						_localctx = new Metodo_CadenaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(462);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(463);
						match(PUNTO);
						setState(464);
						match(ID);
						setState(465);
						match(LPAREN);
						setState(474);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139612692259337840L) != 0)) {
							{
							setState(466);
							expresion(0);
							setState(471);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMA) {
								{
								{
								setState(467);
								match(COMA);
								setState(468);
								expresion(0);
								}
								}
								setState(473);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(476);
						match(RPAREN);
						}
						break;
					case 8:
						{
						_localctx = new Acceso_CadenaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(477);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(478);
						match(PUNTO);
						setState(479);
						match(ID);
						}
						break;
					case 9:
						{
						_localctx = new Acceso_IndiceContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(480);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(481);
						match(LCORCH);
						setState(482);
						expresion(0);
						setState(483);
						match(RCORCH);
						}
						break;
					}
					} 
				}
				setState(489);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
			setState(490);
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
			return precpred(_ctx, 17);
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
			return precpred(_ctx, 20);
		case 7:
			return precpred(_ctx, 19);
		case 8:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001<\u01ed\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"S\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004^\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00a2\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005\u00a6\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00ad\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u00b5\b\u0006\u0005\u0006\u00b7\b\u0006"+
		"\n\u0006\f\u0006\u00ba\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00c1\b\u0007\u0001\u0007\u0003\u0007\u00c4"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00cc\b\u0007\u0001\u0007\u0003\u0007\u00cf\b\u0007"+
		"\u0005\u0007\u00d1\b\u0007\n\u0007\f\u0007\u00d4\t\u0007\u0001\b\u0001"+
		"\b\u0005\b\u00d8\b\b\n\b\f\b\u00db\t\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0003\t\u00e1\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u00e9\b\t\n\t\f\t\u00ec\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00f9\b\t\u000b"+
		"\t\f\t\u00fa\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004"+
		"\t\u0104\b\t\u000b\t\f\t\u0105\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u011d"+
		"\b\t\u000b\t\f\t\u011e\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0003\t\u0128\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\n\u0130\b\n\n\n\f\n\u0133\t\n\u0001\n\u0001\n\u0005\n\u0137\b"+
		"\n\n\n\f\n\u013a\t\n\u0001\n\u0001\n\u0001\n\u0005\n\u013f\b\n\n\n\f\n"+
		"\u0142\t\n\u0001\n\u0003\n\u0145\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u014b\b\u000b\n\u000b\f\u000b\u014e\t\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0003\f\u0153\b\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0178\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u017e\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u018e\b\u000f\n\u000f\f\u000f\u0191\t\u000f\u0003\u000f"+
		"\u0193\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u019c\b\u000f\n\u000f\f\u000f\u019f"+
		"\t\u000f\u0003\u000f\u01a1\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u01ab\b\u000f\n\u000f\f\u000f\u01ae\t\u000f\u0003\u000f\u01b0\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01bb\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u01d6\b\u000f\n\u000f\f\u000f\u01d9\t\u000f\u0003\u000f\u01db"+
		"\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u01e6\b\u000f\n"+
		"\u000f\f\u000f\u01e9\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0000"+
		"\u0001\u001e\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \u0000\u0007\u0001\u0000)*\u0001\u0000"+
		"\'(\u0001\u0000+,\u0001\u0000-.\u0001\u0000/0\u0001\u000023\u0002\u0000"+
		"\u0004\u0006\t\n\u022c\u0000#\u0001\u0000\u0000\u0000\u0002*\u0001\u0000"+
		"\u0000\u0000\u00044\u0001\u0000\u0000\u0000\u0006=\u0001\u0000\u0000\u0000"+
		"\b\u00a1\u0001\u0000\u0000\u0000\n\u00a5\u0001\u0000\u0000\u0000\f\u00ac"+
		"\u0001\u0000\u0000\u0000\u000e\u00c3\u0001\u0000\u0000\u0000\u0010\u00d5"+
		"\u0001\u0000\u0000\u0000\u0012\u0127\u0001\u0000\u0000\u0000\u0014\u0138"+
		"\u0001\u0000\u0000\u0000\u0016\u0146\u0001\u0000\u0000\u0000\u0018\u0152"+
		"\u0001\u0000\u0000\u0000\u001a\u0177\u0001\u0000\u0000\u0000\u001c\u017d"+
		"\u0001\u0000\u0000\u0000\u001e\u01ba\u0001\u0000\u0000\u0000 \u01ea\u0001"+
		"\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000"+
		"#$\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0005\u0000\u0000"+
		"\u0001&\u0001\u0001\u0000\u0000\u0000\')\u0003\u0004\u0002\u0000(\'\u0001"+
		"\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000-/\u0003\u0006\u0003\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000"+
		"\u0000\u0000/0\u0001\u0000\u0000\u000001\u0003\u0010\b\u000012\u0005\b"+
		"\u0000\u000023\u0005$\u0000\u00003\u0003\u0001\u0000\u0000\u000045\u0005"+
		"\u0001\u0000\u00005:\u00054\u0000\u000067\u0005#\u0000\u000079\u00054"+
		"\u0000\u000086\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001"+
		"\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;\u0005\u0001\u0000\u0000"+
		"\u0000<:\u0001\u0000\u0000\u0000=A\u0005\u0002\u0000\u0000>@\u0003\b\u0004"+
		"\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000AB\u0001\u0000\u0000\u0000B\u0007\u0001\u0000\u0000\u0000"+
		"CA\u0001\u0000\u0000\u0000DE\u0005\u0003\u0000\u0000EF\u00054\u0000\u0000"+
		"FG\u0005\u001b\u0000\u0000GH\u0003 \u0010\u0000HI\u0003\u001e\u000f\u0000"+
		"IJ\u0005$\u0000\u0000J\u00a2\u0001\u0000\u0000\u0000KL\u0005\u0003\u0000"+
		"\u0000LM\u00054\u0000\u0000MN\u0005\u001b\u0000\u0000NO\u0005\u000f\u0000"+
		"\u0000OP\u00054\u0000\u0000PR\u0005 \u0000\u0000QS\u0003\u000e\u0007\u0000"+
		"RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000"+
		"\u0000TU\u0005!\u0000\u0000U\u00a2\u0005$\u0000\u0000VW\u0005\u0003\u0000"+
		"\u0000WX\u00054\u0000\u0000XY\u0005\u001b\u0000\u0000YZ\u0005\u000f\u0000"+
		"\u0000Z[\u00054\u0000\u0000[]\u0005 \u0000\u0000\\^\u0003\u000e\u0007"+
		"\u0000]\\\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_`\u0005!\u0000\u0000`a\u0005\u001b\u0000\u0000ab\u0003\n"+
		"\u0005\u0000bc\u0005$\u0000\u0000c\u00a2\u0001\u0000\u0000\u0000de\u0005"+
		"\u0003\u0000\u0000ef\u00054\u0000\u0000fg\u0005\u001b\u0000\u0000gh\u0005"+
		"\u000e\u0000\u0000hi\u0005\u001b\u0000\u0000ij\u0003\n\u0005\u0000jk\u0005"+
		"$\u0000\u0000k\u00a2\u0001\u0000\u0000\u0000lm\u0005\u0003\u0000\u0000"+
		"mn\u00054\u0000\u0000no\u0005\u001b\u0000\u0000op\u0003\u001e\u000f\u0000"+
		"pq\u0005\u001b\u0000\u0000qr\u0003\n\u0005\u0000rs\u0005$\u0000\u0000"+
		"s\u00a2\u0001\u0000\u0000\u0000tu\u0005\u0003\u0000\u0000uv\u00054\u0000"+
		"\u0000vw\u0005\u001b\u0000\u0000wx\u0003\u001e\u000f\u0000xy\u0005$\u0000"+
		"\u0000y\u00a2\u0001\u0000\u0000\u0000z{\u0005\u000b\u0000\u0000{|\u0005"+
		"4\u0000\u0000|}\u0005\u001c\u0000\u0000}~\u0003\u001e\u000f\u0000~\u007f"+
		"\u0005\u001d\u0000\u0000\u007f\u0080\u0005\u001b\u0000\u0000\u0080\u0081"+
		"\u0003\n\u0005\u0000\u0081\u0082\u0005\u001e\u0000\u0000\u0082\u0083\u0003"+
		"\f\u0006\u0000\u0083\u0084\u0005\u001f\u0000\u0000\u0084\u0085\u0005$"+
		"\u0000\u0000\u0085\u00a2\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u000b"+
		"\u0000\u0000\u0087\u0088\u00054\u0000\u0000\u0088\u0089\u0005\u001c\u0000"+
		"\u0000\u0089\u008a\u0003\u001e\u000f\u0000\u008a\u008b\u0005\u001d\u0000"+
		"\u0000\u008b\u008c\u0005\u001b\u0000\u0000\u008c\u008d\u0003\n\u0005\u0000"+
		"\u008d\u008e\u0005$\u0000\u0000\u008e\u00a2\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0005\u0003\u0000\u0000\u0090\u0091\u00054\u0000\u0000\u0091\u0092"+
		"\u0005\u001b\u0000\u0000\u0092\u0093\u00054\u0000\u0000\u0093\u0094\u0005"+
		"\u001e\u0000\u0000\u0094\u0095\u0003\f\u0006\u0000\u0095\u0096\u0005\u001f"+
		"\u0000\u0000\u0096\u0097\u0005$\u0000\u0000\u0097\u00a2\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0005\u000b\u0000\u0000\u0099\u009a\u00054\u0000\u0000"+
		"\u009a\u009b\u0005\u001c\u0000\u0000\u009b\u009c\u0003\u001e\u000f\u0000"+
		"\u009c\u009d\u0005\u001d\u0000\u0000\u009d\u009e\u0005\u001b\u0000\u0000"+
		"\u009e\u009f\u00054\u0000\u0000\u009f\u00a0\u0005$\u0000\u0000\u00a0\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a1D\u0001\u0000\u0000\u0000\u00a1K\u0001\u0000"+
		"\u0000\u0000\u00a1V\u0001\u0000\u0000\u0000\u00a1d\u0001\u0000\u0000\u0000"+
		"\u00a1l\u0001\u0000\u0000\u0000\u00a1t\u0001\u0000\u0000\u0000\u00a1z"+
		"\u0001\u0000\u0000\u0000\u00a1\u0086\u0001\u0000\u0000\u0000\u00a1\u008f"+
		"\u0001\u0000\u0000\u0000\u00a1\u0098\u0001\u0000\u0000\u0000\u00a2\t\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a6\u0003 \u0010\u0000\u00a4\u00a6\u00054\u0000"+
		"\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a6\u000b\u0001\u0000\u0000\u0000\u00a7\u00ad\u0003\u001e\u000f"+
		"\u0000\u00a8\u00a9\u0005\u001e\u0000\u0000\u00a9\u00aa\u0003\f\u0006\u0000"+
		"\u00aa\u00ab\u0005\u001f\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ac\u00a7\u0001\u0000\u0000\u0000\u00ac\u00a8\u0001\u0000\u0000\u0000"+
		"\u00ad\u00b8\u0001\u0000\u0000\u0000\u00ae\u00b4\u0005\"\u0000\u0000\u00af"+
		"\u00b5\u0003\u001e\u000f\u0000\u00b0\u00b1\u0005\u001e\u0000\u0000\u00b1"+
		"\u00b2\u0003\f\u0006\u0000\u00b2\u00b3\u0005\u001f\u0000\u0000\u00b3\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b4\u00af\u0001\u0000\u0000\u0000\u00b4\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000\u0000\u00b8\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\r\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb\u00c4\u0003"+
		"\u001e\u000f\u0000\u00bc\u00bd\u0005\u000f\u0000\u0000\u00bd\u00be\u0005"+
		"4\u0000\u0000\u00be\u00c0\u0005 \u0000\u0000\u00bf\u00c1\u0003\u000e\u0007"+
		"\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c4\u0005!\u0000\u0000"+
		"\u00c3\u00bb\u0001\u0000\u0000\u0000\u00c3\u00bc\u0001\u0000\u0000\u0000"+
		"\u00c4\u00d2\u0001\u0000\u0000\u0000\u00c5\u00ce\u0005\"\u0000\u0000\u00c6"+
		"\u00cf\u0003\u001e\u000f\u0000\u00c7\u00c8\u0005\u000f\u0000\u0000\u00c8"+
		"\u00c9\u00054\u0000\u0000\u00c9\u00cb\u0005 \u0000\u0000\u00ca\u00cc\u0003"+
		"\u000e\u0007\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf\u0005"+
		"!\u0000\u0000\u00ce\u00c6\u0001\u0000\u0000\u0000\u00ce\u00c7\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000\u00d0\u00c5\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u000f\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d9\u0005\u0007"+
		"\u0000\u0000\u00d6\u00d8\u0003\u0012\t\u0000\u00d7\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u0011\u0001\u0000\u0000"+
		"\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u0128\u0003\u0016\u000b"+
		"\u0000\u00dd\u0128\u0003\u0018\f\u0000\u00de\u00e0\u0003\u001e\u000f\u0000"+
		"\u00df\u00e1\u0005$\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e1\u0128\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0005\u0010\u0000\u0000\u00e3\u00e4\u0005 \u0000\u0000\u00e4\u00e5"+
		"\u0003\u001e\u000f\u0000\u00e5\u00e6\u0005!\u0000\u0000\u00e6\u00ea\u0005"+
		"\u001e\u0000\u0000\u00e7\u00e9\u0003\u0012\t\u0000\u00e8\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ec\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u001f"+
		"\u0000\u0000\u00ee\u00ef\u0003\u0014\n\u0000\u00ef\u00f0\u0005\u0011\u0000"+
		"\u0000\u00f0\u00f1\u0005$\u0000\u0000\u00f1\u0128\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f3\u0005\u0013\u0000\u0000\u00f3\u00f4\u0005 \u0000\u0000\u00f4"+
		"\u00f5\u0003\u001e\u000f\u0000\u00f5\u00f6\u0005!\u0000\u0000\u00f6\u00f8"+
		"\u0005\u001e\u0000\u0000\u00f7\u00f9\u0003\u0012\t\u0000\u00f8\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0005\u001f\u0000\u0000\u00fd\u00fe\u0005"+
		"\u0011\u0000\u0000\u00fe\u00ff\u0005$\u0000\u0000\u00ff\u0128\u0001\u0000"+
		"\u0000\u0000\u0100\u0101\u0005\u0014\u0000\u0000\u0101\u0103\u0005\u001e"+
		"\u0000\u0000\u0102\u0104\u0003\u0012\t\u0000\u0103\u0102\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000"+
		"\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0005\u001f\u0000\u0000\u0108\u0109\u0005\u0013\u0000"+
		"\u0000\u0109\u010a\u0005 \u0000\u0000\u010a\u010b\u0003\u001e\u000f\u0000"+
		"\u010b\u010c\u0005!\u0000\u0000\u010c\u010d\u0005$\u0000\u0000\u010d\u0128"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0005\u0015\u0000\u0000\u010f\u0110"+
		"\u0005 \u0000\u0000\u0110\u0111\u0005\u0003\u0000\u0000\u0111\u0112\u0005"+
		"4\u0000\u0000\u0112\u0113\u0005\u001b\u0000\u0000\u0113\u0114\u0003 \u0010"+
		"\u0000\u0114\u0115\u0003\u001e\u000f\u0000\u0115\u0116\u0005$\u0000\u0000"+
		"\u0116\u0117\u0003\u001e\u000f\u0000\u0117\u0118\u0005$\u0000\u0000\u0118"+
		"\u0119\u0003\u001c\u000e\u0000\u0119\u011a\u0005!\u0000\u0000\u011a\u011c"+
		"\u0005\u001e\u0000\u0000\u011b\u011d\u0003\u0012\t\u0000\u011c\u011b\u0001"+
		"\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u011c\u0001"+
		"\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0120\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0005\u001f\u0000\u0000\u0121\u0128\u0001"+
		"\u0000\u0000\u0000\u0122\u0128\u0003\u001a\r\u0000\u0123\u0124\u0005\u0017"+
		"\u0000\u0000\u0124\u0128\u0005$\u0000\u0000\u0125\u0126\u0005\u0018\u0000"+
		"\u0000\u0126\u0128\u0005$\u0000\u0000\u0127\u00dc\u0001\u0000\u0000\u0000"+
		"\u0127\u00dd\u0001\u0000\u0000\u0000\u0127\u00de\u0001\u0000\u0000\u0000"+
		"\u0127\u00e2\u0001\u0000\u0000\u0000\u0127\u00f2\u0001\u0000\u0000\u0000"+
		"\u0127\u0100\u0001\u0000\u0000\u0000\u0127\u010e\u0001\u0000\u0000\u0000"+
		"\u0127\u0122\u0001\u0000\u0000\u0000\u0127\u0123\u0001\u0000\u0000\u0000"+
		"\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u0013\u0001\u0000\u0000\u0000"+
		"\u0129\u012a\u0005\u0012\u0000\u0000\u012a\u012b\u0005 \u0000\u0000\u012b"+
		"\u012c\u0003\u001e\u000f\u0000\u012c\u012d\u0005!\u0000\u0000\u012d\u0131"+
		"\u0005\u001e\u0000\u0000\u012e\u0130\u0003\u0012\t\u0000\u012f\u012e\u0001"+
		"\u0000\u0000\u0000\u0130\u0133\u0001\u0000\u0000\u0000\u0131\u012f\u0001"+
		"\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0134\u0001"+
		"\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0134\u0135\u0005"+
		"\u001f\u0000\u0000\u0135\u0137\u0001\u0000\u0000\u0000\u0136\u0129\u0001"+
		"\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136\u0001"+
		"\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u0144\u0001"+
		"\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u013c\u0005"+
		"\u0012\u0000\u0000\u013c\u0140\u0005\u001e\u0000\u0000\u013d\u013f\u0003"+
		"\u0012\t\u0000\u013e\u013d\u0001\u0000\u0000\u0000\u013f\u0142\u0001\u0000"+
		"\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000"+
		"\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000"+
		"\u0000\u0000\u0143\u0145\u0005\u001f\u0000\u0000\u0144\u013b\u0001\u0000"+
		"\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0015\u0001\u0000"+
		"\u0000\u0000\u0146\u0147\u0005\u0019\u0000\u0000\u0147\u014c\u0003\u001e"+
		"\u000f\u0000\u0148\u0149\u0005\u0019\u0000\u0000\u0149\u014b\u0003\u001e"+
		"\u000f\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000"+
		"\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000"+
		"\u0000\u0000\u014d\u014f\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000"+
		"\u0000\u0000\u014f\u0150\u0005$\u0000\u0000\u0150\u0017\u0001\u0000\u0000"+
		"\u0000\u0151\u0153\u00054\u0000\u0000\u0152\u0151\u0001\u0000\u0000\u0000"+
		"\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000"+
		"\u0154\u0155\u0005\u001a\u0000\u0000\u0155\u0019\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u00054\u0000\u0000\u0157\u0158\u00051\u0000\u0000\u0158\u0159"+
		"\u0003\u001e\u000f\u0000\u0159\u015a\u0005$\u0000\u0000\u015a\u0178\u0001"+
		"\u0000\u0000\u0000\u015b\u015c\u00054\u0000\u0000\u015c\u015d\u0005\u001c"+
		"\u0000\u0000\u015d\u015e\u0003\u001e\u000f\u0000\u015e\u015f\u0005\u001d"+
		"\u0000\u0000\u015f\u0160\u00051\u0000\u0000\u0160\u0161\u0003\u001e\u000f"+
		"\u0000\u0161\u0162\u0005$\u0000\u0000\u0162\u0178\u0001\u0000\u0000\u0000"+
		"\u0163\u0164\u00054\u0000\u0000\u0164\u0165\u0005#\u0000\u0000\u0165\u0166"+
		"\u00054\u0000\u0000\u0166\u0167\u00051\u0000\u0000\u0167\u0168\u0003\u001e"+
		"\u000f\u0000\u0168\u0169\u0005$\u0000\u0000\u0169\u0178\u0001\u0000\u0000"+
		"\u0000\u016a\u016b\u00054\u0000\u0000\u016b\u016c\u0005\u001c\u0000\u0000"+
		"\u016c\u016d\u0003\u001e\u000f\u0000\u016d\u016e\u0005\u001d\u0000\u0000"+
		"\u016e\u016f\u0005#\u0000\u0000\u016f\u0170\u00054\u0000\u0000\u0170\u0171"+
		"\u00051\u0000\u0000\u0171\u0172\u0003\u001e\u000f\u0000\u0172\u0173\u0005"+
		"$\u0000\u0000\u0173\u0178\u0001\u0000\u0000\u0000\u0174\u0175\u0003\u001c"+
		"\u000e\u0000\u0175\u0176\u0005$\u0000\u0000\u0176\u0178\u0001\u0000\u0000"+
		"\u0000\u0177\u0156\u0001\u0000\u0000\u0000\u0177\u015b\u0001\u0000\u0000"+
		"\u0000\u0177\u0163\u0001\u0000\u0000\u0000\u0177\u016a\u0001\u0000\u0000"+
		"\u0000\u0177\u0174\u0001\u0000\u0000\u0000\u0178\u001b\u0001\u0000\u0000"+
		"\u0000\u0179\u017a\u00054\u0000\u0000\u017a\u017e\u0005%\u0000\u0000\u017b"+
		"\u017c\u00054\u0000\u0000\u017c\u017e\u0005&\u0000\u0000\u017d\u0179\u0001"+
		"\u0000\u0000\u0000\u017d\u017b\u0001\u0000\u0000\u0000\u017e\u001d\u0001"+
		"\u0000\u0000\u0000\u017f\u0180\u0006\u000f\uffff\uffff\u0000\u0180\u0181"+
		"\u0005(\u0000\u0000\u0181\u01bb\u0003\u001e\u000f\u0017\u0182\u0183\u0005"+
		"\u0016\u0000\u0000\u0183\u01bb\u0003\u001e\u000f\u0016\u0184\u0185\u0005"+
		" \u0000\u0000\u0185\u0186\u0003\u001e\u000f\u0000\u0186\u0187\u0005!\u0000"+
		"\u0000\u0187\u01bb\u0001\u0000\u0000\u0000\u0188\u0189\u00054\u0000\u0000"+
		"\u0189\u0192\u0005 \u0000\u0000\u018a\u018f\u0003\u001e\u000f\u0000\u018b"+
		"\u018c\u0005\"\u0000\u0000\u018c\u018e\u0003\u001e\u000f\u0000\u018d\u018b"+
		"\u0001\u0000\u0000\u0000\u018e\u0191\u0001\u0000\u0000\u0000\u018f\u018d"+
		"\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0193"+
		"\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000\u0000\u0000\u0192\u018a"+
		"\u0001\u0000\u0000\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193\u0194"+
		"\u0001\u0000\u0000\u0000\u0194\u01bb\u0005!\u0000\u0000\u0195\u0196\u0003"+
		" \u0010\u0000\u0196\u0197\u00054\u0000\u0000\u0197\u01a0\u0005 \u0000"+
		"\u0000\u0198\u019d\u0003\u001e\u000f\u0000\u0199\u019a\u0005\"\u0000\u0000"+
		"\u019a\u019c\u0003\u001e\u000f\u0000\u019b\u0199\u0001\u0000\u0000\u0000"+
		"\u019c\u019f\u0001\u0000\u0000\u0000\u019d\u019b\u0001\u0000\u0000\u0000"+
		"\u019d\u019e\u0001\u0000\u0000\u0000\u019e\u01a1\u0001\u0000\u0000\u0000"+
		"\u019f\u019d\u0001\u0000\u0000\u0000\u01a0\u0198\u0001\u0000\u0000\u0000"+
		"\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000"+
		"\u01a2\u01a3\u0005!\u0000\u0000\u01a3\u01bb\u0001\u0000\u0000\u0000\u01a4"+
		"\u01a5\u0005\u000f\u0000\u0000\u01a5\u01a6\u00054\u0000\u0000\u01a6\u01af"+
		"\u0005 \u0000\u0000\u01a7\u01ac\u0003\u001e\u000f\u0000\u01a8\u01a9\u0005"+
		"\"\u0000\u0000\u01a9\u01ab\u0003\u001e\u000f\u0000\u01aa\u01a8\u0001\u0000"+
		"\u0000\u0000\u01ab\u01ae\u0001\u0000\u0000\u0000\u01ac\u01aa\u0001\u0000"+
		"\u0000\u0000\u01ac\u01ad\u0001\u0000\u0000\u0000\u01ad\u01b0\u0001\u0000"+
		"\u0000\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000\u01af\u01a7\u0001\u0000"+
		"\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b1\u01bb\u0005!\u0000\u0000\u01b2\u01bb\u0005\r\u0000"+
		"\u0000\u01b3\u01bb\u0005\f\u0000\u0000\u01b4\u01bb\u0005\u000e\u0000\u0000"+
		"\u01b5\u01bb\u00054\u0000\u0000\u01b6\u01bb\u00056\u0000\u0000\u01b7\u01bb"+
		"\u00055\u0000\u0000\u01b8\u01bb\u00058\u0000\u0000\u01b9\u01bb\u00057"+
		"\u0000\u0000\u01ba\u017f\u0001\u0000\u0000\u0000\u01ba\u0182\u0001\u0000"+
		"\u0000\u0000\u01ba\u0184\u0001\u0000\u0000\u0000\u01ba\u0188\u0001\u0000"+
		"\u0000\u0000\u01ba\u0195\u0001\u0000\u0000\u0000\u01ba\u01a4\u0001\u0000"+
		"\u0000\u0000\u01ba\u01b2\u0001\u0000\u0000\u0000\u01ba\u01b3\u0001\u0000"+
		"\u0000\u0000\u01ba\u01b4\u0001\u0000\u0000\u0000\u01ba\u01b5\u0001\u0000"+
		"\u0000\u0000\u01ba\u01b6\u0001\u0000\u0000\u0000\u01ba\u01b7\u0001\u0000"+
		"\u0000\u0000\u01ba\u01b8\u0001\u0000\u0000\u0000\u01ba\u01b9\u0001\u0000"+
		"\u0000\u0000\u01bb\u01e7\u0001\u0000\u0000\u0000\u01bc\u01bd\n\u0011\u0000"+
		"\u0000\u01bd\u01be\u0007\u0000\u0000\u0000\u01be\u01e6\u0003\u001e\u000f"+
		"\u0012\u01bf\u01c0\n\u0010\u0000\u0000\u01c0\u01c1\u0007\u0001\u0000\u0000"+
		"\u01c1\u01e6\u0003\u001e\u000f\u0011\u01c2\u01c3\n\u000f\u0000\u0000\u01c3"+
		"\u01c4\u0007\u0002\u0000\u0000\u01c4\u01e6\u0003\u001e\u000f\u0010\u01c5"+
		"\u01c6\n\u000e\u0000\u0000\u01c6\u01c7\u0007\u0003\u0000\u0000\u01c7\u01e6"+
		"\u0003\u001e\u000f\u000f\u01c8\u01c9\n\r\u0000\u0000\u01c9\u01ca\u0007"+
		"\u0004\u0000\u0000\u01ca\u01e6\u0003\u001e\u000f\u000e\u01cb\u01cc\n\f"+
		"\u0000\u0000\u01cc\u01cd\u0007\u0005\u0000\u0000\u01cd\u01e6\u0003\u001e"+
		"\u000f\r\u01ce\u01cf\n\u0014\u0000\u0000\u01cf\u01d0\u0005#\u0000\u0000"+
		"\u01d0\u01d1\u00054\u0000\u0000\u01d1\u01da\u0005 \u0000\u0000\u01d2\u01d7"+
		"\u0003\u001e\u000f\u0000\u01d3\u01d4\u0005\"\u0000\u0000\u01d4\u01d6\u0003"+
		"\u001e\u000f\u0000\u01d5\u01d3\u0001\u0000\u0000\u0000\u01d6\u01d9\u0001"+
		"\u0000\u0000\u0000\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d7\u01d8\u0001"+
		"\u0000\u0000\u0000\u01d8\u01db\u0001\u0000\u0000\u0000\u01d9\u01d7\u0001"+
		"\u0000\u0000\u0000\u01da\u01d2\u0001\u0000\u0000\u0000\u01da\u01db\u0001"+
		"\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc\u01e6\u0005"+
		"!\u0000\u0000\u01dd\u01de\n\u0013\u0000\u0000\u01de\u01df\u0005#\u0000"+
		"\u0000\u01df\u01e6\u00054\u0000\u0000\u01e0\u01e1\n\u0012\u0000\u0000"+
		"\u01e1\u01e2\u0005\u001c\u0000\u0000\u01e2\u01e3\u0003\u001e\u000f\u0000"+
		"\u01e3\u01e4\u0005\u001d\u0000\u0000\u01e4\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e5\u01bc\u0001\u0000\u0000\u0000\u01e5\u01bf\u0001\u0000\u0000\u0000"+
		"\u01e5\u01c2\u0001\u0000\u0000\u0000\u01e5\u01c5\u0001\u0000\u0000\u0000"+
		"\u01e5\u01c8\u0001\u0000\u0000\u0000\u01e5\u01cb\u0001\u0000\u0000\u0000"+
		"\u01e5\u01ce\u0001\u0000\u0000\u0000\u01e5\u01dd\u0001\u0000\u0000\u0000"+
		"\u01e5\u01e0\u0001\u0000\u0000\u0000\u01e6\u01e9\u0001\u0000\u0000\u0000"+
		"\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000\u0000"+
		"\u01e8\u001f\u0001\u0000\u0000\u0000\u01e9\u01e7\u0001\u0000\u0000\u0000"+
		"\u01ea\u01eb\u0007\u0006\u0000\u0000\u01eb!\u0001\u0000\u0000\u0000+#"+
		"*.:AR]\u00a1\u00a5\u00ac\u00b4\u00b8\u00c0\u00c3\u00cb\u00ce\u00d2\u00d9"+
		"\u00e0\u00ea\u00fa\u0105\u011e\u0127\u0131\u0138\u0140\u0144\u014c\u0152"+
		"\u0177\u017d\u018f\u0192\u019d\u01a0\u01ac\u01af\u01ba\u01d7\u01da\u01e5"+
		"\u01e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}