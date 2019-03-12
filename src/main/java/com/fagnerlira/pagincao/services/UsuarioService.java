package com.fagnerlira.pagincao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fagnerlira.pagincao.domain.Usuario;
import com.fagnerlira.pagincao.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Page<Usuario> findPage(
									Integer page,
									Integer linesPerPage,
									String  orderBy,
									String  direction
									){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
	return	repo.findAll(pageRequest);
		
	}

	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
}
