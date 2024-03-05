// Generated from /home/alexey/00university/05semester/01translation_methods/_real03lab/src/main/java/org/grunskii/Latex.g4 by ANTLR 4.13.1
package org.grunskii;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LatexParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LatexVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LatexParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntry(LatexParser.EntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatexParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(LatexParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatexParser#lower}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLower(LatexParser.LowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatexParser#upper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpper(LatexParser.UpperContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatexParser#iSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISymbol(LatexParser.ISymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatexParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(LatexParser.SymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatexParser#iText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIText(LatexParser.ITextContext ctx);
	/**
	 * Visit a parse tree produced by {@link LatexParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(LatexParser.TextContext ctx);
}