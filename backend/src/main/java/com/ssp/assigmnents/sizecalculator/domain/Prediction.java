package com.ssp.assigmnents.sizecalculator.domain;

import java.util.List;

public class Prediction {
	
	private final List<String> labels;

	private Prediction(List<String> labels) {
		this.labels = labels;
	}

	public List<String> getLabels() {
		return labels;
	}
	
	public static Prediction of(List<String> labels) {
		return new Prediction(labels);
	}

}
