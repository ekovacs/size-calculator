package com.ssp.assigmnents.sizecalculator.service.api.impl;

import com.ssp.assigmnents.sizecalculator.charts.SizeChartFactory;
import com.ssp.assigmnents.sizecalculator.domain.Brand;
import com.ssp.assigmnents.sizecalculator.domain.Category;
import com.ssp.assigmnents.sizecalculator.domain.DomainFactory;
import com.ssp.assigmnents.sizecalculator.domain.Prediction;
import com.ssp.assigmnents.sizecalculator.exception.InvalidCategoryConfiguration;
import com.ssp.assigmnents.sizecalculator.service.api.ISizePredictor;

public class ChartBasedSizePredictor implements ISizePredictor {

	private final Brand brand;
	private final Category category;
	private final int measurement;

	private ChartBasedSizePredictor(Brand brand, Category category, int measurement) {
		this.brand = brand;
		this.category = category;
		this.measurement = measurement;
		
	}
	
	public Brand getBrand() {
		return brand;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public int getMeasurement() {
		return measurement;
	}
	
	@Override
	public Prediction predictSize() {
		return Prediction.of(SizeChartFactory.createSizeChartFor(brand).size(category, measurement));
	}
	
	public static class ChartBasedSizePredictorBuilder extends Builder {
		
		private Brand brand;
		private Category category;
		private int measurement;

		public ChartBasedSizePredictorBuilder brand(String brandKey) {
			brand = DomainFactory.brandForKey(brandKey);
			return this; 
		}
		
		public ChartBasedSizePredictorBuilder category(String categoryKey) {
			category = DomainFactory.categoryForKey(categoryKey);
			return this; 
		}
		
		public ChartBasedSizePredictorBuilder measurement(int measurementSize) {
			measurement = measurementSize;
			return this; 
		}
		
		@Override
		public ISizePredictor build() {
			assertInvalidCategoryConfiguration();
			return new ChartBasedSizePredictor(brand, category, measurement);
		}

		private void assertInvalidCategoryConfiguration() {
			if (!DomainFactory.getCategoriesFor(brand.getKey()).contains(category)) {
				throw new InvalidCategoryConfiguration(String.format("Supplied category ('%s') is not sold by brand ('%s')", category.getName(), brand.getName()));
			}
		}
	}

}
