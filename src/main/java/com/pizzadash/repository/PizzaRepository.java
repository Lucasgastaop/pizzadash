package com.pizzadash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzadash.model.PizzaModel;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaModel, Long> {}
