package com.booking.hotel.service;

import java.util.List;

import com.booking.hotel.entity.User;
import com.booking.hotel.exception.ApplicationException;

public interface UserService {
	public List<User> getAllUsers() throws ApplicationException;

	public User addUser(User user) throws ApplicationException;

	public User updateUser(int id, User user) throws ApplicationException;
}
