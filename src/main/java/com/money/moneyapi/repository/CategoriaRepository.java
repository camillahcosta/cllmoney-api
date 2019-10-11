package com.money.moneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.money.moneyapi.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
