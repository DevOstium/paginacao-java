package com.fagnerlira.pagincao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fagnerlira.pagincao.domain.Modulo;
import com.fagnerlira.pagincao.repositories.ModuloRepository;

@Service
public class ModuloService {

	@Autowired
	private ModuloRepository repo;
	
	public List<Modulo> findAll() {
		return repo.findAll();
	}
	
}
