package com.ml.toolkit.form.dao;

import com.ml.toolkit.form.domain.FormTable;
import com.ml.toolkit.mybatis.plus.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ml
 * @date 2023年05月06日 22:50
 */
@Mapper
public interface FormTableDao extends BaseDao<FormTable> {

    /**
     * 创建基础结构表
     * @param physicsName 物理表数据库名称
     */
    void createBaseFormTable(@Param("physicsName") String physicsName);
}
