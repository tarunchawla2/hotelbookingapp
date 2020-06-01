package com.booking.hotel.jpaRepo.reviewRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.hotel.entity.Hotel;
import com.booking.hotel.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	public static final String SEARCH_BY_HOTELID = "SELECT * FROM review where review.hotel_hotel_id=?1 ";

	@Query(value = SEARCH_BY_HOTELID, nativeQuery = true)
	public List<Review> getReviewsByHotelID(int hotelId);
}
