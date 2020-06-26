package com.vitorlipe.demoajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorlipe.demoajax.domain.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {
	
	
	
}
