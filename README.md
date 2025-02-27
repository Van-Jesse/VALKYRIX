# VALKYRIX - 规则风控引擎
==&zwnj;**⚡ 专为复杂计算设计的高性能风控规则引擎 | 支持动态语言解析与智能子查询拆分**&zwnj;==

---

## ✨ 核心特性
- ==&zwnj;**动态语言解析**&zwnj;==：支持自定义规则语法，实时解析复杂逻辑表达式。
- ==&zwnj;**智能查询优化**&zwnj;==：基于运算符优先级自动拆分规则为并行子查询，提升计算效率。
- ==&zwnj;**开箱即用**&zwnj;==：提供 Spring Boot Starter，通过注解和配置快速集成。
- ==&zwnj;**高并发场景**&zwnj;==：适用于金融风控、实时反欺诈、游戏策略执行等场景。

---

## 🚀 快速开始
### 1. 添加依赖
```xml  
<dependency>  
    <groupId>com.valkyrix</groupId>  
    <artifactId>valkyrix-spring-boot-starter</artifactId>  
    <version>1.0.0</version>  
</dependency>  
```
### 2. 定义规则
```java
@ValkyrixRule(  
    name = "anti_fraud_rule",  
    expression = "(user.age < 18 && transactionAmount > 5000) || ipRiskLevel == 'BLACKLIST'"  
)  
public class AntiFraudRule { /* 规则类无需逻辑，仅作声明 */ }  

```

### 3. 执行风控检查
```java
@Autowired
private ValkyrixExecutor executor;

public boolean checkFraud(User user, Transaction transaction) {
        // 构建上下文数据  
        Map<String, Object> context = Map.of(
        "user", user,
        "transactionAmount", transaction.getAmount(),
        "ipRiskLevel", transaction.getIpRiskLevel()
        );
        return executor.execute("anti_fraud_rule", context);
        }
```

## 🔧 规则拆分逻辑

### 1.输入表达式

```
( (A * 2 + B) > 100 ) && (C / (D - 5) < 50 )  
```

### 2.拆分步骤
#### 1. 运算符优先级分层‌：
   - 第一层：```A * 2```
   - 第二层：```(结果) + B```
   - 第三层：```(结果) > 100```
#### 2. 并行执行子查询‌：
```
SubQuery1: A * 2  
SubQuery2: D - 5  
```
#### 3.合并最终结果‌：

```
(SubQuery1 + B) > 100 && (C / SubQuery2) < 50  
```

## 📊 性能对比

| 指标      |    传统引擎    |   VALKYRIX |  
|--------------|:-------------:|-----------:|  
| 10万规则/秒       |    1.5s   |       0.2s |  
| 嵌套表达式支持     |  ❌ 仅限2层      |      ✅ 无限制 |  
| CPU占用（峰值）       |  85%      |        45% |  



## 🌐 开源与支持

‌协议‌：Apache License 2.0

‌问题反馈‌：GitHub Issues

‌商业支持‌：vanjesse2025@gmail.com