package com.ml.toolkit.controller.form;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.controller.BaseController;
import com.ml.toolkit.form.domain.form.field.FormField;
import com.ml.toolkit.form.param.FormFieldSearchParam;
import com.ml.toolkit.form.service.field.FormFieldService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;


@RestController
@RequestMapping("/form/field")
public class FormFieldController extends BaseController {

    private static final long serialVersionUID = -3548304283404511163L;

    @Resource
    private FormFieldService formFieldService;

    @RequestMapping("/save")
    public Result save(@RequestBody @Valid FormField formField) {
        formField.setId(LongIdGenerator.generate());
        formField.setCreator(getCurrentUser());

        formFieldService.save(formField);
        return Result.success();
    }

    @RequestMapping("/list")
    public Result list(@RequestBody FormFieldSearchParam param) {
        QueryWrapper<FormField> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(FormField::getForm, param.getFormId());
        if (param.isNoPage()) {
            return Result.success(formFieldService.list(wrapper));
        }
        return Result.success(formFieldService.page(new Page<>(param.getPage(), param.getLimit()), wrapper));
    }
}
