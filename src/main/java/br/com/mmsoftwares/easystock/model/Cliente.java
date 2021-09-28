package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTES")
public class Cliente extends AbstractEntity<Long> {

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String nome;

    @Getter @Setter
    @Column(nullable = false, length = 11)
    private String numeroDeTelefone;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String email;

    @Getter @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_fk")
    private Endereco endereco;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_empresa_fk")
    private Empresa empresa;
}
