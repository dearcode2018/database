/**
 * @filename OraclePackage.sql
 * @description Oracle - 包
 * @author qye.zheng
 * @version 1.0
 */

/* ====================  ==================== */

/*  */

/* 创建-包规范 */
CREATE OR REPLEACE PACKAGE pkg_name IS
PROCEDURE proc_name(参数列表);
FUNCTION fun_name(参数列表) RETURN retType;
END;

/* 创建-包体 */
CREATE OR REPLACE PACKAGE BODY pkg_name IS
--过程、函数...的实现...
PROCEDURE proc_name() IS ...
FUNCTION fun_name() IS ...
END;

/* ====================  ==================== */

/* 在包中自定义 ref cursor */
create or replace package my_package is
	type my_cursor is ref cursor;
end;

/* 在存储过程中引用数据集 */
create or replace procedure my_proc (p_cursor out my_package.my_cursor) is
begin
	-- 通过这种方式 来返回结果集
	open p_cursor for select 语句;
end;

/* 
这样，在应用程序中调用该存储过程
CallableStatement proc = null;
proc = collection.prepareCall("{call my_proc(?, ?, ?)}");

// 获取结果集
ResultSet resultSet = (ResultSet) proc.getObject();


allableStatement proc=null;
proc=myConnection.prepareCall("{call getdcsj(?,?,?,?,?)}");
proc.setString(1, strDate);
proc.setString(2, jzbh);
proc.registerOutParameter(3, Types.NUMERIC);
proc.registerOutParameter(4, OracleTypes.CURSOR);
proc.registerOutParameter(5, OracleTypes.CURSOR);
proc.execute();
ResultSet rs=null;
int total_number=proc.getInt(3);
rs=(ResultSet)proc.getObject(4);

 */

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

