package com.cyrus.demo.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyrus.demo.account.dao.UserDao;
import com.cyrus.demo.account.service.UserService;
import com.cyrus.demo.domain.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getByPK(Long id) {
		return userDao.getByPK(id);
	}

	@Override
	public User getNyName(String name) {
		return userDao.getNyName(name);
	}

	@Override
	public int add(User user) {
		User demo = new User();
		demo = userDao.getNyName(user.getName());
		if(demo == null)
			return userDao.add(user);
		else
			return 0;
	}

}
