package com.ml.toolkit.form.service.form.table;

import com.ml.toolkit.form.domain.form.table.FormTable;
import com.ml.toolkit.mybatis.plus.base.BaseService;

/**
 * formTable Service
 *
 */
public interface FormTableService extends BaseService<FormTable> {

    /**
     * 创建基础表结构
     * @param physicsName 表单名称
     */
    void createBaseFormTable(String physicsName );
}
