package com.transport.etm.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public String testMethod() {
		return "ServiceMethodCalled";
	}

}
