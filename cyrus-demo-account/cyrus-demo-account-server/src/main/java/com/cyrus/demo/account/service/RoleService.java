package com.cyrus.demo.account.service;

import com.cyrus.demo.domain.Role;

public interface RoleService {

	public Role getByPK(Long id);

	public Role getRole(Role role);

	public int add(Role role);

}
