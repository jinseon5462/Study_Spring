package com.springboot.myapp2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.myapp2.dto.UserDTO;
import com.springboot.myapp2.mapper.IUserMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {
	
	@Autowired
	private IUserMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@GetMapping("/")
	@ResponseBody
	public String root() {
		return "security 연습..";
	}
	
	@GetMapping("/index")
	public void index() {
		log.info("-----index-----");
	}

	@GetMapping("/regForm")
	public void regForm() {
		log.info("-----regForm-----");
	}
	
	@PostMapping("/regist")
	public String regist(UserDTO user) {
		log.info("User : " + user.toString());
		//패스워드 암호화
		//클라이언트가 입력한(User에 담긴) 패스워드 얻어내기 : user.getPw()
		String inputPw = user.getPw();
		
		//그것을 암호화하기 : user.setPw()
		String encodePw = passwordEncoder.encode(inputPw);
		log.info("암호화된 패스워드 : " + encodePw);
		
		//암호된 패스워드를 user객체에 담기
		user.setPw(encodePw);
		
		mapper.insert(user);
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public void list() {
		log.info("------list-----");
	}
	
	@GetMapping("/auth/loginForm")
	public void login() {
		
	}
	
	@GetMapping("/user/main")
	public void userMain() {
		log.info("==========user main==========");
	}
}
