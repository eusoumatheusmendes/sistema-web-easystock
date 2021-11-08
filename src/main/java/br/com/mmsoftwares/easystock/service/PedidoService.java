package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.dao.IPedidoDao;
import br.com.mmsoftwares.easystock.model.Pedido;
import br.com.mmsoftwares.easystock.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private IPedidoDao dao;

    @Autowired
    private ProdutoService produtoService;

    private Pedido pedido;

    private Produto produto = new Produto();

    @Override
    public void salvar(Pedido pedido) {
        try{
            pedido.setDataDeCadastro(LocalDate.now());
            dao.save(pedido);
            produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - pedido.getQuantidade());
            produtoService.salvar(pedido.getProduto());
        }catch (RuntimeException ex){
            ex.getMessage();
        }
    }

    @Override
    public void excluir(Pedido pedido) {
        dao.delete(pedido);
    }

    @Override
    public Collection<Pedido> buscarTodos() {
        Stream<Pedido> pedidosOrdenadosPorDataMaisRecente = dao.findAll().stream().sorted(Comparator.comparing(Pedido::getDataDeCadastro).reversed());
        return pedidosOrdenadosPorDataMaisRecente.collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Pedido> buscarPorNome(String nome) {
        return dao.findByClienteNomeContains(nome);
    }
}
