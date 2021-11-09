package br.com.mmsoftwares.easystock.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Entity
@Table(name = "CLIENTES")
public class Cliente extends AbstractEntity<Long> {

    public Cliente(){
        this.setValorEmComprasConosco(BigDecimal.valueOf(0));
    }

    @Getter @Setter
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Por favor, informe um nome")
    private String nome;

    @Getter @Setter
    @Column(nullable = false, length = 11)
    @NotBlank(message = "Por favor, informe um número de telefone para contato")
    private String numeroDeTelefone;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Por favor, informe um e-mail válido")
    private String email;

    @Getter @Setter @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_fk")
    private Endereco endereco;

    @Getter @Setter @Valid
    @ManyToOne
    @JoinColumn(name = "id_empresa_fk")
    private Empresa empresa;

    @Getter @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_de_cadastro", nullable = false)
    private LocalDate dataDeCadastro;

    @Getter @Setter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    @Column(name = "data_de_nascimento", columnDefinition = "DATE", nullable = false)
    @NotNull(message = "Por favor, informe a data de nascimento do cliente")
    private LocalDate dataDeNascimento;

    @Getter @Setter
    private BigDecimal valorEmComprasConosco;


    public boolean ehAniversarianteDoDia(){
        Month mesDeNascimento = this.dataDeNascimento.getMonth();
        int diaDeNascimento = this.dataDeNascimento.getDayOfMonth();
        return LocalDate.now().getDayOfMonth() ==
                diaDeNascimento && LocalDate.now().getMonth() == mesDeNascimento;
    }

    public boolean ehClienteNovo(){
        return this.getId() == null;
    }

    public void adicionarValorEmCompras(BigDecimal valor, int quantidade, BigDecimal valorJaExistente){
        this.valorEmComprasConosco = new BigDecimal(0);
        BigDecimal valorDoPedido = valor.multiply(BigDecimal.valueOf(quantidade));
        BigDecimal valorTotal = this.valorEmComprasConosco.add(valorDoPedido);
        this.valorEmComprasConosco = valorTotal.add(valorJaExistente);
    }


}
