package com.cyrus.demo.account.dao;

import org.springframework.stereotype.Repository;

import com.cyrus.demo.base.dao.BaseDao;
import com.cyrus.demo.domain.User;

@Repository
public class UserDao extends BaseDao {

	@Override
	public String getMapperNamespace() {
		return User.class.getName();
	}
	
	@SuppressWarnings("unchecked")
	public User getByPK(Long id) {
		return getByPK(id);
	}
	
	public User getNyName(String name) {
		return selectOne("getByName" ,name);
	}

	public int add(User user) {
		return insert("add" ,user);
	}


}
