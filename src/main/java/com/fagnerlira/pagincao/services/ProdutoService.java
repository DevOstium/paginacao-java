package com.fagnerlira.pagincao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fagnerlira.pagincao.domain.Categoria;
import com.fagnerlira.pagincao.domain.Produto;
import com.fagnerlira.pagincao.repositories.CategoriaRepository;
import com.fagnerlira.pagincao.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository cat;
	
	public List<Produto> findAll() {
		return repo.findAll();
	}

	public Page<Produto> findPage(
									String        nome,
									List<Integer> categoriasID,
									String        paramCategorias,
									Integer       page,
									Integer       linesPerPage,
									String        orderBy,
									String        direction
									){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		if(categoriasID != null  ) {
			       List<Categoria> categorias = cat.findAllById(categoriasID);
			return repo.findDistinctByNomeContainingIgnoreCaseAndCategoriasIn(nome, categorias, pageRequest );	
		} else {
			return repo.findDistinctByNomeContainingIgnoreCaseAndCategorias(nome, pageRequest );	
		}
		
		
	}

	
}
