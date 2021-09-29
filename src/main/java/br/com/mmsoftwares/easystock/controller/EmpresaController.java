package br.com.mmsoftwares.easystock.controller;
import br.com.mmsoftwares.easystock.dao.IEmpresaDao;
import br.com.mmsoftwares.easystock.model.Empresa;
import br.com.mmsoftwares.easystock.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping("/cadastro")
    public String cadastro(Empresa empresa){
        return "/empresa/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Empresa empresa){
        service.salvar(empresa);
        return "redirect:/empresa/lista";
    }

    @GetMapping("/lista")
    public String listar(ModelMap model){
        model.addAttribute("empresas", service.buscarTodas());
        return "/empresa/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Empresa empresa, ModelMap model){
        model.addAttribute(empresa);
        return "/empresa/cadastro";
    }
}
