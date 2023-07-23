package com.ml.toolkit.dao.sql;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ml
 * @date 2022年12月21日 21:48
 */
@Mapper
public interface SqlExecutionDao{

    void execute(@Param("sql") String sql);

}
