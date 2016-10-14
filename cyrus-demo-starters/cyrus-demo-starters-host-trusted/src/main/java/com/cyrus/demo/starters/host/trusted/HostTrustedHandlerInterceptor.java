package com.cyrus.demo.starters.host.trusted;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主机信任拦截器
 * <p>
 * Session信任拦截器请查看 {@link SessionTrustedHandlerInterceptor}
 * </p>
 * 
 * @author Cloud
 * @author xxxx
 *
 */
public class HostTrustedHandlerInterceptor implements HandlerInterceptor {

	private String hosts;

	public HostTrustedHandlerInterceptor(String hosts) {
		this.hosts = hosts;
	}

	/**
	 * 处理请求是否受信任
	 * 
	 * @param req
	 *            请求
	 * @param res
	 *            回应
	 * @param param
	 *            参数
	 * @exception 如果不受信任抛出异常
	 */
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object param) throws Exception {
		String host = req.getHeader("x-forwarded-for") == null ? req.getRemoteAddr() : req.getHeader("x-forwarded-for");
		if (hosts.indexOf(host) < 0) {
			throw new Exception("The server is not trusted!");
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
