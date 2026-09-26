// Generated from /home/juanpa/Documentos/Contacto-Extraterrstre-3d/Contacto-Extraterrstre-3d/src/main/java/antlr4/com/PigLatinParser.g4 by ANTLR 4.13.2
package antlr4.com.antlr4.com;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PigLatinParserParser}.
 */
public interface PigLatinParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#inicio}.
	 * @param ctx the parse tree
	 */
	void enterInicio(PigLatinParserParser.InicioContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#inicio}.
	 * @param ctx the parse tree
	 */
	void exitInicio(PigLatinParserParser.InicioContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(PigLatinParserParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(PigLatinParserParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#bloque_imports}.
	 * @param ctx the parse tree
	 */
	void enterBloque_imports(PigLatinParserParser.Bloque_importsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#bloque_imports}.
	 * @param ctx the parse tree
	 */
	void exitBloque_imports(PigLatinParserParser.Bloque_importsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#vars_par}.
	 * @param ctx the parse tree
	 */
	void enterVars_par(PigLatinParserParser.Vars_parContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#vars_par}.
	 * @param ctx the parse tree
	 */
	void exitVars_par(PigLatinParserParser.Vars_parContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#bloque_vars}.
	 * @param ctx the parse tree
	 */
	void enterBloque_vars(PigLatinParserParser.Bloque_varsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#bloque_vars}.
	 * @param ctx the parse tree
	 */
	void exitBloque_vars(PigLatinParserParser.Bloque_varsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#tipos_varios}.
	 * @param ctx the parse tree
	 */
	void enterTipos_varios(PigLatinParserParser.Tipos_variosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#tipos_varios}.
	 * @param ctx the parse tree
	 */
	void exitTipos_varios(PigLatinParserParser.Tipos_variosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#bloque_varios}.
	 * @param ctx the parse tree
	 */
	void enterBloque_varios(PigLatinParserParser.Bloque_variosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#bloque_varios}.
	 * @param ctx the parse tree
	 */
	void exitBloque_varios(PigLatinParserParser.Bloque_variosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#bloque_objt}.
	 * @param ctx the parse tree
	 */
	void enterBloque_objt(PigLatinParserParser.Bloque_objtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#bloque_objt}.
	 * @param ctx the parse tree
	 */
	void exitBloque_objt(PigLatinParserParser.Bloque_objtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#bloque_main}.
	 * @param ctx the parse tree
	 */
	void enterBloque_main(PigLatinParserParser.Bloque_mainContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#bloque_main}.
	 * @param ctx the parse tree
	 */
	void exitBloque_main(PigLatinParserParser.Bloque_mainContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(PigLatinParserParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(PigLatinParserParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#bloque_si}.
	 * @param ctx the parse tree
	 */
	void enterBloque_si(PigLatinParserParser.Bloque_siContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#bloque_si}.
	 * @param ctx the parse tree
	 */
	void exitBloque_si(PigLatinParserParser.Bloque_siContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Impresion_Consola}
	 * labeled alternative in {@link PigLatinParserParser#bloque_impr}.
	 * @param ctx the parse tree
	 */
	void enterImpresion_Consola(PigLatinParserParser.Impresion_ConsolaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Impresion_Consola}
	 * labeled alternative in {@link PigLatinParserParser#bloque_impr}.
	 * @param ctx the parse tree
	 */
	void exitImpresion_Consola(PigLatinParserParser.Impresion_ConsolaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lectura_Texto}
	 * labeled alternative in {@link PigLatinParserParser#bloque_leer}.
	 * @param ctx the parse tree
	 */
	void enterLectura_Texto(PigLatinParserParser.Lectura_TextoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lectura_Texto}
	 * labeled alternative in {@link PigLatinParserParser#bloque_leer}.
	 * @param ctx the parse tree
	 */
	void exitLectura_Texto(PigLatinParserParser.Lectura_TextoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#bloque_asignacion}.
	 * @param ctx the parse tree
	 */
	void enterBloque_asignacion(PigLatinParserParser.Bloque_asignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#bloque_asignacion}.
	 * @param ctx the parse tree
	 */
	void exitBloque_asignacion(PigLatinParserParser.Bloque_asignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#auto_cambio}.
	 * @param ctx the parse tree
	 */
	void enterAuto_cambio(PigLatinParserParser.Auto_cambioContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#auto_cambio}.
	 * @param ctx the parse tree
	 */
	void exitAuto_cambio(PigLatinParserParser.Auto_cambioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Llmada_Elemnto_FUnc_Serie}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLlmada_Elemnto_FUnc_Serie(PigLatinParserParser.Llmada_Elemnto_FUnc_SerieContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Llmada_Elemnto_FUnc_Serie}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLlmada_Elemnto_FUnc_Serie(PigLatinParserParser.Llmada_Elemnto_FUnc_SerieContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Llamada_Series_Valor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLlamada_Series_Valor(PigLatinParserParser.Llamada_Series_ValorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Llamada_Series_Valor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLlamada_Series_Valor(PigLatinParserParser.Llamada_Series_ValorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentesis}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterParentesis(PigLatinParserParser.ParentesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentesis}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitParentesis(PigLatinParserParser.ParentesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalsusValor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterFalsusValor(PigLatinParserParser.FalsusValorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalsusValor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitFalsusValor(PigLatinParserParser.FalsusValorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterIntVal(PigLatinParserParser.IntValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitIntVal(PigLatinParserParser.IntValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Llamada_Series_Structura}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLlamada_Series_Structura(PigLatinParserParser.Llamada_Series_StructuraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Llamada_Series_Structura}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLlamada_Series_Structura(PigLatinParserParser.Llamada_Series_StructuraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterCharVal(PigLatinParserParser.CharValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitCharVal(PigLatinParserParser.CharValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumaResta}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterSumaResta(PigLatinParserParser.SumaRestaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumaResta}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitSumaResta(PigLatinParserParser.SumaRestaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negacion}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterNegacion(PigLatinParserParser.NegacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negacion}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitNegacion(PigLatinParserParser.NegacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Llamada_Elemento_Series}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLlamada_Elemento_Series(PigLatinParserParser.Llamada_Elemento_SeriesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Llamada_Elemento_Series}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLlamada_Elemento_Series(PigLatinParserParser.Llamada_Elemento_SeriesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterMultDiv(PigLatinParserParser.MultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitMultDiv(PigLatinParserParser.MultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Llamada_Actio_Exp}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLlamada_Actio_Exp(PigLatinParserParser.Llamada_Actio_ExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Llamada_Actio_Exp}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLlamada_Actio_Exp(PigLatinParserParser.Llamada_Actio_ExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IgualNoIgual}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterIgualNoIgual(PigLatinParserParser.IgualNoIgualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IgualNoIgual}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitIgualNoIgual(PigLatinParserParser.IgualNoIgualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MenorMayor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterMenorMayor(PigLatinParserParser.MenorMayorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MenorMayor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitMenorMayor(PigLatinParserParser.MenorMayorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Llamada_Ratio_Tipo}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLlamada_Ratio_Tipo(PigLatinParserParser.Llamada_Ratio_TipoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Llamada_Ratio_Tipo}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLlamada_Ratio_Tipo(PigLatinParserParser.Llamada_Ratio_TipoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterDoubleVal(PigLatinParserParser.DoubleValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitDoubleVal(PigLatinParserParser.DoubleValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Llamada_Propiedad_Structura}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLlamada_Propiedad_Structura(PigLatinParserParser.Llamada_Propiedad_StructuraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Llamada_Propiedad_Structura}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLlamada_Propiedad_Structura(PigLatinParserParser.Llamada_Propiedad_StructuraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterStringVal(PigLatinParserParser.StringValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitStringVal(PigLatinParserParser.StringValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identificador}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(PigLatinParserParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identificador}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(PigLatinParserParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MenorMayorIgual}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterMenorMayorIgual(PigLatinParserParser.MenorMayorIgualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MenorMayorIgual}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitMenorMayorIgual(PigLatinParserParser.MenorMayorIgualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LLamada_Propiedad_Funcion}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLLamada_Propiedad_Funcion(PigLatinParserParser.LLamada_Propiedad_FuncionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LLamada_Propiedad_Funcion}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLLamada_Propiedad_Funcion(PigLatinParserParser.LLamada_Propiedad_FuncionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VerumValor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterVerumValor(PigLatinParserParser.VerumValorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VerumValor}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitVerumValor(PigLatinParserParser.VerumValorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndOr}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterAndOr(PigLatinParserParser.AndOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndOr}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitAndOr(PigLatinParserParser.AndOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Umenos}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterUmenos(PigLatinParserParser.UmenosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Umenos}
	 * labeled alternative in {@link PigLatinParserParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitUmenos(PigLatinParserParser.UmenosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParserParser#tipos}.
	 * @param ctx the parse tree
	 */
	void enterTipos(PigLatinParserParser.TiposContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParserParser#tipos}.
	 * @param ctx the parse tree
	 */
	void exitTipos(PigLatinParserParser.TiposContext ctx);
}