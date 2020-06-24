package com.hua.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

@EqualsAndHashCode(callSuper = true)
@ToString
@Table(name = "query_example")
public class QueryExample extends DynamicTableEntity implements Serializable {
    /**
     * 主键-自增长
     */
    @Id
    @KeySql(dialect = IdentityDialect.MYSQL)
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer id;

    /**
     * 定长字符串
     */
    @Column(name = "char_type")
    @ColumnType(jdbcType = JdbcType.CHAR)
    private String charType;

    /**
     * 变长字符串
     */
    @Column(name = "varchar_type")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String varcharType;

    /**
     * decimal类型，指定小数位数
     */
    @Column(name = "decimal_type")
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private BigDecimal decimalType;

    /**
     * 整型类型
     */
    @Column(name = "int_type")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer intType;

    /**
     * 枚举类
     */
    @Column(name = "enum_type")
    @ColumnType(jdbcType = JdbcType.CHAR)
    private String enumType;

    /**
     * 位类型
     */
    @Column(name = "bit_type")
    @ColumnType(jdbcType = JdbcType.BIT)
    private Boolean bitType;

    /**
     * 时间戳类型
     */
    @Column(name = "timestamp_type")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime timestampType;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String CHAR_TYPE = "charType";

    public static final String DB_CHAR_TYPE = "char_type";

    public static final String VARCHAR_TYPE = "varcharType";

    public static final String DB_VARCHAR_TYPE = "varchar_type";

    public static final String DECIMAL_TYPE = "decimalType";

    public static final String DB_DECIMAL_TYPE = "decimal_type";

    public static final String INT_TYPE = "intType";

    public static final String DB_INT_TYPE = "int_type";

    public static final String ENUM_TYPE = "enumType";

    public static final String DB_ENUM_TYPE = "enum_type";

    public static final String BIT_TYPE = "bitType";

    public static final String DB_BIT_TYPE = "bit_type";

    public static final String TIMESTAMP_TYPE = "timestampType";

    public static final String DB_TIMESTAMP_TYPE = "timestamp_type";

    /**
     * 获取主键-自增长
     *
     * @return id - 主键-自增长
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键-自增长
     *
     * @param id 主键-自增长
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取定长字符串
     *
     * @return char_type - 定长字符串
     */
    public String getCharType() {
        return charType;
    }

    /**
     * 设置定长字符串
     *
     * @param charType 定长字符串
     */
    public void setCharType(String charType) {
        this.charType = charType == null ? null : charType.trim();
    }

    /**
     * 获取变长字符串
     *
     * @return varchar_type - 变长字符串
     */
    public String getVarcharType() {
        return varcharType;
    }

    /**
     * 设置变长字符串
     *
     * @param varcharType 变长字符串
     */
    public void setVarcharType(String varcharType) {
        this.varcharType = varcharType == null ? null : varcharType.trim();
    }

    /**
     * 获取decimal类型，指定小数位数
     *
     * @return decimal_type - decimal类型，指定小数位数
     */
    public BigDecimal getDecimalType() {
        return decimalType;
    }

    /**
     * 设置decimal类型，指定小数位数
     *
     * @param decimalType decimal类型，指定小数位数
     */
    public void setDecimalType(BigDecimal decimalType) {
        this.decimalType = decimalType;
    }

    /**
     * 获取整型类型
     *
     * @return int_type - 整型类型
     */
    public Integer getIntType() {
        return intType;
    }

    /**
     * 设置整型类型
     *
     * @param intType 整型类型
     */
    public void setIntType(Integer intType) {
        this.intType = intType;
    }

    /**
     * 获取枚举类
     *
     * @return enum_type - 枚举类
     */
    public String getEnumType() {
        return enumType;
    }

    /**
     * 设置枚举类
     *
     * @param enumType 枚举类
     */
    public void setEnumType(String enumType) {
        this.enumType = enumType == null ? null : enumType.trim();
    }

    /**
     * 获取位类型
     *
     * @return bit_type - 位类型
     */
    public Boolean getBitType() {
        return bitType;
    }

    /**
     * 设置位类型
     *
     * @param bitType 位类型
     */
    public void setBitType(Boolean bitType) {
        this.bitType = bitType;
    }

    /**
     * 获取时间戳类型
     *
     * @return timestamp_type - 时间戳类型
     */
    public LocalDateTime getTimestampType() {
        return timestampType;
    }

    /**
     * 设置时间戳类型
     *
     * @param timestampType 时间戳类型
     */
    public void setTimestampType(LocalDateTime timestampType) {
        this.timestampType = timestampType;
    }
}