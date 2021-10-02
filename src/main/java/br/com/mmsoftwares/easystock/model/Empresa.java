package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESAS")
public class Empresa extends AbstractEntity<Long>{

    @Getter @Setter
    @Column(length = 100, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(length = 100, nullable = false, unique = true)
    private String cnpj;

    @Getter @Setter
    @Column(length = 11, nullable = false, unique = true)
    private String numeroDoWhatsapp;

    @Getter @Setter
    @Column(length = 100, unique = true)
    private String chavePix;

    @Getter @Setter
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Getter @Setter
    @Column(length = 11, nullable = false)
    private String senha;



}
