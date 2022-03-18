package com.desafio.docket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

    @GetMapping
    @RequestMapping({"/", "/home"})
    public String healthCheck() {
        return "Alive!";
    }

}