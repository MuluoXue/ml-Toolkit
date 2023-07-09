package com.ml.toolkit.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login/page")
public class LoginPageController {

    @RequestMapping("/login")
    public ModelAndView mainPage() {
        return new ModelAndView("/login/login");
    }


}
