import com.valkyrix.core.RuleParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class UnitTest {
    @Test
    public void test(){
        RuleParser parser = new RuleParser();

        // 解析表达式
        SyntaxTree ast = parser.parse("(user.age < 18 && transactionAmount > 5000) || ipRiskLevel == 'BLACKLIST'");

        // 拆分子查询
        List<SubExpression> subQueries = parser.splitSubQueries(ast);
        subQueries.forEach(sub ->
                System.out.println("可并行子查询: " + sub.getExpression())
        );

        // 执行运算
        Map<String, Object> context = Map.of(
                "user.age", 16,
                "transactionAmount", 6000.0,
                "ipRiskLevel", "WHITELIST"
        );
        boolean result = (boolean) ast.getRoot().evaluate(context);
        System.out.println("规则执行结果: " + result);
    }
}
