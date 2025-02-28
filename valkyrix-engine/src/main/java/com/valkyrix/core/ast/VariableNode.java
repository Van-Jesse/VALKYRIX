package com.valkyrix.core.ast;

import java.util.Map;

public class VariableNode extends ASTNode{
    private final String name;

    public VariableNode(String name) {
        this.name = name;
    }

    @Override
    public Object evaluate(Map<String, Object> context) {
        return context.get(name);
    }
}
