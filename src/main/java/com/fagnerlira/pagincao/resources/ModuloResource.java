package com.fagnerlira.pagincao.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fagnerlira.pagincao.domain.Modulo;
import com.fagnerlira.pagincao.services.ModuloService;

@RestController
@RequestMapping(value = "/modulos")
public class ModuloResource {

	@Autowired
	private ModuloService service;

	@GetMapping
	public ResponseEntity<List<String>> findAll() {
		 List<String> list = service.findAll().stream().map( x -> new String(x.getNome()) ).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(list);
	}
	
}
