package com.cyrus.demo.account.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cyrus.demo.account.dao.DSWDao;
import com.cyrus.demo.account.service.DSWService;
import com.cyrus.demo.domain.DataSourceConfig;
import com.cyrus.demo.domain.Role;

@Service
public class DSWServiceImpl implements DSWService {

	@SuppressWarnings("unused")
	@Autowired
	private DSWDao dswDao;

	@Override
	@Cacheable
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

	@Override
	public List<DataSourceConfig> getDataSourceConfigs(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataSourceConfig getOneDataSourceConfig(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataSource getOneDataSource(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataSourceConfig> getDataSourceConfigs() {
		// TODO Auto-generated method stub
		return null;
	}

}
