package com.ml.toolkit.form.service.data.impl;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.form.dao.data.FormDataDao;
import com.ml.toolkit.form.domain.form.Form;
import com.ml.toolkit.form.domain.form.field.FormField;
import com.ml.toolkit.form.domain.data.FormData;
import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.ml.toolkit.form.domain.sys.SimpleUser;
import com.ml.toolkit.form.dto.form.data.FormDataDto;
import com.ml.toolkit.form.service.data.FormDataService;
import com.ml.toolkit.form.service.data.FormDataDetailService;
import com.ml.toolkit.form.service.field.FormFieldService;
import com.ml.toolkit.form.vo.form.data.FormDataVo;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Component
public class FormDataServiceImpl extends BaseServiceImpl<FormDataDao, FormData> implements FormDataService {

    @Resource
    private FormDataDetailService formDataDetailService;

    @Resource
    private FormDataDao formDataDao;

    @Resource
    private FormFieldService formFieldService;

    /**
     * 创建表单数据
     *
     * @param entity formData
     */
    @Override
    public void saveData(FormDataDto dto, SimpleUser user) {
        Long formDataId = null;
        // 新增
        if (ObjectUtil.isEmpty(dto.getDataId())) {
            formDataId = LongIdGenerator.generate();
            FormData formData = new FormData();
            formData.setId(formDataId);
            formData.setForm(new Form(dto.getFormId()));
            formData.setCreator(user);
            this.save(formData);
        } else {
            formDataId = dto.getDataId();
        }
        formDataDetailService.saveBatchData(dto.getFormDataDetailList(), formDataId, user);
    }

    @Transactional
    @Override
    public void deleteByIds(List<Long> idList) {
        this.removeByIds(idList);
        formDataDetailService.deleteByFormDataIds(idList);
    }

    @Override
    public FormDataVo findFormDataAndField(FormDataDto dto) {
        Map<String, Object> formFieldParams = new HashMap<>();
        formFieldParams.put("form_id", dto.getFormId());
        List<FormField> formFieldList = formFieldService.listByMap(formFieldParams);

        FormDataVo vo = new FormDataVo();
        vo.setFormFieldList(formFieldList);
        if (ObjectUtil.isNotEmpty(dto.getDataId())) {
            FormData formData = this.getById(dto.getDataId());
            List<FormDataDetail> formDataDetails = formDataDetailService.listByFormDataIdList(Collections.singletonList(dto.getDataId()));
            formData.setFormDataDetailList(formDataDetails);
            vo.setFormData(formData);
        }

        return vo;
    }
}
