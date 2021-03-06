/**
 * @filename OracleBase.sql
 * @description Oracle - 基本
 * @author qye.zheng
 * @version 1.0
 */



/* 注释 */

/* 表 - 注释 */
COMMENT ON TABLE tb_name IS 'comm';

/* 列 - 注释 */
COMMENT ON COLUMN tb_name.column_name IS 'comm';







/* 创建簇 */
CREATE CLUSTER cluster_name (
col_name type
);





/* 创建目录 */
CREATE OR REPLACE DIRECTORY dir_name AS '/dir.../'; 












/* */


/* plsql 配置 tnsnames.ora */
/* 


# 多出空格会导致错误, 服务名称前面不能有空格 
# 连接别名
REMOTE_GSM_ORCL =
  (DESCRIPTION =
	# 协议、地址、端口
    (ADDRESS = (PROTOCOL = TCP)(HOST = 172.16.100.183)(PORT = 1521))
    (CONNECT_DATA =
      (SERVER = DEDICATED)
	  # 远程Db服务器上的db实例
      (SERVICE_NAME = ORCL)
    )
  )

# begin config example #
xx =
(DESCRIPTION =
	(ADDRESS_LIST =
		( ADDRESS = (PROTOCOL = TCP) (HOST = IPAddr) (PORT = 1521) ) )
	(CONNECT_DATA =(SERVICE_NAME = xx))
 )  
# end of config example #
*/



/* ====================  ==================== */

/* 基础知识 */

/*
单引号
①字符串：2个单引号括起来;
②转义：在字符串中，使用一个单引号进行特殊字符转义，使之可以在字符串中表达出来.


*/

/*  字符串连接： || */
/* 由于Oracle支持类型自动转换，数值也可以进行连接 */

/* ====================  ==================== */

/* 
Oracle将NULL作为无穷大处理，所以排序都放在之后

 */


/* ====================  ==================== */

/* 规范 */


/*
表命名：tb_xx
主键_约束：pk_tb_name_col_name
外键_约束：fk_tb_name_col_name
索引：idx_tb_name_col_name
视图：v_xx



*/

/* ====================  ==================== */

/*  */	
	

/* ====================  ==================== */



/* ====================  ==================== */

/*  */

/* ====================  ==================== */

/*  */



/* ====================  ==================== */

/*1）物理数据库结构包括各种文件:
数据文件、控制文件、参数文件、备份文件、归档文件、重做日志文件、报警和跟踪日志文件。
2）数据文件：存放数据库数据。Oracle数据库由一个或多个数据文件组成，数据文件结合在一起形成表空间。*/


/* 1）Oracle为所有的数据分配逻辑数据库空间。
数据库空间分配的单元是：数据块（data block）、盘区、段。
2）数据块（Data Block）
在最好的粒度层次上，Oracle将数据存储在数据块中，数据块也称为逻辑块、Oracle块、页。
3）盘区（Extent）
盘区由连续的数据块组成。
4）段（Segment）
由一组范围组成；
段_类型：数据段、索引段、临时段、回滚段。 */


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














