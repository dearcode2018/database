/**
 * 描述: 
 * User.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Data;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * User
 */
// @TypeAlias 别名，可以对应库中的_class 字段，可以实现新老class的映射
// ID相同的，别名不同，别名也会被更新到数据库
@TypeAlias("com.share.entity.User")
@Document("t_user")
@Data
public final class User {

    /* 对象唯一id */
	@Id
	/* id自动生成 不能使用@Field标注别名，会导致根据id无法查询 */
	@Field("id")
	private String oid;
	
	/* 登录-用户名 (唯一) */
	@Field("name")
	private String username;
	
	/* 昵称 (用于显示) */
	@Field("nick_name")
	private String nickname;
	
	/* 登录-密码 */
	private String password;
	
	/* 用户状态 - 是否有效 默认 : 有效 */
	@Field(targetType = FieldType.BOOLEAN)
	private Boolean valid;
	
	/* 上一次登录-时间 */
	@Field("last_login_time")
	private LocalDateTime lastLoginTime;
	
	/* 上一次登录-IP地址 */
	private String lastLoginIp;
	
}
