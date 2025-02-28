import com.valkyrix.engine.ValkyrixExecutor;
import com.valkyrix.rules.RuleScanner;

import java.util.HashMap;
import java.util.Map;

public class RiskEngineDemo {
    public static void main(String[] args) {
        ValkyrixExecutor executor = new ValkyrixExecutor();

        // 自动扫描注册规则（替代手动注册）
        new RuleScanner(executor).scan("com.valkyrix.rules");

        // 构建测试数据
        Map<String, Object> user = new HashMap<>();
        user.put("age", 20); // 用户年龄超过阈值

        Map<String, Object> transaction = new HashMap<>();
        transaction.put("amount", 6000.0); // 交易金额超限
        transaction.put("ipRiskLevel", "BLACKLIST"); // IP在黑名单

        Map<String, Object> context = Map.of(
                "user", user,
                "transaction", transaction
        );

        // 执行规则
        boolean isFraud = executor.execute("anti_fraud_rule", context);

        System.out.println("是否风险交易: " + isFraud);
        // 输出: 是否风险交易: true（因为 ipRiskLevel == BLACKLIST 满足条件）
    }
}

