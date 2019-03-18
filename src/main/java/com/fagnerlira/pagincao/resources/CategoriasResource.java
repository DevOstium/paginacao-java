package com.fagnerlira.pagincao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fagnerlira.pagincao.domain.Categoria;
import com.fagnerlira.pagincao.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasResource {

	@Autowired
	private CategoriaRepository service;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria>       list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
