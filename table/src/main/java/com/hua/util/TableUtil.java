/**
 * 描述: 
 * TableUtil.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.util;

import java.util.HashMap;
import java.util.Map;

import com.hua.constant.Constant;
import com.hua.util.StringUtil;

/**
 * 描述: 表 - 工具类
 * @author  qye.zheng
 * TableUtil
 */
public final class TableUtil
{

	private static final Map<Integer, String> typeMap = new HashMap<Integer, String>();
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	private TableUtil()
	{
	}

	static
	{
		final String valueString = "String";
		final String valueDate = "java.sql.Date";
		final String valueTime = "Time";
		final String valueDateTime = "java.util.Date";
		//final String valueTimestamp = "Timestamp";
		final String valueInteger = "Integer";
		final String valueLong = "Long";
		final String valueFloat = "Float";
		final String valueDouble = "Double";
		//final String valueBigDecimal = "java.math.BigDecimal";
		final String valueBoolean = "Boolean";
		final String valueByte = "Byte";
		final String valueByteArray = "Byte[]";
		final String valueCharacter = "Character";
		typeMap.put(java.sql.Types.CHAR, valueCharacter);
		typeMap.put(java.sql.Types.VARCHAR, valueString);
		typeMap.put(java.sql.Types.CLOB, valueString);
		typeMap.put(java.sql.Types.NCHAR, valueCharacter);
		typeMap.put(java.sql.Types.NVARCHAR, valueString);
		typeMap.put(java.sql.Types.NCLOB, valueString);
		typeMap.put(java.sql.Types.TINYINT, valueInteger);
		typeMap.put(java.sql.Types.SMALLINT, valueInteger);
		typeMap.put(java.sql.Types.INTEGER, valueInteger);
		typeMap.put(java.sql.Types.BIGINT, valueLong);
		typeMap.put(java.sql.Types.FLOAT, valueFloat);
		typeMap.put(java.sql.Types.DECIMAL, valueDouble);
		typeMap.put(java.sql.Types.DOUBLE, valueDouble);
		typeMap.put(java.sql.Types.BOOLEAN, valueBoolean);
		typeMap.put(java.sql.Types.BIT, valueBoolean);
		typeMap.put(java.sql.Types.BINARY, valueByte);
		typeMap.put(java.sql.Types.VARBINARY, valueByte);
		typeMap.put(java.sql.Types.BLOB, valueByteArray);
		typeMap.put(java.sql.Types.DATE, valueDate);
		typeMap.put(java.sql.Types.TIME, valueTime);
		//typeMap.put(java.sql.Types.TIMESTAMP, valueTimestamp);
		typeMap.put(java.sql.Types.TIMESTAMP, valueDateTime);
	}
	
	/**
	 * 
	 * 描述: 获取java类型名称 
	 * @author qye.zheng
	 * @param type
	 * @return
	 */
	public static final String getTypeName(final int type)
	{
		return typeMap.get(type);
	}
	
	/**
	 * 
	 * 描述: 获取约定处理后的名称
	 * 字段名称: 转成小写，若含有下划线, 
	 * 将下划线后的字母改成大写，去掉所有下划线
	 * @author qye.zheng
	 * @param columnName
	 * @return
	 */
	public static final String getFieldName(final String columnName)
	{
		// 转成小写
		String fieldName = columnName.toLowerCase();
		// 下划线处理
		fieldName = underlineHandler(fieldName);
		
		return fieldName;
	}
	
	/**
	 * 
	 * 描述: 获取约定处理后的名称
	 * 表名称: 转成小写，若含有下划线, 
	 * 将首字母和下划线后的字母改成大写，去掉所有下划线
	 * @author qye.zheng
	 * @param tableName
	 * @return
	 */
	public static final String getClassName(final String tableName)
	{
		// 转成小写
		String className = tableName.toLowerCase();
		// 首字母转成大写
		className = StringUtil.capitalize(className);
		// 下划线处理
		className = underlineHandler(className);
		
		return className;
	}
	
	/**
	 * 
	 * 描述: 下划线后面的字母转成大写
	 * ，去掉所有下划线
	 * @author qye.zheng
	 * @param value
	 * @return
	 */
	public static final String underlineHandler(String value)
	{
		/**
		 * 下划线处理，使用字符数组处理，非常简单
		 */
		if (value.contains(Constant.UNDERLINE))
		{
			final char[] chs = value.toCharArray();
			String temp = null;
			int index = Constant.NEGATIVE_ONE;
			for (int i = 0; i < chs.length; i++)
			{
				index = i;
				temp = chs[i] + Constant.WHITE_SPACE;
				if (Constant.UNDERLINE.equals(temp))
				{
					/*
					 将其下一个位置的字符转成大写(在长度范围之内)
					 避免该下划线是最后一个字符
					 */
					index++;
					if (index < chs.length)
					{
						chs[index] = Character.toUpperCase(chs[index]);
					}
				}
			}
			// 字符数组装成字符串
			value = String.valueOf(chs);
			// 清除所有的下划线
			value = value.replace(Constant.UNDERLINE, Constant.WHITE_SPACE);
		}
		
		return value;
	}
	
}
