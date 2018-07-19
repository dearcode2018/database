/**
 * @filename MysqlComment.sql
 * @description MySql - 注释
 * @author qye.zheng
 * @version 1.0
 */

/* ====================  ==================== */
/* 表注释 */

/* 创建表的时候 - 添加注释 */
CREATE TABLE tb_name () COMMENT '表注释';

/* 添加/修改 - 表注释 */
ALTER TABLE tb_name COMMENT '表注释';  

/* 删除(清空) - 表注释 */
ALTER TABLE tb_name COMMENT '';

/* ====================  ==================== */

/* 列注释 */

/* 创建表 - 定义列的时候 - 添加注释 */
CREATE TABLE tb_name ( `name` varchar(50) DEFAULT NULL COMMENT '列注释') COMMENT '表注释';

/* 添加/修改 - 列注释 */
ALTER TABLE tb_name MODIFY COLUMN column_name column_definition COMMENT '列注释';

/* 删除(清空) - 列注释 */
ALTER TABLE tb_name MODIFY COLUMN column_name column_definition COMMENT '';

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
