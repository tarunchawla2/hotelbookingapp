package com.booking.hotel.exception.hotelExceptions;

import com.booking.hotel.exception.ApplicationException;

public class HotelNotFoundException extends ApplicationException {

	public HotelNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public HotelNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HotelNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HotelNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
