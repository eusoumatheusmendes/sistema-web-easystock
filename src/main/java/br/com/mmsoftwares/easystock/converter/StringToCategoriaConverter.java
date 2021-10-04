package br.com.mmsoftwares.easystock.converter;

import br.com.mmsoftwares.easystock.model.Categoria;
import br.com.mmsoftwares.easystock.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringToCategoriaConverter implements Converter<String, Optional<Categoria>> {

    @Autowired
    private CategoriaService service;

    @Override
    public Optional<Categoria> convert(String stringFormulario) {
        Long id = Long.valueOf(stringFormulario);
        return service.busarPorId(id);
    }
}
