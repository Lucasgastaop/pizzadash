package com.pizzadash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzadash.model.PizzaModel;
import com.pizzadash.service.PizzaService;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    @Autowired private PizzaService service;
 
    @GetMapping
    public List<PizzaModel> listar() { 
    	return service.listarTodas(); 
    	}
 
    @PostMapping
    public ResponseEntity<PizzaModel> criar(@RequestBody PizzaModel p) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(p));
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<PizzaModel> atualizar(@PathVariable Long id, @RequestBody PizzaModel p) {
        return ResponseEntity.ok(service.atualizar(id, p));
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
