/**
 * @filename OracleDDL.sql
 * @description Oracle - 数据定义语言
 * 数据库操作
 * 数据表操作
 * 数据列操作
 * @author qye.zheng
 * @version 1.0
 */


/* 示例表(在演示中，以此表作为参照) */
CREATE TABLE tb_student (
	oid number(10),
	name varchar2(20),
	sex char(2),
	age nunber(3),
	birthday date,
	log_time timestamp
);

/* ====================  ==================== */

/* 数据库操作 */



/* ====================  ==================== */

/* 数据表操作 */
/* 表_操作 */

/* 创建表 */
--自定义创建表
CREATE TABLE tb_name (
	col1 datatype...,...
)[TABLESPACE tb_space];

--根据结果创建表
CREATE TABLE tb_name AS (select 语句) [TABLESPACE tb_space];
/* 根据结果集方式创建表，复制了表结构之后，根据条件可以复制表中的记录；
复制表结构，即不要记录，只要表，需要加上无条件为false的条件即可。*/

/* 复制表结构 */
CREATE TABLE tb_name AS (select 语句限制条件：WHERE 1 = 2 或者 1 <> 1)；

/* 给表添加注释 */
COMMENT ON TABLE tb_name IS 'xx';

/* 清空表注释（使用空字符串） */
COMMENT ON TABLE tb_name IS '';

/* 给列添加注释 */
COMMENT ON COLUMN tb_name.col_name IS 'xx';

/* 清空列注释（使用空字符串） */
COMMENT ON COLUMN tb_name.col_name IS '';

/* 截断表 （不可回滚） */
TRUNCATE TABLE tb_name;

/* 删除表 */
DROP TABLE tb_name;

/* 表_新增_多个列（绿色表示可修改） */
ALTER TABLE tb_name ADD (col1 dataType DEFAULT default_value_exp CONSTRAINT constraint_name constraint_def, ...);

/* 删除_多个列 */
ALTER TABLE tb_name DROP (col1, col2, ...);

/* 修改多个列 */
ALTER TABLE tb_name MODIFY (col_name dataType DEFAULT default_value_exp CONSTRAINT constraint_name constraint_def);

/* 为多个列_清除默认值 */
ALTER TABLE tb_name MODIFY (col1 DEFAULT NULL, col2 DEFAULT NULL, ...);

/* 重命名_ 单个列 */
ALTER TABLE tb_name RENAME COLUMN col_old_name TO col_new_name;

/* 重命名_单个表 */
ALTER TABLE tb_old_name RENAME TO tb_new_name;

/* 创建表 */
CREATE TABLE tb_name (
col_name dataType DEFAULT default_value_exp CONSTRAINT constraint_name constraint_def, ...

/* 外键声明 */
CONSTRAINT fk_tb_col FOREIGN KEY (col) REFERENCES tb_other (col_other)
) TABLESPACE tb_space_name;

/* ====================  ==================== */

/* 数据列操作 */



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

