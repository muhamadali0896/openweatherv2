package com.umraok.weather.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class Snow {
	@Override
	public String toString() {
		return "Snow [TreeHour=" + TreeHour + "]";
	}

	@JsonProperty("3h")
	private double TreeHour;

	public double getTreeHour() {
		return TreeHour;
	}

	public void setTreeHour(double treeHour) {
		TreeHour = treeHour;
	}

}
