package com.umraok.weather.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {
	private String cod;
	private String message;
	private Long cnt;
	private List<WeatherDetails> list;
	private City city;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	public List<WeatherDetails> getList() {
		return list;
	}

	public void setList(List<WeatherDetails> list) {
		this.list = list;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "WeatherForecast [cod=" + cod + ", message=" + message + ", cnt=" + cnt + ", list=" + list + ", city="
				+ city + "]";
	}

}
