/* Microsoft SqlServer */


/* 数据库_操作 */

/* 创建数据库_示例 */




/* 表_操作 */


/* 查询_语句 */

/* 分页-查询 */
SELECT TOP record_size DISTINCT view_list FROM tb_list WHERE filter_condition_list;

/* 分页-查询 示例1 */
SELECT TOP 20 DISTINCT a.name, a.age FROM tb_student a WHERE a.age > 20;





















