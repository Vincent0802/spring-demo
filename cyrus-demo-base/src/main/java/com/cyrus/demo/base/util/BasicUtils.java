package com.cyrus.demo.base.util;

import org.apache.commons.codec.binary.Base64;

/**
 * @Description: Basic编码与解码工具类
 *
 * @author wudan
 *
 * @time: 2016年10月28日 上午9:26:06
 *
 */
public class BasicUtils {

	/**
	 * 根据用户名和密码进行Base64编码，编码的字符串格式为name:password
	 * 
	 * @param name
	 *            用户名
	 * @param password
	 *            密码
	 * @return 编码后的字符串
	 */
	public static String encode(String name, String password) {
		byte[] bs = (name + ":" + password).getBytes();
		Base64 base64 = new Base64();
		return new String(base64.encode(bs));
	}

	/**
	 * 解码字符串，解码后的格式为name:password
	 * 
	 * @param str
	 *            带解码的字符串
	 * @return 用户名加密码字符串
	 */
	public static String decode(String str) {
		byte[] b = str.getBytes();
		Base64 base64 = new Base64();
		return new String(base64.decode(b));
	}

	/**
	 * 单元测试主函数
	 */
	public static void main(String[] args) {
		System.out.println(BasicUtils.encode("admin", "admin"));
		System.out.println("YWRtaW46YWRtaW4=".equals(BasicUtils.encode("admin", "admin")));
		System.out.println(BasicUtils.decode("YWRtaW46YWRtaW4="));
	}

}
