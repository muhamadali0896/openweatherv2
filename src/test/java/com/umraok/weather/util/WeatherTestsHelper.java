package com.umraok.weather.util;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.umraok.weather.dto.Main;
import com.umraok.weather.dto.WeatherDetails;

@Component
public class WeatherTestsHelper {

	public static List<WeatherDetails> getDailyWeatherDetails() {
		List<WeatherDetails> list = new ArrayList<>();

		WeatherDetails wd1 = new WeatherDetails();
		wd1.setDt(Instant.parse("2018-12-15T06:00:00Z"));
		Main main1 = new Main();
		main1.setTemp(10.00);
		main1.setPressure(100.00);
		main1.setTemp_min(10.00);
		main1.setTemp_max(10.00);
		main1.setSea_level(1041.39);
		main1.setHumidity(86);
		main1.setTemp_kf(0.75);
		main1.setGrnd_level(1035.5);
		wd1.setMain(main1);
		list.add(wd1);

		WeatherDetails wd2 = new WeatherDetails();
		wd1.setDt(Instant.parse("2018-12-15T09:00:00Z"));
		Main main2 = new Main();
		main2.setTemp(6.00);
		main2.setPressure(200.00);
		main2.setTemp_min(10.00);
		main2.setTemp_max(10.00);
		main2.setSea_level(1041.39);
		main2.setHumidity(86);
		main2.setTemp_kf(0.75);
		main2.setGrnd_level(1035.5);
		wd2.setMain(main2);
		list.add(wd2);

		// Should not be taken into consideration as is not a day time value
		WeatherDetails wd3 = new WeatherDetails();
		wd3.setDt(Instant.parse("2018-12-15T21:00:00Z"));
		Main main3 = new Main();
		main2.setTemp(4.00);
		main2.setPressure(100.00);
		main2.setTemp_min(10.00);
		main2.setTemp_max(10.00);
		main2.setSea_level(1041.39);
		main2.setHumidity(86);
		main2.setTemp_kf(0.75);
		main2.setGrnd_level(1035.5);
		wd3.setMain(main3);
		list.add(wd3);

		return list;
	}
}
