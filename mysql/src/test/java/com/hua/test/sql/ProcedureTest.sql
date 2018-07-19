/**
 * @filename ProcedureTest.sql
 * @description Sql 存储过程- 测试
 * @author qye.zheng
 * @version 1.0
 */

/* ====================  ==================== */

/* 创建测试 */

/* 无参 */
CREATE PROCEDURE proTest() COMMENT '无参 存储过程注释'
declare v varchar(64) default '';
begin

	select count(*) from t_pro_product_result;
end

/* 无参2 */
CREATE PROCEDURE proTest2() COMMENT '无参 存储过程注释'
begin
	declare v varchar(64) default '';
	select count(*) from t_pro_product_result;
end

/* IN 参数 */
CREATE PROCEDURE proTestIn(IN vID varchar(64)) COMMENT 'IN 参数 存储过程注释'
begin

	select a.* from t_pro_product_result A where a.id = vID;
end

/* 调用 */
set @vID = '0006b2b77df3411ea8349ea84cc62b51';
call proTestIn(@vID);

/* OUT 参数 */
CREATE PROCEDURE proTestOut(OUT dataSize int) COMMENT 'OUT 参数 存储过程注释'
begin
	select count(*) into dataSize from t_pro_product_result;
end

/* 调用 */
set @dataSize = 0;
call proTestOut(@dataSize);
/* 输出显示结果 */
select @dataSize;

/* INOUT 参数 */
CREATE PROCEDURE proTestInOut(INOUT value varchar(64)) COMMENT 'INOUT 参数 存储过程注释'
begin
	select a.CREATER into value from t_pro_product_result a where a.id = value;
end

/* 调用 */
set @value = '0006b2b77df3411ea8349ea84cc62b51';
call proTestInOut(@value);
/* 输出显示结果 */
select @value;
/* ====================  ==================== */

/* if 语句测试 */
CREATE PROCEDURE proTestIf(IN vNum int) COMMENT 'if 语句测试 存储过程注释'
begin
	if vNum > 0 then
		select '大于0';
	elseif vNum = 0 then
		select '等于0';
	else
		select '小于0';
	end if;
end

/* 调用 */
set @value = 0;
call proTestIf(@value);
/* ====================  ==================== */

/* case 语句测试 */
CREATE PROCEDURE proTestCase(IN vNum int) COMMENT 'case 语句测试 存储过程注释'
begin
	case vNum
		when 0 then
		select '0';
		when 1 then
		select '1';
		else
		select 'other';
	end case;
end

/* 调用 */
set @value = 0;
call proTestCase(@value);

/* ====================  ==================== */

/* while 循环测试 */	
CREATE PROCEDURE proTestWhile(OUT vNum int) COMMENT 'while 语句测试 存储过程注释'
begin
	/* 初始化 OUT 变量 */
	set vNum = 0;
	while vNum < 10 do
		 set vNum = vNum + 1;
	end while;
end	

/* 调用 */
set @value = 0;
call proTestWhile(@value);
/* 输出显示结果 */
select @value;

DROP PROCEDURE proTestWhile;

/* repeat 循环测试 */	
CREATE PROCEDURE proTestRepeat(OUT vNum int) COMMENT 'repeat 语句测试 存储过程注释'
begin
	/* 初始化 OUT 变量 */
	set vNum = 0;
	repeat
		 set vNum = vNum + 1;
	until vNum > 10
	end repeat;
end	

/* 调用 */
set @value = 0;
call proTestRepeat(@value);
/* 输出显示结果 */
select @value;

DROP PROCEDURE proTestRepeat;

/* loop 循环测试 */	
CREATE PROCEDURE proTestLoop(OUT vNum int) COMMENT 'loop 语句测试 存储过程注释'
begin
	/* 初始化 OUT 变量 */
	set vNum = 0;
	loop_label: loop
		 set vNum = vNum + 1;
		if vNum > 10 then
			leave loop_label;
		end if;
	end loop;
end	

/* 调用 */
set @value = 0;
call proTestLoop(@value);
/* 输出显示结果 */
select @value;

DROP PROCEDURE proTestLoop;

/* 存储过程中调用其他存储过程 */
CREATE PROCEDURE proTestCallOtherProcedure(OUT vNum int) COMMENT '存储过程中调用其他存储过程'
begin
	/* 初始化 OUT 变量 */
	set vNum = 0;
	/* 调用其他存储过程 */
	call proTestLoop(vNum);
end	

/* 调用 */
set @value = 0;
call proTestCallOtherProcedure(@value);
/* 输出显示结果 */
select @value;

DROP PROCEDURE proTestCallOtherProcedure;

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

