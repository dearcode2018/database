/**
 * MongoDbUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import com.mongodb.MongoClient;

/**
 * MongoDbUtil
 * 描述: 
 * @author  qye.zheng
 */
public final class MongoDbUtil
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private MongoDbUtil()
	{
	}

	/**
	 * 
	 * @description 
	 * @param host
	 * @param port
	 * @return
	 * @author qianye.zheng
	 */
	public static final MongoClient getClient(final String host, final Integer port)
	{
		// 创建mongo客户端
		final MongoClient client = new MongoClient(host, port);
		
		return client;
	}
	
}
