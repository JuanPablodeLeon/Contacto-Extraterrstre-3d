// Generated from src/main/java/antlr4/com/YLenguajeParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link YLenguajeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface YLenguajeParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#inicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicio(YLenguajeParser.InicioContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#bloq_estruc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloq_estruc(YLenguajeParser.Bloq_estrucContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#esctruc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEsctruc(YLenguajeParser.EsctrucContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#bloq_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloq_func(YLenguajeParser.Bloq_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#bloc_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloc_func(YLenguajeParser.Bloc_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(YLenguajeParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#bloc_llaves}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloc_llaves(YLenguajeParser.Bloc_llavesContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#val_arreglo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal_arreglo(YLenguajeParser.Val_arregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(YLenguajeParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#bloc_si}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloc_si(YLenguajeParser.Bloc_siContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(YLenguajeParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#definiciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniciones(YLenguajeParser.DefinicionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#asignaciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignaciones(YLenguajeParser.AsignacionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(YLenguajeParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParser#tipos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipos(YLenguajeParser.TiposContext ctx);
}