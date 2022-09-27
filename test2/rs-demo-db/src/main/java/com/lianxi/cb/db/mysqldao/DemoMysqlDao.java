package com.lianxi.cb.db.mysqldao;

import com.lianxi.cb.db.mysqlmodel.DemoMysql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 作者：Biao丶
 * 时间：2022/9/8 17:07
 */
//@Repository
//@NoRepositoryBean
public interface DemoMysqlDao extends JpaRepository<DemoMysql,String> {
//public interface DemoMysqlDao extends CrudRepository<DemoMysql, String>, QuerydslPredicateExecutor<DemoMysql> {
    @Query(value = "select id, phone,email from test_sql where phone = ?1", nativeQuery = true)
    List<DemoMysql> queryDemoMysql(String phone);
}
