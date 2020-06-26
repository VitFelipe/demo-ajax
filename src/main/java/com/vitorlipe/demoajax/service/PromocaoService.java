package com.vitorlipe.demoajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorlipe.demoajax.domain.Promocao;
import com.vitorlipe.demoajax.repository.PromocaoRepository;

@Service
public class PromocaoService {

	@Autowired
	private PromocaoRepository promocaoRepository;

	public Promocao salvar(Promocao promocao) {
		return promocaoRepository.save(promocao);
	}

	public Promocao findId(Integer promocaoId) {
		return promocaoRepository.getOne(promocaoId);
	}

	public void remover(Integer promocaoId) {
		promocaoRepository.deleteById(promocaoId);
	}

	public List<Promocao> listarTodos() {
		return promocaoRepository.findAll();
	}

}
