package com.valkyrix.executor;

import com.valkyrix.engine.ValkyrixRule;

@ValkyrixRule(
        name = "anti_fraud_rule",
        expression = "(user.age < 18 && transactionAmount > 5000) || ipRiskLevel == 'BLACKLIST'"
)
public class AntiFraudRule {}
