package com.ml.toolkit.util;

import java.util.Map;

/**
 * @author ml
 * @date 2023年05月05日 23:03
 */
public class MapUtil {

    /**
     * 判断map是否为空
     * @param obj map对象
     * @return boolean
     */
    public static boolean isEmpty(Map<?,?> obj) {
        return null == obj || obj.isEmpty();
    }
}
