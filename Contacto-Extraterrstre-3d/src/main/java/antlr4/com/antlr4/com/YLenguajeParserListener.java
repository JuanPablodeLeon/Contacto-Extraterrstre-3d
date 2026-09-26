// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/YLenguajeParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YLenguajeParser}.
 */
public interface YLenguajeParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#inicio}.
	 * @param ctx the parse tree
	 */
	void enterInicio(YLenguajeParser.InicioContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#inicio}.
	 * @param ctx the parse tree
	 */
	void exitInicio(YLenguajeParser.InicioContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#bloq_estruc}.
	 * @param ctx the parse tree
	 */
	void enterBloq_estruc(YLenguajeParser.Bloq_estrucContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#bloq_estruc}.
	 * @param ctx the parse tree
	 */
	void exitBloq_estruc(YLenguajeParser.Bloq_estrucContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#esctruc}.
	 * @param ctx the parse tree
	 */
	void enterEsctruc(YLenguajeParser.EsctrucContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#esctruc}.
	 * @param ctx the parse tree
	 */
	void exitEsctruc(YLenguajeParser.EsctrucContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#bloq_func}.
	 * @param ctx the parse tree
	 */
	void enterBloq_func(YLenguajeParser.Bloq_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#bloq_func}.
	 * @param ctx the parse tree
	 */
	void exitBloq_func(YLenguajeParser.Bloq_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#bloc_func}.
	 * @param ctx the parse tree
	 */
	void enterBloc_func(YLenguajeParser.Bloc_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#bloc_func}.
	 * @param ctx the parse tree
	 */
	void exitBloc_func(YLenguajeParser.Bloc_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(YLenguajeParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(YLenguajeParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#tipos_params}.
	 * @param ctx the parse tree
	 */
	void enterTipos_params(YLenguajeParser.Tipos_paramsContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#tipos_params}.
	 * @param ctx the parse tree
	 */
	void exitTipos_params(YLenguajeParser.Tipos_paramsContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#bloc_llaves}.
	 * @param ctx the parse tree
	 */
	void enterBloc_llaves(YLenguajeParser.Bloc_llavesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#bloc_llaves}.
	 * @param ctx the parse tree
	 */
	void exitBloc_llaves(YLenguajeParser.Bloc_llavesContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#val_arreglo}.
	 * @param ctx the parse tree
	 */
	void enterVal_arreglo(YLenguajeParser.Val_arregloContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#val_arreglo}.
	 * @param ctx the parse tree
	 */
	void exitVal_arreglo(YLenguajeParser.Val_arregloContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(YLenguajeParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(YLenguajeParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#bloc_si}.
	 * @param ctx the parse tree
	 */
	void enterBloc_si(YLenguajeParser.Bloc_siContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#bloc_si}.
	 * @param ctx the parse tree
	 */
	void exitBloc_si(YLenguajeParser.Bloc_siContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(YLenguajeParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(YLenguajeParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#bloque_elegir}.
	 * @param ctx the parse tree
	 */
	void enterBloque_elegir(YLenguajeParser.Bloque_elegirContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#bloque_elegir}.
	 * @param ctx the parse tree
	 */
	void exitBloque_elegir(YLenguajeParser.Bloque_elegirContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#definiciones}.
	 * @param ctx the parse tree
	 */
	void enterDefiniciones(YLenguajeParser.DefinicionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#definiciones}.
	 * @param ctx the parse tree
	 */
	void exitDefiniciones(YLenguajeParser.DefinicionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#asignaciones}.
	 * @param ctx the parse tree
	 */
	void enterAsignaciones(YLenguajeParser.AsignacionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#asignaciones}.
	 * @param ctx the parse tree
	 */
	void exitAsignaciones(YLenguajeParser.AsignacionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(YLenguajeParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(YLenguajeParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YLenguajeParser#tipos}.
	 * @param ctx the parse tree
	 */
	void enterTipos(YLenguajeParser.TiposContext ctx);
	/**
	 * Exit a parse tree produced by {@link YLenguajeParser#tipos}.
	 * @param ctx the parse tree
	 */
	void exitTipos(YLenguajeParser.TiposContext ctx);
}