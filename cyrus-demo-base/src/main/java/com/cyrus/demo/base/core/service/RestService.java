package com.cyrus.demo.base.core.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;

import com.cyrus.demo.domain.User;

/**
 * @Description: 实现RestTemplate服务的类，包含得到数据，提交数据，删除数据和PUT数据
 *
 * @author Cloud
 *
 * @time: 2016年8月22日 下午4:44:49
 *
 */
@Service
public class RestService {

	@Autowired
	private Environment env;

	private static ThreadLocal<RestTemplate> restThreadLocal = new ThreadLocal<RestTemplate>() {
		protected synchronized RestTemplate initialValue() {
			return new RestTemplate();
		}
	};

	protected String getBaseUrl(String service) {
		return env.getProperty("service." + service + ".url");
	}

	protected String getSessionId() {
		return RequestContextHolder.getRequestAttributes().getSessionId();
	}

	protected String getUserId() {
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (obj != null && obj instanceof User) {
			return ((User) obj).getName();
		}
		return "";
	}

	private static RestTemplate getRestTemplate() {
		return restThreadLocal.get();
	}

	protected String getUrl(String service, String url) {
		if (url.indexOf("?") > 0) {
			url += "&sid=" + getSessionId();
		} else {
			url += "?sid=" + getSessionId();
		}
		url += "&uid=" + getUserId();
		return String.format("%s%s", getBaseUrl(service), url);
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
	public <T> T getForObject(String service, String url, Class<T> responseType) throws RestClientException {
		return getRestTemplate().getForObject(getUrl(service, url), responseType);
	}

	public <T> T getForObject(String service, String url, Class<T> responseType, Map<String, Object> urlVariables)
			throws RestClientException {
		return getRestTemplate().getForObject(getUrl(service, url), responseType, urlVariables);
	}

	public <T> T getForObject(String service, String url, Class<T> responseType, Object... urlVariables)
			throws RestClientException {
		return getRestTemplate().getForObject(getUrl(service, url), responseType, urlVariables);
	}

	public <T> T getForEntity(String service, String url, Class<T> responseType) throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().getForEntity(getUrl(service, url), responseType);
		return entity.getBody();
	}

	public <T> T getForEntity(String service, String url, Class<T> responseType, Map<String, Object> urlVariables)
			throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().getForEntity(getUrl(service, url), responseType, urlVariables);
		return entity.getBody();
	}

	public <T> T getForEntity(String service, String url, Class<T> responseType, Object... urlVariables)
			throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().getForEntity(getUrl(service, url), responseType, urlVariables);
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
	public <T> T postForObject(String service, String url, Object request, Class<T> responseType)
			throws RestClientException {
		return getRestTemplate().postForObject(getUrl(service, url), request, responseType);
	}

	public <T> T postForObject(String service, String url, Object request, Class<T> responseType,
			Map<String, Object> uriVariables) throws RestClientException {
		return getRestTemplate().postForObject(getUrl(service, url), request, responseType, uriVariables);
	}

	public <T> T postForObject(String service, String url, Object request, Class<T> responseType,
			Object... uriVariables) throws RestClientException {
		return getRestTemplate().postForObject(getUrl(service, url), request, responseType, uriVariables);
	}

	public <T> T postForEntity(String service, String url, Object request, Class<T> responseType)
			throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().postForEntity(getUrl(service, url), request, responseType);
		return entity.getBody();
	}

	public <T> T postForEntity(String service, String url, Object request, Class<T> responseType,
			Map<String, Object> uriVariables) throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().postForEntity(getUrl(service, url), request, responseType,
				uriVariables);
		return entity.getBody();
	}

	public <T> T postForEntity(String service, String url, Object request, Class<T> responseType,
			Object... uriVariables) throws RestClientException {
		ResponseEntity<T> entity = getRestTemplate().postForEntity(getUrl(service, url), request, responseType,
				uriVariables);
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
	public void delete(String service, String url) {
		getRestTemplate().delete(getUrl(service, url));
	}

	public void delete(String service, String url, Object... urlVariables) throws RestClientException {
		getRestTemplate().delete(getUrl(service, url), urlVariables);
	}

	public void delete(String service, String url, Map<String, Object> urlVariables) throws RestClientException {
		getRestTemplate().delete(getUrl(service, url), urlVariables);
	}

	/**
	 * Put
	 * 
	 * @param url
	 *            URL字段
	 * @param request
	 *            被PUT的值
	 */
	public void put(String service, String url, Object request) throws RestClientException {
		getRestTemplate().put(getUrl(service, url), request);
	}

	public void put(String service, String url, Object request, Object... urlVariables) throws RestClientException {
		getRestTemplate().put(getUrl(service, url), request, urlVariables);
	}

	public void put(String service, String url, Object request, Map<String, Object> urlVariables)
			throws RestClientException {
		getRestTemplate().put(getUrl(service, url), request, urlVariables);
		;
	}

}
