package com.cyrus.demo.starters.exception;

import java.util.Map;

/**
 * @Description: Error错误信息类
 *
 * @author Cloud
 *
 * @time: 2016年8月22日 下午4:35:49
 *
 */
public class Error {
	
	private String code;
	
	private String msg;

	//验证信息字段
	private Map<String,String> validMsg;

	public Map<String,String> getValidMsg() {
		return validMsg;
	}

	public void setValidMsg(Map<String,String> validMsg) {
		this.validMsg = validMsg;
	}


	public Error(){}
	
	
	public Error(String msg){
		this.msg = msg;
	}
	
	public Error(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public Error(String code , String msg, Map<String,String> validMsg){
		this.code = code ; 
		this.msg = msg;
		this.validMsg = validMsg;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

}
