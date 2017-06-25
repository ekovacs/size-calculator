package com.ssp.assigmnents.service.api;

import java.util.Collection;

import com.ssp.assigmnents.domain.Brand;
import com.ssp.assigmnents.domain.Category;
import com.ssp.assigmnents.domain.Prediction;

public interface ISizeCalculatorService {

	Collection<Brand> getBrands();

	Collection<Category> getCategoriesByBrand(String brand);

	Prediction getPrediction(String brand, String category, int measurement);

}
