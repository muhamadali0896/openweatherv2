package com.umraok.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds {
	@Override
	public String toString() {
		return "Clouds [all=" + all + "]";
	}

	private Long all;

	public Long getAll() {
		return all;
	}

	public void setAll(Long all) {
		this.all = all;
	}
}
