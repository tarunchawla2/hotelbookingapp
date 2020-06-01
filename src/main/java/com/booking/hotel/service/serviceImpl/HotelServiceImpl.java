package com.booking.hotel.service.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotel.dto.SearchHotelBody;
import com.booking.hotel.entity.Hotel;
import com.booking.hotel.entity.Review;
import com.booking.hotel.entity.comparators.HotelRatingComparator;
import com.booking.hotel.exception.ApplicationException;
import com.booking.hotel.exception.hotelExceptions.HotelNotFoundException;
import com.booking.hotel.exception.hotelExceptions.InvalidRoomsException;
import com.booking.hotel.jpaRepo.hotelRepo.HotelRepository;
import com.booking.hotel.jpaRepo.reviewRepo.ReviewRepository;
import com.booking.hotel.jpaRepo.userRepo.UserRepository;
import com.booking.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public List<Hotel> getAllHotels() throws ApplicationException {
		try {
			List<Hotel> hotel = hotelRepository.findAll();
			if (hotel.size() > 0)
				return hotel;
			else
				throw new HotelNotFoundException("HOTELS_NOT_FOUND");
		} catch (HotelNotFoundException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	@Override
	public Hotel addHotel(Hotel hotel) throws ApplicationException {
		try {
			if (hotel.getNoOfRooms() == hotel.getRoom().size()) {
				return hotelRepository.save(hotel);
			} else {
				throw new InvalidRoomsException("INVALID_NUMBER_ROOMS");
			}
		} catch (InvalidRoomsException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	@Override
	public Hotel updateHotel(int id, Hotel hotel) throws ApplicationException {
		try {
			Optional<Hotel> hotelOptionalData = hotelRepository.findById(id);
			if (hotelOptionalData.isPresent()) {
				Hotel hotelData = hotelOptionalData.get();
				hotelData.setName(hotel.getName());
				hotelData.setCity(hotel.getCity());
				hotelData.setNoOfRooms(hotel.getNoOfRooms());
				hotelData.setAverageRating(hotel.getAverageRating());
				hotelData.setStar(hotel.getStar());
				return hotelRepository.save(hotelData);
			} else {
				throw new HotelNotFoundException("HOTEL_NOT_FOUND");
			}
		} catch (HotelNotFoundException e) {
			throw new ApplicationException(e.getMessage());
		}

	}

	@Override
	public List<Hotel> searchHotel(SearchHotelBody searchHotelBody) throws ApplicationException {
		String star = searchHotelBody.getStar() == null ? "[1-10]*" : searchHotelBody.getStar();
		List<Hotel> hotels = hotelRepository.searchHotel(searchHotelBody.getCity(), star);

		List<Hotel> filteredHotels = new ArrayList<Hotel>();
		hotels.forEach((hotel) -> {
			if ((searchHotelBody.getWifiAvailability() == null || searchHotelBody.getWifiAvailability().toLowerCase()
					.equals(hotel.getFacilities().getWifiAvailability().toLowerCase()))
					&& (searchHotelBody.getAirConditioningAvailability() == null
							|| searchHotelBody.getAirConditioningAvailability().toLowerCase()
									.equals(hotel.getFacilities().getAirConditioningAvailability().toLowerCase()))
					&& (searchHotelBody.getMealsIncluded() == null || searchHotelBody.getMealsIncluded().toLowerCase()
							.equals(hotel.getFacilities().getMealsIncluded().toLowerCase()))
					&& (searchHotelBody.getRestaurantAvailability() == null
							|| searchHotelBody.getRestaurantAvailability().toLowerCase()
									.equals(hotel.getFacilities().getRestaurantAvailability().toLowerCase()))) {
				int result = (int) hotel.getRoom().stream().filter(room -> {
					return room.getBookingDate() == null
							|| room.getBookingDate().compareTo(searchHotelBody.getDateOfCheckIn()) < 0;
				}).count();
				if (result >= searchHotelBody.getNoOfRooms()) {
					filteredHotels.add(hotel);
				}
			}
		});
		Collections.sort(filteredHotels, new HotelRatingComparator());
		return filteredHotels;
	}

	@Override
	public String deleteHotel(int id) throws ApplicationException {
		try {
			Optional<Hotel> hotel = hotelRepository.findById(id);
			if (hotel.isPresent()) {
				Hotel hotelData = hotel.get();
				hotelData.setUser(null);
				hotelData.setReviews(null);
				hotelRepository.delete(hotelData);
				return "Deleted";
			} else {
				throw new HotelNotFoundException("HOTEL_NOT_FOUND");
			}
		} catch (HotelNotFoundException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
}
