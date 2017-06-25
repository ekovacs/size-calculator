package com.ssp.assigmnents.rest;

import static com.ssp.assigmnents.rest.ServiceEndpointConstants.BRANDS_ENDPOINT;
import static com.ssp.assigmnents.rest.ServiceEndpointConstants.CATEGORIES_ENDPOINT;
import static com.ssp.assigmnents.rest.ServiceEndpointConstants.PREDICTION_ENDPOINT;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssp.assigmnents.domain.Brand;
import com.ssp.assigmnents.domain.Category;
import com.ssp.assigmnents.domain.Prediction;
import com.ssp.assigmnents.service.api.ISizeCalculatorService;

@RestController
@EnableAutoConfiguration
@RequestMapping(method = { RequestMethod.GET })
public class SizeCalculatorRestService {

	@Autowired
	private ISizeCalculatorService sizeCalculatorService;

	@RequestMapping(BRANDS_ENDPOINT)
	@ResponseBody Collection<Brand> getBrands() {
		return sizeCalculatorService.getBrands();
	}

	@RequestMapping(CATEGORIES_ENDPOINT)
	@ResponseBody Collection<Category> getCategories(
			
			@RequestParam(value = "brand") 
			String brand
			) {
		return sizeCalculatorService.getCategoriesByBrand(brand);
	}

	@RequestMapping(PREDICTION_ENDPOINT)
	@ResponseBody Prediction getPrediction(
			
			@RequestParam(value = "brand")
			String brand, 
			
			@RequestParam(value = "category")
			String category, 
			
			@RequestParam(value = "measurement")
			int measurement
			) {
		return sizeCalculatorService.getPrediction(brand, category, measurement);
	}

}