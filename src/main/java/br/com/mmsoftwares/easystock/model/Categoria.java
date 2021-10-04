package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIAS")
public class Categoria extends AbstractEntity<Long> {

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String nome;


}
