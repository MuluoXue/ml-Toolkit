package com.ml.toolkit.log.dao;

import com.ml.toolkit.log.domain.BaseLog;
import com.ml.toolkit.mybatis.plus.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BaseLogDao extends BaseDao<BaseLog> {

    void insertCustomTableName(@Param("tableName") String tableName, @Param("baseLog") BaseLog baseLog);
}
