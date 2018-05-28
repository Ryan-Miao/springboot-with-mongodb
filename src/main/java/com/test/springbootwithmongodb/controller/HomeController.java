package com.test.springbootwithmongodb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/api", "/"})
    public String api() {
        return "redirect:/swagger-ui.html";
    }

}
