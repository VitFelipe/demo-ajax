package com.vitorlipe.demoajax.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.vitorlipe.demoajax.domain.Categoria;
import com.vitorlipe.demoajax.service.CategoriaService;

@Component
public class ConverterCategoria implements Converter<String,Categoria> {
	
	@Autowired
	CategoriaService categoriaService;

	@Override
	public Categoria convert(String value) {
		

		System.out.println("Converter:"+value);
		
		if(value == null) {
			return null;
		}
		return categoriaService.findId(Integer.parseInt(value));
		
	}

}
