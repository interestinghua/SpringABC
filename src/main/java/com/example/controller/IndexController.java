package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends AbstractController {

    @RequestMapping("/main")
    public String main(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "main";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "index";
    }

}
