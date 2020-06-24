/**
  * @filename TableEnum.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.constant;

 /**
 * @type TableEnum
 * @description 
 * @author qianye.zheng
 */
public enum TableEnum {
	
	/** 无索引数量级表 */
	MILLION_1(TableEnum.TB_PREFIX + "1_million", 1 * TableEnum.MILLION),
	MILLION_2(TableEnum.TB_PREFIX + "2_million", 2 * TableEnum.MILLION),
	MILLION_3(TableEnum.TB_PREFIX + "3_million", 3 * TableEnum.MILLION),
	MILLION_4(TableEnum.TB_PREFIX + "4_million", 4 * TableEnum.MILLION),
	MILLION_5(TableEnum.TB_PREFIX + "5_million", 5 * TableEnum.MILLION),
	MILLION_10(TableEnum.TB_PREFIX + "10_million", 10 * TableEnum.MILLION),
	
	/** 索引数量级表 */
	MILLION_1_IDX(TableEnum.TB_PREFIX + "1_million_idx", 1 * TableEnum.MILLION),
	MILLION_2_IDX(TableEnum.TB_PREFIX + "2_million_idx", 2 * TableEnum.MILLION),
	MILLION_3_IDX(TableEnum.TB_PREFIX + "3_million_idx", 3 * TableEnum.MILLION),
	MILLION_4_IDX(TableEnum.TB_PREFIX + "4_million_idx", 4 * TableEnum.MILLION),
	MILLION_5_IDX(TableEnum.TB_PREFIX + "5_million_idx", 5 * TableEnum.MILLION),
	MILLION_10_IDX(TableEnum.TB_PREFIX + "10_million_idx", 10 * TableEnum.MILLION);
	
	// 一百万
	private static final int MILLION = 1000000;
	private static final String TB_PREFIX = "query_example_";
	
	private String tableName;
	
	private int record;

	/**
	 * @description 构造方法
	 * @param tableName
	 * @param record
	 * @author qianye.zheng
	 */
	private TableEnum(String tableName, int record) {
		this.tableName = tableName;
		this.record = record;
	}

	/**
	* @return the tableName
	*/
	public String getTableName() {
		return tableName;
	}

	/**
	* @return the record
	*/
	public int getRecord() {
		return record;
	}
	
	
	
}
