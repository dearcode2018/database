数据库（MYSQL）:172.16.100.183:3306  cgqm_dev  cgqm/cgqm123

1=====>updated by xujijun on 2014.07.31 am
增加表：T_PRO_Type（商品分类表）
字段定义请参考：省工商流通领域商品监管系统表结构.xlsx -> "商品信息" -> T_PRO_Type（商品分类表）

create table T_PRO_Type
(
   id                   varchar(64) not null comment '商品分类ID',
   No                   varchar(10) not null comment '分类编号',
   Name                 varchar(30) not null comment '分类名称',
   Parent_id            varchar(64) comment '上级分类',
   Order_No             numeric comment '顺序号，显示时的排列顺序',
   status               varchar(10) not null comment '状态 ON:有效，OFF:无效,DEL:删除',
   Creater              varchar(20) not null comment '创建者，当前登录用户姓名',
   Create_DT            timestamp comment '创建时间',
   Updater              varchar(20) comment '更新者，当前登录用户姓名',
   Update_DT            timestamp comment '更新时间',
   primary key (id)
);

<<<<<<< .mine
alter table T_PRO_Type comment '商品分类表';

done by hush

2=====>updated by hush on 2014.08.12 am
修改表：T_SYS_USER（用户）
删除字段：PARENT_ID 父ID
修改字段：MERCHANT_ID 商家ID ＝＝＝＝〉UNIT_ID 单位ID
修改字段：MERCHANT_NAME 商家名称 ＝＝＝＝〉UNIT_NAME 单位名称

alter table `T_SYS_USER`
DROP COLUMN `PARENT_ID`,
CHANGE COLUMN `MERCHANT_ID` `UNIT_ID`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL comment '单位ID' AFTER `USER_TYPE`,
CHANGE COLUMN `MERCHANT_NAME` `UNIT_NAME`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL comment '单位名称' AFTER `UNIT_ID`;

新增表：
T_SYS_IC_ORG（工商组织表）

T_SYS_CHECK_ORG（承检机构表）

done by hush


3===>updated by liujian on 2014.08.19
修改表名：T_SYS_IC_ORG（工商组织表）
改动地方：
1、将 所属区域 改为 上级机构名称(PARENT_ID)
2、创建 联系人(LINKMAN VARCHAR(50))
	  顺序号(ORDER_NO int)	
	  备注(REMARK	VARCHAR(300))
	  
done by hush	  
	  
>>>>>>> .r15305


4=====>updated by hush on 2014.08.22 am
修改表名：T_SYS_USER_LOGIN_LOG（用户登录日志）
改动地方：
创建 登录IP(IP VARCHAR(20))

修改表名：T_SYS_USER_TRAIL_LOG（用户操作日志）
改动地方：
创建 耗时(COST_MS number(10))
     操作IP(IP varchar(20))

	  
done by hush	  

5=====>updated by hush on 2014.09.02 am
修改表：T_PRO_PRODUCT（商品表）
创建：FAIL_STATUS
      DGT_STATUS
 
 cgqm_dev
 cgqm_test     
 
 gzvm152
 
 done by hush     
 
 
6=====>updated by hush on 2014.09.18 am
修改表：T_PRO_PRODUCT_FAIL_MANAGE（不合格商品处理表）
创建：CREATE_TYPE 录入类型 varchar(10)
 
alter table `T_PRO_PRODUCT_FAIL_MANAGE`
add column `CREATE_TYPE`  varchar(10) NOT NULL comment '录入类型\r\nT_SYS_DICT\r\nCLS_CODE:PPFM_CT\r\n工商部门：IC\r\n市场主体：ENT' AFTER `DATA_SRC`;

 cgqm_dev
 cgqm_test     
 
 gzvm152
 
 done by hush
 

6=====>updated by XIAOSHIXIONG on 2014.09.25 am 
新增表
 create table `T_PRO_TEMPDATA` (
`CREATER_ID`  varchar(64) NOT NULL ,
`TYPE`  varchar(10) NOT NULL ,
`DATA`  text NULL ,
PRIMARY KEY (`CREATER_ID`,`TYPE`) ,
foreign key(CREATER_ID) references T_SYS_USER(ID) on delete cascade
)    


