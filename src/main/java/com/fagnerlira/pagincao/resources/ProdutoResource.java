package com.fagnerlira.pagincao.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fagnerlira.pagincao.domain.Produto;
import com.fagnerlira.pagincao.services.ProdutoService;
import com.fagnerlira.pagincao.util.URL;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto>       list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//http://localhost:8080/produtos/paginacao/?categorias=1,3
	@RequestMapping(value="/paginacao", method=RequestMethod.GET)
	public ResponseEntity<Page<Produto>> findPage (
													@RequestParam(value = "nome",             defaultValue = "")      String   nome,
													@RequestParam(value = "categorias",       defaultValue = "")      String   paramCategorias,
													@RequestParam(value = "pagina",           defaultValue = "0")     Integer  page,
													@RequestParam(value = "linhasPorPagina",  defaultValue = "24")    Integer  linesPerPage,
													@RequestParam(value = "orderBy",          defaultValue = "id")    String   orderBy,
													@RequestParam(value = "direction",        defaultValue = "ASC")   String   direction
											      ) {

		String        nomeDecoded  = URL.decodeParam(nome.toLowerCase());
		
		List<Integer> categoriasID = new ArrayList<>();
		
		if(!paramCategorias.isEmpty()) {
			categoriasID = Arrays.asList(paramCategorias.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		} else {
			categoriasID = null;
		}
		
		Page<Produto> list = service.findPage(nomeDecoded, categoriasID, paramCategorias,  page, linesPerPage, orderBy, direction);

		return ResponseEntity.ok().body(list);
	}

}
