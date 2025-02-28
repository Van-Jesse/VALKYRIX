package com.valkyrix.engine;

import com.valkyrix.parser.RiskRuleBaseVisitor;
import com.valkyrix.parser.RiskRuleParser;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class RiskRuleEvaluator extends RiskRuleBaseVisitor<Object> {
    private final Map<String, Object> context;

    public RiskRuleEvaluator(Map<String, Object> context) {
        this.context = context;
    }

    @Override
    public Object visitLogicalOr(RiskRuleParser.LogicalOrContext ctx) {
        // 逐项求值，遇到 true 立即返回
        for (RiskRuleParser.LogicalAndContext child : ctx.logicalAnd()) {
            Boolean result = (Boolean) visit(child);
            if (result) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object visitLogicalAnd(RiskRuleParser.LogicalAndContext ctx) {
        // 逐项求值，遇到 false 立即返回
        for (RiskRuleParser.ComparisonContext child : ctx.comparison()) {
            Boolean result = (Boolean) visit(child);
            if (!result) {
                return false;
            }
        }
        return true;
    }




    @Override
    public Object visitComparison(RiskRuleParser.ComparisonContext ctx) {
        Object left = visit(ctx.additive(0));
        if (left instanceof Boolean){
            return left;
        }
        Object right = visit(ctx.additive(1));
        String op = ctx.getChild(1).getText();
        // 处理字符串比较
        if (left instanceof String || right instanceof String) {
            String leftStr = left.toString();
            String rightStr = right.toString();
            return switch (op) {
                case "==" -> leftStr.equals(rightStr);
                case "!=" -> !leftStr.equals(rightStr);
                default -> throw new IllegalStateException("字符串不支持运算符: " + op);
            };
        }

        return switch (op) {
            case "<" -> new BigDecimal(left.toString()).compareTo(new BigDecimal(right.toString()))<0;
            case ">" -> new BigDecimal(left.toString()).compareTo(new BigDecimal(right.toString()))>0;
            case "==" -> new BigDecimal(left.toString()).compareTo(new BigDecimal(right.toString()))==0;
            case "!=" -> new BigDecimal(left.toString()).compareTo(new BigDecimal(right.toString()))!=0;
            default -> throw new IllegalStateException("未知运算符: " + op);
        };


    }


    // 覆盖 visitIdentifier 方法（参数类型为 IdentifierContext）
    @Override
    public Object visitIdentifier(RiskRuleParser.IdentifierContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        Object value = context.get(varName);
        if (value == null) {
            throw new IllegalArgumentException("变量未定义: " + varName);
        }
        return value;
    }


    // 新增：处理带嵌套的表达式（如 user.age）
    @Override
    public Object visitPrimary(RiskRuleParser.PrimaryContext ctx) {
        if (ctx.NUMBER() != null) {
            return Double.parseDouble(ctx.NUMBER().getText());
        } else if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            return text.substring(1, text.length() - 1);
        } else if (ctx.identifierPath() != null) {
            // 调用 visitIdentifierPath 处理路径
            String fullPath = (String) visit(ctx.identifierPath());
            return resolveNestedValue(fullPath, context); // 从上下文中解析值
        } else if (ctx.expression() != null) {
            return visit(ctx.expression());
        }
        throw new IllegalArgumentException("未知的 primary 表达式: " + ctx.getText());
    }




    @Override
    public Object visitIdentifierPath(RiskRuleParser.IdentifierPathContext ctx) {
        // 拼接所有标识符（如 user.age → "user.age"）
        return ctx.identifier().stream()
                .map(idCtx -> idCtx.IDENTIFIER().getText())
                .collect(Collectors.joining("."));
    }

    private Object resolveNestedValue(String fullPath, Map<String, Object> context) {
        // 1. 路径合法性检查
        if (fullPath == null || fullPath.isEmpty()) {
            throw new IllegalArgumentException("路径不能为空");
        }

        // 2. 分割路径为层级数组（如 ["user", "age"]）
        String[] parts = fullPath.split("\\.");
        if (parts.length == 0) {
            throw new IllegalArgumentException("路径格式错误: " + fullPath);
        }

        // 3. 获取根节点（路径的第一部分）
        String rootKey = parts[0]; // 明确取数组第一个元素
        Object current = context.get(rootKey);
        if (current == null) {
            throw new IllegalArgumentException("根节点 '" + rootKey + "' 不存在");
        }

        // 4. 逐级解析子路径
        for (int i = 1; i < parts.length; i++) {
            String key = parts[i];
            if (current instanceof Map) {
                // 处理Map类型
                current = ((Map<?, ?>) current).get(key);
            } else {
                // 处理对象类型（反射获取字段）
                try {
                    Field field = getField(current.getClass(), key);
                    current = field.get(current);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("无法访问字段: " + key, e);
                }
            }

            if (current == null) {
                throw new IllegalArgumentException("路径节点 '" + key + "' 不存在于路径: " + fullPath);
            }
        }

        return current;
    }


    // 辅助方法：缓存反射字段提升性能
    private static final Map<Class<?>, Map<String, Field>> FIELD_CACHE = new java.util.concurrent.ConcurrentHashMap<>();

    private static Field getField(Class<?> clazz, String fieldName) {
        return FIELD_CACHE
                .computeIfAbsent(clazz, k -> new java.util.concurrent.ConcurrentHashMap<>())
                .computeIfAbsent(fieldName, k -> {
                    try {
                        Field field = clazz.getDeclaredField(fieldName);
                        field.setAccessible(true);
                        return field;
                    } catch (NoSuchFieldException e) {
                        throw new IllegalArgumentException("字段 '" + fieldName + "' 不存在于类: " + clazz.getName());
                    }
                });
    }


    @Override
    public Object visitAdditive(RiskRuleParser.AdditiveContext ctx) {
        // 递归解析第一个 multiplicative 节点
        Object result = visit(ctx.multiplicative(0));

        // 处理连续的加减操作
        for (int i = 1; i < ctx.multiplicative().size(); i++) {
            Object next = visit(ctx.multiplicative(i));
            String op = ctx.getChild(2 * i - 1).getText(); // 运算符位置
            double num1 = (double) result;
            double num2 = (double) next;

            if (op.equals("+")) {
                result = num1 + num2;
            } else if (op.equals("-")) {
                result = num1 - num2;
            }
        }
        return result;
    }


    @Override
    public Object visitMultiplicative(RiskRuleParser.MultiplicativeContext ctx) {
        Object result = visit(ctx.primary(0));

        // 处理连续的乘除操作
        for (int i = 1; i < ctx.primary().size(); i++) {
            Object next = visit(ctx.primary(i));
            String op = ctx.getChild(2 * i - 1).getText();
            double num1 = (double) result;
            double num2 = (double) next;

            if (op.equals("*")) {
                result = num1 * num2;
            } else if (op.equals("/")) {
                result = num1 / num2;
            }
        }
        return result;
    }

}