/*==============================================================*/
/* Table: T_PRO_TEMPDATA                                        */
/*==============================================================*/
create table T_PRO_TEMPDATA 
(
   CREATER_ID           varchar(64)                    not null,
   TYPE                 varchar(10)                    not null,
   DATA                 long varchar                   null,
   constraint PK_T_PRO_TEMPDATA primary key (CREATER_ID, TYPE),
   foreign key(CREATER_ID) references T_SYS_USER(ID) on delete cascade
);

alter table `T_PRO_TEMPDATA`
modify column `CREATER_ID`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL comment '用户ID' FIRST ,
modify column `TYPE`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL comment '数据类型' AFTER `CREATER_ID`,
modify column `DATA`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL comment '临时数据字符串' AFTER `TYPE`,
comment='用户临时数据表';

alter table `T_PRO_TEMPDATA`
add index `IND_TEMPDATA_CREATEID` (`CREATER_ID`) USING BTREE ;

修改表T_PRO_PRODUCT
新增字段 IF_SHOW_WS 是否公示
         REGION_ID  所属区域

alter table `T_PRO_PRODUCT`
add column `IF_SHOW_WS`  varchar(10) NULL comment '是否公示 1：是，0：否' AFTER `DGT_STATUS`,
add column `REGION_ID`  varchar(64) NULL comment '所属区域 T_SYS_REGION.ID' AFTER `IF_SHOW_WS`;



 cgqm_dev
 cgqm_test     
 
 gzvm152
 
 done by hush
7=====>updated by YEQI on 2014.09.30 am 
 /*==============================================================*/
/* Table: T_ENT_MERCHANT                                        */
/*==============================================================*/
修改表：T_ENT_MERCHANT（经营者表）
修改字段：REGION_ID 约束改为非空约束（不能为空）

 cgqm_dev
 cgqm_test     
 
 gzvm152
 
 done by hush
 
 
 8=====>updated by YEQI on 2014.10.09 am 
 /*==============================================================*/
/* Table: T_PRO_TYPE                                        */
/*==============================================================*/
修改表：T_PRO_TYPE（经营者表）
修改字段：NO 添加唯一约束，不能重复

alter table `T_PRO_TYPE`
DROP INDEX `IDX_NO` ,
ADD UNIQUE INDEX `IDX_NO` (`NO`) USING BTREE ;

 cgqm_dev
 cgqm_test     
 
 gzvm152
 
 done by hush
 
9=====>updated by xsx on 2014.10.09 am 
alter table `T_PRO_PRODUCT_RESULT`
ADD UNIQUE INDEX `IDX_PRODUCT_RESULT_REPORT_NO` (`REPORT_NO`) USING BTREE ;

 cgqm_dev
 cgqm_test     
 
 gzvm152
 
 done by hush

10=====>updated by zhengqianye on 2014.11.04 am
/* T_SYS_CHECK_ORG（承检机构表）删除列 */
alter table T_SYS_CHECK_ORG DROP CERTIFICATES;
alter table T_SYS_CHECK_ORG DROP CP_TYPE_ID;

/* 创建 T_SYS_CERTIFICATE（资质证书表） */
create table T_SYS_CERTIFICATE (
  ID varchar(64) not null comment '表主键',
  NAME varchar(64) comment '资质证书名称',
  NO varchar(64) comment '资质证书号码',
  ACCEPT_PRODUCTS varchar(1024) comment '可接受委托检验的商品',
  CHECK_ORG_ID varchar(64) comment '承检机构ID - 对应T_SYS_CHECK_ORG.ID，级联删除',
  primary key (ID)
);
/* 添加 - 表注释 */
alter table `T_SYS_CERTIFICATE` comment '资质证书表';
/* 添加外键约束 */
alter table `T_SYS_CERTIFICATE` add constraint `FK_CERTIFICATE_CHECK_ORG_ID` foreign key (`CHECK_ORG_ID`) references `T_SYS_CHECK_ORG` (`ID`) on delete cascade;

