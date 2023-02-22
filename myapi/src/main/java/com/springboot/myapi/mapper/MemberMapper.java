package com.springboot.myapi.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.myapi.vo.UserVO;

@Mapper
public interface MemberMapper {
	public int regMember(UserVO member);
	public int updateUser(UserVO user);
}
