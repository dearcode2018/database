/* mysql-example */

/*
描述:

包含:


*/

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
	
/* 本周(周一 -  周日)录入的数据不动，只把上一周的数据迁移到本周(每个 周一凌晨 执行一次该语句) */
/* 周一 为每周的第一天 */
update T_PRO_DAILY_RECIPE A SET A.DT = ADDDATE(A.DT, 7)
where YEARWEEK(A.DT, 1) = YEARWEEK(NOW(), 1) - 1;

/* 回退 - 语句 (一般情况不同执行，数据有误，可执行回退) */
update T_PRO_DAILY_RECIPE A SET A.DT = ADDDATE(A.DT, 7)
where YEARWEEK(A.DT, 1) = YEARWEEK(NOW(), 1) + 1;


/* 每日菜谱 (上一周) - 用于回退 */
update T_PRO_DAILY_RECIPE A SET A.DT = ADDDATE(A.DT, -7);

/* 每日菜谱 (下一周) */
update T_PRO_DAILY_RECIPE A SET A.DT = ADDDATE(A.DT, 7);

/* mysql不支持 直接这样写  */
update T_ENT_VIDEO_FIXTURE A  set A.`STATUS`='OFF' where EXISTS (select 1 from T_ENT_VIDEO_FIXTURE C LEFT JOIN T_ENT_MERCHANT B  on (B.ID = C.MERCHANT_ID) where C.STATUS = 'ON' and  B.INDUSTRY='SCH'); 

/* 对同一张表，不支持使用 exists或not exists，应该改为在 exists字句中使用视图的方式 ((select * from T_ENT_VIDEO_FIXTURE) C) */
/* 由于两张表没有直接建立关联，因此需要通过 in 来实现条件；另外，左外连接需要考虑左表的所有数据都会被查出来, 右表没有匹配的记录左表字段为空，因此where条件不起作用，需要慎重考虑 */
update T_ENT_VIDEO_FIXTURE A  
set A.`STATUS`='OFF' 
where  A.ID in (select C.ID from (select * from T_ENT_VIDEO_FIXTURE) C LEFT JOIN T_ENT_MERCHANT B  on (B.ID = C.MERCHANT_ID and C.STATUS = 'ON') where B.INDUSTRY='SCH'); 

