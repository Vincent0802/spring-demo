package com.cyrus.demo.base.module.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cyrus.demo.base.core.service.AbstractRestService;

@Service
public class AccountRestService extends AbstractRestService {

	@Value("${service.account.url}")
	private String url;
	
	@Override
	protected String getBaseUrl() {
		// TODO Auto-generated method stub
		return url;
	}

}