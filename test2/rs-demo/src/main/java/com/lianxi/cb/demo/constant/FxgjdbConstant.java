package com.lianxi.cb.demo.constant;

import java.time.format.DateTimeFormatter;

/**
 * The type Base constant.
 *
 * @author chain
 * create by xiongjj on 2018 /5/3 下午7:23
 */
public class FxgjdbConstant {
    /**
     * The constant ENTITY_PAGES.
     */
    public final static String ENTITY_PAGES = "com.lianxi.cb.db.mysqlmodel";
    /**
     * The constant DAO_PAGES.
     */
    public final static String DAO_PAGES = "com.lianxi.cb.db.mysqldao";
    /**
     * The constant PREFIX.
     */
    public final static String PREFIX = "test2";
    /**
     * The constant DATA_SOURCE_PROPERTIES.
     */
    public final static String DATA_SOURCE_PROPERTIES = PREFIX + ".datasource";

    /**
     * The constant PERSISTENCE_UNIT.
     */
    public final static String PERSISTENCE_UNIT = "PersistenceUnit";

    /**
     * The constant DATA_SOURCE_NAME.
     */
    public final static String DATA_SOURCE_NAME ="DataSource";
    /**
     * The constant ENTITY_MANAGER_FACTORY_REF.
     */
    public final static String ENTITY_MANAGER_FACTORY_REF ="EntityManagerFactory";
    /**
     * The constant ENTITY_MANAGER
     */
    public final static String ENTITY_MANAGER_REF = "EntityManager";
    /**
     * The constant TRANSACTION_MANAGER_REF.
     */
    public final static String TRANSACTION_MANAGER_REF = "TransactionManager";
    /**
     * The constant JDBC_TEMPLATE_REF.
     */
    public final static String JDBC_TEMPLATE_REF = "JdbcTemplate";

    public final static String DATE_TIME_FORMAT = "yyyyMMddHHmmss";
    public final static String DATE_TIME_FORMAT2 = "yyyy-MM-dd HH:mm:ss";
    public final static String DEFAULT_DATE_FORMAT = "yyyyMMdd";

    public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    public final static DateTimeFormatter DATE_TIME_FORMATTER2 = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT2);
    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
    /**
     * 日志
     */
    public final static String LOG_TOKEN = "log_token";
    /**
     * 报文头
     */
    public final static String LOGTOKEN = "logToken";

}
