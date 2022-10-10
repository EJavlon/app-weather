package com.company.appweather.model.dataItem;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DailyWaetherDataItem {

	private Double pres;

	@JsonProperty("min_temp_ts")
	private Double minTempTs;

	@JsonProperty("max_wind_dir")
	private Double maxWindDir;

	private Double clouds;

	@JsonProperty("max_wind_spd_ts")
	private Double maxWindSpdTs;

	@JsonProperty("wind_spd")
	private Double windSpd;

	@JsonProperty("precip_gpd")
	private Double precipGpm;

	private String datetime;

	private Double precip;

	@JsonProperty("max_uv")
	private Double maxUv;

	@JsonProperty("t_dhi")
	private Double tDhi;

	@JsonProperty("min_temp")
	private Double minTemp;

	@JsonProperty("max_temp_ts")
	private Double maxTempTs;

	@JsonProperty("max_temp")
	private Double maxTemp;

	@JsonProperty("snow_depth")
	private Double snowDepth;

	@JsonProperty("max_dhi")
	private Double maxDhi;

	private Double temp;

	private Double dhi;

	@JsonProperty("revision_status")
	private String revisionStatus;

	private Double dewpt;

	@JsonProperty("wind_dir")
	private Double windDir;

	@JsonProperty("wind_gust_spd")
	private Double windGustSpd;

	@JsonProperty("max_wind_spd")
	private Double maxWindSpd;

	private Double rh;

	private Double slp;

	private Double snow;

	private Double ts;
}