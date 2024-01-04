package com.flightcheckin.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightcheckin.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
