package com.company.appweather;

import com.company.appweather.service.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AppWeatherApplicationTests {

	@Autowired
	private  WeatherService weatherService;

	@Test
	public void getCurrentWeather(){
		weatherService.getCurrentWeather(34, 45);
		weatherService.getCurrentWeather(23, 200);
		weatherService.getCurrentWeather(-100, 20);
		weatherService.getCurrentWeather(100, 20);
		weatherService.getCurrentWeather(10, 200);
		weatherService.getCurrentWeather(10, -187);
	}

	@Test
	public void getHistoryWeather(){
		weatherService.getHistoryWeather(34, 45,"2020-10-08","2020-10-09");
		weatherService.getHistoryWeather(23, 300,"2020-10-08","2020-10-09");
		weatherService.getHistoryWeather(-200, 20,"2020-10-08","2020-10-09");
		weatherService.getHistoryWeather(456, 450,"2020-10-08","2020-10-09");
		weatherService.getHistoryWeather(5, 450,"2020-10-08","2020-10-09");
		weatherService.getHistoryWeather(37, -450,"2020-10-08","2020-10-09");
		weatherService.getHistoryWeather(37, 67,"2020-10-32","2020-10-09");
		weatherService.getHistoryWeather(3, 67,"2020-13-12","2020-10-10");
		weatherService.getHistoryWeather(6, 8,"2020-01-12","202U-10-10");
		weatherService.getHistoryWeather(6, 8,"2020-01-12","2021-45-10");
		weatherService.getHistoryWeather(6, 8,"2020-01-12","2021-02-30");
	}

	@Test
	public void getHistoryWeatherDaily(){
		weatherService.getHistoryWeatherDaily(56, 61,"2020-fg-08");
		weatherService.getHistoryWeatherDaily(23, 47,"2fgh-10-08");
		weatherService.getHistoryWeatherDaily(98, 7,"2020-10-08");
		weatherService.getHistoryWeatherDaily(300, 96,"2020-10-08");
		weatherService.getHistoryWeatherDaily(-720, 56,"2020-10-08");
		weatherService.getHistoryWeatherDaily(78, 150,"2020-10-08");
		weatherService.getHistoryWeatherDaily(34, -567,"2020-10-08");
		weatherService.getHistoryWeatherDaily(12, 5,"2020-02-30");
		weatherService.getHistoryWeatherDaily(87, 89,"2020-11-31");
		weatherService.getHistoryWeatherDaily(234, 23,"2020-13-08");
		weatherService.getHistoryWeatherDaily(89, 74,"2020-01-32");
	}


	@Test
	public void testWeather(){
		Assertions.assertEquals(weatherService.getCurrentWeather(-200,23).getSuccess(), false);
		Assertions.assertEquals(weatherService.getCurrentWeather(45,23).getSuccess(), true);
		Assertions.assertEquals(weatherService.getCurrentWeather(100,150).getSuccess(), false);
		Assertions.assertEquals(weatherService.getCurrentWeather(10,180).getSuccess(), true);
		Assertions.assertEquals(weatherService.getCurrentWeather(-10,181).getSuccess(), false);

		Assertions.assertEquals(weatherService.getHistoryWeather(90, 51,"2018-01-13","2017-01-20").getSuccess(), false);
		Assertions.assertEquals(weatherService.getHistoryWeather(122, 51,"2018-01-13","2017-01-20").getSuccess(), false);
		Assertions.assertEquals(weatherService.getHistoryWeather(-95, 51,"2018-01-13","2017-01-20").getSuccess(), false);
		Assertions.assertEquals(weatherService.getHistoryWeather(71, 51,"2018-01-13","2018-01-13").getSuccess(), false);
		Assertions.assertEquals(weatherService.getHistoryWeather(24, 51,"2018-01-13","2018-01-15").getSuccess(), true);
		Assertions.assertEquals(weatherService.getHistoryWeather(-24, -51,"2018-01-13","2018-02-30").getSuccess(), false);
		Assertions.assertEquals(weatherService.getHistoryWeather(2, 190,"2018-01-13","2018-01-30").getSuccess(), false);
		Assertions.assertEquals(weatherService.getHistoryWeather(24, -251,"2018-01-13","2018-12-30").getSuccess(), false);
		Assertions.assertEquals(weatherService.getHistoryWeather(65, 51,"2018-01-13","2018-02-05").getSuccess(), true);

		Assertions.assertEquals(weatherService.getHistoryWeatherDaily(71,89,"2015-01-12").getSuccess(), true);
		Assertions.assertEquals(weatherService.getHistoryWeatherDaily(56,93,"2015-01-12").getSuccess(), true);
		Assertions.assertEquals(weatherService.getHistoryWeatherDaily(198,23,"2015-01-12").getSuccess(), false);
		Assertions.assertEquals(weatherService.getHistoryWeatherDaily(-45,45,"2015-01-12").getSuccess(), true);
		Assertions.assertEquals(weatherService.getHistoryWeatherDaily(23,82,"2015-01-12").getSuccess(), true);
		Assertions.assertEquals(weatherService.getHistoryWeatherDaily(56,86,"2015/01/23").getSuccess(), false);
	}

}
