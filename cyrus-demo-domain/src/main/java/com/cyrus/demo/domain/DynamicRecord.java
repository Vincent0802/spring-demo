package com.cyrus.demo.domain;

public class DynamicRecord {

	private String operatedTime;

	private String operator;

	private String action;

	private String comment;
	
	public String getOperatedTime() {
		return operatedTime;
	}

	public void setOperatedTime(String operatedTime) {
		this.operatedTime = operatedTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
