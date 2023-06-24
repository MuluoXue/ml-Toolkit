package com.ml.toolkit.form.service.form.field;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.form.dao.form.field.FormFieldDao;
import com.ml.toolkit.form.domain.FormField;
import com.ml.toolkit.form.dto.form.field.FormFieldDto;
import com.ml.toolkit.form.exception.FormException;
import com.ml.toolkit.form.exception.FormResultCode;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FormFieldServiceImpl extends BaseServiceImpl<FormFieldDao, FormField> implements FormFieldService {

    @Resource
    private FormFieldDao formFieldDao;

    @Transactional
    @Override
    public void batchSave(List<FormFieldDto> list, Long formId) throws FormException {
        if (ObjectUtil.isNotEmpty(list)) {
            List<FormField> formFieldList = new ArrayList<>();
            for (FormFieldDto dto : list) {
                if (ObjectUtil.isEmpty(dto.getName())) {
                    throw new FormException(FormResultCode.PARAM_ERROR);
                }
                FormField formField = new FormField();
                formField.setId(LongIdGenerator.generate());
                formField.setFormId(formId);
                formField.setName(dto.getName());
                formField.setCreateTime(new Date());
                formFieldList.add(formField);
            }
            formFieldDao.insertBatchSomeColumn(formFieldList);
        }
    }
}
