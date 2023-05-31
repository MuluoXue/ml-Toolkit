package com.toolkit.sql.conversion.util;

import com.toolkit.sql.conversion.enums.SqlType;
import com.toolkit.sql.conversion.exception.SqlConversionException;

import java.io.Serializable;

/**
 * sql类型帮助类
 */
public class SqlTypeUtil implements Serializable {
    private static final long serialVersionUID = -6808125771758519888L;

    /**
     * 获取sql类型
     * @param sql sql
     * @return sqlType
     */
    public static SqlType findSqlType(String sql) {
        //sql 转换大写
        String upperCaseSql = sql.toUpperCase();

        if (upperCaseSql.startsWith(SqlType.INSERT.toString())) {
            return SqlType.INSERT;
        } else if (upperCaseSql.startsWith(SqlType.UPDATE.toString())) {
            return SqlType.UPDATE;
        } else if (upperCaseSql.startsWith(SqlType.DELETE.toString())) {
            return SqlType.DELETE;
        } else if (upperCaseSql.startsWith(SqlType.INSERT.toString())) {
            return SqlType.INSERT;
        }
        throw new SqlConversionException("Unknown statement type");
    }
}
