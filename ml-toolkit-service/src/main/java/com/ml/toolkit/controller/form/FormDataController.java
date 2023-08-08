package com.ml.toolkit.controller.form;

import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.controller.BaseController;
import com.ml.toolkit.form.dto.form.data.FormDataDto;
import com.ml.toolkit.form.service.data.FormDataSearchService;
import com.ml.toolkit.form.service.data.FormDataService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/form/data")
public class FormDataController extends BaseController {

    private static final long serialVersionUID = -6243208195005396836L;

    @Resource
    private FormDataSearchService formDataSearchService;

    @Resource
    private FormDataService formDataService;

    @RequestMapping("/save")
    public Result save(@RequestBody FormDataDto dto) {
        formDataService.saveData(dto, getCurrentUser());
        return Result.success();
    }

    @RequestMapping("/list")
    public Result list(@RequestBody FormDataDto param) {
        return Result.success(formDataSearchService.pageByEntity(param));
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
