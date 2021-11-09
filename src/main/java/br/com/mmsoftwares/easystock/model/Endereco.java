package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long>{

    @Getter @Setter
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Por favor, informe o logradouro")
    private String logradouro;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Por favor, informe o bairro")
    private String bairro;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    @NotNull(message = "Por favor, informe um número")
    private Integer numero;

    @Getter @Setter
    @Column(length = 100)
    private String complemento;
}
