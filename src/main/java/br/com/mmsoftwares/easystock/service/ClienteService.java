package br.com.mmsoftwares.easystock.service;

import br.com.mmsoftwares.easystock.dao.IClienteDao;
import br.com.mmsoftwares.easystock.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteDao dao;

    @Override
    public void salvar(Cliente cliente) {
        if(cliente.ehClienteNovo()){
            cliente.setDataDeCadastro(LocalDate.now());
        }
        dao.save(cliente);
    }

    @Override
    public void excluir(Cliente cliente) {
        dao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Cliente> buscarTodos() {
        Stream<Cliente> clientesOrdenadosPorMaiorValorEmCompras = dao.findAll().stream().sorted(Comparator.comparing(Cliente::getValorEmComprasConosco).reversed());
        return clientesOrdenadosPorMaiorValorEmCompras.collect(Collectors.toList());
    }

    @Override
    public Collection<Cliente> buscarPorNome(String nome) {
        return dao.findByNomeContains(nome);
    }

  }

