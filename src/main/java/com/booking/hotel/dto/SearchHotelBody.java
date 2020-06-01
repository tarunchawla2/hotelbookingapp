package com.booking.hotel.dto;

import java.time.LocalDate;

public class SearchHotelBody {
	private String city;
	private int noOfRooms;
	private LocalDate dateOfCheckIn;
	private String star;
	private String wifiAvailability;
	private String restaurantAvailability;
	private String airConditioningAvailability;
	private String mealsIncluded;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public LocalDate getDateOfCheckIn() {
		return dateOfCheckIn;
	}

	public void setDateOfCheckIn(LocalDate dateOfCheckIn) {
		this.dateOfCheckIn = dateOfCheckIn;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
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
