package com.restapi.exam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.restapi.exam.dto.UserDTO;

@Mapper
public interface IUserMapper {
	public int regUser(UserDTO user);
	public UserDTO getUser(String name);
	public int updateUser(@Param("name") String name, @Param("user") UserDTO user);
	public int deleteUser(String name);
}
