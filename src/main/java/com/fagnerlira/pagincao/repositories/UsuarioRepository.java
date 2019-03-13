package com.fagnerlira.pagincao.repositories;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fagnerlira.pagincao.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Transactional
	Page<Usuario> findDistinctByNomeContainingIgnoreCase( @Param("nome") String nome, Pageable pageRequest);
	
}
