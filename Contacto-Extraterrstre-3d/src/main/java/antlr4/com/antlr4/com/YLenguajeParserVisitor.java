// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/YLenguajeParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link YLenguajeParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface YLenguajeParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#inicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicio(YLenguajeParserParser.InicioContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(YLenguajeParserParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#bloq_estruc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloq_estruc(YLenguajeParserParser.Bloq_estrucContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#esctruc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEsctruc(YLenguajeParserParser.EsctrucContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#bloq_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloq_func(YLenguajeParserParser.Bloq_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#bloc_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloc_func(YLenguajeParserParser.Bloc_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(YLenguajeParserParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#bloc_llaves}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloc_llaves(YLenguajeParserParser.Bloc_llavesContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#val_arreglo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal_arreglo(YLenguajeParserParser.Val_arregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(YLenguajeParserParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#bloc_si}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloc_si(YLenguajeParserParser.Bloc_siContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(YLenguajeParserParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#definiciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniciones(YLenguajeParserParser.DefinicionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#asignaciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignaciones(YLenguajeParserParser.AsignacionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(YLenguajeParserParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YLenguajeParserParser#tipos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipos(YLenguajeParserParser.TiposContext ctx);
}