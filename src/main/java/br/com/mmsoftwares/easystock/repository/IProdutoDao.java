package br.com.mmsoftwares.easystock.repository;

import br.com.mmsoftwares.easystock.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IProdutoDao extends JpaRepository<Produto, Long> {

    Collection<Produto> findByNomeContains(String nome);

    @Query("Select p From Produto p Where p.quantidadeEmEstoque < 5")
    Collection<Produto> trazerTodosOsProdutosQuePossuemMenosDeCincoQuantidadeEmEstoque();
}
