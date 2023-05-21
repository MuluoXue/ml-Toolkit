package com.ml.toolkit.common.util;


import java.io.Serializable;

public class Assert implements Serializable {

    /**
     * 为空断言
     * @param errorMsg 错误提示语
     * @param params 参数
     */
    public static void notEmpty(String errorMsg, Object ...params) {
        for (Object param : params) {
            if (ObjectUtil.isEmpty(param)) {
                throw new RuntimeException(errorMsg);
            }
        }
    }
}
