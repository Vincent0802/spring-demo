package com.cyrus.demo.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyrus.demo.account.dao.DSWDao;
import com.cyrus.demo.account.service.DSWService;
import com.cyrus.demo.domain.Role;

@Service
public class DSWServiceImpl implements DSWService {

	@Autowired
	private DSWDao dswDao;

	@Override
	public Role getDSW(Long id) {
		return dswDao.getDSW(id);
	}

	@Override
	public Role getRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
