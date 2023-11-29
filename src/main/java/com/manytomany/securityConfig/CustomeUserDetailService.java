package com.manytomany.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.manytomany.model.Users;
import com.manytomany.repo.UserRepo;

@Component
public class CustomeUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepo user;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users us = user.findByEmail(username).orElseThrow();
		return new CustomeUser(us);
	}
	
	

}
