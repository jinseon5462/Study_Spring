package com.restapi.exam.service;


import com.restapi.exam.dto.UserDTO;

public interface IUserService {
	public int regUser(UserDTO user);
	public UserDTO getUser(String name);
	public int updateUser(String name, UserDTO user);
	public int deleteUser(String name);
}
