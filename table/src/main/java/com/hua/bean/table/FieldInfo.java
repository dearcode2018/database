/**
 * 描述: 
 * FieldInfo.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean.table;

import com.hua.constant.Constant;
import com.hua.util.StringUtil;
import com.hua.util.TableUtil;

/**
 * 描述: 实体-字段信息
 * @author  qye.zheng
 * FieldInfo
 */
public final class FieldInfo
{
	/* 注释 */
	private String comment;

	/* 类型值: 对应 java.sql.Types */
	private int type;
	
	/* 列名称 */
	private String columnName;
	
	/* 类型名称 */
	private String typeName;

	/* 字段名称 */
	private String fieldName;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public FieldInfo()
	{
	}

	/**
	 * @return the comment
	 */
	public final String getComment()
	{
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public final void setComment(String comment)
	{
		if (null == comment)
		{
			comment = Constant.WHITE_SPACE;
		}
		this.comment = comment;
	}

	/**
	 * @return the type
	 */
	public final int getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(int type)
	{
		// 给类型名称赋值
		this.typeName = TableUtil.getTypeName(type);
		this.type = type;
	}

	/**
	 * @return the typeName
	 */
	public final String getTypeName()
	{
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public final void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	/**
	 * @return the fieldName
	 */
	public final String getFieldName()
	{
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public final void setFieldName(String fieldName)
	{
		this.fieldName = fieldName;
	}

	 /**
	 * @return the columnName
	 */
	public final String getColumnName()
	{
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public final void setColumnName(String columnName)
	{
		// 通过列名称来获取类型的名称
		this.fieldName = TableUtil.getFieldName(columnName);
		this.columnName = columnName;
	}

	/**
	 * 描述: 
	 * @author qye.zheng
	 * @return
	 */
	@Override
	public String toString()
	{
		final StringBuilder builder = StringUtil.getBuilder();
		builder.append(Constant.LINE_BREAK);
		builder.append("/* " + comment + " */");
		builder.append(Constant.LINE_BREAK);
		builder.append("private " + typeName + " "+ fieldName + Constant.SEMICOLON);
		builder.append(Constant.LINE_BREAK);
		
		return builder.toString();
	}
	
}
