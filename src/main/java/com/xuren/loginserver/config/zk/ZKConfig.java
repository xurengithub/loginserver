package com.xuren.loginserver.config.zk;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xuren
 */
@Data
@Component
@ConfigurationProperties(prefix = "curator")
public class ZKConfig {
    private int retryCount;
    private int retrySleepTimeMs;
    private int elapsedTimeMs;
    private String connectString;
    private int sessionTimeoutMs;
    private int connectionTimeoutMs;
    private String namespace;
}
