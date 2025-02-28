import com.valkyrix.engine.ValkyrixExecutor;

import java.util.HashMap;
import java.util.Map;

public class RiskEngineDemo {
    public static void main(String[] args) {
        ValkyrixExecutor executor = new ValkyrixExecutor();

        // 注册规则（实际可通过注解扫描自动注册）
        executor.registerRule("anti_fraud_rule",
                "(user.age < 18 && transaction.amount > 5000) || transaction.ipRiskLevel == 'BLACKLIST'"
        );

     /*   executor.registerRule("anti_fraud_rule",
                "1>2 || (1>2 || (1>2 || 1<2))"
        );*/

        // 模拟数据
        // 创建嵌套数据结构
        Map<String, Object> user = new HashMap<>();
        user.put("age", 20);

        Map<String, Object> tx = new HashMap<>();
        tx.put("amount", 6000.0);
        tx.put("ipRiskLevel", "BLACKLIST");

        Map<String, Object> context = Map.of(
                "user", user,
                "transaction", tx
        );

        // 执行风控检查
        boolean isFraud = executor.execute("anti_fraud_rule", context);

        System.out.println("是否风险交易: " + isFraud); // 输出: 是否风险交易: true
    }
}

