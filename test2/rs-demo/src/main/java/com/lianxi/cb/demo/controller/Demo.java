package com.lianxi.cb.demo.controller;

import com.lianxi.cb.db.mongomodel.DemoMongoDB;
import com.lianxi.cb.db.mysqlmodel.DemoMysql;
import com.lianxi.cb.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：Biao丶
 * 时间：2022/9/8 17:01
 */
@RestController
@RequestMapping(value = "/demo/test")
public class Demo {

 @Autowired
 DemoService demoService;
// @Autowired
// DemoMysqlDao testMysqlS;

 @RequestMapping(value = "/selectMysql")
 @GetMapping
 public DemoMysql selectMysql (@RequestParam(value = "id",required = false) String id) {

  DemoMysql test = demoService.showMysqlTest(id);

  return test;

 }

 @RequestMapping(value = "/selectMongo")
 @GetMapping
 public DemoMongoDB selectMongo (@RequestParam(value = "id",required = false) String id) {

  DemoMongoDB demoMongoDB = demoService.showMongoTest(id);

return demoMongoDB;

 }

}