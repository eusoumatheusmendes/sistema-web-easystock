package br.com.mmsoftwares.easystock.dao;

import br.com.mmsoftwares.easystock.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
}
