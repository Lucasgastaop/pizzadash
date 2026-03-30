package com.pizzadash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzadash.model.PizzaModel;
import com.pizzadash.repository.PizzaRepository;


@Service
public class PizzaService {
 
    @Autowired
    private PizzaRepository repository;
 
    public List<PizzaModel> listarTodas() {
        return repository.findAll();
    }
 
    public Optional<PizzaModel> buscarPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Pizza não encontrada com o ID: " + id);
        }
        return repository.findById(id);
    }
 
    public PizzaModel salvar(PizzaModel pizza) {
        return repository.save(pizza);
    }
 
    public PizzaModel atualizar(Long id, PizzaModel novaPizza) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Impossível atualizar. Pizza não encontrada com o ID: " + id);
        }

        return repository.save(novaPizza);
    }
 
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Impossível deletar. Pizza não encontrada com o ID: " + id);
        }
        repository.deleteById(id);
    }
}