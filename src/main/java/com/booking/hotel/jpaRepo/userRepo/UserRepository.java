package com.booking.hotel.jpaRepo.userRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.hotel.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
