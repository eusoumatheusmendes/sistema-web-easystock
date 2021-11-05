package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "PEDIDOS")
@Entity
public class Pedido extends AbstractEntity<Long>{

    @Getter @Setter
    private Integer quantidade;

    @Getter @Setter
    private BigDecimal precoTotal;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_cliente_fk")
    private Cliente cliente;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_produto_fk")
    private Produto produto;

    public void lancarPedido(Cliente cliente, Produto produto, Integer quantidade){
        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidade);
        cliente.adicionarValorEmCompras(produto.getPrecoDeVenda().multiply(BigDecimal.valueOf(quantidade)));
        this.precoTotal = produto.getPrecoDeVenda().multiply(BigDecimal.valueOf(quantidade));
    }
}
