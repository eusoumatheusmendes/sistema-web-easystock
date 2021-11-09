package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.model.Cliente;
import br.com.mmsoftwares.easystock.model.Produto;

import java.util.Collection;
import java.util.Optional;

public interface IProdutoService{

    void salvar(Produto produto);

    void excluir(Produto produto);

    Optional<Produto> buscarPorId(Long id);

    Collection<Produto> buscarTodos();

    Collection<Produto> buscarPorNome(String nome);

    Collection<Produto> trazerTodosOsProdutosQuePossuemMenosDeCincoQuantidadeEmEstoque();
}
