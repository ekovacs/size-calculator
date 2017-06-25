package com.ssp.assigmnents.service.api.impl;

import com.ssp.assigmnents.domain.Brand;
import com.ssp.assigmnents.domain.Category;
import com.ssp.assigmnents.domain.DomainFactory;
import com.ssp.assigmnents.domain.Prediction;
import com.ssp.assigmnents.exception.InvalidCategoryConfiguration;

public class ChartBasedSizePredictor implements ISizePredictor {

	private final Brand brand;
	private final Category category;
	private final int measurement;

	private ChartBasedSizePredictor(Brand brand, Category category, int measurement) {
		this.brand = brand;
		this.category = category;
		this.measurement = measurement;
		
	}
	
	@Override
	public Prediction predictSize() {
		return new Prediction();
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
			if (DomainFactory.getCategoriesFor(brand.getKey()).contains(category)) {
				throw new InvalidCategoryConfiguration(String.format("Supplied category ('%s') is not sold by brand ('%s')", category.getName(), brand.getName()));
			}
		}
	}

}
