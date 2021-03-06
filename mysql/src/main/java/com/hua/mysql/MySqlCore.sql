/**
 * @filename MySqlCore.sql
 * @description MySql - 核心
 * @author qye.zheng
 * @version 1.0
 */

/*
描述:

包含:
分页查询

*/


/* ====================  ==================== */

/* 分页查询 */

/*
A) LIMIT 单个参数
LIMIT n 返回前n条记录

LIMIT n 等效于 LIMIT 0, n

B) LIMIT 2个参数   -- 推荐使用这种方式
offset 第几行， 从 0 开始(beginIndex)
size 页的大小 (pageSize)
LIMIT offset, pageSize

*/

/*
分页-参数实体
int offset;
int pageSize;
*/

LIMIT offset, pageSize;

/* 分页-示例 */
SELECT a.* FROM tb_name a WHERE condition LIMIT offset, pageSize;

SELECT view_field FROM tb_list WHERE filter_condition_list
LIMIT offset, pageSize;


/* 查询_语句 */

/* 分页-查询 (指定记录条数) */
SELECT view_list FROM tb_list a WHERE filter_condition_list LIMIT record_size;

/* 分页-查询 (指定起始下标、记录条数) */
SELECT view_list FROM tb_list a WHERE filter_condition_list LIMIT start_index, record_size;

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



















