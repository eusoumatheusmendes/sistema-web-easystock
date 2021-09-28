package br.com.mmsoftwares.easystock.controller;
import br.com.mmsoftwares.easystock.dao.IEmpresaDao;
import br.com.mmsoftwares.easystock.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private IEmpresaDao dao;

    @GetMapping("/cadastro")
    public String cadastro(){
        return "/empresa/cadastro";
    }

    public String salvar(Empresa empresa){
        dao.save(empresa);
        return "/home";
    }
}
