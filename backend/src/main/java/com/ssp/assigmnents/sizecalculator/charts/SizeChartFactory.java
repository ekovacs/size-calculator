package com.ssp.assigmnents.sizecalculator.charts;

import java.util.Collection;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.common.collect.Range;
import com.ssp.assigmnents.sizecalculator.domain.Brand;
import com.ssp.assigmnents.sizecalculator.domain.Category;
import com.ssp.assigmnents.sizecalculator.domain.DomainFactory;

public class SizeChartFactory {

	
	public static ISizeChart createSizeChartFor(Brand brand) {
		if (brand.getKey().equals(CalvinKleinSizeChart.BRAND_KEY)) {
			return new CalvinKleinSizeChart();
		} else if (brand.getKey().equals(DianeVonFurstenbergSizeChart.BRAND_KEY)) {
			return new DianeVonFurstenbergSizeChart();
		} else if (brand.getKey().equals(MichaelKorsSizeChart.BRAND_KEY)) {
			return new MichaelKorsSizeChart();
		}
		throw new IllegalArgumentException(String.format("Unkown size chart for, brand: %s", brand.getName()));
	}
	
	public static Multimap<Category, Measurement> createSizeChart(String brandKey) {
		Multimap<Category, Measurement> result = HashMultimap.create();
		Collection<Category> categories = DomainFactory.getCategoriesFor(brandKey);
		for (Category category : categories) {
			result.putAll(category, createMeasurements(category, brandKey));
		}
		return result;
	}
	
	private static Collection<Measurement> createMeasurements(Category category, String brandKey) {
		if (brandKey.equals("calvin-klein")) {
			return createCalvinKleinMeasurements(category);
		} else if (brandKey.equals("diane-von-furstenberg")) {
			return createVonFurstenbergMeasurements(category);
		} else if (brandKey.equals("michael-kors")) {
			return createMichaelKorsMeasurements(category);
		}
		
		throw new IllegalArgumentException(String.format("Unkown size chart for, brand: %s, category: %s", brandKey, category.getName()));
	}

	private static Collection<Measurement> createCalvinKleinMeasurements(Category category) {
		if (category.getKey().equals("dresses")) {
			return ImmutableList.<Measurement>builder()
						.add(new Measurement(Range.closedOpen(31d, 33d) , null, "XS"))
						.add(new Measurement(Range.closedOpen(33d, 35d) , null, "S"))
						.add(new Measurement(Range.closedOpen(35d, 37d) , null, "M"))
						.add(new Measurement(Range.closedOpen(37d, 39d) , null, "L"))
						.add(new Measurement(Range.closedOpen(39d, 41d) , null, "XL"))
					.build();
		} else if (category.getKey().equals("jeans")) {
			return ImmutableList.<Measurement>builder()
						.add(new Measurement(Range.closedOpen(23.5d, 25d), Range.closed(25, 26), "XS"))
						.add(new Measurement(Range.closedOpen(25d, 27d), Range.closed(27, 28), "S"))
						.add(new Measurement(Range.closedOpen(27d, 29d), Range.closed(29, 30), "M"))
						.add(new Measurement(Range.closedOpen(29d, 31d), Range.closed(31, 32), "L"))
						.add(new Measurement(Range.closedOpen(31d, 33d), Range.closed(33, 34), "XL"))
					.build();
			
		} else if (category.getKey().equals("sneakers")) {
			return ImmutableList.<Measurement>builder()
					// there is inch / cm present on website but no US sizing available
					.build();
		}
		throw new IllegalArgumentException(String.format("Unknown category encountered: %s",category.getName()));
	}

	private static Collection<Measurement> createVonFurstenbergMeasurements(Category category) {
		if (category.getKey().equals("dresses")) {
			return ImmutableList.<Measurement>builder()
						.add(new Measurement(Range.closed(32.5d, 33.5d), Range.closed(0, 2), "P"))
						.add(new Measurement(Range.closed(34.5d, 35.5d), Range.closed(4, 6), "S"))
						.add(new Measurement(Range.closed(36.5d, 37.5d), Range.closed(8, 10), "M"))
						.add(new Measurement(Range.closed(39d, 40.5d), Range.closed(12, 14), "L"))
					.build();
		} else if (category.getKey().equals("jeans")) {
			return ImmutableList.<Measurement>builder()
						.add(new Measurement(Range.closed(25d, 26d), Range.closed(0, 2), "P"))
						.add(new Measurement(Range.closed(27d, 28d), Range.closed(4, 6), "S"))
						.add(new Measurement(Range.closed(29d, 30d), Range.closed(8, 10), "M"))
						.add(new Measurement(Range.closed(31d, 33d), Range.closed(12, 14), "L"))
					.build();
		} else if (category.getKey().equals("sneakers")) {
			return ImmutableList.<Measurement>builder()
					// no measurements of inch or cm is present on website
					.build();
		}
		throw new IllegalArgumentException(String.format("Unknown category encountered: %s",category.getName()));
	}
	
	private static Collection<Measurement> createMichaelKorsMeasurements(Category category) {
		if (category.getKey().equals("dresses")) {
			return ImmutableList.<Measurement>builder()
					.add(new Measurement(Range.singleton(33d), Range.singleton(0), "XXS"))
					.add(new Measurement(Range.closed(34d, 35d), Range.openClosed(0, 2), "XS"))
					.add(new Measurement(Range.closed(36d, 37d), Range.closed(4, 6), "S"))
					.add(new Measurement(Range.closed(38d, 39.5d), Range.closed(8, 10), "M"))
					.add(new Measurement(Range.closed(41d, 42.5d), Range.closed(12, 14), "L"))
					.add(new Measurement(Range.singleton(44d), Range.singleton(16), "XL"))
					.build();
		} else if (category.getKey().equals("jeans")) {
			return ImmutableList.<Measurement>builder()
					.add(new Measurement(Range.singleton(28d), Range.singleton(0), "XXS"))
					.add(new Measurement(Range.closed(29d, 30d), Range.openClosed(0, 2), "XS"))
					.add(new Measurement(Range.closed(31d, 32d), Range.closed(4, 6), "S"))
					.add(new Measurement(Range.closed(33d, 34.5d), Range.closed(8, 10), "M"))
					.add(new Measurement(Range.closed(36d, 37.5d), Range.closed(12, 14), "L"))
					.add(new Measurement(Range.singleton(39d), Range.singleton(16), "XL"))
					.build();
		} else if (category.getKey().equals("sneakers")) {
			return ImmutableList.<Measurement>builder()
					// no measurements of inch or cm is present on website
					.build();
		}
		throw new IllegalArgumentException(String.format("Unknown category encountered: %s",category.getName()));
	}

}
