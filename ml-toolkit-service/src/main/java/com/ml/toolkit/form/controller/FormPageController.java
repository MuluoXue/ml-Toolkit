package com.ml.toolkit.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form/formPage")
public class FormPageController {

    @RequestMapping("/mainPage")
    public ModelAndView mainPage() {
        return new ModelAndView("/form/main");
    }


}
