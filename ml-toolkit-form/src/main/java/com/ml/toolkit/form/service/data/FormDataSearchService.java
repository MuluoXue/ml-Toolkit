package com.ml.toolkit.form.service.data;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ml.toolkit.form.domain.data.FormData;
import com.ml.toolkit.form.dto.form.data.FormDataDto;

public interface FormDataSearchService {

    /**
     * 查询所有的formData 和 formDetail
     * @param param 查询参数
     * @return FormDataVo
     */
    Page<FormData> pageByEntity(FormDataDto param);
}
