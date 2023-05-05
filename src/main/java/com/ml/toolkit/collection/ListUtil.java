package com.ml.toolkit.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * list 帮助类
 * @author ml
 * @date 2023年04月24日 19:39
 */
public class ListUtil implements Serializable {
    private static final long serialVersionUID = -7225327109027153152L;

    /**
     * 列表对象转指定泛型列表
     * 支持 lambda表达式
     * @param list : 任意类型List
     * @param func : 需要执行的方法
     * @param <T> : 列表对象泛型
     * @param <R> : 返回数据泛型
     * @return java.util.List
     */
    public static <T, R> List<R> listToList(List<T> list, Function<T, R> func) {
        List<R> res = new ArrayList<>();
        for (T t : list) {
            res.add(func.apply(t));
        }
        return res;
    }
}
