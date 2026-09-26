// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/PigLatinParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PigLatinParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PigLatinParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#inicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicio(PigLatinParserParser.InicioContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(PigLatinParserParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#bloque_imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_imports(PigLatinParserParser.Bloque_importsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#vars_par}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars_par(PigLatinParserParser.Vars_parContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#bloque_vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_vars(PigLatinParserParser.Bloque_varsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#tipos_varios}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipos_varios(PigLatinParserParser.Tipos_variosContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#bloque_varios}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_varios(PigLatinParserParser.Bloque_variosContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#bloque_objt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_objt(PigLatinParserParser.Bloque_objtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#bloque_main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_main(PigLatinParserParser.Bloque_mainContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(PigLatinParserParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#bloque_si}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_si(PigLatinParserParser.Bloque_siContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Impresion_Consola}
	 * labeled alternative in {@link PigLatinParserParser#bloque_impr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpresion_Consola(PigLatinParserParser.Impresion_ConsolaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lectura_Texto}
	 * labeled alternative in {@link PigLatinParserParser#bloque_leer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLectura_Texto(PigLatinParserParser.Lectura_TextoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#bloque_asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_asignacion(PigLatinParserParser.Bloque_asignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#auto_cambio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuto_cambio(PigLatinParserParser.Auto_cambioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Llmada_Elemnto_FUnc_Serie}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlmada_Elemnto_FUnc_Serie(PigLatinParserParser.Llmada_Elemnto_FUnc_SerieContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Llamada_Series_Valor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamada_Series_Valor(PigLatinParserParser.Llamada_Series_ValorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentesis}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentesis(PigLatinParserParser.ParentesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalsusValor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalsusValor(PigLatinParserParser.FalsusValorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntVal(PigLatinParserParser.IntValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Llamada_Series_Structura}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamada_Series_Structura(PigLatinParserParser.Llamada_Series_StructuraContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharVal(PigLatinParserParser.CharValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SumaResta}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumaResta(PigLatinParserParser.SumaRestaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negacion}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegacion(PigLatinParserParser.NegacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Llamada_Elemento_Series}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamada_Elemento_Series(PigLatinParserParser.Llamada_Elemento_SeriesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDiv(PigLatinParserParser.MultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Llamada_Actio_Exp}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamada_Actio_Exp(PigLatinParserParser.Llamada_Actio_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IgualNoIgual}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgualNoIgual(PigLatinParserParser.IgualNoIgualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MenorMayor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorMayor(PigLatinParserParser.MenorMayorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Llamada_Ratio_Tipo}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamada_Ratio_Tipo(PigLatinParserParser.Llamada_Ratio_TipoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleVal(PigLatinParserParser.DoubleValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Llamada_Propiedad_Structura}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamada_Propiedad_Structura(PigLatinParserParser.Llamada_Propiedad_StructuraContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringVal(PigLatinParserParser.StringValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identificador}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(PigLatinParserParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MenorMayorIgual}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorMayorIgual(PigLatinParserParser.MenorMayorIgualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LLamada_Propiedad_Funcion}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLLamada_Propiedad_Funcion(PigLatinParserParser.LLamada_Propiedad_FuncionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VerumValor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerumValor(PigLatinParserParser.VerumValorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndOr}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOr(PigLatinParserParser.AndOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Umenos}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUmenos(PigLatinParserParser.UmenosContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParserParser#tipos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipos(PigLatinParserParser.TiposContext ctx);
}