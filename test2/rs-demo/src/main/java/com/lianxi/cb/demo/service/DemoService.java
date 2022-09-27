package com.lianxi.cb.demo.service;

import com.lianxi.cb.db.mongomodel.DemoMongoDB;
import com.lianxi.cb.db.mysqlmodel.DemoMysql;

/**
 * 作者：Biao丶
 * 时间：2022/9/8 20:06
 */
public interface DemoService {

    DemoMysql showMysqlTest(String id);

    DemoMongoDB showMongoTest(String id);
}
