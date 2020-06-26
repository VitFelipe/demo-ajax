package com.vitorlipe.demoajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorlipe.demoajax.domain.Categoria;
import com.vitorlipe.demoajax.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria salvar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Categoria findId(Integer categoriaId) {
		return categoriaRepository.getOne(categoriaId);
	}

	public void remover(Integer categoriaId) {
		categoriaRepository.deleteById(categoriaId);
	}

	public List<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}

}
