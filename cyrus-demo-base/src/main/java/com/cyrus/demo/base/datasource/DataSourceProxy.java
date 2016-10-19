package com.cyrus.demo.base.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;

public class DataSourceProxy {

	private DruidDataSource dataSource;

	public DataSourceProxy() {
		super();
	}

	public DataSourceProxy(DruidDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
