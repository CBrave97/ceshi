package com.lianxi.cb.db.mongodbdao;

import com.lianxi.cb.db.mongomodel.DemoMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 作者：Biao丶
 * 时间：2022/9/9 17:14
 */
public interface DemoMongoDBDao extends MongoRepository<DemoMongoDB,String> {
}
