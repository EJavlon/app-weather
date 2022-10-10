package com.company.appweather.model;

import java.util.List;

import com.company.appweather.model.dataItem.DailyWaetherDataItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DailyWeatherHistory {
	@JsonProperty("country_code")
	private String countryCode;

	@JsonProperty("city_name")
	private String cityName;

	private List<String> sources;

	private List<DailyWaetherDataItem> data;

	private String timezone;

	@JsonProperty("station_id")
	private String stationId;

	private double lon;

	@JsonProperty("state_code")
	private String stateCode;

	private double lat;

	@JsonProperty("city_id")
	private String cityId;
}