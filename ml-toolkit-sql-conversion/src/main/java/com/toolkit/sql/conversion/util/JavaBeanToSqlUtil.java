package com.toolkit.sql.conversion.util;

import com.ml.toolkit.common.util.ObjectUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

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
        tableName = tableName.toLowerCase(Locale.ROOT);

        List<Field> list = new ArrayList<>();
        list.addAll(getField(aClass.getSuperclass(), true));
        list.addAll(getField(aClass, false));

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

        return tableName;
    }

    private static List<Field> getField(Class<?> aClass, boolean containParent ) {
        List<Field> list = new ArrayList<>();
        if (aClass != null && containParent) {
            list.addAll(Arrays.asList(aClass.getDeclaredFields()));
            getField(aClass.getSuperclass(), containParent);
        }
        return list;
    }

    private static String fileToSql(Field field) {
        String name = field.getName();
        if ("serialVersionUID".equals(name)) {
            return "";
        }
        field.setAccessible(true);

        return "`" + convertFileName(field.getName()) + "` " + findType(field.getType()) + findIsNull(field.getName()) + " COMMENT '',\n";
    }

    private static String findIsNull(String name) {
        return "id".equalsIgnoreCase(name) ? " NOT NULL" : " DEFAULT NULL";
    }

    private static String convertFileName(String input) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return input.replaceAll(regex, replacement).toLowerCase();
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
