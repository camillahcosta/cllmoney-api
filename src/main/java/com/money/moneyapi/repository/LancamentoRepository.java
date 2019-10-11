package com.money.moneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.money.moneyapi.model.Lancamento;
import com.money.moneyapi.repository.lancamento.LancamentoRepositoryQuery;


public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{

}
