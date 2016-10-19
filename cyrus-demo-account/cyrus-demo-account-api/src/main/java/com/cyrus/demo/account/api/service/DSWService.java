package com.cyrus.demo.account.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyrus.demo.base.module.account.service.AccountRestService;
import com.cyrus.demo.domain.Role;

@Service
public class DSWService extends AccountRestService{

	public Role getDSW(Long id) {
		return getForObject("/dsw/get/" + id, Role.class);
	}
	
	public Role getRole(Role role) {
		return postForObject("/dsw/get-role" ,role , Role.class);
	}
	
	public int add(Role role) {
		return postForObject("/dsw/add" ,role , int.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getList(List<Role> roles) {
		return postForObject("/dsw/list" ,roles , List.class);
	}
	
}
