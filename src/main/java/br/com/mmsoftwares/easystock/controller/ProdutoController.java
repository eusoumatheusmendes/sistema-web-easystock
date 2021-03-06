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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Collection;

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
    public String salvar(@Valid Produto produto, BindingResult bindingResult, RedirectAttributes ra ){

        if(bindingResult.hasErrors()){
            return "/produto/cadastro";
        }
        service.salvar(produto);
        ra.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
        return "redirect:/produto/lista";
    }

    @GetMapping("/lista")
    public String listar(ModelMap model){
        model.addAttribute("produtos", service.buscarTodos());
        return "/produto/lista";
    }

    @GetMapping("/estoqueBaixo")
    public String listarProdutosComEstoqueBaixo(ModelMap model){
        model.addAttribute("produtosComEstoqueBaixo", service.
                trazerTodosOsProdutosQuePossuemMenosDeCincoQuantidadeEmEstoque());
        model.addAttribute("temProdutoComEstoqueBaixo", !service.trazerTodosOsProdutosQuePossuemMenosDeCincoQuantidadeEmEstoque().isEmpty());
        return "/produto/listaDeEstoqueBaixo";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id")Produto produto, ModelMap model){
        model.addAttribute(produto);
        return "/produto/cadastro";
    }

    @PostMapping("/atualizar")
    public String atualizar(Produto produto, RedirectAttributes ra){
        service.salvar(produto);
        ra.addFlashAttribute("sucesso", "Produto atualizado com sucesso!");
        return "redirect:/produto/lista";
    }

    @ModelAttribute("categorias")
    public Collection<Categoria> exibirCategorias(){
        return serviceDaCategoria.buscarTodos();
    }

    @ModelAttribute("empresas")
    public Collection<Empresa> exibirEmpresas(){
        return serviceDaEmpresa.buscarTodas();
    }

    @GetMapping("/confirmaExclusao/{id}")
    public String confirmarExclusao(@PathVariable("id")Produto produto, ModelMap model){
        model.addAttribute(produto);
        return "/produto/confirmacaoDeExclusao";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Produto produto, RedirectAttributes ra){
        service.excluir(produto);
        ra.addFlashAttribute("sucesso", produto.getNome() + " exclu??do com sucesso!");
        return "redirect:/produto/lista";
    }

    @GetMapping("/buscar/nome")
    public String buscarPorNome(@RequestParam("nome")String nome, ModelMap model){
        model.addAttribute("produtos", service.buscarPorNome(nome));
        return "/produto/lista";
    }

    @GetMapping("/abrirPedido/{id}")
    public String abrirPedido(@PathVariable("id") Produto produto, ModelMap model){
        model.addAttribute(produto);
        return "/produto/reservado";
    }

}
