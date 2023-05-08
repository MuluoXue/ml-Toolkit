package com.ml.toolkit.mybatis.plus.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;

/**
 * SQL 注入器
 * @author ml
 * @date 2023年05月06日 23:46
 */
public class InsertBatchSqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        // super.getMethodList() 保留 Mybatis Plus 自带的方法
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        // 添加自定义方法：批量插入，方法名为 insertBatchSomeColumn, 这个方法名不能改变
        methodList.add(new InsertBatchSomeColumn());
        return methodList;
    }
}
