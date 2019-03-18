package com.fagnerlira.pagincao.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fagnerlira.pagincao.domain.Categoria;
import com.fagnerlira.pagincao.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> findDistinctByNomeContainingIgnoreCaseAndCategoriasIn(
																		 @Param("nome")       String           nome,
																		 @Param("categorias") List<Categoria>  categorias,
																		  Pageable                             pageRequest
																		);
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome%")
	Page<Produto> findDistinctByNomeContainingIgnoreCaseAndCategorias(@Param("nome") String nome, Pageable pageRequest);
	
}
