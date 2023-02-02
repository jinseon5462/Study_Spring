package com.example.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.vo.UserVO;

@Controller
public class MyController {
	
	@Autowired
	private UserMapper mapper;
	
	@GetMapping("/")
	public @ResponseBody String root() {
		return "Mybatis 연습";
	}
	
	@GetMapping("/loginForm")
	public void loginForm() {}
	
	@PostMapping("/login.do")
	public String loginDo(UserVO user) {
		int result = mapper.loginCheck(user);
		if(result == 1) {
			return "login_succes";
		}else {
			return "login_fail";
		}
	}
}
