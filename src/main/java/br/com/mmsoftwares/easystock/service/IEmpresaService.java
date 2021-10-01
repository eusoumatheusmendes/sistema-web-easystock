package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.model.Empresa;

import java.util.Collection;
import java.util.Optional;

public interface IEmpresaService {

    void salvar(Empresa empresa);

    void excluir(Empresa empresa);

    Optional<Empresa> buscarPorId(Long id);

    Collection<Empresa> buscarTodas();
}
