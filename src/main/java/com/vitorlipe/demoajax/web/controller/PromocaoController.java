package com.vitorlipe.demoajax.web.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vitorlipe.demoajax.domain.Categoria;
import com.vitorlipe.demoajax.domain.Promocao;
import com.vitorlipe.demoajax.service.CategoriaService;
import com.vitorlipe.demoajax.service.PromocaoService;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	Logger log  =  LoggerFactory.getLogger(PromocaoController.class);
	
	@Autowired
	CategoriaService CategoriaService;
	
	@Autowired
	PromocaoService promocaoService; 
	
	
	@GetMapping("/add")
	public String abrirCadastro() {
		return "promo-add";
	}
	
	
	@PostMapping("/salvar")
	public ResponseEntity<Promocao> salvar(Promocao promocao) {
		try {
			
			promocao.setDataCadastro(new Date());
			
			promocaoService.salvar(promocao);
			
			return ResponseEntity.ok().build();
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias(){
		return CategoriaService.listarTodos();
	}

}
