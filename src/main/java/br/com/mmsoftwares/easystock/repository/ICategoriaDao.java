package br.com.mmsoftwares.easystock.repository;

import br.com.mmsoftwares.easystock.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaDao extends JpaRepository<Categoria, Long> {
}
