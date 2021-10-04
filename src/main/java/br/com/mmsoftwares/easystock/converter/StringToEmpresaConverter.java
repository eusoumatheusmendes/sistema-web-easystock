package br.com.mmsoftwares.easystock.converter;

import br.com.mmsoftwares.easystock.model.Empresa;
import br.com.mmsoftwares.easystock.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

public class StringToEmpresaConverter implements Converter<String, Optional<Empresa>> {

    @Autowired
    private EmpresaService service;

    @Override
    public Optional<Empresa> convert(String stringFormulario) {
        Long id = Long.valueOf(stringFormulario);
        return service.buscarPorId(id);
    }


}
