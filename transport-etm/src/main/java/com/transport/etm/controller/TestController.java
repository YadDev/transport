package com.transport.etm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transport.beans.etm.TestRequest;
import com.transport.etm.service.TestService;

@RestController
@RequestMapping("/etm")
public class TestController {

	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/getMasterData", method = RequestMethod.POST)
	public String getInsiderListForCompany(@RequestBody @Valid TestRequest testRequest, BindingResult bindingResult) {
		return testService.testMethod() + "/" + testRequest.getId(); 
	}
	
}
