package com.toolkit.sql.conversion.util;

import com.toolkit.sql.conversion.exception.SqlConversionException;
import com.toolkit.sql.conversion.generate.CreateSql;
import com.toolkit.sql.conversion.generate.InsertSql;

import java.io.Serializable;

public class JavaBeanToSqlUtil implements Serializable {

    private static final long serialVersionUID = -8649054165184802202L;

    public static String toInsertSql(Object obj, String tableName) throws SqlConversionException {
        try {
            InsertSql sql = new InsertSql();
            return sql.generate(obj, tableName);
        } catch (Exception e) {
            e.printStackTrace();
//            log.error("toInsertSql error ", e);
            throw new SqlConversionException();
        }
    }

    /**
     * java bean 转sql
     *
     * @param obj       javaBean 对象
     * @param tableName table名称
     * @return 建表语句
     */
    public static String toCreateSql(Object obj, String tableName) {
        try {
            CreateSql sql = new CreateSql();
            return sql.generate(obj, tableName);
        } catch (Exception e) {
            e.printStackTrace();
//            log.error("createSql error ", e);
            throw new SqlConversionException();
        }
    }
}
