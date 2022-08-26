package com.umraok.weather.dto;

import lombok.Data;

@Data
public class WeatherAverages {
	private String date;
	private double dailyAverageTemperature;
	private double nightlyAverageTemperature;
	private double pressureAverage;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getDailyAverageTemperature() {
		return dailyAverageTemperature;
	}

	public void setDailyAverageTemperature(double dailyAverageTemperature) {
		this.dailyAverageTemperature = dailyAverageTemperature;
	}

	public double getNightlyAverageTemperature() {
		return nightlyAverageTemperature;
	}

	public void setNightlyAverageTemperature(double nightlyAverageTemperature) {
		this.nightlyAverageTemperature = nightlyAverageTemperature;
	}

	public double getPressureAverage() {
		return pressureAverage;
	}

	public void setPressureAverage(double pressureAverage) {
		this.pressureAverage = pressureAverage;
	}

	@Override
	public String toString() {
		return "WeatherAverages [date=" + date + ", dailyAverageTemperature=" + dailyAverageTemperature
				+ ", nightlyAverageTemperature=" + nightlyAverageTemperature + ", pressureAverage=" + pressureAverage
				+ "]";
	}

}
