// Generated from C:/lab/RiskRule.g4 by ANTLR 4.13.1
package com.valkyrix.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RiskRuleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RiskRuleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RiskRuleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(RiskRuleParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RiskRuleParser#logicalOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOr(RiskRuleParser.LogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link RiskRuleParser#logicalAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAnd(RiskRuleParser.LogicalAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link RiskRuleParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(RiskRuleParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link RiskRuleParser#additive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive(RiskRuleParser.AdditiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link RiskRuleParser#multiplicative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative(RiskRuleParser.MultiplicativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RiskRuleParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(RiskRuleParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RiskRuleParser#identifierPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierPath(RiskRuleParser.IdentifierPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link RiskRuleParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(RiskRuleParser.IdentifierContext ctx);
}