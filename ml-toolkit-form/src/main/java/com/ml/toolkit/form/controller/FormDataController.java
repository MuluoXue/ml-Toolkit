package com.ml.toolkit.form.controller;

import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.form.domain.data.FormData;
import com.ml.toolkit.form.service.form.data.FormDataService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/form/data")
public class FormDataController {

    @Resource
    private FormDataService formDataService;

    @RequestMapping("/save")
    public Result save(@RequestBody FormData formData) {
        formDataService.saveData(formData);
        return Result.success();
    }

    @RequestMapping("/list")
    public Result list(@RequestBody FormData formData) {
//        List<FormData> list = formDataService.listByEntity(formData);
        return Result.success();
    }
}
