package com.example.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mybatis.vo.UserVO;

@Mapper
public interface UserMapper {
	
	public void insert(UserVO user);
	public UserVO selectOne(@Param("id") String id);
	public List<UserVO> getList();
	public void update(UserVO user);
	public void delete(String id);
}
