package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.dao.IEmpresaDao;
import br.com.mmsoftwares.easystock.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class EmpresaService implements IEmpresaService{

    @Autowired
    private IEmpresaDao dao;

    @Override
    public void salvar(Empresa empresa) {
        dao.save(empresa);
    }

    @Override
    public void atualizar(Empresa empresa) {
        dao.save(empresa);
    }

    @Override
    public void excluir(Empresa empresa) {
        dao.delete(empresa);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Empresa> buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Empresa> buscarTodas() {
        return dao.findAll();
    }
}
