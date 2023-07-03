package com.ml.toolkit.form.service.form.data;

import com.ml.toolkit.form.domain.data.FormData;
import com.ml.toolkit.mybatis.plus.base.BaseService;

import java.util.List;

/**
 * formData Service
 */
public interface FormDataService extends BaseService<FormData> {

    void saveData(FormData formData);


}
