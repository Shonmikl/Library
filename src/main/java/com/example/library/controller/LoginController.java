package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

//    @GetMapping("/start")
//    public ModelAndView loginPage() {
//        return new ModelAndView("/start.html");
//    }

    @GetMapping("/ex")
    public String test() {
        return "NO SECURITY";
    }

    @GetMapping("start")
    public String loginPage() {
        return "start";
    }
}