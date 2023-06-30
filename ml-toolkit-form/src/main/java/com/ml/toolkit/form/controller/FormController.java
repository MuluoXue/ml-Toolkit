package com.ml.toolkit.form.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.form.domain.form.Form;
import com.ml.toolkit.form.dto.form.FormDto;
import com.ml.toolkit.form.service.form.FormService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/form")
public class FormController {

    @Resource
    private FormService formService;

    @RequestMapping("/save")
    public Result save(@RequestBody Form form) {
        formService.saveForm(form);
        return Result.success();
    }

    @RequestMapping("/list")
    public Result list() {
        List<Form> list = formService.list();
        return Result.success(list);
    }
}
