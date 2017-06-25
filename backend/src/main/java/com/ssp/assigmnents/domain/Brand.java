package com.ssp.assigmnents.domain;

public class Brand {
	
	private final String key;
	
	private final String name;

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	private Brand(String key, String name) {
		this.key = key;
		this.name = name;
	}
	
	public static Brand of(String key, String name) {
		return new Brand(key, name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Brand other = (Brand) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
