package com.xuren.loginserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xuren
 */
@Data
@Component
@ConfigurationProperties(prefix = "server")
public class BootConfig {
    private int port;
}
