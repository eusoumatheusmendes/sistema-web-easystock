package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long>{

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String logradouro;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String bairro;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private Integer numero;

    @Getter @Setter
    @Column(length = 100)
    private String complemento;
}
