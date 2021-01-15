/**
 * 描述: 
 * MogonDBSpringBootTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.mongo;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import javax.annotation.Resource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hua.ApplicationStarter;
import com.hua.entity.User;
import com.hua.test.BaseTest;
import com.hua.util.JacksonUtil;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * MogonDBSpringBootTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
// for Junit 5.x
@ExtendWith(SpringExtension.class)
//@WebAppConfiguration(value = "src/main/webapp")
@SpringBootTest(classes = {ApplicationStarter.class}, 
webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@MapperScan(basePackages = {"com.hua.mapper"})
public final class MogonDBSpringBootTest extends BaseTest {

	
	/*
	配置方式1: 
	@WebAppConfiguration(value = "src/main/webapp")  
	@ContextConfiguration(locations = {
			"classpath:conf/xml/spring-bean.xml", 
			"classpath:conf/xml/spring-config.xml", 
			"classpath:conf/xml/spring-mvc.xml", 
			"classpath:conf/xml/spring-service.xml"
		})
	@ExtendWith(SpringExtension.class)
	
	配置方式2: 	
	@WebAppConfiguration(value = "src/main/webapp")  
	@ContextHierarchy({  
		 @ContextConfiguration(name = "parent", locations = "classpath:spring-config.xml"),  
		 @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")  
		}) 
	@ExtendWith(SpringExtension.class)
	 */
	
	/**
	 * 而启动spring 及其mvc环境，然后通过注入方式，可以走完 spring mvc 完整的流程.
	 * 
	 */
	//@Resource
	//private UserController userController;
	
	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * SpringJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	
    @Resource
    private MongoTemplate mongoTemplate;
    
    // 数据表名  (对应 mongodb 中的 collection)
    private String tableName = "t_user";
    
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    //@DisplayName("test")
    @Test
    public void testMogonDB() {
        try {
            
            
        } catch (Exception e) {
            log.error("test =====> ", e);
        }
    }	
    
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    @Test
    public void testMongoTemplate() {
        try {
            User user = new User();
            user.setUsername("zhangping");
            user.setPassword("123456");
            user.setValid(true);
            //mongoTemplate.save(user);
            
            Query query = new Query();
            long count = mongoTemplate.count(query, "Student");
            System.out.println(count);
        } catch (Exception e) {
            log.error("testMongoTemplate =====> ", e);
        }
    }
	
    /**
     * 数据库、集合不存在，均会自动创建，不用提前创建.
     * 
     * 
     */
    
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    @Test
    public void testSave() {
        try {
            /*
             * id重复不会再插进去
             */
            User user = new User();
            //user.setOid("2232324");
            user.setUsername("zhangping2");
            user.setPassword("123456");
            user.setValid(true);
            // 指定存放的集合
            mongoTemplate.save(user, tableName);
            //mongoTemplate.createCollection("collection2");
            //mongoTemplate.save(user, tableName);
        } catch (Exception e) {
            log.error("testSave =====> ", e);
        }
    }
    
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    @Test
    public void testCreateCollection() {
        try {
            mongoTemplate.createCollection("collection2");
            } catch (Exception e) {
            log.error("testCreateCollection =====> ", e);
        }
    }
    
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    @Test
    public void testDelete() {
        try {
            Query query = new Query(Criteria.where("oid").is("ssdfsdf225"));
            /*
             * 要指定实体，否则无法使用 主键字段，因为主键字段是标注在实体中
             */
            // 移除指定集合中符合条件的数据
            DeleteResult writeResult = mongoTemplate.remove(query, User.class, tableName);
            log.info("testDelete =====> " + writeResult.getDeletedCount());
            
        } catch (Exception e) {
            log.error("testDelete =====> ", e);
        }
    }
    
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    @Test
    public void testUpdate() {
        try {
            Query query = new Query(Criteria.where("oid").is("12121212"));
            // 更新指定集合中符合条件的数据，更新第一条
            Update update = new Update();
            update.set("username", "lisi");
            UpdateResult writeResult = mongoTemplate.updateFirst(query, update, User.class, tableName);
            log.info("testUpdate =====> " + writeResult.getModifiedCount());
            
        } catch (Exception e) {
            log.error("testUpdate =====> ", e);
        }
    }
    
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    @Test
    public void testQuery() {
        try {
            /*
             * _id 或 @Id注解标注字段
             */
            //Query query = new Query(Criteria.where("_id").is("12121212"));
            Query query = new Query(Criteria.where("oid").is("12121212"));
            User user = mongoTemplate.findOne(query, User.class, tableName);
            
            System.out.println(JacksonUtil.writeAsString(user));
            
        } catch (Exception e) {
            log.error("testQuery =====> ", e);
        }
    }
    
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    @Test
    public void testSpringJunit() {
        try {
            User user = new User();
            user.setUsername("zhangping");
            user.setPassword("123456");
            user.setValid(true);
            mongoTemplate.save(user);
            
        } catch (Exception e) {
            log.error("testSpringJunit =====> ", e);
        }
    }
    
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testTemp")
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testCommon")
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testSimple")
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
		dynamicTest(null, null);
		
	}

}
