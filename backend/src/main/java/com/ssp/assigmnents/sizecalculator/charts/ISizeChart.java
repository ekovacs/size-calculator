package com.ssp.assigmnents.sizecalculator.charts;

import java.util.List;

import org.assertj.core.util.Lists;

import com.google.common.base.Optional;
import com.google.common.collect.Multimap;
import com.google.common.collect.Range;
import com.ssp.assigmnents.sizecalculator.domain.Category;

public interface ISizeChart {

	Multimap<Category, Measurement> getSizeChart();

	public default List<String> size(Category category, double measurement) {
		List<String> result = Lists.newArrayList();
		for (Measurement m : getSizeChart().get(category)) {
			//supplied measurement is smaller than the range's lower endpoint
			if (m.getMeasurementRange().lowerEndpoint().compareTo(measurement) > 0) {
				
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
