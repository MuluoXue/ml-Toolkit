package com.ml.toolkit.util;

import com.ml.toolkit.collection.ListUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author ml
 * @date 2023年05月05日 22:44
 */
public class ObjectUtil implements Serializable {

    private static final long serialVersionUID = -8114685904089593513L;

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     * @param obj 对象
     * @return boolean
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return StringUtil.isEmpty((CharSequence) obj);
        }
        if (obj instanceof Map) {
            return MapUtil.isEmpty((Map) obj);
        }
        if (obj instanceof List) {
            return ListUtil.isEmpty((List) obj);
        }
        return false;
    }

    /**
     * todo 待优化
     * 转成String
     *
     * @return String
     */
    public static String toString(Object obj) {
        if (null == obj) {
            return StringUtil.NULL;
        }
        return String.valueOf(obj);

    }

}
