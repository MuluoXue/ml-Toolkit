package com.ml.toolkit.form.controller;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.form.domain.FormField;
import com.ml.toolkit.form.service.field.FormFieldService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/form/field")
public class FormFieldController {

    @Resource
    private FormFieldService formFieldService;

    @RequestMapping("/save")
    public Result save(@RequestBody FormField formField) {
        Assert.notEmpty("param is empty", formField, formField.getFormId(), formField.getName());
        formField.setCreateTime(new Date());
        formField.setId(LongIdGenerator.generate());
        formFieldService.save(formField);
        return Result.success();
    }

    @RequestMapping("/list")
    public Result list(@RequestBody FormField formField) {
        Map<String, Object> params = new HashMap<>();
        params.put("form_id", formField.getFormId());
        List<FormField> list = formFieldService.listByMap(params);
        return Result.success(list);
    }
}
