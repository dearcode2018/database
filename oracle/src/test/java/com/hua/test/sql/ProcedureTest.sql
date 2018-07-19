/**
 * @filename ProcedureTest.sql
 * @description Sql 存储过程- 测试
 * @author qye.zheng
 * @version 1.0
 */

/* ====================  ==================== */
dbms_output.put_line('');



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


/* OUT 参数 */
CREATE OR REPLACE PROCEDURE testProcedureOut(vID IN number, vName OUT varchar) is
         v varchar2(64) default 'a';
         a number(3) default 0;
begin
      select a.name into vName from custom a where a.oid = vID;
       dbms_output.put_line(vName);
end;

/* 调用 */
declare
vID number default 1;
vName varchar2(64);
begin
  testProcedureOut(vID, vName);
  dbms_output.put_line('getValue: ' || vName);
end;


/* IN OUT 参数 */
CREATE OR REPLACE PROCEDURE testProcedureInOut(vID IN number, vName IN OUT varchar) is
v varchar2(64) default 'a';
a number(3) default 0;
begin
      select a.name into vName from custom a where a.oid = vID and a.name = vName;
       dbms_output.put_line(vName);
end;

/* 调用 */
declare
vID number default 1;
vName varchar2(128) default '徐明';
begin
	vName := '徐明';
  	testProcedureInOut(vID, vName);
 	 dbms_output.put_line('getValue: ' || vName);
end;


/* 调用其他过程 */
CREATE OR REPLACE PROCEDURE testCallOtherProcedure(vID IN number, vName IN OUT varchar) is
v varchar2(64) default 'a';
a number(3) default 0;
begin
    /* 调用其他过程 */
    testProcedureInOut(vID, vName);
    dbms_output.put_line(vName);
end;
/* 调用 */
declare
vID number default 1;
vName varchar2(128) default '徐明';
begin
	vName := '徐明';
  	testCallOtherProcedure(vID, vName);
 	 dbms_output.put_line('getValue: ' || vName);

end;

/* ==================== 语句测试 ==================== */

/* if 语句测试 */
create or replace procedure testProcedureIf(vCount IN number) is
msg varchar2(64) default '';
v number(3) default 0;
begin
	if vCount > 1 then
		dbms_output.put_line('大于1');
	elsif vCount = 1 then
		dbms_output.put_line('等于1');
	else 
	dbms_output.put_line('小于1');
	end if;
end;
/* 调用 */
declare
vCount number default 1;
begin
  	testProcedureIf(vCount);
end;


/* for 循环测试 */
create or replace procedure testProcedureFor01(vCount IN number) is
msg varchar2(64) default '';
v number(3) default 0;
begin
	for v in 1..5 loop
		dbms_output.put_line(v);
	end loop; 
end;
/* 调用 */
declare
vCount number default 1;
begin
  	testProcedureFor01(vCount);
end;

/* while 循环测试 */
create or replace procedure testProcedureWhile01(vCount IN number) is
msg varchar2(64) default '';
v number(3) default 0;
begin
	v := vCount;
	while v < 10 loop
		dbms_output.put_line(v);
		-- 自增
		v := v + 1;
	end loop;
end;
/* 调用 */
declare
vCount number default 5;
begin
  	testProcedureWhile01(vCount);
end;

/* for 循环 - 游标测试 */
create or replace procedure testProcedureCursor(vCount IN number) is
msg varchar2(64) default '';
v number(3) default 0;
/* 定义游标 */
cursor cursorVar is (select a.oid, a.name, a.balance, a.address, a.status from custom a);
begin
	for cur in cursorVar loop
		dbms_output.put_line(cur.oid || ', ' || cur.name || ', ' || cur.address);
	end loop;
end;
/* 调用 */
declare
vCount number default 5;
begin
  	testProcedureCursor(vCount);
end;

/* 循环 - 数组 测试 */

/* ====================  ==================== */

/* */



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

