package com.valkyrix.executor;

import com.valkyrix.core.ast.ASTNode;
import com.valkyrix.core.subquery.SubExpression;

import java.util.Collections;
import java.util.List;

public class ExecutionPlan {
    private final List<SubExpression> independentSubQueries;
    private final ASTNode remainingTree;

    public ExecutionPlan(List<SubExpression> independentSubQueries, ASTNode remainingTree) {
        this.independentSubQueries = Collections.unmodifiableList(independentSubQueries);
        this.remainingTree = remainingTree;
    }

    public List<SubExpression> getIndependentSubQueries() {
        return independentSubQueries;
    }

    public ASTNode getRemainingTree() {
        return remainingTree;
    }

    public boolean hasParallelTasks() {
        return !independentSubQueries.isEmpty();
    }
}
