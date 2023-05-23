package com.ml.toolkit.form.service;

import com.ml.toolkit.form.domain.Form;
import com.ml.toolkit.mybatis.plus.base.BaseService;

/**
 * @author ml
 * @date 2023年05月11日 20:34
 */
public interface FormService extends BaseService<Form> {
    /**
     * 保存表单
     */
    void saveForm(Form form);
}
