/**
 * 描述: 
 * MongoDbSpringTest2.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.mongo;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hua.entity.User;
import com.hua.test.BaseTest;
import com.hua.util.JacksonUtil;
import com.mongodb.WriteResult;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * MongoDbSpringTest2
 */
/*
 * 
 * @SpringJUnit4ClassRunner 运行器负责拉起 spring 环境
 * @ContextConfiguration 指定 spring配置文件，若不指定，则使用默认配置.
 */
// for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
@ContextConfiguration(locations = {"classpath:conf/xml/mongodb-spring2.xml", "classpath:conf/xml/spring-config.xml"})
public final class MongoDbSpringTest2 extends BaseTest {

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
			mongoTemplate.save(user, "collection1");
			//mongoTemplate.createCollection("collection2");
			//mongoTemplate.save(user, "collection1");
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
			WriteResult writeResult = mongoTemplate.remove(query, User.class, "collection1");
			log.info("testDelete =====> " + writeResult.getN());
			
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
			WriteResult writeResult = mongoTemplate.updateFirst(query, update, User.class, "collection1");
			
			log.info("testUpdate =====> " + writeResult.getN());
			
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
			User user = mongoTemplate.findOne(query, User.class, "collection1");
			
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
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
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
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
