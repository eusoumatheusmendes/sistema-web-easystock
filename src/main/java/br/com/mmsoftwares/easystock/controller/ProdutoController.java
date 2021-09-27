package br.com.mmsoftwares.easystock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping("/cadastro")
    public String cadastrar(){
        return "/produto/cadastro";
    }
}
