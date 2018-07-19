/**
 * @filename OracleCursor.sql
 * @description Oracle - 游标
 * @author qye.zheng
 * @version 1.0
 */


/* ==================== 游标 ==================== */

/* 
游标: 一个可以遍历结果集的工具，Cursor.
结果集: ResultSet

 */



/* ====================  ==================== */

/* 游标定义 */
cursor cursorName(参数列表) is select结果集;

/* ====================  ==================== */

/* for 循环遍历游标 */
for variableName in cursorName loop
	/* 返回结果集一行的某一列 */
	variableName.columnName;
end loop;


/* ====================  ==================== */

/* 隐式游标 - 在 循环中使用进行遍历，十分方便 */	
for cur in (select 语句 select 语句定义的就是一个隐式游标) loop
	-- 循环体
end loop;

/* ==================== 游标使用 ==================== */
declare
-- 变量声明
cursor cursorVar(参数列表) is select 语句;
begin
	-- 打开游标
	open cursorVar(传入具体参数);
	loop 
		-- 抓取值 (类似 select xx into xx)
		fetch cursorVar into v_1, v2,... ;
		-- 退出条件
		exit when cursorVar%notfound;
	end loop;
	-- 关闭游标
	close cursorVar;
end;


/* ==================== 游标属性 ==================== */

/*  */
boolean %found
boolean %notfound
boolean %isopen
boolean %rowcount

/* ====================  ==================== */

/*  */
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

