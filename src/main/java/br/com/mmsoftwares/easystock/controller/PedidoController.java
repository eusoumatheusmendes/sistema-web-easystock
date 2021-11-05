package br.com.mmsoftwares.easystock.controller;

import br.com.mmsoftwares.easystock.model.Cliente;
import br.com.mmsoftwares.easystock.model.Pedido;
import br.com.mmsoftwares.easystock.model.Produto;
import br.com.mmsoftwares.easystock.model.QuantidadeEmEstoqueException;
import br.com.mmsoftwares.easystock.service.ClienteService;
import br.com.mmsoftwares.easystock.service.PedidoService;
import br.com.mmsoftwares.easystock.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastro")
    public String abrirFormulario(Pedido pedido){
        return "/pedido/cadastro";
    }

    @PostMapping("/registrar")
    public String registrarPedido(Pedido pedido, RedirectAttributes ra, ModelMap model){
       try{
           pedido.getProduto().darBaixaEmEstoque(pedido.getQuantidade());
       }
       catch (QuantidadeEmEstoqueException ex){
           model.addAttribute("falha", "Quantidade indisponível em estoque");
           return "/pedido/cadastro";
       }
        service.salvar(pedido);
        produtoService.salvar(pedido.getProduto());
        ra.addFlashAttribute("sucesso", "Pedido registrado com sucesso!");
        return "redirect:/produto/lista";

    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id")Pedido pedido, ModelMap model){
        model.addAttribute(pedido);
        return "/pedido/cadastro";
    }

    @PostMapping("/atualizar")
    public String atualizar(Pedido pedido, RedirectAttributes ra){
        service.salvar(pedido);
        ra.addFlashAttribute("sucesso", "Pedido atualizado com sucesso!");
        return "redirect:/pedido/lista";
    }

    @GetMapping("/lista")
    public String listar(ModelMap model){
        model.addAttribute("pedidos", service.buscarTodos());
        return "/pedido/lista";
    }

    @ModelAttribute("produtos")
    public Collection<Produto> exibirProdutos(){
        return produtoService.buscarTodos();
    }

    @ModelAttribute("clientes")
    public Collection<Cliente> exibirClientes(){
        return clienteService.buscarTodos();
    }

    @GetMapping("/confirmaExclusao/{id}")
    public String confirmarExclusao(@PathVariable("id")Pedido pedido, ModelMap model){
        model.addAttribute(pedido);
        return "/pedido/confirmacaoDeExclusao";
    }

    @GetMapping("/buscar/nome")
    public String buscarPorNome(@RequestParam("nome")String nome, ModelMap model){
        model.addAttribute("pedidos", service.buscarPorNome(nome));
        return "/pedido/lista";
    }
}
