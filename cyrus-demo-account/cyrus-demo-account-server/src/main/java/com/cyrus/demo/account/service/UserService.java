package com.cyrus.demo.account.service;

import com.cyrus.demo.domain.User;

public interface UserService {
	
	public User getByPK(Long id);
	
	public User getNyName(String name);
	
	public int add(User user);

}
