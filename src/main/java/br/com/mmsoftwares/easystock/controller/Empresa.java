package br.com.mmsoftwares.easystock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empresa")
public class Empresa {

    @GetMapping("/cadastro")
    public String cadastro(){
        return "/empresa/cadastro";
    }
}
