package com.wx.webservices.first_rest.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue filerting()
	{
		SomeBean someBean = new SomeBean ("v1", "v2", "v3");
		MappingJacksonValue mappingJV = new MappingJacksonValue(someBean); 
		SimpleBeanPropertyFilter filter=  SimpleBeanPropertyFilter.filterOutAllExcept("f1","f3");
		FilterProvider filers= new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJV.setFilters(filers);
		
		return mappingJV;
	}

	@GetMapping("/filteringList")
	public MappingJacksonValue filertingList()
	{
		List<SomeBean> list = Arrays.asList( new SomeBean ("v1", "v2", "v3"),
				new SomeBean ("v11", "v22", "v33"),
				new SomeBean ("v111", "v222", "v333")
				);
		MappingJacksonValue mappingJV = new MappingJacksonValue(list); 
		
		SimpleBeanPropertyFilter filter=  SimpleBeanPropertyFilter.filterOutAllExcept("f3","f2");
		FilterProvider filers= new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJV.setFilters(filers);
		
		return mappingJV;
		
		//return list;
				
	}
}
