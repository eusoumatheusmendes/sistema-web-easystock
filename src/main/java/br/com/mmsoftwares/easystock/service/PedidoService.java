package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.dao.IPedidoDao;
import br.com.mmsoftwares.easystock.model.Pedido;
import br.com.mmsoftwares.easystock.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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
            dao.save(pedido);
            produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - pedido.getQuantidade());
            produtoService.salvar(pedido.getProduto());
            pedido.lancarPedido(pedido.getCliente(), pedido.getProduto(), pedido.getQuantidade());
        }catch (RuntimeException ex){
            ex.getMessage();
        }
    }

    @Override
    public void excluir(Pedido pedido) {

    }

    @Override
    public Collection<Pedido> buscarTodos() {
        return dao.findAll();
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
