package com.company.appweather.service;

import com.company.appweather.config.WeatherConfig;
import com.company.appweather.exeption.CoordinateExeption;
import com.company.appweather.model.CurrentWeather;
import com.company.appweather.model.DailyWeatherHistory;
import com.company.appweather.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

@Service
public class WeatherService {

    @Autowired
    private  WeatherConfig config;

    public WeatherService(WeatherConfig config) {
        this.config = config;
    }

    public ApiResponse getCurrentWeather(double lat, double lon) {
        try {
            checkCoordinate(lat, lon);
        } catch (CoordinateExeption e) {
            return getResult(null);
        }

        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(config.getUrl1(), lat, lon,config.getApiKey());

        CurrentWeather currentWeather;
        try {
            currentWeather = restTemplate.getForObject(url, CurrentWeather.class);
        }catch (Exception e){
            return getResult(null);
        }

        return getResult(currentWeather);
    }


    public ApiResponse getHistoryWeather(double lat, double lon, String startDate, String endDate) {
        try {
            checkCoordinate(lat, lon);
        } catch (CoordinateExeption e) {
            return getResult(null);
        }

        if (!checkDate(startDate, endDate))
            return getResult(null);

        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(
                config.getUrl2(), lat, lon, startDate, endDate, config.getApiKey());

        DailyWeatherHistory dailyWeatherHistory;
        try {
            dailyWeatherHistory = restTemplate.getForObject(url, DailyWeatherHistory.class);
        } catch (Exception e) {
            dailyWeatherHistory = null;
        }

        return getResult(dailyWeatherHistory);
    }

    public ApiResponse getHistoryWeatherDaily(double lat, double lon, String date) {
        try {
            checkCoordinate(lat, lon);
        } catch (CoordinateExeption e) {
            return getResult(null);
        }

        if (!checkDate(date))
            return getResult(null);

        String endDate = String.valueOf(LocalDate.parse(date).plusDays(1));

        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(
                config.getUrl2(), lat, lon, date, endDate, config.getApiKey());

        DailyWeatherHistory dailyWeatherHistory;
        try {
            dailyWeatherHistory = restTemplate.getForObject(url, DailyWeatherHistory.class);
        } catch (Exception e) {
            dailyWeatherHistory = null;
        }

        return getResult(dailyWeatherHistory);
    }

    private void checkCoordinate(double lat, double lon) throws CoordinateExeption {
        if (lat > 90 || lat < -90 || lon > 180 || lon < -180)
            throw new CoordinateExeption("The coordinate is invalid !");
    }

    private boolean checkDate(String... dates) {
        if (dates.length == 1) {
            try {
                LocalDate.parse(dates[0]);
            } catch (DateTimeParseException e) {
                return false;
            }
            return true;
        }

        try {
            LocalDate.parse(dates[0]);
            LocalDate.parse(dates[1]);
        } catch (DateTimeParseException e) {
            return false;
        }

        return true;
    }

    private ApiResponse getResult(Object object) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setObject(object);
        apiResponse.setMessage(Objects.nonNull(object) ? "Ok" : "Error !");
        apiResponse.setSuccess(Objects.nonNull(object));
        return apiResponse;
    }

}
