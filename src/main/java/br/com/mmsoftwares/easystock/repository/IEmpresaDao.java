package br.com.mmsoftwares.easystock.repository;

import br.com.mmsoftwares.easystock.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaDao extends JpaRepository<Empresa, Long> {
}
