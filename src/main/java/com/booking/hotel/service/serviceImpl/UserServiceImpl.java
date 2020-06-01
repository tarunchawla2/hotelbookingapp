package com.booking.hotel.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotel.entity.Hotel;
import com.booking.hotel.entity.User;
import com.booking.hotel.exception.ApplicationException;
import com.booking.hotel.exception.userExceptions.InvalidUserDetailsException;
import com.booking.hotel.exception.userExceptions.UserNotFoundException;
import com.booking.hotel.jpaRepo.userRepo.UserRepository;
import com.booking.hotel.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() throws ApplicationException {
		try {
			List<User> user = userRepository.findAll();
			if (user.size() > 0) {
				return user;
			} else {
				throw new UserNotFoundException("USERS_NOT_FOUND");
			}
		} catch (UserNotFoundException e) {
			throw new ApplicationException(e.getMessage());
		}

	}

	@Override
	public User addUser(User user) throws ApplicationException {
		try {
			if (user.getFirstName() != null) {
				return userRepository.save(user);
			} else {
				throw new InvalidUserDetailsException("INVALID_USER_DETAILS");
			}
		} catch (InvalidUserDetailsException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	@Override
	public User updateUser(int id, User user) throws ApplicationException {
		try {
			Optional<User> userOptionalData = userRepository.findById(id);
			if (userOptionalData.isPresent()) {
				User userData = userOptionalData.get();
				userData.setFirstName(user.getFirstName());
				userData.setLastName(user.getLastName());
				return userRepository.save(userData);
			} else {
				throw new UserNotFoundException("USER_NOT_FOUND");
			}
		} catch (UserNotFoundException e) {
			throw new ApplicationException(e.getMessage());
		}

	}

}
