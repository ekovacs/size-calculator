package com.ssp.assigmnents.service.api.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ssp.assigmnents.domain.Brand;
import com.ssp.assigmnents.domain.Category;
import com.ssp.assigmnents.domain.Prediction;
import com.ssp.assigmnents.service.api.ISizeCalculatorService;

@Service
public class SizeCalculatorService implements ISizeCalculatorService {

	@Override
	public List<Brand> getBrands() {
		return Lists.newArrayList();
	}

	@Override
	public List<Category> getCategoriesByBrand(String brand) {
		return Lists.newArrayList();
	}

	@Override
	public Prediction getPrediction(String brand, String category, int measurement) {
		return new Prediction();
	}

}
