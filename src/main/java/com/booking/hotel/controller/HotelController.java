package com.booking.hotel.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotel.dto.SearchHotelBody;
import com.booking.hotel.entity.Hotel;
import com.booking.hotel.exception.ApplicationException;
import com.booking.hotel.service.HotelService;
import com.booking.hotel.service.UserService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		try {
			List<Hotel> hotels = new ArrayList<Hotel>();
			hotelService.getAllHotels().forEach((hotel) -> {
				hotels.add(hotel);
			});
			return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
		} catch (ApplicationException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/add")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		try {
			Hotel addedHotel = hotelService.addHotel(hotel);
			return new ResponseEntity<Hotel>(addedHotel, HttpStatus.CREATED);
		} catch (ApplicationException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable("id") int id, @RequestBody Hotel hotel) {
		try {
			Hotel updatedHotel = hotelService.updateHotel(id, hotel);
			if (updatedHotel != null) {
				return new ResponseEntity<Hotel>(updatedHotel, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
		} catch (ApplicationException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/search")
	public ResponseEntity<List<Hotel>> searchHotel(@RequestBody SearchHotelBody searchHotelBody) {
		try {
			List<Hotel> hotels = new ArrayList<Hotel>();
			hotelService.searchHotel(searchHotelBody).forEach(hotels::add);
			return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
		} catch (ApplicationException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable("id") int id) {
		try {
			String message = hotelService.deleteHotel(id);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (ApplicationException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}
}
