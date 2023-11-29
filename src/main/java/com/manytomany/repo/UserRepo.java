package com.manytomany.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer>{

	public Optional<Users> findByEmail(String email);
}
