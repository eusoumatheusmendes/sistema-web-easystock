package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.model.Categoria;

import java.util.Collection;
import java.util.Optional;

public interface ICategoriaService{

    void salvar(Categoria categoria);

    void excluir(Categoria categoria);

    Optional<Categoria> busarPorId(Long id);

    Collection<Categoria> buscarTodos();
}
