package com.ml.toolkit.controller.form;

import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.controller.BaseController;
import com.ml.toolkit.form.domain.form.Form;
import com.ml.toolkit.form.service.form.FormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/form")
public class FormController extends BaseController {

    private static final long serialVersionUID = 645405808493944751L;

    @Resource
    private FormService formService;

    @RequestMapping("/save")
    public Result save(@RequestBody Form form) {
        formService.saveForm(form, getCurrentUser());
        return Result.success();
    }

    @RequestMapping("/list")
    public Result list() {
        List<Form> list = formService.list();
        return Result.success(list);
    }

    @RequestMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable("id") Long id) {
        formService.removeById(id);
        return Result.success();
    }
}
