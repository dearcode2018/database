/**
 * @filename MysqlDatabase.sql
 * @description MySql - 数据库
 * @author qye.zheng
 * @version 1.0
 */

/* ====================  ==================== */

/*  */

/* 创建数据库_示例 */
CREATE DATABASE `db_name` CHARACTER SET 'UTF8' COLLATE 'UTF8_general_ci';

/* 创建数据库_示例 */
CREATE DATABASE `good` CHARACTER SET 'UTF8' COLLATE 'UTF8_general_ci';

/* 使用数据库 */
use db_name;

/* 删除数据库 */
DROP DATABASE db_name;

/* ====================  ==================== */

/* 显示数据库 - 列表 */
show databases;

/* ====================  ==================== */

/* 查询当前数据库 事务的隔离级别 例如: REPEATABLE-READ */
select @@tx_isolation;

/* 开启事务 */
start transaction;

set autocommit=0
show variables like "%autocommit%";

SELECT @@global.tx_isolation;
SELECT @@session.tx_isolation;
SELECT @@tx_isolation;

SET SESSION TRANSACTION ISOLATION LEVEL read uncommitted;
SET SESSION TRANSACTION ISOLATION LEVEL read committed;
SET SESSION TRANSACTION ISOLATION LEVEL repeatable read;
SET SESSION TRANSACTION ISOLATION LEVEL serializable;

start transaction;
SELECT * FROM text.tx;
commit;

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

