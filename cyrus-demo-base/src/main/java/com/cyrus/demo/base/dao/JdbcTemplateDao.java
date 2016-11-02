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
import org.springframework.jdbc.core.RowMapper;

import com.cyrus.demo.domain.DataSourceConfig;

public class JdbcTemplateDao {

	/*@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private DataSourceProxy dataSourceProxy;

	public void setDataSource(DataSourceProxy dataSourceProxy) {
		this.dataSourceProxy = dataSourceProxy;
	}*/
	
	@Autowired
	private static Logger logger = LoggerFactory.getLogger(JdbcTemplateDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 根据DB的id查询数据源
	 * 
	 * @param id
	 *            DB的id
	 * @return DataSourceConfig
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSourceConfig getOneDataSourceConfig(Long id) {
		String sql = "SELECT * FROM DATASOURCE WHERE ID=" + id;
        return (DataSourceConfig) jdbcTemplate.queryForObject(sql, new RowMapper(){

            @Override
            public DataSourceConfig mapRow(ResultSet rs, int rowNum) throws SQLException {
            	DataSourceConfig dsc = new DataSourceConfig();
                dsc.setDriver(rs.getString("DRIVER"));
                dsc.setUrl(rs.getString("URL"));
                return dsc;
            }

        });
	}

	public Object query(String sql, DataSource dataSource) {
		Connection conn = null;
		Statement stat = null;
		ResultSet resultSet = null;
		DataSourceConfig dsc = new DataSourceConfig();
		try {
			conn = dataSource.getConnection();
			System.out.println("得到了数据库连接");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取数据库连接失败");
			throw new RuntimeException("获取数据库连接失败");
		}
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Statement创建失败");
			// 放回连接
			throw new RuntimeException("Statement创建失败");
		}
		try {
			resultSet = stat.executeQuery(sql);
			while (resultSet.next()) {
				String url = resultSet.getString("URL");
				String driver = resultSet.getString("DRIVER");
				dsc.setUrl(url);
				dsc.setDriver(driver);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查询数据库失败");
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
		System.out.println("获取数据......");
		return dsc;
	}
}
