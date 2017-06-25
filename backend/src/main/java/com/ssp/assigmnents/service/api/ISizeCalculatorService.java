package com.ssp.assigmnents.service.api;

import java.util.List;

import com.ssp.assigmnents.domain.Brand;
import com.ssp.assigmnents.domain.Category;
import com.ssp.assigmnents.domain.Prediction;

public interface ISizeCalculatorService {

	List<Brand> getBrands();

	List<Category> getCategoriesByBrand(String brand);

	Prediction getPrediction(String brand, String category, int measurement);

}
