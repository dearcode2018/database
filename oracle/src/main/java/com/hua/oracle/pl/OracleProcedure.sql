/**
 * @filename OracleProcedure.sql
 * @description Oracle - 存储过程
 * @author qye.zheng
 * @version 1.0
 */



/* ====================  ==================== */

/* Oracle 存储过程 */

/*
oracle 存储过程 存放在 *.prc 文件中
*/

/*
数据类型
字符串 varchar2
数字 number
文本 clob
日期 date
时间戳 timestamp

*/


/*
变量
1) 变量声明
在命令行或者外部调用存储过程，需要用declare 来声明变量，
但是如果是在存储过程的定义中，is 之后和begin之间不能加declare.
一定要明确declare 的使用位置.
在Oracle存储过程中使用变量，必须首先声明.

2) 变量赋值
variableName := value;
variableName dataType := value;

3) 相等判断 = 

4) 

在存储过程中，变量声明是在 declare 和 begin 之间，declare 时只能通过default 赋初始值，
而使用 := 赋值的方式是在过程体中.

*/

/*
可以在存储过程 代码中放入dbms_output.put_line('')，可以帮助定位程序信息，或者可以借助 plsql developer 工具调试

dbms_output.put_line('');
*/

/* ====================  ==================== */
/* 创建过程 */
CREATE OR REPLACE PROCEDURE procedureName(param IN | OUT | IN OUT dataType default value,...) is
	/* 变量声明 (不能加 declare) */
	variableName dataType([length]) default value;
	variableName dataType([length]) := value;
begin
	/* 若没有语句，写 null; */
	plsql statement;
end;

/*
在创建的时候，可以指定参数的默认值
paramName IN | OUT | INOUT dataType default value

*/

/*
无参数: 不要加括号，否则无法正常编译.
参数: 不能指定长度，在 declare 下面 和 begin 上面进行变量声明，
该变量有些类型必须带上长度，初始值可以加在default后面.


*/


/* 存储过程创建 - 例子 */
/* 无参 存储过程 */
CREATE OR REPLACE PROCEDURE testProcedure01 is
begin
	null;
end;

/* 有参 存储过程 */
CREATE OR REPLACE PROCEDURE testProcedure02(name IN varchar, age IN number) is
v1 varchar2(50) default 'a';
v2 number(3) default 0;
begin
      null;
end;

/* IN 参数 */
CREATE OR REPLACE PROCEDURE testProcedureIn(v_name IN varchar) is
 v varchar2(64) default 'a';
 a number(3) default 0;
begin
      select a.name into v from custom a where a.name like '%' || v_name || '%';
end;

/* ====================  ==================== */

/* 删除存储过程 */
DROP PROCEDURE procedureName;

/* ====================  ==================== */

/* 修改存储过程 or replace 替换 */
CREATE OR REPLACE PROCEDURE


/* ====================  ==================== */

/* 查询存储过程 */	
	

/* ====================  ==================== */

/* 调用存储过程 */

/* 直接在 sql 窗口中调用 */

begin
  -- Call the procedure
  procedureName(参数列表);
end;

/* 在某个存储过程程序中调用另一个存储过程 */
procedureName(参数列表);






/* 创建和执行例子 */
CREATE OR REPLACE PROCEDURE testProcedureExecute(vID IN number) is
 v varchar2(64) default 'a';
 a number(3) default 0;
begin
      select a.name into v from custom a where a.oid = vID;
        dbms_output.put_line(v);
end;


declare
vID number default 1;
begin
  testProcedureExecute(vID);
end;



/* ==================== 异常 ==================== */

/* 抛异常 */
raise xxException(String msg);


/* 异常异常 则执行回滚 */
exception
	/* others 表示除了声明外的任意错误 */
	when others then
		-- 发生异常处理部分




rollback;

/* 没有异常，则需要事务的就需执行 commit;语句 */

/* 没有查询到数据异常 */
NO_DATA_FOUND

/* ==================== 中断/返回 ==================== */

/* 终止当前循环，进入下轮循环 */
continue;

/* 跳出当前循环体 功能相当于 break; */
exit;

/* 返回 */
return;

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























