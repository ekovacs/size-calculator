package com.ssp.assigmnents.sizecalculator.service.api.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.ssp.assigmnents.sizecalculator.domain.Brand;
import com.ssp.assigmnents.sizecalculator.domain.Category;
import com.ssp.assigmnents.sizecalculator.domain.DomainFactory;
import com.ssp.assigmnents.sizecalculator.domain.Prediction;
import com.ssp.assigmnents.sizecalculator.service.api.ISizeCalculatorService;

@Service
public class SizeCalculatorService implements ISizeCalculatorService {

	@Override
	public Collection<Brand> getBrands() {
		return DomainFactory.getBrands();
	}

	@Override
	public Collection<Category> getCategoriesByBrand(String brand) {
		return DomainFactory.getCategoriesFor(brand);
	}

	@Override
	public Prediction getPrediction(String brand, String category, int measurement) {
		return new ChartBasedSizePredictor.ChartBasedSizePredictorBuilder()
						.brand(brand)
						.category(category)
						.measurement(measurement)
					.build()
					.predictSize();
	}

}
