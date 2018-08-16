package com.ekspertsoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@RequestMapping("/")
	public String hello(){
		return "Zakool REST is up.";
	}

}
