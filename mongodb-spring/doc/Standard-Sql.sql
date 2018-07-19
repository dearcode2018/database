/* Standard-Sq  */

/* 标准 sql 支持 xx 标准 */

/* 数据库_操作 */


 /* 事物控制 */
 /* 提交 */
 COMMIT

 /* 保存点 */
 SAVEPOINT
 
 /* 回滚 */
 ROLLBACK



/* 表_操作 */

/* 创建表 */
CREATE TABLE tb_name (column_def_list);

/* 删除表 */
DROP TABLE tb_name;

/* 修改表 */
ALTER TABLE tb_name;

/* 插入语句 */
INSERT INTO tb_name (column_list) VALUES (value_list);

/* 删除语句 */
DELETE FROM tb_name WHERE filter_condtion_list;

/* 截断表-移除所有记录，不记日志, 不可回滚 */
TRUNCATE TABLE tb_name;

/* 修改语句 */
UPDATE tb_name SET assignment_list WHERE filter_condtion_list;

/* 查询_语句 */
SELECT DISTINCT view_field FROM tb_list WHERE filter_condtion_list 
GROUP BY (case_clause or group_field) HAVING group_condition
ORDER BY field1 ASC, field2 DESC

/* 表连接 */
/* 内连接，INNER JOIN */
SELECT DISTINCT view_field FROM tb_1 JOIN tb_2 ON (join_condidtion) WHERE filter_condtion_list;

/* 外连接 OUTER JOIN */
SELECT DISTINCT view_field FROM tb_1 LEFT JOIN tb_2 ON (join_condidtion) WHERE filter_condtion_list;
SELECT DISTINCT view_field FROM tb_1 FULL JOIN tb_2 ON (join_condidtion) WHERE filter_condtion_list;

/* 交叉连接-笛卡尔积 */
SELECT DISTINCT view_field FROM tb_1 CROSS JOIN tb_2 ON (join_condidtion) WHERE filter_condtion_list;


/* 集合运算前提条件 ： 集合之间保持列表一致 */
/* 集合运算-并集(重复) */
SELECT DISTINCT view_field FROM tb_list
UNION ALL 
SELECT DISTINCT view_field FROM tb_list

/* 集合运算-并集(去重) */
SELECT DISTINCT view_field FROM tb_list
UNION 
SELECT DISTINCT view_field FROM tb_list

/* 集合运算-交集 */
SELECT DISTINCT view_field FROM tb_list
INTERSECT 
SELECT DISTINCT view_field FROM tb_list

/* 集合运算-补集 */
SELECT DISTINCT view_field FROM tb_list
MINUS 
SELECT DISTINCT view_field FROM tb_list

/* 子查询

子查询类型：
单行子查询：返回0-1行结果
多行子查询：返回0-n行结果
 */
 
 /* 模糊查询
 _
 %
 转义 : ESCAPT '/'
 /_
 /%
 */
SELECT DISTINCT view_field FROM tb_list WHERE field LIKE '' ESCAPE '/';
 

 
/* CASE WHEN -用法1 (不推荐)  */
(CASE var_name
	WHEN value_1 THEN result_1
	WHEN value_2 THEN result_2
	WHEN value_3 THEN result_3
	ELSE result_other
END)

/* CASE WHEN -用法2 (推荐) 可构建复杂条件 */
(CASE 
	WHEN boolean_exp_1 THEN result_1
	WHEN boolean_exp_2 THEN result_2
	WHEN boolean_exp_3 THEN result_3   
	ELSE result_other
END)

/* CASE语句可以用于 SELECT/WHERE/GROUP BY 等字句中 */

/* CASE WHEN-示例1 (构成单列) */
(CASE t.name
	WHEN  'a' THEN 'A_name'
	WHEN 'b' THEN 'B_name'
	ELSE 'C_name'
END) AS new_col_name

/* CASE WHEN-示例2 (构成单列) */
(CASE
	WHEN t.name = 'a' AND t.age > 20 THEN 'A_name'
	WHEN t.name = 'b' OR t.age < 30 THEN 'B_name'
	ELSE 'C_name'
END) AS new_col_name

/* 多列构成 新的一列 */

/* CASE WHEN-示例 生产商+供应商+零售商
t.a : 0-不是生产商，1-是生产商
t.b : 0-不是供应商，1-是供应商
t.c : 0-不是零售商，1-是零售商
 */
((CASE
	WHEN t.a = '1' THEN '生产商' 
	ELSE '') 
||
 (CASE 
	WHEN t.b = '1' and t.a = '1' THEN '+供应商'
	WHEN t.b = '1' and (t.a = '0' OR t.a IS NULL) THEN '供应商'
	ELSE '' ) 
 ||
 (CASE
	WHEN t.c = '1' and (t.a = '1' OR t.b = '1') THEN '+零售商'
	WHEN t.c = '1' THEN '零售商'
	ELSE '')) AS entType


/*
CASE WHEN-示例 地区人口统计
CREATE TABLE t_man (country varchar2(30), population number(5));
INSERT INTO t_man (country, population) VALUES ('中国', 125);
INSERT INTO t_man (country, population) VALUES ('美国', 60);
INSERT INTO t_man (country, population) VALUES ('印度', 110);
INSERT INTO t_man (country, population) VALUES ('加拿大', 10);
INSERT INTO t_man (country, population) VALUES ('日本', 40);
INSERT INTO t_man (country, population) VALUES ('墨西哥', 70);
通过该例子，可以这样理解group by的用法：group by 某个列，根据值是否相等来进行归类
*/
SELECT  
/* 统计符合条件的洲的人口 (统计结果依赖于 分组细节 group by) */
SUM(population) AS "人口",   
		/* 显示用 （非必须 与group by 中的case字句必须一致） */
        (CASE country      
                WHEN '中国'     THEN '亚洲'      
                WHEN '印度'     THEN '亚洲'      
                WHEN '日本'     THEN '亚洲'      
                WHEN '美国'     THEN '北美洲'      
                WHEN '加拿大'  THEN '北美洲'    
                WHEN '墨西哥'  THEN '北美洲'      
        ELSE '其他' END) AS "洲" FROM t_man
		/* 分组细节，决定分组如何组织 */
        GROUP BY
           (CASE country      
				/* 若满足该条件，则归到此类别-自定义的类别 */
                WHEN '中国'     THEN '亚洲'
                WHEN '印度'     THEN '亚洲'      
                WHEN '日本'     THEN '亚洲'      
                WHEN '美国'     THEN '北美洲'      
                WHEN '加拿大'  THEN '北美洲'      
                WHEN '墨西哥'  THEN '北美洲'      
        ELSE '其他' END); 


	
	
	
	
	
	
	
	
/*  */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	











