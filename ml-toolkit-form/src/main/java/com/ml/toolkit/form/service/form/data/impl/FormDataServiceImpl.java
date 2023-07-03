package com.ml.toolkit.form.service.form.data.impl;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.form.dao.data.FormDataDao;
import com.ml.toolkit.form.domain.data.FormData;
import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.ml.toolkit.form.service.form.data.FormDataDetailService;
import com.ml.toolkit.form.service.form.data.FormDataService;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component
public class FormDataServiceImpl extends BaseServiceImpl<FormDataDao, FormData> implements FormDataService {

    @Resource
    private FormDataDetailService formDataDetailService;

    @Resource FormDataDao formDataDao;

    /**
     * 创建表单数据
     * @param entity formData
     * @return true/false
     */
    @Override
    public void saveData(FormData entity) {
        FormData formData = new FormData();
        formData.setId(LongIdGenerator.generate());
        formData.setFormId(entity.getFormId());
        formData.setCreateTime(new Date());
        this.save(formData);

        formDataDetailService.saveBatchData(entity.getFormDataDetailList(), formData.getId());
    }

}
