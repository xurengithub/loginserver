package com.xuren.loginserver.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    public static final Logger data = LoggerFactory.getLogger(Data.class);
    public static final Logger db = LoggerFactory.getLogger(Db.class);
    public static final Logger system = LoggerFactory.getLogger(System.class);
    private static class Data {

    }

    /**
     * 数据库日志
     */
    private static class Db {

    }

    private static class System {

    }


}
