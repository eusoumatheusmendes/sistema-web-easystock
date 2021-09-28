package br.com.mmsoftwares.easystock.dao;

import br.com.mmsoftwares.easystock.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoDao extends JpaRepository<Produto, Long> {
}
