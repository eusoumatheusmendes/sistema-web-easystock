package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "PEDIDOS")
@Entity
public class Pedido extends AbstractEntity<Long>{

    @Getter @Setter
    private Integer quantidade;

    @Getter @Setter
    private BigDecimal precoTotal;

    @Getter @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_de_cadastro", nullable = false)
    private LocalDate dataDeCadastro;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_cliente_fk")
    private Cliente cliente;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_produto_fk")
    private Produto produto;

}
