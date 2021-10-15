package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_de_cadastro")
    private LocalDate dataDeCadastro;

    @Getter @Setter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    @Column(name = "data_de_nascimento", columnDefinition = "DATE")
    private LocalDate dataDeNascimento;

    public boolean ehAniversarianteDoDia(){
        Month mesDeNascimento = this.dataDeNascimento.getMonth();
        int diaDeNascimento = this.dataDeNascimento.getDayOfMonth();
        return LocalDate.now().getDayOfMonth() ==
                diaDeNascimento && LocalDate.now().getMonth() == mesDeNascimento;
    }
}
