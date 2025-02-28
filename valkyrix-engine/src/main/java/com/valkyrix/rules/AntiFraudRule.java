package com.valkyrix.rules;

import com.valkyrix.engine.ValkyrixRule;

@ValkyrixRule(
        name = "anti_fraud_rule",
        expression = "(user.age < 18 && transaction.amount > 5000) || transaction.ipRiskLevel == 'BLACKLIST'"
)
public class AntiFraudRule {}
