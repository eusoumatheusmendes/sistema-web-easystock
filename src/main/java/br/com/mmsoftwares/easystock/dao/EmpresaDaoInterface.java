package br.com.mmsoftwares.easystock.dao;

import br.com.mmsoftwares.easystock.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaDaoInterface extends JpaRepository<Empresa, Long> {
}
