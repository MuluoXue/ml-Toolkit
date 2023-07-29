package com.toolkit.sql.conversion.generate;

import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.common.util.ReflectionUtil;
import com.ml.toolkit.common.util.StringUtil;
import com.toolkit.sql.conversion.util.FieldUtil;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 通过java bean 生成建表sql
 */
public class CreateSql extends GenerateAbstract{
    @Override
    public String generate(Object obj, String tableName) throws RuntimeException {
        Class<?> aClass = obj.getClass();
        if (ObjectUtil.isEmpty(tableName)) {
            tableName = aClass.getSimpleName();
        }
        tableName = tableName.toLowerCase(Locale.ROOT);

        List<Field> list = ReflectionUtil.getDeclaredFields(aClass, true);

        if (ObjectUtil.isNotEmpty(list)) {
            StringBuilder createSql = new StringBuilder("CREATE TABLE `" + tableName + "`\n" +
                    "(\n");
            for (Field declaredField : list) {
                createSql.append(fileToSql(declaredField));
            }
            createSql.append(" PRIMARY KEY (`id`)\n" +
                    ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT=''");
            return createSql.toString();
        }

        return "";
    }

    private static String fileToSql(Field field) {
        String name = field.getName();
        if (FieldUtil.isIgnore(name)) {
            return "";
        }
        field.setAccessible(true);

        return "`" + StringUtil.camelCaseToUnderscore(field.getName()) + "` " + findType(field.getType()) + findIsNull(field.getName()) + " COMMENT '',\n";
    }

    private static String findIsNull(String name) {
        return "id".equalsIgnoreCase(name) ? " NOT NULL" : " DEFAULT NULL";
    }

    private static String findType(Class<?> type) {
        if (type == String.class) {
            return "varchar(50)";
        } else if (type == Long.class || type == long.class) {
            return "decimal(20,0)";
        } else if (type == Date.class) {
            return "datetime";
        }
        return "";
    }
}
