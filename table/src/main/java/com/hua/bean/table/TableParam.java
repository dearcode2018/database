/**
 * 描述: 
 * TableParam.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean.table;

import com.hua.constant.Constant;
import com.hua.util.ArrayUtil;
import com.hua.util.ReadProperties;
import com.hua.util.StringUtil;

/**
 * 描述: 表 - 配置参数
 * @author  qye.zheng
 * TableParam
 */
public final class TableParam
{
	/*
	 所有单值的字段，若值为空字符串，统一设置为null.
	 */
	
	/* 数据库 - 目录 */
	private String catalog;
	
	/* 方案模式 (支持 like 查询) */
	private String schemaPattern;
	
	/* 数据表名 数组 (多个指定表) */
	private String[]  tableNames;
	
	/* 表名称模式 (支持 like 查询) */
	private String tableNamePattern;
	
	/* 列名称模式 (支持 like 查询) */
	private String columnNamePattern;
	
	/* 类型名称数组*/
	private String[]  types;
	
	private static TableParam instance;
	
	private static final String CONFIG_PATH = "/conf/properties/table.properties";
	
	private static final ReadProperties props = new ReadProperties(CONFIG_PATH);
	
	static
	{
		instance = new TableParam();
		
		instance.setCatalog(props.getProperty("jdbc.database.catalog"));
		instance.setSchemaPattern(props.getProperty("jdbc.database.schema.pattern"));
		
		// 数据表名 数组
		String value = props.getProperty("jdbc.database.table.names");
		// 拦截空设置
		if (!StringUtil.isEmpty(value))
		{
			final String[] tableNames = value.split(Constant.COMMA);
			ArrayUtil.trim(tableNames);
			instance.setTableNames(tableNames);
		}
		
		// 数据表名 数组
		value = props.getProperty("jdbc.database.table.types");
		// 拦截空设置
		if (!StringUtil.isEmpty(value))
		{
			final String[] types = value.split(Constant.COMMA);
			ArrayUtil.trim(types);
			instance.setTypes(types);
		}
		
		instance.setTableNamePattern(props.getProperty("jdbc.database.table.name.pattern"));
		instance.setColumnNamePattern(props.getProperty("jdbc.database.table.column.name.pattern"));
	}
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public TableParam()
	{
	}

	/**
	 * @return the catalog
	 */
	public final String getCatalog()
	{
		return catalog;
	}

	/**
	 * @param catalog the catalog to set
	 */
	private final void setCatalog(String catalog)
	{
		if (StringUtil.isEmpty(catalog))
		{
			catalog = null;
		}
		this.catalog = catalog;
	}

	/**
	 * @return the schemaPattern
	 */
	public final String getSchemaPattern()
	{
		return schemaPattern;
	}

	/**
	 * @param schemaPattern the schemaPattern to set
	 */
	private final void setSchemaPattern(String schemaPattern)
	{
		if (StringUtil.isEmpty(schemaPattern))
		{
			schemaPattern = null;
		}
		this.schemaPattern = schemaPattern;
	}

	/**
	 * @return the tableNames
	 */
	public final String[] getTableNames()
	{
		return tableNames;
	}

	/**
	 * @param tableNames the tableNames to set
	 */
	private final void setTableNames(String[] tableNames)
	{
		this.tableNames = tableNames;
	}

	/**
	 * @return the tableNamePattern
	 */
	public final String getTableNamePattern()
	{
		return tableNamePattern;
	}

	/**
	 * @param tableNamePattern the tableNamePattern to set
	 */
	private final void setTableNamePattern(String tableNamePattern)
	{
		if (StringUtil.isEmpty(tableNamePattern))
		{
			tableNamePattern = null;
		}
		this.tableNamePattern = tableNamePattern;
	}

	/**
	 * @return the types
	 */
	public final String[] getTypes()
	{
		return types;
	}

	/**
	 * @param types the types to set
	 */
	private final void setTypes(String[] types)
	{
		this.types = types;
	}

	/**
	 * @return the instance
	 */
	public static final TableParam getInstance()
	{
		return instance;
	}

	/**
	 * @return the columnNamePattern
	 */
	public final String getColumnNamePattern()
	{
		return columnNamePattern;
	}

	/**
	 * @param columnNamePattern the columnNamePattern to set
	 */
	private final void setColumnNamePattern(String columnNamePattern)
	{
		if (StringUtil.isEmpty(columnNamePattern))
		{
			columnNamePattern = null;
		}
		this.columnNamePattern = columnNamePattern;
	}

}
