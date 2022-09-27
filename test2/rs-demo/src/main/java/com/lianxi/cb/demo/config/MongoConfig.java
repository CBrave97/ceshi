package com.lianxi.cb.demo.config;

import com.lianxi.cb.demo.conver.BigDecimalToDecimal128Converter;
import com.lianxi.cb.demo.conver.Decimal128ToBigDecimalConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chain
 * create by chain on 2019-02-26 14:45
 **/
@Configuration
public class MongoConfig {
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        List<Object> converters = new ArrayList<>();
        converters.add(new BigDecimalToDecimal128Converter());
        converters.add(new Decimal128ToBigDecimalConverter());
        return new MongoCustomConversions(converters);
    }
}
