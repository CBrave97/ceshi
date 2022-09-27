package com.lianxi.cb.db.mysqlmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 作者：Biao丶
 * 时间：2022/9/8 17:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test_sql")
@Entity
public class DemoMysql {

    @Id
    @Column(name = "id", columnDefinition = "varchar(32) COMMENT '主键，自动生成'")
//    @GenericGenerator(name = "id", strategy = "com.lianxi.cb.db.MyIdGenerator")
    @GeneratedValue(generator = "id")
//    @Id
//    @Column(name = "id", length = 32)
    @GenericGenerator(name = "id", strategy = "uuid")
//    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Basic
    @Column(name ="phone",columnDefinition = "varchar(11) COMMENT '手机号'")
    private String phone;

    @Basic
    @Column(name = "email", columnDefinition = "varchar(50) COMMENT '邮箱'")
    private String email;
}
