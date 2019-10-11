package com.money.moneyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.moneyapi.model.Lancamento;
import com.money.moneyapi.model.Pessoa;
import com.money.moneyapi.repository.LancamentoRepository;
import com.money.moneyapi.repository.PessoaRepository;
import com.money.moneyapi.service.exception.PessoaInexisteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository; 
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexisteOuInativaException();
		}
		return lancamentoRepository.save(lancamento);
	}

}
