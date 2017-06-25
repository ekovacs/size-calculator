package com.ssp.assigmnents.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
	
	private String key;
	
	private String name;
	
	@JsonProperty("measurement_type")
	private String measurementType;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}
	
}
