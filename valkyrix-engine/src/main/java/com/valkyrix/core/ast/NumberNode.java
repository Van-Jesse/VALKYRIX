package com.valkyrix.core.ast;

import java.util.Map;

public class NumberNode extends ASTNode{
    private final Number value;

    public NumberNode(Number value) {
        this.value = value;
    }

    @Override
    public Object evaluate(Map<String, Object> context) {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
