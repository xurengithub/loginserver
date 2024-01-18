package com.xuren.loginserver.cache;

/**
 * @author xuren
 */
public enum NodeMaintainStatusEnum {
    NORMAL(0),
    MAINTAIN(1),
    ;

    NodeMaintainStatusEnum(int code) {
        this.code = code;
    }

    private int code;
}
