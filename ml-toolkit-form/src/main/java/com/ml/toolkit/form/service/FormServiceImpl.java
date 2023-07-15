package com.ml.toolkit.form.service;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.form.dao.form.FormDao;
import com.ml.toolkit.form.domain.form.Form;
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveForm(Form form) {
        Assert.notEmpty("params is empty", form.getName());
        form.setId(LongIdGenerator.generate());
        form.setCreateTime(new Date());
        this.save(form);
    }
}