/* 创建 T_PUBLISH_ANNOUNCEMENT 公告管理 */
create table T_PUBLISH_ANNOUNCEMENT
(
   ID  varchar(64) not null,
   TITLE varchar(200) not null comment '公告标题',
   CONTENT text not null comment '公告内容',
   RELATIVE_PATHS varchar(1024) comment '附件相对路径 多个路径用 逗号 隔开(10个附件)',
   OWNER varchar(64) not null comment '归属者 对应T_SYS_USER表中的CODE字段',
   STATUS varchar(10) comment 'SHOWN-公示，HIDDEN-不公示',
   VIEW_COUNT NUMERIC DEFAULT 0 comment '浏览次数 浏览次数(仅限公示平台浏览)',
   IS_STICKY varchar(10) comment 'T_SYS_DICT CLS_CODE:ANNOUNCEMENT_IS_STICKY NO-不置顶、YES-置顶',
   IS_IMPORTANT varchar(10) comment 'T_SYS_DICT CLS_CODE:ANNOUNCEMENT_IS_IMPORTANT NO-不重要、YES-重要',
   CREATER  varchar(20) not null comment '创建者',
   CREATE_DT timestamp not null comment '创建时间',
   UPDATER  varchar(20) comment '更新者',
   UPDATE_DT timestamp comment '更新时间',
   primary key (ID)
);
/* 添加 - 表注释 */
alter table T_PUBLISH_ANNOUNCEMENT comment '信息发布-公告管理';  

/* 创建 T_PUBLISH_SERVICE_GUIDE 信息发布-办事指南 */
create table T_PUBLISH_SERVICE_GUIDE
(
   ID  varchar(64) not null,
   TITLE varchar(200) not null comment '标题',
   RELATIVE_PATH varchar(256) comment '附件相对路径',
   STATUS varchar(10) comment 'SHOWN-公示，HIDDEN-不公示',
   REMARK varchar(1024) comment '备注',
   CREATER  varchar(20) not null comment '创建者',
   CREATE_DT timestamp not null comment '创建时间',
   UPDATER  varchar(20) comment '更新者',
   UPDATE_DT timestamp comment '更新时间',
   primary key (ID)
);
/* 添加 - 表注释 */
alter table T_PUBLISH_SERVICE_GUIDE comment '信息发布-办事指南';  

/* 创建 T_SYS_CERTIFICATE（资质证书表） */
create table T_SYS_CERTIFICATE (
  ID varchar(64) not null comment '表主键',
  NAME varchar(64) comment '资质证书名称',
  NO varchar(64) comment '资质证书号码',
  ACCEPT_PRODUCTS varchar(1024) comment '可接受委托检验的商品',
  CHECK_ORG_ID varchar(64) comment '承检机构ID - 对应T_SYS_CHECK_ORG.ID，级联删除',
  primary key (ID)
);
/* 添加 - 表注释 */
alter table T_SYS_CERTIFICATE comment '资质证书表';  
/* 添加外键约束 */
alter table T_SYS_CERTIFICATE add CONSTRAINT  foreign key(CHECK_ORG_ID) references T_SYS_CHECK_ORG(ID)  on delete cascade;

/* 创建 T_SYS_CERTIFICATE_ATTACH 资质证书附件表 */
create table T_SYS_CERTIFICATE_ATTACH
(
	ID  varchar(64) not null,
	CERTIFICATE_ID varchar(64) comment '证书id（保留字段）',
	RELATIVE_PATH varchar(150) comment '单个附件的相对路径',
	CHECK_ORG_ID varchar(64) comment '承检机构ID - 对应T_SYS_CHECK_ORG.ID，级联删除',
	primary key (ID)
);
/* 添加 - 表注释 */
alter table T_SYS_CERTIFICATE_ATTACH comment '资质证书附件表';  


cgqm_dev
cgqm_test
gzvm152
 
done by zhengqianye 

11=====>updated by zhengqianye on 2014.11.05 pm
/* 新增一个字段 */
alter table T_ENT_MERCHANT_MNG_RANGE add column DATA_SRC VARCHAR(10) comment 'T_SYS_DICT CLS_CODE: 经营者：ENT 工商：IC';

/* 更新值 */
update T_ENT_MERCHANT_MNG_RANGE A set A.DATA_SRC = 'IC';

cgqm_dev
cgqm_test
gzvm152

done by hush 


12=====>updated by xiaoshixiong on 2014.11.07 am

alter table `T_PRO_PRODUCT`
add column `SHOW_DT`  timestamp NULL comment '公示时间';

cgqm_dev
cgqm_test
gzvm152
done by xiaoshixiong 


13=====>updated by zhengqianye on 2014.11.11 am
alter table `T_ENT_MERCHANT` add column `RANGE_CONFIRM_STATUS`  VARCHAR(10) NULL 
comment '自主标注范围确认状态 T_SYS_DICT CLS_CODE: RANGE_CONFIRM_STATUS已确认(CONFIRMED)、未确认(UNCONFIRM), 无须确认(NULL)';

cgqm_dev
cgqm_test
gzvm152

done by zhengqianye 



