package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

public interface IPedidoService {

    void salvar(Pedido pedido);
    void excluir(Pedido pedido);
    Collection<Pedido> buscarTodos();
    Optional<Pedido> buscarPorId(Long id);
    Collection<Pedido> buscarPorNome(String nome);
}
