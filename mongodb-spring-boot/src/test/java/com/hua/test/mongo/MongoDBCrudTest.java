/**
 * 描述: 
 * MongoDBCrudTest.java
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

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Field;
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
 * MongoDBCrudTest
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
public final class MongoDBCrudTest extends BaseTest {

	
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
	
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    @Test
    public void testInsert() {
        try {
            /* id重复不会再插进去*/
            User user = new User();
            // 不指定id则自动生成
            user.setOid(RandomStringUtils.randomAlphabetic(10));
            user.setUsername("zhangping244");
            user.setPassword("123456");
            user.setValid(true);
            user.setLastLoginTime(LocalDateTime.now());
            mongoTemplate.save(user);
            // 指定存放的集合
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
    public void testInsertAutoId() {
        try {
            /* id重复不会再插进去*/
            User user = new User();
            // 不指定id则自动生成
            //user.setOid(RandomStringUtils.randomAlphabetic(10));
            user.setUsername("zhangping244");
            user.setPassword("123456");
            user.setValid(true);
            user.setLastLoginTime(LocalDateTime.now());
            mongoTemplate.save(user);
            System.out.println("id: " + user.getOid());
            // 指定存放的集合
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
    public void testDelete() {
        try {
            /*
             * 填写Entity的字段名称
             * 注意，若是自动生成的id，则无法通过字段名来查询
             */
            Query query = Query.query(Criteria.where("oid").is("QzVUlcJQOo"));
            /*
             * 要指定实体，否则无法使用 主键字段，因为主键字段是标注在实体中
             */
            // 移除指定集合中符合条件的数据
            DeleteResult writeResult = mongoTemplate.remove(query, User.class);
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
    public void testDeleteById() {
        try {
            /*
             * 要指定实体，否则无法使用 主键字段，因为主键字段是标注在实体中
             */
            // 移除指定集合中符合条件的数据
            User user = new User();
            user.setOid("123456");
            DeleteResult writeResult = mongoTemplate.remove(user);
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
            User user = new User();
            user.setOid("tpaHrezzMO");
            user.setUsername("张萍22d");
            user.setPassword("123456");
            user.setValid(true);
            user.setLastLoginTime(LocalDateTime.now());
            
            // 设置了ID，调用save会update相应的记录
            mongoTemplate.save(user);
            // 指定存放的集合
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
    public void testUpdateByCondition() {
        try {
            Query query = Query.query(Criteria.where("oid").is("tpaHrezzMO"));
            // 更新指定集合中符合条件的数据，更新第一条
            Update update = new Update();
            update.set("username", "lisi");
            UpdateResult writeResult = mongoTemplate.updateFirst(query, update, User.class);
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
    public void testFindOne() {
        try {
            /*
             * _id 或 @Id注解标注字段
             */
            //Query query = Query.query(Criteria.where("_id").is("12121212"));
            String id = "tpaHrezzMO";
            /*
             * 自动生成的id，无法根据id查询出来
             * 解决方法: id 字段不能用@Field标注别名
             */
            //id = "6002c1baa4ad841c041586c4";
            Query query = Query.query(Criteria.where("oid").is(id));
            User user = mongoTemplate.findOne(query, User.class);
            
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
    public void testFindById() {
        try {
            /*
             * _id 或 @Id注解标注字段
             */
            //Query query = Query.query(Criteria.where("_id").is("12121212"));
            String id = "tpaHrezzMO";
            /*
             * 自动生成的id，无法根据id查询出来
             * 解决方法: id 字段不能用@Field标注别名
             * 如果非要用别名的话，只能自主生成id
             */
            //id = "6002c1baa4ad841c041586c4";
            User user = mongoTemplate.findById(id, User.class);
            
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
    public void testFindSelectProperty() {
        try {
            /*
             * _id 或 @Id注解标注字段
             */
            //Query query = Query.query(Criteria.where("_id").is("12121212"));
            String id = "tpaHrezzMO";
            /*
             * 自动生成的id，无法根据id查询出来
             * 解决方法: id 字段不能用@Field标注别名
             * 如果非要用别名的话，只能自主生成id
             */
            //id = "6002c1baa4ad841c041586c4";
            Query query = Query.query(Criteria.where("oid").is(id));
            Field field = query.fields();
            // 指定字段、或排除字段，指定、排除二选一
            field.include("oid").include("username");
            //field.exclude("password");
            User user = mongoTemplate.findOne(query, User.class);
            
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
    public void testPage() {
        try {
            /*
             * _id 或 @Id注解标注字段
             */
            //Query query = Query.query(Criteria.where("_id").is("12121212"));
            /*
             * 自动生成的id，无法根据id查询出来
             * 解决方法: id 字段不能用@Field标注别名
             * 如果非要用别名的话，只能自主生成id
             */
            int currentPage = 1;
            int pageSize = 2;
            Query query = Query.query(Criteria.where("username").is("zhangping244"));
            // 排序
            Sort.Order order = Sort.Order.asc("oid");
            Sort sort = Sort.by(order);
            // PageRequest 的currentPage是从0开始的
            PageRequest pageRequest = PageRequest.of(currentPage - 1, pageSize, sort);
            query.with(pageRequest);
            List<User> list = mongoTemplate.find(query, User.class);
            
            list.forEach(user ->  System.out.println(user.getOid()));
            
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
    public void testPage2() {
        try {
            /*
             * _id 或 @Id注解标注字段
             */
            //Query query = Query.query(Criteria.where("_id").is("12121212"));
            /*
             * 自动生成的id，无法根据id查询出来
             * 解决方法: id 字段不能用@Field标注别名
             * 如果非要用别名的话，只能自主生成id
             */
            int currentPage = 2;
            int pageSize = 2;
            int startOffset = (currentPage - 1) * pageSize;
            Query query = Query.query(Criteria.where("username").is("zhangping244"));
            query.skip(startOffset);
            query.limit(pageSize);
            List<User> list = mongoTemplate.find(query, User.class);
            
            list.forEach(user ->  System.out.println(user.getOid()));
            
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
