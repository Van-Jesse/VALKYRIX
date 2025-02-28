// Generated from C:/Users/fanmi/Downloads/ValkyrixRule.g4 by ANTLR 4.13.1
package com.valkyrix.core.base;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValkyrixRuleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValkyrixRuleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValkyrixRuleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ValkyrixRuleParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrixRuleParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(ValkyrixRuleParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrixRuleParser#compareExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(ValkyrixRuleParser.CompareExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrixRuleParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(ValkyrixRuleParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValkyrixRuleParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(ValkyrixRuleParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link ValkyrixRuleParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(ValkyrixRuleParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link ValkyrixRuleParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(ValkyrixRuleParser.VariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link ValkyrixRuleParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(ValkyrixRuleParser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link ValkyrixRuleParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(ValkyrixRuleParser.StringLiteralContext ctx);
}