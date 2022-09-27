package com.lianxi.cb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * author：Biao丶
 * data：2022/9/16 11:25
 */
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com"})
@EnableMongoRepositories(basePackages ={"com.lianxi.cb.db"})
@EnableMongoAuditing
//@ConfigurationPropertiesScan("com")
public class Test2Application {
    public static void main(String[] args) {
        SpringApplication.run(Test2Application.class,args);
    }
}
