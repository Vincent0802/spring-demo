package com.cyrus.demo.base.core.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;

public abstract class AbstractRestService {
	private static ThreadLocal<RestTemplate> restThreadLocal = new ThreadLocal<RestTemplate>() {
		protected synchronized RestTemplate initialValue() {
			return new RestTemplate();
		}
	};

	/**
	 * 得到域名和端口号
	 * 
	 * @return 形如127.0.0.1:xxxx
	 */
	protected abstract String getBaseUrl();

	/**
	 * 获取Session的ID
	 * 
	 * @return Session的ID的String对象
	 */
	protected String getSessionId() {
		return RequestContextHolder.getRequestAttributes().getSessionId();
	}

	/**
	 * 得到当前的RestTemplate对象
	 * 
	 * @return 当前的RestTemplate对象
	 */
	private static RestTemplate getRestTemplate() {
		return restThreadLocal.get();
	}

	/**
	 * 格式化URL
	 * 
	 * @param url
	 * @return 形如127.0.0.1:8080/account/user/list
	 */
	protected String getUrl(String url) {
		return String.format("%s%s?sid=%s", getBaseUrl(), url, getSessionId());
	}

	/**
	 * 获取数据
	 * 
	 * @param url
	 *            URL字段
	 * @param responseType
	 *            返回值类型
	 * @return
	 */
	public <T> T getForObject(String url, Class<T> responseType) throws RestClientException {
		return getRestTemplate().getForObject(getUrl(url), responseType);
	}

	public <T> T getForObject(String url, Class<T> responseType, Map<String, Object> urlVariables)
			throws RestClientException {
		return getRestTemplate().getForObject(getUrl(url), responseType, urlVariables);
	}

	public <T> T getForObject(String url, Class<T> responseType, Object... urlVariables) throws RestClientException {
		return getRestTemplate().getForObject(getUrl(url), responseType, urlVariables);
	}

	public <T> T getForEntity(String url, Class<T> responseType) throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().getForEntity(getUrl(url), responseType);
		return entity.getBody();
	}

	public <T> T getForEntity(String url, Class<T> responseType, Map<String, Object> urlVariables)
			throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().getForEntity(getUrl(url), responseType, urlVariables);
		return entity.getBody();
	}

	public <T> T getForEntity(String url, Class<T> responseType, Object... urlVariables) throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().getForEntity(getUrl(url), responseType, urlVariables);
		return entity.getBody();
	}

	/**
	 * 提交数据
	 * 
	 * @param url
	 *            URL字段
	 * @param request
	 *            被POST的数据
	 * @param responseType
	 *            返回类型
	 * @return
	 */
	public <T> T postForObject(String url, Object request, Class<T> responseType) throws RestClientException {
		return getRestTemplate().postForObject(getUrl(url), request, responseType);
	}

	public <T> T postForObject(String url, Object request, Class<T> responseType, Map<String, Object> uriVariables)
			throws RestClientException {
		return getRestTemplate().postForObject(getUrl(url), request, responseType, uriVariables);
	}

	public <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables)
			throws RestClientException {
		return getRestTemplate().postForObject(getUrl(url), request, responseType, uriVariables);
	}

	public <T> T postForEntity(String url, Object request, Class<T> responseType) throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().postForEntity(getUrl(url), request, responseType);
		return entity.getBody();
	}

	public <T> T postForEntity(String url, Object request, Class<T> responseType, Map<String, Object> uriVariables)
			throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().postForEntity(getUrl(url), request, responseType, uriVariables);
		return entity.getBody();
	}

	public <T> T postForEntity(String url, Object request, Class<T> responseType, Object... uriVariables)
			throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().postForEntity(getUrl(url), request, responseType, uriVariables);
		return entity.getBody();
	}

	/**
	 * Delete
	 * 
	 * @param url
	 *            URL字段
	 * @param urlVariables
	 *            模板中的变量扩展
	 * @throws RestClientException
	 */
	public void delete(String url) {
		getRestTemplate().delete(getUrl(url));
	}

	public void delete(String url, Object... urlVariables) throws RestClientException {
		getRestTemplate().delete(getUrl(url), urlVariables);
	}

	public void delete(String url, Map<String, Object> urlVariables) throws RestClientException {
		getRestTemplate().delete(getUrl(url), urlVariables);
	}

	/**
	 * Put
	 * 
	 * @param url
	 *            URL字段
	 * @param request
	 *            被PUT的值
	 */
	public void put(String url, Object request) throws RestClientException {
		getRestTemplate().put(getUrl(url), request);
	}

	public void put(String url, Object request, Object... urlVariables) throws RestClientException {
		getRestTemplate().put(getUrl(url), request, urlVariables);
	}

	public void put(String url, Object request, Map<String, Object> urlVariables) throws RestClientException {
		getRestTemplate().put(getUrl(url), request, urlVariables);
		;
	}

}
