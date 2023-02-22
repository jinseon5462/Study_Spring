package com.springboot.myapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myapi.mapper.MemberMapper;
import com.springboot.myapi.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/put-api/")
@Slf4j
public class PutController {
	
	@Autowired
	private MemberMapper mapper;
	
	@PutMapping("/user/{name}")
	public String updateUser(@PathVariable String name, @RequestBody UserVO user) {
		int result = mapper.updateUser(user);
		String msg = "";
		if(result == 1) {
			msg = "수정 성공!";
		}else {
			msg = "수정실패...";
		}
		return msg;
	}
}
