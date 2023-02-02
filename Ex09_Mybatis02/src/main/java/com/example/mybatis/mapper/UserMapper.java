package com.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.mybatis.vo.UserVO;

@Mapper
public interface UserMapper {
	public int loginCheck(UserVO user);
}
