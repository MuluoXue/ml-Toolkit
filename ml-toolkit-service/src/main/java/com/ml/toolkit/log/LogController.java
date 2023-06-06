package com.ml.toolkit.log;

import com.ml.toolkit.log.demo.Demo;
import com.ml.toolkit.log.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/insert")
    public void insert() {
        Demo demo = new Demo();
        demo.setName("666");
        demoService.insert(demo, "ml");
    }
}
