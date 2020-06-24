/**
 * 描述: 
 * JdbcTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.jdbc;

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

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.JdbcUtil;
import com.hua.util.SqlUtil;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * JdbcTest
 */
public final class JdbcTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testJdbc() {
		try {
			
			
		} catch (Exception e) {
			log.error("testJdbc =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetTable() {
		try {
			connection = JdbcUtil.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String[] types = null;
			
			//catalog = "";
			//schemaPattern = "%";
			tableNamePattern = "PERSON";
			
			
			resultSet = connection.getMetaData().getTables(catalog, 
					schemaPattern, tableNamePattern, types);
			ResultSetMetaData rsMetaData = null;
			if (resultSet.next())
			{
				rsMetaData = resultSet.getMetaData();
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
				{
					System.out.println(rsMetaData.getColumnName(i) + ": " 
				+ resultSet.getString(rsMetaData.getColumnName(i)));
					//System.out.println(rsMetaData.getColumnName(i));
				}
				/*System.out.println(resultSet.getString("TABLE_NAME"));
				System.out.println(resultSet.getString("TABLE_COMMENT"));*/
			}
			
			
		} catch (Exception e) {
			log.error("testGetTable =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetColumn() {
		try {
			/**
			 
			 在oracle数据库下，已经能够获取指定表
			 各个列的元数据，但是列的注释为空，此问题
			 尚未解决.
			 
			 以上问题已经解决: 配置中增加 remarksReporting=true
			 然后conn = DriverManager.getConnection(param.getUrl(), 
			 ConnectionParam.getProps().getProps());
			 将Properties 直接传入
			 */
			connection = JdbcUtil.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			
			/**
			 % 可以匹配所有的，LIKE查询
			 */
			
			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String columnNamePattern = "%";
			//catalog = "";
			//schemaPattern = "%";
			tableNamePattern = "PERSON";
			
			
			resultSet = metaData.getColumns(catalog, schemaPattern, 
					tableNamePattern, columnNamePattern);
			ResultSetMetaData rsMetaData = null;
			resultSet.next();
			if (resultSet.next())
			{
				rsMetaData = resultSet.getMetaData();
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
				{
					System.out.println(rsMetaData.getColumnName(i) + ": " 
				+ resultSet.getString(rsMetaData.getColumnName(i)));
					//System.out.println(rsMetaData.getColumnName(i));
				}
				/*System.out.println(resultSet.getString("TABLE_NAME"));
				System.out.println(resultSet.getString("TABLE_COMMENT"));*/
			}
			
		} catch (Exception e) {
			log.error("testGetColumn =====> ", e);
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
	public void testDbConnection() {
		try {
			// 获取连接，检查与数据库的连接情况
			connection = JdbcUtil.getConnection();
			
			log.info("testDbConnection =====> " + connection);
			
		} catch (Exception e) {
			log.error("testDbConnection =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSqlHelper() {
		PreparedStatement ps = null;
		//ps.setDate(parameterIndex, x)
		ResultSet rs = null;
		// ResultSet列标从1开始
		//rs.getLong();
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSqlUtil() {
		String str = "a_b_c_d_%_0%";
		System.out.println(SqlUtil.likeQuery(str));
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
