package com.booking.hotel.service;

import java.time.LocalDate;
import java.util.List;

import com.booking.hotel.dto.SearchHotelBody;
import com.booking.hotel.entity.Hotel;
import com.booking.hotel.exception.ApplicationException;

public interface HotelService {
	public List<Hotel> getAllHotels() throws ApplicationException;

	public Hotel addHotel(Hotel hotel) throws ApplicationException;

	public Hotel updateHotel(int id, Hotel hotel) throws ApplicationException;

	public List<Hotel> searchHotel(SearchHotelBody searchHotelBody) throws ApplicationException;

	public String deleteHotel(int id) throws ApplicationException;
}
