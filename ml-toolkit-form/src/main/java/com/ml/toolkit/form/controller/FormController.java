package com.ml.toolkit.form.controller;

import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.form.domain.Form;
import com.ml.toolkit.form.service.FormService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@ResponseBody
@RequestMapping("/form")
public class FormController {

    @Resource
    private FormService formService;

    @RequestMapping("/saveForm")
    public Result saveForm(@RequestBody Form form){
        formService.saveForm(form);
        return Result.success();
    }
}
