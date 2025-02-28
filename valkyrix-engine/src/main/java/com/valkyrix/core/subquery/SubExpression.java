package com.valkyrix.core.subquery;

import com.valkyrix.core.ast.ASTNode;

import java.util.UUID;

public class SubExpression {
    private final String id;
    private final String expression;
    private final ASTNode astNode;

    public SubExpression(String id, String expression, ASTNode astNode) {
        this.id = id;
        this.expression = expression;
        this.astNode = astNode;
    }

    // 生成唯一ID的工厂方法
    public static String generateSubQueryId() {
        return "subq_" + UUID.randomUUID().toString().substring(0, 8);
    }

    // Getters
    public String getId() { return id; }
    public String getExpression() { return expression; }
    public ASTNode getAstNode() { return astNode; }

    @Override
    public String toString() {
        return "SubExpression[" + expression + "]";
    }
}
