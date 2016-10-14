package com.cyrus.demo.ui.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.cyrus.demo.base.core.service.RestService;

/**
 * @Description: REST服务的Controller，处理用户请求
 *
 * @author Cloud
 *
 * @time: 2016年8月22日 下午5:05:58
 *
 */
@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired
	private RestService restService; 

	/**
	 * Search or Create or Update
	 * 
	 * @param service
	 * @param url
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "{service}/**", method = { RequestMethod.POST }, produces = "application/json")
	@ResponseBody
	public Object post(@PathVariable String service, @Valid @RequestBody(required = false) Map request,
			HttpServletRequest hsr) {
		String url = getRestUrl(service, hsr);
		return restService.postForObject(service, url, request, String.class);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "{service}/**", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public Object get(@PathVariable String service, @RequestParam(required = false) Map request,
			HttpServletRequest hsr) {
		String url = getRestUrl(service, hsr);
		String arr[] = new String[request.entrySet().size()];
		int i = 0;
		for (Object val : request.entrySet()) {
			arr[i++] = val.toString();
		}
		url += "?" + String.join("&", arr);
		return restService.getForObject(service, url, String.class);
	}

	/**
	 * 获取远程服务器URL
	 * 
	 * @param service
	 * @param request
	 * @return
	 */
	private String getRestUrl(String service, HttpServletRequest request) {
		String url = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		return url.replace("/rest/" + service, "");
	}

}
