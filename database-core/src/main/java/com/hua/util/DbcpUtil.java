/**
 * DbcpUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

//import org.apache.commons.dbcp2.BasicDataSourceFactory;

import com.hua.bean.DbcpParam;

/**
 * DbcpUtil
 * 描述: 数据连接池 - 工具类
 * @author  qye.zheng
 */
public final class DbcpUtil
{

	/* javax.sql.DataSource 数据源 */
	private static DataSource dataSource;

	/* java.sql.Connection 连接 */
	private static Connection conn;
	
	static
	{
		try
		{
			// 创建数据源对象
			//dataSource = BasicDataSourceFactory.createDataSource(DbcpParam.getProps());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 构造方法
	 * 描述: 私有 - 禁止实例化
	 * @author  qye.zheng
	 */
	private DbcpUtil()
	{
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * @return
	 */
	public static final Connection getConnection() {
		try
		{
			conn = dataSource.getConnection();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
}
