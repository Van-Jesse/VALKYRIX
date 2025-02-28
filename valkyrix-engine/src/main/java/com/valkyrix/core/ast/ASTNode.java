package com.valkyrix.core.ast;

import java.util.Map;

public abstract class ASTNode {
    public abstract Object evaluate(Map<String, Object> context);
}
