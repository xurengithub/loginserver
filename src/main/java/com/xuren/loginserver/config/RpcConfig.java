package com.xuren.loginserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xuren
 */
@Data
@Component
@ConfigurationProperties(prefix = "rpc")
public class RpcConfig {
    private int port;
}
