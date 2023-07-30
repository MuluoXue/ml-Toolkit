package com.toolkit.sql.conversion.generate;

import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.common.util.ReflectionUtil;
import com.ml.toolkit.common.util.StringUtil;
import com.toolkit.sql.conversion.util.FieldUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 根据java bean 内容生成 新增sql
 * 主要用于数据导出为sql使用
 */
public class InsertSql extends GenerateAbstract implements Serializable {
    private static final long serialVersionUID = 7500861887008165035L;

    @Override
    public String generate(Object obj, String tableName) throws Exception {
        StringBuilder str = new StringBuilder("INSERT INTO ");
        Class<?> aClass = obj.getClass();
        if (ObjectUtil.isEmpty(tableName)) {
            tableName = StringUtil.camelCaseToUnderscore(aClass.getSimpleName());
        }
        tableName = tableName.toLowerCase(Locale.ROOT);
        str.append(tableName).append(" (");
        List<Field> list = ReflectionUtil.getDeclaredFields(aClass, true);

        StringBuilder fieldSql = new StringBuilder();
        StringBuilder valueSql = new StringBuilder();
        if (ObjectUtil.isNotEmpty(list)) {
            for (Field field : list) {
                field.setAccessible(true);
                Object objValue = field.get(obj);
                if (ObjectUtil.isNotEmpty(objValue)) {
                    String name = field.getName();
                    if (FieldUtil.isIgnore(name)) {
                        continue;
                    }
                    Class<?> type = objValue.getClass();
                    if (!ReflectionUtil.isWrapperType(type) && type != Date.class && type != String.class) {
                        try {
                            Field idField = type.getDeclaredField("id");
                            idField.setAccessible(true);
                            objValue = idField.get(objValue);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    fieldSql.append(StringUtil.camelCaseToUnderscore(name)).append(", ");
                    valueSql.append(findValue(objValue)).append(", ");
                }
            }
        }
        if (ObjectUtil.isNotEmpty(fieldSql)) {
            str.append(fieldSql.substring(0, fieldSql.length() - 2));
        }
        str.append(") VALUES (");
        if (ObjectUtil.isNotEmpty(valueSql)) {
            str.append(valueSql.substring(0, valueSql.length() - 2));
        }
        str.append(" ); \n");

        return str.toString();
    }

    private String findValue(Object value) {
        Class<?> aClass = value.getClass();
        if (aClass == String.class) {
            return "'" + value + "'";
        } else if (aClass == Date.class) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return "'" + format.format(value) + "'";
        } else {
            return String.valueOf(value);
        }
    }
}
