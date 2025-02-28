package com.valkyrix.strategy;

import com.valkyrix.core.ast.BinaryOpNode;

public interface SplitStrategy {
    boolean shouldSplit(BinaryOpNode node);
}
