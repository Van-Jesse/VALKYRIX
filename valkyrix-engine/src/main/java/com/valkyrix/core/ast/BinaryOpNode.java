package com.valkyrix.core.ast;

import java.util.Map;

public class BinaryOpNode extends ASTNode{
    public final String operator;
    public final ASTNode left;
    public final ASTNode right;

    public BinaryOpNode(String operator, ASTNode left, ASTNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    // 获取操作符（例如 "*/"）
    public String getOperator() {
        return operator;
    }

    // 获取左子树
    public ASTNode getLeft() {
        return left;
    }

    // 获取右子树
    public ASTNode getRight() {
        return right;
    }

    @Override
    public Object evaluate(Map<String, Object> context) {
        Object leftVal = left.evaluate(context);
        Object rightVal = right.evaluate(context);

        // 实现具体运算逻辑
        switch (operator) {
            case "*": return toNumber(leftVal) * toNumber(rightVal);
            case "/": return toNumber(leftVal) / toNumber(rightVal);
            case "+": return toNumber(leftVal) + toNumber(rightVal);
            case "-": return toNumber(leftVal) - toNumber(rightVal);
            case ">": return toNumber(leftVal) > toNumber(rightVal);
            case "<": return toNumber(leftVal) < toNumber(rightVal);
            case "&&": return toBoolean(leftVal) && toBoolean(rightVal);
            case "||": return toBoolean(leftVal) || toBoolean(rightVal);
            default: throw new UnsupportedOperationException("Unknown operator: " + operator);
        }
    }

    private Number toNumber(Object val) {
        if (val instanceof Number) return (Number) val;
        throw new ClassCastException("Cannot convert to number: " + val);
    }

    private boolean toBoolean(Object val) {
        if (val instanceof Boolean) return (Boolean) val;
        throw new ClassCastException("Cannot convert to boolean: " + val);
    }
}
