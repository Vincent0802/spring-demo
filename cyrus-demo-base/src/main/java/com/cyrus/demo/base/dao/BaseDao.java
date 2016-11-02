package com.cyrus.demo.base.dao;

import org.springframework.stereotype.Repository;

import com.cyrus.demo.base.core.models.DataSourceResult;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 通用的DAO类，数据业务的处理，包含增删改查
 *
 * @author Cyrus
 *
 * @time: 2016年8月22日 下午4:28:42
 *
 */

@Repository
public abstract class BaseDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private SqlSession getSqlSession() {
		return sqlSessionTemplate;
	}

	public abstract String getMapperNamespace();

	public <E> List<E> getAll() {
		return getSqlSession().selectList(getStatement("getAll"));
	}

	public <T> T getByPK(Long id) {
		return getSqlSession().selectOne(getStatement("getByPK"), id);
	}

	public int deleteByPK(Long id) {
		return getSqlSession().delete(getStatement("delByPK"), id);
	}

	public int updateByPK(Long id) {
		return getSqlSession().update(getStatement("updateByPK"), id);
	}

	public <T> T selectOne(String paramString, Object paramObject) {
		return getSqlSession().selectOne(getStatement(paramString), paramObject);
	}

	public <T> T selectOne(String paramString) {
		return getSqlSession().selectOne(getStatement(paramString));
	}

	public <E> List<E> selectList(String paramString) {
		return getSqlSession().selectList(getStatement(paramString));
	}

	public <E> List<E> selectList(String paramString, Object paramObject) {
		return getSqlSession().selectList(getStatement(paramString), paramObject);
	}

	public DataSourceResult selectPage(String paramString, String totalString, Object paramObject) {
		DataSourceResult result = new DataSourceResult();
		result.setData(selectList(paramString, paramObject));
		result.setTotal((Long) selectOne(totalString, paramObject));
		return result;
	}

	public <E> List<E> selectList(String paramString, Object paramObject, RowBounds paramRowBounds) {
		return getSqlSession().selectList(getStatement(paramString), paramObject, paramRowBounds);
	}

	public int insert(String paramString) {
		return getSqlSession().insert(getStatement(paramString));
	}

	public int insert(String paramString, Object paramObject) {
		return getSqlSession().insert(getStatement(paramString), paramObject);
	}

	public int update(String paramString) {
		return getSqlSession().update(getStatement(paramString));
	}

	public int update(String paramString, Object paramObject) {
		return getSqlSession().update(getStatement(paramString), paramObject);
	}

	public int delete(String paramString) {
		return getSqlSession().delete(getStatement(paramString));
	}

	public int delete(String paramString, Object paramObject) {
		return getSqlSession().delete(getStatement(paramString), paramObject);
	}

	private String getStatement(String statement) {
		return getMapperNamespace() + "." + statement;
	}

}
