package com.xkl.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "xkl.springboot")
public class SpringBootConfig {

    private String version;
    private String name;
}
