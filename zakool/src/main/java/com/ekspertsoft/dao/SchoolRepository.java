package com.ekspertsoft.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ekspertsoft.dto.School;

public interface SchoolRepository extends PagingAndSortingRepository<School, String> {

	public School findByName(final String name);
	
	public School findBySchoolCode(final String schoolCode);
    
	//@Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
	//@Query("{ 'name' : { $regex: ?0 } }")
	public List<School> findByNameLikeIgnoreCase(final String name);

	public List<School> findByStateIgnoreCase(final String state);

	public List<School> findByTotalPriceInStateOnCampusBetweenOrderByTotalPriceInStateOnCampusAsc(final int minPrice, final int maxPrice);

	public List<School> findByTotalPriceInStateOffCampusBetween(final int minPrice, final int maxPrice);

	public List<School> findByTotalPriceOffStateOnCampusBetween(final int minPrice, final int maxPrice);

	public List<School> findByTotalPriceOffStateOffCampusBetween(final int minPrice, final int macPrice);

	public List<School> findByStateAndCategoryIgnoreCase(final String state, final String category);

	public List<School> findByTotalPriceInStateOnCampusOrTotalPriceInStateOffCampusBetween(final int minPrice,
			final int maxPrice, final int minPrice2, final int maxPrice2);
	
	public List<School> findByTotalPriceInStateOnCampusLessThanOrTotalPriceInStateOffCampusLessThan(final int price1, final int price2);

	public List<School> findByTotalPriceInStateOnCampusLessThan(final int price);
}
