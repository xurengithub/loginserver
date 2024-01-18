package com.xuren.loginserver.cache;

/**
 * @author xuren
 */
public enum NodeBusyStatusEnum {
    GOOD(0),
    BUSY(1),
    CROWDED(2),
    FULL(3)
    ;

    NodeBusyStatusEnum(int code) {
        this.code = code;
    }

    private int code;
}
