package com.springboot.myapp2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.myapp2.dto.UserDTO;
import com.springboot.myapp2.mapper.IUserMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private IUserMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO principal = mapper.getUser(username);
		return new UserDetailsImpl(principal);
	}
}
