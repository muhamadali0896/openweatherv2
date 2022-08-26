package com.umraok.weather.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class Rain {
	@Override
	public String toString() {
		return "Rain [treeHour=" + treeHour + "]";
	}

	@JsonProperty("3h")
	private double treeHour;

	public double getTreeHour() {
		return treeHour;
	}

	public void setTreeHour(double treeHour) {
		this.treeHour = treeHour;
	}

}
