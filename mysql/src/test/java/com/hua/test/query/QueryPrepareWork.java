/**
 * 描述: 
 * QueryPrepareWork.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.query;

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

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hua.ApplicationStarter;
import com.hua.constant.TableEnum;
import com.hua.entity.QueryExample;
import com.hua.mapper.auto.QueryExampleMapper;
import com.hua.test.BaseTest;
import com.hua.util.EmptyUtil;
import com.hua.util.RandomUtil;

import tk.mybatis.mapper.util.StringUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * QueryPrepareWork
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
public final class QueryPrepareWork extends BaseTest {

	
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
	@Resource
	private QueryExampleMapper queryExampleMapper;
	
	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * SpringJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	
	private String randomChars = "K02KS0OPI92IKSD923JSDKS023K";
	
	private String randomVarchars = "WKJSDKLJ023kja03k230sdjkfj";
	
	private String[] enums = {"spring", "summer", "autumn", "winter"};
	
	
	
	/**
	 * 
	 * 描述: 准备工作，批量录入数据，多个表
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void multipleTable() {
		try {
			// 使用自动提交事务
			/*
			 * 多少条记录，执行一次statement
			 * 注意，不能累积太多，该值乘以线程数，数据占据的内存可能导致内存溢出
			 */
			AtomicInteger counter = new AtomicInteger(0);
			int executeEach = 5000;
			/* 多线程执行，当前配置6核，创建和当前核数相同的线程 或者超过核数一定系数的线程 */
			//final TableEnum[] tables = TableEnum.values();
			TableEnum[] tables = {TableEnum.MILLION_4_IDX};
			int threadCount = tables.length;
			for (int i = 0; i < threadCount; i++) {
				final int total = tables[i].getRecord();
				final String tableName = tables[i].getTableName();
				new Thread(() -> batch(total, executeEach, counter, tableName), "工作线程-" + i).start();
			}
			// 避免主线程提前结束
			while (true) {
				TimeUnit.SECONDS.sleep(10);
				if (counter.get() >= threadCount) {
					break;
				}
			}
		} catch (Exception e) {
			log.error("multipleTable =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 准备工作，批量录入数据，多个表
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void multipleTable2() {
		try {
			// 使用自动提交事务
			/*
			 * 多少条记录，执行一次statement
			 * 注意，不能累积太多，该值乘以线程数，数据占据的内存可能导致内存溢出
			 */
			AtomicInteger counter = new AtomicInteger(0);
			int executeEach = 5000;
			/* 多线程执行，当前配置6核，创建和当前核数相同的线程 或者超过核数一定系数的线程 */
			//final TableEnum[] tables = TableEnum.values();
			TableEnum[] tables = {TableEnum.MILLION_4_IDX};
			TableEnum table = TableEnum.MILLION_10_IDX;
			//int threadCount = tables.length;
			
			int threadCount = 8;
			// 每个线程要完成的记录数
			int eatchCount = table.getRecord() / threadCount;
			for (int i = 0; i < threadCount; i++) {
				new Thread(() -> batch(eatchCount, executeEach, counter, table.getTableName()), "工作线程-" + i).start();
			}
			// 避免主线程提前结束
			while (true) {
				TimeUnit.SECONDS.sleep(1000);
				if (counter.get() >= threadCount) {
					break;
				}
			}
		} catch (Exception e) {
			log.error("multipleTable2 =====> ", e);
		}
	}
	
	/**
	 * 描述: 准备工作，批量录入数据
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void singleTable() {
		try {
			// 使用自动提交事务
			/*
			 * 多少条记录，执行一次statement
			 * 注意，不能累积太多，该值乘以线程数，数据占据的内存可能导致内存溢出
			 */
			AtomicInteger value = new AtomicInteger(0);
			int executeEach = 5000;
			// 一百万
			int total = 1000000;
			//total = 1000;
			// 44154，从耗时上看，多线程比单线程的快了2.2倍
			/* 多线程执行，当前配置6核，创建和当前核数相同的线程 或者超过核数一定系数的线程 */
			int threadCount = 8;
			// 每个线程要完成的记录数
			int eatchCount = total / threadCount;
			for (int i = 0; i < threadCount; i++) {
				new Thread(() -> batch(eatchCount, executeEach, value, null), "工作线程-" + i).start();
			}
			// 避免主线程提前结束
			while (true) {
				TimeUnit.SECONDS.sleep(1);
				if (value.get() >= threadCount) {
					break;
				}
			}
		} catch (Exception e) {
			log.error("singleTable =====> ", e);
		}
	}

	/**
	 * 
	 * @description 
	 * @param total 总记录数
	 * @param executeEach  多少条记录，执行一次statement
	 * @author qianye.zheng
	 */
	private void batch(final int total, final int executeEach, final AtomicInteger value, final String tableName) {
		// 一百万
		QueryExample entity = null;
		List<QueryExample> entities = new ArrayList<>();
		int count = 0;
		int currentCount = 0;
		do {
			entity = new QueryExample();
			if (StringUtil.isNotEmpty(tableName)) {
				entity.setTableName(tableName);
			}
			entity.setCharType(RandomUtil.random(4, randomChars));
			entity.setVarcharType(RandomUtil.random(RandomUtil.nextInt(8) + 1, randomVarchars));
			//entity.setDecimalType(BigDecimal.valueOf(RandomUtils.nextDouble(Float.MIN_VALUE, Float.MAX_VALUE)));
			entity.setDecimalType(BigDecimal.valueOf(RandomUtils.nextDouble(0.00, 9999.99)));
			//entity.setIntType(RandomUtil.nextInt(Integer.MAX_VALUE));
			entity.setIntType(RandomUtil.nextInt(100000));
			entity.setEnumType(enums[RandomUtil.nextInt(enums.length)]);
			entity.setBitType(RandomUtils.nextBoolean());
			// 相差24 小时
			entity.setTimestampType(LocalDateTime.now().minusSeconds(RandomUtil.nextInt(24 * 3600) + 1));
			entities.add(entity);
			currentCount++;
			count++;
			if (currentCount >= executeEach) { // 执行statement
				Instant start = Instant.now();
				//System.out.println("线程: " + Thread.currentThread().getName() + "，提交: " + executeEach + ", ts = " + Instant.now().toEpochMilli());
				// 使用自动提交
				queryExampleMapper.insertList(entities);
				final Instant end = Instant.now();
				System.out.println("线程: " + Thread.currentThread().getName() + "，执行结束，耗时(毫秒): " + Duration.between(start, end).toMillis());
				// 开始下一轮提交
				entities.clear();
				entities = new ArrayList<>();
				currentCount = 0;
			}
		} while (count < total);
		// 执行剩余的
		if (EmptyUtil.isNotEmpty(entities)) {
			queryExampleMapper.insertList(entities);
		}
		value.incrementAndGet();
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testInsert() {
		try {
			QueryExample entity = null;
			entity = new QueryExample();
			entity.setCharType(RandomUtil.random(4, randomChars));
			entity.setVarcharType(RandomUtil.random(RandomUtil.nextInt(8) + 1, randomVarchars));
			entity.setDecimalType(BigDecimal.valueOf(RandomUtils.nextDouble(0.00, 9999.99)));
			entity.setIntType(RandomUtil.nextInt(Integer.MAX_VALUE));
			entity.setEnumType(enums[RandomUtil.nextInt(enums.length)]);
			entity.setBitType(RandomUtils.nextBoolean());
			// 相差24 小时
			entity.setTimestampType(LocalDateTime.now().minusSeconds(RandomUtil.nextInt(24 * 3600) + 1));
			// 使用自动提交
			queryExampleMapper.insert(entity);
		} catch (Exception e) {
			log.error("testInsert =====> ", e);
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
