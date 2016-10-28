package com.cyrus.demo.base.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cyrus.demo.base.datasource.DataSourceProxy;
import com.cyrus.demo.domain.Role;

public class JdbcTemplateDao {

	/*@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private DataSourceProxy dataSourceProxy;

	public void setDataSource(DataSourceProxy dataSourceProxy) {
		this.dataSourceProxy = dataSourceProxy;
	}*/
	
	@Autowired
	private static Logger logger = LoggerFactory.getLogger(JdbcTemplateDao.class);

	public Object query(String sql, DataSource dataSource) {
		Connection conn = null;
		Statement stat = null;
		ResultSet resultSet = null;
		Role role = new Role();
		try {
			conn = dataSource.getConnection();
			// System.out.println("得到了数据库连接");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("获取数据库连接失败");
			throw new RuntimeException("获取数据库连接失败");
		}
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Statement创建失败");
			// 放回连接
			throw new RuntimeException("Statement创建失败");
		}
		try {
			resultSet = stat.executeQuery(sql);
			while (resultSet.next()) {
				String name = resultSet.getString("ROLENAME"); 
				role.setRolename(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("查询数据库失败");
			// 放回连接
			throw new RuntimeException("查询数据库失败");
		}
		try {
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}
}
