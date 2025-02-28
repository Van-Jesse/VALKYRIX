package com.valkyrix.core.ast;

import java.util.Map;

public class StringLiteralNode extends ASTNode{
    private final String value;

    public StringLiteralNode(String value) {
        this.value = value;
    }

    @Override
    public Object evaluate(Map<String, Object> context) {
        return value;
    }

    @Override
    public String toString() {
        return "'" + value + "'";
    }
}
