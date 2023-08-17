package com.xuren.loginserver.config.zk;

import com.xuren.loginserver.consts.ZkConsts;
import com.xuren.loginserver.utils.ZKUtils;
import jakarta.annotation.Resource;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * @author xuren
 */
@Component
public class InitZkNode implements InitializingBean {
    @Resource
    private CuratorFramework curatorFramework;

    @Override
    public void afterPropertiesSet() throws Exception {
        String ip = InetAddress.getLocalHost().getHostAddress();
        if (curatorFramework.checkExists().forPath("/" + ZkConsts.NODE_PATH) == null) {
            ZKUtils.create(curatorFramework, "/" + ZkConsts.NODE_PATH, "".getBytes());
        }
        ZKUtils.createEphemeral(curatorFramework, "/" + ZkConsts.NODE_PATH + "/" + ip, "".getBytes());
    }
}
