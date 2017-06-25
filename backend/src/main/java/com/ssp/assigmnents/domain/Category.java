package com.ssp.assigmnents.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
	
	private final String key;
	
	private final String name;
	
	@JsonProperty("measurement_type")
	private final String measurementType;

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public String getMeasurementType() {
		return measurementType;
	}
	
	private Category(String key, String name, String measurementType) {
		this.key = key;
		this.name = name;
		this.measurementType = measurementType;
	}
	
	public static Category of(String key, String name, String measurementType) {
		return new Category(key, name, measurementType);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((measurementType == null) ? 0 : measurementType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (measurementType == null) {
			if (other.measurementType != null)
				return false;
		} else if (!measurementType.equals(other.measurementType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
