package com.cyrus.demo.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyrus.demo.account.dao.RoleDao;
import com.cyrus.demo.account.service.RoleService;
import com.cyrus.demo.domain.Role;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role getByPK(Long id) {
		return roleDao.getByPK(id);
	}

	@Override
	public Role getRole(Role role) {
		return roleDao.getRole(role);
	}

	@Override
	public int add(Role role) {
		return roleDao.add(role);
	}

}
