package com.umraok.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.umraok.weather.dto.WeatherAverages;
import com.umraok.weather.exception.CityNotFoundException;
import com.umraok.weather.service.impl.OpenWeatherMapService;

@RestController
@Validated
public class WeatherController {

	@Autowired
	private OpenWeatherMapService weatherService;

	@GetMapping(value = "/v1/city/{cityName}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<WeatherAverages> data(@PathVariable("cityName") String cityName) throws CityNotFoundException {
		return weatherService.getWeatherForecastByCity(cityName);
	}

}
