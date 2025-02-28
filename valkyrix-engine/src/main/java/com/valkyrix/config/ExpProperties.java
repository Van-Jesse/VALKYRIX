package com.valkyrix.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "exp")
@Data
public class ExpProperties {

    private String info;

}
