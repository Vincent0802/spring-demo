package com.cyrus.demo.account.service;

import java.util.List;

import javax.sql.DataSource;

import com.cyrus.demo.domain.DataSourceConfig;
import com.cyrus.demo.domain.Role;

public interface DSWService {

	public Role getDSW(Long id);

	public Role getRole(Role role);

	public int add(Role role);

	public List<Role> getList();

	public List<DataSourceConfig> getDataSourceConfigs(Long id);

	public DataSourceConfig getOneDataSourceConfig(Long id);

	public DataSource getOneDataSource(Long id);

	public List<DataSourceConfig> getDataSourceConfigs();
}
