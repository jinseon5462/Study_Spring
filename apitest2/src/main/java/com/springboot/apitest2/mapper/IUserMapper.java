package com.springboot.apitest2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboot.apitest2.vo.UserVO;

@Mapper
public interface IUserMapper {
	
	public int insert(UserVO user);
	public UserVO selectByName(@Param("sel_name") String name);
	public int updateByName(@Param("modname") String name, @Param("user")UserVO user);
	public int updateByName1(Map<String, Object> map);
	public int deleteByName(@Param("del_name") String name);
	public List<UserVO> selectAllUsers();
}
