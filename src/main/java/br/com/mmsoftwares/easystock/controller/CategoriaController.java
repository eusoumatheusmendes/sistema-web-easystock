package br.com.mmsoftwares.easystock.controller;

import br.com.mmsoftwares.easystock.model.Categoria;
import br.com.mmsoftwares.easystock.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/cadastro")
    public String cadastro(Categoria categoria){
        return "/categoria/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Categoria categoria){
        service.salvar(categoria);
        return "redirect:/categoria/lista";
    }

    @GetMapping("/lista")
    public String lista(ModelMap model){
        model.addAttribute("categorias", service.buscarTodos());
        return "/categoria/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id")Categoria categoria, ModelMap model){
        model.addAttribute(categoria);
        return "/categoria/cadastro";
    }
}
