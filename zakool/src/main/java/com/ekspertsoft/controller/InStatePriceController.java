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
public class InStatePriceController {
	
	@Autowired
	private SchoolRepository repository;
    
	@RequestMapping("/instate/oncampus/{maxPrice}")
	public List<School> onCampus(@PathVariable final int maxPrice){
		List<School> results = Lists.newArrayList();
		//zero means no price is being reported.
		if(maxPrice<=0){
			//unsupported query
			return results;
		}
		//results = repository.findByTotalPriceInStateOnCampusLessThan(maxPrice);
		results = repository.findByTotalPriceInStateOnCampusBetweenOrderByTotalPriceInStateOnCampusAsc(1, maxPrice);
		return results;
		
	}
}
