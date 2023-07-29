package com.toolkit.sql.conversion.util;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 字段帮助类
 */
public class FieldUtil implements Serializable {
    private static final long serialVersionUID = 1606590798139840736L;

    //忽略的字段名称
    private static final List<String> ignoreFieldNameList = Collections.singletonList("serialVersionUID");

    /**
     * 是否忽略字段
     * @param fieldName 字段名称
     * @return true/false
     */
    public static boolean isIgnore(String fieldName) {
        return ignoreFieldNameList.contains(fieldName);
    }
}
