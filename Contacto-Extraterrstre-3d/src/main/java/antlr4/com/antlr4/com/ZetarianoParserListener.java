// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/ZetarianoParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ZetarianoParserParser}.
 */
public interface ZetarianoParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#inicio}.
	 * @param ctx the parse tree
	 */
	void enterInicio(ZetarianoParserParser.InicioContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#inicio}.
	 * @param ctx the parse tree
	 */
	void exitInicio(ZetarianoParserParser.InicioContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#bloc_main}.
	 * @param ctx the parse tree
	 */
	void enterBloc_main(ZetarianoParserParser.Bloc_mainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#bloc_main}.
	 * @param ctx the parse tree
	 */
	void exitBloc_main(ZetarianoParserParser.Bloc_mainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(ZetarianoParserParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(ZetarianoParserParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(ZetarianoParserParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(ZetarianoParserParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#bloque_si}.
	 * @param ctx the parse tree
	 */
	void enterBloque_si(ZetarianoParserParser.Bloque_siContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#bloque_si}.
	 * @param ctx the parse tree
	 */
	void exitBloque_si(ZetarianoParserParser.Bloque_siContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#bloque_switch}.
	 * @param ctx the parse tree
	 */
	void enterBloque_switch(ZetarianoParserParser.Bloque_switchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#bloque_switch}.
	 * @param ctx the parse tree
	 */
	void exitBloque_switch(ZetarianoParserParser.Bloque_switchContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(ZetarianoParserParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(ZetarianoParserParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(ZetarianoParserParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(ZetarianoParserParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(ZetarianoParserParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(ZetarianoParserParser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(ZetarianoParserParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(ZetarianoParserParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#param_var}.
	 * @param ctx the parse tree
	 */
	void enterParam_var(ZetarianoParserParser.Param_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#param_var}.
	 * @param ctx the parse tree
	 */
	void exitParam_var(ZetarianoParserParser.Param_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(ZetarianoParserParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(ZetarianoParserParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParserParser#tipos}.
	 * @param ctx the parse tree
	 */
	void enterTipos(ZetarianoParserParser.TiposContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParserParser#tipos}.
	 * @param ctx the parse tree
	 */
	void exitTipos(ZetarianoParserParser.TiposContext ctx);
}