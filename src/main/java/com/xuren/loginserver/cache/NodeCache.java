package com.xuren.loginserver.cache;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.xuren.loginserver.ServerType;
import com.xuren.loginserver.cache.Node;
import com.xuren.loginserver.config.BootConfig;
import com.xuren.loginserver.config.RpcConfig;
import com.xuren.loginserver.consts.ZkConsts;
import com.xuren.loginserver.utils.ZKUtils;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xuren
 */
@Component
public class NodeCache implements InitializingBean {
    @Resource
    private CuratorFramework curatorFramework;
    @Resource
    private RpcConfig rpcConfig;
    @Resource
    private BootConfig bootConfig;

    private final Map<String, Node> nodeCache = Maps.newConcurrentMap();

    @Override
    public void afterPropertiesSet() throws Exception {
//        var cache = new PathChildrenCache(curatorFramework, ZkConsts.NODE_PATH, true);
//        cache.getListenable().addListener((curatorFramework, pathChildrenCacheEvent) -> {
//            var eventType = pathChildrenCacheEvent.getType();
//            if (eventType != PathChildrenCacheEvent.Type.CHILD_ADDED || eventType != PathChildrenCacheEvent.Type.CHILD_UPDATED || eventType != PathChildrenCacheEvent.Type.CHILD_REMOVED) {
//                return;
//            }
//            var data = pathChildrenCacheEvent.getData();
//            var path = data.getPath();
//            var dataBytes = data.getData();
//            if (StringUtils.startsWith(path, ZkConsts.NODE_PATH)) {
//                switch (eventType) {
//                    case CHILD_ADDED:
//                    case CHILD_UPDATED:
//                        nodeCache.put(path, JSON.parseObject(dataBytes, Node.class));
//                        break;
//                    case CHILD_REMOVED:
//                        nodeCache.remove(path);
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });
//        cache.start();
//
//
//        String ip = InetAddress.getLocalHost().getHostAddress();
//        var path = ip + "_" + "GLOBAL" + "_" + 0;
//        Node node = new Node();
//        node.setIp(ip);
//        node.setServerId(path);
//        node.setType("GLOBAL");
//        node.setRpcPort(rpcConfig.getPort());
//        node.setRestPort(bootConfig.getPort());
////        if (curatorFramework.checkExists().forPath(ZkConsts.NODE_PATH) == null) {
////            ZKUtils.create(curatorFramework, ZkConsts.NODE_PATH, "".getBytes());
////        }
//        ZKUtils.createEphemeral(curatorFramework, ZkConsts.NODE_PATH + "/" + path, JSON.toJSONString(node).getBytes());
    }

    public List<Node> globals() {
        return nodes(ServerType.GLOBAL);
    }

    public List<Node> gameServers() {
        return nodes(ServerType.GAME_SERVER);
    }

    public List<Node> nodes(ServerType serverType) {
        return nodeCache.values().stream().filter(node -> node.getType().equals(serverType.name())).collect(Collectors.toList());
    }
}
