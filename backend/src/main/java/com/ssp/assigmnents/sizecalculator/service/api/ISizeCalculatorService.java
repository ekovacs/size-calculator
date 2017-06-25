package com.ssp.assigmnents.sizecalculator.service.api;

import java.util.Collection;

import com.ssp.assigmnents.sizecalculator.domain.Brand;
import com.ssp.assigmnents.sizecalculator.domain.Category;
import com.ssp.assigmnents.sizecalculator.domain.Prediction;

public interface ISizeCalculatorService {

	Collection<Brand> getBrands();

	Collection<Category> getCategoriesByBrand(String brand);

	Prediction getPrediction(String brand, String category, int measurement);

}
