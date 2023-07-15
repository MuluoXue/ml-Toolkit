package com.ml.toolkit.form.service.data;

import com.ml.toolkit.form.domain.data.FormData;
import com.ml.toolkit.form.dto.form.data.FormDataDto;
import com.ml.toolkit.form.vo.form.data.FormDataVo;
import com.ml.toolkit.mybatis.plus.base.BaseService;

import java.util.List;

/**
 * formData Service
 */
public interface FormDataService extends BaseService<FormData> {

    void saveData(FormDataDto dto);

    void deleteByIds(List<Long> ids);

    /**
     * 根据表单Id获取字段和formData
     * @param dto 查询参数
     * @return vo
     */
    FormDataVo findFormDataAndField(FormDataDto dto);
}
