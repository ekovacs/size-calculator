package com.ssp.assigmnents.sizecalculator.charts;

import com.google.common.collect.Multimap;
import com.ssp.assigmnents.sizecalculator.domain.Category;

public class DianeVonFurstenbergSizeChart implements ISizeChart {

	private final Multimap<Category, Measurement> sizeChart;
	
	public DianeVonFurstenbergSizeChart() {
		sizeChart = SizeChartFactory.createSizeChart("diane-von-furstenberg");
	}
	
	@Override
	public Multimap<Category, Measurement> getSizeChart() {
		return sizeChart;
	}
	
}
