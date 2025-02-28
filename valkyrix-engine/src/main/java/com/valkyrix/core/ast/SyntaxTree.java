package com.valkyrix.core.ast;

public class SyntaxTree {
    private final ASTNode root;
    private final String originalExpression;

    public SyntaxTree(ASTNode root, String originalExpression) {
        this.root = root;
        this.originalExpression = originalExpression;
    }

    public ASTNode getRoot() {
        return root;
    }

    public String getOriginalExpression() {
        return originalExpression;
    }

    @Override
    public String toString() {
        return "SyntaxTree[" + originalExpression + "]";
    }
}
