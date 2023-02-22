package com.springboot.myapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myapi.mapper.MemberMapper;
import com.springboot.myapi.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/post-api/")
@Slf4j
public class PostController {
	
	@Autowired
	private MemberMapper mapper;
	
	@PostMapping("/user")
	public String regUser(@RequestBody UserVO user) {
		log.info("regUser..." + user);
		int result = mapper.regMember(user);
		String msg = "";
		if(result == 1) {
			msg = "등록완료!";
		}else {
			msg = "등록 실패...";
		}
		return msg;
	}
}
