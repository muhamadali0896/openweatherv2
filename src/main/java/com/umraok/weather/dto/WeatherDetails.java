package com.umraok.weather.dto;

import java.time.Instant;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDetails {
	@Override
	public String toString() {
		return "WeatherDetails [dt=" + dt + ", main=" + main + ", weather=" + Arrays.toString(weather) + ", clouds="
				+ clouds + ", wind=" + wind + ", rain=" + rain + ", snow=" + snow + ", sys=" + sys + ", dt_txt="
				+ dt_txt + "]";
	}

	private Instant dt;
	private Main main;
	private Weather[] weather;
	private Clouds clouds;
	private Wind wind;
	private Rain rain;
	private Snow snow;
	private Sys sys;
	private String dt_txt;

	public Instant getDt() {
		return dt;
	}

	public void setDt(Instant dt) {
		this.dt = dt;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Rain getRain() {
		return rain;
	}

	public void setRain(Rain rain) {
		this.rain = rain;
	}

	public Snow getSnow() {
		return snow;
	}

	public void setSnow(Snow snow) {
		this.snow = snow;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

}
