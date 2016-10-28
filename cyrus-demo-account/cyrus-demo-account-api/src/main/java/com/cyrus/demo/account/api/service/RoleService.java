package com.cyrus.demo.account.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyrus.demo.base.module.rest.AccountRestService;
import com.cyrus.demo.domain.Role;

@Service
public class RoleService extends AccountRestService{

	public Role getByPK(Long id) {
		return getForObject("/role/get/" + id, Role.class);
	}
	
	public Role getRole(Role role) {
		return postForObject("/role/get-role" ,role , Role.class);
	}
	
	public int add(Role role) {
		return postForObject("/role/add" ,role , int.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getList(List<Role> roles) {
		return postForObject("/role/list" ,roles , List.class);
	}
	
}
