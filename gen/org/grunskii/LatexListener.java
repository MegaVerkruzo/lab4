// Generated from /home/alexey/00university/05semester/01translation_methods/_real03lab/src/main/java/org/grunskii/Latex.g4 by ANTLR 4.13.1
package org.grunskii;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LatexParser}.
 */
public interface LatexListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LatexParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(LatexParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(LatexParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(LatexParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(LatexParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#lower}.
	 * @param ctx the parse tree
	 */
	void enterLower(LatexParser.LowerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#lower}.
	 * @param ctx the parse tree
	 */
	void exitLower(LatexParser.LowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#upper}.
	 * @param ctx the parse tree
	 */
	void enterUpper(LatexParser.UpperContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#upper}.
	 * @param ctx the parse tree
	 */
	void exitUpper(LatexParser.UpperContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#iSymbol}.
	 * @param ctx the parse tree
	 */
	void enterISymbol(LatexParser.ISymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#iSymbol}.
	 * @param ctx the parse tree
	 */
	void exitISymbol(LatexParser.ISymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(LatexParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(LatexParser.SymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#iText}.
	 * @param ctx the parse tree
	 */
	void enterIText(LatexParser.ITextContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#iText}.
	 * @param ctx the parse tree
	 */
	void exitIText(LatexParser.ITextContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatexParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(LatexParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatexParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(LatexParser.TextContext ctx);
}