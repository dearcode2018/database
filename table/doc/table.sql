
/* 数据表类型 - jdbc 类型 探查 */
CREATE TABLE tb_col_type (
	id NUMBER(38),
	sex char(2) default 'M',
	name VARCHAR2(100),
	age NUMBER(3, 0),
	salary NUMBER(7, 2),
	datetime DATE,
	ts TIMESTAMP,
	b_blob BLOB,
	b_clob CLOB
);
















