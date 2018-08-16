package com.ekspertsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekspertsoft.dao.SchoolRepository;
import com.ekspertsoft.dto.School;

@RestController
public class SchoolController {
	
	@Autowired
	private SchoolRepository repository;
	
	@RequestMapping("/list")
	public Iterable<School> list(){
		return repository.findAll();
	}

}
