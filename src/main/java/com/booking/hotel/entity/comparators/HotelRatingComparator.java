package com.booking.hotel.entity.comparators;

import java.util.Comparator;

import com.booking.hotel.entity.Hotel;

public class HotelRatingComparator implements Comparator<Hotel> {

	@Override
	public int compare(Hotel hotel1, Hotel hotel2) {
		if (hotel1.getAverageRating() == hotel2.getAverageRating())
			return 0;
		else if (hotel1.getAverageRating() > hotel2.getAverageRating())
			return -1;
		else
			return 1;
	}

}
