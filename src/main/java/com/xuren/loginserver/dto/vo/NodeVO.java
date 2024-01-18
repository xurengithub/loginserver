package com.xuren.loginserver.dto.vo;

import com.xuren.loginserver.cache.NodeBusyStatusEnum;
import com.xuren.loginserver.cache.NodeMaintainStatusEnum;

/**
 * @author xuren
 */
public class NodeVO {
    private String ip;
    private int port;
    private String name;
    private String sec;
    /**
     * 状态
     */
    private NodeBusyStatusEnum busyStatus;
    private NodeMaintainStatusEnum maintainStatus;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public NodeBusyStatusEnum getBusyStatus() {
        return busyStatus;
    }

    public void setBusyStatus(NodeBusyStatusEnum busyStatus) {
        this.busyStatus = busyStatus;
    }

    public NodeMaintainStatusEnum getMaintainStatus() {
        return maintainStatus;
    }

    public void setMaintainStatus(NodeMaintainStatusEnum maintainStatus) {
        this.maintainStatus = maintainStatus;
    }

    @Override
    public String toString() {
        return "NodeVO{" +
            "ip='" + ip + '\'' +
            ", port='" + port + '\'' +
            ", name='" + name + '\'' +
            ", sec='" + sec + '\'' +
            ", busyStatus=" + busyStatus +
            ", maintainStatus=" + maintainStatus +
            '}';
    }
}
