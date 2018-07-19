/**
 * 描述: 
 * EntityInfo.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean.table;

import java.util.ArrayList;
import java.util.List;

import com.hua.util.EmptyUtil;
import com.hua.util.StringUtil;
import com.hua.util.TableUtil;

/**
 * 描述: 实体-信息
 * @author  qye.zheng
 * EntityInfo
 */
public final class EntityInfo
{
	/* 字段名称 */
	private String tableName;
	
	/* 实体名称 */
	private String entityName;

	/* 字段信息 */
	private List<FieldInfo> fieldInfos = new ArrayList<FieldInfo>();
	
	/* 备注 */
	private String remark;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public EntityInfo()
	{
	}

	/**
	 * @return the tableName
	 */
	public final String getTableName()
	{
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public final void setTableName(String tableName)
	{
		// 通过表名称来获取实体的名称
		this.entityName = TableUtil.getClassName(tableName);
		this.tableName = tableName;
	}

	/**
	 * @return the entityName
	 */
	public final String getEntityName()
	{
		return entityName;
	}

	/**
	 * @param entityName the entityName to set
	 */
	public final void setEntityName(String entityName)
	{
		this.entityName = entityName;
	}

	/**
	 * @return the fieldInfos
	 */
	public final List<FieldInfo> getFieldInfos()
	{
		return fieldInfos;
	}

	/**
	 * @param fieldInfos the fieldInfos to set
	 */
	public final void addFieldInfo(FieldInfo fieldInfo)
	{
		this.fieldInfos.add(fieldInfo);
	}

	/**
	 * @return the remark
	 */
	public final String getRemark()
	{
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public final void setRemark(String remark)
	{
		this.remark = remark;
	}

	 /**
	 * 描述: 
	 * @author qye.zheng
	 * @return
	 */
	@Override
	public String toString()
	{
		final String separateLine = "=========================";
		final StringBuilder builder = StringUtil.getBuilder();
		builder.append("实体名称: " + entityName + " 字段声明 >>>");
		builder.append(separateLine);
		if (!EmptyUtil.isEmpty(fieldInfos))
		{
			for (FieldInfo info : fieldInfos)
			{
				builder.append(info.toString());
			}
		} else
		{
			builder.append("实体字段为空...");
		}
		builder.append(separateLine);
		
		return builder.toString();
	}
	
}
