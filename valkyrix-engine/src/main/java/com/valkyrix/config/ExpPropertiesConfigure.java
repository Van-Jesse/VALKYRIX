package com.valkyrix.config;

import com.valkyrix.executor.ExpExecutorService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ExpProperties.class)
public class ExpPropertiesConfigure {

    @Bean
    @ConditionalOnMissingBean // 当用户未自定义 Bean 时创建
    public ExpExecutorService expExecutorService(ExpProperties properties) {
        return new ExpExecutorService(properties.getInfo());
    }

}
