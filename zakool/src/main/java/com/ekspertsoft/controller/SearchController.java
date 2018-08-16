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
public class SearchController {

	@Autowired
	private SchoolRepository repository;
	
	@RequestMapping("/search/{min}/{max}")
	public List<School> search(@PathVariable final int min, @PathVariable final int max){
		List<School> results = Lists.newArrayList();
		if(min<=max){
			results = repository.findByTotalPriceInStateOnCampusBetweenOrderByTotalPriceInStateOnCampusAsc(min, max);
		}else{
			results = repository.findByTotalPriceInStateOnCampusBetweenOrderByTotalPriceInStateOnCampusAsc(max, min);
		}
		
		return results;
	}
	
}
