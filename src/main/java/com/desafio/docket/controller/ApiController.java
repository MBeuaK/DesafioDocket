package com.desafio.docket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ApiController {

    @GetMapping
    @RequestMapping({"/", "/home"})
    public String healthCheck() {
        return "/home";
    }

}