package com.umraok.weather.service;

import java.util.List;

import com.umraok.weather.dto.WeatherAverages;
import com.umraok.weather.exception.CityNotFoundException;

public interface WeatherService {
	public List<WeatherAverages> getWeatherForecastByCity(String city) throws CityNotFoundException;
}
