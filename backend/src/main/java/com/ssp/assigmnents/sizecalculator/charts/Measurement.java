package com.ssp.assigmnents.sizecalculator.charts;

import com.google.common.base.Optional;
import com.google.common.collect.Range;

public class Measurement {
	
	private final Range<Double> measurementRange;
	private String alphaSize;
	private Optional<Range<Integer>> numericSizeRange;
	
	public Measurement(final Range<Double> range, final Range<Integer> numericRange, final String alphaSize) {
		this.measurementRange = range;
		this.numericSizeRange = Optional.fromNullable(numericRange);
		this.alphaSize = alphaSize;
	}

	public Range<Double> getMeasurementRange() {
		return measurementRange;
	}
	
	public String getAlphaSize() {
		return alphaSize;
	}
	
	public Optional<Range<Integer>> getNumericSizeRange() {
		return numericSizeRange;
	}
}