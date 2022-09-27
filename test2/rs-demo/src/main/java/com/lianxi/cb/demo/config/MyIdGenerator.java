package com.lianxi.cb.demo.config;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * @Description:
 * @Author：Biao丶
 * @Date：2022/9/26 16:37
 */
public class MyIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return  UUID.randomUUID().toString().replaceAll("-","");
    }
}
