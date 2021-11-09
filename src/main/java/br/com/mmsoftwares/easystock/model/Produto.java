package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUTOS")
public class Produto extends AbstractEntity<Long>{

    @Getter @Setter
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Por favor, informe um nome")
    private String nome;

    @Getter @Setter
    @Column(name = "preco_venda", columnDefinition = "Decimal(7, 2)", nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,#00.00")
    @NotNull(message = "Por favor, informe o preço de venda do produto")
    private BigDecimal precoDeVenda;

    @Getter @Setter
    @Column(name = "quantidade_em_estoque", nullable = false)
    @NotNull(message = "Por favor, informe a quantidade em estoque")
    private Integer quantidadeEmEstoque;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_empresa_fk")
    @NotNull(message = "Selecione a empresa")
    private Empresa empresa;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_categoria_fk")
    @NotNull(message = "Por favor, selecione a categoria do produto")
    private Categoria categoria;

    public void darBaixaEmEstoque(int quantidade){
        if(this.getQuantidadeEmEstoque() < quantidade){
            throw  new QuantidadeEmEstoqueException("Quantidade em estoque inferior ao pedido." +
                    " Verifique a quantidade.");
        }
        this.setQuantidadeEmEstoque(this.getQuantidadeEmEstoque() - quantidade);
    }
}
