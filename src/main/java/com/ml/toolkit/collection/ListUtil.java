package com.ml.toolkit.collection;

import com.ml.toolkit.util.ObjectUtil;

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

    /**
     * 将一个数组拆分为多个数组
     *
     * @param list      原数据
     * @param splitSize 拆分后一个数组大小
     * @param <T>       枚举
     * @return List<List < T>
     */
    public static <T> List<List<T>> partition(List<T> list, int splitSize) {
        List<List<T>> result = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(list) && splitSize > 0) {
            if (list.size() <= splitSize) {
                result.add(list);
            } else {
                int splitNum = (list.size() % splitSize) == 0 ? (list.size() / splitSize) : (list.size() / splitSize + 1);
                for (int i = 0; i < splitNum; i++) {
                    if (i < splitNum - 1) {
                        result.add(list.subList(i * splitSize, (i + 1) * splitSize));
                    } else {
                        //最后一组
                        result.add(list.subList(i * splitSize, list.size()));
                    }
                }
            }
        }
        return result;
    }

    /**
     * 判断list是否为空
     * @param list 参数
     * @return boolean
     */
    public static boolean isEmpty(List<?> list) {
        return null == list || list.isEmpty();
    }
}
