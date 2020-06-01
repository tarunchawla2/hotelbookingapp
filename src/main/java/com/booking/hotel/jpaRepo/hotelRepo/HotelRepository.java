package com.booking.hotel.jpaRepo.hotelRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.hotel.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	public static final String SEARCH_HOTELS = "SELECT * FROM hotel where hotel.city=?1  && hotel.star REGEXP ?2";

	@Query(value = SEARCH_HOTELS, nativeQuery = true)
	public List<Hotel> searchHotel(String city, String star);

}
