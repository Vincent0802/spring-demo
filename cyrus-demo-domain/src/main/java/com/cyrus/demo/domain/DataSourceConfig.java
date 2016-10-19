package com.cyrus.demo.domain;

public class DataSourceConfig {

	private final static String TYPE = "com.alibaba.druid.pool.DruidDataSource";

	private final static String DRIVER = "com.mysql.jdbc.Driver";

	private final static String URL = "jdbc:mysql://localhost/cyrus_demo?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=round";

	private final static String USERNAME = "root";

	private final static String PASSWORD = "root";

	private final static int INITIAL_SIZE = 3;

	private final static int MIN_IDLE = 1;

	private final static int MAX_ACTIVE = 20;

	private final static int MAX_IDLE = 20;

	private final static int TIME_BETWEEN_EVICTION_RUNS_MILLIS = 60000;

	private final static String VALIDATION_QUERY = "select 1";

	private final static boolean TEST_WHILE_IDLE = true;

	private final static boolean POOL_PREPARED_STATEMENTS = true;

	private final static int MAX_POOL_PREPARED_STATEMENT_PERCONNECTION_SIZE = 20;

	private String type = TYPE;

	private String driver = DRIVER;

	private String url = URL;

	private String username = USERNAME;

	private String password = PASSWORD;

	private int initialSize = INITIAL_SIZE;

	private int minIdle = MIN_IDLE;

	private int maxActive = MAX_ACTIVE;

	private int maxIdle = MAX_IDLE;

	private int timeBetweenEvictionRunsMillis = TIME_BETWEEN_EVICTION_RUNS_MILLIS;

	private String validationQuery = VALIDATION_QUERY;

	private boolean testWhileIdle = TEST_WHILE_IDLE;

	private boolean poolPreparedStatements = POOL_PREPARED_STATEMENTS;

	private int maxPoolPreparedStatementPerConnectionSize = MAX_POOL_PREPARED_STATEMENT_PERCONNECTION_SIZE;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public boolean isPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public void setPoolPreparedStatements(boolean poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}

	public int getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}

	public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
		this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
	}

}
