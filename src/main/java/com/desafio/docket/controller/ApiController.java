package com.desafio.docket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;


@Controller
public class ApiController {

	@ApiOperation(value = "Verifica se a aplicação está de pé", notes = "Verifica se a aplicação está de pé")
    @GetMapping
    @RequestMapping({"/", "/home"})
    public String healthCheck() {
        return "/home";
    }

}