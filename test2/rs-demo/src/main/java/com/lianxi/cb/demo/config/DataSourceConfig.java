package com.lianxi.cb.demo.config;

import com.lianxi.cb.demo.constant.FxgjdbConstant;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.Map;

/**
 * The type User data source config.
 *
 * @author chain  create by xiongjj on 2018 /4/28 下午4:02
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = FxgjdbConstant.ENTITY_MANAGER_FACTORY_REF,
        transactionManagerRef = FxgjdbConstant.TRANSACTION_MANAGER_REF,
//        repositoryFactoryBeanClass = RepositoryFactoryBean.class,
        basePackages = {FxgjdbConstant.DAO_PAGES})
public class DataSourceConfig {

    private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);
    @Resource
    private JpaProperties jpaProperties;

    /**
     * Primary data source data source.
     *
     * @return the data source
     */
    @Bean(name = FxgjdbConstant.DATA_SOURCE_NAME)
    @Primary
    @ConfigurationProperties(prefix = FxgjdbConstant.DATA_SOURCE_PROPERTIES)
    public HikariDataSource primaryDataSource() {
        log.info(" dataSource {} 加载完成", FxgjdbConstant.DATA_SOURCE_NAME);
        return new HikariDataSource();
    }

    @Primary
    @Bean(name = FxgjdbConstant.ENTITY_MANAGER_REF)
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactory(builder).getObject().createEntityManager();
    }


    private Map<String, String> getVendorProperties() {
        return jpaProperties.getProperties();
    }

    /**
     * 设置实体类所在位置
     */
    @Primary
    @Bean(name = FxgjdbConstant.ENTITY_MANAGER_FACTORY_REF)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(primaryDataSource())
                .packages(FxgjdbConstant.ENTITY_PAGES)
                .persistenceUnit(FxgjdbConstant.PERSISTENCE_UNIT)
                .properties(getVendorProperties())
                .build();
    }

    @Primary
    @Bean(name = FxgjdbConstant.TRANSACTION_MANAGER_REF)
    public PlatformTransactionManager transactionManagerFoo(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

    @Bean(name = FxgjdbConstant.JDBC_TEMPLATE_REF)
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(primaryDataSource());
    }
}
