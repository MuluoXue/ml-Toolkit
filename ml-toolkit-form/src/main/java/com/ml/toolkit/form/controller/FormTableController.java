package com.ml.toolkit.form.controller;

import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.form.service.form.table.FormTableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@ResponseBody
@RequestMapping("/formTable")
public class FormTableController {

    @Resource
    private FormTableService formTableService;

    @RequestMapping("/createBaseFormTable")
    public Result createBaseFormTable(@RequestParam("physicsName") String physicsName) {
        formTableService.createBaseFormTable(physicsName);
        return Result.success();
    }
}
