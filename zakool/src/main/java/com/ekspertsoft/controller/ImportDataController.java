package com.ekspertsoft.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekspertsoft.dao.SchoolRepository;
import com.ekspertsoft.dto.School;
import com.ekspertsoft.utils.StringConversion;

@RestController
public class ImportDataController {
	
	@Autowired
	private SchoolRepository repository;
	
	@RequestMapping("/importdata/{token}")
	public String importData(@PathVariable final String token){
		final String SECURED = "Imp0rt";
		if(!SECURED.equals(token)){
			return "Unauthorized request";
		}
		
		//final String filePath = "/Users/wechypedia/Documents/workspace-sts-3.7.3.RELEASE/zakool/src/main/resources/testdata.txt";
		//final String filePath = "/Users/wechypedia/Documents/workspace-sts-3.7.3.RELEASE/zakool/src/main/resources/Data_5-20-2016.csv";
		final String filePath = "/Users/wechypedia/Documents/workspace-sts-3.7.3.RELEASE/zakool/src/main/resources/zakoolmaster.csv";

		try{
			//repository.deleteAll();
			
			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			/*
			//for Data_5_20-2016
			
			lines.forEach(p -> {
				final String[] tokens = p.split(",", -1);//will not trim empty String.
				School school = repository.findBySchoolCode(tokens[0]);
				if(null==school){
					school = new School();
					school.setSchoolCode(tokens[0]);
					school.setName(tokens[1]);
					school.setState(tokens[2]);
				}
				school.setType(tokens[7]);
				school.setSize(tokens[24]);
				school.setLevel(tokens[6]);
				
				school.setCategory(tokens[12]);
				school.setTotalPriceInStateOnCampus(StringConversion.toInt(tokens[26]));
				school.setTotalPriceInStateOffCampus(StringConversion.toInt(tokens[29]));
				school.setTotalPriceOffStateOnCampus(StringConversion.toInt(tokens[27]));
				school.setTotalPriceOffStateOffCampus(StringConversion.toInt(tokens[30]));
				
				repository.save(school);
			});*/
			
/*			lines.forEach(p -> {
			//UNITID,INSTNM,ADDR,CITY,STABBR,ZIP,GENTELE,WEBADDR
			final String[] tokens = p.split(",", -1);//will not trim empty String.
			School school = repository.findBySchoolCode(tokens[0]);
			if (null==school){
				school = new School();
				school.setSchoolCode(tokens[0]);
			}
			
			school.setName(tokens[1]);
			school.setStreet(tokens[2]);
			school.setCity(tokens[3]);
			school.setState(tokens[4]);
			school.setZipcode(tokens[5]);
			school.setPhone(tokens[6]);
			String temp = tokens[7].isEmpty()? "": tokens[7].toLowerCase();
			if(!temp.isEmpty()){
				if (!temp.contains("www")){
					temp = "www."+temp;
				}
			}
			school.setUrl(temp);
			
			
			repository.save(school);
			});*/
			
		}catch (IOException ex){
			ex.printStackTrace();
			return "Fail";
		}
		return "Success";
	}

}
