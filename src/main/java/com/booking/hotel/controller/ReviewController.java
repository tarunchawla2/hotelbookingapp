package com.booking.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotel.entity.Review;
import com.booking.hotel.exception.ApplicationException;
import com.booking.hotel.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	@PostMapping("/{userId}/{hotelId}")
	public ResponseEntity<Review> postReview(@PathVariable("userId") int userId, @PathVariable("hotelId") int hotelId,
			@RequestBody Review review) {
		try {
			return new ResponseEntity<Review>(reviewService.postReview(userId, hotelId, review), HttpStatus.OK);
		} catch (ApplicationException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
