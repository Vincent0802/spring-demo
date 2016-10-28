package com.cyrus.demo.account.service.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cyrus.demo.account.service.DSWService;
import com.cyrus.demo.account.service.DataSourceService;
import com.cyrus.demo.base.datasource.DataSourceProxy;
import com.cyrus.demo.domain.DataSourceConfig;

/**
 * @Description: 数据源Service的实现类
 *
 * @author wudan
 *
 * @time: 2016年10月19日 下午6:08:55
 *
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {

	@Autowired
	private DSWService dswService;

	private final Map<Long, DataSource> dataSources = null;

	@Override
	public List<DataSourceConfig> getDataSourceConfigs() {
		return dswService.getDataSourceConfigs();
	}

	@Override
	@Cacheable
	public DataSourceConfig getOneDataSourceConfig(Long id) {
		return dswService.getOneDataSourceConfig(id);
	}

	@Override
	@Cacheable
	public DataSource getDataSourceProxy(Long id) {
		DataSourceConfig dataSourceConfig = getOneDataSourceConfig(id);
		DataSourceProxy dataSourceProxy = new DataSourceProxy();
		DataSource dataSource = dataSourceProxy.buildDataSource(dataSourceConfig);
		this.dataSources.put(id, dataSource);
		return dataSource;
	}

}
