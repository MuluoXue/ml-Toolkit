package com.ml.toolkit.controller.second;

import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.controller.BaseController;
import com.ml.toolkit.service.kzz.KzzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api/kzz")
public class KzzController extends BaseController {
    private static final long serialVersionUID = -5937462166905190482L;

    @Resource
    private KzzService kzzService;

    @RequestMapping("/gradJiSiLuData")
    public Result gradJiSiLuData() throws Exception {
        kzzService.gradJiSiLuData();
        return Result.success();
    }
}
