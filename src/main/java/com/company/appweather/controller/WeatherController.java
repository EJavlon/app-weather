package com.company.appweather.controller;

import com.company.appweather.payload.ApiResponse;
import com.company.appweather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private final WeatherService weatherService;

    private ApiResponse apiResponse;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    /**
     * For current weather
     * @param lat : 90.0000000 to -90.0000000
     * @param lon : 180.0000000 to -180.0000000
     * @return ResponseEntity
     */
    @GetMapping("/current")
    public ResponseEntity<?> getWeather(@RequestParam double lat, @RequestParam double lon){
        apiResponse = weatherService.getCurrentWeather(lat,lon);
        return ResponseEntity.status(apiResponse.getSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }


    /**
     * For the interim
     * @param lat : 90.0000000 to -90.0000000
     * @param lon : 180.0000000 to -180.0000000
     * @param startDate : "yyyy-MM-dd"
     * @param endDate : "yyyy-MM-dd"
     * @return ResponseEntity
     */
    @GetMapping("/history")
    public ResponseEntity<?> getWeather(@RequestParam double lat, @RequestParam double lon,
                                        @RequestParam(name = "start_date") String startDate, @RequestParam(name = "end_date") String endDate){
        apiResponse = weatherService.getHistoryWeather(lat,lon,startDate,endDate);
        return ResponseEntity.status(apiResponse.getSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * A day's history
     * @param lat : 90.0000000 to -90.0000000
     * @param lon : 180.0000000 to -180.0000000
     * @param date : "yyyy-MM-dd"
     * @return ResponseEntity
     */
    @GetMapping("/history/one-day")
    public ResponseEntity<?> getWeather(@RequestParam double lat, @RequestParam double lon,
                                        @RequestParam(name = "date") String date){
        apiResponse = weatherService.getHistoryWeatherDaily(lat,lon,date);
        return ResponseEntity.status(apiResponse.getSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

}
