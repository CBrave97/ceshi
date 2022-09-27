package com.lianxi.cb.db.mongomodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 作者：Biao丶
 * 时间：2022/9/9 17:12
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("testMongoDB")
public class DemoMongoDB {
    @Id
    private String id;
    /**
     * 手机号
     */
    @Indexed
    private String phone;
    /**
     * 手机号(密文)
     */
    @Indexed
    private String custId;
    /**
     * 微信openId (有可能没有)
     */
    @Indexed
    private String openId;
    /**
     * 身份证
     */
    @Indexed
    private String idNumber;
}
