package com.ssp.assigmnents.sizecalculator.charts;

import com.google.common.collect.Multimap;
import com.ssp.assigmnents.sizecalculator.domain.Category;

public class MichaelKorsSizeChart implements ISizeChart {

	public static final String BRAND_KEY = "michael-kors";
	
	private final Multimap<Category, Measurement> sizeChart;
	
	public MichaelKorsSizeChart() {
		sizeChart = SizeChartFactory.createSizeChart(BRAND_KEY);
	}
	
	@Override
	public Multimap<Category, Measurement> getSizeChart() {
		return sizeChart;
	}

}
