/**
 * 描述: 
 * ColumnTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.table;

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

import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.JdbcUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ColumnTest
 */
public final class ColumnTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testColumn() {
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
			//resultSet.next();
			while (resultSet.next())
			{
				rsMetaData = resultSet.getMetaData();
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
				{
					System.out.println(rsMetaData.getColumnName(i) + ": " 
				+ resultSet.getString(rsMetaData.getColumnName(i)));
					//System.out.println(rsMetaData.getColumnName(i));
				}
				System.out.println("===========================");
				/*System.out.println(resultSet.getString("TABLE_NAME"));
				System.out.println(resultSet.getString("TABLE_COMMENT"));*/
			}
			
		} catch (Exception e) {
			log.error("testColumn =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDataType() {
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
			String schemaPattern = "SCOTT";
			String tableNamePattern = null;
			String columnNamePattern = "%";
			columnNamePattern = null;
			//catalog = "";
			//schemaPattern = "%";
			//tableNamePattern = "TB_COL_TYPE";
			tableNamePattern = "TB_COL_TYPEB";
			tableNamePattern = "EMP%";
			
			resultSet = metaData.getTables(catalog, schemaPattern, tableNamePattern, null);
			System.out.println("resultSet fetch size = " + resultSet.getFetchSize());
			while (resultSet.next())
			{
				System.out.println("TABLE_NAME: " + resultSet.getString("TABLE_NAME"));
			}
			
			
			resultSet = metaData.getColumns(catalog, schemaPattern, 
					tableNamePattern, columnNamePattern);
			int count = 0;
			while (resultSet.next())
			{
				System.out.println("REMARKS: " + resultSet.getString("REMARKS"));
				System.out.println("DATA_TYPE: " + resultSet.getInt("DATA_TYPE"));
				System.out.println("COLUMN_NAME: " + resultSet.getString("COLUMN_NAME"));
				/*
				rsMetaData = resultSet.getMetaData();
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
				{
					System.out.println(rsMetaData.getColumnName(i) + ": " 
				+ resultSet.getString(rsMetaData.getColumnName(i)));
					//System.out.println(rsMetaData.getColumnName(i));
				}*/
				count++;
				System.out.println("===========================");
				/*System.out.println(resultSet.getString("TABLE_NAME"));
				System.out.println(resultSet.getString("TABLE_COMMENT"));*/
			}
			System.out.println("count = " + count);
		} catch (Exception e) {
			log.error("testDataType =====> ", e);
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
