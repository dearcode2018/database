/**
 * 描述: 
 * DbcpParam.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import java.util.Properties;

import com.hua.util.ReadProperties;

/**
 * 描述: 
 * @author  qye.zheng
 * DbcpParam
 */
public final class DbcpParam
{

	/**
	driverClassName=oracle.jdbc.driver.OracleDriver
	url=jdbc:oracle:thin:@127.0.0.1:1521:orcl
	username=scott
	password=scott
	defaultAutoCommit=false
	
	初始大小
	initialSize=5
	
	最小处理数
	minIdle=3
	
	最大处理数
	maxIdle=4
	
	最大连接数
	maxTotal=3
	
	最大等待时间(毫秒数)
	maxWaitMillis=5000
	 */
	
	/* 数据库驱动类名 */
	private String driverClassName;
	
	/* 地址 */
	private String url;
	
	/* 数据库_用户名 */
	private String username;
	
	/* 数据库_密码 */
	private String password;
	
	/* 是否自动提交 */
	private boolean defaultAutoCommit;
	
	/* 是否自动提交 */
	private boolean defaultReadOnly;
	
	/* 描述信息 */
	private String description;
	
	private static DbcpParam instance;
	
	/* jdbc 配置文件路径 */
	private static final String FILE_PATH = "/conf/properties/dbcp.properties";
	
	private static final ReadProperties readProps = new ReadProperties(FILE_PATH);
	
	static
	{
		instance = new DbcpParam();
	}
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	private DbcpParam()
	{
	}

	/**
	 * @return the driverClassName
	 */
	public final String getDriverClassName()
	{
		return driverClassName;
	}

	/**
	 * @param driverClassName the driverClassName to set
	 */
	public final void setDriverClassName(String driverClassName)
	{
		this.driverClassName = driverClassName;
	}

	/**
	 * @return the url
	 */
	public final String getUrl()
	{
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public final void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * @return the username
	 */
	public final String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public final void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public final String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the defaultAutoCommit
	 */
	public final boolean isDefaultAutoCommit()
	{
		return defaultAutoCommit;
	}

	/**
	 * @param defaultAutoCommit the defaultAutoCommit to set
	 */
	public final void setDefaultAutoCommit(boolean defaultAutoCommit)
	{
		this.defaultAutoCommit = defaultAutoCommit;
	}

	/**
	 * @return the defaultReadOnly
	 */
	public final boolean isDefaultReadOnly()
	{
		return defaultReadOnly;
	}

	/**
	 * @param defaultReadOnly the defaultReadOnly to set
	 */
	public final void setDefaultReadOnly(boolean defaultReadOnly)
	{
		this.defaultReadOnly = defaultReadOnly;
	}

	/**
	 * @return the description
	 */
	public final String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public final void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the instance
	 */
	public static final DbcpParam getInstance()
	{
		return instance;
	}

	/**
	 * @return the readProps
	 */
	public static final Properties getProps()
	{
		return readProps.getProps();
	}
	
}
