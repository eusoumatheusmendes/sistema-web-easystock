package br.com.mmsoftwares.easystock.controller;

import br.com.mmsoftwares.easystock.model.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private

    @GetMapping("/cadastro")
    public String cadastro(Categoria categoria){
        return "/categoria/cadastro";
    }

    public String salvar(Categoria categoria){

    }
}
