package com.ml.toolkit.form.service.data;


import com.ml.toolkit.form.dto.form.data.FormDataDto;
import com.ml.toolkit.form.vo.form.data.FormDataVo;

import java.util.Map;

public interface FormDataSearchService {

    /**
     * 查询所有的formData 和 formDetail
     * @param param 查询参数
     * @return
     */
    FormDataVo listPageByEntity(FormDataDto param);
}
