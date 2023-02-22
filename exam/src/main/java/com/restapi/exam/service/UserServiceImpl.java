package com.restapi.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.exam.controller.PutController;
import com.restapi.exam.dto.UserDTO;
import com.restapi.exam.mapper.IUserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserMapper mapper;
	
	@Override
	public int regUser(UserDTO user) {
		int result = mapper.regUser(user);
		return result;
	}
	
	@Override
	public UserDTO getUser(String name) {
		UserDTO user = mapper.getUser(name);
		return user;
	}

	@Override
	public int updateUser(String name, UserDTO user) {
		log.info("서비스임플\n회원이름 : " + name + "\n수정할 이름 : " + user.getName() + "\n수정할 나이 : " + user.getAge());
		int result = mapper.updateUser(name, user);
		return result;
	}

	@Override
	public int deleteUser(String name) {
		int result = mapper.deleteUser(name);
		return result;
	}
}
