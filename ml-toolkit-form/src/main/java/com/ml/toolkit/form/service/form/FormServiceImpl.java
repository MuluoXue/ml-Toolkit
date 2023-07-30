package com.ml.toolkit.form.service.form;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.form.dao.form.FormDao;
import com.ml.toolkit.form.domain.form.Form;
import com.ml.toolkit.form.domain.form.field.FormField;
import com.ml.toolkit.form.domain.sys.SimpleUser;
import com.ml.toolkit.form.service.field.FormFieldService;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import com.toolkit.sql.conversion.util.JavaBeanToSqlUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
    public void saveForm(Form form, SimpleUser user) {
        Assert.notEmpty("params is empty", form.getName());
        form.setId(LongIdGenerator.generate());
        form.setCreator(user);
        this.save(form);
    }

    @Override
    public File exportSql(Long formId, SimpleUser currentUser) throws IOException {
        // 查询表单数据详情
        Form form = this.getById(formId);

        StringBuilder sb = new StringBuilder();
        sb.append(JavaBeanToSqlUtil.toInsertSql(form, null));

        // 查询字段数据详情
        QueryWrapper<FormField> wrapper = new QueryWrapper<FormField>();
        wrapper.lambda().eq(FormField::getForm, formId);
        List<FormField> list = formFieldService.list(wrapper);
        list.forEach(field -> {
            sb.append(JavaBeanToSqlUtil.toInsertSql(field, null));
        });

        // 写入sql
        String fileName = formId + ".sql";
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(sb.toString());

        bufferedWriter.close();

        return file;
    }

}
