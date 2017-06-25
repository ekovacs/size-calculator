package com.ssp.assigmnents.sizecalculator.charts;

import com.google.common.collect.Multimap;
import com.ssp.assigmnents.sizecalculator.domain.Category;

public class CalvinKleinSizeChart implements ISizeChart {

	public static final String BRAND_KEY = "calvin-klein";
	
	private final Multimap<Category, Measurement> sizeChart;
	
	public CalvinKleinSizeChart() {
		sizeChart = SizeChartFactory.createSizeChart(BRAND_KEY);
	}
	
	@Override
	public Multimap<Category, Measurement> getSizeChart() {
		return sizeChart;
	}
	
}
