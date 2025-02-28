package com.valkyrix.rules;


import com.valkyrix.engine.ValkyrixExecutor;
import com.valkyrix.engine.ValkyrixRule;
import org.reflections.Reflections;
import java.util.Set;

public class RuleScanner {
    private final ValkyrixExecutor executor;

    public RuleScanner(ValkyrixExecutor executor) {
        this.executor = executor;
    }

    public void scan(String basePackage) {
        Reflections reflections = new Reflections(basePackage);
        // 扫描带有 ValkyrixRule 注解的类
        Set<Class<?>> ruleClasses = reflections.getTypesAnnotatedWith(ValkyrixRule.class);

        for (Class<?> clazz : ruleClasses) {
            ValkyrixRule annotation = clazz.getAnnotation(ValkyrixRule.class);
            executor.registerRule(annotation.name(), annotation.expression());
        }
    }
}
