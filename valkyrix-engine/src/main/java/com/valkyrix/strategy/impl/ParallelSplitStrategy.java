package com.valkyrix.strategy.impl;

import com.valkyrix.core.ast.*;
import com.valkyrix.strategy.SplitStrategy;

public class ParallelSplitStrategy implements SplitStrategy {
    @Override
    public boolean shouldSplit(BinaryOpNode node) {
        return node.getOperator().matches("[*/]") &&
                isIndependent(node.getLeft()) &&
                isIndependent(node.getRight());
    }

    private boolean isIndependent(ASTNode node) {
        return node instanceof VariableNode ||
                node instanceof NumberNode ||
                node instanceof StringLiteralNode;
    }
}
