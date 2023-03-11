package com.springboot.myapp2.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.myapp2.dto.UserDTO;

@Mapper
public interface IUserMapper {
	public int insert(UserDTO user);
	public UserDTO getUser(String id);
}
