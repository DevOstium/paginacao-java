package com.fagnerlira.pagincao.LDAP.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fagnerlira.pagincao.LDAP.domain.UserAD;

@Repository
public interface UserADRepository {

	public List<UserAD> findAll();

	public List<UserAD> findUserByLogin(String login);
}
