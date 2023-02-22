package com.springboot.apitest.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboot.apitest.vo.UserVO;

@Mapper
public interface MemberMapper {
	public int regMember(UserVO member);
	public ArrayList<UserVO> getList();
	public UserVO getMember(int sno);
	public UserVO selectByName(@Param("sel_name") String name);
	public int updateMember(UserVO member);
	public int deleteMember(int sno);
}
