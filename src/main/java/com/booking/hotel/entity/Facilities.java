package com.booking.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "facilities")
public class Facilities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private int id;
	
	@ApiModelProperty(example = "yes")
	private String wifiAvailability;
	
	@ApiModelProperty(example = "yes")
	private String restaurantAvailability;
	
	@ApiModelProperty(example = "yes")
	private String airConditioningAvailability;
	
	@ApiModelProperty(example = "no")
	private String mealsIncluded;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWifiAvailability() {
		return wifiAvailability;
	}

	public void setWifiAvailability(String wifiAvailability) {
		this.wifiAvailability = wifiAvailability;
	}

	public String getRestaurantAvailability() {
		return restaurantAvailability;
	}

	public void setRestaurantAvailability(String restaurantAvailability) {
		this.restaurantAvailability = restaurantAvailability;
	}

	public String getAirConditioningAvailability() {
		return airConditioningAvailability;
	}

	public void setAirConditioningAvailability(String airConditioningAvailability) {
		this.airConditioningAvailability = airConditioningAvailability;
	}

	public String getMealsIncluded() {
		return mealsIncluded;
	}

	public void setMealsIncluded(String mealsIncluded) {
		this.mealsIncluded = mealsIncluded;
	}
}
