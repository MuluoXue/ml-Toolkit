package com.ml.toolkit.mybatis.plus.base;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * 通用mapper
 * @author ml
 */
public interface BaseDao <T extends Serializable>  extends BaseMapper<T> {

    /**
     * 批量插入
     * @param batchList 批量插入数据
     * @return 数量
     */
    int insertBatchSomeColumn(@Param("list") List<T> batchList);
}
