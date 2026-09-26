// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/YLenguajeParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YLenguajeParserParser}.
 */
public interface YLenguajeParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#inicio}.
	 * @param ctx the parse tree
	 */
	void enterInicio(YLenguajeParserParser.InicioContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#inicio}.
	 * @param ctx the parse tree
	 */
	void exitInicio(YLenguajeParserParser.InicioContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(YLenguajeParserParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(YLenguajeParserParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#bloq_estruc}.
	 * @param ctx the parse tree
	 */
	void enterBloq_estruc(YLenguajeParserParser.Bloq_estrucContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#bloq_estruc}.
	 * @param ctx the parse tree
	 */
	void exitBloq_estruc(YLenguajeParserParser.Bloq_estrucContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#esctruc}.
	 * @param ctx the parse tree
	 */
	void enterEsctruc(YLenguajeParserParser.EsctrucContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#esctruc}.
	 * @param ctx the parse tree
	 */
	void exitEsctruc(YLenguajeParserParser.EsctrucContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#bloq_func}.
	 * @param ctx the parse tree
	 */
	void enterBloq_func(YLenguajeParserParser.Bloq_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#bloq_func}.
	 * @param ctx the parse tree
	 */
	void exitBloq_func(YLenguajeParserParser.Bloq_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#bloc_func}.
	 * @param ctx the parse tree
	 */
	void enterBloc_func(YLenguajeParserParser.Bloc_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#bloc_func}.
	 * @param ctx the parse tree
	 */
	void exitBloc_func(YLenguajeParserParser.Bloc_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(YLenguajeParserParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(YLenguajeParserParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#bloc_llaves}.
	 * @param ctx the parse tree
	 */
	void enterBloc_llaves(YLenguajeParserParser.Bloc_llavesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#bloc_llaves}.
	 * @param ctx the parse tree
	 */
	void exitBloc_llaves(YLenguajeParserParser.Bloc_llavesContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#val_arreglo}.
	 * @param ctx the parse tree
	 */
	void enterVal_arreglo(YLenguajeParserParser.Val_arregloContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#val_arreglo}.
	 * @param ctx the parse tree
	 */
	void exitVal_arreglo(YLenguajeParserParser.Val_arregloContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(YLenguajeParserParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(YLenguajeParserParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#bloc_si}.
	 * @param ctx the parse tree
	 */
	void enterBloc_si(YLenguajeParserParser.Bloc_siContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#bloc_si}.
	 * @param ctx the parse tree
	 */
	void exitBloc_si(YLenguajeParserParser.Bloc_siContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(YLenguajeParserParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(YLenguajeParserParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#definiciones}.
	 * @param ctx the parse tree
	 */
	void enterDefiniciones(YLenguajeParserParser.DefinicionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#definiciones}.
	 * @param ctx the parse tree
	 */
	void exitDefiniciones(YLenguajeParserParser.DefinicionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#asignaciones}.
	 * @param ctx the parse tree
	 */
	void enterAsignaciones(YLenguajeParserParser.AsignacionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#asignaciones}.
	 * @param ctx the parse tree
	 */
	void exitAsignaciones(YLenguajeParserParser.AsignacionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(YLenguajeParserParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(YLenguajeParserParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParserParser#tipos}.
	 * @param ctx the parse tree
	 */
	void enterTipos(YLenguajeParserParser.TiposContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParserParser#tipos}.
	 * @param ctx the parse tree
	 */
	void exitTipos(YLenguajeParserParser.TiposContext ctx);
}