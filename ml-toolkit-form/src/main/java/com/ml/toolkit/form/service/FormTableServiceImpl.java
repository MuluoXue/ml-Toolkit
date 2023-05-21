package com.ml.toolkit.form.service;

import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.form.dao.FormTableDao;
import com.ml.toolkit.form.domain.FormTable;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Transactional
@Component
public class FormTableServiceImpl extends BaseServiceImpl<FormTableDao, FormTable> implements FormTableService {

    @Resource
    private FormTableDao formTableDao;

    @Override
    public void createBaseFormTable(String physicsName) {
        Assert.notEmpty("physicsName is Empty", physicsName);
        formTableDao.createBaseFormTable(physicsName);
    }


}
