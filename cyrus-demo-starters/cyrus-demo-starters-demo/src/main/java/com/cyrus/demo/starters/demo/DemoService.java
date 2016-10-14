package com.cyrus.demo.starters.demo;

/**
 * @Description: 可为第三方类库
 *
 * @author wudan
 *
 * @time: 2016年9月1日 上午10:23:01
 *
 */
public class DemoService {

	private String msg;

	public String sayDemo() {
		String className = DemoService.class.getName();
		return className.substring(className.lastIndexOf(".") + 1);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
