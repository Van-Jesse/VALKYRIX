package com.valkyrix.engine;

import com.valkyrix.parser.RiskRuleLexer;
import com.valkyrix.parser.RiskRuleParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;

public class ValkyrixExecutor {
    private final Map<String, String> rules = new HashMap<>();

    public void registerRule(String name, String expression) {
        rules.put(name, expression);
    }

    public boolean execute(String ruleName, Map<String, Object> context) {
        String expr = rules.get(ruleName);
        if (expr == null) throw new IllegalArgumentException("规则不存在: " + ruleName);

        RiskRuleLexer lexer = new RiskRuleLexer(CharStreams.fromString(expr));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RiskRuleParser parser = new RiskRuleParser(tokens);
        // 添加错误监听器（关键！）
        parser.removeErrorListeners(); // 移除默认监听器
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException("解析错误: 行 " + line + ":" + charPositionInLine + " " + msg);
            }


        });
        ParseTree tree = parser.expression();
        return (boolean) new RiskRuleEvaluator(context).visit(tree);
    }
}
