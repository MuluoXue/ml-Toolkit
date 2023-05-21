package com.ml.toolkit.common.util;


import java.io.Serializable;

public class Assert implements Serializable {

    /**
     * 为空断言
     * 任一一个为空的的时候会抛出异常
     * @param errorMsg 错误提示语
     * @param params 参数
     */
    public static void notEmpty(String errorMsg, Object ...params) {
        notEmpty(true, errorMsg, params);
    }

    /**
     * 为空断言
     * @param checkOutAll 是否校验所有
     *                    true：任一一个为空的的时候会抛出异常
     *                    false: 只要有一个不为空就不会抛出异常
     * @param errorMsg 错误提示语
     * @param params 参数
     */
    public static void notEmpty(boolean checkOutAll, String errorMsg, Object ...params) {
        if (ObjectUtil.isEmpty(params)) {
            throw new RuntimeException(errorMsg);
        }
        for (Object param : params) {
            if (ObjectUtil.isEmpty(param)) {
                if (checkOutAll) {
                    throw new RuntimeException(errorMsg);
                }
            } else {
                break;
            }
        }
    }
}
