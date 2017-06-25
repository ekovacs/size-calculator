package com.ssp.assigmnents.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class SizeCalculatorRestService {


	@RequestMapping("/brands")
	Object getBrands() {
		return "";
	}

	@RequestMapping("/categories")
	Object getCategories(
			@PathVariable(value = "brand")
			String brand
			) {
		return "";
	}

	@RequestMapping("/prediction")
	Object getPrediction(
			
			@PathVariable(value = "brand")
			String brand, 
			
			@PathVariable(value = "category")
			String category, 
			
			@PathVariable(value = "size")
			Object size) {
		return "";
	}

}