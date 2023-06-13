package com.ml.toolkit.log.dao;

import com.ml.toolkit.log.domain.BaseLog;
import com.ml.toolkit.mybatis.plus.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseLogDao extends BaseDao<BaseLog> {

}
