package com.lianxi.cb.demo.service.impl;

import com.lianxi.cb.db.mongodbdao.DemoMongoDBDao;
import com.lianxi.cb.db.mongomodel.DemoMongoDB;
import com.lianxi.cb.db.mysqldao.DemoMysqlDao;
import com.lianxi.cb.db.mysqlmodel.DemoMysql;
import com.lianxi.cb.db.mysqlmodel.QDemoMysql;
import com.lianxi.cb.demo.service.DemoService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


/**
 * 作者：Biao丶
 * 时间：2022/9/8 20:06
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    DemoMongoDBDao testMongoDBDao;
    @Autowired
    DemoMysqlDao demoMysqlDao;

    @Override
    public DemoMysql showMysqlTest(String id) {
//        QDemoMysql demoMysql1 = QDemoMysql.demoMysql;
        demoMysqlDao.save(new DemoMysql(UUID.randomUUID().toString().replace("-",""),"15972000596","2472985360@qq.com"));
        demoMysqlDao.save(new DemoMysql(null,"15972000597","2472985360@qq.com"));
        demoMysqlDao.save(new DemoMysql(null,"15972000598","2472985360@qq.com"));
//        List<CheckGroupInfo> fetch = demoMysqlDao.(qCheckGroupInfo)
//                .where(qCheckGroupInfo.userId.eq(userId)
//                        .and(qCheckGroupInfo.delStatusEnum.eq(DelStatusEnum.normal)))
//                .fetch();
        DemoMysql demoMysql = demoMysqlDao.findById(id).orElse(null);
        List<DemoMysql> demoMysqls = demoMysqlDao.queryDemoMysql(id);
//        DemoMysql demoMysql2 = new DemoMysql();
//        Predicate predicate = demoMysqlDao.findById("dave")
//                .and(user.lastname.startsWith("mathews"));
//
//        userRepository.findAll(predicate);
        return demoMysql;
    }

    @Override
    public DemoMongoDB showMongoTest(String id) {
        if (id !=null) {
            DemoMongoDB testMongo = new DemoMongoDB();
            testMongo.setPhone("15972000596");
            testMongo.setCustId("165494949999");
            testMongo.setIdNumber("420115199701090945");
            testMongoDBDao.save(testMongo);
            DemoMongoDB demoMongoDB = testMongoDBDao.findById(id).orElse(null);
            return demoMongoDB;
        } else {
//            DemoMongoDB demoMongoDB = testMongoDBDao.findById(id).orElse(null);
            DemoMongoDB testMongo = new DemoMongoDB();
            testMongo.setPhone("15972000596");
            testMongo.setCustId("165494949999");
            testMongo.setIdNumber("420115199701090945");
            testMongoDBDao.save(testMongo);
            Query query = new Query();
            Criteria criteria = Criteria.where("_id").exists(true);
            criteria = criteria.and("idNumber").is("420115199701090945");
            query.addCriteria(criteria);
            List<DemoMongoDB> demoMongoDBS = mongoTemplate.find(query, DemoMongoDB.class);
            return demoMongoDBS.get(0);
        }
    }
}
