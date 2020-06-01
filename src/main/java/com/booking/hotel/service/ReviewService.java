package com.booking.hotel.service;

import com.booking.hotel.entity.Review;
import com.booking.hotel.exception.ApplicationException;

public interface ReviewService {
	public Review postReview(int userId, int hotelId, Review review) throws ApplicationException;
}
