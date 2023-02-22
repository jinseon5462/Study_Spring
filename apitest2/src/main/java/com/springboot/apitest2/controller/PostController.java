package com.springboot.apitest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apitest2.mapper.IUserMapper;
import com.springboot.apitest2.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/post-api/")
public class PostController {

	@Autowired
	IUserMapper mapper;
	
	//http://localhost:9001/api/post-api/user
	@PostMapping("/user")
	public String regUser(@RequestBody UserVO user) {
		log.info("regUser.......");
		int result = mapper.insert(user);
		String msg = "";
		
		if(result == 1) {
			msg = "<span style='color: blue'>등록 성공</span>";
		}else {
			msg = "<span style='color: red'>등록 실패</span>";
		}
		
		return msg;
	}
}
