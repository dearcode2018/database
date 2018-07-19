/**
 * @filename OracleFunction.sql
 * @description Oracle - 函数
 * 系统函数
 * 聚合函数
 * 日期时间
 * 字符函数
 * 数字函数
 * 转换函数
 * 格式函数
 * @author qye.zheng
 * @version 1.0
 */

/* 注意: CONCAT(String, String)函数仅支持2个参数，而不像Orm框架(例如Jpa/Hibernate)可以支持
3个参数，类似CONCAT('%', Object value, '%')
*/
/* 连接多个字符串-正确写法 */
SELECT CONCAT(CONCAT('a', 'b'), 'c') FROM dual;
/* 连接多个字符串-错误写法 */
--SELECT CONCAT('a', 'b', 'c') FROM dual;





/* 创建函数 */
CREATE OR REPLACE FUNCTION
fun_name(param...) 
RETURN return_typeIS
retVal dataType;
BEGIN
plsql statement;
EXCEPTION xx;
END;



/* ====================  ==================== */

/*  */



/* ====================  ==================== */

/*  */


/* ====================  ==================== */

/* 日期时间 */

/*
Oracle标准日期格式：
dd-mon-yy hh:mi:ss
中文格式：
YYYY-MM-DD HH:MI:SS FF1-9
YYYY-MM-DD HH24:MI:SS FF1-9
FF后面跟着数字1-9，是秒的小数部分，最大精度是9
Oracle用7个字节来存储日期时间数据。

*/

 /* 返回Db当前日期时间 */
DATE()

/* 返回当前时区的日期时间 */
TIMESTAMP()

/* ====================  ==================== */

/* 字符函数 */	

String CONCAT(String, String)
/* String对象中第一个字符的ascii码 */
int ASCII(String)
char CHR(int ascii)
/* 单词_首字母_大写,其余小写，单词通过空格、逗号、控制字符来识别 */
String INITCAP(String)
int INSTR(String, String)
int INSTR(String, String, int begin)
/* int appear 出现的位置 */
int INSTR(String, String, int, int appear)
int LENGTH(String)
String LOWER(String)
String UPPER(String)
/* 在列的左边粘贴字符串 */
String LPAD(String)
/* 在列的右边粘贴字符串 */
String RPAD(String)
/* 删除左边出现_字符串 */
String LTRIM(String, String trim_str)
/* 删除右边出现_字符串 */
String RTRIM(String, String trim_str)
String SUBSTR(String, int, int len)
String REPLACE(String, String, String rep_str)
/* 返回与给定str读音相同_字符串 */
String SOUNDER(String)
String TRIM(String)
String TRIM(String, String)
String LEADING(String)
String TRAILING(String)

/* ====================  ==================== */

/* 数字函数 */

double ABS(double)
double ACOS(double)
double ASIN(double)
double ATAN(double)
double SIN(double)
double COS(double)
double TAN(double)
double COSH(double)
double SINH(double)
double TANH(double)
double EXP(double)
int FLOOR(double)
int CEIL(double)
double LN(double)
double LOG(double, double)
int MOD(int, int)
double POWER(double, double)
int ROUND(double)
Number ROUND(double, int)
/* 截取_数字 */
intTRUNC(double)
Number TRUNC(double, int numericSize)
/* -1, 0, 1 */
int SIGN(double)
double SQRT(double)
Date ADD_MONTHS(int)
Date LAST_DATE(Date)
int MONTHS_BETWEEN(Date, Date)
Date NEW_TIME(Date, String, String)
Date NEXT_DAY(Date, Date)
Date NEXT_DAY(String, String)
Date SYSDATE()

/* ====================  ==================== */

/* 转换函数 */
RowId CHARTOROWID(String)
String ROWIDTOCHAR(RowId)
String HEXTOROW(String)
String ROWTOHEXT(String)
String TO_CHAR(Date, String fmt)
例如:
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd') FROM dual;
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd hh:mi:ss') FROM dual;
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd hh24:mi:ss') FROM dual;
String TO_CHAR(Number, String fmt)
SELECT TO_CHAR(123, '999') FROM dual;
Date TO_DATE(String, String fmt)
SELECT TO_DATE('2013-04-19', 'yyyy-mm-dd') FROM dual;
Timestamp TO_TIMESTAMP(String, String fmt)
Number TO_NUMBER(String, String fmt)
SELECT TO_NUMBER('123', '999')  FROM dual;
String TO_MULTI _BYTE(String)
BLOB BFILENAME(String dir, String file)
String CONVERT(????)
String DUMP(String, String fmt, int, int len)


/* ====================  ==================== */

/*  */


/* ====================  ==================== */

/* 

1) CREATE OR REPLACE FUNCTION
fun_name(param...)
RETURN retval
AS / IS
plsql statement;
2) 参数传递方法
①位置表示法：
argument_value, ...
②名称表示法：
argument => parameter,...
③混合表示法：同时采用位置表示、名称表示。
使用位置表示法所传递的参数必须放置在名称表示法的前面，只要有一个参数使用名称表示法，
其他的所有参数都必须采用名称表示法传参。

3) 实际参数与形式参数数据传递方法：
①传址法：将实际参数的地址指针传递给形式参数，使形式参数和实际参数指向内存中的同一区域。

参照法
②传值法：将实际参数的数据拷贝到形式参数，而不是传地址。
4) 可以使用DEFAULT关键字为输入参数指定默认值；不能为输入/输出参数指定默认值。


 */



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































