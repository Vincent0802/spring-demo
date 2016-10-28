package com.cyrus.demo.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cyrus.demo.domain.DataSourceConfig;

/**
 * @Description: 操作数据库的DAO类
 *
 * @author wudan
 *
 * @time: 2016年10月19日 下午6:06:47
 *
 */
@Repository
public class DataSourceDao {

	/**
	 * 得到所有数据源
	 * 
	 * @return DataSourceConfig的List列表
	 */
	public List<DataSourceConfig> getDataSourceConfigs() {
		List<DataSourceConfig> dataSources = new ArrayList<DataSourceConfig>();

		return dataSources;// TODO
	}

	/**
	 * 根据DB的id查询数据源
	 * 
	 * @param id
	 *            DB的id
	 * @return DataSourceConfig
	 */
	@SuppressWarnings("null")
	public DataSourceConfig getOneDataSourceConfig(Long id) {
		DataSourceConfig dataSourceConfig = null;
		String type = "com.alibaba.druid.pool.DruidDataSource";
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/cyrus_demo?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=round";
		String username = "root";
		String password = "root";
		int initialSize = 3;
		int minIdle = 1;
		int maxActive = 20;
		int maxIdle = 20;
		int timeBetweenEvictionRunsMillis = 6000;
		String validationQuery = "select 1";
		boolean testWhileIdle = true;
		boolean poolPreparedStatements = true;
		int maxPoolPreparedStatementPerConnectionSize = 20;
		dataSourceConfig.setType(type);
		dataSourceConfig.setDriver(driverClassName);
		dataSourceConfig.setUrl(url);
		dataSourceConfig.setUsername(username);
		dataSourceConfig.setPassword(password);
		dataSourceConfig.setInitialSize(initialSize);
		dataSourceConfig.setMinIdle(minIdle);
		dataSourceConfig.setMaxActive(maxActive);
		dataSourceConfig.setMaxIdle(maxIdle);
		dataSourceConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSourceConfig.setValidationQuery(validationQuery);
		dataSourceConfig.setTestWhileIdle(testWhileIdle);
		dataSourceConfig.setPoolPreparedStatements(poolPreparedStatements);
		dataSourceConfig.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		return dataSourceConfig;// TODO
	}
}
