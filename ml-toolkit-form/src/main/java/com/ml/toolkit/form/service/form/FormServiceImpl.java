package com.ml.toolkit.form.service.form;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.form.dao.form.FormDao;
import com.ml.toolkit.form.domain.form.Form;
import com.ml.toolkit.form.dto.form.FormDto;
import com.ml.toolkit.form.service.form.field.FormFieldService;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ml
 * @date 2023年05月11日 20:34
 */
@Service
public class FormServiceImpl extends BaseServiceImpl<FormDao, Form> implements FormService {


    @Resource
    private FormFieldService formFieldService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveForm(FormDto dto) {
        Assert.notEmpty("params is empty", dto.getName());
        Form form = new Form();
        form.setId(LongIdGenerator.generate());
        form.setName(dto.getName());
        form.setCreateTime(new Date());
        this.save(form);

        //创建表单字段
        formFieldService.batchSave(dto.getFormFieldList(), form.getId());
    }
}
