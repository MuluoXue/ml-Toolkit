package com.ml.toolkit.form.service;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.form.dao.FormDao;
import com.ml.toolkit.form.domain.Form;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ml
 * @date 2023年05月11日 20:34
 */
@Service
public class FormServiceImpl extends BaseServiceImpl<FormDao, Form> implements FormService{

    @Override
    public void saveForm(Form form) {
        Assert.notEmpty("params is empty", form.getName());
       form.setId(LongIdGenerator.generate());
       form.setCreateTime(new Date());
       this.save(form);
    }
}
