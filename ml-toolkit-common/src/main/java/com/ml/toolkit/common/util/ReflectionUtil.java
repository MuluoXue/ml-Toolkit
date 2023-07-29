package com.ml.toolkit.common.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java反射工具类
 */
public class ReflectionUtil implements Serializable {

    private static final long serialVersionUID = -6514884388637072247L;

    /**
     * 获取一个类的所有字段
     *
     * @param aClass 类
     * @param containParent 是否包含父类
     * @return list
     */
    public static List<Field> getDeclaredFields(Class<?> aClass, boolean containParent ) {
        List<Field> list = new ArrayList<>();
        if (aClass != null) {
            if (containParent) {
                list.addAll(getDeclaredFields(aClass.getSuperclass(), true));
            }
            list.addAll(Arrays.asList(aClass.getDeclaredFields()));
        }
        return list;
    }

    /**
     * 是否是基础类型，或者包装类
     * @param type 类型
     * @return true/false
     */
    public static boolean isWrapperType(Class<?> type) {
        return type.isPrimitive() || isPrimitiveWrapper(type);
    }

    /**
     * 是否是基础类型的包装类型
     * @param type 类型
     * @return true/false
     */
    private static boolean isPrimitiveWrapper(Class<?> type) {
        return type == Byte.class ||
                type == Short.class ||
                type == Integer.class ||
                type == Long.class ||
                type == Float.class ||
                type == Double.class ||
                type == Character.class ||
                type == Boolean.class;
    }
}
