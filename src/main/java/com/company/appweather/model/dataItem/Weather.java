package com.company.appweather.model.dataItem;

import lombok.Data;

@Data
public class Weather{

	private int code;

	private String icon;

	private String description;
}