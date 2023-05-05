package com.ml.toolkit.util;

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
}
