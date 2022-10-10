package com.company.appweather.model.dataItem;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentWeatherDataItem {

	private String sunrise;

	@JsonProperty("pod")
	private String pod;

	private Double pres;

	private List<String> sources;

	private String timezone;

	@JsonProperty("ob_time")
	private String obTime;

	@JsonProperty("wind_cdir")
	private String windCdir;

	private Double lon;

	private Double clouds;

	@JsonProperty("wind_spd")
	private Double windSpd;

	@JsonProperty("h_angle")
	private Double hAngle;

	private String datetime;

	@JsonProperty("city_name")
	private String cityName;

	private Double precip;

	private Weather weather;

	private String station;

	@JsonProperty("elev_angle")
	private Double elevAngle;

	private Double dni;

	private Double lat;

	private Double vis;

	private Double uv;

	private Double temp;

	private Double dhi;

	@JsonProperty("app_temp")
	private Double appTemp;

	private Double ghi;

	private Double dewpt;

	@JsonProperty("wind_dir")
	private Double windDir;

	@JsonProperty("solar_rad")
	private Double solarRad;

	@JsonProperty("country_code")
	private String countryCode;

	private Double rh;

	private Double slp;

	private String sunset;

	private Double aqi;

	@JsonProperty("state_code")
	private String stateCode;

	@JsonProperty("wind_cdir_full")
	private String windCdirFull;

	private Double gust;

	private Double ts;
}