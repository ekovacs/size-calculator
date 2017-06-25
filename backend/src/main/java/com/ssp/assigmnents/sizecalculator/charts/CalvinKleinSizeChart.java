package com.ssp.assigmnents.sizecalculator.charts;

import com.google.common.collect.Multimap;
import com.ssp.assigmnents.sizecalculator.domain.Category;

public class CalvinKleinSizeChart implements ISizeChart {

	private final Multimap<Category, Measurement> sizeChart;
	
	public CalvinKleinSizeChart() {
		sizeChart = SizeChartFactory.createSizeChart("calvin-klein");
	}
	
	@Override
	public Multimap<Category, Measurement> getSizeChart() {
		return sizeChart;
	}
	
}
