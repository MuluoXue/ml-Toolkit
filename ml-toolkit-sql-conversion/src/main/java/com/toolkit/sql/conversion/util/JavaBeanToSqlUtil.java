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

        return "";
    }

    public static String toInsertSql(Object obj, String tableName) throws IllegalAccessException, NoSuchFieldException {
        StringBuilder str = new StringBuilder("INSERT INTO ");
        Class<?> aClass = obj.getClass();
        if (ObjectUtil.isEmpty(tableName)) {
            tableName = aClass.getSimpleName();
        }
        tableName = tableName.toLowerCase(Locale.ROOT);
        str.append(tableName).append(" form (");

        List<Field> list = new ArrayList<>();
        list.addAll(getField(aClass.getSuperclass(), true));
        list.addAll(getField(aClass, false));

        StringBuilder fieldSql = new StringBuilder();
        StringBuilder valueSql = new StringBuilder();
        if (ObjectUtil.isNotEmpty(list)) {
            for (Field declaredField : list) {
                declaredField.setAccessible(true);
                Object objValue = declaredField.get(obj);
                if (ObjectUtil.isNotEmpty(objValue)) {
                    String name = declaredField.getName();
                    if ("serialVersionUID".equals(name)) {
                        continue;
                    }
                    if ("creator".equals(name)) {
                        Class<?> type = objValue.getClass();
                        Field idField  = type.getDeclaredField("id");
                        idField.setAccessible(true);
                        objValue = idField.get(objValue);
                        System.out.println(objValue);
                    }
                    fieldSql.append(convertFileName(name)).append(", ");
                    valueSql.append(objValue).append(", ");
                }
            }
        }
        if (ObjectUtil.isNotEmpty(fieldSql)) {
            str.append(fieldSql.substring(0,fieldSql.length() -2));
        }
        str.append(") VALUES (");
        if (ObjectUtil.isNotEmpty(valueSql)) {
            str.append(valueSql.substring(0,valueSql.length() -2));
        }
        str.append(" ); \n");

        //6228948461889469752, '234', 1, null, null);
        return str.toString();
    }

    private static List<Field> getField(Class<?> aClass, boolean containParent ) {
        List<Field> list = new ArrayList<>();
        if (aClass != null) {
            list.addAll(Arrays.asList(aClass.getDeclaredFields()));
            if (containParent) {
                getField(aClass.getSuperclass(), containParent);
            }
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
