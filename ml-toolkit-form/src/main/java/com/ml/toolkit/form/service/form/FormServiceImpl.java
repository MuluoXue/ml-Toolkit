package com.ml.toolkit.form.service.form;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.form.dao.form.FormDao;
import com.ml.toolkit.form.domain.form.Form;
import com.ml.toolkit.form.domain.sys.SimpleUser;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ml
 * @date 2023年05月11日 20:34
 */
@Service
public class FormServiceImpl extends BaseServiceImpl<FormDao, Form> implements FormService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveForm(Form form, SimpleUser user) {
        Assert.notEmpty("params is empty", form.getName());
        form.setId(LongIdGenerator.generate());
        form.setCreator(user);
        this.save(form);
    }
}
