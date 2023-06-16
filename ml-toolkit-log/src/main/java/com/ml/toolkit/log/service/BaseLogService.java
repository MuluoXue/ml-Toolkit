package com.ml.toolkit.log.service;

import com.ml.toolkit.log.domain.BaseLog;
import com.ml.toolkit.mybatis.plus.base.BaseService;

public interface BaseLogService extends BaseService<BaseLog> {

    /**
     * 自定义表名 新增日志
     * @param tableName 表单名称
     * @param baseLog 日志详情
     */
    void saveCustomTableName(String tableName, BaseLog baseLog);
}
