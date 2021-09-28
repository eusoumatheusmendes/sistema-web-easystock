package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.model.Cliente;

import java.util.Collection;
import java.util.Optional;

public interface IClienteService {

    void salvar(Cliente cliente);

    void atualizar(Cliente cliente);

    void excluir(Cliente cliente);

    Optional<Cliente> buscarPorId(Long id);

    Collection<Cliente> buscarTodos();
}
