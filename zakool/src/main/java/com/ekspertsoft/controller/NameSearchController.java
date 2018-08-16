package com.ekspertsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekspertsoft.dao.SchoolRepository;
import com.ekspertsoft.dto.School;
import com.google.common.collect.Lists;

@RestController
public class NameSearchController {
	
	@Autowired
	private SchoolRepository repository;
	
	@RequestMapping("/name/{query}")
	public List<School> searchByName(@PathVariable final String query){
		List<School> results = Lists.newArrayList();
		if(!query.isEmpty()){
			results = repository.findByNameLikeIgnoreCase(query);
		}
		
		return results;
	}

}
