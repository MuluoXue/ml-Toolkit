package com.ml.toolkit.common.util;

import java.io.Serializable;
import java.util.Map;

/**
 * @author ml
 * @date 2023年05月05日 23:03
 */
public class MapUtil implements Serializable {

    private static final long serialVersionUID = -4470557969031885025L;

    /**
     * 判断map是否为空
     * @param obj map对象
     * @return boolean
     */
    public static boolean isEmpty(Map<?,?> obj) {
        return null == obj || obj.isEmpty();
    }
}
