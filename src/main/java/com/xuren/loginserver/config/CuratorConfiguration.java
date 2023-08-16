package com.xuren.loginserver.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuren
 */
@Configuration
public class CuratorConfiguration {
    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework(ZKConfig zkConfig) {
        return CuratorFrameworkFactory.builder()
            .connectString(zkConfig.getConnectString())
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .connectionTimeoutMs(zkConfig.getConnectionTimeoutMs())
            .sessionTimeoutMs(zkConfig.getSessionTimeoutMs())
            .namespace(zkConfig.getNamespace())
            .build();
    }
}
