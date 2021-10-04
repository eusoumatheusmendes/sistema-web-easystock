package br.com.mmsoftwares.easystock.controller;

import br.com.mmsoftwares.easystock.model.Categoria;
import br.com.mmsoftwares.easystock.model.Empresa;
import br.com.mmsoftwares.easystock.model.Produto;
import br.com.mmsoftwares.easystock.service.CategoriaService;
import br.com.mmsoftwares.easystock.service.EmpresaService;
import br.com.mmsoftwares.easystock.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private CategoriaService serviceDaCategoria;

    @Autowired
    private EmpresaService serviceDaEmpresa;


    @GetMapping("/cadastro")
    public String cadastrar(Produto produto){
        return "/produto/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Produto produto, RedirectAttributes ra){
        service.salvar(produto);
        ra.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
        return "redirect:/produto/lista";
    }

    @GetMapping("/lista")
    public String listar(ModelMap model){
        model.addAttribute("produtos", service.buscarTodos());
        return "/produto/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id")Produto produto, ModelMap model){
        model.addAttribute(produto);
        return "/produto/cadastro";
    }

    @ModelAttribute("categorias")
    public Collection<Categoria> exibirCategorias(){
        return serviceDaCategoria.buscarTodos();
    }

    @ModelAttribute("empresas")
    public Collection<Empresa> exibirEmpresas(){
        return serviceDaEmpresa.buscarTodas();
    }
}
