package br.com.mmsoftwares.easystock.controller;

import br.com.mmsoftwares.easystock.model.Cliente;
import br.com.mmsoftwares.easystock.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/cadastro")
    public String cadastrar(Cliente cliente){
        return "/cliente/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Cliente cliente, RedirectAttributes ra){
        service.salvar(cliente);
        ra.addFlashAttribute("sucesso", "Cliente cadastrado com sucesso!");
        return "redirect:/cliente/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id")Cliente cliente, ModelMap model){
        model.addAttribute(cliente);
        return "/cliente/cadastro";
    }

    @PostMapping("/atualizar")
    public String atualizar(Cliente cliente, RedirectAttributes ra){
        service.salvar(cliente);
        ra.addFlashAttribute("sucesso", "Cliente " + cliente.getNome() + " atualizado com sucesso!");
        return "redirect:/cliente/lista";
    }

    @GetMapping("/lista")
    public String listar(ModelMap model){

        Stream<Cliente> clienteStream =  service.buscarTodos().stream().filter(Cliente::ehAniversarianteDoDia);
        List<Cliente> aniversariantesDoDia = clienteStream.collect(Collectors.toList());
        model.addAttribute("aniversariantes", aniversariantesDoDia);
        model.addAttribute("clientes", service.buscarTodos());
        return "/cliente/lista";
    }



    @GetMapping("/confirmaExclusao/{id}")
    public String confirmarExclusao(@PathVariable("id")Cliente cliente, ModelMap model){
        model.addAttribute(cliente);
        return "/cliente/confirmacaoDeExclusao";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Cliente cliente, RedirectAttributes ra){
        service.excluir(cliente);
        ra.addFlashAttribute("sucesso", "CLiente " +cliente.getNome() + " excluído com sucesso!");
        return "redirect:/cliente/lista";
    }

    @GetMapping("/buscar/nome")
    public String buscarPorNome(@RequestParam("nome")String nome, ModelMap model){
        model.addAttribute("clientes", service.buscarPorNome(nome));
        return "/cliente/lista";
    }

    @GetMapping("/aniversariantes")
    public String exibirListaDeAniversariantes(ModelMap model){
        Stream<Cliente> clienteStream = service.buscarTodos().stream().filter(Cliente::ehAniversarianteDoDia);
        List<Cliente> aniversariantes = clienteStream.collect(Collectors.toList());
        model.addAttribute("aniversariantes", aniversariantes);
        return "/cliente/aniversariantes";
    }

    @ModelAttribute("temAniversariante")
    public boolean temAniversariante(ModelMap model){
        Stream<Cliente> clienteStream = service.buscarTodos().stream().filter(Cliente::ehAniversarianteDoDia);
        List<Cliente> aniversariantes = clienteStream.collect(Collectors.toList());
        return !aniversariantes.isEmpty();
    }

}
