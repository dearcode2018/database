/* oracle-user */

/*
描述:

包含:


*/

/* ====================  ==================== */

/* 系统用户

系统帐户: sys / system / sysman / dbsnmp


 */

/*

连接身份（该用户连接后拥有的权限）
①sysdba：Db管理员，权限：打开/关闭Db服务器、备份/恢复Db、日志归档、会话限制、管理功能、创建Db。
sys用户必须以sysdba的身份才能登录，system用户可以以普通身份登录。
②sysoper：Db操作员，权限：打开/关闭Db服务器、备份/恢复Db、日志归档、会话限制。
③normal：普通用户，权限：查询某些表的数据。
/* 默认用户是 normal */


*/

/* ====================  ==================== */

/* 创建用户 */

CREATE USER user_name IDENTIFIED BY pwd
DEFAULT TABLESPACE xx 
TEMPORARY TABLESPACE yy
ACCOUNT LOCK/UNLOCK;

/* 创建用户- 示例 */
CREATE USER scott IDENTIFIED BY scott ACCOUNT UNLOCK;
GRANT CONNECT, RESOURCE TO scott;
GRANT CONNECT, RESOURCE, DBA TO scott;
/* ====================  ==================== */
/* 修改用户 */

/* 修改密码 */
ALTER USER user_name IDENTIFIED BY new_pwd REPLACE old_pwd; 

/* 用户锁定/解锁 */
ALTER USER user_name ACCOUNT LOCK/UNLOCK; 

/* ====================  ==================== */

/* 授权 */
GRANT CONNECT, SESSION, RESOURCE, DBA TO user_name;


/* ====================  ==================== */

	

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
