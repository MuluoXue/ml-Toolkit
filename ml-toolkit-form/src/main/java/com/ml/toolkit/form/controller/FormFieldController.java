package com.ml.toolkit.form.controller;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.form.domain.FormField;
import com.ml.toolkit.form.service.form.field.FormFieldService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;


@RestController
@RequestMapping("/formField")
public class FormFieldController {

    @Resource
    private FormFieldService formFieldService;

    @RequestMapping("/save")
    public void save(@RequestBody FormField formField) {
        Assert.notEmpty("param is empty", formField, formField.getFormId(), formField.getName());
        formField.setCreateTime(new Date());
        formField.setId(LongIdGenerator.generate());
        formFieldService.save(formField);
    }
}
