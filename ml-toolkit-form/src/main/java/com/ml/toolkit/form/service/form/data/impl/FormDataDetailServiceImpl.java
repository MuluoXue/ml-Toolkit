package com.ml.toolkit.form.service.form.data.impl;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.form.dao.data.FormDataDetailDao;
import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.ml.toolkit.form.service.form.data.FormDataDetailService;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class FormDataDetailServiceImpl extends BaseServiceImpl<FormDataDetailDao, FormDataDetail> implements FormDataDetailService {

    @Override
    public void saveBatchData(List<FormDataDetail> list, Long dataId) {
        if (ObjectUtil.isNotEmpty(list)) {
            for (FormDataDetail formDataDetail : list) {
                formDataDetail.setDataId(dataId);
                formDataDetail.setId(LongIdGenerator.generate());
                formDataDetail.setCreateTime(new Date());
            }
            this.saveBatch(list);
        }
    }

    @Override
    public List<FormDataDetail> listByFormDataIds(List<Long> formDataIds) {
        return null;
    }


}
