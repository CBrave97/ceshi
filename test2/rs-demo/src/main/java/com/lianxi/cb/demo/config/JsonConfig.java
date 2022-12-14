//package com.lianxi.cb.demo.config;
//
//import chain.fxgj.ent.core.constant.DateFormatConstants;
//import chain.utils.commons.JacksonUtil;
//import chain.utils.commons.json.*;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.bson.types.Decimal128;
//import org.bson.types.ObjectId;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//
///**
// * @author chain
// * create by chain on 2018/10/19 下午12:11
// **/
//@Configuration
//@SuppressWarnings("unchecked")
//public class JsonConfig {
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        objectMapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        //美化json字符串打印输出
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        //objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//
//        JavaTimeModule javaTimeModule = new JavaTimeModule();
//        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
//        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
//        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(
//                DateFormatConstants.TIME_FORMATTER));
//        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
//        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
//        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(
//                DateFormatConstants.TIME_FORMATTER));
//        objectMapper.registerModule(javaTimeModule);
//
//        SimpleModule objectIdmodule = new SimpleModule("objectIdmodule");
//        objectIdmodule.addSerializer(ObjectId.class, new ObjectIdSerializer());
//        objectIdmodule.addDeserializer(ObjectId.class, new ObjectIdDeserializer());
//        objectIdmodule.addSerializer(Decimal128.class, new DecimalSerializer());
//        objectIdmodule.addDeserializer(Decimal128.class, new DecimalDeserializer());
//        objectMapper.registerModule(objectIdmodule);
//
//        JacksonUtil.setObjectMapper(objectMapper);
//        return objectMapper;
//    }
//}
