package com.ml.toolkit.form.service.form.field;

import com.ml.toolkit.form.domain.FormField;
import com.ml.toolkit.form.domain.form.table.FormTable;
import com.ml.toolkit.form.dto.form.field.FormFieldDto;
import com.ml.toolkit.form.exception.FormException;
import com.ml.toolkit.mybatis.plus.base.BaseService;

import java.util.List;

/**
 * formField Service
 *
 */
public interface FormFieldService extends BaseService<FormField> {

    /**
     * 批量保存字段
     * @param list list
     */
    void batchSave(List<FormFieldDto> list, Long formId) throws FormException;
}
