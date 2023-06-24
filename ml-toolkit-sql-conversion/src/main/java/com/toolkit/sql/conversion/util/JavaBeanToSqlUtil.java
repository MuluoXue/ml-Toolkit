package com.toolkit.sql.conversion.util;

import com.ml.toolkit.common.util.ObjectUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JavaBeanToSqlUtil implements Serializable {

    private static final long serialVersionUID = -8649054165184802202L;

    /**
     * java bean 转sql
     *
     * @param obj       javaBean 对象
     * @param tableName table名称
     * @return 建表语句
     */
    public static String toCreateSql(Object obj, String tableName) {
        Class<?> aClass = obj.getClass();
        if (ObjectUtil.isEmpty(tableName)) {
            tableName = aClass.getSimpleName();
        }

        List<Field> list = new ArrayList<>();
        while (aClass != null) {
            list.addAll(Arrays.asList(aClass.getDeclaredFields()));
            aClass = aClass.getSuperclass();
        }

        if (ObjectUtil.isNotEmpty(list)) {
            StringBuilder createSql = new StringBuilder("CREATE TABLE `demo_log`\n" +
                    "(\n");
            for (Field declaredField : list) {
                createSql.append(fileToSql(declaredField));
            }
            createSql.append(" PRIMARY KEY (`id`)\n" +
                    ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT=''");
            return createSql.toString();
        }

        return tableName;
    }

    private static String fileToSql(Field field) {
        String name = field.getName();
        if ("serialVersionUID".equals(name)) {
            return "";
        }
        field.setAccessible(true);

        return "`" + field.getName() + "` " + findType(field.getType()) + " DEFAULT NULL COMMENT '',\n";
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
