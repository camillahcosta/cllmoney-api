package com.money.moneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.money.moneyapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
}
