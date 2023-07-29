package com.toolkit.sql.conversion.generate;

/**
 * 生成方法
 */
public abstract class GenerateAbstract {

    abstract public String generate(Object obj,String tableName) throws Exception;
}
