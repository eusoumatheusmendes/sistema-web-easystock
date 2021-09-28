package br.com.mmsoftwares.easystock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @GetMapping("/logar")
    public String logar(){
        return "/login/autenticacao";
    }
}
