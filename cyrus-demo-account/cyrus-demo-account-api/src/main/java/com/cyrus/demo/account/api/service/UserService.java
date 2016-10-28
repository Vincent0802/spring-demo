package com.cyrus.demo.account.api.service;

import org.springframework.stereotype.Service;

import com.cyrus.demo.base.module.rest.AccountRestService;
import com.cyrus.demo.domain.User;

@Service
public class UserService extends AccountRestService{

	public User getByPK(Long id) {
		return getForObject("/user/get/" + id, User.class);
	}
	
	public User getNyName(User user) {
		return postForObject("/user/get-user" ,user , User.class);
	}
	
	public int add(User user) {
		return postForObject("/user/add" ,user , int.class);
	}
} 
