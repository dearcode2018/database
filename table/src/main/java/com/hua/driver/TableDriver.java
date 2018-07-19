/**
 * 描述: 
 * TableDriver.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hua.bean.table.EntityInfo;
import com.hua.bean.table.FieldInfo;
import com.hua.bean.table.TableParam;
import com.hua.util.EmptyUtil;
import com.hua.util.JdbcUtil;


/**
 * 描述:  - 驱动器
 * @author  qye.zheng
 * TableDriver
 */
public class TableDriver
{
	
	private static final TableParam tableParam = TableParam.getInstance();
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	private TableDriver()
	{
	}
	
	/**
	 * 
	 * 描述: 反向生成实体字段
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean createField()
	{
		boolean flag = false;
		try
		{
			final Connection connection = JdbcUtil.getConnection();
			final DatabaseMetaData databaseMetaData = connection.getMetaData();
			ResultSet columnResultSet = null;
			String[] tableNames = null;
			if (EmptyUtil.isEmpty(tableParam.getTableNames()))
			{
				/*
				 使用 tableNamePattern，先把所有符合条件的表查出来
				 */
				final ResultSet tableResultSet = databaseMetaData.getTables(tableParam.getCatalog(), 
						tableParam.getSchemaPattern(), 
						tableParam.getTableNamePattern(), tableParam.getTypes());
				final List<String> nameList = new ArrayList<String>();
				while (tableResultSet.next())
				{
					nameList.add(tableResultSet.getString("TABLE_NAME"));
				}
				// 
				tableNames = new String[nameList.size()];
				tableNames = nameList.toArray(tableNames);
			} else
			{
				/*
				  使用 tableNames
				 */
				tableNames = tableParam.getTableNames();
			}
			if (EmptyUtil.isEmpty(tableNames))
			{
				System.out.println("没有找到符合条件的表...");
			} else
			{
				EntityInfo entityInfo = null;
				FieldInfo fieldInfo = null;
				for (String tableName : tableNames)
				{
					columnResultSet = databaseMetaData.getColumns(tableParam.getCatalog(), 
							tableParam.getSchemaPattern(),
							tableName, tableParam.getColumnNamePattern());
					// 构造实体信息对象
					entityInfo = new EntityInfo();
					entityInfo.setTableName(tableName);
					// 每次迭代，将获取一个字段信息
					while (columnResultSet.next())
					{
						// 构造字段信息对象
						fieldInfo = new FieldInfo();
						fieldInfo.setComment(columnResultSet.getString("REMARKS"));
						fieldInfo.setType(columnResultSet.getInt("DATA_TYPE"));
						fieldInfo.setColumnName(columnResultSet.getString("COLUMN_NAME"));
						// 加入实体字段中
						entityInfo.addFieldInfo(fieldInfo);
					}
					// 输出当前实体信息
					System.out.println(entityInfo.toString());
				}
			}
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean template()
	{
		boolean flag = false;
		try
		{
			
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
