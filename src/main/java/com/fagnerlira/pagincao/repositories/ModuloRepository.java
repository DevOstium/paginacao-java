package com.fagnerlira.pagincao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fagnerlira.pagincao.domain.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Integer> {

	
}
