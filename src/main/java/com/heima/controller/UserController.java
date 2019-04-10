package com.heima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("getString")
	public String getString() { 
		return restTemplate.getForObject("http://heima-provider-1/getString", String.class);
	}
	//4
	@RequestMapping("getMap")
	public String getMap() {
		return restTemplate.getForObject("http://heima-provider-1/getMap", String.class);
	}

}
