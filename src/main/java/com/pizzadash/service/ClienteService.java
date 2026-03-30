package com.pizzadash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzadash.model.ClienteModel;
import com.pizzadash.repository.ClienteRepository;

@Service
public class ClienteService {
 
    @Autowired
    private ClienteRepository repository;
 
    public List<ClienteModel> listarTodos() {
        return repository.findAll();
    }
 
    public Optional<ClienteModel> buscarPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }
        return repository.findById(id);
    }
 
    public ClienteModel salvar(ClienteModel cliente) {
        return repository.save(cliente);
    }
 
    public ClienteModel atualizar(Long id, ClienteModel novoCliente) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Impossível atualizar. Cliente não encontrado com o ID: " + id);
        }
        return repository.save(novoCliente);
    }
 
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Impossível deletar. Cliente não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}
