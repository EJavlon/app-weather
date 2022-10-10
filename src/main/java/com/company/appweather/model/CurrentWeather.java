package com.company.appweather.model;

import java.util.List;

import com.company.appweather.model.dataItem.CurrentWeatherDataItem;
import lombok.Data;

@Data
public class CurrentWeather{

	private List<CurrentWeatherDataItem> data;

	private int count;
}