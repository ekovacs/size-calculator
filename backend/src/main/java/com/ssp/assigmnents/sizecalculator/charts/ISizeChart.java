package com.ssp.assigmnents.sizecalculator.charts;

import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Lists;

import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Range;
import com.ssp.assigmnents.sizecalculator.domain.Category;
import com.ssp.assigmnents.sizecalculator.exception.RequestNotFound;

public interface ISizeChart {

	Multimap<Category, Measurement> getSizeChart();

	public default List<String> size(Category category, Double measurement) {
		List<String> result = Lists.newArrayList();
		List<Measurement> collection = Lists.newArrayList(getSizeChart().get(category));
		Collections.sort(collection);
		
		if (measurement.compareTo(collection.iterator().next().getMeasurementRange().lowerEndpoint()) < 0)
			throw new RequestNotFound("Measurement is too small!");
		
		if (measurement.compareTo(Iterables.getLast(collection).getMeasurementRange().upperEndpoint()) > 0)
			throw new RequestNotFound("Measurement is too large!");
		
		
		for (Measurement m : collection) {
			//supplied measurement is smaller than the range's lower endpoint
			if (measurement.compareTo(m.getMeasurementRange().lowerEndpoint()) < 0) {
				result.add(m.getAlphaSize());
				if (m.getNumericSizeRange().isPresent()) {
					result.add(m.getNumericSizeRange().get().lowerEndpoint().toString());
				}
				break;
			} else if (m.getMeasurementRange().contains(measurement)) {
				result.add(m.getAlphaSize());
				Optional<Range<Integer>> numericSizeRange = m.getNumericSizeRange();
				if (numericSizeRange.isPresent()) {
					Range<Integer> range = numericSizeRange.get();
					
					double median = getMedian(range);
					result.add(roundToRangeEndpoint(measurement, range, median).toString());
				}
				break;
			}
		}
		return result;
	}

	public default Integer roundToRangeEndpoint(double measurement, Range<Integer> range, double median) {
		return measurement >= median ? range.upperEndpoint() : range.lowerEndpoint();
	}

	default double getMedian(Range<Integer> range) {
		return (range.lowerEndpoint() + range.upperEndpoint()) / 2;
	};

}
