package com.umraok.weather.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.umraok.weather.dto.WeatherAverages;
import com.umraok.weather.dto.WeatherDetails;
import com.umraok.weather.dto.WeatherForecast;
import com.umraok.weather.exception.CityNotFoundException;
import com.umraok.weather.service.WeatherService;
import com.umraok.weather.util.WeatherAverageCalculator;

@Service
public class OpenWeatherMapService implements WeatherService {

	@Autowired
	RestTemplate template;

	@Autowired
	WeatherAverageCalculator calculator;

	@Value("${openweathermap.appId}")
	private String appId;

	@Value("${openweathermap.url}")
	private String owmUrl;

	@Override
	public List<WeatherAverages> getWeatherForecastByCity(String city) throws CityNotFoundException {
		WeatherForecast weatherForecast = new WeatherForecast();
		String owmForecastCityUrl = getForecastUrlForCity(city);
		try {
			weatherForecast = template.getForObject(owmForecastCityUrl, WeatherForecast.class);
		} catch (HttpClientErrorException ex) {
			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CityNotFoundException(city + " not Found");
			}
		}

		WeatherAverages weatherAverages = null;
		Map<String, List<WeatherDetails>> forcastFor3Days = getCurrentAndNextThreeDatForcast(weatherForecast.getList());
		List<WeatherAverages> weatherAveragesList = new ArrayList<>();
		for (Map.Entry<String, List<WeatherDetails>> entry : forcastFor3Days.entrySet()) {
			weatherAverages = new WeatherAverages();
			weatherAverages.setDate(entry.getKey());
			weatherAverages.setDailyAverageTemperature(
					formatValue(calculator.getDailyAveragetemperature(forcastFor3Days.get(entry.getKey()))));
			weatherAverages.setNightlyAverageTemperature(
					formatValue(calculator.getNightlyAveragetemperature(forcastFor3Days.get(entry.getKey()))));
			weatherAverages.setPressureAverage(
					formatValue(calculator.getPressureAverage(forcastFor3Days.get(entry.getKey()))));
			weatherAveragesList.add(weatherAverages);
		}
		return weatherAveragesList.subList(0, 4);
	}

	private String getForecastUrlForCity(String city) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(owmUrl).queryParam("q", city)
				.queryParam("appId", appId).queryParam("units", "metric");
		return builder.toUriString();
	}

	public double formatValue(double doubletoFormat) {
		return Math.round(doubletoFormat * 100) / 100D;
	}

	private Map<String, List<WeatherDetails>> getCurrentAndNextThreeDatForcast(List<WeatherDetails> weatherDetails) {
		Map<String, List<WeatherDetails>> dateWiseList = new HashMap<String, List<WeatherDetails>>();
		LocalDateTime datetime = null;
		List<WeatherDetails> tempWeather = null;
		int count = 0;
		for (WeatherDetails weatherDetail : weatherDetails) {
			if (count < 32) {
				datetime = LocalDateTime.ofInstant(weatherDetail.getDt(), ZoneOffset.UTC);
				String formatted = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(datetime);
				if (dateWiseList.containsKey(formatted)) {
					tempWeather = dateWiseList.get(formatted);
					tempWeather.add(weatherDetail);
					dateWiseList.put(formatted, tempWeather);
				} else {
					tempWeather = new ArrayList<WeatherDetails>();
					tempWeather.add(weatherDetail);
					dateWiseList.put(formatted, tempWeather);
				}
				count++;
			}
		}
		return  dateWiseList.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}
}
