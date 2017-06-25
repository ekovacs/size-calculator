package com.ssp.assigmnents.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

public class DomainFactory {
	
	private static Multimap<Brand, Category> brandToCategoryMapping = 
			ImmutableMultimap.<Brand, Category> builder()
				
			.putAll(Brand.of("calvin-klein", "Calvin Klein"), 
							Category.of("dresses", "Dresses", "bust"), 
							Category.of("jeans", "Jeans", "waist"),
							Category.of("sneakers", "Sneakers", "length"))
				.putAll(Brand.of("diane-von-furstenberg", "Diane von Furstenberg"),
							Category.of("dresses", "Dresses", "bust"), 
							Category.of("jeans", "Jeans", "waist"),
							Category.of("sneakers", "Sneakers", "length"))
				
				.putAll(Brand.of("michael-kors", "Michael Kors"), 
							Category.of("dresses", "Dresses", "bust"), 
							Category.of("jeans", "Jeans", "waist"),
							Category.of("sneakers", "Sneakers", "length"))
			.build();
	
	
	public static Brand brandForKey(String key) {
		return getBrands().stream()
				.filter(brand -> brand.getKey().equals(key))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(String.format("Unknown brand used as key: %s", key)));
	}
	
	
	public static Category categoryForKey(String key) {
		return brandToCategoryMapping.values().stream()
				.filter(category -> category.getKey().equals(key))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(String.format("Unknown category used as key: %s", key)));
	}
	
	public static Collection<Brand> getBrands() {
		return brandToCategoryMapping.keySet();
	}

	public static Collection<Category> getCategoriesFor(String brand) {
		return brandToCategoryMapping.asMap().entrySet().stream()
				.filter(entry -> entry.getKey().getKey().equals(brand))
				.flatMap(entry -> entry.getValue().stream())
				.collect(Collectors.toSet());
	}
	
	
	
}
