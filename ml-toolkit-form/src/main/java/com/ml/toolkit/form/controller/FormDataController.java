package com.ml.toolkit.form.controller;

import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.form.domain.data.FormData;
import com.ml.toolkit.form.dto.form.data.FormDataDto;
import com.ml.toolkit.form.service.form.data.FormDataSearchService;
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
    private FormDataSearchService formDataSearchService;

    @Resource
    private FormDataService formDataService;

    @RequestMapping("/save")
    public Result save(@RequestBody FormDataDto dto) {
        formDataService.saveData(dto);
        return Result.success();
    }

    @RequestMapping("/list")
    public Result list(@RequestBody FormData formData) {
        return Result.success(formDataSearchService.listByEntity(formData));
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(@RequestBody FormDataDto dto) {
        formDataService.deleteByIds(dto.getIds());
        return Result.success();
    }

    @RequestMapping("/findFormDataAndField")
    public Result findFormDataAndField(@RequestBody FormDataDto dto) {
        return Result.success(formDataService.findFormDataAndField(dto));
    }
}
