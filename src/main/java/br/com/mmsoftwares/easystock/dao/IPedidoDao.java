package br.com.mmsoftwares.easystock.dao;

import br.com.mmsoftwares.easystock.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IPedidoDao extends JpaRepository<Pedido, Long> {

    Collection<Pedido> findByClienteNomeContains(String nome);

}
