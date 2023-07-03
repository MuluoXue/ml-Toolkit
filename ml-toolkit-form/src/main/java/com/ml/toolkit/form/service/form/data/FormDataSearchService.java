package com.ml.toolkit.form.service.form.data;


import com.ml.toolkit.form.domain.data.FormData;

import java.util.Map;

public interface FormDataSearchService {

    /**
     * 查询所有的formData 和 formDetail
     * @param formData
     * @return
     */
    Map<String, Object> listByEntity(FormData formData);
}
