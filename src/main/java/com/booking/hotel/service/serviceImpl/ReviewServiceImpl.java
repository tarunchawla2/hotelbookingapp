package com.booking.hotel.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotel.entity.Hotel;
import com.booking.hotel.entity.Review;
import com.booking.hotel.entity.User;
import com.booking.hotel.exception.ApplicationException;
import com.booking.hotel.exception.hotelExceptions.HotelNotFoundException;
import com.booking.hotel.exception.userExceptions.UserNotFoundException;
import com.booking.hotel.jpaRepo.hotelRepo.HotelRepository;
import com.booking.hotel.jpaRepo.reviewRepo.ReviewRepository;
import com.booking.hotel.jpaRepo.userRepo.UserRepository;
import com.booking.hotel.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Review postReview(int userId, int hotelId, Review review) throws ApplicationException {
		try {
			Review reviewData = new Review();
			Hotel hotelData;
			User userData;

			Optional<User> user = userRepository.findById(userId);
			if (user.isPresent()) {
				userData = user.get();
			} else {
				throw new UserNotFoundException("USER_NOT_FOUND");
			}

			Optional<Hotel> hotel = hotelRepository.findById(hotelId);
			if (hotel.isPresent()) {
				hotelData = hotel.get();
			} else {
				throw new HotelNotFoundException("HOTEL_NOT_FOUND");
			}

			reviewData.setRating(review.getRating());
			reviewData.setComment(review.getComment());

			double averageRating = (hotelData.getAverageRating() + reviewData.getRating())
					/ (hotelData.getUser().size() + 1);
			hotelData.setAverageRating(averageRating);
			hotelData.getReviews().add(reviewData);
			userData.getReview().add(reviewData);
			hotelData.getUser().add(userData);

			hotelRepository.save(hotelData);
			return reviewData;

		} catch (UserNotFoundException | HotelNotFoundException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
}
