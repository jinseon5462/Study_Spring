package com.springboot.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboot.api.dto.UserDTO;

@Mapper
public interface StudentMapper {
	public int login(UserDTO student);
	public int studentCheck(@Param("sno") int sno, @Param("name") String name);
	public int checkId(@Param("id") String id);
	public int signUp(UserDTO student);
}
