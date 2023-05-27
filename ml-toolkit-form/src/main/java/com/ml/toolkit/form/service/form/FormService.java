package com.ml.toolkit.form.service.form;

import com.ml.toolkit.form.domain.form.Form;
import com.ml.toolkit.form.dto.form.FormDto;
import com.ml.toolkit.mybatis.plus.base.BaseService;

/**
 * @author ml
 * @date 2023年05月11日 20:34
 */
public interface FormService extends BaseService<Form> {
    /**
     * 保存表单
     */
    void saveForm(FormDto form) ;
}
