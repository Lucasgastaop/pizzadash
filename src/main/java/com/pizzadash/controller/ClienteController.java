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

import com.pizzadash.model.ClienteModel;
import com.pizzadash.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired private ClienteService service;
 
    @GetMapping
    public List<ClienteModel> listar() { 
    	return service.listarTodos(); 
    	}
 
    @PostMapping
    public ResponseEntity<ClienteModel> criar(@RequestBody ClienteModel c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(c));
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizar(@PathVariable Long id, @RequestBody ClienteModel c) {
        return ResponseEntity.ok(service.atualizar(id, c));
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
