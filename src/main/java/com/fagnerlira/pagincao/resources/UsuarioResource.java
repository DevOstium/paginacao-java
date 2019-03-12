package com.fagnerlira.pagincao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fagnerlira.pagincao.domain.Usuario;
import com.fagnerlira.pagincao.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario>       list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// page=2 -- página 2 do total de 5 páginas
	// URL: http://localhost:8080/page?linesPerPage=3&page=2&orderBy=campo_do_banco&direction=ASC ou DESC
	// @RequestParam fica como parametros opcional
	// 24 é muiltiplo de 1 , 2 , 3, 4 
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Usuario>> findPage (
													@RequestParam(value = "page",          defaultValue = "0")     Integer  page,
													@RequestParam(value = "linesPerPage",  defaultValue = "24")    Integer  linesPerPage,
													@RequestParam(value = "orderBy",       defaultValue = "nome")  String   orderBy,
													@RequestParam(value = "direction",     defaultValue = "ASC")   String   direction
											      ) {

		Page<Usuario> list = service.findPage(page, linesPerPage, orderBy, direction);

		return ResponseEntity.ok().body(list);
	}

}
