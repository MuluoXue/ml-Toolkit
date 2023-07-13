package com.ml.toolkit.controller.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form/page")
public class FormPageController {

    @RequestMapping("/mainPage")
    public ModelAndView mainPage() {
        return new ModelAndView("/form/main");
    }


}
