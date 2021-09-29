package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.dao.ICategoriaDao;
import br.com.mmsoftwares.easystock.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService{

    @Autowired
    private ICategoriaDao dao;

    @Override
    public void salvar(Categoria categoria) {
        dao.save(categoria);
    }

    @Override
    public void atualizar(Categoria categoria) {
        dao.save(categoria);
    }

    @Override
    public void excluir(Categoria categoria) {
        dao.delete(categoria);
    }


    @Transactional(readOnly = true)
    public Optional<Categoria> busarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Categoria> buscarTodos() {
        return dao.findAll();
    }
}
