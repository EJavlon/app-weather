package com.company.appweather.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class WeatherConfig {

    @Value("${weather.apKey}")
    private String apiKey;

    @Value("${weather.URL_1}")
    private String url1;

    @Value("${weather.URL_2}")
    private String url2;
}
