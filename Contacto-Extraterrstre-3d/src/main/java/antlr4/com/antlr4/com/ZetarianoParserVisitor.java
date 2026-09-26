// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/ZetarianoParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ZetarianoParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ZetarianoParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#inicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicio(ZetarianoParserParser.InicioContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#bloc_main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloc_main(ZetarianoParserParser.Bloc_mainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(ZetarianoParserParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(ZetarianoParserParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#bloque_si}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_si(ZetarianoParserParser.Bloque_siContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#bloque_switch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_switch(ZetarianoParserParser.Bloque_switchContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(ZetarianoParserParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(ZetarianoParserParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(ZetarianoParserParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(ZetarianoParserParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#param_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_var(ZetarianoParserParser.Param_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(ZetarianoParserParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParserParser#tipos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipos(ZetarianoParserParser.TiposContext ctx);
}