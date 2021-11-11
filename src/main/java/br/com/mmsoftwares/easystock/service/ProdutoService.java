package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.repository.IProdutoDao;
import br.com.mmsoftwares.easystock.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProdutoService implements IProdutoService{

    @Autowired
    private IProdutoDao dao;


    @Override
    public void salvar(Produto produto) {
        dao.save(produto);
    }

    @Override
    public void excluir(Produto produto) {
        dao.delete(produto);
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public Collection<Produto> buscarPorNome(String nome) {
        return dao.findByNomeContains(nome);
    }

    @Override
    public Collection<Produto> trazerTodosOsProdutosQuePossuemMenosDeCincoQuantidadeEmEstoque() {
        return dao.trazerTodosOsProdutosQuePossuemMenosDeCincoQuantidadeEmEstoque();
    }
}
