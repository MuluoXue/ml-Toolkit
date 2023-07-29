package com.ml.toolkit.common.util;

/**
 * 字符串判断
 * @author ml
 * @date 2023年05月05日 22:52
 */
public class StringUtil {

    /**
     * 字符串转化默认信息
     */
    public static final String NULL = "null";

    /**
     * 判断字符串是否为空
     * isEmpty(null)  return true;
     * isEmpty("") return true;
     * isEmpty("aaa") return false;
     * @param str 字符串
     * @return true/false
     */
    public static boolean isEmpty(CharSequence str) {
        return null == str || str.length() == 0;
    }

    /**
     * 判断字符串是否为空
     * @return true: 不为空 false:为空
     */
    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }

    /**
     * 将驼峰模式转换为下划线方式展示
     * @param str 内容
     * @return 转换后的结果
     */
    public static String camelCaseToUnderscore(String str) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return str.replaceAll(regex, replacement).toLowerCase();
    }
}
