package com.valkyrix.core;

import com.valkyrix.core.ast.*;
import com.valkyrix.core.base.ValkyrixRuleLexer;
import com.valkyrix.core.base.ValkyrixRuleParser;
import com.valkyrix.core.subquery.SubExpression;
import com.valkyrix.exception.RuleParseException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.*;

import static com.valkyrix.core.subquery.SubExpression.generateSubQueryId;

public class RuleParser {

    private final ValkyrixRuleLexer lexer;
    private final ValkyrixRuleParser parser;

    public RuleParser() {
        this.lexer = new ValkyrixRuleLexer(CharStreams.fromString(""));
        this.parser = new ValkyrixRuleParser(new CommonTokenStream(lexer));
    }

    public SyntaxTree parse(String expression) {
        ValkyrixRuleParser.ExpressionContext ctx = parseToContext(expression);
        ASTNode root = buildAST(ctx);
        return new SyntaxTree(root, expression);
    }

    private ValkyrixRuleParser.ExpressionContext parseToContext(String expr) {
        lexer.setInputStream(CharStreams.fromString(expr));
        parser.setTokenStream(new CommonTokenStream(lexer));
        return parser.expression();
    }

    private ASTNode buildAST(ValkyrixRuleParser.ExpressionContext ctx) {
        return buildLogicalExpression(ctx.logicalExpression());
    }

    private ASTNode buildLogicalExpression(ValkyrixRuleParser.LogicalExpressionContext ctx) {
        List<ValkyrixRuleParser.CompareExpressionContext> nodes = ctx.compareExpression();
        ASTNode current = buildCompareExpression(nodes.get(0));

        for (int i = 1; i < nodes.size(); i++) {
            Token op = ctx.LOGICAL_OP(i-1).getSymbol();
            ASTNode right = buildCompareExpression(nodes.get(i));
            current = new BinaryOpNode(op.getText(), current, right);
        }
        return current;
    }

    // 其他build方法类似，完整代码需实现buildCompareExpression、buildAdditiveExpression等

    public List<SubExpression> splitSubQueries(SyntaxTree ast) {
        List<SubExpression> subQueries = new ArrayList<>();
        Deque<ASTNode> stack = new ArrayDeque<>();
        stack.push(ast.getRoot());

        while (!stack.isEmpty()) {
            ASTNode node = stack.pop();
            if (node instanceof BinaryOpNode) {
                BinaryOpNode binNode = (BinaryOpNode) node;
                // 识别可拆分节点（无依赖的乘法/除法）
                if (isIndependentOperation(binNode)) {
                    subQueries.add(createSubQuery(binNode));
                } else {
                    stack.push(binNode.right);
                    stack.push(binNode.left);
                }
            }
        }
        return subQueries;
    }

    private boolean isIndependentOperation(BinaryOpNode node) {
        // 判断是否为独立运算（仅包含变量和常量）
        return node.operator.matches("[*/]") &&
                !hasNestedOperations(node.left) &&
                !hasNestedOperations(node.right);
    }

    private boolean hasNestedOperations(ASTNode node) {
        return node instanceof BinaryOpNode &&
                !((BinaryOpNode) node).operator.matches("[*/]");
    }

    private SubExpression createSubQuery(BinaryOpNode node) {
        return new SubExpression(
                generateSubQueryId(),
                node.left.toString() + node.operator + node.right.toString(),
                node
        );
    }

    // 补充其他构建方法
    private ASTNode buildCompareExpression(ValkyrixRuleParser.CompareExpressionContext ctx) {
        List<ValkyrixRuleParser.AdditiveExpressionContext> nodes = ctx.additiveExpression();
        ASTNode current = buildAdditiveExpression(nodes.get(0));

        for (int i = 1; i < nodes.size(); i++) {
            Token op = ctx.COMPARE_OP(i-1).getSymbol();
            ASTNode right = buildAdditiveExpression(nodes.get(i));
            current = new BinaryOpNode(op.getText(), current, right);
        }
        return current;
    }

    private ASTNode buildAdditiveExpression(ValkyrixRuleParser.AdditiveExpressionContext ctx) {
        List<ValkyrixRuleParser.MultiplicativeExpressionContext> nodes = ctx.multiplicativeExpression();
        ASTNode current = buildMultiplicativeExpression(nodes.get(0));

        for (int i = 1; i < nodes.size(); i++) {
            Token op = ctx.ADDITIVE_OP(i-1).getSymbol();
            ASTNode right = buildMultiplicativeExpression(nodes.get(i));
            current = new BinaryOpNode(op.getText(), current, right);
        }
        return current;
    }

    private ASTNode buildMultiplicativeExpression(ValkyrixRuleParser.MultiplicativeExpressionContext ctx) {
        List<ValkyrixRuleParser.PrimaryExpressionContext> nodes = ctx.primaryExpression();
        ASTNode current = buildPrimaryExpression(nodes.get(0));

        for (int i = 1; i < nodes.size(); i++) {
            Token op = ctx.MULTIPLICATIVE_OP(i-1).getSymbol();
            ASTNode right = buildPrimaryExpression(nodes.get(i));
            current = new BinaryOpNode(op.getText(), current, right);
        }
        return current;
    }



    private ASTNode buildPrimaryExpression(ValkyrixRuleParser.PrimaryExpressionContext ctx) {
        if (Objects.nonNull(ctx) && ctx instanceof ValkyrixRuleParser.VariableExpressionContext && ((ValkyrixRuleParser.VariableExpressionContext)ctx).IDENTIFIER() != null) {
            return new VariableNode(((ValkyrixRuleParser.VariableExpressionContext)ctx).IDENTIFIER().getText());
        } else if (ctx.NUMBER() != null) {
            return parseNumber(ctx.NUMBER().getText());
        } else if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            return new StringLiteralNode(text.substring(1, text.length()-1));
        } else if (ctx.expression() != null) {
            return buildLogicalExpression(ctx.expression().logicalExpression());
        }
        throw new RuleParseException("Unknown primary expression: " + ctx.getText());
    }

    private NumberNode parseNumber(String text) {
        try {
            if (text.contains(".")) {
                return new NumberNode(Double.parseDouble(text));
            }
            return new NumberNode(Long.parseLong(text));
        } catch (NumberFormatException e) {
            throw new RuleParseException("Invalid number format: " + text, e);
        }
    }
}

