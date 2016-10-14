package com.cyrus.demo.account.dao;

import org.springframework.stereotype.Repository;

import com.cyrus.demo.base.dao.BaseDao;
import com.cyrus.demo.domain.Role;

@Repository
public class RoleDao extends BaseDao{

	@Override
	public String getMapperNamespace() {
		return Role.class.getName();
	}
	
	@SuppressWarnings("unchecked")
	public Role getByPK(Long id) {
		return getByPK(id);
	}
	
	public Role getRole(Role role) {
		return selectOne("getByName" ,role);
	}

	public int add(Role role) {
		return insert("add" ,role);
	}
	
}
