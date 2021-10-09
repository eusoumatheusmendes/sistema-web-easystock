package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

    @Getter @Setter
    @Column(name = "data_de_cadastro")
    private LocalDate dataDeCadastro;


}
