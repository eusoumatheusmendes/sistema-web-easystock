package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUTOS")
public class Produto extends AbstractEntity<Long>{

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String nome;

    @Getter @Setter
    @Column(name = "preco_venda", columnDefinition = "Decimal(7, 2)", nullable = false)
    private BigDecimal precoDeVenda;

    @Getter @Setter
    @Column(name = "quantidade_em_estoque", nullable = false)
    private Integer quantidadeEmEstoque;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_empresa_fk")
    private Empresa empresa;

}
