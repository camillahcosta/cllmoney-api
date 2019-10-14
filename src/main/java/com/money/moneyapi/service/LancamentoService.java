package com.money.moneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		
		Lancamento lancamentoSalvo = buscarLancamentoExistente(codigo);	
		if(!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
			validarPessoa(lancamento);
		}
		
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		return lancamentoRepository.save(lancamentoSalvo);
		
	}

	private void validarPessoa(Lancamento lancamento) {
		Pessoa pessoa = null;
		if(lancamento.getPessoa().getCodigo() !=null) {
			pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
			
		}
		if (pessoa ==null || pessoa.isInativo()) {
			throw new PessoaInexisteOuInativaException();
		}
	}

	private Lancamento buscarLancamentoExistente(Long codigo) {
		Lancamento lancamentoEncontrado = lancamentoRepository.findOne(codigo);
		
		if (lancamentoEncontrado == null){
			throw new EmptyResultDataAccessException(1);
		}
		return lancamentoEncontrado;
	}
	

}
