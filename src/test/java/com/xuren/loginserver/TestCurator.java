package com.xuren.loginserver;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author xuren
 */
public class TestCurator {
    public static void main(String[] args) throws Exception {
        CuratorFramework client = getClient();
        client.start();
    }

    private static CuratorFramework getClient() {
        return CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000, 3)).connectionTimeoutMs(15 * 1000)
            .sessionTimeoutMs(60 * 1000)
            .namespace("game")
            .build();
    }
}
