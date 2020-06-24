/**
 * @filename Query.sql
 * @description 查询
 * @author qye.zheng
 * @version 1.0
 */

/* ====================  ==================== */

/*  */

/* 若存在先删除 */
DROP TABLE IF EXISTS `query_example`;
/* 创建表 */
CREATE TABLE `query_example` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键-自增长',
  `char_type` char(4) DEFAULT NULL COMMENT '定长字符串',  
  `varchar_type` varchar(8) DEFAULT NULL COMMENT '变长字符串',
  `decimal_type` decimal(6, 2) COMMENT 'decimal类型，指定小数位数, 总长度为65=整数部分+小数部分',  
  `int_type` int COMMENT '整型类型',
  `enum_type` enum('spring', 'summer', 'autumn', 'winter') COMMENT '枚举类',
  `bit_type` bit DEFAULT 0 COMMENT '位类型',	              
  `timestamp_type` timestamp COMMENT '时间戳类型',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='查询示例';
/* 添加索引 */
ALTER TABLE `query_example` ADD INDEX idx_char_type (`char_type`) USING BTREE;
ALTER TABLE `query_example` ADD INDEX idx_varchar_type (`varchar_type`) USING BTREE;
ALTER TABLE `query_example` ADD INDEX idx_decimal_type (`decimal_type`) USING BTREE;
ALTER TABLE `query_example` ADD INDEX idx_int_type (`int_type`) USING BTREE;
ALTER TABLE `query_example` ADD INDEX idx_enum_type (`enum_type`) USING BTREE;
ALTER TABLE `query_example` ADD INDEX idx_bit_type (`bit_type`) USING BTREE;
ALTER TABLE `query_example` ADD INDEX idx_timestamp_type (`timestamp_type`) USING BTREE;


/* ====================  ==================== */

/* 无条件计算总数，超过2百万之后，查询速度明显下降 */
SELECT count(*) FROM query_example;

/* 单个条件 */
SELECT * FROM query_example WHERE char_type = '9PK3'; 

/* 多个条件 */
SELECT * FROM query_example WHERE char_type = '9PK3' AND enum_type = 'spring'; 
SELECT * FROM query_example WHERE char_type = '9PK3' AND enum_type = 'spring' AND bit_type = 1; 
SELECT * FROM query_example WHERE char_type = '9PK3' AND enum_type = 'spring' AND bit_type = 1 AND int_type  > 5000; 

EXPLAIN SELECT * FROM query_example WHERE char_type = '9PK3' AND enum_type = 'spring'; 

/* ====================  ==================== */

/* 有索引和无索引比较 
结论:
5百万以下: 有索引的查询时间是无索引的1/2

5百万及以上: 有索引的查询时间是无索引的1/6

1千万及以上: 有索引的查询时间是无索引的1/2
数量级超过一定值，索引的效果也会明显下降

 */
SELECT * FROM query_example_1_million WHERE char_type = '9PK3' AND enum_type = 'spring'; 
SELECT * FROM query_example_1_million_idx WHERE char_type = '9PK3' AND enum_type = 'spring'; 

SELECT * FROM query_example_2_million WHERE char_type = '9PK3' AND enum_type = 'spring'; 
SELECT * FROM query_example_2_million_idx WHERE char_type = '9PK3' AND enum_type = 'spring'; 

SELECT * FROM query_example_3_million WHERE char_type = '9PK3' AND enum_type = 'spring'; 
SELECT * FROM query_example_3_million_idx WHERE char_type = '9PK3' AND enum_type = 'spring'; 


/* ====================  ==================== */

/* 索引的使用情况
 */	
/* 索引字段的条件顺序-对比，从左往右执行，排除越多的条件越靠左 */
SELECT * FROM query_example_1_million_idx WHERE char_type = '9PK3' AND enum_type = 'spring'; 
SELECT * FROM query_example_1_million_idx WHERE enum_type = 'spring' AND char_type = '9PK3'; 

/* 索引字段类型不同-对比 */
SELECT * FROM query_example_1_million_idx WHERE int_type = '1234' AND char_type = '9PK3'; 
SELECT * FROM query_example_1_million_idx WHERE char_type = '9PK3';


/* 模糊查询 */
SELECT * FROM query_example_1_million_idx WHERE char_type LIKE '9P%'; 
SELECT * FROM query_example_1_million_idx WHERE char_type LIKE '9P%' AND enum_type = 'spring';

/* 字段直接用索引上的值 (创建了索引的字段，其值可以体现在索引上，直接引用，会比再去寻找真正数据速度快) */
SELECT int_type FROM query_example_1_million_idx WHERE int_type = '1234';

/*
limit
查询时间和起始记录的位置成正比
*/
/* 查询 9百万后面的100条数据 方法1 (推荐) */
SELECT a.* FROM t1 a LEFT JOIN (SELECT id FROM t1 LIMIT 9000000, 100) b ON a.id = b.id; 

/* 查询 9百万后面的100条数据 方法2 (子查询) */
SELECT a.* FROM t1 a WHERE id >= (SELECT id FROM t1 LIMIT 9000000, 1); 

/* ====================  ==================== */

/* 关键查询优化建议
1) 使用join替代子查询
2) where条件中，排除越多的越靠左写
3) 复合索引，注意字段的先后顺序
4) union all 替代 or
5) like模糊匹配，前模糊和全模糊不走查询，尽量使用后模糊: like 'prefixVal%'
6) 避免使用 is null 后者is not null，空判断导致引擎不走索引，优化为字段设置相应默认值
避免使用 <> 或 !=
7) 查询字段尽量不参与计算、使用函数
8) exists 替代in，not exists 替代 not in
9)
*/

/*
千万级数据查询建议

1) limit用join中间表的方式来查询
2) 

*/


/* ==================== 存储引擎 ==================== */

/* 常用引擎
MyISAM: Indexed Sequential Access Method (有索引的顺序访问方法)，存储记录和文件的标准方法，不支持事务，支持表级锁
1) 不支持外键，有大量select/insert建议使用此引擎
2) 使用聚集索引，使用B+Tree作为索引结构，数据文件和索引是分离的.
3) 表的具体行数，select count(*) 无需扫描全表，
4) 支持全文索引
5) 无需主键

InnoDB: 
1) 支持事务、行锁(默认)/表锁、外键，有大量update/insert建议使用此引擎
2) 使用聚集索引，使用B+Tree作为索引结构，数据文件和主键索引绑定，
3) 不保存表的具体行数，select count(*) 需扫描全表，
4) 支持全文索引(5.7+)
5) 必须要主键，如果用户没指定，则会自定义主键.

*/


/* 全文搜索 */

/* ====================  ==================== */

/*  */



/* ====================  ==================== */

/*  */


/* ====================  ==================== */

/*  */



/* ====================  ==================== */

/*  */	
	

/* ====================  ==================== */



/* ====================  ==================== */

/*  */

/* ====================  ==================== */

/*  */



/* ====================  ==================== */

/*  */


/* ====================  ==================== */

/*  */



/* ====================  ==================== */

/*  */	
	

/* ====================  ==================== */



/* ====================  ==================== */

/*  */

/* ====================  ==================== */

/*  */



/* ====================  ==================== */

/*  */


/* ====================  ==================== */

/*  */



/* ====================  ==================== */

/*  */	
	

/* ====================  ==================== */



/* ====================  ==================== */

/*  */

