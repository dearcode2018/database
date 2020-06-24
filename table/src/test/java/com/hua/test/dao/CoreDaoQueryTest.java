/**
 * 描述: 
 * CoreDaoQueryTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.dao;

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

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.constant.ext.Gender;
import com.hua.dao.o2o.PersonDao;
import com.hua.dao.o2o.impl.PersonDaoImpl;
import com.hua.orm.entity.o2o.Person;
import com.hua.test.BaseTest;
import com.hua.util.SqlUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * CoreDaoQueryTest
 */
public final class CoreDaoQueryTest extends BaseTest {

	private PersonDao personDao = new PersonDaoImpl();
	
	private Person person = new Person();
	
	private List<Person> persons;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQuery() {
		try {
			
			
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
	public void testSelect() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSelect =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGet() {
		try {
			oid = 10L;
			person.setOid(oid);
			sql = "SELECT a.oid, a.name, a.photoUrl, a.gender, a.nation, a.birthday, a.address FROM person a WHERE a.oid = ?";
			
			results = personDao.getSingleRow(sql, person.getOid());
			
			person.setName((String) results[1]);
			person.setPhotoUrl((String) results[2]);
			// 需要通过大数字对象来获取相应的整型值
			bigDecimal = (BigDecimal) results[3];
			person.setGender(Gender.values()[bigDecimal.intValue()]);
			person.setNation((String) results[4]);
			/*
			 oracle 中 DATE TIMESTAMP 类型均存储了日期和时间，不同的是，
			 TIMESTAMP 还存储了小数秒，精确度可控.
			 因此，jdbc返回的是java.sql.Timestamp，需要在此类型的基础上
			 进行构造.
			 因为，ResultSet 在获取值的时候，统一返回Object，因此，数据库返回
			 的是java.sql.Timestamp类型，但是可以使用ResultSet的getDate()方法来
			 获取java.sq.Date类型
			 */
			timestamp = (Timestamp) results[5];
			// 根据Timestamp 来构造 日期对象
			person.setBirthday(new java.sql.Date(timestamp.getTime()));
			person.setAddress((String) results[6]);
			
			System.out.println(person.toString());
			
		} catch (Exception e) {
			log.error("testGet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCountArrayParam() {
		try {
			sql = "SELECT COUNT(*) FROM person a WHERE a.nation IN(?,?)";
			arrayParams = new Object[] {"汉族", "回族"};
			
			count = personDao.count(sql, arrayParams);
			
			log.info("testCountArrayParam =====> count = " + count);
			
		} catch (Exception e) {
			log.error("testCountArrayParam =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCountListParam() {
		try {
			sql = "SELECT COUNT(*) FROM person a WHERE a.nation IN(?,?)";
			arrayParams = new Object[] {"汉族", "回族"};
			listParams.add("汉族");
			listParams.add("回族");
			count = personDao.count(sql, listParams);
			
			log.info("testCountListParam =====> count = " + count);
			
		} catch (Exception e) {
			log.error("testCountListParam =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSearchArrayParam() {
		try {
			arrayParams = new Object[] {"汉族", 1};
			sql = "SELECT a.oid, a.name, a.photoUrl, a.gender, a.nation, a.birthday, a.address FROM person a WHERE a.nation = ? and a.gender = ?";
			
			listResults = personDao.search(sql, arrayParams);
			for (Object[] results : listResults)
			{
				 person = new Person();
				person.setName((String) results[1]);
				person.setPhotoUrl((String) results[2]);
				// 需要通过大数字对象来获取相应的整型值
				bigDecimal = (BigDecimal) results[3];
				person.setGender(Gender.values()[bigDecimal.intValue()]);
				person.setNation((String) results[4]);
				/*
				 oracle 中 DATE TIMESTAMP 类型均存储了日期和时间，不同的是，
				 TIMESTAMP 还存储了小数秒，精确度可控.
				 因此，jdbc返回的是java.sql.Timestamp，需要在此类型的基础上
				 进行构造.
				 因为，ResultSet 在获取值的时候，统一返回Object，因此，数据库返回
				 的是java.sql.Timestamp类型，但是可以使用ResultSet的getDate()方法来
				 获取java.sq.Date类型
				 */
				timestamp = (Timestamp) results[5];
				// 根据Timestamp 来构造 日期对象
				person.setBirthday(new java.sql.Date(timestamp.getTime()));
				person.setAddress((String) results[6]);
				System.out.println(person.toString());
			}
			
		} catch (Exception e) {
			log.error("testSearchArrayParam =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSearchListParam() {
		try {
			listParams.add("汉族");
			listParams.add(2);
			
			sql = "SELECT a.oid, a.name, a.photoUrl, a.gender, a.nation, a.birthday, a.address FROM person a WHERE a.nation = ? and a.gender = ?";
			
			listResults = personDao.search(sql, listParams);
			for (Object[] results : listResults)
			{
				 person = new Person();
				person.setName((String) results[1]);
				person.setPhotoUrl((String) results[2]);
				// 需要通过大数字对象来获取相应的整型值
				bigDecimal = (BigDecimal) results[3];
				person.setGender(Gender.values()[bigDecimal.intValue()]);
				person.setNation((String) results[4]);
				/*
				 oracle 中 DATE TIMESTAMP 类型均存储了日期和时间，不同的是，
				 TIMESTAMP 还存储了小数秒，精确度可控.
				 因此，jdbc返回的是java.sql.Timestamp，需要在此类型的基础上
				 进行构造.
				 因为，ResultSet 在获取值的时候，统一返回Object，因此，数据库返回
				 的是java.sql.Timestamp类型，但是可以使用ResultSet的getDate()方法来
				 获取java.sq.Date类型
				 */
				timestamp = (Timestamp) results[5];
				// 根据Timestamp 来构造 日期对象
				person.setBirthday(new java.sql.Date(timestamp.getTime()));
				person.setAddress((String) results[6]);
				System.out.println(person.toString());
			}
			
		} catch (Exception e) {
			log.error("testSearchListParam =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLike() {
		try {
			
			//	listParams.add(SqlUtil.likeQuery("广") + "%");
			listParams.add(SqlUtil.likeQuery("广东省"));
			
			sql = "SELECT a.oid, a.name, a.photoUrl, a.gender, a.nation, a.birthday, a.address FROM person a WHERE a.address LIKE ?";
			
			listResults = personDao.search(sql, listParams);
			for (Object[] results : listResults)
			{
				 person = new Person();
				person.setName((String) results[1]);
				person.setPhotoUrl((String) results[2]);
				// 需要通过大数字对象来获取相应的整型值
				bigDecimal = (BigDecimal) results[3];
				person.setGender(Gender.values()[bigDecimal.intValue()]);
				person.setNation((String) results[4]);
				/*
				 oracle 中 DATE TIMESTAMP 类型均存储了日期和时间，不同的是，
				 TIMESTAMP 还存储了小数秒，精确度可控.
				 因此，jdbc返回的是java.sql.Timestamp，需要在此类型的基础上
				 进行构造.
				 因为，ResultSet 在获取值的时候，统一返回Object，因此，数据库返回
				 的是java.sql.Timestamp类型，但是可以使用ResultSet的getDate()方法来
				 获取java.sq.Date类型
				 */
				timestamp = (Timestamp) results[5];
				// 根据Timestamp 来构造 日期对象
				person.setBirthday(new java.sql.Date(timestamp.getTime()));
				person.setAddress((String) results[6]);
				System.out.println(person.toString());
			}
			
		} catch (Exception e) {
			log.error("testLike =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAggregate() {
		try {
			
			
		} catch (Exception e) {
			log.error("testAggregate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWhere() {
		try {
			
			
		} catch (Exception e) {
			log.error("testWhere =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGroupBy() {
		try {
			
			
		} catch (Exception e) {
			log.error("testGroupBy =====> ", e);
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
