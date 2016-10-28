package com.cyrus.demo.account.api.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.cyrus.demo.base.module.rest.AccountRestService;
import com.cyrus.demo.domain.DataSourceConfig;
import com.cyrus.demo.domain.Role;

@Service
public class DSWService extends AccountRestService {

	public Role getDSW(Long id) {
		return getForObject("/dsw/get/" + id, Role.class);
	}

	public Role getRole(Role role) {
		return postForObject("/dsw/get-role", role, Role.class);
	}

	public int add(Role role) {
		return postForObject("/dsw/add", role, int.class);
	}

	@SuppressWarnings("unchecked")
	public List<Role> getList(List<Role> roles) {
		return postForObject("/dsw/list", roles, List.class);
	}

	public List<DataSourceConfig> getDataSourceConfigs() {
		return Arrays.asList(postForObject("/dsw/dsc-list", null, DataSourceConfig[].class));
	}

	public DataSourceConfig getOneDataSourceConfig(Long id) {
		return getForObject("/dsw/get-dsc/" + id, DataSourceConfig.class);
	}

	public DataSource getOneDataSource(Long id) {
		return getForObject("/dsw/get-ds/" + id, DataSource.class);
	}

	public Map<Long, DataSource> getDataSources() {
		// TODO Auto-generated method stub
		return null;
	}

}
