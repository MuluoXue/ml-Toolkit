package com.ml.toolkit.controller.form;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.controller.BaseController;
import com.ml.toolkit.form.domain.form.field.FormField;
import com.ml.toolkit.form.service.field.FormFieldService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/form/field")
public class FormFieldController extends BaseController {

    private static final long serialVersionUID = -3548304283404511163L;

    @Resource
    private FormFieldService formFieldService;

    @RequestMapping("/save")
    public Result save(@RequestBody FormField formField) {
        Assert.notEmpty("param is empty", formField, formField.getForm(), formField.getName());

        formField.setCreateTime(new Date());
        formField.setId(LongIdGenerator.generate());
        formField.setCreator(getCurrentUser());

        formFieldService.save(formField);
        return Result.success();
    }

    @RequestMapping("/list")
    public Result list(@RequestBody FormField formField) {
        QueryWrapper<FormField> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(FormField::getForm, formField.getForm().getId());
        List<FormField> list = formFieldService.list(wrapper);
        return Result.success(list);
    }
}
