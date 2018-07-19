/**
 * @filename MySqlDDL.sql
 * @description MySql - 数据定义语言
 * @author qye.zheng
 * @version 1.0
 */

/*
描述:

包含:
数据库操作
数据表操作
数据列操作

*/

/* ====================  ==================== */

/* 数据库操作 */

/* 创建数据库_示例 */
CREATE DATABASE `db_name` CHARACTER SET 'UTF8' COLLATE 'UTF8_general_ci';

/* 创建数据库_示例 */
CREATE DATABASE `good` CHARACTER SET 'UTF8' COLLATE 'UTF8_general_ci';

/* 使用数据库 */
use db_name;

/* ====================  ==================== */

/* 数据表操作 */
/* 若存在先删除 */
DROP TABLE IF EXISTS `person`;
/* 表_创建_示例 */
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` tinyint(4) DEFAULT '0',
  `sex` varchar(5) DEFAULT 'M',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=UTF8;

/* 表 - 重命名 */
ALTER TABLE tb_name RENAME tb_new_name;

/* ====================  ==================== */

/* 数据列操作 */

/* 列修改 */
ALTER TABLE tb_name;

/* 添加列 */
ALTER TABLE tb_name ADD column_name dataType constraint_def COMMENT '' AFTER add_place;
/*
AFTER add_place 添加的位置，可以指定在某个字段后面添加，
若不指定，则追加到最后.
*/

/* 删除列 */
ALTER TABLE tb_name DROP column_name;

/* 修改列 */
ALTER TABLE tb_name CHANGE column_old_name column_new_name dataType constraint_def;

/* 修改多个列 */
ALTER TABLE tb_name MODIFY (col_name dataType DEFAULT default_value_exp 
CONSTRAINT constraint_name constraint_def);

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

